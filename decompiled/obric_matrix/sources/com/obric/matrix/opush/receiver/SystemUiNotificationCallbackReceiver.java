package com.obric.matrix.opush.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.obric.matrix.opush.d.g.f;
import com.obric.matrix.opush.d.g.g;
import com.obric.matrix.opush.f.b;
import com.obric.matrix.opush.service.NotificationEventService;
import com.obric.matrix.r.c.c;
import kotlin.Metadata;
import kotlin.n0.d.o;
import kotlin.v;
import kotlin.w;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\u001c\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\u000e"}, d2 = {"Lcom/obric/matrix/opush/receiver/SystemUiNotificationCallbackReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "bundleToString", "", "bundle", "Landroid/os/Bundle;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "Companion", "o_push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SystemUiNotificationCallbackReceiver extends BroadcastReceiver {
    static {
    }

    public SystemUiNotificationCallbackReceiver() {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r11, Intent r12) {
        if (r11 == null) goto L47;
        if (r12 != null) goto L6;
        return;
    L6:
        if (o.a(r12.getAction(), "com.android.systemui.action.NOTIFICATION_POSTED_CALLBACK") == false) goto L50;
        v.a r3 = v.f21457g;     // Catch: Throwable -> L40
        String r13 = r12.getStringExtra("notification_extras");     // Catch: Throwable -> L40
        if (r13 != null) goto L11;
        String r4 = "{}";
    L12:
        JSONObject r5 = new JSONObject(r4);     // Catch: Throwable -> L40
        String r6 = r5.getString("msg_id");     // Catch: Throwable -> L40
        String r7 = "";
        if (r6 != null) goto L16;
        r6 = "";
    L16:
        String r8 = r5.getString("package_name");     // Catch: Throwable -> L40
        if (r8 != null) goto L19;
        r8 = "";
    L19:
        String r9 = r5.getString("additional_data");     // Catch: Throwable -> L40
        if (r9 == null) goto L23;
        r7 = r9;
    L23:
        c.j("SystemUiNotifyCbRcvr", "posted callback received, msgId=" + r6 + " pkgName=" + r8);     // Catch: Throwable -> L40
        boolean r10 = true;
        if (r6.length() != 0) goto L26;
        boolean r14 = true;
    L27:
        if (r14 == false) goto L29;
    L38:
        c.f("SystemUiNotifyCbRcvr", "posted callback missing identity fields, extras=" + r13);     // Catch: Throwable -> L40
        return;
    L29:
        if (r8.length() == 0) goto L32;
        r10 = false;
    L32:
        if (r10 == true) goto L38;
        JSONObject r15 = new JSONObject();     // Catch: Throwable -> L40
        r15.put("msg_id", r6);     // Catch: Throwable -> L40
        r15.put("package_name", r8);     // Catch: Throwable -> L40
        r15.put("additional_data", r7);     // Catch: Throwable -> L40
        g r16 = g.f9359a;     // Catch: Throwable -> L40
        f r0 = r16.b(r5);     // Catch: Throwable -> L40
        if (r0 == null) goto L37;
        r16.f(r15, r0);     // Catch: Throwable -> L40
    L37:
        Object r17 = r11.startService(NotificationEventService.f9442f.a(r11, r15, b.G.E()));     // Catch: Throwable -> L40
        v.b(r17);     // Catch: Throwable -> L40
    L42:
        Throwable r18 = v.d(r17);
        if (r18 == null) goto L49;
        c.f("SystemUiNotifyCbRcvr", "posted callback handle failed, error: " + r18);
        return;
    L49:
        return;
    L26:
        r14 = false;
        goto L27
    L11:
        r4 = r13;
    L40:
        th = move-exception;
        v.a r19 = v.f21457g;
        r17 = w.a(th);
        v.b(r17);
        goto L42
    L50:
        return;
    }
}
