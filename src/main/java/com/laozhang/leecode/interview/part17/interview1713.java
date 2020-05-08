package com.laozhang.leecode.interview.part17;

import com.laozhang.leecode.interview.common.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 哦，不！你不小心把一个长篇文章中的空格、标点都删掉了，并且大写也弄成了小写。像句子"I reset the computer. It still didn’t boot!"已经变成了"iresetthecomputeritstilldidntboot"。在处理标点符号和大小写之前，你得先把它断成词语。当然了，你有一本厚厚的词典dictionary，不过，有些词没在词典里。假设文章用sentence表示，设计一个算法，把文章断开，要求未识别的字符最少，返回未识别的字符数。

 注意：本题相对原题稍作改动，只需返回未识别的字符数



 示例：

 输入：
 dictionary = ["looked","just","like","her","brother"]
 sentence = "jesslookedjustliketimherbrother"
 输出： 7
 解释： 断句后为"jess looked just like tim her brother"，共7个未识别字符。

 提示：

 0 <= len(sentence) <= 1000
 dictionary中总字符数不超过 150000。
 你可以认为dictionary和sentence中只包含小写字母。
 */
public class interview1713 {
//    public int respace(String[] dictionary, String sentence) {
//        Set<String> dic = new HashSet<>();
//        for(String str: dictionary) dic.add(str);
//
//        int n = sentence.length();
//        //dp[i]表示sentence前i个字符所得结果
//        int[] dp = new int[n+1];
//        for(int i=1; i<=n; i++){
//            dp[i] = dp[i-1]+1;  //先假设当前字符作为单词不在字典中
//            for(int j=0; j<i; j++){
//                if(dic.contains(sentence.substring(j,i))){
//                    dp[i] = Math.min(dp[i], dp[j]);
//                }
//            }
//        }
//        return dp[n];
//    }

//    public int respace(String[] dictionary, String sentence){
//        Set<String> dic = new HashSet<>();
//        // <最后一个字符，这样的单词长度有哪些>
//        Map<Character, Set<Integer>> map = new HashMap<>();
//        for(String str: dictionary){
//            dic.add(str);
//            int len = str.length();
//            char c = str.charAt(len-1);
//            Set<Integer> set = map.getOrDefault(c, new HashSet<>());
//            set.add(len);
//            map.put(c, set);
//        }
//
//        int n = sentence.length();
//        int[] dp = new int[n+1];
//        for(int i=1; i<=n; i++){
//            dp[i] = dp[i-1]+1;
//            char c = sentence.charAt(i-1);
//            if(map.containsKey(c)){
//                Set<Integer> lens = map.get(c);
//                Iterator<Integer> it = lens.iterator();
//                while(it.hasNext()){
//                    int l = it.next();
//                    if(i>=l && dic.contains(sentence.substring(i-l,i))){
//                        dp[i] = Math.min(dp[i], dp[i-l]);
//                    }
//                }
//            }
//        }
//        return dp[n];
//    }

    class TrieNode{
        TrieNode[] childs;
        boolean isWord;
        public TrieNode(){
            childs = new TrieNode[26];
            isWord = false;
        }
    }
    TrieNode root;  //空白的根节点，设为全局变量更醒目
    public int respace(String[] dictionary, String sentence){
        root = new TrieNode();
        makeTrie(dictionary);   //创建字典树
        int n = sentence.length();
        int[] dp = new int[n+1];
        //这里从sentence最后一个字符开始
        for(int i=n-1; i>=0; i--){
            dp[i] = n-i;    //初始默认后面全不匹配
            TrieNode node = root;
            for(int j=i; j<n; j++){
                int c = sentence.charAt(j)-'a';
                if(node.childs[c] == null){
                    //例如"abcde",i=1,j=2 可找出长度关系
                    dp[i] = Math.min(dp[i], j-i+1+dp[j+1]);
                    break;
                }
                if(node.childs[c].isWord){
                    dp[i] = Math.min(dp[i], dp[j+1]);
                } else{
                    dp[i] = Math.min(dp[i], j-i+1+dp[j+1]);
                }
                node = node.childs[c];
            }
        }
        return dp[0];
    }

    public void makeTrie(String[] dictionary){
        for(String str: dictionary){
            TrieNode node = root;
            for(int k=0; k<str.length(); k++){
                int i = str.charAt(k)-'a';
                if(node.childs[i] == null){
                    node.childs[i] = new TrieNode();
                }
                node = node.childs[i];
            }
            node.isWord = true; //单词的结尾
        }
    }

    @Test
    public void test(){

    }
}