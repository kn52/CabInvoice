package com.cab.invoice;

public class CabInvoiceException extends RuntimeException {

    public enum ExceptionType{
        NO_DATA_FOUND, NULL_SUCH_DATA
    }

    public ExceptionType type;

    public CabInvoiceException(String message, ExceptionType type) {
        super(message);
        this.type=type;
    }
}
