package com.example.department.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class DepartmentRequest {

    private String id;

    @NonNull
    private String deptName;

    @NonNull
    private String deptHead;
}
