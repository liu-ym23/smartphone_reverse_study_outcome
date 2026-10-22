package com.android.settings;

import android.content.ContentResolver;
import android.content.om.OverlayIdentifier;
import android.content.om.OverlayManager;
import android.content.om.OverlayManagerTransaction;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import bytedanceos.util.SettingsUtil;
import com.android.settings.accessibility.SmartScreenFragment;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.widget.CustomNavbarStyleView;
import com.android.settings.widget.NavigationBarPreview;
import com.obric.olog.OLog;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.app.settings.search.SettingsSwitchKeyUtil;

/* JADX INFO: loaded from: classes2.dex */
public class NavbarModeFragment extends BaseFragment implements NavigationBarPreview.Callback, View.OnClickListener, CompoundButton.OnCheckedChangeListener, CustomNavbarStyleView.OnCustomStyleCheckedChangeListener {
    private static final String BYTEDANCE_LAUNCHER_PKG_NAME = "com.bytedanceos.launcher";
    public static final int NAVBAR_GESTURE_MODE = 2;
    public static final int NAVBAR_KEY_DOUBLE_BUTTON_MODE = 1;
    public static final int NAVBAR_KEY_THREE_BUTTON_MODE = 0;
    private static final long NAVBAR_OVERLAY_DELAY_MS = 100;
    private boolean mAppSwitchEnable;
    private int mCurrentHideNavHandle;
    private int mCurrentNavbarLayoutStyle;
    private int mCurrentNavbarMode;
    private int mCurrentNavbarTriggerMode;
    private int mCurrentSmartScreenMode;
    private View mGestureContainer;
    private Handler mHandler;
    private OCardListItem mHideNavHandle;
    private OSwitch mHideNavSwitch;
    private boolean mIsBytedanceLauncher;
    private boolean mIsTalkbackOn;
    private boolean mIsTipsShown;
    private View mNavLayoutContainer;
    private CustomNavbarStyleView mNavLayoutLeft;
    private CustomNavbarStyleView mNavLayoutRight;
    private OCardListItem mNavbarModeSwitchItem;
    private OSwitch mNavbarSwitch;
    private int mOriginalNavbarMode;
    private View mSmartScreenContainer;
    private TextView mSmartScreenSetting;
    private Runnable mUpdateNavbarOverlayRunnable;

    public void com_android_settings_NavbarModeFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_NavbarModeFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_NavbarModeFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public NavbarModeFragment() {
    }

    static /* synthetic */ int access$000(NavbarModeFragment r0) {
        return r0.mCurrentNavbarTriggerMode;
    }

    static /* synthetic */ void access$100(NavbarModeFragment r0, int r1) {
        r0.updateNavbarOverlay(r1);
    }

    public void com_android_settings_NavbarModeFragment__onCreate$___twin___(Bundle r2) {
        super.onCreate(r2);
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mUpdateNavbarOverlayRunnable = new AnonymousClass1(this);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        boolean r0 = false;
        this.mRootView = r2.inflate(R.layout.navbar_mode_layout, r3, false);
        OCardListItem r5 = (OCardListItem) findViewByIdNullable(R.id.id_navbar_mode_switch);
        this.mNavbarModeSwitchItem = r5;
        r5.setDefaultCustomEndView(1);
        OSwitch r6 = (OSwitch) this.mNavbarModeSwitchItem.getCustomEndView();
        this.mNavbarSwitch = r6;
        r6.setCheckedNoAnim(false);
        this.mNavbarSwitch.setClickable(true);
        this.mNavbarModeSwitchItem.showCustomEnd(true);
        OCardListItem r7 = (OCardListItem) findViewByIdNullable(R.id.hide_nav_handle);
        this.mHideNavHandle = r7;
        r7.setOnContentClickListener(new NavbarModeFragment$$ExternalSyntheticLambda0(this));
        this.mHideNavHandle.setDefaultCustomEndView(1);
        OSwitch r8 = (OSwitch) this.mHideNavHandle.getCustomEndView();
        this.mHideNavSwitch = r8;
        r8.setClickable(true);
        this.mHideNavHandle.showCustomEnd(true);
        this.mSmartScreenContainer = findViewByIdNullable(R.id.id_smart_screen_protection_container);
        this.mSmartScreenSetting = (TextView) findViewByIdNullable(R.id.id_go_to_setting);
        this.mNavLayoutContainer = findViewByIdNullable(R.id.nav_layout_container);
        this.mGestureContainer = findViewByIdNullable(R.id.gesture_support_layout);
        if (SettingsFeature.isSupportSmartScreenProtection() == false) goto L9;
        int r9 = android.provider.Settings.Global.getInt(getContentResolver(), SettingsSwitchKeyUtil.SMART_SCREEN_PROTECTOR, 0);
        this.mCurrentSmartScreenMode = r9;
        View r10 = this.mSmartScreenContainer;
        if (r9 != 1) goto L7;
        int r11 = 0;
    L8:
        r10.setVisibility(r11);
        goto L9
    L7:
        r11 = 8;
    L9:
        this.mSmartScreenSetting.setOnClickListener(this);
        this.mNavLayoutLeft = (CustomNavbarStyleView) findViewByIdNullable(R.id.nav_layout_left);
        CustomNavbarStyleView r12 = (CustomNavbarStyleView) findViewByIdNullable(R.id.nav_layout_right);
        this.mNavLayoutRight = r12;
        r12.reverseBgResource();
        this.mNavLayoutLeft.setOnCustomStyleCheckedChangeListener(this);
        this.mNavLayoutRight.setOnCustomStyleCheckedChangeListener(this);
        loadOriginalPrefer();
        OSwitch r13 = this.mHideNavSwitch;
        if (this.mCurrentHideNavHandle != 1) goto L12;
        r0 = true;
    L12:
        r13.setChecked(r0);
        return this.mRootView;
    }

    /* JADX INFO: renamed from: lambda$onCreateView$0$com-android-settings-NavbarModeFragment, reason: not valid java name */
    /* synthetic */ void m164lambda$onCreateView$0$comandroidsettingsNavbarModeFragment(View r1) {
        onClick(this.mHideNavHandle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r1) {
        super.onViewStateRestored(r1);
        updateSelectedItemView();
        this.mNavbarSwitch.setOnCheckedChangeListener(this);
        this.mHideNavSwitch.setOnCheckedChangeListener(this);
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        updateSelectedItemView();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.mOriginalNavbarMode == this.mCurrentNavbarMode) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        Utils.killCurrentInputMethodPkg(this.mContext);
        return;
    L9:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public void loadOriginalPrefer() {
        ContentResolver r0 = this.mContext.getContentResolver();
        int r1 = android.provider.Settings.Global.getInt(r0, "navigation_bar_mode", 1);
        this.mOriginalNavbarMode = r1;
        this.mCurrentNavbarMode = r1;
        this.mCurrentNavbarLayoutStyle = android.provider.Settings.System.getInt(r0, settings.Settings.Global.KEY_REVERSE_NAVIGATION_BAR, 0);
        this.mCurrentHideNavHandle = android.provider.Settings.System.getInt(r0, settings.Settings.Global.KEY_HIDE_NAVIGATION_BAR, 0);
        this.mIsBytedanceLauncher = "com.bytedanceos.launcher".equals(Utils.getDefaultLauncherPkg(this.mContext));
        this.mIsTipsShown = false;
    }

    private void refreshCurrentState() {
        this.mCurrentNavbarTriggerMode = android.provider.Settings.Global.getInt(getContentResolver(), "navigationbar_trigger_mode", 2);
        boolean r2 = true;
        if (android.provider.Settings.Global.getInt(getContentResolver(), "navigationbar_app_switch_gesture", 1) == 1) goto L6;
        r2 = false;
    L6:
        this.mAppSwitchEnable = r2;
        this.mIsTalkbackOn = SettingsUtil.isAccessibilityEnabled(this.mContext);
    }

    private void resetNavLayoutState() {
        this.mNavLayoutLeft.setSelected(false);
        this.mNavLayoutRight.setSelected(false);
    }

    private void updateSelectedItemView() {
        refreshCurrentState();
        resetNavLayoutState();
        boolean r1 = false;
        if (this.mCurrentNavbarLayoutStyle != 1) goto L5;
        boolean r0 = true;
    L6:
        this.mNavLayoutLeft.setSelected(!r0);
        this.mNavLayoutRight.setSelected(r0);
        if (this.mCurrentNavbarTriggerMode != 0) goto L9;
        boolean r2 = true;
    L10:
        this.mNavbarSwitch.setChecked(r2);
        OSwitch r3 = this.mHideNavSwitch;
        if (this.mCurrentHideNavHandle != 1) goto L13;
        boolean r4 = true;
    L14:
        r3.setChecked(r4);
        this.mHideNavHandle.setEnabled(!r2);
        if (this.mCurrentSmartScreenMode != 0) goto L17;
        r1 = true;
    L17:
        setEnabled(r1);
        updateNavModeContainers(r2);
        return;
    L13:
        r4 = false;
        goto L14
    L9:
        r2 = false;
        goto L10
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.android.settings.widget.NavigationBarPreview.Callback
    public void onNavbarOptionsChanged(int r3) {
        android.provider.Settings.Global.putInt(getContentResolver(), "navigation_bar_mode", r3);
        this.mCurrentNavbarMode = r3;
        if (this.mIsBytedanceLauncher == true) goto L5;
        return;
    L5:
        if (this.mIsTipsShown == true) goto L9;
        this.mIsTipsShown = true;
        ToastUtils.show(getActivity(), R.string.navigationbar_option_change_tips);
        return;
    }

    @Override // com.android.settings.widget.NavigationBarPreview.Callback
    public void onNavbarThemeChanged(int r2) {
        android.provider.Settings.Global.putInt(getContentResolver(), "navigationbar_theme", r2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r2) {
        if (r2 != this.mSmartScreenSetting) goto L6;
        start(SmartScreenFragment.class);
        return;
    L6:
        if (r2 != this.mNavbarModeSwitchItem) goto L9;
        onNavbarModeSwitchClicked();
        return;
    L9:
        if (r2 != this.mHideNavHandle) goto L18;
        OSwitch r3 = this.mHideNavSwitch;
        if (this.mCurrentHideNavHandle != 0) goto L13;
        boolean r1 = true;
    L14:
        r3.setChecked(r1);
        return;
    L13:
        r1 = false;
        goto L14
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r2, boolean r3) {
        if (r2 != this.mNavbarSwitch) goto L9;
        if (r3 == false) goto L6;
        int r4 = 0;
    L7:
        this.mHideNavHandle.setEnabled(!r3);
        changeNavModeTo(r4);
        return;
    L6:
        r4 = 2;
        goto L7
    L9:
        if (r2 != this.mHideNavSwitch) goto L13;
        android.provider.Settings.System.putInt(getContentResolver(), settings.Settings.Global.KEY_HIDE_NAVIGATION_BAR, r3 ? 1 : 0);
        this.mCurrentHideNavHandle = r3 ? 1 : 0;
        return;
    }

    private void onNavbarModeSwitchClicked() {
        OSwitch r1 = this.mNavbarSwitch;
        r1.setChecked(!r1.isChecked());
    }

    private void changeNavModeTo(int r5) {
        if (this.mCurrentNavbarTriggerMode != r5) goto L5;
        return;
    L5:
        this.mCurrentNavbarTriggerMode = r5;
        android.provider.Settings.Global.putInt(getContentResolver(), "navigationbar_trigger_mode", r5);
        this.mHandler.removeCallbacks(this.mUpdateNavbarOverlayRunnable);
        this.mHandler.postDelayed(this.mUpdateNavbarOverlayRunnable, 100);
        if (r5 != 0) goto L8;
        boolean r6 = true;
    L9:
        updateNavModeContainers(r6);
        return;
    L8:
        r6 = false;
        goto L9
    }

    private void updateNavModeContainers(boolean r5) {
        View r0 = this.mNavLayoutContainer;
        int r1 = 0;
        if (r5 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        View r2 = this.mGestureContainer;
        if (r5 == false) goto L9;
        int r4 = 8;
    L10:
        r2.setVisibility(r4);
        OCardListItem r6 = this.mHideNavHandle;
        if (r5 == false) goto L13;
        r1 = 8;
    L13:
        r6.setVisibility(r1);
        return;
    L9:
        r4 = 0;
        goto L10
    L5:
        r3 = 8;
        goto L6
    }

    private void updateNavbarOverlay(int r9) {
        OverlayManager r3 = (OverlayManager) getContext().getSystemService("overlay");
        OverlayManagerTransaction.Builder r4 = new OverlayManagerTransaction.Builder();     // Catch: Exception -> L9
        r4.setEnabled(new OverlayIdentifier("com.android.internal.systemui.navbar.threebutton"), false, 0);     // Catch: Exception -> L9
        r4.setEnabled(new OverlayIdentifier("com.android.internal.systemui.navbar.gestural"), false, 0);     // Catch: Exception -> L9
        if (r9 != 0) goto L6;
        OLog.d(this.TAG, "Enabling 3-button overlay");     // Catch: Exception -> L9
        r4.setEnabled(new OverlayIdentifier("com.android.internal.systemui.navbar.threebutton"), true, 0);     // Catch: Exception -> L9
    L7:
        r3.commit(r4.build());     // Catch: Exception -> L9
        OLog.i(this.TAG, "set navbar mode to " + r9 + " success");     // Catch: Exception -> L9
        return;
    L6:
        OLog.d(this.TAG, "Enabling gestural overlay");     // Catch: Exception -> L9
        r4.setEnabled(new OverlayIdentifier("com.android.internal.systemui.navbar.gestural"), true, 0);     // Catch: Exception -> L9
    L9:
        e = move-exception;
        OLog.e(this.TAG, "Error while enabling/disabling navbar overlays", e);
    }

    public void setEnabled(boolean r2) {
        this.mNavbarModeSwitchItem.setEnabled(r2);
        disableNavbarNarrowModeIfNeed();
    }

    private void disableNavbarNarrowModeIfNeed() {
        if (this.mIsTalkbackOn == true) goto L5;
        return;
    L5:
        if (this.mCurrentNavbarMode == 0) goto L9;
        this.mCurrentNavbarMode = 0;
        android.provider.Settings.Global.putInt(getContentResolver(), "navigation_bar_mode", this.mCurrentNavbarMode);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        Runnable r0 = this.mUpdateNavbarOverlayRunnable;
        if (r0 == null) goto L5;
        this.mHandler.removeCallbacks(r0);
    L5:
        SettingsTracker.trackNavigationSettings(this.mContext);
        super.onDestroy();
    }

    @Override // com.android.settings.widget.CustomNavbarStyleView.OnCustomStyleCheckedChangeListener
    public void onCustomStyleSelected(CustomNavbarStyleView r3, boolean r4) {
        if (r3.getId() != R.id.nav_layout_left) goto L6;
        this.mNavLayoutRight.setSelected(false);
        this.mCurrentNavbarLayoutStyle = 0;
    L8:
        android.provider.Settings.System.putInt(getContentResolver(), settings.Settings.Global.KEY_REVERSE_NAVIGATION_BAR, this.mCurrentNavbarLayoutStyle);
        return;
    L6:
        if (r3.getId() != R.id.nav_layout_right) goto L8;
        this.mNavLayoutLeft.setSelected(false);
        this.mCurrentNavbarLayoutStyle = 1;
        goto L8
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_NavbarModeFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(NavbarModeFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_NavbarModeFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_NavbarModeFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(NavbarModeFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_NavbarModeFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_NavbarModeFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(NavbarModeFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_NavbarModeFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
