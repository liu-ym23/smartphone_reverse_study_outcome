package d.b.c.b;

import android.os.Handler;
import com.bytedance.bdlocation.callback.BDLocationCallback;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.client.LocationOption;
import d.b.c.d.h;
import d.b.c.d.k;
import d.b.c.d.l;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f13085a;

    public a() {
    }

    public static a a() {
        if (f13085a != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f13085a != null) goto L9;
        f13085a = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f13085a;
    }

    public BDLocationCallback b(BDLocationCallback r1, LocationOption r2, h.l r3, Handler r4) {
        if (BDLocationConfig.isOverSeas() == false) goto L6;
        return new l(r1, r2, r3, r4);
    L6:
        return new k(r1, r2, r3, r4);
    }
}
