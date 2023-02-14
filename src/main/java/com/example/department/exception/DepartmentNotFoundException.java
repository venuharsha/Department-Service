package com.example.department.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
@NoArgsConstructor
public class DepartmentNotFoundException extends RuntimeException{

    private String message;
}
