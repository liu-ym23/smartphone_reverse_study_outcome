package com.obric.aikernel.core;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.obric.aikernel.core.log.AIKLog;
import com.obric.aikernel.sdk.config.RequestParams;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TransactHandle.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006J\u0018\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/obric/aikernel/core/TransactHandle;", "", "()V", "TAG", "", "Transact_post_event", "", "notifyRequestComplete", "", "binder", "Landroid/os/IBinder;", "params", "Lcom/obric/aikernel/sdk/config/RequestParams;", "event", "postEventInner", "bundle", "Landroid/os/Bundle;", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TransactHandle {
    public static final TransactHandle INSTANCE = null;
    private static final String TAG = "TransactHandle";
    public static final int Transact_post_event = 1001;

    static {
        INSTANCE = new TransactHandle();
    }

    private TransactHandle() {
    }

    public final void notifyRequestComplete(IBinder r2, RequestParams r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "binder");
        Intrinsics.checkNotNullParameter(r3, "params");
        r3.setTargetComponent(2);
        r3.setEvent(r4);
        postEventInner(r2, r3.start());
    }

    private final void postEventInner(IBinder r3, Bundle r4) {
        Parcel r2 = Parcel.obtain();
        Intrinsics.checkNotNullExpressionValue(r2, "obtain()");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        r2.writeParcelable(r4, 0);     // Catch: Throwable -> L5
        Object r5 = Result.m1508constructorimpl(Boolean.valueOf(r3.transact(1001, r2, null, 1)));     // Catch: Throwable -> L5
    L7:
        Throwable r6 = Result.m1511exceptionOrNullimpl(r5);
        if (r6 == null) goto L10;
        AIKLog.INSTANCE.e(TAG, "postEvent err: " + r6);
    L10:
        r2.recycle();
        return;
    L5:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.m1508constructorimpl(ResultKt.createFailure(th));
        goto L7
    }
}
