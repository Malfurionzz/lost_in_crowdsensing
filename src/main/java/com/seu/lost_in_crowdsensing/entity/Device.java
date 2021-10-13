package com.seu.lost_in_crowdsensing.entity;

public class Device {
    private Integer deviceID;
    private String deviceName;
    private String blueToothID;
    private Double latitude;
    private Double longitude;
    private Boolean isLost;
    private String usrName;

    public Device(String deviceName, String blueToothID, Double latitude, Double longitude, Boolean isLost, String usrName) {
        this.deviceName = deviceName;
        this.blueToothID = blueToothID;
        this.latitude = latitude;
        this.longitude = longitude;
        this.isLost = isLost;
        this.usrName = usrName;
    }

    public Device() {
    }

    public String getBlueToothID() {
        return blueToothID;
    }

    public void setBlueToothID(String blueToothID) {
        this.blueToothID = blueToothID;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Boolean getIsLost() {
        return isLost;
    }

    public void setIsLost(Boolean isLost) {
        this.isLost = isLost;
    }



    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }


    public Integer getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(Integer deviceID) {
        this.deviceID = deviceID;
    }

    public String getUsrName() {
        return usrName;
    }

    public void setUsrName(String usrName) {
        this.usrName = usrName;
    }
}
