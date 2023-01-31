//smaller bigger number count
 import java.util.Scanner;
import java.util.Random;

class GameInfo {
    Random random = new Random();
    int max = 100; // maximum value
    int min = 1; // minimum value
    int range = max - min + 1;
    int randomNum = random.nextInt(range) + min;
    int Getrandom() {
        return randomNum;
    }
}

class Playing {
    int count = 0;
    Scanner input = new Scanner(System.in);
    GameInfo yit = new GameInfo();

    int check() {
        int geq = yit.Getrandom();

        System.out.println("Enter the number and try to find 1 to 100 ");

        int set = input.nextInt();
        count++;

        int range = 10;

        if (set == geq) {
            return 1;
        } else if (set < geq) {
            System.out.println("Bigger");
        } else if (set > geq) {
            System.out.println("Smaller");
        } else if (Math.abs(set - geq) <= range) {
            System.out.println("You are close");
        } else {
            System.out.println("Something wrong");
        }
        return 0;
    }

    int botCheck(int s) {
        int botCount = 0;
        int geq = yit.Getrandom();

        int set = yit.min + yit.random.nextInt(yit.range);
        botCount++;

        while (set != geq) {
            if (set < geq) {
                yit.min = set + 1;
                yit.range = yit.max - yit.min + 1;
                set = yit.min + yit.random.nextInt(yit.range);
            } else if (set > geq) {
                yit.max = set - 1;
                yit.range = yit.max - yit.min + 1;
                set = yit.min + yit.random.nextInt(yit.range);
            }
            botCount++;
        }
        return botCount;
    }

}

public class Main {
    public static void main(String[] args) {
        int b = 0;
        GameInfo yqwer = new GameInfo();
        Playing frt = new Playing();
        do {
            b = frt.check();
            if (b == 1) {
                break;
            }
        } while (true);
        System.out.println("Congratulations, you won in " + frt.count + " tries");

        System.out.println("Bot tried " + frt.botCheck(b) + " times");

    }
}
