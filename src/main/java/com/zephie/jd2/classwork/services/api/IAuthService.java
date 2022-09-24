package com.zephie.jd2.classwork.services.api;

import com.zephie.jd2.classwork.core.dto.UserLoginDTO;
import com.zephie.jd2.classwork.core.entity.User;

public interface IAuthService {
    User login(UserLoginDTO userLoginDTO);
}
