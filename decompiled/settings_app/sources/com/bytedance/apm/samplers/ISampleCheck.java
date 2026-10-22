package com.bytedance.apm.samplers;

/* JADX INFO: loaded from: classes3.dex */
public interface ISampleCheck {
    boolean getLogTypeSwitch(String r1);

    boolean getMetricSwitch(String r1);

    boolean getPerfAllowSwitch(String r1);

    boolean getPerfFpsAllowSwitch(String r1, String r2);

    boolean getPerfSecondStageSwitch(String r1);

    boolean getServiceSwitch(String r1);
}
