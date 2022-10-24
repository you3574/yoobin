import java.util.*;

public class JewelShopping {
    public static int[] solution(String[] gems) {

        HashSet<String> gem = new HashSet<>();
        LinkedList<String> list = new LinkedList<>();
        HashMap<String,Integer> result = new HashMap();
        int st = 0;
        int start = 0;
        int length = 99999999;

        for(int i=0; i<gems.length; i++){
            //원소 절대값
            gem.add(gems[i]);
        }

        for(int i=0; i<gems.length; i++){
            result.put(gems[i], result.getOrDefault(gems[i], result.getOrDefault(gems[i], 0) + 1));
            list.add(gems[i]);

            //앞에서부터 중복 삭제
            while(true){
                String temp = list.getFirst();
                if(result.get(temp) > 1){
                    result.put(temp, result.get(temp)-1);
                    list.removeFirst();
                    st++;
                }
                else{
                    break;
                }
            }

            //모든 보석 포함되고, 기존 사이즈보다 길이가 작으면
            if(gem.size() == result.size() && length > list.size()){
                length = list.size();
                start = st;
            }
        }

        return new int[]{start+1, start+length};
    }


    public static void main(String[] args) {
        solution(new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"});
    }
}

