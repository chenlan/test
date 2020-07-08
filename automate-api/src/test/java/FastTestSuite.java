import junit.JunitDamoTest;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SuiteDisplayName;
import org.junit.runner.RunWith;
import service.user.UserPoTest;

@RunWith(JUnitPlatform.class)
@SuiteDisplayName("JUnit Platform Suite Demo")
@SelectClasses({
        UserPoTest.class
})
@IncludeTags({"fast"})
public class FastTestSuite {
}
