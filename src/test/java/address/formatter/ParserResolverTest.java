package address.formatter;

import address.formatter.parsers.BackwardsStreetNameParser;
import address.formatter.parsers.GeneralAddressParcer;
import address.formatter.parsers.PrefixedHouseNumberAddressParser;
import junit.framework.TestCase;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ParserResolverTest extends TestCase {

    public void testResolveParserForStringWithNumber() {
        IParser parser = new ParserResolver().resolve("Testallee 42");
        assertThat(parser, instanceOf(GeneralAddressParcer.class));
    }

    public void testResolveParserForStreetStartingWithNumber() {
        IParser parser = new ParserResolver().resolve("42 Testallee");
        assertThat(parser, instanceOf(BackwardsStreetNameParser.class));
    }

    public void testFailsToResolveParserForInvalidString() {
        IParser parser = new ParserResolver().resolve("Testallee No 5");
        assertThat(parser, instanceOf(PrefixedHouseNumberAddressParser.class));
    }

    public void testFailsToResolveParserForInvalidString1() {
        IParser parser = new ParserResolver().resolve("Test 5 allee No 5");
        assertThat(parser, instanceOf(PrefixedHouseNumberAddressParser.class));
    }
}