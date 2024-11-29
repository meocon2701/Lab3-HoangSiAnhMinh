package hust.soict.dsai.lab01;






public class NoGarbage {

    public static void main(String[] args) {
        // Sử dụng StringBuffer để tránh tạo rác
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < 1000000; i++) {
            buffer.append("a");  // Dùng StringBuffer để nối chuỗi
        }

        // Quan sát kết quả
        System.out.println("String created with StringBuffer. Length: " + buffer.length());
    }
}


