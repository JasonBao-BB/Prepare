public class 加星 {
    public static void main(String[] args) {

        String input = "aabbccd";

        StringBuilder sb = new StringBuilder();

        int index = 0;

        while(index < input.length()){
            if(index == 0) {
                sb.append(input.charAt(index));
//                index++;
            } else {
                if(input.charAt(index-1) != input.charAt(index)) {
                    sb.append("*").append(input.charAt(index));
                } else {
                    sb.append(input.charAt(index));
                }
            }
            index++;
        }
        sb.append("*");

        System.out.println(sb.toString());
    }
}
