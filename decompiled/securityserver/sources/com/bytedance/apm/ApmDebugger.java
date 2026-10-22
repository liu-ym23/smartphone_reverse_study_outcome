package com.bytedance.apm;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class ApmDebugger {
    private static volatile long sCpuInterval;
    private static AtomicInteger sForceReportBattery;
    private static volatile long sMemInterval;
    private static volatile int sReportInterval;
    private static volatile boolean sSetCpuInterval;
    private static volatile boolean sSetMemInterval;
    private static volatile boolean sSetReportInterval;
    private static volatile boolean sSetTraffic;
    private static volatile int sTraffic;

    static {
        sForceReportBattery = new AtomicInteger(0);
        sReportInterval = 120;
        sSetReportInterval = false;
        sCpuInterval = 100000;
        sSetCpuInterval = false;
        sMemInterval = 100000;
        sSetMemInterval = false;
        sTraffic = 1000;
        sSetTraffic = false;
    }

    public ApmDebugger() {
    }

    public static void endForceReportBattery() {
        sForceReportBattery.decrementAndGet();
    }

    public static void forceReportBattery() {
    }

    public static long getCpuInterval() {
        return sCpuInterval;
    }

    public static long getMemInterval() {
        return sMemInterval;
    }

    public static int getReportInterval() {
        return sReportInterval;
    }

    public static boolean hasCpuInterval() {
        return sSetCpuInterval;
    }

    public static boolean hasMemInterval() {
        return sSetMemInterval;
    }

    public static boolean hasReportInterval() {
        return sSetReportInterval;
    }

    public static void setAsyncTimer(long r0) {
    }

    public static void setBatteryTimer(long r0) {
    }

    public static void setCpuInterval(long r0) {
        sCpuInterval = r0;
        sSetCpuInterval = true;
    }

    public static void setMemInterval(long r0) {
        sMemInterval = r0;
        sSetMemInterval = true;
    }

    public static void setReportInterval(int r0) {
        sReportInterval = r0;
        sSetReportInterval = true;
    }

    public static boolean shouldForceReportBattery() {
        return false;
    }
}
