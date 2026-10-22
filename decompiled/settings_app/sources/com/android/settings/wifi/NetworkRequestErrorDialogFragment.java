package com.android.settings.wifi;

import android.app.Dialog;
import android.content.DialogInterface;
import android.net.wifi.WifiManager;
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
public class NetworkRequestErrorDialogFragment extends DialogFragment {
    public static final String DIALOG_TYPE = "DIALOG_ERROR_TYPE";
    private OAlertDialog mDialog;
    private WifiManager.NetworkRequestUserSelectionCallback mRejectCallback;

    public static final enum ERROR_DIALOG_TYPE extends Enum<ERROR_DIALOG_TYPE> {
        private static final /* synthetic */ ERROR_DIALOG_TYPE[] $VALUES = null;
        public static final ERROR_DIALOG_TYPE ABORT = null;
        public static final ERROR_DIALOG_TYPE TIME_OUT = null;

        private static /* synthetic */ ERROR_DIALOG_TYPE[] $values() {
            return new ERROR_DIALOG_TYPE[]{TIME_OUT, ABORT};
        }

        static {
            TIME_OUT = new ERROR_DIALOG_TYPE("TIME_OUT", 0);
            ABORT = new ERROR_DIALOG_TYPE("ABORT", 1);
            $VALUES = $values();
        }

        private ERROR_DIALOG_TYPE(String r1, int r2) {
            super(r1, r2);
        }

        public static ERROR_DIALOG_TYPE valueOf(String r1) {
            return (ERROR_DIALOG_TYPE) Enum.valueOf(ERROR_DIALOG_TYPE.class, r1);
        }

        public static ERROR_DIALOG_TYPE[] values() {
            return (ERROR_DIALOG_TYPE[]) $VALUES.clone();
        }
    }

    public void com_android_settings_wifi_NetworkRequestErrorDialogFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_wifi_NetworkRequestErrorDialogFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_wifi_NetworkRequestErrorDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_wifi_NetworkRequestErrorDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public NetworkRequestErrorDialogFragment() {
    }

    public static NetworkRequestErrorDialogFragment newInstance() {
        return new NetworkRequestErrorDialogFragment();
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface r1) {
        super.onCancel(r1);
        rejectNetworkRequestAndFinish();
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle r4) {
        ERROR_DIALOG_TYPE r5 = ERROR_DIALOG_TYPE.TIME_OUT;
        if (getArguments() == null) goto L6;
        r5 = (ERROR_DIALOG_TYPE) getArguments().getSerializable(DIALOG_TYPE);
    L6:
        if (r5 != ERROR_DIALOG_TYPE.TIME_OUT) goto L8;
        this.mDialog = new OAlertDialogBuilder(getContext()).autoDismiss(false).horizontalButton().title(R.string.network_connection_request_dialog_title).message(R.string.network_connection_timeout_dialog_message).negativeButton(R.string.cancel, new NetworkRequestErrorDialogFragment$$ExternalSyntheticLambda0(this)).positiveButton(R.string.network_connection_timeout_dialog_ok, new NetworkRequestErrorDialogFragment$$ExternalSyntheticLambda1(this)).createDialog();
    L10:
        return this.mDialog;
    L8:
        this.mDialog = new OAlertDialogBuilder(getContext()).autoDismiss(false).horizontalButton().title(R.string.network_connection_request_dialog_title).message(R.string.network_connection_errorstate_dialog_message).positiveButton(R.string.okay, new NetworkRequestErrorDialogFragment$$ExternalSyntheticLambda2(this)).createDialog();
        goto L10
    }

    /* JADX INFO: renamed from: lambda$onCreateDialog$0$com-android-settings-wifi-NetworkRequestErrorDialogFragment, reason: not valid java name */
    /* synthetic */ void m670x1b276d4f(DialogInterface r1, int r2) {
        r1.dismiss();
        rejectNetworkRequestAndFinish();
    }

    /* JADX INFO: renamed from: lambda$onCreateDialog$1$com-android-settings-wifi-NetworkRequestErrorDialogFragment, reason: not valid java name */
    /* synthetic */ void m671xd59d0dd0(DialogInterface r1, int r2) {
        r1.dismiss();
        onRescanClick();
    }

    /* JADX INFO: renamed from: lambda$onCreateDialog$2$com-android-settings-wifi-NetworkRequestErrorDialogFragment, reason: not valid java name */
    /* synthetic */ void m672x9012ae51(DialogInterface r1, int r2) {
        r1.dismiss();
        rejectNetworkRequestAndFinish();
    }

    public void setRejectCallback(WifiManager.NetworkRequestUserSelectionCallback r1) {
        this.mRejectCallback = r1;
    }

    protected void onRescanClick() {
        if (getActivity() == null) goto L6;
        dismiss();
        ((NetworkRequestDialogActivity) getActivity()).onClickRescanButton();
        return;
    }

    private void rejectNetworkRequestAndFinish() {
        if (getActivity() == null) goto L9;
        WifiManager.NetworkRequestUserSelectionCallback r0 = this.mRejectCallback;
        if (r0 == null) goto L7;
        r0.reject();
    L7:
        getActivity().finish();
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_wifi_NetworkRequestErrorDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(NetworkRequestErrorDialogFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_wifi_NetworkRequestErrorDialogFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_wifi_NetworkRequestErrorDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(NetworkRequestErrorDialogFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_wifi_NetworkRequestErrorDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_wifi_NetworkRequestErrorDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(NetworkRequestErrorDialogFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_wifi_NetworkRequestErrorDialogFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
