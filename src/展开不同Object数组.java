import java.util.ArrayList;
import java.util.List;

public class 展开不同Object数组 extends 字符串压缩 {

    public static void main(String[] args) {

        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);

        List<Integer> nums1 = new ArrayList<>();
        nums1.add(5);
        nums1.add(6);
        nums1.add(7);

        List<Object> list = new ArrayList<>();
        list.add(nums);
        list.add(3);
        list.add(4);
        list.add(nums1);

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < list.size(); i++) {
            Object cur = list.get(i);
            System.out.println("当前是"+ cur);
            if(cur instanceof List) {
                for(Object num : (List)cur) {
                    sb.append(num);
                }
            } else {
                sb.append(cur);
            }
        }


        System.out.println(sb.toString());
    }


}
