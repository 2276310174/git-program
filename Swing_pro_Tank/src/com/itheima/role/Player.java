package com.itheima.role;

import com.itheima.gameFramer.Bullte;
import com.itheima.gameFramer.SpecialEffects;
import com.itheima.gameFramer.TankPanel;
import com.itheima.set.Settings;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author 李仔文
 * @version 1.0.0
 * @ClassName Player.java
 * @Description TODO
 * @createTime 2020年09月11日 09:09:00
 */
public class Player implements Runnable {

    private BufferedImage palyerImage;

    private BufferedImage bullteImage;

    private TankPanel tankPanel;

    private Integer palyerLevel = 8;/*玩家的初始游戏等级*/

    private Integer bullteLevel = 0;/*子弹的初始游戏等级*/

    private boolean flage = true;/*判断玩家是否是复活时刻*/

    private int direct;

    private int initX;

    private int initY;

    public  int lifeNum;

    public void setLifeNum(int lifeNum) {
        this.lifeNum = lifeNum;
    }

    public int getLifeNum() {
        return lifeNum;
    }

    private Bullte bullte;


    public Player(TankPanel tankPanel) {
        this.tankPanel = tankPanel;
        lifeNum = 5;
    }

    public int getInitX() {
        return initX;
    }

    public int getInitY() {
        return initY;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    public int getDirect() {
        return direct;
    }

    @Override
    public void run() {
        while(lifeNum != 0){
            tankPanel.repaint();/*重复绘制*/
        }
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public  void drawPlayer(Graphics g, JPanel jPanel){

        try {
            palyerImage = ImageIO.read(new File("F:\\JAVA_Project\\Swing_pro_Tank\\image\\player1.bmp"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (flage){
            /*玩家初始的坐标位置*/
            initX = Settings.palyerInitX;
            initY = Settings.playerInitY;
            direct = 0;
            flage = false;
            g.drawImage(palyerImage,initX * Settings.BOXSIZE,initY * Settings.BOXSIZE,
                    (initX + 1) * Settings.BOXSIZE,(initY + 1) * Settings.BOXSIZE,
                    (palyerLevel - 1) * Settings.BOXSIZE,direct * Settings.BOXSIZE,palyerLevel * Settings.BOXSIZE,
                    (direct + 1) * Settings.BOXSIZE,jPanel);

        }else {
            g.drawImage(palyerImage,initX * Settings.BOXSIZE,initY * Settings.BOXSIZE,
                    (initX + 1) * Settings.BOXSIZE,(initY + 1) * Settings.BOXSIZE,
                    (palyerLevel - 1) * Settings.BOXSIZE,direct * Settings.BOXSIZE,palyerLevel * Settings.BOXSIZE,
                    (direct + 1) * Settings.BOXSIZE,jPanel);
        }


    }


    public void move(int direct){

       if (direct == Settings.UP){
           if (initY > 0 && canMove(initX,initY - 1)){
               initY--;
           }
       }else if (direct == Settings.DOWN){
           if (initY < Settings.array.length - 1 && canMove(initX,initY + 1)){
               initY++;
           }
       } else if (direct == Settings.LEFT){
           if (initX > 0 && canMove(initX - 1,initY)){
               initX--;
           }
       } else if (direct == Settings.RIGHT){
           if (initX < Settings.array[0].length - 1 && canMove(initX + 1,initY)){
               initX++;
           }
       }
    }

    public boolean canMove(int X,int Y){
        boolean reValue = true;
        if (Settings.array[Y][X] != Settings.LAND && Settings.array[Y][X] != Settings.GRASS){
                reValue = false;
        }else{
            for (int i = 0; i < TankPanel.bots.size(); i++) {
                if (direct == Settings.UP){
                    if (TankPanel.bots.get(i).aim_X == initX && TankPanel.bots.get(i).aim_Y == (initY - 1)){
                        reValue = false;
                    }
                }else if (direct == Settings.DOWN){
                    if (TankPanel.bots.get(i).aim_X == initX && TankPanel.bots.get(i).aim_Y == (initY + 1)){
                        reValue = false;
                    }
                }else if (direct == Settings.LEFT){
                    if (TankPanel.bots.get(i).aim_X == (initX - 1) && TankPanel.bots.get(i).aim_Y == initY){
                        reValue = false;
                    }
                }else if (direct == Settings.RIGHT){
                    if (TankPanel.bots.get(i).aim_X == (initX + 1) && TankPanel.bots.get(i).aim_Y == initY){
                        reValue = false;
                    }
                }
                }
        }

        return reValue;
    }



}
