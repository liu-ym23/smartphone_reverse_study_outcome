package com.android.settings.wifi;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import com.android.settings.R;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class NetworkRequestSingleSsidDialogFragment extends DialogFragment {
    public static final String EXTRA_APP_NAME = "DIALOG_REQUEST_APP_NAME";
    public static final String EXTRA_SSID = "DIALOG_REQUEST_SSID";
    public static final String EXTRA_TRYAGAIN = "DIALOG_IS_TRYAGAIN";
    NetworkRequestDialogActivity mActivity;
    private Callback mCallback;
    private OAlertDialog mDialog;

    public interface Callback {
        void onClickConnectButton();

        void onFinish();
    }

    public void com_android_settings_wifi_NetworkRequestSingleSsidDialogFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_wifi_NetworkRequestSingleSsidDialogFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_wifi_NetworkRequestSingleSsidDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_wifi_NetworkRequestSingleSsidDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public NetworkRequestSingleSsidDialogFragment() {
        this.mActivity = null;
        this.mDialog = null;
        this.mCallback = null;
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle r7) {
        String r2 = "";
        if (getArguments() == null) goto L5;
        boolean r8 = getArguments().getBoolean(EXTRA_TRYAGAIN, true);
        String r3 = getArguments().getString(EXTRA_SSID, "");
        r2 = getArguments().getString("DIALOG_REQUEST_APP_NAME", "");
    L6:
        OAlertDialogBuilder r0 = new OAlertDialogBuilder(getContext()).autoDismiss(false).horizontalButton().title(R.string.network_connection_request_dialog_title).message(getString(R.string.network_connection_request_dialog_summary, new Object[]{r2}) + "\n" + r3).negativeButton(R.string.cancel, new NetworkRequestSingleSsidDialogFragment$$ExternalSyntheticLambda0(this));
        if (r8 == false) goto L9;
        int r9 = R.string.network_connection_timeout_dialog_ok;
    L10:
        OAlertDialog r10 = r0.positiveButton(r9, new NetworkRequestSingleSsidDialogFragment$$ExternalSyntheticLambda1(this)).createDialog();
        this.mDialog = r10;
        return r10;
    L9:
        r9 = R.string.wifi_connect;
        goto L10
    L5:
        r8 = false;
        r3 = "";
        goto L6
    }

    /* JADX INFO: renamed from: lambda$onCreateDialog$0$com-android-settings-wifi-NetworkRequestSingleSsidDialogFragment, reason: not valid java name */
    /* synthetic */ void m673x4043e26c(DialogInterface r1, int r2) {
        r1.dismiss();
        Callback r0 = this.mCallback;
        if (r0 == null) goto L6;
        r0.onFinish();
        return;
    }

    /* JADX INFO: renamed from: lambda$onCreateDialog$1$com-android-settings-wifi-NetworkRequestSingleSsidDialogFragment, reason: not valid java name */
    /* synthetic */ void m674xaa736a8b(DialogInterface r1, int r2) {
        r1.dismiss();
        onUserClickConnectButton();
    }

    private void onUserClickConnectButton() {
        Callback r0 = this.mCallback;
        if (r0 == null) goto L6;
        r0.onClickConnectButton();
        return;
    }

    public void setCallback(Callback r1) {
        this.mCallback = r1;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_wifi_NetworkRequestSingleSsidDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(NetworkRequestSingleSsidDialogFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_wifi_NetworkRequestSingleSsidDialogFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_wifi_NetworkRequestSingleSsidDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(NetworkRequestSingleSsidDialogFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_wifi_NetworkRequestSingleSsidDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_wifi_NetworkRequestSingleSsidDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(NetworkRequestSingleSsidDialogFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_wifi_NetworkRequestSingleSsidDialogFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
