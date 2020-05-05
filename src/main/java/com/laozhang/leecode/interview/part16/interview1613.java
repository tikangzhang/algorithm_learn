package com.laozhang.leecode.interview.part16;

import org.junit.jupiter.api.Test;

/**
 * 给定两个正方形及一个二维平面。请找出将这两个正方形分割成两半的一条直线。假设正方形顶边和底边与 x 轴平行。
 *
 * 每个正方形的数据square包含3个数值，正方形的左下顶点坐标[X,Y] = [square[0],square[1]]，以及正方形的边长square[2]。所求直线穿过两个正方形会形成4个交点，请返回4个交点形成线段的两端点坐标（两个端点即为4个交点中距离最远的2个点，这2个点所连成的线段一定会穿过另外2个交点）。2个端点坐标[X1,Y1]和[X2,Y2]的返回格式为{X1,Y1,X2,Y2}，要求若X1 != X2，需保证X1 < X2，否则需保证Y1 <= Y2。
 *
 * 若同时有多条直线满足要求，则选择斜率最大的一条计算并返回（与Y轴平行的直线视为斜率无穷大）。
 *
 * 示例：
 *
 * 输入：
 * square1 = {-1, -1, 2}
 * square2 = {0, -1, 2}
 * 输出： {-1,0,2,0}
 * 解释： 直线 y = 0 能将两个正方形同时分为等面积的两部分，返回的两线段端点为[-1,0]和[2,0]
 *
 * 提示：
 *
 *     square.length == 3
 *     square[2] > 0
 */
public class interview1613 {
    public double[] cutSquares(int[] square1, int[] square2) {
        // center1 (square1[0]+square1[2]/2.0, square1[1]+square1[2]/2.0)   计算两正方形中心位置
        double centerX1 = square1[0]+square1[2]/2.0;
        double centerY1 = square1[1]+square1[2]/2.0;
        double centerX2 = square2[0]+square2[2]/2.0;
        double centerY2 = square2[1]+square2[2]/2.0;
        if(centerX1==centerX2){     //中心连接线与y轴平行，包含无穷多解情况（中心重合），取斜率最大的
            double y1 = Math.min(square1[1], square2[1]);   //最底位置
            double y2 = Math.max(square1[1]+square1[2], square2[1]+square2[2]);     //最上位置
            return new double[]{centerX1, y1, centerX1, y2};
        }
        double k = (centerY2-centerY1)/(centerX2-centerX1);
        double b = centerY1-k*centerX1;
        double p1X, p1Y, p2X, p2Y;  //交点坐标
        if(Math.abs(k)<=1){     //斜率k小于1，交点在左右两侧
            // point1:(square1[0],k*square1[0]+b)  point2:(square1[0]+square1[2],k*(square1[0]+square1[2])+b)
            // point3:(square2[0],k*square2[0]+b)  point4:(square2[0]+square2[2],k*(square2[0]+square2[2])+b)
            p1X = Math.min(square1[0],square2[0]);
            p1Y = k*p1X+b;
            p2X = Math.max(square1[0]+square1[2],square2[0]+square2[2]);
            p2Y = k*p2X+b;
        }else{      //交点在上下两侧
            // point5:((square1[1]+square1[2]-b)/k, square1[1]+square1[2])   point6:((square1[1]-b)/k, square1[1])
            // point7:((square2[1]+square2[2]-b)/k, square2[1]+square2[2])   point8:((square2[1]-b)/k, square2[1])
            // 交点是以上四点中x取值最小、最大的点
            p1X = Math.min(Math.min((square1[1]+square1[2]-b)/k,(square1[1]-b)/k), Math.min((square2[1]+square2[2]-b)/k,(square2[1]-b)/k));
            p1Y = k*p1X+b;
            p2X = Math.max(Math.max((square1[1]+square1[2]-b)/k,(square1[1]-b)/k), Math.max((square2[1]+square2[2]-b)/k,(square2[1]-b)/k));
            p2Y = k*p2X+b;
        }
        return new double[]{p1X, p1Y, p2X, p2Y};
    }

    @Test
    public void test(){

    }
}