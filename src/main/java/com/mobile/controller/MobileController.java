package com.mobile.controller;

import com.mobile.model.Mobile;
import com.mobile.service.MobileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping(value = "/mobileApi")
public class MobileController {

    @Autowired
    private MobileService mobileService;

    @RequestMapping(value = "/getAllMobiles", method = RequestMethod.GET)
    public ResponseEntity<List<Mobile>> getAllMobiles(){
        List<Mobile> mobileList=mobileService.getAllMobiles();
        return new ResponseEntity<List<Mobile>>(mobileList,HttpStatus.OK);
    }

    @RequestMapping(value = "/findMobileByBrand", method = RequestMethod.GET)
    public ResponseEntity<List<Mobile>> getAllMobilesByBrand(@RequestParam(value = "brand") String brand){
        List<Mobile> mobileList=mobileService.getAllMobilesByBrand(brand);
        return new ResponseEntity<List<Mobile>>(mobileList,HttpStatus.OK);

    }
    @RequestMapping(value = "/findMobileByMultipleBrand", method = RequestMethod.GET)
    public ResponseEntity<List<Mobile>> getAllMobilesByMultipleBrand(@RequestParam(value = "brand1") String brand1, @RequestParam(value="brand2")String brand2){
        List<Mobile> mobileList=mobileService.getAllMobilesByMultipleBrand(brand1,brand2);
        return new ResponseEntity<List<Mobile>>(mobileList,HttpStatus.OK);

    }

    @RequestMapping(value = "/findMobileByOS", method = RequestMethod.GET)
    public ResponseEntity<List<Mobile>> getAllMobilesByOS(@RequestParam(value = "os") String os){
        List<Mobile> mobileList=mobileService.getAllMobilesByOS(os);
        return new ResponseEntity<List<Mobile>>(mobileList,HttpStatus.OK);

    }

    @RequestMapping(value = "/findMobileByRAM", method = RequestMethod.GET)
    public ResponseEntity<List<Mobile>> getAllMobilesByRAM(@RequestParam(value = "ram") Integer ram){
        List<Mobile> mobileList=mobileService.getAllMobilesByRam(ram);
        return new ResponseEntity<List<Mobile>>(mobileList,HttpStatus.OK);

    }
    @RequestMapping(value="/searchMobile", method=RequestMethod.GET)
    public ResponseEntity<List<Mobile>> searchMobile(@RequestParam(value="brand") String mobileBrand, @RequestParam(value="ramSize") Integer ramSize, @RequestParam(value="mobileOs") String MobileOs)
    {
    	List<Mobile> mobileList=mobileService.getMobileSearch(mobileBrand,ramSize,MobileOs);
    	return new ResponseEntity<List<Mobile>>(mobileList,HttpStatus.OK);
    }
    @RequestMapping(value="/postMobile", method=RequestMethod.POST)
    public void storeMobile(@RequestParam(value="name")String Name, @RequestParam(value="brand") String Brand, @RequestParam(value="NetworkType") String NetworkType, @RequestParam(value="mobileOs") String MobileOs, @RequestParam(value="mobileCore") Integer mobileCore, @RequestParam(value="mobileRam") Integer mobileRam, @RequestParam(value="mobile_wifif") boolean mobile_wifif, @RequestParam(value="mobile_bluetooth") boolean mobile_bluetooth)
    {
		Mobile M=new Mobile(Name, Brand, NetworkType,mobileCore,mobileRam,MobileOs,mobile_wifif, mobile_bluetooth);
		mobileService.saveMobile(M);
    }
    @RequestMapping(value = "/getAllMobileBrand", method = RequestMethod.GET)
    public ResponseEntity<List<String>> getAllMobileBrand(){
        List<String> mobileList=mobileService.getAllMobileBrand();
        return new ResponseEntity<List<String>>(mobileList,HttpStatus.OK);

    }

    @RequestMapping(value = "/getAllMobileOS", method = RequestMethod.GET)
    public ResponseEntity<List<String>> getAllMobileOS(){
        List<String> mobileList=mobileService.getAllMobileOS();
        return new ResponseEntity<List<String>>(mobileList,HttpStatus.OK);

    }

    @RequestMapping(value = "/getAllMobileRAM", method = RequestMethod.GET)
    public ResponseEntity<List<Integer>> getAllMobileRAM(){
        List<Integer> mobileList=mobileService.getAllMobileRam();
        return new ResponseEntity<List<Integer>>(mobileList,HttpStatus.OK);

    }
    @RequestMapping(value="/merge", method=RequestMethod.GET)
    public Boolean merge(@RequestParam("mobile1") Integer mobile1_id ,@RequestParam("mobile2") Integer mobile2_id)
    {
        return mobileService.mergerTwoMobiles(mobile1_id,mobile2_id);
    }


    @RequestMapping("*")
    @ResponseBody
    public String fallBack(){
        return "Fall Back";
    }




}
