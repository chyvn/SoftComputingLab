import java.util.Scanner;

/**
 * Created by chyvn on 05-03-2017.
 */
public class Temp2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int iterations = Integer.parseInt(scanner.nextLine());
        int distance = 0;
        for (int p = 0; p < iterations; p++) {
            String a = scanner.nextLine();
            String b = scanner.nextLine();

            if (a.length() != b.length()) distance = -1;
            else {
                distance = b.charAt(0) - a.charAt(0);
                if (distance < 0) {
                    distance += 26;
                }

                for (int i = 1; i < a.length(); i++) {
                    int temp = (int) a.charAt(i);
                    int temp2 = (int) b.charAt(i);
                    int tempDist = 0;
                    tempDist = (temp2 - temp);
                    if (tempDist < 0) {
                        tempDist += 26;
                    }

                    if (tempDist != distance) {
                        distance = -1;
                        break;
                    }
                }
            }

            System.out.println(distance);
        }
    }
}
