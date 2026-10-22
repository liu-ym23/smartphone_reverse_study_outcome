package com.obric.security.battertpower.powerHigh.settingsobserver;

import android.app.NotificationManager;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import com.bytedanceos.securitycenter.SecurityCenterApplication;
import com.obric.olog.OLog;
import com.obric.security.R;
import com.obric.security.battertpower.powerHigh.HighPowerAppManager;
import com.obric.security.battertpower.powerHigh.clearApp.ClearPowerHighAppsActivity;
import com.obric.security.battertpower.powerHigh.notice.PowerHighApp;
import com.obric.security.battertpower.powerHigh.notice.PowerHighWarningReceiver;
import com.obric.security.battertpower.powerHigh.notice.PowerHightNoticeService;
import java.util.ArrayList;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PowerHighSettingsMonitor.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010\r\u001a\u00020\bH\u0002J\u000e\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/security/battertpower/powerHigh/settingsobserver/PowerHighSettingsMonitor;", "", "()V", "handler", "Landroid/os/Handler;", "settingObserver", "Lcom/obric/security/battertpower/powerHigh/settingsobserver/PowerHighSettingsObserver;", "handleHighPowerSettingChange", "", "context", "Landroid/content/Context;", "value", "", "reSendNotification", "startMonitoring", "stopMonitoring", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class PowerHighSettingsMonitor {
    private final Handler handler;
    private PowerHighSettingsObserver settingObserver;

    public PowerHighSettingsMonitor() {
        this.handler = new Handler(Looper.getMainLooper());
    }

    public static final /* synthetic */ void access$handleHighPowerSettingChange(PowerHighSettingsMonitor r0, Context r1, String r2) {
        r0.handleHighPowerSettingChange(r1, r2);
    }

    public final void startMonitoring(final Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        OLog.d("PowerHighAppsManager", "startMonitoring");
        PowerHighSettingsObserver r0 = new PowerHighSettingsObserver(r5, this.handler, new PowerHighSettingsMonitor$startMonitoring$observer$1(this, r5));
        r5.getContentResolver().registerContentObserver(Settings.Global.getUriFor("allow_bg_power_high"), false, r0);
        this.settingObserver = r0;
    }

    public final void stopMonitoring(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        PowerHighSettingsObserver r0 = this.settingObserver;
        if (r0 == null) goto L6;
        r2.getContentResolver().unregisterContentObserver(r0);
        PowerHighSettingsObserver r1 = (PowerHighSettingsObserver) null;
        this.settingObserver = null;
        return;
    }

    private final void handleHighPowerSettingChange(Context r5, String r6) {
        HashSet<String> r7 = HighPowerAppManager.Companion.getAllowBgPowerList();
        if (PowerHighWarningReceiver.powerHighApps.size() != 1) goto L13;
        PowerHighApp r4 = PowerHighWarningReceiver.powerHighApps.get(0);
        if (r7.contains(r4.getPackageName()) == false) goto L11;
        PowerHighWarningReceiver.powerHighApps.remove(r4);
        Object r8 = r5.getSystemService(ClearPowerHighAppsActivity.COME_FROM_NOTIFICATION);
        if (r8 == null) goto L10;
        ((NotificationManager) r8).cancel(PowerHighWarningReceiver.NOTIFICATION_ID);
        OLog.d("PowerHightNoticeService", "allow bg power high list change, cancel notice: " + r4.getPackageName());
        goto L11
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.app.NotificationManager");
    L11:
        OLog.d("PowerHightNoticeService", "allow bg power high list change, but notice not change ");
        return;
    L13:
        if (PowerHighWarningReceiver.powerHighApps.size() < 2) goto L25;
        PowerHighApp r9 = PowerHighWarningReceiver.powerHighApps.get(0);
        PowerHighApp r0 = PowerHighWarningReceiver.powerHighApps.get(1);
        if (r7.contains(r9.getPackageName()) == false) goto L19;
        PowerHighWarningReceiver.powerHighApps.remove(r9);
        reSendNotification();
        OLog.d("PowerHightNoticeService", "allow bg power high list change,  notice  remove :" + r9.getPackageName());
        return;
    L19:
        if (r7.contains(r0.getPackageName()) == false) goto L22;
        PowerHighWarningReceiver.powerHighApps.remove(r0);
        reSendNotification();
        OLog.d("PowerHightNoticeService", "allow bg power high list change,  notice  remove :" + r0.getPackageName());
        return;
    L22:
        OLog.d("PowerHightNoticeService", "allow bg power high list change, but notice not change");
        return;
    }

    private final void reSendNotification() {
        PowerHightNoticeService.Companion r4 = PowerHightNoticeService.Companion;
        Context r0 = SecurityCenterApplication.getContext();
        Intrinsics.checkNotNullExpressionValue(r0, "SecurityCenterApplication.getContext()");
        ArrayList<PowerHighApp> r2 = PowerHighWarningReceiver.powerHighApps;
        Intrinsics.checkNotNullExpressionValue(r2, "PowerHighWarningReceiver.powerHighApps");
        String r5 = r4.getNotificationMessage(r0, r2);
        PowerHightNoticeService.Companion r1 = PowerHightNoticeService.Companion;
        Context r3 = SecurityCenterApplication.getContext();
        Intrinsics.checkNotNullExpressionValue(r3, "SecurityCenterApplication.getContext()");
        String r6 = SecurityCenterApplication.getContext().getString(R.string.power_high_notification_title);
        Intrinsics.checkNotNullExpressionValue(r6, "SecurityCenterApplicatio…_high_notification_title)");
        r1.sendNotification(r3, r6, r5);
    }
}
