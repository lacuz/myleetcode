public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    double midVal = 0,tmpVal=0;
    int len1 = nums1.length;
    int len2 = nums2.length;
    int tm1 = (len1+len2)/2;
    int tm2 = (len1+len2)%2;
    int i=0,j=0,key=0;
    while(true){
         if((i<len1 && j>=len2) || (i<len1 && nums1[i]<=nums2[j] )){
            midVal = nums1[i];
            i++;
        }else if((i>=len1 && j<len2) || (j<len2 && nums1[i]>nums2[j])){
            midVal = nums2[j];
            j++;
        }
        if(tm2==1 && key==tm1){
            break;
        }else if(tm2==0 && key==tm1-1){
            tmpVal=midVal;
        }else if(tm2==0 && key==tm1){
            midVal = (tmpVal+midVal)/2;
            break;
        }
        key++;
    }
    


    return midVal;
}