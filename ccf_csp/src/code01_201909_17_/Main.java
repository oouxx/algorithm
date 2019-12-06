import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String firstLine = s.nextLine();
        int N = Integer.valueOf(firstLine.split(" ")[0]);
        int M = Integer.valueOf(firstLine.split(" ")[1]);
        int[][] fruitMatrix = new int[N][M];
        for(int i = 0; i < N + 1; i++){
            String nextLine = s.nextLine();
            for(int j = 0; j < M + 1; j++){
                String[] splitedStr = nextLine.split(" ");
                fruitMatrix[i][j] = Integer.valueOf(splitedStr[j]);
            }
        }
        int K = 0; // 疏果最多的果树编号
        int P = 0; // 疏果最多的果树疏果量
        int T = 0;
        for(int i = 1; i <= N; i++){
            int sum = 0;
            for(int j = 1; j <= M; j++){
                sum += Math.abs(fruitMatrix[i][j]);
            }
            fruitMatrix[i][0] -= sum;
            T += fruitMatrix[i][0];
            p = Math.max(sum, P);
            K = sum > p ? i: K;
        }
        System.out.print(T + " ");
        System.out.print(K + " ");
        System.out.print(P);
    }
}    