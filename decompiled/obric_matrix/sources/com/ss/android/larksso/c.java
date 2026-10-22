package com.ss.android.larksso;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.ttnet.TTNetInit;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Locale;
import java.util.UUID;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;
import os.teatracker.IBdInstall;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f12015a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.ss.android.larksso.b f12016b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Activity f12017c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private b f12018d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f12019e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f12020f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ArrayList<g> f12021g;

    static /* synthetic */ class a {
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f12022a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f12023b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Activity f12024c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f12025d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f12026e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f12027f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f12028g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f12029h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private ArrayList<String> f12030i;

        public b() {
            this.f12026e = "";
            this.f12027f = "";
            this.f12028g = false;
            this.f12029h = false;
            this.f12030i = new ArrayList();
        }

        static /* synthetic */ String a(b r0) {
            return r0.f12025d;
        }

        static /* synthetic */ Activity b(b r0) {
            return r0.f12024c;
        }

        static /* synthetic */ String c(b r0) {
            return r0.f12026e;
        }

        static /* synthetic */ String d(b r0) {
            return r0.f12023b;
        }

        static /* synthetic */ String e(b r0) {
            return r0.f12022a;
        }

        static /* synthetic */ String f(b r0) {
            return r0.f12027f;
        }

        static /* synthetic */ boolean g(b r0) {
            return r0.f12029h;
        }

        static /* synthetic */ boolean h(b r0) {
            return r0.f12028g;
        }

        static /* synthetic */ ArrayList i(b r0) {
            return r0.f12030i;
        }

        public b j(String r1) {
            this.f12022a = r1;
            return this;
        }

        public b k(Activity r2) {
            this.f12024c = r2;
            this.f12026e = c.b(r2, this.f12026e);
            return this;
        }

        public b l(String r1) {
            this.f12026e = r1;
            return this;
        }

        public b m(boolean r1) {
            this.f12029h = r1;
            return this;
        }

        public b n(String r1) {
            this.f12023b = r1;
            return this;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.larksso.c$c, reason: collision with other inner class name */
    private static class C0313c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final c f12031a = null;

        static {
            f12031a = new c(null);
        }

        static /* synthetic */ c a() {
            return f12031a;
        }
    }

    private c() {
        this.f12021g = new ArrayList();
    }

    /* synthetic */ c(a r1) {
        this();
    }

    private void B(String r1, String r2, boolean r3) {
        com.ss.android.larksso.l.c.m(r1, r2, r3);
    }

    private byte[] C(String r1, String r2) {
        if (r1 == null) goto L10;
        if (r1.length() <= 0) goto L10;
        MessageDigest r0 = MessageDigest.getInstance(r2);     // Catch: Throwable -> L7
        r0.update(r1.getBytes());     // Catch: Throwable -> L7
        return r0.digest();
    L7:
        th = move-exception;
        th.printStackTrace();
    L10:
        return new byte[0];
    }

    private String E(String r3, String r4, String r5, String r6) {
        this.f12021g.add(new g(r4, r5, r6));     // Catch: UnsupportedEncodingException -> L4
        return URLEncoder.encode(r3, "utf-8");
    L4:
        e = move-exception;
        e.printStackTrace();
        com.ss.android.larksso.l.c.h("LarkSSO", "URL encoding failed");
        m(i.f12044l.a(), "");
        return r3;
    }

    private void F(String r3, String r4) {
        com.ss.android.larksso.b r0 = this.f12016b;
        if (r0 == null) goto L6;
        r0.a(new com.ss.android.larksso.a(r3, r4));
        this.f12016b = null;
        return;
    }

    @Proxy("getSharedPreferences")
    @TargetClass(scope = Scope.ALL, value = "android.content.Context")
    public static SharedPreferences a(Activity r0, String r1, int r2) {
        return com.obric.matrix.r.b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
    }

    static /* synthetic */ String b(Activity r0, String r1) {
        return h(r0, r1);
    }

    private String c(byte[] r1) {
        if (r1 != null) goto L4;
        return "";
    L4:
        if (r1.length != 0) goto L7;
        return "";
    L7:
        return Base64.encodeToString(r1, 11);
    }

    private void d() {
        String r0 = c(p().getBytes());
        this.f12019e = r0;
        this.f12020f = c(C(r0, "SHA-256"));
    }

    private String e() {
        f();
        d();
        return E(String.format("https://%s/%s?%s=%s&%s=%s&%s=%s&%s=%s&sdk_platform=Android&source=sso_web&sso_sdk=1&safety_mode=%s&%s=%s&%s=%s&%s=%s&%s=%s&%s=%s", new Object[]{o(), "suite/passport/sdk/oauth", IBdInstall.PARAM_APP_ID, b.e(this.f12018d), "response_type", "code", WsConstants.KEY_CONNECTION_STATE, this.f12015a, "lang", u(), 1L, "code_challenge_method", "S256", "code_challenge", this.f12020f, "redirect_uri", q(), "scope", n(), "sdk_version", s()}), this.f12015a, this.f12019e, this.f12020f);
    }

    private void f() {
        this.f12015a = p();
    }

    private String g() {
        f();
        return E(String.format("https://%s/%s?%s=%s&%s=%s&%s=%s&%s=%s&sdk_platform=Android&source=sso_web&sso_sdk=1&safety_mode=%s", new Object[]{o(), "suite/passport/sdk/oauth", IBdInstall.PARAM_APP_ID, b.e(this.f12018d), "response_type", "code", WsConstants.KEY_CONNECTION_STATE, this.f12015a, "lang", u(), 1L}), this.f12015a, "", "");
    }

    private static String h(Activity r3, String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L8;
        SharedPreferences r5 = a(r3, "ssoDeviceID", 0);
        String r0 = r5.getString(WsConstants.KEY_DEVICE_ID, "");
        if (TextUtils.isEmpty(r0) == false) goto L9;
        SharedPreferences.Editor r6 = r5.edit();
        String r1 = p();
        Log.i("LarkSSO", "build deviceID:" + r1);
        r6.putString(WsConstants.KEY_DEVICE_ID, r1);
        r6.commit();
        return r1;
    L9:
        return r0;
    L8:
        return r4;
    }

    private void i(Uri r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        if (r6.toString().contains(WsConstants.KEY_CONNECTION_STATE) == true) goto L6;
        return;
    L6:
        if (r6.toString().contains("code") == false) goto L26;
        com.ss.android.larksso.l.c.h("LarkSSO", "The returned scheme is:" + r6.toString());
        if (TextUtils.isEmpty(r6.getQueryParameter("code")) == false) goto L12;
        com.ss.android.larksso.l.c.h("LarkSSO", "No valid code");
        m(i.f12040h.a(), "");
        return;
    L12:
        if (k(r6) == false) goto L21;
        String r0 = r6.getQueryParameter("code");
        if ("/cancel".equalsIgnoreCase(r6.getPath()) == false) goto L18;
        com.ss.android.larksso.l.c.h("LarkSSO", "User cancels the authorization, the code returned is:" + r0);
        i r1 = i.f12041i;
    L16:
        m(r1.a(), r(r6));
    L22:
        com.ss.android.larksso.l.c.h("LarkSSO", "Clear requestDataArrayList");
        this.f12021g.clear();
        return;
    L18:
        if ("/failure".equalsIgnoreCase(r6.getPath()) == false) goto L20;
        com.ss.android.larksso.l.c.h("LarkSSO", "User authorization failed, the code is:" + r0 + ", The error code is" + r6.getQueryParameter(LocationMonitorConst.ERR_CODE));
        r1 = i.f12043k;
        goto L16
    L20:
        com.ss.android.larksso.l.c.h("LarkSSO", "User authorization is successful, the code is:" + r0);
        F(r0, r(r6));
        goto L22
    L21:
        com.ss.android.larksso.l.c.h("LarkSSO", "Authorization failed, state is inconsistent, now state is:" + this.f12015a);
        m(i.f12039g.a(), "");
        goto L22
    }

    private boolean j(Uri r2, int r3) {
        if (this.f12021g.isEmpty() == false) goto L5;
    L11:
        return false;
    L5:
        if (this.f12021g.get(r3) == null) goto L11;
        if (TextUtils.isEmpty(this.f12021g.get(r3).b()) == true) goto L11;
        if (this.f12021g.get(r3).b().equals(t(r2)) == false) goto L11;
        return true;
    }

    private boolean k(Uri r5) {
        if (r5 != null) goto L5;
    L20:
        String r4 = "data is null Or requestDataArrayList is null";
    L18:
        com.ss.android.larksso.l.c.h("LarkSSO", r4);
        return false;
    L5:
        if (TextUtils.isEmpty(t(r5)) == true) goto L20;
        if (this.f12021g.isEmpty() == true) goto L20;
        int r2 = 0;
    L11:
        if (r2 >= this.f12021g.size()) goto L17;
        if (j(r5, r2) == true) goto L14;
        r2 = r2 + 1;
        goto L11
    L14:
        return true;
    L17:
        r4 = "checkRequestDataList Failed";
        goto L18
    }

    private void l() {
        B("1161", b.c(this.f12018d), b.d(this.f12018d).equals("Feishu"));
        com.ss.android.larksso.l.c.h("LarkSSO", "appId:" + b.e(this.f12018d) + ",deviceId:" + b.c(this.f12018d) + ",testUnit:" + b.f(this.f12018d) + ",server:" + b.d(this.f12018d) + ",useWeb:" + b.g(this.f12018d) + ",sdkVersion:" + s());
        if (b.g(this.f12018d) == true) goto L5;
        if (b.h(this.f12018d) == false) goto L12;
        String r0 = e();     // Catch: Throwable -> L15
    L13:
        v(r0);     // Catch: Throwable -> L15
        return;
    L12:
        r0 = g();     // Catch: Throwable -> L15
    L16:
        if (b.h(this.f12018d) == true) goto L6;
    L7:
        String r1 = g();
    L8:
        w(r1);
        return;
    L6:
        r1 = e();
        goto L8
    L5:
        if (b.h(this.f12018d) == false) goto L7;
        goto L6
    }

    private String n() {
        String r0 = new String();
        b r1 = this.f12018d;
        if (r1 != null) goto L5;
        return "";
    L5:
        if (b.i(r1) == null) goto L16;
        int r2 = 0;
    L9:
        if (r2 >= b.i(this.f12018d).size()) goto L12;
        r0 = r0.concat((String) b.i(this.f12018d).get(r2)).concat(" ");
        r2 = r2 + 1;
        goto L9
    L12:
        return r0.trim();
    L16:
        return "";
    }

    private String o() {
        String r0 = b.f(this.f12018d);
        int r1 = r0.hashCode();
        if (r1 == (-1897523141)) goto L16;
        if (r1 == (-1039745817)) goto L13;
        if (r1 == 97720) goto L10;
    L18:
        byte r2 = -1;
    L19:
        boolean r4 = "Feishu".equals(b.d(this.f12018d));
        if (r2 == 0) goto L30;
        if (r2 == 1) goto L26;
        if (r4 == false) goto L24;
        return "passport.feishu.cn";
    L24:
        return "passport.larksuite.com";
    L26:
        if (r4 == false) goto L28;
        return "passport.feishu-boe.cn";
    L28:
        return "passport.larksuite-boe.cn";
    L30:
        if (r4 == false) goto L32;
        return "passport.feishu-staging.cn";
    L32:
        return "passport.larksuite-staging.com";
    L10:
        if (r0.equals(TTNetInit.DOMAIN_BOE_KEY) == false) goto L18;
        r2 = 1;
        goto L19
    L13:
        if (r0.equals("normal") == false) goto L18;
        r2 = 2;
        goto L19
    L16:
        if (r0.equals("staging") == false) goto L18;
        r2 = 0;
        goto L19
    }

    private static String p() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    private String q() {
        b r0 = this.f12018d;
        if (r0 != null) goto L5;
        return "";
    L5:
        if (TextUtils.isEmpty(b.e(r0)) == false) goto L8;
        return "";
    L8:
        return b.e(this.f12018d).concat("://").concat("oauth");
    }

    private String r(Uri r4) {
        if (r4 != null) goto L5;
    L17:
        return "";
    L5:
        if (TextUtils.isEmpty(t(r4)) == true) goto L17;
        if (this.f12021g.isEmpty() == true) goto L17;
        int r1 = 0;
    L11:
        if (r1 >= this.f12021g.size()) goto L17;
        if (j(r4, r1) == true) goto L15;
        r1 = r1 + 1;
        goto L11
    L15:
        return this.f12021g.get(r1).a();
    }

    private String s() {
        return "3.0.3";
    }

    private CharSequence t(Uri r1) {
        if (r1 != null) goto L6;
        return "";
    L6:
        return r1.getQueryParameter(WsConstants.KEY_CONNECTION_STATE);
    }

    private String u() {
        if (TextUtils.isEmpty(b.a(this.f12018d)) == true) goto L7;
        return b.a(this.f12018d);
    L7:
        if (TextUtils.isEmpty(Locale.getDefault().getLanguage()) == false) goto L9;
        return "zh";
    L9:
        return Locale.getDefault().getLanguage();
    }

    private void v(String r4) {
        com.ss.android.larksso.l.c.h("LarkSSO", "Feishu/Lark installed, jump verification");
        Intent r0 = new Intent("android.intent.action.VIEW", Uri.parse("lark://ssoclient/web?url=".concat(r4)));
        r0.putExtra("internal", true);
        if (y(this.f12017c, r0) == false) goto L5;
        this.f12017c.startActivityForResult(r0, 0);
        return;
    L5:
        w(r4);
    }

    private void w(String r6) {
        com.ss.android.larksso.l.c.h("LarkSSO", "Feishu/Lark is not installed, downgrade operation");
        Intent r1 = new Intent();     // Catch: Exception -> L5
        r1.setComponent(new ComponentName("com.obric.larksso_webview", "com.obric.larksso_webview.ObricLarkSSOActivity"));     // Catch: Exception -> L5
        r1.putExtra("build_url", r6);     // Catch: Exception -> L5
        this.f12017c.startActivityForResult(r1, 0);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        com.ss.android.larksso.l.c.h("LarkSSO", "start ObricLarkSSOActivity failed." + e);
    }

    public static c x() {
        return C0313c.a();
    }

    public static boolean y(Context r1, Intent r2) {
        if (r1.getPackageManager().queryIntentActivities(r2, 131072).size() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean z() {
        b r0 = this.f12018d;
        if (r0 != null) goto L5;
    L17:
        m(i.f12044l.a(), "");
        return false;
    L5:
        if (TextUtils.isEmpty(b.e(r0)) == true) goto L17;
        if (TextUtils.isEmpty(b.d(this.f12018d)) == true) goto L17;
        if ("Feishu".equals(b.d(this.f12018d)) == true) goto L13;
        if ("Lark".equals(b.d(this.f12018d)) == false) goto L17;
    L13:
        if (TextUtils.isEmpty(b.c(this.f12018d)) == true) goto L17;
        return true;
    }

    public void A(Activity r1, Intent r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        i(r2.getData());
        if (r1.getIntent().getData() == null) goto L8;
        r1.getIntent().setData(null);
        return;
    }

    public synchronized void D(b r1, com.ss.android.larksso.b r2) {
        monitor-enter(this);
        this.f12018d = r1;     // Catch: Throwable -> L11
        this.f12017c = b.b(r1);     // Catch: Throwable -> L11
        this.f12016b = r2;     // Catch: Throwable -> L11
        if (z() == true) goto L8;
        Log.e("LarkSSO", "The parameter is not correct");     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L8:
        l();     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public void m(String r3, String r4) {
        com.ss.android.larksso.b r0 = this.f12016b;
        if (r0 == null) goto L6;
        r0.b(new com.ss.android.larksso.a(r3, r4));
        this.f12016b = null;
        return;
    }
}
