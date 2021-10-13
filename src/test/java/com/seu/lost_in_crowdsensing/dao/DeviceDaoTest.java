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
    @Test
    @Ignore
    public void queryDevice() {
        List<Device> deviceList= deviceDao.queryDevice("zsy");
        Assert.assertEquals(2,deviceList.size());
    }

    @Test
    public void queryDeviceByName() {
        Device device=deviceDao.queryDeviceByName("nokia");
        Assert.assertEquals("nokia",device.getDeviceName());
    }

    @Test
    public void queryDeviceByBlueToothID() {
        Device device=deviceDao.queryDeviceByBlueToothID("12");
        Assert.assertEquals("nokia",device.getDeviceName());
    }

    @Test
    @Ignore
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
        device.setDeviceName("pear");
        device.setBlueToothID("12");
        int ok=deviceDao.updateDevice(device);
        Assert.assertEquals(1,ok);
    }

    @Test
    public void deleteDevice() {
        Device device=new Device();
        device.setDeviceName("pear");
        int ok=deviceDao.deleteDevice(device);
        Assert.assertEquals(1,ok);
    }
}