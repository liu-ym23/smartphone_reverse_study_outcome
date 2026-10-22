package com.obric.matrix.q.h;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\n"}, d2 = {"Lcom/obric/matrix/base/system/PackageChangeBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "Companion", "internal_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class f extends BroadcastReceiver {
    static {
    }

    public f() {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r7, Intent r8) {
        if (r7 == null) goto L44;
        if (r8 != null) goto L5;
        return;
    L5:
        if (r8.getAction() == null) goto L46;
        String r6 = r8.getAction();
        com.obric.matrix.r.c.c.b("PackageChangeBroadcastReceiver", "the action is " + r6);
        if (r8.getData() != null) goto L10;
        return;
    L10:
        Uri r9 = r8.getData();
        o.c(r9);
        String r10 = r9.getEncodedSchemeSpecificPart();
        com.obric.matrix.r.c.c.b("PackageChangeBroadcastReceiver", "the packageName is " + r10);
        if (r10 != null) goto L13;
    L16:
        boolean r2 = true;
    L17:
        if (r2 == false) goto L19;
        return;
    L19:
        boolean r11 = r8.getBooleanExtra("android.intent.extra.REPLACING", false);
        com.obric.matrix.r.c.c.b("PackageChangeBroadcastReceiver", "the packageName " + r10 + " is replacing: " + r11);
        if (r11 == true) goto L22;
    L27:
        e r5 = null;
        if (r11 == false) goto L33;
        if (o.a("android.intent.action.PACKAGE_REPLACED", r6) == false) goto L33;
        r5 = e.f9878h;
    L39:
        com.obric.matrix.r.c.c.b("PackageChangeBroadcastReceiver", "the final action for package is " + r5);
        if (r5 != null) goto L42;
        return;
    L42:
        h r12 = h.f9880a;
        o.e(r10, "packageName");
        r12.b(r5, r10);
        return;
    L33:
        if (o.a("android.intent.action.PACKAGE_ADDED", r6) == false) goto L36;
        r5 = e.f9876f;
        goto L39
    L36:
        if (o.a("android.intent.action.PACKAGE_REMOVED", r6) == false) goto L38;
        r5 = e.f9877g;
        goto L39
    L38:
        com.obric.matrix.r.c.c.b("PackageChangeBroadcastReceiver", "the action for package(" + r10 + ") is " + r6 + " but is not matched.");
        goto L39
    L22:
        if (o.a("android.intent.action.PACKAGE_ADDED", r6) == false) goto L24;
    L25:
        com.obric.matrix.r.c.c.b("PackageChangeBroadcastReceiver", "the action for package(" + r10 + ") is " + r6 + " but is replacing.");
        return;
    L24:
        if (o.a("android.intent.action.PACKAGE_REMOVED", r6) == false) goto L27;
    L13:
        if (r10.length() == 0) goto L16;
        r2 = false;
        goto L17
    L46:
        return;
    }
}
