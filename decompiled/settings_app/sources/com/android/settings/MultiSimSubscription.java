package com.android.settings;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.GlobalProxyLancet;
import com.android.settings.applications.utils.ActionItem;
import com.android.settings.applications.utils.OActionDialogHelper;
import com.android.settings.applications.utils.OCardListItemUtils;
import com.android.settings.base.BaseActivity;
import com.android.settings.deviceinfo.DeviceInfoProvider;
import com.android.settings.sim.SIMUtils;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.ColorButtonStyleController;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.oui.button.OButton;
import com.obric.oui.dialog.base.OBaseDialog;
import com.obric.oui.dialog.v2.action.OActionDialog;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;
import com.obric.oui.dialog.v2.alert.style.ButtonStyleController;
import com.obric.oui.dialog.v2.misc.OSimpleFormDialog;
import com.obric.oui.dialog.v2.misc.StatusDialog;
import com.obric.oui.forms.OEditText;
import com.obric.oui.forms.OInputLayout;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.texteffects.preset.DimPointEffectTokens;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class MultiSimSubscription extends BaseActivity implements View.OnClickListener, DialogInterface.OnDismissListener, DialogInterface.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private static final Long DELAY_TIME = null;
    private static final int MSG_ID_SHOW_OPEN_CELLULAR_NETWORK_DIALOG = 2;
    private static final int MSG_ID_SHOW_SWITCH_LOADING = 3;
    private static final int MSG_ID_UPDATE_VIEW = 1;
    private static final String TAG = "SetSubscription";
    private static final Long UPDATE_VIEW_DELAY_TIME = null;
    private final int MAX_SUBSCRIPTIONS;
    private boolean isAnotherSubActivate;
    private OAlertDialog mAlertDialog;
    private OActionDialog mDeactivateTwoSimCardWarningDialog;
    private OAlertDialog mDeactivateWarningDialog;
    private Handler mHandler;
    private OSimpleFormDialog mInputDialog;
    private OEditText mOEditor;
    private OAlertDialog mOpenCellularNetworkDialog;
    private AirplaneModeBroadcastReceiver mReceiver;
    private ImageView mSimGuide;
    private String mSimName;
    private OCardListItem mSimNameItem;
    private SimStateChangeHandler mSimStateChangeHandler;
    private OCardListItem mSubscription;
    private SubscriptionManager mSubscriptionManager;
    private StatusDialog mSwitchLoadingDialog;
    private OFloatingTitleBar mTitle;
    private Runnable mUpdatePositiveButtonState;
    private int selectedSimIndex;
    private boolean subErr;

    private class AirplaneModeBroadcastReceiver extends BroadcastReceiver {
        final /* synthetic */ MultiSimSubscription this$0;

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r1, Intent r2) {
            com_android_settings_MultiSimSubscription$AirplaneModeBroadcastReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(this, r1, r2);
        }

        private AirplaneModeBroadcastReceiver(MultiSimSubscription r1) {
            this.this$0 = r1;
        }

        /* synthetic */ AirplaneModeBroadcastReceiver(MultiSimSubscription r1, AnonymousClass1 r2) {
            this(r1);
        }

        public void com_android_settings_MultiSimSubscription$AirplaneModeBroadcastReceiver__onReceive$___twin___(Context r2, Intent r3) {
            if (r3.getAction().equals("android.intent.action.AIRPLANE_MODE") == true) goto L5;
            return;
        L5:
            if (AirplaneModeEnablerEx.isAirplaneModeOn(r2) == false) goto L9;
            OLog.i(MultiSimSubscription.TAG, "Airplane mode is: on ");
            this.this$0.finish();
            return;
        }

        @Insert("onReceive")
        public static void com_android_settings_MultiSimSubscription$AirplaneModeBroadcastReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(AirplaneModeBroadcastReceiver r7, Context r8, Intent r9) {
            Intrinsics.checkNotNullParameter(r8, "context");
            String[] r0 = {"android.bluetooth.device.action.PAIRING_REQUEST", "android.bluetooth.device.action.BOND_STATE_CHANGED", "com.bytedanceos.launcher.new_message", "intent.provision.import_data", "com.android.settings.action.SHOW_IMPORT_DATA_NOTIFICATION"};
            Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.content.BroadcastReceiver");
            AirplaneModeBroadcastReceiver r1 = r7;
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
            r7.com_android_settings_MultiSimSubscription$AirplaneModeBroadcastReceiver__onReceive$___twin___(r8, r9);
            return;
        L13:
            GrantUtil r11 = GrantUtil.INSTANCE;
            Application r12 = SettingsApplication.getApplication();
            Intrinsics.checkNotNullExpressionValue(r12, "getApplication(...)");
            if (r11.isSetupCompelete(r12) == true) goto L16;
            OLog.i("PrivacyHookForReceiver", "onReceive !isSetupCompeleted hooked for " + r3 + ", " + r2);
            r7.com_android_settings_MultiSimSubscription$AirplaneModeBroadcastReceiver__onReceive$___twin___(r8, r9);
            return;
        L16:
            String r13 = r3;
            if (r13 != null) goto L19;
        L22:
            boolean r14 = true;
        L23:
            if (r14 == false) goto L26;
            OLog.i("PrivacyHookForReceiver", "onReceive !simpleName hooked for " + r3 + ", " + r2);
            r7.com_android_settings_MultiSimSubscription$AirplaneModeBroadcastReceiver__onReceive$___twin___(r8, r9);
            return;
        L26:
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == true) goto L30;
            if (r4 == true) goto L30;
            OLog.i("PrivacyHookForReceiver", "onReceive !isPrivacyAllowed hooked for " + r3 + ", " + r2);
            return;
        L30:
            GrantUtil.INSTANCE.applicationInit();
            r7.com_android_settings_MultiSimSubscription$AirplaneModeBroadcastReceiver__onReceive$___twin___(r8, r9);
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

    private int getAnotherSimIndex(int r1) {
        if (r1 != 0) goto L5;
        return 1;
    L5:
        if (r1 != 1) goto L8;
        return 0;
    L8:
        return -1;
    }

    public void com_android_settings_MultiSimSubscription__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_MultiSimSubscription__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r1) {
        com_android_settings_MultiSimSubscription_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        com_android_settings_MultiSimSubscription_com_obric_hook_lancet_PrivacyHook_onDestroy(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        com_android_settings_MultiSimSubscription_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        com_android_settings_MultiSimSubscription_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_MultiSimSubscription_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_MultiSimSubscription_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public MultiSimSubscription() {
        this.subErr = false;
        this.MAX_SUBSCRIPTIONS = MultiSimAdapter.getPhoneCount();
        this.mUpdatePositiveButtonState = null;
        this.mDeactivateTwoSimCardWarningDialog = null;
        this.mDeactivateWarningDialog = null;
        this.mOpenCellularNetworkDialog = null;
        this.mSwitchLoadingDialog = null;
        this.mHandler = new AnonymousClass1(this);
        this.mSimStateChangeHandler = new AnonymousClass3(this, this);
    }

    static /* synthetic */ OCardListItem access$000(MultiSimSubscription r0) {
        return r0.mSubscription;
    }

    static /* synthetic */ void access$100(MultiSimSubscription r0) {
        r0.updateCheckBoxes();
    }

    static /* synthetic */ void access$1000(MultiSimSubscription r0, OInputLayout r1, String r2) {
        r0.initOEditor(r1, r2);
    }

    static /* synthetic */ void access$1100(MultiSimSubscription r0) {
        r0.doApplyNewName();
    }

    static /* synthetic */ void access$1200(MultiSimSubscription r0) {
        r0.destroyInputDialog();
    }

    static /* synthetic */ String access$1300(CharSequence r0) {
        return getStringInLengthLimit(r0);
    }

    static /* synthetic */ OEditText access$1400(MultiSimSubscription r0) {
        return r0.mOEditor;
    }

    static /* synthetic */ Runnable access$1500(MultiSimSubscription r0) {
        return r0.mUpdatePositiveButtonState;
    }

    static /* synthetic */ boolean access$1600(MultiSimSubscription r0) {
        return r0.isAnotherSubActivate;
    }

    static /* synthetic */ Long access$1700() {
        return UPDATE_VIEW_DELAY_TIME;
    }

    static /* synthetic */ Handler access$1800(MultiSimSubscription r0) {
        return r0.mHandler;
    }

    static /* synthetic */ void access$1900(MultiSimSubscription r0, boolean r1, int r2) {
        r0.setSubscription(r1, r2);
    }

    static /* synthetic */ void access$200(MultiSimSubscription r0) {
        r0.updateSimName();
    }

    static /* synthetic */ Long access$2000() {
        return DELAY_TIME;
    }

    static /* synthetic */ void access$2100(MultiSimSubscription r0, boolean r1) {
        r0.checkSwitchQuietly(r1);
    }

    static /* synthetic */ OActionDialog access$2200(MultiSimSubscription r0) {
        return r0.mDeactivateTwoSimCardWarningDialog;
    }

    static /* synthetic */ OActionDialog access$2202(MultiSimSubscription r0, OActionDialog r1) {
        r0.mDeactivateTwoSimCardWarningDialog = r1;
        return r1;
    }

    static /* synthetic */ StatusDialog access$300(MultiSimSubscription r0) {
        return r0.mSwitchLoadingDialog;
    }

    static /* synthetic */ int access$400(MultiSimSubscription r0) {
        return r0.selectedSimIndex;
    }

    static /* synthetic */ int access$500(MultiSimSubscription r0, int r1) {
        return r0.getAnotherSimIndex(r1);
    }

    static /* synthetic */ void access$600(MultiSimSubscription r0) {
        r0.showOpenCellularNetworkDialog();
    }

    static /* synthetic */ void access$700(MultiSimSubscription r0) {
        r0.showSwitchLoading();
    }

    static /* synthetic */ OAlertDialog access$902(MultiSimSubscription r0, OAlertDialog r1) {
        r0.mAlertDialog = r1;
        return r1;
    }

    static {
        DELAY_TIME = 200L;
        UPDATE_VIEW_DELAY_TIME = Long.valueOf(DimPointEffectTokens.PendingCycleMs);
    }

    public void com_android_settings_MultiSimSubscription__onCreate$___twin___(Bundle r3) {
        super.onCreate(r3);
        this.mSubscriptionManager = (SubscriptionManager) getSystemService(SubscriptionManager.class);
        if (Utils.getBooleanExtraSafely(getIntent(), "NOTIFY_NEW_CARD_AVAILABLE", false) == false) goto L5;
        notifyNewCardAvailable();
    L10:
        IntentFilter r4 = new IntentFilter("android.intent.action.AIRPLANE_MODE");
        AirplaneModeBroadcastReceiver r0 = new AirplaneModeBroadcastReceiver(this, null);
        this.mReceiver = r0;
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this, r0, r4, 2);
        OFloatingTitleBar r5 = setupBackBtnOnTitle();
        this.mTitle = r5;
        r5.post(new AnonymousClass2(this));
        return;
    L5:
        setContentView(R.layout.sim_enable_layout);
        this.selectedSimIndex = Utils.getIntExtraSafely(getIntent(), MultiSimSettings.EXTRA_SIM_INDEX, 0);
        OCardListItem r6 = (OCardListItem) findViewById(R.id.sim_enable_switch);
        this.mSubscription = r6;
        r6.getContentContainer().setClickable(false);
        OCardListItem r7 = (OCardListItem) findViewById(R.id.sim_name_setting);
        this.mSimNameItem = r7;
        r7.setOnContentClickListener(this);
        ImageView r8 = (ImageView) findViewById(R.id.sim_guide);
        this.mSimGuide = r8;
        if (this.selectedSimIndex != 0) goto L8;
        int r1 = R.drawable.sim_card_guide_sim1;
    L9:
        r8.setBackgroundResource(r1);
        updateCheckBoxes();
        goto L10
    L8:
        r1 = R.drawable.sim_card_guide_sim2;
        goto L9
    }

    private void updateSimName() {
        String r0 = MultiSimSettings.getSimName(this, this.selectedSimIndex);
        this.mSimName = r0;
        this.mTitle.setCenterTitle(r0);
        this.mSubscription.setTitle(this.mSimName);
        Bundle r1 = getContentResolver().call(DeviceInfoProvider.DEVICE_INFO_PROVIDER_AUTHORITY, DeviceInfoProvider.GET_PHONE_NUM, null, null);
        this.mSubscription.setSubTitle(r1.getString(String.valueOf(this.selectedSimIndex)));
        this.mSubscription.showSubTitle(true);
        String r2 = MultiSimUtil.getSimNameInDb(this, this.selectedSimIndex);
        if (TextUtils.isEmpty(r2) == false) goto L5;
        r2 = getString(R.string.multi_sim_settings_untitled);
    L5:
        OCardListItemUtils.setCustomEndTipTextView(this.mSimNameItem, r2);
    }

    public void com_android_settings_MultiSimSubscription__onResume$___twin___() {
        super.onResume();
        this.mSimStateChangeHandler.register();
        OCardListItem r0 = this.mSubscription;
        if (r0 == null) goto L5;
        ((OSwitch) r0.getCustomEndView()).setOnCheckedChangeListener(this);
    L5:
        updateSimName();
    }

    public void com_android_settings_MultiSimSubscription__onPause$___twin___() {
        super.onPause();
        this.mSimStateChangeHandler.unregister();
        OCardListItem r2 = this.mSubscription;
        if (r2 == null) goto L6;
        ((OSwitch) r2.getCustomEndView()).setOnCheckedChangeListener(this);
    L6:
        if (this.mAlertDialog == null) goto L15;
        OLog.i(TAG, "onPause disimissing dialog = " + this.mAlertDialog);     // Catch: IllegalArgumentException -> L9
        this.mAlertDialog.dismiss();     // Catch: IllegalArgumentException -> L9
    L11:
        this.mAlertDialog = null;
        return;
    L9:
        e = move-exception;
        OLog.w(TAG, "Exception dismissing dialog. Ex=" + e);
        goto L11
    }

    public void com_android_settings_MultiSimSubscription__onDestroy$___twin___() {
        super.onDestroy();
        destroyDialog();
        unregisterReceiver(this.mReceiver);
    }

    private void destroyDialog() {
        OAlertDialog r0 = this.mAlertDialog;
        if (r0 == null) goto L5;
        r0.dismiss();
    L5:
        OActionDialog r1 = this.mDeactivateTwoSimCardWarningDialog;
        if (r1 == null) goto L8;
        r1.dismiss();
        this.mDeactivateTwoSimCardWarningDialog = null;
    L8:
        OAlertDialog r2 = this.mDeactivateWarningDialog;
        if (r2 == null) goto L11;
        r2.dismiss();
        this.mDeactivateWarningDialog = null;
    L11:
        OAlertDialog r3 = this.mOpenCellularNetworkDialog;
        if (r3 == null) goto L14;
        r3.dismiss();
        this.mOpenCellularNetworkDialog = null;
    L14:
        StatusDialog r4 = this.mSwitchLoadingDialog;
        if (r4 == null) goto L18;
        r4.dismiss();
        this.mSwitchLoadingDialog = null;
        return;
    }

    private void notifyNewCardAvailable() {
        OLog.i(TAG, "notifyNewCardAvailable()");
        OAlertDialog r0 = new OAlertDialogBuilder(this).autoDismiss(true).horizontalButton().title(R.string.config_sub_title).message(R.string.new_cards_available).icon(R.drawable.o_icon_alert).positiveButton(R.string.dlg_ok, new AnonymousClass4(this)).build();
        this.mAlertDialog = r0;
        r0.setOnDismissListener(new AnonymousClass5(this));
        this.mAlertDialog.show();
    }

    private void updateCheckBoxes() {
        int r0 = this.selectedSimIndex;
        if (r0 == 0) goto L7;
        if (r0 != 1) goto L8;
        this.isAnotherSubActivate = SIMUtils.isSubActive(this, 0);
    L8:
        OLog.i(TAG, "isAnotherSubActivate:" + this.isAnotherSubActivate);
        boolean r1 = SIMUtils.isSubActive(this, this.selectedSimIndex);
        OCardListItem r2 = this.mSubscription;
        if (r2 == null) goto L11;
        ((OSwitch) r2.getCustomEndView()).setChecked(r1);
    L11:
        OLog.i(TAG, "currentSubActivate:" + r1);
        this.mSimNameItem.setEnabled(r1);
        return;
    L7:
        this.isAnotherSubActivate = SIMUtils.isSubActive(this, 1);
        goto L8
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r2) {
        if (r2 != this.mSimNameItem.getContentContainer()) goto L6;
        showReNameDialog();
        return;
    }

    private void showReNameDialog() {
        final Context r0 = this.mContext;
        final String r1 = MultiSimUtil.getSimNameInDb(this, this.selectedSimIndex);
        if (r1 != null) goto L6;
        r1 = "";
    L6:
        OSimpleFormDialog r2 = new OSimpleFormDialog(this.mActivity, new OSimpleFormDialog.Modifier(getString(R.string.multi_sim_sim_name_setting), getString(R.string.sim_rename_tips), new OSimpleFormDialog.InputViewConfig(true, false, new AnonymousClass6(this, r0, r1)), new OSimpleFormDialog.InputViewConfig(false, false, null), new OBaseDialog.ButtonConfig(getString(R.string.apn_editor_dialog_button_text_positive), new AnonymousClass7(this), null), new OBaseDialog.ButtonConfig(getString(R.string.menu_cancel_confirm), new AnonymousClass8(this), null)));
        this.mInputDialog = r2;
        final OButton r3 = (OButton) r2.getRootView().findViewById(R.id.actionPositive);     // Catch: Exception -> L11
        if (r3 == null) goto L13;
        Runnable r4 = new MultiSimSubscription$$ExternalSyntheticLambda2(this, r3);     // Catch: Exception -> L11
        this.mUpdatePositiveButtonState = r4;     // Catch: Exception -> L11
        r4.run();     // Catch: Exception -> L11
    L13:
        this.mInputDialog.show();
        return;
    L11:
        e = move-exception;
        OLog.e(TAG, "showReNameDialogNew, error_msg: " + e);
        goto L13
    }

    /* JADX INFO: renamed from: lambda$showReNameDialog$0$com-android-settings-MultiSimSubscription, reason: not valid java name */
    /* synthetic */ void m163xb6205d83(OButton r2) {
        OEditText r0 = this.mOEditor;
        if (r0 != null) goto L5;
    L7:
        r2.setEnabled(false);
        return;
    L5:
        if (r0.getText() == null) goto L7;
        r2.setEnabled(!this.mOEditor.getText().toString().trim().isEmpty());
    }

    private void initOEditor(OInputLayout r2, String r3) {
        if (r2 != null) goto L4;
        return;
    L4:
        OEditText r4 = (OEditText) r2.findViewById(R.id.input);
        this.mOEditor = r4;
        r4.setText(r3);
        this.mOEditor.setSelection(0, r3.length());
        this.mOEditor.addTextChangedListener(new AnonymousClass9(this));
    }

    private void doApplyNewName() {
        OEditText r0 = this.mOEditor;
        if (r0 != null) goto L5;
    L7:
        String r1 = "";
    L8:
        MultiSimUtil.setSimName(this, this.selectedSimIndex, r1);
        OCardListItemUtils.setCustomEndTipTextView(this.mSimNameItem, r1);
        updateSimName();
        return;
    L5:
        if (r0.getText() == null) goto L7;
        r1 = this.mOEditor.getText().toString().trim();
        goto L8
    }

    private void destroyInputDialog() {
        if (this.mUpdatePositiveButtonState == null) goto L6;
        this.mUpdatePositiveButtonState = null;
    L6:
        if (this.mOEditor == null) goto L8;
        this.mOEditor = null;
    L8:
        OSimpleFormDialog r0 = this.mInputDialog;
        if (r0 == null) goto L12;
        r0.dismiss();
        this.mInputDialog = null;
        return;
    }

    private static String getStringInLengthLimit(CharSequence r8) {
        StringBuilder r0 = new StringBuilder();
        int r1 = 0;
        int r2 = 0;
        boolean r3 = false;
    L4:
        if (r1 >= r8.length()) goto L22;
        char r4 = r8.charAt(r1);
        String r5 = Character.toString(r4);
        if (Character.isHighSurrogate(r4) == true) goto L22;
        boolean r7 = true;
        if (r5.matches("[Α-￥]") == false) goto L12;
        r2 = r2 + 2;
    L18:
        if (r2 > 8) goto L22;
        r0.append(r5);
        r3 = r7;
    L20:
        r1 = r1 + 1;
        goto L4
    L12:
        if (Character.isSpaceChar(r4) == true) goto L14;
        r3 = true;
    L16:
        r2 = r2 + 1;
        r7 = r3;
        goto L18
    L14:
        if (r3 == true) goto L16;
    L22:
        return r0.toString();
    }

    private void setSubscription(boolean r3) {
        OLog.i(TAG, "setSubscription");
        if (isPhoneInCall() == false) goto L5;
        checkSwitchQuietly(!r3);
        displayErrorDialog(R.string.set_sub_not_supported_phone_in_call);
        return;
    L5:
        if (r3 == false) goto L7;
    L9:
        if (r3 == true) goto L11;
        showDeactivateWarningDialog();
        return;
    L11:
        setSubscription(true, this.selectedSimIndex);
        return;
    L7:
        if (this.isAnotherSubActivate == true) goto L9;
        showDeactivateTwoSimCardWarningDialog();
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.android.settings.MultiSimSubscription$10] */
    private void setSubscription(final boolean r3, final int r4) {
        OLog.i(TAG, "setSubscription activate:" + r3 + " simIndex:" + r4);
        new AnonymousClass10(this, r3, r4).execute(new Void[0]);
    }

    private boolean isPhoneInCall() {
        int r1 = 0;
    L4:
        if (r1 >= this.MAX_SUBSCRIPTIONS) goto L12;
        if (TelephonyManager.from(this.mContext).getCallState(r1) != 0) goto L7;
        r1 = r1 + 1;
        goto L4
    L7:
        return true;
    L12:
        return false;
    }

    private void displayErrorDialog(int r3) {
        OLog.i(TAG, "errorMutipleDeactivate(): " + getResources().getString(r3));
        OAlertDialog r4 = new OAlertDialogBuilder(this).autoDismiss(true).title(R.string.config_sub_title).message(r3).icon(R.drawable.o_icon_alert).positiveButton(R.string.dlg_ok, new AnonymousClass11(this)).build();
        this.mAlertDialog = r4;
        r4.setOnDismissListener(new AnonymousClass12(this));
        this.mAlertDialog.show();
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface r1) {
        this.mAlertDialog = null;
        if (this.subErr == true) goto L6;
        finish();
        return;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface r2, int r3) {
        r2.dismiss();     // Catch: IllegalArgumentException -> L4
    L6:
        updateCheckBoxes();
        return;
    L4:
        e = move-exception;
        OLog.w(TAG, "Exception dismissing dialog. Ex=" + e);
        goto L6
    }

    private void checkSwitchQuietly(boolean r3) {
        ((OSwitch) this.mSubscription.getCustomEndView()).setOnCheckedChangeListener(null);
        ((OSwitch) this.mSubscription.getCustomEndView()).setChecked(r3);
        ((OSwitch) this.mSubscription.getCustomEndView()).setOnCheckedChangeListener(this);
    }

    private void showDeactivateTwoSimCardWarningDialog() {
        OActionDialog r0 = this.mDeactivateTwoSimCardWarningDialog;
        if (r0 != null) goto L5;
    L7:
        String r1 = getString(R.string.multi_sim_sub_1_title);
        String r2 = getString(R.string.multi_sim_sub_2_title);
        String r3 = this.mSimName;
        if (TextUtils.isEmpty(r3) == false) goto L10;
    L13:
        String r4 = MultiSimSettings.getSimName(this, getAnotherSimIndex(this.selectedSimIndex));
        if (TextUtils.isEmpty(r4) == true) goto L20;
        if (this.selectedSimIndex != 0) goto L18;
        r2 = r4;
        goto L20
    L18:
        r1 = r4;
    L20:
        if (this.selectedSimIndex != 1) goto L22;
        String r5 = getString(R.string.multi_sim_deactivate_two_sim_warning_dialog_sub_title, new Object[]{r2, r1, r2});
        String r6 = getString(R.string.multi_sim_deactivate_two_sim_warning_dialog_positive_btn_new, new Object[]{r2, r1});
    L23:
        ArrayList r7 = new ArrayList();
        r7.add(new ActionItem(r6, 2132017997));
        r7.add(new ActionItem(getString(R.string.menu_cancel_confirm), 2132017993));
        OActionDialog r8 = OActionDialogHelper.showOActionDialog(this.mActivity, getString(R.string.multi_sim_deactivate_two_sim_warning_dialog_title), r5, r7, new AnonymousClass13(this));
        this.mDeactivateTwoSimCardWarningDialog = r8;
        TextView r9 = (TextView) r8.findViewById(R.id.action_dialog_sub_title);
        if (r9 == null) goto L26;
        r9.setMaxLines(Integer.MAX_VALUE);
    L26:
        OActionDialog r10 = this.mDeactivateTwoSimCardWarningDialog;
        if (r10 == null) goto L30;
        r10.show();
        return;
    L30:
        return;
    L22:
        r5 = getString(R.string.multi_sim_deactivate_two_sim_warning_dialog_sub_title, new Object[]{r1, r2, r1});
        r6 = getString(R.string.multi_sim_deactivate_two_sim_warning_dialog_positive_btn_new, new Object[]{r1, r2});
        goto L23
    L10:
        if (this.selectedSimIndex != 0) goto L12;
        r1 = r3;
        goto L13
    L12:
        r2 = r3;
        goto L13
    L5:
        if (r0.isShowing() == false) goto L7;
    }

    private void showDeactivateWarningDialog() {
        OAlertDialog r0 = this.mDeactivateWarningDialog;
        if (r0 != null) goto L5;
    L7:
        String r1 = getString(R.string.multi_sim_sub_1_title);
        if (this.selectedSimIndex != 1) goto L10;
        r1 = getString(R.string.multi_sim_sub_2_title);
    L10:
        String r2 = MultiSimSettings.getSimName(this, this.selectedSimIndex);
        if (TextUtils.isEmpty(r2) == true) goto L13;
        r1 = r2;
    L13:
        OAlertDialog r3 = new OAlertDialogBuilder(this.mActivity).horizontalButton(true).title(getString(R.string.multi_sim_deactivate_sim_warning_dialog_title, new Object[]{r1}), false).message(getString(R.string.multi_sim_deactivate_sim_warning_dialog_sub_title)).positiveButton(getString(R.string.multi_sim_deactivate_sim_warning_dialog_positive_btn), new MultiSimSubscription$$ExternalSyntheticLambda0(this)).negativeButton(getString(R.string.multi_sim_deactivate_sim_warning_dialog_negative_btn), new MultiSimSubscription$$ExternalSyntheticLambda1(this)).build();
        this.mDeactivateWarningDialog = r3;
        if (r3 == null) goto L17;
        r3.show();
        return;
    L17:
        return;
    L5:
        if (r0.isShowing() == false) goto L7;
    }

    /* JADX INFO: renamed from: lambda$showDeactivateWarningDialog$1$com-android-settings-MultiSimSubscription, reason: not valid java name */
    /* synthetic */ void m160x6cd072fa(DialogInterface r3, int r4) {
        boolean r5 = SIMUtils.isSIMForDataChecked(this.mSubscriptionManager, this.selectedSimIndex);
        setSubscription(false, this.selectedSimIndex);
        if (r5 == false) goto L5;
        this.mHandler.sendEmptyMessageDelayed(2, DELAY_TIME.longValue());
    L5:
        OAlertDialog r6 = this.mDeactivateWarningDialog;
        if (r6 == null) goto L9;
        r6.dismiss();
        this.mDeactivateWarningDialog = null;
        return;
    }

    /* JADX INFO: renamed from: lambda$showDeactivateWarningDialog$2$com-android-settings-MultiSimSubscription, reason: not valid java name */
    /* synthetic */ void m161x5211e1bb(DialogInterface r1, int r2) {
        OAlertDialog r3 = this.mDeactivateWarningDialog;
        if (r3 == null) goto L6;
        r3.dismiss();
        this.mDeactivateWarningDialog = null;
        return;
    }

    private void showOpenCellularNetworkDialog() {
        final int r0 = getAnotherSimIndex(this.selectedSimIndex);
        if (r0 != (-1)) goto L6;
        return;
    L6:
        if (this.mOpenCellularNetworkDialog != null) goto L14;
        String r1 = getString(R.string.multi_sim_sub_1_title);
        if (r0 != 1) goto L10;
        r1 = getString(R.string.multi_sim_sub_2_title);
    L10:
        String r3 = MultiSimSettings.getSimName(this, r0);
        if (TextUtils.isEmpty(r3) == true) goto L13;
        r1 = r3;
    L13:
        this.mOpenCellularNetworkDialog = new OAlertDialogBuilder(this.mActivity).horizontalButton().overrideButtonStyleController(new MultiSimSubscription$$ExternalSyntheticLambda3()).title(getString(R.string.multi_sim_open_cellular_network_dialog_title), false).message(getString(R.string.multi_sim_open_cellular_network_dialog_sub_title, new Object[]{r1})).positiveButton(getString(R.string.multi_sim_open_cellular_network_dialog_positive_btn), new MultiSimSubscription$$ExternalSyntheticLambda4()).negativeButton(getString(R.string.multi_sim_open_cellular_network_dialog_negative_btn), new MultiSimSubscription$$ExternalSyntheticLambda5(this, r0)).build();
    L14:
        OAlertDialog r2 = this.mOpenCellularNetworkDialog;
        if (r2 != null) goto L17;
        return;
    L17:
        if (r2.isShowing() == true) goto L21;
        this.mOpenCellularNetworkDialog.show();
        return;
    }

    static /* synthetic */ ButtonStyleController lambda$showOpenCellularNetworkDialog$3(Context r1, Integer r2) {
        return new ColorButtonStyleController(r1, r2.intValue()).positiveColor(R.color.oui_basic_text_1, -1);
    }

    static /* synthetic */ void lambda$showOpenCellularNetworkDialog$4(DialogInterface r0, int r1) {
        r0.dismiss();
    }

    /* JADX INFO: renamed from: lambda$showOpenCellularNetworkDialog$5$com-android-settings-MultiSimSubscription, reason: not valid java name */
    /* synthetic */ void m162xcba91130(int r1, DialogInterface r2, int r3) {
        SIMUtils.setDataEnabled(this.mActivity, r1, true);
        r2.dismiss();
    }

    private void showSwitchLoading() {
        if (this.mSwitchLoadingDialog != null) goto L5;
        StatusDialog r0 = new StatusDialog(this.mActivity, new StatusDialog.Modifier(getString(R.string.multi_sim_switch_loading_dialog_title), "", null, null));
        this.mSwitchLoadingDialog = r0;
        r0.setCanceledOnTouchOutside(false);
        this.mSwitchLoadingDialog.setCancelable(false);
    L5:
        StatusDialog r1 = this.mSwitchLoadingDialog;
        if (r1 != null) goto L8;
        return;
    L8:
        if (r1.isShowing() == true) goto L12;
        this.mSwitchLoadingDialog.show();
        return;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r5, boolean r6) {
        boolean r0 = SIMUtils.isSubActive(this, this.selectedSimIndex);
        ((OSwitch) this.mSubscription.getCustomEndView()).setChecked(r0);
        OLog.i(TAG, "onCheckedChanged state:" + r6);
        if (r6 == true) goto L12;
        boolean r2 = false;
        if (TelephonyManager.getDefault().hasIccCard(0) == true) goto L7;
    L9:
        if (r2 == true) goto L12;
        Utils.showShortToast(this, getString(R.string.multi_sim_cannot_turn_off_all));
        r5.setChecked(true);
        return;
    L7:
        if (TelephonyManager.getDefault().hasIccCard(1) == false) goto L9;
        r2 = true;
    L12:
        if (r0 == r6) goto L15;
        setSubscription(r6);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_MultiSimSubscription_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(MultiSimSubscription r1) {
        com_android_settings_MultiSimSubscription_com_obric_hook_lancet_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_MultiSimSubscription_com_obric_hook_lancet_PrivacyHook_onCreate(MultiSimSubscription r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        MultiSimSubscription r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_MultiSimSubscription__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_MultiSimSubscription_com_obric_hook_lancet_BatchedActivityLancet_onResume(MultiSimSubscription r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_MultiSimSubscription_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_MultiSimSubscription_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(MultiSimSubscription r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_MultiSimSubscription_com_obric_hook_lancet_PrivacyHook_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        MultiSimSubscription r5 = r4;
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
    public static void com_android_settings_MultiSimSubscription_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(MultiSimSubscription r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_MultiSimSubscription__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_MultiSimSubscription_com_obric_hook_lancet_BatchedActivityLancet_onStop(MultiSimSubscription r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_MultiSimSubscription_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_MultiSimSubscription_com_obric_hook_lancet_PrivacyHook_onResume(MultiSimSubscription r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        MultiSimSubscription r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_MultiSimSubscription__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_MultiSimSubscription_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(MultiSimSubscription r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_MultiSimSubscription_com_obric_hook_lancet_PrivacyHook_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_MultiSimSubscription_com_obric_hook_lancet_PrivacyHook_onPause(MultiSimSubscription r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        MultiSimSubscription r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_MultiSimSubscription__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_MultiSimSubscription_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(MultiSimSubscription r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_MultiSimSubscription_com_obric_hook_lancet_PrivacyHook_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        MultiSimSubscription r5 = r3;
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
    public static void com_android_settings_MultiSimSubscription_com_obric_hook_lancet_PrivacyHook_onStop(MultiSimSubscription r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        MultiSimSubscription r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_MultiSimSubscription__onStop$___twin___();
    }

    @Insert("onDestroy")
    public static void com_android_settings_MultiSimSubscription_com_obric_hook_lancet_PrivacyHook_onDestroy(MultiSimSubscription r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        MultiSimSubscription r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperDestroy();
        return;
    L6:
        r3.com_android_settings_MultiSimSubscription__onDestroy$___twin___();
    }
}
