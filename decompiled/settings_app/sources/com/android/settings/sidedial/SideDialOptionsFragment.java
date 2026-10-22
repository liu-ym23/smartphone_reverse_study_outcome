package com.android.settings.sidedial;

import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.LinearLayout;
import com.android.settings.R;
import com.android.settings.Utils;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.SettingsProviderUtils;
import com.android.settings.widget.SettingItemCheckSimpleText;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.app.settings.search.SettingsSwitchKeyUtil;

/* JADX INFO: loaded from: classes2.dex */
public class SideDialOptionsFragment extends BaseFragment implements View.OnClickListener, SettingItemCheckSimpleText.IcArrowClickListener {
    public static final int CUSTOM_MODE_SUMMARY_MAX_LINE = 3;
    public static final int DOUBLE_CLICK_THRESHOLD = 300;
    public static final String LAUNCH_MODE = "launch_mode";
    public static final String TITLE_RES = "title_res";
    public static final int TYPE_CAR_MODE = 4;
    public static final int TYPE_CLEAN_MODE = 3;
    public static final int TYPE_CREATIVE_CAPSULE = 1;
    public static final int TYPE_CUSTOM_MODE = 5;
    public static final int TYPE_MUTE = 0;
    public static final int TYPE_NONE = -1;
    public static final int TYPE_WIRELESS_TNT_GO = 2;
    private SettingItemCheckSimpleText.IcArrowClickListener icArrowClickListener;
    private SettingItemCheckSimpleText.IcArrowClickListener icCustomArrowClickListener;
    private SettingItemCheckSimpleText mCarMode;
    private SettingItemCheckSimpleText mCleanMode;
    private SettingItemCheckSimpleText mCreativeCapsule;
    private SettingItemCheckSimpleText mCustomMode;
    private SettingItemCheckSimpleText mMute;
    private LinearLayout mSideDialContainer;
    private SettingItemCheckSimpleText mWirelessMode;

    public void com_android_settings_sidedial_SideDialOptionsFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_sidedial_SideDialOptionsFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_sidedial_SideDialOptionsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_sidedial_SideDialOptionsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public SideDialOptionsFragment() {
        super(R.layout.side_dial_setting_layout);
        this.icArrowClickListener = new SideDialOptionsFragment$$ExternalSyntheticLambda0(this);
        this.icCustomArrowClickListener = new SideDialOptionsFragment$$ExternalSyntheticLambda1(this);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r2, Bundle r3) {
        super.onViewCreated(r2, r3);
        this.mSideDialContainer = (LinearLayout) findViewByIdNullable(R.id.side_dial_container);
        SettingItemCheckSimpleText r4 = (SettingItemCheckSimpleText) findViewByIdNullable(R.id.id_side_dial_mute);
        this.mMute = r4;
        r4.setTag(0);
        SettingItemCheckSimpleText r5 = (SettingItemCheckSimpleText) findViewByIdNullable(R.id.id_side_dial_creative_capsule);
        this.mCreativeCapsule = r5;
        r5.setTag(1);
        SettingItemCheckSimpleText r6 = (SettingItemCheckSimpleText) findViewByIdNullable(R.id.id_side_dial_wireless_mode);
        this.mWirelessMode = r6;
        r6.setTag(2);
        SettingItemCheckSimpleText r7 = (SettingItemCheckSimpleText) findViewByIdNullable(R.id.id_side_dial_clean_mode);
        this.mCleanMode = r7;
        r7.setTag(3);
        SettingItemCheckSimpleText r8 = (SettingItemCheckSimpleText) findViewByIdNullable(R.id.id_side_dial_car_mode);
        this.mCarMode = r8;
        r8.setTag(4);
        this.mCarMode.setIconArrowListener(this.icArrowClickListener);
        this.mCleanMode.setIconArrowListener(this.icArrowClickListener);
        this.mCarMode.setOnClickListener(this);
        this.mCleanMode.setOnClickListener(this);
        this.mMute.setOnClickListener(this);
        this.mCreativeCapsule.setOnClickListener(this);
        this.mWirelessMode.setOnClickListener(this);
        SettingItemCheckSimpleText r9 = (SettingItemCheckSimpleText) findViewByIdNullable(R.id.id_side_custom);
        this.mCustomMode = r9;
        r9.setTag(5);
        this.mCustomMode.getSummaryView().setMaxLines(3);
        this.mCustomMode.setIconArrowListener(this.icCustomArrowClickListener);
        this.mCustomMode.setOnClickListener(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r1) {
        super.onViewStateRestored(r1);
        updateViews();
    }

    /* JADX INFO: renamed from: lambda$new$0$com-android-settings-sidedial-SideDialOptionsFragment, reason: not valid java name */
    /* synthetic */ void m599xac7b196c(View r3) {
        Bundle r0 = new Bundle();
        if (this.mCarMode.getIcArrow() != r3) goto L5;
        r0.putInt("launch_mode", 4);
        r0.putInt(TITLE_RES, R.string.side_dial_car_mode_title);
    L5:
        start(SideDialDetailsFragment.class, r0);
    }

    /* JADX INFO: renamed from: lambda$new$1$com-android-settings-sidedial-SideDialOptionsFragment, reason: not valid java name */
    /* synthetic */ void m600xd5cf6ead(View r3) {
        Bundle r0 = new Bundle();
        if (this.mCustomMode.getIcArrow() != r3) goto L5;
        r0.putInt("launch_mode", 5);
        r0.putInt(TITLE_RES, R.string.side_dial_custom_mode_title);
    L5:
        start(SideDialCustomFragment.class, r0);
    }

    @Override // android.view.View.OnClickListener, com.android.settings.widget.SettingItemCheckSimpleText.IcArrowClickListener
    public void onClick(View r4) {
        if (Utils.isFastDoubleClick(-1, 300) == false) goto L6;
        return;
    L6:
        if ((r4 instanceof SettingItemCheckSimpleText) == true) goto L8;
    L10:
        int r0 = getViewType(r4);
        updateCheckStatus(r0);
        if (SettingsProviderUtils.isSideDialEnable(this.mContext) == false) goto L13;
        SideDialHelper.recoveryMode(this.mContext, SettingsProviderUtils.getSideDialType(this.mContext));
    L13:
        SettingsProviderUtils.setSideDialType(this.mContext, r0);
        if (r4.getId() != R.id.id_side_dial_creative_capsule) goto L17;
        setVoiceInputEnable();
        return;
    L17:
        return;
    L8:
        if (((SettingItemCheckSimpleText) r4).isChecked() == false) goto L10;
    }

    public void updateViews() {
        this.mCustomMode.setTitleText(SideDialCustomFragment.getCustomModeTitleName());
        updateCheckStatus(SettingsProviderUtils.getSideDialType(this.mContext));
        updateSummary();
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        updateViews();
    }

    private void updateSummary() {
        this.mMute.setSummary(R.string.side_dial_mute_summary);
        this.mCreativeCapsule.setSummary(R.string.side_dial_creative_capsule_summary);
        this.mCarMode.setSummary(SideDialHelper.getCarSummary(this.mContext));
        this.mCustomMode.setSummary(SideDialHelper.getCustomSummary(this.mContext));
        this.mWirelessMode.setSummary(R.string.side_dial_wireless_mode_summary);
    }

    private void updateCheckStatus(int r5) {
        int r1 = 0;
    L4:
        if (r1 >= this.mSideDialContainer.getChildCount()) goto L13;
        View r2 = this.mSideDialContainer.getChildAt(r1);
        if ((r2 instanceof SettingItemCheckSimpleText) == false) goto L12;
        SettingItemCheckSimpleText r3 = (SettingItemCheckSimpleText) r2;
        if (getViewType(r3) != r5) goto L10;
        boolean r4 = true;
    L11:
        r3.setChecked(r4);
        goto L12
    L10:
        r4 = false;
    L12:
        r1 = r1 + 1;
        goto L4
    }

    private int getViewType(View r4) {
        Object r0 = r4.getTag();
        if (r0 == null) goto L5;
        int r1 = ((Integer) r0).intValue();
    L6:
        if (r1 != (-1)) goto L8;
    L9:
        OLog.d(this.TAG, "view id = " + r4.getId() + ";result = " + r1 + "for 0466383");
    L10:
        return r1;
    L8:
        if (r1 != 3) goto L10;
    L5:
        r1 = -1;
        goto L6
    }

    private void setVoiceInputEnable() {
        Settings.Global.putInt(getContentResolver(), SettingsSwitchKeyUtil.VOICE_INPUT, 1);
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_sidedial_SideDialOptionsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(SideDialOptionsFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_sidedial_SideDialOptionsFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_sidedial_SideDialOptionsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(SideDialOptionsFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_sidedial_SideDialOptionsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_sidedial_SideDialOptionsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(SideDialOptionsFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_sidedial_SideDialOptionsFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
