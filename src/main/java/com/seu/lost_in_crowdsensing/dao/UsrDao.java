package com.seu.lost_in_crowdsensing.dao;

import com.seu.lost_in_crowdsensing.entity.Usr;

import java.util.List;

public interface UsrDao {
    Usr queryUsrByName(String usrName);
    int insertUsr(Usr usr);
    int updateUsr(Usr usr);
    int deleteUsr(Usr usr);
}
