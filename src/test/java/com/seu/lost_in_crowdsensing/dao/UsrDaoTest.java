package com.seu.lost_in_crowdsensing.dao;
import com.seu.lost_in_crowdsensing.entity.Usr;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest

public class UsrDaoTest {
    @Autowired
    private UsrDao usrDao;
    @Test
    public void queryUsrByName() {
        try {
            Usr usr=usrDao.queryUsrByName("hahah");
        }catch (Exception e){
            System.out.print("hh");
        }
        Usr usr=usrDao.queryUsrByName("hahah");
        //Assert.assertEquals("1",usr.getPasswd());
    }

    @Ignore
    @Test
    public void insertUsr() {
        Usr usr=new Usr("Nearl","123");
        usrDao.insertUsr(usr);
    }

    @Ignore
    @Test
    public void updateUsr() {
        Usr usr=new Usr("Nearl","blacksheepwall");
        usrDao.updateUsr(usr);
    }

    @Ignore
    @Test
    public void deleteUsr() {
        //ok 不写了
    }
}