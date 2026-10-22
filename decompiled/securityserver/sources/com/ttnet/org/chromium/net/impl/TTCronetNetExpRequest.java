package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.base.Log;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.NativeClassQualifiedName;
import com.ttnet.org.chromium.net.TTNetDiagnosisRequest;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("cronet")
public final class TTCronetNetExpRequest extends TTNetDiagnosisRequest {
    private static final String TAG = "TTCronetNetExpRequest";
    private final TTNetDiagnosisRequest.Callback mCallback;
    private Executor mExecutor;
    private int mMultiNetAction;
    private int mNetDetectActions;

    @GuardedBy
    private long mNetDiagnosisRequestAdapter;
    private final Object mNetDiagnosisRequestAdapterLock;
    private CronetUrlRequestContext mRequestContext;
    private int mRequestType;

    @GuardedBy
    private boolean mStarted;
    private List<String> mTargets;
    private int mTimeoutMs;

    public interface Natives {
        long createRequestAdapter(TTCronetNetExpRequest r1, long r2, int r4, String[] r5, int r6, int r7, int r8);

        @NativeClassQualifiedName("TTCronetNetExpRequestAdapter")
        void destroy(long r1, TTCronetNetExpRequest r3);

        @NativeClassQualifiedName("TTCronetNetExpRequestAdapter")
        void doExtraCommand(long r1, TTCronetNetExpRequest r3, String r4, String r5);

        @NativeClassQualifiedName("TTCronetNetExpRequestAdapter")
        void start(long r1, TTCronetNetExpRequest r3);
    }

    public TTCronetNetExpRequest(CronetUrlRequestContext r2, TTNetDiagnosisRequest.Callback r3, Executor r4, int r5, List<String> r6, int r7, int r8, int r9) {
        this.mNetDiagnosisRequestAdapterLock = new Object();
        this.mRequestContext = r2;
        this.mCallback = r3;
        this.mExecutor = r4;
        this.mRequestType = r5;
        this.mTargets = r6;
        this.mNetDetectActions = r7;
        this.mMultiNetAction = r8;
        this.mTimeoutMs = r9;
    }

    public static /* synthetic */ Object access$000(TTCronetNetExpRequest r0) {
        return r0.mNetDiagnosisRequestAdapterLock;
    }

    public static /* synthetic */ boolean access$100(TTCronetNetExpRequest r0) {
        return r0.isDoneLocked();
    }

    public static /* synthetic */ void access$200(TTCronetNetExpRequest r0) {
        r0.destroyRequestAdapterLocked();
    }

    public static /* synthetic */ TTNetDiagnosisRequest.Callback access$300(TTCronetNetExpRequest r0) {
        return r0.mCallback;
    }

    public static /* synthetic */ String access$400() {
        return TAG;
    }

    @GuardedBy
    private void destroyRequestAdapterLocked() {
        if (this.mNetDiagnosisRequestAdapter != 0) goto L5;
        return;
    L5:
        TTCronetNetExpRequestJni.get().destroy(this.mNetDiagnosisRequestAdapter, this);
        this.mNetDiagnosisRequestAdapter = 0;
    }

    @GuardedBy
    private boolean isDoneLocked() {
        if (this.mStarted == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mNetDiagnosisRequestAdapter != 0) goto L7;
        return true;
    }

    @CalledByNative
    private void onNetExpRequestComplete(final String r2, final boolean r3) {
        postTaskToExecutor(new AnonymousClass1(this, r3, r2));
    }

    private void postTaskToExecutor(Runnable r2) {
        Executor r1 = this.mExecutor;     // Catch: RejectedExecutionException -> L5
        if (r1 == null) goto L7;
        r1.execute(r2);     // Catch: RejectedExecutionException -> L5
    L11:
        return;
    L7:
        new Thread(r2, "NetExpCallback").start();     // Catch: RejectedExecutionException -> L5
    L5:
        e = move-exception;
        Log.e(TAG, "Exception posting task to executor", new Object[]{e});
    }

    @Override // com.ttnet.org.chromium.net.TTNetDiagnosisRequest
    public void cancel() {
        Object r0 = this.mNetDiagnosisRequestAdapterLock;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (isDoneLocked() == false) goto L7;
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L7:
        if (this.mStarted == false) goto L14;
        destroyRequestAdapterLocked();     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
    }

    @Override // com.ttnet.org.chromium.net.TTNetDiagnosisRequest
    public void doExtraCommand(String r9, String r10) {
        Object r0 = this.mNetDiagnosisRequestAdapterLock;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (isDoneLocked() == false) goto L7;
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L7:
        if (this.mStarted == false) goto L14;
        TTCronetNetExpRequestJni.get().doExtraCommand(this.mNetDiagnosisRequestAdapter, this, r9, r10);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
    }

    @Override // com.ttnet.org.chromium.net.TTNetDiagnosisRequest
    public void start() {
        Object r0 = this.mNetDiagnosisRequestAdapterLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mStarted == false) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        Natives r1 = TTCronetNetExpRequestJni.get();     // Catch: Throwable -> L8
        long r3 = this.mRequestContext.getUrlRequestContextAdapter();     // Catch: Throwable -> L8
        int r5 = this.mRequestType;     // Catch: Throwable -> L8
        List<String> r2 = this.mTargets;     // Catch: Throwable -> L8
        long r4 = r1.createRequestAdapter(this, r3, r5, (String[]) r2.toArray(new String[r2.size()]), this.mNetDetectActions, this.mMultiNetAction, this.mTimeoutMs);     // Catch: Throwable -> L8
        this.mNetDiagnosisRequestAdapter = r4;     // Catch: Throwable -> L8
        if (r4 == 0) goto L16;
        this.mStarted = true;     // Catch: Throwable -> L8
        TTCronetNetExpRequestJni.get().start(this.mNetDiagnosisRequestAdapter, this);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L16:
        throw new NullPointerException("Create native net exp request adapter failed.");     // Catch: Throwable -> L8
    }
}
