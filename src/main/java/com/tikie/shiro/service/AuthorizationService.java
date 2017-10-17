package com.tikie.shiro.service;

import com.tikie.shiro.entity.Authorization;

/**
 * @targget     AuthorizationService
 *
 * @author      tikie
 * @date        2016-10-09
 * @version     1.0.0
 */
public interface AuthorizationService {


    Authorization getById(String id);
}
