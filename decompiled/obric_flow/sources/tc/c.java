package tc;

import android.util.Log;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile c f22119c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f22120a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f22121b;

    static {
        f22119c = new c();
    }

    public c() {
        this.f22120a = new ConcurrentHashMap();
        this.f22121b = new ConcurrentHashMap();
    }

    public final rc.c a(Class r5, String r10) {
        Intrinsics.checkNotNullParameter(r10, "bid");
        Intrinsics.checkNotNullParameter(r5, "clazz");
        d r11 = b(r10);
        String r12 = r5.getName();
        Intrinsics.checkNotNullParameter(r12, "clazzName");
        rc.c r13 = (rc.c) r11.f22122a.get(r12);
        if (r13 == null) goto L5;
        return r13;
    L5:
        d r14 = b("default_bid");
        String r15 = r5.getName();
        Intrinsics.checkNotNullParameter(r15, "clazzName");
        rc.c r16 = (rc.c) r14.f22122a.get(r15);
        if ((r16 instanceof rc.c) == false) goto L8;
        return r16;
    L8:
        return null;
    }

    public final d b(String r5) {
        ConcurrentHashMap r10 = this.f22120a;
        d r11 = (d) r10.get(r5);
        if (r11 != null) goto L9;
        Log.d("XInit", "no serviceMap for bid=" + r5);
        com.lynx.animax.player.b r12 = new com.lynx.animax.player.b(15);
        Intrinsics.checkNotNullParameter(r5, "bid");
        r12.f9658c = r5;
        d r13 = new d(r12);
        r10.put(r5, r13);
        Intrinsics.checkNotNullParameter(r5, "bid");
        if (this.f22121b.get(r5) != null) goto L8;
        return r13;
    L8:
        throw new ClassCastException();
    L9:
        return r11;
    }

    public final void c(String r5, Class r10, a r11) {
        Intrinsics.checkNotNullParameter(r5, "bid");
        Intrinsics.checkNotNullParameter(r10, "clazz");
        Intrinsics.checkNotNullParameter(r11, "serviceInst");
        b(r5).a(r10.getName(), r11);
    }
}
