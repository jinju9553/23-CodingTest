package DevCourse.Day8;

public class TargetNumber {

	public int solution(int[] numbers, int target) {
        int answer = 0;
        
        int N = numbers.length;
        answer = DFS(numbers, target, N, 0, 0);
        
        return answer;
    }
    
    public static int DFS(int[] items, int target, int N, int depth, int currSum) {
        
        if(N == depth) {
            if(currSum == target) {
                return 1;
            }
            
            return 0;
        }
        
        int answer = 0;
        int operand = items[depth];
            
        answer += DFS(items, target, N, depth + 1, currSum + operand);
        answer += DFS(items, target, N, depth + 1, currSum - operand);
        
        return answer;
    }

}
