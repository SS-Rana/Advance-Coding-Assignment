import java.util.*;
public class Problem1 {

    public static int maxCyclicSum(String s) {
        int n = s.length();
        String cycleStr = s + s;

        int currSum = 0;
        int maxSum = 0;
        int left = 0;

        HashSet<Character> seen = new HashSet<>();

        for(int right = 0; right < cycleStr.length(); right++) {
            char currChar = cycleStr.charAt(right);

            while (seen.contains(currChar) || (right - left + 1) > n) {
                char leftChar = cycleStr.charAt(left);
                seen.remove(leftChar);
                currSum -= (leftChar - 'a' + 1);
                left++;
            }
            seen.add(currChar);
            currSum += (currChar - 'a' + 1);
            maxSum = Math.max(maxSum, currSum);

        }

        return maxSum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        System.out.println("Maximum cyclic sum: " + maxCyclicSum(input));
    }
}