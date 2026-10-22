package com.bytedance.common.wschannel.server;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.android.settings.SettingsApplication;
import com.android.settings.SettingsInitialize;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.bytedance.common.wschannel.WsChannelSettings;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Insert;

/* JADX INFO: loaded from: classes3.dex */
public class WsChannelReceiver extends BroadcastReceiver {
    private static boolean sFrontierEnabled = false;
    private boolean mIsFirstTimeReceiveNetChangedAction;
    private ChannelManager mManager;
    private NetworkUtils.NetworkType mOnCreateNetworkType;

    static {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r1, Intent r2) {
        com_bytedance_common_wschannel_server_WsChannelReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(this, r1, r2);
    }

    static /* synthetic */ void access$000(WsChannelReceiver r0, Context r1) {
        r0.loadFrontierEnabled(r1);
    }

    static /* synthetic */ boolean access$100() {
        return sFrontierEnabled;
    }

    static /* synthetic */ ChannelManager access$200(WsChannelReceiver r0) {
        return r0.mManager;
    }

    @Deprecated
    public WsChannelReceiver() {
        this.mIsFirstTimeReceiveNetChangedAction = true;
    }

    public WsChannelReceiver(Context r2, ChannelManager r3) {
        this.mIsFirstTimeReceiveNetChangedAction = true;
        this.mOnCreateNetworkType = NetworkUtils.getNetworkType(r2);
        this.mManager = r3;
    }

    public void com_bytedance_common_wschannel_server_WsChannelReceiver__onReceive$___twin___(final Context r2, Intent r3) {
        if (r2 == null) goto L20;
        if (r3 != null) goto L5;
        return;
    L5:
        if (this.mManager != null) goto L8;
        return;
    L8:
        if (TextUtils.isEmpty(r3.getAction()) == false) goto L11;
        return;
    L11:
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(r3.getAction()) == true) goto L14;
        return;
    L14:
        if (this.mIsFirstTimeReceiveNetChangedAction == false) goto L18;
        this.mIsFirstTimeReceiveNetChangedAction = false;
        if (NetworkUtils.getNetworkType(r2) != this.mOnCreateNetworkType) goto L18;
        return;
    L18:
        ThreadPlus.submitRunnable(new AnonymousClass1(this, r2));
        return;
    }

    private void loadFrontierEnabled(Context r1) {
        boolean r0 = WsChannelSettings.inst(r1).isEnable();     // Catch: Throwable -> L6
        if (r0 == sFrontierEnabled) goto L9;
        sFrontierEnabled = r0;     // Catch: Throwable -> L6
        return;
    L9:
        return;
    }

    @Insert("onReceive")
    public static void com_bytedance_common_wschannel_server_WsChannelReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(WsChannelReceiver r7, Context r8, Intent r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        String[] r0 = {"android.bluetooth.device.action.PAIRING_REQUEST", "android.bluetooth.device.action.BOND_STATE_CHANGED", "com.bytedanceos.launcher.new_message", "intent.provision.import_data", "com.android.settings.action.SHOW_IMPORT_DATA_NOTIFICATION"};
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.content.BroadcastReceiver");
        WsChannelReceiver r1 = r7;
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
        r7.com_bytedance_common_wschannel_server_WsChannelReceiver__onReceive$___twin___(r8, r9);
        return;
    L13:
        GrantUtil r11 = GrantUtil.INSTANCE;
        Application r12 = SettingsApplication.getApplication();
        Intrinsics.checkNotNullExpressionValue(r12, "getApplication(...)");
        if (r11.isSetupCompelete(r12) == true) goto L16;
        OLog.i("PrivacyHookForReceiver", "onReceive !isSetupCompeleted hooked for " + r3 + ", " + r2);
        r7.com_bytedance_common_wschannel_server_WsChannelReceiver__onReceive$___twin___(r8, r9);
        return;
    L16:
        String r13 = r3;
        if (r13 != null) goto L19;
    L22:
        boolean r14 = true;
    L23:
        if (r14 == false) goto L26;
        OLog.i("PrivacyHookForReceiver", "onReceive !simpleName hooked for " + r3 + ", " + r2);
        r7.com_bytedance_common_wschannel_server_WsChannelReceiver__onReceive$___twin___(r8, r9);
        return;
    L26:
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == true) goto L30;
        if (r4 == true) goto L30;
        OLog.i("PrivacyHookForReceiver", "onReceive !isPrivacyAllowed hooked for " + r3 + ", " + r2);
        return;
    L30:
        GrantUtil.INSTANCE.applicationInit();
        r7.com_bytedance_common_wschannel_server_WsChannelReceiver__onReceive$___twin___(r8, r9);
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
