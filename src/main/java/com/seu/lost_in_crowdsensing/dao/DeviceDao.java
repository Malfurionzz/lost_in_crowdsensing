package com.seu.lost_in_crowdsensing.dao;

import com.seu.lost_in_crowdsensing.entity.Device;

import java.util.List;

public interface DeviceDao {
    List<Device> queryDevice(String usrName);
    Device queryDeviceByName(String deviceName);
    Device queryDeviceByBlueToothID(String blueToothID);
    int insertDevice(Device device);
    int updateDevice(Device device);
    int deleteDevice(Device device);
}
