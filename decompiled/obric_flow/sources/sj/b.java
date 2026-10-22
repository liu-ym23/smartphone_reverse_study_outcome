package sj;

import android.content.Context;
import com.bytedance.common.utility.Logger;
import com.bytedance.ttnet.TTNetInit;
import com.bytedance.ttnet.tnc.TNCManager$TNCUpdateSource;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends e8.f {
    public final /* synthetic */ TNCManager$TNCUpdateSource d;
    public final /* synthetic */ boolean e;
    public final /* synthetic */ d f;

    public b(d r5, TNCManager$TNCUpdateSource r10, boolean r11) {
        this.f = r5;
        this.d = r10;
        this.e = r11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        d r5 = this.f;
        r5.getClass();
        if (Logger.debug() == false) goto L5;
        Logger.d("TNCManager", "doRefresh, actual request");
    L5:
        Context r10 = r5.e;
        if (com.bytedance.common.utility.f.c(r10) == true) goto L8;
        return;
    L8:
        r5.k();
        r5.b();
        if (this.e == true) goto L18;
        yj.b.a().getClass();
        Logger.d("TNCManager", "getdomain internal, use retrofit okhttp: true, tnc source: " + this.d);
        ArrayList r11 = new ArrayList();
        if (d.h(r10).f21920r != null) goto L13;
    L16:
        d.h(r10).getClass();
        TTNetInit.getTTNetDepend();
        throw null;
    L13:
        if (d.h(r10).f21920r.size() == 0) goto L16;
        r11.addAll(d.h(r10).f21920r);
        d.h(r10).getClass();
        TTNetInit.getTTNetDepend();
        throw null;
    L18:
        TTNetInit.getTTNetDepend();
        throw null;
    }
}
