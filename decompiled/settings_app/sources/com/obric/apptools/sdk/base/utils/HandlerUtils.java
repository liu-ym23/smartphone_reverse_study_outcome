package com.obric.apptools.sdk.base.utils;

import android.os.Handler;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: compiled from: HandlerUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/obric/apptools/sdk/base/utils/HandlerUtils;", "", "()V", "TAG", "", "workerHandler", "Landroid/os/Handler;", "getWorkerHandler", "()Landroid/os/Handler;", "workerHandler$delegate", "Lkotlin/Lazy;", "tools_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HandlerUtils {
    public static final HandlerUtils INSTANCE = null;
    private static final String TAG = "HandlerUtils";
    private static final Lazy workerHandler$delegate = null;

    private HandlerUtils() {
    }

    static {
        INSTANCE = new HandlerUtils();
        workerHandler$delegate = LazyKt.lazy(HandlerUtils$workerHandler$2.INSTANCE);
    }

    public final Handler getWorkerHandler() {
        return (Handler) workerHandler$delegate.getValue();
    }
}
