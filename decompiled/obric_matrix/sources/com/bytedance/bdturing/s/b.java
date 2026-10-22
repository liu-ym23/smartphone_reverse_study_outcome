package com.bytedance.bdturing.s;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Pair;
import android.widget.Toast;
import com.bytedance.bdturing.BdTuringConfig;
import com.bytedance.bdturing.g;
import com.bytedance.bdturing.twiceverify.c;
import com.bytedance.bdturing.v.h;
import com.bytedance.bdturing.x.e;
import com.bytedance.common.wschannel.WsConstants;
import kotlin.n0.d.o;
import os.teatracker.IBdInstall;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f3140a = null;

    static {
        f3140a = new b();
    }

    private b() {
    }

    public final void a(Activity r6, StringBuilder r7) {
        o.g(r7, "queryBuilder");
        com.bytedance.bdturing.b r5 = com.bytedance.bdturing.b.f();
        o.b(r5, "BdTuring.getInstance()");
        BdTuringConfig r8 = r5.e();
        String r1 = null;
        if (r8 == null) goto L5;
        String r2 = r8.getAppId();
    L6:
        e.c(r7, WsConstants.KEY_APP_ID, r2);
        if (r8 == null) goto L9;
        String r3 = r8.getLanguage();
    L10:
        e.c(r7, "lang", r3);
        if (r8 == null) goto L13;
        String r4 = r8.getAppName();
    L14:
        e.c(r7, IBdInstall.PARAM_APP_NAME, r4);
        com.bytedance.bdturing.b r9 = com.bytedance.bdturing.b.f();
        o.b(r9, "BdTuring.getInstance()");
        BdTuringConfig r0 = r9.e();
        if (r0 == null) goto L17;
        String r10 = r0.getLocale();
    L18:
        e.c(r7, "locale", r10);
        if (r8 == null) goto L21;
        String r11 = r8.getChannel();
    L22:
        e.c(r7, "ch", r11);
        if (r8 == null) goto L25;
        String r12 = r8.getChannel();
    L26:
        e.c(r7, "channel", r12);
        if (r8 == null) goto L29;
        String r13 = r8.getAppKey();
    L30:
        e.c(r7, WsConstants.KEY_APP_KEY, r13);
        if (r8 == null) goto L33;
        String r14 = r8.getInstallId();
    L34:
        e.c(r7, WsConstants.KEY_INSTALL_ID, r14);
        if (r8 == null) goto L37;
        String r15 = r8.getAppVersion();
    L38:
        e.c(r7, "vc", r15);
        if (r8 == null) goto L41;
        String r16 = r8.getAppVersion();
    L42:
        e.c(r7, "app_verison", r16);
        if (r8 == null) goto L45;
        String r17 = r8.getDeviceId();
    L46:
        e.c(r7, "did", r17);
        if (r8 == null) goto L49;
        String r18 = r8.getSessionId();
    L50:
        e.c(r7, "session_id", r18);
        if (r8 == null) goto L55;
        BdTuringConfig.c r19 = r8.getRegionType();
        if (r19 == null) goto L55;
        String r20 = r19.a();
    L56:
        e.c(r7, "region", r20);
        h r21 = h.f3217l;
        e.b(r7, "use_native_report", r21.v() ? 1 : 0);
        e.b(r7, "use_jsb_request", r21.t() ? 1 : 0);
        e.b(r7, "orientation", e.f(r6));
        e.c(r7, "resolution", e.h(r6));
        e.c(r7, "sdk_version", "3.2.0.cn");
        e.b(r7, "os_version", com.bytedance.bdturing.x.b.f3257c);
        e.c(r7, "device_brand", com.bytedance.bdturing.x.b.f3255a);
        String r22 = com.bytedance.bdturing.x.b.f3256b;
        e.c(r7, "device_model", r22);
        e.c(r7, "os_name", "android");
        if (r8 == null) goto L59;
        String r23 = r8.getAppVersionCode();
    L60:
        e.c(r7, "version_code", r23);
        if (r8 == null) goto L63;
        r1 = r8.getAppVersion();
    L63:
        e.c(r7, "version_name", r1);
        e.c(r7, "device_type", r22);
        e.c(r7, "device_platform", "android");
        e.b(r7, "os_type", 0);
        if (r21.u() == false) goto L67;
        e.b(r7, "mock", 1);
        return;
    L67:
        return;
    L59:
        r23 = null;
    L55:
        r20 = null;
        goto L56
    L49:
        r18 = null;
        goto L50
    L45:
        r17 = null;
        goto L46
    L41:
        r16 = null;
        goto L42
    L37:
        r15 = null;
        goto L38
    L33:
        r14 = null;
        goto L34
    L29:
        r13 = null;
        goto L30
    L25:
        r12 = null;
        goto L26
    L21:
        r11 = null;
        goto L22
    L17:
        r10 = null;
        goto L18
    L13:
        r4 = null;
        goto L14
    L9:
        r3 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    public final StringBuilder b(int r4, String r5, Activity r6) {
        o.g(r5, "serviceType");
        h r7 = h.f3217l;
        String r0 = r7.i(r5);
        String r8 = r7.k(r5);
        if (o.a(r5, "twice_verify") == false) goto L6;
        c r9 = c.d();
        o.b(r9, "TwiceVerifyManager.getInstance()");
        r8 = r9.c().c();
        c r1 = c.d();
        o.b(r1, "TwiceVerifyManager.getInstance()");
        r0 = r1.c().e();
    L6:
        if (g.d() == false) goto L31;
        com.bytedance.bdturing.b r10 = com.bytedance.bdturing.b.f();
        o.b(r10, "BdTuring.getInstance()");
        BdTuringConfig r11 = r10.e();
        if (r11 == null) goto L10;
        Pair<String, String> r12 = r11.getTestConfig(2);
    L11:
        if (r12 == null) goto L13;
        String r2 = (String) r12.first;
    L15:
        if (TextUtils.isEmpty(r2) == true) goto L20;
        if (r12 == null) goto L18;
        r0 = (String) r12.first;
        goto L20
    L18:
        o.p();
        throw null;
    L20:
        if (r12 == null) goto L22;
        String r3 = (String) r12.first;
    L24:
        if (TextUtils.isEmpty(r3) == true) goto L29;
        if (r12 == null) goto L27;
        r8 = (String) r12.second;
        goto L29
    L27:
        o.p();
        throw null;
    L29:
        if (r6 == null) goto L31;
        Toast.makeText(r6, "url = " + r0 + ", verifyHost = " + r8, 1).show();
        goto L31
    L22:
        r3 = null;
        goto L24
    L13:
        r2 = null;
        goto L15
    L10:
        r12 = null;
    L31:
        StringBuilder r13 = new StringBuilder(o.m(r0, "?"));
        e.a(r13, "verify_host", r8);
        a(r6, r13);
        return r13;
    }
}
