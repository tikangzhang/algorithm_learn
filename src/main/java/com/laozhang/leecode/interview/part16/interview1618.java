package com.laozhang.leecode.interview.part16;

import org.junit.jupiter.api.Test;

/**
 你有两个字符串，即pattern和value。 pattern字符串由字母"a"和"b"组成，用于描述字符串中的模式。例如，字符串"catcatgocatgo"匹配模式"aabab"（其中"cat"是"a"，"go"是"b"），该字符串也匹配像"a"、"ab"和"b"这样的模式。但需注意"a"和"b"不能同时表示相同的字符串。编写一个方法判断value字符串是否匹配pattern字符串。

 示例 1：

 输入： pattern = "abba", value = "dogcatcatdog"
 输出： true

 示例 2：

 输入： pattern = "abba", value = "dogcatcatfish"
 输出： false

 示例 3：

 输入： pattern = "aaaa", value = "dogcatcatdog"
 输出： false

 示例 4：

 输入： pattern = "abba", value = "dogdogdogdog"
 输出： true
 解释： "a"="dogdog",b=""，反之也符合规则

 提示：

 0 <= len(pattern) <= 1000
 0 <= len(value) <= 1000
 你可以假设pattern只包含字母"a"和"b"，value仅包含小写字母。
 */
public class interview1618 {
    int[] cnt = new int[2];
    public boolean patternMatching(String pattern, String value) {
        // 分情况讨论
        // 1. pattern为空
        if (pattern.isEmpty()) return value.isEmpty();
        // 2. pattern不为空
        // 2.1 value为空, 判断pattern是否只由一个字母组成
        if (value.isEmpty()) {
            int i = 0;
            while (i < pattern.length() && pattern.charAt(i) == pattern.charAt(0)) i ++;
            return i == pattern.length();
        }
        // 2.2 pattern不为空，value不为空
        int n = pattern.length(), m = value.length();
        //   预处理统计a, b字母个数cnt[0], cnt[1]
        cnt[0] = cnt[1] = 0;
        for (char x : pattern.toCharArray()) cnt[x - 'a'] ++;
        //   判断cnt[0], cnt[1]是否有为0的情况
        if (cnt[0] == 0) return helper(value, cnt[1]);
        else if (cnt[1] == 0) return helper(value, cnt[0]);

        //  2.2.1 假设使得a,b其中之一为空, 即次数为0
        if (helper(value, cnt[0])) return true;
        if (helper(value, cnt[1])) return true;

        // 2.2.2 a,b都不为空; 枚举a, b匹配的长度，使得a * len_a + b * len_b = m; len_a唯一确定len_b，只需枚举len_a
        for (int len_a = 1; len_a * cnt[0] <= m - cnt[1]; len_a ++) {
            if ((m - len_a * cnt[0]) % cnt[1] != 0) continue;
            int len_b = (m - len_a * cnt[0]) / cnt[1];
            if (check(pattern, value, len_a, len_b)) return true;
        }
        return false;
    }

    boolean helper(String value, int k) { // pattern不为空，value不为空. 判断是否可以k次切分value
        int m = value.length();
        if (m % k != 0) return false;
        int len = m / k;
        for (int i = len; i < m; i += len)
            if (value.substring(i, len) != value.substring(0, len)) return false;
        return true;
    }

    boolean check(String pattern, String value, int len_a, int len_b) {
        String[] ps = {"", ""}; // a, b匹配的字符串
        for (int i = 0, j = 0; i < pattern.length(); i ++) { // i, j指针都是恰当长度的
            if (pattern.charAt(i) == 'a') {
                if (ps[0] == "") ps[0] = value.substring(j, len_a);
                else if (value.substring(j, len_a) != ps[0]) return false;
                j += len_a;
            } else if (pattern.charAt(i) == 'b') {
                if (ps[1] == "") ps[1] = value.substring(j, len_b);
                else if (value.substring(j, len_b) != ps[1]) return false;
                j += len_b;
            }
        }
        return true;
    }

    @Test
    public void test(){

    }
}