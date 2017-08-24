package com.mobile.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.mobile.model.Mobile;
@Repository
public class MobileNativeQueryDao {

	@PersistenceContext
    EntityManager em;
	
	 
	 @SuppressWarnings("unchecked")
	public List<Mobile> getAllMobilesBymobileBrand(String brands, String networkType, Integer mobileCore, Integer ramSize, String mobileOs)
	{
		 String query="from Mobile m where";
		 int count=0;
		 if(brands!=null)
		 {
			 query=query+" m.mobileBrand in ("+brands+")";
			 count++;
		 }
		 if(networkType!=null)
		 {
			if(count==0)
			{
				query +=" m.mobileNetworkType in ("+networkType+")";
				count++;
			}
			else
			{
				query += " AND m.mobileNetworkType in ("+networkType+")";
			}
		 }
		 if(mobileCore!=null)
		 {
			if(count==0)
			{
				query=query+" m.mobileAvailableCore in ("+mobileCore+")";
				count++;
			}
			else
			{
				query=query+" AND m.mobileAvailableCore in ("+mobileCore+")";
			}
		 }
		 if(ramSize!=null)
		 {
			if(count==0)
			{
				query=query+" m.mobileRAMSize in ("+ramSize+")";
				count++;
			}
			else
			{
				query=query+" AND m.mobileRAMSize in ("+ramSize+")";
			}
		 }
		 if(mobileOs!=null)
		 {
			if(count==0)
			{
				query=query+" m.mobileOS in ("+mobileOs+")";
				count++;
			}
			else
			{
				query=query+" AND m.mobileOS in ("+mobileOs+")";
			}
		 }
		 Query q = em.createQuery(query);
		 List<Mobile> mobile = q.getResultList();
		 return mobile;
	}
	 
	 @SuppressWarnings("unchecked")
	public List<Mobile> getAllMobilesBymobileBrands(String brands)
	 {
		 Query q = em.createQuery("from Mobile m where m.mobileBrand in ("+brands+")");
		 List<Mobile> mobile = q.getResultList();
		 return mobile;
	 }
	 
	 @SuppressWarnings("unchecked")
	public List<Mobile> getAllMobilesBymobileRamSize(Integer RamSize)
	 {
		 Query q = em.createQuery("from Mobile m where m.mobileRAMSize in ("+RamSize+")");
		 List<Mobile> mobile = q.getResultList();
		 return mobile;
	 }
	 
	 @SuppressWarnings("unchecked")
	public List<Mobile> getAllMobilesBymobileOs(String mobileOs)
	 {
		 Query q = em.createQuery("from Mobile m where m.mobileOS in ("+mobileOs+")");
		 List<Mobile> mobile = q.getResultList();
		 return mobile;
	 }
	 
	 @SuppressWarnings("unchecked")
	public List<Mobile> getAllMobilesBymobileNetworkType(String networkType)
	 {
		 Query q = em.createQuery("from Mobile m where m.mobileNetworkType in ("+networkType+")");
		 List<Mobile> mobile = q.getResultList();
		 return mobile;
	 }
	 
	 @SuppressWarnings("unchecked")
	public List<Mobile> getAllMobilesBymobileCore(Integer mobileCore)
	 {
		 Query q = em.createQuery("from Mobile m where m.mobileAvailableCore in ("+mobileCore+")");
		 List<Mobile> mobile = q.getResultList();
		 return mobile;
	 }
}
