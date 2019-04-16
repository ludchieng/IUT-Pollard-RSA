import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	Pollard1Test.class,
	Pollard2Test.class,
	Pollard3Test.class
})

public class AllTests {

}
