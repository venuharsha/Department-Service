package com.example.department.dto;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentRequest {

    private String deptId;
    private String deptName;

    private String deptHead;
}
