package address.formatter;

import address.formatter.parsers.BackwardsStreetNameParser;
import address.formatter.parsers.GeneralAddressParcer;
import address.formatter.parsers.PrefixedHouseNumberAddressParser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;

public class ParserResolverTest {

    @ParameterizedTest
    @ValueSource(strings = {"Winterallee 3", "Musterstrasse 45", "Blaufeldweg 123B", "Testallee 42", "Testallee 42a", "Testallee 42ab cd"})
    public void testResolveParserForStringWithNumber(String input) {
        IParser parser = new ParserResolver().resolve(input);
        assertThat(parser, instanceOf(GeneralAddressParcer.class));
    }

    @ParameterizedTest
    @ValueSource(strings = {"4, rue de la revolution", "200 Broadway Av", "200 Broadway 2d Av"})
    public void testResolveParserForStreetStartingWithNumber() {
        IParser parser = new ParserResolver().resolve("42 Testallee");
        assertThat(parser, instanceOf(BackwardsStreetNameParser.class));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Calle 39 No 1540", "Calle 39 No1540", "Calle 39 no 1540"})
    public void testResolvedPrefixeNubmberParser() {
        IParser parser = new ParserResolver().resolve("Test 5 allee No 5");
        assertThat(parser, instanceOf(PrefixedHouseNumberAddressParser.class));
    }

    @Test
    public void testFailsToResolveParserForInvalidString() {
        IParser parser = new ParserResolver().resolve("noop");
        assertThat(parser, instanceOf(GeneralAddressParcer.class));
    }
}