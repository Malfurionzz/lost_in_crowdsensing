package com.seu.lost_in_crowdsensing.service.implement;

import com.seu.lost_in_crowdsensing.dao.DeviceDao;
import com.seu.lost_in_crowdsensing.dao.UsrDao;
import com.seu.lost_in_crowdsensing.entity.Device;
import com.seu.lost_in_crowdsensing.entity.Usr;
import com.seu.lost_in_crowdsensing.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DataServiceImp implements DataService {
    @Autowired
    private DeviceDao deviceDao;
    @Autowired
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
                    throw new RuntimeException("No such device!");
            }catch (Exception e){
                throw new RuntimeException("Device error:"+e.getMessage());
            }
        }else {
            throw new RuntimeException("Device name cannot be null!");
        }
    }

    @Override
    public Device getDeviceByToothID(String blueToothID) {
        if (blueToothID!=null){
            Device device=deviceDao.queryDeviceByBlueToothID(blueToothID);
            try {
                if (device!=null)
                    return device;
                else
                    throw new RuntimeException("No such device!");
            }catch (Exception e){
                throw new RuntimeException("No such device!"+e.getMessage());
            }
        }else {
            throw new RuntimeException("BlueToothID cannot be null!");
        }
    }

    @Transactional
    @Override
    public Boolean isLost(String blueToothID) {
        if (blueToothID!=null){
            try {
                Device device=deviceDao.queryDeviceByBlueToothID(blueToothID);
                if (device==null){
                    throw new RuntimeException("No such device!");
                }else {
                    return device.getIsLost();
                }
            }catch (Exception e){
                throw new RuntimeException("Device error:"+e.getMessage());
            }
        }else {
            throw new RuntimeException("BlueTooth ID cannot be null!");
        }
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
                throw new RuntimeException("Device error:"+e.getMessage());
            }
        }else {
            throw new RuntimeException("Device Name cannot be null!");
        }
    }

    @Transactional
    @Override
    public Boolean upDateDevicePosition(Device device) {
        if (device.getBlueToothID()!=null && !"".equals(device.getBlueToothID())){
            try {
                Device toMod=deviceDao.queryDeviceByBlueToothID(device.getBlueToothID());
                if (toMod!=null){
                    deviceDao.updateDevice(device);
                    return true;
                }else {
                    throw new RuntimeException("No such Device!");
                }
            }catch (Exception e){
                throw new RuntimeException("Device error:"+e.getMessage());
            }
        }else {
            throw new RuntimeException("BlueTooth ID cannot be null!");
        }
    }

    @Transactional
    @Override
    public Boolean upDateDeviceState(Device device) {
        if (device.getBlueToothID()!=null && !"".equals(device.getBlueToothID())){
            try {
                Device toMod=deviceDao.queryDeviceByBlueToothID(device.getBlueToothID());
                if (toMod!=null){
                    deviceDao.updateDevice(device);
                    return true;
                }else {
                    throw new RuntimeException("No such Device!");
                }
            }catch (Exception e){
                throw new RuntimeException("Device error:"+e.getMessage());
            }
        }else {
            throw new RuntimeException("BlueToothID cannot be null!");
        }
    }

    @Transactional
    @Override
    public Boolean upDateDeviceInfo(Device device) {
        if (device.getDeviceName()!=null && !"".equals(device.getDeviceName())){
            try {
                Device toMod=deviceDao.queryDeviceByName(device.getDeviceName());
                if (toMod!=null){
                    deviceDao.updateDevice(device);
                    return true;
                }else {
                    throw new RuntimeException("No such Device!");
                }
            }catch (Exception e){
                throw new RuntimeException("Device error:"+e.getMessage());
            }
        }else {
            throw new RuntimeException("Device name cannot be null!");
        }
    }

    @Transactional
    @Override
    public Boolean usrSignUp(Usr usr) {
        if (usr.getUsrName()!=null && !"".equals(usr.getUsrName())){
            try {
                int effectedNum = usrDao.insertUsr(usr);
                if (effectedNum>0){
                    return true;
                }else {
                    throw new RuntimeException("Add user failed!");
                }
            }catch (Exception e){
                throw new RuntimeException("Add user error:"+e.getMessage());
            }
        }else {
            throw new RuntimeException("User Name cannot be null!");
        }
    }

    @Transactional
    @Override
    public Boolean usrSignIn(Usr usr) {
        if (usr.getUsrName()!=null && !"".equals(usr.getUsrName())){
            try {
                Usr trustUsr=usrDao.queryUsrByName(usr.getUsrName());
                if (trustUsr==null)
                    throw new RuntimeException("No such user!");
                if (usr.getPasswd().equals(trustUsr.getPasswd()))
                    return true;
                else
                    throw new RuntimeException("Wrong password!");
            }catch (Exception e){
                throw new RuntimeException("Login error:"+e.getMessage());
            }
        }
        return  true;
    }
}
