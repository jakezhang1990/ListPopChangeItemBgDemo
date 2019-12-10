package com.freedev.listpopchangeitembgdemo;

/**
 * @Author:jakezhang Company:DHC
 * Description: 内容描述
 * Date: 2019/11/27 15:56
 **/
public class ServerPopBean {

    private String server_name;


    public String getServer_name() {
        return server_name;
    }

    public void setServer_name(String server_name) {
        this.server_name = server_name;
    }

    @Override
    public String toString() {
        return "ServerPopBean{" +
                "server_name='" + server_name + '\'' +
                '}';
    }
}
