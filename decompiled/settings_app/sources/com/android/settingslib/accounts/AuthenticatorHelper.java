package com.android.settingslib.accounts;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AuthenticatorDescription;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SyncAdapterType;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.UserHandle;
import android.util.Log;
import com.GlobalProxyLancet;
import com.android.settings.SettingsApplication;
import com.android.settings.SettingsInitialize;
import com.android.settingslib.Utils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Insert;

/* JADX INFO: loaded from: classes.dex */
public final class AuthenticatorHelper extends BroadcastReceiver {
    private static final String TAG = "AuthenticatorHelper";
    private final Map<String, Drawable> mAccTypeIconCache;
    private final HashMap<String, ArrayList<String>> mAccountTypeToAuthorities;
    private final Context mContext;
    private final ArrayList<String> mEnabledAccountTypes;
    private final OnAccountsUpdateListener mListener;
    private boolean mListeningToAccountUpdates;
    private final Map<String, AuthenticatorDescription> mTypeToAuthDescription;
    private final UserHandle mUserHandle;

    public interface OnAccountsUpdateListener {
        void onAccountsUpdate(UserHandle r1);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r1, Intent r2) {
        com_android_settingslib_accounts_AuthenticatorHelper_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(this, r1, r2);
    }

    public AuthenticatorHelper(Context r2, UserHandle r3, OnAccountsUpdateListener r4) {
        this.mTypeToAuthDescription = new HashMap();
        this.mEnabledAccountTypes = new ArrayList();
        this.mAccTypeIconCache = new HashMap();
        this.mAccountTypeToAuthorities = new HashMap();
        this.mContext = r2;
        this.mUserHandle = r3;
        this.mListener = r4;
        onAccountsUpdated(null);
    }

    public String[] getEnabledAccountTypes() {
        ArrayList<String> r1 = this.mEnabledAccountTypes;
        return (String[]) r1.toArray(new String[r1.size()]);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.android.settingslib.accounts.AuthenticatorHelper$1] */
    public void preloadDrawableForType(final Context r2, final String r3) {
        Void[] r4 = (Void[]) null;
        new AnonymousClass1(this, r2, r3).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, null);
    }

    public Drawable getDrawableForType(Context r6, String r7) {
        Map<String, Drawable> r0 = this.mAccTypeIconCache;
        monitor-enter(r0);
    L24:
        th = move-exception;
        throw th;
    L5:
        if (this.mAccTypeIconCache.containsKey(r7) == false) goto L9;
        Drawable r5 = this.mAccTypeIconCache.get(r7);     // Catch: Throwable -> L24
        monitor-exit(r0);     // Catch: Throwable -> L24
        return r5;
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L24
        Drawable r1 = null;
        if (this.mTypeToAuthDescription.containsKey(r7) == true) goto L30;
    L20:
        if (r1 != null) goto L23;
        r1 = r6.getPackageManager().getDefaultActivityIcon();
    L23:
        return Utils.getBadgedIcon(this.mContext, r1, this.mUserHandle);
    L30:
        AuthenticatorDescription r2 = this.mTypeToAuthDescription.get(r7);     // Catch: Throwable -> L27
        r1 = r6.createPackageContextAsUser(r2.packageName, 0, this.mUserHandle).getDrawable(r2.iconId);     // Catch: Throwable -> L27
        Map<String, Drawable> r3 = this.mAccTypeIconCache;     // Catch: Throwable -> L27
        monitor-enter(r3);     // Catch: Throwable -> L27
        this.mAccTypeIconCache.put(r7, r1);     // Catch: Throwable -> L17
        monitor-exit(r3);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L27 Throwable -> L27
    }

    public CharSequence getLabelForType(Context r5, String r6) {
        if (this.mTypeToAuthDescription.containsKey(r6) == true) goto L10;
    L8:
        return null;
    L10:
        AuthenticatorDescription r1 = this.mTypeToAuthDescription.get(r6);     // Catch: Resources.NotFoundException -> L6 PackageManager.NameNotFoundException -> L7
    L12:
        return r5.createPackageContextAsUser(r1.packageName, 0, this.mUserHandle).getResources().getText(r1.labelId);
    L7:
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "No label name for account type " + r6);
    L6:
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "No label icon for account type " + r6);
        goto L8
    }

    public String getPackageForType(String r2) {
        if (this.mTypeToAuthDescription.containsKey(r2) == true) goto L5;
        return null;
    L5:
        return this.mTypeToAuthDescription.get(r2).packageName;
    }

    public int getLabelIdForType(String r2) {
        if (this.mTypeToAuthDescription.containsKey(r2) == true) goto L5;
        return -1;
    L5:
        return this.mTypeToAuthDescription.get(r2).labelId;
    }

    public void updateAuthDescriptions(Context r5) {
        AuthenticatorDescription[] r6 = AccountManager.get(r5).getAuthenticatorTypesAsUser(this.mUserHandle.getIdentifier());
        int r0 = 0;
    L4:
        if (r0 >= r6.length) goto L6;
        this.mTypeToAuthDescription.put(r6[r0].type, r6[r0]);
        r0 = r0 + 1;
        goto L4
    }

    public boolean containsAccountType(String r1) {
        return this.mTypeToAuthDescription.containsKey(r1);
    }

    public AuthenticatorDescription getAccountTypeDescription(String r1) {
        return this.mTypeToAuthDescription.get(r1);
    }

    public boolean hasAccountPreferences(String r2) {
        if (containsAccountType(r2) == false) goto L10;
        AuthenticatorDescription r1 = getAccountTypeDescription(r2);
        if (r1 != null) goto L7;
        return false;
    L7:
        if (r1.accountPreferencesId == 0) goto L13;
        return true;
    L13:
        return false;
    L10:
        return false;
    }

    void onAccountsUpdated(Account[] r5) {
        updateAuthDescriptions(this.mContext);
        if (r5 != null) goto L5;
        r5 = AccountManager.get(this.mContext).getAccountsAsUser(this.mUserHandle.getIdentifier());
    L5:
        this.mEnabledAccountTypes.clear();
        this.mAccTypeIconCache.clear();
        int r0 = 0;
    L7:
        if (r0 >= r5.length) goto L12;
        Account r1 = r5[r0];
        if (this.mEnabledAccountTypes.contains(r1.type) == true) goto L11;
        this.mEnabledAccountTypes.add(r1.type);
    L11:
        r0 = r0 + 1;
        goto L7
    L12:
        buildAccountTypeToAuthoritiesMap();
        if (this.mListeningToAccountUpdates == false) goto L19;
        this.mListener.onAccountsUpdate(this.mUserHandle);
        return;
    }

    public void com_android_settingslib_accounts_AuthenticatorHelper__onReceive$___twin___(Context r1, Intent r2) {
        onAccountsUpdated(AccountManager.get(this.mContext).getAccountsAsUser(this.mUserHandle.getIdentifier()));
    }

    public void listenToAccountUpdates() {
        if (this.mListeningToAccountUpdates == true) goto L6;
        IntentFilter r4 = new IntentFilter();
        r4.addAction("android.accounts.LOGIN_ACCOUNTS_CHANGED");
        r4.addAction("android.intent.action.DEVICE_STORAGE_OK");
        this.mContext.registerReceiverAsUser(this, this.mUserHandle, r4, null, null);
        this.mListeningToAccountUpdates = true;
        return;
    }

    public void stopListeningToAccountUpdates() {
        if (this.mListeningToAccountUpdates == false) goto L6;
        this.mContext.unregisterReceiver(this);
        this.mListeningToAccountUpdates = false;
        return;
    }

    public ArrayList<String> getAuthoritiesForAccountType(String r1) {
        return this.mAccountTypeToAuthorities.get(r1);
    }

    private void buildAccountTypeToAuthoritiesMap() {
        this.mAccountTypeToAuthorities.clear();
        SyncAdapterType[] r0 = ContentResolver.getSyncAdapterTypesAsUser(this.mUserHandle.getIdentifier());
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L11;
        SyncAdapterType r3 = r0[r2];
        ArrayList<String> r4 = this.mAccountTypeToAuthorities.get(r3.accountType);
        if (r4 != null) goto L8;
        r4 = new ArrayList();
        this.mAccountTypeToAuthorities.put(r3.accountType, r4);
    L8:
        if (Log.isLoggable(TAG, 2) == false) goto L10;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_v(TAG, "Added authority " + r3.authority + " to accountType " + r3.accountType);
    L10:
        r4.add(r3.authority);
        r2 = r2 + 1;
        goto L3
    }

    @Insert("onReceive")
    public static void com_android_settingslib_accounts_AuthenticatorHelper_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(AuthenticatorHelper r7, Context r8, Intent r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        String[] r0 = {"android.bluetooth.device.action.PAIRING_REQUEST", "android.bluetooth.device.action.BOND_STATE_CHANGED", "com.bytedanceos.launcher.new_message", "intent.provision.import_data", "com.android.settings.action.SHOW_IMPORT_DATA_NOTIFICATION"};
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.content.BroadcastReceiver");
        AuthenticatorHelper r1 = r7;
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
        r7.com_android_settingslib_accounts_AuthenticatorHelper__onReceive$___twin___(r8, r9);
        return;
    L13:
        GrantUtil r11 = GrantUtil.INSTANCE;
        Application r12 = SettingsApplication.getApplication();
        Intrinsics.checkNotNullExpressionValue(r12, "getApplication(...)");
        if (r11.isSetupCompelete(r12) == true) goto L16;
        OLog.i("PrivacyHookForReceiver", "onReceive !isSetupCompeleted hooked for " + r3 + ", " + r2);
        r7.com_android_settingslib_accounts_AuthenticatorHelper__onReceive$___twin___(r8, r9);
        return;
    L16:
        String r13 = r3;
        if (r13 != null) goto L19;
    L22:
        boolean r14 = true;
    L23:
        if (r14 == false) goto L26;
        OLog.i("PrivacyHookForReceiver", "onReceive !simpleName hooked for " + r3 + ", " + r2);
        r7.com_android_settingslib_accounts_AuthenticatorHelper__onReceive$___twin___(r8, r9);
        return;
    L26:
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == true) goto L30;
        if (r4 == true) goto L30;
        OLog.i("PrivacyHookForReceiver", "onReceive !isPrivacyAllowed hooked for " + r3 + ", " + r2);
        return;
    L30:
        GrantUtil.INSTANCE.applicationInit();
        r7.com_android_settingslib_accounts_AuthenticatorHelper__onReceive$___twin___(r8, r9);
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
