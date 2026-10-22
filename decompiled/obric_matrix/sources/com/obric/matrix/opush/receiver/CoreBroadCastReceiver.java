package com.obric.matrix.opush.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.obric.matrix.opush.f.b;
import com.obric.matrix.r.c.c;
import kotlin.Metadata;
import kotlin.n0.d.o;
import kotlin.u;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u001c\u0010\n\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016¨\u0006\u000e"}, d2 = {"Lcom/obric/matrix/opush/receiver/CoreBroadCastReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "getPushSDKInfo", "Lkotlin/Pair;", "", "context", "Landroid/content/Context;", "packageName", "", "onReceive", "", "intent", "Landroid/content/Intent;", "o_push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CoreBroadCastReceiver extends BroadcastReceiver {
    public CoreBroadCastReceiver() {
    }

    private final u<Object, Object> a(Context r1, String r2) {
        ApplicationInfo r0 = r1.getPackageManager().getApplicationInfo(r2, 128);     // Catch: Throwable -> L4
        o.e(r0, "context.packageManager.g…ageManager.GET_META_DATA)");     // Catch: Throwable -> L4
        Bundle r3 = r0.metaData;     // Catch: Throwable -> L4
        b r4 = b.G;     // Catch: Throwable -> L4
        return new u(r3.get(r4.u()), r3.get(r4.t()));
    L4:
        return null;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r7, Intent r8) {
        if (r7 == null) goto L57;
        if (r8 == null) goto L62;
        c.b("CoreBroadCastReceiver", "CoreBroadCastReceiver.onReceive , action is " + r8.getAction());
        String r4 = null;
        if (TextUtils.equals(r8.getAction(), "android.intent.action.PACKAGE_ADDED") == false) goto L30;
        if (r8.getExtras() == null) goto L14;
        Bundle r0 = r8.getExtras();
        o.c(r0);
        if (r0.getBoolean("android.intent.extra.REPLACING") == false) goto L14;
        com.obric.matrix.opush.c r6 = com.obric.matrix.opush.c.f9247a;
        StringBuilder r9 = new StringBuilder();
    L12:
        r9.append("CoreBroadCastReceiver.onReceive , action  ");
        r9.append(r8.getAction());
        r9.append(" is for upgrade");
        r6.a(r9.toString());
        return;
    L14:
        Uri r10 = r8.getData();
        if (r10 == null) goto L17;
        r4 = r10.getSchemeSpecificPart();
    L17:
        if (r4 != null) goto L56;
        return;
    L56:
        u<Object, Object> r11 = a(r7, r4);     // Catch: Throwable -> L55
        if (r11 != null) goto L22;
        return;
    L22:
        String r12 = String.valueOf(r11.c());     // Catch: Throwable -> L55
        if (TextUtils.isEmpty(r12) == true) goto L58;
        com.obric.matrix.opush.d.e.b r13 = com.obric.matrix.opush.d.b.f9251a.d();     // Catch: Throwable -> L55
        Object r14 = r11.d();     // Catch: Throwable -> L55
        if (r14 == null) goto L28;
        r13.a(r4, r12, ((Integer) r14).intValue());     // Catch: Throwable -> L55
        return;
    L28:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");     // Catch: Throwable -> L55
    L58:
        return;
    L63:
        return;
    L30:
        if (TextUtils.equals(r8.getAction(), "android.intent.action.PACKAGE_REMOVED") == false) goto L43;
        if (r8.getExtras() == null) goto L36;
        Bundle r15 = r8.getExtras();
        o.c(r15);
        if (r15.getBoolean("android.intent.extra.REPLACING") == false) goto L36;
        r6 = com.obric.matrix.opush.c.f9247a;
        r9 = new StringBuilder();
    L36:
        Uri r16 = r8.getData();
        if (r16 == null) goto L39;
        r4 = r16.getSchemeSpecificPart();
    L39:
        if (r4 != null) goto L41;
        return;
    L41:
        com.obric.matrix.opush.g.b.f9424a.e(r4);
        com.obric.matrix.opush.d.b.f9251a.d().d(r4);
        return;
    L43:
        if (TextUtils.equals(r8.getAction(), "android.intent.action.PACKAGE_REPLACED") == false) goto L53;
        Uri r17 = r8.getData();
        if (r17 == null) goto L47;
        r4 = r17.getSchemeSpecificPart();
    L47:
        if (r4 != null) goto L49;
        return;
    L49:
        com.obric.matrix.opush.g.b.f9424a.f(r7, r4);
        if (a(r7, r4) != null) goto L52;
        return;
    L52:
        com.obric.matrix.opush.d.b.f9251a.d().b(r4);
        return;
    L53:
        TextUtils.equals(r8.getAction(), "android.intent.action.LOCALE_CHANGED");
        return;
    L62:
        return;
    }
}
