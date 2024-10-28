import java.security.InvalidParameterException;

public class MethodMan {
    // Instance variables - no need to initialize them, they have default value by type.
    public volatile String test;
    public final String Test2 = "Test";
    public transient  String Test3;

    // throws is for documentation reasons only
    public final void playWithMethodSignature(String name) throws InterruptedException, InvalidParameterException
    {
        // Local variable - you need to initialize it before you use it.
        final int num = 5;
    }

    public void playWithVarArgsVariableArguments(String input1, String... otherInputs) {
        System.out.println(input1);
        for (var input : otherInputs) {
            System.out.println(input);
        }
    }
}
