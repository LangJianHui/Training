package com.aaa.mrlang.service;


import com.aaa.mrlang.entity.Pager;

public interface UserService {
    Pager query(int pageNo);
}
