package com.chengzhi.tank.开火策略;

import com.chengzhi.tank.Bullet;
import com.chengzhi.tank.Tank;
import com.chengzhi.tank.开火策略.FireStrategy;

/**
 * @Author:chengzhi
 * @Date:2021/8/1 21:23
 * @Description
 */
public class DefaultFireStrategy implements FireStrategy {
    @Override
    public void fire(Tank t) {
        int bulletX = t.x + (Tank.WIDTH - Bullet.WIDTH) / 2;
        int bulletY = t.y + (Tank.HEIGHT - Bullet.HEIGHT) / 2;
        new Bullet(bulletX, bulletY, t.dir, t.group, t.tf);
    }
}
