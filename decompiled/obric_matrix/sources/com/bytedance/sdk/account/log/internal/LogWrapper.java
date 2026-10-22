package com.bytedance.sdk.account.log.internal;

import androidx.annotation.Keep;
import d.b.s.a.a0.b;
import kotlin.Metadata;
import kotlin.n0.d.g;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
public final class LogWrapper implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d.b.s.a.a0.c.a f5641a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f5642b;

    @Keep
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/sdk/account/log/internal/LogWrapper$StacktraceThrowable;", "", "<init>", "()V", "account-sdk-log_release"}, k = 1, mv = {1, 1, 15})
    public static final class StacktraceThrowable extends Throwable {
        public StacktraceThrowable() {
        }
    }

    static {
    }

    public LogWrapper(d.b.s.a.a0.c.a r2, boolean r3) {
        o.g(r2, "logger");
        this.f5641a = r2;
        this.f5642b = r3;
    }

    public /* synthetic */ LogWrapper(d.b.s.a.a0.c.a r1, boolean r2, int r3, g r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = false;
    L5:
        this(r1, r2);
    }

    private final void f(int r2, String r3, String r4, Throwable r5) {
        String r6 = h(r2, r3);
        String r7 = g(r2, r4);
        if (r2 != 2) goto L5;
        this.f5641a.e(r6, r7);
        return;
    L5:
        if (r2 != 3) goto L7;
        this.f5641a.a(r6, r7);
        return;
    L7:
        if (r2 != 4) goto L9;
        this.f5641a.b(r6, r7);
        return;
    L9:
        if (r2 != 5) goto L11;
        this.f5641a.w(r6, r7, r5);
        return;
    L11:
        if (r2 != 6) goto L23;
        this.f5641a.e(r6, r7, r5);
        return;
    }

    private final String g(int r1, String r2) {
        if (this.f5642b == false) goto L7;
        return "(LogCalledBeforeInit) " + r2;
    L7:
        return String.valueOf(r2);
    }

    private final String h(int r2, String r3) {
        if (r2 != 2) goto L5;
        String r1 = "V";
    L19:
        return "BDAccountSDK/" + r1 + '/' + r3;
    L5:
        if (r2 != 3) goto L7;
        r1 = "D";
        goto L19
    L7:
        if (r2 != 4) goto L9;
        r1 = "I";
        goto L19
    L9:
        if (r2 != 5) goto L11;
        r1 = "W";
        goto L19
    L11:
        if (r2 == 6) goto L13;
        r1 = "X";
        goto L19
    L13:
        r1 = "E";
        goto L19
    }

    @Override // d.b.s.a.a0.b
    public void a(String r3, String r4) {
        f(3, r3, r4, null);
    }

    @Override // d.b.s.a.a0.b
    public void b(String r3, String r4) {
        f(4, r3, r4, null);
    }

    @Override // d.b.s.a.a0.b
    public void c(String r3, String r4) {
        f(6, r3, r4, null);
    }

    @Override // d.b.s.a.a0.b
    public void d(String r3, String r4) {
        f(5, r3, r4, null);
    }

    @Override // d.b.s.a.a0.b
    public void e(String r3, String r4) {
        f(2, r3, r4, null);
    }

    @Override // d.b.s.a.a0.b
    public void e(String r2, String r3, Throwable r4) {
        f(6, r2, r3, r4);
    }

    public String toString() {
        return "LogWrapper(isBeforeInit=" + this.f5642b + ')';
    }

    @Override // d.b.s.a.a0.b
    public void w(String r2, String r3, Throwable r4) {
        f(5, r2, r3, r4);
    }
}
