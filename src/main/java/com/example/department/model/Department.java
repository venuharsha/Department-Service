package com.example.department.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@Table(name = "department")
@AllArgsConstructor
@NoArgsConstructor
public class Department {

    @Id
    private String deptId;

    @NonNull
    private String deptName;

    @NonNull
    private String deptHead;
}
