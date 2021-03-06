package com.seu.lost_in_crowdsensing.dao;
import com.seu.lost_in_crowdsensing.entity.Device;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DeviceDaoTest {
    @Autowired
    private DeviceDao deviceDao;

    @Ignore
    @Test
    public void queryDevice() {
        List<Device> deviceList= deviceDao.queryDevice("zsy");
        Assert.assertEquals("132",deviceList.get(0).getBlueToothID());
    }
    @Ignore
    @Test
    public void queryDeviceByName() {
        Device device=deviceDao.queryDeviceByName("nokia");
        Assert.assertEquals(Integer.valueOf(1),device.getDeviceID());
    }
    @Ignore
    @Test
    public void queryDeviceByBlueToothID() {
        Device device=deviceDao.queryDeviceByBlueToothID("12");
        Assert.assertEquals("nokia",device.getDeviceName());
    }

    @Ignore
    @Test
    public void insertDevice() {
//        this.deviceName = deviceName;
//        this.blueToothID = blueToothID;
//        this.latitude = latitude;
//        this.longitude = longitude;
//        this.isLost = isLost;
//        this.usrName = usrName;
        Device device1=new Device("sansum","321",21.0,22.0,true,"zsy");
        int device=deviceDao.insertDevice(device1);
        Assert.assertEquals(1,device);
    }

    @Test
    public void updateDevice() {
        Device device=new Device();
        device.setDeviceName("Nokia");
        device.setBlueToothID("132");
        device.setIsLost(Boolean.FALSE);
        int ok=deviceDao.updateDevice(device);
        Assert.assertEquals(1,ok);
    }
    @Ignore
    @Test
    public void deleteDevice() {
        Device device=new Device();
        device.setDeviceName("pear");
        int ok=deviceDao.deleteDevice(device);
        Assert.assertEquals(1,ok);
    }
}