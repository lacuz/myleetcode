class Solution{

//给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
// 注意：
// num1 和num2 的长度都小于 5100.
// num1 和num2 都只包含数字 0-9.
// num1 和num2 都不包含任何前导零。
// 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。

    public String addStrings(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        len1--;
        len2--;
        String result = "";
        int remain = 0;
        while(len1>=0 || len2>=0 || remain!=0){
            int tm1 =0,tm2=0;
            if(len1>=0){
                tm1 =  Integer.parseInt(String.valueOf(num1.charAt(len1)));
                
            }
            if(len2>=0){
                tm2 =  Integer.parseInt(String.valueOf(num2.charAt(len2)));
            }
            int sum = tm1+tm2+remain;
            remain = sum/10;
            result=(sum%10)+result;
            len1--;
            len2--;
        }

        return result;
    }
    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(s.addStrings("123", "456"));
        System.out.println(s.addStrings("0", "0"));
    }
}