
class Test{
    
    /*魔術索引*/
    public static int findMagicIndex(int[] nums) {
        int val = -1;
        for(int i=0;i<nums.length;i++){
            if(i==nums[i]){
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] arg){
        System.out.println(findMagicIndex(new int[]{0, 2, 3, 4, 5}));
        System.out.println(findMagicIndex(new int[]{1, 1, 1}));
    }
}