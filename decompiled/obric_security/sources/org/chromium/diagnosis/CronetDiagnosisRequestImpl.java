package org.chromium.diagnosis;

import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.frameworks.baselib.network.http.cronet.diagnosis.ICronetDiagnosisRequest;
import com.ttnet.org.chromium.net.CronetEngine;
import com.ttnet.org.chromium.net.TTNetDiagnosisRequest;
import java.util.List;
import org.chromium.CronetClient;

/* JADX INFO: loaded from: classes5.dex */
public class CronetDiagnosisRequestImpl implements ICronetDiagnosisRequest {
    private static final String TAG = "CronetDiagnosisRequestImpl";
    private static final String TTNET_INIT_CLASS = "com.bytedance.ttnet.TTNetInit";
    private static CronetEngine sCronetEngine;
    private ICronetDiagnosisRequest.Callback mCallback;
    private CallbackImpl mCronetCallback;
    private TTNetDiagnosisRequest mRequest;

    class CallbackImpl implements TTNetDiagnosisRequest.Callback {
        final /* synthetic */ CronetDiagnosisRequestImpl this$0;

        CallbackImpl(CronetDiagnosisRequestImpl r1) {
            this.this$0 = r1;
        }

        @Override // com.ttnet.org.chromium.net.TTNetDiagnosisRequest.Callback
        public void onNetDiagnosisRequestComplete(TTNetDiagnosisRequest r1, String r2) {
            CronetDiagnosisRequestImpl.access$000(this.this$0).onNetDiagnosisRequestComplete(r2);
        }
    }

    static {
    }

    static /* synthetic */ ICronetDiagnosisRequest.Callback access$000(CronetDiagnosisRequestImpl r0) {
        return r0.mCallback;
    }

    public CronetDiagnosisRequestImpl(ICronetDiagnosisRequest.Callback r3, int r4, List<String> r5, int r6, int r7, int r8) throws Exception {
        this.mRequest = null;
        this.mCronetCallback = new CallbackImpl(this);
        this.mCallback = r3;
        if (sCronetEngine != null) goto L5;
        sCronetEngine = getCronetEngine();
    L5:
        CronetEngine r9 = sCronetEngine;
        if (r9 == null) goto L10;
        TTNetDiagnosisRequest.Builder r10 = r9.newNetDiagnosisRequestBuilder(this.mCronetCallback, null);
        r10.setRequestType(r4).setTargets(r5).setNetDetectType(r6).setMultiNetAction(r7).setTimeout(r8);
        this.mRequest = r10.build();
        return;
    L10:
        throw new UnsupportedOperationException("Can not get cronet engine.");
    }

    private CronetEngine getCronetEngine() {
        if (Logger.debug() == false) goto L13;
        Logger.d(TAG, "Init cronet engine");
    L13:
        loadCronetKernel();     // Catch: Throwable -> L7
    L12:
        return CronetClient.getCronetEngine();
    L7:
        th = move-exception;
        th.printStackTrace();
        if (Logger.debug() == false) goto L12;
        Logger.d(TAG, "TTNet init failed, cronet engine is null.");
        goto L12
    }

    private static void loadCronetKernel() throws Exception {
        Reflect.on(Class.forName(TTNET_INIT_CLASS).newInstance()).call("preInitCronetKernel");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.diagnosis.ICronetDiagnosisRequest
    public void start() {
        TTNetDiagnosisRequest r0 = this.mRequest;
        if (r0 == null) goto L6;
        r0.start();
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.diagnosis.ICronetDiagnosisRequest
    public void cancel() {
        TTNetDiagnosisRequest r0 = this.mRequest;
        if (r0 == null) goto L6;
        r0.cancel();
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.diagnosis.ICronetDiagnosisRequest
    public void doExtraCommand(String r1, String r2) {
        TTNetDiagnosisRequest r0 = this.mRequest;
        if (r0 == null) goto L6;
        r0.doExtraCommand(r1, r2);
        return;
    }
}
