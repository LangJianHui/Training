package com.aaa.mrlang.service;


import com.aaa.mrlang.entity.PageInfo;

import java.util.Map;

public interface UserService {
    PageInfo query(int start, int pageSize, Map condation);
}
