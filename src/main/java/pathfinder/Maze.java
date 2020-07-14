package pathfinder;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Maze {
    private enum Directions {
        LEFT, RIGHT, UP, DOWN, STARTPOINT
    }

    private final Queue<int[]> queue = new ArrayDeque<>();
    int[][] steps;

    Maze() {
        queue.add(new int[]{0, 0});
    }

    public static int pathFinder(String maze) {
        return new Maze().find(convertToDoubleStringArray(maze));
    }

    private int find(String[][] maze) {

        steps = new int[maze.length][];
        for (int i = 0; i < maze.length; ++i)
            steps[i] = new int[maze[i].length];

        steps[0][0] = 1;
        queue.add(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int[] coordinate = queue.poll();

            if (coordinate[0] == maze.length - 1 && coordinate[1] == maze[maze.length - 1].length - 1) {
                return steps[maze.length - 1][maze[maze.length - 1].length - 1] - 1;
            }

            int step = steps[coordinate[0]][coordinate[1]] + 1;
            step(maze, coordinate[0] - 1, coordinate[1], step);
            step(maze, coordinate[0] + 1, coordinate[1], step);
            step(maze, coordinate[0], coordinate[1] - 1, step);
            step(maze, coordinate[0], coordinate[1] + 1, step);
        }
        return -1;
    }

    private void step(String[][] maze, int y, int x, int step) {
        if(y < 0 || y > maze.length - 1 || x < 0 || x > maze[maze.length-1].length - 1 || steps[y][x] != 0)
            return;

        if (maze[y][x].equals(".")) {
            steps[y][x] = step;
            queue.add(new int[] { y, x });
        }

    }

    @Deprecated
    private boolean find(String[][] maze, int y, int x, Directions directions) {
        System.out.println(convertToString(maze)); //print steps
        boolean valid = false;
        if (x == maze[maze.length - 1].length - 1 && y == maze.length - 1) {
            return true;
        } else {
            if (Directions.LEFT != directions && maze[y].length - 1 != x && maze[y][x + 1].equals(".")) {
                queue.add(new int[]{y, x + 1});
                maze[y][x] = "R";
                valid = find(maze, y, x + 1, Directions.RIGHT); // right
                if (valid) return true;
            }
            if (Directions.UP != directions && y != maze.length - 1 && maze[y + 1][x].equals(".")) {
                queue.add(new int[]{y + 1, x});
                maze[y][x] = "D";
                if (y != 0 && maze[y - 1].length > x && validD(maze[y - 1][x])) maze[y - 1][x] = "D";
                valid = find(maze, y + 1, x, Directions.DOWN); // down
                if (valid) return true;
            }

            if (Directions.RIGHT != directions && x != 0 && maze[y][x - 1].equals(".")) {
                queue.add(new int[]{y, x - 1});
                maze[y][x] = "L";
                valid = find(maze, y, x - 1, Directions.LEFT); // left
                if (valid) return true;
            }
            if (Directions.DOWN != directions && y != 0 && maze[y - 1][x].equals(".")) {
                queue.add(new int[]{y - 1, x});
                maze[y][x] = "U";
                valid = find(maze, y - 1, x, Directions.UP); // up
                return valid;
            }
        }
        return false;
    }

    private boolean validD(String string) {
        if (string.equals(".")) return false;
        if (string.equals("W")) return false;
        return !string.equals("D");
    }

    private int count(String[][] maze) {
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

    public boolean havePath(String maze) {
        return new Maze().find(convertToDoubleStringArray(maze), 0, 0, Directions.STARTPOINT);
    }

    public static boolean havePath(String[][] maze) {
        return new Maze().find(maze, 0, 0, Directions.STARTPOINT);
    }


    // FIXME: Make algorithm find short path. Now algorithm find not optimise path
    @Deprecated
    public static int shortPath(String maze) {
        String[][] strings = convertToDoubleStringArray(maze);
        Maze cl = new Maze();
        boolean valid = cl.find(strings, 0, 0, Directions.STARTPOINT);
        if (valid) {
            return cl.count(strings);
        } else {
            return -1;
        }

    }

    private static String[][] convertToDoubleStringArray(String maze) {
        return Arrays.stream(maze.split("\n"))
                .map(string -> string.split(""))
                .toArray(String[][]::new);
    }

    private static <T> String convertToString(T[][] maze) {
        StringBuilder builder = new StringBuilder();
        for (T[] elems : maze) {
            for (T elem : elems) {
                builder.append(elem);
            }
            builder.append("\n");
        }
        return builder.toString();
    }

    private static String convertToString(int[][] maze) {
        StringBuilder builder = new StringBuilder();
        for (int[] elems : maze) {
            for (int elem : elems) {
                builder.append(elem == 0 ? "0" : Integer.toString(elem));
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}
