package com.obric.matrix.push.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.obric.matrix.push.n.c.c;
import com.obric.matrix.push.p.b;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\n"}, d2 = {"Lcom/obric/matrix/push/receiver/PushHandlerReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "Companion", "push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PushHandlerReceiver extends BroadcastReceiver {
    static {
    }

    public PushHandlerReceiver() {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r5, Intent r6) {
        if (r5 == null) goto L37;
        if (r6 == null) goto L46;
        c.b("PushHandlerReceiver", "onReceive, action: " + r6.getAction());
        String r4 = r6.getAction();
        b r1 = b.h0;
        if (o.a(r4, r1.a()) == false) goto L18;
        Bundle r7 = r6.getExtras();
        if (r7 == null) goto L10;
        Integer r8 = Integer.valueOf(r7.getInt(r1.C()));
    L11:
        c.b("PushHandlerReceiver", "onReceive , on updateDevice alarm task, requestCode is " + r8);
        int r0 = r1.D();
        if (r8 != null) goto L15;
        return;
    L15:
        if (r8.intValue() != r0) goto L41;
        com.obric.matrix.push.m.c.b.a.a(com.obric.matrix.push.m.b.f9633a.b(), r5, false, 2, null);
        return;
    L41:
        return;
    L10:
        r8 = null;
        goto L11
    L18:
        if (o.a(r4, r1.b()) == false) goto L32;
        String r9 = r6.getStringExtra("msg_id");     // Catch: Exception -> L28
        if (r9 == null) goto L27;
        String r10 = r6.getStringExtra("package_name");     // Catch: Exception -> L28
        if (r10 == null) goto L25;
        com.obric.matrix.push.m.k.c.f9716a.d(r6, r1.b());     // Catch: Exception -> L28
        com.obric.matrix.push.m.b.f9633a.x().c(r9, r10, r6);     // Catch: Exception -> L28
        return;
    L25:
        throw new Exception("pkgName is null");     // Catch: Exception -> L28
    L27:
        throw new Exception("msgId is null");     // Catch: Exception -> L28
    L28:
        e = e;
        StringBuilder r11 = new StringBuilder();
        String r12 = "onReceive, handle click push error: ";
    L30:
        r11.append(r12);
        r11.append(e);
        com.obric.matrix.r.c.c.f("PushHandlerReceiver", r11.toString());
        return;
    L32:
        if (o.a(r4, r1.c()) == false) goto L45;
        com.obric.matrix.push.m.k.c.f9716a.d(r6, r1.c());     // Catch: Exception -> L35
        return;
    L35:
        e = e;
        r11 = new StringBuilder();
        r12 = "onReceive, handle delete push error: ";
        goto L30
    L45:
        return;
    L46:
        return;
    }
}
