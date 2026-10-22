package com.android.settings.applications;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.UserHandle;
import android.text.TextUtils;
import com.android.settings.HandleEventService;
import com.android.settings.SettingsApplication;
import com.android.settings.SettingsInitialize;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Insert;

/* JADX INFO: loaded from: classes2.dex */
public class IconUpdateReceiver extends BroadcastReceiver {
    private static final String ACTION_UPDATE_ICON = "com.bytedanceos.launcher.update_icon";
    private static final String EXTRA_PACKAGENAME = "extra_packagename";

    public static final class Processor {
        private Context mContext;

        public Processor(Context r1) {
            this.mContext = r1;
        }

        public void process(Intent r6) {
            if (IconUpdateReceiver.ACTION_UPDATE_ICON.equals(r6.getAction()) == false) goto L15;
            String r7 = r6.getStringExtra(IconUpdateReceiver.EXTRA_PACKAGENAME);
            int r0 = 0;
            ApplicationsState r5 = ApplicationsState.getInstance((Application) this.mContext.getApplicationContext(), false);
            if (TextUtils.isEmpty(r7) == true) goto L19;
            String[] r8 = r7.split(",");
            int r1 = r8.length;
        L7:
            if (r0 >= r1) goto L20;
            String r2 = r8[r0];
            ApplicationsState.AppEntry r3 = r5.getEntryByUserId(r2, UserHandle.myUserId());
            if (r3 == null) goto L11;
            r3.setDirty(true);
        L11:
            ApplicationsState.AppEntry r4 = r5.getEntryByUserId(r2, UserHandle.myUserId());
            if (r4 == null) goto L14;
            r4.setDirty(true);
        L14:
            r0 = r0 + 1;
            goto L7
        L20:
            return;
        L19:
            return;
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r1, Intent r2) {
        com_android_settings_applications_IconUpdateReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(this, r1, r2);
    }

    public IconUpdateReceiver() {
    }

    public void com_android_settings_applications_IconUpdateReceiver__onReceive$___twin___(Context r2, Intent r3) {
        OLog.d("IconUpdateReceiver", "receive action : " + r3.getAction());
        r3.setClass(r2, HandleEventService.class);
        r3.putExtra("type", 9);
        r2.startService(r3);
    }

    @Insert("onReceive")
    public static void com_android_settings_applications_IconUpdateReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(IconUpdateReceiver r7, Context r8, Intent r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        String[] r0 = {"android.bluetooth.device.action.PAIRING_REQUEST", "android.bluetooth.device.action.BOND_STATE_CHANGED", "com.bytedanceos.launcher.new_message", "intent.provision.import_data", "com.android.settings.action.SHOW_IMPORT_DATA_NOTIFICATION"};
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.content.BroadcastReceiver");
        IconUpdateReceiver r1 = r7;
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
        r7.com_android_settings_applications_IconUpdateReceiver__onReceive$___twin___(r8, r9);
        return;
    L13:
        GrantUtil r11 = GrantUtil.INSTANCE;
        Application r12 = SettingsApplication.getApplication();
        Intrinsics.checkNotNullExpressionValue(r12, "getApplication(...)");
        if (r11.isSetupCompelete(r12) == true) goto L16;
        OLog.i("PrivacyHookForReceiver", "onReceive !isSetupCompeleted hooked for " + r3 + ", " + r2);
        r7.com_android_settings_applications_IconUpdateReceiver__onReceive$___twin___(r8, r9);
        return;
    L16:
        String r13 = r3;
        if (r13 != null) goto L19;
    L22:
        boolean r14 = true;
    L23:
        if (r14 == false) goto L26;
        OLog.i("PrivacyHookForReceiver", "onReceive !simpleName hooked for " + r3 + ", " + r2);
        r7.com_android_settings_applications_IconUpdateReceiver__onReceive$___twin___(r8, r9);
        return;
    L26:
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == true) goto L30;
        if (r4 == true) goto L30;
        OLog.i("PrivacyHookForReceiver", "onReceive !isPrivacyAllowed hooked for " + r3 + ", " + r2);
        return;
    L30:
        GrantUtil.INSTANCE.applicationInit();
        r7.com_android_settings_applications_IconUpdateReceiver__onReceive$___twin___(r8, r9);
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
