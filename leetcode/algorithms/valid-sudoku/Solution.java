class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        List<Character> rowElements = new ArrayList<>();
        List<Character> columnElements = new ArrayList<>();
        List<Character> subBoxesElements = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] != '.') {
                    if (rowElements.contains(board[i][j])) return false;
                    rowElements.add(board[i][j]);
                }

                if(board[j][i] != '.') {
                    if (columnElements.contains(board[j][i])) return false;
                    columnElements.add(board[j][i]);
                }

                if(i % 3 == 0 && j % 3 == 0) {
                    int count = 0;
                    while(count < 3) {
                        if(board[i + count][j] != '.') {
                            if (subBoxesElements.contains(board[i + count][j])) return false;
                            subBoxesElements.add(board[i + count][j]);
                        }

                        if(count == 0) {
                            count++;
                            continue;
                        }


                        if(count == 1 && board[i + count][j + 2] != '.') {
                            if (subBoxesElements.contains(board[i + count][j + 2])) return false;
                            subBoxesElements.add(board[i + count][j + 2]);
                        }

                        if(count == 2 && board[i + count][j + 1] != '.') {
                            if (subBoxesElements.contains(board[i + count][j + 1])) return false;
                            subBoxesElements.add(board[i + count][j + 1]);
                        }

                        if(board[i + count][j + count] != '.') {
                            if (subBoxesElements.contains(board[i + count][j + count])) return false;
                            subBoxesElements.add(board[i + count][j + count]);
                        }

                        if(board[i][j + count] != '.') {
                            if (subBoxesElements.contains(board[i][j + count])) return false;
                            subBoxesElements.add(board[i][j + count]);
                        }
                        count++;
                    }
                    subBoxesElements.clear();
                }
            }
            rowElements.clear();
            columnElements.clear();
        }
        return true;
    }
}