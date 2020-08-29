package com.example.study.handlers;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * Model for error response
 *
 * @author Vinod John
 */
@Data
@AllArgsConstructor
public class ErrorResponse {
    private String message;
    private List<String> details;
}
