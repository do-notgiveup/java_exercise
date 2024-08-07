package vn.edu.likelion.springioc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import vn.edu.likelion.springioc.service.ServiceSMS;

@Controller
public class ControllerSMS {

    @Autowired
    ServiceSMS serviceSMS;

    public void print() {

        System.out.println("Xu ly input");
        serviceSMS.print("goi den service");
    }
}
