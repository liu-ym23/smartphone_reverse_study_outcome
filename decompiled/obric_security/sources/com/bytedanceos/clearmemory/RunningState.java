package com.bytedanceos.clearmemory;

import android.app.ActivityManager;
import android.app.ActivityManagerNative;
import android.app.ActivityThread;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.UserInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.UserHandle;
import android.os.UserManager;
import android.text.format.Formatter;
import android.util.SparseArray;
import bytedanceos.api.PackageManagerSmt;
import com.bytedanceos.application.ApplicationLabelCache;
import com.bytedanceos.application.ApplicationLabelUtils;
import com.bytedanceos.security.Utils;
import com.bytedanceos.utils.ByteConverter;
import com.bytedanceos.utils.ByteUnitPair;
import com.obric.olog.OLog;
import com.obric.security.R;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class RunningState {
    static final long CONTENTS_UPDATE_DELAY = 10000;
    static final boolean DEBUG_COMPARE = false;
    static final int MAX_SERVICES = 100;
    static final int MSG_REFRESH_UI = 3;
    static final int MSG_RESET_CONTENTS = 1;
    static final int MSG_UPDATE_CONTENTS = 2;
    static final int MSG_UPDATE_TIME = 4;
    static final String TAG = "RunningState";
    static final long TIME_UPDATE_DELAY = 1000;
    private static HashSet<String> sAppWithLauncherCategory;
    static Object sGlobalLock;
    static RunningState sInstance;
    final ArrayList<ProcessItem> mAllProcessItems;
    final ActivityManager mAm;
    final Context mApplicationContext;
    final Comparator<MergedItem> mBackgroundComparator;
    BackgroundHandler mBackgroundHandler;
    ArrayList<MergedItem> mBackgroundItems;
    long mBackgroundProcessMemory;
    final HandlerThread mBackgroundThread;
    long mForegroundProcessMemory;
    final Handler mHandler;
    boolean mHaveData;
    final InterestingConfigChanges mInterestingConfigChanges;
    final ArrayList<ProcessItem> mInterestingProcesses;
    ArrayList<BaseItem> mItems;
    final Object mLock;
    ArrayList<MergedItem> mMergedItems;
    final int mMyUserId;
    int mNumBackgroundProcesses;
    int mNumForegroundProcesses;
    int mNumServiceProcesses;
    final SparseArray<MergedItem> mOtherUserBackgroundItems;
    final SparseArray<MergedItem> mOtherUserMergedItems;
    final PackageManager mPm;
    final ArrayList<ProcessItem> mProcessItems;
    private List<OnRefreshUiListener> mRefreshUiListeners;
    boolean mResumed;
    final SparseArray<ProcessItem> mRunningProcesses;
    int mSequence;
    final ServiceProcessComparator mServiceProcessComparator;
    long mServiceProcessMemory;
    final SparseArray<HashMap<String, ProcessItem>> mServiceProcessesByName;
    final SparseArray<ProcessItem> mServiceProcessesByPid;
    final SparseArray<AppProcessInfo> mTmpAppProcesses;
    final UserManager mUm;
    ArrayList<MergedItem> mUserBackgroundItems;
    final SparseArray<UserState> mUsers;
    boolean mWatchingBackgroundItems;

    static class AppProcessInfo {
        boolean hasForegroundServices;
        boolean hasServices;
        final ActivityManager.RunningAppProcessInfo info;

        AppProcessInfo(ActivityManager.RunningAppProcessInfo _info) {
            this.info = _info;
        }
    }

    final class BackgroundHandler extends Handler {
        final /* synthetic */ RunningState this$0;

        public BackgroundHandler(final RunningState this$0, Looper looper) {
            this.this$0 = this$0;
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            int r4 = msg.what;
            if (r4 != 1) goto L5;
            RunningState.access$000(this.this$0);
            return;
        L5:
            if (r4 != 2) goto L22;
            Object r5 = this.this$0.mLock;
            monitor-enter(r5);
        L15:
            th = move-exception;
            throw th;
        L10:
            if (this.this$0.mResumed == true) goto L13;
            monitor-exit(r5);     // Catch: Throwable -> L15
            return;
        L13:
            monitor-exit(r5);     // Catch: Throwable -> L15
            Message r6 = this.this$0.mHandler.obtainMessage(3);
            RunningState r1 = this.this$0;
            r1.updateSM(r1.mAm);
            r6.arg1 = 1;
            this.this$0.mHandler.sendMessage(r6);
            return;
        }
    }

    static class BaseItem {
        public boolean isDoppleganger;
        long mActiveSince;
        boolean mBackground;
        int mCurSeq;
        String mCurSizeStr;
        String mDescription;
        CharSequence mDisplayLabel;
        Drawable mDrawable;
        final boolean mIsProcess;
        public boolean mIsRecommendClear;
        public boolean mIsTaskPersist;
        String mLabel;
        public long mMergeSize;
        boolean mNeedDivider;
        public ApplicationInfo mPackageInfo;
        long mSize;
        String mSizeStr;
        final int mUserId;

        public BaseItem(boolean isProcess, int userId) {
            this.isDoppleganger = false;
            this.mIsRecommendClear = true;
            this.mIsProcess = isProcess;
            this.mUserId = userId;
        }

        public Drawable loadIcon(Context context, RunningState state) {
            Drawable r2 = this.mDrawable;
            if (r2 == null) goto L5;
            return r2;
        L5:
            ApplicationInfo r3 = this.mPackageInfo;
            if (r3 == null) goto L12;
            Drawable r4 = r3.loadIcon(state.mPm);
            this.mDrawable = r4;
            if (this.mUserId != 10) goto L10;
            this.isDoppleganger = true;
        L11:
            return r4;
        L10:
            this.isDoppleganger = false;
            goto L11
        L12:
            return null;
        }
    }

    public static class InterestingConfigChanges {
        final Configuration mLastConfiguration;
        int mLastDensity;

        public InterestingConfigChanges() {
            this.mLastConfiguration = new Configuration();
        }

        public boolean applyNewConfig(Resources res) {
            int r0 = this.mLastConfiguration.updateFrom(res.getConfiguration());
            if (this.mLastDensity == res.getDisplayMetrics().densityDpi) goto L5;
            boolean r1 = true;
        L6:
            if (r1 == false) goto L8;
        L11:
            this.mLastDensity = res.getDisplayMetrics().densityDpi;
            return true;
        L8:
            if ((r0 & 772) != 0) goto L11;
            return false;
        L5:
            r1 = false;
            goto L6
        }
    }

    public static class MergedItem extends BaseItem {
        final ArrayList<MergedItem> mChildren;
        private int mLastNumProcesses;
        private int mLastNumServices;
        final ArrayList<ProcessItem> mOtherProcesses;
        ProcessItem mProcess;
        final ArrayList<ServiceItem> mServices;
        UserState mUser;

        MergedItem(int userId) {
            super(false, userId);
            this.mOtherProcesses = new ArrayList();
            this.mServices = new ArrayList();
            this.mChildren = new ArrayList();
            this.mLastNumProcesses = -1;
            this.mLastNumServices = -1;
        }

        private void setDescription(Context context, int numProcesses, int numServices) {
            if (this.mLastNumProcesses == numProcesses) goto L5;
        L6:
            this.mLastNumProcesses = numProcesses;
            this.mLastNumServices = numServices;
            if (numProcesses == 1) goto L11;
            if (numServices == 1) goto L10;
            int r1 = R.string.running_processes_item_description_p_p;
        L14:
            this.mDescription = context.getResources().getString(r1, new Object[]{Integer.valueOf(numProcesses), Integer.valueOf(numServices)});
            return;
        L10:
            r1 = R.string.running_processes_item_description_p_s;
            goto L14
        L11:
            if (numServices == 1) goto L13;
            r1 = R.string.running_processes_item_description_s_p;
            goto L14
        L13:
            r1 = R.string.running_processes_item_description_s_s;
            goto L14
        L5:
            if (this.mLastNumServices != numServices) goto L6;
        }

        boolean update(Context context, boolean background) {
            this.mBackground = background;
            if (this.mUser == null) goto L17;
            this.mPackageInfo = this.mChildren.get(0).mProcess.mPackageInfo;
            UserState r8 = this.mUser;
            if (r8 == null) goto L7;
            String r9 = r8.mLabel;
        L8:
            this.mLabel = r9;
            this.mDisplayLabel = this.mLabel;
            this.mActiveSince = -1;
            int r10 = 0;
        L10:
            if (r10 >= this.mChildren.size()) goto L26;
            MergedItem r2 = this.mChildren.get(r10);
            int r3 = r2.mLastNumProcesses;
            int r4 = r2.mLastNumServices;
            if (r2.mActiveSince < 0) goto L16;
            if (this.mActiveSince >= r2.mActiveSince) goto L16;
            this.mActiveSince = r2.mActiveSince;
        L16:
            r10 = r10 + 1;
        L26:
            return false;
        L7:
            r9 = null;
            goto L8
        L17:
            this.mPackageInfo = this.mProcess.mPackageInfo;
            this.mDisplayLabel = this.mProcess.mDisplayLabel;
            this.mLabel = this.mProcess.mLabel;
            this.mActiveSince = -1;
            int r11 = 0;
        L19:
            if (r11 >= this.mServices.size()) goto L26;
            ServiceItem r5 = this.mServices.get(r11);
            if (r5.mActiveSince < 0) goto L25;
            if (this.mActiveSince >= r5.mActiveSince) goto L25;
            this.mActiveSince = r5.mActiveSince;
        L25:
            r11 = r11 + 1;
            goto L19
        }

        boolean updateSize(Context context) {
            if (this.mUser == null) goto L8;
            this.mSize = 0;
            int r0 = 0;
        L6:
            if (r0 >= this.mChildren.size()) goto L12;
            MergedItem r2 = this.mChildren.get(r0);
            r2.updateSize(context);
            this.mSize += r2.mSize;
            r0 = r0 + 1;
        L12:
            return false;
        L8:
            this.mSize = this.mProcess.mSize;
            int r8 = 0;
        L10:
            if (r8 >= this.mOtherProcesses.size()) goto L12;
            this.mSize += this.mOtherProcesses.get(r8).mSize;
            r8 = r8 + 1;
            goto L10
        }

        public void updateMergeSizeString(Context context) {
            if (context != null) goto L4;
            return;
        L4:
            ByteUnitPair r4 = ByteConverter.convert(this.mMergeSize, "B", 1000);
            this.mSizeStr = r4.getValue() + r4.getUnit();
        }

        @Override // com.bytedanceos.clearmemory.RunningState.BaseItem
        public Drawable loadIcon(Context context, RunningState state) {
            UserState r0 = this.mUser;
            if (r0 != null) goto L7;
            return super.loadIcon(context, state);
        L7:
            if (r0.mIcon == null) goto L14;
            Drawable.ConstantState r3 = this.mUser.mIcon.getConstantState();
            if (r3 != null) goto L13;
            return this.mUser.mIcon;
        L13:
            return r3.newDrawable();
        L14:
            int r2 = Utils.getResouceId("android", "ic_menu_cc", "drawable", android.R.drawable.pointer_arrow_large);
            return context.getResources().getDrawable(r2);
        }

        public void enSureTaskPersist(PackageManager pm) {
            if (this.mPackageInfo != null) goto L5;
            return;
        L5:
            this.mIsTaskPersist = PackageManagerSmt.getInstance().isTaskPersist(pm, this.mPackageInfo.packageName, this.mUserId);
        }
    }

    public interface OnRefreshUiListener {
        public static final int REFRESH_DATA = 1;
        public static final int REFRESH_STRUCTURE = 2;
        public static final int REFRESH_TIME = 0;

        void onRefreshUi(int what);
    }

    static class ProcessItem extends BaseItem {
        long mActiveSince;
        ProcessItem mClient;
        Context mContext;
        final SparseArray<ProcessItem> mDependentProcesses;
        boolean mInteresting;
        boolean mIsStarted;
        boolean mIsSystem;
        int mLastNumDependentProcesses;
        MergedItem mMergedItem;
        int mPid;
        final String mProcessName;
        ActivityManager.RunningAppProcessInfo mRunningProcessInfo;
        int mRunningSeq;
        final HashMap<ComponentName, ServiceItem> mServices;
        final int mUid;

        public ProcessItem(Context context, int uid, String processName) {
            super(true, UserHandle.getUserId(uid));
            this.mServices = new HashMap();
            this.mDependentProcesses = new SparseArray();
            this.mContext = context;
            this.mDescription = context.getResources().getString(R.string.service_process_name, new Object[]{processName});
            this.mUid = uid;
            this.mProcessName = processName;
        }

        void ensureLabel(PackageManager pm) {
            if (pm != null) goto L5;
            return;
        L5:
            if (this.mLabel == null) goto L61;
            return;
        L61:
            ApplicationInfo r2 = pm.getApplicationInfo(this.mProcessName, 8192);     // Catch: PackageManager.NameNotFoundException -> L17
            if (r2 != null) goto L11;
        L18:
            String[] r3 = pm.getPackagesForUid(this.mUid);
            if (r3 != null) goto L22;
            return;
        L22:
            if (r3.length == 1) goto L55;
        L29:
            int r4 = r3.length;
            int r5 = 0;
        L30:
            if (r5 >= r4) goto L43;
            String r6 = r3[r5];
            PackageInfo r7 = pm.getPackageInfo(r6, 0);     // Catch: PackageManager.NameNotFoundException -> L40
            if (r7 == null) goto L41;
            if (r7.sharedUserLabel == 0) goto L41;
            CharSequence r8 = pm.getText(r6, r7.sharedUserLabel, r7.applicationInfo);     // Catch: PackageManager.NameNotFoundException -> L40
            if (r8 == null) goto L41;
            this.mDisplayLabel = r8;     // Catch: PackageManager.NameNotFoundException -> L40
            this.mLabel = r8.toString();     // Catch: PackageManager.NameNotFoundException -> L40
            this.mPackageInfo = r7.applicationInfo;     // Catch: PackageManager.NameNotFoundException -> L40
            return;
        L41:
            r5 = r5 + 1;
        L40:
            OLog.d(RunningProcessesView.TAG, "ensureLabel ensureLabel mPackageInfo error3");
            goto L41
        L43:
            if (this.mServices.size() <= 0) goto L57;
            this.mPackageInfo = this.mServices.values().iterator().next().mServiceInfo.applicationInfo;
            this.mDisplayLabel = ApplicationLabelCache.getInstance().getLabel(this.mContext, this.mPackageInfo);
            if (this.mDisplayLabel == null) goto L69;
            this.mLabel = this.mDisplayLabel.toString();
            return;
        L69:
            return;
        L57:
            ApplicationInfo r11 = pm.getApplicationInfo(r3[0], 8192);     // Catch: PackageManager.NameNotFoundException -> L53
            this.mDisplayLabel = ApplicationLabelCache.getInstance().getLabel(this.mContext, r11);     // Catch: PackageManager.NameNotFoundException -> L53
            if (this.mDisplayLabel == null) goto L51;
            this.mLabel = this.mDisplayLabel.toString();     // Catch: PackageManager.NameNotFoundException -> L53
        L51:
            this.mPackageInfo = r11;     // Catch: PackageManager.NameNotFoundException -> L53
            return;
        L53:
            OLog.d(RunningProcessesView.TAG, "ensureLabel ensureLabel mPackageInfo error4");
            return;
        L55:
            ApplicationInfo r9 = pm.getApplicationInfo(r3[0], 8192);     // Catch: PackageManager.NameNotFoundException -> L28
            this.mDisplayLabel = ApplicationLabelCache.getInstance().getLabel(this.mContext, r9);     // Catch: PackageManager.NameNotFoundException -> L28
            if (this.mDisplayLabel == null) goto L26;
            this.mLabel = this.mDisplayLabel.toString();     // Catch: PackageManager.NameNotFoundException -> L28
        L26:
            this.mPackageInfo = r9;     // Catch: PackageManager.NameNotFoundException -> L28
            return;
        L28:
            OLog.d(RunningProcessesView.TAG, "ensureLabel ensureLabel mPackageInfo error2");
            goto L29
        L11:
            if (r2.uid != this.mUid) goto L18;
            this.mDisplayLabel = ApplicationLabelCache.getInstance().getLabel(this.mContext, r2);     // Catch: PackageManager.NameNotFoundException -> L17
            if (this.mDisplayLabel == null) goto L15;
            this.mLabel = this.mDisplayLabel.toString();     // Catch: PackageManager.NameNotFoundException -> L17
        L15:
            this.mPackageInfo = r2;     // Catch: PackageManager.NameNotFoundException -> L17
            return;
        L17:
            OLog.d(RunningProcessesView.TAG, "ensureLabel ensureLabel error1 ");
            goto L18
        }

        boolean updateService(Context context, ActivityManager.RunningServiceInfo service) {
            PackageManager r1 = context.getPackageManager();
            ServiceItem r2 = this.mServices.get(service.service);
            boolean r4 = true;
            if (r2 != null) goto L14;
            r2 = new ServiceItem(this.mUserId);
            r2.mRunningService = service;
            r2.mServiceInfo = ActivityThread.getPackageManager().getServiceInfo(service.service, 8192, UserHandle.getUserId(service.uid));     // Catch: RemoteException -> L39
            if (r2.mServiceInfo != null) goto L9;
            OLog.d("RunningService", "getServiceInfo returned null for: " + service.service);     // Catch: RemoteException -> L39
            return false;
        L9:
            r2.mDisplayLabel = RunningState.makeLabel(r1, r2.mRunningService.service.getClassName(), r2.mServiceInfo);
            if (this.mDisplayLabel == null) goto L12;
            String r0 = this.mDisplayLabel.toString();
        L13:
            this.mLabel = r0;
            r2.mPackageInfo = r2.mServiceInfo.applicationInfo;
            this.mServices.put(service.service, r2);
            boolean r3 = true;
        L15:
            r2.mCurSeq = this.mCurSeq;
            r2.mRunningService = service;
            if (service.restarting != 0) goto L18;
            long r6 = service.activeSince;
        L20:
            if (r2.mActiveSince == r6) goto L23;
            r2.mActiveSince = r6;
            r3 = true;
        L23:
            if (service.clientPackage == null) goto L34;
            if (service.clientLabel == 0) goto L34;
            if (r2.mShownAsStarted == false) goto L29;
            r2.mShownAsStarted = false;
            r3 = true;
        L29:
            if (r1 == null) goto L44;
            r2.mDescription = context.getResources().getString(R.string.service_client_name, new Object[]{r1.getResourcesForApplication(service.clientPackage).getString(service.clientLabel)});     // Catch: PackageManager.NameNotFoundException -> L32
            return r3;
        L32:
            r2.mDescription = null;
            return r3;
        L44:
            return r3;
        L34:
            if (r2.mShownAsStarted == true) goto L36;
            r2.mShownAsStarted = true;
        L37:
            r2.mDescription = context.getResources().getString(R.string.service_started_by_app);
            return r4;
        L36:
            r4 = r3;
            goto L37
        L18:
            r6 = -1;
            goto L20
        L12:
            r0 = null;
            goto L13
        L14:
            r3 = false;
            goto L15
        }

        boolean updateSize(Context context, long pss) {
            long r3 = pss << 10;
            if (r3 != this.mSize) goto L6;
            return false;
        L6:
            this.mSize = r3;
            return true;
        }

        boolean updateSize(Context context, long pss, int curSeq) {
            long r4 = pss << 10;
            if (r4 != this.mSize) goto L5;
            return false;
        L5:
            this.mSize = r4;
            if (this.mCurSeq == curSeq) goto L15;
        L14:
            return false;
        L15:
            String r3 = Formatter.formatShortFileSize(context, this.mSize);     // Catch: Exception -> L12
            if (r3.equals(this.mSizeStr) == true) goto L14;
            this.mSizeStr = r3;
            return false;
        L12:
            e = move-exception;
            e.printStackTrace();
            goto L14
        }

        boolean buildDependencyChain(Context context, PackageManager pm, int curSeq) {
            int r0 = this.mDependentProcesses.size();
            int r1 = 0;
            boolean r2 = false;
        L4:
            if (r1 >= r0) goto L10;
            ProcessItem r4 = this.mDependentProcesses.valueAt(r1);
            if (r4.mClient == this) goto L8;
            r4.mClient = this;
            r2 = true;
        L8:
            r4.mCurSeq = curSeq;
            r4.ensureLabel(pm);
            r2 = r2 | r4.buildDependencyChain(context, pm, curSeq);
            r1 = r1 + 1;
            goto L4
        L10:
            if (this.mLastNumDependentProcesses == this.mDependentProcesses.size()) goto L16;
            this.mLastNumDependentProcesses = this.mDependentProcesses.size();
            return true;
        L16:
            return r2;
        }

        void addDependentProcesses(ArrayList<BaseItem> dest, ArrayList<ProcessItem> destProc) {
            int r0 = this.mDependentProcesses.size();
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L8;
            ProcessItem r2 = this.mDependentProcesses.valueAt(r1);
            r2.addDependentProcesses(dest, destProc);
            dest.add(r2);
            if (r2.mPid <= 0) goto L7;
            destProc.add(r2);
        L7:
            r1 = r1 + 1;
            goto L3
        }
    }

    static class ServiceItem extends BaseItem {
        MergedItem mMergedItem;
        ActivityManager.RunningServiceInfo mRunningService;
        ServiceInfo mServiceInfo;
        boolean mShownAsStarted;

        public ServiceItem(int userId) {
            super(false, userId);
        }
    }

    class ServiceProcessComparator implements Comparator<ProcessItem> {
        final /* synthetic */ RunningState this$0;

        ServiceProcessComparator(final RunningState this$0) {
            this.this$0 = this$0;
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(ProcessItem object1, ProcessItem object2) {
            return compare2(object1, object2);
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(ProcessItem object1, ProcessItem object2) {
            if (object1.mUserId == object2.mUserId) goto L15;
            if (object1.mUserId != this.this$0.mMyUserId) goto L8;
            return -1;
        L8:
            if (object2.mUserId != this.this$0.mMyUserId) goto L11;
            return 1;
        L11:
            if (object1.mUserId < object2.mUserId) goto L13;
            return 1;
        L13:
            return -1;
        L15:
            if (object1.mIsStarted == object2.mIsStarted) goto L21;
            if (object1.mIsStarted == true) goto L19;
            return 1;
        L19:
            return -1;
        L21:
            if (object1.mIsSystem == object2.mIsSystem) goto L28;
            if (object1.mIsSystem == false) goto L26;
            return 1;
        L26:
            return -1;
        L28:
            if (object1.mActiveSince != object2.mActiveSince) goto L30;
            return 0;
        L30:
            if (object1.mActiveSince > object2.mActiveSince) goto L32;
            return 1;
        L32:
            return -1;
        }
    }

    static class UserState {
        Drawable mIcon;
        UserInfo mInfo;
        String mLabel;

        UserState() {
        }
    }

    static /* synthetic */ void access$000(RunningState r0) {
        r0.reset();
    }

    static /* synthetic */ List access$100(RunningState r0) {
        return r0.mRefreshUiListeners;
    }

    static {
        sGlobalLock = new Object();
        sAppWithLauncherCategory = new HashSet();
    }

    static CharSequence makeLabel(PackageManager pm, String className, PackageItemInfo item) {
        if (pm == null) goto L11;
        if (item == null) goto L11;
        if (item.labelRes == 0) goto L7;
    L8:
        CharSequence r1 = item.loadLabel(pm);
        if (r1 == null) goto L11;
        return r1;
    L7:
        if (item.nonLocalizedLabel != null) goto L8;
    L11:
        int r2 = className.lastIndexOf(46);
        if (r2 >= 0) goto L14;
        return className;
    L14:
        return className.substring(r2 + 1, className.length());
    }

    public static RunningState getInstance(Context context) {
        Object r0 = sGlobalLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L7;
        sInstance = new RunningState(context);     // Catch: Throwable -> L10
    L7:
        RunningState r2 = sInstance;     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r2;
    }

    private RunningState(Context context) {
        this.mRefreshUiListeners = new CopyOnWriteArrayList();
        this.mInterestingConfigChanges = new InterestingConfigChanges();
        this.mServiceProcessesByName = new SparseArray();
        this.mServiceProcessesByPid = new SparseArray();
        this.mServiceProcessComparator = new ServiceProcessComparator(this);
        this.mInterestingProcesses = new ArrayList();
        this.mRunningProcesses = new SparseArray();
        this.mProcessItems = new ArrayList();
        this.mAllProcessItems = new ArrayList();
        this.mOtherUserMergedItems = new SparseArray();
        this.mOtherUserBackgroundItems = new SparseArray();
        this.mUsers = new SparseArray();
        this.mTmpAppProcesses = new SparseArray();
        this.mSequence = 0;
        this.mBackgroundComparator = new AnonymousClass1(this);
        this.mLock = new Object();
        this.mItems = new ArrayList();
        this.mMergedItems = new ArrayList();
        this.mBackgroundItems = new ArrayList();
        this.mUserBackgroundItems = new ArrayList();
        this.mHandler = new AnonymousClass2(this);
        Context r3 = context.getApplicationContext();
        this.mApplicationContext = r3;
        this.mAm = (ActivityManager) r3.getSystemService("activity");
        this.mPm = r3.getPackageManager();
        this.mUm = (UserManager) r3.getSystemService("user");
        this.mMyUserId = UserHandle.myUserId();
        this.mResumed = false;
        HandlerThread r4 = new HandlerThread("RunningState:Background");
        this.mBackgroundThread = r4;
        r4.start();
        Looper r5 = r4.getLooper();
        if (r5 == null) goto L6;
        this.mBackgroundHandler = new BackgroundHandler(this, r5);
        return;
    }

    public void resume() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mResumed = true;     // Catch: Throwable -> L13
        if (this.mInterestingConfigChanges.applyNewConfig(this.mApplicationContext.getResources()) == false) goto L9;
        this.mHaveData = false;     // Catch: Throwable -> L13
        this.mBackgroundHandler.removeMessages(1);     // Catch: Throwable -> L13
        this.mBackgroundHandler.removeMessages(2);     // Catch: Throwable -> L13
        this.mBackgroundHandler.sendEmptyMessage(1);     // Catch: Throwable -> L13
    L9:
        if (this.mBackgroundHandler.hasMessages(2) == true) goto L11;
        this.mBackgroundHandler.sendEmptyMessage(2);     // Catch: Throwable -> L13
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public void registListener(OnRefreshUiListener listener) {
        if (listener != null) goto L5;
        return;
    L5:
        if (this.mRefreshUiListeners.contains(listener) == false) goto L7;
        return;
    L7:
        this.mRefreshUiListeners.add(listener);
    }

    public void unregistListener(OnRefreshUiListener listener) {
        if (listener != null) goto L4;
        return;
    L4:
        this.mRefreshUiListeners.remove(listener);
    }

    public void updateNow() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mBackgroundHandler.removeMessages(2);     // Catch: Throwable -> L7
        this.mBackgroundHandler.sendEmptyMessage(2);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    boolean hasData() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = this.mHaveData;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    void waitForData() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L14:
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mHaveData == true) goto L8;
        this.mLock.wait(0);     // Catch: InterruptedException -> L13 Throwable -> L10
        goto L14
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
    }

    void pause() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mResumed = false;     // Catch: Throwable -> L8
        this.mHandler.removeMessages(4);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private boolean isInterestingProcess(ActivityManager.RunningAppProcessInfo pi) {
        if ((pi.flags & 1) == 0) goto L6;
        return true;
    L6:
        if ((pi.flags & 2) == 0) goto L8;
        return false;
    L8:
        if (pi.importance >= 100) goto L10;
        return false;
    L10:
        if (pi.importance < 350) goto L12;
        return false;
    L12:
        if (pi.importanceReasonCode != 0) goto L18;
        return true;
    L18:
        return false;
    }

    private void reset() {
        this.mServiceProcessesByName.clear();
        this.mServiceProcessesByPid.clear();
        this.mInterestingProcesses.clear();
        this.mRunningProcesses.clear();
        this.mProcessItems.clear();
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mAllProcessItems.clear();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        this.mUsers.clear();
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public boolean updateSM(ActivityManager am) {
        refreshLuanchApp();
        PackageManager r0 = this.mApplicationContext.getPackageManager();
        List<ActivityManager.RunningAppProcessInfo> r14 = am.getRunningAppProcesses();
        ArrayList r1 = new ArrayList();
        Iterator<ActivityManager.RunningAppProcessInfo> r15 = r14.iterator();
        boolean r3 = false;
    L4:
        if (r15.hasNext() == false) goto L62;
        ActivityManager.RunningAppProcessInfo r4 = r15.next();
        if ((r4.flags & 2) != 0) goto L4;
        ProcessItem r6 = this.mRunningProcesses.get(r4.pid);
        if (r6 != null) goto L12;
        r6 = new ProcessItem(this.mApplicationContext, r4.uid, r4.processName);
        r6.mPid = r4.pid;
        this.mRunningProcesses.put(r4.pid, r6);
        r6.ensureLabel(r0);
        r3 = true;
    L12:
        if (RunningStateHelper.getInstance().skipPackage(r6.mPackageInfo) == true) goto L4;
        r6.mRunningProcessInfo = r4;
        r1.add(r6);
        goto L4
    L62:
        int r16 = r1.size();     // Catch: RemoteException -> L22
        int[] r5 = new int[r16];     // Catch: RemoteException -> L22
        int r7 = 0;
    L16:
        if (r7 >= r16) goto L18;
        r5[r7] = ((ProcessItem) r1.get(r7)).mPid;     // Catch: RemoteException -> L22
        r7 = r7 + 1;     // Catch: RemoteException -> L22
        goto L16
    L18:
        long[] r8 = ActivityManagerNative.getDefault().getProcessPss(r5);     // Catch: RemoteException -> L22
        int r9 = 0;
    L19:
        if (r9 >= r16) goto L23;
        ProcessItem r10 = (ProcessItem) r1.get(r9);     // Catch: RemoteException -> L22
        r3 = r3 | r10.updateSize(this.mApplicationContext, r8[r9]);     // Catch: RemoteException -> L22
        r10.mMergeSize = r10.mSize;     // Catch: RemoteException -> L22
        r9 = r9 + 1;
    L23:
        ArrayList<MergedItem> r17 = new ArrayList();
        Iterator r11 = r1.iterator();
        long r12 = 0;
    L25:
        if (r11.hasNext() == false) goto L35;
        ProcessItem r13 = (ProcessItem) r11.next();
        if (r13.mPackageInfo == null) goto L25;
        MergedItem r18 = new MergedItem(r13.mUserId);
        r18.mMergeSize = r13.mMergeSize;
        r18.mSize = r13.mSize;
        r18.mProcess = r13;
        r18.mPackageInfo = r13.mPackageInfo;
        if (r0 == null) goto L32;
        r18.mDisplayLabel = ApplicationLabelUtils.loadLabel(r0, r13.mPackageInfo);
    L32:
        r17.add(r18);
        if (r13.mRunningProcessInfo.importance < 400) goto L25;
        r12 = r12 + r13.mSize;
        goto L25
    L35:
        Object r2 = this.mLock;
        monitor-enter(r2);
        if (r3 == false) goto L64;
    L52:
        this.mAllProcessItems.clear();     // Catch: Throwable -> L59
        this.mAllProcessItems.addAll(r1);     // Catch: Throwable -> L59
        if (this.mHaveData == true) goto L55;
        this.mHaveData = true;     // Catch: Throwable -> L59
        this.mLock.notifyAll();     // Catch: Throwable -> L59
    L55:
        if (r3 == false) goto L57;
        this.mMergedItems = r17;     // Catch: Throwable -> L59
        this.mBackgroundProcessMemory = r12;     // Catch: Throwable -> L59
    L57:
        monitor-exit(r2);     // Catch: Throwable -> L59
        return r3;
    L59:
        th = move-exception;
        throw th;
    L64:
        Iterator<MergedItem> r19 = this.mMergedItems.iterator();     // Catch: Throwable -> L59
    L40:
        if (r19.hasNext() == false) goto L52;
        MergedItem r20 = r19.next();     // Catch: Throwable -> L59
        Iterator<MergedItem> r21 = r17.iterator();     // Catch: Throwable -> L59
    L43:
        if (r21.hasNext() == false) goto L49;
        MergedItem r110 = r21.next();     // Catch: Throwable -> L59
        if (r20.mPackageInfo.packageName.equals(r110.mPackageInfo.packageName) == false) goto L43;
        if (r20.mPackageInfo.uid != r110.mPackageInfo.uid) goto L43;
        boolean r22 = true;
    L50:
        if (r22 == true) goto L40;
        r3 = true;
        goto L52
    L49:
        r22 = false;
    L22:
        OLog.d(RunningProcessesView.TAG, "updateSM RemoteException");
        goto L23
    }

    private void refreshLuanchApp() {
        Intent r0 = new Intent("android.intent.action.MAIN", null);
        r0.addCategory("android.intent.category.LAUNCHER");
        List<ResolveInfo> r3 = this.mPm.queryIntentActivities(r0, 0);
        sAppWithLauncherCategory.clear();
        if (r3 == null) goto L8;
        Iterator<ResolveInfo> r4 = r3.iterator();
    L6:
        if (r4.hasNext() == false) goto L10;
        ResolveInfo r1 = r4.next();
        sAppWithLauncherCategory.add(r1.activityInfo.packageName);
        goto L6
    L10:
        return;
    }

    public HashSet<String> getLuanchApps() {
        return sAppWithLauncherCategory;
    }

    ArrayList<BaseItem> getCurrentItems() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        ArrayList<BaseItem> r1 = this.mItems;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    void setWatchingBackgroundItems(boolean watching) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mWatchingBackgroundItems = watching;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public ArrayList<MergedItem> getCurrentMergedItems() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        ArrayList<MergedItem> r1 = this.mMergedItems;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void clearCurrentMergedItems() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mMergedItems.clear();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    ArrayList<MergedItem> getCurrentBackgroundItems() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        ArrayList<MergedItem> r1 = this.mUserBackgroundItems;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }
}
