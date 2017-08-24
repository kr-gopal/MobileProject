package com.mobile.service;


import com.mobile.dao.MobileDao;
import com.mobile.dao.MobileNativeQueryDao;
import com.mobile.model.Mobile;
import com.mobile.service.MobileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Service
public class MobileServiceImplementation implements MobileService{

    @Autowired
    private MobileDao mobileDao;
    @PersistenceContext
    EntityManager em;
    
    @Autowired
    private MobileNativeQueryDao dao;
    public List<Mobile> getAllMobilesBymobileAttribute(String brands, String networkType, Integer mobileCore, Integer ramSize, String mobileOs)
    {
    	if(brands==null && networkType==null && mobileCore==null && ramSize==null && mobileOs==null)
    	{
    		return (List<Mobile>) mobileDao.findAll();
    	}
    	else
    	{
    	return dao.getAllMobilesBymobileBrand(brands, networkType, mobileCore, ramSize, mobileOs);
    	}
    }
    
    // searching Mobile by multiple brands name only
    public List<Mobile> getAllMobilesBymobileBrands(String brands)
    {
    	
    	return dao.getAllMobilesBymobileBrands(brands);
    }
    
    // searching Mobile by multiple ramSize only
    public List<Mobile> getAllMobilesByRam(Integer mobileRam)
    {
    	return dao.getAllMobilesBymobileRamSize(mobileRam);
    }
    
    // searching Mobile by multiple mobileOs only
    public List<Mobile> getAllMobilesByOS(String mobileOS){
        return dao.getAllMobilesBymobileOs(mobileOS);
    }

    // searching Mobile by multiple mobileCore only
    public List<Mobile> getAllMobilesByMobileCore(Integer mobileCore){
        return dao.getAllMobilesBymobileCore(mobileCore);
    }
    
    // searching Mobile by multiple networkType
    public List<Mobile> getAllMobilesByMobileNetworkType(String networkType){
        return dao.getAllMobilesBymobileNetworkType(networkType);
    }
    
    //Get different all mobile Brands available in database
    public List<String> getAllMobileBrand(){
        return mobileDao.getAllDistinctBrand();
    }

    //Get different all mobile Rams available in database
    public List<Integer> getAllMobileRam(){
        return mobileDao.getAllDistinctRam();
    }

    //Get different all mobile Os available in database
    public List<String> getAllMobileOS(){
        return mobileDao.getAllDistinctMobileOS();
    }
 
    //Save mobile in database
    public Mobile saveMobile(Mobile mobile){
        return mobileDao.save(mobile);
    }

    //Get all mobiles
    public List<Mobile> getAllMobiles(){
        List<Mobile> mobileList= (List<Mobile>) mobileDao.findAll();
        return mobileList;
    }

    // merge two mobiles
    public Boolean mergerTwoMobiles(Integer mobileId1, Integer mobileId2){
        Mobile mobile1=mobileDao.findMobileByMobileId(mobileId1);
        Mobile mobile2=mobileDao.findMobileByMobileId(mobileId2);

        mobile1.setMobileBrand(mobile2.getMobileBrand());
        mobile1.setMobileName(mobile2.getMobileName());

        if(mobile2.getMobileBluethoothAvailablity()!=null)
            mobile1.setMobileBluethoothAvailablity(mobile2.getMobileBluethoothAvailablity());

        if(mobile2.getMobileWifiAvailability()!=null)
            mobile1.setMobileWifiAvailability(mobile2.getMobileWifiAvailability());

        if(mobile2.getMobileAvailableCore()!=null)
            mobile1.setMobileAvailableCore(mobile2.getMobileAvailableCore());

        if(mobile2.getMobileNetworkType()!=null)
            mobile1.setMobileNetworkType(mobile2.getMobileNetworkType());

        if(mobile2.getMobileOS()!=null)
            mobile1.setMobileOS(mobile2.getMobileOS());

        if(mobile2.getMobileRAMSize()!=null)
            mobile1.setMobileRAMSize(mobile2.getMobileRAMSize());

        saveMobile(mobile1);
        mobileDao.delete(mobile2);


        return true;

    }
}
