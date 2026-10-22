package v0;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;
import w0.l;

/* JADX INFO: loaded from: classes.dex */
public final class e extends com.bytedance.android.anniex.base.service.e {
    public static final Lazy f = null;

    static {
        f = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new s1.b(4));
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.ai.model.widgets.a, w0.l] */
    public static l n() {
        Lazy r5 = d.f22502n;
        return cl.a.h().f22506k;
    }

    public final boolean o(String r5) {
        Intrinsics.checkNotNullParameter(r5, "viewId");
        Intrinsics.checkNotNullParameter("FloatingViewManagerDelegate", "tag");
        t0.d r10 = com.bytedance.ai.utils.c.f2846a;
        if (r10 == null) goto L5;
        r10.i("FloatingViewManagerDelegate", "remove floating window");
    L5:
        Lazy r11 = d.f22502n;
        if (cl.a.h().s() == true) goto L8;
        return true;
    L8:
        return cl.a.h().q(r5);
    }
}
