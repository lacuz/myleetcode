
class Solution459{
    // 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。
    // 给定的字符串只含有小写英文字母，并且长度不超过10000。
   
    public boolean repeatedSubstringPattern(String s) {
        //首先考虑二分法
        if(s.length()%2!=0) return false;
        int mid = s.length()/2;
        while(mid!=0){
            boolean flag = true;
            for(int i=0;i<mid;i++){
                if(s.charAt(i)!=s.charAt(mid+i)){
                    flag = false;
                    break;
                }
            }

            if(flag){
                return true;
            }
            
            if(mid%2!=0) return false;
            
            mid=mid/2;
        }
        return false;
    }
    
    public boolean repeatedSubstringPattern2(String s) {
        for(int i=1;i<=s.length()/2;i++){
            if(s.length()%i!=0) continue;
            String aa = s.substring(0, i);
            boolean flag = true;
            for(int j=i;j+i<=s.length();j+=i){
                String bb = s.substring(j, j+i);
                if(!aa.equals(bb)){
                    flag = false;
                    break;
                }
            }
            
            if(flag){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        Solution459 s = new Solution459();
        System.out.println("---------");
        // System.out.println(s.repeatedSubstringPattern(""));
        System.out.println(s.repeatedSubstringPattern2("abaababaab"));
        System.out.println(s.repeatedSubstringPattern2("abac"));
        System.out.println(s.repeatedSubstringPattern2("aaa"));
        System.out.println(s.repeatedSubstringPattern2("abcabcabcabc"));
        System.out.println(s.repeatedSubstringPattern2("abcabcabcabca"));
       
    }
}