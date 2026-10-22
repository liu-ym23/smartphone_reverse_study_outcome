package com.obric.matrix.opush.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.obric.matrix.opush.c;
import com.obric.matrix.opush.f.b;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\n"}, d2 = {"Lcom/obric/matrix/opush/receiver/PushHandlerReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "Companion", "o_push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PushHandlerReceiver extends BroadcastReceiver {
    static {
    }

    public PushHandlerReceiver() {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r6, Intent r7) {
        if (r6 == null) goto L37;
        if (r7 == null) goto L46;
        c r5 = c.f9247a;
        r5.b("PushHandlerReceiver", "onReceive, action: " + r7.getAction());
        String r0 = r7.getAction();
        b r2 = b.G;
        if (o.a(r0, r2.a()) == false) goto L18;
        Bundle r8 = r7.getExtras();
        if (r8 == null) goto L10;
        Integer r9 = Integer.valueOf(r8.getInt(r2.r()));
    L11:
        r5.b("PushHandlerReceiver", "onReceive , on updateDevice alarm task, requestCode is " + r9);
        int r10 = r2.s();
        if (r9 != null) goto L15;
        return;
    L15:
        if (r9.intValue() != r10) goto L41;
        com.obric.matrix.opush.d.c.b.a.a(com.obric.matrix.opush.d.b.f9251a.b(), r6, false, 2, null);
        return;
    L41:
        return;
    L10:
        r9 = null;
        goto L11
    L18:
        if (o.a(r0, r2.b()) == false) goto L32;
        String r11 = r7.getStringExtra("msg_id");     // Catch: Exception -> L28
        if (r11 == null) goto L27;
        String r12 = r7.getStringExtra("package_name");     // Catch: Exception -> L28
        if (r12 == null) goto L25;
        com.obric.matrix.opush.d.h.b.f9375a.e(r7, r2.b());     // Catch: Exception -> L28
        com.obric.matrix.opush.d.b.f9251a.s().a(r11, r12, r7);     // Catch: Exception -> L28
        return;
    L25:
        throw new Exception("pkgName is null");     // Catch: Exception -> L28
    L27:
        throw new Exception("msgId is null");     // Catch: Exception -> L28
    L28:
        e = e;
        StringBuilder r13 = new StringBuilder();
        String r14 = "onReceive, handle click push error: ";
    L30:
        r13.append(r14);
        r13.append(e);
        com.obric.matrix.r.c.c.f("PushHandlerReceiver", r13.toString());
        return;
    L32:
        if (o.a(r0, r2.c()) == false) goto L45;
        com.obric.matrix.opush.d.h.b.f9375a.e(r7, r2.c());     // Catch: Exception -> L35
        return;
    L35:
        e = e;
        r13 = new StringBuilder();
        r14 = "onReceive, handle delete push error: ";
        goto L30
    L45:
        return;
    L46:
        return;
    }
}
