package tj;

import com.bytedance.ttnet.cronet.AbsCronetDependAdapter;

/* JADX INFO: loaded from: classes2.dex */
public final class l extends e8.f {
    public final /* synthetic */ String d;
    public final /* synthetic */ int e;
    public final /* synthetic */ AbsCronetDependAdapter f;

    public l(AbsCronetDependAdapter r5, String r10, int r11) {
        this.f = r5;
        this.d = r10;
        this.e = r11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String r5 = this.d;
        int r10 = this.e;
        this.f.onCronetMappingRequestStatus(r5, r10);
    }
}
