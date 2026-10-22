package yc;

import androidx.core.app.NotificationCompat;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import tc.c;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap f23246a = null;

    static {
        f23246a = new ConcurrentHashMap(3);
    }

    public static Object a(Class r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "cls");
        ConcurrentHashMap r11 = f23246a;
        Map r12 = (Map) r11.get(r10);
        if (r12 != null) goto L13;
        androidx.constraintlayout.motion.widget.a.A("no serviceGroup for bid=", r10, "XInit");
        c r13 = c.f22119c;
        c r14 = c.f22119c;
        if (r10 != null) goto L7;
        r10 = "default_bid";
    L7:
        r14.getClass();
        Intrinsics.checkNotNullParameter(r10, "bid");
        if (r14.f22121b.get(r10) == null) goto L13;
        throw new ClassCastException();
    L13:
        if (r12 == null) goto L16;
        Object r15 = r12.get(r5);
        if (r15 == null) goto L16;
    L20:
        if (r15 != null) goto L22;
        return null;
    L22:
        return r15;
    L16:
        Map r16 = (Map) r11.get("default_bid");
        if (r16 == null) goto L19;
        r15 = r16.get(r5);
        goto L20
    L19:
        r15 = null;
        goto L20
    }

    public static void b(Class r5, Object r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, "bid");
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_SERVICE);
        ConcurrentHashMap r12 = f23246a;
        Map r13 = (Map) r12.get(r11);
        if (r13 != null) goto L5;
        r13 = new ConcurrentHashMap(3);
        r12.put(r11, r13);
    L5:
        r13.put(r5, r10);
    }
}
