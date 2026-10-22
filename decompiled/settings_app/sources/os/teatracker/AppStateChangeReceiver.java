package os.teatracker;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.android.settings.SettingsApplication;
import com.android.settings.SettingsInitialize;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Insert;

/* JADX INFO: loaded from: classes6.dex */
public class AppStateChangeReceiver extends BroadcastReceiver {
    private Gson gsonBuilder;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r1, Intent r2) {
        os_teatracker_AppStateChangeReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(this, r1, r2);
    }

    public AppStateChangeReceiver() {
    }

    public void os_teatracker_AppStateChangeReceiver__onReceive$___twin___(Context context, Intent intent) {
        if (this.gsonBuilder != null) goto L5;
        this.gsonBuilder = new GsonBuilder().create();
    L5:
        if (intent != null) goto L7;
        return;
    L7:
        if (TeaHandler.getTeaHandler().getAppStateListener() == null) goto L18;
        AppState r2 = (AppState) this.gsonBuilder.fromJson(intent.getStringExtra(TeaConst.APP_STATE_PARAMS), AppState.class);     // Catch: Exception -> L12
        if (r2 == null) goto L19;
        r2.setParams(intent.getStringExtra(TeaConst.APP_STATE_PARAMS));     // Catch: Exception -> L12
        TeaHandler.getTeaHandler().getAppStateListener().onGetAppState(r2);     // Catch: Exception -> L12
        return;
    L19:
        return;
    L12:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    @Insert("onReceive")
    public static void os_teatracker_AppStateChangeReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(AppStateChangeReceiver r7, Context r8, Intent r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        String[] r0 = {"android.bluetooth.device.action.PAIRING_REQUEST", "android.bluetooth.device.action.BOND_STATE_CHANGED", "com.bytedanceos.launcher.new_message", "intent.provision.import_data", "com.android.settings.action.SHOW_IMPORT_DATA_NOTIFICATION"};
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.content.BroadcastReceiver");
        AppStateChangeReceiver r1 = r7;
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
        r7.os_teatracker_AppStateChangeReceiver__onReceive$___twin___(r8, r9);
        return;
    L13:
        GrantUtil r11 = GrantUtil.INSTANCE;
        Application r12 = SettingsApplication.getApplication();
        Intrinsics.checkNotNullExpressionValue(r12, "getApplication(...)");
        if (r11.isSetupCompelete(r12) == true) goto L16;
        OLog.i("PrivacyHookForReceiver", "onReceive !isSetupCompeleted hooked for " + r3 + ", " + r2);
        r7.os_teatracker_AppStateChangeReceiver__onReceive$___twin___(r8, r9);
        return;
    L16:
        String r13 = r3;
        if (r13 != null) goto L19;
    L22:
        boolean r14 = true;
    L23:
        if (r14 == false) goto L26;
        OLog.i("PrivacyHookForReceiver", "onReceive !simpleName hooked for " + r3 + ", " + r2);
        r7.os_teatracker_AppStateChangeReceiver__onReceive$___twin___(r8, r9);
        return;
    L26:
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == true) goto L30;
        if (r4 == true) goto L30;
        OLog.i("PrivacyHookForReceiver", "onReceive !isPrivacyAllowed hooked for " + r3 + ", " + r2);
        return;
    L30:
        GrantUtil.INSTANCE.applicationInit();
        r7.os_teatracker_AppStateChangeReceiver__onReceive$___twin___(r8, r9);
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
