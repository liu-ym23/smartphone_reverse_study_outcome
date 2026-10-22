package com.loc;

import android.content.Context;
import android.database.Cursor;
import android.net.Proxy;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import java.net.InetSocketAddress;
import java.net.ProxySelector;
import java.net.URI;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public final class s5 {
    private static String a() {
        String r0 = Proxy.getDefaultHost();     // Catch: Throwable -> L4
    L6:
        if (r0 != null) goto L11;
        return "null";
    L11:
        return r0;
    L4:
        th = move-exception;
        v.m(th, "pu", "gdh");
        r0 = null;
        goto L6
    }

    private static String b(String r0) {
        return u5.u(r0);
    }

    public static java.net.Proxy c(Context r2) {
    L7:
        th = move-exception;
        v.m(th, "pu", "gp");
        return null;
    L3:
        if (Build.VERSION.SDK_INT < 11) goto L5;
        java.net.Proxy r3 = d(r2, new URI("http://restsdk.amap.com"));     // Catch: Throwable -> L7
    L10:
        return r3;
    L5:
        r3 = f(r2);     // Catch: Throwable -> L7
        goto L10
    }

    private static java.net.Proxy d(Context r2, URI r3) {
        if (g(r2) == true) goto L18;
    L17:
        return null;
    L18:
        List<java.net.Proxy> r4 = ProxySelector.getDefault().select(r3);     // Catch: Throwable -> L15
        if (r4 != null) goto L7;
        return null;
    L7:
        if (r4.isEmpty() == true) goto L21;
        java.net.Proxy r5 = r4.get(0);     // Catch: Throwable -> L15
        if (r5 == null) goto L22;
        if (r5.type() != java.net.Proxy.Type.DIRECT) goto L14;
        return null;
    L14:
        return r5;
    L22:
        return null;
    L21:
        return null;
    L15:
        th = move-exception;
        v.m(th, "pu", "gpsc");
        goto L17
    }

    private static int e() {
        return Proxy.getDefaultPort();
    L4:
        th = move-exception;
        v.m(th, "pu", "gdp");
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v17 */
    /* JADX WARN: Type inference failed for: r10v18 */
    /* JADX WARN: Type inference failed for: r10v19 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v7, types: [int] */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r18v0 */
    /* JADX WARN: Type inference failed for: r18v1 */
    /* JADX WARN: Type inference failed for: r18v10 */
    /* JADX WARN: Type inference failed for: r18v11 */
    /* JADX WARN: Type inference failed for: r18v2 */
    /* JADX WARN: Type inference failed for: r18v3 */
    /* JADX WARN: Type inference failed for: r18v4 */
    /* JADX WARN: Type inference failed for: r18v5 */
    /* JADX WARN: Type inference failed for: r18v6 */
    /* JADX WARN: Type inference failed for: r18v7 */
    /* JADX WARN: Type inference failed for: r18v8 */
    /* JADX WARN: Type inference failed for: r18v9 */
    /* JADX WARN: Type inference failed for: r9v0, types: [android.content.ContentResolver, android.database.Cursor] */
    private static java.net.Proxy f(Context r19) {
        if (g(r19) == false) goto L126;
        Uri r10 = Uri.parse("content://telephony/carriers/preferapn");
        ?? r9 = r19.getContentResolver();
        String r11 = null;
        boolean r16 = false;
        Cursor r12 = r9.query(r10, null, null, null, null);     // Catch: Throwable -> L63 SecurityException -> L72
        if (r12 != null) goto L140;
    L55:
        r11 = null;
        ?? r18 = -1;
    L56:
        if (r12 != null) goto L131;
    L62:
        ?? r13 = r18;
    L107:
        if (r11 != null) goto L127;
    L114:
        if (r16 == false) goto L126;
        return new java.net.Proxy(java.net.Proxy.Type.HTTP, InetSocketAddress.createUnresolved(r11, r13));
    L112:
        th = move-exception;
        s.e(th, "pu", "gp2");
        th.printStackTrace();
        goto L126
    L127:
        if (r11.length() <= 0) goto L114;
        if (r13 == (-1)) goto L114;
        r16 = true;
        goto L114
    L131:
        r12.close();     // Catch: Throwable -> L59
    L59:
        th = move-exception;
        Throwable r1 = th;
        r18 = r18;
    L61:
        v.m(r1, "pu", "gPx2");
        goto L62
    L140:
    L53:
        e = e;
        r11 = null;
    L74:
        ?? r14 = -1;
    L75:
        v.m(e, "pu", "ghp");     // Catch: Throwable -> L118
        String r0 = l5.Q(r19);     // Catch: Throwable -> L118
        if (r0 == null) goto L101;
        String r2 = r0.toLowerCase(Locale.US);     // Catch: Throwable -> L118
        String r15 = a();     // Catch: Throwable -> L118
        int r17 = e();     // Catch: Throwable -> L118
        if (r2.indexOf("ctwap") == (-1)) goto L90;
        if (TextUtils.isEmpty(r15) == false) goto L82;
    L84:
        boolean r3 = false;
    L85:
        if (r3 == true) goto L87;
        r11 = b("QMTAuMC4wLjIwMA==");     // Catch: Throwable -> L118
    L87:
        if (r17 != (-1)) goto L100;
    L88:
        r18 = 80;
    L102:
        if (r12 == null) goto L62;
        r12.close();     // Catch: Throwable -> L105
    L105:
        th = move-exception;
        r1 = th;
        r18 = r18;
    L100:
        r18 = r17;
        goto L102
    L82:
        if (r15.equals("null") == true) goto L84;
        r11 = r15;
        r3 = true;
        goto L85
    L90:
        if (r2.indexOf("wap") == (-1)) goto L100;
        if (TextUtils.isEmpty(r15) == false) goto L94;
    L96:
        boolean r4 = false;
    L97:
        if (r4 == true) goto L88;
        r11 = b("QMTAuMC4wLjE3Mg==");     // Catch: Throwable -> L118
        goto L88
    L94:
        if (r15.equals("null") == true) goto L96;
        r11 = r15;
        r4 = true;
        goto L97
    L101:
        r18 = r14;
    L51:
        th = th;
        r11 = null;
    L65:
        r14 = -1;
    L66:
        v.m(th, "pu", "gPx1");     // Catch: Throwable -> L118
        th.printStackTrace();     // Catch: Throwable -> L118
        r13 = r14;
        if (r12 == null) goto L107;
        r12.close();     // Catch: Throwable -> L70
        r13 = r14;
    L70:
        th = move-exception;
        v.m(th, "pu", "gPx2");
        r13 = r14;
        goto L107
    L8:
        if (r12.moveToFirst() == false) goto L55;
        String r5 = r12.getString(r12.getColumnIndex("apn"));     // Catch: Throwable -> L51 SecurityException -> L53
        String r6 = r5;
        r14 = r10;
        if (r5 == null) goto L139;
        Locale r110 = Locale.US;     // Catch: Throwable -> L51 SecurityException -> L53
        r6 = r5.toLowerCase(r110);     // Catch: Throwable -> L51 SecurityException -> L53
        r14 = r110;
    L139:
        if (r6 != null) goto L14;
    L35:
        if (r6 == null) goto L55;
        if (r6.contains("wap") == false) goto L55;
        String r7 = a();     // Catch: Throwable -> L51 SecurityException -> L53
        int r111 = e();     // Catch: Throwable -> L51 SecurityException -> L53
        if (TextUtils.isEmpty(r7) == false) goto L42;
    L44:
        r11 = null;
        boolean r8 = false;
    L45:
        if (r8 == false) goto L47;
    L48:
        if (r111 != (-1)) goto L50;
    L49:
        r18 = 80;
    L50:
        r18 = r111;
        goto L56
    L47:
        r11 = b("QMTAuMC4wLjE3Mg==");     // Catch: Throwable -> L25 SecurityException -> L27
        goto L48
    L42:
        if (r7.equals("null") == true) goto L44;
        r11 = r7;
        r8 = true;
        goto L45
    L14:
        if (r6.contains("ctwap") == false) goto L35;
        String r20 = a();     // Catch: Throwable -> L51 SecurityException -> L53
        r111 = e();     // Catch: Throwable -> L51 SecurityException -> L53
        if (TextUtils.isEmpty(r20) == false) goto L19;
    L21:
        r11 = null;
        boolean r21 = false;
    L22:
        if (r21 == true) goto L29;
        r11 = b("QMTAuMC4wLjIwMA==");     // Catch: Throwable -> L25 SecurityException -> L27
    L29:
        if (r111 != (-1)) goto L50;
    L19:
        if (r20.equals("null") == true) goto L21;
        r11 = r20;
        r21 = true;
    L33:
        e = e;
        r11 = null;
    L31:
        th = th;
        r11 = null;
    L27:
        e = e;
    L25:
        th = th;
        goto L66
    L118:
        th = move-exception;
        if (r9 == 0) goto L141;
        r9.close();     // Catch: Throwable -> L123
        throw th;
    L123:
        th = move-exception;
        v.m(th, "pu", "gPx2");
        throw th;
    L141:
        throw th;
    L72:
        e = e;
        r12 = null;
        r11 = null;
    L63:
        th = th;
        r12 = null;
        r11 = null;
    L126:
        return null;
    }

    private static boolean g(Context r0) {
        if (l5.M(r0) != 0) goto L6;
        return true;
    L6:
        return false;
    }
}
