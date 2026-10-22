package com.obric.tools;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.PowerManager;
import com.android.settings.SettingsApplication;
import com.android.settings.SettingsInitialize;
import com.android.settings.deviceinfo.DeviceInfoProvider;
import com.android.settings.utils.ThreadUtils;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Insert;

/* JADX INFO: compiled from: SettingsUpdateReceiver.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002¨\u0006\r"}, d2 = {"Lcom/obric/tools/SettingsUpdateReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "releaseQuietly", DeviceInfoProvider.CLIENT, "Landroid/content/ContentProviderClient;", "Companion", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SettingsUpdateReceiver extends BroadcastReceiver {
    public static final String ACTION_SETTINGS_UPDATE = "com.obric.matrix.systemapp.settings.update.action";
    public static final Companion Companion = null;

    /* JADX INFO: compiled from: SettingsUpdateReceiver.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/tools/SettingsUpdateReceiver$Companion;", "", "()V", "ACTION_SETTINGS_UPDATE", "", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$VtBj2-LGSqbLnoeOIBwlXxU6HOA, reason: not valid java name */
    public static /* synthetic */ void m1474$r8$lambda$VtBj2LGSqbLnoeOIBwlXxU6HOA(Context r0, SettingsUpdateReceiver r1) {
        onReceive$lambda$0(r0, r1);
    }

    static {
        Companion = new Companion(null);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r1, Intent r2) {
        com_obric_tools_SettingsUpdateReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(this, r1, r2);
    }

    public SettingsUpdateReceiver() {
    }

    public void com_obric_tools_SettingsUpdateReceiver__onReceive$___twin___(final Context r2, Intent r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "intent");
        if (ACTION_SETTINGS_UPDATE.equals(r3.getAction()) == false) goto L10;
        OLog.i("SettingsUpdateReceiver", "on matrix settings update");
        Object r4 = r2.getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.os.PowerManager");
        PowerManager r5 = (PowerManager) r4;
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == true) goto L7;
        return;
    L7:
        if (r5.isInteractive() == false) goto L12;
        ThreadUtils.postOnBackgroundThread(new SettingsUpdateReceiver$$ExternalSyntheticLambda0(r2, this));
        return;
    L12:
        return;
    }

    private static final void onReceive$lambda$0(Context r4, SettingsUpdateReceiver r5) {
        Intrinsics.checkNotNullParameter(r4, "$context");
        Intrinsics.checkNotNullParameter(r5, "this$0");
        OLog.i("SettingsUpdateReceiver", "aiLab call check_permission");
        ContentProviderClient r3 = null;
        ContentProviderClient r6 = r4.getContentResolver().acquireUnstableContentProviderClient(Uri.parse("content://com.obric.memorydata.memory.ailabprovider"));     // Catch: Throwable -> L12
        if (r6 != null) goto L8;
        OLog.i("SettingsUpdateReceiver", "aiLab provider client null");     // Catch: Throwable -> L10
        r5.releaseQuietly(r6);
        return;
    L8:
        r6.call("check_permission", null, null);     // Catch: Throwable -> L10
        r5.releaseQuietly(r6);
        return;
    L10:
        th = th;
        r3 = r6;
    L22:
        OLog.e("SettingsUpdateReceiver", "aiLab call check_permission " + th);     // Catch: Throwable -> L16
        r5.releaseQuietly(r3);
        return;
    L16:
        th = move-exception;
        r5.releaseQuietly(r3);
        throw th;
    L12:
        th = th;
        goto L22
    }

    private final void releaseQuietly(ContentProviderClient r1) {
        if (r1 != null) goto L7;
        return;
    L7:
        r1.close();     // Catch: Throwable -> L6
        return;
    }

    @Insert("onReceive")
    public static void com_obric_tools_SettingsUpdateReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(SettingsUpdateReceiver r7, Context r8, Intent r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        String[] r0 = {"android.bluetooth.device.action.PAIRING_REQUEST", "android.bluetooth.device.action.BOND_STATE_CHANGED", "com.bytedanceos.launcher.new_message", "intent.provision.import_data", "com.android.settings.action.SHOW_IMPORT_DATA_NOTIFICATION"};
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.content.BroadcastReceiver");
        SettingsUpdateReceiver r1 = r7;
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
        r7.com_obric_tools_SettingsUpdateReceiver__onReceive$___twin___(r8, r9);
        return;
    L13:
        GrantUtil r11 = GrantUtil.INSTANCE;
        Application r12 = SettingsApplication.getApplication();
        Intrinsics.checkNotNullExpressionValue(r12, "getApplication(...)");
        if (r11.isSetupCompelete(r12) == true) goto L16;
        OLog.i("PrivacyHookForReceiver", "onReceive !isSetupCompeleted hooked for " + r3 + ", " + r2);
        r7.com_obric_tools_SettingsUpdateReceiver__onReceive$___twin___(r8, r9);
        return;
    L16:
        String r13 = r3;
        if (r13 != null) goto L19;
    L22:
        boolean r14 = true;
    L23:
        if (r14 == false) goto L26;
        OLog.i("PrivacyHookForReceiver", "onReceive !simpleName hooked for " + r3 + ", " + r2);
        r7.com_obric_tools_SettingsUpdateReceiver__onReceive$___twin___(r8, r9);
        return;
    L26:
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == true) goto L30;
        if (r4 == true) goto L30;
        OLog.i("PrivacyHookForReceiver", "onReceive !isPrivacyAllowed hooked for " + r3 + ", " + r2);
        return;
    L30:
        GrantUtil.INSTANCE.applicationInit();
        r7.com_obric_tools_SettingsUpdateReceiver__onReceive$___twin___(r8, r9);
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
