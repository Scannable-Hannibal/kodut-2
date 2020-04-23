import java.util.Scanner;

public class lotery {
    static void hint(String guess, int winning_number){
        int guessed_num = Integer.parseInt(guess);
        if(guessed_num < winning_number){
            System.out.println("Your number is too low!");
        } else System.out.println("Your number is too high!");
    }

    public static void main(String[] args) {
        boolean status = true;
        int min_num = 0;
        int max_num = 1000000;
        int winning_number = (int) (Math.random() * ((max_num - min_num) + 1)) + min_num; // = random number from range 0 to 100000;
        String winning_string = Integer.toString(winning_number);

        //System.out.printf("Winning number is %d\n", winning_number);
        String introduction = "Want to win a million dollars?\n" +
                "If so, guess the winning number (a number between 0 and 100000).";
        String default_reply = "Insert $1.00 and enter your number or 'q' to quit:";
        String correct = "YOU WIN!";
        String wrong = "Sorry, good guess, but not quite right. Do you want me to give you a hint (y|n)?";
        String hint_request = "Insert $2.00 for the hint!";

        int lost_money = 0;
        System.out.println(introduction);
        Scanner scan = new Scanner(System.in);

        while(status){
            System.out.println(default_reply);
            String guess = scan.nextLine();
            if(guess.equals("q") || guess.equals("Q")){
                System.out.printf("You lost $%d. Thanks for playing. Come again!", lost_money);
                status = false;
            } else if(guess.equals(winning_string)){
                lost_money = 0;
                System.out.println(correct);
                status = false;
            } else {
                lost_money+=1;
                System.out.println(wrong);
                String hint_response = scan.nextLine();
                if(hint_response.equals("y") || hint_response.equals("Y")){
                    lost_money+=2;
                    System.out.println(hint_request);
                    hint(guess, winning_number);
                }
            }
        }
    }
}
