package com.laozhang.leecode.interview.part05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 二进制数转字符串。给定一个介于0和1之间的实数（如0.72），类型为double，打印它的二进制表达式。如果该数字不在0和1之间，或者无法精确地用32位以内的二进制表示，则打印“ERROR”。
 *
 * 示例1:
 *
 *  输入：0.625
 *  输出："0.101"
 *
 * 示例2:
 *
 *  输入：0.1
 *  输出："ERROR"
 *  提示：0.1无法被二进制准确表示
 *
 * 提示：
 *
 *     32位包括输出中的"0."这两位。
 */
public class interview0502 {
    public String printBin(double num) {
        char[] bits = new char[32];
        bits[0] = '0';
        bits[1] = '.';
        int curr = 2;
        int divisor = 2;
        while (num != 0 && curr < bits.length) {
            if (num * divisor >= 1) {
                bits[curr] = '1';
                num -= (1.0 / divisor);
            } else {
                bits[curr] = '0';
            }
            divisor *= 2;
            curr++;
        }
        if (num != 0) {
            return "ERROR";
        }
        return String.valueOf(bits, 0, curr);
    }
//    public String printBin(double num) {
//        StringBuilder sb = new StringBuilder();
//        sb.append("0.");
//        for (int i = 0; i < 33; i++) {
//            if (num == 0) return sb.toString();
//            num *= 2;
//            if (num >= 1) {
//                sb.append("1");
//                num -= 1;
//            } else {
//                sb.append("0");
//            }
//        }
//        return "ERROR";
//    }

    @Test
    public void test(){
        Assertions.assertEquals(printBin(0.625),"0.101");
        Assertions.assertEquals(printBin(0.1),"ERROR");
    }
}
