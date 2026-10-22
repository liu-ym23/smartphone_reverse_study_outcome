package com.obric.capabilitykit;

import android.app.Application;
import com.bytedance.framwork.core.sdkmonitor.MonitorConstants;
import com.bytedance.sremlib.LibUtil;
import com.obric.capabilitykit.apphost.AppHost;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\nX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0014\u0010\u0018\u001a\u00020\u0019X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u0019X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u0019X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u0019X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\nX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\fR\u0014\u0010 \u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0010R\u0014\u0010\"\u001a\u00020\nX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\fR\u0014\u0010$\u001a\u00020\nX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\fR\u0014\u0010&\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0010¨\u0006("}, d2 = {"Lcom/obric/capabilitykit/apphost/AppHostImpl;", "Lcom/obric/capabilitykit/apphost/AppHost;", LibUtil.EXCEPTION_APPLICATION, "Landroid/app/Application;", "(Landroid/app/Application;)V", "appClock", "Lcom/obric/capabilitykit/apphost/AppClock;", "getAppClock", "()Lcom/obric/capabilitykit/apphost/AppClock;", "appId", "", "getAppId", "()I", "appName", "", "getAppName", "()Ljava/lang/String;", "appStringName", "getAppStringName", "application", "getApplication", "()Landroid/app/Application;", "buildChannel", "getBuildChannel", "isDebug", "", "()Z", "isDebugChannel", "isOversea", "isTestChannel", "manifestVersionCode", "getManifestVersionCode", "manifestVersionName", "getManifestVersionName", "updateVersionCode", "getUpdateVersionCode", "versionCode", "getVersionCode", "versionName", "getVersionName", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class l implements AppHost {
    private final Application a;
    private final String b;
    private final int c;
    private final j d;
    private final int e;
    private final String f;
    private final String g;
    private final boolean h;
    private final boolean i;
    private final String j;
    private final boolean k;
    private final boolean l;
    private final String m;
    private final int n;
    private final int o;

    public l(Application r2) {
        Intrinsics.checkNotNullParameter(r2, LibUtil.EXCEPTION_APPLICATION);
        this.a = r2;
        this.b = "160";
        this.c = 160;
        this.d = new k();
        this.e = 498349;
        this.f = "obric_assistant";
        this.g = "OGrace";
        this.j = MonitorConstants.MONITOR_FROM_SDK;
        this.m = "0.0.1";
        this.n = 1;
        this.o = 1;
    }

    @Override // com.obric.capabilitykit.apphost.AppHost
    public j getAppClock() {
        return this.d;
    }

    @Override // com.obric.capabilitykit.apphost.AppHost
    public int getAppId() {
        return this.e;
    }

    @Override // com.obric.capabilitykit.apphost.AppHost
    public String getAppName() {
        return this.f;
    }

    @Override // com.obric.capabilitykit.apphost.AppHost
    public String getAppStringName() {
        return this.g;
    }

    @Override // com.obric.capabilitykit.apphost.AppHost
    public Application getApplication() {
        return this.a;
    }

    @Override // com.obric.capabilitykit.apphost.AppHost
    public String getBuildChannel() {
        return this.j;
    }

    @Override // com.obric.capabilitykit.apphost.AppHost
    public int getManifestVersionCode() {
        return this.c;
    }

    @Override // com.obric.capabilitykit.apphost.AppHost
    public String getManifestVersionName() {
        return this.b;
    }

    @Override // com.obric.capabilitykit.apphost.AppHost
    public int getUpdateVersionCode() {
        return this.o;
    }

    @Override // com.obric.capabilitykit.apphost.AppHost
    public int getVersionCode() {
        return this.n;
    }

    @Override // com.obric.capabilitykit.apphost.AppHost
    public String getVersionName() {
        return this.m;
    }

    @Override // com.obric.capabilitykit.apphost.AppHost
    public boolean isDebug() {
        return this.h;
    }

    @Override // com.obric.capabilitykit.apphost.AppHost
    public boolean isDebugChannel() {
        return this.l;
    }

    @Override // com.obric.capabilitykit.apphost.AppHost
    public boolean isOversea() {
        return this.i;
    }

    @Override // com.obric.capabilitykit.apphost.AppHost
    public boolean isTestChannel() {
        return this.k;
    }
}
