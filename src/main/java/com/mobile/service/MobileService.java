package com.mobile.service;

import com.mobile.model.Mobile;

import java.util.List;


public interface MobileService {


    /**
     * Getting all moble by brand
     * @param mobileBrand
     * @return
     */
	
    public List<Mobile> getAllMobilesByBrand(String mobileBrand);

    public List<Mobile> getMobileSearch(String mobileBrand, Integer mobileRAMSize, String mobileOS);

    /**
     * Getting all mobile by different RAM
     * @param mobileRam
     * @return
     */
    public List<Mobile> getAllMobilesByRam(Integer mobileRam);

    /**
     * Getting all mobile brand available in database
     * @return
     */
    public List<String> getAllMobileBrand();
  //  public List<Mobile> getAllMobilesByMultipleBrand(String brand1, String brand2);


    /**
     * Getting all mobile RAM possible in database
     * @return
     */
    public List<Integer> getAllMobileRam();


    /**
     * Getting all mobile by given OS
     * @param mobileOS
     * @return
     */
    public List<Mobile> getAllMobilesByOS(String mobileOS);

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