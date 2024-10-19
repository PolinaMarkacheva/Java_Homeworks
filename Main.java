import java.util.Scanner;
import java.util.Random;
/*import C.Users.79200.Desktop.complex.java;
import C.Users.79200.Desktop.matrix.java;*/
//import com.example;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows1,  rows2, cols1, cols2;
        ComplexMatrix matrix1, matrix2;

        try {
            System.out.print("Введите количество строк и столбцов первой матрицы (например, 2 2): ");
            rows1 = scanner.nextInt();
            while (rows1 <= 0) {
                System.out.print("Невозможное количество строк. Попробуйте заново: ");
                rows1 = scanner.nextInt();
            }
            cols1 = scanner.nextInt();
            while (cols1 <= 0) {
                System.out.print("Невозможное количество стоблцов. Попробуйте заново: ");
                cols1 = scanner.nextInt();
            }
            matrix1 = new ComplexMatrix(rows1, cols1);

            System.out.print("Введите количество строк и столбцов второй матрицы (например, 2 2): ");
            rows2 = scanner.nextInt();
            while (rows2 <= 0) {
                System.out.print("Невозможное количество строк. Попробуйте заново: ");
                rows2 = scanner.nextInt();
            }
            cols2 = scanner.nextInt();
            while (cols2 <= 0) {
                System.out.print("Невозможное количество стоблцов. Попробуйте заново: ");
                cols2 = scanner.nextInt();
            }
            matrix2 = new ComplexMatrix(rows2, cols2);

            System.out.print("Вы хотите заполнить матрицу самостоятельно или чтобы она заполнилась рандомно? (1/0)");
            boolean Choice = scanner.hasNextBoolean();
            if (Choice) {
                for (int i = 0; i < rows1; i++) {
                    for (int j = 0; j < cols1; j++) {
                        System.out.print("Enter real part for element (" + i + "," + j + "): ");
                        double real = scanner.nextDouble();
                        System.out.print("Enter imaginary part for element (" + i + "," + j + "): ");
                        double imaginary = scanner.nextDouble();
                        matrix1.setElement(i, j, new Complex(real, imaginary));
                    }
                }

                for (int i = 0; i < rows2; i++) {
                    for (int j = 0; j < cols2; j++) {
                        System.out.print("Enter real part for element (" + i + "," + j + "): ");
                        double real = scanner.nextDouble();
                        System.out.print("Enter imaginary part for element (" + i + "," + j + "): ");
                        double imaginary = scanner.nextDouble();
                        matrix2.setElement(i, j, new Complex(real, imaginary));
                    }
                }
            }
            else
            {
                Random random = new Random();
                for (int i = 0; i < rows1; i++) {
                    for (int j = 0; j < cols1; j++) {
                        double real = random.nextDouble() * 100;
                        double imaginary = random.nextDouble() * 100;
                        matrix1.setElement(i, j, new Complex(real, imaginary));
                    }
                }

                for (int i = 0; i < rows2; i++) {
                    for (int j = 0; j < cols2; j++) {
                        double real = random.nextDouble() * 100;
                        double imaginary = random.nextDouble() * 100;
                        matrix2.setElement(i, j, new Complex(real, imaginary));
                    }
                }
            }

            System.out.println("Matrix 1:");
            System.out.println(matrix1);
            System.out.println("Matrix 2:");
            System.out.println(matrix2);

            ComplexMatrix sum = matrix1.add(matrix2);
            System.out.println("Sum:");
            System.out.println(sum);

            ComplexMatrix difference = matrix1.subtract(matrix2);
            System.out.println("Difference:");
            System.out.println(difference);

            ComplexMatrix product = matrix1.multiply(matrix2);
            System.out.println("Product:");
            System.out.println(product);

            ComplexMatrix transpose = matrix1.transpose();
            System.out.println("Transpose of Matrix 1:");
            System.out.println(transpose);

            double det = matrix1.determinant();
            System.out.println("Determinant of Matrix 1: " + det);
        }
        catch (Exception E) {System.out.print("Congratulations! Unknown error. ");}
    }
}
