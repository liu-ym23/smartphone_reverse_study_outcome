package com.monitor.cloudmessage.callback;

/* JADX INFO: loaded from: classes4.dex */
public interface IABTestConsumer extends IConsumerResultCallback {
    boolean isUpdateABTestInfoInSP();

    void notifyABTestModelUpdate(String r1, Object r2);

    void notifyABTestSPUpdate(String r1, Object r2);
}
