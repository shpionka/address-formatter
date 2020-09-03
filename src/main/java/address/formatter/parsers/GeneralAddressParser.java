package address.formatter.parsers;

import java.util.regex.Pattern;

/**
 * General address parser takes care of standard addresses in format "Streer name 42A"
 */
public class GeneralAddressParser extends BaseParser {

    private static final Pattern SIMPLE_PATTERN = Pattern.compile("(.+?)(\\d+.+|\\d+)");

    public GeneralAddressParser(String input) {
        super(input, SIMPLE_PATTERN);
    }
}