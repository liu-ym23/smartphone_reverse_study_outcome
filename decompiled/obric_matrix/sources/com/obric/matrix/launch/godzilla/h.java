package com.obric.matrix.launch.godzilla;

import com.bytedance.bdlocation.client.BDLocationConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

/* JADX WARN: Unexpected interfaces in signature: [java.lang.Object<com.obric.matrix.launch.godzilla.h>] */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0016\u001a\u00020\u0000H\u0016J\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\nR\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/obric/matrix/launch/godzilla/SettingsLaunchSafeConfig;", "Lcom/bytedance/news/common/settings/api/annotation/IDefaultValueProvider;", "()V", "crashLimit", "", "getCrashLimit", "()I", "setCrashLimit", "(I)V", "strategyItems", "", "Lcom/obric/matrix/launch/godzilla/LaunchCrashStrategyItems;", "getStrategyItems", "()Ljava/util/List;", "setStrategyItems", "(Ljava/util/List;)V", "watchDogTime", "", "getWatchDogTime", "()J", "setWatchDogTime", "(J)V", "create", "toLaunchSafeStrategyList", "Lcom/bytedance/platform/godzilla/launch/safe/Strategy;", "app_launch_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @com.google.gson.y.c("strategy_items")
    private List<e> f9154a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @com.google.gson.y.c("watch_dog_time")
    private long f9155b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @com.google.gson.y.c("crash_limit")
    private int f9156c;

    public h() {
        this.f9154a = new ArrayList();
        this.f9155b = BDLocationConfig.sScanBleMaxInterval;
        this.f9156c = 3;
    }

    public h a() {
        return new h();
    }

    public final int b() {
        return this.f9156c;
    }

    public final long c() {
        return this.f9155b;
    }

    public final List<d.b.p.a.f.a.d> d() {
        ArrayList r0 = new ArrayList();
        Iterator<e> r2 = this.f9154a.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        d.b.p.a.f.a.d r1 = r2.next().a();
        if (r1 == null) goto L4;
        r0.add(r1);
        goto L4
    L8:
        return r0;
    }
}
