package androidx.constraintlayout.core.state;

import com.bytedance.frameworks.baselib.network.http.cronet.impl.BaseCronetSsCall;
import com.bytedance.frameworks.baselib.network.http.storeregion.StoreRegionManager;
import com.bytedance.ttnet.diagnosis.IDiagnosisCallback;
import com.bytedance.ttnet.diagnosis.TTGameDiagnosisService;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements Interpolator, StoreRegionManager.StoreRegionCallback, IDiagnosisCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1a;

    public /* synthetic */ b(int r1) {
        this.f1a = r1;
    }

    @Override // androidx.constraintlayout.core.state.Interpolator
    public float getInterpolation(float r1) {
        switch(this.f1a) {
            case 0: goto L17;
            case 1: goto L15;
            case 2: goto L13;
            case 3: goto L11;
            case 4: goto L9;
            case 5: goto L7;
            default: goto L5;
        };
    L5:
        return Transition.b(r1);
    L7:
        return Transition.g(r1);
    L9:
        return Transition.c(r1);
    L11:
        return Transition.e(r1);
    L13:
        return Transition.f(r1);
    L15:
        return Transition.h(r1);
    L17:
        return Transition.a(r1);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.storeregion.StoreRegionManager.StoreRegionCallback
    public void notifyStoreRegionUpdatedForCronet(String r1, String r2, String r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10, String r11) {
        BaseCronetSsCall.a(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
    }

    @Override // com.bytedance.ttnet.diagnosis.IDiagnosisCallback
    public void onDiagnosisComplete(String r1) {
        TTGameDiagnosisService.a(r1);
    }
}
