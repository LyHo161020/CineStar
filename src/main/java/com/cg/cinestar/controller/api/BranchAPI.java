package com.cg.cinestar.controller.api;

import com.cg.cinestar.model.Branch;
import com.cg.cinestar.model.Role;
import com.cg.cinestar.service.branch.IBranchService;
import com.cg.cinestar.service.role.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/branches")
public class BranchAPI {
    @Autowired
    private IBranchService branchService;
    @GetMapping
    public ResponseEntity<?> findAllBranch() {
        List<Branch> branches = branchService.findAll();

        if(branches.isEmpty()) {
            return new ResponseEntity<>("Danh sach trong", HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(branches, HttpStatus.OK);
    }
}
