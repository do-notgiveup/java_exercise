package vn.edu.likelion.springioc.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import vn.edu.likelion.springioc.repo.RepoSMS;

@Service
public class ServiceSMS {

    @Autowired
    private RepoSMS repoSMS;

    public ServiceSMS() {
        System.out.println("Khoi tao ServiceSMS");
    }

    @PostConstruct
    public void init() {
        System.out.println("Khoi dong");
    }

    public void print(String message) {
        System.out.println("Model Mapperrrrrrrrrrr: ");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Ket thuc");
    }

}
