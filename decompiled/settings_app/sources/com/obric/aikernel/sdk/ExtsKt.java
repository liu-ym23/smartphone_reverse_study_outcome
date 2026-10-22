package com.obric.aikernel.sdk;

import android.os.Parcel;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.constant.SlardarConfigConsts;
import com.obric.aikernel.core.log.AIKLog;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Exts.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a#\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u0002¢\u0006\u0002\u0010\u0005\u001a2\u0010\u0006\u001a\u0004\u0018\u0001H\u0002\"\u0004\b\u0000\u0010\u0002*\u00020\u00072\u0019\u0010\b\u001a\u0015\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\t¢\u0006\u0002\b\n¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"resume", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/coroutines/Continuation;", SlardarConfigConsts.CONFIG_RET, "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;)V", "safeRead", "Landroid/os/Parcel;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Landroid/os/Parcel;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "sdk_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ExtsKt {
    public static final <T> T safeRead(Parcel r1, Function1<? super Parcel, ? extends T> r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "block");
        if (r1.dataAvail() > 0) goto L7;
        return null;
    L7:
        return r2.invoke(r1);
    }

    public static final <T> void resume(Continuation<? super T> r2, T r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        r2.resumeWith(Result.m1508constructorimpl(r3));     // Catch: Throwable -> L5
        Object r4 = Result.m1508constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r5 = Result.m1511exceptionOrNullimpl(r4);
        if (r5 == null) goto L13;
        AIKLog.INSTANCE.w("Continuation", "resume failed, " + r5);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r4 = Result.m1508constructorimpl(ResultKt.createFailure(th));
        goto L7
    }
}
