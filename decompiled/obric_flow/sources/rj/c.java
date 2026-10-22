package rj;

import android.content.Context;
import com.bytedance.ttnet.TTNetInit;
import com.bytedance.ttnet.tnc.TNCManager$TNCUpdateSource;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends e8.f {
    public final /* synthetic */ Context d;
    public final /* synthetic */ boolean e;

    public c(Context r5, boolean r10) {
        this.d = r5;
        this.e = r10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context r5 = this.d;
        sj.d.h(r5).k();
        sj.d.h(r5).l(TNCManager$TNCUpdateSource.TTSERVER, true);
        TTNetInit.access$000(r5, this.e, true);
    }
}
