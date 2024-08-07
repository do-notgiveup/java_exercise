package vn.edu.likelion.springioc.component;

import vn.edu.likelion.springioc.service.ServiceSMS;

public class ComponentSMS {

    private ServiceSMS serviceSMS;

    public ComponentSMS(ServiceSMS serviceSMS) {
        this.serviceSMS = serviceSMS;
    }

    public void print(String message) {
        serviceSMS.print(message);
    }

}
