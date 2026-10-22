package com.android.settings;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TabWidget;
import androidx.preference.Preference;
import androidx.preference.SwitchPreference;
import com.GlobalProxyLancet;
import com.android.internal.telephony.IccCard;
import com.android.internal.telephony.Phone;
import com.android.internal.telephony.PhoneFactory;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class IccLockSettings extends SettingsPreferenceFragment implements EditPinPreference.OnPinEnteredListener {
    private static final boolean DBG = true;
    private static final String DIALOG_ERROR = "dialogError";
    private static final String DIALOG_PIN = "dialogPin";
    private static final String DIALOG_STATE = "dialogState";
    private static final String ENABLE_TO_STATE = "enableState";
    private static final int ICC_LOCK_MODE = 1;
    private static final int ICC_NEW_MODE = 3;
    private static final int ICC_OLD_MODE = 2;
    private static final int ICC_REENTER_MODE = 4;
    private static final int MAX_PIN_LENGTH = 8;
    private static final int MIN_PIN_LENGTH = 4;
    private static final int MSG_CHANGE_ICC_PIN_COMPLETE = 101;
    private static final int MSG_ENABLE_ICC_PIN_COMPLETE = 100;
    private static final int MSG_SIM_STATE_CHANGED = 102;
    private static final String NEW_PINCODE = "newPinCode";
    private static final int OFF_MODE = 0;
    private static final String OLD_PINCODE = "oldPinCode";
    private static final String PIN_DIALOG = "sim_pin";
    private static final String PIN_TOGGLE = "sim_toggle";
    private static final String TAG = "IccLockSettings";
    private int mDialogState;
    private TabHost.TabContentFactory mEmptyTabContent;
    private String mError;
    private Handler mHandler;
    private ListView mListView;
    private String mNewPin;
    private String mOldPin;
    private Phone mPhone;
    private String mPin;
    private EditPinPreference mPinDialog;
    private SwitchPreference mPinToggle;
    private Resources mRes;
    private final BroadcastReceiver mSimStateReceiver;
    private TabHost mTabHost;
    private TabHost.OnTabChangeListener mTabListener;
    private TabWidget mTabWidget;
    private boolean mToState;

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_IccLockSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.SettingsPreferenceFragment, com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_IccLockSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public IccLockSettings() {
        this.mDialogState = 0;
        this.mHandler = new AnonymousClass1(this);
        this.mSimStateReceiver = new AnonymousClass2(this);
        this.mTabListener = new AnonymousClass3(this);
        this.mEmptyTabContent = new AnonymousClass4(this);
    }

    static /* synthetic */ void access$000(IccLockSettings r0, boolean r1, int r2) {
        r0.iccLockChanged(r1, r2);
    }

    static /* synthetic */ void access$100(IccLockSettings r0, boolean r1, int r2) {
        r0.iccPinChanged(r1, r2);
    }

    static /* synthetic */ void access$200(IccLockSettings r0) {
        r0.updatePreferences();
    }

    static /* synthetic */ Handler access$300(IccLockSettings r0) {
        return r0.mHandler;
    }

    static /* synthetic */ Phone access$402(IccLockSettings r0, Phone r1) {
        r0.mPhone = r1;
        return r1;
    }

    static /* synthetic */ TabHost access$500(IccLockSettings r0) {
        return r0.mTabHost;
    }

    static boolean isIccLockEnabled() {
        IccCard r0 = PhoneFactory.getDefaultPhone().getIccCard();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.getIccLockEnabled();
    }

    static String getSummary(Context r1) {
        Resources r2 = r1.getResources();
        if (isIccLockEnabled() == false) goto L6;
        return r2.getString(R.string.sim_lock_on);
    L6:
        return r2.getString(R.string.sim_lock_off);
    }

    public void com_android_settings_IccLockSettings__onCreate$___twin___(Bundle r4) {
        super.onCreate(r4);
        if (Utils.isMonkeyRunning() == false) goto L6;
        finish();
        return;
    L6:
        addPreferencesFromResource(R.xml.sim_lock_settings);
        this.mPinDialog = (EditPinPreference) findPreference(PIN_DIALOG);
        this.mPinToggle = (SwitchPreference) findPreference(PIN_TOGGLE);
        if (r4 != null) goto L9;
    L17:
        this.mPinDialog.setOnPinEnteredListener(this);
        getPreferenceScreen().setPersistent(false);
        this.mRes = getResources();
        return;
    L9:
        if (r4.containsKey(DIALOG_STATE) == false) goto L17;
        this.mDialogState = r4.getInt(DIALOG_STATE);
        this.mPin = r4.getString(DIALOG_PIN);
        this.mError = r4.getString(DIALOG_ERROR);
        this.mToState = r4.getBoolean(ENABLE_TO_STATE);
        int r0 = this.mDialogState;
        if (r0 != 3) goto L13;
        this.mOldPin = r4.getString(OLD_PINCODE);
        goto L17
    L13:
        if (r0 != 4) goto L17;
        this.mOldPin = r4.getString(OLD_PINCODE);
        this.mNewPin = r4.getString(NEW_PINCODE);
        goto L17
    }

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r9, ViewGroup r10, Bundle r11) {
        finish();
        int r0 = ((TelephonyManager) getContext().getSystemService(MultiSimAdapter.PHONE_KEY)).getSimCount();
        if (r0 <= 1) goto L17;
        View r2 = r9.inflate(R.layout.icc_lock_tabs, r10, false);
        ViewGroup r4 = (ViewGroup) r2.findViewById(R.id.prefs_container);
        Utils.prepareCustomPreferencesList(r10, r2, r4, false);
        r4.addView(super.onCreateView(r9, r4, r11));
        this.mTabHost = (TabHost) r2.findViewById(android.R.id.tabhost);
        this.mTabWidget = (TabWidget) r2.findViewById(android.R.id.tabs);
        this.mListView = (ListView) r2.findViewById(android.R.id.list);
        this.mTabHost.setup();
        this.mTabHost.setOnTabChangedListener(this.mTabListener);
        this.mTabHost.clearAllTabs();
        SubscriptionManager r12 = SubscriptionManager.from(getContext());
        int r13 = 0;
    L5:
        if (r13 >= r0) goto L11;
        SubscriptionInfo r14 = r12.getActiveSubscriptionInfoForSimSlotIndex(r13);
        TabHost r5 = this.mTabHost;
        String r6 = String.valueOf(r13);
        if (r14 != null) goto L9;
        CharSequence r15 = getContext().getString(R.string.sim_editor_title, new Object[]{Integer.valueOf(r13 + 1)});
    L10:
        r5.addTab(buildTabSpec(r6, String.valueOf(r15)));
        r13 = r13 + 1;
        goto L5
    L9:
        r15 = r14.getDisplayName();
        goto L10
    L11:
        SubscriptionInfo r16 = r12.getActiveSubscriptionInfoForSimSlotIndex(0);
        if (r16 != null) goto L14;
        Phone r17 = null;
    L15:
        this.mPhone = r17;
        return r2;
    L14:
        r17 = PhoneFactory.getPhone(SubscriptionManager.getPhoneId(r16.getSubscriptionId()));
        goto L15
    L17:
        this.mPhone = PhoneFactory.getDefaultPhone();
        return super.onCreateView(r9, r10, r11);
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onViewCreated(View r1, Bundle r2) {
        super.onViewCreated(r1, r2);
        updatePreferences();
    }

    private void updatePreferences() {
        EditPinPreference r0 = this.mPinDialog;
        boolean r2 = true;
        if (this.mPhone == null) goto L5;
        boolean r1 = true;
    L6:
        r0.setEnabled(r1);
        SwitchPreference r3 = this.mPinToggle;
        if (this.mPhone != null) goto L10;
        r2 = false;
    L10:
        r3.setEnabled(r2);
        Phone r4 = this.mPhone;
        if (r4 == null) goto L16;
        IccCard r5 = r4.getIccCard();
        if (r5 == null) goto L17;
        this.mPinToggle.setChecked(r5.getIccLockEnabled());
        return;
    L17:
        return;
    L16:
        return;
    L5:
        r1 = false;
        goto L6
    }

    public void com_android_settings_IccLockSettings__onResume$___twin___() {
        super.onResume();
        IntentFilter r0 = new IntentFilter("android.intent.action.SIM_STATE_CHANGED");
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(getContext(), this.mSimStateReceiver, r0, 2);
        if (this.mDialogState == 0) goto L5;
        showPinDialog();
        return;
    L5:
        resetDialogState();
    }

    @Override // com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        getContext().unregisterReceiver(this.mSimStateReceiver);
    }

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle r4) {
        if (this.mPinDialog.isDialogOpen() == false) goto L15;
        r4.putInt(DIALOG_STATE, this.mDialogState);
        EditText r0 = this.mPinDialog.getEditText();
        if (r0 == null) goto L7;
        r4.putString(DIALOG_PIN, r0.getText().toString());
    L8:
        r4.putString(DIALOG_ERROR, this.mError);
        r4.putBoolean(ENABLE_TO_STATE, this.mToState);
        int r1 = this.mDialogState;
        if (r1 != 3) goto L11;
        r4.putString(OLD_PINCODE, this.mOldPin);
        return;
    L11:
        if (r1 != 4) goto L19;
        r4.putString(OLD_PINCODE, this.mOldPin);
        r4.putString(NEW_PINCODE, this.mNewPin);
        return;
    L19:
        return;
    L7:
        r4.putString(DIALOG_PIN, null);
        goto L8
    L15:
        super.onSaveInstanceState(r4);
    }

    private void showPinDialog() {
        if (this.mDialogState != 0) goto L5;
        return;
    L5:
        setDialogValues();
        this.mPinDialog.showPinDialog();
    }

    private void setDialogValues() {
        this.mPinDialog.setText(this.mPin);
        int r0 = this.mDialogState;
        if (r0 != 1) goto L5;
        String r1 = this.mRes.getString(R.string.sim_enter_pin);
        EditPinPreference r2 = this.mPinDialog;
        if (this.mToState == false) goto L17;
        String r3 = this.mRes.getString(R.string.sim_enable_sim_lock);
    L18:
        r2.setDialogTitle(r3);
    L20:
        if (this.mError == null) goto L22;
        r1 = this.mError + "\n" + r1;
        this.mError = null;
    L22:
        this.mPinDialog.setDialogMessage(r1);
        return;
    L17:
        r3 = this.mRes.getString(R.string.sim_disable_sim_lock);
        goto L18
    L5:
        if (r0 != 2) goto L7;
        r1 = this.mRes.getString(R.string.sim_enter_old);
        this.mPinDialog.setDialogTitle(this.mRes.getString(R.string.sim_change_pin));
        goto L20
    L7:
        if (r0 != 3) goto L9;
        r1 = this.mRes.getString(R.string.sim_enter_new);
        this.mPinDialog.setDialogTitle(this.mRes.getString(R.string.sim_change_pin));
        goto L20
    L9:
        if (r0 == 4) goto L11;
        r1 = "";
        goto L20
    L11:
        r1 = this.mRes.getString(R.string.sim_reenter_new);
        this.mPinDialog.setDialogTitle(this.mRes.getString(R.string.sim_change_pin));
        goto L20
    }

    @Override // com.android.settings.EditPinPreference.OnPinEnteredListener
    public void onPinEntered(EditPinPreference r3, boolean r4) {
        if (r4 == true) goto L5;
        resetDialogState();
        return;
    L5:
        String r5 = r3.getText();
        this.mPin = r5;
        if (reasonablePin(r5) == true) goto L9;
        this.mError = this.mRes.getString(R.string.sim_bad_pin);
        showPinDialog();
        return;
    L9:
        int r6 = this.mDialogState;
        if (r6 != 1) goto L12;
        tryChangeIccLockState();
        return;
    L12:
        if (r6 != 2) goto L14;
        this.mOldPin = this.mPin;
        this.mDialogState = 3;
        this.mError = null;
        this.mPin = null;
        showPinDialog();
        return;
    L14:
        if (r6 == 3) goto L21;
        if (r6 == 4) goto L18;
        return;
    L18:
        if (this.mPin.equals(this.mNewPin) == true) goto L20;
        this.mError = this.mRes.getString(R.string.sim_pins_dont_match);
        this.mDialogState = 3;
        this.mPin = null;
        showPinDialog();
        return;
    L20:
        this.mError = null;
        tryChangePin();
        return;
    L21:
        this.mNewPin = this.mPin;
        this.mDialogState = 4;
        this.mPin = null;
        showPinDialog();
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.preference.PreferenceManager.OnPreferenceTreeClickListener
    public boolean onPreferenceTreeClick(Preference r3) {
        SwitchPreference r0 = this.mPinToggle;
        if (r3 != r0) goto L6;
        boolean r4 = r0.isChecked();
        this.mToState = r4;
        this.mPinToggle.setChecked(!r4);
        this.mDialogState = 1;
        showPinDialog();
    L9:
        return true;
    L6:
        if (r3 != this.mPinDialog) goto L9;
        this.mDialogState = 2;
        return false;
    }

    private void tryChangeIccLockState() {
        Message r0 = Message.obtain(this.mHandler, 100);
        this.mPhone.getIccCard().setIccLockEnabled(this.mToState, this.mPin, r0);
        this.mPinToggle.setEnabled(false);
    }

    private void iccLockChanged(boolean r1, int r2) {
        if (r1 == false) goto L4;
        this.mPinToggle.setChecked(this.mToState);
    L5:
        this.mPinToggle.setEnabled(true);
        resetDialogState();
        return;
    L4:
        ToastUtils.show(getContext(), getPinPasswordErrorMessage(r2));
        goto L5
    }

    private void iccPinChanged(boolean r2, int r3) {
        if (r2 == true) goto L4;
        ToastUtils.show(getContext(), getPinPasswordErrorMessage(r3));
    L5:
        resetDialogState();
        return;
    L4:
        ToastUtils.show(getContext(), this.mRes.getString(R.string.sim_change_succeeded));
        goto L5
    }

    private void tryChangePin() {
        Message r0 = Message.obtain(this.mHandler, 101);
        this.mPhone.getIccCard().changeIccLockPassword(this.mOldPin, this.mNewPin, r0);
    }

    private String getPinPasswordErrorMessage(int r4) {
        if (r4 != 0) goto L4;
        String r3 = this.mRes.getString(R.string.wrong_pin_code_pukked);
    L7:
        OLog.d(TAG, "getPinPasswordErrorMessage: attemptsRemaining=" + r4 + " displayMessage=" + r3);
        return r3;
    L4:
        if (r4 <= 0) goto L6;
        r3 = this.mRes.getQuantityString(R.plurals.wrong_pin_code, r4, new Object[]{Integer.valueOf(r4)});
        goto L7
    L6:
        r3 = this.mRes.getString(R.string.pin_failed);
        goto L7
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

    private TabHost.TabSpec buildTabSpec(String r2, String r3) {
        return this.mTabHost.newTabSpec(r2).setIndicator(r3).setContent(this.mEmptyTabContent);
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_IccLockSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(IccLockSettings r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_IccLockSettings__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_IccLockSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(IccLockSettings r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_IccLockSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_IccLockSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(IccLockSettings r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_IccLockSettings__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
