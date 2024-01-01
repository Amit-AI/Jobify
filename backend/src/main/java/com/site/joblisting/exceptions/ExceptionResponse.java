package com.site.joblisting.exceptions;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ExceptionResponse {

    private final String timeStamp;
    private final String error;
    private final String status;
    private final String path;

    private ExceptionResponse(String timeStamp, String error, String status, String path) {
        this.timeStamp = timeStamp;
        this.error = error;
        this.status = status;
        this.path = path;
    }

    public static ExceptionResponseBuilder builder() {
        return new ExceptionResponseBuilder();
    }


    public static class ExceptionResponseBuilder {
        private final String timeStamp = LocalDateTime.now().toString();
        private String error;
        private String status;
        private String path;

        public ExceptionResponseBuilder error(String errorMessage) {
            this.error = errorMessage;
            return this;
        }

        public ExceptionResponseBuilder status(String status) {
            this.status = status;
            return this;
        }

        public ExceptionResponseBuilder path(String path) {
            this.path = path;
            return this;
        }

        public ExceptionResponse build() {
            return new ExceptionResponse(this.timeStamp, this.error, this.status, this.path);
        }
    }
}
