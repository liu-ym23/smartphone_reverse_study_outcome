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

/* JADX INFO: compiled from: Default.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00140\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0018"}, d2 = {"Lcom/tt/skin/sdk/Default;", "", "()V", "DEFAULT_LISTENER_INTERCEPTOR", "Lcom/tt/skin/sdk/api/ISkinListenerInterceptor;", "getDEFAULT_LISTENER_INTERCEPTOR", "()Lcom/tt/skin/sdk/api/ISkinListenerInterceptor;", "DEFAULT_STATUS_INTERCEPTOR", "Lcom/tt/skin/sdk/api/ISkinStatusInterceptor;", "getDEFAULT_STATUS_INTERCEPTOR", "()Lcom/tt/skin/sdk/api/ISkinStatusInterceptor;", "DEFAULT_VIEW_INTERCEPTOR", "Lcom/tt/skin/sdk/api/ISkinViewInterceptor;", "getDEFAULT_VIEW_INTERCEPTOR", "()Lcom/tt/skin/sdk/api/ISkinViewInterceptor;", "DEFAULT_WEBVIEW_NIGHT_INTERCEPTOR", "Lcom/tt/skin/sdk/api/ISkinWebViewInterceptor;", "getDEFAULT_WEBVIEW_NIGHT_INTERCEPTOR", "()Lcom/tt/skin/sdk/api/ISkinWebViewInterceptor;", "context", "", "cb", "Lkotlin/Function1;", "Landroid/content/Context;", "api_release"}, k = 1, mv = {1, 1, 15})
public final class Default {
    private static final ISkinListenerInterceptor DEFAULT_LISTENER_INTERCEPTOR = null;
    private static final ISkinStatusInterceptor DEFAULT_STATUS_INTERCEPTOR = null;
    private static final ISkinViewInterceptor DEFAULT_VIEW_INTERCEPTOR = null;
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

    public final void context(Function1<? super Context, Unit> r1) {
        Intrinsics.checkParameterIsNotNull(r1, "cb");
        Context r0 = SkinManagerAdapter.INSTANCE.getContext();
        if (r0 == null) goto L6;
        r1.invoke(r0);
        return;
    }

    public final ISkinListenerInterceptor getDEFAULT_LISTENER_INTERCEPTOR() {
        return DEFAULT_LISTENER_INTERCEPTOR;
    }

    public final ISkinStatusInterceptor getDEFAULT_STATUS_INTERCEPTOR() {
        return DEFAULT_STATUS_INTERCEPTOR;
    }

    public final ISkinViewInterceptor getDEFAULT_VIEW_INTERCEPTOR() {
        return DEFAULT_VIEW_INTERCEPTOR;
    }

    public final ISkinWebViewInterceptor getDEFAULT_WEBVIEW_NIGHT_INTERCEPTOR() {
        return DEFAULT_WEBVIEW_NIGHT_INTERCEPTOR;
    }
}
