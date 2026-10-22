package com.obric.matrix.push.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.obric.matrix.push.j;
import com.obric.matrix.push.m.l.a;
import com.obric.matrix.push.p.b;
import com.obric.matrix.r.c.c;
import kotlin.Metadata;
import kotlin.n0.d.o;
import kotlin.u;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u001c\u0010\n\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016¨\u0006\u000e"}, d2 = {"Lcom/obric/matrix/push/receiver/CoreBroadCastReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "getPushSDKInfo", "Lkotlin/Pair;", "", "context", "Landroid/content/Context;", "packageName", "", "onReceive", "", "intent", "Landroid/content/Intent;", "push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CoreBroadCastReceiver extends BroadcastReceiver {
    public CoreBroadCastReceiver() {
    }

    private final u<Object, Object> a(Context r1, String r2) {
        ApplicationInfo r0 = r1.getPackageManager().getApplicationInfo(r2, 128);     // Catch: Throwable -> L4
        o.e(r0, "context.packageManager.g…ageManager.GET_META_DATA)");     // Catch: Throwable -> L4
        Bundle r3 = r0.metaData;     // Catch: Throwable -> L4
        b r4 = b.h0;     // Catch: Throwable -> L4
        return new u(r3.get(r4.G()), r3.get(r4.F()));
    L4:
        return null;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r9, Intent r10) {
        if (r9 == null) goto L68;
        if (r10 == null) goto L76;
        c.b("CoreBroadCastReceiver", "CoreBroadCastReceiver.onReceive , action is " + r10.getAction());
        String r4 = null;
        if (TextUtils.equals(r10.getAction(), "android.intent.action.PACKAGE_ADDED") == false) goto L30;
        if (r10.getExtras() == null) goto L14;
        Bundle r0 = r10.getExtras();
        o.c(r0);
        if (r0.getBoolean("android.intent.extra.REPLACING") == false) goto L14;
        StringBuilder r8 = new StringBuilder();
    L12:
        r8.append("CoreBroadCastReceiver.onReceive , action  ");
        r8.append(r10.getAction());
        r8.append(" is for upgrade");
        com.obric.matrix.push.n.c.c.a(r8.toString());
        return;
    L14:
        Uri r11 = r10.getData();
        if (r11 == null) goto L17;
        r4 = r11.getSchemeSpecificPart();
    L17:
        if (r4 != null) goto L67;
        return;
    L67:
        u<Object, Object> r12 = a(r9, r4);     // Catch: Throwable -> L66
        if (r12 != null) goto L22;
        return;
    L22:
        String r13 = String.valueOf(r12.c());     // Catch: Throwable -> L66
        if (TextUtils.isEmpty(r13) == true) goto L69;
        com.obric.matrix.push.m.f.b r14 = com.obric.matrix.push.m.b.f9633a.d();     // Catch: Throwable -> L66
        Object r15 = r12.d();     // Catch: Throwable -> L66
        if (r15 == null) goto L28;
        r14.a(r4, r13, ((Integer) r15).intValue());     // Catch: Throwable -> L66
        return;
    L28:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");     // Catch: Throwable -> L66
    L69:
        return;
    L77:
        return;
    L30:
        if (TextUtils.equals(r10.getAction(), "android.intent.action.PACKAGE_REMOVED") == false) goto L46;
        if (r10.getExtras() == null) goto L36;
        Bundle r1 = r10.getExtras();
        o.c(r1);
        if (r1.getBoolean("android.intent.extra.REPLACING") == false) goto L36;
        r8 = new StringBuilder();
    L36:
        Uri r16 = r10.getData();
        if (r16 == null) goto L39;
        r4 = r16.getSchemeSpecificPart();
    L39:
        if (r4 != null) goto L42;
        return;
    L42:
        if (a(r9, r4) != null) goto L44;
        return;
    L44:
        com.obric.matrix.push.m.b.f9633a.d().d(r4);
        return;
    L46:
        if (TextUtils.equals(r10.getAction(), "android.intent.action.PACKAGE_REPLACED") == false) goto L57;
        Uri r17 = r10.getData();
        if (r17 == null) goto L50;
        r4 = r17.getSchemeSpecificPart();
    L50:
        if (r4 != null) goto L53;
        return;
    L53:
        if (a(r9, r4) != null) goto L55;
        return;
    L55:
        com.obric.matrix.push.m.b.f9633a.d().b(r4);
        return;
    L57:
        if (TextUtils.equals(r10.getAction(), "android.intent.action.LOCALE_CHANGED") == false) goto L60;
        a r2 = com.obric.matrix.push.m.b.f9633a.A();
        String r3 = r9.getPackageName();
        o.e(r3, "context.packageName");
        a.C0273a.a(r2, r3, null, null, b.h0.X(), null, 22, null);
        return;
    L60:
        if (TextUtils.equals(r10.getAction(), "android.intent.action.LOCKED_BOOT_COMPLETED") == false) goto L63;
        j.f9609a.b();
        return;
    L63:
        if (TextUtils.equals(r10.getAction(), "android.intent.action.BOOT_COMPLETED") == false) goto L75;
        j.f9609a.c();
        return;
    L75:
        return;
    L76:
        return;
    }
}
