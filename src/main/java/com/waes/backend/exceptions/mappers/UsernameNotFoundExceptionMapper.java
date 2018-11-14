package com.waes.backend.exceptions.mappers;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.waes.backend.exceptions.UsernameNotFoundException;
import com.waes.backend.model.ErrorMessage;

@Provider
public class UsernameNotFoundExceptionMapper implements ExceptionMapper<UsernameNotFoundException> {

  @Override
  public Response toResponse(UsernameNotFoundException exception) {
    ErrorMessage errorMessage = new ErrorMessage(exception.getMessage(), 404);
    return Response.status(Response.Status.NOT_FOUND)
        .entity(errorMessage)
        .build();
  }

}
