package tj;

import com.bytedance.ttnet.cronet.AbsCronetDependAdapter;

/* JADX INFO: loaded from: classes2.dex */
public final class n extends e8.f {
    public final /* synthetic */ int d;
    public final /* synthetic */ int e;
    public final /* synthetic */ int f;
    public final /* synthetic */ AbsCronetDependAdapter g;

    public n(AbsCronetDependAdapter r5, int r10, int r11, int r12) {
        this.g = r5;
        this.d = r10;
        this.e = r11;
        this.f = r12;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r5 = this.e;
        int r10 = this.f;
        this.g.onNQERTTOrThroughputComputed(this.d, r5, r10);
    }
}
