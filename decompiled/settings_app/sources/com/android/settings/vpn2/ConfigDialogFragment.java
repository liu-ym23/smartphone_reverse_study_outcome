package com.android.settings.vpn2;

import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.VpnManager;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.UserHandle;
import androidx.fragment.app.DialogFragment;
import com.android.internal.net.LegacyVpnInfo;
import com.android.internal.net.VpnProfile;
import com.android.settings.R;
import com.android.settings.ToastUtils;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class ConfigDialogFragment extends DialogFragment implements DialogInterface.OnClickListener {
    private static final String ARG_EDITING = "editing";
    private static final String ARG_EXISTS = "exists";
    private static final String ARG_PROFILE = "profile";
    private static final String TAG = "ConfigDialogFragment";
    private static final String TAG_CONFIG_DIALOG = "vpnconfigdialog";
    private boolean mUnlocking;
    private VpnManager mVpnManager;

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_vpn2_ConfigDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_vpn2_ConfigDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public ConfigDialogFragment() {
        this.mUnlocking = false;
    }

    public void com_android_settings_vpn2_ConfigDialogFragment__onCreate$___twin___(Bundle r2) {
        super.onCreate(r2);
        this.mVpnManager = (VpnManager) getContext().getSystemService("vpn_management");
    }

    public static void show(VpnSettings r2, VpnProfile r3, boolean r4, boolean r5) {
        if (r2.isAdded() == true) goto L5;
        return;
    L5:
        Bundle r0 = new Bundle();
        r0.putParcelable(ARG_PROFILE, r3);
        r0.putBoolean(ARG_EDITING, r4);
        r0.putBoolean(ARG_EXISTS, r5);
        ConfigDialogFragment r6 = new ConfigDialogFragment();
        r6.setArguments(r0);
        r6.show(r2.getParentFragmentManager(), TAG_CONFIG_DIALOG);
    }

    public void com_android_settings_vpn2_ConfigDialogFragment__onResume$___twin___() {
        super.onResume();
        this.mUnlocking = false;
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle r8) {
        Bundle r9 = getArguments();
        VpnProfile r4 = r9.getParcelable(ARG_PROFILE);
        boolean r5 = r9.getBoolean(ARG_EDITING);
        boolean r6 = r9.getBoolean(ARG_EXISTS);
        return new ConfigDialog(getActivity(), this, r4, r5, r6);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface r3, int r4) {
        ConfigDialog r5 = (ConfigDialog) getDialog();
        VpnProfile r0 = r5.getProfile();
        if (r4 != (-1)) goto L13;
        disconnect(r0);
        if (r5.isEditing() == false) goto L7;
    L15:
        dismiss();
        return;
    L7:
        if (VpnUtils.isVpnLockdown(r0.key) == true) goto L15;
        connect(r0);     // Catch: RemoteException -> L10
    L10:
        e = move-exception;
        OLog.e(TAG, "Failed to connect", e);
        goto L15
    L13:
        if (r4 != (-3)) goto L15;
        disconnect(r0);
        goto L15
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface r1) {
        dismiss();
        super.onCancel(r1);
    }

    private void connect(VpnProfile r2) throws RemoteException {
        this.mVpnManager.startLegacyVpn(r2);     // Catch: IllegalStateException -> L4
        return;
    L4:
        ToastUtils.show(getActivity(), R.string.vpn_no_network);
    }

    private void disconnect(VpnProfile r3) {
        LegacyVpnInfo r0 = this.mVpnManager.getLegacyVpnInfo(UserHandle.myUserId());
        if (r0 != null) goto L5;
        return;
    L5:
        if (r3.key.equals(r0.key) == false) goto L9;
        VpnUtils.clearLockdownVpn(getContext());
        this.mVpnManager.prepareVpn("[Legacy VPN]", "[Legacy VPN]", UserHandle.myUserId());
        return;
    }

    public static void CredentialUnlock(Context r2) {
        r2.startActivity(new Intent("com.android.credentials.UNLOCK"));     // Catch: ActivityNotFoundException -> L4
        return;
    L4:
        e = move-exception;
        OLog.d(TAG, e.toString());
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_vpn2_ConfigDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(ConfigDialogFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_vpn2_ConfigDialogFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_vpn2_ConfigDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(ConfigDialogFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_vpn2_ConfigDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_vpn2_ConfigDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(ConfigDialogFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_vpn2_ConfigDialogFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
