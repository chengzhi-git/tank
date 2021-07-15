package com.chengzhi.tank;

import org.omg.CORBA.ARG_OUT;

import java.io.IOException;
import java.util.Properties;

/**
 * @Author:chengzhi
 * @Date:2021/7/15 11:59
 * @Description
 */
public class PropertyManager {
    static Properties props = new Properties();

    static {
        try {
            props.load(PropertyManager.class.getClassLoader().getResourceAsStream("config"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Object get(String key) {
        if(props == null)
            return null;
        System.out.println(props);
       return props.get(key);
    }

    public static void main(String[] args) {
        System.out.println(PropertyManager.get("initTankCount"));
    }
}
