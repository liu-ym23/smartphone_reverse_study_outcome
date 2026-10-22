package com.bytedance.news.common.settings;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.Nullable;
import com.bytedance.news.common.settings.g.g;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f5268a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.bytedance.news.common.settings.g.a f5269b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private c f5270c;

    static /* synthetic */ class a {
    }

    /* JADX INFO: renamed from: com.bytedance.news.common.settings.b$b, reason: collision with other inner class name */
    public static class C0170b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Context f5271a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private g f5272b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private com.bytedance.news.common.settings.g.a f5273c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Executor f5274d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f5275e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private long f5276f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private com.bytedance.news.common.settings.g.e f5277g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private com.bytedance.news.common.settings.g.d f5278h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private boolean f5279i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private boolean f5280j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private boolean f5281k;

        public C0170b() {
            this.f5275e = -1;
            this.f5276f = -1;
            this.f5279i = true;
            this.f5280j = true;
        }

        public b a() {
            if (this.f5271a == null) goto L27;
            if (this.f5273c == null) goto L25;
            if (this.f5272b != null) goto L10;
            this.f5272b = new com.bytedance.news.common.settings.i.a();
        L10:
            if (this.f5274d != null) goto L13;
            this.f5274d = Executors.newCachedThreadPool();
        L13:
            if (this.f5275e >= 0) goto L16;
            this.f5275e = 3600000;
        L16:
            if (this.f5276f >= 0) goto L18;
            this.f5276f = 120000;
        L18:
            a r1 = null;
            c r0 = new c(r1);
            r0.f5283b = this.f5272b;
            r0.f5284c = this.f5274d;
            r0.f5285d = this.f5275e;
            r0.f5286e = this.f5276f;
            r0.f5287f = this.f5277g;
            r0.f5288g = this.f5278h;
            r0.f5289h = this.f5279i;
            r0.f5290i = this.f5280j;
            r0.f5291j = this.f5281k;
            Context r2 = this.f5271a;
            if ((r2 instanceof Application) == false) goto L23;
            return new b(r2, this.f5273c, r0, r1);
        L23:
            return new b(r2.getApplicationContext(), this.f5273c, r0, r1);
        L25:
            throw new IllegalArgumentException("requestService不能为空");
        L27:
            throw new IllegalArgumentException("context不能为空");
        }

        public C0170b b(Context r1) {
            this.f5271a = r1;
            return this;
        }

        public C0170b c(boolean r1) {
            this.f5279i = r1;
            return this;
        }

        public C0170b d(com.bytedance.news.common.settings.g.a r1) {
            this.f5273c = r1;
            return this;
        }
    }

    private static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f5282a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public g f5283b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Executor f5284c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f5285d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f5286e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public com.bytedance.news.common.settings.g.e f5287f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public com.bytedance.news.common.settings.g.d f5288g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f5289h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f5290i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f5291j;

        private c() {
            this.f5289h = true;
            this.f5290i = true;
        }

        /* synthetic */ c(a r1) {
            this();
        }
    }

    private b(Context r1, com.bytedance.news.common.settings.g.a r2, c r3) {
        this.f5268a = r1;
        this.f5269b = r2;
        this.f5270c = r3;
    }

    /* synthetic */ b(Context r1, com.bytedance.news.common.settings.g.a r2, c r3, a r4) {
        this(r1, r2, r3);
    }

    public Context a() {
        return this.f5268a;
    }

    public Executor b() {
        return this.f5270c.f5284c;
    }

    public String c() {
        return this.f5270c.f5282a;
    }

    public com.bytedance.news.common.settings.g.a d() {
        return this.f5269b;
    }

    public long e() {
        return this.f5270c.f5286e;
    }

    @Nullable
    public com.bytedance.news.common.settings.g.d f() {
        return this.f5270c.f5288g;
    }

    @Nullable
    public SharedPreferences g(Context r1, String r2, int r3) {
        com.bytedance.news.common.settings.g.e r0 = this.f5270c.f5287f;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a(r1, r2, r3);
    }

    public g h() {
        return this.f5270c.f5283b;
    }

    public long i() {
        return this.f5270c.f5285d;
    }

    public boolean j() {
        return this.f5270c.f5289h;
    }

    void k(String r1) {
        this.f5270c.f5282a = r1;
    }

    public boolean l() {
        return this.f5270c.f5291j;
    }

    public boolean m() {
        return this.f5270c.f5290i;
    }
}
