package com.seu.lost_in_crowdsensing.service.implement;

import com.seu.lost_in_crowdsensing.dao.DeviceDao;
import com.seu.lost_in_crowdsensing.dao.UsrDao;
import com.seu.lost_in_crowdsensing.entity.Device;
import com.seu.lost_in_crowdsensing.entity.Usr;
import com.seu.lost_in_crowdsensing.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class DataServiceImp implements DataService {
    @Autowired
    private DeviceDao deviceDao;
    private UsrDao usrDao;

    @Override
    public List<Device> getDeviceList(String usrName) {
        return deviceDao.queryDevice(usrName);
    }

    @Transactional
    @Override
    public Device getDeviceByName(Usr usr, String deviceName) {
        if (usr.getUsrName()!=null){
            Device device=deviceDao.queryDeviceByName(deviceName);
            try {
                if (device.getUsrName().equals(usr.getUsrName()))
                    return device;
                else
                    throw new RuntimeException("Get device failed");
            }catch (Exception e){
                throw new RuntimeException("No such device!");
            }
        }else {
            throw new RuntimeException("Device name cannot be null!");
        }
    }

    @Override
    public Device getDeviceByToothID(String blueToothID) {
        return deviceDao.queryDeviceByBlueToothID(blueToothID);
    }

    @Transactional
    @Override
    public Boolean addDevice(Device device) {
        if (device.getDeviceName()!=null && !"".equals(device.getDeviceName())){
            try {
                int effectedNum = deviceDao.insertDevice(device);
                if (effectedNum>0){
                    return true;
                }else {
                    throw new RuntimeException("Add device failed!");
                }
            }catch (Exception e){
                throw new RuntimeException("Add device failed:"+e.getMessage());
            }
        }else {
            throw new RuntimeException("Device Name cannot be null!");
        }
    }

    @Transactional
    @Override
    public Boolean upDateDevicePosition(Device device) {
        if (device.getBlueToothID()!=null && "".equals(device.getBlueToothID())){
            try {
                Device toMod=deviceDao.queryDeviceByBlueToothID(device.getBlueToothID());
                if (toMod!=null){
                    toMod.setLatitude(device.getLatitude());
                    toMod.setLongitude(device.getLongitude());
                    deviceDao.updateDevice(toMod);
                    return true;
                }else {
                    throw new RuntimeException("No such Device!");
                }
            }catch (Exception e){
                throw new RuntimeException("update position failed!");
            }
        }else {
            throw new RuntimeException("BlueTooth ID cannot be null!");
        }
    }

    @Transactional
    @Override
    public Boolean upDateDeviceState(Device device) {
        if (device.getDeviceName()!=null && "".equals(device.getDeviceName())){
            try {
                Device toMod=deviceDao.queryDeviceByName(device.getDeviceName());
                if (toMod!=null){
                    toMod.setIsLost(device.getIsLost());
                    deviceDao.updateDevice(toMod);
                    return true;
                }else {
                    throw new RuntimeException("No such Device!");
                }
            }catch (Exception e){
                throw new RuntimeException("update state failed!");
            }
        }else {
            throw new RuntimeException("Device name cannot be null!");
        }
    }

    @Transactional
    @Override
    public Boolean upDateDeviceInfo(Device device) {
        if (device.getDeviceName()!=null && "".equals(device.getDeviceName())){
            try {
                Device toMod=deviceDao.queryDeviceByName(device.getDeviceName());
                if (toMod!=null){
                    deviceDao.updateDevice(device);
                    return true;
                }else {
                    throw new RuntimeException("No such Device!");
                }
            }catch (Exception e){
                throw new RuntimeException("update device failed!");
            }
        }else {
            throw new RuntimeException("Device name cannot be null!");
        }
    }

    @Override
    public Boolean addUsr(Usr usr) {
        if (usr.getUsrName()!=null && !"".equals(usr.getUsrName())){
            try {
                int effectedNum = usrDao.insertUsr(usr);
                if (effectedNum>0){
                    return true;
                }else {
                    throw new RuntimeException("Add user failed!");
                }
            }catch (Exception e){
                throw new RuntimeException("Add user failed:"+e.getMessage());
            }
        }else {
            throw new RuntimeException("User Name cannot be null!");
        }
    }
}
