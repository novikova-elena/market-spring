package ru.novikova.market.core.exceptions;

import lombok.Data;

import java.util.List;

@Data
public class ValidationError {
    private List<ValidationFieldError> fields;
    private String message;

    public ValidationError(List<ValidationFieldError> fields, String message) {
        this.fields = fields;
        this.message = message;
    }
}
