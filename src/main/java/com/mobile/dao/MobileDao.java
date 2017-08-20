package com.mobile.dao;

import com.mobile.model.Mobile;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
public interface MobileDao extends CrudRepository<Mobile, Integer>, JpaSpecificationExecutor<Mobile> {

    public List<Mobile> findByMobileBrand(String mobileBrand);

    @Query("select distinct m.mobileBrand from Mobile m")
    public List<String > getAllDistinctBrand();

    public List<Mobile> findByMobileRAMSize(Integer mobileRAMSize);

    @Query("select distinct m.mobileRAMSize from Mobile m")
    public List<Integer> getAllDistinctRam();

    public List<Mobile> findByMobileOS(String mobileOS);


    @Query("select distinct m.mobileOS from Mobile m")
    public List<String > getAllDistinctMobileOS();

    public Mobile findMobileByMobileId(Integer mobileId);
    //public Mobile find
}
