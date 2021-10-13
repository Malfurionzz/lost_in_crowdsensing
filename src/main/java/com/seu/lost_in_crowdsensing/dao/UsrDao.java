package com.seu.lost_in_crowdsensing.dao;

import com.seu.lost_in_crowdsensing.entity.Usr;

import java.util.List;

public interface UsrDao {
    Usr usrSignIn (Usr usr);
    Usr usrSignUp (Usr usr);
    int updateDevice(Usr usr);
    int deleteDevice(Usr usr);
}
