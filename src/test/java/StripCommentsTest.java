
import org.junit.jupiter.api.Test;
import strings.Strings;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * @author Marko Bekhta
 */
public class StripCommentsTest {

    private static final Random RANDOM = new Random();

    @Test
    public void stripComments() throws Exception {
        assertEquals(
                "apples, pears\ngrapes\nbananas",
                Strings.stripComments( "apples, pears # and bananas\ngrapes\nbananas !apples", new String[] { "#", "!" } )
        );

        assertEquals(
                "a\nc\nd",
                Strings.stripComments( "a #b\nc\nd $e f g", new String[] { "#", "$" } )
        );

    }

    @Test
    public void edges() throws Exception {
        assertEquals(
                "a\n b\nc",
                Strings.stripComments( "a \n b \nc ", new String[] { "#", "$" } )
        );
        assertEquals(
                "a",
                Strings.stripComments( "a", new String[] { "1" } )
        );

        assertEquals(
                "",
                Strings.stripComments( "a", new String[] { "a" } )
        );

        assertEquals(
                "",
                Strings.stripComments( "            ", new String[] { "#" } )
        );

        assertEquals(
                "",
                Strings.stripComments( "# some text", new String[] { "#" } )
        );
    }

    @Test
    public void random() throws Exception {
        String[] comments = { "#", "$", "!", "-" };
        for ( int i = 0; i < 20; i++ ) {
            String test = randomString().replace( "1", comments[RANDOM.nextInt( 4 )] )
                    .replace( "0", "\n" )
                    .replaceAll( "\n+$", "" );
            assertEquals( stripComments( test, comments ), Strings.stripComments( test, comments ) );
        }
    }

    private static String randomString() {
        return new BigInteger( 1000, RANDOM ).toString( 16 )
                .replaceAll( "[2-9]+", "\n\n" );
    }

    private static String stripComments(String text, String[] commentSymbols) {
        String pattern = String.format(
                "[ ]*([%s].*)?$",
                String.join("", commentSymbols)
        );
        return Arrays.stream( text.split( "\n" ) )
                .map( x -> x.replaceAll( pattern, "" ) )
                .collect( Collectors.joining( "\n" ) );
    }
}