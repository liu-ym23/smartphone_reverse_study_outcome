package com.android.settings.applications;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Handler;
import android.os.UserHandle;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.android.internal.content.PackageMonitor;
import com.android.settings.AppListPreference;
import com.android.settings.R;
import com.obric.olog.OLog;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class DefaultBrowserPreference extends AppListPreference {
    private static final long DELAY_UPDATE_BROWSER_MILLIS = 500;
    private static final String TAG = "DefaultBrowserPref";
    private final Handler mHandler;
    private final PackageMonitor mPackageMonitor;
    private final PackageManager mPm;
    private final Runnable mUpdateRunnable;

    static /* synthetic */ void access$000(DefaultBrowserPreference r0) {
        r0.updateDefaultBrowserPreference();
    }

    static /* synthetic */ Runnable access$100(DefaultBrowserPreference r0) {
        return r0.mUpdateRunnable;
    }

    static /* synthetic */ Handler access$200(DefaultBrowserPreference r0) {
        return r0.mHandler;
    }

    public DefaultBrowserPreference(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.mHandler = new Handler();
        this.mUpdateRunnable = new AnonymousClass1(this);
        this.mPackageMonitor = new AnonymousClass2(this);
        this.mPm = r1.getPackageManager();
        refreshBrowserApps();
    }

    @Override // androidx.preference.Preference
    public void onAttached() {
        super.onAttached();
        updateDefaultBrowserPreference();
        this.mPackageMonitor.register(getContext(), getContext().getMainLooper(), false);
    }

    @Override // androidx.preference.Preference
    public void onDetached() {
        this.mPackageMonitor.unregister();
        super.onDetached();
    }

    @Override // androidx.preference.Preference
    protected boolean persistString(String r5) {
        if (r5 != null) goto L6;
        return false;
    L6:
        if (TextUtils.isEmpty(r5) == false) goto L8;
        return false;
    L8:
        boolean r1 = this.mPm.setDefaultBrowserPackageNameAsUser(r5.toString(), this.mUserId);
        if (r1 == false) goto L11;
        setSummary("%s");
    L11:
        if (r1 == true) goto L13;
        return false;
    L13:
        if (super.persistString(r5) == false) goto L17;
        return true;
    L17:
        return false;
    }

    public void refreshBrowserApps() {
        List<String> r0 = resolveBrowserApps();
        setPackageNames((CharSequence[]) r0.toArray(new String[r0.size()]), null);
    }

    private void updateDefaultBrowserPreference() {
        refreshBrowserApps();
        String r0 = getContext().getPackageManager().getDefaultBrowserPackageNameAsUser(this.mUserId);
        if (TextUtils.isEmpty(r0) == true) goto L8;
        Intent r1 = new Intent();
        r1.setPackage(r0);
        r1.setAction("android.intent.action.VIEW");
        r1.addCategory("android.intent.category.BROWSABLE");
        r1.setData(Uri.parse("http:"));
        if (this.mPm.resolveActivityAsUser(r1, 0, this.mUserId) == null) goto L7;
        setValue(r0);
        setSummary("%s");
        return;
    L7:
        setSummary(R.string.default_browser_title_none);
        return;
    L8:
        setSummary(R.string.default_browser_title_none);
        OLog.d(TAG, "Cannot set empty default Browser value!");
    }

    private List<String> resolveBrowserApps() {
        ArrayList r0 = new ArrayList();
        Intent r1 = new Intent();
        r1.setAction("android.intent.action.VIEW");
        r1.addCategory("android.intent.category.BROWSABLE");
        r1.setData(Uri.parse("http:"));
        List r5 = this.mPm.queryIntentActivitiesAsUser(r1, 131072, this.mUserId);
        int r2 = r5.size();
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L13;
        ResolveInfo r4 = (ResolveInfo) r5.get(r3);
        if (r4.activityInfo == null) goto L12;
        if (r0.contains(r4.activityInfo.packageName) == true) goto L12;
        if (r4.handleAllWebDataURI == false) goto L12;
        r0.add(r4.activityInfo.packageName);
    L12:
        r3 = r3 + 1;
        goto L3
    L13:
        return r0;
    }

    public static boolean hasBrowserPreference(String r2, Context r3) {
        Intent r0 = new Intent();
        r0.setAction("android.intent.action.VIEW");
        r0.addCategory("android.intent.category.BROWSABLE");
        r0.setData(Uri.parse("http:"));
        r0.setPackage(r2);
        List<ResolveInfo> r4 = r3.getPackageManager().queryIntentActivities(r0, 0);
        if (r4 != null) goto L5;
        return false;
    L5:
        if (r4.size() == 0) goto L9;
        return true;
    L9:
        return false;
    }

    public static boolean isBrowserDefault(String r1, Context r2) {
        String r3 = r2.getPackageManager().getDefaultBrowserPackageNameAsUser(UserHandle.myUserId());
        if (r3 != null) goto L5;
    L7:
        return false;
    L5:
        if (r3.equals(r1) == false) goto L7;
        return true;
    }
}
