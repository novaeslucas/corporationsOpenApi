package com.novaeslucas.corporationsOpenApi.exceptions;

import org.mapstruct.Builder;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

public class ErrorDTO {

    private LocalDateTime timestamp;
    private int status;
    private String path;
    private HttpStatus httpStatus;
    private String mostSpecificCause;
    List<String> errorDetails;

    public ErrorDTO(LocalDateTime timestamp, int status, String path, HttpStatus httpStatus, String mostSpecificCause, List<String> errorDetails) {
        this.timestamp = timestamp;
        this.status = status;
        this.path = path;
        this.httpStatus = httpStatus;
        this.mostSpecificCause = mostSpecificCause;
        this.errorDetails = errorDetails;
    }

    public ErrorDTO() {
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public List<String> getErrorDetails() {
        return errorDetails;
    }

    public void setErrorDetails(List<String> errorDetails) {
        this.errorDetails = errorDetails;
    }

    public String getMostSpecificCause() {
        return mostSpecificCause;
    }

    public void setMostSpecificCause(String mostSpecificCause) {
        this.mostSpecificCause = mostSpecificCause;
    }
}
