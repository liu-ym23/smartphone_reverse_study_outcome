package com.ttnet.org.chromium.net.impl;

import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.obric.matrix.common_api.INetworkApi;
import com.ttnet.org.chromium.base.Log;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNIAdditionalImport;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.NativeClassQualifiedName;
import com.ttnet.org.chromium.net.CronetException;
import com.ttnet.org.chromium.net.InlineExecutionProhibitedException;
import com.ttnet.org.chromium.net.RequestFinishedInfo;
import com.ttnet.org.chromium.net.UploadDataProvider;
import com.ttnet.org.chromium.net.UrlRequest;
import java.nio.ByteBuffer;
import java.time.Duration;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: loaded from: classes2.dex */
@JNIAdditionalImport({VersionSafeCallbacks.class})
@JNINamespace("cronet")
@VisibleForTesting
public final class CronetUrlRequest extends UrlRequestBase {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private long mAddCookieCostUs;
    private final boolean mAllowDirectExecutor;
    private String mAuthCertPassword;
    private String mAuthCertUsername;
    private final VersionSafeCallbacks.UrlRequestCallback mCallback;
    private final int mCronetEngineId;
    private String mCronetMapKey;
    private final boolean mDisableCache;
    private final boolean mDisableConnectionMigration;
    private CronetException mException;
    private final Executor mExecutor;
    private String mFinalUrl;
    private int mFinishedReason;
    private final int mIdempotency;
    private String mInitialMethod;
    private final String mInitialUrl;
    private final CronetLogger mLogger;
    private CronetMetrics mMetrics;
    private final long mNetworkHandle;
    private Runnable mOnDestroyedCallbackForTesting;
    private OnReadCompletedRunnable mOnReadCompletedTask;
    private final int mPriority;
    private boolean mQuicConnectionMigrationAttempted;
    private boolean mQuicConnectionMigrationSuccessful;
    private final Collection<Object> mRequestAnnotations;
    private final CronetUrlRequestContext mRequestContext;
    private int mRequestCookieSource;
    private final VersionSafeCallbacks.RequestFinishedInfoListener mRequestFinishedListener;
    private int mRequestFlag;
    private final HeadersList mRequestHeaders;
    private String mRequestLog;
    private int mRequestTimeout;
    private int mRequestTypeFlags;
    private UrlResponseInfoImpl mResponseInfo;
    private long mSaveCookieCostUs;
    private int mSocketConnectTimeout;
    private int mSocketReadTimeout;
    private int mSocketWriteTimeout;
    private boolean mStarted;
    private long mThrottleNetSpeed;
    private final int mTrafficStatsTag;
    private final boolean mTrafficStatsTagSet;
    private final int mTrafficStatsUid;
    private final boolean mTrafficStatsUidSet;
    private CronetUploadDataStream mUploadDataStream;
    private final List<String> mUrlChain;
    private long mUrlRequestAdapter;
    private final Object mUrlRequestAdapterLock;
    private boolean mWaitingOnRead;
    private boolean mWaitingOnRedirect;

    @VisibleForTesting
    static final class HeadersList extends ArrayList<Map.Entry<String, String>> {
        HeadersList() {
        }
    }

    interface Natives {
        @NativeClassQualifiedName("CronetURLRequestAdapter")
        void abortWhenUploadException(long r1, CronetUrlRequest r3);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        void addRequestCookieHeader(long r1, CronetUrlRequest r3, String r4, String r5);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        boolean addRequestHeader(long r1, CronetUrlRequest r3, String r4, String r5);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        void appTimeout(long r1, CronetUrlRequest r3);

        long createRequestAdapter(CronetUrlRequest r1, long r2, String r4, int r5, int r6, boolean r7, boolean r8, boolean r9, int r10, boolean r11, int r12, int r13, long r14);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        void destroy(long r1, CronetUrlRequest r3, boolean r4);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        void followDeferredRedirect(long r1, CronetUrlRequest r3);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        void getStatus(long r1, CronetUrlRequest r3, VersionSafeCallbacks.UrlRequestStatusListener r4);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        boolean readData(long r1, CronetUrlRequest r3, ByteBuffer r4, int r5, int r6);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        void removeRequestCookieHeader(long r1, CronetUrlRequest r3);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        void setAuthCredentials(long r1, CronetUrlRequest r3, String r4, String r5);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        boolean setHttpMethod(long r1, CronetUrlRequest r3, String r4);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        void setRequestTimeout(long r1, CronetUrlRequest r3, int r4);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        void setRequestTypeFlags(long r1, CronetUrlRequest r3, int r4);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        void setSocketTimeout(long r1, CronetUrlRequest r3, int r4, int r5, int r6);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        void setThrottleNetSpeed(long r1, CronetUrlRequest r3, long r4);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        void start(long r1, CronetUrlRequest r3);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        void stopRedirect(long r1, CronetUrlRequest r3);
    }

    private final class OnReadCompletedRunnable implements Runnable {
        ByteBuffer mByteBuffer;
        final /* synthetic */ CronetUrlRequest this$0;

        private OnReadCompletedRunnable(CronetUrlRequest r1) {
            this.this$0 = r1;
        }

        /* synthetic */ OnReadCompletedRunnable(CronetUrlRequest r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.checkCallingThread();
            ByteBuffer r0 = this.mByteBuffer;
            this.mByteBuffer = null;
            Object r1 = CronetUrlRequest.access$000(this.this$0);     // Catch: Exception -> L16
            monitor-enter(r1);     // Catch: Exception -> L16
        L13:
            th = move-exception;
            throw th;     // Catch: Exception -> L16
        L6:
            if (CronetUrlRequest.access$100(this.this$0) == false) goto L9;
            monitor-exit(r1);     // Catch: Throwable -> L13
            return;
        L9:
            CronetUrlRequest.access$202(this.this$0, true);     // Catch: Throwable -> L13
            monitor-exit(r1);     // Catch: Throwable -> L13
            VersionSafeCallbacks.UrlRequestCallback r2 = CronetUrlRequest.access$400(this.this$0);     // Catch: Exception -> L16
            CronetUrlRequest r3 = this.this$0;     // Catch: Exception -> L16
            r2.onReadCompleted(r3, CronetUrlRequest.access$300(r3), r0);     // Catch: Exception -> L16
            return;
        L16:
            e = move-exception;
            CronetUrlRequest.access$500(this.this$0, e);
        }
    }

    static {
    }

    CronetUrlRequest(CronetUrlRequestContext r9, String r10, int r11, UrlRequest.Callback r12, Executor r13, Collection<Object> r14, boolean r15, boolean r16, boolean r17, boolean r18, int r19, boolean r20, int r21, RequestFinishedInfo.Listener r22, int r23, long r24) {
        this.mUrlRequestAdapterLock = new Object();
        ArrayList r5 = new ArrayList();
        this.mUrlChain = r5;
        this.mRequestHeaders = new HeadersList();
        Objects.requireNonNull(r10, "URL is required");
        Objects.requireNonNull(r12, "Listener is required");
        Objects.requireNonNull(r13, "Executor is required");
        this.mAllowDirectExecutor = r17;
        this.mRequestContext = r9;
        this.mCronetEngineId = r9.getCronetEngineId();
        this.mLogger = r9.getCronetLogger();
        this.mInitialUrl = r10;
        r5.add(r10);
        this.mPriority = convertRequestPriority(r11);
        this.mCallback = new VersionSafeCallbacks.UrlRequestCallback(r12);
        this.mExecutor = r13;
        this.mRequestAnnotations = r14;
        this.mDisableCache = r15;
        this.mDisableConnectionMigration = r16;
        this.mTrafficStatsTagSet = r18;
        this.mTrafficStatsTag = r19;
        this.mTrafficStatsUidSet = r20;
        this.mTrafficStatsUid = r21;
        if (r22 == null) goto L5;
        VersionSafeCallbacks.RequestFinishedInfoListener r1 = new VersionSafeCallbacks.RequestFinishedInfoListener(r22);
    L6:
        this.mRequestFinishedListener = r1;
        this.mIdempotency = convertIdempotency(r23);
        this.mNetworkHandle = r24;
        return;
    L5:
        r1 = null;
        goto L6
    }

    static /* synthetic */ Object access$000(CronetUrlRequest r0) {
        return r0.mUrlRequestAdapterLock;
    }

    static /* synthetic */ boolean access$100(CronetUrlRequest r0) {
        return r0.isDoneLocked();
    }

    static /* synthetic */ boolean access$1002(CronetUrlRequest r0, boolean r1) {
        r0.mWaitingOnRedirect = r1;
        return r1;
    }

    static /* synthetic */ void access$1200(CronetUrlRequest r0, int r1) {
        r0.destroyRequestAdapterLocked(r1);
    }

    static /* synthetic */ CronetException access$1300(CronetUrlRequest r0) {
        return r0.mException;
    }

    static /* synthetic */ VersionSafeCallbacks.RequestFinishedInfoListener access$1400(CronetUrlRequest r0) {
        return r0.mRequestFinishedListener;
    }

    static /* synthetic */ boolean access$202(CronetUrlRequest r0, boolean r1) {
        r0.mWaitingOnRead = r1;
        return r1;
    }

    static /* synthetic */ UrlResponseInfoImpl access$300(CronetUrlRequest r0) {
        return r0.mResponseInfo;
    }

    static /* synthetic */ VersionSafeCallbacks.UrlRequestCallback access$400(CronetUrlRequest r0) {
        return r0.mCallback;
    }

    static /* synthetic */ void access$500(CronetUrlRequest r0, Exception r1) {
        r0.onCallbackException(r1);
    }

    static /* synthetic */ CronetUploadDataStream access$600(CronetUrlRequest r0) {
        return r0.mUploadDataStream;
    }

    static /* synthetic */ long access$700(CronetUrlRequest r2) {
        return r2.mUrlRequestAdapter;
    }

    static /* synthetic */ void access$800(CronetUrlRequest r0) {
        r0.startInternalLocked();
    }

    static /* synthetic */ void access$900(CronetUrlRequest r0) {
        r0.maybeReportMetrics();
    }

    @CalledByNative
    private String[] addSecurityFactor(String r6, String[] r7) {
        HashMap r0 = new HashMap();
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r2 >= r7.length) goto L6;
        r0.put(r7[r2].toLowerCase(Locale.US), r7[r2 + 1]);
        r2 = r2 + 2;
        goto L4
    L6:
        Map<String, String> r5 = this.mRequestContext.onCallToAddSecurityFactor(r6, r0);
        if (r5 != null) goto L10;
        return null;
    L10:
        String[] r8 = new String[r5.size() * 2];
        Iterator<Map.Entry<String, String>> r9 = r5.entrySet().iterator();
    L12:
        if (r9.hasNext() == false) goto L14;
        Map.Entry<String, String> r10 = r9.next();
        r8[r1] = r10.getKey();
        r8[r1 + 1] = r10.getValue();
        r1 = r1 + 2;
        goto L12
    L14:
        return r8;
    }

    @RequiresApi(26)
    private CronetLogger.CronetTrafficInfo buildCronetTrafficInfo() {
        UrlResponseInfoImpl r1 = this.mResponseInfo;
        boolean r2 = false;
        if (r1 == null) goto L5;
        Map<String, List<String>> r3 = r1.getAllHeaders();
        String r4 = this.mResponseInfo.getNegotiatedProtocol();
        String r15 = r4;
        int r12 = this.mResponseInfo.getHttpStatusCode();
        r2 = this.mResponseInfo.wasCached();
    L6:
        long r5 = this.mMetrics.getSentByteCount().longValue();
        if (r2 == true) goto L9;
    L11:
        long r7 = estimateHeadersSizeInBytes(this.mRequestHeaders);
        long r9 = Math.max(0, r5 - r7);
    L12:
        long r6 = this.mMetrics.getReceivedByteCount().longValue();
        if (r2 == true) goto L15;
    L17:
        long r8 = estimateHeadersSizeInBytes(r3);
        long r13 = Math.max(0, r6 - r8);
    L19:
        if (this.mMetrics.getRequestStart() != null) goto L21;
    L23:
        Duration r10 = Duration.ofSeconds(0);
    L24:
        Duration r16 = r10;
        if (this.mMetrics.getRequestStart() != null) goto L27;
    L29:
        Duration r11 = Duration.ofSeconds(0);
    L31:
        return new CronetLogger.CronetTrafficInfo(r7, r9, r8, r13, r12, r16, r11, r15, this.mQuicConnectionMigrationAttempted, this.mQuicConnectionMigrationSuccessful);
    L27:
        if (this.mMetrics.getRequestEnd() == null) goto L29;
        r11 = Duration.ofMillis(this.mMetrics.getRequestEnd().getTime() - this.mMetrics.getRequestStart().getTime());
        goto L31
    L21:
        if (this.mMetrics.getResponseStart() == null) goto L23;
        r10 = Duration.ofMillis(this.mMetrics.getResponseStart().getTime() - this.mMetrics.getRequestStart().getTime());
        goto L24
    L15:
        if (r6 != 0) goto L17;
        r8 = 0;
        r13 = 0;
        goto L19
    L9:
        if (r5 != 0) goto L11;
        r7 = 0;
        r9 = 0;
        goto L12
    L5:
        r3 = Collections.emptyMap();
        r12 = 0;
        r15 = "";
        goto L6
    }

    private void checkNotStarted() {
        Object r0 = this.mUrlRequestAdapterLock;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.mStarted == true) goto L11;
        if (isDoneLocked() == true) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L11:
        throw new IllegalStateException("Request is already started.");     // Catch: Throwable -> L12
    }

    private static int convertIdempotency(int r1) {
        int r0 = 1;
        if (r1 == 1) goto L8;
        r0 = 2;
        if (r1 == 2) goto L8;
        return 0;
    L8:
        return r0;
    }

    private static int convertRequestPriority(int r2) {
        if (r2 != 0) goto L5;
        return 1;
    L5:
        if (r2 == 1) goto L14;
        if (r2 != 2) goto L8;
        return 3;
    L8:
        if (r2 == 4) goto L10;
        return 4;
    L10:
        return 5;
    L14:
        return 2;
    }

    private void destroyRequestAdapterLocked(int r7) {
        this.mFinishedReason = r7;
        if (this.mUrlRequestAdapter != 0) goto L5;
        return;
    L5:
        this.mRequestContext.onRequestDestroyed();
        Natives r0 = CronetUrlRequestJni.get();
        long r4 = this.mUrlRequestAdapter;
        if (r7 != 2) goto L8;
        boolean r8 = true;
    L9:
        r0.destroy(r4, this, r8);
        this.mUrlRequestAdapter = 0;
        return;
    L8:
        r8 = false;
        goto L9
    }

    @VisibleForTesting
    static long estimateHeadersSizeInBytes(HeadersList r5) {
        long r0 = 0;
        if (r5 != null) goto L5;
        return 0;
    L5:
        Iterator<Map.Entry<String, String>> r6 = r5.iterator();
    L7:
        if (r6.hasNext() == false) goto L14;
        Map.Entry<String, String> r2 = r6.next();
        String r3 = r2.getKey();
        if (r3 == null) goto L12;
        r0 = r0 + ((long) r3.length());
    L12:
        if (r2.getValue() == null) goto L7;
        r0 = r0 + ((long) r2.getValue().length());
        goto L7
    L14:
        return r0;
    }

    @VisibleForTesting
    static long estimateHeadersSizeInBytes(Map<String, List<String>> r5) {
        long r0 = 0;
        if (r5 != null) goto L5;
        return 0;
    L5:
        Iterator<Map.Entry<String, List<String>>> r6 = r5.entrySet().iterator();
    L7:
        if (r6.hasNext() == false) goto L18;
        Map.Entry<String, List<String>> r2 = r6.next();
        String r3 = r2.getKey();
        if (r3 == null) goto L12;
        r0 = r0 + ((long) r3.length());
    L12:
        if (r2.getValue() == null) goto L7;
        Iterator<String> r4 = r2.getValue().iterator();
    L16:
        if (r4.hasNext() == false) goto L7;
        r0 = r0 + ((long) r4.next().length());
        goto L16
    L18:
        return r0;
    }

    private void failWithException(final CronetException r4) {
        Object r0 = this.mUrlRequestAdapterLock;
        monitor-enter(r0);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (isDoneLocked() == false) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L16
        return;
    L8:
        this.mException = r4;     // Catch: Throwable -> L16
        destroyRequestAdapterLocked(1);     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
        this.mExecutor.execute(new AnonymousClass3(this, r4));     // Catch: RejectedExecutionException -> L13
        return;
    L13:
        e = move-exception;
        Log.e(CronetUrlRequestContext.LOG_TAG, "Exception posting task to executor", new Object[]{e});
    }

    private RequestFinishedInfo getRequestFinishedInfo() {
        return new RequestFinishedInfoImpl(this.mInitialUrl, this.mRequestAnnotations, this.mMetrics, this.mFinishedReason, this.mResponseInfo, this.mException);
    }

    private boolean isDoneLocked() {
        if (this.mStarted == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mUrlRequestAdapter != 0) goto L7;
        return true;
    }

    private int mapUrlRequestErrorToApiErrorCode(int r3) {
        switch(r3) {
            case 1: goto L25;
            case 2: goto L23;
            case 3: goto L21;
            case 4: goto L19;
            case 5: goto L17;
            case 6: goto L15;
            case 7: goto L13;
            case 8: goto L11;
            case 9: goto L9;
            case 10: goto L7;
            case 11: goto L5;
            default: goto L3;
        };
    L3:
        Log.e(CronetUrlRequestContext.LOG_TAG, "Unknown error code: " + r3, new Object[0]);
        return r3;
    L5:
        return 11;
    L7:
        return 10;
    L9:
        return 9;
    L11:
        return 8;
    L13:
        return 7;
    L15:
        return 6;
    L17:
        return 5;
    L19:
        return 4;
    L21:
        return 3;
    L23:
        return 2;
    L25:
        return 1;
    }

    private void maybeReportMetrics() {
        if (this.mMetrics != null) goto L5;
        return;
    L5:
        if (Build.VERSION.SDK_INT >= 26) goto L17;
    L10:
        final RequestFinishedInfoImpl r0 = new RequestFinishedInfoImpl(this.mInitialUrl, this.mRequestAnnotations, this.mMetrics, this.mFinishedReason, this.mResponseInfo, this.mException);
        this.mRequestContext.reportRequestFinished(r0);
        VersionSafeCallbacks.RequestFinishedInfoListener r1 = this.mRequestFinishedListener;
        if (r1 == null) goto L22;
        r1.getExecutor().execute(new AnonymousClass11(this, r0));     // Catch: RejectedExecutionException -> L14
        return;
    L14:
        e = move-exception;
        Log.e(CronetUrlRequestContext.LOG_TAG, "Exception posting task to executor", new Object[]{e});
        return;
    L22:
        return;
    L17:
        this.mLogger.logCronetTrafficInfo(this.mCronetEngineId, buildCronetTrafficInfo());     // Catch: RuntimeException -> L8
    L8:
        e = move-exception;
        Log.e(CronetUrlRequestContext.LOG_TAG, "Error while trying to log CronetTrafficInfo: ", new Object[]{e});
        goto L10
    }

    private void onCallbackException(Exception r5) {
        CallbackExceptionImpl r0 = new CallbackExceptionImpl("Exception received from UrlRequest.Callback", r5);
        Log.e(CronetUrlRequestContext.LOG_TAG, "Exception in CalledByNative method", new Object[]{r5});
        failWithException(r0);
    }

    @CalledByNative
    private void onCanceled() {
        CronetUrlRequestMapping.RemoveRequest(this.mCronetMapKey);
        postTaskToExecutor(new AnonymousClass7(this));
    }

    @CalledByNative
    private void onError(int r2, int r3, int r4, String r5, long r6) {
        UrlResponseInfoImpl r0 = this.mResponseInfo;
        if (r0 == null) goto L5;
        r0.setReceivedByteCount(r6);
    L5:
        CronetUrlRequestMapping.RemoveRequest(this.mCronetMapKey);
        if (r2 != 10) goto L8;
    L11:
        failWithException(new QuicExceptionImpl("Exception in CronetUrlRequest: " + r5, r2, r3, r4));
        return;
    L8:
        if (r2 == 3) goto L11;
        failWithException(new NetworkExceptionImpl("Exception in CronetUrlRequest: " + r5, mapUrlRequestErrorToApiErrorCode(r2), r3));
    }

    @CalledByNative
    private void onMetricsCollected(long r53, long r55, long r57, long r59, long r61, long r63, long r65, long r67, long r69, long r71, long r73, long r75, long r77, boolean r79, long r80, long r82, long r84, String r86, long r87, long r89, String r91, String r92, String r93, String r94, boolean r95, boolean r96, boolean r97, boolean r98) {
        Object r2 = this.mUrlRequestAdapterLock;
        monitor-enter(r2);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.mMetrics != null) goto L11;
        this.mMetrics = new CronetMetrics(r53, r55, r57, r59, r61, r63, r65, r67, r69, r71, r73, r75, r77, r79, r80, r82, r84, r86, r87, r89, r91, r92, this.mAddCookieCostUs, this.mSaveCookieCostUs, this.mRequestCookieSource, r95, r96);     // Catch: Throwable -> L12
        this.mRequestLog = r94;     // Catch: Throwable -> L12
        this.mFinalUrl = r93;     // Catch: Throwable -> L12
        this.mCallback.onRequestLogCollected(r94, getRequestFinishedInfo());     // Catch: Throwable -> L12
        this.mQuicConnectionMigrationAttempted = r97;     // Catch: Throwable -> L12
        this.mQuicConnectionMigrationSuccessful = r98;     // Catch: Throwable -> L12
        monitor-exit(r2);     // Catch: Throwable -> L12
        final RequestFinishedInfo r1 = getRequestFinishedInfo();
        postTaskToExecutor(new AnonymousClass9(this, r1));
        this.mRequestContext.reportRequestFinished(r1);
        return;
    L11:
        throw new IllegalStateException("Metrics collection should only happen once.");     // Catch: Throwable -> L12
    }

    @CalledByNative
    private void onNativeAdapterDestroyed() {
        Object r0 = this.mUrlRequestAdapterLock;
        monitor-enter(r0);
        Runnable r1 = this.mOnDestroyedCallbackForTesting;     // Catch: Throwable -> L18
        if (r1 == null) goto L8;
        r1.run();     // Catch: Throwable -> L18
    L8:
        if (this.mException != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L18
        return;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L18
        this.mExecutor.execute(new AnonymousClass10(this));     // Catch: RejectedExecutionException -> L15
        return;
    L15:
        e = move-exception;
        Log.e(CronetUrlRequestContext.LOG_TAG, "Exception posting task to executor", new Object[]{e});
        return;
    L18:
        th = move-exception;
        throw th;
    }

    @CalledByNative
    private void onReadCompleted(ByteBuffer r2, int r3, int r4, int r5, long r6) {
        this.mResponseInfo.setReceivedByteCount(r6);
        AnonymousClass1 r7 = null;
        if (r2.position() == r4) goto L5;
    L12:
        failWithException(new CronetExceptionImpl("ByteBuffer modified externally during read", null));
        return;
    L5:
        if (r2.limit() != r5) goto L12;
        if (this.mOnReadCompletedTask != null) goto L10;
        this.mOnReadCompletedTask = new OnReadCompletedRunnable(this, r7);
    L10:
        r2.position(r4 + r3);
        OnReadCompletedRunnable r8 = this.mOnReadCompletedTask;
        r8.mByteBuffer = r2;
        postTaskToExecutor(r8);
    }

    @CalledByNative
    private void onRedirectReceived(final String r12, int r13, String r14, String[] r15, boolean r16, String r17, String r18, long r19, final String r21) {
        final UrlResponseInfoImpl r0 = prepareResponseInfoOnNetworkThread(r13, r14, r15, r16, r17, r18, r19);
        this.mUrlChain.add(r12);
        postTaskToExecutor(new AnonymousClass4(this, r0, r12, r21));
    }

    @CalledByNative
    private void onResponseStarted(int r1, String r2, String[] r3, boolean r4, String r5, String r6, long r7, final String r9) {
        this.mResponseInfo = prepareResponseInfoOnNetworkThread(r1, r2, r3, r4, r5, r6, r7);
        postTaskToExecutor(new AnonymousClass5(this, r9));
    }

    @CalledByNative
    private void onStatus(final VersionSafeCallbacks.UrlRequestStatusListener r2, final int r3) {
        postTaskToExecutor(new AnonymousClass8(this, r2, r3));
    }

    @CalledByNative
    private void onSucceeded(long r2) {
        this.mResponseInfo.setReceivedByteCount(r2);
        CronetUrlRequestMapping.RemoveRequest(this.mCronetMapKey);
        postTaskToExecutor(new AnonymousClass6(this));
    }

    private void postTaskToExecutor(Runnable r4) {
        this.mExecutor.execute(r4);     // Catch: RejectedExecutionException -> L4
        return;
    L4:
        e = move-exception;
        Log.e(CronetUrlRequestContext.LOG_TAG, "Exception posting task to executor", new Object[]{e});
        failWithException(new CronetExceptionImpl("Exception posting task to executor", e));
    }

    private UrlResponseInfoImpl prepareResponseInfoOnNetworkThread(int r12, String r13, String[] r14, boolean r15, String r16, String r17, long r18) {
        HeadersList r4 = new HeadersList();
        int r1 = 0;
    L4:
        if (r1 >= r14.length) goto L7;
        r4.add(new AbstractMap.SimpleImmutableEntry(r14[r1], r14[r1 + 1]));
        r1 = r1 + 2;
        goto L4
    L7:
        return new UrlResponseInfoImpl(new ArrayList(this.mUrlChain), r12, r13, r4, r15, r16, r17, r18);
    }

    private void startInternalLocked() {
        String r0 = this.mCronetMapKey;
        if (r0 == null) goto L5;
        CronetUrlRequestMapping.AddRequest(r0, this);
    L5:
        CronetUrlRequestJni.get().start(this.mUrlRequestAdapter, this);
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void AddRequestCookieHeader(String r8, String r9) {
        Object r0 = this.mUrlRequestAdapterLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mUrlRequestAdapter != 0) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L8:
        CronetUrlRequestJni.get().addRequestCookieHeader(this.mUrlRequestAdapter, this, r8, r9);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void RemoveRequestCookieHeader() {
        Object r0 = this.mUrlRequestAdapterLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mUrlRequestAdapter != 0) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L8:
        CronetUrlRequestJni.get().removeRequestCookieHeader(this.mUrlRequestAdapter, this);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
    }

    @Override // com.ttnet.org.chromium.net.impl.UrlRequestBase
    public void addHeader(String r2, String r3) {
        checkNotStarted();
        Objects.requireNonNull(r2, "Invalid header name.");
        Objects.requireNonNull(r3, "Invalid header value.");
        this.mRequestHeaders.add(new AbstractMap.SimpleImmutableEntry(r2, r3));
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void appTimeout() {
        CronetUrlRequestMapping.RemoveRequest(this.mCronetMapKey);
        Object r0 = this.mUrlRequestAdapterLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mUrlRequestAdapter != 0) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L8:
        CronetUrlRequestJni.get().appTimeout(this.mUrlRequestAdapter, this);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void cancel() {
        Object r0 = this.mUrlRequestAdapterLock;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (isDoneLocked() == false) goto L7;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L7:
        if (this.mStarted == false) goto L12;
        destroyRequestAdapterLocked(2);     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
    }

    void checkCallingThread() {
        if (this.mAllowDirectExecutor == false) goto L5;
        return;
    L5:
        if (this.mRequestContext.isNetworkThread(Thread.currentThread()) == true) goto L8;
        return;
    L8:
        throw new InlineExecutionProhibitedException();
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void followRedirect() {
        Object r0 = this.mUrlRequestAdapterLock;
        monitor-enter(r0);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (this.mWaitingOnRedirect == false) goto L14;
        this.mWaitingOnRedirect = false;     // Catch: Throwable -> L15
        if (isDoneLocked() == false) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L10:
        CronetUrlRequestJni.get().followDeferredRedirect(this.mUrlRequestAdapter, this);     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L14:
        throw new IllegalStateException("No redirect to follow.");     // Catch: Throwable -> L15
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public String getFinalUrl() {
        return this.mFinalUrl;
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public String getRequestLog() {
        return this.mRequestLog;
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void getStatus(UrlRequest.StatusListener r6) {
        final VersionSafeCallbacks.UrlRequestStatusListener r0 = new VersionSafeCallbacks.UrlRequestStatusListener(r6);
        Object r7 = this.mUrlRequestAdapterLock;
        monitor-enter(r7);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.mUrlRequestAdapter == 0) goto L9;
        CronetUrlRequestJni.get().getStatus(this.mUrlRequestAdapter, this, r0);     // Catch: Throwable -> L12
        monitor-exit(r7);     // Catch: Throwable -> L12
        return;
    L9:
        monitor-exit(r7);     // Catch: Throwable -> L12
        postTaskToExecutor(new AnonymousClass2(this, r0));
    }

    @VisibleForTesting
    public long getUrlRequestAdapterForTesting() {
        Object r0 = this.mUrlRequestAdapterLock;
        monitor-enter(r0);
        long r1 = this.mUrlRequestAdapter;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public boolean isDone() {
        Object r0 = this.mUrlRequestAdapterLock;
        monitor-enter(r0);
        boolean r1 = isDoneLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    void onUploadException(Throwable r5) {
        Log.e(CronetUrlRequestContext.LOG_TAG, "Exception in upload method", new Object[]{r5});
        Object r6 = this.mUrlRequestAdapterLock;
        monitor-enter(r6);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mUrlRequestAdapter != 0) goto L8;
        monitor-exit(r6);     // Catch: Throwable -> L11
        return;
    L8:
        CronetUrlRequestJni.get().abortWhenUploadException(this.mUrlRequestAdapter, this);     // Catch: Throwable -> L11
        monitor-exit(r6);     // Catch: Throwable -> L11
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void read(ByteBuffer r9) {
        Preconditions.checkHasRemaining(r9);
        Preconditions.checkDirect(r9);
        Object r0 = this.mUrlRequestAdapterLock;
        monitor-enter(r0);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (this.mWaitingOnRead == false) goto L17;
        this.mWaitingOnRead = false;     // Catch: Throwable -> L18
        if (isDoneLocked() == false) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L18
        return;
    L11:
        if (CronetUrlRequestJni.get().readData(this.mUrlRequestAdapter, this, r9, r9.position(), r9.limit()) == false) goto L14;
        monitor-exit(r0);     // Catch: Throwable -> L18
        return;
    L14:
        this.mWaitingOnRead = true;     // Catch: Throwable -> L18
        throw new IllegalArgumentException("Unable to call native read");     // Catch: Throwable -> L18
    L17:
        throw new IllegalStateException("Unexpected read attempt.");     // Catch: Throwable -> L18
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void setAddCookieCostUs(long r1) {
        this.mAddCookieCostUs = r1;
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void setAuthCredentials(String r1, String r2) {
        this.mAuthCertUsername = r1;
        this.mAuthCertPassword = r2;
    }

    @Override // com.ttnet.org.chromium.net.impl.UrlRequestBase
    public void setHttpMethod(String r2) {
        checkNotStarted();
        Objects.requireNonNull(r2, "Method is required.");
        this.mInitialMethod = r2;
    }

    @VisibleForTesting
    public void setOnDestroyedCallbackForTesting(Runnable r2) {
        Object r0 = this.mUrlRequestAdapterLock;
        monitor-enter(r0);
        this.mOnDestroyedCallbackForTesting = r2;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @VisibleForTesting
    public void setOnDestroyedUploadCallbackForTesting(Runnable r1) {
        this.mUploadDataStream.setOnDestroyedCallbackForTesting(r1);
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void setRequestCookieSource(int r1) {
        this.mRequestCookieSource = r1;
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void setRequestFlag(int r1) {
        this.mRequestFlag = r1;
    }

    @Override // com.ttnet.org.chromium.net.impl.UrlRequestBase
    public void setRequestTimeout(int r1) {
        this.mRequestTimeout = r1;
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void setRequestTypeFlags(int r2) {
        this.mRequestTypeFlags = r2 | this.mRequestTypeFlags;
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void setSaveCookieCostUs(long r1) {
        this.mSaveCookieCostUs = r1;
    }

    @Override // com.ttnet.org.chromium.net.impl.UrlRequestBase
    public void setSocketConnectTimeout(int r1) {
        this.mSocketConnectTimeout = r1;
    }

    @Override // com.ttnet.org.chromium.net.impl.UrlRequestBase
    public void setSocketReadTimeout(int r1) {
        this.mSocketReadTimeout = r1;
    }

    @Override // com.ttnet.org.chromium.net.impl.UrlRequestBase
    public void setSocketWriteTimeout(int r1) {
        this.mSocketWriteTimeout = r1;
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void setThrottleNetSpeed(long r9) {
        Object r0 = this.mUrlRequestAdapterLock;
        monitor-enter(r0);
        this.mThrottleNetSpeed = r9;     // Catch: Throwable -> L9
        if (this.mUrlRequestAdapter == 0) goto L7;
        CronetUrlRequestJni.get().setThrottleNetSpeed(this.mUrlRequestAdapter, this, r9);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.impl.UrlRequestBase
    public void setUploadDataProvider(UploadDataProvider r2, Executor r3) {
        Objects.requireNonNull(r2, "Invalid UploadDataProvider.");
        if (this.mInitialMethod != null) goto L5;
        this.mInitialMethod = "POST";
    L5:
        this.mUploadDataStream = new CronetUploadDataStream(r2, r3, this);
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void start() {
        Object r14 = this.mUrlRequestAdapterLock;
        monitor-enter(r14);
        checkNotStarted();     // Catch: Throwable -> L75
    L88:
    L84:
        final CronetUrlRequest r8 = this;
        r8.mUrlRequestAdapter = CronetUrlRequestJni.get().createRequestAdapter(this, this.mRequestContext.getUrlRequestContextAdapter(), this.mInitialUrl, this.mPriority, this.mRequestFlag, this.mDisableCache, this.mDisableConnectionMigration, this.mTrafficStatsTagSet, this.mTrafficStatsTag, this.mTrafficStatsUidSet, this.mTrafficStatsUid, this.mIdempotency, this.mNetworkHandle);     // Catch: RuntimeException -> L62 Throwable -> L79
        r8.mRequestContext.onRequestStarted();     // Catch: RuntimeException -> L62 Throwable -> L79
        if (r8.mInitialMethod != null) goto L14;
    L18:
        Iterator<Map.Entry<String, String>> r7 = r8.mRequestHeaders.iterator();     // Catch: RuntimeException -> L62 Throwable -> L79
        boolean r13 = false;
    L20:
        if (r7.hasNext() == false) goto L36;
        Map.Entry<String, String> r0 = r7.next();     // Catch: RuntimeException -> L62 Throwable -> L79
        if (r0.getKey().equalsIgnoreCase(INetworkApi.CONTENT_TYPE) == false) goto L27;
        if (r0.getValue().isEmpty() == true) goto L27;
        r13 = true;
    L27:
        if (r0.getKey().equalsIgnoreCase("Tt-Map-Key") == false) goto L32;
        if (r0.getValue().isEmpty() == true) goto L32;
        r8.mCronetMapKey = r0.getValue();     // Catch: RuntimeException -> L62 Throwable -> L79
    L32:
        if (CronetUrlRequestJni.get().addRequestHeader(r8.mUrlRequestAdapter, this, r0.getKey(), r0.getValue()) == true) goto L20;
        throw new IllegalArgumentException("Invalid header " + r0.getKey() + "=" + r0.getValue());     // Catch: RuntimeException -> L62 Throwable -> L79
    L36:
        CronetUrlRequestJni.get().setSocketTimeout(r8.mUrlRequestAdapter, this, r8.mSocketConnectTimeout, r8.mSocketReadTimeout, r8.mSocketWriteTimeout);     // Catch: RuntimeException -> L62 Throwable -> L79
        CronetUrlRequestJni.get().setRequestTimeout(r8.mUrlRequestAdapter, r8, r8.mRequestTimeout);     // Catch: RuntimeException -> L62 Throwable -> L79
        if (r8.mThrottleNetSpeed <= 0) goto L40;
        CronetUrlRequestJni.get().setThrottleNetSpeed(r8.mUrlRequestAdapter, this, r8.mThrottleNetSpeed);     // Catch: RuntimeException -> L62 Throwable -> L79
    L40:
        if (r8.mRequestTypeFlags <= 0) goto L43;
        CronetUrlRequestJni.get().setRequestTypeFlags(r8.mUrlRequestAdapter, r8, r8.mRequestTypeFlags);     // Catch: RuntimeException -> L62 Throwable -> L79
    L43:
        if (r8.mAuthCertUsername != null) goto L45;
    L47:
        CronetUploadDataStream r1 = r8.mUploadDataStream;     // Catch: RuntimeException -> L62 Throwable -> L79
        if (r1 == null) goto L59;
        int r2 = 1;
        if (r13 == false) goto L57;
        r8.mStarted = true;     // Catch: RuntimeException -> L54 Throwable -> L79
        r1.postTaskToExecutor(new AnonymousClass1(r8));     // Catch: RuntimeException -> L54 Throwable -> L79
        monitor-exit(r14);     // Catch: Throwable -> L79
        return;
    L57:
        throw new IllegalArgumentException("Requests with upload data must have a Content-Type.");     // Catch: RuntimeException -> L54 Throwable -> L79
    L54:
        e = e;
    L73:
        r8.destroyRequestAdapterLocked(r2);     // Catch: Throwable -> L79
        throw e;     // Catch: Throwable -> L79
    L59:
        r8.mStarted = true;     // Catch: Throwable -> L79
        startInternalLocked();     // Catch: Throwable -> L79
        monitor-exit(r14);     // Catch: Throwable -> L79
        return;
    L45:
        if (r8.mAuthCertPassword == null) goto L47;
        CronetUrlRequestJni.get().setAuthCredentials(r8.mUrlRequestAdapter, this, r8.mAuthCertUsername, r8.mAuthCertPassword);     // Catch: RuntimeException -> L62 Throwable -> L79
        goto L47
    L14:
        if (CronetUrlRequestJni.get().setHttpMethod(r8.mUrlRequestAdapter, r8, r8.mInitialMethod) == true) goto L18;
        throw new IllegalArgumentException("Invalid http method " + r8.mInitialMethod);     // Catch: RuntimeException -> L62 Throwable -> L79
    L62:
        e = e;
    L72:
        r2 = 1;
    L64:
        e = e;
        r2 = 1;
        r8 = this;
    L68:
        e = e;
        r8 = this;
    L66:
        th = th;
        Object r17 = r14;
    L77:
        monitor-exit(r17);     // Catch: Throwable -> L79
        throw th;
    L70:
        e = e;
        r8 = this;
    L79:
        th = th;
    L75:
        th = th;
        r17 = r14;
        goto L77
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void stopRedirect() {
        Object r0 = this.mUrlRequestAdapterLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mUrlRequestAdapter != 0) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L8:
        CronetUrlRequestJni.get().stopRedirect(this.mUrlRequestAdapter, this);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
    }
}
