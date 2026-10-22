package org.chromium.diagnosis;

import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.reflect.Reflect;
import com.ttnet.org.chromium.net.CronetEngine;
import com.ttnet.org.chromium.net.TTNetDiagnosisRequest;
import java.util.List;
import org.chromium.CronetClient;

/* JADX INFO: loaded from: classes2.dex */
public class CronetDiagnosisRequestImpl implements com.bytedance.frameworks.baselib.network.http.cronet.d.a {
    private static final String TAG = "CronetDiagnosisRequestImpl";
    private static final String TTNET_INIT_CLASS = "com.bytedance.ttnet.TTNetInit";
    private static CronetEngine sCronetEngine;
    private com.bytedance.frameworks.baselib.network.http.cronet.d.a.InterfaceC0149a mCallback;
    private a mCronetCallback;
    private TTNetDiagnosisRequest mRequest;

    class a implements TTNetDiagnosisRequest.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ CronetDiagnosisRequestImpl f22667a;

        a(CronetDiagnosisRequestImpl r1) {
            this.f22667a = r1;
        }

        @Override // com.ttnet.org.chromium.net.TTNetDiagnosisRequest.Callback
        public void onNetDiagnosisRequestComplete(TTNetDiagnosisRequest r1, String r2) {
            CronetDiagnosisRequestImpl.access$000(this.f22667a).a(r2);
        }
    }

    static {
    }

    public CronetDiagnosisRequestImpl(com.bytedance.frameworks.baselib.network.http.cronet.d.a.InterfaceC0149a r3, int r4, List<String> r5, int r6, int r7, int r8) {
        this.mRequest = null;
        this.mCronetCallback = new a(this);
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

    static /* synthetic */ com.bytedance.frameworks.baselib.network.http.cronet.d.a.InterfaceC0149a access$000(CronetDiagnosisRequestImpl r0) {
        return r0.mCallback;
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

    private static void loadCronetKernel() {
        Reflect.on(Class.forName(TTNET_INIT_CLASS).newInstance()).call("preInitCronetKernel");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.d.a
    public void cancel() {
        TTNetDiagnosisRequest r0 = this.mRequest;
        if (r0 == null) goto L6;
        r0.cancel();
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.d.a
    public void doExtraCommand(String r1, String r2) {
        TTNetDiagnosisRequest r0 = this.mRequest;
        if (r0 == null) goto L6;
        r0.doExtraCommand(r1, r2);
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.d.a
    public void start() {
        TTNetDiagnosisRequest r0 = this.mRequest;
        if (r0 == null) goto L6;
        r0.start();
        return;
    }
}
