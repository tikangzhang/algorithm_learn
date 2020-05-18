package com.laozhang.leecode.interview.part17;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 假设你有两个数组，一个长一个短，短的元素均不相同。找到长数组中包含短数组所有的元素的最短子数组，其出现顺序无关紧要。
 *
 * 返回最短子数组的左端点和右端点，如有多个满足条件的子数组，返回左端点最小的一个。若不存在，返回空数组。
 *
 * 示例 1:
 *
 * 输入:
 * big = [7,5,9,0,2,1,3,5,7,9,1,1,5,8,8,9,7]
 * small = [1,5,9]
 * 输出: [7,10]
 *
 * 示例 2:
 *
 * 输入:
 * big = [1,2,3]
 * small = [4]
 * 输出: []
 *
 * 提示：
 *
 *     big.length <= 100000
 *     1 <= small.length <= 100000
 */
public class interview1718 {
    public int[] shortestSeq(int[] big, int[] small) {
        int b_len = big.length;
        if (b_len < small.length)
            return new int[0];
        HashSet<Integer> smallSet = new HashSet<>(), bigSet = new HashSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int s : small)
            smallSet.add(s);
        int len = Integer.MAX_VALUE;
        int[] ans={-1,-1};
        for (int i = 0; i < b_len; ++i) {
            if (smallSet.contains(big[i])) {
                list.add(i);
                bigSet.add(big[i]);
                if(map.containsKey(big[i]))
                    map.put(big[i],map.get(big[i])+1);
                else
                    map.put(big[i],1);

                if (bigSet.size() == smallSet.size()) {
                    int temp;
                    while (true) {
                        temp = list.remove(0);
                        int count = map.get(big[temp]) - 1;
                        map.put(big[temp], count);
                        if (count == 0) {
                            bigSet.remove(big[temp]);
                            break;
                        }
                    }
                    if (len > i - temp + 1) {
                        len = i - temp + 1;
                        ans[0] = temp;
                        ans[1] = i;
                    }
                }
            }
        }
        if(ans[0]<0)
            return new int[0];
        return ans;
    }

//    public int[] shortestSeq(int[] big, int[] small) {
//        if(small.length>big.length)
//            return new int[0];
//        Map<Integer,Integer> map=new HashMap<>();
//        int count=small.length;
//        int[] ans={0,big.length};
//
//        for(int i:small)
//            map.put(i,-1);
//
//        for(int i=0;i<big.length;i++){
//            if(map.containsKey(big[i])){
//                if(map.get(big[i])==-1)
//                    count--;
//                map.put(big[i],i);
//            }
//            if(count<=0){
//                Collection<Integer> c = map.values();
//                Object[] obj = c.toArray();
//                int minNum=getMin(obj);
//                if(i-minNum+1<ans[1]-ans[0]+1){
//                    ans[0]=minNum;
//                    ans[1]=i;
//                }
//            }
//        }
//        if(count>0)
//            return new int[0];
//        return ans;
//    }
    int getMin(Object[] obj){
        int minNum=Integer.MAX_VALUE;
        for(Object i:obj){
            minNum=Math.min((int)i,minNum);
        }
        return minNum;
    }

    @Test
    public void test(){


    }
}