package address.formatter.parsers;

import java.util.regex.Pattern;

public class PrefixedHouseNumberAddressParser extends BaseParser {

    private static final Pattern HARD_PATTERN = Pattern.compile("(.+)(No\\s?\\d+.+|No\\s?\\d+)$");

    public PrefixedHouseNumberAddressParser(String input) {
        super(input, HARD_PATTERN);
    }
}
