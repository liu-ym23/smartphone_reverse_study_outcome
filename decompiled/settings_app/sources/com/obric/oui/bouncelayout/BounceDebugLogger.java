package com.obric.oui.bouncelayout;

import android.util.Log;
import android.view.View;
import com.android.settings.search.IndexDatabaseHelper;
import com.obric.oui.material.MaterialConfigFormatNames;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BounceDebugLogger.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00042\b\b\u0002\u0010\u0019\u001a\u00020\u0004H\u0007J2\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u0019\u001a\u00020\u0004H\u0007J\u001a\u0010\u001e\u001a\u00020\u000f2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000f0 H\u0086\bø\u0001\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R$\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0007\u0010\u0002\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR2\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0010\u0010\u0002\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006!"}, d2 = {"Lcom/obric/oui/bouncelayout/BounceDebugLogger;", "", "()V", "TAG", "", IndexDatabaseHelper.IndexColumns.ENABLED, "", "getEnabled$annotations", "getEnabled", "()Z", "setEnabled", "(Z)V", "listener", "Lkotlin/Function1;", "Lcom/obric/oui/bouncelayout/BounceDebugEvent;", "", "getListener$annotations", "getListener", "()Lkotlin/jvm/functions/Function1;", "setListener", "(Lkotlin/jvm/functions/Function1;)V", "log", "view", "Landroid/view/View;", "operation", "message", "logContentFrame", MaterialConfigFormatNames.X, "", "y", "runIfEnabled", "block", "Lkotlin/Function0;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BounceDebugLogger {
    public static final BounceDebugLogger INSTANCE = null;
    private static final String TAG = "OUIBounce";
    private static volatile boolean enabled;
    private static volatile Function1<? super BounceDebugEvent, Unit> listener;

    static {
        INSTANCE = new BounceDebugLogger();
    }

    @JvmStatic
    public static /* synthetic */ void getEnabled$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getListener$annotations() {
    }

    private BounceDebugLogger() {
    }

    public static final boolean getEnabled() {
        return enabled;
    }

    public static final void setEnabled(boolean r0) {
        enabled = r0;
    }

    public static final Function1<BounceDebugEvent, Unit> getListener() {
        return listener;
    }

    public static final void setListener(Function1<? super BounceDebugEvent, Unit> r0) {
        listener = r0;
    }

    public final void runIfEnabled(Function0<Unit> r1) {
        Intrinsics.checkNotNullParameter(r1, "block");
        if (getEnabled() == false) goto L6;
        r1.invoke();
        return;
    }

    public static /* synthetic */ void log$default(View r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 4) == 0) goto L5;
        r2 = "";
    L5:
        log(r0, r1, r2);
    }

    @JvmStatic
    public static final void log(View r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r11, "view");
        Intrinsics.checkNotNullParameter(r12, "operation");
        Intrinsics.checkNotNullParameter(r13, "message");
        if (enabled == true) goto L5;
        return;
    L5:
        String r2 = r11.getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(r2, "view.javaClass.simpleName");
        BounceDebugEvent r0 = new BounceDebugEvent(r2, r12, r11.getScrollX(), r11.getScrollY(), r13, 0, 32, null);
        Log.d(TAG, r0.toLogMessage());
        Function1<? super BounceDebugEvent, Unit> r14 = listener;
        if (r14 == null) goto L10;
        r14.invoke(r0);
        return;
    }

    public static /* synthetic */ void logContentFrame$default(View r0, String r1, float r2, float r3, String r4, int r5, Object r6) {
        if ((r5 & 16) == 0) goto L5;
        r4 = "";
    L5:
        logContentFrame(r0, r1, r2, r3, r4);
    }

    @JvmStatic
    public static final void logContentFrame(View r11, String r12, float r13, float r14, String r15) {
        Intrinsics.checkNotNullParameter(r11, "view");
        Intrinsics.checkNotNullParameter(r12, "operation");
        Intrinsics.checkNotNullParameter(r15, "message");
        if (enabled == true) goto L5;
        return;
    L5:
        String r2 = r11.getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(r2, "view.javaClass.simpleName");
        BounceDebugEvent r0 = new BounceDebugEvent(r2, r12, r13, r14, r15, 0, 32, null);
        Log.d(TAG, r0.toLogMessage());
        Function1<? super BounceDebugEvent, Unit> r16 = listener;
        if (r16 == null) goto L10;
        r16.invoke(r0);
        return;
    }
}
