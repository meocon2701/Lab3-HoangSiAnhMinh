package hust.soict.dsai.lab01;




public class GarbageCreator {

    public static void main(String[] args) {
        // Tạo rác bằng cách sử dụng phép cộng chuỗi
        String str = "";
        for (int i = 0; i < 1000000; i++) {
            str += "a";  // Nối chuỗi bằng cách cộng chuỗi
        }

        // Quan sát việc tạo rác
        System.out.println("String created with + operator. Length: " + str.length());
    }
}
