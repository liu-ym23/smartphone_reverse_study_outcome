package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.net.BidirectionalStream;
import com.ttnet.org.chromium.net.ExperimentalBidirectionalStream;
import com.ttnet.org.chromium.net.ExperimentalCronetEngine;
import com.ttnet.org.chromium.net.ExperimentalUrlRequest;
import com.ttnet.org.chromium.net.RequestFinishedInfo;
import com.ttnet.org.chromium.net.TTNetDiagnosisRequest;
import com.ttnet.org.chromium.net.TTWebsocketConnection;
import com.ttnet.org.chromium.net.UrlRequest;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes5.dex */
public abstract class CronetEngineBase extends ExperimentalCronetEngine {
    protected static final long DEFAULT_NETWORK_HANDLE = -1;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Idempotency {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface RequestPriority {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface StreamPriority {
    }

    protected abstract ExperimentalBidirectionalStream createBidirectionalStream(String r1, BidirectionalStream.Callback r2, Executor r3, String r4, List<Map.Entry<String, String>> r5, int r6, boolean r7, Collection<Object> r8, boolean r9, int r10, boolean r11, int r12, long r13);

    protected abstract TTNetDiagnosisRequest createNetDiagnosisRequest(TTNetDiagnosisRequest.Callback r1, Executor r2, int r3, List<String> r4, int r5, int r6, int r7);

    protected abstract UrlRequestBase createRequest(String r1, UrlRequest.Callback r2, Executor r3, int r4, Collection<Object> r5, boolean r6, boolean r7, boolean r8, boolean r9, int r10, boolean r11, int r12, RequestFinishedInfo.Listener r13, int r14, long r15);

    protected abstract TTWebsocketConnection createWebsocketConnection(TTWebsocketConnection.Callback r1, Executor r2, List<String> r3, int r4, String r5, long r6, int r8, long r9, String r11, int r12, String r13, Map<String, String> r14, Map<String, String> r15, boolean r16);

    protected abstract TTWebsocketConnection createWebsocketConnection(TTWebsocketConnection.Callback r1, Executor r2, List<String> r3, Map<String, String> r4, Map<String, String> r5, boolean r6);

    public CronetEngineBase() {
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine, com.ttnet.org.chromium.net.CronetEngine
    public /* bridge */ /* synthetic */ UrlRequest.Builder newUrlRequestBuilder(String r1, UrlRequest.Callback r2, Executor r3) {
        return newUrlRequestBuilder(r1, r2, r3);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine, com.ttnet.org.chromium.net.CronetEngine
    public ExperimentalUrlRequest.Builder newUrlRequestBuilder(String r2, UrlRequest.Callback r3, Executor r4) {
        return new UrlRequestBuilderImpl(r2, r3, r4, this);
    }

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public TTWebsocketConnection.Builder newWebsocketConnectionBuilder(TTWebsocketConnection.Callback r2, Executor r3) {
        return new TTWebsocketConnectionBuilderImpl(r2, r3, this);
    }

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public TTNetDiagnosisRequest.Builder newNetDiagnosisRequestBuilder(TTNetDiagnosisRequest.Callback r2, Executor r3) {
        return new TTNetDiagnosisRequestBuilderImpl(r2, r3, this);
    }
}
