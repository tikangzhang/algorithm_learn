package com.laozhang.leecode.interview.part17;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

/**
 给定一组单词words，编写一个程序，找出其中的最长单词，且该单词由这组单词中的其他单词组合而成。若有多个长度相同的结果，返回其中字典序最小的一项，若没有符合要求的单词则返回空字符串。

 示例：

 输入： ["cat","banana","dog","nana","walk","walker","dogwalker"]
 输出： "dogwalker"
 解释： "dogwalker"可由"dog"和"walker"组成。

 提示：

 0 <= len(words) <= 100
 1 <= len(words[i]) <= 100
 */
public class interview1715 {
    public String longestWord(String[] words) {
        Set<String> allWords = new HashSet<>();
        String ans = "";
        for(String word : words) {
            allWords.remove(word);
            if(isCombine(word,allWords)) {
                if (word.length() > ans.length()){ans = word;}
                if (word.length() == ans.length()){
                    ans = ans.compareTo(word) > 0 ? ans : word;
                }
            }
        }
        return ans;
    }

    boolean isCombine(String s,Set<String> words) {
        if (s.length() == 0)return true;
        for(int i=1;i<=s.length();i++) {
            if (words.contains(s.substring(0, i)) && isCombine(s.substring(i), words))return true;
        }
        return false;
    }

    @Test
    public void test(){

    }
}