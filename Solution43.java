import java.math.BigInteger;

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
    

    //缺陷：补0考虑不周，超过最大值，只能用字符串操作
    public String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        long result = 0;
        for(int i=len1-1;i>=0;i--){
            int tm1 =  Integer.parseInt(String.valueOf(num1.charAt(i)));
            long remain = 0;
            long tmpResult=0;
            for(int j=len2-1;j>=0;j--){
                int tm2 = Integer.parseInt(String.valueOf(num2.charAt(j)));
                long sum = tm1*tm2+remain;
                remain = sum/10;
                tmpResult=(sum%10)*(long)Math.pow(10,len2-1-j)+tmpResult;
                if(j==0 && remain!=0){
                    tmpResult = tmpResult+remain*(long)Math.pow(10,len2);
                }
            }
            result = tmpResult*(long)Math.pow(10,len1-1-i)+result;
        }
        return String.valueOf(result);
    }

    
    public String multiply2(String num1, String num2) {
        // BigInteger val1 = new BigInteger(num1);
        // BigInteger val2 = new BigInteger(num2);
        // System.out.println("正确的值："+(val1.multiply(val2)));

        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        StringBuilder sb = new StringBuilder("");
        for(int i=num1.length()-1;i>=0;i--){
            int tm1 =  Integer.parseInt(String.valueOf(num1.charAt(i)));
            StringBuilder sbTmp = new StringBuilder("");
            int remain = 0;//进位数
            for(int j=num2.length()-1;j>=0;j--){
                int tm2 = Integer.parseInt(String.valueOf(num2.charAt(j)));
                int sum = tm1*tm2+remain;
                remain = sum/10;
                sbTmp.append(sum%10);
                if(j==0 && remain!=0){
                    sbTmp.append(remain);
                }
            }
            for(int n=0;n<num1.length()-i-1;n++){
                sbTmp = sbTmp.insert(0, "0");
            }

            //相加
            StringBuilder sbTmp2 = new StringBuilder("");
            int m=0,n=0;
            remain = 0;
            while(m<sbTmp.length() || n<sb.length()){
                int mVal = 0,nVal = 0;
                if(m<sbTmp.length()){
                    mVal = Integer.parseInt(String.valueOf(sbTmp.charAt(m++)));
                }
                if(n<sb.length()){
                    nVal = Integer.parseInt(String.valueOf(sb.charAt(n++)));
                }
                int tmpSum = mVal+nVal+remain;
                remain = (tmpSum)/10;
                sbTmp2.append((tmpSum)%10);
            }
            if(remain!=0){
                sbTmp2.append(remain);
            }
            sb = sbTmp2;


        }
        return sb.reverse().toString();
    }
    public static void main(String[] args){
        Solution43 s = new Solution43();
        System.out.println(s.multiply2("111", "0"));
        // System.out.println(s.multiply2("15", "123"));//1845
        // System.out.println(s.multiply("0", "0"));
        // System.out.println(s.multiply2("123456789", "987654321"));//"121932631112635269"
        // System.out.println(s.multiply("6", "501"));//"3006"
        // System.out.println(s.multiply2("5423396", "5424012638"));//29416568444878648"
        // System.out.println(s.multiply2("498828660196", "840477629533"));//"419254329864656431168468""
        
    }
}