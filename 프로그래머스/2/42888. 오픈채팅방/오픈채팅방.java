import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> nicknameMap = new HashMap<>();
        List<String[]> messages = new ArrayList<>();

        // 1. 명령을 처리하면서 최종 닉네임 저장
        for (String str : record) {
            StringTokenizer st = new StringTokenizer(str);

            String command = st.nextToken();
            String userId = st.nextToken();

            if (command.equals("Enter")) {
                String nickname = st.nextToken();

                nicknameMap.put(userId, nickname);
                messages.add(new String[]{userId, "님이 들어왔습니다."});

            } else if (command.equals("Leave")) {
                messages.add(new String[]{userId, "님이 나갔습니다."});

            } else if (command.equals("Change")) {
                String nickname = st.nextToken();

                nicknameMap.put(userId, nickname);
            }
        }

        // 2. 최종 닉네임을 이용해 메시지 구성
        String[] result = new String[messages.size()];

        for (int i = 0; i < messages.size(); i++) {
            String userId = messages.get(i)[0];
            String message = messages.get(i)[1];

            result[i] = nicknameMap.get(userId) + message;
        }

        return result;
    }
}