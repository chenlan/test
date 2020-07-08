//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package exce;

import org.junit.platform.engine.TestExecutionResult;
import org.junit.platform.engine.reporting.ReportEntry;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestIdentifier;
import org.junit.platform.launcher.TestPlan;


public class RunTestListen implements TestExecutionListener {
    private TestPlan testPlan;

    public RunTestListen() {
    }

    @Override
    public void testPlanExecutionStarted(TestPlan testPlan) {
        System.out.println("start testPlan-------");
    }

    @Override
    public void testPlanExecutionFinished(TestPlan testPlan) {
        System.out.println("finish testPlan---------");
    }

    @Override
    public void dynamicTestRegistered(TestIdentifier testIdentifier) {
        System.out.println("dynamicTestRegistered");
    }

    @Override
    public void executionSkipped(TestIdentifier testIdentifier, String reason) {
        System.out.println("executionSkipped");
    }

    @Override
    public void executionStarted(TestIdentifier testIdentifier) {
        System.out.println("executionStarted:"+testIdentifier.getDisplayName());
    }

    @Override
    public void executionFinished(TestIdentifier testIdentifier, TestExecutionResult testExecutionResult) {
        System.out.println(testExecutionResult.getStatus().toString());
        System.out.println("executionFinished:"+testIdentifier.getDisplayName());
    }

    @Override
    public void reportingEntryPublished(TestIdentifier testIdentifier, ReportEntry entry) {
        System.out.println("reportingEntryPublicshe");
    }
}
