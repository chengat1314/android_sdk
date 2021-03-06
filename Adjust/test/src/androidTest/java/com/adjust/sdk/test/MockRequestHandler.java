package com.adjust.sdk.test;

import com.adjust.sdk.ActivityPackage;
import com.adjust.sdk.IPackageHandler;
import com.adjust.sdk.IRequestHandler;

public class MockRequestHandler implements IRequestHandler {
    private MockLogger testLogger;
    private String prefix = "RequestHandler ";
    IPackageHandler packageHandler;

    public MockRequestHandler(MockLogger testLogger) {
        this.testLogger = testLogger;
    }

    @Override
    public void init(IPackageHandler packageHandler) {
        testLogger.test(prefix + "init");
        this.packageHandler = packageHandler;
    }

    @Override
    public void sendPackage(ActivityPackage pack) {
        testLogger.test(prefix + "sendPackage, " + pack);
        /*
        // respond successfully to the package handler
        if (packageHandler != null && !errorNextSend) {
            packageHandler.sendNextPackage();
        }

        if (packageHandler != null && errorNextSend) {
            testLogger.test(packageHandler.getFailureMessage());
            packageHandler.closeFirstPackage();
        }
        */
    }
}
