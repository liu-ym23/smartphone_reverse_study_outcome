package com.android.settings;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import com.GlobalProxyLancet;
import com.android.settings.applications.utils.Item;
import com.android.settings.applications.utils.OCardListItemUtils;
import com.android.settings.applications.utils.OPopoverHelper;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.UIUtils;
import com.android.settingslib.dream.DreamBackend;
import com.obric.olog.OLog;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.lisitem.OUICardConstraintLayout;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.popover.v2.OPopover;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class DreamSettings extends BaseFragment implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private static final int DREAM_CATEGORY_HOME_PANEL = 2;
    private static final String LOCKSCREEN_SHOW_CONTROLS = "lockscreen_show_controls";
    private static final String LOG_TAG = "DreamSettings";
    private static final String PACKAGE_SCHEME = "package";
    private static final int[] WHEN_TO_DREAM_VALUES = null;
    private LinearLayout mAdditionalInfoContainer;
    private DreamBackend mBackend;
    private OCardListItem mComplicationsItem;
    private OCardListItem mCustomizeItem;
    private LinearLayout mDreamListContainer;
    private OCardListItem mHomeControlsItem;
    private OCardListItem mMainSwitchItem;
    private final PackageReceiver mPackageReceiver;
    private View mPickerTitle;
    private OCardListItem mPreviewItem;
    private boolean mReceiverRegistered;
    private boolean mRefreshing;
    private OCardListItem mWhenToDreamItem;
    private OPopover mWhenToDreamPopover;

    private class PackageReceiver extends BroadcastReceiver {
        final /* synthetic */ DreamSettings this$0;

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r1, Intent r2) {
            com_android_settings_DreamSettings$PackageReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(this, r1, r2);
        }

        private PackageReceiver(DreamSettings r1) {
            this.this$0 = r1;
        }

        /* synthetic */ PackageReceiver(DreamSettings r1, AnonymousClass1 r2) {
            this(r1);
        }

        public void com_android_settings_DreamSettings$PackageReceiver__onReceive$___twin___(Context r1, Intent r2) {
            DreamSettings.access$300(this.this$0);
        }

        @Insert("onReceive")
        public static void com_android_settings_DreamSettings$PackageReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(PackageReceiver r7, Context r8, Intent r9) {
            Intrinsics.checkNotNullParameter(r8, "context");
            String[] r0 = {"android.bluetooth.device.action.PAIRING_REQUEST", "android.bluetooth.device.action.BOND_STATE_CHANGED", "com.bytedanceos.launcher.new_message", "intent.provision.import_data", "com.android.settings.action.SHOW_IMPORT_DATA_NOTIFICATION"};
            Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.content.BroadcastReceiver");
            PackageReceiver r1 = r7;
            String r2 = r1.getClass().getName();
            String r3 = r1.getClass().getSimpleName();
            boolean r4 = Intrinsics.areEqual(SettingsInitialize.class, r1.getClass());
            String r5 = null;
            if (r9 == null) goto L5;
            String r6 = r9.getAction();
        L7:
            if (ArraysKt.contains(r0, r6) == false) goto L13;
            StringBuilder r10 = new StringBuilder("onReceive allowList ");
            if (r9 == null) goto L11;
            r5 = r9.getAction();
        L11:
            OLog.i("PrivacyHookForReceiver", r10.append(r5).toString());
            r7.com_android_settings_DreamSettings$PackageReceiver__onReceive$___twin___(r8, r9);
            return;
        L13:
            GrantUtil r11 = GrantUtil.INSTANCE;
            Application r12 = SettingsApplication.getApplication();
            Intrinsics.checkNotNullExpressionValue(r12, "getApplication(...)");
            if (r11.isSetupCompelete(r12) == true) goto L16;
            OLog.i("PrivacyHookForReceiver", "onReceive !isSetupCompeleted hooked for " + r3 + ", " + r2);
            r7.com_android_settings_DreamSettings$PackageReceiver__onReceive$___twin___(r8, r9);
            return;
        L16:
            String r13 = r3;
            if (r13 != null) goto L19;
        L22:
            boolean r14 = true;
        L23:
            if (r14 == false) goto L26;
            OLog.i("PrivacyHookForReceiver", "onReceive !simpleName hooked for " + r3 + ", " + r2);
            r7.com_android_settings_DreamSettings$PackageReceiver__onReceive$___twin___(r8, r9);
            return;
        L26:
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == true) goto L30;
            if (r4 == true) goto L30;
            OLog.i("PrivacyHookForReceiver", "onReceive !isPrivacyAllowed hooked for " + r3 + ", " + r2);
            return;
        L30:
            GrantUtil.INSTANCE.applicationInit();
            r7.com_android_settings_DreamSettings$PackageReceiver__onReceive$___twin___(r8, r9);
            return;
        L19:
            if (r13.length() == 0) goto L22;
            r14 = false;
            goto L23
        L5:
            r6 = null;
            goto L7
        }
    }

    private static int getDreamSettingSummaryResId(int r1) {
        if (r1 != 0) goto L4;
        return R.string.screensaver_settings_summary_sleep;
    L4:
        if (r1 != 1) goto L6;
        return R.string.screensaver_settings_summary_dock;
    L6:
        if (r1 == 2) goto L9;
        return R.string.screensaver_settings_summary_never;
    L9:
        return R.string.screensaver_settings_summary_either_long;
    }

    public void com_android_settings_DreamSettings__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    @Override // com.android.settings.base.BaseFragment
    public int getTitleResId() {
        return R.string.screensaver_settings_title;
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_DreamSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_DreamSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    static /* synthetic */ int[] access$100() {
        return WHEN_TO_DREAM_VALUES;
    }

    static /* synthetic */ DreamBackend access$200(DreamSettings r0) {
        return r0.mBackend;
    }

    static /* synthetic */ void access$300(DreamSettings r0) {
        r0.refreshFromBackend();
    }

    static /* synthetic */ OPopover access$400(DreamSettings r0) {
        return r0.mWhenToDreamPopover;
    }

    static /* synthetic */ OPopover access$402(DreamSettings r0, OPopover r1) {
        r0.mWhenToDreamPopover = r1;
        return r1;
    }

    static {
        WHEN_TO_DREAM_VALUES = new int[]{0, 1, 2};
    }

    public DreamSettings() {
        super(R.layout.screen_saver_settings_layout);
        this.mPackageReceiver = new PackageReceiver(this, null);
    }

    @Override // com.android.settings.base.BaseFragment
    public void initViews(View r1, Bundle r2) {
        super.initViews(r1, r2);
        setTitle(R.string.screensaver_settings_title);
        this.mBackend = DreamBackend.getInstance(this.mContext);
        this.mMainSwitchItem = (OCardListItem) findViewById(R.id.screensaver_main_switch);
        this.mWhenToDreamItem = (OCardListItem) findViewById(R.id.screensaver_when_to_dream);
        this.mPreviewItem = (OCardListItem) findViewById(R.id.screensaver_preview);
        this.mCustomizeItem = (OCardListItem) findViewById(R.id.screensaver_customize);
        this.mComplicationsItem = (OCardListItem) findViewById(R.id.screensaver_complications);
        this.mHomeControlsItem = (OCardListItem) findViewById(R.id.screensaver_home_controls);
        this.mDreamListContainer = (LinearLayout) findViewById(R.id.screensaver_dream_list);
        this.mAdditionalInfoContainer = (LinearLayout) findViewById(R.id.screensaver_additional_info_container);
        this.mPickerTitle = findViewById(R.id.screensaver_picker_title);
        initSwitchItem(this.mMainSwitchItem);
        initSwitchItem(this.mComplicationsItem);
        initSwitchItem(this.mHomeControlsItem);
        this.mWhenToDreamItem.setOnContentClickListener(this);
        this.mPreviewItem.setOnContentClickListener(this);
        this.mCustomizeItem.setOnContentClickListener(this);
        UIUtils.setUpBottomPaddingOnApplyWindowInsets((ViewGroup) findViewByIdNullable(R.id.page_container));
        refreshFromBackend();
    }

    private void initSwitchItem(OCardListItem r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.getEndSwitch() == null) goto L9;
        r3.getContentContainer().setClickable(false);
        r3.getEndSwitch().setOnCheckedChangeListener(this);
        return;
    }

    public void com_android_settings_DreamSettings__onResume$___twin___() {
        super.onResume();
        refreshFromBackend();
        registerPackageReceiver();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        unregisterPackageReceiver();
        OPopover r0 = this.mWhenToDreamPopover;
        if (r0 == null) goto L6;
        r0.dismiss();
        this.mWhenToDreamPopover = null;
        return;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r2) {
        if (r2 != this.mWhenToDreamItem.getContentContainer()) goto L6;
        showWhenToDreamPopover();
        return;
    L6:
        if (r2 != this.mPreviewItem.getContentContainer()) goto L9;
        previewActiveDream();
        return;
    L9:
        if (r2 != this.mCustomizeItem.getContentContainer()) goto L14;
        launchActiveDreamSettings();
        return;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r2, boolean r3) {
        if (this.mRefreshing == false) goto L5;
        return;
    L5:
        if (this.mBackend != null) goto L8;
        return;
    L8:
        if (r2 != getEndSwitch(this.mMainSwitchItem)) goto L15;
        if (r3 == true) goto L11;
    L13:
        this.mBackend.setEnabled(r3);
    L20:
        refreshFromBackend();
        return;
    L11:
        if (this.mBackend.getWhenToDreamSetting() != 3) goto L13;
        this.mBackend.setWhenToDream(2);
        goto L20
    L15:
        if (r2 != getEndSwitch(this.mComplicationsItem)) goto L18;
        this.mBackend.setComplicationsEnabled(r3);
        goto L20
    L18:
        if (r2 != getEndSwitch(this.mHomeControlsItem)) goto L20;
        this.mBackend.setHomeControlsEnabled(r3);
        goto L20
    }

    public static int getSummaryResource(Context r1) {
        DreamBackend r2 = DreamBackend.getInstance(r1);
        if (r2.isEnabled() == true) goto L7;
        return R.string.screensaver_settings_summary_off;
    L7:
        return getDreamSettingSummaryResId(r2.getWhenToDreamSetting());
    }

    public static CharSequence getSummaryTextWithDreamName(Context r3) {
        DreamBackend r0 = DreamBackend.getInstance(r3);
        if (r0.isEnabled() == false) goto L10;
        CharSequence r1 = r0.getActiveDreamName();
        Object[] r2 = new Object[1];
        if (TextUtils.isEmpty(r1) == false) goto L7;
        r1 = "";
    L7:
        r2[0] = r1;
        return r3.getString(R.string.screensaver_settings_summary_on, r2);
    L10:
        return r3.getString(R.string.screensaver_settings_summary_off);
    }

    private void refreshFromBackend() {
        DreamBackend r0 = this.mBackend;
        if (r0 != null) goto L5;
        return;
    L5:
        this.mRefreshing = true;
        boolean r1 = r0.isEnabled();
        setSwitchChecked(this.mMainSwitchItem, r1);
        OCardListItemUtils.setCustomEndTipTextView(this.mWhenToDreamItem, getString(getDreamSettingSummaryResId(this.mBackend.getWhenToDreamSetting())));
        setItemEnabled(this.mWhenToDreamItem, r1);
        setItemEnabled(this.mPreviewItem, r1);
        List<DreamBackend.DreamInfo> r2 = this.mBackend.getDreamInfos();
        DreamBackend.DreamInfo r3 = getActiveDream(r2);
        updateDreamList(r2, r1);
        updateCustomizeItem(r3, r1);
        updateComplicationItems(r3, r1);
        this.mRefreshing = false;
    }

    private void updateDreamList(List<DreamBackend.DreamInfo> r8, boolean r9) {
        this.mDreamListContainer.removeAllViews();
        if (r8 != null) goto L5;
    L30:
        this.mPickerTitle.setVisibility(8);
        this.mDreamListContainer.setVisibility(8);
        return;
    L5:
        if (r8.isEmpty() == true) goto L30;
        this.mPickerTitle.setVisibility(0);
        this.mDreamListContainer.setVisibility(0);
        int r0 = 0;
    L9:
        if (r0 >= r8.size()) goto L29;
        final DreamBackend.DreamInfo r2 = r8.get(r0);
        OCardListItem r3 = new OCardListItem(this.mContext);
        r3.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        OCardListItemUtils.initCardItemInAdapter(r3, r8.size(), r0);
        r3.showTailIcon(false);
        r3.setDefaultCustomEndView(2);
        if (r9 == true) goto L13;
    L15:
        boolean r5 = false;
    L16:
        r3.showCustomEnd(r5);
        if (r2.icon == null) goto L19;
        r3.setAppIcon(r2.icon);
        r3.showIcon(true);
    L20:
        OCardListItemUtils.setTitle(r3, getDreamTitle(r2));
        if (TextUtils.isEmpty(r2.description) == true) goto L23;
        r3.setSubTitle(r2.description);
        r3.showSubTitle(true);
    L24:
        setItemEnabled(r3, r9);
        if (r9 == false) goto L27;
        View.OnClickListener r4 = new DreamSettings$$ExternalSyntheticLambda0(this, r2);
    L28:
        r3.setOnContentClickListener(r4);
        this.mDreamListContainer.addView(r3);
        r0 = r0 + 1;
        goto L9
    L27:
        r4 = null;
        goto L28
    L23:
        r3.showSubTitle(false);
        goto L24
    L19:
        r3.showIcon(false);
        goto L20
    L13:
        if (r2.isActive == false) goto L15;
        r5 = true;
        goto L16
    }

    /* JADX INFO: renamed from: lambda$updateDreamList$0$com-android-settings-DreamSettings, reason: not valid java name */
    /* synthetic */ void m131lambda$updateDreamList$0$comandroidsettingsDreamSettings(DreamBackend.DreamInfo r1, View r2) {
        selectDream(r1);
    }

    private void updateCustomizeItem(DreamBackend.DreamInfo r3, boolean r4) {
        int r0 = 0;
        if (r3 != null) goto L5;
    L7:
        boolean r5 = false;
    L8:
        OCardListItem r1 = this.mCustomizeItem;
        if (r5 == true) goto L12;
        r0 = 8;
    L12:
        r1.setVisibility(r0);
        OCardListItem r2 = this.mPreviewItem;
        if (r5 == false) goto L15;
        int r6 = 2;
    L16:
        r2.setCardPosition(r6);
        setItemEnabled(this.mCustomizeItem, r4);
        return;
    L15:
        r6 = 3;
        goto L16
    L5:
        if (r3.settingsComponentName == null) goto L7;
        r5 = true;
        goto L8
    }

    private void updateComplicationItems(DreamBackend.DreamInfo r8, boolean r9) {
        boolean r0 = true;
        if (r8 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        boolean r3 = isHomeControlsAvailable();
        OCardListItem r4 = this.mComplicationsItem;
        int r5 = 8;
        if (r2 == false) goto L11;
        int r6 = 0;
    L12:
        r4.setVisibility(r6);
        OCardListItem r7 = this.mHomeControlsItem;
        if (r3 == false) goto L15;
        int r10 = 0;
    L16:
        r7.setVisibility(r10);
        LinearLayout r11 = this.mAdditionalInfoContainer;
        if (r2 == true) goto L19;
        if (r3 == true) goto L19;
    L20:
        r11.setVisibility(r5);
        OCardListItemUtils.updateGroupContainer(new OCardListItem[]{this.mComplicationsItem, this.mHomeControlsItem});
        setSwitchChecked(this.mComplicationsItem, this.mBackend.getComplicationsEnabled());
        setSwitchChecked(this.mHomeControlsItem, isHomeControlsChecked());
        setItemEnabled(this.mComplicationsItem, r9);
        OCardListItem r12 = this.mHomeControlsItem;
        if (r9 == true) goto L23;
    L25:
        r0 = false;
    L26:
        setItemEnabled(r12, r0);
        return;
    L23:
        if (isHomePanelDream(r8) == true) goto L25;
    L19:
        r5 = 0;
        goto L20
    L15:
        r10 = 8;
        goto L16
    L11:
        r6 = 8;
        goto L12
    L5:
        if (r8.supportsComplications == false) goto L7;
        r2 = true;
        goto L8
    }

    private void selectDream(DreamBackend.DreamInfo r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r2.isActive == true) goto L9;
        this.mBackend.setActiveDream(r2.componentName);
        refreshFromBackend();
        return;
    }

    private void showWhenToDreamPopover() {
        if (this._mActivity != null) goto L5;
        return;
    L5:
        if (this.mBackend.isEnabled() == false) goto L21;
        ArrayList r0 = new ArrayList();
        int r1 = this.mBackend.getWhenToDreamSetting();
        int[] r2 = WHEN_TO_DREAM_VALUES;
        int r3 = r2.length;
        int r5 = 0;
    L8:
        boolean r6 = true;
        if (r5 >= r3) goto L15;
        int r7 = r2[r5];
        String r9 = getString(getDreamSettingSummaryResId(r7));
        if (r1 == r7) goto L14;
        r6 = false;
    L14:
        r0.add(new Item(r9, r6));
        r5 = r5 + 1;
        goto L8
    L15:
        this.mWhenToDreamPopover = OPopoverHelper.showPopoverList(this._mActivity, this.mWhenToDreamItem, r0, new AnonymousClass1(this), true);
        return;
    }

    private void previewActiveDream() {
        if (this.mBackend.isEnabled() == true) goto L5;
        return;
    L5:
        DreamBackend r1 = this.mBackend;
        r1.preview(r1.getActiveDream());
    }

    private void launchActiveDreamSettings() {
        DreamBackend.DreamInfo r0 = getActiveDream(this.mBackend.getDreamInfos());
        if (this.mBackend.isEnabled() == false) goto L10;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.settingsComponentName == null) goto L12;
        this.mBackend.launchSettings(this.mContext, r0);
        return;
    L12:
        return;
    }

    private void registerPackageReceiver() {
        if (this.mReceiverRegistered == false) goto L5;
        return;
    L5:
        IntentFilter r0 = new IntentFilter();
        r0.addAction("android.intent.action.PACKAGE_ADDED");
        r0.addAction("android.intent.action.PACKAGE_CHANGED");
        r0.addAction("android.intent.action.PACKAGE_REMOVED");
        r0.addAction("android.intent.action.PACKAGE_REPLACED");
        r0.addDataScheme("package");
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this.mContext, this.mPackageReceiver, r0, 2);
        this.mReceiverRegistered = true;
    }

    private void unregisterPackageReceiver() {
        if (this.mReceiverRegistered == true) goto L11;
        return;
    L11:
        this.mContext.unregisterReceiver(this.mPackageReceiver);     // Catch: IllegalArgumentException -> L7
    L9:
        this.mReceiverRegistered = false;
        return;
    L7:
        e = move-exception;
        OLog.e(LOG_TAG, "unregister package receiver failed", e);
        goto L9
    }

    private DreamBackend.DreamInfo getActiveDream(List<DreamBackend.DreamInfo> r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        Iterator<DreamBackend.DreamInfo> r4 = r3.iterator();
    L7:
        if (r4.hasNext() == false) goto L13;
        DreamBackend.DreamInfo r0 = r4.next();
        if (r0 == null) goto L7;
        if (r0.isActive == false) goto L7;
        return r0;
    L13:
        return null;
    }

    private CharSequence getDreamTitle(DreamBackend.DreamInfo r2) {
        if (r2 != null) goto L6;
        return "";
    L6:
        if (TextUtils.isEmpty(r2.caption) == true) goto L10;
        return r2.caption;
    L10:
        if (r2.componentName != null) goto L13;
        return "";
    L13:
        return r2.componentName.flattenToShortString();
    }

    private boolean isHomeControlsAvailable() {
        if (isLockscreenControlsEnabled() == true) goto L5;
    L7:
        return false;
    L5:
        if (getSupportedComplications().contains(6) == false) goto L7;
        return true;
    }

    private boolean isHomeControlsChecked() {
        return getEnabledComplications().contains(6);
    }

    private Set<Integer> getSupportedComplications() {
        return this.mBackend.getSupportedComplications();
    }

    private Set<Integer> getEnabledComplications() {
        return this.mBackend.getEnabledComplications();
    }

    private boolean isLockscreenControlsEnabled() {
        if (android.provider.Settings.Secure.getInt(getContentResolver(), LOCKSCREEN_SHOW_CONTROLS, 0) == 0) goto L6;
        return true;
    L6:
        return false;
    }

    private boolean isHomePanelDream(DreamBackend.DreamInfo r1) {
        if (r1 != null) goto L4;
    L6:
        return false;
    L4:
        if ((r1.dreamCategory & 2) == 0) goto L6;
        return true;
    }

    private void setSwitchChecked(OCardListItem r1, boolean r2) {
        OSwitch r0 = getEndSwitch(r1);
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isChecked() == r2) goto L9;
        r0.setChecked(r2);
        return;
    }

    private OSwitch getEndSwitch(OCardListItem r1) {
        if (r1 != null) goto L5;
        return null;
    L5:
        return r1.getEndSwitch();
    }

    private void setItemEnabled(OCardListItem r3, boolean r4) {
        if (r3 != null) goto L4;
        return;
    L4:
        r3.setEnabled(r4);
        OUICardConstraintLayout r0 = r3.getContentContainer();
        if (r0 == null) goto L11;
        r0.setEnabled(r4);
        if (r4 == false) goto L9;
        float r1 = 1.0f;
    L10:
        r0.setAlpha(r1);
        goto L11
    L9:
        r1 = 0.4f;
    L11:
        OSwitch r2 = getEndSwitch(r3);
        if (r2 == null) goto L15;
        r2.setEnabled(r4);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_DreamSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(DreamSettings r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_DreamSettings__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_DreamSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(DreamSettings r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_DreamSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_DreamSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(DreamSettings r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_DreamSettings__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
