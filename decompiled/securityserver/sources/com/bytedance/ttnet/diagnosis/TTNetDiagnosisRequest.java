package com.bytedance.ttnet.diagnosis;

import com.bytedance.frameworks.baselib.network.http.cronet.diagnosis.ICronetDiagnosisRequest;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class TTNetDiagnosisRequest implements IDiagnosisRequest {
    private static final String CRONET_DIAGNOSIS_REQUEST_IMPL_CLASS = "org.chromium.diagnosis.CronetDiagnosisRequestImpl";
    private static final String TAG = "TTNetDiagnosisRequest";
    private IDiagnosisCallback mCallback;
    private boolean mCanceled;
    private ICronetDiagnosisRequest mCronetDiagnosisRequest;
    private ICronetDiagnosisRequest.Callback mCronetDiagnosisRequestCallback;
    private String mExtraInfo;
    private int mMultiNetAction;
    private int mNetDetectType;
    private int mReqType;
    private boolean mStarted;
    private List<String> mTargets;
    private int mTimeoutMs;

    public class CallbackImpl implements ICronetDiagnosisRequest.Callback {
        final /* synthetic */ TTNetDiagnosisRequest this$0;

        public CallbackImpl(TTNetDiagnosisRequest r1) {
            this.this$0 = r1;
        }

        @Override // com.bytedance.frameworks.baselib.network.http.cronet.diagnosis.ICronetDiagnosisRequest.Callback
        public void onNetDiagnosisRequestComplete(String r2) {
            if (TTNetDiagnosisRequest.access$000(this.this$0) == null) goto L6;
            TTNetDiagnosisRequest.access$000(this.this$0).onDiagnosisComplete(r2);
            return;
        }
    }

    public TTNetDiagnosisRequest(int r2, List<String> r3, int r4, int r5, int r6) {
        this.mCronetDiagnosisRequestCallback = new CallbackImpl(this);
        this.mStarted = false;
        this.mCanceled = false;
        this.mReqType = r2;
        this.mTargets = r3;
        this.mNetDetectType = r4;
        this.mMultiNetAction = r5;
        this.mTimeoutMs = r6;
        tryResolveCronetDiagnosisRequest();
    }

    public static /* synthetic */ IDiagnosisCallback access$000(TTNetDiagnosisRequest r0) {
        return r0.mCallback;
    }

    private Class<?> checkClass(String r1) {
        return Class.forName(r1);
    L4:
        return null;
    }

    private void tryResolveCronetDiagnosisRequest() {
        if (this.mCronetDiagnosisRequest != null) goto L11;
        Class<?> r0 = checkClass(CRONET_DIAGNOSIS_REQUEST_IMPL_CLASS);
        if (r0 == null) goto L10;
        Class r6 = Integer.TYPE;
        Object r1 = r0.getDeclaredConstructor(new Class[]{ICronetDiagnosisRequest.Callback.class, r6, List.class, r6, r6, r6}).newInstance(new Object[]{this.mCronetDiagnosisRequestCallback, Integer.valueOf(this.mReqType), this.mTargets, Integer.valueOf(this.mNetDetectType), Integer.valueOf(this.mMultiNetAction), Integer.valueOf(this.mTimeoutMs)});
        if ((r1 instanceof ICronetDiagnosisRequest) == false) goto L12;
        this.mCronetDiagnosisRequest = (ICronetDiagnosisRequest) r1;
        return;
    L12:
        return;
    L10:
        throw new ClassNotFoundException("org.chromium.diagnosis.CronetDiagnosisRequestImpl class not found");
    }

    @Override // com.bytedance.ttnet.diagnosis.IDiagnosisRequest
    public void cancel() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.mStarted == true) goto L6;
    L13:
        monitor-exit(this);     // Catch: Throwable -> L11
        return;
    L6:
        if (this.mCanceled == true) goto L13;
        this.mCronetDiagnosisRequest.cancel();     // Catch: Throwable -> L11
        this.mCanceled = true;     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
    }

    @Override // com.bytedance.ttnet.diagnosis.IDiagnosisRequest
    public void doExtraCommand(String r2, String r3) {
        monitor-enter(this);
    L7:
        th = move-exception;
        throw th;
    L4:
        if (this.mStarted == true) goto L9;
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L9:
        this.mCronetDiagnosisRequest.doExtraCommand(r2, r3);     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
    }

    @Override // com.bytedance.ttnet.diagnosis.IDiagnosisRequest
    public void setUserExtraInfo(String r2) {
        monitor-enter(this);
        this.mExtraInfo = r2;     // Catch: Throwable -> L6
        doExtraCommand("extra_info", r2);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.ttnet.diagnosis.IDiagnosisRequest
    public void start(IDiagnosisCallback r2) {
        monitor-enter(this);
    L7:
        th = move-exception;
        throw th;
    L4:
        if (this.mStarted == false) goto L9;
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L9:
        this.mCallback = r2;     // Catch: Throwable -> L7
        this.mCronetDiagnosisRequest.start();     // Catch: Throwable -> L7
        this.mStarted = true;     // Catch: Throwable -> L7
        String r3 = this.mExtraInfo;     // Catch: Throwable -> L7
        if (r3 != null) goto L12;
    L14:
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L12:
        if (r3.isEmpty() == true) goto L14;
        doExtraCommand("extra_info", this.mExtraInfo);     // Catch: Throwable -> L7
        goto L14
    }
}
