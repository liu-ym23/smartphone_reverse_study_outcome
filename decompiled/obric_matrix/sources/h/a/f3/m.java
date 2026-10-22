package h.a.f3;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"ANDROID_DETECTED", "", "getANDROID_DETECTED", "()Z", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final boolean f17396a = false;

    static {
        kotlin.v.a r0 = kotlin.v.f21457g;     // Catch: Throwable -> L4
        Object r1 = Class.forName("android.os.Build");     // Catch: Throwable -> L4
        kotlin.v.b(r1);     // Catch: Throwable -> L4
    L6:
        f17396a = kotlin.v.g(r1);
        return;
    L4:
        th = move-exception;
        kotlin.v.a r2 = kotlin.v.f21457g;
        r1 = kotlin.w.a(th);
        kotlin.v.b(r1);
        goto L6
    }

    public static final boolean a() {
        return f17396a;
    }
}
