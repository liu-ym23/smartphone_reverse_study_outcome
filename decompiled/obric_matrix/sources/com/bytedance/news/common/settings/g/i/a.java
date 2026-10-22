package com.bytedance.news.common.settings.g.i;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.obric.matrix.r.b;
import java.util.Iterator;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static volatile a f5316g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JSONObject f5317a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private SharedPreferences f5318b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private SharedPreferences f5319c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private SharedPreferences f5320d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private SharedPreferences.Editor f5321e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f5322f;

    private a(Context r3) {
        this.f5318b = a(r3, "__ab_vid_info.sp", 0);
        this.f5320d = a(r3, "__ab_exposed_info.sp", 0);
        SharedPreferences r4 = a(r3, "__ab_local_exposed_info.sp", 0);
        this.f5319c = r4;
        r4.edit();
        this.f5321e = this.f5320d.edit();
        String r5 = this.f5318b.getString("key_vid_info", "");
        if (TextUtils.isEmpty(r5) == true) goto L11;
        this.f5317a = new JSONObject(r5);     // Catch: JSONException -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    @Proxy("getSharedPreferences")
    @TargetClass(scope = Scope.SELF, value = "android.content.Context")
    public static SharedPreferences a(Context r0, String r1, int r2) {
        return b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
    }

    public static a b(Context r2) {
        if (f5316g != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f5316g != null) goto L9;
        f5316g = new a(r2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f5316g;
    }

    public boolean c() {
        return this.f5322f;
    }

    public void d(String r5) {
        if (this.f5317a == null) goto L17;
        monitor-enter(this);
        JSONObject r0 = this.f5317a;     // Catch: Throwable -> L14
        if (r0 == null) goto L12;
        long r1 = r0.optLong(r5);     // Catch: Throwable -> L14
        if (r1 <= 0) goto L12;
        if (this.f5320d.contains(r5) == true) goto L12;
        this.f5321e.putString(r5, String.valueOf(r1)).apply();     // Catch: Throwable -> L14
    L12:
        monitor-exit(this);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public void e(boolean r1) {
        this.f5322f = r1;
    }

    public synchronized void f(@NonNull JSONObject r3) {
        monitor-enter(this);
        this.f5317a = r3;     // Catch: Throwable -> L12
        this.f5318b.edit().putString("key_vid_info", r3.toString()).apply();     // Catch: Throwable -> L12
        Iterator<String> r4 = this.f5320d.getAll().keySet().iterator();     // Catch: Throwable -> L12
    L5:
        if (r4.hasNext() == false) goto L9;
        String r0 = r4.next();     // Catch: Throwable -> L12
        if (this.f5317a.has(r0) == true) goto L5;
        this.f5321e.remove(r0);     // Catch: Throwable -> L12
        goto L5
    L9:
        this.f5321e.apply();     // Catch: Throwable -> L12
        monitor-exit(this);
        return;
    L12:
        th = move-exception;
        throw th;
    }
}
