package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.net.TTNetDiagnosisRequest;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public class TTNetDiagnosisRequestBuilderImpl extends TTNetDiagnosisRequest.Builder {
    private static final String TAG = "TTNetDiagnosisRequestBuilderImpl";
    private final TTNetDiagnosisRequest.Callback mCallback;
    private final CronetEngineBase mCronetEngine;
    private final Executor mExecutor;
    private int mMultiNetAction;
    private int mNetDetectType;
    private int mReqType;
    private List<String> mTargets;
    private int mTimeoutMs;

    public TTNetDiagnosisRequestBuilderImpl(TTNetDiagnosisRequest.Callback r1, Executor r2, CronetEngineBase r3) {
        this.mCronetEngine = r3;
        this.mCallback = r1;
        this.mExecutor = r2;
    }

    @Override // com.ttnet.org.chromium.net.TTNetDiagnosisRequest.Builder
    public TTNetDiagnosisRequest build() {
        return this.mCronetEngine.createNetDiagnosisRequest(this.mCallback, this.mExecutor, this.mReqType, this.mTargets, this.mNetDetectType, this.mMultiNetAction, this.mTimeoutMs);
    }

    @Override // com.ttnet.org.chromium.net.TTNetDiagnosisRequest.Builder
    public TTNetDiagnosisRequest.Builder setMultiNetAction(int r1) {
        this.mMultiNetAction = r1;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.TTNetDiagnosisRequest.Builder
    public TTNetDiagnosisRequest.Builder setNetDetectType(int r1) {
        this.mNetDetectType = r1;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.TTNetDiagnosisRequest.Builder
    public TTNetDiagnosisRequest.Builder setRequestType(int r1) {
        this.mReqType = r1;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.TTNetDiagnosisRequest.Builder
    public TTNetDiagnosisRequest.Builder setTargets(List<String> r1) {
        this.mTargets = r1;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.TTNetDiagnosisRequest.Builder
    public TTNetDiagnosisRequest.Builder setTimeout(int r1) {
        this.mTimeoutMs = r1;
        return this;
    }
}
