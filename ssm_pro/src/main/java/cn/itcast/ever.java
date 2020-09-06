package cn.itcast;

import com.sun.xml.internal.messaging.saaj.util.FinalArrayList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author 李仔文
 * @version 1.0.0
 * @ClassName ever.java
 * @Description TODO
 * @createTime 2020年08月30日 10:36:00
 */
public class ever {
    public static void main(String[] args) {
        System.out.println(new ever().reverse(-321));

    }
    public int reverse(int x) {
        System.out.println("x:..........." + x);
        int result, val = 0;
        int flage = 0;
        String tmp="";
        List<Integer> list = new ArrayList<Integer>();
        if(x < 0){
            flage = 1;
        }
        do{
            val = x % 10;
            if(flage == 1){
                val = val * -1;
            }
            System.out.println("val:"+val);
            list.add(val);
            x = x / 10;
            System.out.println("x:"+x);
        }while(x != 0);
        Iterator iter = list.iterator();
        while(iter.hasNext()){
            tmp = tmp + iter.next().toString();
        }
        if(Double.parseDouble(tmp) < Math.pow(2,-31)){
            return 0;
        }else if(Double.parseDouble(tmp) > (Math.pow(2, 31) - 1)){
            return 0;
        }else{
            val = (int)Double.parseDouble(tmp);
            if(flage == 1){
                return result = val * -1;
            }else{
                return result = val;
            }

        }


    }

}


