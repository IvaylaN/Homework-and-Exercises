package homework1;

import java.util.Scanner;

public class homework1 {
}
    public static void homework1(String[] args) {
        showPineTree() ;
    }
    public static void storeAndPrintName() {
        String firstName = "Ivayla";
        String secondName = "Nikolova";
        String lastName = "Slavova";

        String fullName = firstName + " " + secondName + " " + lastName;

        System.out.println(fullName);
    }
    public static void perimeterTriangle() {
        int firstSide = 2;
        int secondSide = 5;
        int thirdSide = 9;

        int perTriangle = firstSide + secondSide + thirdSide;

        System.out.println(perTriangle);
    }
    public static void areaTriangle() {
        int oneSide = 10;
        int secondSide = 25;

        int areaTriangle = (oneSide + secondSide) / 2;

        System.out.println(areaTriangle);
    }
    public static void showPineTree() {
        String pineTree = "   *    "+" \n  ***  "+" \n *****" ;
        System.out.println(pineTree) ;
    }
    public static void trianglePerimeterInput() {
        Scanner myObj = new Scanner(System.in);

        System.out.println("First side");
        int firstSide = myObj.nextInt();

        System.out.println("Second side");
        int secondSide = myObj.nextInt();

        System.out.println("Third side");
        int thirdSide = myObj.nextInt();

        int perimeter = firstSide + secondSide + thirdSide;

        System.out.println("Triangle Perimeter is: " + perimeter);
    }
    public static void printQuadraticEquation() {
        // value of the constants a, b, c
        double a = 7.2;
        double b = 5;
        double c = 9;

        // declared the two roots
        double root1;
        double root2;

        // determinant (b^2 - 4ac)
        double determinant = b * b - 4 * a * c;

        System.out.println("Determinant = " + determinant);

        //determinant > 0
        root1 = (-b + Math.sqrt(determinant)) / (2 * a);
        root2 = (-b - Math.sqrt(determinant)) / (2 * a);
        System.out.println("\nDeterminant > 0");
        System.out.println("root1 = " + root1);
        System.out.println("root2 = " + root2);


        //determinant == 0
        root1 = root2 = -b / (2 * a);
        System.out.println("\nDeterminant == 0");
        System.out.println("root1 = root2 = " + root1);

        //determinant < 0
        double real = -b / (2 * a);
        double imaginary = Math.sqrt(-determinant) / (2 * a);
        System.out.println("\nDeterminant < 0");
        System.out.format("root1 = %.2f+%.2fi", real, imaginary);
        System.out.format("\nroot2 = %.2f-%.2fi", real, imaginary);
    }
}

