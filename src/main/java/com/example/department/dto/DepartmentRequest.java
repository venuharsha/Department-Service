package com.example.department.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentRequest {

    private String id;

    private String deptName;

    private String deptHead;
}
