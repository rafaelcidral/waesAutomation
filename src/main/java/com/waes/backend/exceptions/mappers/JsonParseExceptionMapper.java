package com.waes.backend.exceptions.mappers;

import javax.ws.rs.ProcessingException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.waes.backend.model.ErrorMessage;

@Provider
public class JsonParseExceptionMapper implements ExceptionMapper<ProcessingException> {

  @Override
  public Response toResponse(ProcessingException exception) {
    ErrorMessage errorMessage = new ErrorMessage(
        "Data format is not correct: " + exception.getMessage(), 400);
    return Response.status(Response.Status.BAD_REQUEST)
        .entity(errorMessage)
        .build();
  }

}
