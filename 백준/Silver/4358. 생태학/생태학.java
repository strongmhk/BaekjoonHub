import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        
        TreeMap<String, Integer> map = new TreeMap<>();
        
        String str = "";
        int count = 0;
        while((str = br.readLine()) != null) {
            map.put(str, !map.containsKey(str) ? 1 : map.get(str) + 1);
            count++;
        }
        
        Object[] k = map.keySet().toArray();
        Arrays.sort(k);
        
        StringBuilder sb = new StringBuilder();
        for(Object o : k) {
            String key = (String) o;
            double value = (double)(map.get(key)*100)/count;
            sb.append(key).append(" ").append(String.format("%.4f", value)).append("\n");
        }
        System.out.print(sb);
    }
}