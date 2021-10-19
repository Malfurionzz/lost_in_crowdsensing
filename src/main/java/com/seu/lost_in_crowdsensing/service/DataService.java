package com.seu.lost_in_crowdsensing.service;

import com.seu.lost_in_crowdsensing.entity.Device;
import com.seu.lost_in_crowdsensing.entity.Usr;

import java.util.List;

public interface DataService {
    List<Device> getDeviceList(String usrName);

    Device getDeviceByName(Usr usr, String deviceName);

    Device getDeviceByToothID(String blueToothID);

    Boolean addDevice(Device device);

//    Boolean delDevice(Device device);

    Boolean upDateDevicePosition(Device device);

    Boolean upDateDeviceState(Device device);

    Boolean upDateDeviceInfo(Device device);

    Boolean usrSignUp(Usr usr);

    Boolean usrSignIn(Usr usr);
}
