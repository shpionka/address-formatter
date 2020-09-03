package address.formatter;

import junit.framework.TestCase;
import org.junit.Assert;

public class AddressParserTest extends TestCase {

    public void testParseSimpleStreetNameWithHouseNumber() {
        String input = "Winterallee 3";
        Address address = new ParserResolver()
                .resolve(input)
                .parse();
        Assert.assertEquals("Winterallee", address.getStreet());
        Assert.assertEquals("3", address.getHouseNumber());
    }

    public void testParseAddressStartingWithHouseNumber() {
        String input = "200 Broadway Av";
        Address address = new ParserResolver()
                .resolve(input)
                .parse();
        Assert.assertEquals("Broadway Av", address.getStreet());
        Assert.assertEquals("200", address.getHouseNumber());

    }
}