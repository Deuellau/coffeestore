import java.util.Scanner;

public class Dice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int pickNum1 = pickNum(scanner, 1);
        int pickNum2 = pickNum(scanner, 2);
        int pickNum3 = pickNum(scanner, 3);

        printPickNum(pickNum1, pickNum2, pickNum3);

        int rollDice1 = rollDice();
        int rollDice2 = rollDice();
        int rollDice3 = rollDice();

        printRollDice(rollDice1, rollDice2, rollDice3);

        int sumPickNum = pickNum1 + pickNum2 + pickNum3;
        int sumRollDice = rollDice1 + rollDice2 + rollDice3;

        validation(sumPickNum, sumRollDice);
    }


    public static int pickNum(Scanner scanner, int num) {
        while (true) {
            try {
                System.out.println("Enter number " + num + ": ");
                int userNum = Integer.parseInt(scanner.nextLine());
                if (userNum < 1 || userNum > 6) {
                    System.out.println("Number entered out of range. Please re-pick.");
                } else {
                    return userNum;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter an integer.");
            }
        }
    }


    public static void printPickNum(int num1, int num2, int num3) {
        System.out.println("\nYour picked numbers: " + num1 + ", " + num2 + ", " + num3 + ".");
        System.out.print("Sum of picked numbers: ");
        System.out.println(num1 + num2 + num3);
    }


    public static int rollDice() {
        return (int)(Math.random() * 6) + 1;
    }


    public static void printRollDice(int num1, int num2, int num3) {
        System.out.println("\nRolled dice numbers: " + num1 + ", " + num2 + ", " + num3 + ".");
        System.out.print("Sum of rolled numbers: ");
        System.out.println(num1 + num2 + num3);
    }


    public static void validation(int sumPickNum, int sumRollDice) {
        boolean firstCondition = sumRollDice < sumPickNum;
        boolean secondCondition = Math.abs(sumPickNum - sumRollDice) < 3;
        if (firstCondition && secondCondition) {
            System.out.println("\nYou won!!!");
        }
        else {
            System.out.println("\nYou lost :(");
            int difference = Math.abs(sumPickNum - sumRollDice);
            if (!firstCondition) {
                System.out.println("Picked numbers were bigger by: " + difference);
            } 
            else if (!secondCondition) {
                System.out.println("Difference was too big, at: " + difference);
            }
        }
        main(null);
    }
}
