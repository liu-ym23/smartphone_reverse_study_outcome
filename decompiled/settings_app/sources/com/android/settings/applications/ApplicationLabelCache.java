package com.android.settings.applications;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Looper;
import android.os.MessageQueue;
import com.android.settings.ExecutorManager;
import com.android.settings.SettingsApplication;
import com.obric.olog.OLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class ApplicationLabelCache {
    private static final String TAG = "ApplicationLabelCache";
    private InterestingConfigChanges mInterestingConfigChanges;
    private ConcurrentHashMap<String, LabelEntry> mLabelCache;

    private static class Holder {
        private static ApplicationLabelCache instance;

        private Holder() {
        }

        static /* synthetic */ ApplicationLabelCache access$200() {
            return instance;
        }

        static {
            instance = new ApplicationLabelCache(null);
        }
    }

    private static class LoadLabelCacheIdler implements MessageQueue.IdleHandler {
        private LoadLabelCacheIdler() {
        }

        static /* synthetic */ void access$300() {
            submitToQueue();
        }

        private static void submitToQueue() {
            Looper.myQueue().addIdleHandler(new LoadLabelCacheIdler());
        }

        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            Context r2 = SettingsApplication.getContext();
            if (r2 != null) goto L6;
            OLog.d(ApplicationLabelCache.TAG, "SettingsApplication context is null !");
            return true;
        L6:
            OLog.d(ApplicationLabelCache.TAG, "queueIdle start load label cache");
            ApplicationLabelCache.access$100(ApplicationLabelCache.getInstance(), r2);
            return false;
        }
    }

    /* synthetic */ ApplicationLabelCache(AnonymousClass1 r1) {
        this();
    }

    static /* synthetic */ void access$100(ApplicationLabelCache r0, Context r1) {
        r0.loadLabelCache(r1);
    }

    static /* synthetic */ ConcurrentHashMap access$400(ApplicationLabelCache r0) {
        return r0.mLabelCache;
    }

    static /* synthetic */ void access$500(ApplicationLabelCache r0, Context r1) {
        r0.loadLabelCacheSync(r1);
    }

    private ApplicationLabelCache() {
        this.mLabelCache = new ConcurrentHashMap();
        this.mInterestingConfigChanges = new InterestingConfigChanges();
        OLog.d(TAG, " init<ApplicationLabelCache>");
    }

    public static ApplicationLabelCache getInstance() {
        return Holder.access$200();
    }

    public synchronized void init() {
        monitor-enter(this);
        OLog.d(TAG, "init");     // Catch: Throwable -> L6
        LoadLabelCacheIdler.access$300();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void reload(Context r2) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.mInterestingConfigChanges.applyNewConfig(r2.getResources()) == false) goto L6;
        OLog.d(TAG, "reload");     // Catch: Throwable -> L8
        LoadLabelCacheIdler.access$300();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
    }

    public LabelEntry getLabelEntry(Context r4, String r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        LabelEntry r0 = this.mLabelCache.get(r5);
        if (r0 != null) goto L14;
        r0 = getLabelEntryForApplication(r4, r4.getPackageManager().getApplicationInfo(r5, 8704));     // Catch: PackageManager.NameNotFoundException -> L9
        this.mLabelCache.put(r5, r0);     // Catch: PackageManager.NameNotFoundException -> L9
        return r0;
    L9:
        e = move-exception;
        e.printStackTrace();
        return r0;
    L14:
        return r0;
    }

    public LabelEntry getLabelEntryWithoutPinyin(Context r4, String r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        LabelEntry r0 = this.mLabelCache.get(r5);
        if (r0 != null) goto L14;
        return getLabelEntryForApplicationWithoutPinyin(r4, r4.getPackageManager().getApplicationInfo(r5, 8704));
    L9:
        e = move-exception;
        e.printStackTrace();
        return r0;
    L14:
        return r0;
    }

    public String getLabel(Context r3, String r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        LabelEntry r2 = this.mLabelCache.get(r4);
        if (r2 != null) goto L15;
        return ApplicationLabelUtils.loadLabel(r3, r3.getPackageManager().getApplicationInfo(r4, 8704));
    L10:
        e = move-exception;
        e.printStackTrace();
        return null;
    L15:
        return r2.label;
    }

    public String getLabel(Context r2, ApplicationInfo r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        LabelEntry r1 = this.mLabelCache.get(r3.packageName);
        if (r1 == null) goto L9;
        return r1.label;
    L9:
        return ApplicationLabelUtils.loadLabel(r2, r3);
    }

    private void loadLabelCache(final Context r2) {
        ExecutorManager.execute(new AnonymousClass1(this, r2));
    }

    private void loadLabelCacheSync(Context r8) {
        OLog.d(TAG, "loadLabelCache start");
        long r2 = System.currentTimeMillis();
        List<ApplicationInfo> r0 = r8.getPackageManager().getInstalledApplications(8704);     // Catch: RuntimeException -> L17
        if (this.mLabelCache.isEmpty() == false) goto L10;
        Iterator<ApplicationInfo> r1 = r0.iterator();
    L8:
        if (r1.hasNext() == false) goto L15;
        ApplicationInfo r4 = r1.next();
        this.mLabelCache.put(r4.packageName, getLabelEntryForApplication(r8, r4));
    L15:
        OLog.d(TAG, "loadLabelCache end, use time: " + (System.currentTimeMillis() - r2));
        return;
    L10:
        ConcurrentHashMap r5 = new ConcurrentHashMap();
        Iterator<ApplicationInfo> r3 = r0.iterator();
    L12:
        if (r3.hasNext() == false) goto L14;
        ApplicationInfo r6 = r3.next();
        r5.put(r6.packageName, getLabelEntryForApplication(r8, r6));
        goto L12
    L14:
        this.mLabelCache.clear();
        this.mLabelCache.putAll(r5);
    L17:
        e = move-exception;
        e.printStackTrace();
    }

    public LabelEntry getLabelEntryForApplication(Context r1, ApplicationInfo r2) {
        String r0 = ApplicationLabelUtils.loadLabel(r1, r2);
        return ApplicationLabelUtils.generatorLabelEntry(r1, r2.packageName, r0);
    }

    public LabelEntry getLabelEntryForApplicationWithoutPinyin(Context r1, ApplicationInfo r2) {
        String r0 = ApplicationLabelUtils.loadLabel(r1, r2);
        return new LabelEntry.Builder().setPacakgeName(r2.packageName).setLabel(r0).setLabelPinyin("").setFirstLetters("").build();
    }
}
