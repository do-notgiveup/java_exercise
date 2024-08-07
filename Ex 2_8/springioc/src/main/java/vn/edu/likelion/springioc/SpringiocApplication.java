package vn.edu.likelion.springioc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import vn.edu.likelion.springioc.component.ComponentSMS;
import vn.edu.likelion.springioc.controller.ControllerSMS;
import vn.edu.likelion.springioc.repo.RepoSMS;
import vn.edu.likelion.springioc.service.ServiceSMS;

@SpringBootApplication
public class SpringiocApplication {

	public static void main(String[] args) {

		//ServiceSMS serviceSMS = new ServiceSMS();
		ApplicationContext context = SpringApplication.run(SpringiocApplication.class, args);

		ServiceSMS serviceSMS = context.getBean(ServiceSMS.class);
		serviceSMS.print("123abc");

//		// goi bean ComponentSMS tu IoC Container'
////		ComponentSMS componentSMS = context.getBean(ComponentSMS.class);
////		ComponentSMS componentSMS1 = context.getBean(ComponentSMS.class);
////		System.out.println(componentSMS);
////		System.out.println(componentSMS1);
//		ServiceSMS serviceSMS1 = context.getBean(ServiceSMS.class);
//		ComponentSMS componentSMS = new ComponentSMS(serviceSMS1);
//		componentSMS.print("heloooooooo!!!!!!!!");
//
//		// goi bean ServiceSMS tu IoC Container
//		ServiceSMS serviceSMS = context.getBean(ServiceSMS.class);
//		ServiceSMS serviceSMS2 = context.getBean(ServiceSMS.class);
//		System.out.println(serviceSMS);
//		System.out.println(serviceSMS1);
//		System.out.println(serviceSMS2);
//
//		// goi bean ControllerSMS tu IoC Container
//		ControllerSMS controllerSMS = context.getBean(ControllerSMS.class);
//		controllerSMS.print();
//
//		// goi bean RepoSMS tu IoC Container'
//		RepoSMS repoSMS = context.getBean(RepoSMS.class);
//		repoSMS.print("Java");
	}

}
