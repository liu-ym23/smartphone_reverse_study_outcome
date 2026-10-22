package com.android.settings.accessibility;

import android.content.Context;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import com.android.settings.R;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.HanziToPinyin;
import com.obric.olog.OLog;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class AccessibilityAutoClickSettingsFragment extends BaseFragment implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {
    private static final int AUTOCLICK_DELAY_STEP = 100;
    private static final int MAX_AUTOCLICK_DELAY = 1000;
    private static final int MIN_AUTOCLICK_DELAY = 200;
    private OCardListItem mAutoClick;
    private OSwitch mAutoClickSwitch;
    private LinearLayout mContainer;
    private OCardListItem mDelay1000;
    private OCardListItem mDelay200;
    private OCardListItem mDelay300;
    private OCardListItem mDelay400;
    private OCardListItem mDelay500;
    private OCardListItem mDelay600;
    private OCardListItem mDelay700;
    private OCardListItem mDelay800;
    private OCardListItem mDelay900;

    private int seekBarProgressToDelay(int r1) {
        return (r1 * 100) + 200;
    }

    public void com_android_settings_accessibility_AccessibilityAutoClickSettingsFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_accessibility_AccessibilityAutoClickSettingsFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_accessibility_AccessibilityAutoClickSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_accessibility_AccessibilityAutoClickSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public AccessibilityAutoClickSettingsFragment() {
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.mTitleResId = Integer.valueOf(R.string.accessibility_autoclick_preference_title);
        this.mRootView = r2.inflate(R.layout.accessibility_auto_click_fragment, r3, false);
        OCardListItem r5 = (OCardListItem) findViewByIdNullable(R.id.auto_click);
        this.mAutoClick = r5;
        this.mAutoClickSwitch = r5.getEndSwitch();
        this.mContainer = (LinearLayout) findViewByIdNullable(R.id.items_container);
        OCardListItem r6 = (OCardListItem) findViewByIdNullable(R.id.click_delay_200);
        this.mDelay200 = r6;
        r6.setOnContentClickListener(new AccessibilityAutoClickSettingsFragment$$ExternalSyntheticLambda0(this));
        OCardListItem r7 = (OCardListItem) findViewByIdNullable(R.id.click_delay_300);
        this.mDelay300 = r7;
        r7.setOnContentClickListener(new AccessibilityAutoClickSettingsFragment$$ExternalSyntheticLambda1(this));
        OCardListItem r8 = (OCardListItem) findViewByIdNullable(R.id.click_delay_400);
        this.mDelay400 = r8;
        r8.setOnContentClickListener(new AccessibilityAutoClickSettingsFragment$$ExternalSyntheticLambda2(this));
        OCardListItem r9 = (OCardListItem) findViewByIdNullable(R.id.click_delay_500);
        this.mDelay500 = r9;
        r9.setOnContentClickListener(new AccessibilityAutoClickSettingsFragment$$ExternalSyntheticLambda3(this));
        OCardListItem r10 = (OCardListItem) findViewByIdNullable(R.id.click_delay_600);
        this.mDelay600 = r10;
        r10.setOnContentClickListener(new AccessibilityAutoClickSettingsFragment$$ExternalSyntheticLambda4(this));
        OCardListItem r11 = (OCardListItem) findViewByIdNullable(R.id.click_delay_700);
        this.mDelay700 = r11;
        r11.setOnContentClickListener(new AccessibilityAutoClickSettingsFragment$$ExternalSyntheticLambda5(this));
        OCardListItem r12 = (OCardListItem) findViewByIdNullable(R.id.click_delay_800);
        this.mDelay800 = r12;
        r12.setOnContentClickListener(new AccessibilityAutoClickSettingsFragment$$ExternalSyntheticLambda6(this));
        OCardListItem r13 = (OCardListItem) findViewByIdNullable(R.id.click_delay_900);
        this.mDelay900 = r13;
        r13.setOnContentClickListener(new AccessibilityAutoClickSettingsFragment$$ExternalSyntheticLambda7(this));
        OCardListItem r14 = (OCardListItem) findViewByIdNullable(R.id.click_delay_1000);
        this.mDelay1000 = r14;
        r14.setOnContentClickListener(new AccessibilityAutoClickSettingsFragment$$ExternalSyntheticLambda8(this));
        return this.mRootView;
    }

    /* JADX INFO: renamed from: lambda$onCreateView$0$com-android-settings-accessibility-AccessibilityAutoClickSettingsFragment, reason: not valid java name */
    /* synthetic */ void m226x661aa102(View r1) {
        onClick(this.mDelay200);
    }

    /* JADX INFO: renamed from: lambda$onCreateView$1$com-android-settings-accessibility-AccessibilityAutoClickSettingsFragment, reason: not valid java name */
    /* synthetic */ void m227x99c8cbc3(View r1) {
        onClick(this.mDelay300);
    }

    /* JADX INFO: renamed from: lambda$onCreateView$2$com-android-settings-accessibility-AccessibilityAutoClickSettingsFragment, reason: not valid java name */
    /* synthetic */ void m228xcd76f684(View r1) {
        onClick(this.mDelay400);
    }

    /* JADX INFO: renamed from: lambda$onCreateView$3$com-android-settings-accessibility-AccessibilityAutoClickSettingsFragment, reason: not valid java name */
    /* synthetic */ void m229x1252145(View r1) {
        onClick(this.mDelay500);
    }

    /* JADX INFO: renamed from: lambda$onCreateView$4$com-android-settings-accessibility-AccessibilityAutoClickSettingsFragment, reason: not valid java name */
    /* synthetic */ void m230x34d34c06(View r1) {
        onClick(this.mDelay600);
    }

    /* JADX INFO: renamed from: lambda$onCreateView$5$com-android-settings-accessibility-AccessibilityAutoClickSettingsFragment, reason: not valid java name */
    /* synthetic */ void m231x688176c7(View r1) {
        onClick(this.mDelay700);
    }

    /* JADX INFO: renamed from: lambda$onCreateView$6$com-android-settings-accessibility-AccessibilityAutoClickSettingsFragment, reason: not valid java name */
    /* synthetic */ void m232x9c2fa188(View r1) {
        onClick(this.mDelay800);
    }

    /* JADX INFO: renamed from: lambda$onCreateView$7$com-android-settings-accessibility-AccessibilityAutoClickSettingsFragment, reason: not valid java name */
    /* synthetic */ void m233xcfddcc49(View r1) {
        onClick(this.mDelay900);
    }

    /* JADX INFO: renamed from: lambda$onCreateView$8$com-android-settings-accessibility-AccessibilityAutoClickSettingsFragment, reason: not valid java name */
    /* synthetic */ void m234x38bf70a(View r1) {
        onClick(this.mDelay1000);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r1) {
        super.onViewStateRestored(r1);
        updateViews();
        this.mAutoClickSwitch.setOnCheckedChangeListener(this);
    }

    public void updateViews() {
        boolean r0 = isAutoClickEnable(this.mContext);
        this.mAutoClickSwitch.setChecked(r0);
        LinearLayout r1 = this.mContainer;
        if (r0 == false) goto L5;
        int r2 = 0;
    L6:
        r1.setVisibility(r2);
        updateStatus(getAutoClickDelayMs(this.mContext));
        return;
    L5:
        r2 = 4;
        goto L6
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        updateViews();
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r2, boolean r3) {
        if (r2 != this.mAutoClickSwitch) goto L10;
        setAutoClickEnable(r3);
        LinearLayout r1 = this.mContainer;
        if (r3 == false) goto L7;
        int r4 = 0;
    L8:
        r1.setVisibility(r4);
        return;
    L7:
        r4 = 4;
        goto L8
    }

    private static void setAutoClickDelayMs(Context r1, int r2) {
        Settings.Secure.putInt(r1.getContentResolver(), "accessibility_autoclick_delay", r2);
    }

    private static int getAutoClickDelayMs(Context r2) {
        return Settings.Secure.getInt(r2.getContentResolver(), "accessibility_autoclick_delay", 600);
    }

    private static boolean isAutoClickEnable(Context r2) {
        if (Settings.Secure.getInt(r2.getContentResolver(), "accessibility_autoclick_enabled", 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    private void setAutoClickEnable(boolean r2) {
        Settings.Secure.putInt(getContentResolver(), "accessibility_autoclick_enabled", r2 ? 1 : 0);
    }

    static CharSequence getAutoClickSubTitle(Context r1) {
        if (isAutoClickEnable(r1) == true) goto L7;
        return r1.getString(R.string.settings_state_off);
    L7:
        return getAutoClickPreferenceSummary(r1);
    }

    private static CharSequence getAutoClickPreferenceSummary(Context r2) {
        return getAutoClickDelayMs(r2) + HanziToPinyin.Token.SEPARATOR + r2.getResources().getString(R.string.millisecond);
    }

    private int delayToSeekBarProgress(int r1) {
        return (r1 - 200) / 100;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r3) {
        if (r3 != this.mDelay200) goto L6;
        setAutoClickDelayMs(this.mContext, 200);
    L29:
        clearStatus();
        ((OCardListItem) r3).showCustomEnd(true);
        return;
    L6:
        if (r3 != this.mDelay300) goto L9;
        setAutoClickDelayMs(this.mContext, 300);
        goto L29
    L9:
        if (r3 != this.mDelay400) goto L12;
        setAutoClickDelayMs(this.mContext, 400);
        goto L29
    L12:
        if (r3 != this.mDelay500) goto L15;
        setAutoClickDelayMs(this.mContext, 500);
        goto L29
    L15:
        if (r3 != this.mDelay600) goto L18;
        setAutoClickDelayMs(this.mContext, 600);
        goto L29
    L18:
        if (r3 != this.mDelay700) goto L21;
        setAutoClickDelayMs(this.mContext, 700);
        goto L29
    L21:
        if (r3 != this.mDelay800) goto L24;
        setAutoClickDelayMs(this.mContext, 800);
        goto L29
    L24:
        if (r3 != this.mDelay900) goto L27;
        setAutoClickDelayMs(this.mContext, 900);
        goto L29
    L27:
        if (r3 != this.mDelay1000) goto L29;
        setAutoClickDelayMs(this.mContext, 1000);
        goto L29
    }

    private void clearStatus() {
        this.mDelay200.showCustomEnd(false);
        this.mDelay300.showCustomEnd(false);
        this.mDelay400.showCustomEnd(false);
        this.mDelay500.showCustomEnd(false);
        this.mDelay600.showCustomEnd(false);
        this.mDelay700.showCustomEnd(false);
        this.mDelay800.showCustomEnd(false);
        this.mDelay900.showCustomEnd(false);
        this.mDelay1000.showCustomEnd(false);
    }

    private void updateStatus(int r2) {
        clearStatus();
        if (r2 != 200) goto L6;
        setItemCheck(this.mDelay200);
        return;
    L6:
        if (r2 != 300) goto L9;
        setItemCheck(this.mDelay300);
        return;
    L9:
        if (r2 != 400) goto L12;
        setItemCheck(this.mDelay400);
        return;
    L12:
        if (r2 != 500) goto L15;
        setItemCheck(this.mDelay500);
        return;
    L15:
        if (r2 != 600) goto L18;
        setItemCheck(this.mDelay600);
        return;
    L18:
        if (r2 != 700) goto L21;
        setItemCheck(this.mDelay700);
        return;
    L21:
        if (r2 != 800) goto L24;
        setItemCheck(this.mDelay800);
        return;
    L24:
        if (r2 != 900) goto L27;
        setItemCheck(this.mDelay900);
        return;
    L27:
        if (r2 != 1000) goto L38;
        setItemCheck(this.mDelay1000);
        return;
    }

    private void setItemCheck(OCardListItem r1) {
        r1.showCustomEnd(true);
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_accessibility_AccessibilityAutoClickSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(AccessibilityAutoClickSettingsFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_accessibility_AccessibilityAutoClickSettingsFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_accessibility_AccessibilityAutoClickSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(AccessibilityAutoClickSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_accessibility_AccessibilityAutoClickSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_accessibility_AccessibilityAutoClickSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(AccessibilityAutoClickSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_accessibility_AccessibilityAutoClickSettingsFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
