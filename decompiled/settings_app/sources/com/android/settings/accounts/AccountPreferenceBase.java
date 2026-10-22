package com.android.settings.accounts;

import android.accounts.AuthenticatorDescription;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SyncStatusObserver;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.UserHandle;
import android.os.UserManager;
import android.view.ContextThemeWrapper;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.PreferenceScreen;
import com.android.settings.SettingsPreferenceFragment23;
import com.android.settings.Utils;
import com.android.settings.accounts.obric.ObricIconUtils;
import com.android.settings.applications.PickApplicationActivity;
import com.android.settingslib.accounts.AuthenticatorHelper;
import com.obric.olog.OLog;
import com.obric.oui.time.TimeDateUtil;
import com.obric.oui.time.TimeStyle;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
abstract class AccountPreferenceBase extends SettingsPreferenceFragment23 implements AuthenticatorHelper.OnAccountsUpdateListener {
    public static final String ACCOUNT_TYPES_FILTER_KEY = "account_types";
    public static final String AUTHORITIES_FILTER_KEY = "authorities";
    protected static final String TAG = "AccountSettings";
    protected AuthenticatorHelper mAuthenticatorHelper;
    private DateFormat mDateFormat;
    private final Handler mHandler;
    private Object mStatusChangeListenerHandle;
    private SyncStatusObserver mSyncStatusObserver;
    private DateFormat mTimeFormat;
    private UserManager mUm;
    protected UserHandle mUserHandle;

    @Override // com.android.settingslib.accounts.AuthenticatorHelper.OnAccountsUpdateListener
    public void onAccountsUpdate(UserHandle r1) {
    }

    protected void onAuthDescriptionsUpdated() {
    }

    protected void onSyncStateUpdated() {
    }

    AccountPreferenceBase() {
        this.mHandler = new Handler();
        this.mSyncStatusObserver = new AnonymousClass1(this);
    }

    static /* synthetic */ Handler access$000(AccountPreferenceBase r0) {
        return r0.mHandler;
    }

    @Override // com.android.settings.SettingsPreferenceFragment23, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r5) {
        super.onCreate(r5);
        this.mUm = (UserManager) getSystemService(PickApplicationActivity.EXTRA_USER);
        FragmentActivity r6 = getActivity();
        this.mUserHandle = Utils.getSecureTargetUser(r6.getActivityToken(), this.mUm, getArguments(), r6.getIntent().getExtras());
        this.mAuthenticatorHelper = new AuthenticatorHelper(r6, this.mUserHandle, this);
    }

    @Override // com.android.settings.SettingsPreferenceFragment23, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle r2) {
        super.onActivityCreated(r2);
        FragmentActivity r3 = getActivity();
        this.mDateFormat = android.text.format.DateFormat.getDateFormat(r3);
        this.mTimeFormat = android.text.format.DateFormat.getTimeFormat(r3);
    }

    @Override // com.android.settings.SettingsPreferenceFragment23, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.mStatusChangeListenerHandle = ContentResolver.addStatusChangeListener(13, this.mSyncStatusObserver);
        onSyncStateUpdated();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        ContentResolver.removeStatusChangeListener(this.mStatusChangeListenerHandle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public ArrayList<String> getAuthoritiesForAccountType(String r1) {
        return this.mAuthenticatorHelper.getAuthoritiesForAccountType(r1);
    }

    public PreferenceScreen addPreferencesForType(String r9, PreferenceScreen r10) {
        if (this.mAuthenticatorHelper.containsAccountType(r9) == false) goto L26;
        AuthenticatorDescription r11 = this.mAuthenticatorHelper.getAccountTypeDescription(r9);     // Catch: Exception -> L12 Resources.NotFoundException -> L15 PackageManager.NameNotFoundException -> L17
        if (r11 == null) goto L27;
    L10:
        e = e;
    L14:
        OLog.w("AccountSettings", "Couldn't load preferences.xml file from " + r11.packageName, e);
        return null;
    L7:
        if (r11.accountPreferencesId == 0) goto L28;
        Context r2 = getActivity().createPackageContextAsUser(r11.packageName, 0, this.mUserHandle);     // Catch: Exception -> L10 Resources.NotFoundException -> L20 PackageManager.NameNotFoundException -> L21
        Resources.Theme r4 = getResources().newTheme();     // Catch: Exception -> L10 Resources.NotFoundException -> L20 PackageManager.NameNotFoundException -> L21
        r4.applyStyle(2132019116, true);     // Catch: Exception -> L10 Resources.NotFoundException -> L20 PackageManager.NameNotFoundException -> L21
        ContextThemeWrapper r5 = new ContextThemeWrapper(r2, 0);     // Catch: Exception -> L10 Resources.NotFoundException -> L20 PackageManager.NameNotFoundException -> L21
        r5.getTheme().setTo(r4);     // Catch: Exception -> L10 Resources.NotFoundException -> L20 PackageManager.NameNotFoundException -> L21
    L29:
        return getPreferenceManager().inflateFromResource(r5, r11.accountPreferencesId, r10);
    L28:
        return null;
    L18:
        OLog.w("AccountSettings", "Couldn't load preferences.xml file from " + r11.packageName);
        return null;
    L16:
        OLog.w("AccountSettings", "Couldn't load preferences.xml file from " + r11.packageName);
        return null;
    L27:
        return null;
    L17:
        r11 = null;
    L15:
        r11 = null;
    L12:
        e = e;
        r11 = null;
        goto L14
    L26:
        return null;
    }

    public void updateAuthDescriptions() {
        this.mAuthenticatorHelper.updateAuthDescriptions(getActivity());
        onAuthDescriptionsUpdated();
    }

    protected Drawable getDrawableForType(String r1) {
        return ObricIconUtils.getDrawable(this.mAuthenticatorHelper.getPackageForType(r1));
    }

    protected CharSequence getLabelForType(String r2) {
        return this.mAuthenticatorHelper.getLabelForType(getActivity(), r2);
    }

    protected String formatSyncDate(Date r3) {
        return TimeDateUtil.formatTimeRelative(TimeStyle.RELATIVE_MIXED, r3, new Date(), Locale.getDefault());
    }
}
