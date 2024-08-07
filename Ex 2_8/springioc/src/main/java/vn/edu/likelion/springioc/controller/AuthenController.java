package vn.edu.likelion.springioc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import vn.edu.likelion.springioc.service.ServiceSMS;

@Controller
public class AuthenController {
    @Autowired
    ServiceSMS serviceSMS;
}
