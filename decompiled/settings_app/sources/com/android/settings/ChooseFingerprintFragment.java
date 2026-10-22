package com.android.settings;

import android.hardware.fingerprint.Fingerprint;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
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
public class ChooseFingerprintFragment extends BaseFragment implements View.OnClickListener {
    public static final String EXTRA_PKG = "extra_pkg";
    private View mChooseFpTipsView;
    private int mCurrentSetupFpId;
    private List<Fingerprint> mFingerprintList;
    private LinearLayout mFingerprintManageContainer;
    private FingerprintManager mFingerprintManager;
    private String mTargetPkg;

    public void com_android_settings_ChooseFingerprintFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_ChooseFingerprintFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_ChooseFingerprintFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_ChooseFingerprintFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public ChooseFingerprintFragment() {
        this.mCurrentSetupFpId = 0;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.mRootView = r2.inflate(R.layout.choose_fingerprint_layout, r3, false);
        this.mFingerprintManager = (FingerprintManager) this.mContext.getSystemService("fingerprint");
        this.mFingerprintManageContainer = (LinearLayout) findViewByIdNullable(R.id.fingerprint_manage_container);
        this.mChooseFpTipsView = findViewByIdNullable(R.id.choose_fp_tips);
        String r5 = getArguments().getString(EXTRA_PKG);
        this.mTargetPkg = r5;
        if ("com.eg.android.AlipayGphone".equals(r5) == true) goto L8;
        if ("com.tencent.mm".equals(this.mTargetPkg) == true) goto L8;
        finish();
    L8:
        return this.mRootView;
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r1, Bundle r2) {
        super.onViewCreated(r1, r2);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r1) {
        super.onViewStateRestored(r1);
        updateViews();
    }

    public void updateViews() {
        updateTipsView();
        List<Fingerprint> r0 = this.mFingerprintManager.getEnrolledFingerprints();
        this.mFingerprintList = r0;
        Iterator<Fingerprint> r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L10;
        Fingerprint r2 = r1.next();
        String r3 = getQuickAppOfFingerprintId("quick_app_via_fingerprint_id_" + InvisibleApi.getFingerId(r2));
        if (r3 == null) goto L4;
        if (r3.contains(this.mTargetPkg) == false) goto L4;
        this.mCurrentSetupFpId = InvisibleApi.getFingerId(r2);
        goto L4
    L10:
        updateFingerprintManageView();
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        updateViews();
    }

    private void updateTipsView() {
        "com.tencent.mm".equals(this.mTargetPkg);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r5) {
        int r6 = ((Integer) r5.getTag()).intValue();
        OLog.d(this.TAG, "click TAG " + this.TAG);
        if (this.mCurrentSetupFpId == 0) goto L5;
        android.provider.Settings.Global.putString(getContentResolver(), "quick_app_via_fingerprint_id_" + this.mCurrentSetupFpId, null);
    L5:
        if (r6 == 0) goto L7;
        android.provider.Settings.Global.putString(getContentResolver(), "quick_app_via_fingerprint_id_" + this.TAG, "payment/" + this.mTargetPkg);
    L7:
        finish();
    }

    private void updateFingerprintManageView() {
        this.mFingerprintManageContainer.removeAllViews();
        View r0 = View.inflate(this.mContext, R.layout.list_content_item_check, null);
        SettingItemCheck r4 = (SettingItemCheck) r0.findViewById(R.id.item_check);
        r4.setTitle(R.string.undefined);
        r4.setTag(0);
        if (this.mCurrentSetupFpId != 0) goto L5;
        boolean r6 = true;
    L6:
        r4.setChecked(r6);
        r4.setOnClickListener(this);
        List<Fingerprint> r7 = this.mFingerprintList;
        if (r7 != null) goto L9;
        int r8 = 0;
    L10:
        int r9 = r8 + 1;
        Utils.setItemBgStyle(r4, r9, 0);
        this.mFingerprintManageContainer.addView(r0);
        int r1 = 0;
    L11:
        if (r1 >= r8) goto L27;
        Fingerprint r5 = this.mFingerprintList.get(r1);
        View r10 = View.inflate(this.mContext, R.layout.list_content_item_check, null);
        SettingItemCheck r11 = (SettingItemCheck) r10.findViewById(R.id.item_check);
        r11.setTag(Integer.valueOf(InvisibleApi.getFingerId(r5)));
        r11.setTitle(r5.getName());
        if (InvisibleApi.getFingerId(r5) != this.mCurrentSetupFpId) goto L15;
        boolean r12 = true;
    L16:
        r11.setChecked(r12);
        String r13 = getQuickAppOfFingerprintId("quick_app_via_fingerprint_id_" + InvisibleApi.getFingerId(r5));
        if (r13 == null) goto L26;
        if (r13.contains(this.mTargetPkg) == true) goto L26;
        r11.setEnabled(false);
        if (r13.contains("com.eg.android.AlipayGphone") == false) goto L24;
        r11.setSummary(getString(R.string.pay_via_alipay));
        goto L26
    L24:
        if (r13.contains("com.tencent.mm") == false) goto L26;
        r11.setSummary(getString(R.string.pay_via_wechat));
    L26:
        r1 = r1 + 1;
        Utils.setItemBgStyle(r11, r9, r1);
        r11.setOnClickListener(this);
        this.mFingerprintManageContainer.addView(r10);
        goto L11
    L15:
        r12 = false;
        goto L16
    L27:
        LinearLayout r14 = this.mFingerprintManageContainer;
        r14.addView(Utils.inflateGapView(r14));
        return;
    L9:
        r8 = r7.size();
        goto L10
    L5:
        r6 = false;
        goto L6
    }

    private String getQuickAppOfFingerprintId(String r4) {
        String r0 = android.provider.Settings.Global.getString(getContentResolver(), r4);
        OLog.d(this.TAG, "getQuickAppOfFingerprintId, key = " + r4 + " , value = " + r0);
        return r0;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_ChooseFingerprintFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(ChooseFingerprintFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_ChooseFingerprintFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_ChooseFingerprintFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(ChooseFingerprintFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_ChooseFingerprintFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_ChooseFingerprintFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(ChooseFingerprintFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_ChooseFingerprintFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
