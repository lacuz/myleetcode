//93.93.复原IP地址
// 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。

// 有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），整数之间用 '.' 分隔。

//  

// 示例:

// 输入: "25525511135"
// 输出: ["255.255.11.135", "255.255.111.35"]

import java.util.*;

class Solution93{

        public static void main(String[] args){
            Solution93 s = new Solution93();
            System.out.println("start");
            System.out.println(s.restoreIpAddresses("25525511135"));
        }

        public List<String> restoreIpAddresses(String s) {
            List<String> res = new ArrayList<>();
            int len = s.length();
            if (len > 12) return res;
            for (int i = 0; i < len - 3; i++) {
                int num1 = Integer.parseInt(s.substring(0, i + 1));
                if (num1 > 255 || getLen(num1) != i + 1) continue;
                for (int j = i + 1; j < len - 2; j++) {
                    int num2 = Integer.parseInt(s.substring(i + 1, j + 1));
                    if (num2 > 255 || getLen(num2) != j - i) continue;
                    for (int k = j + 1; k < len - 1; k++) {
                        int num3 = Integer.parseInt(s.substring(j + 1, k + 1));
                        if (num3 > 255 || getLen(num3) != k - j) continue;
                        int num4 = Integer.parseInt(s.substring(k + 1, len));
                        if (num4 > 255 || getLen(num4) != len - k - 1) continue;
                        String temp = num1 + "." + num2 + "." + num3 + "." + num4;
                        res.add(temp);
                    }
                }
            }
            return res;
        }
    
        int getLen(int num) {
            if (num == 0)
                return 1;
            return (int) (Math.log(num) / Math.log(10)) + 1;
        }
    
}