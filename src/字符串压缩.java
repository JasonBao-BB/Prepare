public class 字符串压缩 {
    public static void main(String[] args) {
        String str = "aaabbbbbbbbdccc";

        StringBuilder sb = new StringBuilder();

        int index = 1;
        int count = 1;

        while(index < str.length()) {
            if(str.charAt(index) != str.charAt(index-1)) {
                sb.append(str.charAt(index-1)).append(count);
                count = 1;
            } else {
                count++;
            }
            index++;
        }
        sb.append(str.charAt(str.length()-1)).append(count);
        System.out.println(sb.toString());
    }
}

