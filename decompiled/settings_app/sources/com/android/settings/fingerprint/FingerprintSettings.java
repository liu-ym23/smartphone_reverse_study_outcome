package com.android.settings.fingerprint;

import android.R;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.hardware.fingerprint.Fingerprint;
import android.hardware.fingerprint.FingerprintManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.UserHandle;
import android.os.UserManager;
import android.text.Annotation;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.Preference;
import androidx.preference.PreferenceGroup;
import androidx.preference.PreferenceScreen;
import androidx.preference.PreferenceViewHolder;
import com.android.settings.ChooseLockGeneric;
import com.android.settings.ChooseLockSettingsHelper;
import com.android.settings.InvisibleApi;
import com.android.settings.MultiSDKAdapter;
import com.android.settings.MultiSDKAdapterNew;
import com.android.settings.SettingsPreferenceFragment;
import com.android.settings.SubSettings;
import com.android.settings.ToastUtils;
import com.android.settings.Utils;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settingslib.HelpUtils;
import com.android.settingslib.RestrictedLockUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class FingerprintSettings extends SubSettings {
    public static final String KEY_FINGERPRINT_SETTINGS = "fingerprint_settings";
    private static final long LOCKOUT_DURATION = 30000;
    static final int RESULT_FINISHED = 1;
    private static final String TAG = "FingerprintSettings";

    public static class FingerprintPreference extends Preference {
        private Fingerprint mFingerprint;
        private View mView;

        public FingerprintPreference(Context r1, AttributeSet r2, int r3, int r4) {
            super(r1, r2, r3, r4);
        }

        public FingerprintPreference(Context r2, AttributeSet r3, int r4) {
            this(r2, r3, r4, 0);
        }

        public FingerprintPreference(Context r2, AttributeSet r3) {
            this(r2, r3, R.attr.preferenceStyle);
        }

        public FingerprintPreference(Context r2) {
            this(r2, null);
        }

        public View getView() {
            return this.mView;
        }

        public void setFingerprint(Fingerprint r1) {
            this.mFingerprint = r1;
        }

        public Fingerprint getFingerprint() {
            return this.mFingerprint;
        }

        @Override // androidx.preference.Preference
        public void onBindViewHolder(PreferenceViewHolder r1) {
            super.onBindViewHolder(r1);
            this.mView = r1.itemView;
        }
    }

    public static class FingerprintSettingsFragment extends SettingsPreferenceFragment implements Preference.OnPreferenceChangeListener {
        private static final int ADD_FINGERPRINT_REQUEST = 10;
        private static final int CHOOSE_LOCK_GENERIC_REQUEST = 102;
        private static final int CONFIRM_REQUEST = 101;
        protected static final boolean DEBUG = true;
        private static final String KEY_FINGERPRINT_ADD = "key_fingerprint_add";
        private static final String KEY_FINGERPRINT_ENABLE_KEYGUARD_TOGGLE = "fingerprint_enable_keyguard_toggle";
        private static final String KEY_FINGERPRINT_ITEM_PREFIX = "key_fingerprint_item";
        private static final String KEY_LAUNCHED_CONFIRM = "launched_confirm";
        private static final int MAX_RETRY_ATTEMPTS = 20;
        private static final int MSG_FINGER_AUTH_ERROR = 1003;
        private static final int MSG_FINGER_AUTH_FAIL = 1002;
        private static final int MSG_FINGER_AUTH_HELP = 1004;
        private static final int MSG_FINGER_AUTH_SUCCESS = 1001;
        private static final int MSG_REFRESH_FINGERPRINT_TEMPLATES = 1000;
        private static final int RESET_HIGHLIGHT_DELAY_MS = 500;
        private static final String TAG = "FingerprintSettings";
        private FingerprintManager.AuthenticationCallback mAuthCallback;
        private CancellationSignal mFingerprintCancel;
        private final Runnable mFingerprintLockoutReset;
        private FingerprintManager mFingerprintManager;
        private final Handler mHandler;
        private Drawable mHighlightDrawable;
        private boolean mInFingerprintLockout;
        private boolean mLaunchedConfirm;
        private MultiSDKAdapter.RemovalCallback mRemoveCallback;
        private byte[] mToken;
        private int mUserId;

        public static class ConfirmLastDeleteDialog extends DialogFragment {
            private Fingerprint mFp;

            public void com_android_settings_fingerprint_FingerprintSettings$FingerprintSettingsFragment$ConfirmLastDeleteDialog__onCreate$___twin___(Bundle r1) {
                super.onCreate(r1);
            }

            public void com_android_settings_fingerprint_FingerprintSettings$FingerprintSettingsFragment$ConfirmLastDeleteDialog__onResume$___twin___() {
                super.onResume();
            }

            @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
            public void onCreate(Bundle r1) {
                com_android_settings_fingerprint_FingerprintSettings$FingerprintSettingsFragment$ConfirmLastDeleteDialog_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
            }

            @Override // androidx.fragment.app.Fragment
            public void onResume() {
                com_android_settings_fingerprint_FingerprintSettings$FingerprintSettingsFragment$ConfirmLastDeleteDialog_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
            }

            public ConfirmLastDeleteDialog() {
            }

            static /* synthetic */ Fingerprint access$1700(ConfirmLastDeleteDialog r0) {
                return r0.mFp;
            }

            @Override // androidx.fragment.app.DialogFragment
            public Dialog onCreateDialog(Bundle r3) {
                this.mFp = getArguments().getParcelable("fingerprint");
                boolean r4 = getArguments().getBoolean("isProfileChallengeUser");
                AlertDialog.Builder r0 = new AlertDialog.Builder(getActivity()).setTitle(com.android.settings.R.string.fingerprint_last_delete_title);
                if (r4 == false) goto L5;
                int r5 = com.android.settings.R.string.fingerprint_last_delete_message_profile_challenge;
            L7:
                return r0.setMessage(r5).setPositiveButton(com.android.settings.R.string.fingerprint_last_delete_confirm, new AnonymousClass2(this)).setNegativeButton(com.android.settings.R.string.cancel, new AnonymousClass1(this)).create();
            L5:
                r5 = com.android.settings.R.string.fingerprint_last_delete_message;
                goto L7
            }

            @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
            @Insert(mayCreateSuper = true, value = "onCreate")
            public static void com_android_settings_fingerprint_FingerprintSettings$FingerprintSettingsFragment$ConfirmLastDeleteDialog_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(ConfirmLastDeleteDialog r2, Bundle r3) {
                String r0 = r2.getClass().getName();
                r2.com_android_settings_fingerprint_FingerprintSettings$FingerprintSettingsFragment$ConfirmLastDeleteDialog__onCreate$___twin___(r3);
                if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
                OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
                AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
                Intrinsics.checkNotNull(r0);
                r4.callingPackageEvent("self", r0, true);
                return;
            }

            @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
            @Insert(mayCreateSuper = true, value = "onResume")
            public static void com_android_settings_fingerprint_FingerprintSettings$FingerprintSettingsFragment$ConfirmLastDeleteDialog_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(ConfirmLastDeleteDialog r2) {
                String r0 = r2.getClass().getName();
                com_android_settings_fingerprint_FingerprintSettings$FingerprintSettingsFragment$ConfirmLastDeleteDialog_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
                if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
                OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
                AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
                Intrinsics.checkNotNull(r0);
                r3.recordVisibleTime(r0);
                return;
            }

            @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
            @Insert(mayCreateSuper = true, value = "onResume")
            public static void com_android_settings_fingerprint_FingerprintSettings$FingerprintSettingsFragment$ConfirmLastDeleteDialog_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(ConfirmLastDeleteDialog r2) {
                String r0 = r2.getClass().getName();
                r2.com_android_settings_fingerprint_FingerprintSettings$FingerprintSettingsFragment$ConfirmLastDeleteDialog__onResume$___twin___();
                if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
                OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
                AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
                Intrinsics.checkNotNull(r0);
                r3.reportVisibleTime(r0, true);
                return;
            }
        }

        public static class RenameDeleteDialog extends DialogFragment {
            private EditText mDialogTextField;
            private String mFingerName;
            private Fingerprint mFp;
            private Boolean mTextHadFocus;
            private int mTextSelectionEnd;
            private int mTextSelectionStart;

            public void com_android_settings_fingerprint_FingerprintSettings$FingerprintSettingsFragment$RenameDeleteDialog__onCreate$___twin___(Bundle r1) {
                super.onCreate(r1);
            }

            public void com_android_settings_fingerprint_FingerprintSettings$FingerprintSettingsFragment$RenameDeleteDialog__onResume$___twin___() {
                super.onResume();
            }

            @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
            public void onCreate(Bundle r1) {
                com_android_settings_fingerprint_FingerprintSettings$FingerprintSettingsFragment$RenameDeleteDialog_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
            }

            @Override // androidx.fragment.app.Fragment
            public void onResume() {
                com_android_settings_fingerprint_FingerprintSettings$FingerprintSettingsFragment$RenameDeleteDialog_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
            }

            public RenameDeleteDialog() {
            }

            static /* synthetic */ String access$1000(RenameDeleteDialog r0) {
                return r0.mFingerName;
            }

            static /* synthetic */ Boolean access$1100(RenameDeleteDialog r0) {
                return r0.mTextHadFocus;
            }

            static /* synthetic */ int access$1200(RenameDeleteDialog r0) {
                return r0.mTextSelectionStart;
            }

            static /* synthetic */ int access$1300(RenameDeleteDialog r0) {
                return r0.mTextSelectionEnd;
            }

            static /* synthetic */ void access$600(RenameDeleteDialog r0, DialogInterface r1) {
                r0.onDeleteClick(r1);
            }

            static /* synthetic */ EditText access$700(RenameDeleteDialog r0) {
                return r0.mDialogTextField;
            }

            static /* synthetic */ EditText access$702(RenameDeleteDialog r0, EditText r1) {
                r0.mDialogTextField = r1;
                return r1;
            }

            static /* synthetic */ Fingerprint access$800(RenameDeleteDialog r0) {
                return r0.mFp;
            }

            @Override // androidx.fragment.app.DialogFragment
            public Dialog onCreateDialog(Bundle r3) {
                this.mFp = getArguments().getParcelable("fingerprint");
                if (r3 == null) goto L5;
                this.mFingerName = r3.getString("fingerName");
                this.mTextHadFocus = Boolean.valueOf(r3.getBoolean("textHadFocus"));
                this.mTextSelectionStart = r3.getInt("startSelection");
                this.mTextSelectionEnd = r3.getInt("endSelection");
            L5:
                final AlertDialog r4 = new AlertDialog.Builder(getActivity()).setView(com.android.settings.R.layout.fingerprint_rename_dialog).setPositiveButton(com.android.settings.R.string.security_settings_fingerprint_enroll_dialog_ok, new AnonymousClass2(this)).setNegativeButton(com.android.settings.R.string.security_settings_fingerprint_enroll_dialog_delete, new AnonymousClass1(this)).create();
                r4.setOnShowListener(new AnonymousClass3(this, r4));
                Boolean r2 = this.mTextHadFocus;
                if (r2 != null) goto L8;
            L9:
                r4.getWindow().setSoftInputMode(5);
            L10:
                return r4;
            L8:
                if (r2.booleanValue() == false) goto L10;
                goto L9
            }

            private void onDeleteClick(DialogInterface r7) {
                OLog.v(FingerprintSettingsFragment.TAG, "Removing fpId=" + InvisibleApi.getFingerId(this.mFp));
                FingerprintSettingsFragment r0 = (FingerprintSettingsFragment) getTargetFragment();
                Context r1 = getContext();
                if (r1 == null) goto L5;
                boolean r2 = Utils.isManagedProfile(UserManager.get(r1), FingerprintSettingsFragment.access$1400(r0));
            L7:
                if (FingerprintSettingsFragment.access$1500(r0).getEnrolledFingerprints(FingerprintSettingsFragment.access$1400(r0)).size() <= 1) goto L9;
                FingerprintSettingsFragment.access$1600(r0, this.mFp);
            L10:
                r7.dismiss();
                return;
            L9:
                ConfirmLastDeleteDialog r3 = new ConfirmLastDeleteDialog();
                Bundle r4 = new Bundle();
                r4.putParcelable("fingerprint", this.mFp);
                r4.putBoolean("isProfileChallengeUser", r2);
                r3.setArguments(r4);
                r3.setTargetFragment(getTargetFragment(), 0);
                r3.show(getParentFragmentManager(), ConfirmLastDeleteDialog.class.getName());
                goto L10
            L5:
                r2 = false;
                goto L7
            }

            @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
            public void onSaveInstanceState(Bundle r3) {
                super.onSaveInstanceState(r3);
                EditText r0 = this.mDialogTextField;
                if (r0 == null) goto L6;
                r3.putString("fingerName", r0.getText().toString());
                r3.putBoolean("textHadFocus", this.mDialogTextField.hasFocus());
                r3.putInt("startSelection", this.mDialogTextField.getSelectionStart());
                r3.putInt("endSelection", this.mDialogTextField.getSelectionEnd());
                return;
            }

            @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
            @Insert(mayCreateSuper = true, value = "onCreate")
            public static void com_android_settings_fingerprint_FingerprintSettings$FingerprintSettingsFragment$RenameDeleteDialog_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(RenameDeleteDialog r2, Bundle r3) {
                String r0 = r2.getClass().getName();
                r2.com_android_settings_fingerprint_FingerprintSettings$FingerprintSettingsFragment$RenameDeleteDialog__onCreate$___twin___(r3);
                if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
                OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
                AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
                Intrinsics.checkNotNull(r0);
                r4.callingPackageEvent("self", r0, true);
                return;
            }

            @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
            @Insert(mayCreateSuper = true, value = "onResume")
            public static void com_android_settings_fingerprint_FingerprintSettings$FingerprintSettingsFragment$RenameDeleteDialog_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(RenameDeleteDialog r2) {
                String r0 = r2.getClass().getName();
                com_android_settings_fingerprint_FingerprintSettings$FingerprintSettingsFragment$RenameDeleteDialog_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
                if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
                OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
                AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
                Intrinsics.checkNotNull(r0);
                r3.recordVisibleTime(r0);
                return;
            }

            @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
            @Insert(mayCreateSuper = true, value = "onResume")
            public static void com_android_settings_fingerprint_FingerprintSettings$FingerprintSettingsFragment$RenameDeleteDialog_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(RenameDeleteDialog r2) {
                String r0 = r2.getClass().getName();
                r2.com_android_settings_fingerprint_FingerprintSettings$FingerprintSettingsFragment$RenameDeleteDialog__onResume$___twin___();
                if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
                OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
                AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
                Intrinsics.checkNotNull(r0);
                r3.reportVisibleTime(r0, true);
                return;
            }
        }

        @Override // com.android.settings.SettingsPreferenceFragment
        protected int getHelpResource() {
            return com.android.settings.R.string.help_url_fingerprint;
        }

        @Override // com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
        public void onCreate(Bundle r1) {
            com_android_settings_fingerprint_FingerprintSettings$FingerprintSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
        }

        @Override // com.android.settings.SettingsPreferenceFragment, com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
        public void onResume() {
            com_android_settings_fingerprint_FingerprintSettings$FingerprintSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
        }

        public FingerprintSettingsFragment() {
            this.mAuthCallback = new AnonymousClass1(this);
            this.mRemoveCallback = new AnonymousClass2(this);
            this.mHandler = new AnonymousClass3(this);
            this.mFingerprintLockoutReset = new AnonymousClass5(this);
        }

        static /* synthetic */ Handler access$000(FingerprintSettingsFragment r0) {
            return r0.mHandler;
        }

        static /* synthetic */ void access$100(FingerprintSettingsFragment r0) {
            r0.updateAddPreference();
        }

        static /* synthetic */ int access$1400(FingerprintSettingsFragment r0) {
            return r0.mUserId;
        }

        static /* synthetic */ FingerprintManager access$1500(FingerprintSettingsFragment r0) {
            return r0.mFingerprintManager;
        }

        static /* synthetic */ void access$1600(FingerprintSettingsFragment r0, Fingerprint r1) {
            r0.deleteFingerPrint(r1);
        }

        static /* synthetic */ CancellationSignal access$202(FingerprintSettingsFragment r0, CancellationSignal r1) {
            r0.mFingerprintCancel = r1;
            return r1;
        }

        static /* synthetic */ void access$300(FingerprintSettingsFragment r0, int r1) {
            r0.highlightFingerprintItem(r1);
        }

        static /* synthetic */ void access$400(FingerprintSettingsFragment r0) {
            r0.retryFingerprint();
        }

        static /* synthetic */ boolean access$502(FingerprintSettingsFragment r0, boolean r1) {
            r0.mInFingerprintLockout = r1;
            return r1;
        }

        static /* synthetic */ void access$900(FingerprintSettingsFragment r0, int r1, String r2) {
            r0.renameFingerPrint(r1, r2);
        }

        private void stopFingerprint() {
            CancellationSignal r0 = this.mFingerprintCancel;
            if (r0 != null) goto L5;
        L7:
            this.mFingerprintCancel = null;
            return;
        L5:
            if (r0.isCanceled() == true) goto L7;
            this.mFingerprintCancel.cancel();
            goto L7
        }

        protected void handleError(int r4, CharSequence r5) {
            this.mFingerprintCancel = null;
            if (r4 != 5) goto L5;
            return;
        L5:
            if (r4 != 7) goto L10;
            this.mInFingerprintLockout = true;
            if (this.mHandler.hasCallbacks(this.mFingerprintLockoutReset) == true) goto L10;
            this.mHandler.postDelayed(this.mFingerprintLockoutReset, 30000);
        L10:
            FragmentActivity r6 = getActivity();
            if (r6 == null) goto L13;
            ToastUtils.show(r6, r5);
        L13:
            retryFingerprint();
        }

        private void retryFingerprint() {
            if (this.mInFingerprintLockout == true) goto L6;
            this.mFingerprintCancel = new CancellationSignal();
            return;
        }

        public void com_android_settings_fingerprint_FingerprintSettings$FingerprintSettingsFragment__onCreate$___twin___(Bundle r3) {
            super.onCreate(r3);
            if (r3 == null) goto L5;
            this.mToken = r3.getByteArray("hw_auth_token");
            this.mLaunchedConfirm = r3.getBoolean(KEY_LAUNCHED_CONFIRM, false);
        L5:
            this.mUserId = getActivity().getIntent().getIntExtra("android.intent.extra.USER_ID", UserHandle.myUserId());
            this.mFingerprintManager = (FingerprintManager) getActivity().getSystemService("fingerprint");
            if (this.mToken == null) goto L8;
            return;
        L8:
            if (this.mLaunchedConfirm == true) goto L12;
            this.mLaunchedConfirm = true;
            launchChooseOrConfirmLock();
            return;
        }

        @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
        public void onViewCreated(View r3, Bundle r4) {
            super.onViewCreated(r3, r4);
            TextView r5 = (TextView) LayoutInflater.from(r3.getContext()).inflate(com.android.settings.R.layout.fingerprint_settings_footer, null);
            RestrictedLockUtils.EnforcedAdmin r6 = MultiSDKAdapterNew.checkIfKeyguardFeaturesDisabled(getActivity(), 32, this.mUserId);
            if (r6 == null) goto L5;
            int r0 = com.android.settings.R.string.security_settings_fingerprint_enroll_disclaimer_lockscreen_disabled;
        L6:
            r5.setText(LearnMoreSpan.linkify(getText(r0), getString(getHelpResource()), r6));
            r5.setMovementMethod(new LinkMovementMethod());
            setFooterView(r5);
            return;
        L5:
            r0 = com.android.settings.R.string.security_settings_fingerprint_enroll_disclaimer;
            goto L6
        }

        protected void removeFingerprintPreference(int r3) {
            String r4 = genKey(r3);
            Preference r0 = findPreference(r4);
            if (r0 != null) goto L5;
            OLog.w(TAG, "Can't find preference to remove: " + r4);
            return;
        L5:
            if (getPreferenceScreen().removePreference(r0) == true) goto L9;
            OLog.w(TAG, "Failed to remove preference with key " + r4);
            return;
        }

        private PreferenceScreen createPreferenceHierarchy() {
            PreferenceScreen r0 = getPreferenceScreen();
            if (r0 == null) goto L5;
            r0.removeAll();
        L5:
            addPreferencesFromResource(com.android.settings.R.xml.security_settings_fingerprint);
            PreferenceScreen r1 = getPreferenceScreen();
            addFingerprintItemPreferences(r1);
            setPreferenceScreen(r1);
            return r1;
        }

        private void addFingerprintItemPreferences(PreferenceGroup r8) {
            r8.removeAll();
            List r0 = this.mFingerprintManager.getEnrolledFingerprints(this.mUserId);
            if (r0 == null) goto L7;
            int r1 = r0.size();
            int r3 = 0;
        L5:
            if (r3 >= r1) goto L7;
            Fingerprint r4 = (Fingerprint) r0.get(r3);
            FingerprintPreference r5 = new FingerprintPreference(r8.getContext());
            r5.setKey(genKey(InvisibleApi.getFingerId(r4)));
            r5.setTitle(r4.getName());
            r5.setFingerprint(r4);
            r5.setPersistent(false);
            r8.addPreference(r5);
            r5.setOnPreferenceChangeListener(this);
            r3 = r3 + 1;
        L7:
            Preference r2 = new Preference(r8.getContext());
            r2.setKey(KEY_FINGERPRINT_ADD);
            r2.setTitle(com.android.settings.R.string.fingerprint_add_title);
            r2.setIcon(com.android.settings.R.drawable.ic_add_24dp);
            r8.addPreference(r2);
            r2.setOnPreferenceChangeListener(this);
            updateAddPreference();
        }

        private void updateAddPreference() {
            int r0 = FingerprintHelper.getMaxFingerprintPerUser(getContext().getResources());
            if (this.mFingerprintManager.getEnrolledFingerprints(this.mUserId).size() < r0) goto L5;
            boolean r1 = true;
        L6:
            if (r1 == false) goto L8;
            String r2 = getContext().getString(com.android.settings.R.string.fingerprint_add_max, new Object[]{Integer.valueOf(r0)});
        L9:
            Preference r6 = findPreference(KEY_FINGERPRINT_ADD);
            r6.setSummary(r2);
            r6.setEnabled(!r1);
            return;
        L8:
            r2 = "";
            goto L9
        L5:
            r1 = false;
            goto L6
        }

        private static String genKey(int r2) {
            return "key_fingerprint_item_" + r2;
        }

        public void com_android_settings_fingerprint_FingerprintSettings$FingerprintSettingsFragment__onResume$___twin___() {
            super.onResume();
            updatePreferences();
        }

        private void updatePreferences() {
            createPreferenceHierarchy();
            retryFingerprint();
        }

        @Override // com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
        public void onPause() {
            super.onPause();
            stopFingerprint();
        }

        @Override // com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
        public void onSaveInstanceState(Bundle r3) {
            r3.putByteArray("hw_auth_token", this.mToken);
            r3.putBoolean(KEY_LAUNCHED_CONFIRM, this.mLaunchedConfirm);
        }

        @Override // androidx.preference.PreferenceFragmentCompat, androidx.preference.PreferenceManager.OnPreferenceTreeClickListener
        public boolean onPreferenceTreeClick(Preference r3) {
            if (KEY_FINGERPRINT_ADD.equals(r3.getKey()) == false) goto L6;
            Intent r4 = new Intent();
            r4.setClassName("com.android.settings", FingerprintEnrollEnrolling.class.getName());
            r4.putExtra("android.intent.extra.USER_ID", this.mUserId);
            r4.putExtra("hw_auth_token", this.mToken);
            startActivityForResult(r4, 10);
            return true;
        L6:
            if ((r3 instanceof FingerprintPreference) == false) goto L11;
            showRenameDeleteDialog(((FingerprintPreference) r3).getFingerprint());
            return super.onPreferenceTreeClick(r3);
        L11:
            return true;
        }

        private void showRenameDeleteDialog(Fingerprint r4) {
            RenameDeleteDialog r0 = new RenameDeleteDialog();
            Bundle r1 = new Bundle();
            r1.putParcelable("fingerprint", r4);
            r0.setArguments(r1);
            r0.setTargetFragment(this, 0);
            r0.show(getParentFragmentManager(), RenameDeleteDialog.class.getName());
        }

        @Override // androidx.preference.Preference.OnPreferenceChangeListener
        public boolean onPreferenceChange(Preference r1, Object r2) {
            String r0 = r1.getKey();
            if (KEY_FINGERPRINT_ENABLE_KEYGUARD_TOGGLE.equals(r0) == true) goto L8;
            OLog.v(TAG, "Unknown key:" + r0);
            return true;
        L8:
            return true;
        }

        @Override // androidx.fragment.app.Fragment
        public void onActivityResult(int r2, int r3, Intent r4) {
            super.onActivityResult(r2, r3, r4);
            if (r2 == 102) goto L7;
            if (r2 == 101) goto L7;
        L13:
            if (this.mToken != null) goto L16;
            getActivity().finish();
            return;
        L16:
            return;
        L7:
            if (r3 != 1) goto L9;
        L10:
            if (r4 == null) goto L13;
            this.mToken = r4.getByteArrayExtra("hw_auth_token");
            goto L13
        L9:
            if (r3 != (-1)) goto L13;
            goto L10
        }

        @Override // androidx.fragment.app.Fragment
        public void onDestroy() {
            super.onDestroy();
            getActivity().isFinishing();
        }

        private Drawable getHighlightDrawable() {
            if (this.mHighlightDrawable != null) goto L8;
            FragmentActivity r0 = getActivity();
            if (r0 == null) goto L8;
            this.mHighlightDrawable = r0.getDrawable(com.android.settings.R.drawable.preference_highlight);
        L8:
            return this.mHighlightDrawable;
        }

        private void highlightFingerprintItem(int r4) {
            FingerprintPreference r5 = (FingerprintPreference) findPreference(genKey(r4));
            Drawable r0 = getHighlightDrawable();
            if (r0 == null) goto L6;
            final View r6 = r5.getView();
            r0.setHotspot(r6.getWidth() / 2, r6.getHeight() / 2);
            r6.setBackground(r0);
            r6.setPressed(true);
            this.mHandler.postDelayed(new AnonymousClass4(this, r6), 500);
            return;
        }

        private void launchChooseOrConfirmLock() {
            Intent r0 = new Intent();
            OLog.i(TAG, "launchChooseOrConfirmLock challenge 0");
            if (new ChooseLockSettingsHelper(getActivity(), this).launchConfirmationActivity(101, getString(com.android.settings.R.string.security_settings_fingerprint_preference_title), null, null, 0, 2) == true) goto L6;
            r0.setClassName("com.android.settings", ChooseLockGeneric.class.getName());
            r0.putExtra("minimum_quality", 65536);
            r0.putExtra(ChooseLockGeneric.ChooseLockGenericFragment.HIDE_DISABLED_PREFS, true);
            r0.putExtra(ChooseLockSettingsHelper.EXTRA_KEY_HAS_CHALLENGE, true);
            r0.putExtra("android.intent.extra.USER_ID", this.mUserId);
            r0.putExtra("challenge", 0);
            r0.putExtra("android.intent.extra.USER_ID", this.mUserId);
            startActivityForResult(r0, 102);
            return;
        }

        private void deleteFingerPrint(Fingerprint r3) {
            this.mFingerprintManager.remove(r3, this.mUserId, this.mRemoveCallback);
        }

        private void renameFingerPrint(int r3, String r4) {
            this.mFingerprintManager.rename(r3, this.mUserId, r4);
            updatePreferences();
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onCreate")
        public static void com_android_settings_fingerprint_FingerprintSettings$FingerprintSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(FingerprintSettingsFragment r2, Bundle r3) {
            String r0 = r2.getClass().getName();
            r2.com_android_settings_fingerprint_FingerprintSettings$FingerprintSettingsFragment__onCreate$___twin___(r3);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
            AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r4.callingPackageEvent("self", r0, true);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_fingerprint_FingerprintSettings$FingerprintSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(FingerprintSettingsFragment r2) {
            String r0 = r2.getClass().getName();
            com_android_settings_fingerprint_FingerprintSettings$FingerprintSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.recordVisibleTime(r0);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_fingerprint_FingerprintSettings$FingerprintSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(FingerprintSettingsFragment r2) {
            String r0 = r2.getClass().getName();
            r2.com_android_settings_fingerprint_FingerprintSettings$FingerprintSettingsFragment__onResume$___twin___();
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.reportVisibleTime(r0, true);
            return;
        }
    }

    private static class LearnMoreSpan extends URLSpan {
        private static final String ANNOTATION_ADMIN_DETAILS = "admin_details";
        private static final String ANNOTATION_URL = "url";
        private static final Typeface TYPEFACE_MEDIUM = null;
        private RestrictedLockUtils.EnforcedAdmin mEnforcedAdmin;

        static {
            TYPEFACE_MEDIUM = Typeface.create("sans-serif-medium", 0);
        }

        private LearnMoreSpan(String r1) {
            super(r1);
            this.mEnforcedAdmin = null;
        }

        private LearnMoreSpan(RestrictedLockUtils.EnforcedAdmin r3) {
            String r1 = (String) null;
            super(null);
            this.mEnforcedAdmin = r3;
        }

        @Override // android.text.style.URLSpan, android.text.style.ClickableSpan
        public void onClick(View r3) {
            Context r0 = r3.getContext();
            RestrictedLockUtils.EnforcedAdmin r1 = this.mEnforcedAdmin;
            if (r1 == null) goto L5;
            RestrictedLockUtils.sendShowAdminSupportDetailsIntent(r0, r1);
            return;
        L5:
            Intent r2 = HelpUtils.getHelpIntent(r0, getURL(), r0.getClass().getName());
            r3.startActivityForResult(r2, 0);     // Catch: ActivityNotFoundException -> L8
            return;
        L8:
            OLog.w(FingerprintSettings.TAG, "Actvity was not found for intent, " + r2.toString());
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint r1) {
            super.updateDrawState(r1);
            r1.setUnderlineText(false);
            r1.setTypeface(TYPEFACE_MEDIUM);
        }

        public static CharSequence linkify(CharSequence r8, String r9, RestrictedLockUtils.EnforcedAdmin r10) {
            SpannableString r0 = new SpannableString(r8);
            int r2 = 0;
            Annotation[] r11 = (Annotation[]) r0.getSpans(0, r0.length(), Annotation.class);
            SpannableStringBuilder r1 = new SpannableStringBuilder(r0);
            int r3 = r11.length;
        L3:
            if (r2 >= r3) goto L14;
            Annotation r4 = r11[r2];
            String r5 = r4.getValue();
            int r6 = r0.getSpanStart(r4);
            int r7 = r0.getSpanEnd(r4);
            if ("url".equals(r5) == false) goto L8;
            LearnMoreSpan r12 = new LearnMoreSpan(r9);
        L11:
            if (r12 == null) goto L13;
            r1.setSpan(r12, r6, r7, r0.getSpanFlags(r12));
        L13:
            r2 = r2 + 1;
            goto L3
        L8:
            if (ANNOTATION_ADMIN_DETAILS.equals(r5) == false) goto L10;
            r12 = new LearnMoreSpan(r10);
            goto L11
        L10:
            r12 = null;
            goto L11
        L14:
            return r1;
        }
    }

    public void com_android_settings_fingerprint_FingerprintSettings__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_fingerprint_FingerprintSettings__onResume$___twin___() {
        super.onResume();
    }

    public void com_android_settings_fingerprint_FingerprintSettings__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_fingerprint_FingerprintSettings__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // com.android.settings.SettingsActivity, com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r1) {
        com_android_settings_fingerprint_FingerprintSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_fingerprint_FingerprintSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com_android_settings_fingerprint_FingerprintSettings_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // com.android.settings.SettingsActivity, com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_fingerprint_FingerprintSettings_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_fingerprint_FingerprintSettings_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public FingerprintSettings() {
    }

    @Override // com.android.settings.SettingsActivity, android.app.Activity
    public Intent getIntent() {
        return new Intent(super.getIntent());
    }

    @Override // com.android.settings.SubSettings, com.android.settings.SettingsActivity
    protected boolean isValidFragment(String r1) {
        if (FingerprintSettingsFragment.class.getName().equals(r1) == false) goto L6;
        return true;
    L6:
        return false;
    }

    public void com_android_settings_fingerprint_FingerprintSettings__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
        setTitle(getText(com.android.settings.R.string.security_settings_fingerprint_preference_title));
    }

    public static Preference getFingerprintPreferenceForUser(Context r5, final int r6) {
        FingerprintManager r0 = (FingerprintManager) r5.getSystemService("fingerprint");
        if (r0 != null) goto L5;
    L16:
        OLog.v(TAG, "No fingerprint hardware detected!!");
        return null;
    L5:
        if (r0.isHardwareDetected() == false) goto L16;
        Preference r1 = new Preference(r5);
        r1.setKey(KEY_FINGERPRINT_SETTINGS);
        r1.setTitle(com.android.settings.R.string.security_settings_fingerprint_preference_title);
        List r2 = r0.getEnrolledFingerprints(r6);
        if (r2 == null) goto L10;
        int r3 = r2.size();
    L11:
        if (r3 <= 0) goto L13;
        r1.setSummary(r5.getResources().getQuantityString(com.android.settings.R.plurals.security_settings_fingerprint_preference_summary, r3, new Object[]{Integer.valueOf(r3)}));
        final String r7 = FingerprintSettings.class.getName();
    L14:
        r1.setOnPreferenceClickListener(new AnonymousClass1(r6, r7));
        return r1;
    L13:
        r1.setSummary(com.android.settings.R.string.security_settings_fingerprint_preference_summary_none);
        r7 = FingerprintEnrollIntroduction.class.getName();
        goto L14
    L10:
        r3 = 0;
        goto L11
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_fingerprint_FingerprintSettings_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(FingerprintSettings r1) {
        com_android_settings_fingerprint_FingerprintSettings_com_obric_hook_lancet_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_fingerprint_FingerprintSettings_com_obric_hook_lancet_PrivacyHook_onCreate(FingerprintSettings r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        FingerprintSettings r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_fingerprint_FingerprintSettings__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_fingerprint_FingerprintSettings_com_obric_hook_lancet_BatchedActivityLancet_onResume(FingerprintSettings r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_fingerprint_FingerprintSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_fingerprint_FingerprintSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(FingerprintSettings r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_fingerprint_FingerprintSettings_com_obric_hook_lancet_PrivacyHook_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        FingerprintSettings r5 = r4;
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
    public static void com_android_settings_fingerprint_FingerprintSettings_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(FingerprintSettings r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_fingerprint_FingerprintSettings__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_fingerprint_FingerprintSettings_com_obric_hook_lancet_BatchedActivityLancet_onStop(FingerprintSettings r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_fingerprint_FingerprintSettings_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_fingerprint_FingerprintSettings_com_obric_hook_lancet_PrivacyHook_onResume(FingerprintSettings r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        FingerprintSettings r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_fingerprint_FingerprintSettings__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_fingerprint_FingerprintSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(FingerprintSettings r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_fingerprint_FingerprintSettings_com_obric_hook_lancet_PrivacyHook_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_fingerprint_FingerprintSettings_com_obric_hook_lancet_PrivacyHook_onPause(FingerprintSettings r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        FingerprintSettings r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_fingerprint_FingerprintSettings__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_fingerprint_FingerprintSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(FingerprintSettings r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_fingerprint_FingerprintSettings_com_obric_hook_lancet_PrivacyHook_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        FingerprintSettings r5 = r3;
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
    public static void com_android_settings_fingerprint_FingerprintSettings_com_obric_hook_lancet_PrivacyHook_onStop(FingerprintSettings r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        FingerprintSettings r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_fingerprint_FingerprintSettings__onStop$___twin___();
    }
}
