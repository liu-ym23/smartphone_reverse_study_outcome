package com.android.settings;

import android.app.AlertDialog;
import android.app.admin.DevicePolicyManager;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.UserHandle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.android.internal.widget.LockscreenCredential;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.widget.SettingItemButton;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class CryptKeeperSettings extends BaseFragment {
    private static final int KEYGUARD_REQUEST = 55;
    private static final int MIN_BATTERY_LEVEL = 80;
    static final int MIN_PASSWORD_QUALITY = 131072;
    private static final String PASSWORD = "password";
    private static final String TAG = "CryptKeeper";
    private static final String TYPE = "type";
    private AlertDialog mConfirmDialog;
    private SettingItemButton mInitiateButton;
    private View.OnClickListener mInitiateListener;
    private IntentFilter mIntentFilter;
    private BroadcastReceiver mIntentReceiver;
    private TextView mNeedLockscreenWarning;
    private TextView mPowerWarning;

    public void com_android_settings_CryptKeeperSettings__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_CryptKeeperSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_CryptKeeperSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public CryptKeeperSettings() {
        this.mIntentReceiver = new AnonymousClass1(this);
        this.mInitiateListener = new AnonymousClass2(this);
    }

    static /* synthetic */ SettingItemButton access$000(CryptKeeperSettings r0) {
        return r0.mInitiateButton;
    }

    static /* synthetic */ TextView access$100(CryptKeeperSettings r0) {
        return r0.mNeedLockscreenWarning;
    }

    static /* synthetic */ TextView access$200(CryptKeeperSettings r0) {
        return r0.mPowerWarning;
    }

    static /* synthetic */ AlertDialog access$300(CryptKeeperSettings r0) {
        return r0.mConfirmDialog;
    }

    static /* synthetic */ boolean access$400(CryptKeeperSettings r0, int r1) {
        return r0.runKeyguardConfirmation(r1);
    }

    static /* synthetic */ void access$500(CryptKeeperSettings r0, int r1, LockscreenCredential r2) {
        r0.finalConfirm(r1, r2);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        this.mRootView = r1.inflate(R.layout.crypt_keeper_settings, null);
        IntentFilter r4 = new IntentFilter();
        this.mIntentFilter = r4;
        r4.addAction("android.intent.action.BATTERY_CHANGED");
        SettingItemButton r5 = (SettingItemButton) this.mRootView.findViewById(R.id.initiate_encrypt);
        this.mInitiateButton = r5;
        r5.setOnClickListener(this.mInitiateListener);
        this.mInitiateButton.setEnabled(false);
        if (Utils.isExperienceVersion() == false) goto L5;
        this.mInitiateButton.setOnDisabledClickListener(new AnonymousClass3(this));
    L5:
        this.mPowerWarning = (TextView) this.mRootView.findViewById(R.id.warning_unplugged);
        this.mNeedLockscreenWarning = (TextView) this.mRootView.findViewById(R.id.tip_warning_need_lock_screen);
        return this.mRootView;
    }

    public void com_android_settings_CryptKeeperSettings__onResume$___twin___() {
        super.onResume();
        registerReceiver(this.mIntentReceiver, this.mIntentFilter);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        unregisterReceiver(this.mIntentReceiver);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle r2) {
        super.onActivityCreated(r2);
        FragmentActivity r1 = getActivity();
        if ("android.app.action.START_ENCRYPTION".equals(r1.getIntent().getAction()) == false) goto L10;
        DevicePolicyManager r3 = (DevicePolicyManager) r1.getSystemService("device_policy");
        if (r3 != null) goto L7;
        return;
    L7:
        if (r3.getStorageEncryptionStatus() == 1) goto L12;
        r1.finish();
        return;
    L12:
        return;
    }

    private boolean runKeyguardConfirmation(int r5) {
        Resources r0 = getActivity().getResources();
        ChooseLockSettingsHelper r1 = new ChooseLockSettingsHelper(getActivity(), this);
        if (r1.utils().getKeyguardStoredPasswordQuality(UserHandle.myUserId()) != 0) goto L7;
        showFinalConfirmation(1, LockscreenCredential.createNone());
        return true;
    L7:
        return r1.launchConfirmationActivity(r5, r0.getText(R.string.crypt_keeper_encrypt_title), true, 2);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int r2, int r3, Intent r4) {
        super.onActivityResult(r2, r3, r4);
        if (r2 == 55) goto L6;
        return;
    L6:
        if (r3 != (-1)) goto L17;
        if (r4 == null) goto L18;
        int r5 = r4.getIntExtra("type", -1);
        if (r4.hasExtra("password") == false) goto L15;
        LockscreenCredential r6 = (LockscreenCredential) r4.getParcelableExtra("password");
        if (r6 != null) goto L13;
        return;
    L13:
        if (r6.isNone() == true) goto L20;
        showFinalConfirmation(r5, r6);
        return;
    L20:
        return;
    L15:
        OLog.e(TAG, "don't have EXTRA_KEY_PASSWORD");
        return;
    L18:
        return;
    }

    private void showFinalConfirmation(final int r3, final LockscreenCredential r4) {
        if (this.mConfirmDialog != null) goto L5;
        this.mConfirmDialog = new AlertDialog.Builder(getActivity()).setTitle(R.string.encrypt_warning_title).setMessage(R.string.crypt_keeper_final_desc).setPositiveButton(R.string.crypt_keeper_settings_title, new AnonymousClass4(this, r3, r4)).setNegativeButton(R.string.cancel, null).create();
    L5:
        new Handler().post(new AnonymousClass5(this));
    }

    private void finalConfirm(int r4, LockscreenCredential r5) {
        if (Utils.isMonkeyRunning() == false) goto L5;
        return;
    L5:
        Intent r0 = new Intent(getActivity(), CryptKeeperConfirm.Blank.class);
        r0.putExtra("type", r4);
        r0.putExtra("password", r5);
        startActivity(r0);
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_CryptKeeperSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(CryptKeeperSettings r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_CryptKeeperSettings__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_CryptKeeperSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(CryptKeeperSettings r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_CryptKeeperSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_CryptKeeperSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(CryptKeeperSettings r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_CryptKeeperSettings__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
