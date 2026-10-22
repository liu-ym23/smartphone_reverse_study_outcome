package com.android.settings.scheduledpower.receiver;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.android.settings.SettingsApplication;
import com.android.settings.SettingsInitialize;
import com.android.settings.scheduledpower.utils.ScheduledPowerUtils;
import com.android.settings.utils.ThreadUtils;
import com.bytedance.sremlib.LibUtil;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Insert;

/* JADX INFO: compiled from: ScheduledPowerOnAndOffReceiver.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\n"}, d2 = {"Lcom/android/settings/scheduledpower/receiver/ScheduledPowerOnAndOffReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "Companion", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ScheduledPowerOnAndOffReceiver extends BroadcastReceiver {
    public static final String ACTION_SET_SCHEDULED_POWER_OFF = "com.android.settings.scheduledpower.receiver.SET_SCHEDULED_POWER_OFF";
    public static final String ACTION_SET_SCHEDULED_POWER_ON = "com.android.settings.scheduledpower.receiver.SET_SCHEDULED_POWER_ON";
    public static final Companion Companion = null;
    private static final String TAG = "ScheduledPowerOnAndOffReceiver";

    /* JADX INFO: compiled from: ScheduledPowerOnAndOffReceiver.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/android/settings/scheduledpower/receiver/ScheduledPowerOnAndOffReceiver$Companion;", "", "()V", "ACTION_SET_SCHEDULED_POWER_OFF", "", "ACTION_SET_SCHEDULED_POWER_ON", "TAG", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    public static /* synthetic */ void $r8$lambda$8ArO7hNfgcUqzYChxBmhi2kQvOU(Context r0) {
        onReceive$lambda$2$lambda$1(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$8dugk_VW9-I1Z6bBk--8daNJFeg, reason: not valid java name */
    public static /* synthetic */ void m584$r8$lambda$8dugk_VW9I1Z6bBk8daNJFeg(Context r0) {
        onReceive$lambda$2$lambda$0(r0);
    }

    static {
        Companion = new Companion(null);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r1, Intent r2) {
        com_android_settings_scheduledpower_receiver_ScheduledPowerOnAndOffReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(this, r1, r2);
    }

    public ScheduledPowerOnAndOffReceiver() {
    }

    public void com_android_settings_scheduledpower_receiver_ScheduledPowerOnAndOffReceiver__onReceive$___twin___(final Context r3, Intent r4) {
        if (r3 == null) goto L46;
        StringBuilder r2 = new StringBuilder("onReceive: ");
        String r0 = null;
        if (r4 == null) goto L6;
        String r1 = r4.getAction();
    L7:
        OLog.i(TAG, r2.append(r1).toString());
        if (r4 == null) goto L10;
        r0 = r4.getAction();
    L10:
        if (r0 != null) goto L12;
        return;
    L12:
        switch(r0.hashCode()) {
            case -605837410: goto L40;
            case -19011148: goto L31;
            case 502473491: goto L28;
            case 505380757: goto L25;
            case 534646192: goto L19;
            case 798292259: goto L15;
            default: goto L54;
        };
    L54:
        return;
    L15:
        if (r0.equals(LibUtil.ACTION_BOOT_COMPLETELY) == false) goto L55;
        ThreadUtils.postOnMainThread(new ScheduledPowerOnAndOffReceiver$$ExternalSyntheticLambda0(r3), 1000L);
        ThreadUtils.postOnMainThread(new ScheduledPowerOnAndOffReceiver$$ExternalSyntheticLambda1(r3), 1000L);
        return;
    L55:
        return;
    L19:
        if (r0.equals(ACTION_SET_SCHEDULED_POWER_ON) == true) goto L22;
        return;
    L22:
        if (ScheduledPowerUtils.isScheduledPowerOnOpen(r3) == false) goto L49;
        ScheduledPowerUtils.sendStartupEvent(r3, true);
        return;
    L49:
        return;
    L25:
        if (r0.equals("android.intent.action.TIME_SET") == false) goto L57;
    L33:
        OLog.i(TAG, "System time/timezone/locale changed, resetting alarms");
        if (ScheduledPowerUtils.isScheduledPowerOnOpen(r3) == false) goto L37;
        ScheduledPowerUtils.sendStartupEvent(r3, true);
    L37:
        if (ScheduledPowerUtils.isScheduledPowerOffOpen(r3) == false) goto L51;
        ScheduledPowerUtils.sendShutdownEvent(r3, true);
        return;
    L51:
        return;
    L57:
        return;
    L28:
        if (r0.equals("android.intent.action.TIMEZONE_CHANGED") == true) goto L33;
        return;
    L31:
        if (r0.equals("android.intent.action.LOCALE_CHANGED") == true) goto L33;
        return;
    L40:
        if (r0.equals(ACTION_SET_SCHEDULED_POWER_OFF) == true) goto L43;
        return;
    L43:
        if (ScheduledPowerUtils.isScheduledPowerOffOpen(r3) == false) goto L53;
        ScheduledPowerUtils.routeToShutdownConfigActivity(r3);
        ScheduledPowerUtils.sendShutdownEvent(r3, true);
        return;
    L53:
        return;
    L6:
        r1 = null;
        goto L7
    }

    private static final void onReceive$lambda$2$lambda$0(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "$_context");
        if (ScheduledPowerUtils.isScheduledPowerOnOpen(r1) == false) goto L6;
        ScheduledPowerUtils.sendStartupEvent(r1, true);
        return;
    }

    private static final void onReceive$lambda$2$lambda$1(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "$_context");
        if (ScheduledPowerUtils.isScheduledPowerOffOpen(r1) == false) goto L6;
        ScheduledPowerUtils.sendShutdownEvent(r1, true);
        return;
    }

    @Insert("onReceive")
    public static void com_android_settings_scheduledpower_receiver_ScheduledPowerOnAndOffReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(ScheduledPowerOnAndOffReceiver r7, Context r8, Intent r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        String[] r0 = {"android.bluetooth.device.action.PAIRING_REQUEST", "android.bluetooth.device.action.BOND_STATE_CHANGED", "com.bytedanceos.launcher.new_message", "intent.provision.import_data", "com.android.settings.action.SHOW_IMPORT_DATA_NOTIFICATION"};
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.content.BroadcastReceiver");
        ScheduledPowerOnAndOffReceiver r1 = r7;
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
        OLog.i("PrivacyHookForReceiver", r10.append(r5).toString());
        r7.com_android_settings_scheduledpower_receiver_ScheduledPowerOnAndOffReceiver__onReceive$___twin___(r8, r9);
        return;
    L13:
        GrantUtil r11 = GrantUtil.INSTANCE;
        Application r12 = SettingsApplication.getApplication();
        Intrinsics.checkNotNullExpressionValue(r12, "getApplication(...)");
        if (r11.isSetupCompelete(r12) == true) goto L16;
        OLog.i("PrivacyHookForReceiver", "onReceive !isSetupCompeleted hooked for " + r3 + ", " + r2);
        r7.com_android_settings_scheduledpower_receiver_ScheduledPowerOnAndOffReceiver__onReceive$___twin___(r8, r9);
        return;
    L16:
        String r13 = r3;
        if (r13 != null) goto L19;
    L22:
        boolean r14 = true;
    L23:
        if (r14 == false) goto L26;
        OLog.i("PrivacyHookForReceiver", "onReceive !simpleName hooked for " + r3 + ", " + r2);
        r7.com_android_settings_scheduledpower_receiver_ScheduledPowerOnAndOffReceiver__onReceive$___twin___(r8, r9);
        return;
    L26:
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == true) goto L30;
        if (r4 == true) goto L30;
        OLog.i("PrivacyHookForReceiver", "onReceive !isPrivacyAllowed hooked for " + r3 + ", " + r2);
        return;
    L30:
        GrantUtil.INSTANCE.applicationInit();
        r7.com_android_settings_scheduledpower_receiver_ScheduledPowerOnAndOffReceiver__onReceive$___twin___(r8, r9);
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
