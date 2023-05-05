package week7.day1;

import java.util.*;

public class BestAlbum {

	public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        
        HashMap<String, Integer> map = new HashMap<>();
        
        //�帣�� �� ���Ƚ���� �����Ѵ�.
        for(int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            
            map.put(genre, map.getOrDefault(genre, 0) + play);
        }
        
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
            (o1, o2) -> Integer.compare(o2.getValue(), o1.getValue())); //����� ��������
        
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.add(entry);
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        
        //pq���� ������� ���� �帣 ������ ������ �ٹ��� �����Ѵ�.
        while(!pq.isEmpty()) {
            Map.Entry<String, Integer> entry = pq.poll();
            String genre = entry.getKey();

            ArrayList<int[]> list = new ArrayList<>();
            for(int i = 0; i < genres.length; i++) {
                if(genre.equals(genres[i])) { //Ž���� �帣�� list�� ������.
                    int[] a = {i, plays[i]};
                    list.add(a);
                }
            }
            
            //������� ���� ������ �����Ѵ�.
            Collections.sort(list, (o1, o2) -> (Integer.compare(o2[1], o1[1])));
            
            int avaliableSize = 0; //�ٹ��� ������ ����� ���Ѵ�.
            if(list.size() >= 2) {
                avaliableSize = 2;
            }
            else if (list.size() == 1) {
                avaliableSize = 1;
            }
            
            for(int i = 0; i < avaliableSize; i++) {
                int num = (list.get(i))[0];
                result.add(num); //�ٹ�(result)�� �����Ѵ�.
            }
        }
        
        answer = new int[result.size()];
        for(int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }

}
