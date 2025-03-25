package com.google.utils.listeners;

import com.google.utils.config.ConfigReader;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestPlan;

public class CustomTestExecutionListener implements TestExecutionListener {
    @Override
    public void testPlanExecutionStarted(TestPlan testPlan) {
        ConfigReader.readProperties();
    }

}
