package com.obric.matrix.push.m.k;

import android.app.Application;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.obric.matrix.push.g;
import kotlin.Metadata;
import kotlin.n0.d.o;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010J \u0010\u0011\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u0010J\u0016\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/obric/matrix/push/base/notification/NotificationPushEventHandler;", "", "()V", "PUSH_CLICK_TYPE_CUSTOM", "", "PUSH_CLICK_TYPE_DETAIL", "PUSH_CLICK_TYPE_HOME", "PUSH_CLICK_TYPE_URL", "TAG", "", "buildContentIntent", "Landroid/app/PendingIntent;", "context", "Landroid/content/Context;", "requestCode", "push", "Lcom/obric/matrix/push/Push;", "createIntent", "Landroid/content/Intent;", "action", "notifyPushShow", "", "processPushEvent", "notificationIntent", "push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f9716a = null;

    static {
        f9716a = new c();
    }

    private c() {
    }

    private final Intent b(Context r2, String r3, g r4) {
        Intent r1 = new Intent(r3);
        r1.putExtra("msg_id", r4.f9564f);
        r1.putExtra("package_name", r4.f9565g);
        Integer r5 = r4.p;
        if (r5 == null) goto L5;
        o.e(r5, "click_type");
        r1.putExtra("click_type", r5.intValue());
    L5:
        String r6 = r4.D;
        if (r6 == null) goto L8;
        o.e(r6, "additional_data");
        r1.putExtra("additional_data", r6);
    L8:
        String r7 = r4.q;
        if (r7 == null) goto L11;
        o.e(r7, "open_url");
        r1.putExtra("open_url", r4.q);
    L11:
        Integer r8 = r4.E;
        if (r8 == null) goto L14;
        o.e(r8, "open_url_type");
        r1.putExtra("open_url_type", r8.intValue());
    L14:
        r1.setPackage(r2.getPackageName());
        return r1;
    }

    public final PendingIntent a(Context r2, int r3, g r4) {
        o.f(r2, "context");
        o.f(r4, "push");
        return PendingIntent.getBroadcast(r2, r3, b(r2, com.obric.matrix.push.p.b.h0.b(), r4), 67108864);
    L5:
        th = move-exception;
        com.obric.matrix.r.c.c.f("NotificationPushEventHandler", "buildContentIntent error: " + th);
        return null;
    }

    public final void c(g r6) {
        o.f(r6, "push");
        Application r5 = com.bytedance.mpaas.app.a.b();     // Catch: Throwable -> L5
        com.obric.matrix.push.p.b r1 = com.obric.matrix.push.p.b.h0;     // Catch: Throwable -> L5
        Intent r0 = new Intent(r1.d());     // Catch: Throwable -> L5
        JSONObject r2 = new JSONObject();     // Catch: Throwable -> L5
        r2.put("msg_id", r6.f9564f);     // Catch: Throwable -> L5
        r2.put("package_name", r6.f9565g);     // Catch: Throwable -> L5
        r0.putExtra("data", r2.toString());     // Catch: Throwable -> L5
        r0.putExtra(r1.o(), r1.e0());     // Catch: Throwable -> L5
        r0.setPackage(r5.getPackageName());     // Catch: Throwable -> L5
        r5.startService(r0);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        com.obric.matrix.r.c.c.f("NotificationPushEventHandler", "notifyPushShow failed, id: " + r6.f9564f + ", error: " + th);
    }

    public final void d(Intent r19, String r20) {
        String r1 = r20;
        String r2 = ", action: ";
        o.f(r19, "notificationIntent");
        o.f(r1, "action");
        Application r7 = com.bytedance.mpaas.app.a.b();     // Catch: Exception -> L103
        String r8 = r19.getStringExtra("msg_id");     // Catch: Exception -> L103
        if (r8 == null) goto L100;
        String r9 = r19.getStringExtra("package_name");     // Catch: Exception -> L103
        if (r9 == null) goto L98;
        int r10 = r19.getIntExtra("click_type", -1);     // Catch: Exception -> L103
        String r11 = r19.getStringExtra("additional_data");     // Catch: Exception -> L103
        String r12 = r19.getStringExtra("open_url");     // Catch: Exception -> L103
        int r0 = r19.getIntExtra("open_url_type", 0);     // Catch: Exception -> L103
        com.obric.matrix.r.c.c.b("NotificationPushEventHandler", "processPushEvent, id: " + r8 + ", action: " + r1);     // Catch: Exception -> L103
        com.obric.matrix.push.p.b r13 = com.obric.matrix.push.p.b.h0;     // Catch: Exception -> L103
        if (o.a(r1, r13.b()) == true) goto L11;
        String r17 = ", action: ";
        String r16 = "NotificationPushEventHandler";
        r1 = r20;
    L92:
        e = e;
    L96:
        r2 = r16;
    L105:
        com.obric.matrix.r.c.c.f(r2, "processPushEvent failed, action: " + r1 + ", error: " + e);
        return;
    L87:
        if (o.a(r1, r13.c()) == false) goto L89;
        Intent r3 = new Intent(r13.d());     // Catch: Exception -> L92
        JSONObject r4 = new JSONObject();     // Catch: Exception -> L92
        r4.put("msg_id", r8);     // Catch: Exception -> L92
        r4.put("package_name", r9);     // Catch: Exception -> L92
        r4.put("result", r13.Q());     // Catch: Exception -> L92
        r3.putExtra("data", r4.toString());     // Catch: Exception -> L92
        r3.putExtra(r13.o(), r13.d0());     // Catch: Exception -> L92
        r3.setPackage(r7.getPackageName());     // Catch: Exception -> L92
        r7.startService(r3);     // Catch: Exception -> L92
    L89:
        com.obric.matrix.r.c.c.b(r16, "processPushEvent success, id: " + r8 + r17 + r1);     // Catch: Exception -> L101
        return;
    L11:
        if (r10 == 1) goto L76;
        r16 = "NotificationPushEventHandler";
        r17 = ", action: ";
        if (r10 != 2) goto L15;
        boolean r5 = true;
        if (r12 != null) goto L66;
    L69:
        if (r5 == true) goto L75;
        Uri r6 = Uri.parse(r12);     // Catch: Exception -> L94
        o.e(r6, "parse(this)");     // Catch: Exception -> L94
        Intent r14 = new Intent("android.intent.action.VIEW", r6);     // Catch: Exception -> L94
        if (r11 == null) goto L73;
        r14.putExtra("additional_data", r11);     // Catch: Exception -> L94
    L73:
        r14.setFlags(268435456);     // Catch: Exception -> L94
    L60:
        r7.startActivity(r14);     // Catch: Exception -> L94
    L81:
        Intent r15 = new Intent(r13.d());     // Catch: Exception -> L94
        JSONObject r18 = new JSONObject();     // Catch: Exception -> L94
        r18.put("msg_id", r8);     // Catch: Exception -> L94
        r18.put("package_name", r9);     // Catch: Exception -> L94
        r15.putExtra("data", r18.toString());     // Catch: Exception -> L94
        r15.putExtra(r13.o(), r13.c0());     // Catch: Exception -> L94
        r15.setPackage(r7.getPackageName());     // Catch: Exception -> L94
        r7.startService(r15);     // Catch: Exception -> L94
        r1 = r20;
        goto L89
    L75:
        throw new Exception("open_url is null");     // Catch: Exception -> L94
    L66:
        if (r12.length() == 0) goto L69;
        r5 = false;
        goto L69
    L15:
        if (r10 != 3) goto L17;
        boolean r21 = true;
        if (r12 != null) goto L52;
    L55:
        if (r21 == true) goto L62;
        Uri r22 = Uri.parse(r12);     // Catch: Exception -> L94
        o.e(r22, "parse(this)");     // Catch: Exception -> L94
        r14 = new Intent("android.intent.action.VIEW", r22);     // Catch: Exception -> L94
        if (r11 == null) goto L59;
        r14.putExtra("additional_data", r11);     // Catch: Exception -> L94
    L59:
        r14.setFlags(268435456);     // Catch: Exception -> L94
        goto L60
    L62:
        throw new Exception("open_url is null");     // Catch: Exception -> L94
    L52:
        if (r12.length() == 0) goto L55;
        r21 = false;
        goto L55
    L17:
        if (r10 != 4) goto L48;
        if (r12 != null) goto L20;
    L23:
        boolean r23 = true;
    L24:
        if (r23 == true) goto L46;
        Intent r24 = Intent.parseUri(r12, 1);     // Catch: Exception -> L94
        if (r11 == null) goto L28;
        r24.putExtra("additional_data", r11);     // Catch: Exception -> L94
    L28:
        if (r0 == 0) goto L44;
        boolean r25 = true;
        if (r0 != 1) goto L43;
        String r26 = r24.getStringExtra("intent_action");     // Catch: Exception -> L94
        String r27 = r24.getStringExtra("intent_class");     // Catch: Exception -> L94
        if (TextUtils.isEmpty(r26) == true) goto L34;
        r24.setAction(r26);     // Catch: Exception -> L94
    L34:
        if (r27 != null) goto L36;
    L39:
        if (r25 == true) goto L41;
        r24.setComponent(new ComponentName(r9, r27));     // Catch: Exception -> L94
    L41:
        r7.sendBroadcast(r24);     // Catch: Exception -> L94
        goto L81
    L36:
        if (r27.length() == 0) goto L39;
        r25 = false;
        goto L39
    L43:
        throw new Exception("unknown open_url_type: " + r0);     // Catch: Exception -> L94
    L44:
        r24.setFlags(268435456);     // Catch: Exception -> L94
        r7.startActivity(r24);     // Catch: Exception -> L94
        goto L81
    L46:
        throw new Exception("open_url is null");     // Catch: Exception -> L94
    L20:
        if (r12.length() == 0) goto L23;
        r23 = false;
        goto L24
    L48:
        throw new Exception("unknown click type: " + r10);     // Catch: Exception -> L94
    L76:
        r17 = ", action: ";
        r16 = "NotificationPushEventHandler";
        r14 = r7.getPackageManager().getLaunchIntentForPackage(r9);     // Catch: Exception -> L94
        if (r14 == null) goto L83;
        if (r11 == null) goto L80;
        r14.putExtra("additional_data", r11);     // Catch: Exception -> L94
    L80:
        r14.setFlags(268435456);     // Catch: Exception -> L94
        goto L60
    L83:
        throw new Exception("launch intent is null");     // Catch: Exception -> L94
    L94:
        e = e;
        r1 = r20;
        goto L96
    L98:
        throw new Exception("package_name is null");     // Catch: Exception -> L101
    L100:
        throw new Exception("id is null");     // Catch: Exception -> L101
    L101:
        e = e;
    L103:
        e = e;
        r2 = "NotificationPushEventHandler";
        goto L105
    }
}
