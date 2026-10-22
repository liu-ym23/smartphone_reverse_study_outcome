package com.bytedance.ttnet.diagnosis;

/* JADX INFO: loaded from: classes3.dex */
public interface IDiagnosisRequest {
    void cancel();

    void doExtraCommand(String r1, String r2);

    void setUserExtraInfo(String r1);

    void start(IDiagnosisCallback r1);
}
