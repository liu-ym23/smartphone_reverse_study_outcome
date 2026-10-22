package com.obric.matrix.platform.sdk.ones.account;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SuppressLint({"PrivateApi"})
public final class AppGlobals {

    @NotNull
    public static final AppGlobals INSTANCE = null;

    @NotNull
    private static final Lazy app$delegate = null;

    static {
        INSTANCE = new AppGlobals();
        app$delegate = LazyKt.b(AppGlobals$app$2.INSTANCE);
    }

    private AppGlobals() {
    }

    private final Application getApp() {
        return (Application) app$delegate.getValue();
    }

    @NotNull
    public final Application getApplication() {
        return getApp();
    }

    @NotNull
    public final Context getApplicationContext() {
        Context r1 = getApplication().getApplicationContext();
        Intrinsics.e(r1, "getApplication().applicationContext");
        return r1;
    }

    @NotNull
    public final Resources getResource() {
        Resources r1 = getApp().getResources();
        Intrinsics.e(r1, "app.resources");
        return r1;
    }
}
