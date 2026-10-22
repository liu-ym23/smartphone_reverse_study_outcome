package com.ss.android.i.n.a.e;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.util.Log;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.security.MessageDigest;
import kotlin.b0;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f11945a = null;

    static {
        f11945a = new c();
    }

    private c() {
    }

    public final String a(Context r2, String r3) {
        o.g(r2, "context");
        o.g(r3, "callingPackage");
        PackageInfo r4 = r2.getPackageManager().getPackageInfo(r3, 64);     // Catch: Exception -> L5
        o.b(r4, "context.packageManager.g…geManager.GET_SIGNATURES)");     // Catch: Exception -> L5
        Signature r5 = r4.signatures[0];     // Catch: Exception -> L5
        o.b(r5, "signatures[0]");     // Catch: Exception -> L5
        return b(r5, "SHA256");
    L5:
        e = move-exception;
        com.ss.android.i.n.a.c r6 = com.ss.android.i.n.a.c.d();
        r6.b("share_sdk_get_pkg_sign_failed");
        r6.a(LocationMonitorConst.ERR_MSG, e.getMessage());
        r6.a("err_msg_stack", Log.getStackTraceString(e));
        r6.c();
        return null;
    }

    public final String b(Signature r4, String r5) {
        o.g(r4, "sig");
        byte[] r3 = r4.toByteArray();
        o.b(r3, "sig.toByteArray()");
        StringBuffer r6 = new StringBuffer();     // Catch: Exception -> L18
        MessageDigest r7 = MessageDigest.getInstance(r5);     // Catch: Exception -> L18
        if (r7 == null) goto L20;
        r7.reset();     // Catch: Exception -> L18
        r7.update(r3);     // Catch: Exception -> L18
        byte[] r8 = r7.digest();     // Catch: Exception -> L18
        int r9 = 0;
        o.b(r8, "byteArray");     // Catch: Exception -> L18
        int r0 = r8.length;     // Catch: Exception -> L18
    L6:
        if (r9 >= r0) goto L13;
        if (Integer.toHexString(r8[r9] & 255).length() != 1) goto L11;
        r6.append(BDLocationException.ERROR_TIMEOUT);     // Catch: Exception -> L18
        String r1 = Integer.toHexString(r8[r9] & 255);     // Catch: Exception -> L18
    L10:
        r6.append(r1);     // Catch: Exception -> L18
        r9 = r9 + 1;     // Catch: Exception -> L18
        goto L6
    L11:
        r1 = Integer.toHexString(r8[r9] & 255);     // Catch: Exception -> L18
        goto L10
    L13:
        String r10 = r6.toString();     // Catch: Exception -> L18
        o.b(r10, "buffer.toString()");     // Catch: Exception -> L18
        if (r10 == null) goto L17;
        String r11 = r10.toUpperCase();     // Catch: Exception -> L18
        o.b(r11, "(this as java.lang.String).toUpperCase()");     // Catch: Exception -> L18
        return r11;
    L17:
        throw new b0("null cannot be cast to non-null type java.lang.String");     // Catch: Exception -> L18
    L20:
        return "";
    L18:
        e = move-exception;
        com.ss.android.i.n.a.c r12 = com.ss.android.i.n.a.c.d();
        r12.b("share_sdk_get_pkg_sign_failed");
        r12.a(LocationMonitorConst.ERR_MSG, e.getMessage());
        r12.a("err_msg_stack", Log.getStackTraceString(e));
        r12.c();
        goto L20
    }
}
