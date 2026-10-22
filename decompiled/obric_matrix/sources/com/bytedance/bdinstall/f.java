package com.bytedance.bdinstall;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.common.wschannel.WsConstants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import os.teatracker.IBdInstall;

/* JADX INFO: loaded from: classes.dex */
class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a0 f2753a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile boolean f2754b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile int f2755c = 36;

    static {
    }

    private static void a(Map<String, String> r2) {
        if (com.bytedance.bdinstall.d1.l.u() == false) goto L5;
        String r0 = "harmony";
    L6:
        r2.put("os", r0);
        if (com.bytedance.bdinstall.d1.l.u() == false) goto L14;
        r2.put("sub_os_api", String.valueOf(com.bytedance.bdinstall.d1.q.a("hw_sc.build.os.apiversion")));     // Catch: Throwable -> L11
        return;
    L14:
        return;
    L15:
        return;
    L5:
        r0 = "android";
        goto L6
    }

    static String b(Context r4, StringBuilder r5, String r6, boolean r7, m0 r8) {
        String r0 = r5.toString();
        if (TextUtils.isEmpty(r0) == false) goto L5;
        return r0;
    L5:
        Uri r1 = Uri.parse(r0);
        Set<String> r2 = r1.getQueryParameterNames();
        Uri.Builder r3 = r1.buildUpon();
        LinkedHashMap r9 = new LinkedHashMap(f2755c);
        c(r4, r7, r6, r9, r8);
        Iterator r10 = r9.entrySet().iterator();
    L7:
        if (r10.hasNext() == false) goto L13;
        Map.Entry r11 = (Map.Entry) r10.next();
        String r12 = (String) r11.getKey();
        String r13 = (String) r11.getValue();
        if (r2.contains(r12) == true) goto L7;
        if (TextUtils.isEmpty(r13) == true) goto L7;
        r3.appendQueryParameter(r12, (String) r11.getValue());
        goto L7
    L13:
        r5.delete(0, r5.length());
        r5.append(r3.build().toString());
        f2755c = r9.size();
        return r5.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    static void c(Context r6, boolean r7, String r8, Map<String, String> r9, m0 r10) {
        if (r9 != null) goto L4;
        return;
    L4:
        r9.put("device_platform", "android");
        a(r9);
        if (r7 == false) goto L7;
        r9.put("ssmix", "a");
    L7:
        r9.put("_rticket", String.valueOf(System.currentTimeMillis()));
        String r11 = l.d(r6);
        if (TextUtils.isEmpty(r11) == true) goto L10;
        r9.put("cdid", r11);
    L10:
        g r12 = i.h();
        i0 r0 = i.m();
        HashMap<String, String> r1 = null;
        if (r0 == null) goto L13;
        com.bytedance.bdinstall.d1.j r2 = new com.bytedance.bdinstall.d1.j(r0);
    L14:
        if (r2 != null) goto L17;
        if (r12 == 0) goto L17;
        r2 = new com.bytedance.bdinstall.d1.j(r12);
    L17:
        if (r2 == null) goto L33;
        String r3 = r2.c();
        if (TextUtils.isEmpty(r3) == true) goto L22;
        r9.put("channel", r3);
    L22:
        if (r8 != null) goto L25;
        r8 = String.valueOf(r2.a());
    L25:
        r9.put(WsConstants.KEY_APP_ID, r8);
        String r13 = r2.b();
        if (r13 == null) goto L28;
        r9.put(IBdInstall.PARAM_APP_NAME, r13);
    L29:
        r9.put("version_code", String.valueOf(r2.g()));
        String r14 = r2.f();
        if (r14 == null) goto L32;
        r9.put("version_name", r14);
    L32:
        r9.put("manifest_version_code", String.valueOf(r2.d()));
        r9.put("update_version_code", String.valueOf(r2.e()));
        goto L33
    L28:
        q.i(new IllegalArgumentException("app_name is null"));
    L33:
        if (r0 == null) goto L35;
        v r15 = r0.e();
    L36:
        if (r15 == null) goto L39;
        r12 = r15;
    L39:
        if (r12 == 0) goto L55;
        String r16 = r12.getAbVersion();
        if (TextUtils.isEmpty(r16) == true) goto L43;
        r9.put("ab_version", r16);
    L43:
        String r17 = r12.getAbClient();
        if (TextUtils.isEmpty(r17) == true) goto L46;
        r9.put("ab_client", r17);
    L46:
        String r18 = r12.b();
        if (TextUtils.isEmpty(r18) == true) goto L49;
        r9.put("ab_group", r18);
    L49:
        String r19 = r12.getAbFeature();
        if (TextUtils.isEmpty(r19) == true) goto L52;
        r9.put("ab_feature", r19);
    L52:
        long r20 = r12.getAbFlag();
        if (r20 <= 0) goto L55;
        r9.put("abflag", String.valueOf(r20));
    L55:
        com.bytedance.bdinstall.b1.c r21 = (com.bytedance.bdinstall.b1.c) com.bytedance.bdinstall.b1.e.a(com.bytedance.bdinstall.b1.c.class);
        if (r21 == null) goto L58;
        r21.c(r9);
    L58:
        String r22 = com.bytedance.bdinstall.d1.s.c(r6);
        if (TextUtils.isEmpty(r22) == true) goto L61;
        r9.put("resolution", r22);
    L61:
        int r23 = com.bytedance.bdinstall.d1.s.a(r6);
        if (r23 <= 0) goto L64;
        r9.put("dpi", String.valueOf(r23));
    L64:
        String r24 = Build.BRAND;
        if (r24.equals("Pico") == false) goto L67;
        String r25 = com.bytedance.bdinstall.d1.l.j();
    L68:
        r9.put("device_type", r25);
        r9.put("device_brand", r24);
        r9.put("language", Locale.getDefault().getLanguage());
        r9.put("os_api", String.valueOf(Build.VERSION.SDK_INT));
        String r26 = Build.VERSION.RELEASE;     // Catch: Exception -> L123
        if (r26 != null) goto L72;
    L74:
        r9.put("os_version", r26);     // Catch: Exception -> L123
        goto L75
    L72:
        if (r26.length() <= 10) goto L74;
        r26 = r26.substring(0, 10);     // Catch: Exception -> L123
    L75:
        String r27 = com.bytedance.common.utility.i.g(r6);
        if (TextUtils.isEmpty(r27) == true) goto L126;
        r9.put("ac", r27);
    L126:
        a0 r28 = f2753a;     // Catch: Exception -> L100
        if (r28 == null) goto L82;
        r1 = r28.a(r10);     // Catch: Exception -> L100
    L82:
        if (r1 != null) goto L84;
    L102:
        boolean r29 = v0.j(r6);
        h0 r30 = i.l();
        if (e(r6, r29, r30) == false) goto L119;
        if (r30 == null) goto L117;
        if (TextUtils.isEmpty(r30.d()) == true) goto L109;
        r9.put(WsConstants.KEY_INSTALL_ID, r30.d());
    L109:
        if (TextUtils.isEmpty(r30.c()) == true) goto L112;
        r9.put(WsConstants.KEY_DEVICE_ID, r30.c());
    L112:
        if (r10 != m0.f2842f) goto L117;
        String r31 = r30.e();
        if (TextUtils.isEmpty(r31) == true) goto L117;
        r9.put("openudid", r31);
    L117:
        if (r10 != m0.f2842f) goto L119;
        e.c(r6, r9, r29, r0);
    L119:
        e.b(r29, r6);
        com.bytedance.bdinstall.y0.c r32 = i.n();
        if (r32 == null) goto L141;
        r32.a(r9);
        return;
    L141:
        return;
    L84:
        if (r1.isEmpty() == true) goto L102;
        Iterator<Map.Entry<String, String>> r33 = r1.entrySet().iterator();     // Catch: Exception -> L100
    L86:
        if (r33.hasNext() == false) goto L102;
        Map.Entry<String, String> r34 = r33.next();     // Catch: Exception -> L100
        if (r34 == null) goto L86;
        String r4 = r34.getKey();     // Catch: Exception -> L100
        String r35 = r34.getValue();     // Catch: Exception -> L100
        if (TextUtils.isEmpty(r4) == true) goto L86;
        if (TextUtils.isEmpty(r35) == true) goto L86;
        if (r9.containsKey(r4) == true) goto L86;
        r9.put(r4, r35);     // Catch: Exception -> L100
    L100:
        e = move-exception;
        q.i(e);
        goto L102
    L67:
        r25 = Build.MODEL;
        goto L68
    L35:
        r15 = null;
        goto L36
    L13:
        r2 = null;
        goto L14
    }

    static void d(a0 r1) {
        if (f2753a != null) goto L7;
        if (r1 == null) goto L8;
        f2753a = r1;
        return;
    L8:
        return;
    }

    private static boolean e(Context r2, boolean r3, h0 r4) {
        if (r3 == false) goto L10;
        boolean r5 = f2754b;
        if (r5 == true) goto L9;
        r5 = com.bytedance.bdinstall.d1.h.a(r2).getBoolean("_install_started_v2", false);
        if (r5 == false) goto L9;
        f2754b = true;
    L9:
        return r5;
    L10:
        if (r4 == null) goto L17;
        if (TextUtils.isEmpty(r4.c()) == true) goto L17;
        if (TextUtils.isEmpty(r4.d()) == true) goto L17;
        return true;
    L17:
        return false;
    }
}
