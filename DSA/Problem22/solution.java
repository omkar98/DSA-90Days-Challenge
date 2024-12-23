package DSA.Problem22;

public class  solution {
    public static void main(String[] args) {
        // consider 0 as +ve.
        int[] arr = {4,3,2,1,4};
        System.out.println(maxArea(arr));

    }

    public static int maxArea(int[] height) {
        int size = height.length;
        int left = 0 ;
        int right  = size-1;
        int area = 0;
        while(left<right) {
            int newArea = Math.min(height[left], height[right]) * (right-left);
            area = area>newArea ? area : newArea;
            if(height[left]>height[right]) right--;
            else if(height[left]<height[right]) left++;
            else if(height[left] == height[right]) {
                if(height[left+1]>height[right-1]) left++;
                else right--;
            }
        }
        return area;
    }
}



