package com.android.settings;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import com.android.settings.applications.PreferredSettingsUtils;
import com.obric.olog.OLog;
import java.util.List;
import obric.time.HttpHeadTimeFetcher;

/* JADX INFO: loaded from: classes2.dex */
public class DefaultBrowserSetter implements Runnable {
    private static final String TAG = "DefaultBrowserSetter";
    private Context mContext;

    public static void start(Context r1) {
        ExecutorManager.execute(new DefaultBrowserSetter(r1.getApplicationContext()));
    }

    private DefaultBrowserSetter(Context r1) {
        this.mContext = r1;
    }

    @Override // java.lang.Runnable
    public void run() {
        PackageManager r0 = this.mContext.getPackageManager();
        Intent r1 = new Intent();
        r1.setAction("android.intent.action.VIEW");
        r1.addCategory("android.intent.category.DEFAULT");
        ComponentName r5 = null;
        r1.setDataAndType(Uri.parse("http://*"), null);
        ResolveInfo r4 = r0.resolveActivity(r1, 65536);
        if (r4 != null) goto L5;
    L29:
        android.provider.Settings.Global.putInt(this.mContext.getContentResolver(), "default_browser_setting_done", 1);
        return;
    L5:
        if ("com.android.browser.BrowserActivity".equals(r4.activityInfo.name) == true) goto L29;
        if (PreferredSettingsUtils.COMPONENT_RESOLVERACTIVITY.equals(r4.activityInfo.name) == true) goto L9;
        r0.clearPackagePreferredActivities(r4.activityInfo.packageName);
    L9:
        IntentFilter r6 = new IntentFilter("android.intent.action.VIEW");
        r6.addCategory("android.intent.category.DEFAULT");
        r6.addDataScheme("http");
        r6.addDataScheme(HttpHeadTimeFetcher.FETCHER_TYPE);
        r6.addDataAuthority(ApnEditor.APN_TYPE_ALL, null);
        List<ResolveInfo> r2 = r0.queryIntentActivities(r1, 65600);
        if (r2 != null) goto L12;
        return;
    L12:
        int r3 = r2.size();
        ComponentName[] r7 = new ComponentName[r3];
        int r8 = 0;
        int r9 = 0;
        int r10 = 0;
    L13:
        if (r9 >= r3) goto L21;
        ResolveInfo r11 = r2.get(r9);
        if ("com.android.browser".equals(r11.activityInfo.packageName) == false) goto L17;
        r5 = new ComponentName(r11.activityInfo.packageName, r11.activityInfo.name);
    L17:
        r7[r9] = new ComponentName(r11.activityInfo.packageName, r11.activityInfo.name);
        if (r11.match <= r10) goto L20;
        r10 = r11.match;
    L20:
        r9 = r9 + 1;
        goto L13
    L21:
        if (r5 == null) goto L23;
        r0.addPreferredActivity(r6, r10, r7, r5);
    L23:
        if (r8 >= r3) goto L29;
        ComponentName r12 = r7[r8];
        if (r12 == null) goto L27;
        OLog.i(TAG, "activityInfo.packageName:" + r12.getPackageName() + ",activityInfo.name:" + r12.getClassName());
    L28:
        r8 = r8 + 1;
        goto L23
    L27:
        OLog.i(TAG, "componentName = null");
        goto L28
    }
}
