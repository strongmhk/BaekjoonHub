import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int count = 0; // 곰곰티콘 사용횟수

        Set<String> chatUsers = new HashSet<>(); //  채팅한 유저 이름을 담은 Hash set

        for (int i = 0; i < N; i++) {
            String chatUser = br.readLine();
            if (chatUser.equals("ENTER")){
                count += chatUsers.size();
                chatUsers.clear();
            } else {
                chatUsers.add(chatUser);
            }

        }

        // 마지막에는 수동으로 더해주기
        count += chatUsers.size();

        System.out.println(count);



    }
}