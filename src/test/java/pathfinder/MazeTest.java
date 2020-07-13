package pathfinder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MazeTest {

    String pyramidMaze =
            ".\n" +
            "..\n" +
            "..\n" +
            ".W.\n" +
            ".W.\n" +
            "...\n" +
            "....\n" +
            "....\n" +
            ".W..\n" +
            "WWW.\n" +
            "....W\n" +
            "....W\n" +
            "..W..\n" +
            "....W\n" +
            "W.W..";

    String snakeMaze = ".W...\n" +
            ".W...\n" +
            ".W.W.\n" +
            "...W.\n" +
            "...W.";


    String[][] maze = new String[][]{
            {".", ".", "W", ".", ".", ".", "W", ".", ".", ".",},
            {"W", ".", ".", ".", "W", ".", "W", ".", "W", ".",},
            {"W", "W", "W", "W", ".", ".", ".", ".", ".", "W",},
            {"W", ".", ".", ".", ".", "W", ".", "W", ".", ".",},
            {".", ".", "W", "W", "W", "W", ".", "W", "W", ".",},
            {"W", ".", ".", ".", "W", "W", ".", ".", ".", ".",},
            {".", "W", "W", ".", ".", ".", ".", "W", "W", "W",},
            {".", ".", ".", ".", "W", "W", "W", ".", ".", ".",},
            {".", "W", "W", "W", ".", ".", ".", ".", "W", "W",},
            {".", ".", ".", ".", ".", "W", "W", ".", ".", ".",},
    };

    String a = ".W.\n" +
            ".W.\n" +
            "...";

    String b = ".W.\n" +
            ".W.\n" +
            "W..";

    String c = "......\n" +
            "......\n" +
            "......\n" +
            "......\n" +
            "......\n" +
            "......";

    String d = "......\n" +
            "......\n" +
            "......\n" +
            "......\n" +
            ".....W\n" +
            "....W.";

    String g = "........\n" +
            "..W.W.W.\n" +
            ".....WW.\n" +
            "W.WW....\n" +
            "......WW\n" +
            "W.......\n" +
            "W.W.W...\n" +
            "W.W..W..";

    @Test
    public void finderWithString() {
        assertTrue(Maze.havePath(a));
        assertFalse(Maze.havePath(b));
        assertTrue(Maze.havePath(c));
        assertFalse(Maze.havePath(d));
    }

    @Test
    public void finderCountWithString() {
        assertEquals( 4,  Maze.shortPath(a));
        assertEquals( -1, Maze.shortPath(b));
        assertEquals( 10,  Maze.shortPath(c));
        assertEquals( -1, Maze.shortPath(d));
    }

    @Test
    public void count () {
        assertEquals(14,Maze.shortPath(g));
    }

    @Test
    public void finderWithStringArray() {
        assertTrue(Maze.havePath(maze));
    }

    @Test
    public void snakeMaze(){
        assertTrue(Maze.havePath(snakeMaze));
    }

    @Test
    public void PyramidMaze (){
        assertTrue(Maze.havePath(pyramidMaze));
    }

    @Test
    public void shortPathInPyramidMaze (){
        assertEquals(18,Maze.shortPath(pyramidMaze));
    }

    @Test
    public void shortPathInSnakeMaze (){
        assertEquals(12,Maze.shortPath(snakeMaze));
    }

}