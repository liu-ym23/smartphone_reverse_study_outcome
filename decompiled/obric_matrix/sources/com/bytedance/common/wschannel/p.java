package com.bytedance.common.wschannel;

import android.app.Application;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Application f3640a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private com.bytedance.common.wschannel.app.d f3641b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f3642c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f3643d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f3644e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.common.wschannel.app.b f3645f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private b<Boolean> f3646g;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Application f3647a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private com.bytedance.common.wschannel.app.d f3648b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f3649c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f3650d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f3651e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private com.bytedance.common.wschannel.app.b f3652f;

        public a() {
            this.f3649c = false;
            this.f3650d = true;
            this.f3651e = false;
        }

        public a a(Application r1) {
            this.f3647a = r1;
            return this;
        }

        public a b(com.bytedance.common.wschannel.app.b r1) {
            this.f3652f = r1;
            return this;
        }

        public p c() {
            return new p(this.f3647a, this.f3648b, this.f3649c, this.f3650d, this.f3651e, this.f3652f);
        }

        public a d(boolean r1) {
            this.f3650d = r1;
            return this;
        }

        public a e(boolean r1) {
            this.f3649c = r1;
            return this;
        }

        public a f(boolean r1) {
            this.f3651e = r1;
            return this;
        }

        public a g(com.bytedance.common.wschannel.app.d r1) {
            this.f3648b = r1;
            return this;
        }
    }

    public p(Application r1, @Nullable com.bytedance.common.wschannel.app.d r2, boolean r3, boolean r4, boolean r5, com.bytedance.common.wschannel.app.b r6) {
        this.f3640a = r1;
        this.f3641b = r2;
        this.f3642c = r3;
        this.f3643d = r4;
        this.f3644e = r5;
        this.f3645f = r6;
    }

    public Application a() {
        return this.f3640a;
    }

    @Nullable
    public com.bytedance.common.wschannel.app.d b() {
        return this.f3641b;
    }

    public b<Boolean> c() {
        return this.f3646g;
    }

    public boolean d() {
        return this.f3643d;
    }

    public boolean e() {
        return this.f3642c;
    }

    public boolean f() {
        return this.f3644e;
    }
}
