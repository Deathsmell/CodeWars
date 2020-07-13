package pathfinder;

import java.util.Arrays;

public class Maze {
    private enum Directions {
        LEFT, RIGHT, UP, DOWN, STARTPOINT
    }

    private static boolean find(String[][] maze, int y, int x, Directions directions) {
        System.out.println(convertDobleStringArrayToString(maze));
        boolean valid = false;
        if (x == maze[maze.length - 1].length - 1 && y == maze.length - 1) {
            return true;
        } else {
            if (Directions.LEFT != directions && maze[y].length - 1 != x && maze[y][x + 1].equals(".")) {
                maze[y][x] = "R";
                valid = find(maze, y, x + 1, Directions.RIGHT); // right
                if (valid) return true;
            }
            if (Directions.UP != directions && y != maze.length - 1 && maze[y + 1][x].equals(".")) {
                maze[y][x] = "D";
                if (y != 0 && maze[y - 1].length > x && validD(maze[y - 1][x])) maze[y - 1][x] = "D";
                valid = find(maze, y + 1, x, Directions.DOWN); // down
                if (valid) return true;
            }

            if (Directions.RIGHT != directions && x != 0 && maze[y][x - 1].equals(".")) {
                maze[y][x] = "L";
                valid = find(maze, y, x - 1, Directions.LEFT); // left
                if (valid) return true;
            }
            if (Directions.DOWN != directions && y != 0 && maze[y - 1][x].equals(".")) {
                maze[y][x] = "U";
                valid = find(maze, y - 1, x, Directions.UP); // up
                if (valid) return true;
            }
        }
        return false;
    }

    private static boolean validD(String string) {
        if (string.equals(".")) return false;
        if (string.equals("W")) return false;
        return !string.equals("D");
    }

    private static int count(String[][] maze) {
        int count = 0;
        int x = 0, y = 0;
        int endY = maze.length - 1, endX = maze[endY].length - 1;
        while (y != endY || x != endX) {
            switch (maze[y][x]) {
                case "D":
                    y++;
                    count++;
                    break;
                case "R":
                    x++;
                    count++;
                    break;
                case "U":
                    y--;
                    count++;
                    break;
                case "L":
                    x--;
                    count++;
                    break;
            }
        }
        return count;
    }

    public static boolean havePath(String maze) {
        return find(convertToDoubleStringArray(maze), 0, 0, Directions.STARTPOINT);
    }

    public static boolean havePath(String[][] maze) {
        return find(maze, 0, 0, Directions.STARTPOINT);
    }


    // FIXME: Make algorithm find short path. Now algorithm find not optimise path
    @Deprecated
    public static int shortPath(String maze) {
        String[][] strings = convertToDoubleStringArray(maze);
        boolean valid = find(strings, 0, 0, Directions.STARTPOINT);
        if (valid) {
            return count(strings);
        } else {
            return -1;
        }

    }

    private static String[][] convertToDoubleStringArray(String maze) {
        return Arrays.stream(maze.split("\n"))
                .map(string -> string.split(""))
                .toArray(String[][]::new);
    }

    private static String convertDobleStringArrayToString(String[][] maze) {
        StringBuilder builder = new StringBuilder();
        for (String[] strings : maze) {
            for (String string : strings) {
                builder.append(string);
            }
            builder.append("\n");
        }
        return builder.toString();
    }

}
