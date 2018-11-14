package com.waes.backend.exceptions.mappers;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.waes.backend.exceptions.UserRegistrationException;
import com.waes.backend.model.ErrorMessage;

@Provider
public class UserRegistrationExceptionMapper implements ExceptionMapper<UserRegistrationException> {

  @Override
  public Response toResponse(UserRegistrationException exception) {
    ErrorMessage errorMessage = new ErrorMessage("User registration error: " + exception.getMessage(), 409);
    return Response.status(Status.CONFLICT)
        .entity(errorMessage)
        .build();
  }

}
