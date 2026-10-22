package com.android.settings.textboom;

import android.app.SmtPCUtils;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Handler;
import android.os.Looper;
import android.util.LruCache;
import com.android.settings.AppLockUtil;
import com.android.settings.Constants;
import com.android.settings.Utils;
import com.android.settings.applications.ApplicationLabelCache;
import com.android.settings.applications.LabelEntry;
import com.android.settings.textboom.db.OcrAppInfoDataHelper;
import com.android.settings.utils.NullSafe;
import com.obric.olog.OLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes2.dex */
public class AppInfoDataLoader {
    public static final Comparator<AppInfoEntry> ALPHA_COMPARATOR = null;
    public static final List<String> DEFAULT_APP_DISABLE_ORC = null;
    private static final int MAX_CACHE_SIZE = 4;
    private static final int MAX_THREAD_NUM = 3;
    private static final String TAG = "AppInfoDataLoader";
    public static final String TYPE_ALL_LAUNCHER_APP_AND_LOCK = "all_apps";
    private static HashSet<String> sAppWithLauncherCategory;
    public static volatile AppInfoDataLoader sInstance;
    public static final HashSet<String> sWhiteAppList = null;
    private long curId;
    private List<AppInfoEntry> mAppInfoList;
    protected LruCache<String, List<AppInfoEntry>> mCachedData;
    private Context mContext;
    private ExecutorService mExecutorService;
    protected Handler mHandler;
    private boolean mIsloading;
    protected List<DataLoadListener> mListeners;
    private LinkedList<String> mTaskKeys;

    public static class AppInfoEntry {
        public ApplicationInfo appInfo;
        public boolean canBoom;
        long id;
        public boolean isGame;
        public LabelEntry mLabelEntry;

        public AppInfoEntry() {
        }
    }

    static /* synthetic */ void access$000(AppInfoDataLoader r0, String r1) {
        r0.loadAndNotify(r1);
    }

    static /* synthetic */ Context access$100(AppInfoDataLoader r0) {
        return r0.mContext;
    }

    static {
        sAppWithLauncherCategory = new HashSet();
        HashSet<String> r0 = new HashSet();
        sWhiteAppList = r0;
        r0.add("com.cootek.smartinputv5.bytedance");
        r0.add("com.sohu.inputmethod.sogou.chuizi");
        r0.add("com.iflytek.inputmethod.bytedance");
        DEFAULT_APP_DISABLE_ORC = Collections.unmodifiableList(new ArrayList(Arrays.asList(new String[]{Constants.PKG_MUSIC, SmtPCUtils.PKG_CAMERA_2, "com.android.calendar", SmtPCUtils.PKG_CALCULATOR, "com.obric.recorder", "com.bytedanceos.clock", "com.bytedanceos.weather", "com.obric.filemanager", "com.android.providers.downloads", "com.bytedanceos.cloudsync", "com.obric.quicksearch", Constants.PKG_HAND_IN_HAND, AppLockUtil.PACKAGE_NAME, Constants.PKG_SECURITY, "com.obric.cleaner", "com.cootek.smartinputv5.bytedance", "com.sohu.inputmethod.sogou.chuizi", "com.iflytek.inputmethod.bytedance", "com.bytedanceos.voice", "com.bytedanceos.updater", "com.iflytek.speechsuite", Constants.PKG_PHONE_CHARGE, "com.bytedanceos.sidebar", Constants.PKG_WALLPAPER_PROVIDER, "org.codeaurora.snapcam", "com.bytedanceos.thinkboost"})));
        ALPHA_COMPARATOR = new AnonymousClass3();
    }

    private AppInfoDataLoader(Context r3) {
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mCachedData = new LruCache(4);
        this.mTaskKeys = new LinkedList();
        this.mAppInfoList = new ArrayList();
        this.curId = 0;
        this.mListeners = new ArrayList();
        this.mExecutorService = Executors.newFixedThreadPool(3);
        this.mContext = r3;
    }

    public static AppInfoDataLoader getInstance(Context r2) {
        if (sInstance != null) goto L16;
        monitor-enter(AppInfoDataLoader.class);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new AppInfoDataLoader(r2);     // Catch: Throwable -> L12
    L9:
        AppInfoDataLoader r3 = sInstance;     // Catch: Throwable -> L12
        monitor-exit(AppInfoDataLoader.class);     // Catch: Throwable -> L12
        return r3;
    L16:
        return sInstance;
    }

    public void removeDataLoadListener(DataLoadListener r2) {
        if (this.mListeners.remove(r2) == true) goto L5;
        return;
    L5:
        if (this.mListeners.isEmpty() == false) goto L9;
        onRemovedLastListener();
        return;
    }

    public void addDataLoadListener(DataLoadListener r2) {
        if (this.mListeners.isEmpty() == false) goto L6;
        this.mListeners.add(r2);
        return;
    L6:
        if (this.mListeners.contains(r2) == true) goto L10;
        this.mListeners.add(r2);
        return;
    }

    public void clearCache() {
        this.mCachedData.evictAll();
    }

    protected List<AppInfoEntry> getCache(String r1) {
        return this.mCachedData.get(r1);
    }

    protected List<AppInfoEntry> removeCache(String r1) {
        return this.mCachedData.remove(r1);
    }

    protected void putCache(String r1, List<AppInfoEntry> r2) {
        this.mCachedData.put(r1, r2);
    }

    protected void onRemovedLastListener() {
        OLog.d(TAG, "onRemovedLastListener ");
        clearCache();
    }

    private void loadAndNotify(String r2) {
        List<AppInfoEntry> r0 = loadInBackground(r2);
        putCache(r2, r0);
        notifyOnMainThread(r2, r0);
    }

    protected void notifyOnMainThread(final String r3, final List<AppInfoEntry> r4) {
        this.mHandler.post(new AnonymousClass1(this, r3, r4));
    }

    protected void onDataLoaded(DataLoadListener r1, String r2, List<AppInfoEntry> r3) {
        r1.onDataLoaded(r2, r3);
    }

    public void requestData(String r3) {
        OLog.d(TAG, "requestData key " + r3 + "  isLoading " + this.mIsloading);
        if (this.mIsloading == false) goto L6;
        return;
    L6:
        if (this.mTaskKeys.contains(r3) == false) goto L8;
        return;
    L8:
        this.mTaskKeys.addLast(r3);
        tryLoad();
    }

    protected void tryLoad() {
        if (this.mTaskKeys.isEmpty() == false) goto L5;
        return;
    L5:
        final String r0 = this.mTaskKeys.removeFirst();
        List<AppInfoEntry> r1 = getCache(r0);
        if (r1 == null) goto L9;
        notifyOnMainThread(r0, r1);
        tryLoad();
        return;
    L9:
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) goto L11;
        this.mExecutorService.submit(new AnonymousClass2(this, r0));
        return;
    L11:
        loadAndNotify(r0);
        tryLoad();
    }

    protected List<AppInfoEntry> loadInBackground(String r11) {
        this.mIsloading = true;
        OLog.d(TAG, "loadInBackground start " + r11);
        Intent r12 = new Intent("android.intent.action.MAIN", null);
        r12.addCategory("android.intent.category.LAUNCHER");
        List<ResolveInfo> r13 = ((PackageManager) NullSafe.nonNull(this.mContext.getPackageManager())).queryIntentActivities(r12, 0);
        sAppWithLauncherCategory.clear();
        Iterator<ResolveInfo> r14 = r13.iterator();
    L4:
        if (r14.hasNext() == false) goto L6;
        sAppWithLauncherCategory.add(r14.next().activityInfo.packageName);
        goto L4
    L6:
        List<ApplicationInfo> r15 = this.mContext.getPackageManager().getInstalledApplications(8704);
        this.mAppInfoList.clear();
        Iterator<ApplicationInfo> r16 = r15.iterator();
        boolean r2 = false;
    L8:
        if (r16.hasNext() == false) goto L20;
        ApplicationInfo r4 = r16.next();
        if (filterAppInfo(r4) == true) goto L8;
        AppInfoEntry r5 = new AppInfoEntry();
        long r6 = this.curId;
        this.curId = 1 + r6;
        r5.id = r6;
        r5.appInfo = r4;
        r5.isGame = Utils.isGame(r4);
        r5.mLabelEntry = ApplicationLabelCache.getInstance().getLabelEntry(this.mContext, r4.packageName);
        int r7 = OcrAppInfoDataHelper.boomStatus(this.mContext, r4.packageName);
        if (r7 != 1) goto L15;
        boolean r8 = true;
    L16:
        r5.canBoom = r8;
        if (r7 != (-1)) goto L19;
        r5.canBoom = !DEFAULT_APP_DISABLE_ORC.contains(r4.packageName);
        OcrAppInfoDataHelper.insertAppInfo(this.mContext, r5);
        r2 = true;
    L19:
        this.mAppInfoList.add(r5);
        goto L8
    L15:
        r8 = false;
        goto L16
    L20:
        if (r2 == false) goto L22;
        Utils.sendIntentToAndroid(this.mContext);
    L22:
        Collections.sort(this.mAppInfoList, ALPHA_COMPARATOR);
        OLog.d(TAG, "end size " + this.mAppInfoList.size());
        this.mIsloading = false;
        return this.mAppInfoList;
    }

    private boolean filterAppInfo(ApplicationInfo r5) {
        if (sWhiteAppList.contains(r5.packageName) == false) goto L6;
        return false;
    L6:
        if (r5.enabled == true) goto L11;
        if (r5.enabledSetting == 3) goto L11;
    L17:
        return true;
    L11:
        if (Utils.isSystemPackage(this.mContext, r5.packageName) == true) goto L15;
        if (r5.packageName.startsWith("com.bytedanceos.") == true) goto L15;
        return false;
    L15:
        if (sAppWithLauncherCategory.contains(r5.packageName) == false) goto L17;
        return false;
    }

    public void syncStatusToDb(final List<AppInfoEntry> r3, final HashMap<String, Boolean> r4) {
        if (r3 == null) goto L10;
        if (r4 == null) goto L11;
        OLog.d(TAG, "syncStatusToDb changedList " + r4.size() + " applist " + r3.size());
        if (r4.size() != 0) goto L8;
        return;
    L8:
        this.mExecutorService.submit(new AnonymousClass4(this, r3, r4));
        return;
    L11:
        return;
    }
}
