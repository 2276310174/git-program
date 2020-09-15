package com.itheima.gameFramer;

import com.itheima.set.Settings;

import javax.swing.*;
import java.awt.*;

/**
 * @author 李仔文
 * @version 1.0.0
 * @ClassName TankFramer.java
 * @Description 坦克大战界面容器
 * @createTime 2020年09月10日 10:24:00
 */
public class TankFramer extends JFrame {

    /**
     *
     */
    public TankFramer(){
//        设置窗体大小
        setSize(Settings.FRAMERWIDTH,Settings.FRAMERHEIGHT);
//        设置默认关闭退出程序
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        设置可见
        setVisible(true);
//        设置窗体出现的坐标位置
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();/*获取屏幕大小*/
        int width = (int) screenSize.getWidth();/*获取屏幕的宽度*/
        int height = (int) screenSize.getHeight();/*获取屏幕的高度*/
        int Horizontally = (width - Settings.FRAMERWIDTH)/2;/*水平居中值*/
        int Vertical_Center = (height - Settings.FRAMERHEIGHT) / 2;/*垂直居中*/
        setLocation(Horizontally,Vertical_Center);

        setTitle("坦克大战");

        setContentPane(new TankPanel());
    }

}
