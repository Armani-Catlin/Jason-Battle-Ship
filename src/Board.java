import java.util.Scanner;

class Board {
    public Board() {
        o = new Out();
    }

    public void placeShip(int row, int startColumn) {
        if (row == 0) shipRow = "a";
        else if (row == 1) shipRow = "b";
        else if (row == 2) shipRow = "c";
        else if (row == 3) shipRow = "d";
        else if (row == 4) shipRow = "e";
        else if (row == 5) shipRow = "f";
        else if (row == 6) shipRow = "g";
        else if (row == 7) shipRow = "h";
        else if (row == 8) shipRow = "i";
        else if (row == 9) shipRow = "j";

        columnOne = startColumn;
        columnTwo = startColumn + 1;
        columnThree = startColumn + 2;
        columnFour = startColumn + 3;
        columnFive = startColumn + 4;
    }

    public int checkWinStatus() {
        // Find a way to change the current lettered array(a,b,etc.)
        // Match shipRow to row array name
        int hits = 0;
        for (int x = 0; x < rows.length; x++) {
            for (int idx = 0; idx < 10; ++idx) {
                if (columnOne == idx && rows[x][columnOne] == 5) ++hits;
                if (columnTwo == idx && rows[x][columnTwo] == 5) ++hits;
                if (columnThree == idx && rows[x][columnThree] == 5) ++hits;
                if (columnFour == idx && rows[x][columnFour] == 5) ++hits;
                if (columnFive == idx && rows[x][columnFive] == 5) ++hits;
            }
        }

        String msg = "So far the number of hits you have is: " + hits;
        System.out.println(msg);
        return hits;
    }

    public void handleUserGuess() {
        boolean hit = false;
        Scanner userInput = new Scanner(System.in);
        System.out.println("Which Row? (a,b,c,d,e,f,g,h,i,j)");
        String row = userInput.nextLine();
        System.out.println("Which Column? (0,1,2,3,4,5,6,7,8,9)");
        int column = userInput.nextInt();

        o.msg("\n\n You entered " + row + column + "\n");
        int r = aBC.indexOf(row);
        if (row.equals(shipRow)) {
            if (
                    (column == columnOne) ||
                            (column == columnTwo) ||
                            (column == columnThree) ||
                            (column == columnFour) ||
                            (column == columnFive)
            ) {
                rows[r][column] = 5;
                hit = true;

            } else o.msg("You did not provide a valid column number");
        } else if (column <= 9) {
            rows[r][column] = 1;
        } else {
            System.out.println("You entered an invalid row and/or column, come on now, let's keep it on the board please... row must be between a-j inclusive, columns must be between 0-9 inclusive...");
        }
        if (!hit) o.msg("That was a MISS!");
        else o.msg("That was a HIT!!! ... uh oh!");
    }

    public void showBoard() {
        System.out.println("\n\n*****GAME BOARD*****");
        System.out.println("   0 1 2 3 4 5 6 7 8 9");

        for (int i = 0; i < rows.length; i++) {
            System.out.print(aBC.charAt(i) == 'a' ? aBC.charAt(i) + "  " : "\n" + aBC.charAt(i) + "  ");
            for (int idx = 0; idx <= 9; ++idx) {
                System.out.print(rows[i][idx]);
                System.out.print(" ");
            }
        }
        System.out.println("\n\n");
    }

        Out o;
        public int[] a = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        public int[] b = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        public int[] c = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        public int[] d = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        public int[] e = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        public int[] f = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        public int[] g = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        public int[] h = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        public int[] i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        public int[] j = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        public int[][] rows = new int[][]{
                a, b, c, d, e, f, g, h, i, j
        };
        public String shipRow;
        public int columnOne;
        public int columnTwo;
        public int columnThree;
        public int columnFour;
        public int columnFive;
        public String aBC = "abcdefghij";
}