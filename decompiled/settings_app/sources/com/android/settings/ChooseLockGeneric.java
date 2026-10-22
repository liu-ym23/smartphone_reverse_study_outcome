package com.android.settings;

import android.app.admin.DevicePolicyManager;
import android.content.Context;
import android.content.Intent;
import android.hardware.fingerprint.FingerprintManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.UserHandle;
import android.view.accessibility.AccessibilityManager;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.Preference;
import androidx.preference.PreferenceScreen;
import androidx.recyclerview.widget.RecyclerView;
import com.android.internal.widget.LockPatternUtils;
import com.android.internal.widget.LockscreenCredential;
import com.android.settings.base.BaseActivity;
import com.android.settings.biometrics.FaceRecognitionHelper;
import com.android.settings.teaevent.AppMetricsUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.lang.reflect.InvocationTargetException;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class ChooseLockGeneric extends BaseActivity {
    public static final String CONFIRM_CREDENTIALS = "confirm_credentials";

    public static class ChooseLockGenericFragment extends SettingsPreferenceFragment23 {
        private static final int CHOOSE_LOCK_REQUEST = 102;
        private static final int CONFIRM_EXISTING_REQUEST = 100;
        private static final int ENABLE_ENCRYPTION_REQUEST = 101;
        public static final String ENCRYPT_REQUESTED_DISABLED = "encrypt_requested_disabled";
        public static final String ENCRYPT_REQUESTED_QUALITY = "encrypt_requested_quality";
        private static final String FINISH_PENDING = "finish_pending";
        public static final String HIDE_DISABLED_PREFS = "hide_disabled_prefs";
        private static final String KEY_UNLOCK_BACKUP_INFO = "unlock_backup_info";
        private static final String KEY_UNLOCK_SET_BIOMETRIC_WEAK = "unlock_set_biometric_weak";
        private static final String KEY_UNLOCK_SET_NONE = "unlock_set_none";
        private static final String KEY_UNLOCK_SET_OFF = "unlock_set_off";
        private static final String KEY_UNLOCK_SET_PASSWORD = "unlock_set_password";
        private static final String KEY_UNLOCK_SET_PATTERN = "unlock_set_pattern";
        private static final String KEY_UNLOCK_SET_PIN_FOUR = "unlock_set_pin_four";
        private static final String KEY_UNLOCK_SET_PIN_SIX = "unlock_set_pin_six";
        public static final String MINIMUM_QUALITY_KEY = "minimum_quality";
        private static final int MIN_PASSWORD_LENGTH = 4;
        private static final String PASSWORD_CONFIRMED = "password_confirmed";
        private static final String TAG = "ChooseLockGenericFragment";
        private static final String WAITING_FOR_CONFIRMATION = "waiting_for_confirmation";
        private long mChallenge;
        private ChooseLockSettingsHelper mChooseLockSettingsHelper;
        private DevicePolicyManager mDPM;
        private boolean mEncryptionRequestDisabled;
        private int mEncryptionRequestQuality;
        private boolean mFaceRecognitionEnable;
        private FaceRecognitionHelper mFaceRecognitionHelper;
        private FingerprintManager mFingerprintManager;
        private boolean mForFingerprint;
        private boolean mHasChallenge;
        private LockPatternUtils mLockPatternUtils;
        private boolean mPasswordConfirmed;
        private MultiSDKAdapter.RemovalCallback mRemovalCallback;
        private boolean mRequirePassword;
        private LockscreenCredential mUserPassword;
        private boolean mWaitingForConfirmation;

        public void com_android_settings_ChooseLockGeneric$ChooseLockGenericFragment__onResume$___twin___() {
            super.onResume();
        }

        @Override // com.android.settings.SettingsPreferenceFragment23
        protected int getHelpResource() {
            return R.string.help_url_choose_lockscreen;
        }

        @Override // com.android.settings.SettingsPreferenceFragment23, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
        public void onCreate(Bundle r1) {
            com_android_settings_ChooseLockGeneric$ChooseLockGenericFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
        }

        @Override // com.android.settings.SettingsPreferenceFragment23, androidx.fragment.app.Fragment
        public void onResume() {
            com_android_settings_ChooseLockGeneric$ChooseLockGenericFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
        }

        public ChooseLockGenericFragment() {
            this.mFaceRecognitionEnable = false;
            this.mHasChallenge = false;
            this.mPasswordConfirmed = false;
            this.mWaitingForConfirmation = false;
            this.mForFingerprint = false;
            this.mRemovalCallback = new AnonymousClass1(this);
        }

        public void com_android_settings_ChooseLockGeneric$ChooseLockGenericFragment__onCreate$___twin___(Bundle r7) {
            super.onCreate(r7);
            if (SettingsFeature.isFaceRecognitionEnable() == false) goto L5;
            this.mFaceRecognitionEnable = true;
            FaceRecognitionHelper r0 = new FaceRecognitionHelper(getActivity());
            this.mFaceRecognitionHelper = r0;
            r0.bind(null);
        L5:
            this.mFingerprintManager = (FingerprintManager) getActivity().getSystemService("fingerprint");
            this.mDPM = (DevicePolicyManager) getSystemService("device_policy");
            this.mChooseLockSettingsHelper = new ChooseLockSettingsHelper(getActivity());
            this.mLockPatternUtils = new LockPatternUtils(getActivity());
            sanitizePassword();
            boolean r1 = Utils.getBooleanExtraSafely(getActivity().getIntent(), ChooseLockGeneric.CONFIRM_CREDENTIALS, true);
            if ((getActivity() instanceof InternalActivity) == false) goto L8;
            this.mPasswordConfirmed = !r1;
        L8:
            this.mHasChallenge = getActivity().getIntent().getBooleanExtra(ChooseLockSettingsHelper.EXTRA_KEY_HAS_CHALLENGE, false);
            this.mChallenge = getActivity().getIntent().getLongExtra("challenge", 0);
            this.mForFingerprint = getActivity().getIntent().getBooleanExtra("for_fingerprint", false);
            if (r7 == null) goto L12;
            this.mPasswordConfirmed = r7.getBoolean("password_confirmed");
            this.mWaitingForConfirmation = r7.getBoolean(WAITING_FOR_CONFIRMATION);
            this.mEncryptionRequestQuality = r7.getInt(ENCRYPT_REQUESTED_QUALITY);
            this.mEncryptionRequestDisabled = r7.getBoolean(ENCRYPT_REQUESTED_DISABLED);
        L12:
            if (this.mPasswordConfirmed == false) goto L15;
            updatePreferencesOrFinish();
            return;
        L15:
            if (this.mWaitingForConfirmation == false) goto L17;
            return;
        L17:
            if (new ChooseLockSettingsHelper(getActivity(), this).launchConfirmationActivity(100, getString(R.string.unlock_set_unlock_launch_picker_title), 2, true) == true) goto L19;
            this.mPasswordConfirmed = true;
            updatePreferencesOrFinish();
            return;
        L19:
            this.mWaitingForConfirmation = true;
        }

        @Override // com.android.settings.SettingsPreferenceFragment23, androidx.fragment.app.Fragment
        public void onActivityCreated(Bundle r4) {
            super.onActivityCreated(r4);
            RecyclerView r5 = getListView();
            if (this.mForFingerprint == false) goto L6;
            r5.setPadding(r5.getPaddingLeft(), r5.getPaddingTop() + getResources().getDimensionPixelSize(R.dimen.settings_item_top_bottom_margin), r5.getPaddingRight(), r5.getPaddingBottom());
            return;
        }

        @Override // androidx.preference.PreferenceFragmentCompat, androidx.preference.PreferenceManager.OnPreferenceTreeClickListener
        public boolean onPreferenceTreeClick(Preference r5) {
            String r6 = r5.getKey();
            if (KEY_UNLOCK_SET_OFF.equals(r6) == false) goto L11;
            if (this.mFaceRecognitionEnable == true) goto L7;
        L9:
            updateUnlockMethodAndFinish(0, true);
        L34:
            return true;
        L7:
            if (this.mFaceRecognitionHelper.isReady() == true) goto L9;
            return true;
        L11:
            if (KEY_UNLOCK_SET_NONE.equals(r6) == false) goto L19;
            if (this.mFaceRecognitionEnable == true) goto L15;
        L17:
            updateUnlockMethodAndFinish(0, false);
            goto L34
        L15:
            if (this.mFaceRecognitionHelper.isReady() == true) goto L17;
            return true;
        L19:
            if (KEY_UNLOCK_SET_BIOMETRIC_WEAK.equals(r6) == false) goto L22;
            maybeEnableEncryption(32768, false);
            goto L34
        L22:
            if (KEY_UNLOCK_SET_PATTERN.equals(r6) == false) goto L25;
            maybeEnableEncryption(65536, false);
            goto L34
        L25:
            if (KEY_UNLOCK_SET_PIN_FOUR.equals(r6) == false) goto L28;
            maybeEnableEncryption(131072, false);
            goto L34
        L28:
            if (KEY_UNLOCK_SET_PIN_SIX.equals(r6) == false) goto L31;
            maybeEnableEncryption(131072, 6, false);
            goto L34
        L31:
            if (KEY_UNLOCK_SET_PASSWORD.equals(r6) == false) goto L35;
            maybeEnableEncryption(262144, false);
            goto L34
        L35:
            return false;
        }

        private void maybeEnableEncryption(int r2, boolean r3) {
            maybeEnableEncryption(r2, 4, r3);
        }

        private void maybeEnableEncryption(int r2, int r3, boolean r4) {
            DevicePolicyManager r0 = (DevicePolicyManager) getSystemService("device_policy");
            this.mRequirePassword = false;
            updateUnlockMethodAndFinish(r2, r3, r4);
        }

        @Override // androidx.fragment.app.Fragment
        public void onActivityResult(int r5, int r6, Intent r7) {
            super.onActivityResult(r5, r6, r7);
            this.mWaitingForConfirmation = false;
            if (r5 != 100) goto L7;
            if (r6 != (-1)) goto L7;
            this.mPasswordConfirmed = true;
            this.mUserPassword = r7.getParcelableExtra("password");
            updatePreferencesOrFinish();
            return;
        L7:
            if (r5 != 101) goto L11;
            if (r6 != (-1)) goto L11;
            this.mRequirePassword = r7.getBooleanExtra(EncryptionInterstitial.EXTRA_REQUIRE_PASSWORD, true);
            int r8 = r7.getIntExtra(ChooseLockPassword.EXTRA_PIN_LENGTH, 4);
            updateUnlockMethodAndFinish(this.mEncryptionRequestQuality, r8, this.mEncryptionRequestDisabled);
            return;
        L11:
            if (r5 != 102) goto L13;
            getActivity().setResult(r6, r7);
            finish();
            return;
        L13:
            getActivity().setResult(0);
            finish();
        }

        @Override // com.android.settings.SettingsPreferenceFragment23, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
        public void onSaveInstanceState(Bundle r3) {
            super.onSaveInstanceState(r3);
            r3.putBoolean("password_confirmed", this.mPasswordConfirmed);
            r3.putBoolean(WAITING_FOR_CONFIRMATION, this.mWaitingForConfirmation);
            r3.putInt(ENCRYPT_REQUESTED_QUALITY, this.mEncryptionRequestQuality);
            r3.putBoolean(ENCRYPT_REQUESTED_DISABLED, this.mEncryptionRequestDisabled);
        }

        private void updatePreferencesOrFinish() {
            Intent r0 = getActivity().getIntent();
            int r1 = r0.getIntExtra("lockscreen.password_type", -1);
            if (r1 != (-1)) goto L8;
            int r2 = upgradeQuality(r0.getIntExtra("minimum_quality", -1));
            boolean r3 = r0.getBooleanExtra(HIDE_DISABLED_PREFS, false);
            PreferenceScreen r4 = getPreferenceScreen();
            if (r4 == null) goto L7;
            r4.removeAll();
        L7:
            addPreferencesFromResource(R.xml.security_settings_picker);
            disableUnusablePreferences(r2, r3);
            updateCurrentPreference();
            updatePreferenceSummaryIfNeeded();
            return;
        L8:
            updateUnlockMethodAndFinish(r1, false);
        }

        private void updateCurrentPreference() {
            Preference r1 = findPreference(getKeyForCurrent());
            if (r1 == null) goto L6;
            r1.setSummary(R.string.current_screen_lock);
            return;
        }

        private String getKeyForCurrent() {
            if (this.mLockPatternUtils.isLockScreenDisabled(UserHandle.myUserId()) == false) goto L6;
            return KEY_UNLOCK_SET_OFF;
        L6:
            int r0 = this.mLockPatternUtils.getKeyguardStoredPasswordQuality(UserHandle.myUserId());
            if (r0 != 0) goto L9;
            return KEY_UNLOCK_SET_NONE;
        L9:
            if (r0 != 65536) goto L11;
            return KEY_UNLOCK_SET_PATTERN;
        L11:
            if (r0 == 131072) goto L23;
            if (r0 == 196608) goto L23;
            if (r0 != 262144) goto L17;
            return KEY_UNLOCK_SET_PASSWORD;
        L17:
            if (r0 == 327680) goto L32;
            return null;
        L32:
            return KEY_UNLOCK_SET_PASSWORD;
        L23:
            if (((int) LockPatternUtilsOnly.getPasswordLengthBytedance(this.mLockPatternUtils, UserHandle.myUserId())) != 6) goto L25;
            return KEY_UNLOCK_SET_PIN_SIX;
        L25:
            return KEY_UNLOCK_SET_PIN_FOUR;
        }

        private int upgradeQuality(int r1) {
            return upgradeQualityForDPM(r1);
        }

        private int upgradeQualityForDPM(int r2) {
            int r1 = this.mDPM.getPasswordQuality(null);
            if (r2 < r1) goto L5;
            return r2;
        L5:
            return r1;
        }

        protected void disableUnusablePreferences(int r1, boolean r2) {
            disableUnusablePreferencesImpl(r1, r2);
        }

        protected void disableUnusablePreferencesImpl(int r8, boolean r9) {
            PreferenceScreen r7 = getPreferenceScreen();
            int r0 = r7.getPreferenceCount() - 1;
        L3:
            if (r0 < 0) goto L39;
            Preference r2 = r7.getPreference(r0);
            String r3 = r2.getKey();
            if (KEY_UNLOCK_SET_OFF.equals(r3) == false) goto L10;
            if (r8 <= 0) goto L30;
        L8:
            boolean r4 = false;
        L31:
            if (r9 == false) goto L33;
            boolean r5 = r4;
        L34:
            if (r5 == true) goto L36;
            r7.removePreference(r2);
        L38:
            r0 = r0 - 1;
            goto L3
        L36:
            if (r4 == true) goto L38;
            r2.setSummary(R.string.unlock_set_unlock_disabled_summary);
            r2.setEnabled(false);
            goto L38
        L33:
            r5 = true;
        L30:
            r4 = true;
            goto L31
        L10:
            if (KEY_UNLOCK_SET_NONE.equals(r3) == false) goto L14;
            if (r8 > 0) goto L8;
        L14:
            if (KEY_UNLOCK_SET_PATTERN.equals(r3) == false) goto L19;
            if (r8 > 65536) goto L8;
        L19:
            if (KEY_UNLOCK_SET_PIN_FOUR.equals(r3) == false) goto L23;
            if (r8 > 196608) goto L8;
        L23:
            if (KEY_UNLOCK_SET_PIN_SIX.equals(r3) == false) goto L27;
            if (r8 > 196608) goto L8;
        L27:
            if (KEY_UNLOCK_SET_PASSWORD.equals(r3) == false) goto L30;
            if (r8 > 393216) goto L8;
        }

        private void updatePreferenceSummaryIfNeeded() {
            if (AccessibilityManager.getInstance(getActivity()).getEnabledAccessibilityServiceList(-1).isEmpty() == false) goto L5;
            return;
        L5:
            String r0 = getString(R.string.secure_lock_encryption_warning);
            PreferenceScreen r8 = getPreferenceScreen();
            int r2 = r8.getPreferenceCount();
            int r4 = 0;
        L6:
            if (r4 >= r2) goto L30;
            Preference r5 = r8.getPreference(r4);
            String r6 = r5.getKey();
            r6.hashCode();
            switch(r6.hashCode()) {
                case -982940184: goto L23;
                case 669087475: goto L19;
                case 1407992888: goto L15;
                case 1630872544: goto L11;
                default: goto L9;
            };
        L9:
            byte r7 = -1;
        L26:
            switch(r7) {
                case 0: goto L28;
                case 1: goto L28;
                case 2: goto L28;
                case 3: goto L28;
                default: goto L29;
            };
        L28:
            r5.setSummary(r0);
        L29:
            r4 = r4 + 1;
            goto L6
        L11:
            if (r6.equals(KEY_UNLOCK_SET_PIN_SIX) == false) goto L34;
            r7 = 3;
            goto L26
        L34:
            r7 = -1;
            goto L26
        L15:
            if (r6.equals(KEY_UNLOCK_SET_PATTERN) == false) goto L35;
            r7 = 2;
            goto L26
        L35:
            r7 = -1;
            goto L26
        L19:
            if (r6.equals(KEY_UNLOCK_SET_PASSWORD) == false) goto L36;
            r7 = 1;
            goto L26
        L36:
            r7 = -1;
            goto L26
        L23:
            if (r6.equals(KEY_UNLOCK_SET_PIN_FOUR) == false) goto L37;
            r7 = 0;
            goto L26
        L37:
            r7 = -1;
            goto L26
        }

        protected Intent getLockPasswordIntent(Context r1, int r2, int r3, int r4, boolean r5, boolean r6) {
            return ChooseLockPassword.createIntent(r1, r2, r3, r4, r5, r6);
        }

        protected Intent getLockPasswordIntent(Context r1, int r2, int r3, int r4, boolean r5, long r6) {
            return ChooseLockPassword.createIntent(r1, r2, r3, r4, r5, r6);
        }

        protected Intent getLockPasswordIntent(Context r1, int r2, int r3, int r4, boolean r5, LockscreenCredential r6) {
            return ChooseLockPassword.createIntent(r1, r2, r3, r4, r5, r6);
        }

        protected Intent getLockPatternIntent(Context r1, boolean r2, long r3) {
            return ChooseLockPattern.createIntent(r1, r2, r3, UserHandle.myUserId());
        }

        protected Intent getLockPatternIntent(Context r1, boolean r2, LockscreenCredential r3) {
            return ChooseLockPattern.createIntent(r1, r2, r3, UserHandle.myUserId());
        }

        protected Intent getEncryptionInterstitialIntent(Context r1, int r2, boolean r3) {
            return EncryptionInterstitial.createStartIntent(r1, r2, r3, null);
        }

        void updateUnlockMethodAndFinish(int r2, boolean r3) {
            updateUnlockMethodAndFinish(r2, 4, r3);
        }

        void updateUnlockMethodAndFinish(int r9, int r10, boolean r11) {
            if (this.mPasswordConfirmed == false) goto L27;
            int r2 = upgradeQuality(r9);
            FragmentActivity r1 = getActivity();
            if (r2 < 131072) goto L16;
            int r12 = this.mDPM.getPasswordMinimumLength(null);
            if (r12 >= 4) goto L9;
            int r3 = 4;
        L10:
            int r4 = this.mDPM.getPasswordMaximumLength(r2);
            if (this.mHasChallenge == false) goto L13;
            Intent r13 = getLockPasswordIntent(r1, r2, r3, r4, this.mRequirePassword, this.mChallenge);
        L14:
            r13.putExtra(ChooseLockPassword.EXTRA_PIN_LENGTH, r10);
            startActivityForResult(r13, 102);
            return;
        L13:
            r13 = getLockPasswordIntent(r1, r2, r3, r4, this.mRequirePassword, this.mUserPassword);
            goto L14
        L9:
            r3 = r12;
            goto L10
        L16:
            if (r2 == 65536) goto L18;
            if (r2 != 0) goto L24;
            InvisibleApi.clearLock2(this.mChooseLockSettingsHelper.utils(), this.mUserPassword);
            this.mChooseLockSettingsHelper.utils().setLockScreenDisabled(false, UserHandle.myUserId());
            removeAllFingerprintTemplates();
            removeFaceRecognitionIfExist();
            getActivity().setResult(-1);
            finish();
            return;
        L24:
            removeAllFingerprintTemplates();
            removeFaceRecognitionIfExist();
            finish();
            return;
        L18:
            if (this.mHasChallenge == false) goto L20;
            Intent r14 = getLockPatternIntent(r1, this.mRequirePassword, this.mChallenge);
        L21:
            startActivityForResult(r14, 102);
            return;
        L20:
            r14 = getLockPatternIntent(r1, this.mRequirePassword, this.mUserPassword);
            goto L21
        L27:
            throw new IllegalStateException("Tried to update password without confirming it");
        }

        private void removeFaceRecognitionIfExist() {
            if (this.mFaceRecognitionEnable == true) goto L5;
            return;
        L5:
            LockScreenModeActivity.removeFaceRecognitionIfExist(getActivity(), this.mFaceRecognitionHelper);
        }

        private void removeAllFingerprintTemplates() {
            LockScreenModeActivity.removeAllFingerprintTemplates(getActivity(), this.mRemovalCallback);
        }

        @Override // androidx.fragment.app.Fragment
        public void onDestroy() {
            super.onDestroy();
            sanitizePassword();
            if (this.mFaceRecognitionEnable == false) goto L6;
            this.mFaceRecognitionHelper.unbind();
            return;
        }

        private void sanitizePassword() {
            LockPatternUtils.class.getMethod("sanitizePassword", new Class[0]).invoke(this.mLockPatternUtils, new Object[0]);     // Catch: IllegalAccessException -> L4 InvocationTargetException -> L6 NoSuchMethodException -> L8
        L15:
            return;
        L4:
            e = move-exception;
            e.printStackTrace();
            return;
        L8:
            e = move-exception;
            e.printStackTrace();
            return;
        L6:
            e = move-exception;
            e.printStackTrace();
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onCreate")
        public static void com_android_settings_ChooseLockGeneric$ChooseLockGenericFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(ChooseLockGenericFragment r2, Bundle r3) {
            String r0 = r2.getClass().getName();
            r2.com_android_settings_ChooseLockGeneric$ChooseLockGenericFragment__onCreate$___twin___(r3);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
            AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r4.callingPackageEvent("self", r0, true);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_ChooseLockGeneric$ChooseLockGenericFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(ChooseLockGenericFragment r2) {
            String r0 = r2.getClass().getName();
            com_android_settings_ChooseLockGeneric$ChooseLockGenericFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.recordVisibleTime(r0);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_ChooseLockGeneric$ChooseLockGenericFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(ChooseLockGenericFragment r2) {
            String r0 = r2.getClass().getName();
            r2.com_android_settings_ChooseLockGeneric$ChooseLockGenericFragment__onResume$___twin___();
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.reportVisibleTime(r0, true);
            return;
        }
    }

    public static class InternalActivity extends ChooseLockGeneric {
        public void com_android_settings_ChooseLockGeneric$InternalActivity__onCreate$___twin___(Bundle r1) {
            super.onCreate(r1);
        }

        public void com_android_settings_ChooseLockGeneric$InternalActivity__onPause$___twin___() {
            super.onPause();
        }

        public void com_android_settings_ChooseLockGeneric$InternalActivity__onResume$___twin___() {
            super.onResume();
        }

        public void com_android_settings_ChooseLockGeneric$InternalActivity__onStop$___twin___() {
            super.onStop();
        }

        public void com_android_settings_ChooseLockGeneric$InternalActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
            super.startActivityForResult(r1, r2, r3);
        }

        @Override // com.android.settings.ChooseLockGeneric, com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onCreate(Bundle r1) {
            com_android_settings_ChooseLockGeneric$InternalActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
        }

        @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
        public void onPause() {
            com_android_settings_ChooseLockGeneric$InternalActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
        }

        @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
        public void onResume() {
            com_android_settings_ChooseLockGeneric$InternalActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
        }

        @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
        public void onStop() {
            com_android_settings_ChooseLockGeneric$InternalActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
        }

        @Override // androidx.activity.ComponentActivity, android.app.Activity
        public void startActivityForResult(Intent r1, int r2, Bundle r3) {
            com_android_settings_ChooseLockGeneric$InternalActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
        }

        public InternalActivity() {
        }

        @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
        @Insert(mayCreateSuper = true, value = "onStop")
        public static void com_android_settings_ChooseLockGeneric$InternalActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(InternalActivity r1) {
            com_android_settings_ChooseLockGeneric$InternalActivity_com_obric_hook_lancet_PrivacyHook_onStop(r1);
            if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
            return;
        L8:
            r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
            return;
        }

        @Insert("onCreate")
        public static void com_android_settings_ChooseLockGeneric$InternalActivity_com_obric_hook_lancet_PrivacyHook_onCreate(InternalActivity r3, Bundle r4) {
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
            InternalActivity r0 = r3;
            if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
            r0.onCreateWhenPrivacyNotOk(null);
            r0.onSuperCreate(null);
            return;
        L6:
            GrantUtil.INSTANCE.applicationInit();
            r3.com_android_settings_ChooseLockGeneric$InternalActivity__onCreate$___twin___(r4);
        }

        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_ChooseLockGeneric$InternalActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(InternalActivity r1) {
            String r0 = r1.getClass().getName();
            com_android_settings_ChooseLockGeneric$InternalActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            AppMetricsUtils.INSTANCE.activityEventEnd(r0);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_ChooseLockGeneric$InternalActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(InternalActivity r4) {
            String r0 = r4.getClass().getName();
            com_android_settings_ChooseLockGeneric$InternalActivity_com_obric_hook_lancet_PrivacyHook_onResume(r4);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
            OLog.i("AppLifecycle", "onResume_Activity " + r0);
            AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r1.recordVisibleTime(r0);
            Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
            InternalActivity r5 = r4;
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
        public static void com_android_settings_ChooseLockGeneric$InternalActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(InternalActivity r2, Intent r3, int r4, Bundle r5) {
            Intrinsics.checkNotNullParameter(r3, "intent");
            String r0 = r2.getClass().getName();
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
            AppMetricsUtils.INSTANCE.activityEventStart(r0);
        L5:
            r2.com_android_settings_ChooseLockGeneric$InternalActivity__startActivityForResult$___twin___(r3, r4, r5);
        }

        @Insert(mayCreateSuper = true, value = "onStop")
        public static void com_android_settings_ChooseLockGeneric$InternalActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(InternalActivity r2) {
            String r0 = r2.getClass().getName();
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
            AppMetricsUtils.INSTANCE.activityEventStoped(r0);
        L5:
            com_android_settings_ChooseLockGeneric$InternalActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
        }

        @Insert("onResume")
        public static void com_android_settings_ChooseLockGeneric$InternalActivity_com_obric_hook_lancet_PrivacyHook_onResume(InternalActivity r3) {
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
            InternalActivity r0 = r3;
            if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
            r0.onSuperResume();
            return;
        L6:
            r3.com_android_settings_ChooseLockGeneric$InternalActivity__onResume$___twin___();
        }

        @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
        @Insert(mayCreateSuper = true, value = "onPause")
        public static void com_android_settings_ChooseLockGeneric$InternalActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(InternalActivity r4) {
            String r0 = r4.getClass().getName();
            com_android_settings_ChooseLockGeneric$InternalActivity_com_obric_hook_lancet_PrivacyHook_onPause(r4);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onPause_Activity " + r0);
            AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
            return;
        }

        @Insert("onPause")
        public static void com_android_settings_ChooseLockGeneric$InternalActivity_com_obric_hook_lancet_PrivacyHook_onPause(InternalActivity r3) {
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
            InternalActivity r0 = r3;
            if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
            r0.onSuperPause();
            return;
        L6:
            r3.com_android_settings_ChooseLockGeneric$InternalActivity__onPause$___twin___();
        }

        @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
        @Insert(mayCreateSuper = true, value = "onCreate")
        public static void com_android_settings_ChooseLockGeneric$InternalActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(InternalActivity r3, Bundle r4) {
            String r0 = r3.getClass().getName();
            com_android_settings_ChooseLockGeneric$InternalActivity_com_obric_hook_lancet_PrivacyHook_onCreate(r3, r4);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
            OLog.i("AppLifecycle", "onCreate_Activity " + r0);
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
            InternalActivity r5 = r3;
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
        public static void com_android_settings_ChooseLockGeneric$InternalActivity_com_obric_hook_lancet_PrivacyHook_onStop(InternalActivity r3) {
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
            InternalActivity r0 = r3;
            if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
            r0.onSuperStop();
            return;
        L6:
            r3.com_android_settings_ChooseLockGeneric$InternalActivity__onStop$___twin___();
        }
    }

    protected boolean canRunBeforeDeviceProvisioned() {
        return false;
    }

    @Override // com.android.settings.base.BaseActivity, android.app.Activity
    public void finish() {
        com_android_settings_ChooseLockGeneric_com_obric_hook_lancet_PrivacyHook_finish(this);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_settings_ChooseLockGeneric_com_obric_hook_lancet_PrivacyHook_onCreate(this, r1);
    }

    public ChooseLockGeneric() {
    }

    public void com_android_settings_ChooseLockGeneric__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
        if (Utils.isDeviceProvisioned(this) == false) goto L5;
    L8:
        setContentView(R.layout.choose_lock_generic_activity);
        setupBackBtnOnTitle();
        return;
    L5:
        if (canRunBeforeDeviceProvisioned() == true) goto L8;
        finish();
    }

    public void com_android_settings_ChooseLockGeneric__finish$___twin___() {
        super.finish();
        if (getIntent() == null) goto L8;
        int[] r0 = getIntent().getIntArrayExtra("bytedanceos.intent.extra.ANIM_RESOURCE_ID");
        if (r0 == null) goto L9;
        overridePendingTransition(r0[0], r0[1]);
        return;
    L9:
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_ChooseLockGeneric_com_obric_hook_lancet_PrivacyHook_onCreate(ChooseLockGeneric r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        ChooseLockGeneric r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_ChooseLockGeneric__onCreate$___twin___(r4);
    }

    @Insert("finish")
    public static void com_android_settings_ChooseLockGeneric_com_obric_hook_lancet_PrivacyHook_finish(ChooseLockGeneric r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        ChooseLockGeneric r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.superFinish();
        return;
    L6:
        r3.com_android_settings_ChooseLockGeneric__finish$___twin___();
    }
}
