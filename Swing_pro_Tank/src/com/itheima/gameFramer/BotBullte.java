package com.itheima.gameFramer;

import com.itheima.role.Player;
import com.itheima.set.Settings;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author 李仔文
 * @version 1.0.0
 * @ClassName BotBullte.java
 * @Description TODO
 * @createTime 2020年09月14日 19:01:00
 */
public class BotBullte implements Runnable{

    private int bullteX;/*子弹的横坐标*/

    private int bullteY;/*子弹的纵坐标*/

    private int bullteLevel;/*子弹的等级*/

    private BufferedImage bullteImg;

    private TankPanel tankPanel;

    private int direct;

    private Player player;

    private int sourceImgY = 0;

    private boolean diplay = true;

    private Graphics g;

    public void setG(Graphics g) {
        this.g = g;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    public BotBullte(int bullteX, int bullteY, TankPanel tankPanel, int direct,Player player) {
        this.bullteX = bullteX;
        this.bullteY = bullteY;
        this.tankPanel = tankPanel;
        this.player = player;
        this.bullteLevel = 0;
        this.direct = direct;
        try {
            this.bullteImg = ImageIO.read(new File("F:\\JAVA_Project\\Swing_pro_Tank\\image\\xinxin.bmp"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public boolean drawBullte(Graphics g){
        g.drawImage(bullteImg,bullteX * Settings.BOXSIZE,bullteY * Settings.BOXSIZE,
                (bullteX + 1) * Settings.BOXSIZE,(bullteY + 1) * Settings.BOXSIZE,
                bullteLevel * Settings.BOXSIZE,sourceImgY * Settings.BOXSIZE,
                (bullteLevel + 1) * Settings.BOXSIZE,(sourceImgY + 1) * Settings.BOXSIZE,tankPanel);
        if (diplay == false){
            return false;
        }else return true;
    }

    @Override
    public void run() {
        while (diplay){
            if (bullteLevel == 4){
                bullteLevel = 0;
            }else {
                bullteLevel++;
            }
            bullteMove();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void bullteMove(){

        if (direct == Settings.UP && canMove(bullteX,bullteY)){
            bullteY--;
        }else if (direct == Settings.DOWN && canMove(bullteX,bullteY)){
            bullteY++;
        }else if (direct == Settings.LEFT && canMove(bullteX,bullteY)){
            bullteX--;
        }else if (direct == Settings.RIGHT && canMove(bullteX,bullteY)){
            bullteX++;
        }

    }

    public boolean canMove(int x,int y){

        if (x < 0 || x > Settings.array[0].length -1 || y < 0 || y > Settings.array.length - 1){
            diplay = false;
            TankPanel.bot_Bulltes.remove(this);
            SpecialEffects specialEffects = new SpecialEffects(x,y,tankPanel);
            TankPanel.specialCollection.add(specialEffects);
            Thread thread_special = new Thread(specialEffects);
            thread_special.start();
        }else if (Settings.array[y][x] == Settings.BRICK){
            diplay = false;
            Settings.array[y][x] = Settings.LAND;
            TankPanel.bot_Bulltes.remove(this);
            SpecialEffects specialEffects = new SpecialEffects(x,y,tankPanel);
            TankPanel.specialCollection.add(specialEffects);
            Thread thread_special = new Thread(specialEffects);
            thread_special.start();
        }else if (Settings.array[y][x] == Settings.STEEl){
            diplay = false;
            TankPanel.bot_Bulltes.remove(this);
            SpecialEffects specialEffects = new SpecialEffects(x,y,tankPanel);
            TankPanel.specialCollection.add(specialEffects);
            Thread thread_special = new Thread(specialEffects);
            thread_special.start();
        }else if (Settings.array[y][x] == Settings.BOSS){
            diplay = false;
            Settings.array[y][x] = Settings.DEATHBOSS;
            TankPanel.bot_Bulltes.remove(this);
            SpecialEffects specialEffects = new SpecialEffects(x,y,tankPanel);
            TankPanel.specialCollection.add(specialEffects);
            Thread thread_special = new Thread(specialEffects);
            thread_special.start();
            tankPanel.repaint();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            player.setLifeNum(0);
        } else {
            if (player.getInitX() == x && player.getInitY() == y){
                diplay = false;
                SpecialEffects specialEffects = new SpecialEffects(x, y, tankPanel);
                TankPanel.specialCollection.add(specialEffects);
                Thread thread_special = new Thread(specialEffects);
                thread_special.start();
                TankPanel.bot_Bulltes.remove(this);
                player.setLifeNum(0);
                tankPanel.repaint();
            }
        }
        return diplay;
    }
}
