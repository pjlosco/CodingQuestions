import org.junit.Assert;
import org.junit.Test;

public class RemoveAlternateDupesTest {

    RemoveAlternateDupes removeAlternateDupes = new RemoveAlternateDupes();

    @Test
    public void inputTest() {
        String input = "you got beautiful eyes";
        String output = "you gtbeaiful es";
        Assert.assertEquals(removeAlternateDupes.activate(input), output);
    }
}
