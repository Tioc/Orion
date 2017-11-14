package com.lookcc.orion.service;


import com.github.pagehelper.PageHelper;
import com.lookcc.orion.mapper.OrionUserMapper;
import com.lookcc.orion.model.OrionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrionUserService {

    @Autowired
    private OrionUserMapper orionUserMapper;

    public List<OrionUser> getAll() {
        PageHelper.startPage(1, 10);
        return orionUserMapper.selectAll();
    }

    public OrionUser getOne(String id) {
        return orionUserMapper.selectByPrimaryKey(id);
    }

    public int add(OrionUser orionUser) {
        return orionUserMapper.insert(orionUser);
    }

    public int update(OrionUser orionUser) {
        return orionUserMapper.updateByPrimaryKey(orionUser);
    }

    public int delete(String id) {
        return orionUserMapper.deleteByPrimaryKey(id);
    }
}
