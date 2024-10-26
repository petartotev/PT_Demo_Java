package DataTypes;

public class StringDogg {
    public final String GREATEST_RAPPER = "Snoop Dogg";

    public void PlayWithTextBlocks() {
        String myTextBlockEndingWithNewLine = """
                   This is some test to try out TextBlock-s.
                       This goes a little to the right!
                """;
        System.out.println(myTextBlockEndingWithNewLine + "Hello!");

        String myTextBlockEndingOnSameLine = """
                   This is some test to try out TextBlock-s.
                       This goes a little to the right!""";
        System.out.println(myTextBlockEndingOnSameLine + "Hello!");
    }
}
