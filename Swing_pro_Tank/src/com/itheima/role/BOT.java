package com.itheima.role;

import com.itheima.gameFramer.BotBullte;
import com.itheima.gameFramer.Bullte;
import com.itheima.gameFramer.TankPanel;
import com.itheima.set.Settings;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author 李仔文
 * @version 1.0.0
 * @ClassName BOT.java
 * @Description TODO
 * @createTime 2020年09月14日 14:48:00
 */
public class BOT implements Runnable {

    private BufferedImage botImage;

    private BufferedImage bullteImage;

    private TankPanel tankPanel;

    private Integer botSource_X = 0;/*电脑的原图片横坐标*/

    private Integer botSource_Y = 0;/*电脑的原图片纵坐标*/

    public Integer aim_X;/*电脑的坐标*/

    public Integer aim_Y;/*电脑的坐标*/

    public  boolean flage = true;

    private Bullte bullte;

    private boolean xiso_flag = true;


    //移动的步数
    private  int step = 5;

    private boolean init_flage = true;

    private Player player;

    private Graphics g;

    public Integer getBotSource_Y() {
        return botSource_Y;
    }

    public boolean isFlage() {
        return flage;
    }

    public BOT(TankPanel tankPanel, Player player) {
        this.tankPanel = tankPanel;
        this.player = player;
        do {
            this.aim_X = (int)(Math.random() * 37);
            this.aim_Y = (int)(Math.random() * 10);
            if (Settings.array[aim_Y][aim_X] == Settings.LAND){
                xiso_flag = false;
            }
        }while (xiso_flag);

        this.botSource_X = (int) (Math.random() * 16);
        this.botSource_Y = (int)(Math.random()*4);
//        this.direct = (int)(Math.random()*4);
        try {
            this.botImage = ImageIO.read(new File("F:\\JAVA_Project\\Swing_pro_Tank\\image\\enemy.bmp"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (flage){
                fireBotBullte();
                move(this.botSource_Y);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
    }

    public void drawBotImage(Graphics g){

        if (init_flage){
            init_flage = false;
            g.drawImage(botImage,aim_X * Settings.BOXSIZE,aim_Y * Settings.BOXSIZE,
                    (aim_X + 1) * Settings.BOXSIZE,(aim_Y + 1) * Settings.BOXSIZE,
                    botSource_X * Settings.BOXSIZE,botSource_Y * Settings.BOXSIZE,
                    (botSource_X + 1) * Settings.BOXSIZE,(botSource_Y + 1) * Settings.BOXSIZE,
                    tankPanel);
        }else {
            g.drawImage(botImage,aim_X * Settings.BOXSIZE,aim_Y * Settings.BOXSIZE,
                    (aim_X + 1) * Settings.BOXSIZE,(aim_Y + 1) * Settings.BOXSIZE,
                    botSource_X * Settings.BOXSIZE,botSource_Y * Settings.BOXSIZE,
                    (botSource_X + 1) * Settings.BOXSIZE,(botSource_Y + 1) * Settings.BOXSIZE,
                    tankPanel);
        }
    }

    public void move(int direct){
        step--;
        if(step < 1){
            this.botSource_Y = (int)(Math.random()*4);
            step = 5;
        }
        if(direct == Settings.UP  && canMove(aim_X,aim_Y - 1)){
            aim_Y--;
        }else if(direct == Settings.DOWN  && canMove(aim_X,aim_Y + 1)){
            aim_Y++;
        }else if(direct == Settings.LEFT  && canMove(aim_X - 1,aim_Y)){
            aim_X--;
        }else if(direct == Settings.RIGHT && canMove(aim_X + 1,aim_Y - 1)){
            aim_X++;
        }
    }

    public boolean canMove(int X,int Y){
        boolean reValue = true;
        if (X < 0 || X > Settings.array[0].length -1 || Y < 0 || Y > Settings.array.length - 1){
            step = 1;
            reValue = false;
        }else if (Settings.array[Y][X] != Settings.LAND && Settings.array[Y][X] != Settings.GRASS){
            step = 1;
            reValue = false;
        }else {
            if (botSource_Y == Settings.UP){
                if (aim_X == player.getInitX() && player.getInitY() == (aim_Y - 1)){
                    reValue = false;
                }
            }else if (botSource_Y == Settings.DOWN){
                if (aim_X == player.getInitX() && player.getInitY() == (aim_Y + 1)){
                    reValue = false;
                }
            }else if (botSource_Y == Settings.LEFT){
                if ((aim_X - 1) == player.getInitX() && player.getInitY() == aim_Y){
                    reValue = false;
                }
            }else if (botSource_Y == Settings.RIGHT){
                if ((aim_X + 1) == player.getInitX() && player.getInitY() == aim_Y){
                    reValue = false;
                }
            }
        }
        return reValue;
    }

    public void fireBotBullte(){

        BotBullte bullte = new BotBullte(aim_X,aim_Y,tankPanel,botSource_Y,player);
        TankPanel.bot_Bulltes.add(bullte);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread bot_thread_bullte = new Thread(bullte);
         bot_thread_bullte.start();
        try {
            Thread.sleep(1200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
