package com.laozhang.leecode.interview.part08;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * 括号。设计一种算法，打印n对括号的所有合法的（例如，开闭一一对应）组合。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */
public class interview0809 {
    public List<String> generateParenthesis(int n) {
        List<String> list = new LinkedList();
        dfs(list, new char[n * 2], n, n, 0, ' ');
        return list;
    }
    private void dfs(List<String> list, char[] chars, int left, int right, int index,char temp){
        if (left > right) return;
        if (left == 0 && right == 0) list.add(new String(chars));
        if (left > 0) dfs(list, chars, left - 1, right, index + 1, chars[index] = '(');
        if (right > 0) dfs(list, chars, left, right - 1, index + 1, chars[index] = ')');
    }

    @Test
    public void test(){
        System.out.println(generateParenthesis(3));
    }
}
