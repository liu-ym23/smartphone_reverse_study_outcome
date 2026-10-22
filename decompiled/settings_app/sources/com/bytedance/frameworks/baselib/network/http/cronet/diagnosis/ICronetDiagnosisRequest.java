package com.bytedance.frameworks.baselib.network.http.cronet.diagnosis;

/* JADX INFO: loaded from: classes3.dex */
public interface ICronetDiagnosisRequest {

    public interface Callback {
        void onNetDiagnosisRequestComplete(String r1);
    }

    void cancel();

    void doExtraCommand(String r1, String r2);

    void start();
}
