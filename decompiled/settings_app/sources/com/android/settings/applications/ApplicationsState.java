package com.android.settings.applications;

import android.app.ActivityManager;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.LauncherApps;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageStats;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.ServiceManager;
import android.os.SystemClock;
import android.os.Trace;
import android.os.UserHandle;
import android.os.UserManager;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.SparseArray;
import com.GlobalProxyLancet;
import com.android.settings.MultiSDKAdapter;
import com.android.settings.NotificationDisplayDetailsActivity;
import com.android.settings.R;
import com.android.settings.SettingsApplication;
import com.android.settings.SettingsInitialize;
import com.android.settings.Utils;
import com.android.settings.accounts.obric.ObricIconUtils;
import com.android.settings.utils.NullSafe;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Insert;

/* JADX INFO: loaded from: classes2.dex */
public class ApplicationsState {
    public static final AppFilter ALL_ENABLED_FILTER = null;
    public static final Comparator<AppEntry> ALPHA_COMPARATOR = null;
    public static final AppFilter COMMON_APP_FILTER = null;
    static final boolean DEBUG = false;
    static final boolean DEBUG_LOCKING = false;
    private static final String DESKTOP_SYSTEMUI_PACKAGE = "com.android.desktop.systemui";
    public static final AppFilter DISABLED_FILTER = null;
    public static final Comparator<AppEntry> EXTERNAL_SIZE_COMPARATOR = null;
    private static final String FEEDBACK_APP = "com.obric.feedback";
    private static final String FEEDBACK_ENTRY = "com.obric.feedbackserviceproject";
    public static final AppFilter FILTER_INTERACT_ACROSS_PROFILES = null;
    public static final Comparator<AppEntry> FREQUENCY_COMPARATOR = null;
    public static final Comparator<AppEntry> INSTALL_TIME_COMPARATOR = null;
    public static final Comparator<AppEntry> INTERNAL_SIZE_COMPARATOR = null;
    public static final int INTERVAL_YEARLY = 3;
    private static final int INTRINSIC_WIDTH = 96;
    private static final String IUsageStatsStubClassName = "com.android.internal.app.IUsageStats$Stub";
    public static final AppFilter ON_SD_CARD_FILTER = null;
    public static final AppFilter PERSONAL_FILTER = null;
    static final Pattern REMOVE_DIACRITICALS_PATTERN = null;
    public static final Comparator<AppEntry> SIZE_COMPARATOR = null;
    static final int SIZE_INVALID = -2;
    static final int SIZE_UNKNOWN = -1;
    public static final AppFilter SYSTEM_COMPONENT_FILTER = null;
    static final String TAG = "ApplicationsState";
    public static final AppFilter THIRD_PARTY_FILTER = null;
    public static final AppFilter THRID_LAUNCHABLE_APP_FILTER = null;
    public static final AppFilter WORK_FILTER = null;
    static boolean mShowDoppelgangerApp;
    private static volatile HashSet<String> sAppWithLauncherCategory;
    static ApplicationsState sInstance;
    static final Object sLock = null;
    public static HashSet<String> sWhiteAppList;
    final ArrayList<Session> mActiveSessions;
    final ArrayList<AppEntry> mAppEntries;
    private HashMap<String, Long> mAppUsageTimeMap;
    List<ApplicationInfo> mApplications;
    final BackgroundHandler mBackgroundHandler;
    List<String> mCommonAppWhiteList;
    final Context mContext;
    String mCurComputingSizePkg;
    long mCurId;
    final HashMap<String, AppEntry> mEntriesMap;
    final InterestingConfigChanges mInterestingConfigChanges;
    private LauncherApps.Callback mLauncherCallback;
    final MainHandler mMainHandler;
    PackageIntentReceiver mPackageIntentReceiver;
    final PackageManager mPm;
    final ArrayList<Session> mRebuildingSessions;
    volatile boolean mResumed;
    final int mRetrieveFlags;
    final ArrayList<Session> mSessions;
    boolean mSessionsChanged;
    final HandlerThread mThread;
    final UserManager mUm;
    final SparseArray<HashMap<String, AppEntry>> mUserIdEntriesMap;

    public static class AppEntry extends SizeInfo {
        File apkFile;
        File dataFile;
        long externalSize;
        String externalSizeStr;
        public Drawable icon;
        public final long id;
        boolean ignoreLabelPinyin;
        public ApplicationInfo info;
        long internalSize;
        String internalSizeStr;
        private boolean isDirty;
        public boolean isDoppleganger;
        public boolean isWork;
        public String label;
        public LabelEntry mLabelEntry;
        boolean mounted;
        String normalizedLabel;
        long size;
        long sizeLoadStart;
        boolean sizeStale;
        String sizeStr;
        public long usageTime;

        static /* synthetic */ boolean access$800(AppEntry r0) {
            return r0.isDirty;
        }

        String getNormalizedLabel() {
            String r0 = this.normalizedLabel;
            if (r0 == null) goto L5;
            return r0;
        L5:
            String r1 = ApplicationsState.normalize(this.label);
            this.normalizedLabel = r1;
            return r1;
        }

        public AppEntry(Context r4, ApplicationInfo r5, long r6) {
            this.ignoreLabelPinyin = false;
            this.isDoppleganger = false;
            this.isWork = false;
            if (r5.sourceDir == null) goto L6;
            this.apkFile = new File(r5.sourceDir);
        L6:
            if (r5.dataDir == null) goto L8;
            this.dataFile = new File(r5.dataDir);
        L8:
            this.id = r6;
            this.info = r5;
            this.size = -1;
            this.sizeStale = true;
            this.isDirty = false;
            ensureLabel(r4);
        }

        public AppEntry(Context r4, ApplicationInfo r5, long r6, boolean r8) {
            this.ignoreLabelPinyin = false;
            this.isDoppleganger = false;
            this.isWork = false;
            if (r5.sourceDir == null) goto L6;
            this.apkFile = new File(r5.sourceDir);
        L6:
            if (r5.dataDir == null) goto L8;
            this.dataFile = new File(r5.dataDir);
        L8:
            this.id = r6;
            this.info = r5;
            this.size = -1;
            this.sizeStale = true;
            this.isDirty = false;
            this.ignoreLabelPinyin = r8;
            if (r8 == true) goto L11;
            ensureLabel(r4);
            return;
        L11:
            ensureLabelWithoutPinyin(r4);
        }

        public AppEntry(Context r3, ApplicationInfo r4) {
            this.ignoreLabelPinyin = false;
            this.isDoppleganger = false;
            this.isWork = false;
            this.id = 2147483647L;
            this.info = r4;
            this.isDirty = false;
        }

        void ensureLabel(Context r3) {
            if (this.label != null) goto L5;
        L6:
            File r0 = this.apkFile;
            if (r0 != null) goto L9;
        L11:
            boolean r1 = false;
        L12:
            this.mounted = r1;
            LabelEntry r2 = ApplicationLabelCache.getInstance().getLabelEntry(r3, this.info.packageName);
            if (r2 == null) goto L15;
            this.label = r2.label;
            return;
        L15:
            this.label = ApplicationLabelUtils.loadLabel(r3, this.info);
            return;
        L9:
            if (r0.exists() == false) goto L11;
            r1 = true;
            goto L12
        L5:
            if (this.mounted == false) goto L6;
        }

        void ensureLabelWithoutPinyin(Context r3) {
            if (this.label != null) goto L5;
        L6:
            File r0 = this.apkFile;
            if (r0 != null) goto L9;
        L11:
            boolean r1 = false;
        L12:
            this.mounted = r1;
            LabelEntry r2 = ApplicationLabelCache.getInstance().getLabelEntryWithoutPinyin(r3, this.info.packageName);
            if (r2 == null) goto L15;
            this.label = r2.label;
            return;
        L15:
            this.label = ApplicationLabelUtils.loadLabel(r3, this.info);
            return;
        L9:
            if (r0.exists() == false) goto L11;
            r1 = true;
            goto L12
        L5:
            if (this.mounted == false) goto L6;
        }

        public void ensureLabelEntry(Context r3) {
            LabelEntry r0 = ApplicationLabelCache.getInstance().getLabelEntry(r3, this.info.packageName);
            this.mLabelEntry = r0;
            if (r0 != null) goto L6;
            this.mLabelEntry = ApplicationLabelUtils.generatorLabelEntry(r3, this.info.packageName, this.label);
            return;
        }

        public boolean ensureIconLocked(Context r7, PackageManager r8) {
            if (this.icon != null) goto L5;
        L29:
            File r0 = this.apkFile;
            if (r0 != null) goto L32;
        L52:
            this.mounted = false;
            this.icon = r7.getResources().getDrawable(R.drawable.sym_app_on_sd_unavailable_icon);
        L53:
            return false;
        L32:
            if (r0.exists() == false) goto L52;
            this.icon = this.info.loadIcon(r8);
            int r9 = UserHandle.getUserId(this.info.uid);
            if (r9 != 10) goto L39;
            if (this.icon == null) goto L39;
            this.isDoppleganger = true;
            this.icon = ObricIconUtils.getDrawable(this.info);
        L39:
            if (this.isWork == false) goto L43;
            Drawable r1 = this.icon;
            if (r1 == null) goto L43;
            this.icon = r8.getUserBadgedIcon(r1, new UserHandle(r9));
        L43:
            Drawable r10 = this.icon;
            if (r10 != null) goto L46;
        L50:
            this.isDirty = false;
            return true;
        L46:
            if (r10.getIntrinsicWidth() <= 96) goto L50;
            Drawable r11 = this.icon;
            if ((r11 instanceof BitmapDrawable) == false) goto L50;
            this.icon = new BitmapDrawable(null, Utils.resizeAppIcon(((BitmapDrawable) r11).getBitmap()));
            goto L50
        L5:
            if (this.isDirty == true) goto L29;
            if (this.mounted == true) goto L53;
            File r12 = this.apkFile;
            if (r12 == null) goto L53;
            if (r12.exists() == false) goto L53;
            this.mounted = true;
            this.icon = (Drawable) NullSafe.nonNull(this.info.loadIcon(r8));
            int r13 = UserHandle.getUserId(this.info.uid);
            if (r13 != 10) goto L19;
            if (this.icon == null) goto L19;
            this.isDoppleganger = true;
            this.icon = ObricIconUtils.getDrawable(this.info);
        L19:
            if (this.isWork == false) goto L23;
            Drawable r2 = this.icon;
            if (r2 == null) goto L23;
            this.icon = r8.getUserBadgedIcon(r2, new UserHandle(r13));
        L23:
            Drawable r14 = this.icon;
            if ((r14 instanceof BitmapDrawable) == true) goto L26;
        L28:
            return true;
        L26:
            if (r14.getIntrinsicWidth() <= 96) goto L28;
            this.icon = new BitmapDrawable(null, Utils.resizeAppIcon(((BitmapDrawable) this.icon).getBitmap()));
            goto L28
        }

        public void setDirty(boolean r1) {
            this.isDirty = r1;
        }
    }

    public interface AppFilter {
        boolean filterApp(ApplicationInfo r1);

        void init();
    }

    class BackgroundHandler extends Handler {
        static final int MSG_LOAD_ENTRIES = 2;
        static final int MSG_LOAD_ICONS = 3;
        static final int MSG_LOAD_SIZES = 4;
        static final int MSG_REBUILD_LIST = 1;
        boolean mRunning;
        final MultiSDKAdapter.PackageStatsObserverEx mStatsObserver;
        final /* synthetic */ ApplicationsState this$0;

        BackgroundHandler(ApplicationsState r1, Looper r2) {
            this.this$0 = r1;
            super(r2);
            this.mStatsObserver = new AnonymousClass1(this);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r12) {
            SparseArray<HashMap<String, AppEntry>> r0 = this.this$0.mUserIdEntriesMap;
            monitor-enter(r0);
        L120:
            th = move-exception;
            throw th;
        L5:
            if (this.this$0.mRebuildingSessions.size() <= 0) goto L7;
            ArrayList r1 = new ArrayList(this.this$0.mRebuildingSessions);     // Catch: Throwable -> L120
            this.this$0.mRebuildingSessions.clear();     // Catch: Throwable -> L120
        L8:
            monitor-exit(r0);     // Catch: Throwable -> L120
            int r2 = 0;
            if (r1 == null) goto L15;
            int r3 = 0;
        L13:
            if (r3 >= r1.size()) goto L15;
            ((Session) r1.get(r3)).handleRebuildList();
            r3 = r3 + 1;
        L15:
            int r13 = r12.what;
            if (r13 != 2) goto L18;
            SparseArray<HashMap<String, AppEntry>> r14 = this.this$0.mUserIdEntriesMap;
            monitor-enter(r14);
            int r5 = 0;
        L123:
        L117:
            th = move-exception;
            throw th;
        L103:
            if (r2 >= this.this$0.mApplications.size()) goto L112;
            if (r5 >= 6) goto L112;
            if (this.mRunning == true) goto L108;
            this.mRunning = true;     // Catch: Throwable -> L117
            this.this$0.mMainHandler.sendMessage(this.this$0.mMainHandler.obtainMessage(6, 1));     // Catch: Throwable -> L117
        L108:
            ApplicationInfo r6 = this.this$0.mApplications.get(r2);     // Catch: Throwable -> L117
            if (this.this$0.mUserIdEntriesMap.get(UserHandle.getUserId(r6.uid)).get(r6.packageName) != null) goto L111;
            r5 = r5 + 1;     // Catch: Throwable -> L117
            this.this$0.getEntryLocked(r6);     // Catch: Throwable -> L117
        L111:
            r2 = r2 + 1;     // Catch: Throwable -> L117
        L112:
            monitor-exit(r14);     // Catch: Throwable -> L117
            if (r5 < 6) goto L115;
            sendEmptyMessage(2);
            return;
        L115:
            sendEmptyMessage(3);
            return;
        L18:
            if (r13 == 3) goto L63;
            if (r13 != 4) goto L149;
            SparseArray<HashMap<String, AppEntry>> r15 = this.this$0.mUserIdEntriesMap;
            monitor-enter(r15);
        L60:
            th = move-exception;
            throw th;
        L24:
            if (this.this$0.mCurComputingSizePkg == null) goto L27;
            monitor-exit(r15);     // Catch: Throwable -> L60
            return;
        L27:
            long r4 = SystemClock.uptimeMillis();     // Catch: Throwable -> L60
            int r7 = 0;
        L29:
            if (r7 >= this.this$0.mAppEntries.size()) goto L56;
            AppEntry r8 = this.this$0.mAppEntries.get(r7);     // Catch: Throwable -> L60
            if (r8.size == (-1)) goto L35;
            if (r8.sizeStale == true) goto L35;
        L54:
            r7 = r7 + 1;     // Catch: Throwable -> L60
        L35:
            if (r8.sizeLoadStart == 0) goto L39;
            if (r8.sizeLoadStart >= (r4 - TraceStatsConsts.PAGE_LOAD_MAX_LIMIT_MS)) goto L54;
        L39:
            if (this.mRunning == true) goto L41;
            this.mRunning = true;     // Catch: Throwable -> L60
            this.this$0.mMainHandler.sendMessage(this.this$0.mMainHandler.obtainMessage(6, 1));     // Catch: Throwable -> L60
        L41:
            r8.sizeLoadStart = r4;     // Catch: Throwable -> L60
            if (ApplicationsState.FEEDBACK_ENTRY.equals(r8.info.packageName) == false) goto L50;
            this.this$0.mCurComputingSizePkg = ApplicationsState.FEEDBACK_ENTRY;     // Catch: Throwable -> L45
            ApplicationInfo r9 = this.this$0.mPm.getApplicationInfo("com.obric.feedback", 0);     // Catch: Throwable -> L45
            MultiSDKAdapter.getPackageSizeInfoAsUser(this.this$0.mContext, r9, UserHandle.getUserId(r9.uid), this.mStatsObserver);     // Catch: Throwable -> L45
        L47:
            monitor-exit(r15);     // Catch: Throwable -> L60
            return;
        L45:
            th = move-exception;
            OLog.e(ApplicationsState.TAG, "getApplicationInfo err=" + th);     // Catch: Throwable -> L60
            goto L47
        L50:
            if (Utils.isPackageInstalled(this.this$0.mContext, r8.info.packageName) == false) goto L54;
            this.this$0.mCurComputingSizePkg = r8.info.packageName;     // Catch: Throwable -> L60
            MultiSDKAdapter.getPackageSizeInfoAsUser(this.this$0.mContext, r8.info, UserHandle.getUserId(r8.info.uid), this.mStatsObserver);     // Catch: Throwable -> L60
            monitor-exit(r15);     // Catch: Throwable -> L60
            return;
        L56:
            if (this.this$0.mMainHandler.hasMessages(5) == true) goto L58;
            this.this$0.mMainHandler.sendEmptyMessage(5);     // Catch: Throwable -> L60
            this.mRunning = false;     // Catch: Throwable -> L60
            this.this$0.mMainHandler.sendMessage(this.this$0.mMainHandler.obtainMessage(6, 0));     // Catch: Throwable -> L60
        L58:
            monitor-exit(r15);     // Catch: Throwable -> L60
            return;
        L149:
            return;
        L63:
            Process.setThreadPriority(19);
            SparseArray<HashMap<String, AppEntry>> r16 = this.this$0.mUserIdEntriesMap;
            monitor-enter(r16);
            int r10 = 0;
        L132:
        L96:
            th = move-exception;
            throw th;
        L67:
            if (r2 >= this.this$0.mAppEntries.size()) goto L87;
            if (r10 >= 2) goto L87;
            AppEntry r11 = this.this$0.mAppEntries.get(r2);     // Catch: Throwable -> L96
            if (r11.icon != null) goto L72;
        L75:
            monitor-enter(r11);     // Catch: Throwable -> L96
            if (r11.ensureIconLocked(this.this$0.mContext, this.this$0.mPm) == true) goto L79;
        L82:
            monitor-exit(r11);     // Catch: Throwable -> L84
        L129:
            r2 = r2 + 1;     // Catch: Throwable -> L84
        L84:
            th = move-exception;
            throw th;     // Catch: Throwable -> L96
        L79:
            if (this.mRunning == true) goto L81;
            this.mRunning = true;     // Catch: Throwable -> L84
            this.this$0.mMainHandler.sendMessage(this.this$0.mMainHandler.obtainMessage(6, 1));     // Catch: Throwable -> L84
        L81:
            r10 = r10 + 1;     // Catch: Throwable -> L84
            goto L82
        L72:
            if (AppEntry.access$800(r11) == true) goto L75;
            if (r11.mounted == true) goto L129;
        L87:
            monitor-exit(r16);     // Catch: Throwable -> L96
            if (r10 > 0) goto L90;
        L92:
            if (r10 < 2) goto L94;
            sendEmptyMessage(3);
        L95:
            Process.setThreadPriority(10);
            return;
        L94:
            sendEmptyMessage(4);
            goto L95
        L90:
            if (this.this$0.mMainHandler.hasMessages(3) == true) goto L92;
            this.this$0.mMainHandler.sendEmptyMessage(3);
            goto L92
        L7:
            r1 = null;
            goto L8
        }
    }

    public interface Callbacks {
        void onAllSizesComputed();

        void onPackageIconChanged();

        void onPackageListChanged();

        void onPackageSizeChanged(String r1);

        void onRebuildComplete(ArrayList<AppEntry> r1);

        void onRunningStateChanged(boolean r1);
    }

    public static class CompoundFilter implements AppFilter {
        private final AppFilter mFirst;
        private final AppFilter mSecond;

        public CompoundFilter(AppFilter r1, AppFilter r2) {
            this.mFirst = r1;
            this.mSecond = r2;
        }

        @Override // com.android.settings.applications.ApplicationsState.AppFilter
        public void init() {
            this.mFirst.init();
            this.mSecond.init();
        }

        @Override // com.android.settings.applications.ApplicationsState.AppFilter
        public boolean filterApp(ApplicationInfo r2) {
            if (this.mFirst.filterApp(r2) == true) goto L5;
        L7:
            return false;
        L5:
            if (this.mSecond.filterApp(r2) == false) goto L7;
            return true;
        }
    }

    class MainHandler extends Handler {
        static final int MSG_ALL_SIZES_COMPUTED = 5;
        static final int MSG_PACKAGE_ICON_CHANGED = 3;
        static final int MSG_PACKAGE_LIST_CHANGED = 2;
        static final int MSG_PACKAGE_SIZE_CHANGED = 4;
        static final int MSG_REBUILD_COMPLETE = 1;
        static final int MSG_RUNNING_STATE_CHANGED = 6;
        final /* synthetic */ ApplicationsState this$0;

        /* synthetic */ MainHandler(ApplicationsState r1, AnonymousClass1 r2) {
            this(r1);
        }

        private MainHandler(ApplicationsState r1) {
            this.this$0 = r1;
            super(Looper.getMainLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message r5) {
            this.this$0.rebuildActiveSessions();
            int r1 = 0;
            switch(r5.what) {
                case 1: goto L25;
                case 2: goto L23;
                case 3: goto L20;
                case 4: goto L17;
                case 5: goto L14;
                case 6: goto L5;
                default: goto L37;
            };
        L5:
            int r0 = 0;
        L7:
            if (r0 >= this.this$0.mActiveSessions.size()) goto L38;
            Callbacks r2 = this.this$0.mActiveSessions.get(r0).mCallbacks;
            if (r5.arg1 == 0) goto L11;
            boolean r3 = true;
        L12:
            r2.onRunningStateChanged(r3);
            r0 = r0 + 1;
            goto L7
        L11:
            r3 = false;
            goto L12
        L38:
            return;
        L25:
            Session r6 = (Session) r5.obj;
            if (this.this$0.mActiveSessions.contains(r6) == false) goto L36;
            r6.mCallbacks.onRebuildComplete(r6.mLastAppList);
            return;
        L36:
            return;
        L37:
            return;
        L14:
            if (r1 >= this.this$0.mActiveSessions.size()) goto L39;
            this.this$0.mActiveSessions.get(r1).mCallbacks.onAllSizesComputed();
            r1 = r1 + 1;
            goto L14
        L39:
            return;
        L17:
            if (r1 >= this.this$0.mActiveSessions.size()) goto L40;
            this.this$0.mActiveSessions.get(r1).mCallbacks.onPackageSizeChanged((String) r5.obj);
            r1 = r1 + 1;
            goto L17
        L40:
            return;
        L20:
            if (r1 >= this.this$0.mActiveSessions.size()) goto L41;
            this.this$0.mActiveSessions.get(r1).mCallbacks.onPackageIconChanged();
            r1 = r1 + 1;
            goto L20
        L41:
            return;
        L23:
            if (r1 >= this.this$0.mActiveSessions.size()) goto L42;
            this.this$0.mActiveSessions.get(r1).mCallbacks.onPackageListChanged();
            r1 = r1 + 1;
            goto L23
        }
    }

    private class PackageIntentReceiver extends BroadcastReceiver {
        final /* synthetic */ ApplicationsState this$0;

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r1, Intent r2) {
            com_android_settings_applications_ApplicationsState$PackageIntentReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(this, r1, r2);
        }

        private PackageIntentReceiver(ApplicationsState r1) {
            this.this$0 = r1;
        }

        /* synthetic */ PackageIntentReceiver(ApplicationsState r1, AnonymousClass1 r2) {
            this(r1);
        }

        void registerReceiver() {
            IntentFilter r0 = new IntentFilter("android.intent.action.PACKAGE_ADDED");
            r0.addAction("android.intent.action.PACKAGE_REMOVED");
            r0.addAction("android.intent.action.PACKAGE_CHANGED");
            r0.addDataScheme("package");
            GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this.this$0.mContext, this, r0, 2);
            IntentFilter r1 = new IntentFilter();
            r1.addAction("android.intent.action.EXTERNAL_APPLICATIONS_AVAILABLE");
            r1.addAction("android.intent.action.EXTERNAL_APPLICATIONS_UNAVAILABLE");
            GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this.this$0.mContext, this, r1, 2);
        }

        void unregisterReceiver() {
            this.this$0.mContext.unregisterReceiver(this);
        }

        public void com_android_settings_applications_ApplicationsState$PackageIntentReceiver__onReceive$___twin___(Context r4, Intent r5) {
            String r6 = r5.getAction();
            if ("android.intent.action.PACKAGE_ADDED".equals(r6) == false) goto L5;
            String r7 = r5.getData().getEncodedSchemeSpecificPart();
            this.this$0.addPackage(r7);
            return;
        L5:
            int r1 = 0;
            if ("android.intent.action.PACKAGE_REMOVED".equals(r6) == false) goto L15;
            String r8 = r5.getData().getEncodedSchemeSpecificPart();
            if (r5.getBooleanExtra("android.intent.extra.REPLACING", false) == true) goto L34;
            Iterator r9 = ApplicationsState.access$100(this.this$0.mUm).iterator();
        L11:
            if (r9.hasNext() == false) goto L13;
            UserHandle r0 = (UserHandle) r9.next();
            this.this$0.removePackageByUserId(r8, r0.getIdentifier());
            goto L11
        L13:
            this.this$0.removePackageByUserId(r8, 10);
            return;
        L34:
            return;
        L15:
            if ("android.intent.action.PACKAGE_CHANGED".equals(r6) == false) goto L18;
            String r10 = r5.getData().getEncodedSchemeSpecificPart();
            this.this$0.invalidatePackage(r10);
            return;
        L18:
            if ("android.intent.action.EXTERNAL_APPLICATIONS_AVAILABLE".equals(r6) == false) goto L20;
        L21:
            String[] r11 = r5.getStringArrayExtra("android.intent.extra.changed_package_list");
            if (r11 != null) goto L24;
            return;
        L24:
            if (r11.length != 0) goto L27;
            return;
        L27:
            if ("android.intent.action.EXTERNAL_APPLICATIONS_AVAILABLE".equals(r6) == false) goto L39;
            int r12 = r11.length;
        L29:
            if (r1 >= r12) goto L41;
            String r2 = r11[r1];
            this.this$0.invalidatePackage(r2);
            r1 = r1 + 1;
            goto L29
        L41:
            return;
        L39:
            return;
        L20:
            if ("android.intent.action.EXTERNAL_APPLICATIONS_UNAVAILABLE".equals(r6) == true) goto L21;
        }

        @Insert("onReceive")
        public static void com_android_settings_applications_ApplicationsState$PackageIntentReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(PackageIntentReceiver r7, Context r8, Intent r9) {
            Intrinsics.checkNotNullParameter(r8, "context");
            String[] r0 = {"android.bluetooth.device.action.PAIRING_REQUEST", "android.bluetooth.device.action.BOND_STATE_CHANGED", "com.bytedanceos.launcher.new_message", "intent.provision.import_data", "com.android.settings.action.SHOW_IMPORT_DATA_NOTIFICATION"};
            Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.content.BroadcastReceiver");
            PackageIntentReceiver r1 = r7;
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
            r7.com_android_settings_applications_ApplicationsState$PackageIntentReceiver__onReceive$___twin___(r8, r9);
            return;
        L13:
            GrantUtil r11 = GrantUtil.INSTANCE;
            Application r12 = SettingsApplication.getApplication();
            Intrinsics.checkNotNullExpressionValue(r12, "getApplication(...)");
            if (r11.isSetupCompelete(r12) == true) goto L16;
            OLog.i("PrivacyHookForReceiver", "onReceive !isSetupCompeleted hooked for " + r3 + ", " + r2);
            r7.com_android_settings_applications_ApplicationsState$PackageIntentReceiver__onReceive$___twin___(r8, r9);
            return;
        L16:
            String r13 = r3;
            if (r13 != null) goto L19;
        L22:
            boolean r14 = true;
        L23:
            if (r14 == false) goto L26;
            OLog.i("PrivacyHookForReceiver", "onReceive !simpleName hooked for " + r3 + ", " + r2);
            r7.com_android_settings_applications_ApplicationsState$PackageIntentReceiver__onReceive$___twin___(r8, r9);
            return;
        L26:
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == true) goto L30;
            if (r4 == true) goto L30;
            OLog.i("PrivacyHookForReceiver", "onReceive !isPrivacyAllowed hooked for " + r3 + ", " + r2);
            return;
        L30:
            GrantUtil.INSTANCE.applicationInit();
            r7.com_android_settings_applications_ApplicationsState$PackageIntentReceiver__onReceive$___twin___(r8, r9);
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

    public class Session {
        final Callbacks mCallbacks;
        ArrayList<AppEntry> mLastAppList;
        boolean mRebuildAsync;
        Comparator<AppEntry> mRebuildComparator;
        AppFilter mRebuildFilter;
        boolean mRebuildRequested;
        ArrayList<AppEntry> mRebuildResult;
        final Object mRebuildSync;
        boolean mSessionResumed;
        final /* synthetic */ ApplicationsState this$0;

        Session(ApplicationsState r1, Callbacks r2) {
            this.this$0 = r1;
            this.mRebuildSync = new Object();
            this.mRebuildRequested = false;
            this.mCallbacks = r2;
        }

        public void resume(final boolean r3) {
            Trace.beginSection("ApplicationsState-resume");
            OLog.d(ApplicationsState.TAG, "resume");
            this.this$0.mBackgroundHandler.post(new AnonymousClass1(this, r3));
            Trace.endSection();
        }

        public void pause() {
            OLog.d(ApplicationsState.TAG, "pause");
            this.this$0.mBackgroundHandler.post(new AnonymousClass2(this));
        }

        public ArrayList<AppEntry> rebuild(AppFilter r6, Comparator<AppEntry> r7) {
            Object r0 = this.mRebuildSync;
            monitor-enter(r0);
        L41:
        L32:
            th = move-exception;
            throw th;
        L5:
            if (this.mRebuildRequested == false) goto L10;
            this.mRebuildSync.wait(500);     // Catch: InterruptedException -> L8 Throwable -> L32
        L8:
            e = move-exception;
            e.printStackTrace();     // Catch: Throwable -> L32
            OLog.e(ApplicationsState.TAG, "mRebuildRequested==true, wait failed: " + e);     // Catch: Throwable -> L32
            goto L41
        L10:
            SparseArray<HashMap<String, AppEntry>> r1 = this.this$0.mUserIdEntriesMap;     // Catch: Throwable -> L32
            monitor-enter(r1);     // Catch: Throwable -> L32
            this.this$0.mRebuildingSessions.add(this);     // Catch: Throwable -> L29
            OLog.i(ApplicationsState.TAG, "mRebuildRequested = true;");     // Catch: Throwable -> L29
            this.mRebuildRequested = true;     // Catch: Throwable -> L29
            this.mRebuildAsync = false;     // Catch: Throwable -> L29
            this.mRebuildFilter = r6;     // Catch: Throwable -> L29
            this.mRebuildComparator = r7;     // Catch: Throwable -> L29
            OLog.i(ApplicationsState.TAG, "mRebuildResult = null;");     // Catch: Throwable -> L29
            this.mRebuildResult = null;     // Catch: Throwable -> L29
            if (this.this$0.mBackgroundHandler.hasMessages(1, this) == true) goto L15;
            this.this$0.mBackgroundHandler.sendMessage(this.this$0.mBackgroundHandler.obtainMessage(1, this));     // Catch: Throwable -> L29
        L15:
            monitor-exit(r1);     // Catch: Throwable -> L29
        L17:
            if (this.mRebuildResult == null) goto L39;
        L22:
            this.mRebuildAsync = true;     // Catch: Throwable -> L32
            if (this.mRebuildResult != null) goto L25;
            OLog.e(ApplicationsState.TAG, "rebuild mRebuildResult == null");     // Catch: Throwable -> L32
        L26:
            ArrayList<AppEntry> r5 = this.mRebuildResult;     // Catch: Throwable -> L32
            monitor-exit(r0);     // Catch: Throwable -> L32
            return r5;
        L25:
            OLog.i(ApplicationsState.TAG, "rebuild mRebuildResult.size() == " + this.mRebuildResult.size());     // Catch: Throwable -> L32
            goto L26
        L39:
            this.mRebuildSync.wait();     // Catch: InterruptedException -> L20 Throwable -> L32
        L20:
            e = move-exception;
            e.printStackTrace();     // Catch: Throwable -> L32
            OLog.e(ApplicationsState.TAG, "wait failed: " + e);     // Catch: Throwable -> L32
        L29:
            th = move-exception;
            throw th;     // Catch: Throwable -> L32
        }

        void handleRebuildList() {
            Object r0 = this.mRebuildSync;
            monitor-enter(r0);
        L55:
            th = move-exception;
            throw th;
        L5:
            if (this.mRebuildRequested == true) goto L8;
            monitor-exit(r0);     // Catch: Throwable -> L55
            return;
        L8:
            AppFilter r1 = this.mRebuildFilter;     // Catch: Throwable -> L55
            Comparator<AppEntry> r2 = this.mRebuildComparator;     // Catch: Throwable -> L55
            OLog.i(ApplicationsState.TAG, "mRebuildRequested = false;");     // Catch: Throwable -> L55
            int r3 = 0;
            this.mRebuildRequested = false;     // Catch: Throwable -> L55
            this.mRebuildFilter = null;     // Catch: Throwable -> L55
            this.mRebuildComparator = null;     // Catch: Throwable -> L55
            Process.setThreadPriority(-2);     // Catch: Throwable -> L55
            if (r1 == null) goto L11;
            r1.init();     // Catch: Throwable -> L55
        L11:
            SparseArray<HashMap<String, AppEntry>> r4 = this.this$0.mUserIdEntriesMap;     // Catch: Throwable -> L55
            monitor-enter(r4);     // Catch: Throwable -> L55
            ArrayList r5 = new ArrayList(this.this$0.mApplications);     // Catch: Throwable -> L52
            monitor-exit(r4);     // Catch: Throwable -> L52
            ArrayList<AppEntry> r6 = new ArrayList();     // Catch: Throwable -> L55
        L17:
            if (r3 >= r5.size()) goto L30;
            ApplicationInfo r7 = (ApplicationInfo) r5.get(r3);     // Catch: Throwable -> L55
            if (r1 != null) goto L21;
        L22:
            SparseArray<HashMap<String, AppEntry>> r8 = this.this$0.mUserIdEntriesMap;     // Catch: Throwable -> L55
            monitor-enter(r8);     // Catch: Throwable -> L55
            AppEntry r9 = this.this$0.getEntryLocked(r7);     // Catch: Throwable -> L27
            r9.ensureLabel(this.this$0.mContext);     // Catch: Throwable -> L27
            r6.add(r9);     // Catch: Throwable -> L27
            monitor-exit(r8);     // Catch: Throwable -> L27
        L58:
            r3 = r3 + 1;     // Catch: Throwable -> L27
        L27:
            th = move-exception;
            throw th;     // Catch: Throwable -> L55
        L21:
            if (r1.filterApp(r7) == false) goto L58;
        L30:
            Iterator<AppEntry> r10 = r6.iterator();     // Catch: Throwable -> L55
        L32:
            if (r10.hasNext() == false) goto L41;
            AppEntry r11 = r10.next();     // Catch: Throwable -> L55
            if (r11.mLabelEntry != null) goto L36;
            r11.ensureLabelEntry(this.this$0.mContext);     // Catch: Throwable -> L55
        L36:
            Long r12 = (Long) ApplicationsState.access$300(this.this$0).get(r11.info.packageName);     // Catch: Throwable -> L55
            if (r12 != null) goto L39;
            long r13 = 0;
        L40:
            r11.usageTime = r13;     // Catch: Throwable -> L55
            goto L32
        L39:
            r13 = r12.longValue();     // Catch: Throwable -> L55
            goto L40
        L41:
            Collections.sort(r6, r2);     // Catch: Throwable -> L55
            if (this.mRebuildRequested == true) goto L49;
            this.mLastAppList = r6;     // Catch: Throwable -> L55
            if (this.mRebuildAsync == true) goto L47;
            OLog.i(ApplicationsState.TAG, "mRebuildResult = filteredApps;");     // Catch: Throwable -> L55
            this.mRebuildResult = r6;     // Catch: Throwable -> L55
            OLog.i(ApplicationsState.TAG, "handleRebuildList filteredApps.size() = " + r6.size());     // Catch: Throwable -> L55
            this.mRebuildSync.notifyAll();     // Catch: Throwable -> L55
            goto L49
        L47:
            if (this.this$0.mMainHandler.hasMessages(1, this) == true) goto L49;
            this.this$0.mMainHandler.sendMessage(this.this$0.mMainHandler.obtainMessage(1, this));     // Catch: Throwable -> L55
        L49:
            monitor-exit(r0);     // Catch: Throwable -> L55
            Process.setThreadPriority(10);
            return;
        L52:
            th = move-exception;
            throw th;     // Catch: Throwable -> L55
        }

        public void release() {
            pause();
            monitor-enter(ApplicationsState.class);
            this.this$0.mSessions.remove(this);     // Catch: Throwable -> L7
            this.this$0.mActiveSessions.remove(this);     // Catch: Throwable -> L7
            monitor-exit(ApplicationsState.class);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    public static class SizeInfo {
        long cacheSize;
        long codeSize;
        long dataSize;
        long externalCacheSize;
        long externalCodeSize;
        long externalDataSize;

        public SizeInfo() {
        }
    }

    static /* synthetic */ HashSet access$000() {
        return sAppWithLauncherCategory;
    }

    static /* synthetic */ List access$100(UserManager r0) {
        return getNonDoppelgangerProfiles(r0);
    }

    static /* synthetic */ HashMap access$300(ApplicationsState r0) {
        return r0.mAppUsageTimeMap;
    }

    static /* synthetic */ long access$500(ApplicationsState r0, PackageStats r1) {
        return r0.getTotalInternalSize(r1);
    }

    static /* synthetic */ String access$600(ApplicationsState r0, long r1) {
        return r0.getSizeStr(r1);
    }

    static /* synthetic */ long access$700(ApplicationsState r0, PackageStats r1) {
        return r0.getTotalExternalSize(r1);
    }

    static {
        HashSet<String> r0 = new HashSet();
        sWhiteAppList = r0;
        r0.add("com.cootek.smartinputv5.bytedance");
        sWhiteAppList.add("com.sohu.inputmethod.sogou.chuizi");
        sWhiteAppList.add("com.iflytek.inputmethod.bytedance");
        REMOVE_DIACRITICALS_PATTERN = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        ALPHA_COMPARATOR = new AnonymousClass1();
        INSTALL_TIME_COMPARATOR = new AnonymousClass2();
        FREQUENCY_COMPARATOR = new AnonymousClass3();
        SIZE_COMPARATOR = new AnonymousClass4();
        INTERNAL_SIZE_COMPARATOR = new AnonymousClass5();
        EXTERNAL_SIZE_COMPARATOR = new AnonymousClass6();
        THIRD_PARTY_FILTER = new AnonymousClass7();
        ON_SD_CARD_FILTER = new AnonymousClass8();
        DISABLED_FILTER = new AnonymousClass9();
        ALL_ENABLED_FILTER = new AnonymousClass10();
        SYSTEM_COMPONENT_FILTER = new AnonymousClass11();
        COMMON_APP_FILTER = new AnonymousClass12();
        THRID_LAUNCHABLE_APP_FILTER = new AnonymousClass13();
        PERSONAL_FILTER = new AnonymousClass14();
        WORK_FILTER = new AnonymousClass15();
        FILTER_INTERACT_ACROSS_PROFILES = new AnonymousClass16();
        sAppWithLauncherCategory = new HashSet();
        sLock = new Object();
        mShowDoppelgangerApp = false;
    }

    public static String normalize(String r1) {
        String r2 = Normalizer.normalize(r1, Normalizer.Form.NFD);
        return REMOVE_DIACRITICALS_PATTERN.matcher(r2).replaceAll("").toLowerCase();
    }

    void rebuildActiveSessions() {
        monitor-enter(ApplicationsState.class);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (this.mSessionsChanged == true) goto L8;
        monitor-exit(ApplicationsState.class);     // Catch: Throwable -> L17
        return;
    L8:
        this.mActiveSessions.clear();     // Catch: Throwable -> L17
        int r1 = 0;
    L10:
        if (r1 >= this.mSessions.size()) goto L15;
        Session r2 = this.mSessions.get(r1);     // Catch: Throwable -> L17
        if (r2.mSessionResumed == false) goto L14;
        this.mActiveSessions.add(r2);     // Catch: Throwable -> L17
    L14:
        r1 = r1 + 1;     // Catch: Throwable -> L17
        goto L10
    L15:
        monitor-exit(ApplicationsState.class);     // Catch: Throwable -> L17
    }

    public static ApplicationsState getInstance(Application r3, boolean r4) {
        OLog.i(TAG, "getInstance start");
        Object r0 = sLock;
        monitor-enter(r0);
        OLog.i(TAG, "getInstance sLock start");     // Catch: Throwable -> L10
        Trace.beginSection("ApplicationsState-getInstance");     // Catch: Throwable -> L10
        if (sInstance != null) goto L7;
        sInstance = new ApplicationsState(r3, r4);     // Catch: Throwable -> L10
    L7:
        OLog.i(TAG, "getInstance sLock end");     // Catch: Throwable -> L10
        mShowDoppelgangerApp = r4;     // Catch: Throwable -> L10
        Trace.endSection();     // Catch: Throwable -> L10
        ApplicationsState r5 = sInstance;     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r5;
    L10:
        th = move-exception;
        throw th;
    }

    private ApplicationsState(Application r5, boolean r6) {
        this.mSessions = new ArrayList();
        this.mRebuildingSessions = new ArrayList();
        this.mInterestingConfigChanges = new InterestingConfigChanges();
        this.mUserIdEntriesMap = new SparseArray();
        this.mEntriesMap = new HashMap();
        this.mAppEntries = new ArrayList();
        this.mApplications = new ArrayList();
        this.mCurId = 1;
        this.mAppUsageTimeMap = new HashMap();
        this.mActiveSessions = new ArrayList();
        this.mCommonAppWhiteList = new ArrayList();
        this.mMainHandler = new MainHandler(this, null);
        this.mLauncherCallback = new AnonymousClass18(this);
        OLog.i(TAG, "ApplicationsState ctor1");
        mShowDoppelgangerApp = r6;
        this.mContext = r5;
        this.mPm = r5.getPackageManager();
        UserManager r7 = (UserManager) r5.getSystemService(PickApplicationActivity.EXTRA_USER);
        this.mUm = r7;
        Iterator<UserHandle> r8 = getNonDoppelgangerProfiles(r7).iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        this.mUserIdEntriesMap.put(r8.next().getIdentifier(), new HashMap());
        goto L4
    L6:
        this.mUserIdEntriesMap.put(10, new HashMap());
        OLog.i(TAG, "ApplicationsState ctor2");
        HandlerThread r9 = new HandlerThread("ApplicationsState.Loader", 10);
        this.mThread = r9;
        OLog.i(TAG, "ApplicationsState ctor3");
        r9.start();
        OLog.i(TAG, "ApplicationsState ctor4");
        this.mBackgroundHandler = new BackgroundHandler(this, r9.getLooper());
        OLog.i(TAG, "ApplicationsState ctor5");
        this.mCommonAppWhiteList = Arrays.asList(this.mContext.getResources().getStringArray(R.array.common_white_app_list));
        if (UserHandle.myUserId() != 0) goto L9;
        this.mRetrieveFlags = 8704;
    L10:
        OLog.i(TAG, "ApplicationsState ctor6");
        SparseArray<HashMap<String, AppEntry>> r10 = this.mUserIdEntriesMap;
        monitor-enter(r10);
        OLog.i(TAG, "ApplicationsState ctor7");     // Catch: Throwable -> L14 InterruptedException -> L16
        this.mUserIdEntriesMap.wait(1);     // Catch: Throwable -> L14 InterruptedException -> L16
        OLog.i(TAG, "ApplicationsState ctor8");     // Catch: Throwable -> L14 InterruptedException -> L16
    L18:
        monitor-exit(r10);     // Catch: Throwable -> L14
        OLog.i(TAG, "ApplicationsState ctor9");
        return;
    L16:
        e = move-exception;
        OLog.e(TAG, "ApplicationsState ctor8 InterruptedException=" + e);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    L9:
        this.mRetrieveFlags = 512;
        goto L10
    }

    private void initUsageStats() {
        clearUsageStatsCache();
        getUsageStatusWithHigherApiLevel();
    }

    private void getUsageStatusWithLowerApiLevel() {
        int r5 = 0;
        Object r0 = Class.forName(IUsageStatsStubClassName).getMethod("asInterface", new Class[]{Class.forName("android.os.IBinder")}).invoke(null, new Object[]{ServiceManager.getService("usagestats")});     // Catch: Exception -> L10
        Object[] r1 = (Object[]) r0.getClass().getMethod("getAllPkgUsageStats", new Class[0]).invoke(r0, new Object[0]);     // Catch: Exception -> L10
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1.length <= 0) goto L17;
        int r2 = r1.length;     // Catch: Exception -> L10
    L7:
        if (r5 >= r2) goto L18;
        Object r3 = r1[r5];     // Catch: Exception -> L10
        Class<?> r4 = r3.getClass();     // Catch: Exception -> L10
        Field r6 = r4.getField(NotificationDisplayDetailsActivity.EXTRA_PACKAGE_NAME);     // Catch: Exception -> L10
        r4.getField("usageTime");     // Catch: Exception -> L10
        this.mAppUsageTimeMap.put((String) r6.get(r3), Long.valueOf(((Integer) r4.getField("launchCount").get(r3)).intValue()));     // Catch: Exception -> L10
        r5 = r5 + 1;
        goto L7
    L18:
        return;
    L17:
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
    }

    private void getUsageStatusWithHigherApiLevel() {
        Object r0 = this.mContext.getSystemService("usagestats");     // Catch: NoSuchFieldException -> L12 IllegalAccessException -> L14 InvocationTargetException -> L16 NoSuchMethodException -> L18
        Object r1 = r0.getClass().getDeclaredMethod("queryUsageStats", new Class[]{Integer.TYPE, Long.TYPE, Long.TYPE}).invoke(r0, new Object[]{3, new Long(0), Long.valueOf(System.currentTimeMillis())});     // Catch: NoSuchFieldException -> L12 IllegalAccessException -> L14 InvocationTargetException -> L16 NoSuchMethodException -> L18
        if (r1 == null) goto L29;
        Iterator r2 = ((List) r1).iterator();     // Catch: NoSuchFieldException -> L12 IllegalAccessException -> L14 InvocationTargetException -> L16 NoSuchMethodException -> L18
    L6:
        if (r2.hasNext() == false) goto L33;
        Object r3 = r2.next();     // Catch: NoSuchFieldException -> L12 IllegalAccessException -> L14 InvocationTargetException -> L16 NoSuchMethodException -> L18
        if (r3 == null) goto L6;
        Class<?> r4 = r3.getClass();     // Catch: NoSuchFieldException -> L12 IllegalAccessException -> L14 InvocationTargetException -> L16 NoSuchMethodException -> L18
        this.mAppUsageTimeMap.put((String) r4.getDeclaredMethod("getPackageName", new Class[0]).invoke(r3, new Object[0]), Long.valueOf(r4.getDeclaredField("mLaunchCount").getInt(r3)));     // Catch: NoSuchFieldException -> L12 IllegalAccessException -> L14 InvocationTargetException -> L16 NoSuchMethodException -> L18
    L33:
        return;
    L29:
        return;
    L14:
        e = move-exception;
        e.printStackTrace();
        return;
    L12:
        e = move-exception;
        e.printStackTrace();
        return;
    L18:
        e = move-exception;
        e.printStackTrace();
        return;
    L16:
        e = move-exception;
        e.printStackTrace();
    }

    private void clearUsageStatsCache() {
        this.mAppUsageTimeMap.clear();
    }

    public Session newSession(Callbacks r3) {
        Trace.beginSection("ApplicationsState-newSession");
        OLog.i(TAG, "newSession1");
        Session r0 = new Session(this, r3);
        OLog.i(TAG, "newSession2");
        monitor-enter(ApplicationsState.class);
        this.mSessions.add(r0);     // Catch: Throwable -> L8
        monitor-exit(ApplicationsState.class);     // Catch: Throwable -> L8
        OLog.i(TAG, "newSession3");
        Trace.endSection();
        return r0;
    L8:
        th = move-exception;
        throw th;
    }

    private boolean isWhiteListApp(String r3) {
        boolean r0 = "gintama".equals(Utils.getDeviceColor());
        if ("com.bytedanceos.launcher.theme.gintama".equals(r3) == false) goto L8;
        if (r0 == true) goto L8;
        return true;
    L8:
        return this.mCommonAppWhiteList.contains(r3);
    }

    public static boolean isBlackListOrHiddenApp(ApplicationInfo r4) {
        String r0 = r4.packageName;
        if (sWhiteAppList.contains(r0) == false) goto L6;
        return false;
    L6:
        if (Utils.FAKE_SYSTEM_APPS.contains(r0) == false) goto L9;
        return true;
    L9:
        if (Utils.SYSTEM_COMPONENT_APPS.contains(r0) == false) goto L12;
        return true;
    L12:
        if (Utils.APP_STORE_PACKAGE.equals(r0) == false) goto L17;
        if (Utils.isCmccVersion(SettingsApplication.getContext()) == false) goto L17;
        return true;
    L17:
        if (Utils.isSystemPackage(r4) == true) goto L25;
        if (r0.startsWith("com.bytedanceos.") == true) goto L25;
        if (r0.startsWith("com.obric.") == true) goto L25;
        return false;
    L25:
        if (r0.equals("com.obric.screenrecorder") == false) goto L28;
        return false;
    L28:
        return !sAppWithLauncherCategory.contains(r0);
    }

    void doResumeIfNeededLocked(boolean r11) {
        if (this.mResumed == false) goto L5;
        return;
    L5:
        mShowDoppelgangerApp = r11;
        this.mResumed = true;
        AnonymousClass1 r1 = null;
        if (this.mPackageIntentReceiver != null) goto L8;
        PackageIntentReceiver r0 = new PackageIntentReceiver(this, r1);
        this.mPackageIntentReceiver = r0;
        r0.registerReceiver();
    L8:
        LauncherApps r2 = (LauncherApps) this.mContext.getSystemService("launcherapps");
        if (r2 == null) goto L11;
        r2.registerCallback(this.mLauncherCallback, this.mBackgroundHandler);
    L11:
        initUsageStats();
        ArrayList r3 = new ArrayList();
        Iterator<UserHandle> r4 = getNonDoppelgangerProfiles(this.mUm).iterator();
    L13:
        if (r4.hasNext() == false) goto L15;
        UserHandle r5 = r4.next();
        r3.addAll(this.mPm.getInstalledApplicationsAsUser(this.mRetrieveFlags, r5.getIdentifier()));
        goto L13
    L15:
        int r6 = 0;
        if (ActivityManager.getCurrentUser() == 0) goto L18;
    L27:
        Intent r7 = new Intent("android.intent.action.MAIN", null);
        r7.addCategory("android.intent.category.LAUNCHER");
        List<ResolveInfo> r8 = this.mPm.queryIntentActivities(r7, 0);
        SparseArray<HashMap<String, AppEntry>> r9 = this.mUserIdEntriesMap;
        monitor-enter(r9);
        this.mApplications.clear();     // Catch: Throwable -> L82
        Iterator<UserHandle> r10 = getNonDoppelgangerProfiles(this.mUm).iterator();     // Catch: Throwable -> L82
    L31:
        if (r10.hasNext() == false) goto L35;
        UserHandle r12 = r10.next();     // Catch: Throwable -> L82
        if (this.mUserIdEntriesMap.get(r12.getIdentifier()) != null) goto L31;
        this.mUserIdEntriesMap.put(r12.getIdentifier(), new HashMap());     // Catch: Throwable -> L82
        goto L31
    L35:
        HashSet<String> r13 = new HashSet();     // Catch: Throwable -> L82
        if (r8 == null) goto L41;
        Iterator<ResolveInfo> r14 = r8.iterator();     // Catch: Throwable -> L82
    L39:
        if (r14.hasNext() == false) goto L41;
        r13.add(r14.next().activityInfo.packageName);     // Catch: Throwable -> L82
    L41:
        sAppWithLauncherCategory = r13;     // Catch: Throwable -> L82
        Iterator r15 = r3.iterator();     // Catch: Throwable -> L82
    L43:
        if (r15.hasNext() == false) goto L48;
        ApplicationInfo r16 = (ApplicationInfo) r15.next();     // Catch: Throwable -> L82
        if (isWhiteListApp(r16.packageName) == true) goto L46;
        this.mApplications.add(r16);     // Catch: Throwable -> L82
        goto L43
    L46:
        this.mAppUsageTimeMap.remove(r16.packageName);     // Catch: Throwable -> L82
        goto L43
    L48:
        r3.clear();     // Catch: Throwable -> L82
        if (this.mInterestingConfigChanges.applyNewConfig(this.mContext.getResources()) == false) goto L56;
        this.mUserIdEntriesMap.clear();     // Catch: Throwable -> L82
        Iterator<UserHandle> r17 = getNonDoppelgangerProfiles(this.mUm).iterator();     // Catch: Throwable -> L82
    L52:
        if (r17.hasNext() == false) goto L54;
        UserHandle r18 = r17.next();     // Catch: Throwable -> L82
        this.mUserIdEntriesMap.put(r18.getIdentifier(), new HashMap());     // Catch: Throwable -> L82
        goto L52
    L54:
        this.mUserIdEntriesMap.put(10, new HashMap());     // Catch: Throwable -> L82
        this.mAppEntries.clear();     // Catch: Throwable -> L82
    L58:
        Iterator<ApplicationInfo> r19 = this.mApplications.iterator();     // Catch: Throwable -> L82
    L60:
        if (r19.hasNext() == false) goto L74;
        ApplicationInfo r20 = r19.next();     // Catch: Throwable -> L82
        if (r20.enabled == true) goto L66;
        if (r20.enabledSetting == 3) goto L66;
        r19.remove();     // Catch: Throwable -> L82
        this.mUserIdEntriesMap.get(UserHandle.getUserId(r20.uid)).remove(r20.packageName);     // Catch: Throwable -> L82
    L66:
        AppEntry r21 = this.mUserIdEntriesMap.get(UserHandle.getUserId(r20.uid)).get(r20.packageName);     // Catch: Throwable -> L82
        if (r21 == null) goto L60;
        r21.info = r20;     // Catch: Throwable -> L82
        if (r20.sourceDir == null) goto L72;
        r21.apkFile = new File(r20.sourceDir);     // Catch: Throwable -> L82
    L72:
        if (r20.dataDir == null) goto L60;
        r21.dataFile = new File(r20.dataDir);     // Catch: Throwable -> L82
        goto L60
    L74:
        monitor-exit(r9);     // Catch: Throwable -> L82
        this.mCurComputingSizePkg = null;
        if (this.mBackgroundHandler.hasMessages(2) == true) goto L79;
        this.mBackgroundHandler.sendEmptyMessage(2);
    L79:
        if (this.mMainHandler.hasMessages(2) == true) goto L118;
        this.mMainHandler.sendEmptyMessage(2);
        return;
    L118:
        return;
    L56:
        if (r6 >= this.mAppEntries.size()) goto L58;
        this.mAppEntries.get(r6).sizeStale = true;     // Catch: Throwable -> L82
        r6 = r6 + 1;     // Catch: Throwable -> L82
    L82:
        th = move-exception;
        throw th;
    L18:
        if (mShowDoppelgangerApp == false) goto L27;
        List r22 = this.mPm.getInstalledPackagesAsUser(0, 10);
        if (r22.size() <= 0) goto L27;
        Iterator r23 = r22.iterator();
    L23:
        if (r23.hasNext() == false) goto L27;
        PackageInfo r24 = (PackageInfo) r23.next();
        if ((r24.applicationInfo.flags & 1) != 0) goto L23;
        r3.add(r24.applicationInfo);
        goto L23
    }

    void doPauseIfNeededLocked() {
        if (this.mResumed == true) goto L6;
        return;
    L6:
        monitor-enter(ApplicationsState.class);
        int r2 = 0;
    L27:
    L24:
        th = move-exception;
        throw th;
    L9:
        if (r2 >= this.mSessions.size()) goto L15;
        if (this.mSessions.get(r2).mSessionResumed == true) goto L12;
        r2 = r2 + 1;     // Catch: Throwable -> L24
        goto L27
    L12:
        monitor-exit(ApplicationsState.class);     // Catch: Throwable -> L24
        return;
    L15:
        monitor-exit(ApplicationsState.class);     // Catch: Throwable -> L24
        this.mResumed = false;
        PackageIntentReceiver r0 = this.mPackageIntentReceiver;
        if (r0 == null) goto L19;
        r0.unregisterReceiver();
        this.mPackageIntentReceiver = null;
    L19:
        LauncherApps r1 = (LauncherApps) this.mContext.getSystemService("launcherapps");
        if (r1 == null) goto L22;
        r1.unregisterCallback(this.mLauncherCallback);
    L22:
        clearUsageStatsCache();
    }

    public AppEntry getEntry(String r6) {
        if (r6 != null) goto L5;
        return null;
    L5:
        SparseArray<HashMap<String, AppEntry>> r0 = this.mUserIdEntriesMap;
        monitor-enter(r0);
        AppEntry r1 = this.mEntriesMap.get(r6);     // Catch: Throwable -> L20
        if (r1 != null) goto L16;
        int r2 = 0;
    L11:
        if (r2 >= this.mApplications.size()) goto L16;
        ApplicationInfo r3 = this.mApplications.get(r2);     // Catch: Throwable -> L20
        if (r6.equals(r3.packageName) == true) goto L14;
        r2 = r2 + 1;     // Catch: Throwable -> L20
        goto L11
    L14:
        r1 = getEntryLocked(r3);     // Catch: Throwable -> L20
    L16:
        if (r1 != null) goto L18;
        OLog.d(TAG, "could not found application info in loaded applications, find again in PackageManager.");     // Catch: Throwable -> L20
        r1 = getInstalledAppEntryLocked(r6);     // Catch: Throwable -> L20
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L20
        return r1;
    L20:
        th = move-exception;
        throw th;
    }

    public AppEntry getEntryByUserId(String r5, int r6) {
        AppEntry r0 = null;
        if (r5 != null) goto L5;
        return null;
    L5:
        SparseArray<HashMap<String, AppEntry>> r1 = this.mUserIdEntriesMap;
        monitor-enter(r1);
        SparseArray<HashMap<String, AppEntry>> r2 = this.mUserIdEntriesMap;     // Catch: Throwable -> L27
        if (r2 == null) goto L10;
        HashMap<String, AppEntry> r7 = r2.get(r6);     // Catch: Throwable -> L27
    L11:
        if (r7 == null) goto L13;
        r0 = r7.get(r5);     // Catch: Throwable -> L27
    L13:
        if (r0 == null) goto L32;
    L23:
        if (r0 != null) goto L25;
        r0 = getInstalledAppEntryLocked(r5);     // Catch: Throwable -> L27
    L25:
        monitor-exit(r1);     // Catch: Throwable -> L27
        return r0;
    L32:
        Iterator<ApplicationInfo> r8 = this.mApplications.iterator();     // Catch: ConcurrentModificationException -> L21 Throwable -> L27
    L16:
        if (r8.hasNext() == false) goto L23;
        ApplicationInfo r3 = r8.next();     // Catch: ConcurrentModificationException -> L21 Throwable -> L27
        if (r5.equals(r3.packageName) == false) goto L16;
        r0 = getEntryLocked(r3);     // Catch: ConcurrentModificationException -> L21 Throwable -> L27
        goto L23
    L21:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L27
        goto L23
    L10:
        r7 = null;
    L27:
        th = move-exception;
        throw th;
    }

    private AppEntry getInstalledAppEntryLocked(String r4) {
        if (r4 != null) goto L11;
        return null;
    L11:
        ApplicationInfo r5 = this.mPm.getApplicationInfo(r4, this.mRetrieveFlags);     // Catch: PackageManager.NameNotFoundException -> L10
        if (r5 != null) goto L8;
        return null;
    L8:
        return getEntryLocked(r5);
    L10:
        return null;
    }

    public void ensureIcon(AppEntry r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r2.icon != null) goto L16;
        monitor-enter(r2);
        r2.ensureIconLocked(this.mContext, this.mPm);     // Catch: Throwable -> L10
        monitor-exit(r2);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    void requestSizeByUserId(ApplicationInfo r3) {
        OLog.d(TAG, "requestSizeByUserId size of " + r3.packageName);
        MultiSDKAdapter.getPackageSizeInfoAsUser(this.mContext, r3, UserHandle.getUserId(r3.uid), this.mBackgroundHandler.mStatsObserver);
    }

    int indexOfApplicationInfoLocked(String r4) {
        int r0 = this.mApplications.size() - 1;
    L3:
        if (r0 < 0) goto L10;
        ApplicationInfo r1 = this.mApplications.get(r0);
        if (r1.packageName.equals(r4) == false) goto L9;
        if (UserHandle.getUserId(r1.uid) != this.mContext.getUserId()) goto L9;
        return r0;
    L9:
        r0 = r0 - 1;
        goto L3
    L10:
        return -1;
    }

    void addPackage(String r4) {
        SparseArray<HashMap<String, AppEntry>> r0 = this.mUserIdEntriesMap;     // Catch: PackageManager.NameNotFoundException -> L30
        monitor-enter(r0);     // Catch: PackageManager.NameNotFoundException -> L30
    L26:
        th = move-exception;
        throw th;     // Catch: PackageManager.NameNotFoundException -> L30
    L5:
        if (this.mResumed == true) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L26
        return;
    L9:
        if (indexOfApplicationInfoLocked(r4) < 0) goto L12;
        monitor-exit(r0);     // Catch: Throwable -> L26
        return;
    L12:
        ApplicationInfo r5 = this.mPm.getApplicationInfo(r4, this.mRetrieveFlags);     // Catch: Throwable -> L26
        if (r5.enabled == false) goto L15;
    L17:
        this.mApplications.add(r5);     // Catch: Throwable -> L26
    L19:
        if (this.mBackgroundHandler.hasMessages(2) == true) goto L22;
        this.mBackgroundHandler.sendEmptyMessage(2);     // Catch: Throwable -> L26
    L22:
        if (this.mMainHandler.hasMessages(2) == true) goto L24;
        this.mMainHandler.sendEmptyMessage(2);     // Catch: Throwable -> L26
    L24:
        monitor-exit(r0);     // Catch: Throwable -> L26
        return;
    L15:
        if (r5.enabledSetting == 3) goto L17;
    }

    void addPackageByUid(String r3, int r4) {
        SparseArray<HashMap<String, AppEntry>> r5 = this.mUserIdEntriesMap;     // Catch: PackageManager.NameNotFoundException -> L24
        monitor-enter(r5);     // Catch: PackageManager.NameNotFoundException -> L24
    L20:
        th = move-exception;
        throw th;     // Catch: PackageManager.NameNotFoundException -> L24
    L5:
        if (this.mResumed == true) goto L9;
        monitor-exit(r5);     // Catch: Throwable -> L20
        return;
    L9:
        if (indexOfApplicationInfoLocked(r3) < 0) goto L12;
        monitor-exit(r5);     // Catch: Throwable -> L20
        return;
    L12:
        ApplicationInfo r6 = this.mPm.getApplicationInfo(r3, this.mRetrieveFlags);     // Catch: Throwable -> L20
        this.mApplications.add(r6);     // Catch: Throwable -> L20
        if (this.mBackgroundHandler.hasMessages(2) == true) goto L16;
        this.mBackgroundHandler.sendEmptyMessage(2);     // Catch: Throwable -> L20
    L16:
        if (this.mMainHandler.hasMessages(2) == true) goto L18;
        this.mMainHandler.sendEmptyMessage(2);     // Catch: Throwable -> L20
    L18:
        monitor-exit(r5);     // Catch: Throwable -> L20
        return;
    }

    @Deprecated
    void removePackage(String r5) {
        SparseArray<HashMap<String, AppEntry>> r0 = this.mUserIdEntriesMap;
        monitor-enter(r0);
        int r1 = indexOfApplicationInfoLocked(r5);     // Catch: Throwable -> L14
        if (r1 < 0) goto L12;
        AppEntry r2 = this.mEntriesMap.get(r5);     // Catch: Throwable -> L14
        if (r2 == null) goto L9;
        this.mEntriesMap.remove(r5);     // Catch: Throwable -> L14
        this.mAppEntries.remove(r2);     // Catch: Throwable -> L14
    L9:
        this.mApplications.remove(r1);     // Catch: Throwable -> L14
        if (this.mMainHandler.hasMessages(2) == true) goto L12;
        this.mMainHandler.sendEmptyMessage(2);     // Catch: Throwable -> L14
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public void removePackageByUserId(String r6, int r7) {
        SparseArray<HashMap<String, AppEntry>> r0 = this.mUserIdEntriesMap;
        monitor-enter(r0);
        int r1 = this.mApplications.size() - 1;     // Catch: Throwable -> L21
        int r2 = -1;
    L5:
        if (r1 < 0) goto L12;
        ApplicationInfo r3 = this.mApplications.get(r1);     // Catch: Throwable -> L21
        if (r3.packageName.equals(r6) == false) goto L11;
        if (UserHandle.getUserId(r3.uid) != r7) goto L11;
        r2 = r1;
    L11:
        r1 = r1 - 1;     // Catch: Throwable -> L21
        goto L5
    L12:
        if (r2 < 0) goto L19;
        AppEntry r4 = this.mUserIdEntriesMap.get(r7).get(r6);     // Catch: Throwable -> L21
        if (r4 == null) goto L16;
        this.mUserIdEntriesMap.get(r7).remove(r6);     // Catch: Throwable -> L21
        this.mAppEntries.remove(r4);     // Catch: Throwable -> L21
    L16:
        this.mApplications.remove(r2);     // Catch: Throwable -> L21
        if (this.mMainHandler.hasMessages(2) == true) goto L19;
        this.mMainHandler.sendEmptyMessage(2);     // Catch: Throwable -> L21
    L19:
        monitor-exit(r0);     // Catch: Throwable -> L21
        return;
    L21:
        th = move-exception;
        throw th;
    }

    void invalidatePackage(String r2) {
        removePackageByUserId(r2, 0);
        addPackage(r2);
    }

    void invalidatePackageByUid(String r2, int r3) {
        removePackageByUserId(r2, UserHandle.getUserId(r3));
        addPackageByUid(r2, r3);
    }

    AppEntry getEntryLocked(ApplicationInfo r9) {
        int r0 = UserHandle.getUserId(r9.uid);
        HashMap<String, AppEntry> r1 = this.mUserIdEntriesMap.get(r0);
        if (r1 == null) goto L5;
        AppEntry r2 = r1.get(r9.packageName);
    L6:
        if (r2 != null) goto L14;
        Context r3 = this.mContext;
        long r4 = this.mCurId;
        this.mCurId = 1 + r4;
        r2 = new AppEntry(r3, r9, r4);
        if (r1 != null) goto L10;
        r1 = new HashMap();
        this.mUserIdEntriesMap.put(r0, r1);
    L10:
        r1.put(r9.packageName, r2);
        r2.isWork = this.mUm.isManagedProfile(r0);     // Catch: Exception -> L22
    L12:
        this.mAppEntries.add(r2);
    L21:
        return r2;
    L14:
        if (r2.info == r9) goto L21;
        r2.info = r9;
        if (r9.sourceDir == null) goto L19;
        r2.apkFile = new File(r9.sourceDir);
    L19:
        if (r9.dataDir == null) goto L21;
        r2.dataFile = new File(r9.dataDir);
        goto L21
    L5:
        r2 = null;
        goto L6
    }

    public AppEntry getEntryWithoutPinyin(Context r8, ApplicationInfo r9) {
        AppEntry r6 = new AppEntry(r8, r9, 0, true);
        refreshSizeInfo(r8, r9, r6);
        return r6;
    }

    public void refreshSizeInfo(Context r3, ApplicationInfo r4, final AppEntry r5) {
        MultiSDKAdapter.getPackageSizeInfoAsUser(r3, r4, UserHandle.getUserId(r4.uid), new AnonymousClass17(this, r5));
    }

    private long getTotalInternalSize(PackageStats r3) {
        if (r3 != null) goto L4;
        return -2;
    L4:
        return r3.codeSize + r3.dataSize;
    }

    private long getTotalExternalSize(PackageStats r5) {
        if (r5 != null) goto L4;
        return -2;
    L4:
        return (((r5.externalCodeSize + r5.externalDataSize) + r5.externalCacheSize) + r5.externalMediaSize) + r5.externalObbSize;
    }

    private String getSizeStr(long r1) {
        return Utils.formatFileSize(this.mContext, r1);
    }

    private static List<UserHandle> getNonDoppelgangerProfiles(UserManager r1) {
        List<UserHandle> r2 = r1.getUserProfiles();
        r2.removeIf(new ApplicationsState$$ExternalSyntheticLambda0());
        return r2;
    }

    static /* synthetic */ boolean lambda$getNonDoppelgangerProfiles$0(UserHandle r1) {
        if (r1.getIdentifier() != 10) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isFeedbackApp(String r1) {
        if (TextUtils.equals(r1, "com.obric.feedback") == false) goto L5;
    L8:
        return true;
    L5:
        if (TextUtils.equals(r1, FEEDBACK_ENTRY) == true) goto L8;
        return false;
    }

    public static void setFeedbackAppNotificationsEnabled(Context r0, String r1, boolean r2) {
        if (isFeedbackApp(r1) == false) goto L6;
        Settings.System.putInt(r0.getContentResolver(), "System.Settings.FeedbackNotifiCation", r2 ? 1 : 0);
        return;
    }
}
