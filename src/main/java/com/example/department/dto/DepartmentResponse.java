package com.example.department.dto;

import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class DepartmentResponse {


    private String deptId;

    private String deptName;

    private String deptHead;
}
