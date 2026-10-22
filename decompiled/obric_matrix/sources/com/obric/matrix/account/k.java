package com.obric.matrix.account;

import android.annotation.SuppressLint;
import kotlin.Metadata;
import kotlin.n0.d.o;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u001a\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/matrix/account/UserInfoCache;", "", "()V", "KEY_USER_NAME_PREFIX", "", "TAG", "getUserName", "userId", "", "keyOfUserName", "update", "", "userInfo", "Lcom/bytedance/sdk/account/user/IBDAccountUserEntity;", "scene", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f8544a = null;

    static {
        f8544a = new k();
    }

    private k() {
    }

    private final String b(long r2) {
        return "o_user_info_cache_key_user_name_" + r2;
    }

    public final synchronized String a(long r7) {
        monitor-enter(this);
        String r8 = com.obric.matrix.q.e.a.k(com.obric.matrix.q.e.a.f9851a, b(r7), null, null, 6, null);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r8;
    L6:
        th = move-exception;
        throw th;
    }

    @SuppressLint({"[ByDesign9.3]LogSensitiveInfo"})
    public final synchronized void c(d.b.s.a.k0.a r7, String r8) {
        monitor-enter(this);
        o.f(r8, "scene");     // Catch: Throwable -> L34
        StringBuilder r1 = new StringBuilder();     // Catch: Throwable -> L34
        r1.append("update, scene: ");     // Catch: Throwable -> L34
        r1.append(r8);     // Catch: Throwable -> L34
        r1.append(", ");     // Catch: Throwable -> L34
        com.ss.android.i.e r9 = null;
        d.b.s.a.k0.a r10 = null;
        if (r7 == null) goto L6;
        JSONObject r2 = r7.j();     // Catch: Throwable -> L34
    L7:
        r1.append(r2);     // Catch: Throwable -> L34
        com.obric.matrix.r.c.e.a("UserInfoCache", r1.toString());     // Catch: Throwable -> L34
        if (r7 == null) goto L13;
        com.obric.matrix.r.e.f r0 = com.obric.matrix.r.e.f.f9940a;     // Catch: Throwable -> L34
        if ((r7 instanceof com.ss.android.i.e) == false) goto L12;
        r10 = r7;
    L12:
        r9 = (com.ss.android.i.e) r10;     // Catch: Throwable -> L34
    L13:
        if (r9 != null) goto L17;
        com.obric.matrix.r.c.c.s("UserInfoCache", "update userEntity is null " + r7);     // Catch: Throwable -> L34
        monitor-exit(this);
        return;
    L17:
        String r3 = r9.t;     // Catch: Throwable -> L34
        long r11 = r9.f14828a;     // Catch: Throwable -> L34
        com.obric.matrix.r.c.e.a("UserInfoCache", "update, userName: " + r3 + ", userId: " + r11);     // Catch: Throwable -> L34
        if (r3 != null) goto L20;
    L23:
        boolean r4 = true;
    L24:
        if (r4 == false) goto L26;
        String r12 = "UserInfoCache";
        String r13 = "update userName is empty, ignore!";
    L29:
        com.obric.matrix.r.c.c.s(r12, r13);     // Catch: Throwable -> L34
    L32:
        monitor-exit(this);
        return;
    L26:
        if (r11 == 0) goto L28;
        com.obric.matrix.q.e.a r5 = com.obric.matrix.q.e.a.f9851a;     // Catch: Throwable -> L34
        String r6 = b(r11);     // Catch: Throwable -> L34
        o.e(r3, "userName");     // Catch: Throwable -> L34
        com.obric.matrix.q.e.a.m(r5, r6, r3, null, 4, null);     // Catch: Throwable -> L34
        goto L32
    L28:
        r12 = "UserInfoCache";
        r13 = "update userId is 0, ignore!";
        goto L29
    L20:
        if (r3.length() == 0) goto L23;
        r4 = false;
        goto L24
    L6:
        r2 = null;
    L34:
        th = move-exception;
        throw th;
    }
}
