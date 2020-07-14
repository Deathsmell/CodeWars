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

//    @Test
//    public void finderWithString() {
//        assertTrue(Maze.havePath(a));
//        assertFalse(Maze.havePath(b));
//        assertTrue(Maze.havePath(c));
//        assertFalse(Maze.havePath(d));
//    }

    @Test
    public void finderCountWithString() {
        assertEquals( 4,  Maze.pathFinder(a));
        assertEquals( -1, Maze.pathFinder(b));
        assertEquals( 10,  Maze.pathFinder(c));
        assertEquals( -1, Maze.pathFinder(d));
    }

    @Test
    public void finderCountWithStringFinder() {
//        assertEquals( 4,  TestFinder.pathFinder(a));
        assertEquals( -1, TestFinder.pathFinder(b));
//        assertEquals( 10,  TestFinder.pathFinder(c));
//        assertEquals( -1, TestFinder.pathFinder(d));
    }


    @Test
    public void count () {
        assertEquals(14,Maze.shortPath(g));
    }

    @Test
    public void finderWithStringArray() {
        assertTrue(Maze.havePath(maze));
    }

//    @Test
//    public void snakeMaze(){
//        assertTrue(Maze.havePath(snakeMaze));
//    }
//
//    @Test
//    public void PyramidMaze (){
//        assertTrue(Maze.havePath(pyramidMaze));
//    }

    @Test
    public void shortPathInPyramidMaze (){
        assertEquals(18,Maze.pathFinder(pyramidMaze));
    }

    @Test
    public void shortPathInSnakeMaze (){
        assertEquals(12,Maze.pathFinder(snakeMaze));
    }


}