import java.util.Scanner;

/**
 * Created by chyvn on 05-03-2017.
 */
public class Temp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.next();

        String[] parts = input.split("\\.");

        boolean isValid = true;
        if (parts.length != 4) isValid = false;
        for (int i = 0; i < parts.length; i++) {
            try {
                int number = Integer.parseInt(parts[i]);
                if (number < 0 || number > 255) isValid = false;
            } catch (NumberFormatException e ) {
                isValid = false;
            }
        }

        if (isValid) System.out.println("YES");
        else System.out.println("NO");
    }
}
