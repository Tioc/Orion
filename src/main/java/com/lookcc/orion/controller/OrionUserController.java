package com.lookcc.orion.controller;

import com.github.pagehelper.PageInfo;
import com.lookcc.orion.model.OrionUser;
import com.lookcc.orion.service.OrionUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class OrionUserController {

    @Autowired
    private OrionUserService orionUserService;

    @GetMapping("/list")
    public PageInfo<OrionUser> list() {
        return new PageInfo<>(orionUserService.getAll());
    }
    
    @GetMapping("/{id}")
    public OrionUser detial(@PathVariable String id) {
        return orionUserService.getOne(id);
    }
    
    @PostMapping("/add")
    public int add(OrionUser orionUser) {
        return orionUserService.add(orionUser);
    }
    
    @PutMapping("/update")
    public int update(OrionUser orionUser) {
        return orionUserService.update(orionUser);
    }
    
    @DeleteMapping("/delete/{id}")
    public int delete(@PathVariable String id) {
        return orionUserService.delete(id);
    }
    
}
