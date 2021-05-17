public class Main {
    public static void main(String[] args) {
        Out o = new Out();
        o.msg("Welcome to Access Point Find-a-ship!");
        o.msg("I bet you can't find my ship!!!");
        o.msg("... well at least not in less then 40 guesses which is when I become invisible to you!");
        int hits = 0;
        int guesses = 0;

        Board b = new Board();
        int rowRandom = (int)(Math.random() * 9); //0 to 9
        int columnStartRandom = (int)(Math.random() * 4); //0 to 4
        b.placeShip(rowRandom, columnStartRandom);

        while (hits < 5) {
            b.showBoard();
            b.handleUserGuess();
            hits = b.checkWinStatus();
            ++guesses;
            o.msg("You're up to " + guesses + " guesses now...");
            if (guesses == 40) break;
        }

        if (guesses == 40) {
            o.msg("\n\n\nOhhhh yeaaaaahhhhh!!!!!");
            o.msg("T told you you couldn't find me in less than 40 guesses!!!");
            o.msg("Maybe, just maybe, you'll try again!");
        }
        else {
            o.msg("\n\n\nYou sunk my ship!!!!!");
            o.msg("But that's ok, I'll figure out how to move next time... or maybe I won't...");
            o.msg("Thanks for playing Access-Point-A-Ship!!!!!");
        }
    }
}