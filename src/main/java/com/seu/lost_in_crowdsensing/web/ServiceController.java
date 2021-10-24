package com.seu.lost_in_crowdsensing.web;

import com.seu.lost_in_crowdsensing.entity.Device;
import com.seu.lost_in_crowdsensing.entity.Usr;
import com.seu.lost_in_crowdsensing.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/superadmin")
public class ServiceController {
    @Autowired
    private DataService dataService;

    @RequestMapping(value = "/listdevice", method = RequestMethod.GET)
    private Map<String,Object> listDevice(String usrName){
        Map<String,Object> modelMap = new HashMap<String,Object>();
        List<Device> list = dataService.getDeviceList(usrName);
        modelMap.put("deviceList",list);
        return modelMap;
    }

    @RequestMapping(value = "/devicebyname", method = RequestMethod.POST)
    private Map<String, Object> deviceByName(@RequestBody Usr usr, String deviceName){
        Map<String,Object> modelMap = new HashMap<String,Object>();
        Device device= dataService.getDeviceByName(usr,deviceName);
        modelMap.put("device",device);
        return modelMap;
    }

    @RequestMapping(value = "/devicebybtid", method = RequestMethod.GET)
    private Map<String, Object> deviceByBTID(String blueToothID){
        Map<String,Object> modelMap = new HashMap<String,Object>();
        Device device = dataService.getDeviceByToothID(blueToothID);
        modelMap.put("device",device);
        return modelMap;
    }

    @RequestMapping(value = "/islost", method = RequestMethod.GET)
    private Map<String, Object> deviceIsLost(String blueToothID){
        Map<String,Object> modelMap = new HashMap<String,Object>();
        modelMap.put("isLost",dataService.isLost(blueToothID));
        return modelMap;
    }

    @RequestMapping(value = "/adddevice", method = RequestMethod.POST)
    private Map<String, Object> addDevice(@RequestBody Device device){
        Map<String,Object> modelMap = new HashMap<String,Object>();
        modelMap.put("success",dataService.addDevice(device));
        return modelMap;
    }

    @RequestMapping(value = "/updatedeviceposition", method = RequestMethod.POST)
    private Map<String, Object> upDateDevicePosition(@RequestBody Device device){
        Map<String,Object> modelMap = new HashMap<String,Object>();
        modelMap.put("success",dataService.upDateDevicePosition(device));
        return modelMap;
    }

    @RequestMapping(value = "/updatedevicestate", method = RequestMethod.POST)
    private Map<String, Object> upDateDeviceState(@RequestBody Device device){
        Map<String,Object> modelMap = new HashMap<String,Object>();
        modelMap.put("success",dataService.upDateDeviceState(device));
        return modelMap;
    }

    @RequestMapping(value = "/updatedeviceinfo", method = RequestMethod.POST)
    private Map<String, Object> upDateDeviceInfo(@RequestBody Device device){
        Map<String,Object> modelMap = new HashMap<String,Object>();
        modelMap.put("success",dataService.upDateDeviceInfo(device));
        return modelMap;
    }
    @RequestMapping(value = "/usrsignup", method = RequestMethod.POST)
    private Map<String, Object> usrSignUp(@RequestBody Usr usr){
        Map<String,Object> modelMap = new HashMap<String,Object>();
        modelMap.put("success",dataService.usrSignUp(usr));
        return modelMap;
    }

    @RequestMapping(value = "/usrsignin", method = RequestMethod.POST)
    private Map<String, Object> usrSignIn(@RequestBody Usr usr) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", dataService.usrSignIn(usr));
        return modelMap;
    }
}

