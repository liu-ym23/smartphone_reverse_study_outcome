package com.obric.pushservice;

import com.obric.olog.OLog;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PushMessageCallbackRegistry.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0007H\u0007J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0007H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/obric/pushservice/PushMessageCallbackRegistry;", "", "()V", "TAG", "", "callbacks", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/obric/pushservice/PushMessageCallback;", "dispatcher", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "dispatch", "", "data", "messageId", "registerCallback", "callback", "unregisterCallback", "baseservice_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class PushMessageCallbackRegistry {
    public static final PushMessageCallbackRegistry INSTANCE = null;
    private static final String TAG = "PushMessageCallbackRegistry";
    private static final CopyOnWriteArrayList<PushMessageCallback> callbacks = null;
    private static final ExecutorService dispatcher = null;

    @JvmStatic
    public static final void dispatch(String r2) {
        dispatch$default(r2, null, 2, null);
    }

    static {
        INSTANCE = new PushMessageCallbackRegistry();
        callbacks = new CopyOnWriteArrayList();
        dispatcher = Executors.newSingleThreadExecutor(PushMessageCallbackRegistry$dispatcher$1.INSTANCE);
    }

    private PushMessageCallbackRegistry() {
    }

    public static final /* synthetic */ CopyOnWriteArrayList access$getCallbacks$p(PushMessageCallbackRegistry r0) {
        return callbacks;
    }

    @JvmStatic
    public static final void registerCallback(PushMessageCallback r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        CopyOnWriteArrayList<PushMessageCallback> r0 = callbacks;
        if (r0.contains(r2) == true) goto L6;
        r0.add(r2);
        return;
    }

    @JvmStatic
    public static final void unregisterCallback(PushMessageCallback r1) {
        Intrinsics.checkNotNullParameter(r1, "callback");
        callbacks.remove(r1);
    }

    public static /* synthetic */ void dispatch$default(String r0, String r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L5;
        r1 = null;
        String r4 = (String) null;
    L5:
        dispatch(r0, r1);
    }

    @JvmStatic
    public static final void dispatch(final String r2, final String r3) {
        Intrinsics.checkNotNullParameter(r2, "data");
        if (callbacks.isEmpty() == false) goto L6;
        OLog.d(TAG, "no callback registered, drop message, msgId is " + r3);
        return;
    L6:
        dispatcher.execute(new AnonymousClass1(r2, r3));
    }
}
