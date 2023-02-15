package com.example.department.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class DepartmentRequest {

    private String id;

    private String deptName;

    private String deptHead;
}
