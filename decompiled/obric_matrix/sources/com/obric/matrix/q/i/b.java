package com.obric.matrix.q.i;

import android.os.IBinder;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/obric/matrix/base/tunnel/ClientDeathRecipient;", "Landroid/os/IBinder$DeathRecipient;", "packageName", "", "(Ljava/lang/String;)V", "getPackageName", "()Ljava/lang/String;", "binderDied", "", "Companion", "internal_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class b implements IBinder.DeathRecipient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f9906a;

    static {
    }

    public b(String r2) {
        o.f(r2, "packageName");
        this.f9906a = r2;
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
        com.obric.matrix.r.c.c.b("ClientDeathRecipient", "binderDied is invoked for " + this.f9906a);
        com.obric.matrix.platform.e.b r0 = a.g(a.f9901a, this.f9906a, false, 2, null);
        if (r0 == null) goto L13;
        IBinder r1 = r0.asBinder();     // Catch: Exception -> L8
        if (r1 == null) goto L14;
        r1.unlinkToDeath(this, 0);     // Catch: Exception -> L8
        return;
    L14:
        return;
    L8:
        e = move-exception;
        com.obric.matrix.r.c.c.f("ClientDeathRecipient", "the exception occurred when unlinkToDeath is invoked that message is " + e.getMessage());
        return;
    }
}
