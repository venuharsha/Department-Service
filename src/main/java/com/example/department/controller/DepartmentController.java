package com.example.department.controller;

import com.example.department.dto.DepartmentRequest;
import com.example.department.dto.DepartmentResponse;
import com.example.department.service.DepartmentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/department/")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @PostMapping("create")
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public String createDepartment(@RequestBody DepartmentRequest departmentRequest) {
        return departmentService.createDepartment(departmentRequest);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    @Transactional
    public List<DepartmentResponse> getAllDepartments() {

        return departmentService.getAllDepartments();
    }

    @GetMapping("byId")
    @ResponseStatus(HttpStatus.OK)
    public DepartmentResponse getDepartmentById(@RequestParam(value="deptId") String id) {
        return departmentService.getDepartmentById(id);
    }

    @GetMapping("byName")
    @ResponseStatus(HttpStatus.OK)
    public List<DepartmentResponse> getDepartmentByName(@RequestParam(value = "deptName") String name) {
        return departmentService.getDepartmentByName(name);
    }
}
