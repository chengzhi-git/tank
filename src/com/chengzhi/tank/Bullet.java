package com.chengzhi.tank;

import java.awt.*;

/**
 * @Author:chengzhi
 * @Date:2021/7/11 16:45
 * @Description
 */
public class Bullet {
    private static final int SPEED = Integer.parseInt(PropertyManager.get("bulletSpeed").toString());
    private int x, y;
    private Dir dir;
    static int WIDTH = ResourceMgr.bulletD.getWidth(), HEIGHT = ResourceMgr.bulletD.getHeight();
    private boolean living = true;
    private TankFrame tf = null;
    private Group group = Group.BAD;
    Rectangle rectangle = new Rectangle();

    public Bullet(int x, int y, Dir dir, Group group, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tf = tf;
        rectangle.x = this.x;
        rectangle.y = this.y;
        rectangle.width = WIDTH;
        rectangle.height = HEIGHT;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void paint(Graphics g) {
        if (!living) {
            tf.bullets.remove(this);
        }
        switch (dir) {
            case LEFT:
                g.drawImage(ResourceMgr.bulletL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.bulletR, x, y, null);
                break;
            case UP:
                g.drawImage(ResourceMgr.bulletU, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.bulletD, x, y, null);
                break;
        }
        move();
    }

    private void move() {
        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            default:
                break;
        }
        rectangle.x = this.x;
        rectangle.y = this.y;

        if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) living = false;

    }

    public void collideWith(Tank tank) {
        if (this.group == tank.getGroup()) return;
        if (rectangle.intersects(tank.rectangle)) {
            tank.die();
            this.die();

            int explodeX = tank.getX() + (Tank.WIDTH - Explode.WIDTH) / 2;
            int explodeY = tank.getY() + (Tank.HEIGHT - Explode.HEIGHT) / 2;
            tf.explodes.add(new Explode(explodeX, explodeY, tf));
        }
    }

    private void die() {
        this.living = false;
    }
}
