package com.android.settings.fingerprint;

import android.content.ContentResolver;
import android.hardware.fingerprint.Fingerprint;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.android.settings.InvisibleApi;
import com.android.settings.R;
import com.android.settings.SettingsFeature;
import com.android.settings.Utils;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.SettingItemCheck;

/* JADX INFO: loaded from: classes2.dex */
public class FingerprintSetupForPaymentFragment extends BaseFragment implements View.OnClickListener {
    public static final String EXTRA_FINGERPRINT_ID = "extra_fingerprint_id";
    private SettingItemCheck mPaymentAlipay;
    private SettingItemCheck mPaymentUndefined;
    private SettingItemCheck mPaymentWechat;
    private String mSelectedPaymentWay;
    private int mTargetFingerprintID;

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_fingerprint_FingerprintSetupForPaymentFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_fingerprint_FingerprintSetupForPaymentFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public FingerprintSetupForPaymentFragment() {
        this.mTargetFingerprintID = -1;
    }

    public void com_android_settings_fingerprint_FingerprintSetupForPaymentFragment__onCreate$___twin___(Bundle r3) {
        super.onCreate(r3);
        int r0 = -1;
        if (getIntent() == null) goto L6;
        r0 = getIntent().getIntExtra(EXTRA_FINGERPRINT_ID, -1);
    L6:
        this.mTargetFingerprintID = r0;
        OLog.d(this.TAG, "target fingerprint ID = " + this.mTargetFingerprintID);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.mRootView = r2.inflate(R.layout.fragment_fingerprint_setup_payment, r3, false);
        this.mPaymentUndefined = (SettingItemCheck) findViewByIdNullable(R.id.payment_undefined);
        this.mPaymentAlipay = (SettingItemCheck) findViewByIdNullable(R.id.payment_alipay);
        this.mPaymentWechat = (SettingItemCheck) findViewByIdNullable(R.id.payment_wechat);
        this.mPaymentUndefined.setTitle(R.string.undefined);
        this.mPaymentAlipay.setIcon(R.drawable.pay_alipay);
        this.mPaymentWechat.setIcon(R.drawable.pay_wechat);
        this.mPaymentUndefined.setTag(null);
        this.mPaymentAlipay.setTag("com.eg.android.AlipayGphone");
        this.mPaymentWechat.setTag("com.tencent.mm");
        this.mPaymentUndefined.setOnClickListener(this);
        this.mPaymentAlipay.setOnClickListener(this);
        this.mPaymentWechat.setOnClickListener(this);
        findViewByIdNullable(R.id.btn_done).setOnClickListener(this);
        return this.mRootView;
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r1, Bundle r2) {
        super.onViewCreated(r1, r2);
        if (this.mTargetFingerprintID != (-1)) goto L6;
        OLog.e(this.TAG, "a target fingerprint ID required");
        finish();
        return;
    L6:
        updateItemCheckViewState();
    }

    public void com_android_settings_fingerprint_FingerprintSetupForPaymentFragment__onResume$___twin___() {
        super.onResume();
        if (this.mTargetFingerprintID != (-1)) goto L6;
        OLog.e(this.TAG, "a target fingerprint ID required");
        finish();
        return;
    L6:
        updateItemCheckViewState();
    }

    private void updateItemCheckViewState() {
        String r0 = getCurrentPaymentWay();
        SettingItemCheck r1 = this.mPaymentUndefined;
        if (r0 != null) goto L5;
        boolean r4 = true;
    L6:
        r1.setChecked(r4);
        SettingItemCheck r2 = this.mPaymentAlipay;
        if (r0 != null) goto L9;
    L11:
        boolean r5 = false;
    L12:
        r2.setChecked(r5);
        SettingItemCheck r3 = this.mPaymentWechat;
        if (r0 != null) goto L15;
    L17:
        boolean r6 = false;
    L18:
        r3.setChecked(r6);
        if (SettingsFeature.isAliPayAvailable(this.mContext) == false) goto L24;
        CharSequence r7 = getPaymentSettedFingerprintName("com.eg.android.AlipayGphone");
        if (r7 == null) goto L23;
        this.mPaymentAlipay.setEnabled(false);
        this.mPaymentAlipay.setTitle(String.format(getString(R.string.pay_via_alipay) + "（%1$s）", new Object[]{r7}));
    L26:
        if (SettingsFeature.isWeChatPayAvailable(this.mContext) == false) goto L32;
        CharSequence r8 = getPaymentSettedFingerprintName("com.tencent.mm");
        if (r8 == null) goto L30;
        this.mPaymentWechat.setEnabled(false);
        this.mPaymentWechat.setTitle(String.format(getString(R.string.pay_via_wechat) + "（%1$s）", new Object[]{r8}));
        return;
    L30:
        this.mPaymentWechat.setEnabled(true);
        this.mPaymentWechat.setTitle(R.string.pay_via_wechat);
        return;
    L32:
        if (Utils.isPackageInstalled(this.mContext, "com.tencent.mm") == false) goto L34;
        String r9 = getString(R.string.need_update_tips);
    L35:
        this.mPaymentWechat.setEnabled(false);
        this.mPaymentWechat.setTitle(String.format(getString(R.string.pay_via_wechat) + "（%1$s）", new Object[]{r9}));
        return;
    L34:
        r9 = getString(R.string.pico_not_installed);
        goto L35
    L23:
        this.mPaymentAlipay.setEnabled(true);
        this.mPaymentAlipay.setTitle(R.string.pay_via_alipay);
        goto L26
    L24:
        this.mPaymentAlipay.setEnabled(false);
        this.mPaymentAlipay.setTitle(String.format(getString(R.string.pay_via_alipay) + "（%1$s）", new Object[]{getString(R.string.pico_not_installed)}));
        goto L26
    L15:
        if (r0.contains("com.tencent.mm") == false) goto L17;
        r6 = true;
        goto L18
    L9:
        if (r0.contains("com.eg.android.AlipayGphone") == false) goto L11;
        r5 = true;
        goto L12
    L5:
        r4 = false;
        goto L6
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r5) {
        if (r5 != this.mPaymentUndefined) goto L5;
    L12:
        this.mSelectedPaymentWay = (String) r5.getTag();
        SettingItemCheck r0 = this.mPaymentUndefined;
        boolean r1 = true;
        if (r5 != r0) goto L15;
        boolean r3 = true;
    L16:
        r0.setChecked(r3);
        SettingItemCheck r2 = this.mPaymentAlipay;
        if (r5 != r2) goto L19;
        boolean r4 = true;
    L20:
        r2.setChecked(r4);
        SettingItemCheck r6 = this.mPaymentWechat;
        if (r5 == r6) goto L24;
        r1 = false;
    L24:
        r6.setChecked(r1);
        return;
    L19:
        r4 = false;
        goto L20
    L15:
        r3 = false;
        goto L16
    L5:
        if (r5 == this.mPaymentAlipay) goto L12;
        if (r5 == this.mPaymentWechat) goto L12;
        if (r5.getId() != R.id.btn_done) goto L26;
        savePaymentWay(this.mSelectedPaymentWay);
        finish();
        return;
    }

    private void savePaymentWay(String r4) {
        OLog.d(this.TAG, "save payment way for : " + this.mTargetFingerprintID + " = " + r4);
        if (isCurrentPayment(r4) == false) goto L5;
        return;
    L5:
        String r0 = makePaymentFingerprintSettingKey(this.mTargetFingerprintID);
        ContentResolver r3 = getContentResolver();
        if (r4 != null) goto L8;
        String r5 = null;
    L9:
        Settings.Global.putString(r3, r0, r5);
        return;
    L8:
        r5 = "payment/" + r4;
        goto L9
    }

    private boolean isCurrentPayment(String r3) {
        String r2 = getCurrentPaymentWay();
        if (r3 != null) goto L6;
        if (r2 != null) goto L11;
        return true;
    L11:
        return false;
    L6:
        if (r2 == null) goto L11;
        if (r2.contains(r3) == false) goto L11;
        return true;
    }

    private String getCurrentPaymentWay() {
        return Settings.Global.getString(getContentResolver(), makePaymentFingerprintSettingKey(this.mTargetFingerprintID));
    }

    private CharSequence getPaymentSettedFingerprintName(String r6) {
        List r0 = ((FingerprintManager) getSystemService("fingerprint")).getEnrolledFingerprints();
        if (r0 != null) goto L5;
    L16:
        return null;
    L5:
        if (r0.isEmpty() == true) goto L16;
        Iterator r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L16;
        Fingerprint r2 = (Fingerprint) r1.next();
        String r3 = makePaymentFingerprintSettingKey(InvisibleApi.getFingerId(r2));
        String r4 = Settings.Global.getString(getContentResolver(), r3);
        if (r4 == null) goto L9;
        if (r4.contains(r6) == false) goto L9;
        return r2.getName();
    }

    private static String makePaymentFingerprintSettingKey(int r2) {
        return "quick_app_via_fingerprint_id_" + r2;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_fingerprint_FingerprintSetupForPaymentFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(FingerprintSetupForPaymentFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_fingerprint_FingerprintSetupForPaymentFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_fingerprint_FingerprintSetupForPaymentFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(FingerprintSetupForPaymentFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_fingerprint_FingerprintSetupForPaymentFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_fingerprint_FingerprintSetupForPaymentFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(FingerprintSetupForPaymentFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_fingerprint_FingerprintSetupForPaymentFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
