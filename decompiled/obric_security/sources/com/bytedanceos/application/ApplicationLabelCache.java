package com.bytedanceos.application;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import com.bytedanceos.securitycenter.SecurityCenterApplication;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class ApplicationLabelCache {
    private volatile boolean mInit;
    private AppListLoader.InterestingConfigChanges mInterestingConfigChanges;
    private ConcurrentHashMap<String, LabelEntry> mLabelCache;
    private PackageManager mPackageManager;

    private static class Holder {
        private static ApplicationLabelCache instance;

        private Holder() {
        }

        static /* synthetic */ ApplicationLabelCache access$100() {
            return instance;
        }

        static {
            instance = new ApplicationLabelCache(null);
        }
    }

    /* synthetic */ ApplicationLabelCache(AnonymousClass1 r1) {
        this();
    }

    static /* synthetic */ ConcurrentHashMap access$200(ApplicationLabelCache r0) {
        return r0.mLabelCache;
    }

    private ApplicationLabelCache() {
        this.mLabelCache = new ConcurrentHashMap();
        this.mInterestingConfigChanges = new AppListLoader.InterestingConfigChanges();
        this.mInit = false;
        this.mPackageManager = SecurityCenterApplication.getApplication().getPackageManager();
    }

    public static ApplicationLabelCache getInstance() {
        return Holder.access$100();
    }

    public void init(Context context) {
        if (this.mInit == true) goto L6;
        this.mInit = true;
        return;
    }

    public void reload(Context context) {
        if (this.mInterestingConfigChanges.applyNewConfig(context.getResources()) == false) goto L6;
        this.mLabelCache.clear();
        loadLabelCache(context.getApplicationContext());
        return;
    }

    public LabelEntry getLabelEntry(PackageManager pm, String packageName) {
        LabelEntry r0 = this.mLabelCache.get(packageName);
        if (r0 == null) goto L15;
        return r0;
    L15:
        ApplicationInfo r3 = pm.getApplicationInfo(packageName, 0);     // Catch: PackageManager.NameNotFoundException -> L12
        if (r3 == null) goto L18;
        LabelEntry r4 = getLabelEntryForApplication(r3);     // Catch: PackageManager.NameNotFoundException -> L12
        this.mLabelCache.put(packageName, r4);     // Catch: PackageManager.NameNotFoundException -> L11
    L10:
        return r4;
    L18:
        return r0;
    L19:
        return r0;
    }

    public String getLabel(Context context, String packageName) {
        if (packageName != null) goto L5;
        return null;
    L5:
        LabelEntry r1 = this.mLabelCache.get(packageName);
        if (r1 != null) goto L21;
        PackageManager r2 = context.getPackageManager();     // Catch: PackageManager.NameNotFoundException -> L16
        if (r2 != null) goto L11;
        return null;
    L11:
        ApplicationInfo r3 = r2.getApplicationInfo(packageName, 8704);     // Catch: PackageManager.NameNotFoundException -> L16
        if (r3 != null) goto L14;
        return null;
    L14:
        return ApplicationLabelUtils.loadLabel(r2, r3);
    L16:
        e = move-exception;
        e.printStackTrace();
        return null;
    L21:
        return r1.label;
    }

    public String getLabel(Context context, ApplicationInfo appInco) {
        if (appInco != null) goto L5;
        return null;
    L5:
        LabelEntry r2 = this.mLabelCache.get(appInco.packageName);
        if (r2 != null) goto L13;
        PackageManager r3 = context.getPackageManager();
        if (r3 != null) goto L12;
        return null;
    L12:
        return ApplicationLabelUtils.loadLabel(r3, appInco);
    L13:
        return r2.label;
    }

    private void loadLabelCache(final Context context) {
        AsyncTask.THREAD_POOL_EXECUTOR.execute(new AnonymousClass1(this, context));
    }

    public LabelEntry getLabelEntryForApplication(ApplicationInfo info) {
        return ApplicationLabelUtils.generatorLabelEntry(ApplicationLabelUtils.loadLabel(this.mPackageManager, info));
    }
}
