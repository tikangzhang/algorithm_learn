package com.laozhang.leecode.interview.part17;

import org.junit.jupiter.api.Test;

/**
 * 给定一个正整数和负整数组成的 N × M 矩阵，编写代码找出元素总和最大的子矩阵。
 *
 * 返回一个数组 [r1, c1, r2, c2]，其中 r1, c1 分别代表子矩阵左上角的行号和列号，r2, c2 分别代表右下角的行号和列号。若有多个满足条件的子矩阵，返回任意一个均可。
 *
 * 注意：本题相对书上原题稍作改动
 *
 * 示例:
 *
 * 输入:
 * [
 *    [-1,0],
 *    [0,-1]
 * ]
 * 输出: [0,1,0,1]
 * 解释: 输入中标粗的元素即为输出所表示的矩阵
 *
 * 说明：
 *
 *     1 <= matrix.length, matrix[0].length <= 200
 */
public class interview1724 {
    public int[] getMaxMatrix(int[][] matrix) {
        int[] ans = new int[4];//保存最大子矩阵的左上角和右下角的行列坐标
        int N = matrix.length;
        int M = matrix[0].length;
        int[] b = new int[M];//记录当前i~j行组成大矩阵的每一列的和，将二维转化为一维
        int sum;//相当于dp[i],dp_i
        int maxsum = Integer.MIN_VALUE;//记录最大值
        int bestr1 = 0,bestc1 = 0;//暂时记录左上角，相当于begin

        for(int i=0;i<N;i++){     //以i为上边，从上而下扫描
            for(int t=0;t<M;t++ ) b[t]=0;    //每次更换子矩形上边，就要清空b，重新计算每列的和
            for(int j=i;j<N;j++){    //子矩阵的下边，从i到N-1，不断增加子矩阵的高
                //一下就相当于求一次最大子序列和
                sum = 0;//从头开始求dp
                for(int k=0;k<M;k++){
                    b[k]+=matrix[j][k];
//我们只是不断增加其高，也就是下移矩阵下边，所有这个矩阵每列的和只需要加上新加的哪一行的元素
//因为我们求dp[i]的时候只需要dp[i-1]和nums[i],所有在我们不断更新b数组时就可以求出当前位置的dp_i
                    if(sum>0){
                        sum+=b[k];
                    }
                    else{
                        sum=b[k];
                        bestr1=i;//自立门户，暂时保存其左上角
                        bestc1=k;
                    }
                    if( sum > maxsum){
                        maxsum = sum;
                        ans[0]=bestr1;//更新答案
                        ans[1]=bestc1;
                        ans[2]=j;
                        ans[3]=k;
                    }
                }
            }
        }
        return ans;
    }


    @Test
    public void test(){


    }
}