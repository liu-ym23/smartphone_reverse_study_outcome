package tj;

import com.bytedance.ttnet.cronet.AbsCronetDependAdapter;

/* JADX INFO: loaded from: classes2.dex */
public final class o extends e8.f {
    public final /* synthetic */ int d;
    public final /* synthetic */ double e;
    public final /* synthetic */ double f;
    public final /* synthetic */ double g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ double f22135h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ AbsCronetDependAdapter f22136i;

    public o(AbsCronetDependAdapter r5, int r10, double r11, double r12, double r13, double r14) {
        this.f22136i = r5;
        this.d = r10;
        this.e = r11;
        this.f = r12;
        this.g = r13;
        this.f22135h = r14;
    }

    @Override // java.lang.Runnable
    public final void run() {
        double r10 = this.g;
        double r11 = this.f22135h;
        this.f22136i.onNQEPacketLossComputed(this.d, this.e, this.f, r10, r11);
    }
}
