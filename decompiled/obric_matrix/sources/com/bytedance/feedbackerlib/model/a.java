package com.bytedance.feedbackerlib.model;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.os.EnvironmentCompat;
import androidx.lifecycle.CoroutineLiveDataKt;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.feedbackerlib.Feedbacker;
import com.bytedance.feedbackerlib.provider.FeedbackerContentProvider;
import com.google.gson.Gson;
import com.ss.ttuploader.TTImageInfo;
import com.ss.ttuploader.TTImageUploader;
import com.ss.ttuploader.TTImageUploaderListener;
import com.ss.ttuploader.TTVideoInfo;
import com.ss.ttuploader.TTVideoUploader;
import com.ss.ttuploader.TTVideoUploaderListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONObject;
import os.teatracker.IBdInstall;
import p000j.a0;
import p000j.d0;
import p000j.e0;
import p000j.f0;
import p000j.g0;
import p000j.y;

/* JADX INFO: loaded from: classes.dex */
public class a {
    private static final Handler m = null;
    private static volatile a n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Gson f4481a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f4482b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f4483c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<com.bytedance.feedbackerlib.model.e.c> f4484d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<com.bytedance.feedbackerlib.model.e.c> f4485e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List<com.bytedance.feedbackerlib.model.e.c> f4486f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private List<com.bytedance.feedbackerlib.model.e.c> f4487g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f4488h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f4489i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Map<String, com.bytedance.feedbackerlib.model.e.d> f4490j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f4491k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private com.bytedance.feedbackerlib.model.e.e f4492l;

    /* JADX INFO: renamed from: com.bytedance.feedbackerlib.model.a$a, reason: collision with other inner class name */
    class C0132a implements com.bytedance.feedbackerlib.m.g.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ v f4493a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f4494b;

        C0132a(a r1, v r2) {
            this.f4494b = r1;
            this.f4493a = r2;
        }

        @Override // com.bytedance.feedbackerlib.m.g.e
        public void a(@Nullable String r6, @NonNull String r7) {
            Log.d("FeedbackModel", "onHttpRequestFinished: " + r6);
            if (TextUtils.isEmpty(r6) == false) goto L5;
        L12:
            this.f4493a.a(1, r7);
            return;
        L5:
            if (TextUtils.isEmpty(r7) == false) goto L12;
            JSONObject r8 = new JSONObject(r6);     // Catch: Throwable -> L9
            boolean r1 = r8.optJSONObject("data").optBoolean("is_allowed");     // Catch: Throwable -> L9
            a.t(this.f4494b, (com.bytedance.feedbackerlib.model.e.e) new Gson().m(r8.optJSONObject("data").optString("user_info"), com.bytedance.feedbackerlib.model.e.e.class));     // Catch: Throwable -> L9
            this.f4493a.a(0, Boolean.toString(r1));     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            this.f4493a.a(1, r6 + ": " + th.getMessage());
        }
    }

    class b implements com.bytedance.feedbackerlib.m.g.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f4495a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ v f4496b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f4497c;

        b(a r1, String r2, v r3) {
            this.f4497c = r1;
            this.f4495a = r2;
            this.f4496b = r3;
        }

        @Override // com.bytedance.feedbackerlib.m.g.e
        public void a(@Nullable String r8, @NonNull String r9) {
            com.bytedance.feedbackerlib.m.c.b("FeedbackModel", "requestAccessCredentialsFromServer finished: result is " + r8 + ", errorDetail: " + r9);
            com.bytedance.feedbackerlib.m.r.k(this.f4495a, "requestAccessCredentialsFromServer finished", new String[]{"result is " + r8 + ", errorDetail: " + r9});
            if (TextUtils.isEmpty(r9) == true) goto L5;
        L14:
            com.bytedance.feedbackerlib.m.c.a("FeedbackModel", "request user access token failed!", new RuntimeException(r9));
            this.f4496b.a(1, r9);
            return;
        L5:
            if (TextUtils.isEmpty(r8) == true) goto L14;
            String r10 = new JSONObject(r8).optJSONObject("data").optString("user_access_token");     // Catch: Throwable -> L12
            if (TextUtils.isEmpty(r10) == false) goto L10;
            com.bytedance.feedbackerlib.model.e.a.d(15003);     // Catch: Throwable -> L12
            this.f4496b.a(1, "userAccessToken is empty: " + r10);     // Catch: Throwable -> L12
        L16:
            return;
        L10:
            this.f4496b.a(0, r10);     // Catch: Throwable -> L12
            a.v(this.f4497c, r10);     // Catch: Throwable -> L12
            com.bytedance.feedbackerlib.m.q.d.s.c(a.u(this.f4497c));     // Catch: Throwable -> L12
            com.bytedance.feedbackerlib.m.q.c.f4307g.b(System.currentTimeMillis());     // Catch: Throwable -> L12
        L12:
            this.f4496b.a(1, "response error: " + r8);
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ v f4498f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f4499g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f4500h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ a f4501i;

        /* JADX INFO: renamed from: com.bytedance.feedbackerlib.model.a$c$a, reason: collision with other inner class name */
        class RunnableC0133a implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ c f4502f;

            RunnableC0133a(c r1) {
                this.f4502f = r1;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f4502f.f4498f.a(1, "httpUrl == null");
            }
        }

        class b implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ c f4503f;

            b(c r1) {
                this.f4503f = r1;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.feedbackerlib.model.e.a.c(25004);
                this.f4503f.f4498f.a(1, "response == null");
            }
        }

        /* JADX INFO: renamed from: com.bytedance.feedbackerlib.model.a$c$c, reason: collision with other inner class name */
        class RunnableC0134c implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ c f4504f;

            RunnableC0134c(c r1) {
                this.f4504f = r1;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.feedbackerlib.model.e.a.c(25003);
                this.f4504f.f4498f.a(1, "body == null");
            }
        }

        class d implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ c f4505f;

            d(c r1) {
                this.f4505f = r1;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f4505f.f4498f.a(0, "request feedbacker activate info successed");
            }
        }

        class e implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ IOException f4506f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ c f4507g;

            e(c r1, IOException r2) {
                this.f4507g = r1;
                this.f4506f = r2;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.feedbackerlib.m.c.b("FeedbackModel", "requestFeedbackerActivateInfoFromServer: exception: " + this.f4506f.toString());
                com.bytedance.feedbackerlib.m.r.h(this.f4507g.f4500h, "requestFeedbackerActivateInfoFromServer: exception: " + this.f4506f.toString(), new String[0]);
                com.bytedance.feedbackerlib.model.e.a.c(25001);
                this.f4507g.f4498f.a(1, "exception: " + this.f4506f.getMessage());
            }
        }

        class f implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ Throwable f4508f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ c f4509g;

            f(c r1, Throwable r2) {
                this.f4509g = r1;
                this.f4508f = r2;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.feedbackerlib.m.c.b("FeedbackModel", "requestFeedbackerActivateInfoFromServer: exception: " + this.f4508f.toString());
                com.bytedance.feedbackerlib.m.r.h(this.f4509g.f4500h, "requestFeedbackerActivateInfoFromServer: exception: " + this.f4508f.toString(), new String[0]);
                this.f4509g.f4498f.a(1, "exception: " + this.f4508f.getMessage());
            }
        }

        c(a r1, v r2, String r3, String r4) {
            this.f4501i = r1;
            this.f4498f = r2;
            this.f4499g = r3;
            this.f4500h = r4;
        }

        @Override // java.lang.Runnable
        public void run() {
            p000j.w r3 = p000j.w.r(com.bytedance.feedbackerlib.m.g.f.f4290b + "v1/package/active2");
            if (r3 != null) goto L6;
            com.bytedance.feedbackerlib.m.t.a(new RunnableC0133a(this));
            return;
        L6:
            String r4 = Feedbacker.getLarkSSOEmail();
            if (r4 != null) goto L9;
            r4 = EnvironmentCompat.MEDIA_UNKNOWN;
        L9:
            j.w.a r5 = r3.p();
            r5.a("pkg_md5", this.f4499g);
            r5.a("zone_identifier", a.c(this.f4501i));
            r5.a(NotificationCompat.CATEGORY_EMAIL, r4);
            r5.a(IBdInstall.PARAM_APP_ID, Feedbacker.getAid() + "");
            d0.a r6 = new d0.a();
            r6.l(r5.b());
            r6.c();
            d0 r7 = r6.b();
            com.bytedance.feedbackerlib.m.c.b("FeedbackModel", "requestFeedbackerActivateInfoFromServer: request: " + r7 + ", header: " + r7.d());
            com.bytedance.feedbackerlib.m.r.h(this.f4500h, "requestFeedbackerActivateInfoFromServer: request: " + r7 + ", header: " + r7.d(), new String[0]);
            f0 r8 = null;
            r8 = com.bytedance.feedbackerlib.m.g.h().w(r7).execute();     // Catch: Throwable -> L24 Throwable -> L26
            com.bytedance.feedbackerlib.m.c.b("FeedbackModel", "requestFeedbackerActivateInfoFromServer: response: " + r8);     // Catch: Throwable -> L24 Throwable -> L26
            com.bytedance.feedbackerlib.m.r.h(this.f4500h, "requestFeedbackerActivateInfoFromServer: response: " + r8, new String[0]);     // Catch: Throwable -> L24 Throwable -> L26
            if (r8 != null) goto L15;
            com.bytedance.feedbackerlib.m.t.a(new b(this));     // Catch: Throwable -> L24 Throwable -> L26
            com.bytedance.feedbackerlib.m.s.a(r8);
            return;
        L15:
            g0 r2 = r8.a();     // Catch: Throwable -> L24 Throwable -> L26 Throwable -> L26
            com.bytedance.feedbackerlib.m.c.b("FeedbackModel", "requestFeedbackerActivateInfoFromServer: body: " + r2);     // Catch: Throwable -> L24 Throwable -> L26 Throwable -> L26
            com.bytedance.feedbackerlib.m.r.h(this.f4500h, "requestFeedbackerActivateInfoFromServer: body: " + r2, new String[0]);     // Catch: Throwable -> L24 Throwable -> L26 Throwable -> L26
            if (r2 != null) goto L20;
            com.bytedance.feedbackerlib.m.t.a(new RunnableC0134c(this));     // Catch: Throwable -> L24 Throwable -> L26 Throwable -> L26
            com.bytedance.feedbackerlib.m.s.a(r8);
            return;
        L20:
            JSONObject r9 = new JSONObject(r2.C());     // Catch: Throwable -> L24 Throwable -> L26 Throwable -> L26
            com.bytedance.feedbackerlib.m.c.b("FeedbackModel", "requestFeedbackerActivateInfoFromServer: jsonObj: " + r9);     // Catch: Throwable -> L24 Throwable -> L26 Throwable -> L26
            com.bytedance.feedbackerlib.m.r.h(this.f4500h, "requestFeedbackerActivateInfoFromServer: jsonObj: " + r9, new String[0]);     // Catch: Throwable -> L24 Throwable -> L26 Throwable -> L26
            a.d(this.f4501i, r9.optJSONObject("data").optInt("active"));     // Catch: Throwable -> L34
        L22:
            com.bytedance.feedbackerlib.m.t.a(new d(this));     // Catch: Throwable -> L24 Throwable -> L26 Throwable -> L26
        L29:
            com.bytedance.feedbackerlib.m.s.a(r8);
            return;
        L24:
            th = move-exception;
            th.printStackTrace();     // Catch: Throwable -> L31
            Runnable r1 = new f(this, th);     // Catch: Throwable -> L31
        L28:
            com.bytedance.feedbackerlib.m.t.a(r1);     // Catch: Throwable -> L31
        L26:
            e = move-exception;
            e.printStackTrace();     // Catch: Throwable -> L31
            r1 = new e(this, e);     // Catch: Throwable -> L31
        L31:
            th = move-exception;
            com.bytedance.feedbackerlib.m.s.a(null);
            throw th;
        }
    }

    class d implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ com.bytedance.feedbackerlib.model.e.c f4510f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ com.bytedance.feedbackerlib.model.e.c f4511g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ com.bytedance.feedbackerlib.model.e.c f4512h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f4513i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ com.bytedance.feedbackerlib.model.e.c f4514j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ com.bytedance.feedbackerlib.model.e.c f4515k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ String f4516l;
        final /* synthetic */ String m;
        final /* synthetic */ String n;
        final /* synthetic */ String o;
        final /* synthetic */ String p;
        final /* synthetic */ List q;
        final /* synthetic */ List r;
        final /* synthetic */ v s;
        final /* synthetic */ String t;
        final /* synthetic */ a u;

        /* JADX INFO: renamed from: com.bytedance.feedbackerlib.model.a$d$a, reason: collision with other inner class name */
        class RunnableC0135a implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ d f4517f;

            RunnableC0135a(d r1) {
                this.f4517f = r1;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f4517f.s.a(1, "无法得到response");
            }
        }

        class b implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ d f4518f;

            b(d r1) {
                this.f4518f = r1;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.feedbackerlib.model.e.a.e(45004);
                this.f4518f.s.a(1, "无法得到response");
            }
        }

        class c implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ d f4519f;

            c(d r1) {
                this.f4519f = r1;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.feedbackerlib.model.e.a.e(45003);
                this.f4519f.s.a(1, "无法得到response");
            }
        }

        /* JADX INFO: renamed from: com.bytedance.feedbackerlib.model.a$d$d, reason: collision with other inner class name */
        class RunnableC0136d implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ int f4520f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ String f4521g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ d f4522h;

            RunnableC0136d(d r1, int r2, String r3) {
                this.f4522h = r1;
                this.f4520f = r2;
                this.f4521g = r3;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f4520f != 200) goto L5;
                v r0 = this.f4522h.s;
                int r1 = 0;
            L6:
                r0.a(r1, this.f4521g);
                return;
            L5:
                r0 = this.f4522h.s;
                r1 = 1;
                goto L6
            }
        }

        class e implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ d f4523f;

            e(d r1) {
                this.f4523f = r1;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f4523f.s.a(1, "请求失败");
            }
        }

        class f implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ d f4524f;

            f(d r1) {
                this.f4524f = r1;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f4524f.s.a(1, "请求失败");
            }
        }

        d(a r3, com.bytedance.feedbackerlib.model.e.c r4, com.bytedance.feedbackerlib.model.e.c r5, com.bytedance.feedbackerlib.model.e.c r6, String r7, com.bytedance.feedbackerlib.model.e.c r8, com.bytedance.feedbackerlib.model.e.c r9, String r10, String r11, String r12, String r13, String r14, List r15, List r16, v r17, String r18) {
            this.u = r3;
            this.f4510f = r4;
            this.f4511g = r5;
            this.f4512h = r6;
            this.f4513i = r7;
            this.f4514j = r8;
            this.f4515k = r9;
            this.f4516l = r10;
            this.m = r11;
            this.n = r12;
            this.o = r13;
            this.p = r14;
            this.q = r15;
            this.r = r16;
            this.s = r17;
            this.t = r18;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.e(this.u);
            JSONObject r10 = new JSONObject();
        L77:
            com.bytedance.feedbackerlib.m.t.a(new RunnableC0135a(this));
            com.bytedance.feedbackerlib.m.c.b("FeedbackModel", "无法得到response");
            com.bytedance.feedbackerlib.m.r.o(this.t, "无法得到response", new String[0]);
            return;
        L5:
            if (this.f4510f.f4617a != 0) goto L16;
            com.bytedance.feedbackerlib.model.e.c r0 = this.f4511g;     // Catch: Throwable -> L77
            if (r0 == null) goto L9;
            r10.put("user_bug_level", r0.f4617a);     // Catch: Throwable -> L77
        L9:
            com.bytedance.feedbackerlib.model.e.c r1 = this.f4512h;     // Catch: Throwable -> L77
            if (r1 == null) goto L81;
            r10.put("tag_id", r1.f4617a);     // Catch: Throwable -> L77
        L81:
            r10.put("recurrent_time", Integer.parseInt(this.f4513i));     // Catch: Throwable -> L14
        L14:
            th = move-exception;
            com.bytedance.feedbackerlib.m.c.a("FeedbackModel", "recurrent_time parse number failed", th);     // Catch: Throwable -> L77
            r10.put("recurrent_time", 0);     // Catch: Throwable -> L77
        L16:
            long r13 = this.f4510f.f4617a;     // Catch: Throwable -> L77
            if (r13 != 1) goto L22;
            com.bytedance.feedbackerlib.model.e.c r2 = this.f4514j;     // Catch: Throwable -> L77
            if (r2 == null) goto L27;
        L20:
            r10.put("tag_id", r2.f4617a);     // Catch: Throwable -> L77
        L27:
            if (Feedbacker.getAid() != null) goto L29;
            int r7 = -1;
        L30:
            r10.put(IBdInstall.PARAM_APP_ID, r7);     // Catch: Throwable -> L77
            r10.put(WsConstants.KEY_DEVICE_ID, Feedbacker.getDid());     // Catch: Throwable -> L77
            r10.put(NotificationCompat.CATEGORY_EMAIL, this.f4516l);     // Catch: Throwable -> L77
            r10.put("content", this.m);     // Catch: Throwable -> L77
            r10.put("feedback_type", this.f4510f.f4617a + 1);     // Catch: Throwable -> L77
            r10.put("version_code", Feedbacker.getVersionCode() + "");     // Catch: Throwable -> L77
            r10.put("version_name", Feedbacker.getVersionName());     // Catch: Throwable -> L77
            r10.put("update_version_code", Feedbacker.getUpdateVersionCode());     // Catch: Throwable -> L77
            r10.put("bundle_id", this.n);     // Catch: Throwable -> L77
            r10.put("channel", Feedbacker.getChannel());     // Catch: Throwable -> L77
            r10.put(WsConstants.KEY_PLATFORM, 1);     // Catch: Throwable -> L77
            r10.put("os_version", Build.VERSION.RELEASE);     // Catch: Throwable -> L77
            r10.put("device_type", Build.MODEL);     // Catch: Throwable -> L77
            r10.put("ac", this.o);     // Catch: Throwable -> L77
            r10.put("pkg_md5", this.u.F());     // Catch: Throwable -> L77
            r10.put("zone_identifier", a.c(this.u));     // Catch: Throwable -> L77
            String r3 = this.p;     // Catch: Throwable -> L77
            if (r3 == null) goto L34;
            r10.put("resolution", r3);     // Catch: Throwable -> L77
        L34:
            if (Feedbacker.getUserId() == null) goto L36;
            r10.put("app_user_id", Feedbacker.getUserId());     // Catch: Throwable -> L77
        L36:
            JSONArray r4 = new JSONArray();     // Catch: Throwable -> L77
            List r8 = this.q;     // Catch: Throwable -> L77
            if (r8 != null) goto L39;
        L45:
            JSONArray r5 = new JSONArray();     // Catch: Throwable -> L77
            List r9 = this.r;     // Catch: Throwable -> L77
            if (r9 != null) goto L48;
        L54:
            e0 r6 = e0.c(y.d("application/json;charset=UTF-8"), r10.toString().replaceAll("\\\\/", "/"));
            String r11 = com.bytedance.feedbackerlib.m.g.f.f4290b + "v1/feedback";
            d0.a r12 = new d0.a();
            r12.k(r11);
            r12.g(r6);
            d0 r14 = r12.b();
            f0 r15 = null;
            a0 r16 = com.bytedance.feedbackerlib.m.g.h();     // Catch: Throwable -> L67 Throwable -> L70
            com.bytedance.feedbackerlib.m.c.b("FeedbackModel", "submitFeedbackToServer: request: " + r14 + ", header: " + r14.d());     // Catch: Throwable -> L67 Throwable -> L70
            com.bytedance.feedbackerlib.m.r.o(this.t, "submitFeedbackToServer: request: " + r14 + ", header: " + r14.d(), new String[0]);     // Catch: Throwable -> L67 Throwable -> L70
            r15 = r16.w(r14).execute();     // Catch: Throwable -> L67 Throwable -> L70
            StringBuilder r17 = new StringBuilder();     // Catch: Throwable -> L67 Throwable -> L70
            r17.append("submitFeedbackToServer: response: ");     // Catch: Throwable -> L67 Throwable -> L70
            r17.append(r15);     // Catch: Throwable -> L67 Throwable -> L70
            com.bytedance.feedbackerlib.m.c.b("FeedbackModel", r17.toString());     // Catch: Throwable -> L67 Throwable -> L70
            com.bytedance.feedbackerlib.m.r.o(this.t, "submitFeedbackToServer: response: " + r15, new String[0]);     // Catch: Throwable -> L67 Throwable -> L70
            if (r15 != null) goto L60;
            com.bytedance.feedbackerlib.m.t.a(new b(this));     // Catch: Throwable -> L67 Throwable -> L70
            com.bytedance.feedbackerlib.m.s.a(r15);
            return;
        L60:
            int r18 = r15.s();     // Catch: Throwable -> L67 Throwable -> L70 Throwable -> L70
            g0 r19 = r15.a();     // Catch: Throwable -> L67 Throwable -> L70 Throwable -> L70
            com.bytedance.feedbackerlib.m.c.b("FeedbackModel", "submitFeedbackToServer: body: " + r19);     // Catch: Throwable -> L67 Throwable -> L70 Throwable -> L70
            com.bytedance.feedbackerlib.m.r.o(this.t, "submitFeedbackToServer: body: " + r19, new String[0]);     // Catch: Throwable -> L67 Throwable -> L70 Throwable -> L70
            if (r19 != null) goto L65;
            com.bytedance.feedbackerlib.m.t.a(new c(this));     // Catch: Throwable -> L67 Throwable -> L70 Throwable -> L70
            com.bytedance.feedbackerlib.m.s.a(r15);
            return;
        L65:
            JSONObject r20 = new JSONObject(r19.C());     // Catch: Throwable -> L67 Throwable -> L70 Throwable -> L70
            com.bytedance.feedbackerlib.m.c.b("FeedbackModel", "submitFeedbackToServer: jsonObject: " + r20);     // Catch: Throwable -> L67 Throwable -> L70 Throwable -> L70
            com.bytedance.feedbackerlib.m.r.o(this.t, "submitFeedbackToServer: jsonObject: " + r20, new String[0]);     // Catch: Throwable -> L67 Throwable -> L70 Throwable -> L70
            com.bytedance.feedbackerlib.m.t.a(new RunnableC0136d(this, r18, r20.optString("result")));     // Catch: Throwable -> L67 Throwable -> L70 Throwable -> L70
        L69:
            com.bytedance.feedbackerlib.m.s.a(r15);
            return;
        L70:
            e = move-exception;
            e.printStackTrace();     // Catch: Throwable -> L74
            com.bytedance.feedbackerlib.m.t.a(new e(this));     // Catch: Throwable -> L74
            com.bytedance.feedbackerlib.m.c.b("FeedbackModel", "submitFeedbackToServer请求失败: " + e.toString());     // Catch: Throwable -> L74
            com.bytedance.feedbackerlib.m.r.o(this.t, "submitFeedbackToServer请求失败: " + e.toString(), new String[0]);     // Catch: Throwable -> L74
            com.bytedance.feedbackerlib.model.e.a.e(45001);     // Catch: Throwable -> L74
        L67:
            th = move-exception;
            th.printStackTrace();     // Catch: Throwable -> L74
            com.bytedance.feedbackerlib.m.t.a(new f(this));     // Catch: Throwable -> L74
            com.bytedance.feedbackerlib.m.c.b("FeedbackModel", "submitFeedbackToServer请求失败: " + th.toString());     // Catch: Throwable -> L74
            com.bytedance.feedbackerlib.m.r.o(this.t, "submitFeedbackToServer请求失败: " + th.toString(), new String[0]);     // Catch: Throwable -> L74
        L74:
            th = move-exception;
            com.bytedance.feedbackerlib.m.s.a(null);
            throw th;
        L48:
            if (r9.size() <= 0) goto L54;
            Iterator r21 = this.r.iterator();     // Catch: Throwable -> L77
        L51:
            if (r21.hasNext() == false) goto L53;
            r5.put((String) r21.next());     // Catch: Throwable -> L77
            goto L51
        L53:
            r10.put("video_url", r5);     // Catch: Throwable -> L77
            goto L54
        L39:
            if (r8.size() <= 0) goto L45;
            Iterator r22 = this.q.iterator();     // Catch: Throwable -> L77
        L42:
            if (r22.hasNext() == false) goto L44;
            r4.put((String) r22.next());     // Catch: Throwable -> L77
            goto L42
        L44:
            r10.put("pic_url", r4);     // Catch: Throwable -> L77
            goto L45
        L29:
            r7 = Feedbacker.getAid().intValue();     // Catch: Throwable -> L77
            goto L30
        L22:
            if (r13 != 7) goto L27;
            r2 = this.f4515k;     // Catch: Throwable -> L77
            if (r2 == null) goto L27;
            goto L27
        }
    }

    class e implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f4525f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ v f4526g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ a f4527h;

        /* JADX INFO: renamed from: com.bytedance.feedbackerlib.model.a$e$a, reason: collision with other inner class name */
        class RunnableC0137a implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ e f4528f;

            RunnableC0137a(e r1) {
                this.f4528f = r1;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f4528f.f4526g.a(1, "response == null");
            }
        }

        class b implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ e f4529f;

            b(e r1) {
                this.f4529f = r1;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f4529f.f4526g.a(1, "body == null");
            }
        }

        class c implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ String f4530f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ e f4531g;

            c(e r1, String r2) {
                this.f4531g = r1;
                this.f4530f = r2;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f4531g.f4526g.a(1, "analys response failed: " + this.f4530f);
            }
        }

        class d implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ e f4532f;

            d(e r1) {
                this.f4532f = r1;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f4532f.f4526g.a(0, "success");
            }
        }

        /* JADX INFO: renamed from: com.bytedance.feedbackerlib.model.a$e$e, reason: collision with other inner class name */
        class RunnableC0138e implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ String f4533f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ e f4534g;

            RunnableC0138e(e r1, String r2) {
                this.f4534g = r1;
                this.f4533f = r2;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f4534g.f4526g.a(1, "analys response failed: " + this.f4533f);
            }
        }

        class f implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ Throwable f4535f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ e f4536g;

            f(e r1, Throwable r2) {
                this.f4536g = r1;
                this.f4535f = r2;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f4536g.f4526g.a(1, this.f4535f.getMessage());
            }
        }

        e(a r1, String r2, v r3) {
            this.f4527h = r1;
            this.f4525f = r2;
            this.f4526g = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            String r0 = com.bytedance.feedbackerlib.m.g.f.f4289a + "001c7e40906711ea92d03fb1ddc95a6e/android/" + this.f4525f;
            a0 r1 = com.bytedance.feedbackerlib.m.g.h();
            d0.a r2 = new d0.a();
            r2.k(r0);
            r2.c();
            d0 r3 = r2.b();
            f0 r4 = null;
            com.bytedance.feedbackerlib.m.c.b("FeedbackModel", "requestTranslationFromServer: request: " + r3 + ", headers: " + r3.d());     // Catch: Throwable -> L35
            r4 = r1.w(r3).execute();     // Catch: Throwable -> L35
            StringBuilder r5 = new StringBuilder();     // Catch: Throwable -> L35
            r5.append("requestTranslationFromServer: response: ");     // Catch: Throwable -> L35
            r5.append(r4);     // Catch: Throwable -> L35
            com.bytedance.feedbackerlib.m.c.b("FeedbackModel", r5.toString());     // Catch: Throwable -> L35
            if (r4 != null) goto L8;
            com.bytedance.feedbackerlib.m.t.a(new RunnableC0137a(this));     // Catch: Throwable -> L35
            com.bytedance.feedbackerlib.m.s.a(r4);
            return;
        L8:
            g0 r6 = r4.a();     // Catch: Throwable -> L35
            com.bytedance.feedbackerlib.m.c.b("FeedbackModel", "requestTranslationFromServer: body: " + r6);     // Catch: Throwable -> L35
            if (r6 != null) goto L13;
            com.bytedance.feedbackerlib.m.t.a(new b(this));     // Catch: Throwable -> L35
            com.bytedance.feedbackerlib.m.s.a(r4);
            return;
        L13:
            String r7 = r6.C();     // Catch: Throwable -> L35
            com.bytedance.feedbackerlib.m.c.b("FeedbackModel", "requestTranslationFromServer: responseStr: " + r7);     // Catch: Throwable -> L35
            com.bytedance.feedbackerlib.model.d.b r8 = com.bytedance.feedbackerlib.model.d.b.a(r7);     // Catch: Throwable -> L33
            if (r8.f4612b != 200) goto L30;
            Map<String, String> r9 = r8.f4611a;     // Catch: Throwable -> L33
            if (r9 == null) goto L30;
            if (r9.size() <= 0) goto L30;
            Map r10 = a.f(this.f4527h);     // Catch: Throwable -> L33
            monitor-enter(r10);     // Catch: Throwable -> L33
            a.f(this.f4527h).put(this.f4525f, com.bytedance.feedbackerlib.model.e.d.a(r8));     // Catch: Throwable -> L27
            monitor-exit(r10);     // Catch: Throwable -> L27
            com.bytedance.feedbackerlib.m.t.a(new d(this));     // Catch: Throwable -> L33
        L37:
            com.bytedance.feedbackerlib.m.s.a(r4);
            return;
        L27:
            th = move-exception;
            throw th;     // Catch: Throwable -> L33
        L30:
            com.bytedance.feedbackerlib.m.t.a(new c(this, r7));     // Catch: Throwable -> L33
            com.bytedance.feedbackerlib.m.s.a(r4);
            return;
        L33:
            com.bytedance.feedbackerlib.m.t.a(new RunnableC0138e(this, r7));     // Catch: Throwable -> L35
        L35:
            th = move-exception;
            com.bytedance.feedbackerlib.m.t.a(new f(this, th));     // Catch: Throwable -> L39
        L39:
            th = move-exception;
            com.bytedance.feedbackerlib.m.s.a(r4);
            throw th;
        }
    }

    class f implements com.bytedance.apm.p.e {
        f(a r1) {
        }

        @Override // com.bytedance.apm.p.e
        public void flushAlogDataToFile() {
            d.i.a.a.a.h();     // Catch: Throwable -> L4
            d.i.a.a.a.i();     // Catch: Throwable -> L4
            Thread.sleep(1000);     // Catch: Throwable -> L4
            return;
        }
    }

    class g implements v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f4537a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ w f4538b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f4539c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ a f4540d;

        g(a r1, List r2, w r3, String r4) {
            this.f4540d = r1;
            this.f4537a = r2;
            this.f4538b = r3;
            this.f4539c = r4;
        }

        @Override // com.bytedance.feedbackerlib.model.a.v
        public void a(int r3, String r4) {
            if (r3 != 0) goto L4;
            a.g(this.f4540d, r4, this.f4537a, this.f4538b, this.f4539c);
            return;
        L4:
            this.f4538b.a(1, r4, null, null);
        }
    }

    class h implements w {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ w f4541a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Uri f4542b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f4543c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f4544d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ a f4545e;

        h(a r1, w r2, Uri r3, String r4, String r5) {
            this.f4545e = r1;
            this.f4541a = r2;
            this.f4542b = r3;
            this.f4543c = r4;
            this.f4544d = r5;
        }

        @Override // com.bytedance.feedbackerlib.model.a.w
        public void a(int r8, @Nullable String r9, List<String> r10, List<String> r11) {
            if (r8 != 1) goto L6;
            this.f4541a.a(1, r9, null, null);
            return;
        L6:
            Uri r3 = this.f4542b;
            if (r3 == null) goto L9;
            a.h(this.f4545e, this.f4543c, r3, this.f4541a, r10, this.f4544d);
            return;
        L9:
            this.f4541a.a(0, r9, r10, r11);
        }
    }

    class i implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f4546f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ v f4547g;

        /* JADX INFO: renamed from: com.bytedance.feedbackerlib.model.a$i$a, reason: collision with other inner class name */
        class RunnableC0139a implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ i f4548f;

            RunnableC0139a(i r1) {
                this.f4548f = r1;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f4548f.f4547g.a(1, null);
            }
        }

        class b implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ i f4549f;

            b(i r1) {
                this.f4549f = r1;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f4549f.f4547g.a(1, null);
            }
        }

        class c implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ i f4550f;

            c(i r1) {
                this.f4550f = r1;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f4550f.f4547g.a(1, null);
            }
        }

        class d implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ String f4551f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ i f4552g;

            d(i r1, String r2) {
                this.f4552g = r1;
                this.f4551f = r2;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.isEmpty(this.f4551f) == true) goto L5;
                this.f4552g.f4547g.a(0, this.f4551f);
                return;
            L5:
                this.f4552g.f4547g.a(1, null);
            }
        }

        class e implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ i f4553f;

            e(i r1) {
                this.f4553f = r1;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f4553f.f4547g.a(1, null);
            }
        }

        i(a r1, String r2, v r3) {
            this.f4546f = r2;
            this.f4547g = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            a0 r6 = com.bytedance.feedbackerlib.m.g.h();
            String r7 = com.bytedance.feedbackerlib.m.g.f.f4290b + "tos/auth";
            d0.a r8 = new d0.a();
            r8.k(r7);
            r8.c();
            d0 r9 = r8.b();
            f0 r10 = null;
            com.bytedance.feedbackerlib.m.c.b("FeedbackModel upload", "requestTOSAuthorization: request: " + r9 + ", header: " + r9.d());     // Catch: Throwable -> L24
            com.bytedance.feedbackerlib.m.r.o(this.f4546f, "requestTOSAuthorization: request: " + r9 + ", header: " + r9.d(), new String[0]);     // Catch: Throwable -> L24
            r10 = r6.w(r9).execute();     // Catch: Throwable -> L24
            StringBuilder r3 = new StringBuilder();     // Catch: Throwable -> L24
            r3.append("requestTOSAuthorization: response: ");     // Catch: Throwable -> L24
            r3.append(r10);     // Catch: Throwable -> L24
            com.bytedance.feedbackerlib.m.c.b("FeedbackModel upload", r3.toString());     // Catch: Throwable -> L24
            com.bytedance.feedbackerlib.m.r.o(this.f4546f, "requestTOSAuthorization: response: " + r10, new String[0]);     // Catch: Throwable -> L24
            if (r10 != null) goto L9;
            com.bytedance.feedbackerlib.m.t.a(new RunnableC0139a(this));     // Catch: Throwable -> L24
            if (r10 == null) goto L34;
            r10.close();
            return;
        L34:
            return;
        L9:
            g0 r2 = r10.a();     // Catch: Throwable -> L24
            com.bytedance.feedbackerlib.m.c.b("FeedbackModel upload", "requestTOSAuthorization: body: " + r2);     // Catch: Throwable -> L24
            com.bytedance.feedbackerlib.m.r.o(this.f4546f, "requestTOSAuthorization: body: " + r2, new String[0]);     // Catch: Throwable -> L24
            if (r2 != null) goto L15;
            com.bytedance.feedbackerlib.m.t.a(new b(this));     // Catch: Throwable -> L24
            if (r10 == null) goto L35;
            r10.close();
            return;
        L35:
            return;
        L15:
            JSONObject r1 = new JSONObject(r2.C());     // Catch: Throwable -> L24
            com.bytedance.feedbackerlib.m.c.b("FeedbackModel upload", "requestTOSAuthorization: jsonObject: " + r1);     // Catch: Throwable -> L24
            com.bytedance.feedbackerlib.m.r.o(this.f4546f, "requestTOSAuthorization: jsonObject: " + r1, new String[0]);     // Catch: Throwable -> L24
            JSONObject r0 = r1.optJSONObject("data");     // Catch: Throwable -> L24
            if (r0 != null) goto L21;
            com.bytedance.feedbackerlib.m.t.a(new c(this));     // Catch: Throwable -> L24
            if (r10 == null) goto L36;
            r10.close();
            return;
        L36:
            return;
        L21:
            com.bytedance.feedbackerlib.m.t.a(new d(this, r0.optString("auth")));     // Catch: Throwable -> L24
            if (r10 == null) goto L37;
        L26:
            r10.close();
            return;
        L37:
            return;
        L24:
            com.bytedance.feedbackerlib.m.t.a(new e(this));     // Catch: Throwable -> L28
            if (0 != 0) goto L26;
            return;
        L28:
            th = move-exception;
            if (0 == 0) goto L31;
            r10.close();
        L31:
            throw th;
        }
    }

    class j implements TTImageUploaderListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private List<String> f4554a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ w f4555b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f4556c;

        j(a r1, w r2, String r3) {
            this.f4555b = r2;
            this.f4556c = r3;
            this.f4554a = new ArrayList();
        }

        @Override // com.ss.ttuploader.TTImageUploaderListener
        public void onNotify(int r5, long r6, TTImageInfo r8) {
            if (r5 != 4) goto L5;
        L13:
            this.f4555b.a(1, null, null, null);
            com.bytedance.feedbackerlib.model.e.a.e(35001);
            com.bytedance.feedbackerlib.m.c.b("FeedbackModel upload", "upload image failed");
            com.bytedance.feedbackerlib.m.r.o(this.f4556c, "upload image failed", new String[0]);
            return;
        L5:
            if (r5 == 2) goto L13;
            if (r5 != 3) goto L10;
            this.f4554a.add("https://voffline.byted.org/download/tos/schedule/" + r8.mImageToskey);
        L10:
            if (r5 != 0) goto L15;
            this.f4555b.a(0, null, this.f4554a, null);
            com.bytedance.feedbackerlib.m.c.b("FeedbackModel upload", "upload image succeed");
            com.bytedance.feedbackerlib.m.r.o(this.f4556c, "upload image succeed", new String[0]);
            return;
        }
    }

    static class k extends Handler {
        k(Looper r1) {
            super(r1);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message r1) {
            if (r1.what != 0) goto L7;
            a.I().d0(null);
            return;
        }
    }

    class l implements TTVideoUploaderListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ w f4557a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f4558b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ List f4559c;

        l(a r1, w r2, String r3, List r4) {
            this.f4557a = r2;
            this.f4558b = r3;
            this.f4559c = r4;
        }

        @Override // com.ss.ttuploader.TTVideoUploaderListener
        public String getStringFromExtern(int r1) {
            return null;
        }

        @Override // com.ss.ttuploader.TTVideoUploaderListener
        public void onLog(int r1, int r2, String r3) {
        }

        @Override // com.ss.ttuploader.TTVideoUploaderListener
        public void onNotify(int r6, long r7, TTVideoInfo r9) {
            if (r6 != 2) goto L6;
            this.f4557a.a(1, null, null, null);
            com.bytedance.feedbackerlib.model.e.a.e(35002);
            com.bytedance.feedbackerlib.m.c.b("FeedbackModel upload", "upload video failed");
            com.bytedance.feedbackerlib.m.r.o(this.f4558b, "upload video failed", new String[0]);
            return;
        L6:
            if (r6 != 0) goto L9;
            this.f4557a.a(0, null, this.f4559c, Arrays.asList(new String[]{"https://voffline.byted.org/download/tos/schedule/" + r9.mTosKey}));
            com.bytedance.feedbackerlib.m.c.b("FeedbackModel upload", "upload video succeed");
            com.bytedance.feedbackerlib.m.r.o(this.f4558b, "upload video succeed", new String[0]);
            return;
        }

        @Override // com.ss.ttuploader.TTVideoUploaderListener
        public void onUploadVideoStage(int r1, long r2) {
        }

        @Override // com.ss.ttuploader.TTVideoUploaderListener
        public int videoUploadCheckNetState(int r1, int r2) {
            Context r0 = Feedbacker.getApplicationContext();
            if (r0 != null) goto L6;
            return 0;
        L6:
            if (com.bytedance.feedbackerlib.m.l.a(r0) == 0) goto L10;
            return 1;
        L10:
            return 0;
        }
    }

    class m implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Context f4560f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ t f4561g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ a f4562h;

        /* JADX INFO: renamed from: com.bytedance.feedbackerlib.model.a$m$a, reason: collision with other inner class name */
        class RunnableC0140a implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ m f4563f;

            RunnableC0140a(m r1) {
                this.f4563f = r1;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f4563f.f4561g.a("baseApkPath is empty");
            }
        }

        class b implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ m f4564f;

            b(m r1) {
                this.f4564f = r1;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f4564f.f4561g.a("baseApkFile not exist");
            }
        }

        class c implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ m f4565f;

            c(m r1) {
                this.f4565f = r1;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f4565f.f4561g.a("File Not Found Exception");
            }
        }

        m(a r1, Context r2, t r3) {
            this.f4562h = r1;
            this.f4560f = r2;
            this.f4561g = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            String r1 = this.f4560f.getApplicationContext().getApplicationInfo().sourceDir;
            if (TextUtils.isEmpty(r1) == false) goto L7;
            Runnable r0 = new RunnableC0140a(this);
        L5:
            com.bytedance.feedbackerlib.m.t.a(r0);
            return;
        L7:
            File r2 = new File(r1);
            if (r2.exists() == true) goto L24;
            r0 = new b(this);
            goto L5
        L24:
            FileInputStream r3 = new FileInputStream(r2);     // Catch: Throwable -> L16
            a.j(this.f4562h, com.bytedance.feedbackerlib.m.i.b(r3));     // Catch: Throwable -> L14
            com.bytedance.feedbackerlib.m.c.b("FeedbackModel", "calculateBaseApkMd5: success: " + a.i(this.f4562h));     // Catch: Throwable -> L14
            this.f4561g.a("success");     // Catch: Throwable -> L14
        L19:
            com.bytedance.feedbackerlib.m.s.a(r3);
            return;
        L14:
            Throwable th = th;
        L26:
            th.printStackTrace();     // Catch: Throwable -> L21
            com.bytedance.feedbackerlib.m.t.a(new c(this));     // Catch: Throwable -> L21
            com.bytedance.feedbackerlib.m.c.b("FeedbackModel", "calculateBaseApkMd5: failed");     // Catch: Throwable -> L21
        L21:
            th = move-exception;
            com.bytedance.feedbackerlib.m.s.a(r3);
            throw th;
        L16:
            th = move-exception;
            r3 = null;
            th = th;
            goto L26
        }
    }

    class n implements com.bytedance.feedbackerlib.m.g.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ u f4566a;

        n(a r1, u r2) {
            this.f4566a = r2;
        }

        @Override // com.bytedance.feedbackerlib.m.g.e
        public void a(@Nullable String r3, @NonNull String r4) {
            Boolean r0 = Boolean.FALSE;
            if (TextUtils.isEmpty(r3) == false) goto L5;
        L11:
            this.f4566a.a(r0);
            return;
        L5:
            if (TextUtils.isEmpty(r4) == false) goto L11;
            boolean r5 = new JSONObject(r3).optBoolean(LocationMonitorConst.IS_VALID);     // Catch: Throwable -> L9
            this.f4566a.a(Boolean.valueOf(r5));     // Catch: Throwable -> L9
            return;
        L9:
            this.f4566a.a(r0);
        }
    }

    class o implements com.bytedance.feedbackerlib.m.g.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ u f4567a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f4568b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f4569c;

        o(a r1, u r2, int r3) {
            this.f4569c = r1;
            this.f4567a = r2;
            this.f4568b = r3;
        }

        @Override // com.bytedance.feedbackerlib.m.g.e
        public void a(@Nullable String r2, @NonNull String r3) {
            if (TextUtils.isEmpty(r2) == false) goto L14;
        L6:
            boolean r4 = false;
        L7:
            if (r4 == false) goto L11;
            a r5 = this.f4569c;
            Boolean r6 = Boolean.TRUE;
            r5.d0(r6);
            u r1 = this.f4567a;
            if (r1 == null) goto L16;
            r1.a(r6);
            return;
        L16:
            return;
        L11:
            a.a(this.f4569c, this.f4568b + 1, this.f4567a);
            return;
        L14:
            r4 = TextUtils.equals("pong", new JSONObject(r2).optString("message", ""));     // Catch: Throwable -> L13
            goto L7
        }
    }

    class p implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f4570f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ v f4571g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ a f4572h;

        /* JADX INFO: renamed from: com.bytedance.feedbackerlib.model.a$p$a, reason: collision with other inner class name */
        class RunnableC0141a implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ p f4573f;

            RunnableC0141a(p r1) {
                this.f4573f = r1;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f4573f.f4571g.a(1, "无法得到response");
            }
        }

        class b implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ p f4574f;

            b(p r1) {
                this.f4574f = r1;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f4574f.f4571g.a(1, "response body为空");
            }
        }

        class c implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ p f4575f;

            c(p r1) {
                this.f4575f = r1;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f4575f.f4571g.a(1, "反馈类型为空");
            }
        }

        class d implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ p f4576f;

            d(p r1) {
                this.f4576f = r1;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f4576f.f4571g.a(1, "无法获取到反馈类型");
            }
        }

        class e implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ p f4577f;

            e(p r1) {
                this.f4577f = r1;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f4577f.f4571g.a(0, "");
            }
        }

        class f implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ p f4578f;

            f(p r1) {
                this.f4578f = r1;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f4578f.f4571g.a(1, "请求异常");
            }
        }

        p(a r1, String r2, v r3) {
            this.f4572h = r1;
            this.f4570f = r2;
            this.f4571g = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            a0 r0 = com.bytedance.feedbackerlib.m.g.h();
            f0 r2 = null;
            String r3 = com.bytedance.feedbackerlib.m.g.f.f4290b + "v1/feedbacks/root-type?app_id=" + Feedbacker.getAid() + "&pkg_md5=" + a.I().F() + "&update_version_code=" + Feedbacker.getUpdateVersionCode() + "&task_id=-1";     // Catch: Throwable -> L52
            String r4 = Feedbacker.getLarkSSOEmail();     // Catch: Throwable -> L52
            d0.a r5 = new d0.a();     // Catch: Throwable -> L52
            r5.k(r3);     // Catch: Throwable -> L52
            if (r4 != null) goto L6;
            r4 = EnvironmentCompat.MEDIA_UNKNOWN;
        L6:
            r5.a("Email-Token", r4);     // Catch: Throwable -> L52
            r5.a("locale", a.b(this.f4572h));     // Catch: Throwable -> L52
            r5.c();     // Catch: Throwable -> L52
            d0 r6 = r5.b();     // Catch: Throwable -> L52
            com.bytedance.feedbackerlib.m.c.b("FeedbackModel upload", "requestFeedbackTypes: request: " + r6.k() + "headers: " + r6.d());     // Catch: Throwable -> L52
            int r7 = 0;
            com.bytedance.feedbackerlib.m.r.i(this.f4570f, "requestFeedbackTypes: request: " + r6.k() + "headers: " + r6.d(), new String[0]);     // Catch: Throwable -> L52
            r2 = r0.w(r6).execute();     // Catch: Throwable -> L52
            StringBuilder r8 = new StringBuilder();     // Catch: Throwable -> L52
            r8.append("requestFeedbackTypes: response: ");     // Catch: Throwable -> L52
            r8.append(r2);     // Catch: Throwable -> L52
            com.bytedance.feedbackerlib.m.c.b("FeedbackModel upload", r8.toString());     // Catch: Throwable -> L52
            com.bytedance.feedbackerlib.m.r.i(this.f4570f, "requestFeedbackTypes: response: " + r2, new String[0]);     // Catch: Throwable -> L52
            if (r2 != null) goto L11;
            com.bytedance.feedbackerlib.m.t.a(new RunnableC0141a(this));     // Catch: Throwable -> L52
            com.bytedance.feedbackerlib.m.s.a(r2);
            return;
        L11:
            g0 r1 = r2.a();     // Catch: Throwable -> L52
            com.bytedance.feedbackerlib.m.c.b("FeedbackModel upload", "requestFeedbackTypes: response.body: " + r1);     // Catch: Throwable -> L52
            com.bytedance.feedbackerlib.m.r.i(this.f4570f, "requestFeedbackTypes: response.body: " + r1, new String[0]);     // Catch: Throwable -> L52
            if (r1 != null) goto L16;
            com.bytedance.feedbackerlib.m.t.a(new b(this));     // Catch: Throwable -> L52
            com.bytedance.feedbackerlib.m.s.a(r2);
            return;
        L16:
            JSONObject r9 = new JSONObject(r1.C());     // Catch: Throwable -> L52
            JSONArray r10 = r9.optJSONArray("data");     // Catch: Throwable -> L52
            com.bytedance.feedbackerlib.m.c.b("FeedbackModel upload", "requestFeedbackTypes: jsonObj: " + r9);     // Catch: Throwable -> L52
            com.bytedance.feedbackerlib.m.r.i(this.f4570f, "requestFeedbackTypes: jsonObj: " + r9, new String[0]);     // Catch: Throwable -> L52
            if (r10 != null) goto L21;
            com.bytedance.feedbackerlib.m.t.a(new c(this));     // Catch: Throwable -> L52
            com.bytedance.feedbackerlib.m.s.a(r2);
            return;
        L21:
            a r11 = this.f4572h;     // Catch: Throwable -> L52
            monitor-enter(r11);     // Catch: Throwable -> L52
            a.l(this.f4572h, new ArrayList());     // Catch: Throwable -> L49
        L25:
            if (r7 >= r10.length()) goto L41;
            JSONObject r12 = r10.getJSONObject(r7);     // Catch: Throwable -> L49
            int r13 = r12.optInt("type_id", -1);     // Catch: Throwable -> L49
            String r14 = r12.optString("type_name", "empty");     // Catch: Throwable -> L49
            if (r13 != 1) goto L29;
            List r15 = a.k(this.f4572h);     // Catch: Throwable -> L49
            com.bytedance.feedbackerlib.model.e.c r16 = new com.bytedance.feedbackerlib.model.e.c(0, r14, 0, null, null);     // Catch: Throwable -> L49
        L36:
            r15.add(r16);     // Catch: Throwable -> L49
        L40:
            r7 = r7 + 1;     // Catch: Throwable -> L49
            goto L25
        L29:
            if (r13 != 2) goto L31;
            r15 = a.k(this.f4572h);     // Catch: Throwable -> L49
            r16 = new com.bytedance.feedbackerlib.model.e.c(1, r14, 0, null, null);     // Catch: Throwable -> L49
            goto L36
        L31:
            if (r13 != 3) goto L33;
            r15 = a.k(this.f4572h);     // Catch: Throwable -> L49
            r16 = new com.bytedance.feedbackerlib.model.e.c(2, r14, 0, null, null);     // Catch: Throwable -> L49
            goto L36
        L33:
            if (r13 != 8) goto L40;
            r15 = a.k(this.f4572h);     // Catch: Throwable -> L49
            r16 = new com.bytedance.feedbackerlib.model.e.c(7, r14, 0, null, null);     // Catch: Throwable -> L49
            goto L36
        L41:
            monitor-exit(r11);     // Catch: Throwable -> L49
        L43:
            if (a.k(this.f4572h).size() >= 1) goto L47;
            com.bytedance.feedbackerlib.m.t.a(new d(this));     // Catch: Throwable -> L52
            com.bytedance.feedbackerlib.m.s.a(r2);
            return;
        L47:
            com.bytedance.feedbackerlib.m.t.a(new e(this));     // Catch: Throwable -> L52
        L54:
            com.bytedance.feedbackerlib.m.s.a(r2);
            return;
        L49:
            th = move-exception;
            throw th;     // Catch: Throwable -> L52
        L52:
            th = move-exception;
            th.printStackTrace();     // Catch: Throwable -> L56
            com.bytedance.feedbackerlib.m.t.a(new f(this));     // Catch: Throwable -> L56
        L56:
            th = move-exception;
            com.bytedance.feedbackerlib.m.s.a(r2);
            throw th;
        }
    }

    class q implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f4579f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ v f4580g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ a f4581h;

        /* JADX INFO: renamed from: com.bytedance.feedbackerlib.model.a$q$a, reason: collision with other inner class name */
        class RunnableC0142a implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ q f4582f;

            RunnableC0142a(q r1) {
                this.f4582f = r1;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f4582f.f4580g.a(1, "无法得到response");
            }
        }

        class b implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ q f4583f;

            b(q r1) {
                this.f4583f = r1;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f4583f.f4580g.a(1, "response body为空");
            }
        }

        class c implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ q f4584f;

            c(q r1) {
                this.f4584f = r1;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f4584f.f4580g.a(1, "tags为空");
            }
        }

        class d extends com.google.gson.z.a<ArrayList<com.bytedance.feedbackerlib.model.d.a>> {
            d(q r1) {
            }
        }

        class e implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ q f4585f;

            e(q r1) {
                this.f4585f = r1;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f4585f.f4580g.a(1, "无法获取到tag");
            }
        }

        class f implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ q f4586f;

            f(q r1) {
                this.f4586f = r1;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f4586f.f4580g.a(0, "");
            }
        }

        class g implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ q f4587f;

            g(q r1) {
                this.f4587f = r1;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f4587f.f4580g.a(1, "请求异常");
            }
        }

        q(a r1, String r2, v r3) {
            this.f4581h = r1;
            this.f4579f = r2;
            this.f4580g = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            a0 r0 = com.bytedance.feedbackerlib.m.g.h();
            f0 r1 = null;
            String r2 = com.bytedance.feedbackerlib.m.g.f.f4290b + "v1/labels/" + Feedbacker.getAid();     // Catch: Throwable -> L51
            String r3 = Feedbacker.getLarkSSOEmail();     // Catch: Throwable -> L51
            d0.a r4 = new d0.a();     // Catch: Throwable -> L51
            r4.k(r2);     // Catch: Throwable -> L51
            if (r3 != null) goto L6;
            r3 = EnvironmentCompat.MEDIA_UNKNOWN;
        L6:
            r4.a("Email-Token", r3);     // Catch: Throwable -> L51
            r4.a("locale", a.b(this.f4581h));     // Catch: Throwable -> L51
            r4.c();     // Catch: Throwable -> L51
            d0 r5 = r4.b();     // Catch: Throwable -> L51
            com.bytedance.feedbackerlib.m.c.b("FeedbackModel upload", "requestProductTags: request: " + r5.k() + "headers: " + r5.d());     // Catch: Throwable -> L51
            com.bytedance.feedbackerlib.m.r.i(this.f4579f, "requestProductTags: request: " + r5.k() + "headers: " + r5.d(), new String[0]);     // Catch: Throwable -> L51
            f0 r6 = r0.w(r5).execute();     // Catch: Throwable -> L51
            com.bytedance.feedbackerlib.m.c.b("FeedbackModel upload", "requestProductTags: response: " + r6);     // Catch: Throwable -> L49
            com.bytedance.feedbackerlib.m.r.i(this.f4579f, "requestProductTags: response: " + r6, new String[0]);     // Catch: Throwable -> L49
            if (r6 != null) goto L12;
            com.bytedance.feedbackerlib.m.t.a(new RunnableC0142a(this));     // Catch: Throwable -> L49
            com.bytedance.feedbackerlib.m.s.a(r6);
            return;
        L12:
            g0 r7 = r6.a();     // Catch: Throwable -> L49
            com.bytedance.feedbackerlib.m.c.b("FeedbackModel upload", "requestProductTags: response.body: " + r7);     // Catch: Throwable -> L49
            com.bytedance.feedbackerlib.m.r.i(this.f4579f, "requestProductTags: response.body: " + r7, new String[0]);     // Catch: Throwable -> L49
            if (r7 != null) goto L17;
            com.bytedance.feedbackerlib.m.t.a(new b(this));     // Catch: Throwable -> L49
            com.bytedance.feedbackerlib.m.s.a(r6);
            return;
        L17:
            JSONObject r8 = new JSONObject(r7.C());     // Catch: Throwable -> L49
            JSONArray r9 = r8.optJSONArray("data");     // Catch: Throwable -> L49
            com.bytedance.feedbackerlib.m.c.b("FeedbackModel upload", "requestProductTags: jsonObj: " + r8);     // Catch: Throwable -> L49
            com.bytedance.feedbackerlib.m.r.i(this.f4579f, "requestProductTags: jsonObj: " + r8, new String[0]);     // Catch: Throwable -> L49
            if (r9 != null) goto L22;
            com.bytedance.feedbackerlib.m.t.a(new c(this));     // Catch: Throwable -> L49
            com.bytedance.feedbackerlib.m.s.a(r6);
            return;
        L22:
            List r10 = (List) a.m(this.f4581h).n(r9.toString(), new d(this).getType());     // Catch: Throwable -> L49
            com.bytedance.feedbackerlib.m.c.b("FeedbackModel upload", "productTagExpressions = " + r10);     // Catch: Throwable -> L49
            com.bytedance.feedbackerlib.m.r.i(this.f4579f, "productTagExpressions = " + r10, new String[0]);     // Catch: Throwable -> L49
            if (r10 != null) goto L27;
            com.bytedance.feedbackerlib.m.t.a(new e(this));     // Catch: Throwable -> L49
            com.bytedance.feedbackerlib.m.s.a(r6);
            return;
        L27:
            a r11 = this.f4581h;     // Catch: Throwable -> L49
            monitor-enter(r11);     // Catch: Throwable -> L49
            a.o(this.f4581h, new ArrayList());     // Catch: Throwable -> L46
            a.q(this.f4581h, new ArrayList());     // Catch: Throwable -> L46
            a.s(this.f4581h, new ArrayList());     // Catch: Throwable -> L46
            Iterator r12 = r10.iterator();     // Catch: Throwable -> L46
        L31:
            if (r12.hasNext() == false) goto L43;
            com.bytedance.feedbackerlib.model.d.a r13 = (com.bytedance.feedbackerlib.model.d.a) r12.next();     // Catch: Throwable -> L46
            com.bytedance.feedbackerlib.model.e.c r14 = com.bytedance.feedbackerlib.model.e.c.a(null, r13);     // Catch: Throwable -> L46
            int r15 = r13.f4610d;     // Catch: Throwable -> L46
            if (r15 == 1) goto L42;
            if (r15 == 2) goto L41;
            if (r15 != 8) goto L31;
            List r16 = a.r(this.f4581h);     // Catch: Throwable -> L46
        L40:
            r16.add(r14);     // Catch: Throwable -> L46
            goto L31
        L41:
            r16 = a.p(this.f4581h);     // Catch: Throwable -> L46
            goto L40
        L42:
            r16 = a.n(this.f4581h);     // Catch: Throwable -> L46
            goto L40
        L43:
            monitor-exit(r11);     // Catch: Throwable -> L46
            com.bytedance.feedbackerlib.m.t.a(new f(this));     // Catch: Throwable -> L49
            com.bytedance.feedbackerlib.m.s.a(r6);
            return;
        L46:
            th = move-exception;
            throw th;     // Catch: Throwable -> L49
        L49:
            th = move-exception;
            r1 = r6;
            th = th;
        L61:
            th.printStackTrace();     // Catch: Throwable -> L55
            com.bytedance.feedbackerlib.m.t.a(new g(this));     // Catch: Throwable -> L55
            com.bytedance.feedbackerlib.m.s.a(r1);
            return;
        L55:
            th = move-exception;
            com.bytedance.feedbackerlib.m.s.a(r1);
            throw th;
        L51:
            th = th;
            goto L61
        }
    }

    class r implements com.bytedance.feedbackerlib.m.g.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ v f4588a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f4589b;

        r(a r1, v r2) {
            this.f4589b = r1;
            this.f4588a = r2;
        }

        @Override // com.bytedance.feedbackerlib.m.g.e
        public void a(@Nullable String r6, @NonNull String r7) {
            if (TextUtils.isEmpty(r7) == true) goto L5;
        L19:
            com.bytedance.feedbackerlib.m.c.a("FeedbackModel", "request user profile failed!", new RuntimeException(r7));
            this.f4588a.a(1, r7);
            return;
        L5:
            if (TextUtils.isEmpty(r6) == true) goto L19;
            com.bytedance.feedbackerlib.m.c.b("FeedbackModel", "requestUserProfileFromServer finish: " + r6);
            JSONObject r8 = new JSONObject(r6);     // Catch: Throwable -> L17
            if (r8.optLong("code") != 19004) goto L12;
            FeedbackerContentProvider.a(Feedbacker.getApplicationContext());     // Catch: Throwable -> L17
            this.f4588a.a(1, "19004，token已经过期");     // Catch: Throwable -> L17
            return;
        L12:
            String r9 = r8.optJSONObject("data").optString("user_info");     // Catch: Throwable -> L17
            if (TextUtils.isEmpty(r9) == false) goto L15;
            com.bytedance.feedbackerlib.model.e.a.d(15013);     // Catch: Throwable -> L17
            this.f4588a.a(1, "userInfo is empty: " + r9);     // Catch: Throwable -> L17
            return;
        L15:
            a.t(this.f4589b, (com.bytedance.feedbackerlib.model.e.e) new Gson().m(r9, com.bytedance.feedbackerlib.model.e.e.class));     // Catch: Throwable -> L17
            this.f4588a.a(0, null);     // Catch: Throwable -> L17
            return;
        L17:
            this.f4588a.a(1, "response error: " + r6);
        }
    }

    class s implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ v f4590f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ a f4591g;

        s(a r1, v r2) {
            this.f4591g = r1;
            this.f4590f = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f4591g.c0(this.f4590f);
        }
    }

    public interface t {
        void a(String r1);
    }

    public interface u {
        void a(@NonNull Boolean r1);
    }

    public interface v {
        void a(int r1, String r2);
    }

    public interface w {
        void a(int r1, @Nullable String r2, List<String> r3, List<String> r4);
    }

    static {
        m = new k(Looper.getMainLooper());
    }

    private a() {
        this.f4481a = new Gson();
        new ArrayList();
        this.f4488h = 3;
        this.f4489i = null;
        this.f4490j = new HashMap();
        this.f4491k = null;
        this.f4492l = null;
        this.f4482b = TimeZone.getDefault().getID();
        this.f4483c = J();
    }

    private List<com.bytedance.feedbackerlib.model.e.c> A() {
        Feedbacker.getApplicationContext().getResources();
        ArrayList r0 = new ArrayList();
        com.bytedance.feedbackerlib.j.e r1 = com.bytedance.feedbackerlib.j.e.e();
        r0.add(new com.bytedance.feedbackerlib.model.e.c(2, "P0 " + r1.g("p0"), 0, null, null));
        r0.add(new com.bytedance.feedbackerlib.model.e.c(3, "P1 " + r1.g("p1"), 0, null, null));
        r0.add(new com.bytedance.feedbackerlib.model.e.c(4, "P2 " + r1.g("p2"), 0, null, null));
        r0.add(new com.bytedance.feedbackerlib.model.e.c(5, "P3 " + r1.g("p3"), 0, null, null));
        r0.add(new com.bytedance.feedbackerlib.model.e.c(6, "P4 " + r1.g("p4"), 0, null, null));
        return r0;
    }

    private List<com.bytedance.feedbackerlib.model.e.c> B() {
        Resources r0 = Feedbacker.getApplicationContext().getResources();
        ArrayList r1 = new ArrayList();
        r1.add(new com.bytedance.feedbackerlib.model.e.c(1, r0.getString(com.bytedance.feedbackerlib.g.f4043h), 0, null, null));
        r1.add(new com.bytedance.feedbackerlib.model.e.c(2, r0.getString(com.bytedance.feedbackerlib.g.f4044i), 0, null, null));
        r1.add(new com.bytedance.feedbackerlib.model.e.c(3, r0.getString(com.bytedance.feedbackerlib.g.f4045j), 0, null, null));
        return r1;
    }

    @Nullable
    private String E(@NonNull Context r1) {
        return String.valueOf(r1.getPackageManager().getApplicationLabel(r1.getApplicationInfo()));
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public static a I() {
        if (n != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (n != null) goto L9;
        n = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return n;
    }

    private String J() {
        String r2 = Locale.getDefault().getLanguage();
        if (r2 != null) goto L6;
        return "zh-CN";
    L6:
        if ("zh".equals(r2) == true) goto L8;
        return r2;
    L8:
        return "zh-CN";
    }

    private void X(int r2, @Nullable u r3) {
        if (r2 < 3) goto L8;
        Boolean r4 = Boolean.FALSE;
        d0(r4);
        if (r3 == null) goto L10;
        r3.a(r4);
        return;
    L10:
        return;
    L8:
        com.bytedance.feedbackerlib.m.g.a(new o(this, r3, r2));
    }

    private void Z(String r3, @NonNull v r4) {
        com.bytedance.feedbackerlib.m.c.b("FeedbackModel upload", "requestTOSAuthorization: start");
        com.bytedance.feedbackerlib.m.r.o(r3, "requestTOSAuthorization: start", new String[0]);
        com.bytedance.feedbackerlib.m.t.c(new i(this, r3, r4));
    }

    static /* synthetic */ void a(a r0, int r1, u r2) {
        r0.X(r1, r2);
    }

    static /* synthetic */ String b(a r0) {
        return r0.f4483c;
    }

    static /* synthetic */ String c(a r0) {
        return r0.f4482b;
    }

    static /* synthetic */ int d(a r0, int r1) {
        r0.f4488h = r1;
        return r1;
    }

    static /* synthetic */ void e(a r0) {
        r0.f0();
    }

    static /* synthetic */ Map f(a r0) {
        return r0.f4490j;
    }

    private void f0() {
        com.bytedance.feedbackerlib.m.c.b("FeedbackModel", "uploadAlog executed");
    L7:
        th = move-exception;
        com.bytedance.feedbackerlib.m.c.a("FeedbackModel", th.getMessage(), th);
        return;
    L4:
        if (TextUtils.isEmpty(Feedbacker.getAlogFilesDir()) == true) goto L12;
        com.bytedance.apm.c.b(Feedbacker.getAlogFilesDir(), 0, System.currentTimeMillis() / 1000, "InternalTestFeedbacker", new f(this));     // Catch: Throwable -> L7
        return;
    }

    static /* synthetic */ void g(a r0, String r1, List r2, w r3, String r4) {
        r0.i0(r1, r2, r3, r4);
    }

    private void g0(@NonNull String r8, @NonNull List<Uri> r9, @NonNull w r10, String r11) {
        com.bytedance.feedbackerlib.m.c.b("FeedbackModel upload", "uploadImage: start");
        com.bytedance.feedbackerlib.m.r.o(r11, "uploadImage: start", new String[]{"auth = " + r8 + ", uris.size() = " + r9.size()});
        if (r9.size() > 0) goto L5;
        return;
    L5:
        int r1 = r9.size();
        String[] r3 = new String[r1];
        int r4 = 0;
    L6:
        if (r4 >= r1) goto L16;
        r3[r4] = com.bytedance.feedbackerlib.m.j.b(r9.get(r4));
        r4 = r4 + 1;
        goto L6
    L16:
        TTImageUploader r5 = new TTImageUploader();     // Catch: Throwable -> L10
        r5.setFilePath(r1, r3);     // Catch: Throwable -> L10
        r5.setUserKey("349dfbdae56043a584a0247932038e13");     // Catch: Throwable -> L10
        r5.setAuthorization(r8);     // Catch: Throwable -> L10
        r5.setImageUploadDomain("vas-lf-x.snssdk.com");     // Catch: Throwable -> L10
        r5.setListener(new j(this, r10, r11));     // Catch: Throwable -> L10
        r5.setMediaDataReader(new com.bytedance.feedbackerlib.model.c(r9, Feedbacker.getApplicationContext()), r9.size());     // Catch: Throwable -> L10
        r5.start();     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        r10.a(1, th.getMessage(), null, null);
        if (Feedbacker.getMediasUploadFailedListener() == null) goto L14;
        Feedbacker.getMediasUploadFailedListener().f();
    L14:
        com.bytedance.feedbackerlib.model.e.a.e(35001);
        com.bytedance.feedbackerlib.m.c.b("FeedbackModel upload", "upload image failed: " + th.toString());
        com.bytedance.feedbackerlib.m.r.o(r11, "upload image failed: " + th.toString(), new String[0]);
    }

    static /* synthetic */ void h(a r0, String r1, Uri r2, w r3, List r4, String r5) {
        r0.j0(r1, r2, r3, r4, r5);
    }

    static /* synthetic */ String i(a r0) {
        return r0.f4489i;
    }

    private void i0(@NonNull String r9, List<Uri> r10, w r11, String r12) {
        com.bytedance.feedbackerlib.m.c.b("FeedbackModel upload", "uploadMediasToServerWithAuth: start, auth: " + r9 + ", mediaUris: " + r10);
        com.bytedance.feedbackerlib.m.r.o(r12, "uploadMediasToServerWithAuth: start, auth: " + r9 + ", mediaUris: " + r10, new String[0]);
        if (r11 == null) goto L27;
        if (r10 != null) goto L6;
        return;
    L6:
        if (r10.size() <= 0) goto L31;
        ArrayList r0 = new ArrayList();
        Uri r1 = null;
        Iterator<Uri> r13 = r10.iterator();
    L10:
        if (r13.hasNext() == false) goto L16;
        Uri r2 = r13.next();
        if (com.bytedance.feedbackerlib.m.j.h(r2) == true) goto L13;
        r1 = r2;
        goto L10
    L13:
        r0.add(r2);
        goto L10
    L16:
        if (r0.size() <= 0) goto L18;
        g0(r9, r0, new h(this, r11, r1, r9, r12), r12);
        return;
    L18:
        if (r1 == null) goto L30;
        j0(r9, r1, r11, null, r12);
        return;
    L30:
        return;
    L31:
        return;
    }

    static /* synthetic */ String j(a r0, String r1) {
        r0.f4489i = r1;
        return r1;
    }

    private void j0(@NonNull String r6, @NonNull Uri r7, @NonNull w r8, @Nullable List<String> r9, String r10) {
        com.bytedance.feedbackerlib.m.c.b("FeedbackModel upload", "uploadVideo: start");
        com.bytedance.feedbackerlib.m.r.o(r10, "uploadVideo: start", new String[0]);
        String r1 = com.bytedance.feedbackerlib.m.j.b(r7);
        TTVideoUploader r4 = new TTVideoUploader();     // Catch: Throwable -> L5
        r4.setPathName(r1);     // Catch: Throwable -> L5
        r4.setUserKey("349dfbdae56043a584a0247932038e13");     // Catch: Throwable -> L5
        r4.setAuthorization(r6);     // Catch: Throwable -> L5
        r4.setVideoUploadDomain("vas-lf-x.snssdk.com");     // Catch: Throwable -> L5
        r4.setListener(new l(this, r8, r10, r9));     // Catch: Throwable -> L5
        r4.setMediaDataReader(new com.bytedance.feedbackerlib.model.c(Arrays.asList(new Uri[]{r7}), Feedbacker.getApplicationContext()));     // Catch: Throwable -> L5
        r4.start();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        r8.a(1, th.getMessage(), null, null);
        if (Feedbacker.getMediasUploadFailedListener() == null) goto L9;
        Feedbacker.getMediasUploadFailedListener().f();
    L9:
        com.bytedance.feedbackerlib.model.e.a.e(35002);
        com.bytedance.feedbackerlib.m.c.b("FeedbackModel upload", "upload video failed: " + th.toString());
        com.bytedance.feedbackerlib.m.r.o(r10, "upload video failed: " + th.toString(), new String[0]);
        com.bytedance.feedbackerlib.m.c.a("FeedbackModel", "upload video failed: ", th);
    }

    static /* synthetic */ List k(a r0) {
        return r0.f4484d;
    }

    static /* synthetic */ List l(a r0, List r1) {
        r0.f4484d = r1;
        return r1;
    }

    static /* synthetic */ Gson m(a r0) {
        return r0.f4481a;
    }

    static /* synthetic */ List n(a r0) {
        return r0.f4485e;
    }

    static /* synthetic */ List o(a r0, List r1) {
        r0.f4485e = r1;
        return r1;
    }

    static /* synthetic */ List p(a r0) {
        return r0.f4486f;
    }

    static /* synthetic */ List q(a r0, List r1) {
        r0.f4486f = r1;
        return r1;
    }

    static /* synthetic */ List r(a r0) {
        return r0.f4487g;
    }

    static /* synthetic */ List s(a r0, List r1) {
        r0.f4487g = r1;
        return r1;
    }

    static /* synthetic */ com.bytedance.feedbackerlib.model.e.e t(a r0, com.bytedance.feedbackerlib.model.e.e r1) {
        r0.f4492l = r1;
        return r1;
    }

    static /* synthetic */ String u(a r0) {
        return r0.f4491k;
    }

    static /* synthetic */ String v(a r0, String r1) {
        r0.f4491k = r1;
        return r1;
    }

    public int C() {
        return this.f4488h;
    }

    public synchronized List<com.bytedance.feedbackerlib.model.e.c> D() {
        monitor-enter(this);
        List<com.bytedance.feedbackerlib.model.e.c> r0 = this.f4486f;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public String F() {
        return this.f4489i;
    }

    public synchronized List<com.bytedance.feedbackerlib.model.e.c> G() {
        monitor-enter(this);
        List<com.bytedance.feedbackerlib.model.e.c> r0 = this.f4485e;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized List<com.bytedance.feedbackerlib.model.e.c> H() {
        monitor-enter(this);
        List<com.bytedance.feedbackerlib.model.e.c> r0 = this.f4487g;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public List<com.bytedance.feedbackerlib.model.e.c> K() {
        return A();
    }

    public List<com.bytedance.feedbackerlib.model.e.c> L() {
        return B();
    }

    @Nullable
    public com.bytedance.feedbackerlib.model.e.d M(@NonNull String r2) {
        Map<String, com.bytedance.feedbackerlib.model.e.d> r0 = this.f4490j;
        monitor-enter(r0);
        com.bytedance.feedbackerlib.model.e.d r1 = this.f4490j.get(r2);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public List<com.bytedance.feedbackerlib.model.e.c> N() {
        return this.f4484d;
    }

    @Nullable
    public String O() {
        if (TextUtils.isEmpty(this.f4491k) == true) goto L7;
        return this.f4491k;
    L7:
        return com.bytedance.feedbackerlib.m.q.d.s.a(null);
    }

    public com.bytedance.feedbackerlib.model.e.e P() {
        return this.f4492l;
    }

    public boolean Q() {
        int r2 = this.f4488h;
        if (r2 != 1) goto L5;
        return true;
    L5:
        if (r2 == 2) goto L10;
        return false;
    L10:
        return true;
    }

    public boolean R() {
        if (this.f4488h != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean S() {
        com.bytedance.feedbackerlib.model.e.e r0 = this.f4492l;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (TextUtils.isEmpty(r0.f4623b) == true) goto L7;
        return true;
    }

    public void T(String r11, String r12, @Nullable v r13) {
        if (r13 != null) goto L4;
        return;
    L4:
        HashMap r0 = new HashMap();
        r0.put("code", r11);
        HashMap r1 = new HashMap();
        String r2 = Feedbacker.getAid() + "";
        String r3 = Feedbacker.getDid() + "";
        r1.put("x-tt-aid", r2);
        r1.put("x-tt-did", r3);
        if (Feedbacker.getApplicationContext() == null) goto L7;
        r1.put("x-tt-packagename", Feedbacker.getApplicationContext().getPackageName());
    L7:
        com.bytedance.feedbackerlib.m.c.b("FeedbackModel", "requestAccessCredentialsFromServer: code: " + r11 + ", aid: " + r2 + ", did: " + r3);
        com.bytedance.feedbackerlib.m.r.k(r12, "requestAccessCredentialsFromServer ", new String[]{"code: " + r11 + ", aid: " + r2 + ", did: " + r3});
        com.bytedance.feedbackerlib.m.g.c("https://app-alpha.bytedance.com/v1/sdk/sso/token", r1, r0, new b(this, r12, r13));
    }

    public void U(v r6) {
        com.bytedance.feedbackerlib.m.c.b("FeedbackModel upload", "start request feedback types from server...");
        String r2 = "requestFeedbackTypeFromServer->" + System.currentTimeMillis();
        com.bytedance.feedbackerlib.m.r.i(r2, "start request feedback types from server...", new String[0]);
        if (r6 != null) goto L6;
        com.bytedance.feedbackerlib.m.c.b("FeedbackModel upload", "requestFeedbackTypeFromServer: listener == null");
        com.bytedance.feedbackerlib.m.r.i(r2, "requestFeedbackTypeFromServer: listener == null", new String[0]);
        return;
    L6:
        com.bytedance.feedbackerlib.m.t.c(new p(this, r2, r6));
    }

    public void V(@NonNull v r3, @NonNull String r4, String r5) {
        com.bytedance.feedbackerlib.m.c.b("FeedbackModel", "requestFeedbackerActivateInfoFromServer: start");
        com.bytedance.feedbackerlib.m.r.h(r5, "requestFeedbackerActivateInfoFromServer: start", new String[0]);
        com.bytedance.feedbackerlib.m.t.c(new c(this, r3, r4, r5));
    }

    public void W(@NonNull u r2) {
        X(0, r2);
    }

    public void Y(v r6) {
        com.bytedance.feedbackerlib.m.c.b("FeedbackModel upload", "start request product tags from server...");
        String r2 = "requestProductTagsDataFromServer->" + System.currentTimeMillis();
        com.bytedance.feedbackerlib.m.r.i(r2, "start request product tags from server...", new String[0]);
        if (r6 != null) goto L6;
        com.bytedance.feedbackerlib.m.c.b("FeedbackModel upload", "requestProductTagsDataFromServer: listener == null");
        com.bytedance.feedbackerlib.m.r.i(r2, "requestProductTagsDataFromServer: listener == null", new String[0]);
        return;
    L6:
        com.bytedance.feedbackerlib.m.t.c(new q(this, r2, r6));
    }

    public void a0(@NonNull String r3, @NonNull v r4) {
        com.bytedance.feedbackerlib.m.c.b("FeedbackModel", "requestTranslationFromServer: start");
        com.bytedance.feedbackerlib.m.t.c(new e(this, r3, r4));
    }

    public void b0(boolean r10, @Nullable v r11) {
        if (r11 != null) goto L39;
        return;
    L39:
        String r1 = (String) Feedbacker.getDid();     // Catch: Throwable -> L7
    L37:
        String r2 = Feedbacker.getAppId();     // Catch: Throwable -> L10
    L11:
        String r3 = Feedbacker.getUserAccessToken();
        if (TextUtils.isEmpty(r1) == false) goto L14;
    L35:
        r11.a(1, "did or userAccessToken or appId is empty, did: " + r1 + ", appId: " + r2 + ", userAccessToken: " + r3);
        return;
    L14:
        if (TextUtils.isEmpty(r3) == true) goto L35;
        if (TextUtils.isEmpty(r2) == true) goto L35;
        String r4 = com.bytedance.feedbackerlib.m.a.a("alphatestawesome", r3);
        if (TextUtils.isEmpty(r4) == false) goto L22;
        r11.a(1, "encrypt userAccessToken failed! " + r4);
        return;
    L22:
        String r5 = r1 + ":" + r4;
        HashMap r6 = new HashMap();
        r6.put("Authorization", "Basic " + Base64.encodeToString(r5.getBytes(), 0).replace("\n", ""));
        r6.put("x-tt-app_id", r2);
        r6.put("x-tt-did", Feedbacker.getDid() + "");
        r6.put("x-tt-aid", Feedbacker.getAid() + "");
        String r7 = LocationInfoConst.ALLOW_USE_LOCATION;
        r6.put("x-tt-platform", LocationInfoConst.ALLOW_USE_LOCATION);
        r6.put("x-tt-app-version", Feedbacker.getVersionCode() + "");
        r6.put("x-tt-device-type", Build.MODEL);
        r6.put("x-tt-channel", Feedbacker.getChannel());
        r6.put("x-tt-update-version-code", Feedbacker.getUpdateVersionCode());
        r6.put("x-tt-appkey", "");
        String r8 = E(Feedbacker.getApplicationContext());
        if (TextUtils.isEmpty(r2) == false) goto L25;
        String r9 = "empty";
    L26:
        r6.put("x-tt-app-name", r9.replace("\n", ""));
        if (r10 == true) goto L30;
        r7 = "2";
    L30:
        r6.put("x-tt-network-type", r7);
        if (Feedbacker.getApplicationContext() == null) goto L33;
        r6.put("x-tt-packagename", Feedbacker.getApplicationContext().getPackageName());
    L33:
        com.bytedance.feedbackerlib.m.g.c("https://app-alpha.bytedance.com/v1/sdk/profile", r6, null, new r(this, r11));
        return;
    L25:
        r9 = URLEncoder.encode(r8);
    L10:
        r2 = null;
    L7:
        r1 = null;
        goto L37
    }

    public void c0(@Nullable v r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        String r0 = Feedbacker.getAid() + "";
        String r1 = Feedbacker.getDid() + "";
        if (TextUtils.isEmpty(r0) == false) goto L7;
    L11:
        com.bytedance.feedbackerlib.m.c.b("FeedbackModel", "aid or did is empty, aid: " + r0 + ", did: " + r1 + ", retry after 1 second");
        m.postDelayed(new s(this, r6), 1000);
        return;
    L7:
        if (TextUtils.isEmpty(r1) == true) goto L11;
        HashMap r2 = new HashMap();
        r2.put("x-tt-aid", r0);
        r2.put("x-tt-did", r1);
        r2.put("x-tt-platform", LocationInfoConst.ALLOW_USE_LOCATION);
        Log.d("FeedbackModel", "requestWhiteListInfoFromServer: url: https://app-alpha.bytedance.com/v1/sdk/is-allowed-device, headers: " + r2);
        com.bytedance.feedbackerlib.m.g.d("https://app-alpha.bytedance.com/v1/sdk/is-allowed-device", r2, null, new C0132a(this, r6), com.bytedance.feedbackerlib.m.f.f4261d);
    }

    public synchronized void d0(@Nullable Boolean r4) {
        monitor-enter(this);
        if (r4 != null) goto L11;
    L9:
        monitor-exit(this);
        return;
    L11:
        Handler r5 = m;     // Catch: Throwable -> L6
        r5.removeMessages(0);     // Catch: Throwable -> L6
        r5.sendEmptyMessageDelayed(0, CoroutineLiveDataKt.DEFAULT_TIMEOUT);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    public void e0(String r19, String r20, com.bytedance.feedbackerlib.model.e.c r21, com.bytedance.feedbackerlib.model.e.c r22, com.bytedance.feedbackerlib.model.e.c r23, com.bytedance.feedbackerlib.model.e.c r24, com.bytedance.feedbackerlib.model.e.c r25, String r26, String r27, String r28, String r29, String r30, List<String> r31, List<String> r32, v r33) {
        com.bytedance.feedbackerlib.m.c.b("FeedbackModel", "submitFeedbackToServer: start");
        com.bytedance.feedbackerlib.m.r.o(r19, "submitFeedbackToServer: start", new String[]{"listener = " + r33 + ", typeInfo = " + r21});
        if (r33 == null) goto L12;
        if (r21 != null) goto L7;
        return;
    L7:
        if (Feedbacker.isFeedbackCommonInfoSetted() == true) goto L10;
        com.bytedance.feedbackerlib.m.r.o(r19, "Feedbacker.isFeedbackCommonInfoSetted() is false", new String[0]);
        r33.a(1, "请在提交反馈前调用Feedbacker.setIFeedbackCommon方法传入相应信息。");
        return;
    L10:
        com.bytedance.feedbackerlib.m.t.c(new d(this, r21, r22, r23, r26, r24, r25, r28, r27, r20, r29, r30, r31, r32, r33, r19));
        return;
    }

    public void h0(List<Uri> r3, w r4, String r5) {
        com.bytedance.feedbackerlib.m.c.b("FeedbackModel upload", "uploadMediasToServer() is invoked");
        com.bytedance.feedbackerlib.m.r.o(r5, "uploadMediasToServer() is invoked", new String[0]);
        Z(r5, new g(this, r3, r4, r5));
    }

    public void w(@NonNull Context r3, @NonNull t r4) {
        com.bytedance.feedbackerlib.m.c.b("FeedbackModel", "calculateBaseApkMd5: start");
        com.bytedance.feedbackerlib.m.t.c(new m(this, r3, r4));
    }

    public void x(@NonNull String r14, @NonNull u r15) {
        Boolean r0 = Boolean.FALSE;
        if (TextUtils.isEmpty(r14) == false) goto L10;
        r15.a(r0);
        return;
    L10:
        HashMap r1 = new HashMap();     // Catch: Throwable -> L8
        r1.put("x-jwt-token", r14);     // Catch: Throwable -> L8
        Long r16 = 1500L;     // Catch: Throwable -> L8
        Long r2 = 1500L;     // Catch: Throwable -> L8
        com.bytedance.feedbackerlib.m.g.d("https://app-alpha.bytedance.com/v1/sdk/jwt-valid", r1, null, new n(this, r15), new com.bytedance.feedbackerlib.m.f(r16.longValue(), r2.longValue(), r2.longValue()));     // Catch: Throwable -> L8
        return;
    L8:
        r15.a(r0);
    }

    public void y() {
        this.f4492l = null;
        this.f4491k = null;
    }

    public void z() {
        this.f4492l = null;
    }
}
