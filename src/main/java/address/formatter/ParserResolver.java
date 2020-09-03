package address.formatter;

import address.formatter.parsers.PrefixedHouseNumberAddressParser;
import address.formatter.parsers.BackwardsStreetNameParser;
import address.formatter.parsers.GeneralAddressParcer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParserResolver {

    // A regular expression to check if an input starts with a number
    public static final Pattern numberPattern = Pattern.compile("\\d+");


    // A regular expression
    public static final Pattern numberPrefixPattern = Pattern.compile("No\\s?\\d+.*$");

    public IParser resolve(String input){
        final Matcher matcher = numberPattern.matcher(input);
        final Matcher noPrefixMatcher = numberPrefixPattern.matcher(input);

        boolean startsWithNumber = matcher.lookingAt();


        boolean includesNoPrefix = noPrefixMatcher.find();

        if (includesNoPrefix) {
            return new PrefixedHouseNumberAddressParser(input);
        } else if (startsWithNumber) {
            return new BackwardsStreetNameParser(input);
        } else {
            return new GeneralAddressParcer(input);
        }
    }

}
