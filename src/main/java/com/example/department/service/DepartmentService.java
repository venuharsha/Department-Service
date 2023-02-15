package com.example.department.service;

import com.example.department.dto.DepartmentRequest;
import com.example.department.dto.DepartmentResponse;
import com.example.department.exception.DepartmentNotFoundException;
import com.example.department.model.Department;
import com.example.department.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    public String createDepartment(DepartmentRequest departmentRequest) {
        Department d = Department.builder()
                .deptId(departmentRequest.getId())
                .deptName(departmentRequest.getDeptName())
                .deptHead(departmentRequest.getDeptHead())
                .build();
        departmentRepository.save(d);

        return "Department created successfully.";

    }

    public List<DepartmentResponse> getAllDepartments() {

        List<Department> departmentList = departmentRepository.findAll();
        return departmentList.stream().map(department -> mapToDepartmentResponse(department)).toList();
    }

    private DepartmentResponse mapToDepartmentResponse(Department department) {

        return DepartmentResponse.builder()
                .deptId(department.getDeptId())
                .deptName(department.getDeptName())
                .deptHead(department.getDeptHead())
                .build();
    }

    public DepartmentResponse getDepartmentById(String id) {
        Optional<Department> byId = departmentRepository.findById(String.valueOf(id));
        if (byId.isPresent()) {
            return mapToDepartmentResponse(byId.get());
        } else {
            throw new DepartmentNotFoundException("Department not found for given id: " + id);
        }
    }

    public List<DepartmentResponse> getDepartmentByName(String name) {
        List<Department> byDeptName = departmentRepository.findByDeptName(name);
        if (!CollectionUtils.isEmpty(byDeptName)) return byDeptName.stream().map(department -> mapToDepartmentResponse(department)).toList();
        else throw new DepartmentNotFoundException("Department not found for given name: "+ name);
    }
}
