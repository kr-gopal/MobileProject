package com.mobile.model;

import javax.persistence.*;


@Entity
@Table(name = "mobile_table")
public class Mobile {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public int mobileId;

    @Column(name = "mobile_name",nullable = false,length = 20)
    public String mobileName;

    @Column(name = "mobile_brand",nullable = false,length = 15)
    public String mobileBrand;

    @Column(name="mobile_networkType")
    public String mobileNetworkType;

    @Column(name = "mobile_core")
    public Integer mobileAvailableCore;

    @Column(name = "mobile_ram")
    public Integer mobileRAMSize;

    @Column(name = "mobile_os")
    public String mobileOS;

    @Column(name = "mobile_wifif")
    public Boolean mobileWifiAvailability;

    @Column(name = "mobile_bluetooth")
    public Boolean mobileBluethoothAvailablity;

    public Mobile() {
    }

    public Mobile(String mobileName, String mobileBrand, String mobileNetworkType, Integer mobileAvailableCore, Integer mobileRAMSize, String mobileOS, Boolean mobileWifiAvailability, Boolean mobileBluethoothAvailablity) {
        this.mobileName = mobileName;
        this.mobileBrand = mobileBrand;
        this.mobileNetworkType = mobileNetworkType;
        this.mobileAvailableCore = mobileAvailableCore;
        this.mobileRAMSize = mobileRAMSize;
        this.mobileOS = mobileOS;
        this.mobileWifiAvailability = mobileWifiAvailability;
        this.mobileBluethoothAvailablity = mobileBluethoothAvailablity;
    }

    public int getMobileId() {
        return mobileId;
    }

    public void setMobileId(int mobileId) {
        this.mobileId = mobileId;
    }

    public String getMobileName() {
        return mobileName;
    }

    public void setMobileName(String mobileName) {
        this.mobileName = mobileName;
    }

    public String getMobileBrand() {
        return mobileBrand;
    }

    public void setMobileBrand(String mobileBrand) {
        this.mobileBrand = mobileBrand;
    }

    public String getMobileNetworkType() {
        return mobileNetworkType;
    }

    public void setMobileNetworkType(String mobileNetworkType) {
        this.mobileNetworkType = mobileNetworkType;
    }

    public Integer getMobileAvailableCore() {
        return mobileAvailableCore;
    }

    public void setMobileAvailableCore(Integer mobileAvailableCore) {
        this.mobileAvailableCore = mobileAvailableCore;
    }

    public Integer getMobileRAMSize() {
        return mobileRAMSize;
    }

    public void setMobileRAMSize(Integer mobileRAMSize) {
        this.mobileRAMSize = mobileRAMSize;
    }

    public String getMobileOS() {
        return mobileOS;
    }

    public void setMobileOS(String mobileOS) {
        this.mobileOS = mobileOS;
    }

    public Boolean getMobileWifiAvailability() {
        return mobileWifiAvailability;
    }

    public void setMobileWifiAvailability(Boolean mobileWifiAvailability) {
        this.mobileWifiAvailability = mobileWifiAvailability;
    }

    public Boolean getMobileBluethoothAvailablity() {
        return mobileBluethoothAvailablity;
    }

    public void setMobileBluethoothAvailablity(Boolean mobileBluethoothAvailablity) {
        this.mobileBluethoothAvailablity = mobileBluethoothAvailablity;
    }

    @Override
    public String toString() {
        return "Mobile{" +
                "mobileId=" + mobileId +
                ", mobileName='" + mobileName + '\'' +
                ", mobileBrand='" + mobileBrand + '\'' +
                ", mobileNetworkType='" + mobileNetworkType + '\'' +
                ", mobileAvailableCore=" + mobileAvailableCore +
                ", mobileRAMSize=" + mobileRAMSize +
                ", mobileOS='" + mobileOS + '\'' +
                ", mobileWifiAvailability=" + mobileWifiAvailability +
                ", mobileBluethoothAvailablity=" + mobileBluethoothAvailablity +
                '}';
    }
}
