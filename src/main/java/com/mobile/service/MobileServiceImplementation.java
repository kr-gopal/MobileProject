package com.mobile.service;

import com.mobile.MobileApplication;
import com.mobile.dao.MobileDao;
import com.mobile.model.Mobile;
import com.mobile.service.MobileService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MobileServiceImplementation implements MobileService{

    @Autowired
    private MobileDao mobileDao;
    
    public List<Mobile> getAllMobilesByBrand(String mobileBrand){
        return mobileDao.findByMobileBrand(mobileBrand);
    }

    /*public List<Mobile>getAllMobilesByMultipleBrand(String brand1, String brand2)
    {
    	return mobileDao.findAll(where(getAllMobilesByBrand(brand1))
    			.and(getAllMobilesByBrand(brand2)));
    }*/
    public List<Mobile> getAllMobilesByOS(String mobileOS){
        return mobileDao.findByMobileOS(mobileOS);
    }


    public List<Mobile> getAllMobilesByRam(Integer mobileRam){
        return mobileDao.findByMobileRAMSize(mobileRam);
    }

    public List<String> getAllMobileBrand(){
        return mobileDao.getAllDistinctBrand();
    }

    public List<Integer> getAllMobileRam(){
        return mobileDao.getAllDistinctRam();
    }

    public List<String> getAllMobileOS(){
        return mobileDao.getAllDistinctMobileOS();
    }

    //Query for multiple selection
    @SuppressWarnings("unchecked")
	public List<Mobile> getMobileSearch(String mobileBrand, Integer mobileRAMSize, String mobileOS){
    	return mobileDao.findAll(Specifications.where((Specification<Mobile>) getAllMobilesByBrand(mobileBrand))
    			.and((Specification<Mobile>) getAllMobilesByOS(mobileOS))
    			.and((Specification<Mobile>) getAllMobilesByRam(mobileRAMSize)));
    }
    
    public Mobile saveMobile(Mobile mobile){
        return mobileDao.save(mobile);
    }

    public List<Mobile> getAllMobiles(){
        List<Mobile> mobileList= (List<Mobile>) mobileDao.findAll();
        return mobileList;
    }

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

	/*public List<Mobile> getMobileSearch(String mobileName, String mobileBrand,
			String mobileNetworkType, Integer mobileAvailableCore,
			Integer mobileRAMSize, String mobileOS,
			Boolean mobileWifiAvailability, Boolean mobileBluethoothAvailablity) {
		// TODO Auto-generated method stub
		return null;
	}
*/
}
