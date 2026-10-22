package com.ttnet.org.chromium.net.impl;

import android.util.Log;
import com.bytedance.librarian.LibrarianImpl;
import com.ttnet.org.chromium.net.BidirectionalStream;
import com.ttnet.org.chromium.net.ExperimentalBidirectionalStream;
import com.ttnet.org.chromium.net.NetworkQualityRttListener;
import com.ttnet.org.chromium.net.NetworkQualityThroughputListener;
import com.ttnet.org.chromium.net.RequestFinishedInfo;
import com.ttnet.org.chromium.net.TTAppInfoProvider;
import com.ttnet.org.chromium.net.TTEventListener;
import com.ttnet.org.chromium.net.TTMonitorProvider;
import com.ttnet.org.chromium.net.TTMpaService;
import com.ttnet.org.chromium.net.TTNetDiagnosisRequest;
import com.ttnet.org.chromium.net.TTWebsocketConnection;
import com.ttnet.org.chromium.net.UrlRequest;
import java.io.IOException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandlerFactory;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class JavaCronetEngine extends CronetEngineBase {
    private static final String TAG = "JavaCronetEngine";
    private final int mCronetEngineId;
    private final ExecutorService mExecutorService;
    private final CronetLogger mLogger;
    private final String mUserAgent;

    static {
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void addRequestFinishedListener(RequestFinishedInfo.Listener r1) {
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void addRttListener(NetworkQualityRttListener r1) {
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void addThroughputListener(NetworkQualityThroughputListener r1) {
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void configureNetworkQualityEstimatorForTesting(boolean r1, boolean r2, boolean r3) {
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBase
    protected TTNetDiagnosisRequest createNetDiagnosisRequest(TTNetDiagnosisRequest.Callback r1, Executor r2, int r3, List<String> r4, int r5, int r6, int r7) {
        return null;
    }

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public TTMpaService createTTMpaService() {
        return null;
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBase
    public TTWebsocketConnection createWebsocketConnection(TTWebsocketConnection.Callback r2, Executor r3, List<String> r4, int r5, String r6, long r7, int r9, long r10, String r12, int r13, String r14, Map<String, String> r15, Map<String, String> r16, boolean r17) {
        return null;
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBase
    public TTWebsocketConnection createWebsocketConnection(TTWebsocketConnection.Callback r1, Executor r2, List<String> r3, Map<String, String> r4, Map<String, String> r5, boolean r6) {
        return null;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public int getDownstreamThroughputKbps() {
        return -1;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public int getEffectiveConnectionType() {
        return 0;
    }

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public byte[] getGlobalMetricsDeltas() {
        return new byte[0];
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public int getHttpRttMs() {
        return -1;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public int getTransportRttMs() {
        return -1;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void registerAppInfoProvider(TTAppInfoProvider r1) {
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void registerAppMonitorProvider(TTMonitorProvider r1) {
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void registerEventListener(TTEventListener r1) {
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void removeRequestFinishedListener(RequestFinishedInfo.Listener r1) {
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void removeRttListener(NetworkQualityRttListener r1) {
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void removeThroughputListener(NetworkQualityThroughputListener r1) {
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void startNetLogToDisk(String r1, boolean r2, int r3) {
    }

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public void startNetLogToFile(String r1, boolean r2) {
    }

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public void stopNetLog() {
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBase, com.ttnet.org.chromium.net.ExperimentalCronetEngine, com.ttnet.org.chromium.net.CronetEngine
    public /* bridge */ /* synthetic */ UrlRequest.Builder newUrlRequestBuilder(String r1, UrlRequest.Callback r2, Executor r3) {
        return super.newUrlRequestBuilder(r1, r2, r3);
    }

    public JavaCronetEngine(CronetEngineBuilderImpl r12) {
        int r0 = hashCode();
        this.mCronetEngineId = r0;
        final int r1 = r12.threadPriority(9);
        this.mUserAgent = r12.getUserAgent();
        this.mExecutorService = new ThreadPoolExecutor(10, 20, 50, TimeUnit.SECONDS, new LinkedBlockingQueue(), new AnonymousClass1(this, r1));
        CronetLogger r2 = CronetLoggerFactory.createLogger(r12.getContext(), CronetLogger.CronetSource.CRONET_SOURCE_FALLBACK);
        this.mLogger = r2;
        r2.logCronetEngineCreation(r0, new CronetLogger.CronetEngineBuilderInfo(r12), buildCronetVersion(), CronetLogger.CronetSource.CRONET_SOURCE_FALLBACK);     // Catch: RuntimeException -> L5
        return;
    L5:
        e = move-exception;
        Log.e(TAG, "Error while trying to log JavaCronetEngine creation: ", e);
    }

    int getCronetEngineId() {
        return this.mCronetEngineId;
    }

    CronetLogger getCronetLogger() {
        return this.mLogger;
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBase
    public UrlRequestBase createRequest(String r14, UrlRequest.Callback r15, Executor r16, int r17, Collection<Object> r18, boolean r19, boolean r20, boolean r21, boolean r22, int r23, boolean r24, int r25, RequestFinishedInfo.Listener r26, int r27, long r28) {
        if (r28 != (-1)) goto L7;
        return new JavaUrlRequest(this, r15, this.mExecutorService, r16, r14, this.mUserAgent, r21, r22, r23, r24, r25);
    L7:
        throw new UnsupportedOperationException("The multi-network API is not supported by the Java implementation of Cronet Engine");
    }

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public URLConnection openConnection(URL r1, Proxy r2, boolean r3) throws IOException {
        return r1.openConnection(r2);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBase
    protected ExperimentalBidirectionalStream createBidirectionalStream(String r1, BidirectionalStream.Callback r2, Executor r3, String r4, List<Map.Entry<String, String>> r5, int r6, boolean r7, Collection<Object> r8, boolean r9, int r10, boolean r11, int r12, long r13) {
        throw new UnsupportedOperationException("Can't create a bidi stream - httpurlconnection doesn't have those APIs");
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public ExperimentalBidirectionalStream.Builder newBidirectionalStreamBuilder(String r1, BidirectionalStream.Callback r2, Executor r3) {
        throw new UnsupportedOperationException("The bidirectional stream API is not supported by the Java implementation of Cronet Engine");
    }

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public String getVersionString() {
        return "CronetHttpURLConnection/" + ImplVersion.getCronetVersionWithLastChange();
    }

    private CronetLogger.CronetVersion buildCronetVersion() {
        return new CronetLogger.CronetVersion(getVersionString().split(LibrarianImpl.Constants.SEPARATOR)[1].split("@")[0]);
    }

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public void shutdown() {
        this.mExecutorService.shutdown();
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void bindToNetwork(long r1) {
        throw new UnsupportedOperationException("The multi-network API is not supported by the Java implementation of Cronet Engine");
    }

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public URLConnection openConnection(URL r1) throws IOException {
        return r1.openConnection();
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public URLConnection openConnection(URL r1, Proxy r2) throws IOException {
        return r1.openConnection(r2);
    }

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public URLStreamHandlerFactory createURLStreamHandlerFactory() {
        return new AnonymousClass2(this);
    }
}
