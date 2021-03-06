/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package address.formatter;

public class App {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please pass valid address string!");
            System.exit(1);
        }

        String input = String.join(" ", args);
        IParser parser = new ParserResolver().resolve(input);
        Address parse = parser.parse();
        System.out.println(parse.toString());
    }
}
