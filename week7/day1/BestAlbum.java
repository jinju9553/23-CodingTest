package week7.day1;

import java.util.*;

public class BestAlbum {

	public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        
        HashMap<String, Integer> map = new HashMap<>();
        
        //장르별 총 재생횟수를 집계한다.
        for(int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            
            map.put(genre, map.getOrDefault(genre, 0) + play);
        }
        
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
            (o1, o2) -> Integer.compare(o2.getValue(), o1.getValue())); //재생수 내림차순
        
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.add(entry);
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        
        //pq에서 재생수가 높은 장르 순으로 뽑으며 앨범에 수록한다.
        while(!pq.isEmpty()) {
            Map.Entry<String, Integer> entry = pq.poll();
            String genre = entry.getKey();

            ArrayList<int[]> list = new ArrayList<>();
            for(int i = 0; i < genres.length; i++) {
                if(genre.equals(genres[i])) { //탐색할 장르만 list로 모은다.
                    int[] a = {i, plays[i]};
                    list.add(a);
                }
            }
            
            //재생수가 높은 순으로 정렬한다.
            Collections.sort(list, (o1, o2) -> (Integer.compare(o2[1], o1[1])));
            
            int avaliableSize = 0; //앨범할 수록할 곡수를 정한다.
            if(list.size() >= 2) {
                avaliableSize = 2;
            }
            else if (list.size() == 1) {
                avaliableSize = 1;
            }
            
            for(int i = 0; i < avaliableSize; i++) {
                int num = (list.get(i))[0];
                result.add(num); //앨범(result)에 수록한다.
            }
        }
        
        answer = new int[result.size()];
        for(int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }

}
