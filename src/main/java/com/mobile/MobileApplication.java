package com.mobile;

import com.mobile.model.Mobile;
import com.mobile.service.MobileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class MobileApplication implements CommandLineRunner {

    @Autowired
    private MobileService mobileService;

    public static void main(String[] args) {
        SpringApplication.run(MobileApplication.class,args);
    }

    public void run(String... strings) throws Exception {
            //public Mobile(String mobileName, String mobileBrand, String mobileNetworkType, Integer mobileAvailableCore, Integer mobileRAMSize, String mobileOS, Boolean mobileWifiAvailability, Boolean mobileBluethoothAvailablity) {

             Mobile mobile1=new Mobile("Mobile1","Samsung","4G LTE",4,2,"Android",true,true);
             mobileService.saveMobile(mobile1);
             Mobile mobile2=new Mobile("Mobile2","LG","4G LTE",4,2,"Android",true,true);
             mobileService.saveMobile(mobile2);
             Mobile mobile3=new Mobile("Mobile3","Samsung","3G",4,2,"Android",true,true);
             mobileService.saveMobile(mobile3);
             Mobile mobile4=new Mobile("Mobile4","Samsung","4G",6,2,"Android",true,true);
             mobileService.saveMobile(mobile4);
             Mobile mobile5=new Mobile("Mobile5","Samsung","4G LTE",4,2,"Window",true,true);
             mobileService.saveMobile(mobile5);
             Mobile mobile6=new Mobile("Mobile6","Blackberry","4G LTE",4,2,"Android",true,true);
             mobileService.saveMobile(mobile6);
             Mobile mobile7=new Mobile("Mobile7","Blackberry","4G",4,2,"Android",true,true);
             mobileService.saveMobile(mobile7);
             Mobile mobile8=new Mobile("Mobile8","Blacberry","3G",4,2,"Android",true,true);
             mobileService.saveMobile(mobile8);
             Mobile mobile9=new Mobile("Mobile9","Blackberry","4G LTE",4,2,"Blackberry",true,true);
             mobileService.saveMobile(mobile9);
             Mobile mobile10=new Mobile("Mobile10","Blackberry","4G LTE",2,2,"Blackberry",true,true);
             mobileService.saveMobile(mobile10);
             Mobile mobile11=new Mobile("Mobile11","Blackberry","4G LTE",4,4,"Blackberry",true,true);
             mobileService.saveMobile(mobile11);
             Mobile mobile12=new Mobile("Mobile12","Blackberry","4G LTE",4,4,"Blackberry",false,true);
             mobileService.saveMobile(mobile12);
             Mobile mobile13=new Mobile("Mobile13","Blackberry","4G LTE",4,4,"Blackberry",true,false);
             mobileService.saveMobile(mobile13);
             Mobile mobile14=new Mobile("Mobile14","Blackberry","4G LTE",4,4,"Blackberry",false,false);
             mobileService.saveMobile(mobile14);
             Mobile mobile15=new Mobile("Mobile15","Blackberry","4G LTE",4,4,"Blackberry",true,true);
             mobileService.saveMobile(mobile15);
             Mobile mobile16=new Mobile("Mobile16","Samsung","4G LTE",4,2,"Android",true,true);
             mobileService.saveMobile(mobile16);
             Mobile mobile17=new Mobile("Mobile17","Samsung","4G",4,2,"Android",true,true);
             mobileService.saveMobile(mobile17);

    }
}
