package d.b.b.e.a.k.h;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.Nullable;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SharedPreferences f12704a;

    public b(Context r3) {
        if (this.f12704a != null) goto L13;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.f12704a != null) goto L8;
        this.f12704a = a(r3, "monitor_downgrade", 0);     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    }

    @Proxy("getSharedPreferences")
    @TargetClass(scope = Scope.SELF, value = "android.content.Context")
    public static SharedPreferences a(Context r0, String r1, int r2) {
        return com.obric.matrix.r.b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
    }

    @Nullable
    public c b() {
        String r6 = this.f12704a.getString("rule", null);
        if (r6 != null) goto L14;
    L13:
        return null;
    L14:
    L11:
        e = move-exception;
        e.printStackTrace();
        goto L13
    L5:
        if (d.b.b.o.a.c() == false) goto L7;
        d.b.b.o.m.b.d("APM-Downgrade", "DowngradeData-load-" + r6);     // Catch: JSONException -> L11
    L7:
        c r7 = c.a(new JSONObject(r6));     // Catch: JSONException -> L11
        if (System.currentTimeMillis() >= r7.f12705a) goto L13;
        return r7;
    }

    public void c(c r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (this.f12704a == null) goto L13;
        JSONObject r5 = r4.b();
        if (r5 == null) goto L14;
        String r0 = r5.toString();
        if (d.b.b.o.a.c() == false) goto L10;
        d.b.b.o.m.b.d("APM-Downgrade", "DowngradeData-save-" + r0);
    L10:
        this.f12704a.edit().putString("rule", r5.toString()).apply();
        return;
    L14:
        return;
    }
}
