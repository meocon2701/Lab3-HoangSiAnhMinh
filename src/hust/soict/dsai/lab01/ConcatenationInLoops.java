package hust.soict.dsai.lab01;

import java.util.Random;

public class ConcatenationInLoops {
    public static void main(String[] args) {
        Random r = new Random(123);

        // Nối chuỗi bằng phép cộng chuỗi
        long start = System.currentTimeMillis();
        String s = "";
        for (int i = 0; i < 65536; i++) {
            s += r.nextInt(2);  // Nối chuỗi với mỗi số ngẫu nhiên
        }
        System.out.println(" Time taken using '+' operator: " + (System.currentTimeMillis() - start) + " milliseconds");

        // Nối chuỗi bằng StringBuilder
        r = new Random(123);  // Tạo lại Random để có cùng dãy số ngẫu nhiên
        start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 65536; i++) {
            sb.append(r.nextInt(2));  // Dùng StringBuilder để nối chuỗi
        }
        s = sb.toString();
        System.out.println(" Time taken using StringBuilder: " + (System.currentTimeMillis() - start) + " milliseconds");
    }
}
