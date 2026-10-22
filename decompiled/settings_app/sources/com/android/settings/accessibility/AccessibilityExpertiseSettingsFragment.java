package com.android.settings.accessibility;

import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.KeyCharacterMap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.android.settings.R;
import com.android.settings.SettingsFeature;
import com.android.settings.SettingsTracker;
import com.android.settings.Utils;
import com.android.settings.applications.utils.Item;
import com.android.settings.applications.utils.OPopoverHelper;
import com.android.settings.base.BaseFragment;
import com.android.settings.settingitemsprovider.Constants;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.popover.v2.OPopover;
import com.obric.oui.text.OTextView;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class AccessibilityExpertiseSettingsFragment extends BaseFragment implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private static final String ASK_HEARING_POLICY_DIALOG = "ask_policy";
    public static final String EXTRA_BACK_BTN_RES_NAME = "back_text_res_name";
    public static final String EXTRA_INFO_TYPE = "extra_info_type";
    public static final int INFO_TYPE_PRIVACY_POLICY = 2;
    private boolean mAskHearingPolicyDialog;
    private OCardListItem mGlobalGesture;
    private OTextView mGlobalGestureDetail;
    private OCardListItem mItemAccessibilityHearingAccess;
    private OCardListItem mItemAccessibilityVisualAccess;
    private OCardListItem mItemAutoClick;
    private OCardListItem mItemLongPressTimeout;
    private OPopover mLongPressTimeoutPopover;
    private OCardListItem mMasterMono;
    private OSwitch mMasterMonoSwitch;
    private OCardListItem mPowerButtonEndsCall;
    private OSwitch mPowerButtonEndsCallSwitch;

    private class PrivacyPolicyClickableSpans extends ClickableSpan {
        final /* synthetic */ AccessibilityExpertiseSettingsFragment this$0;

        private PrivacyPolicyClickableSpans(AccessibilityExpertiseSettingsFragment r1) {
            this.this$0 = r1;
        }

        /* synthetic */ PrivacyPolicyClickableSpans(AccessibilityExpertiseSettingsFragment r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint r2) {
            super.updateDrawState(r2);
            r2.setUnderlineText(false);
            r2.setColor(this.this$0.getResources().getColor(R.color.legal_privacy_light_color));
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View r1) {
            AccessibilityExpertiseSettingsFragment.access$200(this.this$0, 2);
        }
    }

    public void com_android_settings_accessibility_AccessibilityExpertiseSettingsFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_accessibility_AccessibilityExpertiseSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_accessibility_AccessibilityExpertiseSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public AccessibilityExpertiseSettingsFragment() {
    }

    static /* synthetic */ void access$000(AccessibilityExpertiseSettingsFragment r0) {
        r0.startHearingAccessbility();
    }

    static /* synthetic */ void access$200(AccessibilityExpertiseSettingsFragment r0, int r1) {
        r0.startPrivacyActivity(r1);
    }

    public void com_android_settings_accessibility_AccessibilityExpertiseSettingsFragment__onCreate$___twin___(Bundle r2) {
        super.onCreate(r2);
        this.mAskHearingPolicyDialog = getArguments().getBoolean(ASK_HEARING_POLICY_DIALOG);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.mTitleResId = Integer.valueOf(R.string.accessibility_expertise_settings_title);
        this.mRootView = r2.inflate(R.layout.accessibility_expertise_settings_fragment, r3, false);
        OCardListItem r5 = (OCardListItem) findViewByIdNullable(R.id.id_accessibility_visual_access);
        this.mItemAccessibilityVisualAccess = r5;
        r5.setOnContentClickListener(new AccessibilityExpertiseSettingsFragment$$ExternalSyntheticLambda0(this));
        OCardListItem r6 = (OCardListItem) findViewByIdNullable(R.id.id_accessibility_hearing_access);
        this.mItemAccessibilityHearingAccess = r6;
        r6.setOnContentClickListener(new AccessibilityExpertiseSettingsFragment$$ExternalSyntheticLambda1(this));
        OCardListItem r7 = (OCardListItem) findViewByIdNullable(R.id.master_mono);
        this.mMasterMono = r7;
        r7.setDefaultCustomEndView(1);
        this.mMasterMono.showCustomEnd(true);
        this.mMasterMonoSwitch = (OSwitch) this.mMasterMono.getCustomEndView();
        OCardListItem r8 = (OCardListItem) findViewByIdNullable(R.id.auto_click);
        this.mItemAutoClick = r8;
        r8.setOnContentClickListener(new AccessibilityExpertiseSettingsFragment$$ExternalSyntheticLambda2(this));
        this.mItemAutoClick.setDefaultCustomEndView(3);
        this.mItemAutoClick.showCustomEnd(true);
        OCardListItem r9 = (OCardListItem) findViewById(R.id.power_button_ends_call);
        this.mPowerButtonEndsCall = r9;
        r9.setDefaultCustomEndView(1);
        this.mPowerButtonEndsCall.showCustomEnd(true);
        this.mPowerButtonEndsCallSwitch = (OSwitch) this.mPowerButtonEndsCall.getCustomEndView();
        OCardListItem r10 = (OCardListItem) findViewByIdNullable(R.id.select_long_press_timeout_preference);
        this.mItemLongPressTimeout = r10;
        r10.setOnContentClickListener(new AccessibilityExpertiseSettingsFragment$$ExternalSyntheticLambda3(this));
        this.mItemLongPressTimeout.setDefaultCustomEndView(3);
        this.mItemLongPressTimeout.showCustomEnd(true);
        OCardListItem r11 = (OCardListItem) findViewById(R.id.accessibility_global_gesture);
        this.mGlobalGesture = r11;
        r11.setOnContentClickListener(new AccessibilityExpertiseSettingsFragment$$ExternalSyntheticLambda4(this));
        this.mGlobalGesture.setDefaultCustomEndView(3);
        this.mGlobalGesture.showCustomEnd(true);
        this.mGlobalGesture.setVisibility(8);
        if (SettingsFeature.isSupportHearing() == true) goto L5;
        this.mItemAccessibilityHearingAccess.setVisibility(8);
        findViewByIdNullable(R.id.id_accessibility_hearing_shadow).setVisibility(8);
    L9:
        return this.mRootView;
    L5:
        if (this.mAskHearingPolicyDialog == false) goto L9;
        showHearingAccessbilityDialog();
        goto L9
    }

    /* JADX INFO: renamed from: lambda$onCreateView$0$com-android-settings-accessibility-AccessibilityExpertiseSettingsFragment, reason: not valid java name */
    /* synthetic */ void m238xf32785fa(View r1) {
        onClick(this.mItemAccessibilityVisualAccess);
    }

    /* JADX INFO: renamed from: lambda$onCreateView$1$com-android-settings-accessibility-AccessibilityExpertiseSettingsFragment, reason: not valid java name */
    /* synthetic */ void m239x26d5b0bb(View r1) {
        onClick(this.mItemAccessibilityHearingAccess);
    }

    /* JADX INFO: renamed from: lambda$onCreateView$2$com-android-settings-accessibility-AccessibilityExpertiseSettingsFragment, reason: not valid java name */
    /* synthetic */ void m240x5a83db7c(View r1) {
        onClick(this.mItemAutoClick);
    }

    /* JADX INFO: renamed from: lambda$onCreateView$3$com-android-settings-accessibility-AccessibilityExpertiseSettingsFragment, reason: not valid java name */
    /* synthetic */ void m241x8e32063d(View r1) {
        onClick(this.mItemLongPressTimeout);
    }

    /* JADX INFO: renamed from: lambda$onCreateView$4$com-android-settings-accessibility-AccessibilityExpertiseSettingsFragment, reason: not valid java name */
    /* synthetic */ void m242xc1e030fe(View r1) {
        onClick(this.mGlobalGesture);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r2, Bundle r3) {
        super.onViewCreated(r2, r3);
        this.mItemAutoClick.setEndDetailText(getAutoClickSubTitle().toString());
        int r4 = AccessibilitySettingsFragment.getLongPressTimeoutIndex(this.mContext);
        this.mItemLongPressTimeout.setEndDetailText(getResources().getStringArray(R.array.long_press_timeout_selector_titles)[r4]);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r1) {
        super.onViewStateRestored(r1);
        updateViews();
        this.mMasterMonoSwitch.setOnCheckedChangeListener(this);
        this.mPowerButtonEndsCallSwitch.setOnCheckedChangeListener(this);
    }

    public void updateViews() {
        this.mItemAutoClick.setEndDetailText(getAutoClickSubTitle().toString());
        this.mMasterMonoSwitch.setChecked(isMasterMonoEnable());
        updatePowerButtonEndsCallPreference();
        int r0 = AccessibilitySettingsFragment.getLongPressTimeoutIndex(this.mContext);
        this.mItemLongPressTimeout.setEndDetailText(getResources().getStringArray(R.array.long_press_timeout_selector_titles)[r0]);
        OCardListItem r1 = this.mGlobalGesture;
        if (AccessibilityGlobalGestureSettingsFragment.isAccessibilityGlobalGestureEnable(this.mContext) == false) goto L5;
        int r2 = R.string.settings_state_on;
    L6:
        r1.setEndDetailText(getString(r2));
        return;
    L5:
        r2 = R.string.settings_state_off;
        goto L6
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        updateViews();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r2) {
        if (this.mItemLongPressTimeout != r2) goto L6;
        launchLongPressTimeoutOptions();
        SettingsTracker.onItemClick(260303);
        return;
    L6:
        if (r2 != this.mItemAccessibilityVisualAccess) goto L9;
        start(VisualAccessibilitySettingsFragment.class);
        return;
    L9:
        if (r2 != this.mItemAutoClick) goto L12;
        start(AccessibilityAutoClickSettingsFragment.class);
        return;
    L12:
        if (r2 != this.mGlobalGesture) goto L15;
        start(AccessibilityGlobalGestureSettingsFragment.class);
        return;
    L15:
        if (r2 != this.mItemAccessibilityHearingAccess) goto L22;
        startHearingAccessbility();
        return;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r2, boolean r3) {
        if (r2 != this.mMasterMonoSwitch) goto L6;
        setMasterMonoEnable(r3);
        return;
    L6:
        if (r2 != this.mPowerButtonEndsCallSwitch) goto L10;
        setPowerButtonEndsCallEnable(r3);
        return;
    }

    private void launchLongPressTimeoutOptions() {
        final String[] r0 = getResources().getStringArray(R.array.long_press_timeout_selector_values);
        final String[] r1 = getResources().getStringArray(R.array.long_press_timeout_selector_titles);
        int r2 = AccessibilitySettingsFragment.getLongPressTimeoutIndex(this.mContext);
        ArrayList r3 = new ArrayList();
        int r5 = 0;
    L3:
        boolean r7 = true;
        if (r5 >= r0.length) goto L10;
        String r8 = r1[r5];
        if (r2 == r5) goto L9;
        r7 = false;
    L9:
        r3.add(new Item(r8, r7));
        r5 = r5 + 1;
        goto L3
    L10:
        this.mLongPressTimeoutPopover = OPopoverHelper.showPopoverList(this._mActivity, this.mItemLongPressTimeout, r3, new AccessibilityExpertiseSettingsFragment$$ExternalSyntheticLambda5(this, r0, r1), true);
    }

    /* JADX INFO: renamed from: lambda$launchLongPressTimeoutOptions$5$com-android-settings-accessibility-AccessibilityExpertiseSettingsFragment, reason: not valid java name */
    /* synthetic */ void m237xab0a36(String[] r2, String[] r3, View r4, int r5) {
        Settings.Secure.putInt(getContentResolver(), "long_press_timeout", Integer.parseInt(r2[r5]));
        this.mItemLongPressTimeout.setEndDetailText(r3[r5]);
        this.mLongPressTimeoutPopover.dismiss();
    }

    private CharSequence getAutoClickSubTitle() {
        return AccessibilityAutoClickSettingsFragment.getAutoClickSubTitle(this.mContext);
    }

    private void updatePowerButtonEndsCallPreference() {
        boolean r1 = true;
        if (KeyCharacterMap.deviceHasKey(26) == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == false) goto L10;
        int r3 = 0;
    L11:
        this.mPowerButtonEndsCall.setVisibility(r3);
        findViewByIdNullable(R.id.shadow_below_power_button_ends_call).setVisibility(r3);
        if (r0 == true) goto L15;
        return;
    L15:
        if (Settings.Secure.getInt(getContentResolver(), "incall_power_button_behavior", 1) == 2) goto L18;
        r1 = false;
    L18:
        this.mPowerButtonEndsCallSwitch.setChecked(r1);
        return;
    L10:
        r3 = 8;
        goto L11
    L5:
        if (Utils.isVoiceCapable(this.mContext) == false) goto L7;
        r0 = true;
        goto L8
    }

    private boolean isMasterMonoEnable() {
        if (Settings.System.getIntForUser(getContentResolver(), "master_mono", 0, -2) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    private void setMasterMonoEnable(boolean r3) {
        Settings.System.putIntForUser(getContentResolver(), "master_mono", r3 ? 1 : 0, -2);
    }

    private void setPowerButtonEndsCallEnable(boolean r2) {
        ContentResolver r1 = getContentResolver();
        if (r2 == false) goto L5;
        int r3 = 2;
    L6:
        Settings.Secure.putInt(r1, "incall_power_button_behavior", r3);
        return;
    L5:
        r3 = 1;
        goto L6
    }

    private void startHearingAccessbility() {
        Intent r0 = new Intent();
        r0.setClassName(Constants.PACKAGE_HEARINGAID, com.android.settings.Constants.CLASS_HEARINGAID_SETTING);
        r0.setAction("android.intent.action.MAIN");
        Utils.startActivity(getActivity(), r0);
    }

    private void showHearingAccessbilityDialog() {
        View r0 = LayoutInflater.from(getActivity()).inflate(R.layout.grant_dialog, null, false);
        TextView r1 = (TextView) r0.findViewById(R.id.grant_message);
        r1.setText(getPrivacySpan(R.string.dialog_accessibility_policy_tip));
        r1.setHighlightColor(getResources().getColor(android.R.color.transparent));
        r1.setMovementMethod(LinkMovementMethod.getInstance());
        new AlertDialog.Builder(getActivity()).setTitle(R.string.dialog_title_alert).setView(r0).setNegativeButton(R.string.disagree, null).setPositiveButton(R.string.agree, new AnonymousClass1(this)).show();
    }

    private SpannableString getPrivacySpan(int r5) {
        String r6 = getString(r5);
        String r0 = getString(R.string.accessibility_privacy_policy);
        SpannableString r1 = new SpannableString(r6);
        int r7 = r6.toLowerCase().indexOf(r0.toLowerCase());
        if (r7 == (-1)) goto L5;
        int r2 = r0.length() + r7;
        r1.setSpan(new PrivacyPolicyClickableSpans(this, null), r7, r2, 33);
    L5:
        return r1;
    }

    private void startPrivacyActivity(int r5) {
        Intent r0 = new Intent();
        r0.putExtra("back_text_res_name", "about_item_title_law_info");
        r0.setComponent(new ComponentName(com.android.settings.Constants.PKG_WALLPAPER_PROVIDER, "com.obric.wallpaper.LicenseActivity"));
        r0.putExtra("extra_info_type", r5);
        Utils.startActivity(this._mActivity, r0, 0);
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_accessibility_AccessibilityExpertiseSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(AccessibilityExpertiseSettingsFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_accessibility_AccessibilityExpertiseSettingsFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_accessibility_AccessibilityExpertiseSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(AccessibilityExpertiseSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_accessibility_AccessibilityExpertiseSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_accessibility_AccessibilityExpertiseSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(AccessibilityExpertiseSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_accessibility_AccessibilityExpertiseSettingsFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
