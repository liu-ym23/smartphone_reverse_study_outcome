package com.obric.matrix.sdk.push;

import a.a.a.a.a.c.b;
import a.a.a.a.a.c.c;
import android.content.Context;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u001a\u0010\u0013\u001a\u00020\n2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0007R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0018"}, d2 = {"Lcom/obric/matrix/sdk/push/PushApi;", "", "()V", "pushService", "Lcom/obric/matrix/sdk/push/PushImpl;", "getPushService", "()Lcom/obric/matrix/sdk/push/PushImpl;", "pushService$delegate", "Lkotlin/Lazy;", "registerPush", "", "context", "Landroid/content/Context;", "pushConfiguration", "Lcom/obric/matrix/sdk/push/PushConfiguration;", "registerCallback", "Lcom/obric/matrix/sdk/push/IRegisterCallback;", "appId", "", "setLogger", "enableAndroidLog", "", "logger", "Lcom/obric/matrix/push/common/log/ILogger;", "sdk_push_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PushApi {
    public static final PushApi INSTANCE = null;
    private static final Lazy pushService$delegate = null;

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/obric/matrix/sdk/push/PushImpl;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class a extends Lambda implements Function0<a.a.a.b.a.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f15a = null;

        static {
            f15a = new a();
        }

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public a.a.a.b.a.a invoke() {
            return new a.a.a.b.a.a();
        }
    }

    static {
        INSTANCE = new PushApi();
        pushService$delegate = LazyKt.lazy(a.f15a);
    }

    private PushApi() {
    }

    private final a.a.a.b.a.a getPushService() {
        return (a.a.a.b.a.a) pushService$delegate.getValue();
    }

    @JvmStatic
    public static final void registerPush(Context r1, PushConfiguration r2, IRegisterCallback r3) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "pushConfiguration");
        Intrinsics.checkNotNullParameter(r3, "registerCallback");
        INSTANCE.getPushService().a(r1, r2, r3);
    }

    @JvmStatic
    public static final void registerPush(Context r3, String r4, IRegisterCallback r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "appId");
        Intrinsics.checkNotNullParameter(r5, "registerCallback");
        INSTANCE.getPushService().a(r3, new PushConfiguration(r4, "-"), r5);
    }

    @JvmStatic
    public static final void setLogger(boolean r1, b r2) {
        Intrinsics.checkNotNullParameter(r2, "logger");
        c.b = r1;
        c.c = r2;
    }

    public static /* synthetic */ void setLogger$default(boolean r0, b r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r0 = true;
    L5:
        setLogger(r0, r1);
    }
}
