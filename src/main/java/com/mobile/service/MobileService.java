package com.mobile.service;

import com.mobile.model.Mobile;

import java.util.List;


public interface MobileService {

	/**
     * Getting all mobile by different Attribute
     * @param mobileBrand, networkType, mobileCore, ramSize, mobileOs
     * @return
     */
	public List<Mobile> getAllMobilesBymobileAttribute(String brands, String networkType, Integer mobileCore, Integer ramSize, String mobileOs);
	
	/**
     * Getting all mobile by brands
     * @param mobileBrand
     * @return
     */
	public List<Mobile> getAllMobilesBymobileBrands(String brands);
	
	/**
     * Getting all mobile by different RAM
     * @param mobileRam
     * @return
     */
	public List<Mobile> getAllMobilesByRam(Integer mobileRam);
	
	/**
     * Getting all mobile by given OS
     * @param mobileOS
     * @return
     */
	public List<Mobile> getAllMobilesByOS(String mobileOS);
	
	/**
     * Getting all mobile by given mobileCore
     * @param mobileCore
     * @return
     */
	public List<Mobile> getAllMobilesByMobileCore(Integer mobileCore);
	
	/**
     * Getting all mobile by given networkType
     * @param networkType
     * @return
     */
	public List<Mobile> getAllMobilesByMobileNetworkType(String networkType);
	
	/**
     * Getting all mobile brand available in database
     * @return
     */
	public List<String> getAllMobileBrand();
	
	/**
     * Getting all mobile RAM possible in database
     * @return
     */
	public List<Integer> getAllMobileRam();
	
	/**
     * Getting all possible OS in Database
     * @return
     */
	public List<String> getAllMobileOS();
	
	/**
     * Adding new mobile in database
     * @param mobile
     * @return
     */
	public Mobile saveMobile(Mobile mobile);
	
	/**
     * Returning all possible mobiles
     * @return
     */
	public List<Mobile> getAllMobiles();
	
	/**
     * Merging two mobile on user preference
     * @param mobileId1
     * @param mobileId2
     * @return
     */

    public Boolean mergerTwoMobiles(Integer mobileId1, Integer mobileId2);
    }