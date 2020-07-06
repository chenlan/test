package junit;
/*
 * Copyright 2015-2020 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * https://www.eclipse.org/legal/epl-v20.html
 */


// tag::imports[]
import static org.junit.platform.engine.discovery.ClassNameFilter.includeClassNamePatterns;
import static org.junit.platform.engine.discovery.DiscoverySelectors.selectClass;
import static org.junit.platform.engine.discovery.DiscoverySelectors.selectPackage;

import exce.RunTestListen;
import org.junit.jupiter.api.Tag;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.launcher.listeners.TestExecutionSummary;
// end::imports[]

/**
 * @since 5.0
 */
public class UsingLauncherDemo {

//    @org.junit.jupiter.api.Test
//    @SuppressWarnings("unused")
//    void discovery() {
//        // @formatter:off
//        // tag::discovery[]
//        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
//                .selectors(
//                        selectPackage("junit")
//                        //,
//                        //selectClass(MyTestClass.class)
//                )
//                .filters(
//                        includeClassNamePatterns(".*Test")
//                )
//                .build();
//
//        Launcher launcher = LauncherFactory.create();
//
//        TestPlan testPlan = launcher.discover(request);
//        // end::discovery[]
//        // @formatter:on
//    }

    @org.junit.jupiter.api.Test
    @Tag("siutB")
    void execution() {
        // @formatter:off
        // tag::execution[]
        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
                .selectors(
                        selectPackage("junit")//,
                //        selectClass(MyTestClass.class)
                )
                .filters(
                        includeClassNamePatterns(".*Test")
                )
                .build();

        Launcher launcher = LauncherFactory.create();

        // Register a listener of your choice
        SummaryGeneratingListener listener = new SummaryGeneratingListener();
        RunTestListen RunTestListen = new RunTestListen();
        launcher.registerTestExecutionListeners(listener);
        launcher.registerTestExecutionListeners(RunTestListen);
        launcher.execute(request);

        TestExecutionSummary summary = listener.getSummary();
        // Do something with the TestExecutionSummary.
        System.out.println(summary.getTestsSucceededCount());

        // end::execution[]
        // @formatter:on
    }

//    @org.junit.jupiter.api.Test
//    void launcherConfig() {
//        Path reportsDir = Paths.get("target", "xml-reports");
//        PrintWriter out = new PrintWriter(System.out);
//        // @formatter:off
//        // tag::launcherConfig[]
//        LauncherConfig launcherConfig = LauncherConfig.builder()
//                .enableTestEngineAutoRegistration(false)
//                .enableTestExecutionListenerAutoRegistration(false)
//               // .addTestEngines(new CustomTestEngine())
//              //  .addTestExecutionListeners(new LegacyXmlReportGeneratingListener(reportsDir, out))
//                .addTestExecutionListeners(new CustomTestExecutionListener())
//                .build();
//
//        Launcher launcher = LauncherFactory.create(launcherConfig);
//
//        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
//                .selectors(selectPackage("junit"))
//                .build();
//
//        launcher.execute(request);
//    }
//
}

