class Solution43{
    // 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。

    // 示例 1:
    
    // 输入: num1 = "2", num2 = "3"
    // 输出: "6"
    // 示例 2:
    
    // 输入: num1 = "123", num2 = "456"
    // 输出: "56088"
    // 说明：
    
    // num1 和 num2 的长度小于110。
    // num1 和 num2 只包含数字 0-9。
    // num1 和 num2 均不以零开头，除非是数字 0 本身。
    // 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
    

    public String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        len1--;
        len2--;
        String result = "";
        int remain = 0;
        while(len1>=0 || len2>=0 || remain!=0){
            int tm1 =1,tm2=1;
            if(len1>=0){
                tm1 =  Integer.parseInt(String.valueOf(num1.charAt(len1)));
                
            }
            if(len2>=0){
                tm2 =  Integer.parseInt(String.valueOf(num2.charAt(len2)));
            }
            int sum = tm1*tm2+remain;
            remain = sum/10;
            result=(sum%10)+result;
            len1--;
            len2--;
        }

        return result;
    }
    public static void main(String[] args){
        Solution43 s = new Solution43();
        System.out.println(s.multiply("123", "5"));
        System.out.println(s.multiply("0", "0"));
    }
}