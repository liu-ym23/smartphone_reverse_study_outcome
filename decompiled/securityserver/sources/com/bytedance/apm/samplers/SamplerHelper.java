package com.bytedance.apm.samplers;

/* JADX INFO: loaded from: classes.dex */
public class SamplerHelper {
    private static ISampleCheck sSampler;

    static {
        sSampler = new EmptySampler();
    }

    public SamplerHelper() {
    }

    public static boolean getLogTypeSwitch(String r1) {
        return sSampler.getLogTypeSwitch(r1);
    }

    public static boolean getMetricSwitch(String r1) {
        return sSampler.getMetricSwitch(r1);
    }

    public static boolean getPerfAllowSwitch(String r1) {
        return sSampler.getPerfAllowSwitch(r1);
    }

    public static boolean getPerfFpsAllowSwitch(String r1, String r2) {
        return sSampler.getPerfFpsAllowSwitch(r1, r2);
    }

    public static boolean getPerfSecondStageSwitch(String r1) {
        return sSampler.getPerfSecondStageSwitch(r1);
    }

    public static boolean getServiceSwitch(String r1) {
        return sSampler.getServiceSwitch(r1);
    }

    public static void setSampler(ISampleCheck r0) {
        sSampler = r0;
    }
}
