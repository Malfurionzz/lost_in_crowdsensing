package com.seu.lost_in_crowdsensing.service.implement;

import com.seu.lost_in_crowdsensing.entity.Device;
import com.seu.lost_in_crowdsensing.entity.Usr;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataServiceImpTest {
    @Autowired
    private DataServiceImp serviceImp;
//    @Test
//    void getDeviceList() {
//    }
//
//    @Test
//    void getDeviceByName() {
//    }
//
//    @Test
//    void getDeviceByToothID() {
//    }
//
//    @Test
//    void isLost() {
//    }

    @Ignore
    @Test
    public void addDevice() {
        Usr usr=new Usr("mtx","???");
        Assert.assertEquals(true, serviceImp.usrSignUp(usr));
    }

    @Test
    public void upDateDeviceInfo(){
        Device device=new Device();
        device.setDeviceName("nokia");
        device.setBlueToothID("132");
        device.setIsLost(Boolean.FALSE);
        Assert.assertEquals(Boolean.TRUE,serviceImp.upDateDeviceInfo(device));
    }
//    @Test
//    void upDateDevicePosition() {
//    }
}