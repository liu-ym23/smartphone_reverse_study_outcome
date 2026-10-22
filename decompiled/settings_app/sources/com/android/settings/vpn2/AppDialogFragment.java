package com.android.settings.vpn2;

import android.app.Dialog;
import android.app.admin.DevicePolicyManager;
import android.content.DialogInterface;
import android.content.pm.PackageInfo;
import android.net.VpnManager;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.UserHandle;
import android.os.UserManager;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import com.android.internal.net.VpnConfig;
import com.android.settings.MultiSDKAdapterNew;
import com.android.settings.R;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class AppDialogFragment extends DialogFragment implements AppDialog.Listener {
    private static final String ARG_CONNECTED = "connected";
    private static final String ARG_LABEL = "label";
    private static final String ARG_MANAGING = "managing";
    private static final String ARG_PACKAGE = "package";
    private static final String TAG = "AppDialogFragment";
    private static final String TAG_APP_DIALOG = "vpnappdialog";
    private DevicePolicyManager mDevicePolicyManager;
    private Listener mListener;
    private PackageInfo mPackageInfo;
    private UserManager mUserManager;
    private VpnManager mVpnManager;

    public interface Listener {
        void onCancel();

        void onForget();
    }

    public void com_android_settings_vpn2_AppDialogFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_vpn2_AppDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_vpn2_AppDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public AppDialogFragment() {
    }

    static /* synthetic */ void access$000(AppDialogFragment r0, DialogInterface r1) {
        r0.onDisconnect(r1);
    }

    public static void show(Fragment r6, PackageInfo r7, String r8, boolean r9, boolean r10) {
        show(r6, null, r7, r8, r9, r10);
    }

    public static void show(Fragment r2, Listener r3, PackageInfo r4, String r5, boolean r6, boolean r7) {
        if (r2.isAdded() == true) goto L5;
        return;
    L5:
        Bundle r0 = new Bundle();
        r0.putParcelable("package", r4);
        r0.putString("label", r5);
        r0.putBoolean(ARG_MANAGING, r6);
        r0.putBoolean(ARG_CONNECTED, r7);
        AppDialogFragment r8 = new AppDialogFragment();
        r8.mListener = r3;
        r8.setArguments(r0);
        r8.setTargetFragment(r2, 0);
        r8.show(r2.getParentFragmentManager(), TAG_APP_DIALOG);
    }

    public void com_android_settings_vpn2_AppDialogFragment__onCreate$___twin___(Bundle r3) {
        super.onCreate(r3);
        this.mPackageInfo = (PackageInfo) getArguments().getParcelable("package");
        this.mUserManager = UserManager.get(getContext());
        this.mDevicePolicyManager = (DevicePolicyManager) getContext().createContextAsUser(UserHandle.of(getUserId()), 0).getSystemService(DevicePolicyManager.class);
        this.mVpnManager = (VpnManager) getContext().getSystemService("vpn_management");
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle r4) {
        Bundle r5 = getArguments();
        String r0 = r5.getString("label");
        boolean r1 = r5.getBoolean(ARG_MANAGING);
        boolean r6 = r5.getBoolean(ARG_CONNECTED);
        if (r1 == true) goto L5;
        OAlertDialogBuilder r2 = new OAlertDialogBuilder(getActivity()).horizontalButton().title(r0, false).message(R.string.vpn_disconnect_prompt).negativeButton(R.string.cancel, new AnonymousClass1(this));
        if (r6 == false) goto L14;
        if (this.mPackageInfo == null) goto L14;
        if (isUiRestricted() == true) goto L14;
        r2.positiveButton(R.string.vpn_disconnect, new AnonymousClass2(this));
    L14:
        return r2.build();
    L5:
        return new AppDialog(getActivity(), this, this.mPackageInfo, r0);
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface r2) {
        dismissAllowingStateLoss();
        Listener r0 = this.mListener;
        if (r0 == null) goto L5;
        r0.onCancel();
    L5:
        super.onCancel(r2);
    }

    @Override // com.android.settings.vpn2.AppDialog.Listener
    public void onForget(DialogInterface r5) {
        if (isUiRestricted() == false) goto L5;
        return;
    L5:
        int r0 = getUserId();
        this.mVpnManager.setVpnPackageAuthorization(this.mPackageInfo.packageName, r0, -1);
        onDisconnect(r5);
        Listener r4 = this.mListener;
        if (r4 == null) goto L9;
        r4.onForget();
        return;
    }

    private void onDisconnect(DialogInterface r4) {
        if (isUiRestricted() == false) goto L5;
        return;
    L5:
        int r5 = getUserId();
    L10:
        e = move-exception;
        OLog.e(TAG, "Failed to disconnect package " + this.mPackageInfo.packageName + " for user " + r5, e);
        return;
    L7:
        if (this.mPackageInfo.packageName.equals(getConnectedPackage(this.mVpnManager, r5)) == false) goto L15;
        MultiSDKAdapterNew.setAlwaysOnVpnPackage(this.mVpnManager, r5, null, false, null);     // Catch: RemoteException -> L10
        this.mVpnManager.prepareVpn(this.mPackageInfo.packageName, "[Legacy VPN]", r5);     // Catch: RemoteException -> L10
        return;
    }

    private boolean isUiRestricted() {
        UserHandle r0 = UserHandle.of(getUserId());
        if (this.mUserManager.hasUserRestriction("no_config_vpn", r0) == false) goto L7;
        return true;
    L7:
        return this.mPackageInfo.packageName.equals(this.mDevicePolicyManager.getAlwaysOnVpnPackage());
    }

    private int getUserId() {
        return UserHandle.getUserId(this.mPackageInfo.applicationInfo.uid);
    }

    private static String getConnectedPackage(VpnManager r0, int r1) throws RemoteException {
        VpnConfig r2 = r0.getVpnConfig(r1);
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.user;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_vpn2_AppDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(AppDialogFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_vpn2_AppDialogFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_vpn2_AppDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(AppDialogFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_vpn2_AppDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_vpn2_AppDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(AppDialogFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_vpn2_AppDialogFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
