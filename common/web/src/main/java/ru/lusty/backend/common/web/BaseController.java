package ru.lusty.backend.common.web;

import org.springframework.beans.factory.annotation.Autowired;
import ru.lusty.auth.api.service.AuthService;

public class BaseController {

    @Autowired
    protected AuthService authService;


}
