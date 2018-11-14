package com.waes.backend.exceptions.mappers;

import javax.naming.AuthenticationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.waes.backend.model.ErrorMessage;

@Provider
public class AuthenticationExceptionMapper implements ExceptionMapper<AuthenticationException> {

  @Override
  public Response toResponse(AuthenticationException exception) {
    ErrorMessage errorMessage = new ErrorMessage("Invalid credentials: " + exception.getMessage(), 401);
    return Response.status(Response.Status.UNAUTHORIZED)
        .entity(errorMessage)
        .build();
  }
}
