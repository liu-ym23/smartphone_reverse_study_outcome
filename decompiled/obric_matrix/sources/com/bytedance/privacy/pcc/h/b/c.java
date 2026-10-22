package com.bytedance.privacy.pcc.h.b;

import android.util.Base64;
import com.bytedance.common.wschannel.WsConstants;
import com.google.gson.Gson;
import com.google.gson.m;
import com.google.gson.o;
import java.nio.charset.StandardCharsets;
import java.util.List;
import os.teatracker.IBdInstall;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f5436a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f5437b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f5438c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f5439d;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @com.google.gson.y.c("evidence_version")
        private String f5440a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @com.google.gson.y.c("evidence_token")
        private String f5441b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @com.google.gson.y.c("evidence_detail")
        private String f5442c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @com.google.gson.y.c("evidence_extra")
        private String f5443d;

        public a() {
        }

        public static a a(String r2) {
            return (a) new Gson().m(r2, a.class);
        }

        public String b() {
            return this.f5441b;
        }

        public String c() {
            return new Gson().v(this);
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @com.google.gson.y.c("service_info")
        private C0174c f5444a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @com.google.gson.y.c("evidence_info")
        private a f5445b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @com.google.gson.y.c("access_token")
        private String f5446c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @com.google.gson.y.c(WsConstants.KEY_CHANNEL_ID)
        private String f5447d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @com.google.gson.y.c("channel_expiry_time")
        private String f5448e;

        b(C0174c r1, a r2, String r3, String r4, String r5) {
            this.f5444a = r1;
            this.f5445b = r2;
            this.f5446c = r3;
            this.f5447d = r4;
            this.f5448e = r5;
        }

        static /* synthetic */ C0174c a(b r0) {
            return r0.f5444a;
        }

        static /* synthetic */ a b(b r0) {
            return r0.f5445b;
        }

        static /* synthetic */ String c(b r0) {
            return r0.f5446c;
        }

        static /* synthetic */ String d(b r0) {
            return r0.f5447d;
        }

        static /* synthetic */ String e(b r0) {
            return r0.f5448e;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.privacy.pcc.h.b.c$c, reason: collision with other inner class name */
    public static class C0174c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @com.google.gson.y.c(IBdInstall.PARAM_APP_ID)
        private String f5449a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @com.google.gson.y.c("app_svc_id")
        private String f5450b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @com.google.gson.y.c("app_svc_pod_list")
        private List<d> f5451c;

        public C0174c() {
        }

        public static C0174c a(String r2) {
            return (C0174c) new Gson().m(r2, C0174c.class);
        }

        public List<d> b() {
            return this.f5451c;
        }

        public String c() {
            return new Gson().v(this);
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @com.google.gson.y.c("svc_pod_id")
        private String f5452a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @com.google.gson.y.c("svc_pod_key_type")
        private String f5453b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @com.google.gson.y.c("svc_pod_key_version")
        private String f5454c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @com.google.gson.y.c("svc_pod_pub_key")
        private String f5455d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @com.google.gson.y.c("svc_pod_index")
        private int f5456e;

        public d() {
        }

        public String a() {
            return this.f5452a;
        }

        public int b() {
            return this.f5456e;
        }

        public String c() {
            return this.f5453b;
        }

        public String d() {
            return this.f5454c;
        }

        public String e() {
            return this.f5455d;
        }
    }

    private c(b r1, String r2, String r3, String r4) {
        this.f5436a = r1;
        this.f5437b = r2;
        this.f5438c = r3;
        this.f5439d = r4;
    }

    public static c a(String r7, String r8, String r9, String r10, String r11, String r12, String r13, String r14) {
        a r0 = null;
        if (r7 != null) goto L5;
    L7:
        C0174c r2 = null;
    L8:
        if (r8 == null) goto L13;
        if (r8.isEmpty() == true) goto L13;
        r0 = a.a(r8);
    L13:
        return new c(new b(r2, r0, r9, r10, r11), r12, r13, r14);
    L5:
        if (r7.isEmpty() == true) goto L7;
        r2 = C0174c.a(r7);
        goto L8
    }

    public static c j(String r4, String r5) {
        m r6 = o.c(r4).c();
        int r0 = r6.v("code").a();
        if (r0 != 0) goto L7;
        m r7 = r6.x("data");
        String r1 = r7.v(WsConstants.KEY_PAYLOAD).l();
        return new c((b) new Gson().m(new String(Base64.decode(r1, 0), StandardCharsets.UTF_8), b.class), r1, r5, r7.v("signature").l());
    L7:
        throw new Exception("unexpected server code=" + r0);
    }

    public String b() {
        b r0 = this.f5436a;
        if (r0 != null) goto L7;
        return "";
    L7:
        return b.c(r0);
    }

    public String c() {
        b r0 = this.f5436a;
        if (r0 != null) goto L7;
        return "";
    L7:
        return b.e(r0);
    }

    public String d() {
        b r0 = this.f5436a;
        if (r0 != null) goto L7;
        return "";
    L7:
        return b.d(r0);
    }

    public a e() {
        b r0 = this.f5436a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return b.b(r0);
    }

    public String f() {
        return this.f5437b;
    }

    public String g() {
        return this.f5438c;
    }

    public C0174c h() {
        b r0 = this.f5436a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return b.a(r0);
    }

    public String i() {
        return this.f5439d;
    }
}
