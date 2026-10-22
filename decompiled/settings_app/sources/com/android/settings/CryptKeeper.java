package com.android.settings;

import android.app.StatusBarManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.PowerManager;
import android.os.RemoteException;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.telecom.TelecomManager;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.format.DateUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import android.view.inputmethod.InputMethodSubtype;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.lifecycle.ViewModelProvider;
import bytedanceos.api.TextViewSmt;
import com.android.internal.widget.KeyguardLockPatternView;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.NullSafe;
import com.android.settings.viewmodel.CryptKeeperViewModel;
import com.android.settingslib.applications.RecentAppOpsAccess;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.oui.texteffects.preset.DimPointEffectTokens;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.GrantUtil;
import com.obric.privacy.LifeHookActivity2;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class CryptKeeper extends LifeHookActivity2 implements TextView.OnEditorActionListener, View.OnKeyListener, View.OnTouchListener, TextWatcher {
    static final String ACTION_EMERGENCY_DIAL = "com.android.phone.EmergencyDialer.DIAL";
    private static final int COOL_DOWN_ATTEMPTS = 10;
    private static final String DECRYPT_STATE = "trigger_restart_framework";
    private static final String EXTRA_FORCE_VIEW = "com.android.settings.CryptKeeper.DEBUG_FORCE_VIEW";
    private static final int FAKE_ATTEMPT_DELAY = 1000;
    private static final String FORCE_VIEW_ERROR = "error";
    private static final String FORCE_VIEW_PASSWORD = "password";
    private static final String FORCE_VIEW_PROGRESS = "progress";
    private static final int MAX_FAILED_ATTEMPTS = 30;
    private static final int MESSAGE_NOTIFY = 2;
    private static final int MESSAGE_UPDATE_PROGRESS = 1;
    protected static final int MIN_LENGTH_BEFORE_REPORT = 4;
    private static final int RIGHT_PATTERN_CLEAR_TIMEOUT_MS = 500;
    private static final String STATE_COOLDOWN = "cooldown";
    private static final String TAG = "CryptKeeper";
    private static final int WRONG_PATTERN_CLEAR_TIMEOUT_MS = 1500;
    private static final int sWidgetsToDisable = 52887552;
    private AudioManager mAudioManager;
    protected KeyguardLockPatternView.OnPatternListener mChooseNewLockPatternListener;
    private final Runnable mClearPatternRunnable;
    private boolean mCooldown;
    private boolean mCorrupt;
    private boolean mEncryptionGoneBad;
    private final Runnable mFakeUnlockAttemptRunnable;
    private final Handler mHandler;
    private KeyguardLockPatternView mLockPatternView;
    private boolean mMdtpActivated;
    private int mNotificationCountdown;
    private EditText mPasswordEntry;
    private int mReleaseWakeLockCountdown;
    private View mRightView;
    private StatusBarManager mStatusBar;
    private int mStatusString;
    private OFloatingTitleBar mTitle;
    private boolean mValidationComplete;
    private boolean mValidationRequested;
    private CryptKeeperViewModel mViewModel;
    PowerManager.WakeLock mWakeLock;

    /* JADX INFO: renamed from: com.android.settings.CryptKeeper$9, reason: invalid class name */
    class AnonymousClass9 implements View.OnClickListener {
        final /* synthetic */ CryptKeeper this$0;

        AnonymousClass9(CryptKeeper r1) {
            this.this$0 = r1;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r1) {
            CryptKeeper.access$2100(this.this$0);
        }
    }

    private class DecryptTask extends AsyncTask<String, Void, Integer> {
        final /* synthetic */ CryptKeeper this$0;

        private DecryptTask(CryptKeeper r1) {
            this.this$0 = r1;
        }

        /* synthetic */ DecryptTask(CryptKeeper r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ Integer doInBackground(String[] r1) {
            return doInBackground2(r1);
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ void onPostExecute(Integer r1) {
            onPostExecute2(r1);
        }

        private void hide(int r1) {
            View r0 = this.this$0.findViewById(r1);
            if (r0 == null) goto L6;
            r0.setVisibility(8);
            return;
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            super.onPreExecute();
            CryptKeeper.access$200(this.this$0);
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        protected Integer doInBackground2(String... r2) {
            return Integer.valueOf(MultiSDKAdapter.decryptStorage(r2[0]));
        L5:
            e = move-exception;
            OLog.e(CryptKeeper.TAG, "Error while decrypting...", e);
            return -1;
        }

        /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        protected void onPostExecute2(Integer r4) {
            if (r4.intValue() != 0) goto L9;
            if (CryptKeeper.access$100(this.this$0) == null) goto L7;
            CryptKeeper.access$100(this.this$0).removeCallbacks(CryptKeeper.access$300(this.this$0));
            CryptKeeper.access$100(this.this$0).postDelayed(CryptKeeper.access$300(this.this$0), 500);
        L7:
            hide(R.id.passwordEntry);
            hide(R.id.switch_ime_button);
            hide(R.id.lockPattern);
            hide(R.id.status);
            hide(R.id.emergencyCallButton);
            return;
        L9:
            if (r4.intValue() != 30) goto L20;
            if (CryptKeeper.access$400(this.this$0) == false) goto L18;
            OLog.d(CryptKeeper.TAG, "  CryptKeeper.MAX_FAILED_ATTEMPTS, calling encryptStorage with wipe");
            MultiSDKAdapter.encryptWipeStorage(1, "");     // Catch: RemoteException -> L15
            return;
        L15:
            e = move-exception;
            e.printStackTrace();
            OLog.w(CryptKeeper.TAG, "Unable to call MountService properly");
            return;
        L18:
            Intent r5 = new Intent(MultiSDKAdapter.ACTION_FACTORY_RESET);
            r5.setPackage(RecentAppOpsAccess.ANDROID_SYSTEM_PACKAGE_NAME);
            r5.addFlags(268435456);
            r5.putExtra("android.intent.extra.REASON", "CryptKeeper.MAX_FAILED_ATTEMPTS");
            this.this$0.sendBroadcast(r5);
            return;
        L20:
            if (r4.intValue() != (-1)) goto L23;
            this.this$0.setContentView(R.layout.crypt_keeper_progress);
            CryptKeeper.access$500(this.this$0, true, false);
            return;
        L23:
            CryptKeeper.access$000(this.this$0, r4);
        }
    }

    private class ValidationTask extends AsyncTask<Void, Void, Boolean> {
        int state;
        final /* synthetic */ CryptKeeper this$0;

        private ValidationTask(CryptKeeper r1) {
            this.this$0 = r1;
        }

        /* synthetic */ ValidationTask(CryptKeeper r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ Boolean doInBackground(Void[] r1) {
            return doInBackground2(r1);
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ void onPostExecute(Boolean r1) {
            onPostExecute2(r1);
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        protected Boolean doInBackground2(Void... r5) {
            OLog.d(CryptKeeper.TAG, "Validating encryption state.");     // Catch: RemoteException -> L15
            int r1 = MultiSDKAdapter.getEncryptionState();     // Catch: RemoteException -> L15
            this.state = r1;     // Catch: RemoteException -> L15
            boolean r3 = true;
            if (r1 != MultiSDKAdapter.ENCRYPTION_STATE_NONE) goto L8;
            OLog.w(CryptKeeper.TAG, "Unexpectedly in CryptKeeper even though there is no encryption.");     // Catch: RemoteException -> L15
            return true;
        L8:
            if (this.state == MultiSDKAdapter.ENCRYPTION_STATE_OK) goto L14;
            if (this.state == MultiSDKAdapter.ENCRYPTION_STATE_OK_MDTP_ACTIVATED) goto L14;
            r3 = false;
        L14:
            return Boolean.valueOf(r3);
        L15:
            OLog.w(CryptKeeper.TAG, "Unable to get encryption state properly");
            return false;
        }

        /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        protected void onPostExecute2(Boolean r4) {
            boolean r1 = true;
            CryptKeeper.access$602(this.this$0, true);
            if (Boolean.FALSE.equals(r4) == false) goto L9;
            OLog.w(CryptKeeper.TAG, "Incomplete, or corrupted encryption detected. Prompting user to wipe.");
            CryptKeeper.access$702(this.this$0, true);
            CryptKeeper r5 = this.this$0;
            if (this.state == MultiSDKAdapter.ENCRYPTION_STATE_ERROR_CORRUPT) goto L8;
            r1 = false;
        L8:
            CryptKeeper.access$802(r5, r1);
        L10:
            CryptKeeper.access$900(this.this$0);
            return;
        L9:
            OLog.d(CryptKeeper.TAG, "Encryption state validated. Proceeding to configure UI");
            goto L10
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable r1) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    public void com_android_settings_CryptKeeper__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_CryptKeeper__onResume$___twin___() {
        super.onResume();
    }

    public void com_android_settings_CryptKeeper__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r1) {
        com_android_settings_CryptKeeper_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        com_android_settings_CryptKeeper_com_obric_hook_lancet_PrivacyHookActivity2_onDestroy(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_CryptKeeper_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com_android_settings_CryptKeeper_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        com_android_settings_CryptKeeper_com_obric_hook_lancet_PrivacyHookActivity2_onStart(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_CryptKeeper_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_CryptKeeper_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public CryptKeeper() {
        this.mCooldown = false;
        this.mNotificationCountdown = 0;
        this.mReleaseWakeLockCountdown = 0;
        this.mStatusString = R.string.enter_password;
        this.mFakeUnlockAttemptRunnable = new AnonymousClass1(this);
        this.mClearPatternRunnable = new AnonymousClass2(this);
        this.mHandler = new AnonymousClass3(this);
        this.mChooseNewLockPatternListener = new AnonymousClass6(this);
    }

    static /* synthetic */ void access$000(CryptKeeper r0, Integer r1) {
        r0.handleBadAttempt(r1);
    }

    static /* synthetic */ KeyguardLockPatternView access$100(CryptKeeper r0) {
        return r0.mLockPatternView;
    }

    static /* synthetic */ void access$1000(CryptKeeper r0) {
        r0.updateProgress();
    }

    static /* synthetic */ void access$1100(CryptKeeper r0) {
        r0.notifyUser();
    }

    static /* synthetic */ OFloatingTitleBar access$1200(CryptKeeper r0) {
        return r0.mTitle;
    }

    static /* synthetic */ OFloatingTitleBar access$1202(CryptKeeper r0, OFloatingTitleBar r1) {
        r0.mTitle = r1;
        return r1;
    }

    static /* synthetic */ void access$1300(CryptKeeper r0) {
        r0.initRightButton();
    }

    static /* synthetic */ int access$1400(CryptKeeper r0) {
        return r0.mStatusString;
    }

    static /* synthetic */ boolean access$1500(CryptKeeper r0) {
        return r0.mCooldown;
    }

    static /* synthetic */ void access$1600(CryptKeeper r0, boolean r1) {
        r0.setBackFunctionality(r1);
    }

    static /* synthetic */ void access$1700(CryptKeeper r0) {
        r0.cooldown();
    }

    static /* synthetic */ void access$200(CryptKeeper r0) {
        r0.beginAttempt();
    }

    static /* synthetic */ void access$2000(CryptKeeper r0, View r1) {
        r0.fakeUnlockAttempt(r1);
    }

    static /* synthetic */ void access$2100(CryptKeeper r0) {
        r0.takeEmergencyCallAction();
    }

    static /* synthetic */ boolean access$2200(CryptKeeper r0) {
        return r0.verifyPassword();
    }

    static /* synthetic */ Runnable access$300(CryptKeeper r0) {
        return r0.mClearPatternRunnable;
    }

    static /* synthetic */ boolean access$400(CryptKeeper r0) {
        return r0.mMdtpActivated;
    }

    static /* synthetic */ boolean access$402(CryptKeeper r0, boolean r1) {
        r0.mMdtpActivated = r1;
        return r1;
    }

    static /* synthetic */ void access$500(CryptKeeper r0, boolean r1, boolean r2) {
        r0.showFactoryReset(r1, r2);
    }

    static /* synthetic */ boolean access$602(CryptKeeper r0, boolean r1) {
        r0.mValidationComplete = r1;
        return r1;
    }

    static /* synthetic */ boolean access$702(CryptKeeper r0, boolean r1) {
        r0.mEncryptionGoneBad = r1;
        return r1;
    }

    static /* synthetic */ boolean access$802(CryptKeeper r0, boolean r1) {
        r0.mCorrupt = r1;
        return r1;
    }

    static /* synthetic */ void access$900(CryptKeeper r0) {
        r0.setupUi();
    }

    private void beginAttempt() {
        ((TextView) findViewById(R.id.status)).setText(R.string.checking_decryption);
    }

    private void handleBadAttempt(Integer r6) {
        KeyguardLockPatternView r0 = this.mLockPatternView;
        if (r0 == null) goto L6;
        r0.setDisplayMode(KeyguardLockPatternView.DisplayMode.Wrong);
        this.mLockPatternView.removeCallbacks(this.mClearPatternRunnable);
        this.mLockPatternView.postDelayed(this.mClearPatternRunnable, DimPointEffectTokens.PendingCycleMs);
    L6:
        if ((r6.intValue() % 10) != 0) goto L8;
        this.mCooldown = true;
        cooldown();
        return;
    L8:
        TextView r1 = (TextView) NullSafe.nonNull(findViewById(R.id.status));
        int r7 = 30 - r6.intValue();
        if (r7 >= 10) goto L11;
        r1.setText(TextUtils.expandTemplate(getText(R.string.crypt_keeper_warn_wipe), new CharSequence[]{Integer.toString(r7)}));
    L11:
        KeyguardLockPatternView r8 = this.mLockPatternView;
        if (r8 == null) goto L14;
        r8.setDisplayMode(KeyguardLockPatternView.DisplayMode.Wrong);
    L14:
        EditText r9 = this.mPasswordEntry;
        if (r9 == null) goto L17;
        r9.setEnabled(true);
        ((InputMethodManager) getSystemService("input_method")).showSoftInput(this.mPasswordEntry, 0);
        setBackFunctionality(true);
    L17:
        KeyguardLockPatternView r5 = this.mLockPatternView;
        if (r5 == null) goto L22;
        r5.setEnabled(true);
        return;
    }

    private boolean isDebugView() {
        return getIntent().hasExtra(EXTRA_FORCE_VIEW);
    }

    private boolean isDebugView(String r2) {
        return r2.equals(getIntent().getStringExtra(EXTRA_FORCE_VIEW));
    }

    private void notifyUser() {
        int r0 = this.mNotificationCountdown;
        if (r0 <= 0) goto L5;
        this.mNotificationCountdown = r0 - 1;
    L12:
        this.mHandler.removeMessages(2);
        this.mHandler.sendEmptyMessageDelayed(2, 5000);
        if (this.mWakeLock.isHeld() == false) goto L21;
        int r1 = this.mReleaseWakeLockCountdown;
        if (r1 <= 0) goto L17;
        this.mReleaseWakeLockCountdown = r1 - 1;
        return;
    L17:
        this.mWakeLock.release();
        return;
    L21:
        return;
    L5:
        AudioManager r2 = this.mAudioManager;
        if (r2 == null) goto L12;
        r2.playSoundEffect(5, 100);     // Catch: Exception -> L10
    L10:
        e = move-exception;
        OLog.w(TAG, "notifyUser: Exception while playing sound: " + e);
        goto L12
    }

    public void com_android_settings_CryptKeeper__onCreate$___twin___(Bundle r4) {
        super.onCreate(r4);
        Utils.setTranslucentStatusAndNavigation(getApplicationContext(), getWindow());
        String r0 = SystemProperties.get("vold.decrypt");
        boolean r1 = SystemProperties.getBoolean("ro.alarm_boot", false);
        if (isDebugView() == false) goto L5;
    L8:
        if (r1 == false) goto L11;
    L9:
        disableCryptKeeperComponent(this);
        finish();
        return;
    L11:
        StatusBarManager r2 = (StatusBarManager) getSystemService("statusbar");
        this.mStatusBar = r2;
        r2.disable(sWidgetsToDisable);
        if (r4 == null) goto L14;
        this.mCooldown = r4.getBoolean(STATE_COOLDOWN);
    L14:
        setAirplaneModeIfNecessary();
        this.mAudioManager = (AudioManager) getSystemService("audio");
        CryptKeeperViewModel r5 = (CryptKeeperViewModel) new ViewModelProvider(this).get(CryptKeeperViewModel.class);
        this.mViewModel = r5;
        if (r5.wakelock == null) goto L18;
        OLog.d(TAG, "Restoring wakelock from CryptKeeperViewModel");
        this.mWakeLock = this.mViewModel.wakelock;
        return;
    L18:
        return;
    L5:
        if ("".equals(r0) == true) goto L9;
        if (DECRYPT_STATE.equals(r0) == true) goto L9;
        goto L8
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle r3) {
        r3.putBoolean(STATE_COOLDOWN, this.mCooldown);
        super.onSaveInstanceState(r3);
    }

    public void com_android_settings_CryptKeeper__onStart$___twin___() {
        super.onStart();
        setupUi();
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [com.android.settings.CryptKeeper$4] */
    private void setupUi() {
        if (this.mEncryptionGoneBad == false) goto L5;
    L23:
        setContentView(R.layout.crypt_keeper_progress);
        showFactoryReset(this.mCorrupt, this.mMdtpActivated);
        return;
    L5:
        if (isDebugView("error") == true) goto L23;
        if ("".equals(SystemProperties.get("vold.encrypt_progress")) == true) goto L10;
    L21:
        setContentView(R.layout.crypt_keeper_progress);
        encryptionProgressInit();
        return;
    L10:
        if (isDebugView("progress") == true) goto L21;
        if (this.mValidationComplete == false) goto L15;
    L20:
        new AnonymousClass4(this).execute(new Void[0]);
        return;
    L15:
        if (isDebugView("password") == true) goto L20;
        if (this.mValidationRequested == true) goto L25;
        Void[] r2 = (Void[]) null;
        new ValidationTask(this, null).execute(null);
        this.mValidationRequested = true;
        return;
    }

    public void com_android_settings_CryptKeeper__onStop$___twin___() {
        super.onStop();
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
    }

    public void com_android_settings_CryptKeeper__onDestroy$___twin___() {
        super.onDestroy();
        if (this.mWakeLock == null) goto L6;
        OLog.d(TAG, "Releasing and destroying wakelock");
        this.mWakeLock.release();
        this.mWakeLock = null;
        this.mViewModel.wakelock = null;
        return;
    }

    private void encryptionProgressInit() {
        OLog.d(TAG, "Encryption progress screen initializing.");
        if (this.mWakeLock != null) goto L5;
        OLog.d(TAG, "Acquiring wakelock.");
        PowerManager.WakeLock r0 = ((PowerManager) getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK)).newWakeLock(26, TAG);
        this.mWakeLock = r0;
        this.mViewModel.wakelock = r0;
        this.mWakeLock.acquire();
    L5:
        ((ProgressBar) findViewById(R.id.progress_bar)).setIndeterminate(true);
        setBackFunctionality(false);
        updateProgress();
    }

    private void showFactoryReset(final boolean r3, final boolean r4) {
        findViewById(R.id.encroid).setVisibility(8);
        Button r0 = (Button) findViewById(R.id.factory_reset);
        r0.setVisibility(0);
        r0.setOnClickListener(new AnonymousClass5(this, r4, r3));
        if (r3 == false) goto L5;
        ((TextView) findViewById(R.id.title)).setText(R.string.crypt_keeper_data_corrupt_title);
        ((TextView) findViewById(R.id.status)).setText(R.string.crypt_keeper_data_corrupt_summary);
        return;
    L5:
        ((TextView) findViewById(R.id.title)).setText(R.string.crypt_keeper_failed_title);
        ((TextView) findViewById(R.id.status)).setText(R.string.crypt_keeper_failed_summary);
    }

    private void updateProgress() {
        String r1 = SystemProperties.get("vold.encrypt_progress");
        if ("error_partially_encrypted".equals(r1) == false) goto L6;
        showFactoryReset(false, false);
        return;
    L6:
        CharSequence r2 = getText(R.string.crypt_keeper_setup_description);
    L12:
        e = move-exception;
        OLog.w(TAG, "Error parsing progress: " + e.toString());
        int r3 = 0;
    L14:
        String r4 = Integer.toString(r3);
        OLog.v(TAG, "Encryption progress: " + r4);
        int r0 = Integer.parseInt(SystemProperties.get("vold.encrypt_time_remaining"));     // Catch: Exception -> L24
        if (r0 < 0) goto L19;
        r4 = DateUtils.formatElapsedTime(((r0 + 9) / 10) * 10);     // Catch: Exception -> L24
        r2 = getText(R.string.crypt_keeper_setup_time_remaining);     // Catch: Exception -> L24
    L19:
        TextView r5 = (TextView) findViewById(R.id.status);
        if (r5 == null) goto L22;
        r5.setText(TextUtils.expandTemplate(r2, new CharSequence[]{r4}));
    L22:
        this.mHandler.removeMessages(1);
        this.mHandler.sendEmptyMessageDelayed(1, 1000);
        return;
    L8:
        if (isDebugView() == false) goto L10;
        r3 = 50;
        goto L14
    L10:
        r3 = Integer.parseInt(r1);     // Catch: Exception -> L12
        goto L14
    }

    private void cooldown() {
        EditText r0 = this.mPasswordEntry;
        if (r0 == null) goto L5;
        r0.setEnabled(false);
    L5:
        KeyguardLockPatternView r1 = this.mLockPatternView;
        if (r1 == null) goto L8;
        r1.setEnabled(false);
    L8:
        TextView r2 = (TextView) findViewById(R.id.status);
        if (r2 == null) goto L12;
        r2.setText(R.string.crypt_keeper_force_power_cycle);
        return;
    }

    private final void setBackFunctionality(boolean r1) {
        if (r1 == false) goto L4;
        this.mStatusBar.disable(sWidgetsToDisable);
        return;
    L4:
        this.mStatusBar.disable(57081856);
    }

    private void fakeUnlockAttempt(View r3) {
        beginAttempt();
        r3.postDelayed(this.mFakeUnlockAttemptRunnable, 1000);
    }

    private void passwordEntryInit(int r4) {
        EditText r5 = (EditText) findViewById(R.id.passwordEntry);
        this.mPasswordEntry = r5;
        if (r5 == null) goto L5;
        r5.requestFocus();
        this.mPasswordEntry.setOnKeyListener(this);
        this.mPasswordEntry.setOnTouchListener(this);
        this.mPasswordEntry.addTextChangedListener(this);
        TextViewSmt.getInstance().setHiddenContextMenuItem(this.mPasswordEntry, 255);
    L5:
        KeyguardLockPatternView r6 = (KeyguardLockPatternView) findViewById(R.id.lockPattern);
        this.mLockPatternView = r6;
        if (r6 == null) goto L9;
        r6.setOnPatternListener(this.mChooseNewLockPatternListener);
    L9:
        if (getTelephonyManager().isVoiceCapable() == true) goto L13;
        View r7 = findViewById(R.id.emergencyCallButton);
        if (r7 == null) goto L13;
        OLog.d(TAG, "Removing the emergency Call button");
        r7.setVisibility(8);
    L13:
        View r8 = findViewById(R.id.switch_ime_button);
        final InputMethodManager r1 = (InputMethodManager) getSystemService("input_method");
        if (r8 == null) goto L19;
        if (hasMultipleEnabledIMEsOrSubtypes(r1, false) == false) goto L19;
        r8.setOnClickListener(new AnonymousClass7(this, r1));
    L19:
        if (this.mWakeLock != null) goto L24;
        OLog.d(TAG, "Acquiring wakelock.");
        PowerManager r9 = (PowerManager) getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK);
        if (r9 == null) goto L24;
        PowerManager.WakeLock r10 = r9.newWakeLock(26, TAG);
        this.mWakeLock = r10;
        this.mViewModel.wakelock = r10;
        this.mWakeLock.acquire();
        this.mReleaseWakeLockCountdown = 96;
    L24:
        if (this.mLockPatternView == null) goto L26;
    L28:
        updateEmergencyCallButtonState();
        this.mHandler.removeMessages(2);
        this.mHandler.sendEmptyMessageDelayed(2, 120000);
        getWindow().addFlags(4718592);
        return;
    L26:
        if (this.mCooldown == true) goto L28;
        getWindow().setSoftInputMode(5);
        this.mHandler.postDelayed(new AnonymousClass8(this, r1), 500);
        goto L28
    }

    private boolean hasMultipleEnabledIMEsOrSubtypes(InputMethodManager r8, boolean r9) {
        Iterator<InputMethodInfo> r7 = r8.getEnabledInputMethodList().iterator();
        int r1 = 0;
    L4:
        if (r7.hasNext() == false) goto L22;
        InputMethodInfo r2 = r7.next();
        if (r1 > 1) goto L7;
        List<InputMethodSubtype> r3 = r8.getEnabledInputMethodSubtypeList(r2, true);
        if (r3.isEmpty() == true) goto L10;
        Iterator<InputMethodSubtype> r4 = r3.iterator();
        int r5 = 0;
    L13:
        if (r4.hasNext() == false) goto L18;
        if (r4.next().isAuxiliary() == false) goto L13;
        r5 = r5 + 1;
        goto L13
    L18:
        if ((r3.size() - r5) > 0) goto L10;
        if (r9 == false) goto L4;
        if (r5 <= 1) goto L4;
    L10:
        r1 = r1 + 1;
        goto L4
    L7:
        return true;
    L22:
        if (r1 > 1) goto L26;
        if (r8.getEnabledInputMethodSubtypeList(null, false).size() > 1) goto L26;
        return false;
    L26:
        return true;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView r1, int r2, KeyEvent r3) {
        if (r2 == 0) goto L9;
        if (r2 == 6) goto L9;
        return false;
    L9:
        return verifyPassword();
    }

    private boolean verifyPassword() {
        String r0 = this.mPasswordEntry.getText().toString();
        if (TextUtils.isEmpty(r0) == false) goto L5;
        return true;
    L5:
        AnonymousClass1 r3 = null;
        this.mPasswordEntry.setText(null);
        this.mPasswordEntry.setEnabled(false);
        setBackFunctionality(false);
        if (r0.length() < 4) goto L8;
        OLog.d(TAG, "Attempting to send command to decrypt");
        new DecryptTask(this, r3).execute(new String[]{r0});
    L9:
        return true;
    L8:
        fakeUnlockAttempt(this.mPasswordEntry);
        goto L9
    }

    private final void setAirplaneModeIfNecessary() {
        if (AdaptUtils.getLteOnCdmaMode(getTelephonyManager()) != 1) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        OLog.d(TAG, "Going into airplane mode.");
        android.provider.Settings.Global.putInt(getContentResolver(), "airplane_mode_on", 1);
        Intent r1 = new Intent("android.intent.action.AIRPLANE_MODE");
        r1.putExtra("state", true);
        sendBroadcastAsUser(r1, UserHandle.ALL);
        return;
    L9:
        return;
    L5:
        r0 = false;
        goto L6
    }

    private void updateEmergencyCallButtonState() {
        OFloatingTitleBar r1 = (OFloatingTitleBar) findViewById(R.id.view_title);
    }

    private boolean isEmergencyCallCapable() {
        return getResources().getBoolean(android.R.bool.config_watchlistUseFileHashesCache);
    }

    private void takeEmergencyCallAction() {
        TelecomManager r0 = getTelecomManager();
        if (r0 != null) goto L5;
    L7:
        launchEmergencyDialer();
        return;
    L5:
        if (r0.isInCall() == false) goto L7;
        r0.showInCallScreen(false);
    }

    private void launchEmergencyDialer() {
        Intent r0 = new Intent(ACTION_EMERGENCY_DIAL);
        r0.setFlags(276824064);
        setBackFunctionality(true);
        Utils.startActivity(this, r0, 1);
    }

    private TelephonyManager getTelephonyManager() {
        return (TelephonyManager) getSystemService(MultiSimAdapter.PHONE_KEY);
    }

    private TelecomManager getTelecomManager() {
        return (TelecomManager) getSystemService("telecom");
    }

    private void delayAudioNotification() {
        this.mNotificationCountdown = 20;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View r1, int r2, KeyEvent r3) {
        delayAudioNotification();
        return false;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View r1, MotionEvent r2) {
        delayAudioNotification();
        return false;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
        delayAudioNotification();
        if (this.mTitle == null) goto L11;
        if (r1 != null) goto L6;
    L8:
        boolean r5 = false;
    L9:
        this.mRightView.setEnabled(r5);
        return;
    L6:
        if (r1.length() < 4) goto L8;
        r5 = true;
        goto L9
    }

    private static void disableCryptKeeperComponent(Context r3) {
        PackageManager r0 = r3.getPackageManager();
        ComponentName r1 = new ComponentName(r3, CryptKeeper.class);
        OLog.d(TAG, "Disabling component " + r1);
        r0.setComponentEnabledSetting(r1, 2, 1);
    }

    private void initRightButton() {
        View r0 = this.mTitle.addEndAction(R.drawable.standard_icon_hignlight_confirm_selector, -1, null);
        this.mRightView = r0;
        r0.setEnabled(false);
        this.mRightView.setOnClickListener(new AnonymousClass10(this));
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_CryptKeeper_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(CryptKeeper r1) {
        com_android_settings_CryptKeeper_com_obric_hook_lancet_PrivacyHookActivity2_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_CryptKeeper_com_obric_hook_lancet_PrivacyHookActivity2_onCreate(CryptKeeper r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        CryptKeeper r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_CryptKeeper__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_CryptKeeper_com_obric_hook_lancet_BatchedActivityLancet_onResume(CryptKeeper r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_CryptKeeper_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_CryptKeeper_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(CryptKeeper r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_CryptKeeper_com_obric_hook_lancet_PrivacyHookActivity2_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        CryptKeeper r5 = r4;
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
    public static void com_android_settings_CryptKeeper_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(CryptKeeper r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_CryptKeeper__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_CryptKeeper_com_obric_hook_lancet_BatchedActivityLancet_onStop(CryptKeeper r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_CryptKeeper_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onStart")
    public static void com_android_settings_CryptKeeper_com_obric_hook_lancet_PrivacyHookActivity2_onStart(CryptKeeper r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        CryptKeeper r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStart();
        return;
    L6:
        r3.com_android_settings_CryptKeeper__onStart$___twin___();
    }

    @Insert("onResume")
    public static void com_android_settings_CryptKeeper_com_obric_hook_lancet_PrivacyHookActivity2_onResume(CryptKeeper r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        CryptKeeper r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_CryptKeeper__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_CryptKeeper_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(CryptKeeper r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_CryptKeeper_com_obric_hook_lancet_PrivacyHookActivity2_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_CryptKeeper_com_obric_hook_lancet_PrivacyHookActivity2_onPause(CryptKeeper r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        CryptKeeper r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_CryptKeeper__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_CryptKeeper_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(CryptKeeper r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_CryptKeeper_com_obric_hook_lancet_PrivacyHookActivity2_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        CryptKeeper r5 = r3;
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
    public static void com_android_settings_CryptKeeper_com_obric_hook_lancet_PrivacyHookActivity2_onStop(CryptKeeper r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        CryptKeeper r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_CryptKeeper__onStop$___twin___();
    }

    @Insert("onDestroy")
    public static void com_android_settings_CryptKeeper_com_obric_hook_lancet_PrivacyHookActivity2_onDestroy(CryptKeeper r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        CryptKeeper r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperDestroy();
        return;
    L6:
        r3.com_android_settings_CryptKeeper__onDestroy$___twin___();
    }
}
