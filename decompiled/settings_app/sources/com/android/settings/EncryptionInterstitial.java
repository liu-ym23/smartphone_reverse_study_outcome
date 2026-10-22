package com.android.settings;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.TextView;
import androidx.preference.Preference;
import com.obric.olog.OLog;
import com.obric.oui.titlebar.OFloatingTitleBar;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class EncryptionInterstitial extends SettingsActivity {
    private static final int CHOOSE_LOCK_REQUEST = 100;
    protected static final String EXTRA_PASSWORD_QUALITY = "extra_password_quality";
    public static final String EXTRA_REQUIRE_PASSWORD = "extra_require_password";
    protected static final String EXTRA_UNLOCK_METHOD_INTENT = "extra_unlock_method_intent";
    private static final String TAG = "EncryptionInterstitial";

    public static class EncryptionInterstitialFragment extends SettingsPreferenceFragment implements DialogInterface.OnClickListener {
        private static final int ACCESSIBILITY_WARNING_DIALOG = 1;
        private static final String KEY_ENCRYPT_DONT_REQUIRE_PASSWORD = "encrypt_dont_require_password";
        private static final String KEY_ENCRYPT_REQUIRE_PASSWORD = "encrypt_require_password";
        private Preference mDontRequirePasswordToDecrypt;
        private boolean mPasswordRequired;
        private int mPinLength;
        private int mRequestedPasswordQuality;
        private Preference mRequirePasswordToDecrypt;
        private Intent mUnlockMethodIntent;

        public EncryptionInterstitialFragment() {
            this.mPinLength = 4;
        }

        @Override // com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
        public void onCreate(Bundle r4) {
            super.onCreate(r4);
            addPreferencesFromResource(R.xml.security_settings_encryption_interstitial);
            findPreference(KEY_ENCRYPT_DONT_REQUIRE_PASSWORD).setViewId(R.id.encrypt_dont_require_password);
            this.mRequirePasswordToDecrypt = findPreference(KEY_ENCRYPT_REQUIRE_PASSWORD);
            this.mDontRequirePasswordToDecrypt = findPreference(KEY_ENCRYPT_DONT_REQUIRE_PASSWORD);
            boolean r5 = getActivity().getIntent().getBooleanExtra("for_fingerprint", false);
            Intent r0 = getActivity().getIntent();
            this.mRequestedPasswordQuality = r0.getIntExtra(EncryptionInterstitial.EXTRA_PASSWORD_QUALITY, 0);
            this.mUnlockMethodIntent = (Intent) r0.getParcelableExtra(EncryptionInterstitial.EXTRA_UNLOCK_METHOD_INTENT);
            this.mPinLength = getActivity().getIntent().getIntExtra(ChooseLockPassword.EXTRA_PIN_LENGTH, 4);
            int r1 = this.mRequestedPasswordQuality;
            if (r1 != 65536) goto L5;
            if (r5 == false) goto L18;
            int r6 = R.string.encryption_interstitial_message_pattern_for_fingerprint;
        L19:
            int r2 = R.string.encrypt_require_pattern;
            int r3 = R.string.encrypt_dont_require_pattern;
        L20:
            TextView r7 = createHeaderView();
            r7.setText(r6);
            setHeaderView(r7);
            this.mRequirePasswordToDecrypt.setTitle(r2);
            this.mDontRequirePasswordToDecrypt.setTitle(r3);
            setRequirePasswordState(getActivity().getIntent().getBooleanExtra(EncryptionInterstitial.EXTRA_REQUIRE_PASSWORD, true));
            return;
        L18:
            r6 = R.string.encryption_interstitial_message_pattern;
            goto L19
        L5:
            if (r1 != 131072) goto L7;
        L12:
            if (r5 == false) goto L14;
            r6 = R.string.encryption_interstitial_message_pin_for_fingerprint;
        L15:
            r2 = R.string.encrypt_require_pin;
            r3 = R.string.encrypt_dont_require_pin;
            goto L20
        L14:
            r6 = R.string.encryption_interstitial_message_pin;
            goto L15
        L7:
            if (r1 == 196608) goto L12;
            if (r5 == false) goto L10;
            r6 = R.string.encryption_interstitial_message_password_for_fingerprint;
        L11:
            r2 = R.string.encrypt_require_password;
            r3 = R.string.encrypt_dont_require_password;
            goto L20
        L10:
            r6 = R.string.encryption_interstitial_message_password;
            goto L11
        }

        private void setupBackBtnOnTitle(View r4) {
            ((OFloatingTitleBar) r4.findViewById(R.id.view_title)).addStartAction(R.drawable.o_floating_title_bar_icon_back, -1, null).setOnClickListener(new AnonymousClass1(this));
        }

        protected TextView createHeaderView() {
            return (TextView) LayoutInflater.from(getActivity()).inflate(R.layout.encryption_interstitial_header, null, false);
        }

        protected void startLockIntent() {
            Intent r0 = this.mUnlockMethodIntent;
            if (r0 == null) goto L5;
            r0.putExtra(EncryptionInterstitial.EXTRA_REQUIRE_PASSWORD, this.mPasswordRequired);
            this.mUnlockMethodIntent.putExtra(ChooseLockPassword.EXTRA_PIN_LENGTH, this.mPinLength);
            startActivityForResult(this.mUnlockMethodIntent, 100);
            return;
        L5:
            OLog.w(EncryptionInterstitial.access$000(), "no unlock intent to start");
            Log.wtf(EncryptionInterstitial.access$000(), "no unlock intent to start");
            finish();
        }

        @Override // androidx.fragment.app.Fragment
        public void onActivityResult(int r2, int r3, Intent r4) {
            super.onActivityResult(r2, r3, r4);
            if (r2 != 100) goto L7;
            if (r3 == 0) goto L8;
            getActivity().setResult(r3, r4);
            finish();
            return;
        L8:
            return;
        }

        @Override // androidx.preference.PreferenceFragmentCompat, androidx.preference.PreferenceManager.OnPreferenceTreeClickListener
        public boolean onPreferenceTreeClick(Preference r3) {
            if (r3.getKey().equals(KEY_ENCRYPT_REQUIRE_PASSWORD) == true) goto L5;
            setRequirePasswordState(false);
            startLockIntent();
        L11:
            return true;
        L5:
            if (AccessibilityManager.getInstance(getActivity()).isEnabled() == true) goto L7;
        L9:
            setRequirePasswordState(true);
            startLockIntent();
            goto L11
        L7:
            if (this.mPasswordRequired == true) goto L9;
            setRequirePasswordState(false);
            showDialog(1);
            goto L11
        }

        @Override // com.android.settings.SettingsPreferenceFragment, com.android.settings.DialogCreatable
        public Dialog onCreateDialog(int r7) {
            if (r7 != 1) goto L20;
            int r8 = this.mRequestedPasswordQuality;
            if (r8 != 65536) goto L7;
            int r9 = R.string.encrypt_talkback_dialog_require_pattern;
            int r1 = R.string.encrypt_talkback_dialog_message_pattern;
        L13:
            List<AccessibilityServiceInfo> r2 = AccessibilityManager.getInstance(getActivity()).getEnabledAccessibilityServiceList(-1);
            if (r2.isEmpty() == false) goto L16;
            CharSequence r3 = "";
        L18:
            return new AlertDialog.Builder(getActivity()).setTitle(r9).setMessage(getString(r1, new Object[]{r3})).setCancelable(true).setPositiveButton(android.R.string.ok, this).setNegativeButton(android.R.string.cancel, this).create();
        L16:
            r3 = r2.get(0).getResolveInfo().loadLabel(getPackageManager());
            goto L18
        L7:
            if (r8 != 131072) goto L9;
        L11:
            r9 = R.string.encrypt_talkback_dialog_require_pin;
            r1 = R.string.encrypt_talkback_dialog_message_pin;
            goto L13
        L9:
            if (r8 == 196608) goto L11;
            r9 = R.string.encrypt_talkback_dialog_require_password;
            r1 = R.string.encrypt_talkback_dialog_message_password;
            goto L13
        L20:
            throw new IllegalArgumentException();
        }

        private void setRequirePasswordState(boolean r1) {
            this.mPasswordRequired = r1;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface r1, int r2) {
            if (r2 != (-1)) goto L6;
            setRequirePasswordState(true);
            return;
        L6:
            if (r2 != (-2)) goto L10;
            setRequirePasswordState(false);
            return;
        }
    }

    static {
    }

    public EncryptionInterstitial() {
    }

    static /* synthetic */ String access$000() {
        return TAG;
    }

    @Override // com.android.settings.SettingsActivity, android.app.Activity
    public Intent getIntent() {
        Intent r0 = new Intent(super.getIntent());
        r0.putExtra(SettingsActivity.EXTRA_SHOW_FRAGMENT, EncryptionInterstitialFragment.class.getName());
        return r0;
    }

    @Override // com.android.settings.SettingsActivity
    protected boolean isValidFragment(String r1) {
        return EncryptionInterstitialFragment.class.getName().equals(r1);
    }

    public static Intent createStartIntent(Context r2, int r3, boolean r4, Intent r5) {
        return new Intent(r2, EncryptionInterstitial.class).putExtra(EXTRA_PASSWORD_QUALITY, r3).putExtra(SettingsActivity.EXTRA_SHOW_FRAGMENT_TITLE_RESID, R.string.encryption_interstitial_header).putExtra(EXTRA_REQUIRE_PASSWORD, r4).putExtra(EXTRA_UNLOCK_METHOD_INTENT, r5);
    }
}
