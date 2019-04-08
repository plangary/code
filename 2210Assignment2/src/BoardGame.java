public class BoardGame {

    char[][] gameBoard;

    private int board_size;
    private int empty_positions;
    private int max_levels;

    /**
     * sets all values in game board to green
     *
     * @param board_size
     * @param empty_positions
     * @param max_levels
     */

    public BoardGame(int board_size, int empty_positions, int max_levels) {

        this.board_size = board_size;
        this.empty_positions = empty_positions;
        this.max_levels = max_levels;

        gameBoard = new char[board_size][board_size];
        for (int i = 0; i < board_size; i++) {
            for (int j = 0; j < board_size; j++) {
                gameBoard[i][j] = 'g';
            }
        }


    }

    /**
     * returns dictionary object
     *
     * @return
     */

    public HashDictionary makeDictionary() {
        HashDictionary dict = new HashDictionary(9887);
        return dict;

    }

    /**
     * checks if the value provided is in dictionary. Returns associated score if true
     *
     * @param dict
     * @return
     */

    public int isRepeatedConfig(HashDictionary dict) {
        String temp = "";
        temp = gameBoard.toString();
        for (int i = 0; i < board_size; i++) {
            for (int j = 0; j < board_size; j++) {
                temp += gameBoard[i][j];

            }


        }
        return dict.getScore(temp);

    }

    /**
     * insert provided values into in dictionary
     *
     * @param dict
     * @param score
     */
    public void putConfig(HashDictionary dict, int score) {
        String temp = "";
        temp = gameBoard.toString();
        for (int i = 0; i < board_size; i++) {
            for (int j = 0; j < board_size; j++) {
                temp += gameBoard[i][j];
            }

        }
        Configuration config = new Configuration(temp, score);
        dict.put(config);

    }

    /**
     * stores symbol at specided row and column
     *
     * @param row
     * @param col
     * @param symbol
     */
    public void savePlay(int row, int col, char symbol) {
        gameBoard[row][col] = symbol;
    }

    /**
     * retruns true if at specified row and column is empty
     *
     * @param row
     * @param col
     * @return
     */
    public boolean positionIsEmpty(int row, int col) {
        return gameBoard[row][col] == 'g';
    }

    /**
     * returns true if specified positon is 'o'
     *
     * @param row
     * @param col
     * @return
     */

    public boolean tileOfComputer(int row, int col) {
        return gameBoard[row][col] == 'o';
    }

    /**
     * returns true if specified tile is blue
     *
     * @param row
     * @param col
     * @return
     */

    public boolean tileOfHuman(int row, int col) {
        return gameBoard[row][col] == 'b';
    }

    public boolean wins(char symbol) { //check for win by calling all check methods
        int flag = 0;
        for (int i = 0; i < board_size; i++) {
            for (int j = 0; j < board_size; j++) {
                if (gameBoard[i][j] == symbol) {
                    if (getCol(j, symbol)) {
                        return true;
                    }
                    else if (getRow(j, symbol)) {
                        flag = 1;
                    }
                    else if (getDiagonalOne(symbol)) {
                        flag = 1;
                    }
                    else if (getDiagonalTwo(symbol)) {
                        flag = 1;
                    }

                }
            }
        }
        if (flag == 1) {
            return true;
        }
        return false;
    }

    private boolean getRow(int col, char symbol) { // check for win in row
        for (int i = 0; i < board_size; i++) {
            if (gameBoard[i][col] != symbol) {
                return false;
            }
        }
        return true;
    }

    private boolean getCol(int row, char symbol) { //check for win in column

        for (int i = 0; i < board_size; i++) {
            if (gameBoard[row][i] != symbol) {
                return false;
            }
        }
        return true;
    }

    private boolean getDiagonalOne(char symbol) { //check for left diagonal win
        for (int i = 0; i < board_size; i++) {

            if (gameBoard[i][(board_size - 1) - i] != symbol) {
                return false;
            }
        }
        return true;
    }

    private boolean getDiagonalTwo(char symbol) { //check for right diagional win
        int count = 0;
        for (int i = 0; i < board_size; i++) {
            if (gameBoard[i][i] != symbol) {
                return false;
            }
        }
        return true;
    }


    public boolean isDraw(char symbol, int empty_positions) { // checks if draw
        return false;
    }

    public int evalBoard(char symbol, int empty_positions) { //evaluates board and returns associated score
        if (wins('o')) {
            return 3;
        } else if (wins('b')) {
            return 0;
        } else if (isDraw(symbol, empty_positions)) {
            return 2;
        } else {
            return 1;
        }

    }
}
