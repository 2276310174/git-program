package com.itheima.gameFramer;

import com.itheima.role.BOT;
import com.itheima.role.Player;
import com.itheima.set.Settings;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 李仔文
 * @version 1.0.0
 * @ClassName TankPanel.java
 * @Description TODO
 * @createTime 2020年09月10日 10:46:00
 */
public class TankPanel extends JPanel {

    private BufferedImage iconImage;


    private int imageIndex;

    private Player player;

    private Bullte bullte;

    public static Graphics g;

    public static List<Bullte> bulltes;

    private boolean condition = false;

    public    static List<BOT> bots;

    public static List<SpecialEffects> specialCollection;

    public static List<BotBullte> bot_Bulltes;

    public static boolean marke_bit;/*坦克标志位*/

    private static BufferedImage GameOverImg;


    public TankPanel(){
//设置内容区域背景颜色
        setBackground(Color.BLACK);
//       setSize(Settings.TANKPANELWIDTH,Settings.TANKPANELHEIGHT);
////设置Panel区域可见
//        setVisible(true);

        bulltes = new ArrayList<Bullte>();
        bots = new ArrayList<BOT>();
        bot_Bulltes = new ArrayList<BotBullte>();
        specialCollection = new ArrayList<SpecialEffects>();

        try {
            iconImage = ImageIO.read(new File("F:\\JAVA_Project\\Swing_pro_Tank\\image\\icon.bmp"));

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            GameOverImg = ImageIO.read(new File("F:\\JAVA_Project\\Swing_pro_Tank\\image\\gameover.bmp"));
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        player = new Player(this);
        Thread thread = new Thread(player);
        thread.start();

        /*生成5个电脑*/
        for (int i = 0;i < 5;i++){
            BOT bot = new BOT(this,player);
            TankPanel.bots.add(bot);
            Thread bot_thread = new Thread(bot);
            bot_thread.start();
        }

        //聚焦
//        setFocusable(true);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                requestFocus();
            }
        });

        //给窗体添加键盘事件监听
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                //键盘按下的方法

                if(e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W){
                    player.setDirect(Settings.UP);
                    player.move(Settings.UP);
                }else if(e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S){
                    player.setDirect(Settings.DOWN);
                    player.move(Settings.DOWN);
                }else if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A){
                    player.setDirect(Settings.LEFT);
                    player.move(Settings.LEFT);
                }else if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D){
                    player.setDirect(Settings.RIGHT);
                    player.move(Settings.RIGHT);
                }else if (e.getKeyCode() == KeyEvent.VK_SPACE){
                    bullte = judgeBullte();
                    Thread thread1 = new Thread(bullte);
                    thread1.start();
                    bulltes.add(bullte);
                }


            }
        });

    }

//    @Override
    protected void paintComponent(Graphics g) {
        this.g = g;
        super.paintComponent(g);
//
        drawImageMap(g);
        player.drawPlayer(g,this);

        for (Bullte bullte1 : bulltes) {
            bullte1.drawBullte(g);
        }

        for (BotBullte bot_bullte : bot_Bulltes) {
            bot_bullte.drawBullte(g);
        }
//
        for (SpecialEffects specialEffects : specialCollection) {
            specialEffects.fireEffect(g);
        }

        for (BOT bot : bots) {
            bot.drawBotImage(g);
        }

        if (player.getLifeNum() == 0){
            drawGameEnd(g);
        }
    }

    /**
     *
     * 1:图片资源
     * 2-5:图片绘制的坐标位置
     *6-9:图片上选取的位置
     * 10：绘制的目标位置
     *
     * @param g
     */
    public void drawImageMap(Graphics g){

        for (int row = 0; row < Settings.array.length; row++) {
            for (int col = 0;col < Settings.array[row].length;col++){
                switch (Settings.array[row][col]){

                    case Settings.BRICK :
                        imageIndex = 0;
                        g.drawImage(iconImage,col*Settings.BOXSIZE,row*Settings.BOXSIZE,
                                (col+1)*Settings.BOXSIZE,(row+1)*Settings.BOXSIZE,
                                imageIndex*Settings.BOXSIZE,0,(imageIndex+1)*Settings.BOXSIZE,
                                32,this);
                        break;
                    case Settings.GRASS :
                        imageIndex = 2;
                        g.drawImage(iconImage,col*Settings.BOXSIZE,row*Settings.BOXSIZE,
                                (col+1)*Settings.BOXSIZE,(row+1)*Settings.BOXSIZE,
                                imageIndex*Settings.BOXSIZE,0,(imageIndex+1)*Settings.BOXSIZE,
                                32,this);
                        break;
                    case Settings.RIVER :
                        imageIndex = 4;
                        g.drawImage(iconImage,col*Settings.BOXSIZE,row*Settings.BOXSIZE,
                                (col+1)*Settings.BOXSIZE,(row+1)*Settings.BOXSIZE,
                                imageIndex*Settings.BOXSIZE,0,(imageIndex+1)*Settings.BOXSIZE,
                                32,this);
                        break;
                    case  Settings.STEEl :
                        imageIndex = 1;
                        g.drawImage(iconImage,col*Settings.BOXSIZE,row*Settings.BOXSIZE,
                                (col+1)*Settings.BOXSIZE,(row+1)*Settings.BOXSIZE,
                                imageIndex*Settings.BOXSIZE,0,(imageIndex+1)*Settings.BOXSIZE,
                                32,this);
                        break;
                    case Settings.BOSS :
                        imageIndex = 5;
                        g.drawImage(iconImage,col*Settings.BOXSIZE,row*Settings.BOXSIZE,
                                (col+1)*Settings.BOXSIZE,(row+1)*Settings.BOXSIZE,
                                imageIndex*Settings.BOXSIZE,0,(imageIndex+1)*Settings.BOXSIZE,
                                32,this);
                        break;
                    case Settings.DEATHBOSS :
                        imageIndex = 6;
                        g.drawImage(iconImage,col*Settings.BOXSIZE,row*Settings.BOXSIZE,
                                (col+1)*Settings.BOXSIZE,(row+1)*Settings.BOXSIZE,
                                imageIndex*Settings.BOXSIZE,0,(imageIndex+1)*Settings.BOXSIZE,
                                32,this);
                        break;

                }
            }
        }

    }

        public Bullte judgeBullte(){
            if (player.getDirect() == Settings.UP) {
                return new Bullte(player.getInitX(), (player.getInitY() - 1), this,Settings.UP,player);
            }else if (player.getDirect() == Settings.DOWN){
                return new Bullte(player.getInitX(),(player.getInitY() + 1),this,Settings.DOWN,player);
            }else if (player.getDirect() == Settings.LEFT){
                return new Bullte((player.getInitX() - 1),player.getInitY(),this,Settings.LEFT,player);
            }else{
                return new Bullte((player.getInitX() + 1),player.getInitY(),this,Settings.RIGHT,player);
            }

        }

        public void drawGameEnd(Graphics g){
            g.drawImage(GameOverImg,15*Settings.BOXSIZE,12 * Settings.BOXSIZE,
                    22 * Settings.BOXSIZE,16 * Settings.BOXSIZE,0,
                    0,8 * Settings.BOXSIZE,5 * Settings.BOXSIZE,this);
        }
    }



