package com.android.settings;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.EditText;
import com.GlobalProxyLancet;
import com.android.internal.telephony.IccCard;
import com.android.internal.telephony.Phone;
import com.android.internal.telephony.PhoneFactory;
import com.android.settings.base.BaseActivity;
import com.android.settings.teaevent.AppMetricsUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.SettingItemSwitch;
import obric.widget.SettingItemText;
import obric.widget.SwitchEx;

/* JADX INFO: loaded from: classes2.dex */
public class SimPinSettingsActivity extends BaseActivity implements View.OnClickListener, DialogInterface.OnClickListener {
    private static final int ICC_LOCK_MODE = 1;
    private static final int ICC_NEW_MODE = 3;
    private static final int ICC_OLD_MODE = 2;
    private static final int ICC_REENTER_MODE = 4;
    private static final int MAX_PIN_LENGTH = 8;
    private static final int MIN_PIN_LENGTH = 4;
    private static final int MSG_CHANGE_ICC_PIN_COMPLETE = 101;
    private static final int MSG_ENABLE_ICC_PIN_COMPLETE = 100;
    private static final int MSG_SIM_STATE_CHANGED = 102;
    private static final int OFF_MODE = 0;
    private SwitchEx mCheckBoxEnablePin;
    private AlertDialog.Builder mDialogBuilder;
    private String mDialogMessage;
    private int mDialogState;
    private String mDialogTitle;
    private String mError;
    private final Handler mHandler;
    private String mNewPin;
    private String mOldPin;
    private Phone mPhone;
    private String mPin;
    private EditText mPinEdit;
    private Resources mRes;
    private final BroadcastReceiver mSimStateReceiver;
    private SettingItemSwitch mViewEnablePin;
    private SettingItemText mViewModifyPin;

    public void com_android_settings_SimPinSettingsActivity__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_SimPinSettingsActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_settings_SimPinSettingsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        com_android_settings_SimPinSettingsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        com_android_settings_SimPinSettingsActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_SimPinSettingsActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_SimPinSettingsActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public SimPinSettingsActivity() {
        this.mDialogState = 0;
        this.mHandler = new AnonymousClass1(this);
        this.mSimStateReceiver = new AnonymousClass2(this);
    }

    static /* synthetic */ void access$000(SimPinSettingsActivity r0, boolean r1) {
        r0.iccLockChanged(r1);
    }

    static /* synthetic */ void access$100(SimPinSettingsActivity r0, boolean r1) {
        r0.iccPinChanged(r1);
    }

    static /* synthetic */ void access$200(SimPinSettingsActivity r0) {
        r0.updateViews();
    }

    static /* synthetic */ Handler access$300(SimPinSettingsActivity r0) {
        return r0.mHandler;
    }

    public void com_android_settings_SimPinSettingsActivity__onCreate$___twin___(Bundle r4) {
        super.onCreate(r4);
        setContentView(R.layout.sim_pin_settings_layout);
        SettingItemSwitch r5 = (SettingItemSwitch) findViewById(R.id.item_enable_pin);
        this.mViewEnablePin = r5;
        SwitchEx r6 = r5.getSwitch();
        this.mCheckBoxEnablePin = r6;
        r6.setOnClickListener(this);
        SettingItemText r7 = (SettingItemText) findViewById(R.id.item_modify_pin);
        this.mViewModifyPin = r7;
        r7.setOnClickListener(this);
        this.mPhone = PhoneFactory.getDefaultPhone();
        this.mRes = getResources();
        this.mBackView = this.mTitle.addStartAction(R.drawable.o_floating_title_bar_icon_back, -1, null);
        this.mBackView.setOnClickListener(new AnonymousClass3(this));
    }

    public void com_android_settings_SimPinSettingsActivity__onResume$___twin___() {
        super.onResume();
        IntentFilter r0 = new IntentFilter("android.intent.action.SIM_STATE_CHANGED");
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this, this.mSimStateReceiver, r0, 2);
        if (this.mDialogState == 0) goto L5;
        showPinDialog();
    L6:
        updateViews();
        return;
    L5:
        resetDialogState();
        goto L6
    }

    public void com_android_settings_SimPinSettingsActivity__onPause$___twin___() {
        super.onPause();
        unregisterReceiver(this.mSimStateReceiver);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r2) {
        if (this.mCheckBoxEnablePin != r2) goto L6;
        this.mDialogState = 1;
        showPinDialog();
        return;
    L6:
        if (this.mViewModifyPin != r2) goto L10;
        this.mDialogState = 2;
        showPinDialog();
        return;
    }

    private void updateViews() {
        this.mCheckBoxEnablePin.setChecked(this.mPhone.getIccCard().getIccLockEnabled());
        this.mViewModifyPin.setEnabled(this.mCheckBoxEnablePin.isChecked());
    }

    private void showPinDialog() {
        if (this.mDialogState != 0) goto L5;
        return;
    L5:
        setDialogValues();
        EditText r0 = new EditText(this);
        this.mPinEdit = r0;
        r0.setInputType(18);
        AlertDialog.Builder r1 = new AlertDialog.Builder(this);
        this.mDialogBuilder = r1;
        r1.setTitle(this.mDialogTitle);
        this.mDialogBuilder.setMessage(this.mDialogMessage);
        this.mDialogBuilder.setView(this.mPinEdit);
        this.mDialogBuilder.setPositiveButton(R.string.apn_editor_dialog_button_text_positive, this);
        this.mDialogBuilder.setNegativeButton(R.string.apn_editor_dialog_button_text_negative, this);
        this.mDialogBuilder.setCancelable(false);
        this.mDialogBuilder.create();
        this.mDialogBuilder.show();
    }

    private void setDialogValues() {
        int r0 = this.mDialogState;
        if (r0 != 1) goto L5;
        this.mDialogMessage = this.mRes.getString(R.string.sim_enter_pin);
        if (this.mPhone.getIccCard().getIccLockEnabled() == true) goto L17;
        String r1 = this.mRes.getString(R.string.sim_enable_sim_lock);
    L18:
        this.mDialogTitle = r1;
    L20:
        if (this.mError == null) goto L23;
        this.mDialogMessage = this.mError + "\n" + this.mDialogMessage;
        this.mError = null;
        return;
    L23:
        return;
    L17:
        r1 = this.mRes.getString(R.string.sim_disable_sim_lock);
        goto L18
    L5:
        if (r0 != 2) goto L7;
        this.mDialogMessage = this.mRes.getString(R.string.sim_enter_old);
        this.mDialogTitle = this.mRes.getString(R.string.sim_change_pin);
        goto L20
    L7:
        if (r0 != 3) goto L9;
        this.mDialogMessage = this.mRes.getString(R.string.sim_enter_new);
        this.mDialogTitle = this.mRes.getString(R.string.sim_change_pin);
        goto L20
    L9:
        if (r0 != 4) goto L20;
        this.mDialogMessage = this.mRes.getString(R.string.sim_reenter_new);
        this.mDialogTitle = this.mRes.getString(R.string.sim_change_pin);
        goto L20
    }

    public void onPinEntered() {
        String r0 = this.mPinEdit.getText().toString();
        this.mPin = r0;
        if (reasonablePin(r0) == true) goto L6;
        this.mError = this.mRes.getString(R.string.sim_bad_pin);
        showPinDialog();
        return;
    L6:
        int r1 = this.mDialogState;
        if (r1 != 1) goto L9;
        tryChangeIccLockState();
        return;
    L9:
        if (r1 != 2) goto L11;
        this.mOldPin = this.mPin;
        this.mDialogState = 3;
        this.mError = null;
        this.mPin = null;
        showPinDialog();
        return;
    L11:
        if (r1 == 3) goto L18;
        if (r1 == 4) goto L15;
        return;
    L15:
        if (this.mPin.equals(this.mNewPin) == true) goto L17;
        this.mError = this.mRes.getString(R.string.sim_pins_dont_match);
        this.mDialogState = 3;
        this.mPin = null;
        showPinDialog();
        return;
    L17:
        this.mError = null;
        tryChangePin();
        return;
    L18:
        this.mNewPin = this.mPin;
        this.mDialogState = 4;
        this.mPin = null;
        showPinDialog();
    }

    private void tryChangeIccLockState() {
        Message r0 = Message.obtain(this.mHandler, 100);
        IccCard r1 = this.mPhone.getIccCard();
        if (r1 == null) goto L6;
        r1.setIccLockEnabled(!this.mPhone.getIccCard().getIccLockEnabled(), this.mPin, r0);
        return;
    }

    private void iccLockChanged(boolean r2) {
        if (r2 == true) goto L4;
        ToastUtils.show(this, this.mRes.getString(R.string.sim_lock_failed));
    L4:
        this.mCheckBoxEnablePin.setChecked(this.mPhone.getIccCard().getIccLockEnabled());
        this.mViewModifyPin.setEnabled(this.mCheckBoxEnablePin.isChecked());
        resetDialogState();
    }

    private void iccPinChanged(boolean r2) {
        if (r2 == true) goto L4;
        ToastUtils.show(this, this.mRes.getString(R.string.sim_change_failed));
    L5:
        resetDialogState();
        return;
    L4:
        ToastUtils.show(this, this.mRes.getString(R.string.sim_change_succeeded));
        goto L5
    }

    private void tryChangePin() {
        Message r0 = Message.obtain(this.mHandler, 101);
        this.mPhone.getIccCard().changeIccLockPassword(this.mOldPin, this.mNewPin, r0);
    }

    private boolean reasonablePin(String r2) {
        if (r2 != null) goto L4;
        return false;
    L4:
        if (r2.length() >= 4) goto L6;
        return false;
    L6:
        if (r2.length() > 8) goto L13;
        return true;
    L13:
        return false;
    }

    private void resetDialogState() {
        this.mError = null;
        this.mDialogState = 2;
        this.mPin = "";
        setDialogValues();
        this.mDialogState = 0;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface r1, int r2) {
        if (r2 != (-1)) goto L6;
        onPinEntered();
        return;
    L6:
        if (r2 != (-2)) goto L10;
        updateViews();
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_SimPinSettingsActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(SimPinSettingsActivity r1) {
        com_android_settings_SimPinSettingsActivity_com_obric_hook_lancet_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_SimPinSettingsActivity_com_obric_hook_lancet_PrivacyHook_onCreate(SimPinSettingsActivity r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        SimPinSettingsActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_SimPinSettingsActivity__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_SimPinSettingsActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(SimPinSettingsActivity r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_SimPinSettingsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_SimPinSettingsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(SimPinSettingsActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_SimPinSettingsActivity_com_obric_hook_lancet_PrivacyHook_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        SimPinSettingsActivity r5 = r4;
        String r2 = r5.getCallingPackage();
        if (r2 != null) goto L9;
        OLog.e("BaseActivity", "isDeviceSetupComplete callingPkg is null, try getReferrer");
        Uri r6 = r5.getReferrer();
        if (r6 == null) goto L9;
        r2 = r6.toString();
    L9:
        OLog.i("TeaEventReportUtil", "callingPkg=" + r2);
        if (r2 != null) goto L12;
        r2 = "null";
    L12:
        AppMetricsUtils.INSTANCE.reportColdStartActivity(r2, r0);
    L13:
        AppMetricsUtils.INSTANCE.setColdStartTime(0);
    }

    @Insert(mayCreateSuper = true, value = "startActivityForResult")
    public static void com_android_settings_SimPinSettingsActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(SimPinSettingsActivity r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_SimPinSettingsActivity__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_SimPinSettingsActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(SimPinSettingsActivity r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_SimPinSettingsActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_SimPinSettingsActivity_com_obric_hook_lancet_PrivacyHook_onResume(SimPinSettingsActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        SimPinSettingsActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_SimPinSettingsActivity__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_SimPinSettingsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(SimPinSettingsActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_SimPinSettingsActivity_com_obric_hook_lancet_PrivacyHook_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_SimPinSettingsActivity_com_obric_hook_lancet_PrivacyHook_onPause(SimPinSettingsActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        SimPinSettingsActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_SimPinSettingsActivity__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_SimPinSettingsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(SimPinSettingsActivity r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_SimPinSettingsActivity_com_obric_hook_lancet_PrivacyHook_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        SimPinSettingsActivity r5 = r3;
        String r6 = r5.getCallingPackage();
        if (r6 != null) goto L9;
        OLog.e("AppLifecycle", "isDeviceSetupComplete callingPkg is null, try getReferrer");
        Uri r7 = r5.getReferrer();
        if (r7 == null) goto L9;
        r6 = r7.toString();
    L9:
        OLog.i("AppLifecycle", "TeaEventReportUtil callingPkg=" + r6);
        if (r6 != null) goto L12;
        r6 = "null";
    L12:
        AppMetricsUtils r8 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r8.callingPackageEvent(r6, r0, false);
        return;
    }

    @Insert("onStop")
    public static void com_android_settings_SimPinSettingsActivity_com_obric_hook_lancet_PrivacyHook_onStop(SimPinSettingsActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        SimPinSettingsActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_SimPinSettingsActivity__onStop$___twin___();
    }
}
