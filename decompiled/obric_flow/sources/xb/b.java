package xb;

import java.util.HashMap;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bd.d f23005a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a6.c f23006b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap f23007c;

    public b(JSONObject r5, bd.d r10, a6.c r11) {
        Intrinsics.checkNotNullParameter(r11, "signature");
        this.f23005a = r10;
        this.f23006b = r11;
        this.f23007c = new HashMap();
        if (r5 == null) goto L5;
        Iterator<String> r12 = r5.keys();
    L6:
        if (r12 == null) goto L10;
        if (r12.hasNext() != true) goto L14;
        String r13 = r12.next();
        String r14 = r5.optString(r13);
        this.f23007c.put(r13, r14);
        goto L6
    L14:
        return;
    L10:
        return;
    L5:
        r12 = null;
        goto L6
    }
}
