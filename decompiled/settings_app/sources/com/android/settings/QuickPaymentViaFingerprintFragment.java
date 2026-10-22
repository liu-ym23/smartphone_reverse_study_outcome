package com.android.settings;

import android.hardware.fingerprint.Fingerprint;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.NullSafe;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.SettingItemText;

/* JADX INFO: loaded from: classes2.dex */
public class QuickPaymentViaFingerprintFragment extends BaseFragment implements View.OnClickListener {
    private SettingItemText mAlipayView;
    private List<Fingerprint> mFingerprintList;
    private FingerprintManager mFingerprintManager;
    private SettingItemText mWechatPayView;

    public void com_android_settings_QuickPaymentViaFingerprintFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_QuickPaymentViaFingerprintFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_QuickPaymentViaFingerprintFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_QuickPaymentViaFingerprintFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public QuickPaymentViaFingerprintFragment() {
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.mRootView = r2.inflate(R.layout.quick_payment_via_fingerprint_layout, r3, false);
        this.mFingerprintManager = (FingerprintManager) this.mContext.getSystemService("fingerprint");
        SettingItemText r5 = (SettingItemText) findViewByIdNullable(R.id.payment_alipay);
        this.mAlipayView = r5;
        r5.setOnClickListener(this);
        SettingItemText r6 = (SettingItemText) findViewByIdNullable(R.id.payment_wechat);
        this.mWechatPayView = r6;
        r6.setOnClickListener(this);
        return this.mRootView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r1) {
        super.onViewStateRestored(r1);
        updateViews();
    }

    public void updateViews() {
        boolean r0 = SettingsFeature.isAliPayAvailable(this.mContext);
        this.mAlipayView.setEnabled(r0);
        ImageView r1 = this.mAlipayView.getIconView();
        float r2 = 1.0f;
        if (r0 == false) goto L5;
        float r4 = 1.0f;
    L6:
        r1.setAlpha(r4);
        CharSequence r5 = null;
        if (r0 == false) goto L9;
        this.mAlipayView.setSummary(null);
    L10:
        boolean r3 = SettingsFeature.isWeChatPayAvailable(this.mContext);
        if (Utils.isPackageInstalled(this.mContext, "com.tencent.mm") == false) goto L15;
        if (r3 == true) goto L14;
        String r6 = getString(R.string.need_update_tips);
    L16:
        this.mWechatPayView.setEnabled(r3);
        ImageView r7 = this.mWechatPayView.getIconView();
        if (r3 == true) goto L20;
        r2 = 0.3f;
    L20:
        r7.setAlpha(r2);
        this.mWechatPayView.setSummary(r6);
        List<Fingerprint> r8 = (List) NullSafe.nonNull(this.mFingerprintManager.getEnrolledFingerprints());
        this.mFingerprintList = r8;
        Iterator<Fingerprint> r9 = r8.iterator();
        CharSequence r10 = null;
    L22:
        if (r9.hasNext() == false) goto L32;
        Fingerprint r11 = r9.next();
        String r12 = getQuickAppOfFingerprintId("quick_app_via_fingerprint_id_" + InvisibleApi.getFingerId(r11));
        if (TextUtils.isEmpty(r12) == true) goto L22;
        if (r12.contains("com.eg.android.AlipayGphone") == true) goto L27;
        if (r12.contains("com.tencent.mm") == false) goto L22;
        r10 = r11.getName();
        goto L22
    L27:
        r5 = r11.getName();
        goto L22
    L32:
        if (r5 == null) goto L34;
        this.mAlipayView.setSubTitle(r5);
    L35:
        if (r10 == null) goto L37;
        this.mWechatPayView.setSubTitle(r10);
        return;
    L37:
        this.mWechatPayView.setSubTitle(R.string.undefined);
        return;
    L34:
        this.mAlipayView.setSubTitle(R.string.undefined);
        goto L35
    L14:
        r6 = null;
        goto L16
    L15:
        r6 = getString(R.string.pico_not_installed);
        goto L16
    L9:
        this.mAlipayView.setSummary(getString(R.string.pico_not_installed));
        goto L10
    L5:
        r4 = 0.3f;
        goto L6
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        updateViews();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r3) {
        if (r3 != this.mAlipayView) goto L6;
        SettingsTracker.onItemClick(160201);
        String r4 = "com.eg.android.AlipayGphone";
    L9:
        Bundle r0 = new Bundle();
        r0.putString(ChooseFingerprintFragment.EXTRA_PKG, r4);
        start(ChooseFingerprintFragment.class, r0);
        return;
    L6:
        if (r3 != this.mWechatPayView) goto L8;
        SettingsTracker.onItemClick(160202);
        r4 = "com.tencent.mm";
        goto L9
    L8:
        r4 = null;
        goto L9
    }

    private String getQuickAppOfFingerprintId(String r4) {
        String r0 = android.provider.Settings.Global.getString(getContentResolver(), r4);
        OLog.d(this.TAG, "getQuickAppOfFingerprintId, key = " + r4 + " , value = " + r0);
        return r0;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_QuickPaymentViaFingerprintFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(QuickPaymentViaFingerprintFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_QuickPaymentViaFingerprintFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_QuickPaymentViaFingerprintFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(QuickPaymentViaFingerprintFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_QuickPaymentViaFingerprintFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_QuickPaymentViaFingerprintFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(QuickPaymentViaFingerprintFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_QuickPaymentViaFingerprintFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
