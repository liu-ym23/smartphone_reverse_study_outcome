package com.android.settings.bluetooth;

import android.app.AlertDialog;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.UserHandle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.GlobalProxyLancet;
import com.android.internal.widget.LockPatternUtils;
import com.android.settings.ChooseLockSettingsHelper;
import com.android.settings.R;
import com.android.settings.SettingsApplication;
import com.android.settings.databinding.ProfileDisconnectDialogNewBinding;
import com.android.settings.ext.ViewExtKt;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.ResourceUtils;
import com.android.settings.utils.ThreadUtils;
import com.android.settings.utils.UIUtils;
import com.android.settingslib.widget.LottieColorUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.common.oea.style.scene.transition.TransitionAnimHelper;
import com.obric.common.oea.style.scene.transition.TransitionAnimStyle;
import com.obric.olog.OLog;
import com.obric.oui.button.OButton;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;
import com.obric.oui.dialog.v2.alert.style.DialogContainer;
import com.obric.oui.dialog.v2.alert.style.OViewStyleController;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.lisitem.OCardListItemPositionHelper;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.GrantUtil;
import com.obric.privacy.LifeHookActivity2;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.bluetooth.SmartBluetoothBinderClient;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceProfilesSettingsSmtActivity extends LifeHookActivity2 implements View.OnClickListener, CachedBluetoothDevice.Callback, CompoundButton.OnCheckedChangeListener {
    private static final int REQUEST_CONFIRM_PWD_CODE = 1001;
    private static final String TAG = "DeviceProfilesSettingsSmtActivity";
    private OSwitch codecSwitch;
    private OButton disconnectBtn;
    private Runnable disconnectFallbackRunnable;
    private boolean isDisconnecting;
    private boolean isHighQualityAudioEnabled;
    private boolean isProgrammaticChange;
    private View loadingImg;
    private LinearLayout mAdvancedContainer;
    private OCardListItem mAdvancedSetting;
    private LinearLayout mAutoDiscContainer;
    private int mBackBtnTextResId;
    private FrameLayout mBtnLayoutBottom;
    private FrameLayout mBtnLayoutRecordVoicePrint;
    private FrameLayout mBtnLayoutTop;
    private OButton mBtnRecordVoicePrint;
    private CachedBluetoothDevice mCachedDevice;
    private OCardListItem mCodecSetting;
    private OCardListItem mConnectionTimer;
    private Context mContext;
    private OCardListItem mDeviceProfileRenameItem;
    private AlertDialog mDisconnectDialog;
    private IntentFilter mIntentFilter;
    private LocalBluetoothManager mManager;
    private LinearLayout mProfileContainer;
    private boolean mProfileGroupIsRemoved;
    private LocalBluetoothProfileManager mProfileManager;
    private View mProfilesBottom;
    private TextView mProfilesHeaderTitle;
    private final BroadcastReceiver mReceiver;
    private DeviceRenameDialogFragment mRenamefragment;
    private Timer mTimer;
    OFloatingTitleBar mTitle;
    private OButton mUnpairBtn;

    class Task extends TimerTask {
        long mHasTime;
        final /* synthetic */ DeviceProfilesSettingsSmtActivity this$0;

        public Task(DeviceProfilesSettingsSmtActivity r3, long r4) {
            this.this$0 = r3;
            this.mHasTime = r4 + 60000;
            OLog.d(DeviceProfilesSettingsSmtActivity.TAG, " mHasTime = " + this.mHasTime);
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            DeviceProfilesSettingsSmtActivity.access$900(this.this$0).post(new AnonymousClass1(this));
            this.mHasTime -= 1000;
        }
    }

    public void com_android_settings_bluetooth_DeviceProfilesSettingsSmtActivity__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_bluetooth_DeviceProfilesSettingsSmtActivity__onResume$___twin___() {
        super.onResume();
    }

    public void com_android_settings_bluetooth_DeviceProfilesSettingsSmtActivity__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_bluetooth_DeviceProfilesSettingsSmtActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // android.app.Activity
    public void finish() {
        com_android_settings_bluetooth_DeviceProfilesSettingsSmtActivity_com_obric_hook_lancet_PrivacyHookActivity2_finish(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r1) {
        com_android_settings_bluetooth_DeviceProfilesSettingsSmtActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        com_android_settings_bluetooth_DeviceProfilesSettingsSmtActivity_com_obric_hook_lancet_PrivacyHookActivity2_onDestroy(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_bluetooth_DeviceProfilesSettingsSmtActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com_android_settings_bluetooth_DeviceProfilesSettingsSmtActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_bluetooth_DeviceProfilesSettingsSmtActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_bluetooth_DeviceProfilesSettingsSmtActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public DeviceProfilesSettingsSmtActivity() {
        this.mRenamefragment = null;
        this.isHighQualityAudioEnabled = false;
        this.isProgrammaticChange = false;
        this.isDisconnecting = false;
        this.disconnectFallbackRunnable = new AnonymousClass1(this);
        this.mReceiver = new AnonymousClass2(this);
    }

    static /* synthetic */ boolean access$000(DeviceProfilesSettingsSmtActivity r0) {
        return r0.isDisconnecting;
    }

    static /* synthetic */ boolean access$002(DeviceProfilesSettingsSmtActivity r0, boolean r1) {
        r0.isDisconnecting = r1;
        return r1;
    }

    static /* synthetic */ void access$100(DeviceProfilesSettingsSmtActivity r0) {
        r0.refreshButtonState();
    }

    static /* synthetic */ Context access$1000(DeviceProfilesSettingsSmtActivity r0) {
        return r0.mContext;
    }

    static /* synthetic */ Timer access$1100(DeviceProfilesSettingsSmtActivity r0) {
        return r0.mTimer;
    }

    static /* synthetic */ OCardListItem access$1200(DeviceProfilesSettingsSmtActivity r0) {
        return r0.mDeviceProfileRenameItem;
    }

    static /* synthetic */ void access$1300(DeviceProfilesSettingsSmtActivity r0) {
        r0.refreshProfiles();
    }

    static /* synthetic */ DeviceRenameDialogFragment access$200(DeviceProfilesSettingsSmtActivity r0) {
        return r0.mRenamefragment;
    }

    static /* synthetic */ Runnable access$300(DeviceProfilesSettingsSmtActivity r0) {
        return r0.disconnectFallbackRunnable;
    }

    static /* synthetic */ boolean access$400(DeviceProfilesSettingsSmtActivity r0) {
        return r0.isProgrammaticChange;
    }

    static /* synthetic */ boolean access$402(DeviceProfilesSettingsSmtActivity r0, boolean r1) {
        r0.isProgrammaticChange = r1;
        return r1;
    }

    static /* synthetic */ CachedBluetoothDevice access$500(DeviceProfilesSettingsSmtActivity r0) {
        return r0.mCachedDevice;
    }

    static /* synthetic */ OCardListItem access$600(DeviceProfilesSettingsSmtActivity r0) {
        return r0.mCodecSetting;
    }

    static /* synthetic */ OSwitch access$700(DeviceProfilesSettingsSmtActivity r0) {
        return r0.codecSwitch;
    }

    static /* synthetic */ String access$800(DeviceProfilesSettingsSmtActivity r0, long r1, boolean r3, boolean r4) {
        return r0.millisTimeToDotFormat(r1, r3, r4);
    }

    static /* synthetic */ OCardListItem access$900(DeviceProfilesSettingsSmtActivity r0) {
        return r0.mConnectionTimer;
    }

    public void com_android_settings_bluetooth_DeviceProfilesSettingsSmtActivity__onCreate$___twin___(Bundle r6) {
        super.onCreate(r6);
        setContentView(R.layout.device_profiles_settings_smt_activity_layout);
        this.mContext = this;
        com.android.settings.Utils.edgeToEdgeSystemViews(this);
        if (r6 == null) goto L5;
        BluetoothDevice r2 = (BluetoothDevice) r6.getParcelable("device");
        this.mBackBtnTextResId = r6.getInt("back_text_id", -1);
    L6:
        this.mTitle = (OFloatingTitleBar) findViewById(R.id.view_title);
        this.mProfileContainer = (LinearLayout) findViewById(R.id.profiles_container);
        this.mProfilesBottom = findViewById(R.id.profiles_bottom_view);
        this.mDeviceProfileRenameItem = (OCardListItem) findViewById(R.id.device_rename);
        this.mConnectionTimer = (OCardListItem) findViewById(R.id.connection_timer);
        this.mAutoDiscContainer = (LinearLayout) findViewById(R.id.auto_disconnect_container);
        this.mProfilesHeaderTitle = (TextView) findViewById(R.id.profiles_header_title);
        this.mUnpairBtn = (OButton) findViewById(R.id.unpair_btn);
        this.mAdvancedContainer = (LinearLayout) findViewById(R.id.advanced_container);
        this.mAdvancedSetting = (OCardListItem) findViewById(R.id.advanced_setting);
        this.mBtnLayoutRecordVoicePrint = (FrameLayout) findViewById(R.id.btnLayoutRecordVoicePrint);
        this.mBtnRecordVoicePrint = (OButton) findViewById(R.id.btn_record_voice_print);
        this.mBtnLayoutTop = (FrameLayout) findViewById(R.id.btnLayoutTop);
        this.mBtnLayoutBottom = (FrameLayout) findViewById(R.id.btnLayoutBottom);
        OButton r0 = this.mBtnRecordVoicePrint;
        if (r0 == null) goto L9;
        ViewExtKt.setOnDebounceClickListener(r0, new DeviceProfilesSettingsSmtActivity$$ExternalSyntheticLambda0(this));
    L9:
        OCardListItem r1 = (OCardListItem) findViewById(R.id.codec_item);
        this.mCodecSetting = r1;
        r1.setDefaultCustomEndView(1);
        OSwitch r3 = this.mCodecSetting.getEndSwitch();
        this.codecSwitch = r3;
        r3.setClickable(true);
        this.codecSwitch.setOnCheckedChangeListener(new AnonymousClass3(this));
        this.mAdvancedSetting.setOnContentClickListener(new DeviceProfilesSettingsSmtActivity$$ExternalSyntheticLambda1(this));
        this.disconnectBtn = (OButton) findViewById(R.id.disconnect_btn);
        this.loadingImg = findViewById(R.id.loading_view);
        ViewExtKt.setOnDebounceClickListener(this.disconnectBtn, new DeviceProfilesSettingsSmtActivity$$ExternalSyntheticLambda2(this));
        if (r2 != null) goto L13;
        OLog.w(TAG, "Activity started without a remote Bluetooth device");
        finish();
        return;
    L13:
        ((OFloatingTitleBar) findViewById(R.id.view_title)).addStartAction(R.drawable.o_floating_title_bar_icon_back, -1, null).setOnClickListener(new AnonymousClass4(this));
        LocalBluetoothManager r7 = LocalBluetoothManager.getInstance(this);
        this.mManager = r7;
        CachedBluetoothDeviceManager r8 = r7.getCachedDeviceManager();
        this.mProfileManager = this.mManager.getProfileManager();
        CachedBluetoothDevice r9 = r8.findDevice(r2);
        this.mCachedDevice = r9;
        if (r9 != null) goto L17;
        OLog.w(TAG, "Device not found, cannot connect to it");
        finish();
        return;
    L17:
        this.mDeviceProfileRenameItem.setOnContentClickListener(new DeviceProfilesSettingsSmtActivity$$ExternalSyntheticLambda3(this));
        this.mUnpairBtn.setOnClickListener(this);
        addPreferencesForProfiles();
        this.mManager.setForegroundActivity(this);
        this.mCachedDevice.registerCallback(this);
        if (this.mCachedDevice.getBondState() != 10) goto L20;
        finish();
    L20:
        refresh();
        IntentFilter r10 = new IntentFilter();
        this.mIntentFilter = r10;
        r10.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        this.mIntentFilter.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this, this.mReceiver, this.mIntentFilter);
        return;
    L5:
        r2 = (BluetoothDevice) ((Bundle) getIntent().getExtras().getParcelable("device")).getParcelable("device");
        this.mBackBtnTextResId = getIntent().getIntExtra("back_text_id", -1);
        goto L6
    }

    /* JADX INFO: renamed from: lambda$onCreate$0$com-android-settings-bluetooth-DeviceProfilesSettingsSmtActivity, reason: not valid java name */
    /* synthetic */ void m364x17085347(View r4) {
        if (new LockPatternUtils(this.mContext).isSecure(UserHandle.myUserId()) == false) goto L5;
        new ChooseLockSettingsHelper(this).launchConfirmationActivity(1001, null, 2, true);
        return;
    L5:
        startVoicePrintEnrollActivity();
    }

    /* JADX INFO: renamed from: lambda$onCreate$1$com-android-settings-bluetooth-DeviceProfilesSettingsSmtActivity, reason: not valid java name */
    /* synthetic */ void m365x8137db66(View r1) {
        onClick(this.mAdvancedSetting);
    }

    /* JADX INFO: renamed from: lambda$onCreate$2$com-android-settings-bluetooth-DeviceProfilesSettingsSmtActivity, reason: not valid java name */
    /* synthetic */ void m366xeb676385(View r2) {
        if (this.mCachedDevice.isBusy() == false) goto L6;
        return;
    L6:
        if (this.mCachedDevice.getDevice().isConnected() == false) goto L8;
        this.mCachedDevice.disconnect();
        applyDisconnect();
        return;
    L8:
        this.mCachedDevice.connect(true);
        ThreadUtils.getUiThreadHandler().removeCallbacks(this.disconnectFallbackRunnable);
    }

    /* JADX INFO: renamed from: lambda$onCreate$3$com-android-settings-bluetooth-DeviceProfilesSettingsSmtActivity, reason: not valid java name */
    /* synthetic */ void m367x5596eba4(View r1) {
        onClick(this.mDeviceProfileRenameItem);
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0052: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:24:0x0052 */
    private boolean hasObricVoicePrint() {
        ContentProviderClient r0 = null;
        Bundle r1 = null;
        r1 = null;
        r1 = null;
        ContentProviderClient r2 = SettingsApplication.getContext().getContentResolver().acquireUnstableContentProviderClient(Uri.parse("content://com.obric.sva.sdk.ipc.provider"));     // Catch: Throwable -> L11 RemoteException -> L13
        if (r2 != null) goto L29;
    L9:
        if (r2 == null) goto L19;
    L10:
        r2.close();
    L19:
        if (r1 == null) goto L22;
        boolean r3 = r1.getBoolean("status", false);
        OLog.i(TAG, "hasObricVoicePrint: " + r3);
        return r3;
    L22:
        return false;
    L29:
        r1 = r2.call("wakeup-get-status", null, null);     // Catch: RemoteException -> L7 Throwable -> L23
    L7:
        e = e;
    L15:
        OLog.e(TAG, "Failed to get voice print status", e);     // Catch: Throwable -> L23
        if (r2 == null) goto L19;
    L23:
        th = th;
        r0 = r1;
    L25:
        if (r0 == null) goto L27;
        r0.close();
    L27:
        throw th;
    L13:
        e = e;
        r2 = null;
    L11:
        th = th;
        goto L25
    }

    private void startVoicePrintEnrollActivity() {
        if (hasObricVoicePrint() == true) goto L6;
        Intent r0 = new Intent();
        r0.setClassName("com.larus.nova", "com.obric.assistant.AssistantSettingsActivity");
        r0.putExtra("previous_page", "system_settings");
        r0.putExtra("sub_page", "voice_print_management");
        startActivity(r0);
        return;
    L6:
        Intent r1 = new Intent("com.obric.sva.sdk.ACTION_START_ENROLL");
        r1.setClassName("com.larus.nova", "com.obric.audio.enroll.ui.VoicePrintEnrollActivity");
        r1.putExtra("sub_page", "voice_print");
        r1.putExtra("device_sn", ViewExtKt.sha256(this.mCachedDevice.getDevice().getAddress()));
        r1.putExtra("device_name", this.mCachedDevice.getName());
        r1.putExtra("enroll_device_type", 2);
        r1.putExtra("start_from", "SystemSetting");
        r1.putExtra("IS_DARK_MODE", LottieColorUtils.isDarkMode(this));
        startActivity(r1);     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        OLog.e(TAG, "Failed to start AssistantSettingsActivity", e);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int r1, int r2, Intent r3) {
        super.onActivityResult(r1, r2, r3);
        if (r1 == 1001) goto L5;
        return;
    L5:
        if (r2 != (-1)) goto L9;
        startVoicePrintEnrollActivity();
        return;
    }

    private void applyDisconnect() {
        this.isDisconnecting = true;
        ThreadUtils.getUiThreadHandler().postDelayed(this.disconnectFallbackRunnable, 2000);
    }

    public void com_android_settings_bluetooth_DeviceProfilesSettingsSmtActivity__onDestroy$___twin___() {
        super.onDestroy();
        AlertDialog r0 = this.mDisconnectDialog;
        if (r0 == null) goto L5;
        r0.dismiss();
        this.mDisconnectDialog = null;
    L5:
        CachedBluetoothDevice r1 = this.mCachedDevice;
        if (r1 == null) goto L8;
        r1.unregisterCallback(this);
    L8:
        LocalBluetoothManager r2 = this.mManager;
        if (r2 == null) goto L16;
        r2.setForegroundActivity(null);
    L16:
        unregisterReceiver(this.mReceiver);     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        OLog.e(TAG, e.toString());
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle r3) {
        super.onSaveInstanceState(r3);
        r3.putParcelable("device", this.mCachedDevice.getDevice());
        r3.putInt("back_text_id", this.mBackBtnTextResId);
    }

    void refreshTimerPreference() {
        if (this.mCachedDevice.isConnectedProfile(this.mProfileManager.getHeadsetProfile()) == false) goto L5;
    L13:
        OLog.d(TAG, "Device is connected, show the timer preference");
        SetTimerPreference();
        return;
    L5:
        if (this.mCachedDevice.isConnectedProfile(this.mProfileManager.getA2dpProfile()) == true) goto L13;
        Timer r0 = this.mTimer;
        if (r0 == null) goto L10;
        r0.cancel();
        this.mTimer = null;
    L10:
        LinearLayout r2 = this.mAutoDiscContainer;
        if (r2 == null) goto L15;
        r2.setVisibility(8);
        return;
    }

    private String millisTimeToDotFormat(long r7, boolean r9, boolean r10) {
        long r8 = r7 - ((r7 / 86400000) * 86400000);
        long r0 = r8 / 3600000;
        long r11 = r8 - (3600000 * r0);
        long r2 = r11 / 60000;
        long r12 = (r11 - (60000 * r2)) / 1000;
        OLog.d(TAG, " hours = " + r0 + "; mins = " + r2);
        if (r0 == 0) goto L5;
    L7:
        if (r0 != 0) goto L9;
    L11:
        if (r0 != 0) goto L13;
    L15:
        return "";
    L13:
        if (r2 == 0) goto L15;
        return getString(R.string.time_hour_min, new Object[]{Long.valueOf(r0), Long.valueOf(r2)});
    L9:
        if (r2 != 0) goto L11;
        return getString(R.string.time_hour, new Object[]{Long.valueOf(r0)});
    L5:
        if (r2 == 0) goto L7;
        return getString(R.string.time_min, new Object[]{Long.valueOf(r2)});
    }

    private void refreshRemainTime() {
        long r0 = Utils.getRemainingTime(this);
        if (r0 <= 0) goto L8;
        OLog.d(TAG, "start thread to count");
        String r2 = millisTimeToDotFormat(60000 + r0, false, false);
        OLog.d(TAG, "in refreshRemainTime = " + r0 + " ;set item title " + r2);
        this.mConnectionTimer.setEndDetailText(r2);
        this.mConnectionTimer.showCustomEnd(true);
        Timer r3 = this.mTimer;
        if (r3 == null) goto L7;
        r3.cancel();
        this.mTimer = null;
    L7:
        Timer r5 = new Timer(true);
        this.mTimer = r5;
        r5.schedule(new Task(this, r0), 0, 1000);
        return;
    L8:
        OLog.d(TAG, "remainTime < 0");
        Timer r1 = this.mTimer;
        if (r1 == null) goto L11;
        r1.cancel();
        this.mTimer = null;
    L11:
        this.mConnectionTimer.setTitle(this.mContext.getResources().getString(R.string.bluetooth_connection_timer));
        this.mConnectionTimer.setEndDetailText("");
    }

    private void SetTimerPreference() {
        if (this.mAutoDiscContainer != null) goto L5;
        return;
    L5:
        OLog.d(TAG, "SetTimerPreference");
        this.mConnectionTimer.setOnContentClickListener(new DeviceProfilesSettingsSmtActivity$$ExternalSyntheticLambda5(this));
        refreshRemainTime();
        this.mAutoDiscContainer.setVisibility(8);
    }

    /* JADX INFO: renamed from: lambda$SetTimerPreference$4$com-android-settings-bluetooth-DeviceProfilesSettingsSmtActivity, reason: not valid java name */
    /* synthetic */ void m363x25ee9780(View r1) {
        onClick(this.mConnectionTimer);
    }

    private void createRenameProfileDialog(String r4) {
        DeviceRenameDialogFragment r0 = this.mRenamefragment;
        if (r0 != null) goto L13;
    L11:
        DeviceRenameDialogFragment r1 = new DeviceRenameDialogFragment(r4);
        this.mRenamefragment = r1;
        r1.setDialogTitle(getString(R.string.bluetooth_rename_device));
        this.mRenamefragment.setPositiveButtonText(getString(R.string.bluetooth_rename_button));
        this.mRenamefragment.setPositiveButtonClickListener(new AnonymousClass5(this));
        this.mRenamefragment.showInActivity(this);
        return;
    L13:
    L8:
        e = move-exception;
        OLog.e(TAG, "dismiss rename fragment failed", e);
    L10:
        this.mRenamefragment = null;
        goto L11
    L5:
        if (r0.isAdded() == false) goto L10;
        this.mRenamefragment.dismiss();     // Catch: Exception -> L8
        goto L10
    }

    private void addPreferencesForProfiles() {
        this.mProfileContainer.removeAllViews();
        List<LocalBluetoothProfile> r0 = this.mCachedDevice.getConnectableProfiles();
        int r1 = 0;
    L4:
        if (r1 >= r0.size()) goto L6;
        View r2 = getProfileView(r0.get(r1));
        OCardListItem r3 = (OCardListItem) r2.findViewById(R.id.profile_item_container);
        this.mProfileContainer.addView(r2);
        r1 = r1 + 1;
        goto L4
    L6:
        showOrHideProfileGroup();
        refreshProfilesBackground();
    }

    private View getProfileView(LocalBluetoothProfile r8) {
        View r0 = LayoutInflater.from(this).inflate(R.layout.device_profile_item_layout_2, null, false);
        OCardListItem r1 = (OCardListItem) r0.findViewById(R.id.profile_item_container);
        r1.setDefaultCustomEndView(1);
        r1.getEndSwitch().setClickable(true);
        r0.setId(r8.toString().hashCode());
        r1.setTitle(this.mContext.getResources().getString(r8.getNameResource(this.mCachedDevice.getDevice())));
        int r4 = r8.getDrawableResource(this.mCachedDevice.getBtClass());
        int r5 = this.mCachedDevice.getProductId();
        if (r5 != (-1)) goto L8;
        SmartBluetoothBinderClient r6 = LocalBluetoothManager.getInstance(this.mContext).getSmartBluetoothBinderClient();
        if (r6 == null) goto L8;
        r5 = r6.getProductId(this.mCachedDevice.getDevice());
    L8:
        if (r5 != 4096) goto L10;
        r4 = R.drawable.settings_oic_glasses_fill;
    L21:
        if (r4 == 0) goto L23;
        r1.setIcon(r4);
    L23:
        r1.showIcon(false);
        r1.setEnabled(true ^ this.mCachedDevice.isBusy());
        refreshProfilePreference(r0, r8);
        return r0;
    L10:
        if (r5 != 1) goto L13;
        r4 = R.drawable.settings_oic_oladance_earphone;
        goto L21
    L13:
        if (r5 != 365) goto L15;
    L20:
        r4 = R.drawable.settings_oic_freebudspro_double;
        goto L21
    L15:
        if (r5 == 363) goto L20;
        if (r5 != 359) goto L21;
        r4 = R.drawable.settings_oic_freeclip2_double;
        goto L21
    }

    private void showOrHideProfileGroup() {
        int r0 = this.mProfileContainer.getChildCount();
        boolean r1 = this.mProfileGroupIsRemoved;
        if (r1 == true) goto L6;
        if (r0 != 0) goto L6;
        this.mProfileContainer.setVisibility(8);
        this.mProfilesBottom.setVisibility(8);
        this.mProfileGroupIsRemoved = true;
    L9:
        OLog.d(TAG, "showOrHideProfileGroup num:" + r0);
        return;
    L6:
        if (r1 == false) goto L9;
        if (r0 == 0) goto L9;
        this.mProfileContainer.setVisibility(0);
        this.mProfilesBottom.setVisibility(0);
        this.mProfileGroupIsRemoved = false;
        goto L9
    }

    private void onProfileClicked(LocalBluetoothProfile r6, View r7, CompoundButton r8) {
        BluetoothDevice r0 = this.mCachedDevice.getDevice();
        if (r6.getConnectionStatus(r0) != 2) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L11;
        if (r8.isChecked() == true) goto L15;
        askDisconnect(this, r6, r8);
        return;
    L15:
        return;
    L11:
        if (r6.isPreferred(r0) == false) goto L13;
        r6.setPreferred(r0, false);
        refreshProfilePreference(r7, r6);
        refreshAdvancedSetting();
        return;
    L13:
        r6.setPreferred(r0, true);
        this.mCachedDevice.connectProfile(r6);
        return;
    L5:
        r1 = false;
        goto L6
    }

    private void askDisconnect(Context r12, final LocalBluetoothProfile r13, final CompoundButton r14) {
        final CachedBluetoothDevice r0 = this.mCachedDevice;
        String r1 = r0.getName();
        if (TextUtils.isEmpty(r1) == false) goto L5;
        r1 = r12.getString(R.string.bluetooth_device);
    L5:
        String r2 = r12.getString(r13.getNameResource(r0.getDevice()));
        final ProfileDisconnectDialogNewBinding r15 = ProfileDisconnectDialogNewBinding.inflate(LayoutInflater.from(r12));
        LinearLayout r3 = r15.getRoot();
        OViewStyleController r4 = new OViewStyleController(new DeviceProfilesSettingsSmtActivity$$ExternalSyntheticLambda4(r15));
        r3.setPadding(r3.getPaddingLeft(), r3.getPaddingTop(), r3.getPaddingRight(), r3.getPaddingBottom() + UIUtils.INSTANCE.dp2px(20));
        r15.desName.setText(r2);
        r15.desName2.setText(r1);
        ((OAlertDialog) new OAlertDialogBuilder(this).autoDismiss(false).horizontalButton().title(R.string.bluetooth_disable_profile_title).body(r4).positiveButton(R.string.ok, new AnonymousClass8(this, r0, r13)).negativeButton(R.string.cancel, new AnonymousClass7(this, r14)).onCancel(new AnonymousClass6(this, r14)).build()).show();
    }

    static /* synthetic */ Unit lambda$askDisconnect$5(ProfileDisconnectDialogNewBinding r0, DialogContainer r1) {
        r1.getBodySlot().addView(r0.getRoot());
        return null;
    }

    private void refresh() {
        String r0 = this.mCachedDevice.getName();
        this.mTitle.setCenterTitle(r0);
        this.mDeviceProfileRenameItem.setEndDetailText(r0);
        this.mDeviceProfileRenameItem.showCustomEnd(true);
        refreshProfiles();
        refreshTimerPreference();
        refreshAdvancedSetting();
        refreshButtonState();
    }

    private void refreshButtonState() {
        if (this.disconnectBtn == null) goto L15;
        String r0 = ResourceUtils.getString(R.string.bluetooth_device_context_disconnect);
        if (this.mCachedDevice.isAclConnected() == true) goto L8;
        r0 = ResourceUtils.getString(R.string.bluetooth_device_context_connect);
    L8:
        if (this.mCachedDevice.isConnecting() == false) goto L10;
    L13:
        r0 = "";
    L14:
        this.disconnectBtn.setText(r0);
        goto L15
    L10:
        if (this.mCachedDevice.isDisconnecting() == true) goto L13;
        if (this.isDisconnecting == false) goto L14;
    L15:
        View r1 = this.loadingImg;
        if (r1 != null) goto L18;
    L27:
        updateButtonPositions();
        return;
    L18:
        if (this.mCachedDevice.isConnecting() == false) goto L20;
    L25:
        int r2 = 0;
    L26:
        r1.setVisibility(r2);
        goto L27
    L20:
        if (this.mCachedDevice.isDisconnecting() == true) goto L25;
        if (this.isDisconnecting == true) goto L25;
        r2 = 8;
        goto L26
    }

    private void updateButtonPositions() {
        if (this.mBtnLayoutTop != null) goto L5;
        return;
    L5:
        if (this.mBtnLayoutBottom != null) goto L7;
        return;
    L7:
        if (this.mBtnLayoutRecordVoicePrint == null) goto L17;
        int r0 = this.mContext.getColor(R.color.oui_fill_list_item_card);
        if (this.mBtnLayoutRecordVoicePrint.getVisibility() != 0) goto L12;
        new OCardListItemPositionHelper(this.mBtnLayoutRecordVoicePrint, true, r0, 1);
        new OCardListItemPositionHelper(this.mBtnLayoutTop, true, r0, 2);
        new OCardListItemPositionHelper(this.mBtnLayoutBottom, true, r0, 3);
        return;
    L12:
        new OCardListItemPositionHelper(this.mBtnLayoutTop, true, r0, 1);
        new OCardListItemPositionHelper(this.mBtnLayoutBottom, true, r0, 3);
        return;
    }

    private void refreshProfiles() {
        OLog.d(TAG, "refreshProfiles");
        BluetoothDevice r0 = this.mCachedDevice.getDevice();
        Iterator<LocalBluetoothProfile> r2 = this.mCachedDevice.getConnectableProfiles().iterator();
    L4:
        if (r2.hasNext() == false) goto L24;
        LocalBluetoothProfile r3 = r2.next();
        View r4 = findViewById(r3.toString().hashCode());
        if (r4 != null) goto L8;
        this.mProfileContainer.addView(getProfileView(r3));
    L10:
        if ((r3 instanceof A2dpProfile) == false) goto L4;
        OLog.d(TAG, "refreshProfiles A2dpProfile");
        A2dpProfile r5 = (A2dpProfile) r3;
        boolean r6 = r5.supportsHighQualityAudio(r0);
        boolean r7 = r5.isHighQualityAudioEnabled(r0);
        this.isHighQualityAudioEnabled = r7;
        String r8 = r5.getHighQualityAudioOptionLabel(r0);
        if (TextUtils.isEmpty(r8) == false) goto L14;
        r8 = A2dpProfile.getHighQualityAudioOptionLabel(BluetoothUtils.getCodeType(r0.getAddress()));
    L14:
        OLog.d(TAG, "refreshProfiles A2dpProfile label = " + r8 + "supportHighQualityAudio = " + r6 + " enable = " + r7);
        OCardListItem r9 = this.mCodecSetting;
        boolean r10 = false;
        if (r6 == true) goto L17;
    L19:
        int r11 = 8;
    L20:
        r9.setVisibility(r11);
        if (this.codecSwitch.isChecked() == r7) goto L23;
        r10 = true;
    L23:
        this.isProgrammaticChange = r10;
        this.codecSwitch.setChecked(r7);
        this.mCodecSetting.setSubTitle(r8);
        this.mCodecSetting.showSubTitle(true);
        goto L4
    L17:
        if (TextUtils.isEmpty(r8) == true) goto L19;
        r11 = 0;
        goto L20
    L8:
        refreshProfilePreference(r4, r3);
        goto L10
    L24:
        Iterator<LocalBluetoothProfile> r1 = this.mCachedDevice.getRemovedProfiles().iterator();
    L26:
        if (r1.hasNext() == false) goto L30;
        LocalBluetoothProfile r12 = r1.next();
        View r13 = findViewById(r12.toString().hashCode());
        if (r13 == null) goto L26;
        OLog.d(TAG, "Removing " + r12.toString().hashCode() + " from profile list");
        this.mProfileContainer.removeView(r13);
        goto L26
    L30:
        this.mCodecSetting.setEnabled(this.mCachedDevice.isConnected());
        showOrHideProfileGroup();
        refreshProfilesBackground();
    }

    private void refreshProfilesBackground() {
        int r0 = this.mProfileContainer.getChildCount();
        OCardListItem r1 = null;
        OCardListItem r3 = null;
        int r4 = 0;
    L3:
        if (r4 >= r0) goto L8;
        r3 = (OCardListItem) this.mProfileContainer.getChildAt(r4).findViewById(R.id.profile_item_container);
        if (r1 != null) goto L7;
        r1 = r3;
    L7:
        r3.setCardPosition(2);
        r4 = r4 + 1;
        goto L3
    L8:
        if (r1 == null) goto L12;
        if (r1 != r3) goto L12;
        r1.setCardPosition(0);
        return;
    L12:
        if (r1 == null) goto L14;
        r1.setCardPosition(1);
    L14:
        if (r3 == null) goto L20;
        r3.setCardPosition(3);
        return;
    }

    private void refreshProfilePreference(View r5, LocalBluetoothProfile r6) {
        BluetoothDevice r0 = this.mCachedDevice.getDevice();
        OCardListItem r7 = (OCardListItem) r5.findViewById(R.id.profile_item_container);
        r7.setDefaultCustomEndView(1);
        OSwitch r2 = r7.getEndSwitch();
        r2.setClickable(true);
        r2.setChecked(r6.isPreferred(r0));
        r2.setOnCheckedChangeListener(this);
        r2.setTag(r6.toString());
        r7.setSubTitle(this.mContext.getResources().getString(r6.getSummaryResourceForDevice(r0)));
        r7.showSubTitle(true);
    }

    private LocalBluetoothProfile getProfileOf(View r3) {
        if ((r3 instanceof OSwitch) == true) goto L5;
        return null;
    L5:
        Object r4 = r3.getTag();
        if (r4 != null) goto L8;
        return null;
    L8:
        String r5 = (String) r4;
        if (TextUtils.isEmpty(r5) == false) goto L14;
        return null;
    L14:
        return this.mProfileManager.getProfileByName(r5);
    L13:
        return null;
    }

    private void unpairDevice() {
        OLog.d(TAG, "unpairDevice");
        this.mCachedDevice.unpair();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r4) {
        switch(r4.getId()) {
            case 2131427539: goto L10;
            case 2131428168: goto L12;
            case 2131428382: goto L9;
            case 2131431572: goto L5;
            default: goto L4;
        };
    L4:
        OLog.e(TAG, "The onClick of the view is undefined..");
        return;
    L5:
        unpairDevice();
        CachedBluetoothDevice r5 = this.mCachedDevice;
        if (r5 == null) goto L8;
        r5.unregisterCallback(this);
    L8:
        finish();
        return;
    L9:
        createRenameProfileDialog(this.mCachedDevice.getName());
        return;
    L10:
        Intent r6 = new Intent(this.mContext, DeviceAdvancedSettings.class);
        Bundle r0 = new Bundle();
        r0.putParcelable("device", this.mCachedDevice.getDevice());
        r6.putExtras(r0);
        com.android.settings.Utils.startActivity(this.mContext, r6);
        return;
    }

    @Override // com.android.settings.bluetooth.CachedBluetoothDevice.Callback
    public void onDeviceAttributesChanged(boolean r1) {
        refresh();
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r2, boolean r3) {
        LocalBluetoothProfile r4 = getProfileOf(r2);
        if (r4 == null) goto L9;
        View r0 = findViewById(r4.toString().hashCode());
        if (r0 != null) goto L7;
        return;
    L7:
        onProfileClicked(r4, r0, r2);
        return;
    }

    private void refreshAdvancedSetting() {
        A2dpProfile r0 = this.mProfileManager.getA2dpProfile();
        HeadsetProfile r1 = this.mProfileManager.getHeadsetProfile();
        if (this.mCachedDevice.isConnectedProfile(r0) == false) goto L5;
    L9:
        this.mAdvancedSetting.setEnabled(true);
        return;
    L5:
        if (this.mCachedDevice.isConnectedProfile(r1) == true) goto L9;
        this.mAdvancedSetting.setEnabled(false);
    }

    public void com_android_settings_bluetooth_DeviceProfilesSettingsSmtActivity__finish$___twin___() {
        super.finish();
        TransitionAnimHelper.overrideExitAnim(this, TransitionAnimStyle.Standard);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_bluetooth_DeviceProfilesSettingsSmtActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(DeviceProfilesSettingsSmtActivity r1) {
        com_android_settings_bluetooth_DeviceProfilesSettingsSmtActivity_com_obric_hook_lancet_PrivacyHookActivity2_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_bluetooth_DeviceProfilesSettingsSmtActivity_com_obric_hook_lancet_PrivacyHookActivity2_onCreate(DeviceProfilesSettingsSmtActivity r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        DeviceProfilesSettingsSmtActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_bluetooth_DeviceProfilesSettingsSmtActivity__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_bluetooth_DeviceProfilesSettingsSmtActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(DeviceProfilesSettingsSmtActivity r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_bluetooth_DeviceProfilesSettingsSmtActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_bluetooth_DeviceProfilesSettingsSmtActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(DeviceProfilesSettingsSmtActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_bluetooth_DeviceProfilesSettingsSmtActivity_com_obric_hook_lancet_PrivacyHookActivity2_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        DeviceProfilesSettingsSmtActivity r5 = r4;
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
    public static void com_android_settings_bluetooth_DeviceProfilesSettingsSmtActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(DeviceProfilesSettingsSmtActivity r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_bluetooth_DeviceProfilesSettingsSmtActivity__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_bluetooth_DeviceProfilesSettingsSmtActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(DeviceProfilesSettingsSmtActivity r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_bluetooth_DeviceProfilesSettingsSmtActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_bluetooth_DeviceProfilesSettingsSmtActivity_com_obric_hook_lancet_PrivacyHookActivity2_onResume(DeviceProfilesSettingsSmtActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        DeviceProfilesSettingsSmtActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_bluetooth_DeviceProfilesSettingsSmtActivity__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_bluetooth_DeviceProfilesSettingsSmtActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(DeviceProfilesSettingsSmtActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_bluetooth_DeviceProfilesSettingsSmtActivity_com_obric_hook_lancet_PrivacyHookActivity2_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_bluetooth_DeviceProfilesSettingsSmtActivity_com_obric_hook_lancet_PrivacyHookActivity2_onPause(DeviceProfilesSettingsSmtActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        DeviceProfilesSettingsSmtActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_bluetooth_DeviceProfilesSettingsSmtActivity__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_bluetooth_DeviceProfilesSettingsSmtActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(DeviceProfilesSettingsSmtActivity r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_bluetooth_DeviceProfilesSettingsSmtActivity_com_obric_hook_lancet_PrivacyHookActivity2_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        DeviceProfilesSettingsSmtActivity r5 = r3;
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
    public static void com_android_settings_bluetooth_DeviceProfilesSettingsSmtActivity_com_obric_hook_lancet_PrivacyHookActivity2_onStop(DeviceProfilesSettingsSmtActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        DeviceProfilesSettingsSmtActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_bluetooth_DeviceProfilesSettingsSmtActivity__onStop$___twin___();
    }

    @Insert("onDestroy")
    public static void com_android_settings_bluetooth_DeviceProfilesSettingsSmtActivity_com_obric_hook_lancet_PrivacyHookActivity2_onDestroy(DeviceProfilesSettingsSmtActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        DeviceProfilesSettingsSmtActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperDestroy();
        return;
    L6:
        r3.com_android_settings_bluetooth_DeviceProfilesSettingsSmtActivity__onDestroy$___twin___();
    }

    @Insert("finish")
    public static void com_android_settings_bluetooth_DeviceProfilesSettingsSmtActivity_com_obric_hook_lancet_PrivacyHookActivity2_finish(DeviceProfilesSettingsSmtActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        DeviceProfilesSettingsSmtActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.superFinish();
        return;
    L6:
        r3.com_android_settings_bluetooth_DeviceProfilesSettingsSmtActivity__finish$___twin___();
    }
}
