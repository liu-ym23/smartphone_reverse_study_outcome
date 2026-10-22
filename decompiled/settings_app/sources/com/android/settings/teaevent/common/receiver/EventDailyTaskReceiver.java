package com.android.settings.teaevent.common.receiver;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.android.settings.SettingsApplication;
import com.android.settings.SettingsInitialize;
import com.android.settings.teaevent.common.EventDailyReporter;
import com.android.settings.utils.ThreadUtils;
import com.bytedance.sremlib.LibUtil;
import com.obric.matrix.platform.sdk.ones.account.log.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Insert;

/* JADX INFO: compiled from: EventDailyTaskReceiver.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\n"}, d2 = {"Lcom/android/settings/teaevent/common/receiver/EventDailyTaskReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "Companion", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class EventDailyTaskReceiver extends BroadcastReceiver {
    public static final String ACTION_EVENT_DAILY_TASK = "com.android.settings.action.EVENT_DAILY_TASK";
    public static final Companion Companion = null;
    private static final String TAG = "EventDailyTaskReceiver";

    /* JADX INFO: compiled from: EventDailyTaskReceiver.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/android/settings/teaevent/common/receiver/EventDailyTaskReceiver$Companion;", "", "()V", "ACTION_EVENT_DAILY_TASK", "", "TAG", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    public static /* synthetic */ void $r8$lambda$g2OxZ5Ve5fc6IFw0KMZ9GkHdnL4(Context r0) {
        onReceive$lambda$1$lambda$0(r0);
    }

    static {
        Companion = new Companion(null);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r1, Intent r2) {
        com_android_settings_teaevent_common_receiver_EventDailyTaskReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(this, r1, r2);
    }

    public EventDailyTaskReceiver() {
    }

    public void com_android_settings_teaevent_common_receiver_EventDailyTaskReceiver__onReceive$___twin___(final Context r3, Intent r4) {
        StringBuilder r2 = new StringBuilder("onReceive: context=").append(r3).append(", action=");
        String r0 = null;
        if (r4 == null) goto L5;
        String r1 = r4.getAction();
    L6:
        OLog.d(TAG, r2.append(r1).toString());
        if (r3 == null) goto L31;
        if (r4 == null) goto L10;
        r0 = r4.getAction();
    L10:
        if (r0 == null) goto L32;
        int r5 = r0.hashCode();
        if (r5 == 798292259) goto L27;
        if (r5 == 1041332296) goto L23;
        if (r5 == 1958314057) goto L19;
        return;
    L19:
        if (r0.equals(ACTION_EVENT_DAILY_TASK) == false) goto L36;
        EventDailyReporter.handleEventDailyTask(r3);
        return;
    L36:
        return;
    L23:
        if (r0.equals("android.intent.action.DATE_CHANGED") == false) goto L37;
        EventDailyReporter.createEventDailyTask(r3);
        return;
    L37:
        return;
    L27:
        if (r0.equals(LibUtil.ACTION_BOOT_COMPLETELY) == false) goto L38;
        ThreadUtils.postOnMainThread(new EventDailyTaskReceiver$$ExternalSyntheticLambda0(r3), 1000L);
        return;
    L38:
        return;
    L32:
        return;
    L31:
        return;
    L5:
        r1 = null;
        goto L6
    }

    private static final void onReceive$lambda$1$lambda$0(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "$_context");
        EventDailyReporter.createEventDailyTask(r1);
    }

    @Insert("onReceive")
    public static void com_android_settings_teaevent_common_receiver_EventDailyTaskReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(EventDailyTaskReceiver r7, Context r8, Intent r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        String[] r0 = {"android.bluetooth.device.action.PAIRING_REQUEST", "android.bluetooth.device.action.BOND_STATE_CHANGED", "com.bytedanceos.launcher.new_message", "intent.provision.import_data", "com.android.settings.action.SHOW_IMPORT_DATA_NOTIFICATION"};
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.content.BroadcastReceiver");
        EventDailyTaskReceiver r1 = r7;
        String r2 = r1.getClass().getName();
        String r3 = r1.getClass().getSimpleName();
        boolean r4 = Intrinsics.areEqual(SettingsInitialize.class, r1.getClass());
        String r5 = null;
        if (r9 == null) goto L5;
        String r6 = r9.getAction();
    L7:
        if (ArraysKt.contains(r0, r6) == false) goto L13;
        StringBuilder r10 = new StringBuilder("onReceive allowList ");
        if (r9 == null) goto L11;
        r5 = r9.getAction();
    L11:
        com.obric.olog.OLog.i("PrivacyHookForReceiver", r10.append(r5).toString());
        r7.com_android_settings_teaevent_common_receiver_EventDailyTaskReceiver__onReceive$___twin___(r8, r9);
        return;
    L13:
        GrantUtil r11 = GrantUtil.INSTANCE;
        Application r12 = SettingsApplication.getApplication();
        Intrinsics.checkNotNullExpressionValue(r12, "getApplication(...)");
        if (r11.isSetupCompelete(r12) == true) goto L16;
        com.obric.olog.OLog.i("PrivacyHookForReceiver", "onReceive !isSetupCompeleted hooked for " + r3 + ", " + r2);
        r7.com_android_settings_teaevent_common_receiver_EventDailyTaskReceiver__onReceive$___twin___(r8, r9);
        return;
    L16:
        String r13 = r3;
        if (r13 != null) goto L19;
    L22:
        boolean r14 = true;
    L23:
        if (r14 == false) goto L26;
        com.obric.olog.OLog.i("PrivacyHookForReceiver", "onReceive !simpleName hooked for " + r3 + ", " + r2);
        r7.com_android_settings_teaevent_common_receiver_EventDailyTaskReceiver__onReceive$___twin___(r8, r9);
        return;
    L26:
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == true) goto L30;
        if (r4 == true) goto L30;
        com.obric.olog.OLog.i("PrivacyHookForReceiver", "onReceive !isPrivacyAllowed hooked for " + r3 + ", " + r2);
        return;
    L30:
        GrantUtil.INSTANCE.applicationInit();
        r7.com_android_settings_teaevent_common_receiver_EventDailyTaskReceiver__onReceive$___twin___(r8, r9);
        return;
    L19:
        if (r13.length() == 0) goto L22;
        r14 = false;
        goto L23
    L5:
        r6 = null;
        goto L7
    }
}
