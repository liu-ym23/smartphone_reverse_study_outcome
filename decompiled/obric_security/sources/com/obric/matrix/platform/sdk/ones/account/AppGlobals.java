package com.obric.matrix.platform.sdk.ones.account;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AppGlobals.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\u0004J\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\rR\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/account/AppGlobals;", "", "()V", "app", "Landroid/app/Application;", "getApp", "()Landroid/app/Application;", "app$delegate", "Lkotlin/Lazy;", "getApplication", "getApplicationContext", "Landroid/content/Context;", "getResource", "Landroid/content/res/Resources;", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AppGlobals {
    public static final AppGlobals INSTANCE = null;
    private static final Lazy app$delegate = null;

    private AppGlobals() {
    }

    static {
        INSTANCE = new AppGlobals();
        app$delegate = LazyKt.lazy(AppGlobals$app$2.INSTANCE);
    }

    private final Application getApp() {
        return (Application) app$delegate.getValue();
    }

    public final Application getApplication() {
        return getApp();
    }

    public final Context getApplicationContext() {
        Context r1 = getApplication().getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(r1, "getApplication().applicationContext");
        return r1;
    }

    public final Resources getResource() {
        Resources r1 = getApp().getResources();
        Intrinsics.checkNotNullExpressionValue(r1, "app.resources");
        return r1;
    }
}
