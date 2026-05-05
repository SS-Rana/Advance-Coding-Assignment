import java.util.Arrays;
import java.util.Scanner;
public class Problem2 {

    public static int minOperations(int[] A, int k) {
        int n = A.length;

        int mod = A[0] % k;
        for (int e : A) {
            if (e % k != mod) {
                return -1;
            }
        }
        
        int[] B = new int[n];
        for (int i = 0; i < n; i++) {
            B[i] = A[i] / k;
        }

        Arrays.sort(B);
        int median = B[n / 2];
        int ans = 0;
        for (int e : B) {
            ans += Math.abs(e - median);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        int[] A = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            System.out.print("A[" + i + "]: ");
            A[i] = sc.nextInt();
        }
        System.out.print("Enter the value of k: ");
        int k = sc.nextInt();
        System.out.println("Minimum number of operations required: " + minOperations(A, k));
    }
}
