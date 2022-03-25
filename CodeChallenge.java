package HackerRankPractice;

import java.util.*;

public class CodeChallenge {

    public static void main(String[] args) {

        System.out.println(IsValid("abc"));
        System.out.println(Winner(5, 2));
    }
    public static String IsValid(String str){
        HashMap<Character,Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++){
            char key = str.charAt(i);
            if (map.get(key) != null)
                map.put(key, map.get(key)+1);
            else
                map.put(key,1);
        }

        ArrayList<Integer> mapValues = new ArrayList<>(map.values());

        int max = Collections.max(mapValues);
        int min = Collections.min(mapValues);

        if (min == max)
            return "YES";

        int min_count = 0, max_count = 0;
        for (int i=0; i<mapValues.size(); i++){
            if (mapValues.get(i) == max)
                max_count++;
            else if (mapValues.get(i) == min)
                min_count++;
        }
        return (min_count == 1 || (max_count == 1 && max == min+1)) ? "YES" : "NO";
    }

    public static int Winner(int n, int k) {
        List<Integer> w =new ArrayList<Integer>();
        for(int i=1;i<=n;i++){
            w.add(i);
        }
        int i=0;
        while(w.size()>1){

            i = (i + k - 1) % (w.size());
            w.remove(i);
        }
        return w.get(0);

    }

}
