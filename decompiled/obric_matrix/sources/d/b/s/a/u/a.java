package d.b.s.a.u;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.sdk.account.impl.g;
import com.obric.matrix.r.b;
import com.ss.android.d;
import com.ss.android.i.j;
import d.b.s.a.q.f;
import kotlin.n0.d.o;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static SharedPreferences f14937a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f14938b = null;

    static {
        f14938b = new a();
    }

    private a() {
    }

    @Proxy("getSharedPreferences")
    @TargetClass(scope = Scope.SELF, value = "android.content.Context")
    public static SharedPreferences a(Context r0, String r1, int r2) {
        return b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
    }

    public static final String b(String r3) {
        boolean r0 = false;
        if (r3 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        f r4 = g.c();
        o.b(r4, "BDAccountDelegateInner.instance()");
        r3 = r4.k();
    L11:
        if (r3 != null) goto L13;
    L14:
        r0 = true;
    L16:
        if (r0 == false) goto L18;
        return "";
    L18:
        SharedPreferences r1 = f14938b.c();
        if (r1 == null) goto L24;
        String r5 = r1.getString(r3, "");
        if (r5 != null) goto L23;
        return "";
    L23:
        return r5;
    L24:
        return "";
    L13:
        if (r3.length() != 0) goto L16;
    L5:
        if (r3.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    private final SharedPreferences c() {
        if (f14937a != null) goto L12;
        d r2 = j.l();
        if (r2 == null) goto L9;
        Context r3 = r2.e();
        if (r3 == null) goto L9;
        SharedPreferences r4 = a(r3, "account_sdk_d_ticket", 0);
    L10:
        f14937a = r4;
    L9:
        r4 = null;
    L12:
        return f14937a;
    }

    public static final void d(String r1, String r2) {
        o.g(r1, "secUserId");
        o.g(r2, "dTicket");
        if (r1.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        SharedPreferences r3 = f14938b.c();
        if (r3 == null) goto L16;
        SharedPreferences.Editor r4 = r3.edit();
        if (r4 == null) goto L17;
        SharedPreferences.Editor r5 = r4.putString(r1, r2);
        if (r5 == null) goto L18;
        r5.apply();
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    L5:
        r0 = false;
        goto L6
    }
}
