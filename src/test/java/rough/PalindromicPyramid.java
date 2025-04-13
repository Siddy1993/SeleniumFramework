package rough;

public class PalindromicPyramid {
    public static void main(String[] args) {
        int rows = 5;

        for (int i = 1; i <= rows; i++) {

            // Print leading spaces
            for (int j = 1; j <= rows - i; j++) {
                System.out.print(" ");
            }

            // Print increasing numbers
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }

            // Print decreasing numbers
            for (int j = i - 1; j >= 1; j--) {
                System.out.print(j);
            }

            // Move to next line
            System.out.println();
        }
    }
}