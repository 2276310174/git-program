package com.itheima.set;

import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * @author 李仔文
 * @version 1.0.0
 * @ClassName Settings.java
 * @Description TODO
 * @createTime 2020年09月10日 10:30:00
 */
public class Settings {
    public static final int FRAMERWIDTH = 1200;

    public static final int FRAMERHEIGHT = 910;

//    public static final int TANKPANELWIDTH = 1200;
//
//    public static final int TANKPANELHEIGHT = 870;

    public static final int palyerInitX = 13;

    public static final int playerInitY = 26;

    //路
    public   static final int LAND = 0;

    //墙
    public static final int BRICK = 1;

    //草
    public  static final int GRASS = 2;

    //钢砖
    public static final int STEEl = 3;

    //河流
    public  static final int RIVER = 4;

    //老王
    public static final int BOSS = 5;

    public static final int DEATHBOSS = 6;

    //设置盒子的大小
    public static final int BOXSIZE = 32;

    public static final int UP = 0;

    public static final int DOWN = 2;

    public static final int LEFT = 3;

    public static final int RIGHT = 1;

    public static int[][] array = {{LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND},
            {LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND},
            {LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND},
            {LAND,LAND,LAND,LAND,BRICK,BRICK,BRICK,BRICK,BRICK,BRICK,BRICK,LAND,LAND,LAND,LAND,BRICK,BRICK,BRICK,BRICK,BRICK,BRICK,LAND,LAND,LAND,LAND,LAND,BRICK,BRICK,BRICK,BRICK,BRICK,BRICK,BRICK,LAND,LAND,LAND,LAND},
            {LAND,LAND,LAND,LAND,BRICK,BRICK,BRICK,BRICK,BRICK,BRICK,BRICK,LAND,LAND,LAND,LAND,BRICK,BRICK,BRICK,BRICK,BRICK,BRICK,LAND,LAND,LAND,LAND,LAND,BRICK,BRICK,BRICK,BRICK,BRICK,BRICK,BRICK,LAND,LAND,LAND,LAND},
            {LAND,LAND,LAND,LAND,BRICK,BRICK,GRASS,GRASS,GRASS,GRASS,GRASS,STEEl,BRICK,BRICK,STEEl,GRASS,GRASS,GRASS,GRASS,BRICK,BRICK,STEEl,GRASS,BRICK,GRASS,STEEl,BRICK,BRICK,RIVER,RIVER,RIVER,BRICK,BRICK,LAND,LAND,LAND,LAND},
            {LAND,LAND,LAND,LAND,BRICK,BRICK,GRASS,GRASS,GRASS,GRASS,GRASS,STEEl,BRICK,BRICK,STEEl,GRASS,GRASS,GRASS,GRASS,BRICK,BRICK,STEEl,GRASS,BRICK,GRASS,STEEl,BRICK,BRICK,RIVER,RIVER,RIVER,BRICK,BRICK,GRASS,LAND,LAND,LAND},
            {LAND,LAND,RIVER,RIVER,BRICK,BRICK,GRASS,GRASS,GRASS,GRASS,GRASS,STEEl,BRICK,BRICK,STEEl,GRASS,GRASS,GRASS,GRASS,BRICK,BRICK,STEEl,GRASS,BRICK,GRASS,STEEl,BRICK,BRICK,RIVER,RIVER,RIVER,BRICK,BRICK,GRASS,RIVER,BRICK,BRICK},
            {LAND,LAND,RIVER,RIVER,BRICK,BRICK,GRASS,GRASS,GRASS,GRASS,GRASS,STEEl,BRICK,BRICK,STEEl,GRASS,GRASS,GRASS,GRASS,BRICK,BRICK,STEEl,GRASS,BRICK,GRASS,STEEl,BRICK,BRICK,RIVER,RIVER,RIVER,BRICK,BRICK,GRASS,RIVER,BRICK,BRICK},
            {BRICK,BRICK,RIVER,RIVER,BRICK,BRICK,BRICK,BRICK,BRICK,BRICK,BRICK,LAND,LAND,LAND,LAND,BRICK,BRICK,BRICK,BRICK,BRICK,BRICK,LAND,LAND,LAND,LAND,LAND,BRICK,BRICK,RIVER,RIVER,RIVER,BRICK,BRICK,GRASS,RIVER,BRICK,BRICK},
            {BRICK,BRICK,RIVER,RIVER,BRICK,BRICK,BRICK,BRICK,BRICK,BRICK,BRICK,LAND,LAND,LAND,LAND,BRICK,BRICK,BRICK,BRICK,BRICK,BRICK,LAND,LAND,LAND,LAND,LAND,BRICK,BRICK,RIVER,RIVER,RIVER,BRICK,BRICK,GRASS,RIVER,BRICK,BRICK},
            {BRICK,BRICK,RIVER,RIVER,RIVER,RIVER,RIVER,RIVER,RIVER,BRICK,BRICK,LAND,LAND,LAND,LAND,BRICK,BRICK,STEEl,STEEl,STEEl,STEEl,LAND,LAND,LAND,LAND,LAND,BRICK,BRICK,RIVER,RIVER,RIVER,BRICK,BRICK,GRASS,RIVER,BRICK,BRICK},
            {BRICK,BRICK,RIVER,RIVER,RIVER,RIVER,RIVER,RIVER,RIVER,BRICK,BRICK,LAND,LAND,LAND,LAND,BRICK,BRICK,STEEl,STEEl,STEEl,STEEl,LAND,LAND,LAND,LAND,LAND,BRICK,BRICK,RIVER,RIVER,RIVER,BRICK,BRICK,GRASS,RIVER,BRICK,BRICK},
            {BRICK,BRICK,RIVER,RIVER,RIVER,RIVER,RIVER,RIVER,RIVER,BRICK,BRICK,LAND,LAND,LAND,LAND,BRICK,BRICK,STEEl,STEEl,STEEl,STEEl,LAND,LAND,LAND,LAND,LAND,BRICK,BRICK,RIVER,RIVER,RIVER,BRICK,BRICK,LAND,LAND,LAND,LAND},
            {LAND,LAND,LAND,LAND,BRICK,BRICK,BRICK,BRICK,BRICK,BRICK,BRICK,LAND,LAND,LAND,LAND,BRICK,BRICK,BRICK,BRICK,BRICK,BRICK,LAND,LAND,LAND,LAND,LAND,BRICK,BRICK,BRICK,BRICK,BRICK,BRICK,BRICK,LAND,LAND,LAND,LAND},
            {LAND,LAND,LAND,LAND,BRICK,BRICK,BRICK,BRICK,BRICK,BRICK,BRICK,LAND,LAND,LAND,LAND,BRICK,BRICK,BRICK,BRICK,BRICK,BRICK,LAND,LAND,LAND,LAND,LAND,BRICK,BRICK,BRICK,BRICK,BRICK,BRICK,BRICK,LAND,LAND,LAND,LAND},
            {LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND},
            {GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS,GRASS},
            {BRICK,BRICK,BRICK,BRICK,BRICK,BRICK,BRICK,BRICK,BRICK,BRICK,BRICK,BRICK,BRICK,BRICK,BRICK,BRICK,BRICK,BRICK,BRICK,BRICK,BRICK,BRICK,BRICK,BRICK,BRICK,BRICK,BRICK,BRICK,BRICK,BRICK,BRICK,BRICK,BRICK,BRICK,BRICK,BRICK,BRICK},
            {LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND},
            {LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND},
            {LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND},
            {LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND},
            {LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND},
            {LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,BRICK,BRICK,BRICK,BRICK,BRICK,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND},
            {LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,BRICK,BRICK,BRICK,BRICK,BRICK,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND},
            {LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,BRICK,BRICK,BOSS,BRICK,BRICK,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND,LAND}};

}
