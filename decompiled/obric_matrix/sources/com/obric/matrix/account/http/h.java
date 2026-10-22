package com.obric.matrix.account.http;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB/\b\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/obric/matrix/account/http/HttpEnv;", "", "boeEnable", "", "boeEnv", "", "ppeEnable", "ppeEnv", "(ZLjava/lang/String;ZLjava/lang/String;)V", "getBoeEnable", "()Z", "getBoeEnv", "()Ljava/lang/String;", "getPpeEnable", "getPpeEnv", "Companion", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class h {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f8500e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f8501a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f8502b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f8503c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f8504d;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/matrix/account/http/HttpEnv$Companion;", "", "()V", "init", "Lcom/obric/matrix/account/http/HttpEnv;", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.n0.d.g r1) {
            this();
        }

        public final h a() {
            com.obric.matrix.base.env.d r6 = com.obric.matrix.base.env.d.f8838a;
            boolean r1 = r6.e();
            String r2 = r6.b();
            boolean r3 = r6.f();
            String r4 = r6.d();
            com.obric.matrix.r.c.c.j("HttpEnv", "init " + r1 + ' ' + r2 + ' ' + r3 + ' ' + r4);
            return new h(r1, r2, r3, r4, null);
        }
    }

    static {
        f8500e = new a(null);
    }

    private h(boolean r1, String r2, boolean r3, String r4) {
        this.f8501a = r1;
        this.f8502b = r2;
        this.f8503c = r3;
        this.f8504d = r4;
    }

    public /* synthetic */ h(boolean r1, String r2, boolean r3, String r4, kotlin.n0.d.g r5) {
        this(r1, r2, r3, r4);
    }

    public final boolean a() {
        return this.f8501a;
    }

    public final String b() {
        return this.f8502b;
    }

    public final boolean c() {
        return this.f8503c;
    }

    public final String d() {
        return this.f8504d;
    }
}
