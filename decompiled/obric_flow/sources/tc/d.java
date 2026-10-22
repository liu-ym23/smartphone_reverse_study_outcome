package tc;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f22122a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f22123b;

    public d(com.lynx.animax.player.b r5) {
        ConcurrentHashMap r10 = new ConcurrentHashMap();
        this.f22122a = r10;
        this.f22123b = (String) r5.f9658c;
        r10.putAll((ConcurrentHashMap) r5.f9657b);
    }

    public final void a(String r5, rc.c r10) {
        Intrinsics.checkNotNullParameter(r5, "clazzName");
        Intrinsics.checkNotNullParameter(r10, "serviceInst");
        ConcurrentHashMap r11 = this.f22122a;
        rc.c r12 = (rc.c) r11.get(r5);
        String r13 = this.f22123b;
        if (r13 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("bid");
        r13 = null;
    L5:
        r10.a(r13);
        r11.put(r5, r10);
    }
}
