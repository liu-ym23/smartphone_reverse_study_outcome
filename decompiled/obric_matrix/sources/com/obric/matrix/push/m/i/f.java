package com.obric.matrix.push.m.i;

import android.app.Application;
import android.content.Intent;
import android.text.TextUtils;
import com.obric.matrix.push.k;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J \u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/matrix/push/base/message/RevokeMsgHandlerService;", "Lcom/obric/matrix/push/base/message/IRevokeMsgHandlerService;", "()V", "TAG", "", "handlerRevokeMsg", "", "revokeMsg", "Lcom/obric/matrix/push/Revoke;", "onHandlerRevoke", "msgId", "pkgName", "result", "", "push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class f implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f9711a;

    public f() {
        this.f9711a = "RevokeMsgHandlerService";
    }

    @Override // com.obric.matrix.push.m.i.d
    public void a(String r1, String r2, int r3) {
        o.f(r1, "msgId");
        o.f(r2, "pkgName");
        com.obric.matrix.push.m.b.f9633a.c().f(r1, r2, r3);
    }

    @Override // com.obric.matrix.push.m.i.d
    public void b(k r6) {
        o.f(r6, "revokeMsg");
        if (TextUtils.isEmpty(r6.f9612f) == false) goto L5;
    L29:
        com.obric.matrix.push.m.d.c r5 = com.obric.matrix.push.m.b.f9633a.c();
        String r0 = r6.f9612f;
        o.e(r0, "revokeMsg.id");
        String r7 = r6.f9614h;
        o.e(r7, "revokeMsg.package_name");
        int r1 = com.obric.matrix.push.p.b.h0.P();
    L10:
        r5.f(r0, r7, r1);
        return;
    L5:
        if (TextUtils.isEmpty(r6.f9615i) == true) goto L29;
        com.obric.matrix.push.r.e r2 = com.obric.matrix.push.r.e.f9794a;
        String r3 = r6.f9614h;
        o.e(r3, "revokeMsg.package_name");
        if (r2.s(r3) == true) goto L12;
        com.obric.matrix.push.n.c.c.e(this.f9711a, "onHandler error, target pkg no exists, [" + r6.f9614h + ']', null, 4, null);
        r5 = com.obric.matrix.push.m.b.f9633a.c();
        r0 = r6.f9612f;
        o.e(r0, "revokeMsg.id");
        r7 = r6.f9614h;
        o.e(r7, "revokeMsg.package_name");
        r1 = com.obric.matrix.push.p.b.h0.I();
        goto L10
    L12:
        Application r4 = com.bytedance.mpaas.app.a.b();
        Integer r8 = r6.f9613g;
        if (r8 != null) goto L16;
    L18:
        Integer r9 = r6.f9613g;
        if (r9 != null) goto L22;
        return;
    L22:
        if (r9.intValue() != 2) goto L33;
        Intent r10 = new Intent();
        r10.setPackage(r6.f9614h);
        r10.setAction(r6.f9614h + ".action.MESSAGE_EVENT");
        r10.putExtra("msg_type", 2);
        r10.putExtra("msg_id", r6.f9612f);
        r10.putExtra("revoke_id", r6.f9615i);
        r10.putExtra("revoke_data", r6.f9616j);
        r4.sendBroadcast(r10);     // Catch: Throwable -> L26
        return;
    L26:
        th = move-exception;
        com.obric.matrix.r.c.c.g(this.f9711a, "send revoke broadcast error", th);
        return;
    L33:
        return;
    L16:
        if (r8.intValue() != 1) goto L18;
        com.obric.matrix.push.m.b.f9633a.v().b(r6);
    }
}
