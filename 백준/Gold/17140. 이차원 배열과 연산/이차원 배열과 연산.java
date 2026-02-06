import java.io.*;
import java.util.*;

class Pair implements Comparable<Pair> {
    public int num, cnt;

    public Pair(int num, int cnt) {
        this.num = num;
        this.cnt = cnt;
    }
    
    @Override
    public int compareTo(Pair o) {
        if (this.cnt > o.cnt) return 1;
        else if (this.cnt == o.cnt) return this.num - o.num;
        else return -1;
    }
}

class Main {
    static int[][] arr = new int[101][101];
    static int r, c, k;
    static int xLen = 3, yLen = 3;

    static void R(int rowIdx) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        Map<Integer, Integer> map = new HashMap<>();
        
        // 행에 있는 숫자 등장 횟수 계산
        for (int i = 1; i <= yLen; i++) {
            if (arr[rowIdx][i] == 0) continue;
            
            int num = arr[rowIdx][i];
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        // 각 숫자의 등장 횟수 우선순위 큐에 넣기
        map.forEach((num, cnt) -> pq.add(new Pair(num, cnt)));
    
        // 숫자, 등장 횟수 갱신
        int i = 1;
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            arr[rowIdx][i++] = p.num;
            arr[rowIdx][i++] = p.cnt;
        }
        
        // 열의 길이 갱신
        yLen = Math.max(yLen, i);
        
        // 행의 남은 부분에 0 넣기
        while (i <= 99) {
            arr[rowIdx][i++] = 0;
            arr[rowIdx][i++] = 0;
        }
    }
    
    static void C(int colIdx) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        Map<Integer, Integer> map = new HashMap<>();
        
        // 숫자, 등장 횟수 계산
        for (int i = 1; i <= yLen; i++) {
            if (arr[i][colIdx] == 0) continue;
            
            int num = arr[i][colIdx];
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        // 우선 순위 큐에 넣기
        map.forEach((num, cnt) -> pq.add(new Pair(num, cnt)));
        
        // 숫자, 등장 횟수 갱신
        int i = 1;
        while(!pq.isEmpty()) {
            Pair p = pq.poll();
            arr[i++][colIdx] = p.num;
            arr[i++][colIdx] = p.cnt;
        }
        
        // 행의 길이 갱신
        xLen = Math.max(xLen, i);
        
        // 열의 남은 부분에 0 넣기
        while(i <= 99) {
            arr[i++][colIdx] = 0;
            arr[i++][colIdx] = 0;
        }
    }

    static void operating() {
        if (xLen >= yLen) {
            for (int i = 1; i <= xLen; i++) {
                R(i);
            }
        } else {
            for (int i = 1; i <= yLen; i++) {
                C(i);
            }
        }
        
    }

    static int solution() {
        // time이 1부터가 아니고 0부터 하는 이유 -> 입력값 자체가 arr[r][c] == k으로 주어졌을 때
        for (int time = 0; time <= 100; time++) {
            if (arr[r][c] == k) return time;
            
            operating();
        }
        
        return -1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        for (int x = 1; x <= 3; x++) {
            st = new StringTokenizer(br.readLine());
            for (int y = 1; y <= 3; y++) {
                arr[x][y] = Integer.parseInt(st.nextToken());
            }
        }
        
        System.out.println(solution());
    }
}