/*******************************************************************************
 * Copyright (c) 2014-2018 Cognizant TriZetto Software Group, Inc. All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Cognizant TriZetto Software Group, Inc.  or its affiliates ("Confidential
 * Information"). You shall not disclose such Confidential Information and
 * shall use it only in accordance with the terms of the license agreement
 * you entered into with Cognizant TriZetto Software Group, Inc. or
 * its predecessor.
 ******************************************************************************/
package com.zopa.qa.util;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Reporter;

public class LoggerUtil
{

    public static Logger log = LogManager.getLogger(LoggerUtil.class.getName());

    /**
     * Returns class name extracted from full class name string
     * @param fullName - full class name string with package info
     */
    public static String getClassNameFromFullName(String fullName) {
        String[] lexems = fullName.split("\\.");
        return lexems[lexems.length - 1];
    }

    public static String formatLogMessage(String fullClassName, String methodName, String message) {
        return String.format("%s.%s - %s", getClassNameFromFullName(fullClassName), methodName, message);
    }

    public static String formatLogMessage(StackTraceElement stackElement, String message) {
        return formatLogMessage(stackElement.getClassName(), stackElement.getMethodName(), message);
    }

    public static void logStackTrace (Throwable thr) {
        log.error(thr.getMessage());
        StringWriter errors = new StringWriter();
        thr.printStackTrace(new PrintWriter(errors));
        log.trace(errors.toString());
    }

    public static void logAndReport(String message){
        message = escapeHtml(message);
        log.info(message);
        Reporter.log(message);
    }

    public static String escapeHtml(String message)
    {
        return message.replace("&", "&amp;").replace("<", "&lt;");
    }
}

