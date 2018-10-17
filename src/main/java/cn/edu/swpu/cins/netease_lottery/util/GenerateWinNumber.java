package cn.edu.swpu.cins.netease_lottery.util;

import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

/**
 * Created by miaomiao on 17-7-28.
 */
@Component
public class GenerateWinNumber {

    //生成中奖号码数组  五个不重复的数
    public static List<Integer> generateNumber(){
        Supplier<List<Integer>> supplier = () -> {
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
        };
        return supplier.get();
    }


    //判断大小比
    public static String bigSmallCompare(List<Integer> numbers){
        StringBuffer sb = new StringBuffer();
        Long big = numbers.stream()
                .filter((num) -> num > 5)
                .count();
        sb.append(big);
        sb.append(":");
        sb.append(numbers.size() - big);
        return sb.toString();
    }


    //判断奇偶比
    public static String singleDoubleCompare(List<Integer> numbers){
        StringBuffer sb = new StringBuffer();
        Long singleNumber = numbers.stream()
                .filter((num) -> num % 2 != 0)
                .count();
        sb.append(singleNumber);
        sb.append(":");
        sb.append(numbers.size() - singleNumber);
        return sb.toString();
    }
}
