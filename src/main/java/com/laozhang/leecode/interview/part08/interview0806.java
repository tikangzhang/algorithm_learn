package com.laozhang.leecode.interview.part08;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 在经典汉诺塔问题中，有 3 根柱子及 N 个不同大小的穿孔圆盘，盘子可以滑入任意一根柱子。一开始，所有盘子自上而下按升序依次套在第一根柱子上(即每一个盘子只能放在更大的盘子上面)。移动圆盘时受到以下限制:
 * (1) 每次只能移动一个盘子;
 * (2) 盘子只能从柱子顶端滑出移到下一根柱子;
 * (3) 盘子只能叠在比它大的盘子上。
 *
 * 请编写程序，用栈将所有盘子从第一根柱子移到最后一根柱子。
 *
 * 你需要原地修改栈。
 *
 * 示例1:
 *
 *  输入：A = [2, 1, 0], B = [], C = []
 *  输出：C = [2, 1, 0]
 *
 * 示例2:
 *
 *  输入：A = [1, 0], B = [], C = []
 *  输出：C = [1, 0]
 */
public class interview0806 {
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        move(A.size(),(LinkedList)A,(LinkedList)B,(LinkedList)C);
    }

    private void move(int n,LinkedList<Integer> A, LinkedList<Integer> B, LinkedList<Integer> C){
        if (n == 1){
            C.push(A.pop());
            return;
        }
        move(n - 1,A,C,B);
        C.push(A.pop());
        move(n-1,B,A,C);
    }
//    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
//        move(A.size(),A,B,C);
//    }
//
//    private void move(int n,List<Integer> A, List<Integer> B, List<Integer> C){
//        if (n == 1){
//            C.add(A.remove(A.size() - 1));
//            return;
//        }
//        move(n - 1,A,C,B);
//        C.add(A.remove(A.size() - 1));
//        move(n-1,B,A,C);
//    }


    @Test
    public void test(){
        LinkedList<Integer> a = new LinkedList<>();
        a.add(1);
        a.add(2);
        a.add(3);

        LinkedList<Integer> b = new LinkedList<>();
        LinkedList<Integer> c = new LinkedList<>();
        hanota(a,b,c);
        System.out.println(c);


//        List<Integer> a = new ArrayList<>();
//        a.add(1);
//        a.add(2);
//        a.add(3);
//
//        List<Integer> b = new ArrayList<>();
//        List<Integer> c = new ArrayList<>();
//        hanota(a,b,c);
//        System.out.println(c);
    }
}
