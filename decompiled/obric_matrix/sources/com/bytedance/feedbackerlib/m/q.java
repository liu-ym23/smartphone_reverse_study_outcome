package com.bytedance.feedbackerlib.m;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.feedbackerlib.Feedbacker;
import com.bytedance.feedbackerlib.matisse.internal.entity.Item;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static SharedPreferences f4295a;

    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f4296g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final a f4297h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final a f4298i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final /* synthetic */ a[] f4299j = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f4300f;

        static {
            a r0 = new a("ORIGIN_ENABLED", 0, "feedbacker_origin_enabled");
            f4296g = r0;
            a r1 = new a("HAS_DENIED_OVERLAY_PERMISSION", 1, "feedbacker_has_denied_overlay_permission");
            f4297h = r1;
            a r3 = new a("HIDE_FLOAT_WINDOW", 2, "feedbacker_hide_float_window");
            f4298i = r3;
            f4299j = new a[]{r0, r1, r3};
        }

        private a(@NonNull String r1, int r2, String r3) {
            super(r1, r2);
            this.f4300f = r3;
            if (TextUtils.isEmpty(r3) == false) goto L6;
            this.f4300f = "feedbacker_boolean_unknown";
            return;
        }

        public static a valueOf(String r1) {
            return (a) Enum.valueOf(a.class, r1);
        }

        public static a[] values() {
            return (a[]) f4299j.clone();
        }

        public boolean a(boolean r2) {
            if (q.d() == true) goto L6;
            return r2;
        L6:
            return q.b().getBoolean(this.f4300f, r2);
        }

        public void b(boolean r2) {
            if (q.d() == true) goto L5;
            return;
        L5:
            q.b().edit().putBoolean(this.f4300f, r2).commit();
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f4301a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f4302b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f4303c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f4304d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f4305e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f4306f;

        public b(Item r3) {
            this.f4301a = r3.f4333f;
            this.f4302b = r3.f4334g;
            this.f4303c = r3.f4336i;
            this.f4304d = r3.f4337j;
            this.f4305e = r3.f4335h.toString();
            this.f4306f = r3.f4338k;
        }

        public Item a() {
            Item r9 = new Item(this.f4301a, this.f4302b, this.f4303c, this.f4304d, this.f4306f);
            r9.f4335h = Uri.parse(this.f4305e);
            return r9;
        }
    }

    public static final enum c extends Enum<c> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final c f4307g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final c f4308h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final c f4309i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final /* synthetic */ c[] f4310j = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f4311f;

        static {
            c r0 = new c("LAST_SSO_TIMESTAMP", 0, "feedbacker_last_sso_timestamp");
            f4307g = r0;
            c r1 = new c("DURATION_PROCESS_ALIVE", 1, "feedbacker_duration_process_alive");
            f4308h = r1;
            c r3 = new c("APP_VERSION", 2, "feedbacker_app_version");
            f4309i = r3;
            f4310j = new c[]{r0, r1, r3};
        }

        private c(@NonNull String r1, int r2, String r3) {
            super(r1, r2);
            this.f4311f = r3;
            if (TextUtils.isEmpty(r3) == false) goto L6;
            this.f4311f = "feedbacker_long_unknown";
            return;
        }

        public static c valueOf(String r1) {
            return (c) Enum.valueOf(c.class, r1);
        }

        public static c[] values() {
            return (c[]) f4310j.clone();
        }

        public long a(long r2) {
            if (q.d() == true) goto L6;
            return r2;
        L6:
            return q.b().getLong(this.f4311f, r2);
        }

        public void b(long r2) {
            if (q.d() == true) goto L5;
            return;
        L5:
            q.b().edit().putLong(this.f4311f, r2).commit();
        }
    }

    public static final enum d extends Enum<d> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final d f4312g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final d f4313h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final d f4314i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final d f4315j = null;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final d f4316k = null;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final d f4317l = null;
        public static final d m = null;
        public static final d n = null;
        public static final d o = null;
        public static final d p = null;
        public static final d q = null;
        public static final d r = null;
        public static final d s = null;
        public static final d t = null;
        private static final /* synthetic */ d[] u = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f4318f;

        class a extends com.google.gson.z.a<List<b>> {
            a(d r1) {
            }
        }

        class b extends com.google.gson.z.a<List<String>> {
            b(d r1) {
            }
        }

        static {
            d r0 = new d("TYPE", 0, "feedbacker_type");
            f4312g = r0;
            d r1 = new d("RECURRENCE", 1, "feedbacker_recurrence");
            f4313h = r1;
            d r3 = new d("CLASSIFICATION", 2, "feedbacker_classification");
            f4314i = r3;
            d r5 = new d("PRIORI", 3, "feedbacker_priori");
            f4315j = r5;
            d r7 = new d("ADVICE", 4, "feedbacker_advice");
            f4316k = r7;
            d r9 = new d("CUSTOM", 5, "feedbacker_custom");
            f4317l = r9;
            d r11 = new d("REMARK", 6, "feedbacker_remark");
            m = r11;
            d r13 = new d("SSO_EMAIL", 7, "feedbacker_sso_email");
            n = r13;
            d r12 = new d("MEDIA_URI_STRING", 8, "feedbacker_media_uri_string");
            o = r12;
            d r10 = new d("QUESTION_CACHE", 9, "feedbacker_question_cache");
            p = r10;
            d r8 = new d("Other_CACHE", 10, "feedbacker_other_cache");
            q = r8;
            d r6 = new d("FEEDBACK_LOCALE", 11, "feedbacker_feedback_locale");
            r = r6;
            d r4 = new d("USER_ACCESS_TOKEN", 12, "feedbacker_user_access_token");
            s = r4;
            d r2 = new d("EMPLOYEE_ID", 13, "feedbacker_employee_id");
            t = r2;
            u = new d[]{r0, r1, r3, r5, r7, r9, r11, r13, r12, r10, r8, r6, r4, r2};
        }

        private d(@NonNull String r1, int r2, String r3) {
            super(r1, r2);
            this.f4318f = r3;
            if (TextUtils.isEmpty(r3) == false) goto L6;
            this.f4318f = "feedbacker_string_unknown";
            return;
        }

        public static d valueOf(String r1) {
            return (d) Enum.valueOf(d.class, r1);
        }

        public static d[] values() {
            return (d[]) u.clone();
        }

        public String a(@Nullable String r2) {
            if (q.d() == true) goto L6;
            return r2;
        L6:
            return q.b().getString(this.f4318f, r2);
        }

        public List<Item> b() {
            String r0 = a("");
            if (TextUtils.isEmpty(r0) == true) goto L5;
            Gson r1 = new Gson();
            List r2 = (List) r1.n(r0, new a(this).getType());     // Catch: Throwable -> L13
            ArrayList r3 = new ArrayList();     // Catch: Throwable -> L13
            Iterator r4 = r2.iterator();     // Catch: Throwable -> L13
        L9:
            if (r4.hasNext() == false) goto L12;
            r3.add(((b) r4.next()).a());     // Catch: Throwable -> L13
            goto L9
        L12:
            return r3;
        L13:
            List r5 = (List) r1.n(r0, new b(this).getType());
            if (r5 == null) goto L24;
            if (Feedbacker.getApplicationContext() == null) goto L24;
            ArrayList r6 = new ArrayList();
            Iterator r7 = r5.iterator();
        L20:
            if (r7.hasNext() == false) goto L22;
            String r8 = (String) r7.next();
            r6.add(new Item(Feedbacker.getApplicationContext(), Uri.parse(r8)));
            goto L20
        L22:
            return r6;
        L24:
            return new ArrayList();
        L5:
            return new ArrayList();
        }

        public void c(String r2) {
            if (q.d() == true) goto L5;
            return;
        L5:
            q.b().edit().putString(this.f4318f, r2).commit();
        }

        public void g(List<Item> r5) {
            if (r5 != null) goto L4;
            return;
        L4:
            Gson r0 = new Gson();
            ArrayList r1 = new ArrayList();
            Iterator<Item> r6 = r5.iterator();
        L6:
            if (r6.hasNext() == false) goto L10;
            r1.add(new b(r6.next()));     // Catch: Throwable -> L12
            goto L6
        L10:
            c(r0.v(r1));
        }
    }

    static {
    }

    @Proxy("getSharedPreferences")
    @TargetClass(scope = Scope.SELF, value = "android.content.Context")
    public static SharedPreferences a(Context r0, String r1, int r2) {
        return com.obric.matrix.r.b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
    }

    static /* synthetic */ SharedPreferences b() {
        return f4295a;
    }

    public static synchronized void c(@NonNull Context r5) {
        monitor-enter(q.class);
        Context r1 = r5.getApplicationContext();     // Catch: Throwable -> L19
        if (f4295a != null) goto L7;
        f4295a = a(r1, "com.bytedance.feedbacker.feedbacker_cache", 0);     // Catch: Throwable -> L19
    L7:
        String r6 = n.a(r5);     // Catch: Throwable -> L19
        if (TextUtils.isEmpty(r6) == false) goto L10;
    L17:
        monitor-exit(q.class);
        return;
    L10:
        if (r6.endsWith(":feedbacker") == false) goto L17;
        c r7 = c.f4307g;     // Catch: Throwable -> L19
        if (r7.a(-1) >= 0) goto L15;
        r7.b(System.currentTimeMillis());     // Catch: Throwable -> L19
    L15:
        monitor-exit(q.class);
        return;
    L19:
        th = move-exception;
        throw th;
    }

    public static synchronized boolean d() {
        monitor-enter(q.class);
        if (f4295a == null) goto L7;
        boolean r1 = true;
    L8:
        monitor-exit(q.class);
        return r1;
    L7:
        r1 = false;
    L10:
        th = move-exception;
        throw th;
    }
}
