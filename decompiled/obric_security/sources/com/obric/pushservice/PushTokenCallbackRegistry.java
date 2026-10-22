package com.obric.pushservice;

import com.obric.matrix.platform.sdk.ones.account.AccountConst;
import com.obric.olog.OLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PushTokenCallbackRegistry.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0007J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0004H\u0007J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0007H\u0007J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0007H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/obric/pushservice/PushTokenCallbackRegistry;", "", "()V", "TAG", "", "callbacks", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/obric/pushservice/PushTokenCallback;", "lastDeviceToken", "dispatchFailed", "", AccountConst.KEY_ERROR_CODE, AccountConst.KEY_ERROR_MSG, "dispatchSuccess", "deviceToken", "registerCallback", "callback", "unregisterCallback", "baseservice_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class PushTokenCallbackRegistry {
    public static final PushTokenCallbackRegistry INSTANCE = null;
    private static final String TAG = "PushTokenCallbackRegistry";
    private static final CopyOnWriteArrayList<PushTokenCallback> callbacks = null;
    private static volatile String lastDeviceToken;

    static {
        INSTANCE = new PushTokenCallbackRegistry();
        callbacks = new CopyOnWriteArrayList();
    }

    private PushTokenCallbackRegistry() {
    }

    @JvmStatic
    public static final void registerCallback(PushTokenCallback r3) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        CopyOnWriteArrayList<PushTokenCallback> r0 = callbacks;
        if (r0.contains(r3) == true) goto L5;
        r0.add(r3);
    L5:
        String r1 = lastDeviceToken;
        if (r1 == null) goto L9;
        OLog.d(TAG, "dispatch cached push token to callback");
        r3.onSuccess(r1);
        return;
    }

    @JvmStatic
    public static final void unregisterCallback(PushTokenCallback r1) {
        Intrinsics.checkNotNullParameter(r1, "callback");
        callbacks.remove(r1);
    }

    @JvmStatic
    public static final void dispatchSuccess(String r2) {
        Intrinsics.checkNotNullParameter(r2, "deviceToken");
        lastDeviceToken = r2;
        Iterator<T> r0 = callbacks.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((PushTokenCallback) r0.next()).onSuccess(r2);
        goto L4
    }

    @JvmStatic
    public static final void dispatchFailed(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, AccountConst.KEY_ERROR_CODE);
        Intrinsics.checkNotNullParameter(r3, AccountConst.KEY_ERROR_MSG);
        Iterator<T> r0 = callbacks.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((PushTokenCallback) r0.next()).onFailed(r2, r3);
        goto L4
    }
}
