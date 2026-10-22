package com.obric.safecheck.dataSync.miitAntiFraud;

import com.obric.olog.OLog;
import com.obric.pushservice.PushMessageCallbackRegistry;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import org.json.JSONObject;

/* JADX INFO: compiled from: MiitAntiFraudPushMessageObserver.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000)\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\u000f\u001a\u00020\fH\u0007J\b\u0010\u0010\u001a\u00020\fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/obric/safecheck/dataSync/miitAntiFraud/MiitAntiFraudPushMessageObserver;", "", "()V", "KEY_FRAUD_UPDATE", "", "TAG", "callback", "com/obric/safecheck/dataSync/miitAntiFraud/MiitAntiFraudPushMessageObserver$callback$1", "Lcom/obric/safecheck/dataSync/miitAntiFraud/MiitAntiFraudPushMessageObserver$callback$1;", "registered", "", "handleMessage", "", "data", "messageId", "register", "unregister", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class MiitAntiFraudPushMessageObserver {
    public static final MiitAntiFraudPushMessageObserver INSTANCE = null;
    private static final String KEY_FRAUD_UPDATE = "fraud_update";
    private static final String TAG = "MiitAntiFraudPush";
    private static final MiitAntiFraudPushMessageObserver$callback$1 callback = null;
    private static volatile boolean registered;

    /* JADX WARN: Type inference failed for: r0v1, types: [com.obric.safecheck.dataSync.miitAntiFraud.MiitAntiFraudPushMessageObserver$callback$1] */
    static {
        INSTANCE = new MiitAntiFraudPushMessageObserver();
        callback = new MiitAntiFraudPushMessageObserver$callback$1();
    }

    private MiitAntiFraudPushMessageObserver() {
    }

    public static final /* synthetic */ void access$handleMessage(MiitAntiFraudPushMessageObserver r0, String r1, String r2) {
        r0.handleMessage(r1, r2);
    }

    @JvmStatic
    public static final void register() {
        if (registered == false) goto L6;
        OLog.d(TAG, "already registered, skip");
        return;
    L6:
        MiitAntiFraudPushMessageObserver r0 = INSTANCE;
        monitor-enter(r0);
    L15:
        th = move-exception;
        throw th;
    L9:
        if (registered == false) goto L12;
        monitor-exit(r0);
        return;
    L12:
        PushMessageCallbackRegistry.registerCallback(callback);     // Catch: Throwable -> L15
        registered = true;     // Catch: Throwable -> L15
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L15
        monitor-exit(r0);
    }

    @JvmStatic
    public static final void unregister() {
        if (registered == true) goto L5;
        return;
    L5:
        MiitAntiFraudPushMessageObserver r0 = INSTANCE;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L8:
        if (registered == true) goto L11;
        monitor-exit(r0);
        return;
    L11:
        PushMessageCallbackRegistry.unregisterCallback(callback);     // Catch: Throwable -> L14
        registered = false;     // Catch: Throwable -> L14
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(r0);
    }

    private final void handleMessage(String r3, String r4) {
        JSONObject r0 = new JSONObject(r3);     // Catch: Throwable -> L13
        if (r0.has(KEY_FRAUD_UPDATE) == false) goto L11;
        String r5 = r0.optString(KEY_FRAUD_UPDATE);
        OLog.d(TAG, "hit fraud_update, value is " + r5 + ", trigger update list request");
        MiitAntiFraudUpdateRequester.requestUpdateList(r5);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        OLog.e(TAG, "requestUpdateList failed, msgId is " + r4, th);
        return;
    L11:
        OLog.d(TAG, "no known key in push message, msgId is " + r4);
        return;
    L13:
        th = move-exception;
        OLog.e(TAG, "parse push message failed, msgId is " + r4, th);
    }
}
