package com.android.settings;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import com.GlobalProxyLancet;
import com.android.settings.base.BaseActivity;
import com.android.settings.base.BaseFragment;
import com.android.settings.provision.ProvisionConstants;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.DevicePolicyUtils;
import com.android.settings.utils.MinorUtils;
import com.android.settings.widget.DatePickerDialog;
import com.android.settings.widget.TimePickerDialog;
import com.obric.olog.OLog;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;
import com.obric.privacy.GrantUtil;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class DateTimeSettingsFragment extends BaseFragment implements CompoundButton.OnCheckedChangeListener, View.OnClickListener, TimePickerDialog.OnTimeSetListener, DatePickerDialog.OnDateSetListener {
    private static final String HOURS_12 = "12";
    private static final String HOURS_24 = "24";
    private LinearLayout mContainer;
    private OSectionTitleBar mDateTimeTitle;
    private BroadcastReceiver mIntentReceiver;
    private OCardListItem mItemUnitC;
    private OCardListItem mItemUnitF;
    private Button mNextBtn;
    private View mNextBtnGroup;
    ScrollView mScrollView;
    private boolean mSetupWizardMode;
    private OCardListItem mSwitchAutoSet;
    private OSwitch mSwitchAutoSetSwitch;
    private View mTemperatureLayout;
    private OCardListItem mTimezoneTimeSettings;
    private OCardListItem mViewDateSet;
    private OCardListItem mViewTimeMode;
    private OSwitch mViewTimeModeSwitch;
    private OCardListItem mViewTimeSet;
    private OCardListItem mViewZoneSet;
    private ImageView mWizardSetupImage;

    public void com_android_settings_DateTimeSettingsFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_DateTimeSettingsFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_DateTimeSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_DateTimeSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public DateTimeSettingsFragment() {
        this.mIntentReceiver = new AnonymousClass1(this);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        this.mSetupWizardMode = getArguments().getBoolean(ProvisionConstants.EXTRA_SETUPWIZARD, false);
        this.mRootView = r3.inflate(R.layout.date_time_setting, r4, false);
        OCardListItem r6 = (OCardListItem) findViewByIdNullable(R.id.switch_date_time_auto_set);
        this.mSwitchAutoSet = r6;
        r6.setDefaultCustomEndView(1);
        this.mSwitchAutoSet.showCustomEnd(true);
        this.mSwitchAutoSetSwitch = (OSwitch) this.mSwitchAutoSet.getCustomEndView();
        if (MinorUtils.INSTANCE.getMinorsModeState(this.mContext) == false) goto L5;
        this.mSwitchAutoSet.setEnabled(false);
    L5:
        this.mContainer = (LinearLayout) findViewByIdNullable(R.id.items_container);
        OCardListItem r7 = (OCardListItem) findViewByIdNullable(R.id.item_date_set);
        this.mViewDateSet = r7;
        r7.setDefaultCustomEndView(3);
        this.mViewDateSet.showCustomEnd(true);
        this.mViewDateSet.setOnContentClickListener(new DateTimeSettingsFragment$$ExternalSyntheticLambda0(this));
        OCardListItem r8 = (OCardListItem) findViewByIdNullable(R.id.item_time_set);
        this.mViewTimeSet = r8;
        r8.setDefaultCustomEndView(3);
        this.mViewTimeSet.showCustomEnd(true);
        this.mViewTimeSet.setOnContentClickListener(new DateTimeSettingsFragment$$ExternalSyntheticLambda1(this));
        OCardListItem r9 = (OCardListItem) findViewByIdNullable(R.id.item_zone_set);
        this.mViewZoneSet = r9;
        r9.setDefaultCustomEndView(3);
        this.mViewZoneSet.showCustomEnd(true);
        this.mViewZoneSet.setOnContentClickListener(new DateTimeSettingsFragment$$ExternalSyntheticLambda2(this));
        OCardListItem r10 = (OCardListItem) findViewByIdNullable(R.id.timezone_time_settings);
        this.mTimezoneTimeSettings = r10;
        r10.setOnContentClickListener(new DateTimeSettingsFragment$$ExternalSyntheticLambda3(this));
        View r11 = findViewByIdNullable(R.id.double_timezone_settings_container);
        if (SettingsFeature.ENABLE_DOUBLE_TIMEZONE_FEATURE == false) goto L8;
        int r12 = 0;
    L9:
        r11.setVisibility(r12);
        OCardListItem r13 = (OCardListItem) findViewByIdNullable(R.id.switch_time_display_mode);
        this.mViewTimeMode = r13;
        r13.setDefaultCustomEndView(1);
        this.mViewTimeMode.showCustomEnd(true);
        this.mViewTimeModeSwitch = (OSwitch) this.mViewTimeMode.getCustomEndView();
        this.mTitleResId = Integer.valueOf(R.string.date_time_temperature_title);
        this.mDateTimeTitle = (OSectionTitleBar) findViewByIdNullable(R.id.date_time_setting_title);
        this.mTemperatureLayout = findViewByIdNullable(R.id.temperature_unit_setting_layout);
        OCardListItem r14 = (OCardListItem) findViewByIdNullable(R.id.unit_celsius);
        this.mItemUnitC = r14;
        r14.setTitle(getString(R.string.temperature_unit_celsius));
        this.mItemUnitC.setOnContentClickListener(new DateTimeSettingsFragment$$ExternalSyntheticLambda4(this));
        this.mItemUnitC.setDefaultCustomEndView(2);
        this.mItemUnitC.showCustomEnd(false);
        OCardListItem r15 = (OCardListItem) findViewByIdNullable(R.id.unit_fahrenheit);
        this.mItemUnitF = r15;
        r15.setTitle(getString(R.string.temperature_unit_fahrenheit));
        this.mItemUnitF.setOnContentClickListener(new DateTimeSettingsFragment$$ExternalSyntheticLambda5(this));
        this.mItemUnitF.setDefaultCustomEndView(2);
        this.mItemUnitF.showCustomEnd(false);
        this.mWizardSetupImage = (ImageView) findViewByIdNullable(R.id.wizard_setup_image);
        Button r16 = (Button) findViewByIdNullable(R.id.next_step_btn);
        this.mNextBtn = r16;
        r16.setOnClickListener(this);
        this.mNextBtnGroup = findViewByIdNullable(R.id.next_step_btn_group);
        this.mScrollView = (ScrollView) findViewByIdNullable(R.id.page_scrollview);
        if (this.mIsExtDisplayConnected == false) goto L13;
        this.mScrollView.setVerticalScrollBarEnabled(false);
    L13:
        if (this.mSetupWizardMode == false) goto L18;
        this.mTitleResId = Integer.valueOf(R.string.date_and_time_settings_title_setup_wizard);
        RelativeLayout.LayoutParams r17 = (RelativeLayout.LayoutParams) this.mScrollView.getLayoutParams();
        r17.bottomMargin = getResources().getDimensionPixelSize(R.dimen.bottom_line_bottom_margin);
        this.mScrollView.setLayoutParams(r17);
        if ((getActivity() instanceof BaseActivity) == false) goto L18;
        ((BaseActivity) getActivity()).registerWizardFinishReceiver();
    L18:
        return this.mRootView;
    L8:
        r12 = 8;
        goto L9
    }

    /* JADX INFO: renamed from: lambda$onCreateView$0$com-android-settings-DateTimeSettingsFragment, reason: not valid java name */
    /* synthetic */ void m114x8d1d2553(View r1) {
        onClick(this.mViewDateSet);
    }

    /* JADX INFO: renamed from: lambda$onCreateView$1$com-android-settings-DateTimeSettingsFragment, reason: not valid java name */
    /* synthetic */ void m115x2974b94(View r1) {
        onClick(this.mViewTimeSet);
    }

    /* JADX INFO: renamed from: lambda$onCreateView$2$com-android-settings-DateTimeSettingsFragment, reason: not valid java name */
    /* synthetic */ void m116x781171d5(View r1) {
        onClick(this.mViewZoneSet);
    }

    /* JADX INFO: renamed from: lambda$onCreateView$3$com-android-settings-DateTimeSettingsFragment, reason: not valid java name */
    /* synthetic */ void m117xed8b9816(View r1) {
        onClick(this.mTimezoneTimeSettings);
    }

    /* JADX INFO: renamed from: lambda$onCreateView$4$com-android-settings-DateTimeSettingsFragment, reason: not valid java name */
    /* synthetic */ void m118x6305be57(View r1) {
        onClick(this.mItemUnitC);
    }

    /* JADX INFO: renamed from: lambda$onCreateView$5$com-android-settings-DateTimeSettingsFragment, reason: not valid java name */
    /* synthetic */ void m119xd87fe498(View r1) {
        onClick(this.mItemUnitF);
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
    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r2, Bundle r3) {
        super.onViewCreated(r2, r3);
        boolean r4 = getAutoState("auto_time");
        this.mSwitchAutoSet.setCardPosition(!r4 ? 1 : 0);
        this.mViewDateSet.setEnabled(!r4);
        this.mViewTimeSet.setEnabled(!r4);
        this.mViewZoneSet.setEnabled(!r4);
        LinearLayout r5 = this.mContainer;
        if (r4 == false) goto L5;
        int r6 = 8;
    L6:
        r5.setVisibility(r6);
        updateTimeAndDateDisplay(this.mContext);
        return;
    L5:
        r6 = 0;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r2) {
        super.onViewStateRestored(r2);
        updateViews();
        boolean r3 = getAutoState("auto_time");
        this.mViewTimeModeSwitch.setOnCheckedChangeListener(this);
        this.mSwitchAutoSetSwitch.setChecked(r3);
        this.mSwitchAutoSetSwitch.setOnCheckedChangeListener(this);
    }

    private void registeTimeChangeReceiver() {
        IntentFilter r0 = new IntentFilter();
        r0.addAction("android.intent.action.TIME_TICK");
        r0.addAction("android.intent.action.TIME_SET");
        r0.addAction("android.intent.action.TIMEZONE_CHANGED");
        if (getActivity() == null) goto L6;
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(getActivity(), this.mIntentReceiver, r0, null, null);
        return;
    }

    public void updateViews() {
        updateTimeAndDateDisplay(this.mContext);
        this.mViewTimeModeSwitch.setChecked(is24Hour());
        if (this.mSetupWizardMode == true) goto L5;
        updateTemperatureUnitDisplay(getCurrentTemperatureUnit());
    L5:
        registeTimeChangeReceiver();
        updateWizardView();
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        updateViews();
    }

    private void updateWizardView() {
        if (this.mSetupWizardMode == false) goto L6;
        this.mViewDateSet.setEnabled(true);
        this.mViewTimeSet.setEnabled(true);
        this.mViewZoneSet.setEnabled(true);
        this.mContainer.setVisibility(0);
        this.mWizardSetupImage.setVisibility(0);
        this.mNextBtnGroup.setVisibility(0);
        this.mSwitchAutoSet.setVisibility(8);
        this.mDateTimeTitle.setVisibility(8);
        this.mTemperatureLayout.setVisibility(8);
        return;
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        unregisterReceiver(this.mIntentReceiver);
    }

    public void updateTimeAndDateDisplay(Context r5) {
        DateFormat r6 = android.text.format.DateFormat.getDateFormat(r5);
        Calendar r0 = Calendar.getInstance();
        this.mViewTimeSet.setEndDetailText(android.text.format.DateFormat.getTimeFormat(this.mContext).format(r0.getTime()));
        this.mViewZoneSet.setEndDetailText(getTimeZoneText(r0.getTimeZone()));
        this.mViewDateSet.setEndDetailText(r6.format(r0.getTime()));
    }

    private static String getTimeZoneText(TimeZone r2) {
        return ZonePicker.getTimezoneText(r2, new Date().getTime());
    }

    private void updateTemperatureUnitDisplay(int r3) {
        if (r3 != 1) goto L5;
        this.mItemUnitC.showCustomEnd(true);
        this.mItemUnitF.showCustomEnd(false);
        return;
    L5:
        this.mItemUnitF.showCustomEnd(true);
        this.mItemUnitC.showCustomEnd(false);
    }

    private int getCurrentTemperatureUnit() {
        return android.provider.Settings.System.getInt(getContentResolver(), "temperature_unit", 1);
    }

    private void setCurrentTemperatureUnit(int r2) {
        android.provider.Settings.System.putInt(getContentResolver(), "temperature_unit", r2);
    }

    private boolean isMinorMode(String r3) {
        if (MinorUtils.INSTANCE.getMinorsModeState(this.mContext) == false) goto L6;
        ToastUtils.show(getActivity(), r3);
        return true;
    L6:
        return false;
    }

    private boolean isConfigDateTimeRestrictedByAdmin() {
        return DevicePolicyUtils.hasUserRestriction(this.mContext, "no_config_date_time");
    }

    private boolean interceptIfConfigDateTimeRestricted() {
        if (isConfigDateTimeRestrictedByAdmin() == true) goto L6;
        return false;
    L6:
        DevicePolicyUtils.trySendShowAdminSupportDetailsIntent(this.mContext, "no_config_date_time");
        return true;
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
    public void onCheckedChanged(CompoundButton r4, boolean r5) {
        if (r4 != this.mSwitchAutoSetSwitch) goto L17;
        if (interceptIfConfigDateTimeRestricted() == false) goto L9;
        boolean r6 = getAutoState("auto_time");
        this.mSwitchAutoSetSwitch.setOnCheckedChangeListener(null);
        this.mSwitchAutoSetSwitch.setChecked(r6);
        this.mSwitchAutoSetSwitch.setOnCheckedChangeListener(this);
        return;
    L9:
        if (isMinorMode(getString(R.string.minor_time_error_text)) == false) goto L11;
        return;
    L11:
        this.mViewDateSet.setEnabled(!r5);
        this.mViewTimeSet.setEnabled(!r5);
        this.mViewZoneSet.setEnabled(!r5);
        LinearLayout r7 = this.mContainer;
        if (r5 == false) goto L14;
        int r1 = 8;
    L15:
        r7.setVisibility(r1);
        this.mSwitchAutoSet.setCardPosition(!r5 ? 1 : 0);
        android.provider.Settings.Global.putInt(getContentResolver(), "auto_time", r5 ? 1 : 0);
        OLog.e(this.TAG, "set AUTO_TIME, and now state is " + getAutoState("auto_time"));
        android.provider.Settings.Global.putInt(getContentResolver(), "auto_time_zone", r5 ? 1 : 0);
        android.provider.Settings.System.putInt(getContentResolver(), Constants.USE_AUTO_TIME_SWITCH, 1);
        return;
    L14:
        r1 = 0;
        goto L15
    L17:
        if (r4 != this.mViewTimeModeSwitch) goto L21;
        set24Hour(r5);
        updateTimeAndDateDisplay(this.mContext);
        timeUpdated();
        return;
    }

    private void timeUpdated() {
        Intent r0 = new Intent("android.intent.action.TIME_SET");
        r0.putExtra("TIME_12_24_MODE_CHANGED", true);
        sendBroadcast(r0);
    }

    private boolean is24Hour() {
        return android.text.format.DateFormat.is24HourFormat(this.mContext);
    }

    private void set24Hour(boolean r2) {
        ContentResolver r1 = getContentResolver();
        if (r2 == false) goto L5;
        String r3 = HOURS_24;
    L6:
        android.provider.Settings.System.putString(r1, "time_12_24", r3);
        return;
    L5:
        r3 = HOURS_12;
        goto L6
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r12) {
        Calendar r0 = Calendar.getInstance();
        int r3 = 2;
        switch(r12.getId()) {
            case 2131429317: goto L38;
            case 2131429546: goto L28;
            case 2131429573: goto L18;
            case 2131430083: goto L16;
            case 2131431332: goto L10;
            case 2131431563: goto L6;
            case 2131431564: goto L6;
            default: goto L53;
        };
    L16:
        Intent r13 = new Intent();
        r13.setClassName("com.bytedanceos.setupwizard", "com.bytedanceos.setupwizard.ServiceActivity");
        Utils.startActivity(this._mActivity, r13);
        return;
    L53:
        return;
    L6:
        if (r12.getId() != R.id.unit_celsius) goto L8;
        r3 = 1;
    L8:
        updateTemperatureUnitDisplay(r3);
        setCurrentTemperatureUnit(r3);
        return;
    L10:
        if (interceptIfConfigDateTimeRestricted() == false) goto L12;
        return;
    L12:
        Intent r14 = new Intent(this.mContext, TimezoneSettingsActivity.class);
        if (this.mTitleResId == null) goto L15;
        r14.putExtra("back_text_id", this.mTitleResId);
    L15:
        Utils.startActivity(this._mActivity, r14);
        return;
    L18:
        if (interceptIfConfigDateTimeRestricted() == false) goto L21;
        return;
    L21:
        if (isMinorMode(getString(R.string.minor_time_error_text)) == false) goto L23;
        return;
    L23:
        Intent r15 = new Intent(this.mContext, ZonePickerActivity.class);
        if (this.mTitleResId == null) goto L26;
        r15.putExtra("back_text_id", this.mTitleResId);
    L26:
        Utils.startActivity(this._mActivity, r15);
        return;
    L28:
        if (interceptIfConfigDateTimeRestricted() == false) goto L31;
        return;
    L31:
        if (Utils.isFastDoubleClick() == false) goto L34;
        return;
    L34:
        if (isMinorMode(getString(R.string.minor_time_error_text)) == false) goto L36;
        return;
    L36:
        new TimePickerDialog(requireActivity(), getString(R.string.date_time_set_time), this, r0.get(11), r0.get(12), android.text.format.DateFormat.is24HourFormat(this.mContext)).show();
        return;
    L38:
        if (interceptIfConfigDateTimeRestricted() == false) goto L41;
        return;
    L41:
        if (Utils.isFastDoubleClick() == false) goto L44;
        return;
    L44:
        if (isMinorMode(getString(R.string.minor_time_error_text)) == false) goto L46;
        return;
    L46:
        new DatePickerDialog(requireActivity(), this, r0.get(1), r0.get(2) + 1, r0.get(5)).show();
    }

    private boolean getAutoState(String r2) {
        if (android.provider.Settings.System.getInt(getContentResolver(), r2) <= 0) goto L10;
        return true;
    L10:
        return false;
    L11:
        return false;
    }

    @Override // com.android.settings.widget.DatePickerDialog.OnDateSetListener
    public void onDateSet(int r1, int r2, int r3) {
        setDate(r1, r2, r3);
        if (isAdded() == false) goto L6;
        updateTimeAndDateDisplay(this.mContext);
        return;
    }

    @Override // com.android.settings.widget.TimePickerDialog.OnTimeSetListener
    public void onTimeSet(int r1, int r2) {
        setTime(r1, r2);
        if (isAdded() == false) goto L6;
        updateTimeAndDateDisplay(this.mContext);
        return;
    }

    private static void setDate(int r2, int r3, int r4) {
        Calendar r0 = Calendar.getInstance();
        r0.set(1, r2);
        r0.set(2, r3 - 1);
        r0.set(5, r4);
        SystemClock.setCurrentTimeMillis(r0.getTimeInMillis());
    }

    private static void setTime(int r2, int r3) {
        Calendar r0 = Calendar.getInstance();
        r0.set(11, r2);
        r0.set(12, r3);
        r0.set(13, 0);
        r0.set(14, 0);
        SystemClock.setCurrentTimeMillis(r0.getTimeInMillis());
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_DateTimeSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(DateTimeSettingsFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_DateTimeSettingsFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_DateTimeSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(DateTimeSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_DateTimeSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_DateTimeSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(DateTimeSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_DateTimeSettingsFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
