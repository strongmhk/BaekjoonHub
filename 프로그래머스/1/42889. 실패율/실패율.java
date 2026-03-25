import java.util.*;

class Stage {
    int num;
    double fail;

    Stage(int num, double fail) {
        this.num = num;
        this.fail = fail;
    }
}

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] count = new int[N + 2];

        for (int s : stages) count[s]++;

        int players = stages.length;
        List<Stage> list = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            double fail = (players == 0) ? 0 : (double) count[i] / players;
            list.add(new Stage(i, fail));
            players -= count[i];
        }

        Collections.sort(list, (a, b) -> {
            if (b.fail == a.fail) return a.num - b.num;
            return Double.compare(b.fail, a.fail);
        });

        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = list.get(i).num;
        }

        return answer;
    }
}