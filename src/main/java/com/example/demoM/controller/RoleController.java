package com.example.demoM.controller;

import com.example.demoM.dto.RoleDto;
import com.example.demoM.service.role.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class RoleController {
    private final RoleService roleService;

    @GetMapping("/roles")
    public String getRoles(Model model){
        List<RoleDto> roles = roleService.getAllRoles();

        model.addAttribute("title", "Roles");
        model.addAttribute("roles", roles);

        return "roles";
    }

    @GetMapping("/roles/{id}")
    public RoleDto getRoleById(@PathVariable Integer id){
        return roleService.getRoleById(id);
    }
}
