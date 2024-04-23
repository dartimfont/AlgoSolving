package org.example;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidSudoku36 {

    public static boolean isValidSudoku(char[][] board) {

        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> columns = new HashMap<>();
        Map<String, Set<Character>> boxes = new HashMap<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }

                String keyBoxes = String.format("%s, %s", i / 3, j / 3);

                if (!rows.containsKey(i)) {
                    rows.put(i, new HashSet<>());
                }
                if (!columns.containsKey(j)) {
                    columns.put(j, new HashSet<>());
                }
                if (!boxes.containsKey(keyBoxes)) {
                    boxes.put(keyBoxes, new HashSet<>());
                }

                if (rows.get(i).contains(board[i][j])) {
                    return false;
                }
                if (columns.get(j).contains(board[i][j])) {
                    return false;
                }
                if (boxes.get(keyBoxes).contains(board[i][j])) {
                    return false;
                }

                rows.get(i).add(board[i][j]);
                columns.get(j).add(board[i][j]);
                boxes.get(keyBoxes).add(board[i][j]);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(
                isValidSudoku(new char[][]{
                        {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                        {'.', '.', '.', '.', '8', '.', '.', '7', '9'},
                })
        );
    }
}
