package com.seu.lost_in_crowdsensing.entity;

public class Usr {
    private Integer usrID;
    private String usrName;
    private String passwd;

    public Usr() {}

    public Usr(String usrName, String passwd) {
        this.usrName = usrName;
        this.passwd = passwd;
    }


    public String getUsrName() {
        return usrName;
    }

    public void setUsrName(String usrName) {
        this.usrName = usrName;
    }
    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public Integer getUsrID() {
        return usrID;
    }

    public void setUsrID(Integer usrID) {
        this.usrID = usrID;
    }
}