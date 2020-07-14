package pathfinder;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class TestFinder {

    public static int pathFinder(String maze) {
        return new TestFinder().find(maze);
    }

    private char[][] aMaze;
    private int[][] steps;
    private Queue<int[]> front;
    private int goal;

    public int find(String maze) {

        String[] rows = maze.split("\n");
        aMaze = Arrays.stream(rows).map(String::toCharArray).toArray(char[][]::new);

        steps = new int[aMaze.length][];
        for (int i = 0; i < aMaze.length; ++i)
            steps[i] = new int[aMaze.length];

        steps[0][0] = 1;
        front = new ArrayDeque<>();
        front.add(new int[] { 0, 0 });

        goal = aMaze.length - 1;

        while (!front.isEmpty()) {

            int[] c = front.poll();

            if (c[0] == goal && c[1] == goal)
                return steps[goal][goal] - 1;

            int step = steps[c[0]][c[1]] + 1;
            tryStep(c[0] - 1, c[1], step);
            tryStep(c[0] + 1, c[1], step);
            tryStep(c[0], c[1] - 1, step);
            tryStep(c[0], c[1] + 1, step);

        }
        return -1;
    }

    private void tryStep(int r, int c, int v) {

        if(r < 0 || r > goal || c < 0 || c > goal || steps[r][c] != 0)
            return;

        if (aMaze[r][c] == '.') {
            steps[r][c] = v;
            front.add(new int[] { r, c });
        }
    }
}