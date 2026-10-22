package com.bytedance.sync.v2.l;

import com.bytedance.sync.v2.j.e;
import com.bytedance.sync.v2.j.j;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6160a = null;

    static {
        f6160a = new a();
    }

    private a() {
    }

    public final boolean a(int r2) {
        if (j.f6111k.getValue() != r2) goto L10;
        return true;
    L10:
        return false;
    L11:
        return false;
    }

    public final boolean b(int r2) {
        if (j.f6110j.getValue() != r2) goto L10;
        return true;
    L10:
        return false;
    L11:
        return false;
    }

    public final Integer c(e r2) {
        if (r2 != null) goto L8;
        return 0;
    L8:
        j r1 = r2.f6071g.get(0).f6074f;     // Catch: Throwable -> L7
        o.b(r1, "msg.topics[0].flag");     // Catch: Throwable -> L7
        return Integer.valueOf(r1.getValue());
    L7:
        return 0;
    }
}
