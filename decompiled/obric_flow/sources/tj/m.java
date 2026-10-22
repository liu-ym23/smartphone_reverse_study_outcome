package tj;

import com.bytedance.ttnet.cronet.AbsCronetDependAdapter;

/* JADX INFO: loaded from: classes2.dex */
public final class m extends e8.f {
    public final /* synthetic */ int d;
    public final /* synthetic */ AbsCronetDependAdapter e;

    public m(AbsCronetDependAdapter r5, int r10) {
        this.e = r5;
        this.d = r10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.e.onNQEEffectiveConnectionTypeChanged(this.d);
    }
}
