package com.example.department.dto;

import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class DepartmentResponse {

    @Id
    private String deptId;

    @NonNull
    private String deptName;

    @NonNull
    private String deptHead;
}
