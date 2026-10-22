package com.android.settingslib.applications;

import android.app.ActivityManager;
import android.app.AppGlobals;
import android.app.Application;
import android.app.usage.StorageStats;
import android.app.usage.StorageStatsManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.IPackageManager;
import android.content.pm.IPackageStatsObserver;
import android.content.pm.ModuleInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageStats;
import android.content.pm.ResolveInfo;
import android.content.pm.UserInfo;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Flags;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import android.os.UserHandle;
import android.os.UserManager;
import android.text.format.Formatter;
import android.util.ArrayMap;
import android.util.SparseArray;
import androidx.core.content.IntentCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.GlobalProxyLancet;
import com.android.internal.util.ArrayUtils;
import com.android.settings.SettingsApplication;
import com.android.settings.SettingsInitialize;
import com.android.settingslib.Utils;
import com.android.settingslib.utils.R;
import com.android.settingslib.utils.ThreadUtils;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.io.File;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Insert;

/* JADX INFO: loaded from: classes.dex */
public class ApplicationsState {
    public static final Comparator<AppEntry> ALPHA_COMPARATOR = null;
    private static final boolean DEBUG = false;
    private static final boolean DEBUG_LOCKING = false;
    public static final int DEFAULT_SESSION_FLAGS = 15;
    public static final Comparator<AppEntry> EXTERNAL_SIZE_COMPARATOR = null;
    public static final AppFilter FILTER_ALL_ENABLED = null;
    public static final AppFilter FILTER_APPS_EXCEPT_GAMES = null;
    public static final AppFilter FILTER_AUDIO = null;
    public static final AppFilter FILTER_DISABLED = null;
    public static final AppFilter FILTER_DOWNLOADED_AND_LAUNCHER = null;
    public static final AppFilter FILTER_DOWNLOADED_AND_LAUNCHER_AND_INSTANT = null;
    public static final AppFilter FILTER_DOWNLOADED_AND_LAUNCHER_NOT_QUIET = null;
    public static final AppFilter FILTER_ENABLED_NOT_QUIET = null;
    public static final AppFilter FILTER_EVERYTHING = null;
    public static final AppFilter FILTER_GAMES = null;
    public static final AppFilter FILTER_INSTANT = null;
    public static final AppFilter FILTER_MOVIES = null;
    public static final AppFilter FILTER_NOT_HIDE = null;
    public static final AppFilter FILTER_OTHER_APPS = null;
    public static final AppFilter FILTER_PERSONAL = null;
    public static final AppFilter FILTER_PHOTOS = null;
    public static final AppFilter FILTER_PRIVATE_PROFILE = null;
    public static final AppFilter FILTER_THIRD_PARTY = null;
    public static final AppFilter FILTER_WITHOUT_DISABLED_UNTIL_USED = null;
    public static final AppFilter FILTER_WITH_DOMAIN_URLS = null;
    public static final AppFilter FILTER_WORK = null;
    public static final int FLAG_SESSION_REQUEST_HOME_APP = 1;
    public static final int FLAG_SESSION_REQUEST_ICONS = 2;
    public static final int FLAG_SESSION_REQUEST_LAUNCHER = 8;
    public static final int FLAG_SESSION_REQUEST_LEANBACK_LAUNCHER = 16;
    public static final int FLAG_SESSION_REQUEST_SIZES = 4;
    public static final Comparator<AppEntry> INTERNAL_SIZE_COMPARATOR = null;
    private static final Pattern REMOVE_DIACRITICALS_PATTERN = null;
    private static final String SETTING_PKG = "com.android.settings";
    public static final Comparator<AppEntry> SIZE_COMPARATOR = null;
    public static final int SIZE_INVALID = -2;
    public static final int SIZE_UNKNOWN = -1;
    private static final String TAG = "ApplicationsState";
    private static boolean sAppIconCacheEnabled;
    static ApplicationsState sInstance;
    private static final Object sLock = null;
    final ArrayList<WeakReference<Session>> mActiveSessions;
    final int mAdminRetrieveFlags;
    final ArrayList<AppEntry> mAppEntries;
    List<ApplicationInfo> mApplications;
    final BackgroundHandler mBackgroundHandler;
    PackageIntentReceiver mClonePackageIntentReceiver;
    final Context mContext;
    String mCurComputingSizePkg;
    int mCurComputingSizeUserId;
    UUID mCurComputingSizeUuid;
    long mCurId;
    final SparseArray<HashMap<String, AppEntry>> mEntriesMap;
    boolean mHaveDisabledApps;
    boolean mHaveInstantApps;
    private InterestingConfigChanges mInterestingConfigChanges;
    final IPackageManager mIpm;
    final MainHandler mMainHandler;
    PackageIntentReceiver mPackageIntentReceiver;
    final PackageManager mPm;
    final ArrayList<Session> mRebuildingSessions;
    boolean mResumed;
    final int mRetrieveFlags;
    final ArrayList<Session> mSessions;
    boolean mSessionsChanged;
    final StorageStatsManager mStats;
    final HashMap<String, Boolean> mSystemModules;
    final HandlerThread mThread;
    final UserManager mUm;

    public static class AppEntry extends SizeInfo {

        @Nullable
        public final File apkFile;
        public long externalSize;
        public String externalSizeStr;
        public Object extraInfo;
        public boolean hasLauncherEntry;
        public boolean hideInQuietMode;
        public Drawable icon;
        public final long id;
        public ApplicationInfo info;
        public long internalSize;
        public String internalSizeStr;
        public boolean isHomeApp;
        public String label;
        public String labelDescription;
        public boolean launcherEntryEnabled;
        String mProfileType;
        public boolean mounted;
        public String normalizedLabel;
        public boolean showInPersonalTab;
        public long size;
        public long sizeLoadStart;
        public boolean sizeStale;
        public String sizeStr;

        public String getNormalizedLabel() {
            String r0 = this.normalizedLabel;
            if (r0 == null) goto L5;
            return r0;
        L5:
            String r1 = ApplicationsState.normalize(this.label);
            this.normalizedLabel = r1;
            return r1;
        }

        public AppEntry(final Context r3, ApplicationInfo r4, long r5) {
            if (r4.sourceDir == null) goto L5;
            File r0 = new File(r4.sourceDir);
        L6:
            this.apkFile = r0;
            this.id = r5;
            this.info = r4;
            this.size = -1;
            this.sizeStale = true;
            ensureLabel(r3);
            if (this.labelDescription != null) goto L9;
            ThreadUtils.getBackgroundExecutor().submit(new ApplicationsState$AppEntry$$ExternalSyntheticLambda0(this, r3));
        L9:
            UserManager r6 = UserManager.get(r3);
            this.mProfileType = r6.getUserInfo(UserHandle.getUserId(r4.uid)).userType;
            this.showInPersonalTab = shouldShowInPersonalTab(r6, r4.uid);
            this.hideInQuietMode = shouldHideInQuietMode(r6, r4.uid);
            return;
        L5:
            r0 = null;
            goto L6
        }

        /* JADX INFO: renamed from: lambda$new$0$com-android-settingslib-applications-ApplicationsState$AppEntry, reason: not valid java name */
        /* synthetic */ void m737x3d24fd27(Context r1) {
            ensureLabelDescriptionLocked(r1);
        }

        public boolean isClonedProfile() {
            return "android.os.usertype.profile.CLONE".equals(this.mProfileType);
        }

        public boolean isManagedProfile() {
            return "android.os.usertype.profile.MANAGED".equals(this.mProfileType);
        }

        public boolean isPrivateProfile() {
            if (Flags.allowPrivateProfile() == true) goto L5;
        L9:
            return false;
        L5:
            if (android.multiuser.Flags.enablePrivateSpaceFeatures() == false) goto L9;
            if ("android.os.usertype.profile.PRIVATE".equals(this.mProfileType) == false) goto L9;
            return true;
        }

        boolean shouldShowInPersonalTab(UserManager r4, int r5) {
            int r3 = UserHandle.getUserId(r5);
            if (r3 != ActivityManager.getCurrentUser()) goto L6;
            return true;
        L6:
            if (Build.VERSION.SDK_INT >= 34) goto L9;
            return false;
        L9:
            if (r4.getUserProperties(UserHandle.of(r3)).getShowInSettings() != 0) goto L12;
            return true;
        L12:
            return false;
        }

        public void ensureLabel(Context r2) {
            if (this.label != null) goto L5;
        L6:
            File r0 = this.apkFile;
            if (r0 != null) goto L9;
        L15:
            this.mounted = false;
            this.label = this.info.packageName;
            return;
        L9:
            if (r0.exists() == false) goto L15;
            this.mounted = true;
            CharSequence r3 = this.info.loadLabel(r2.getPackageManager());
            if (r3 == null) goto L13;
            String r4 = r3.toString();
        L14:
            this.label = r4;
            return;
        L13:
            r4 = this.info.packageName;
            goto L14
        L5:
            if (this.mounted == false) goto L6;
        }

        boolean ensureIconLocked(Context r4) {
            if (ApplicationsState.access$100(r4) == false) goto L6;
            return false;
        L6:
            if (this.icon != null) goto L15;
            File r0 = this.apkFile;
            if (r0 != null) goto L10;
        L13:
            this.mounted = false;
            this.icon = r4.getDrawable(17305168);
        L22:
            return false;
        L10:
            if (r0.exists() == false) goto L13;
            this.icon = Utils.getBadgedIcon(r4, this.info);
            return true;
        L15:
            if (this.mounted == true) goto L22;
            File r1 = this.apkFile;
            if (r1 == null) goto L22;
            if (r1.exists() == false) goto L22;
            this.mounted = true;
            this.icon = Utils.getBadgedIcon(r4, this.info);
            return true;
        }

        public String getVersion(Context r2) {
            return r2.getPackageManager().getPackageInfo(this.info.packageName, 0).versionName;
        L4:
            return "";
        }

        public void ensureLabelDescriptionLocked(Context r5) {
            if (UserManager.get(r5).isManagedProfile(UserHandle.getUserId(this.info.uid)) == false) goto L5;
            this.labelDescription = r5.getString(R.string.accessibility_work_profile_app_description, new Object[]{this.label});
            return;
        L5:
            this.labelDescription = this.label;
        }

        private boolean shouldHideInQuietMode(UserManager r1, int r2) {
            if (android.multiuser.Flags.enablePrivateSpaceFeatures() == true) goto L5;
            return false;
        L5:
            if (android.multiuser.Flags.handleInterleavedSettingsForPrivateSpace() == true) goto L7;
            return false;
        L7:
            return ApplicationsState.access$200(r1, UserHandle.of(UserHandle.getUserId(r2)));
        }
    }

    public interface AppFilter {
        boolean filterApp(AppEntry r1);

        void init();

        default void refreshAppEntryOnRebuild(AppEntry r1, boolean r2) {
        }

        default void init(Context r1) {
            init();
        }
    }

    private class BackgroundHandler extends Handler {
        static final int MSG_LOAD_ENTRIES = 2;
        static final int MSG_LOAD_HOME_APP = 3;
        static final int MSG_LOAD_ICONS = 6;
        static final int MSG_LOAD_LAUNCHER = 4;
        static final int MSG_LOAD_LEANBACK_LAUNCHER = 5;
        static final int MSG_LOAD_SIZES = 7;
        static final int MSG_REBUILD_LIST = 1;
        boolean mRunning;
        final IPackageStatsObserver.Stub mStatsObserver;
        final /* synthetic */ ApplicationsState this$0;

        BackgroundHandler(ApplicationsState r1, Looper r2) {
            this.this$0 = r1;
            super(r2);
            this.mStatsObserver = new AnonymousClass1(this);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r19) {
            ArrayList<Session> r2 = this.this$0.mRebuildingSessions;
            monitor-enter(r2);
        L180:
            th = move-exception;
            throw th;
        L5:
            if (this.this$0.mRebuildingSessions.size() <= 0) goto L7;
            ArrayList r3 = new ArrayList(this.this$0.mRebuildingSessions);     // Catch: Throwable -> L180
            this.this$0.mRebuildingSessions.clear();     // Catch: Throwable -> L180
        L8:
            monitor-exit(r2);     // Catch: Throwable -> L180
            if (r3 == null) goto L14;
            Iterator r4 = r3.iterator();
        L12:
            if (r4.hasNext() == false) goto L14;
            ((Session) r4.next()).handleRebuildList();
        L14:
            int r5 = getCombinedSessionFlags(this.this$0.mSessions);
            int r13 = 0;
            boolean r14 = true;
            switch(r19.what) {
                case 2: goto L143;
                case 3: goto L125;
                case 4: goto L89;
                case 5: goto L89;
                case 6: goto L54;
                case 7: goto L18;
                default: goto L227;
            };
        L143:
            SparseArray<HashMap<String, AppEntry>> r1 = this.this$0.mEntriesMap;
            monitor-enter(r1);
            int r6 = 0;
            int r7 = 0;
        L188:
        L176:
            th = move-exception;
            throw th;
        L147:
            if (r7 >= this.this$0.mApplications.size()) goto L168;
            if (r6 >= 6) goto L168;
            if (this.mRunning == true) goto L154;
            this.mRunning = true;     // Catch: Throwable -> L176
            this.this$0.mMainHandler.sendMessage(this.this$0.mMainHandler.obtainMessage(6, 1));     // Catch: Throwable -> L176
        L154:
            ApplicationInfo r8 = this.this$0.mApplications.get(r7);     // Catch: Throwable -> L176
            int r9 = UserHandle.getUserId(r8.uid);     // Catch: Throwable -> L176
            if (this.this$0.mEntriesMap.get(r9).get(r8.packageName) != null) goto L157;
            r6 = r6 + 1;     // Catch: Throwable -> L176
            ApplicationsState.access$300(this.this$0, r8);     // Catch: Throwable -> L176
        L157:
            if (r9 == 0) goto L167;
            if (this.this$0.mEntriesMap.indexOfKey(0) < 0) goto L167;
            AppEntry r10 = this.this$0.mEntriesMap.get(0).get(r8.packageName);     // Catch: Throwable -> L176
            if (r10 == null) goto L167;
            if (ApplicationsState.access$400(r10.info.flags, 8388608) == true) goto L167;
            this.this$0.mEntriesMap.get(0).remove(r8.packageName);     // Catch: Throwable -> L176
            this.this$0.mAppEntries.remove(r10);     // Catch: Throwable -> L176
        L167:
            r7 = r7 + 1;     // Catch: Throwable -> L176
        L168:
            monitor-exit(r1);     // Catch: Throwable -> L176
            if (r6 < 6) goto L173;
            sendEmptyMessage(2);
            return;
        L173:
            if (this.this$0.mMainHandler.hasMessages(8) == true) goto L175;
            this.this$0.mMainHandler.sendEmptyMessage(8);
        L175:
            sendEmptyMessage(3);
            return;
        L227:
            return;
        L18:
            if (ApplicationsState.access$400(r5, 4) == false) goto L179;
            SparseArray<HashMap<String, AppEntry>> r11 = this.this$0.mEntriesMap;
            monitor-enter(r11);
        L50:
            th = move-exception;
            throw th;
        L22:
            if (this.this$0.mCurComputingSizePkg == null) goto L25;
            monitor-exit(r11);     // Catch: Throwable -> L50
            return;
        L25:
            long r12 = SystemClock.uptimeMillis();     // Catch: Throwable -> L50
            int r15 = 0;
        L27:
            if (r15 >= this.this$0.mAppEntries.size()) goto L46;
            AppEntry r16 = this.this$0.mAppEntries.get(r15);     // Catch: Throwable -> L50
            if (ApplicationsState.access$400(r16.info.flags, 8388608) == false) goto L44;
            if (r16.size == (-1)) goto L35;
            if (r16.sizeStale == false) goto L44;
        L35:
            if (r16.sizeLoadStart == 0) goto L39;
            if (r16.sizeLoadStart < (r12 - TraceStatsConsts.PAGE_LOAD_MAX_LIMIT_MS)) goto L39;
        L42:
            monitor-exit(r11);     // Catch: Throwable -> L50
            return;
        L39:
            if (this.mRunning == true) goto L41;
            this.mRunning = true;     // Catch: Throwable -> L50
            this.this$0.mMainHandler.sendMessage(this.this$0.mMainHandler.obtainMessage(6, 1));     // Catch: Throwable -> L50
        L41:
            r16.sizeLoadStart = r12;     // Catch: Throwable -> L50
            this.this$0.mCurComputingSizeUuid = r16.info.storageUuid;     // Catch: Throwable -> L50
            this.this$0.mCurComputingSizePkg = r16.info.packageName;     // Catch: Throwable -> L50
            this.this$0.mCurComputingSizeUserId = UserHandle.getUserId(r16.info.uid);     // Catch: Throwable -> L50
            this.this$0.mBackgroundHandler.post(new ApplicationsState$BackgroundHandler$$ExternalSyntheticLambda0(this));     // Catch: Throwable -> L50
        L44:
            r15 = r15 + 1;     // Catch: Throwable -> L50
            goto L27
        L46:
            if (this.this$0.mMainHandler.hasMessages(5) == true) goto L48;
            this.this$0.mMainHandler.sendEmptyMessage(5);     // Catch: Throwable -> L50
            this.mRunning = false;     // Catch: Throwable -> L50
            this.this$0.mMainHandler.sendMessage(this.this$0.mMainHandler.obtainMessage(6, 0));     // Catch: Throwable -> L50
        L48:
            monitor-exit(r11);     // Catch: Throwable -> L50
            return;
        L179:
            return;
        L54:
            if (ApplicationsState.access$400(r5, 2) == false) goto L87;
            SparseArray<HashMap<String, AppEntry>> r17 = this.this$0.mEntriesMap;
            monitor-enter(r17);
            int r18 = 0;
        L185:
        L84:
            th = move-exception;
            throw th;
        L59:
            if (r13 >= this.this$0.mAppEntries.size()) goto L77;
            if (r18 >= 2) goto L77;
            AppEntry r20 = this.this$0.mAppEntries.get(r13);     // Catch: Throwable -> L84
            if (r20.icon != null) goto L64;
        L65:
            monitor-enter(r20);     // Catch: Throwable -> L84
            if (r20.ensureIconLocked(this.this$0.mContext) == true) goto L69;
        L72:
            monitor-exit(r20);     // Catch: Throwable -> L74
        L186:
            r13 = r13 + 1;     // Catch: Throwable -> L74
        L74:
            th = move-exception;
            throw th;     // Catch: Throwable -> L84
        L69:
            if (this.mRunning == true) goto L71;
            this.mRunning = true;     // Catch: Throwable -> L74
            this.this$0.mMainHandler.sendMessage(this.this$0.mMainHandler.obtainMessage(6, 1));     // Catch: Throwable -> L74
        L71:
            r18 = r18 + 1;     // Catch: Throwable -> L74
            goto L72
        L64:
            if (r20.mounted == true) goto L186;
        L77:
            monitor-exit(r17);     // Catch: Throwable -> L84
            if (r18 > 0) goto L80;
        L82:
            if (r18 < 2) goto L87;
            sendEmptyMessage(6);
            return;
        L80:
            if (this.this$0.mMainHandler.hasMessages(3) == true) goto L82;
            this.this$0.mMainHandler.sendEmptyMessage(3);
        L87:
            sendEmptyMessage(7);
            return;
        L89:
            if (r19.what != 4) goto L93;
            if (ApplicationsState.access$400(r5, 8) == false) goto L93;
        L96:
            Intent r21 = new Intent("android.intent.action.MAIN", null);
            if (r19.what != 4) goto L99;
            String r22 = "android.intent.category.LAUNCHER";
        L100:
            r21.addCategory(r22);
            int r23 = 0;
        L102:
            if (r23 >= this.this$0.mEntriesMap.size()) goto L118;
            int r24 = this.this$0.mEntriesMap.keyAt(r23);
            List r25 = this.this$0.mPm.queryIntentActivitiesAsUser(r21, 786944, r24);
            SparseArray<HashMap<String, AppEntry>> r26 = this.this$0.mEntriesMap;
            monitor-enter(r26);
            HashMap<String, AppEntry> r27 = this.this$0.mEntriesMap.valueAt(r23);     // Catch: Throwable -> L114
            int r110 = r25.size();     // Catch: Throwable -> L114
            int r111 = r13;
        L106:
            if (r111 >= r110) goto L112;
            ResolveInfo r112 = (ResolveInfo) r25.get(r111);     // Catch: Throwable -> L114
            String r113 = r112.activityInfo.packageName;     // Catch: Throwable -> L114
            AppEntry r28 = r27.get(r113);     // Catch: Throwable -> L114
            if (r28 == null) goto L110;
            r28.hasLauncherEntry = r14;     // Catch: Throwable -> L114
            r28.launcherEntryEnabled |= r112.activityInfo.enabled;     // Catch: Throwable -> L114
        L111:
            r111 = r111 + 1;     // Catch: Throwable -> L114
            r14 = true;
            goto L106
        L110:
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(ApplicationsState.TAG, "Cannot find pkg: " + r113 + " on user " + r24);     // Catch: Throwable -> L114
            goto L111
        L112:
            monitor-exit(r26);     // Catch: Throwable -> L114
            r23 = r23 + 1;     // Catch: Throwable -> L114
            r13 = 0;
            r14 = true;
        L114:
            th = move-exception;
            throw th;
        L118:
            if (this.this$0.mMainHandler.hasMessages(7) == true) goto L121;
            this.this$0.mMainHandler.sendEmptyMessage(7);
        L121:
            if (r19.what != 4) goto L123;
            sendEmptyMessage(5);
            return;
        L123:
            sendEmptyMessage(6);
            return;
        L99:
            r22 = IntentCompat.CATEGORY_LEANBACK_LAUNCHER;
        L93:
            if (r19.what != 5) goto L121;
            if (ApplicationsState.access$400(r5, 16) == false) goto L121;
        L125:
            if (ApplicationsState.access$400(r5, 1) == false) goto L142;
            ArrayList r29 = new ArrayList();
            this.this$0.mPm.getHomeActivities(r29);
            SparseArray<HashMap<String, AppEntry>> r30 = this.this$0.mEntriesMap;
            monitor-enter(r30);
            int r31 = this.this$0.mEntriesMap.size();     // Catch: Throwable -> L139
            int r114 = 0;
        L129:
            if (r114 >= r31) goto L137;
            HashMap<String, AppEntry> r32 = this.this$0.mEntriesMap.valueAt(r114);     // Catch: Throwable -> L139
            Iterator r33 = r29.iterator();     // Catch: Throwable -> L139
        L132:
            if (r33.hasNext() == false) goto L136;
            AppEntry r34 = r32.get(((ResolveInfo) r33.next()).activityInfo.packageName);     // Catch: Throwable -> L139
            if (r34 == null) goto L132;
            r34.isHomeApp = true;     // Catch: Throwable -> L139
            goto L132
        L136:
            r114 = r114 + 1;     // Catch: Throwable -> L139
            goto L129
        L137:
            monitor-exit(r30);     // Catch: Throwable -> L139
        L139:
            th = move-exception;
            throw th;
        L142:
            sendEmptyMessage(4);
            return;
        L7:
            r3 = null;
            goto L8
        }

        /* JADX INFO: renamed from: lambda$handleMessage$0$com-android-settingslib-applications-ApplicationsState$BackgroundHandler, reason: not valid java name */
        /* synthetic */ void m738x363bbbe7() {
            StorageStats r0 = this.this$0.mStats.queryStatsForPackage(this.this$0.mCurComputingSizeUuid, this.this$0.mCurComputingSizePkg, UserHandle.of(this.this$0.mCurComputingSizeUserId));     // Catch: Throwable -> L5
            PackageStats r1 = new PackageStats(this.this$0.mCurComputingSizePkg, this.this$0.mCurComputingSizeUserId);     // Catch: Throwable -> L5
            r1.codeSize = r0.getAppBytes();     // Catch: Throwable -> L5
            r1.dataSize = r0.getDataBytes();     // Catch: Throwable -> L5
            r1.cacheSize = r0.getCacheBytes();     // Catch: Throwable -> L5
            this.mStatsObserver.onGetStatsCompleted(r1, true);     // Catch: Throwable -> L5 Throwable -> L5 RemoteException -> L9
            goto L14
        L13:
            return;
        L5:
            e = move-exception;
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(ApplicationsState.TAG, "Failed to query stats: " + e);
            this.mStatsObserver.onGetStatsCompleted(null, false);     // Catch: RemoteException -> L9
            return;
        }

        private int getCombinedSessionFlags(List<Session> r3) {
            SparseArray<HashMap<String, AppEntry>> r2 = this.this$0.mEntriesMap;
            monitor-enter(r2);
            Iterator<Session> r4 = r3.iterator();     // Catch: Throwable -> L10
            int r0 = 0;
        L6:
            if (r4.hasNext() == false) goto L8;
            r0 = r0 | Session.access$500(r4.next());     // Catch: Throwable -> L10
            goto L6
        L8:
            monitor-exit(r2);     // Catch: Throwable -> L10
            return r0;
        L10:
            th = move-exception;
            throw th;
        }
    }

    public interface Callbacks {
        void onAllSizesComputed();

        void onLauncherInfoChanged();

        void onLoadEntriesCompleted();

        void onPackageIconChanged();

        void onPackageListChanged();

        void onPackageSizeChanged(String r1);

        void onRebuildComplete(ArrayList<AppEntry> r1);

        void onRunningStateChanged(boolean r1);
    }

    public static class CompoundFilter implements AppFilter {
        private final AppFilter mFirstFilter;
        private final AppFilter mSecondFilter;

        public CompoundFilter(AppFilter r1, AppFilter r2) {
            this.mFirstFilter = r1;
            this.mSecondFilter = r2;
        }

        @Override // com.android.settingslib.applications.ApplicationsState.AppFilter
        public void init(Context r2) {
            this.mFirstFilter.init(r2);
            this.mSecondFilter.init(r2);
        }

        @Override // com.android.settingslib.applications.ApplicationsState.AppFilter
        public void init() {
            this.mFirstFilter.init();
            this.mSecondFilter.init();
        }

        @Override // com.android.settingslib.applications.ApplicationsState.AppFilter
        public boolean filterApp(AppEntry r2) {
            if (this.mFirstFilter.filterApp(r2) == true) goto L5;
        L7:
            return false;
        L5:
            if (this.mSecondFilter.filterApp(r2) == false) goto L7;
            return true;
        }
    }

    class MainHandler extends Handler {
        static final int MSG_ALL_SIZES_COMPUTED = 5;
        static final int MSG_LAUNCHER_INFO_CHANGED = 7;
        static final int MSG_LOAD_ENTRIES_COMPLETE = 8;
        static final int MSG_PACKAGE_ICON_CHANGED = 3;
        static final int MSG_PACKAGE_LIST_CHANGED = 2;
        static final int MSG_PACKAGE_SIZE_CHANGED = 4;
        static final int MSG_REBUILD_COMPLETE = 1;
        static final int MSG_RUNNING_STATE_CHANGED = 6;
        final /* synthetic */ ApplicationsState this$0;

        public MainHandler(ApplicationsState r1, Looper r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r3) {
            this.this$0.rebuildActiveSessions();
            switch(r3.what) {
                case 1: goto L51;
                case 2: goto L45;
                case 3: goto L39;
                case 4: goto L33;
                case 5: goto L27;
                case 6: goto L17;
                case 7: goto L11;
                case 8: goto L5;
                default: goto L58;
            };
        L5:
            Iterator<WeakReference<Session>> r2 = this.this$0.mActiveSessions.iterator();
        L7:
            if (r2.hasNext() == false) goto L101;
            Session r4 = r2.next().get();
            if (r4 == null) goto L7;
            r4.mCallbacks.onLoadEntriesCompleted();
            goto L7
        L101:
            return;
        L11:
            Iterator<WeakReference<Session>> r5 = this.this$0.mActiveSessions.iterator();
        L13:
            if (r5.hasNext() == false) goto L102;
            Session r6 = r5.next().get();
            if (r6 == null) goto L13;
            r6.mCallbacks.onLauncherInfoChanged();
            goto L13
        L102:
            return;
        L17:
            Iterator<WeakReference<Session>> r7 = this.this$0.mActiveSessions.iterator();
        L19:
            if (r7.hasNext() == false) goto L103;
            Session r0 = r7.next().get();
            if (r0 == null) goto L19;
            Callbacks r1 = r0.mCallbacks;
            if (r3.arg1 == 0) goto L25;
            boolean r8 = true;
        L26:
            r1.onRunningStateChanged(r8);
            goto L19
        L25:
            r8 = false;
            goto L26
        L103:
            return;
        L27:
            Iterator<WeakReference<Session>> r9 = this.this$0.mActiveSessions.iterator();
        L29:
            if (r9.hasNext() == false) goto L104;
            Session r10 = r9.next().get();
            if (r10 == null) goto L29;
            r10.mCallbacks.onAllSizesComputed();
            goto L29
        L104:
            return;
        L33:
            Iterator<WeakReference<Session>> r11 = this.this$0.mActiveSessions.iterator();
        L35:
            if (r11.hasNext() == false) goto L105;
            Session r12 = r11.next().get();
            if (r12 == null) goto L35;
            r12.mCallbacks.onPackageSizeChanged((String) r3.obj);
            goto L35
        L105:
            return;
        L39:
            Iterator<WeakReference<Session>> r13 = this.this$0.mActiveSessions.iterator();
        L41:
            if (r13.hasNext() == false) goto L106;
            Session r14 = r13.next().get();
            if (r14 == null) goto L41;
            r14.mCallbacks.onPackageIconChanged();
            goto L41
        L106:
            return;
        L45:
            Iterator<WeakReference<Session>> r15 = this.this$0.mActiveSessions.iterator();
        L47:
            if (r15.hasNext() == false) goto L107;
            Session r16 = r15.next().get();
            if (r16 == null) goto L47;
            r16.mCallbacks.onPackageListChanged();
            goto L47
        L107:
            return;
        L51:
            Session r17 = (Session) r3.obj;
            Iterator<WeakReference<Session>> r18 = this.this$0.mActiveSessions.iterator();
        L53:
            if (r18.hasNext() == false) goto L108;
            Session r19 = r18.next().get();
            if (r19 == null) goto L53;
            if (r19 != r17) goto L53;
            r17.mCallbacks.onRebuildComplete(r17.mLastAppList);
            goto L53
        L108:
            return;
        }
    }

    private class PackageIntentReceiver extends BroadcastReceiver {
        final /* synthetic */ ApplicationsState this$0;

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r1, Intent r2) {
            com_android_settingslib_applications_ApplicationsState$PackageIntentReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(this, r1, r2);
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
            GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this.this$0.mContext, this, r0);
            IntentFilter r1 = new IntentFilter();
            r1.addAction("android.intent.action.EXTERNAL_APPLICATIONS_AVAILABLE");
            r1.addAction("android.intent.action.EXTERNAL_APPLICATIONS_UNAVAILABLE");
            GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this.this$0.mContext, this, r1);
            IntentFilter r2 = new IntentFilter();
            r2.addAction("android.intent.action.USER_ADDED");
            r2.addAction("android.intent.action.USER_REMOVED");
            GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this.this$0.mContext, this, r2);
        }

        void unregisterReceiver() {
            this.this$0.mContext.unregisterReceiver(this);
        }

        public void com_android_settingslib_applications_ApplicationsState$PackageIntentReceiver__onReceive$___twin___(Context r7, Intent r8) {
            String r9 = r8.getAction();
            int r1 = 0;
            if ("android.intent.action.PACKAGE_ADDED".equals(r9) == false) goto L9;
            String r10 = r8.getData().getEncodedSchemeSpecificPart();
        L6:
            if (r1 >= this.this$0.mEntriesMap.size()) goto L56;
            ApplicationsState r11 = this.this$0;
            r11.addPackage(r10, r11.mEntriesMap.keyAt(r1));
            r1 = r1 + 1;
            goto L6
        L56:
            return;
        L9:
            if ("android.intent.action.PACKAGE_REMOVED".equals(r9) == false) goto L15;
            String r12 = r8.getData().getEncodedSchemeSpecificPart();
        L12:
            if (r1 >= this.this$0.mEntriesMap.size()) goto L57;
            ApplicationsState r13 = this.this$0;
            r13.removePackage(r12, r13.mEntriesMap.keyAt(r1));
            r1 = r1 + 1;
            goto L12
        L57:
            return;
        L15:
            if ("android.intent.action.PACKAGE_CHANGED".equals(r9) == false) goto L21;
            String r14 = r8.getData().getEncodedSchemeSpecificPart();
        L18:
            if (r1 >= this.this$0.mEntriesMap.size()) goto L58;
            ApplicationsState r15 = this.this$0;
            r15.invalidatePackage(r14, r15.mEntriesMap.keyAt(r1));
            r1 = r1 + 1;
            goto L18
        L58:
            return;
        L21:
            if ("android.intent.action.EXTERNAL_APPLICATIONS_AVAILABLE".equals(r9) == false) goto L23;
        L31:
            String[] r16 = r8.getStringArrayExtra("android.intent.extra.changed_package_list");
            if (r16 != null) goto L34;
            return;
        L34:
            if (r16.length != 0) goto L37;
            return;
        L37:
            if ("android.intent.action.EXTERNAL_APPLICATIONS_AVAILABLE".equals(r9) == false) goto L54;
            int r17 = r16.length;
            int r0 = 0;
        L39:
            if (r0 >= r17) goto L59;
            String r2 = r16[r0];
            int r3 = 0;
        L42:
            if (r3 >= this.this$0.mEntriesMap.size()) goto L44;
            ApplicationsState r4 = this.this$0;
            r4.invalidatePackage(r2, r4.mEntriesMap.keyAt(r3));
            r3 = r3 + 1;
            goto L42
        L44:
            r0 = r0 + 1;
            goto L39
        L59:
            return;
        L54:
            return;
        L23:
            if ("android.intent.action.EXTERNAL_APPLICATIONS_UNAVAILABLE".equals(r9) == true) goto L31;
            if ("android.intent.action.USER_ADDED".equals(r9) == false) goto L29;
            ApplicationsState.access$900(this.this$0, r8.getIntExtra("android.intent.extra.user_handle", -10000));
            return;
        L29:
            if ("android.intent.action.USER_REMOVED".equals(r9) == false) goto L51;
            ApplicationsState.access$1000(this.this$0, r8.getIntExtra("android.intent.extra.user_handle", -10000));
            return;
        }

        public void registerReceiverForClone(int r7) {
            IntentFilter r3 = new IntentFilter("android.intent.action.PACKAGE_ADDED");
            r3.addDataScheme("package");
            this.this$0.mContext.registerReceiverAsUser(this, UserHandle.of(r7), r3, null, null);
        }

        @Insert("onReceive")
        public static void com_android_settingslib_applications_ApplicationsState$PackageIntentReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(PackageIntentReceiver r7, Context r8, Intent r9) {
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
            r7.com_android_settingslib_applications_ApplicationsState$PackageIntentReceiver__onReceive$___twin___(r8, r9);
            return;
        L13:
            GrantUtil r11 = GrantUtil.INSTANCE;
            Application r12 = SettingsApplication.getApplication();
            Intrinsics.checkNotNullExpressionValue(r12, "getApplication(...)");
            if (r11.isSetupCompelete(r12) == true) goto L16;
            OLog.i("PrivacyHookForReceiver", "onReceive !isSetupCompeleted hooked for " + r3 + ", " + r2);
            r7.com_android_settingslib_applications_ApplicationsState$PackageIntentReceiver__onReceive$___twin___(r8, r9);
            return;
        L16:
            String r13 = r3;
            if (r13 != null) goto L19;
        L22:
            boolean r14 = true;
        L23:
            if (r14 == false) goto L26;
            OLog.i("PrivacyHookForReceiver", "onReceive !simpleName hooked for " + r3 + ", " + r2);
            r7.com_android_settingslib_applications_ApplicationsState$PackageIntentReceiver__onReceive$___twin___(r8, r9);
            return;
        L26:
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == true) goto L30;
            if (r4 == true) goto L30;
            OLog.i("PrivacyHookForReceiver", "onReceive !isPrivacyAllowed hooked for " + r3 + ", " + r2);
            return;
        L30:
            GrantUtil.INSTANCE.applicationInit();
            r7.com_android_settingslib_applications_ApplicationsState$PackageIntentReceiver__onReceive$___twin___(r8, r9);
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

    public class Session implements LifecycleObserver {
        final Callbacks mCallbacks;
        private int mFlags;
        private final boolean mHasLifecycle;
        ArrayList<AppEntry> mLastAppList;
        Comparator<AppEntry> mRebuildComparator;
        AppFilter mRebuildFilter;
        boolean mRebuildForeground;
        boolean mRebuildRequested;
        final Object mRebuildSync;
        boolean mResumed;
        final /* synthetic */ ApplicationsState this$0;

        static /* synthetic */ int access$500(Session r0) {
            return r0.mFlags;
        }

        Session(ApplicationsState r2, Callbacks r3, Lifecycle r4) {
            this.this$0 = r2;
            this.mRebuildSync = new Object();
            this.mFlags = 15;
            this.mCallbacks = r3;
            if (r4 == null) goto L5;
            r4.addObserver(this);
            this.mHasLifecycle = true;
        L7:
            if (ApplicationsState.access$100(r2.mContext) == false) goto L10;
            this.mFlags &= -3;
            return;
        L10:
            return;
        L5:
            this.mHasLifecycle = false;
            goto L7
        }

        public int getSessionFlags() {
            return this.mFlags;
        }

        public void setSessionFlags(int r2) {
            if (ApplicationsState.access$100(this.this$0.mContext) == false) goto L5;
            this.mFlags = r2 & (-3);
            return;
        L5:
            this.mFlags = r2;
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
        public void onResume() {
            SparseArray<HashMap<String, AppEntry>> r0 = this.this$0.mEntriesMap;
            monitor-enter(r0);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (this.mResumed == true) goto L7;
            this.mResumed = true;     // Catch: Throwable -> L9
            this.this$0.mSessionsChanged = true;     // Catch: Throwable -> L9
            this.this$0.doPauseLocked();     // Catch: Throwable -> L9
            this.this$0.doResumeIfNeededLocked();     // Catch: Throwable -> L9
        L7:
            monitor-exit(r0);     // Catch: Throwable -> L9
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
        public void onPause() {
            SparseArray<HashMap<String, AppEntry>> r0 = this.this$0.mEntriesMap;
            monitor-enter(r0);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (this.mResumed == false) goto L7;
            this.mResumed = false;     // Catch: Throwable -> L9
            this.this$0.mSessionsChanged = true;     // Catch: Throwable -> L9
            this.this$0.mBackgroundHandler.removeMessages(1, this);     // Catch: Throwable -> L9
            this.this$0.doPauseIfNeededLocked();     // Catch: Throwable -> L9
        L7:
            monitor-exit(r0);     // Catch: Throwable -> L9
        }

        public void activateSession() {
            SparseArray<HashMap<String, AppEntry>> r0 = this.this$0.mEntriesMap;
            monitor-enter(r0);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (this.mResumed == true) goto L7;
            this.mResumed = true;     // Catch: Throwable -> L9
            this.this$0.mSessionsChanged = true;     // Catch: Throwable -> L9
        L7:
            monitor-exit(r0);     // Catch: Throwable -> L9
        }

        public void deactivateSession() {
            SparseArray<HashMap<String, AppEntry>> r0 = this.this$0.mEntriesMap;
            monitor-enter(r0);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (this.mResumed == false) goto L7;
            this.mResumed = false;     // Catch: Throwable -> L9
            this.this$0.mSessionsChanged = true;     // Catch: Throwable -> L9
        L7:
            monitor-exit(r0);     // Catch: Throwable -> L9
        }

        public ArrayList<AppEntry> getAllApps() {
            SparseArray<HashMap<String, AppEntry>> r0 = this.this$0.mEntriesMap;
            monitor-enter(r0);
            ArrayList<AppEntry> r1 = new ArrayList(this.this$0.mAppEntries);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public ArrayList<AppEntry> rebuild(AppFilter r2, Comparator<AppEntry> r3) {
            return rebuild(r2, r3, true);
        }

        public ArrayList<AppEntry> rebuild(AppFilter r4, Comparator<AppEntry> r5, boolean r6) {
            Object r0 = this.mRebuildSync;
            monitor-enter(r0);
            ArrayList<Session> r1 = this.this$0.mRebuildingSessions;     // Catch: Throwable -> L16
            monitor-enter(r1);     // Catch: Throwable -> L16
            this.this$0.mRebuildingSessions.add(this);     // Catch: Throwable -> L13
            this.mRebuildRequested = true;     // Catch: Throwable -> L13
            this.mRebuildFilter = r4;     // Catch: Throwable -> L13
            this.mRebuildComparator = r5;     // Catch: Throwable -> L13
            this.mRebuildForeground = r6;     // Catch: Throwable -> L13
            if (this.this$0.mBackgroundHandler.hasMessages(1) == true) goto L9;
            Message r7 = this.this$0.mBackgroundHandler.obtainMessage(1);     // Catch: Throwable -> L13
            this.this$0.mBackgroundHandler.sendMessage(r7);     // Catch: Throwable -> L13
        L9:
            monitor-exit(r1);     // Catch: Throwable -> L13
            monitor-exit(r0);     // Catch: Throwable -> L16
            return null;
        L13:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L16:
            th = move-exception;
            throw th;
        }

        void handleRebuildList() {
            if (this.mResumed == true) goto L5;
            return;
        L5:
            Object r0 = this.mRebuildSync;
            monitor-enter(r0);
        L71:
            th = move-exception;
            throw th;
        L8:
            if (this.mRebuildRequested == true) goto L11;
            monitor-exit(r0);     // Catch: Throwable -> L71
            return;
        L11:
            AppFilter r1 = this.mRebuildFilter;     // Catch: Throwable -> L71
            Comparator<AppEntry> r2 = this.mRebuildComparator;     // Catch: Throwable -> L71
            this.mRebuildRequested = false;     // Catch: Throwable -> L71
            this.mRebuildFilter = null;     // Catch: Throwable -> L71
            this.mRebuildComparator = null;     // Catch: Throwable -> L71
            if (this.mRebuildForeground == false) goto L14;
            Process.setThreadPriority(-2);     // Catch: Throwable -> L71
            this.mRebuildForeground = false;     // Catch: Throwable -> L71
        L14:
            monitor-exit(r0);     // Catch: Throwable -> L71
            if (r1 == null) goto L17;
            r1.init(this.this$0.mContext);
        L17:
            SparseArray<HashMap<String, AppEntry>> r3 = this.this$0.mEntriesMap;
            monitor-enter(r3);
            ArrayList r4 = new ArrayList(this.this$0.mAppEntries);     // Catch: Throwable -> L68
            monitor-exit(r3);     // Catch: Throwable -> L68
            ArrayMap r5 = new ArrayMap();
            ArrayList<AppEntry> r6 = new ArrayList();
            Iterator r7 = r4.iterator();
        L23:
            if (r7.hasNext() == false) goto L46;
            AppEntry r8 = (AppEntry) r7.next();
            if (android.multiuser.Flags.enablePrivateSpaceFeatures() == true) goto L27;
        L32:
            if (r8 == null) goto L23;
            if (r1 == null) goto L36;
            if (r1.filterApp(r8) == false) goto L23;
        L36:
            SparseArray<HashMap<String, AppEntry>> r9 = this.this$0.mEntriesMap;
            monitor-enter(r9);
            if (r2 != null) goto L81;
        L40:
            r6.add(r8);     // Catch: Throwable -> L43
            monitor-exit(r9);     // Catch: Throwable -> L43
            goto L23
        L81:
            r8.ensureLabel(this.this$0.mContext);     // Catch: Throwable -> L43
        L43:
            th = move-exception;
            throw th;
        L27:
            if (android.multiuser.Flags.handleInterleavedSettingsForPrivateSpace() == false) goto L32;
            UserHandle r10 = UserHandle.of(UserHandle.getUserId(r8.info.uid));
            if (r5.containsKey(r10) == true) goto L31;
            r5.put(r10, Boolean.valueOf(ApplicationsState.access$200(this.this$0.mUm, r10)));
        L31:
            r1.refreshAppEntryOnRebuild(r8, ((Boolean) r5.get(r10)).booleanValue());
            goto L32
        L46:
            if (r2 == null) goto L55;
            SparseArray<HashMap<String, AppEntry>> r11 = this.this$0.mEntriesMap;
            monitor-enter(r11);
            Collections.sort(r6, r2);     // Catch: Throwable -> L52
            monitor-exit(r11);     // Catch: Throwable -> L52
        L52:
            th = move-exception;
            throw th;
        L55:
            Object r12 = this.mRebuildSync;
            monitor-enter(r12);
        L65:
            th = move-exception;
            throw th;
        L58:
            if (this.mRebuildRequested == true) goto L62;
            this.mLastAppList = r6;     // Catch: Throwable -> L65
            if (this.this$0.mMainHandler.hasMessages(1, this) == true) goto L62;
            Message r13 = this.this$0.mMainHandler.obtainMessage(1, this);     // Catch: Throwable -> L65
            this.this$0.mMainHandler.sendMessage(r13);     // Catch: Throwable -> L65
        L62:
            monitor-exit(r12);     // Catch: Throwable -> L65
            Process.setThreadPriority(10);
            return;
        L68:
            th = move-exception;
            throw th;
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        public void onDestroy() {
            if (this.mHasLifecycle == true) goto L5;
            onPause();
        L5:
            SparseArray<HashMap<String, AppEntry>> r0 = this.this$0.mEntriesMap;
            monitor-enter(r0);
            this.this$0.mSessions.remove(this);     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface SessionFlags {
    }

    public static class SizeInfo {
        public long cacheSize;
        public long codeSize;
        public long dataSize;
        public long externalCacheSize;
        public long externalCodeSize;
        public long externalDataSize;

        public SizeInfo() {
        }
    }

    public static class VolumeFilter implements AppFilter {
        private final String mVolumeUuid;

        @Override // com.android.settingslib.applications.ApplicationsState.AppFilter
        public void init() {
        }

        public VolumeFilter(String r1) {
            this.mVolumeUuid = r1;
        }

        @Override // com.android.settingslib.applications.ApplicationsState.AppFilter
        public boolean filterApp(AppEntry r1) {
            return Objects.equals(r1.info.volumeUuid, this.mVolumeUuid);
        }
    }

    private static boolean hasFlag(int r0, int r1) {
        if ((r0 & r1) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    static /* synthetic */ boolean access$100(Context r0) {
        return isAppIconCacheEnabled(r0);
    }

    static /* synthetic */ void access$1000(ApplicationsState r0, int r1) {
        r0.removeUser(r1);
    }

    static /* synthetic */ boolean access$200(UserManager r0, UserHandle r1) {
        return isHideInQuietEnabledForProfile(r0, r1);
    }

    static /* synthetic */ AppEntry access$300(ApplicationsState r0, ApplicationInfo r1) {
        return r0.getEntryLocked(r1);
    }

    static /* synthetic */ boolean access$400(int r0, int r1) {
        return hasFlag(r0, r1);
    }

    static /* synthetic */ long access$600(ApplicationsState r0, PackageStats r1) {
        return r0.getTotalInternalSize(r1);
    }

    static /* synthetic */ String access$700(ApplicationsState r0, long r1) {
        return r0.getSizeStr(r1);
    }

    static /* synthetic */ long access$800(ApplicationsState r0, PackageStats r1) {
        return r0.getTotalExternalSize(r1);
    }

    static /* synthetic */ void access$900(ApplicationsState r0, int r1) {
        r0.addUser(r1);
    }

    static {
        sLock = new Object();
        REMOVE_DIACRITICALS_PATTERN = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        sAppIconCacheEnabled = false;
        ALPHA_COMPARATOR = new AnonymousClass1();
        SIZE_COMPARATOR = new AnonymousClass2();
        INTERNAL_SIZE_COMPARATOR = new AnonymousClass3();
        EXTERNAL_SIZE_COMPARATOR = new AnonymousClass4();
        FILTER_PERSONAL = new AnonymousClass5();
        FILTER_WITHOUT_DISABLED_UNTIL_USED = new AnonymousClass6();
        FILTER_WORK = new AnonymousClass7();
        FILTER_PRIVATE_PROFILE = new AnonymousClass8();
        FILTER_DOWNLOADED_AND_LAUNCHER = new AnonymousClass9();
        FILTER_DOWNLOADED_AND_LAUNCHER_NOT_QUIET = new AnonymousClass10();
        FILTER_DOWNLOADED_AND_LAUNCHER_AND_INSTANT = new AnonymousClass11();
        FILTER_THIRD_PARTY = new AnonymousClass12();
        FILTER_DISABLED = new AnonymousClass13();
        FILTER_INSTANT = new AnonymousClass14();
        FILTER_ALL_ENABLED = new AnonymousClass15();
        FILTER_ENABLED_NOT_QUIET = new AnonymousClass16();
        FILTER_EVERYTHING = new AnonymousClass17();
        FILTER_WITH_DOMAIN_URLS = new AnonymousClass18();
        FILTER_NOT_HIDE = new AnonymousClass19();
        FILTER_GAMES = new AnonymousClass20();
        FILTER_AUDIO = new AnonymousClass21();
        FILTER_MOVIES = new AnonymousClass22();
        FILTER_PHOTOS = new AnonymousClass23();
        FILTER_OTHER_APPS = new AnonymousClass24();
        FILTER_APPS_EXCEPT_GAMES = new AnonymousClass25();
    }

    public static ApplicationsState getInstance(Application r1) {
        return getInstance(r1, AppGlobals.getPackageManager());
    }

    static ApplicationsState getInstance(Application r2, IPackageManager r3) {
        Object r0 = sLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L7;
        sInstance = new ApplicationsState(r2, r3);     // Catch: Throwable -> L10
    L7:
        ApplicationsState r4 = sInstance;     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r4;
    }

    public static void setAppIconCacheEnabled(boolean r0) {
        sAppIconCacheEnabled = r0;
    }

    void setInterestingConfigChanges(InterestingConfigChanges r1) {
        this.mInterestingConfigChanges = r1;
    }

    private ApplicationsState(Application r8, IPackageManager r9) {
        this.mSessions = new ArrayList();
        this.mRebuildingSessions = new ArrayList();
        this.mInterestingConfigChanges = new InterestingConfigChanges();
        this.mEntriesMap = new SparseArray();
        this.mAppEntries = new ArrayList();
        this.mApplications = new ArrayList();
        this.mCurId = 1;
        this.mSystemModules = new HashMap();
        this.mActiveSessions = new ArrayList();
        this.mMainHandler = new MainHandler(this, Looper.getMainLooper());
        this.mContext = r8;
        this.mPm = r8.getPackageManager();
        this.mIpm = r9;
        UserManager r10 = (UserManager) r8.getSystemService(UserManager.class);
        this.mUm = r10;
        this.mStats = (StorageStatsManager) r8.getSystemService(StorageStatsManager.class);
        int[] r11 = r10.getProfileIdsWithDisabled(UserHandle.myUserId());
        int r12 = r11.length;
        int r3 = 0;
    L3:
        if (r3 >= r12) goto L5;
        this.mEntriesMap.put(r11[r3], new HashMap());
        r3 = r3 + 1;
        goto L3
    L5:
        HandlerThread r13 = new HandlerThread("ApplicationsState.Loader");
        this.mThread = r13;
        r13.start();
        this.mBackgroundHandler = new BackgroundHandler(this, r13.getLooper());
        this.mAdminRetrieveFlags = 4227584;
        this.mRetrieveFlags = 33280;
        Iterator<ModuleInfo> r14 = this.mPm.getInstalledModules(0).iterator();
    L7:
        if (r14.hasNext() == false) goto L14;
        ModuleInfo r15 = r14.next();
        this.mSystemModules.put(r15.getPackageName(), Boolean.valueOf(r15.isHidden()));
        if (android.content.pm.Flags.provideInfoOfApkInApex() == false) goto L7;
        Iterator r2 = r15.getApkInApexPackageNames().iterator();
    L12:
        if (r2.hasNext() == false) goto L7;
        this.mSystemModules.put((String) r2.next(), Boolean.valueOf(r15.isHidden()));
        goto L12
    L14:
        SparseArray<HashMap<String, AppEntry>> r16 = this.mEntriesMap;
        monitor-enter(r16);
        this.mEntriesMap.wait(1);     // Catch: Throwable -> L18 InterruptedException -> L24
    L18:
        th = move-exception;
        throw th;
    L20:
        monitor-exit(r16);     // Catch: Throwable -> L18
    }

    public Looper getBackgroundLooper() {
        return this.mThread.getLooper();
    }

    public Session newSession(Callbacks r2) {
        return newSession(r2, null);
    }

    public Session newSession(Callbacks r2, Lifecycle r3) {
        Session r0 = new Session(this, r2, r3);
        SparseArray<HashMap<String, AppEntry>> r4 = this.mEntriesMap;
        monitor-enter(r4);
        this.mSessions.add(r0);     // Catch: Throwable -> L7
        monitor-exit(r4);     // Catch: Throwable -> L7
        return r0;
    L7:
        th = move-exception;
        throw th;
    }

    void doResumeIfNeededLocked() {
        if (this.mResumed == false) goto L5;
        return;
    L5:
        this.mResumed = true;
        AnonymousClass1 r2 = null;
        if (this.mPackageIntentReceiver != null) goto L9;
        PackageIntentReceiver r1 = new PackageIntentReceiver(this, r2);
        this.mPackageIntentReceiver = r1;
        r1.registerReceiver();
    L9:
        if (this.mClonePackageIntentReceiver != null) goto L13;
        int r3 = AppUtils.getCloneUserId(this.mContext);
        if (r3 == (-1)) goto L13;
        PackageIntentReceiver r4 = new PackageIntentReceiver(this, r2);
        this.mClonePackageIntentReceiver = r4;
        r4.registerReceiverForClone(r3);
    L13:
        List<ApplicationInfo> r5 = this.mApplications;
        this.mApplications = new ArrayList();
        Iterator r6 = this.mUm.getProfiles(UserHandle.myUserId()).iterator();
    L15:
        if (r6.hasNext() == false) goto L29;
        UserInfo r7 = (UserInfo) r6.next();
        if (this.mEntriesMap.indexOfKey(r7.id) >= 0) goto L20;
        this.mEntriesMap.put(r7.id, new HashMap());     // Catch: Exception -> L27
    L20:
        IPackageManager r8 = this.mIpm;     // Catch: Exception -> L27
        if (r7.isAdmin() == false) goto L24;
        int r9 = this.mAdminRetrieveFlags;     // Catch: Exception -> L27
    L25:
        this.mApplications.addAll(r8.getInstalledApplications(r9, r7.id).getList());     // Catch: Exception -> L27
        goto L15
    L24:
        r9 = this.mRetrieveFlags;     // Catch: Exception -> L27
    L27:
        e = move-exception;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_e(TAG, "Error during doResumeIfNeededLocked", e);
        goto L15
    L29:
        int r10 = 0;
        if (this.mInterestingConfigChanges.applyNewConfig(this.mContext.getResources()) == false) goto L32;
        clearEntries();
    L36:
        this.mHaveDisabledApps = false;
        this.mHaveInstantApps = false;
    L38:
        if (r10 >= this.mApplications.size()) goto L58;
        ApplicationInfo r11 = this.mApplications.get(r10);
        if (r11.enabled == true) goto L46;
        if (r11.enabledSetting == 3) goto L44;
        this.mApplications.remove(r10);
        r10 = r10 - 1;
    L56:
        r10 = r10 + 1;
        goto L38
    L44:
        this.mHaveDisabledApps = true;
    L46:
        if (isHiddenModule(r11.packageName) == false) goto L49;
        this.mApplications.remove(r10);
        r10 = r10 - 1;
        goto L56
    L49:
        if (this.mHaveInstantApps == false) goto L51;
    L53:
        AppEntry r12 = this.mEntriesMap.get(UserHandle.getUserId(r11.uid)).get(r11.packageName);
        if (r12 == null) goto L56;
        r12.info = r11;
        goto L56
    L51:
        if (AppUtils.isInstant(r11) == false) goto L53;
        this.mHaveInstantApps = true;
        goto L53
    L58:
        if (anyAppIsRemoved(r5, this.mApplications) == false) goto L60;
        clearEntries();
    L60:
        this.mCurComputingSizePkg = null;
        if (this.mBackgroundHandler.hasMessages(2) == true) goto L77;
        this.mBackgroundHandler.sendEmptyMessage(2);
        return;
    L77:
        return;
    L32:
        int r13 = 0;
    L34:
        if (r13 >= this.mAppEntries.size()) goto L36;
        this.mAppEntries.get(r13).sizeStale = true;
        r13 = r13 + 1;
        goto L34
    }

    private static boolean anyAppIsRemoved(List<ApplicationInfo> r7, List<ApplicationInfo> r8) {
        if (r7.size() != 0) goto L6;
        return false;
    L6:
        if (r8.size() >= r7.size()) goto L8;
        return true;
    L8:
        HashMap r0 = new HashMap();
        Iterator<ApplicationInfo> r9 = r8.iterator();
    L10:
        if (r9.hasNext() == false) goto L17;
        ApplicationInfo r2 = r9.next();
        String r5 = String.valueOf(UserHandle.getUserId(r2.uid));
        HashSet r6 = (HashSet) r0.get(r5);
        if (r6 != null) goto L15;
        r6 = new HashSet();
        r0.put(r5, r6);
    L15:
        if (hasFlag(r2.flags, 8388608) == false) goto L10;
        r6.add(r2.packageName);
        goto L10
    L17:
        Iterator<ApplicationInfo> r10 = r7.iterator();
    L19:
        if (r10.hasNext() == false) goto L28;
        ApplicationInfo r11 = r10.next();
        if (hasFlag(r11.flags, 8388608) == false) goto L19;
        HashSet r3 = (HashSet) r0.get(String.valueOf(UserHandle.getUserId(r11.uid)));
        if (r3 == null) goto L27;
        if (r3.remove(r11.packageName) == true) goto L19;
    L27:
        return true;
    L28:
        return false;
    }

    void clearEntries() {
        int r0 = 0;
    L4:
        if (r0 >= this.mEntriesMap.size()) goto L6;
        this.mEntriesMap.valueAt(r0).clear();
        r0 = r0 + 1;
        goto L4
    L6:
        this.mAppEntries.clear();
    }

    public boolean haveDisabledApps() {
        return this.mHaveDisabledApps;
    }

    public boolean haveInstantApps() {
        return this.mHaveInstantApps;
    }

    boolean isHiddenModule(String r1) {
        Boolean r0 = this.mSystemModules.get(r1);
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.booleanValue();
    }

    boolean isSystemModule(String r1) {
        return this.mSystemModules.containsKey(r1);
    }

    void doPauseIfNeededLocked() {
        if (this.mResumed == true) goto L5;
        return;
    L5:
        int r0 = 0;
    L7:
        if (r0 >= this.mSessions.size()) goto L12;
        if (this.mSessions.get(r0).mResumed == true) goto L10;
        r0 = r0 + 1;
        goto L7
    L10:
        return;
    L12:
        doPauseLocked();
    }

    void doPauseLocked() {
        this.mResumed = false;
        PackageIntentReceiver r0 = this.mPackageIntentReceiver;
        if (r0 == null) goto L5;
        r0.unregisterReceiver();
        this.mPackageIntentReceiver = null;
    L5:
        PackageIntentReceiver r1 = this.mClonePackageIntentReceiver;
        if (r1 == null) goto L9;
        r1.unregisterReceiver();
        this.mClonePackageIntentReceiver = null;
        return;
    }

    public AppEntry getEntry(String r7, int r8) {
        SparseArray<HashMap<String, AppEntry>> r0 = this.mEntriesMap;
        monitor-enter(r0);
        HashMap<String, AppEntry> r1 = this.mEntriesMap.get(r8);     // Catch: Throwable -> L21
        if (r1 == null) goto L7;
        AppEntry r2 = r1.get(r7);     // Catch: Throwable -> L21
    L8:
        if (r2 != null) goto L19;
        ApplicationInfo r3 = getAppInfoLocked(r7, r8);     // Catch: Throwable -> L21
        if (r3 == null) goto L24;
    L17:
        if (r3 == null) goto L19;
        r2 = getEntryLocked(r3);     // Catch: Throwable -> L21
        goto L19
    L24:
        r3 = this.mIpm.getApplicationInfo(r7, 4294967296L, r8);     // Catch: RemoteException -> L13 Throwable -> L21
    L13:
        e = move-exception;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "getEntry couldn't reach PackageManager", e);     // Catch: Throwable -> L21
        return null;
    L19:
        monitor-exit(r0);     // Catch: Throwable -> L21
        return r2;
    L7:
        r2 = null;
    L21:
        th = move-exception;
        throw th;
    }

    private ApplicationInfo getAppInfoLocked(String r4, int r5) {
        int r0 = 0;
    L4:
        if (r0 >= this.mApplications.size()) goto L11;
        ApplicationInfo r1 = this.mApplications.get(r0);
        if (r4.equals(r1.packageName) == false) goto L10;
        if (r5 != UserHandle.getUserId(r1.uid)) goto L10;
        return r1;
    L10:
        r0 = r0 + 1;
        goto L4
    L11:
        return null;
    }

    public void ensureIcon(AppEntry r2) {
        if (r2.icon == null) goto L5;
        return;
    L5:
        monitor-enter(r2);
        r2.ensureIconLocked(this.mContext);     // Catch: Throwable -> L9
        monitor-exit(r2);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void ensureLabelDescription(AppEntry r2) {
        if (r2.labelDescription == null) goto L5;
        return;
    L5:
        monitor-enter(r2);
        r2.ensureLabelDescriptionLocked(this.mContext);     // Catch: Throwable -> L9
        monitor-exit(r2);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void requestSize(final String r5, final int r6) {
        SparseArray<HashMap<String, AppEntry>> r0 = this.mEntriesMap;
        monitor-enter(r0);
        final AppEntry r1 = this.mEntriesMap.get(r6).get(r5);     // Catch: Throwable -> L11
        if (r1 != null) goto L7;
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L7:
        if (hasFlag(r1.info.flags, 8388608) == false) goto L9;
        this.mBackgroundHandler.post(new ApplicationsState$$ExternalSyntheticLambda0(this, r1, r5, r6));     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    /* JADX INFO: renamed from: lambda$requestSize$0$com-android-settingslib-applications-ApplicationsState, reason: not valid java name */
    /* synthetic */ void m736xde7da91e(AppEntry r4, String r5, int r6) {
        StorageStats r0 = this.mStats.queryStatsForPackage(r4.info.storageUuid, r5, UserHandle.of(r6));     // Catch: Throwable -> L5
        long r1 = this.mStats.getCacheQuotaBytes(r4.info.storageUuid.toString(), r4.info.uid);     // Catch: Throwable -> L5
        PackageStats r7 = new PackageStats(r5, r6);     // Catch: Throwable -> L5
        r7.codeSize = r0.getAppBytes();     // Catch: Throwable -> L5
        r7.dataSize = r0.getDataBytes();     // Catch: Throwable -> L5
        r7.cacheSize = Math.min(r0.getCacheBytes(), r1);     // Catch: Throwable -> L5
        this.mBackgroundHandler.mStatsObserver.onGetStatsCompleted(r7, true);     // Catch: Throwable -> L5 Throwable -> L5 RemoteException -> L9
    L10:
        return;
    L5:
        e = move-exception;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "Failed to query stats: " + e);
        this.mBackgroundHandler.mStatsObserver.onGetStatsCompleted(null, false);     // Catch: RemoteException -> L9
    }

    long sumCacheSizes() {
        SparseArray<HashMap<String, AppEntry>> r0 = this.mEntriesMap;
        monitor-enter(r0);
        int r1 = this.mAppEntries.size() - 1;     // Catch: Throwable -> L9
        long r2 = 0;
    L5:
        if (r1 < 0) goto L7;
        r2 = r2 + this.mAppEntries.get(r1).cacheSize;     // Catch: Throwable -> L9
        r1 = r1 - 1;     // Catch: Throwable -> L9
        goto L5
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L9:
        th = move-exception;
        throw th;
    }

    int indexOfApplicationInfoLocked(String r4, int r5) {
        int r0 = this.mApplications.size() - 1;
    L3:
        if (r0 < 0) goto L10;
        ApplicationInfo r1 = this.mApplications.get(r0);
        if (r1.packageName.equals(r4) == false) goto L9;
        if (UserHandle.getUserId(r1.uid) != r5) goto L9;
        return r0;
    L9:
        r0 = r0 - 1;
        goto L3
    L10:
        return -1;
    }

    void addPackage(String r5, int r6) {
        SparseArray<HashMap<String, AppEntry>> r0 = this.mEntriesMap;     // Catch: RemoteException -> L43
        monitor-enter(r0);     // Catch: RemoteException -> L43
    L39:
        th = move-exception;
        throw th;     // Catch: RemoteException -> L43
    L5:
        if (this.mResumed == true) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L39
        return;
    L9:
        if (indexOfApplicationInfoLocked(r5, r6) < 0) goto L12;
        monitor-exit(r0);     // Catch: Throwable -> L39
        return;
    L12:
        IPackageManager r1 = this.mIpm;     // Catch: Throwable -> L39
        if (this.mUm.isUserAdmin(r6) == false) goto L16;
        int r2 = this.mAdminRetrieveFlags;     // Catch: Throwable -> L39
    L17:
        ApplicationInfo r7 = r1.getApplicationInfo(r5, r2, r6);     // Catch: Throwable -> L39
        if (r7 != null) goto L22;
        monitor-exit(r0);     // Catch: Throwable -> L39
        return;
    L22:
        if (r7.enabled == true) goto L29;
        if (r7.enabledSetting == 3) goto L27;
        monitor-exit(r0);     // Catch: Throwable -> L39
        return;
    L27:
        this.mHaveDisabledApps = true;     // Catch: Throwable -> L39
    L29:
        if (AppUtils.isInstant(r7) == false) goto L31;
        this.mHaveInstantApps = true;     // Catch: Throwable -> L39
    L31:
        this.mApplications.add(r7);     // Catch: Throwable -> L39
        if (this.mBackgroundHandler.hasMessages(2) == true) goto L35;
        this.mBackgroundHandler.sendEmptyMessage(2);     // Catch: Throwable -> L39
    L35:
        if (this.mMainHandler.hasMessages(2) == true) goto L37;
        this.mMainHandler.sendEmptyMessage(2);     // Catch: Throwable -> L39
    L37:
        monitor-exit(r0);     // Catch: Throwable -> L39
        return;
    L16:
        r2 = this.mRetrieveFlags;     // Catch: Throwable -> L39
    }

    public void removePackage(String r5, int r6) {
        SparseArray<HashMap<String, AppEntry>> r0 = this.mEntriesMap;
        monitor-enter(r0);
        int r1 = indexOfApplicationInfoLocked(r5, r6);     // Catch: Throwable -> L30
        if (r1 < 0) goto L28;
        AppEntry r2 = this.mEntriesMap.get(r6).get(r5);     // Catch: Throwable -> L30
        if (r2 == null) goto L9;
        this.mEntriesMap.get(r6).remove(r5);     // Catch: Throwable -> L30
        this.mAppEntries.remove(r2);     // Catch: Throwable -> L30
    L9:
        ApplicationInfo r7 = this.mApplications.get(r1);     // Catch: Throwable -> L30
        this.mApplications.remove(r1);     // Catch: Throwable -> L30
        if (r7.enabled == true) goto L18;
        this.mHaveDisabledApps = false;     // Catch: Throwable -> L30
        Iterator<ApplicationInfo> r8 = this.mApplications.iterator();     // Catch: Throwable -> L30
    L13:
        if (r8.hasNext() == false) goto L18;
        if (r8.next().enabled == true) goto L13;
        this.mHaveDisabledApps = true;     // Catch: Throwable -> L30
    L18:
        if (AppUtils.isInstant(r7) == false) goto L26;
        this.mHaveInstantApps = false;     // Catch: Throwable -> L30
        Iterator<ApplicationInfo> r9 = this.mApplications.iterator();     // Catch: Throwable -> L30
    L21:
        if (r9.hasNext() == false) goto L26;
        if (AppUtils.isInstant(r9.next()) == false) goto L21;
        this.mHaveInstantApps = true;     // Catch: Throwable -> L30
    L26:
        if (this.mMainHandler.hasMessages(2) == true) goto L28;
        this.mMainHandler.sendEmptyMessage(2);     // Catch: Throwable -> L30
    L28:
        monitor-exit(r0);     // Catch: Throwable -> L30
        return;
    L30:
        th = move-exception;
        throw th;
    }

    public void invalidatePackage(String r1, int r2) {
        removePackage(r1, r2);
        addPackage(r1, r2);
    }

    private void addUser(int r4) {
        if (ArrayUtils.contains(this.mUm.getProfileIdsWithDisabled(UserHandle.myUserId()), r4) == false) goto L17;
        SparseArray<HashMap<String, AppEntry>> r0 = this.mEntriesMap;
        monitor-enter(r0);
        this.mEntriesMap.put(r4, new HashMap());     // Catch: Throwable -> L14
        if (this.mResumed == false) goto L10;
        doPauseLocked();     // Catch: Throwable -> L14
        doResumeIfNeededLocked();     // Catch: Throwable -> L14
    L10:
        if (this.mMainHandler.hasMessages(2) == true) goto L12;
        this.mMainHandler.sendEmptyMessage(2);     // Catch: Throwable -> L14
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }

    private void removeUser(int r5) {
        SparseArray<HashMap<String, AppEntry>> r0 = this.mEntriesMap;
        monitor-enter(r0);
        HashMap<String, AppEntry> r1 = this.mEntriesMap.get(r5);     // Catch: Throwable -> L15
        if (r1 == null) goto L13;
        Iterator<AppEntry> r2 = r1.values().iterator();     // Catch: Throwable -> L15
    L8:
        if (r2.hasNext() == false) goto L10;
        AppEntry r3 = r2.next();     // Catch: Throwable -> L15
        this.mAppEntries.remove(r3);     // Catch: Throwable -> L15
        this.mApplications.remove(r3.info);     // Catch: Throwable -> L15
        goto L8
    L10:
        this.mEntriesMap.remove(r5);     // Catch: Throwable -> L15
        if (this.mMainHandler.hasMessages(2) == true) goto L13;
        this.mMainHandler.sendEmptyMessage(2);     // Catch: Throwable -> L15
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    }

    private AppEntry getEntryLocked(ApplicationInfo r8) {
        int r0 = UserHandle.getUserId(r8.uid);
        HashMap<String, AppEntry> r1 = this.mEntriesMap.get(r0);
        if (r1 == null) goto L5;
        AppEntry r2 = r1.get(r8.packageName);
    L6:
        if (r2 != null) goto L14;
        if (isHiddenModule(r8.packageName) == false) goto L10;
        return null;
    L10:
        Context r3 = this.mContext;
        long r4 = this.mCurId;
        this.mCurId = 1 + r4;
        r2 = new AppEntry(r3, r8, r4);
        HashMap<String, AppEntry> r5 = this.mEntriesMap.get(r0);
        if (r5 == null) goto L16;
        r5.put(r8.packageName, r2);
        this.mAppEntries.add(r2);
    L16:
        return r2;
    L14:
        if (r2.info == r8) goto L16;
        r2.info = r8;
        goto L16
    L5:
        r2 = null;
        goto L6
    }

    private long getTotalInternalSize(PackageStats r5) {
        if (r5 != null) goto L4;
        return -2;
    L4:
        return (r5.codeSize + r5.dataSize) - r5.cacheSize;
    }

    private long getTotalExternalSize(PackageStats r5) {
        if (r5 != null) goto L4;
        return -2;
    L4:
        return (((r5.externalCodeSize + r5.externalDataSize) + r5.externalCacheSize) + r5.externalMediaSize) + r5.externalObbSize;
    }

    private String getSizeStr(long r3) {
        if (r3 >= 0) goto L5;
        return null;
    L5:
        return Formatter.formatFileSize(this.mContext, r3);
    }

    private static boolean isAppIconCacheEnabled(Context r1) {
        if ("com.android.settings".equals(r1.getPackageName()) == false) goto L5;
    L8:
        return true;
    L5:
        if (sAppIconCacheEnabled == true) goto L8;
        return false;
    }

    void rebuildActiveSessions() {
        SparseArray<HashMap<String, AppEntry>> r0 = this.mEntriesMap;
        monitor-enter(r0);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (this.mSessionsChanged == true) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L17
        return;
    L8:
        this.mActiveSessions.clear();     // Catch: Throwable -> L17
        int r1 = 0;
    L10:
        if (r1 >= this.mSessions.size()) goto L15;
        Session r2 = this.mSessions.get(r1);     // Catch: Throwable -> L17
        if (r2.mResumed == false) goto L14;
        this.mActiveSessions.add(new WeakReference(r2));     // Catch: Throwable -> L17
    L14:
        r1 = r1 + 1;     // Catch: Throwable -> L17
        goto L10
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L17
    }

    public static String normalize(String r1) {
        String r2 = Normalizer.normalize(r1, Normalizer.Form.NFD);
        return REMOVE_DIACRITICALS_PATTERN.matcher(r2).replaceAll("").toLowerCase();
    }

    public boolean isUserAdded(int r1) {
        return this.mEntriesMap.contains(r1);
    }

    private static boolean isHideInQuietEnabledForProfile(UserManager r1, UserHandle r2) {
        if (r1.isQuietModeEnabled(r2) == true) goto L5;
    L7:
        return false;
    L5:
        if (r1.getUserProperties(r2).getShowInQuietMode() != 1) goto L7;
        return true;
    }
}
