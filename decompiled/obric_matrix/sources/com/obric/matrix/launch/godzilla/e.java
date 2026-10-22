package com.obric.matrix.launch.godzilla;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.SharedPreferences;
import kotlin.Metadata;
import kotlin.f0;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010'\u001a\u0004\u0018\u00010(H\u0007R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR \u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001e\u0010\u0015\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR \u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR \u0010\u001b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR \u0010\u001e\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR \u0010!\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR \u0010$\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\b¨\u0006)"}, d2 = {"Lcom/obric/matrix/launch/godzilla/LaunchCrashStrategyItems;", "", "()V", "clazz", "", "getClazz", "()Ljava/lang/String;", "setClazz", "(Ljava/lang/String;)V", "crashLimit", "", "getCrashLimit", "()I", "setCrashLimit", "(I)V", "message", "getMessage", "setMessage", "method", "getMethod", "setMethod", "os_version", "getOs_version", "setOs_version", "param", "getParam", "setParam", "process", "getProcess", "setProcess", "strategyType", "getStrategyType", "setStrategyType", "thread", "getThread", "setThread", "throwable", "getThrowable", "setThrowable", "toStrategy", "Lcom/bytedance/platform/godzilla/launch/safe/Strategy;", "app_launch_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @com.google.gson.y.c("process")
    private String f9133a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @com.google.gson.y.c("class")
    private String f9134b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @com.google.gson.y.c("method")
    private String f9135c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @com.google.gson.y.c("thread")
    private String f9136d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @com.google.gson.y.c("message")
    private String f9137e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @com.google.gson.y.c("os_version")
    private int f9138f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @com.google.gson.y.c("throwable")
    private String f9139g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @com.google.gson.y.c("strategy_type")
    private String f9140h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @com.google.gson.y.c("crash_limit")
    private int f9141i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @com.google.gson.y.c("param")
    private String f9142j;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0017¨\u0006\u0004"}, d2 = {"com/obric/matrix/launch/godzilla/LaunchCrashStrategyItems$toStrategy$1", "Lcom/bytedance/platform/godzilla/launch/safe/impl/SettingClearHandler$SettingClear;", "clear", "", "app_launch_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a implements d.b.p.a.f.a.f.e.a {
        a() {
        }

        @Proxy("getSharedPreferences")
        @TargetClass(scope = Scope.ALL, value = "android.content.Context")
        public static SharedPreferences a(Application r0, String r1, int r2) {
            return com.obric.matrix.r.b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
        }

        @Override // d.b.p.a.f.a.f.e.a
        @SuppressLint({"CommitPrefEdits"})
        public boolean clear() {
            a(com.bytedance.mpaas.app.a.f5245g, "__local_settings_data.sp", 0).edit().clear().commit();
            return true;
        }
    }

    public e() {
        this.f9141i = 3;
    }

    @SuppressLint({"CommitPrefEdits"})
    public final d.b.p.a.f.a.d a() {
        d.b.p.a.f.a.e.b r0 = new d.b.p.a.f.a.e.b();
        r0.f14285a = this.f9133a;
        r0.f14286b = this.f9134b;
        r0.f14287c = this.f9135c;
        r0.f14289e = this.f9137e;
        r0.f14291g = this.f9138f;
        r0.f14290f = this.f9139g;
        String r1 = this.f9140h;
        if (r1 != null) goto L5;
    L27:
        f.a r2 = f.f9143d;
        String r3 = r2.b();
        JSONObject r4 = new JSONObject();
        r4.put("strategy_type", this.f9140h);
        f0 r5 = f0.f18324a;
        r2.e(r3, r4);
        d.b.p.a.f.a.e.a r6 = null;
    L28:
        if (r6 != null) goto L30;
        return null;
    L30:
        return new d.b.p.a.f.a.d(r0, r6, this.f9141i, com.bytedance.mpaas.app.a.f5245g);
    L5:
        switch(r1.hashCode()) {
            case -1274277205: goto L24;
            case -753676706: goto L20;
            case 343671586: goto L16;
            case 813758768: goto L12;
            case 1764911822: goto L8;
            default: goto L27;
        };
    L8:
        if (r1.equals("delete_db ") == false) goto L27;
        r6 = new d.b.p.a.f.a.f.b(this.f9142j);
        goto L28
    L12:
        if (r1.equals("del_file") == false) goto L27;
        r6 = new d.b.p.a.f.a.f.c(this.f9142j);
        goto L28
    L16:
        if (r1.equals("del_folder") == false) goto L27;
        r6 = new d.b.p.a.f.a.f.d(this.f9142j);
        goto L28
    L20:
        if (r1.equals("clear_setting") == false) goto L27;
        r6 = new d.b.p.a.f.a.f.e(new a());
        goto L28
    L24:
        if (r1.equals("clean_all") == false) goto L27;
        r6 = new d.b.p.a.f.a.f.a();
        goto L28
    }
}
