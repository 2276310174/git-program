package com.itheima.gameFramer;

import com.itheima.set.Settings;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author 李仔文
 * @version 1.0.0
 * @ClassName SpecialEffects.java
 * @Description TODO
 * @createTime 2020年09月14日 10:03:00
 */
public class SpecialEffects implements Runnable{

    private BufferedImage specialImage;

    private int index_specialImage;

    private int init_X_special;

    private int init_Y_special;

    private TankPanel tankPanel;

    private boolean isLive;

    public SpecialEffects(int init_X_special, int init_Y_special,TankPanel tankPanel) {
        this.init_X_special = init_X_special;
        this.init_Y_special = init_Y_special;
        this.tankPanel = tankPanel;
        this.index_specialImage = 0;
        this.isLive = true;
        try {
            this.specialImage = ImageIO.read(new File("F:\\大四上实训\\MyTank\\image\\boom3.bmp"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void fireEffect(Graphics g){

        g.drawImage(specialImage,init_X_special * Settings.BOXSIZE,init_Y_special * Settings.BOXSIZE,
                (init_X_special + 1) * Settings.BOXSIZE,(init_Y_special + 1) * Settings.BOXSIZE,
                index_specialImage * Settings.BOXSIZE,0,(index_specialImage + 1) * Settings.BOXSIZE,
                1 * Settings.BOXSIZE,tankPanel);

    }

    @Override
    public void run() {

        while (isLive){
            if (index_specialImage == 8){
                isLive = false;
                TankPanel.specialCollection.remove(this);
            }else {
                index_specialImage++;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
