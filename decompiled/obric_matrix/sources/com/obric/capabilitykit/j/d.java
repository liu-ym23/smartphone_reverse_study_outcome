package com.obric.capabilitykit.j;

import android.app.Application;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u0012X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u0012X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u0012X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0014\u0010\u001c\u001a\u00020\u001dX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001eR\u0014\u0010\u001f\u001a\u00020\u001dX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u0014\u0010 \u001a\u00020\u001dX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001eR\u0014\u0010!\u001a\u00020\u001dX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001eR\u0014\u0010\"\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0010R\u0014\u0010$\u001a\u00020\u0012X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0014R\u0014\u0010&\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0010R\u0014\u0010(\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0010R\u0014\u0010*\u001a\u00020\u0012X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0014¨\u0006,"}, d2 = {"Lcom/obric/capabilitykit/apphost/AppHostImpl;", "Lcom/obric/capabilitykit/apphost/AppHost;", "app", "Landroid/app/Application;", "(Landroid/app/Application;)V", "activityStackManager", "Lcom/obric/capabilitykit/apphost/ActivityStackManager;", "getActivityStackManager", "()Lcom/obric/capabilitykit/apphost/ActivityStackManager;", "appClock", "Lcom/obric/capabilitykit/apphost/AppClock;", "getAppClock", "()Lcom/obric/capabilitykit/apphost/AppClock;", "appId", "", "getAppId", "()I", "appName", "", "getAppName", "()Ljava/lang/String;", "appStringName", "getAppStringName", "application", "getApplication", "()Landroid/app/Application;", "buildChannel", "getBuildChannel", "isDebug", "", "()Z", "isDebugChannel", "isOversea", "isTestChannel", "manifestVersionCode", "getManifestVersionCode", "manifestVersionName", "getManifestVersionName", "updateVersionCode", "getUpdateVersionCode", "versionCode", "getVersionCode", "versionName", "getVersionName", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class d implements c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Application f8153b;

    public d(Application r2) {
        o.f(r2, "app");
        this.f8153b = r2;
        new a(a());
    }

    @Override // com.obric.capabilitykit.j.c
    public Application a() {
        return this.f8153b;
    }
}
