package com.chengzhi.tank;

import java.awt.*;

/**
 * @Author:chengzhi
 * @Date:2021/7/11 16:45
 * @Description
 */
public class Explode {
    private int x, y;
    static int WIDTH = ResourceMgr.explodes[0].getWidth(), HEIGHT = ResourceMgr.explodes[0].getHeight();
    private boolean living = true;
    TankFrame tf = null;

    private int step = 0;
    public Explode(int x, int y, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;
    }

    public void paint(Graphics g) {
        g.drawImage(ResourceMgr.explodes[step++], x, y, null);
        if(step >= ResourceMgr.explodes.length) step = 0;
    }
}
