import java.util.*;
public class Tuple {
    public static int[] solution(String s) {
        int[] answer = {};
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        ArrayList<String> result = new ArrayList<>();
        // 가장 앞의 {{ 를 제거한다.
        s = s.substring(2,s.length());
        // 가장 뒤의 }} 를 제거한 뒤, },{ 형태의 문자열을 -로 바꾼다.
        s = s.substring(0,s.length()-2).replace("},{","-");
        // 위에서 바꾼 문자열을 기준으로 split 해준다.
        String str[] = s.split("-");

        //배열 길이 기준으로 정렬
        Arrays.sort(str, (String s1, String s2) -> s1.length() - s2.length());

        for(int i= 0; i<str.length; i++){
            String[] temp = str[i].split(",");

            if(i == 0){
                result = new ArrayList<>(Arrays.asList(temp));
                continue;
            }
            list1 = result;
            list2 = new ArrayList<>(Arrays.asList(temp));

            list2.removeAll(list1);
            result.add(list2.get(0));

        }

        answer = result.stream().mapToInt(i-> Integer.parseInt(i)).toArray();
        return answer;
    }

    public static void main(String[] args) {
        solution("{{1,2,3},{2,1},{1,2,4,3},{2}}");
    }
}
