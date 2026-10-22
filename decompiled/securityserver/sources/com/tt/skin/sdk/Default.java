package com.tt.skin.sdk;

import android.content.Context;
import com.tt.skin.sdk.api.ISkinListenerInterceptor;
import com.tt.skin.sdk.api.ISkinStatusInterceptor;
import com.tt.skin.sdk.api.ISkinViewInterceptor;
import com.tt.skin.sdk.api.ISkinWebViewInterceptor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class Default {

    @NotNull
    private static final ISkinListenerInterceptor DEFAULT_LISTENER_INTERCEPTOR = null;

    @NotNull
    private static final ISkinStatusInterceptor DEFAULT_STATUS_INTERCEPTOR = null;

    @NotNull
    private static final ISkinViewInterceptor DEFAULT_VIEW_INTERCEPTOR = null;

    @NotNull
    private static final ISkinWebViewInterceptor DEFAULT_WEBVIEW_NIGHT_INTERCEPTOR = null;
    public static final Default INSTANCE = null;

    static {
        INSTANCE = new Default();
        DEFAULT_LISTENER_INTERCEPTOR = new Default$DEFAULT_LISTENER_INTERCEPTOR$1();
        DEFAULT_STATUS_INTERCEPTOR = new Default$DEFAULT_STATUS_INTERCEPTOR$1();
        DEFAULT_VIEW_INTERCEPTOR = new Default$DEFAULT_VIEW_INTERCEPTOR$1();
        DEFAULT_WEBVIEW_NIGHT_INTERCEPTOR = new Default$DEFAULT_WEBVIEW_NIGHT_INTERCEPTOR$1();
    }

    private Default() {
    }

    public final void context(@NotNull Function1<? super Context, Unit> r1) {
        Intrinsics.g(r1, "cb");
        Context r0 = SkinManagerAdapter.INSTANCE.getContext();
        if (r0 == null) goto L6;
        r1.invoke(r0);
        return;
    }

    @NotNull
    public final ISkinListenerInterceptor getDEFAULT_LISTENER_INTERCEPTOR() {
        return DEFAULT_LISTENER_INTERCEPTOR;
    }

    @NotNull
    public final ISkinStatusInterceptor getDEFAULT_STATUS_INTERCEPTOR() {
        return DEFAULT_STATUS_INTERCEPTOR;
    }

    @NotNull
    public final ISkinViewInterceptor getDEFAULT_VIEW_INTERCEPTOR() {
        return DEFAULT_VIEW_INTERCEPTOR;
    }

    @NotNull
    public final ISkinWebViewInterceptor getDEFAULT_WEBVIEW_NIGHT_INTERCEPTOR() {
        return DEFAULT_WEBVIEW_NIGHT_INTERCEPTOR;
    }
}
