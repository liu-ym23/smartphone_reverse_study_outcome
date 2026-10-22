package com.android.settings.accessibility;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.UserHandle;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import bytedanceos.util.SettingsUtil;
import com.android.internal.content.PackageMonitor;
import com.android.settings.R;
import com.android.settings.Utils;
import com.android.settings.base.BaseFragment;
import com.android.settings.riskcontrol.RiskPermissionControlGuard;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.DisplayUtils;
import com.android.settings.utils.RegisterUtils;
import com.android.settings.utils.UIUtils;
import com.android.settingslib.RestrictedLockUtils;
import com.android.settingslib.accessibility.AccessibilityUtils;
import com.obric.olog.OLog;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;
import com.obric.oui.dialog.v2.alert.style.DialogContainer;
import com.obric.oui.dialog.v2.alert.style.OViewStyleController;
import com.obric.oui.dialog.v2.common.ODialogListItemView;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.sectiontitlebar.OSectionSupportiveText;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;
import com.obric.oui.toast.OPopupNotice;
import com.obric.privacy.GrantUtil;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class ToggleAccessibilityServiceFragment extends BaseFragment implements DialogInterface.OnClickListener, DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {
    public static String ACCESSIBILITY_MEMORY_PACKAGE_NAME = "com.larus.nova";
    private static final int DIALOG_ID_DISABLE_WARNING = 2;
    private static final int DIALOG_ID_ENABLE_WARNING = 1;
    private static final int DIALOG_ID_VERIFY_PASSWORD = 3;
    public static String ENABLED_ACCESSIBILITY_MEMORY_SERVICES = "enabled_accessibility_memory_services";
    private static final int REQ_VERIFY_LAUNCHER_PASSWORD = 1000;
    private boolean initialState;
    private boolean isDisableDialog;
    private AccessibilityServiceInfo mAccessibilityServiceInfo;
    private OCardListItem mBtn;
    private ComponentName mComponentName;
    private OAlertDialogBuilder mDialog;
    private Drawable mIcon;
    private OCardListItem mItem;
    private String mPreferenceKey;
    private final SettingsContentObserver mSettingsContentObserver;
    protected Intent mSettingsIntent;
    private final PackageMonitor mSettingsPackageMonitor;
    private int mShownDialogId;
    private OSwitch mSwitch;
    private View mSwitchParent;
    private OSectionSupportiveText mTips;
    private final DialogInterface.OnClickListener mVerityPassWordListener;

    static {
    }

    public void com_android_settings_accessibility_ToggleAccessibilityServiceFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_accessibility_ToggleAccessibilityServiceFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_accessibility_ToggleAccessibilityServiceFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_accessibility_ToggleAccessibilityServiceFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    @Override // com.android.settings.base.BaseFragment
    protected boolean shouldMonitorExtDisplayStatus() {
        return true;
    }

    public ToggleAccessibilityServiceFragment() {
        this.mSettingsPackageMonitor = new AnonymousClass1(this);
        final Handler r1 = new Handler();
        this.mSettingsContentObserver = new AnonymousClass2(this, r1);
        this.mVerityPassWordListener = new AnonymousClass3(this);
    }

    static /* synthetic */ String access$000(ToggleAccessibilityServiceFragment r0) {
        return r0.mPreferenceKey;
    }

    static /* synthetic */ ComponentName access$100(ToggleAccessibilityServiceFragment r0) {
        return r0.mComponentName;
    }

    static /* synthetic */ OCardListItem access$200(ToggleAccessibilityServiceFragment r0) {
        return r0.mItem;
    }

    static /* synthetic */ OSwitch access$300(ToggleAccessibilityServiceFragment r0) {
        return r0.mSwitch;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        View r4 = r1.inflate(R.layout.toggle_accessibility_service_fragment_layout, null);
        OCardListItem r5 = (OCardListItem) r4.findViewById(R.id.toggle_accessibility);
        this.mItem = r5;
        r5.setDefaultCustomEndView(1);
        this.mItem.showCustomEnd(true);
        OSwitch r6 = (OSwitch) this.mItem.getCustomEndView();
        this.mSwitch = r6;
        r6.setClickable(false);
        this.mSwitch.setOnTouchListener(new ToggleAccessibilityServiceFragment$$ExternalSyntheticLambda1(this));
        View r7 = (View) this.mSwitch.getParent();
        this.mSwitchParent = r7;
        r7.setOnClickListener(new ToggleAccessibilityServiceFragment$$ExternalSyntheticLambda2(this));
        this.mTips = (OSectionSupportiveText) r4.findViewById(R.id.toggle_tips);
        this.mBtn = (OCardListItem) r4.findViewById(R.id.settings_btn);
        this.mRootView = r4;
        return r4;
    }

    /* JADX INFO: renamed from: lambda$onCreateView$0$com-android-settings-accessibility-ToggleAccessibilityServiceFragment, reason: not valid java name */
    /* synthetic */ boolean m260xf914144f(View r3, MotionEvent r4) {
        if (this.mComponentName != null) goto L5;
    L7:
        return false;
    L5:
        if (RiskPermissionControlGuard.interceptOnActionUp(getActivity(), this.mComponentName.getPackageName(), UserHandle.myUserId(), 32, r4) == false) goto L7;
        return true;
    }

    /* JADX INFO: renamed from: lambda$onCreateView$1$com-android-settings-accessibility-ToggleAccessibilityServiceFragment, reason: not valid java name */
    /* synthetic */ void m261xdc3fc790(View r1) {
        handleClickSwitch(!this.mSwitch.isChecked());
    }

    @Override // com.android.settings.base.BaseFragment
    protected void onExtDisplayChanged(boolean r1) {
        finishIfNeed(r1);
    }

    private void finishIfNeed(boolean r2) {
        if (r2 == true) goto L4;
        return;
    L4:
        if (Utils.isTalkbackApp(this.mContext, this.mPreferenceKey) == false) goto L8;
        finish();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r1) {
        super.onViewStateRestored(r1);
        onProcessArguments(getArguments());
        finishIfNeed(this.mIsExtDisplayConnected);
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle r2) {
        super.onSaveInstanceState(r2);
        getArguments().putBoolean("checked", this.mSwitch.isChecked());
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle r3) {
        super.onActivityCreated(r3);
        this.mSettingsPackageMonitor.register(getActivity(), getActivity().getMainLooper(), false);
    }

    protected void onProcessArguments(Bundle r6) {
        this.mComponentName = (ComponentName) r6.getParcelable(AccessibilitySettings.EXTRA_COMPONENT_NAME);
        this.mPreferenceKey = r6.getString(AccessibilitySettings.EXTRA_PREFERENCE_KEY);
        if (this.mComponentName != null) goto L8;
        String r0 = r6.getString("android.intent.extra.COMPONENT_NAME");
        if (r0 == null) goto L7;
        this.mComponentName = ComponentName.unflattenFromString(r0);
    L7:
        this.mPreferenceKey = r0;
        r6.putBoolean("checked", isServiceEnabledBySettings(this.mComponentName));
    L8:
        boolean r1 = r6.getBoolean("checked");
        ComponentName r2 = this.mComponentName;
        if (r2 != null) goto L11;
    L18:
        this.initialState = r1;
        this.mSwitch.setChecked(r1);
        String r3 = r6.getString("title");
        if (TextUtils.isEmpty(r3) == false) goto L21;
        String r4 = getAccessibilityServiceName(this.mComponentName);
        this.mItem.setTitle(r4);
        setTitle(r4);
    L22:
        CharSequence r5 = r6.getCharSequence("summary", "");
        if (r5.toString().endsWith("。") == false) goto L25;
        r5 = r5.subSequence(0, r5.length() - 1);
    L25:
        this.mTips.setSectionDes(r5.toString());
        if (TextUtils.isEmpty(r5.toString()) == false) goto L28;
        this.mTips.setVisibility(8);
    L28:
        this.isDisableDialog = getArguments().getBoolean(AccessibilitySettings.EXTRA_DISABLE_WARNING_DIALOG, false);
        settingIntentForButton(r6);
        handleFromSearch(r6);
        this.mSettingsContentObserver.register(this.mContext.getContentResolver());
        updateViews();
        return;
    L21:
        this.mItem.setTitle(r3);
        goto L22
    L11:
        if (ACCESSIBILITY_MEMORY_PACKAGE_NAME.equals(r2.getPackageName()) == false) goto L18;
        if (r1 == false) goto L14;
    L17:
        r1 = true;
        goto L18
    L14:
        if (Settings.Secure.getInt(getContentResolver(), ENABLED_ACCESSIBILITY_MEMORY_SERVICES, 0) == 1) goto L17;
        r1 = false;
        goto L18
    }

    public String getAccessibilityServiceName(ComponentName r2) {
        PackageManager r1 = this.mContext.getPackageManager();
        CharSequence r3 = r1.getServiceInfo(r2, 0).loadLabel(r1);     // Catch: Exception -> L9
        if (r3 == null) goto L7;
        return r3.toString();
    L7:
        return null;
    L9:
        return "";
    }

    public Drawable getAccessibilityServiceIcon(ComponentName r2) {
        PackageManager r1 = this.mContext.getPackageManager();
        return r1.getServiceInfo(r2, 0).loadIcon(r1);
    L5:
        return null;
    }

    private void settingIntentForButton(Bundle r5) {
        String r0 = r5.getString(AccessibilitySettings.EXTRA_SETTINGS_TITLE);
        String r1 = r5.getString(AccessibilitySettings.EXTRA_SETTINGS_COMPONENT_NAME);
        if (TextUtils.isEmpty(r0) == false) goto L5;
    L13:
        this.mAccessibilityServiceInfo = (AccessibilityServiceInfo) r5.getParcelable("info");
        Drawable r6 = AccessibilitySettingsFragment.getA11yActivityIcon(getContext(), this.mAccessibilityServiceInfo);
        this.mIcon = r6;
        if (r6 != null) goto L17;
        this.mIcon = getAccessibilityServiceIcon(this.mComponentName);
        return;
    L17:
        return;
    L5:
        if (TextUtils.isEmpty(r1) == true) goto L13;
        final Intent r2 = new Intent("android.intent.action.MAIN").setComponent(ComponentName.unflattenFromString(r1.toString()));
        FragmentActivity r3 = getActivity();
        if (r3 == null) goto L13;
        PackageManager r4 = r3.getPackageManager();
        if (r4 == null) goto L13;
        if (r4.queryIntentActivities(r2, 0).isEmpty() == true) goto L13;
        this.mSettingsIntent = r2;
        this.mBtn.setVisibility(0);
        this.mBtn.setTitle(r0);
        this.mBtn.setOnContentClickListener(new AnonymousClass4(this, r2));
        goto L13
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        updateViews();
    }

    private void updateViews() {
        ComponentName r0 = this.mComponentName;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.mSwitch == null) goto L18;
        String r1 = r0.getPackageName();
        AccessibilityServiceInfo r2 = this.mAccessibilityServiceInfo;
        if (r2 != null) goto L10;
        ResolveInfo r3 = null;
    L11:
        final RestrictedLockUtils.EnforcedAdmin r4 = AccessibilitySettingsFragment.getEnforcedAdmin(this._mActivity, r1, r3);
        if (r4 == null) goto L14;
        this.mSwitch.setEnabled(false);
        this.mItem.setOnContentClickListener(new ToggleAccessibilityServiceFragment$$ExternalSyntheticLambda3(this, r4));
        return;
    L14:
        this.mSwitch.setEnabled(true);
        this.mItem.setOnContentClickListener(null);
        return;
    L10:
        r3 = r2.getResolveInfo();
        goto L11
    }

    /* JADX INFO: renamed from: lambda$updateViews$2$com-android-settings-accessibility-ToggleAccessibilityServiceFragment, reason: not valid java name */
    /* synthetic */ void m264x727a8edc(RestrictedLockUtils.EnforcedAdmin r1, View r2) {
        RestrictedLockUtils.sendShowAdminSupportDetailsIntent(this.mContext, r1);
    }

    private void handleFromSearch(Bundle r4) {
        if (r4.getBoolean("from_search") == false) goto L11;
        this.mComponentName = ComponentName.unflattenFromString(r4.getString(AccessibilitySettings.EXTRA_COMPONENT_NAME));     // Catch: Exception -> L6
        this.mSwitch.setChecked(SettingsUtil.isAccessibilityEnabled(this.mContext, this.mComponentName.getPackageName()));     // Catch: Exception -> L6
        this.isDisableDialog = Boolean.valueOf(r4.getString(AccessibilitySettings.EXTRA_DISABLE_WARNING_DIALOG)).booleanValue();     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        OLog.e(this.TAG, "handleFromSearch failed, error_msg: " + e);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        RegisterUtils.unRegisterSafely(this.TAG, new ToggleAccessibilityServiceFragment$$ExternalSyntheticLambda4(this));
        RegisterUtils.unRegisterSafely(this.TAG, new ToggleAccessibilityServiceFragment$$ExternalSyntheticLambda5(this));
    }

    /* JADX INFO: renamed from: lambda$onDestroy$3$com-android-settings-accessibility-ToggleAccessibilityServiceFragment, reason: not valid java name */
    /* synthetic */ Unit m262xcf3062d3() {
        this.mSettingsPackageMonitor.unregister();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: lambda$onDestroy$4$com-android-settings-accessibility-ToggleAccessibilityServiceFragment, reason: not valid java name */
    /* synthetic */ Unit m263xb25c1614() {
        this.mSettingsContentObserver.unregister(this.mContext.getContentResolver());
        return Unit.INSTANCE;
    }

    public boolean isServiceEnabledBySettings(ComponentName r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        String r2 = Settings.Secure.getString(this.mContext.getContentResolver(), "enabled_accessibility_services");
        if (TextUtils.isEmpty(r2) == false) goto L9;
        return false;
    L9:
        return r2.contains(r3.flattenToString());
    }

    /* JADX INFO: renamed from: lambda$createDialog$5$com-android-settings-accessibility-ToggleAccessibilityServiceFragment, reason: not valid java name */
    /* synthetic */ Unit m259x6cfcdcf8(AccessibilityServiceInfo r2, DialogContainer r3) {
        r3.getBodySlot().addView(createEnableDialogContentView(r2), getBodyLayoutParams(r2));
        return Unit.INSTANCE;
    }

    private OAlertDialogBuilder createDialog(int r10) {
        if (r10 != 1) goto L5;
        this.mShownDialogId = 1;
        final AccessibilityServiceInfo r11 = getAccessibilityServiceInfo();
        if (r11 != null) goto L27;
        return null;
    L27:
        return new OAlertDialogBuilder(getActivity()).autoDismiss(false).horizontalButton(true).title(getString(R.string.enable_service_title, new Object[]{r11.getResolveInfo().loadLabel(getActivity().getPackageManager())}), false).message(R.string.accessibility_warning).imageSize((int) DisplayUtils.dip2px(56.0f), (int) DisplayUtils.dip2px(56.0f)).icon(this.mIcon).iconStroke(true).clipToMask(true).body(new OViewStyleController(new ToggleAccessibilityServiceFragment$$ExternalSyntheticLambda0(this, r11))).negativeButton(android.R.string.cancel, this).positiveButton(R.string.button_enable, this);
    L5:
        if (r10 != 2) goto L7;
        this.mShownDialogId = 2;
        AccessibilityServiceInfo r12 = getAccessibilityServiceInfo();
        if (r12 != null) goto L15;
        return null;
    L15:
        ComponentName r0 = this.mComponentName;
        if (r0 == null) goto L22;
        if (ACCESSIBILITY_MEMORY_PACKAGE_NAME.equals(r0.getPackageName()) == false) goto L22;
        return new OAlertDialogBuilder(getActivity()).autoDismiss(false).horizontalButton().title(getString(R.string.disable_service_title, new Object[]{r12.getResolveInfo().loadLabel(getActivity().getPackageManager())}), false).message(getString(R.string.disable_memory_service_message)).negativeButton(android.R.string.cancel, this).positiveButton(R.string.disable_text, this);
    L22:
        return new OAlertDialogBuilder(getActivity()).autoDismiss(false).horizontalButton().title(getString(R.string.disable_service_title, new Object[]{r12.getResolveInfo().loadLabel(getActivity().getPackageManager())}), false).message(getString(R.string.disable_service_message, new Object[]{r12.getResolveInfo().loadLabel(getActivity().getPackageManager())})).negativeButton(android.R.string.cancel, this).positiveButton(android.R.string.ok, this);
    L7:
        if (r10 != 3) goto L11;
        return new OAlertDialogBuilder(getActivity()).autoDismiss(false).title(R.string.launcher_switch_warning_title).message(R.string.launcher_switch_verify_psw).horizontalButton().negativeButton(android.R.string.cancel, this).positiveButton(android.R.string.ok, this.mVerityPassWordListener);
    L11:
        throw new IllegalArgumentException();
    }

    private void showDialog(int r2) {
        OAlertDialogBuilder r0 = this.mDialog;
        if (r0 == null) goto L5;
        r0.createDialog().dismiss();
        this.mDialog = null;
    L5:
        OAlertDialogBuilder r3 = createDialog(r2);
        this.mDialog = r3;
        if (r3 == null) goto L9;
        r3.show();
        return;
    }

    private AccessibilityServiceInfo getAccessibilityServiceInfo() {
        List<AccessibilityServiceInfo> r0 = AccessibilityManager.getInstance(getActivity()).getInstalledAccessibilityServiceList();
        int r1 = r0.size();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L16;
        AccessibilityServiceInfo r3 = r0.get(r2);
        ResolveInfo r4 = r3.getResolveInfo();
        if (r4 == null) goto L15;
        if (this.mComponentName == null) goto L15;
        if (r4.serviceInfo == null) goto L15;
        if (TextUtils.equals(this.mComponentName.getPackageName(), r4.serviceInfo.packageName) == false) goto L15;
        if (TextUtils.equals(this.mComponentName.getClassName(), r4.serviceInfo.name) == false) goto L15;
        return r3;
    L15:
        r2 = r2 + 1;
        goto L3
    L16:
        return null;
    }

    private View createEnableDialogContentView(AccessibilityServiceInfo r14) {
        View r0 = ((LayoutInflater) getActivity().getSystemService("layout_inflater")).inflate(R.layout.enable_accessibility_service_dialog_content_2, null);
        ((OSectionTitleBar) r0.findViewById(R.id.capabilities_header)).setTitleText(getString(R.string.capabilities_list_title, new Object[]{r14.getResolveInfo().loadLabel(getActivity().getPackageManager())}));
        LinearLayout r1 = (LinearLayout) r0.findViewById(R.id.capabilities);
        ODialogListItemView r4 = new ODialogListItemView(this._mActivity, null);
        r4.setTitle(getString(R.string.capability_title_receiveAccessibilityEvents));
        r4.setSubtitle(getString(R.string.capability_desc_receiveAccessibilityEvents));
        r4.showDivider(true);
        r4.setMinimumHeight(UIUtils.INSTANCE.dp2px(60));
        r1.addView(r4);
        r1.addView(new View(this._mActivity), new ViewGroup.LayoutParams(-1, UIUtils.INSTANCE.dp2px(4)));
        List r15 = r14.getCapabilityInfos();
        int r5 = r15.size();
        int r6 = 0;
    L3:
        if (r6 >= r5) goto L12;
        AccessibilityServiceInfo.CapabilityInfo r10 = (AccessibilityServiceInfo.CapabilityInfo) r15.get(r6);
        ODialogListItemView r11 = new ODialogListItemView(this._mActivity, null);
        r11.setMinimumHeight(UIUtils.INSTANCE.dp2px(60));
        r11.setTitle(getString(r10.titleResId));
        r11.setSubtitle(getString(r10.descResId));
        int r12 = r5 - 1;
        if (r6 == r12) goto L7;
        boolean r13 = true;
    L8:
        r11.showDivider(r13);
        r1.addView(r11);
        if (r6 == r12) goto L11;
        r1.addView(new View(this._mActivity), new ViewGroup.LayoutParams(-1, UIUtils.INSTANCE.dp2px(4)));
    L11:
        r6 = r6 + 1;
        goto L3
    L7:
        r13 = false;
        goto L8
    L12:
        return r0;
    }

    private ViewGroup.LayoutParams getBodyLayoutParams(AccessibilityServiceInfo r3) {
        if (r3.getCapabilityInfos().size() <= 5) goto L7;
        return new ViewGroup.LayoutParams(-1, UIUtils.INSTANCE.dp2px(OPopupNotice.DUX_BOTTOM_NOTICE_SMALL_WINDOW_WIDTH_IN_DP));
    L7:
        return new ViewGroup.LayoutParams(-1, -1);
    }

    private void handleClickSwitch(boolean r6) {
        if (this.mComponentName == null) goto L9;
        if (RiskPermissionControlGuard.intercept(getActivity(), this.mComponentName.getPackageName(), UserHandle.myUserId(), 32) == false) goto L9;
        this.mSwitch.setChecked(!r6);
        return;
    L9:
        if (r6 == false) goto L14;
        getArguments().putBoolean("checked", false);
        if (this.isDisableDialog == false) goto L13;
        onPreferenceToggled(this.mPreferenceKey, true);
        return;
    L13:
        showDialog(1);
        return;
    L14:
        getArguments().putBoolean("checked", true);
        if (this.isDisableDialog == false) goto L17;
        onPreferenceToggled(this.mPreferenceKey, false);
        return;
    L17:
        showDialog(2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
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
    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface r4, int r5) {
        boolean r1 = false;
        ?? r2 = 0;
        if (r5 == (-2)) goto L21;
        if (r5 != (-1)) goto L19;
        if (this.mShownDialogId != 1) goto L9;
        r2 = 1;
    L9:
        onPreferenceToggled(this.mPreferenceKey, r2);
        String r6 = this.mPreferenceKey;
        if (r6 == null) goto L12;
        ComponentName r7 = ComponentName.unflattenFromString(r6);
    L13:
        if (r7 != null) goto L15;
    L17:
        this.initialState = r2;
        this.mSwitch.setChecked(r2);
        r4.dismiss();
        return;
    L15:
        if (ACCESSIBILITY_MEMORY_PACKAGE_NAME.equals(r7.getPackageName()) == false) goto L17;
        Settings.Secure.putInt(getContentResolver(), ENABLED_ACCESSIBILITY_MEMORY_SERVICES, r2);
        goto L17
    L12:
        r7 = null;
        goto L13
    L19:
        throw new IllegalArgumentException();
    L21:
        if (this.mShownDialogId != 2) goto L23;
        r1 = true;
    L23:
        this.mSwitch.setChecked(r1);
        r4.dismiss();
    }

    private void onPreferenceToggled(String r4, boolean r5) {
        if (isAdded() == true) goto L5;
        return;
    L5:
        if (r4 != null) goto L8;
        return;
    L8:
        if (Utils.isTalkbackApp(this.mContext, r4) == false) goto L15;
        if (r5 == false) goto L15;
        if (Utils.hasLockedPackages(this.mContext.getPackageManager()) == false) goto L15;
        showDialog(3);
        return;
    L15:
        if (Utils.isTalkbackApp(this.mContext, r4) == false) goto L18;
        if (r5 == false) goto L18;
        Utils.switchToOriginalLauncher(this.mContext);
    L18:
        Set r0 = AccessibilityUtils.getEnabledServicesFromSettings(this._mActivity);
        if (r0 != Collections.emptySet()) goto L21;
        r0 = new HashSet();
    L21:
        ComponentName r6 = ComponentName.unflattenFromString(r4);
        if (r5 == false) goto L25;
        r0.add(r6);
    L24:
        int r7 = 1;
    L32:
        StringBuilder r8 = new StringBuilder();
        Iterator r1 = r0.iterator();
    L34:
        if (r1.hasNext() == false) goto L36;
        r8.append(((ComponentName) r1.next()).flattenToString());
        r8.append(AccessibilityUtils.ENABLED_ACCESSIBILITY_SERVICES_SEPARATOR);
        goto L34
    L36:
        int r2 = r8.length();
        if (r2 <= 0) goto L39;
        r8.deleteCharAt(r2 - 1);
    L39:
        Settings.Secure.putString(getContentResolver(), "enabled_accessibility_services", r8.toString());
        Settings.Secure.putInt(getContentResolver(), "accessibility_enabled", r7);
        return;
    L25:
        r0.remove(r6);
        Set<ComponentName> r9 = AccessibilitySettingsFragment.sInstalledServices;
        Iterator r10 = r0.iterator();
    L27:
        if (r10.hasNext() == false) goto L31;
        if (r9.contains((ComponentName) r10.next()) == false) goto L27;
    L31:
        r7 = 0;
        goto L32
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface r4) {
        int r5 = this.mShownDialogId;
        boolean r0 = true;
        if (r5 != 1) goto L5;
    L6:
        r0 = false;
    L7:
        this.mSwitch.setChecked(r0);
        return;
    L5:
        if (r5 == 2) goto L7;
        goto L6
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface r1) {
        this.mDialog = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int r3, int r4, Intent r5) {
        if (r3 == 1000) goto L5;
    L8:
        super.onActivityResult(r3, r4, r5);
        return;
    L5:
        if (r4 != RESULT_OK) goto L7;
        Utils.switchToOriginalLauncher(this.mContext);
        onPreferenceToggled(this.mPreferenceKey, true);
        goto L8
    L7:
        this.mSwitch.setChecked(false);
        goto L8
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_accessibility_ToggleAccessibilityServiceFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(ToggleAccessibilityServiceFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_accessibility_ToggleAccessibilityServiceFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_accessibility_ToggleAccessibilityServiceFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(ToggleAccessibilityServiceFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_accessibility_ToggleAccessibilityServiceFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_accessibility_ToggleAccessibilityServiceFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(ToggleAccessibilityServiceFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_accessibility_ToggleAccessibilityServiceFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
