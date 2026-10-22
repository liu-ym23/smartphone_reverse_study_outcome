package com.android.settings;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import bytedanceos.api.PackageManagerSmt;
import com.android.settings.applications.PreferredSettingsUtils;
import com.obric.olog.OLog;
import java.util.List;
import settings.PreferredActivityChooseUtils;

/* JADX INFO: loaded from: classes2.dex */
class DefaultFileSetter implements Runnable {
    private PreferredSettingsUtils.Category mCategory;
    private PreferredActivityChooseUtils mChooseUtils;
    private Context mContext;
    private StatusListener mListener;
    private List<String> mMimeTypes;
    private PackageManager mPm;

    public interface StatusListener {
        void onCompleted();
    }

    private DefaultFileSetter(Context r2) {
        this.mContext = r2;
        this.mPm = r2.getPackageManager();
        this.mChooseUtils = new PreferredActivityChooseUtils(r2);
    }

    private DefaultFileSetter(Context r1, List<String> r2, PreferredSettingsUtils.Category r3) {
        this(r1);
        this.mCategory = r3;
        this.mMimeTypes = r2;
    }

    public static void start(Context r1, List<String> r2, PreferredSettingsUtils.Category r3, StatusListener r4) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r2.isEmpty() == true) goto L12;
        DefaultFileSetter r0 = new DefaultFileSetter(r1, r2, r3);
        r0.setStatusListener(r4);
        if (r3 != null) goto L8;
        boolean r5 = true;
    L9:
        ExecutorManager.execute(r0, r5);
        return;
    L8:
        r5 = false;
        goto L9
    }

    public static void start(Context r1, List<String> r2, PreferredSettingsUtils.Category r3) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r2.isEmpty() == true) goto L12;
        DefaultFileSetter r0 = new DefaultFileSetter(r1, r2, r3);
        if (r3 != null) goto L8;
        boolean r4 = true;
    L9:
        ExecutorManager.execute(r0, r4);
        return;
    L8:
        r4 = false;
        goto L9
    }

    @Override // java.lang.Runnable
    public void run() {
        this.mMimeTypes.stream().filter(new DefaultFileSetter$$ExternalSyntheticLambda0()).forEach(new DefaultFileSetter$$ExternalSyntheticLambda1(this));
        StatusListener r2 = this.mListener;
        if (r2 == null) goto L6;
        r2.onCompleted();
        return;
    }

    static /* synthetic */ boolean lambda$run$0(String r0) {
        return !TextUtils.isEmpty(r0);
    }

    /* JADX INFO: renamed from: lambda$run$1$com-android-settings-DefaultFileSetter, reason: not valid java name */
    /* synthetic */ void m120lambda$run$1$comandroidsettingsDefaultFileSetter(String r2) {
        setupDefaultAppByMimeType(this.mCategory, r2);
    }

    private void setStatusListener(StatusListener r1) {
        this.mListener = r1;
    }

    private void setupDefaultAppByMimeType(PreferredSettingsUtils.Category r13, String r14) {
        IntentFilter r1 = PreferredSettingsUtils.getIntentFilterForType(r14);
        if (r1 != null) goto L5;
        return;
    L5:
        Intent r2 = PreferredActivityChooseUtils.makeIntentByFilter(r1);
        int r4 = 0;
        this.mChooseUtils.generateData(r2, false);
        List<ResolveInfo> r3 = this.mChooseUtils.getResolveInfoList();
        if (r3 != null) goto L8;
        return;
    L8:
        if (r3.isEmpty() == true) goto L38;
        ComponentName[] r5 = new ComponentName[r3.size()];
        ComponentName r7 = null;
        int r6 = 0;
    L12:
        if (r4 >= r3.size()) goto L20;
        ResolveInfo r8 = r3.get(r4);
        String r9 = r8.activityInfo.packageName;
        String r10 = r8.activityInfo.name;
        if (r7 != null) goto L16;
        r7 = getPreferredActivity(r14, r9, r13, r10);
    L16:
        r5[r4] = new ComponentName(r9, r10);
        if (r8.match <= r6) goto L19;
        r6 = r8.match;
    L19:
        r4 = r4 + 1;
        goto L12
    L20:
        if (r7 != null) goto L31;
        return;
    L31:
        PackageManagerSmt r15 = PackageManagerSmt.getInstance();     // Catch: NullPointerException -> L27
        if (r15 == null) goto L25;
        r15.clearPreferredActivities(this.mPm, r2);     // Catch: NullPointerException -> L27
        this.mPm.addPreferredActivity(r1, r6, r5, r7);     // Catch: NullPointerException -> L27
    L30:
        return;
    L25:
        OLog.e("DefaultFileSetter", "setupDefaultAppByMimeType failed! packageManagerSmt is null");     // Catch: NullPointerException -> L27
    L27:
        e = move-exception;
        OLog.e("DefaultFileSetter", "Caught NullPointerException: " + e.getMessage());
        return;
    }

    private ComponentName getPreferredActivity(String r1, String r2, PreferredSettingsUtils.Category r3, String r4) {
        if (r3 != null) goto L14;
        if (Constants.PKG_MUSIC.equals(r2) == true) goto L12;
        if (Constants.PKG_VIDEO.equals(r2) == true) goto L12;
        if (Constants.PKG_WPS.equals(r2) == true) goto L12;
        if ("com.android.gallery3d".equals(r2) == true) goto L12;
        return null;
    L12:
        return new ComponentName(r2, r4);
    L14:
        if ("text/html".equals(r1) == false) goto L20;
        if ("com.android.browser".equals(r2) == true) goto L18;
        return null;
    L18:
        return new ComponentName("com.android.browser", r4);
    L20:
        if (PreferredSettingsUtils.getDefaultAppByCategory(r3).equals(r2) == true) goto L22;
        return null;
    L22:
        return new ComponentName(r2, r4);
    }
}
