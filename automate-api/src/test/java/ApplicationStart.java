import exce.RunTestListen;
import junit.JunitDamoTest;
import junit.MyTestSuit;
import org.junit.platform.launcher.*;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;

import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;

import static org.junit.platform.engine.discovery.ClassNameFilter.includeClassNamePatterns;
import static org.junit.platform.engine.discovery.DiscoverySelectors.*;
import static org.junit.platform.launcher.TagFilter.excludeTags;
import static org.junit.platform.launcher.TagFilter.includeTags;

public class ApplicationStart {

    public static void main(String[] args) {
        File classesDir = new File("target/test-classes/junit");
        Path  d = Paths.get(classesDir.toURI());
        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
                .selectors(
                       // selectPackage("junit")
                        //selectClasspathRoots(Collections.singleton(Paths.get(classesDir.toURI())))
  //                      selectClass(JunitDamoTest.class)
                        selectClasspathRoots(new HashSet<>(Arrays.asList(
                                Paths.get("target/test-classes/junit/")
                               //,
//                                //Paths.get("src/main/resources/Calculator-1.0-SNAPSHOT-tests")
                               )))

                )
               .filters(

//                        includeEngines("junit-jupiter", "spek"),
//                        // excludeEngines("junit-vintage"),
                includeTags("A"),
                excludeTags("B")
               // includeClassNamePatterns(".*Test")
                // includeClassNamePatterns("org\.example\.tests.*")
        )
                // .configurationParameter("key1", "value1")
                // .configurationParameters(configParameterMap)
                .build();




            Launcher launcher = LauncherFactory.create();
            TestPlan plan = launcher.discover(request);


        Path reportsDir = Paths.get("target", "xml-reports");
        PrintWriter out = new PrintWriter(System.out);

            // Executing tests
        TestExecutionListener listener = new SummaryGeneratingListener();
//        TestExecutionListener le =  new LegacyXmlReportGeneratingListener(reportsDir, out);
        RunTestListen list = new RunTestListen();
            launcher.registerTestExecutionListeners(listener,list);
            launcher.execute(request,listener);


    }
}


