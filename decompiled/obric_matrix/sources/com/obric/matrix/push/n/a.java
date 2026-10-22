package com.obric.matrix.push.n;

import android.content.Context;
import com.obric.matrix.push.n.b.d.c;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/matrix/push/common/CommonSupport;", "", "()V", "iCrossProcessService", "Lcom/obric/matrix/push/common/cross_process/interfaze/ICrossProcessService;", "getCrossProcessService", "context", "Landroid/content/Context;", "sdk_push_common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9741a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static c f9742b;

    static {
        f9741a = new a();
    }

    private a() {
    }

    public final c a(Context r2) {
        o.f(r2, "context");
        if (f9742b != null) goto L14;
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L6:
        if (f9742b != null) goto L8;
        f9742b = new com.obric.matrix.push.n.b.a(r2);     // Catch: Throwable -> L11
    L8:
        f0 r3 = f0.f18324a;     // Catch: Throwable -> L11
        monitor-exit(this);
    L14:
        c r1 = f9742b;
        o.c(r1);
        return r1;
    }
}
