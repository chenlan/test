package junit;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SuiteDisplayName;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SuiteDisplayName("JUnit Platform Suite Demo")
@SelectClasses({
        JunitDamoTest.class
})
//@SelectPackages("junit")
//@IncludeClassNamePatterns({"^.*ATests?$"})
@IncludeTags("D")
public class TestSuitB {
}
