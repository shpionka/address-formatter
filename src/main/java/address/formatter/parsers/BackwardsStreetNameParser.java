package address.formatter.parsers;

import java.util.regex.Pattern;

public class BackwardsStreetNameParser extends BaseParser {

    private static final Pattern MEDIUM_PATTERN = Pattern.compile("(\\d+)(.+)");

    public BackwardsStreetNameParser(String input) {
        super(input, MEDIUM_PATTERN, 2, 1);
    }
}
