package com.waes.backend.resources;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import javax.ws.rs.core.UriBuilder;

/**
 * This Runner can be run standalone as a Java Application (in case it is not possible to deploy the project to a
 * server)
 *
 * Grizzly creates the server requiring in the configuration: - the class to run (UsersResource.class); - the package
 * where the exception mappers are located (otherwise a generic error page os thrown).
 */
public class UserResourceRestStartup {

  private static final String HOST = "http://localhost/waesheroes/api";
  private static Logger LOGGER = LoggerFactory.getLogger(UserResourceRestStartup.class);

  @SuppressWarnings({"unused"})
  public static void main(String[] args) {
    int port = 8081;
    if (args.length == 1) {
      try {
        port = Integer.parseInt(args[0]);
      } catch (NumberFormatException e) {
        LOGGER.error("Invalid Input: Please enter numbers for the port.");
      }
    }

    URI baseUri = UriBuilder.fromUri(HOST).port(port).build();

    ResourceConfig config = new ResourceConfig()
        .registerClasses(UsersResource.class)
        .packages("com.waes.backend.exceptions.mappers");
    HttpServer server = GrizzlyHttpServerFactory.createHttpServer(baseUri, config);
  }
}
