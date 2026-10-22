package com.android.settings.accounts;

import android.accounts.AccountManager;
import android.accounts.AuthenticatorDescription;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SyncAdapterType;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.UserHandle;
import android.os.UserManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.android.internal.util.CharSequences;
import com.android.settings.R;
import com.android.settings.Utils;
import com.android.settings.base.BaseActivity;
import com.android.settings.teaevent.AppMetricsUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.google.android.collect.Maps;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import cz.msebera.android.httpclient.message.TokenParser;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class ChooseAccountActivity extends BaseActivity {
    private static final String TAG = "ChooseAccountActivity";
    private HashMap<String, ArrayList<String>> mAccountTypeToAuthorities;
    public HashSet<String> mAccountTypesFilter;
    private AuthenticatorDescription[] mAuthDescs;
    private String[] mAuthorities;
    private ListView mListView;
    public ArrayList<ProviderEntry> mProviderList;
    private final Map<String, AuthenticatorDescription> mTypeToAuthDescription;
    private UserManager mUm;
    private UserHandle mUserHandle;

    private static class AccountArrayAdapter extends ArrayAdapter<ProviderEntry> {
        private LayoutInflater mLayoutInflater;
        private ArrayList<ProviderEntry> mProviderList;

        public AccountArrayAdapter(Context r1, int r2, ArrayList<ProviderEntry> r3) {
            super(r1, r2, r3);
            this.mProviderList = r3;
            this.mLayoutInflater = (LayoutInflater) r1.getSystemService("layout_inflater");
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int r2, View r3, ViewGroup r4) {
            if (r3 != null) goto L4;
            r3 = this.mLayoutInflater.inflate(R.layout.choose_account_item_layout, null);
            ViewHolder r5 = new ViewHolder(null);
            r5.text = (TextView) r3.findViewById(R.id.account_row_text);
            r5.icon = (ImageView) r3.findViewById(R.id.account_row_icon);
            r3.setTag(r5);
        L5:
            ProviderEntry r1 = this.mProviderList.get(r2);
            r5.text.setText(ProviderEntry.access$300(r1));
            r5.icon.setImageDrawable(ProviderEntry.access$400(r1));
            return r3;
        L4:
            r5 = (ViewHolder) r3.getTag();
            goto L5
        }
    }

    private static class ProviderEntry implements Comparable<ProviderEntry> {
        private final Drawable icon;
        private final CharSequence name;
        private final String type;

        static /* synthetic */ String access$000(ProviderEntry r0) {
            return r0.type;
        }

        static /* synthetic */ CharSequence access$300(ProviderEntry r0) {
            return r0.name;
        }

        static /* synthetic */ Drawable access$400(ProviderEntry r0) {
            return r0.icon;
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(ProviderEntry r1) {
            return compareTo2(r1);
        }

        ProviderEntry(CharSequence r1, String r2, Drawable r3) {
            this.name = r1;
            this.type = r2;
            this.icon = r3;
        }

        /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
        public int compareTo2(ProviderEntry r1) {
            CharSequence r0 = this.name;
            if (r0 != null) goto L6;
            return -1;
        L6:
            CharSequence r2 = r1.name;
            if (r2 != null) goto L11;
            return 1;
        L11:
            return CharSequences.compareToIgnoreCase(r0, r2);
        }
    }

    private static class ViewHolder {
        ImageView icon;
        TextView text;

        private ViewHolder() {
        }

        /* synthetic */ ViewHolder(AnonymousClass1 r1) {
            this();
        }
    }

    public void com_android_settings_accounts_ChooseAccountActivity__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_accounts_ChooseAccountActivity__onResume$___twin___() {
        super.onResume();
    }

    public void com_android_settings_accounts_ChooseAccountActivity__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_accounts_ChooseAccountActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_settings_accounts_ChooseAccountActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_accounts_ChooseAccountActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com_android_settings_accounts_ChooseAccountActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_accounts_ChooseAccountActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_accounts_ChooseAccountActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public ChooseAccountActivity() {
        this.mProviderList = new ArrayList();
        this.mAccountTypeToAuthorities = null;
        this.mTypeToAuthDescription = new HashMap();
    }

    static /* synthetic */ void access$100(ChooseAccountActivity r0, String r1) {
        r0.finishWithAccountType(r1);
    }

    public void com_android_settings_accounts_ChooseAccountActivity__onCreate$___twin___(Bundle r5) {
        super.onCreate(r5);
        requestWindowFeature(1);
        setContentView(R.layout.add_account_screen);
        this.mAuthorities = getIntent().getStringArrayExtra(AccountPreferenceBase.AUTHORITIES_FILTER_KEY);
        String[] r6 = getIntent().getStringArrayExtra(AccountPreferenceBase.ACCOUNT_TYPES_FILTER_KEY);
        if (r6 == null) goto L7;
        this.mAccountTypesFilter = new HashSet();
        int r0 = r6.length;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L7;
        String r2 = r6[r1];
        this.mAccountTypesFilter.add(r2);
        r1 = r1 + 1;
    L7:
        this.mUm = UserManager.get(this);
        this.mUserHandle = Utils.getSecureTargetUser(getActivityToken(), this.mUm, null, getIntent().getExtras());
        this.mListView = (ListView) findViewById(android.R.id.list);
        updateAuthDescriptions();
        this.mListView.setOnItemClickListener(new AnonymousClass1(this));
    }

    private void updateAuthDescriptions() {
        this.mAuthDescs = AccountManager.get(this).getAuthenticatorTypesAsUser(this.mUserHandle.getIdentifier());
        int r0 = 0;
    L3:
        AuthenticatorDescription[] r1 = this.mAuthDescs;
        if (r0 >= r1.length) goto L6;
        this.mTypeToAuthDescription.put(r1[r0].type, this.mAuthDescs[r0]);
        r0 = r0 + 1;
        goto L3
    L6:
        onAuthDescriptionsUpdated();
    }

    private void onAuthDescriptionsUpdated() {
        int r1 = 0;
    L3:
        AuthenticatorDescription[] r2 = this.mAuthDescs;
        boolean r6 = true;
        if (r1 >= r2.length) goto L39;
        String r3 = r2[r1].type;
        Drawable r4 = getDrawableForType(r3);
        CharSequence r7 = getLabelForType(r3);
        ArrayList<String> r8 = getAuthoritiesForAccountType(r3);
        String[] r9 = this.mAuthorities;
        if (r9 != null) goto L8;
    L18:
        if (r6 == false) goto L24;
        HashSet<String> r10 = this.mAccountTypesFilter;
        if (r10 == null) goto L24;
        if (r10.contains(r3) == true) goto L24;
    L31:
        r6 = false;
    L32:
        if (r6 == false) goto L35;
        this.mProviderList.add(new ProviderEntry(r7, r3, r4));
    L37:
        r1 = r1 + 1;
        goto L3
    L35:
        if (Log.isLoggable(TAG, 2) == false) goto L37;
        OLog.v(TAG, "Skipped pref " + r7 + ": has no authority we need");
    L24:
        if (ManageAccountsSettingsActivity.BYTEDANCE_ACCOUNT_TYPE.equals(r3) == true) goto L31;
        if (ManageAccountsSettingsActivity.BYTEDANCE_MOVER_TYPE.equals(r3) == true) goto L31;
        if (r3.equals("com.android.sim") == true) goto L31;
        if (r3.equals("com.android.localphone") == false) goto L32;
    L8:
        if (r9.length <= 0) goto L18;
        if (r8 == null) goto L18;
        int r11 = 0;
    L11:
        String[] r12 = this.mAuthorities;
        if (r11 >= r12.length) goto L17;
        if (r8.contains(r12[r11]) == true) goto L18;
        r11 = r11 + 1;
        goto L11
    L17:
        r6 = false;
        goto L18
    L39:
        if (this.mProviderList.size() != 1) goto L42;
        finishWithAccountType(ProviderEntry.access$000(this.mProviderList.get(0)));
        return;
    L42:
        if (this.mProviderList.size() <= 0) goto L45;
        Collections.sort(this.mProviderList);
        this.mListView.setAdapter(new AccountArrayAdapter(this, android.R.layout.simple_list_item_1, this.mProviderList));
        return;
    L45:
        if (Log.isLoggable(TAG, 2) == true) goto L47;
    L52:
        setResult(0);
        finish();
        return;
    L47:
        if (this.mAuthorities == null) goto L52;
        StringBuilder r5 = new StringBuilder();
        String[] r13 = this.mAuthorities;
        int r14 = r13.length;
        int r15 = 0;
    L49:
        if (r15 >= r14) goto L51;
        r5.append(r13[r15]);
        r5.append(TokenParser.SP);
        r15 = r15 + 1;
        goto L49
    L51:
        OLog.v(TAG, "No providers found for authorities: " + r5);
        goto L52
    }

    public ArrayList<String> getAuthoritiesForAccountType(String r9) {
        if (this.mAccountTypeToAuthorities != null) goto L14;
        this.mAccountTypeToAuthorities = Maps.newHashMap();
        SyncAdapterType[] r0 = ContentResolver.getSyncAdapterTypesAsUser(this.mUserHandle.getIdentifier());
        int r1 = r0.length;
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L14;
        SyncAdapterType r3 = r0[r2];
        ArrayList<String> r4 = this.mAccountTypeToAuthorities.get(r3.accountType);
        if (r4 != null) goto L10;
        r4 = new ArrayList();
        this.mAccountTypeToAuthorities.put(r3.accountType, r4);
    L10:
        if (Log.isLoggable(TAG, 2) == false) goto L12;
        OLog.d(TAG, "added authority " + r3.authority + " to accountType " + r3.accountType);
    L12:
        r4.add(r3.authority);
        r2 = r2 + 1;
    L14:
        return this.mAccountTypeToAuthorities.get(r9);
    }

    protected Drawable getDrawableForType(String r6) {
        if (this.mTypeToAuthDescription.containsKey(r6) == true) goto L13;
    L8:
        Drawable r7 = null;
    L9:
        if (r7 == null) goto L12;
        return r7;
    L12:
        return getPackageManager().getDefaultActivityIcon();
    L13:
        AuthenticatorDescription r1 = this.mTypeToAuthDescription.get(r6);     // Catch: Resources.NotFoundException -> L6 PackageManager.NameNotFoundException -> L7
        r7 = getPackageManager().getUserBadgedIcon(createPackageContextAsUser(r1.packageName, 0, this.mUserHandle).getResources().getDrawable(r1.iconId), this.mUserHandle);     // Catch: Resources.NotFoundException -> L6 PackageManager.NameNotFoundException -> L7
    L7:
        OLog.w(TAG, "No icon name for account type " + r6);
    L6:
        OLog.w(TAG, "No icon resource for account type " + r6);
        goto L8
    }

    protected CharSequence getLabelForType(String r6) {
        if (this.mTypeToAuthDescription.containsKey(r6) == true) goto L10;
    L8:
        return null;
    L10:
        AuthenticatorDescription r1 = this.mTypeToAuthDescription.get(r6);     // Catch: Resources.NotFoundException -> L6 PackageManager.NameNotFoundException -> L7
    L12:
        return createPackageContextAsUser(r1.packageName, 0, this.mUserHandle).getResources().getText(r1.labelId);
    L7:
        OLog.w(TAG, "No label name for account type " + r6);
    L6:
        OLog.w(TAG, "No label resource for account type " + r6);
        goto L8
    }

    private void finishWithAccountType(String r3) {
        Intent r0 = new Intent();
        r0.putExtra("selected_account", r3);
        r0.putExtra("android.intent.extra.USER", this.mUserHandle);
        setResult(-1, r0);
        finish();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_accounts_ChooseAccountActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(ChooseAccountActivity r1) {
        com_android_settings_accounts_ChooseAccountActivity_com_obric_hook_lancet_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_accounts_ChooseAccountActivity_com_obric_hook_lancet_PrivacyHook_onCreate(ChooseAccountActivity r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        ChooseAccountActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_accounts_ChooseAccountActivity__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_accounts_ChooseAccountActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(ChooseAccountActivity r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_accounts_ChooseAccountActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_accounts_ChooseAccountActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(ChooseAccountActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_accounts_ChooseAccountActivity_com_obric_hook_lancet_PrivacyHook_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        ChooseAccountActivity r5 = r4;
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
    public static void com_android_settings_accounts_ChooseAccountActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(ChooseAccountActivity r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_accounts_ChooseAccountActivity__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_accounts_ChooseAccountActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(ChooseAccountActivity r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_accounts_ChooseAccountActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_accounts_ChooseAccountActivity_com_obric_hook_lancet_PrivacyHook_onResume(ChooseAccountActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        ChooseAccountActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_accounts_ChooseAccountActivity__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_accounts_ChooseAccountActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(ChooseAccountActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_accounts_ChooseAccountActivity_com_obric_hook_lancet_PrivacyHook_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_accounts_ChooseAccountActivity_com_obric_hook_lancet_PrivacyHook_onPause(ChooseAccountActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        ChooseAccountActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_accounts_ChooseAccountActivity__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_accounts_ChooseAccountActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(ChooseAccountActivity r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_accounts_ChooseAccountActivity_com_obric_hook_lancet_PrivacyHook_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        ChooseAccountActivity r5 = r3;
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
    public static void com_android_settings_accounts_ChooseAccountActivity_com_obric_hook_lancet_PrivacyHook_onStop(ChooseAccountActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        ChooseAccountActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_accounts_ChooseAccountActivity__onStop$___twin___();
    }
}
