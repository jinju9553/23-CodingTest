package DevCourse.Day23;

import java.util.*;

public class SkillTree {

	private static int[] indegree;
    private static Set<Character> set = new HashSet<>();
    
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        int size = skill.length();
        indegree = new int[size];
        
        for(int i = 0; i < size; i++) {
            char nextSkill = skill.charAt(i);
            set.add(nextSkill);
        }
        
        indegree[0] = 0;
        for(int i = 1; i < size; i++) {
            indegree[i] = 1; //스킬트리 번호, 진입간선 수
        }
        
        for(String skill_tree : skill_trees) {
            answer += checkValidation(skill, skill_tree);
        }
        
        return answer;
    }
    
    public static int checkValidation(String skill, String skill_tree) {
        int[] currIndegree = new int[indegree.length];
        int length = skill_tree.length();
        
        for(int i = 0; i < indegree.length; i++) {
            currIndegree[i] = indegree[i];
        }
        
        for(int i = 0; i < length; i++) {
            char s = skill_tree.charAt(i);
            
            if(!set.contains(s)) {
                continue;
            }
            
            int idx = skill.indexOf(s);
            
            //진입간선이 0이라면 다음 스킬의 진입간선 수를 줄이고 계속 탐색
            if(currIndegree[idx] == 0) {
                if(idx < currIndegree.length - 1) {
                    currIndegree[idx + 1] = 0;   
                }
            }
            else {
                return 0;
            }
        }

        return 1;
    }

}
