package com.obric.matrix.launch.godzilla;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.mpaas.app.AppInfo;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010*\u001a\u00020+J\b\u0010,\u001a\u00020\u0004H\u0016R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR \u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR \u0010\u001e\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR \u0010!\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR \u0010$\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR\u001e\u0010'\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001b\"\u0004\b)\u0010\u001d¨\u0006-"}, d2 = {"Lcom/obric/matrix/launch/godzilla/CrashPortraitsData;", "", "()V", "appVersion", "", "getAppVersion", "()Ljava/lang/String;", "setAppVersion", "(Ljava/lang/String;)V", "clazz", "getClazz", "setClazz", "ignoreAppVersion", "", "getIgnoreAppVersion", "()Z", "setIgnoreAppVersion", "(Z)V", "message", "getMessage", "setMessage", "method", "getMethod", "setMethod", "osVersion", "", "getOsVersion", "()I", "setOsVersion", "(I)V", "process", "getProcess", "setProcess", "thread", "getThread", "setThread", "throwable", "getThrowable", "setThrowable", "updateVersion", "getUpdateVersion", "setUpdateVersion", "toCrashPortrait", "Lcom/bytedance/platform/godzilla/common/CrashPortrait;", "toString", "app_launch_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @com.google.gson.y.c("process")
    private String f9123a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @com.google.gson.y.c("class")
    private String f9124b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @com.google.gson.y.c("method")
    private String f9125c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @com.google.gson.y.c("thread")
    private String f9126d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @com.google.gson.y.c("message")
    private String f9127e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @com.google.gson.y.c(WsConstants.KEY_APP_VERSION)
    private String f9128f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @com.google.gson.y.c("update_version")
    private int f9129g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @com.google.gson.y.c("os_version")
    private int f9130h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @com.google.gson.y.c("throwable")
    private String f9131i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @com.google.gson.y.c("ignore_app_version")
    private boolean f9132j;

    public d() {
    }

    public final d.b.p.a.d.c a() {
        d.b.p.a.d.c r0 = new d.b.p.a.d.c();
        r0.f14234a = this.f9123a;
        r0.f14235b = this.f9124b;
        r0.f14236c = this.f9125c;
        r0.f14240g = this.f9127e;
        if (this.f9132j == false) goto L5;
        com.obric.matrix.r.c.c.b("toCrashPortrait", "ignoreAppVersion " + this.f9124b + ", " + this.f9131i);
        r0.f14238e = AppInfo.getInstatnce().getVersionCode();
        String r1 = AppInfo.getInstatnce().getVersionCode();
        o.e(r1, "getInstatnce().versionCode");
        int r2 = Integer.parseInt(r1);
    L6:
        r0.f14239f = r2;
        r0.f14242i = this.f9130h;
        r0.f14241h = this.f9131i;
        return r0;
    L5:
        r0.f14238e = this.f9128f;
        r2 = this.f9129g;
        goto L6
    }

    public String toString() {
        return "CrashPortraitsData(process=" + this.f9123a + ", clazz=" + this.f9124b + ", method=" + this.f9125c + ", thread=" + this.f9126d + ", message=" + this.f9127e + ", app_version=" + this.f9128f + ", update_version=" + this.f9129g + ", os_version=" + this.f9130h + ", throwable=" + this.f9131i + ')';
    }
}
