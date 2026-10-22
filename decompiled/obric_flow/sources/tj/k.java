package tj;

import com.bytedance.ttnet.cronet.AbsCronetDependAdapter;

/* JADX INFO: loaded from: classes2.dex */
public final class k extends e8.f {
    public final /* synthetic */ String d;
    public final /* synthetic */ AbsCronetDependAdapter e;

    public k(AbsCronetDependAdapter r5, String r10) {
        this.e = r5;
        this.d = r10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.e.onTTNetDetectResult(this.d);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }
}
