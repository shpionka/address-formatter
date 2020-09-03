package address.formatter;

public class AddressFixture {

    public static AddressFixture[] generalAddressCases(){
        return new AddressFixture[]{
                new AddressFixture(new Address("Winterallee", "3"), "Winterallee 3"),
                new AddressFixture(new Address("Musterstrasse", "45"), "Musterstrasse 45"),
                new AddressFixture(new Address("Blaufeldweg", "123B"), "Blaufeldweg 123B"),
                new AddressFixture(new Address("Am Bächle", "23"), "Am Bächle 23"),
                new AddressFixture(new Address("Auf der Vogelwiese", "23 b"), "Auf der Vogelwiese 23 b"),
                new AddressFixture(new Address("Test alle", "2ABC"), "Test alle 2ABC"),
                new AddressFixture(new Address("Calle Aduana", "29"), "Calle Aduana, 29")
        };
    }

    public static AddressFixture[] startingWithNumberCases(){
        return new AddressFixture[]{
                new AddressFixture(new Address("rue de la revolution", "4"), "4, rue de la revolution"),
                new AddressFixture(new Address("Broadway Av", "200"), "200 Broadway Av"),
                new AddressFixture(new Address("Broadway Av", "200"), "200 Broadway Av"),
        };
    }

    public static AddressFixture[] prefixNoHouseNumberCases(){
        return new AddressFixture[]{
                new AddressFixture(new Address("rue de la revolution", "4"), "4, rue de la revolution"),
                new AddressFixture(new Address("Broadway Av", "200"), "200 Broadway Av"),
        };
    }

    public AddressFixture(Address expectedAddress, String rawString) {
        this.expectedAddress = expectedAddress;
        this.rawString = rawString;
    }

    private Address expectedAddress;

    private String rawString;

    public Address getExpectedAddress() {
        return expectedAddress;
    }

    public String getRawString() {
        return rawString;
    }
}
