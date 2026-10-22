package com.android.settings.teaevent.common;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.provider.Settings;
import com.android.settings.fingerprint.utils.FingerprintUtils;
import com.android.settings.teaevent.common.receiver.EventDailyTaskReceiver;
import com.android.vcard.VCardConfig;
import com.obric.olog.OLog;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: compiled from: EventDailyReporter.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0016\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0019\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/android/settings/teaevent/common/EventDailyReporter;", "", "()V", "KEY_CANCEL_OLD_EVENT_DAILY_TASK", "", "ONE_DAY_MILLIS", "", "REQUEST_CODE", "", "TAG", "ioScope", "Lkotlinx/coroutines/CoroutineScope;", "cancelEventDailyTask", "", "context", "Landroid/content/Context;", "createAlarmPendingIntent", "Landroid/app/PendingIntent;", "createEventDailyTask", "createIntent", "Landroid/content/Intent;", "getExistAlarmPendingIntent", "handleEventDailyTask", "isAlarmExist", "", "reportFingerprintEvent", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class EventDailyReporter {
    public static final EventDailyReporter INSTANCE = null;
    private static final String KEY_CANCEL_OLD_EVENT_DAILY_TASK = "cancel_settings_old_event_daily_task";
    private static final long ONE_DAY_MILLIS = 86400000;
    private static final int REQUEST_CODE = 0;
    private static final String TAG = "EventDailyReporter";
    private static final CoroutineScope ioScope = null;

    /* JADX INFO: renamed from: com.android.settings.teaevent.common.EventDailyReporter$handleEventDailyTask$1, reason: invalid class name */
    /* JADX INFO: compiled from: EventDailyReporter.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.android.settings.teaevent.common.EventDailyReporter$handleEventDailyTask$1", f = "EventDailyReporter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        int label;

        AnonymousClass1(Context r1, Continuation<? super AnonymousClass1> r2) {
            this.$context = r1;
            super(2, r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new AnonymousClass1(this.$context, r2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((AnonymousClass1) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            EventDailyReporter.access$reportFingerprintEvent(EventDailyReporter.INSTANCE, this.$context);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private EventDailyReporter() {
    }

    public static final /* synthetic */ void access$reportFingerprintEvent(EventDailyReporter r0, Context r1) {
        r0.reportFingerprintEvent(r1);
    }

    static {
        INSTANCE = new EventDailyReporter();
        ioScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
    }

    @JvmStatic
    public static final void createEventDailyTask(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        OLog.d(TAG, "createEventDailyTask");
        boolean r3 = false;
        if (Settings.Global.getInt(r4.getContentResolver(), KEY_CANCEL_OLD_EVENT_DAILY_TASK, 0) != 1) goto L5;
        r3 = true;
    L5:
        if (r3 == false) goto L8;
        INSTANCE.cancelEventDailyTask(r4);
    L8:
        if (INSTANCE.isAlarmExist(r4) == false) goto L11;
        OLog.d(TAG, "alarm already exists");
        return;
    L11:
        handleEventDailyTask(r4);
    }

    @JvmStatic
    public static final void handleEventDailyTask(Context r17) {
        Intrinsics.checkNotNullParameter(r17, "context");
        OLog.d(TAG, "handleEventDailyTask");
        AlarmManager r9 = null;
        BuildersKt.launch$default(ioScope, null, null, new AnonymousClass1(r17, null), 3, null);
        EventDailyReporter r1 = INSTANCE;
        if (r1.isAlarmExist(r17) == false) goto L6;
        OLog.d(TAG, "handleEventDailyTask, alarm already exists, return");
        return;
    L6:
        Object r3 = r17.getSystemService("alarm");
        if ((r3 instanceof AlarmManager) == false) goto L9;
        r9 = (AlarmManager) r3;
    L9:
        AlarmManager r10 = r9;
        if (r10 != null) goto L13;
        OLog.e(TAG, "handleEventDailyTask, alarmManager is null, return");
        return;
    L13:
        PendingIntent r16 = r1.createAlarmPendingIntent(r17);
        r10.setRepeating(2, SystemClock.elapsedRealtime() + 86400000, 86400000, r16);
    }

    private final boolean isAlarmExist(Context r1) {
        if (getExistAlarmPendingIntent(r1) == null) goto L5;
        return true;
    L5:
        return false;
    }

    private final PendingIntent getExistAlarmPendingIntent(Context r3) {
        return PendingIntent.getBroadcast(r3, 0, createIntent(r3), 603979776);
    }

    private final void cancelEventDailyTask(Context r5) {
        OLog.d(TAG, "cancelEventDailyTask");
    L3:
        PendingIntent r0 = getExistAlarmPendingIntent(r5);
        if (r0 == null) goto L5;
        OLog.d(TAG, "removeEventDailyTask");
        Object r2 = r5.getSystemService("alarm");
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type android.app.AlarmManager");
        ((AlarmManager) r2).cancel(r0);
        r0.cancel();
        goto L3
    }

    private final PendingIntent createAlarmPendingIntent(Context r3) {
        Intent r2 = new Intent(r3, EventDailyTaskReceiver.class);
        r2.setAction(EventDailyTaskReceiver.ACTION_EVENT_DAILY_TASK);
        PendingIntent r4 = PendingIntent.getBroadcast(r3, 0, r2, VCardConfig.FLAG_APPEND_TYPE_PARAM);
        Intrinsics.checkNotNullExpressionValue(r4, "getBroadcast(...)");
        return r4;
    }

    private final Intent createIntent(Context r2) {
        Intent r1 = new Intent(r2, EventDailyTaskReceiver.class);
        r1.setAction(EventDailyTaskReceiver.ACTION_EVENT_DAILY_TASK);
        return r1;
    }

    private final void reportFingerprintEvent(Context r4) {
        OLog.d(TAG, "reportFingerprintEvent");
        boolean r3 = FingerprintUtils.hasUdfps(r4);
        boolean r0 = FingerprintUtils.hasAIFps(r4);
        if (r3 == false) goto L6;
        if (r0 == false) goto L6;
        String r5 = SettingsTeaEvent.Value.VALUE_SIDE_AND_DISPLAY_FINGERPRINT;
    L11:
        boolean r1 = FingerprintUtils.isUdfpsUnlockScreenEnabled(r4);
        int r6 = FingerprintUtils.getUdfpsUnlockScreenType(r4);
        LinkedHashMap r2 = new LinkedHashMap();
        r2.put(SettingsTeaEvent.Key.KEY_SETTINGS_FINGER_PRINT_ENROLL_TYPE, r5);
        if (r1 == false) goto L14;
        String r7 = "1";
    L15:
        r2.put(SettingsTeaEvent.Key.KEY_SETTINGS_FINGER_PRINT_USE_FOR_UNLOCKSCREEN_SWITCH, r7);
        if (r6 != 0) goto L18;
        String r8 = SettingsTeaEvent.Value.VALUE_USE_FOR_ENTER_LAUNCHER;
    L19:
        r2.put(SettingsTeaEvent.Key.KEY_SETTINGS_FINGER_PRINT_UNLOCK_CHOICE, r8);
        SettingsTeaEvent.reportEvent(SettingsTeaEvent.Event.EVENT_SETTINGS_FINGER_PRINT_ENROLL, r2);
        return;
    L18:
        r8 = SettingsTeaEvent.Value.VALUE_USE_FOR_STAY_ON_SCREEN;
        goto L19
    L14:
        r7 = "0";
    L6:
        if (r3 == false) goto L8;
        r5 = SettingsTeaEvent.Value.VALUE_DISPLAY_FINGERPRINT_ONLY;
        goto L11
    L8:
        if (r0 == false) goto L10;
        r5 = SettingsTeaEvent.Value.VALUE_SIDE_FINGERPRINT_ONLY;
        goto L11
    L10:
        r5 = SettingsTeaEvent.Value.VALUE_NO_FINGERPRINT;
        goto L11
    }
}
