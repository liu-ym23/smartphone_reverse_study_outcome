package com.obric.safecheck.dataSync.miitAntiFraud;

import com.bytedance.android.standard.tools.date.DateUtils;
import com.obric.olog.OLog;
import com.obric.pushservice.PushTokenCallbackRegistry;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MiitAntiFraudPushTokenObserver.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000)\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\fH\u0007J\b\u0010\r\u001a\u00020\fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/safecheck/dataSync/miitAntiFraud/MiitAntiFraudPushTokenObserver;", "", "()V", "TAG", "", "callback", "com/obric/safecheck/dataSync/miitAntiFraud/MiitAntiFraudPushTokenObserver$callback$1", "Lcom/obric/safecheck/dataSync/miitAntiFraud/MiitAntiFraudPushTokenObserver$callback$1;", "registered", "", "getDateBefore19DaysString", "register", "", "unregister", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class MiitAntiFraudPushTokenObserver {
    public static final MiitAntiFraudPushTokenObserver INSTANCE = null;
    private static final String TAG = "MiitAntiFraudPushTokenObserver";
    private static final MiitAntiFraudPushTokenObserver$callback$1 callback = null;
    private static volatile boolean registered;

    /* JADX WARN: Type inference failed for: r0v1, types: [com.obric.safecheck.dataSync.miitAntiFraud.MiitAntiFraudPushTokenObserver$callback$1] */
    static {
        INSTANCE = new MiitAntiFraudPushTokenObserver();
        callback = new MiitAntiFraudPushTokenObserver$callback$1();
    }

    private MiitAntiFraudPushTokenObserver() {
    }

    public static final /* synthetic */ String access$getDateBefore19DaysString(MiitAntiFraudPushTokenObserver r0) {
        return r0.getDateBefore19DaysString();
    }

    @JvmStatic
    public static final void register() {
        if (registered == false) goto L6;
        OLog.d(TAG, "already registered, skip");
        return;
    L6:
        MiitAntiFraudPushTokenObserver r0 = INSTANCE;
        monitor-enter(r0);
    L15:
        th = move-exception;
        throw th;
    L9:
        if (registered == false) goto L12;
        monitor-exit(r0);
        return;
    L12:
        PushTokenCallbackRegistry.registerCallback(callback);     // Catch: Throwable -> L15
        registered = true;     // Catch: Throwable -> L15
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L15
        monitor-exit(r0);
    }

    @JvmStatic
    public static final void unregister() {
        if (registered == true) goto L5;
        return;
    L5:
        MiitAntiFraudPushTokenObserver r0 = INSTANCE;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L8:
        if (registered == true) goto L11;
        monitor-exit(r0);
        return;
    L11:
        PushTokenCallbackRegistry.unregisterCallback(callback);     // Catch: Throwable -> L14
        registered = false;     // Catch: Throwable -> L14
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(r0);
    }

    private final String getDateBefore19DaysString() {
        Calendar r4 = Calendar.getInstance();
        r4.add(6, -19);
        SimpleDateFormat r0 = new SimpleDateFormat(DateUtils.PATTERN_YEAR, Locale.US);
        Intrinsics.checkNotNullExpressionValue(r4, "calendar");
        String r5 = r0.format(new Date(r4.getTimeInMillis()));
        Intrinsics.checkNotNullExpressionValue(r5, "SimpleDateFormat(\"yyyy-M…e(calendar.timeInMillis))");
        return r5;
    }
}
