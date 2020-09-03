package address.formatter;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddressParserTest {

    @ParameterizedTest
    @MethodSource("address.formatter.AddressFixture#generalAddressCases")
    public void testParseSimpleStreetNameWithHouseNumber(AddressFixture fixture) {
        Address address = new ParserResolver()
                .resolve(fixture.getRawString())
                .parse();
        assertEquals(fixture.getExpectedAddress().getStreet(), address.getStreet());
        assertEquals(fixture.getExpectedAddress().getHouseNumber(), address.getHouseNumber());
    }

    @ParameterizedTest
    @MethodSource("address.formatter.AddressFixture#startingWithNumberCases")
    public void testParseAddressStartingWithHouseNumber(AddressFixture fixture) {
        Address address = new ParserResolver()
                .resolve(fixture.getRawString())
                .parse();
        assertEquals(fixture.getExpectedAddress().getStreet(), address.getStreet());
        assertEquals(fixture.getExpectedAddress().getHouseNumber(), address.getHouseNumber());
    }

    @ParameterizedTest
    @MethodSource("address.formatter.AddressFixture#prefixNoHouseNumberCases")
    public void testParseAddressWithPrefixedHouseNumbers(AddressFixture fixture) {
        Address address = new ParserResolver()
                .resolve(fixture.getRawString())
                .parse();
        assertEquals(fixture.getExpectedAddress().getStreet(), address.getStreet());
        assertEquals(fixture.getExpectedAddress().getHouseNumber(), address.getHouseNumber());
    }
}