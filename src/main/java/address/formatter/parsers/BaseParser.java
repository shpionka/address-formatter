package address.formatter.parsers;

import address.formatter.Address;
import address.formatter.IParser;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class BaseParser implements IParser {

    private static final int DEFAULT_STREET_GROUP = 1;
    private static final int DEFAULT_HOUSE_GROUP = 2;

    protected final String input;
    protected final Pattern pattern;

    private final int streetGroup;
    private final int houseGroup;

    public BaseParser(String input, Pattern pattern, Integer streetGroup, Integer houseGroup) {
        this.input = input;
        this.pattern = pattern;
        this.streetGroup = Objects.requireNonNullElse(streetGroup, DEFAULT_STREET_GROUP);
        this.houseGroup = Objects.requireNonNullElse(houseGroup, DEFAULT_HOUSE_GROUP);;
    }

    public BaseParser(String input, Pattern pattern) {
        this(input, pattern, null, null);
    }

    public Address parse() {
        final Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            final String houseNumber = matcher.group(houseGroup).trim();
            final String street = matcher.group(streetGroup).trim();

            return new Address(street, houseNumber);
        } else {
            throw new IllegalArgumentException("Unable to parse an address!");
        }
    }
}
