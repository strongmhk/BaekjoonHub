import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> nicknameMap = new HashMap<>();
        List<String[]> logs = new ArrayList<>();

        for (String r : record) {
            String[] split = r.split(" ");

            String command = split[0];
            String uid = split[1];

            if (command.equals("Enter")) {
                nicknameMap.put(uid, split[2]);
                logs.add(new String[]{uid, "님이 들어왔습니다."});
            } else if (command.equals("Leave")) {
                logs.add(new String[]{uid, "님이 나갔습니다."});
            } else if (command.equals("Change")) {
                nicknameMap.put(uid, split[2]);
            }
        }

        String[] result = new String[logs.size()];

        for (int i = 0; i < logs.size(); i++) {
            String uid = logs.get(i)[0];
            String message = logs.get(i)[1];

            result[i] = nicknameMap.get(uid) + message;
        }

        return result;
    }
}