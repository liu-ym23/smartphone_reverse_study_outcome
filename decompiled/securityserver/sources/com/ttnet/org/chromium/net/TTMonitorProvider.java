package com.ttnet.org.chromium.net;

/* JADX INFO: loaded from: classes2.dex */
public abstract class TTMonitorProvider {
    public TTMonitorProvider() {
    }

    public abstract void handleApiResult(boolean r1, String r2, String r3, String r4, long r5, long r7, long r9, long r11, long r13, long r15, long r17, long r19, long r21, long r23, boolean r25, long r26, long r28, String r30, String r31, String r32, int r33, int r34, String r35);

    public abstract boolean handleApiSample(String r1, String r2);

    public abstract void sendAppMonitorEvent(String r1, String r2);
}
