package com.laozhang.leecode.interview.part16;

import org.junit.jupiter.api.Test;

/**
 * 给定N个人的出生年份和死亡年份，第i个人的出生年份为birth[i]，死亡年份为death[i]，实现一个方法以计算生存人数最多的年份。
 *
 * 你可以假设所有人都出生于1900年至2000年（含1900和2000）之间。如果一个人在某一年的任意时期都处于生存状态，那么他们应该被纳入那一年的统计中。例如，生于1908年、死于1909年的人应当被列入1908年和1909年的计数。
 *
 * 如果有多个年份生存人数相同且均为最大值，输出其中最小的年份。
 *
 * 示例：
 *
 * 输入：
 * birth = {1900, 1901, 1950}
 * death = {1948, 1951, 2000}
 * 输出： 1901
 *
 * 提示：
 *
 *     0 < birth.length == death.length <= 10000
 *     birth[i] <= death[i]
 */
public class interview1610 {
    public int maxAliveYear(int[] birth, int[] death) {
        int[] changes = new int[102];
        int len = birth.length, res = 1900, max_alive = 0, cur_alive = 0;
        for (int i = 0; i < len; ++i) {
            ++changes[birth[i] - 1900];
            --changes[death[i] - 1899];
        }
        for (int i = 1; i < 101; ++i) {
            cur_alive += changes[i];
            if (cur_alive > max_alive) {
                max_alive = cur_alive;
                res = 1900 + i;
            }
        }
        return res;
    }

    @Test
    public void test(){

    }
}