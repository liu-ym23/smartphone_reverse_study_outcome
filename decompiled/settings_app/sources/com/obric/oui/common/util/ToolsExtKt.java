package com.obric.oui.common.util;

import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ToolsExt.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001aH\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00010\u00032!\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u0002H\u00010\u0005H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\n\u001aH\u0010\u000b\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00010\u00032!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u0002H\u00010\u0005H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\n\u001aL\u0010\u000e\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00010\u00032%\u0010\u000f\u001a!\u0012\u0017\u0012\u00150\u0010j\u0002`\u0011¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u0002H\u00010\u0005H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\n\u001a5\u0010\u0012\u001a\u0004\u0018\u0001H\u0013\"\u0004\b\u0000\u0010\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00130\u0003H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0016\u001a\u0010\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u001a\u0014\u0010\u001b\u001a\u00020\u00182\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00180\u0003\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001c"}, d2 = {"Try", ExifInterface.GPS_DIRECTION_TRUE, "action", "Lkotlin/Function0;", "exceptionHandler", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "throwable", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "TryResNotFound", "resNotFoundException", "Landroid/content/res/Resources$NotFoundException;", "TryRuntimeAndDeadObjectException", "runtimeException", "Ljava/lang/Exception;", "Lkotlin/Exception;", "check", "R", "predict", "", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "printLog", "", "info", "", "runInUIThread", "OUI_standardRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ToolsExtKt {
    public static /* synthetic */ void $r8$lambda$H8SvH7KbEo6itDCbk1EitgTD6n0(Function0 r0) {
        m1094runInUIThread$lambda0(r0);
    }

    public static final void printLog(String r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        OUILogger.INSTANCE.i("OUILogger", r2);
    }

    public static final <T> T Try(Function0<? extends T> r2, Function1<? super Throwable, ? extends T> r3) {
        Intrinsics.checkNotNullParameter(r2, "action");
        Intrinsics.checkNotNullParameter(r3, "exceptionHandler");
        return r2.invoke();
    L5:
        e = move-exception;
        printLog(Intrinsics.stringPlus("Try exception occur ", e.getMessage()));
        return r3.invoke(e);
    }

    public static final <T> T TryResNotFound(Function0<? extends T> r1, Function1<? super Resources.NotFoundException, ? extends T> r2) {
        Intrinsics.checkNotNullParameter(r1, "action");
        Intrinsics.checkNotNullParameter(r2, "resNotFoundException");
        return r1.invoke();
    L5:
        e = move-exception;
        printLog("Try Resources.NotFoundException error occur");
        return r2.invoke(e);
    }

    public static final <T> T TryRuntimeAndDeadObjectException(Function0<? extends T> r2, Function1<? super Exception, ? extends T> r3) {
        Intrinsics.checkNotNullParameter(r2, "action");
        Intrinsics.checkNotNullParameter(r3, "runtimeException");
    L13:
        return r2.invoke();
    L5:
        e = move-exception;
        printLog(Intrinsics.stringPlus("Try DeadObjectException occur, ", e.getMessage()));
        return r3.invoke(e);
    L7:
        e = move-exception;
        printLog(Intrinsics.stringPlus("Try runtimeException occur, ", e.getMessage()));
        return r3.invoke(e);
    }

    public static final <R> R check(Function0<Boolean> r1, Function0<? extends R> r2) {
        Intrinsics.checkNotNullParameter(r1, "predict");
        Intrinsics.checkNotNullParameter(r2, "action");
        if (r1.invoke().booleanValue() == true) goto L5;
        return null;
    L5:
        return r2.invoke();
    }

    public static final void runInUIThread(final Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        r2.invoke();
        return;
    L5:
        new Handler(Looper.getMainLooper()).post(new ToolsExtKt$$ExternalSyntheticLambda0(r2));
    }

    /* JADX INFO: renamed from: runInUIThread$lambda-0, reason: not valid java name */
    private static final void m1094runInUIThread$lambda0(Function0 r1) {
        Intrinsics.checkNotNullParameter(r1, "$action");
        r1.invoke();
    }
}
