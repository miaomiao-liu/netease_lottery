package cn.edu.swpu.cins.netease_lottery.util;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by miaomiao on 17-7-28.
 */
@Component
public class GenerateWinNumber {

    //生成中奖号码数组  五个不重复的数
    public static List<Integer> generateNumber(){
        Random random = new Random();
        List<Integer> numbers = new ArrayList<>();
        int num;
        for(int i = 0; i<5; i++){
            do {
                num = random.nextInt(11) + 1;   //产生1～11的随机数
            }while(numbers.contains(num));
            numbers.add(num);
        }
        return numbers;
    }

    //判断大小比
    public static String bigSmallCompare(List<Integer> numbers){
        StringBuffer sb = new StringBuffer();
        int big = 0;
        int small = 0;
        for (int num : numbers) {
            if(num <=5 ) {
                small++;
            }else {
                big++;
            }
        }
        sb.append(big);
        sb.append(":");
        sb.append(small);
        String bigSmall = sb.toString();
        return bigSmall;
    }


    //判断奇偶比
    public static String singleDoubleCompare(List<Integer> numbers){
        StringBuffer sb = new StringBuffer();
        int singleNumber = 0;
        int  doubleNumber = 0;

        for (int num : numbers) {
            if(num % 2 ==0)
                doubleNumber++;
            else
                singleNumber++;
        }
        sb.append(singleNumber);
        sb.append(":");
        sb.append(doubleNumber);
        String singleDouble = sb.toString();
        return singleDouble;
    }
}
