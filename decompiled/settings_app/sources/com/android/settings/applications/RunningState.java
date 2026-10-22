package com.android.settings.applications;

import android.app.ActivityManager;
import android.app.ActivityManagerNative;
import android.app.ActivityThread;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.content.pm.UserInfo;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
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
import com.android.settings.R;
import com.android.settings.Utils;
import com.obric.olog.OLog;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

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
    static Object sGlobalLock;
    static RunningState sInstance;
    final ArrayList<ProcessItem> mAllProcessItems;
    final ActivityManager mAm;
    final Context mApplicationContext;
    final Comparator<MergedItem> mBackgroundComparator;
    final BackgroundHandler mBackgroundHandler;
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
    OnRefreshUiListener mRefreshUiListener;
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

        AppProcessInfo(ActivityManager.RunningAppProcessInfo r1) {
            this.info = r1;
        }
    }

    final class BackgroundHandler extends Handler {
        final /* synthetic */ RunningState this$0;

        public BackgroundHandler(RunningState r1, Looper r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r4) {
            int r5 = r4.what;
            if (r5 != 1) goto L5;
            RunningState.access$000(this.this$0);
            return;
        L5:
            if (r5 != 2) goto L22;
            Object r6 = this.this$0.mLock;
            monitor-enter(r6);
        L15:
            th = move-exception;
            throw th;
        L10:
            if (this.this$0.mResumed == true) goto L13;
            monitor-exit(r6);     // Catch: Throwable -> L15
            return;
        L13:
            monitor-exit(r6);     // Catch: Throwable -> L15
            Message r7 = this.this$0.mHandler.obtainMessage(3);
            RunningState r1 = this.this$0;
            r7.arg1 = r1.updateSM(r1.mAm) ? 1 : 0;
            this.this$0.mHandler.sendMessage(r7);
            removeMessages(2);
            sendMessageDelayed(obtainMessage(2), RunningState.CONTENTS_UPDATE_DELAY);
            return;
        }
    }

    static class BaseItem {
        long mActiveSince;
        boolean mBackground;
        int mCurSeq;
        String mCurSizeStr;
        String mDescription;
        CharSequence mDisplayLabel;
        Drawable mDrawable;
        final boolean mIsProcess;
        boolean mIsRecommendClear;
        boolean mIsTaskPersist;
        String mLabel;
        long mMergeSize;
        boolean mNeedDivider;
        ApplicationInfo mPackageInfo;
        long mSize;
        String mSizeStr;
        final int mUserId;

        public BaseItem(boolean r2, int r3) {
            this.mIsRecommendClear = true;
            this.mIsProcess = r2;
            this.mUserId = r3;
        }

        public Drawable loadIcon(Context r3, RunningState r4) {
            Drawable r0 = this.mDrawable;
            if (r0 == null) goto L5;
            return r0;
        L5:
            ApplicationInfo r1 = this.mPackageInfo;
            if (r1 == null) goto L14;
            Drawable r5 = r1.loadIcon(r4.mPm);
            this.mDrawable = r5;
            if (this.mUserId != 10) goto L13;
            if ((r5 instanceof BitmapDrawable) == false) goto L13;
            this.mDrawable = Utils.getDoppelgangerDrawableIcon(r3.getResources(), (BitmapDrawable) this.mDrawable);
        L13:
            return this.mDrawable;
        L14:
            return null;
        }
    }

    static class MergedItem extends BaseItem {
        final ArrayList<MergedItem> mChildren;
        private int mLastNumProcesses;
        private int mLastNumServices;
        final ArrayList<ProcessItem> mOtherProcesses;
        ProcessItem mProcess;
        final ArrayList<ServiceItem> mServices;
        UserState mUser;

        MergedItem(int r2) {
            super(false, r2);
            this.mOtherProcesses = new ArrayList();
            this.mServices = new ArrayList();
            this.mChildren = new ArrayList();
            this.mLastNumProcesses = -1;
            this.mLastNumServices = -1;
        }

        private void setDescription(Context r5, int r6, int r7) {
            if (this.mLastNumProcesses == r6) goto L5;
        L6:
            this.mLastNumProcesses = r6;
            this.mLastNumServices = r7;
            if (r6 == 1) goto L11;
            if (r7 == 1) goto L10;
            int r1 = R.string.running_processes_item_description_p_p;
        L14:
            this.mDescription = r5.getResources().getString(r1, new Object[]{Integer.valueOf(r6), Integer.valueOf(r7)});
            return;
        L10:
            r1 = R.string.running_processes_item_description_p_s;
            goto L14
        L11:
            if (r7 == 1) goto L13;
            r1 = R.string.running_processes_item_description_s_p;
            goto L14
        L13:
            r1 = R.string.running_processes_item_description_s_s;
            goto L14
        L5:
            if (this.mLastNumServices != r7) goto L6;
        }

        boolean update(Context r8, boolean r9) {
            this.mBackground = r9;
            if (this.mUser == null) goto L17;
            this.mPackageInfo = this.mChildren.get(0).mProcess.mPackageInfo;
            UserState r10 = this.mUser;
            if (r10 == null) goto L7;
            String r11 = r10.mLabel;
        L8:
            this.mLabel = r11;
            this.mDisplayLabel = this.mLabel;
            this.mActiveSince = -1;
            int r12 = 0;
        L10:
            if (r12 >= this.mChildren.size()) goto L26;
            MergedItem r2 = this.mChildren.get(r12);
            int r3 = r2.mLastNumProcesses;
            int r4 = r2.mLastNumServices;
            if (r2.mActiveSince < 0) goto L16;
            if (this.mActiveSince >= r2.mActiveSince) goto L16;
            this.mActiveSince = r2.mActiveSince;
        L16:
            r12 = r12 + 1;
        L26:
            return false;
        L7:
            r11 = null;
            goto L8
        L17:
            this.mPackageInfo = this.mProcess.mPackageInfo;
            this.mDisplayLabel = this.mProcess.mDisplayLabel;
            this.mLabel = this.mProcess.mLabel;
            this.mActiveSince = -1;
            int r13 = 0;
        L19:
            if (r13 >= this.mServices.size()) goto L26;
            ServiceItem r5 = this.mServices.get(r13);
            if (r5.mActiveSince < 0) goto L25;
            if (this.mActiveSince >= r5.mActiveSince) goto L25;
            this.mActiveSince = r5.mActiveSince;
        L25:
            r13 = r13 + 1;
            goto L19
        }

        boolean updateSize(Context r8) {
            if (this.mUser == null) goto L8;
            this.mSize = 0;
            int r0 = 0;
        L6:
            if (r0 >= this.mChildren.size()) goto L12;
            MergedItem r2 = this.mChildren.get(r0);
            r2.updateSize(r8);
            this.mSize += r2.mSize;
            r0 = r0 + 1;
        L12:
            return false;
        L8:
            this.mSize = this.mProcess.mSize;
            int r9 = 0;
        L10:
            if (r9 >= this.mOtherProcesses.size()) goto L12;
            this.mSize += this.mOtherProcesses.get(r9).mSize;
            r9 = r9 + 1;
            goto L10
        }

        void updateMergeSizeString(Context r3) {
            String r4 = Formatter.formatShortFileSize(r3, this.mMergeSize);
            if (r4.equals(this.mSizeStr) == true) goto L6;
            this.mSizeStr = r4;
            return;
        }

        @Override // com.android.settings.applications.RunningState.BaseItem
        public Drawable loadIcon(Context r2, RunningState r3) {
            UserState r0 = this.mUser;
            if (r0 != null) goto L7;
            return super.loadIcon(r2, r3);
        L7:
            if (r0.mIcon == null) goto L15;
            Drawable.ConstantState r4 = this.mUser.mIcon.getConstantState();
            if (r4 != null) goto L13;
            return this.mUser.mIcon;
        L13:
            return r4.newDrawable();
        L15:
            return r2.getResources().getDrawable(android.R.drawable.pointer_arrow_vector);
        }

        public void enSureTaskPersist(PackageManager r4) {
            if (this.mPackageInfo != null) goto L8;
            return;
        L8:
            this.mIsTaskPersist = PackageManagerSmt.getInstance().isTaskPersist(r4, this.mPackageInfo.packageName, this.mUserId);     // Catch: Exception -> L7
            return;
        }
    }

    interface OnRefreshUiListener {
        public static final int REFRESH_DATA = 1;
        public static final int REFRESH_STRUCTURE = 2;
        public static final int REFRESH_TIME = 0;

        void onRefreshUi(int r1);
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

        public ProcessItem(Context r3, int r4, String r5) {
            super(true, UserHandle.getUserId(r4));
            this.mServices = new HashMap();
            this.mDependentProcesses = new SparseArray();
            this.mContext = r3;
            this.mDescription = r3.getResources().getString(R.string.service_process_name, new Object[]{r5});
            this.mUid = r4;
            this.mProcessName = r5;
        }

        void ensureLabel(PackageManager r10) {
            if (this.mLabel == null) goto L45;
            return;
        L45:
            ApplicationInfo r1 = r10.getApplicationInfo(this.mProcessName, 8192);     // Catch: PackageManager.NameNotFoundException -> L35
            if (r1 == null) goto L12;
            if (r1.uid != this.mUid) goto L12;
            this.mDisplayLabel = ApplicationLabelCache.getInstance().getLabel(this.mContext, r1);     // Catch: PackageManager.NameNotFoundException -> L35
            this.mLabel = this.mDisplayLabel.toString();     // Catch: PackageManager.NameNotFoundException -> L35
            this.mPackageInfo = r1;     // Catch: PackageManager.NameNotFoundException -> L35
            return;
        L12:
            String[] r2 = r10.getPackagesForUid(this.mUid);
            if (r2 != null) goto L16;
            return;
        L16:
            if (r2.length == 1) goto L39;
        L19:
            int r3 = r2.length;
            int r4 = 0;
        L20:
            if (r4 >= r3) goto L30;
            String r5 = r2[r4];
            PackageInfo r6 = r10.getPackageInfo(r5, 0);     // Catch: PackageManager.NameNotFoundException -> L37
            if (r6.sharedUserLabel == 0) goto L28;
            CharSequence r7 = r10.getText(r5, r6.sharedUserLabel, r6.applicationInfo);     // Catch: PackageManager.NameNotFoundException -> L37
            if (r7 == null) goto L28;
            this.mDisplayLabel = r7;     // Catch: PackageManager.NameNotFoundException -> L37
            this.mLabel = r7.toString();     // Catch: PackageManager.NameNotFoundException -> L37
            this.mPackageInfo = r6.applicationInfo;     // Catch: PackageManager.NameNotFoundException -> L37
            return;
        L28:
            r4 = r4 + 1;
            goto L20
        L30:
            if (this.mServices.size() <= 0) goto L41;
            this.mPackageInfo = this.mServices.values().iterator().next().mServiceInfo.applicationInfo;
            this.mDisplayLabel = ApplicationLabelCache.getInstance().getLabel(this.mContext, this.mPackageInfo);
            this.mLabel = this.mDisplayLabel.toString();
            return;
        L41:
            ApplicationInfo r11 = r10.getApplicationInfo(r2[0], 8192);     // Catch: PackageManager.NameNotFoundException -> L38
            this.mDisplayLabel = ApplicationLabelCache.getInstance().getLabel(this.mContext, r11);     // Catch: PackageManager.NameNotFoundException -> L38
            this.mLabel = this.mDisplayLabel.toString();     // Catch: PackageManager.NameNotFoundException -> L38
            this.mPackageInfo = r11;     // Catch: PackageManager.NameNotFoundException -> L38
            return;
        L51:
            return;
        L39:
            ApplicationInfo r8 = r10.getApplicationInfo(r2[0], 8192);     // Catch: PackageManager.NameNotFoundException -> L36
            this.mDisplayLabel = ApplicationLabelCache.getInstance().getLabel(this.mContext, r8);     // Catch: PackageManager.NameNotFoundException -> L36
            this.mLabel = this.mDisplayLabel.toString();     // Catch: PackageManager.NameNotFoundException -> L36
            this.mPackageInfo = r8;     // Catch: PackageManager.NameNotFoundException -> L36
        }

        boolean updateService(Context r12, ActivityManager.RunningServiceInfo r13) {
            PackageManager r1 = r12.getPackageManager();
            ServiceItem r2 = this.mServices.get(r13.service);
            boolean r4 = true;
            if (r2 != null) goto L14;
            r2 = new ServiceItem(this.mUserId);
            r2.mRunningService = r13;
            r2.mServiceInfo = ActivityThread.getPackageManager().getServiceInfo(r13.service, 8192, UserHandle.getUserId(r13.uid));     // Catch: RemoteException -> L38
            if (r2.mServiceInfo != null) goto L9;
            OLog.d("RunningService", "getServiceInfo returned null for: " + r13.service);     // Catch: RemoteException -> L38
            return false;
        L9:
            r2.mDisplayLabel = RunningState.makeLabel(r1, r2.mRunningService.service.getClassName(), r2.mServiceInfo);
            if (this.mDisplayLabel == null) goto L12;
            String r0 = this.mDisplayLabel.toString();
        L13:
            this.mLabel = r0;
            r2.mPackageInfo = r2.mServiceInfo.applicationInfo;
            this.mServices.put(r13.service, r2);
            boolean r3 = true;
        L15:
            r2.mCurSeq = this.mCurSeq;
            r2.mRunningService = r13;
            if (r13.restarting != 0) goto L18;
            long r6 = r13.activeSince;
        L20:
            if (r2.mActiveSince == r6) goto L23;
            r2.mActiveSince = r6;
            r3 = true;
        L23:
            if (r13.clientPackage == null) goto L33;
            if (r13.clientLabel == 0) goto L33;
            if (r2.mShownAsStarted == false) goto L39;
            r2.mShownAsStarted = false;
            r3 = true;
        L39:
            r2.mDescription = r12.getResources().getString(R.string.service_client_name, new Object[]{r1.getResourcesForApplication(r13.clientPackage).getString(r13.clientLabel)});     // Catch: PackageManager.NameNotFoundException -> L31
            return r3;
        L31:
            r2.mDescription = null;
            return r3;
        L33:
            if (r2.mShownAsStarted == true) goto L35;
            r2.mShownAsStarted = true;
        L36:
            r2.mDescription = r12.getResources().getString(R.string.service_started_by_app);
            return r4;
        L35:
            r4 = r3;
            goto L36
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

        boolean updateSize(Context r3, long r4) {
            long r5 = r4 << 10;
            if (r5 != this.mSize) goto L6;
            return false;
        L6:
            this.mSize = r5;
            return true;
        }

        boolean updateSize(Context r3, long r4, int r6) {
            long r5 = r4 << 10;
            if (r5 != this.mSize) goto L5;
            return false;
        L5:
            this.mSize = r5;
            if (this.mCurSeq == r6) goto L15;
        L14:
            return false;
        L15:
            String r7 = Formatter.formatShortFileSize(r3, this.mSize);     // Catch: Exception -> L12
            if (r7.equals(this.mSizeStr) == true) goto L14;
            this.mSizeStr = r7;
            return false;
        L12:
            e = move-exception;
            e.printStackTrace();
            goto L14
        }

        boolean buildDependencyChain(Context r7, PackageManager r8, int r9) {
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
            r4.mCurSeq = r9;
            r4.ensureLabel(r8);
            r2 = r2 | r4.buildDependencyChain(r7, r8, r9);
            r1 = r1 + 1;
            goto L4
        L10:
            if (this.mLastNumDependentProcesses == this.mDependentProcesses.size()) goto L16;
            this.mLastNumDependentProcesses = this.mDependentProcesses.size();
            return true;
        L16:
            return r2;
        }

        void addDependentProcesses(ArrayList<BaseItem> r5, ArrayList<ProcessItem> r6) {
            int r0 = this.mDependentProcesses.size();
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L8;
            ProcessItem r2 = this.mDependentProcesses.valueAt(r1);
            r2.addDependentProcesses(r5, r6);
            r5.add(r2);
            if (r2.mPid <= 0) goto L7;
            r6.add(r2);
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

        public ServiceItem(int r2) {
            super(false, r2);
        }
    }

    class ServiceProcessComparator implements Comparator<ProcessItem> {
        final /* synthetic */ RunningState this$0;

        ServiceProcessComparator(RunningState r1) {
            this.this$0 = r1;
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(ProcessItem r1, ProcessItem r2) {
            return compare2(r1, r2);
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(ProcessItem r7, ProcessItem r8) {
            if (r7.mUserId == r8.mUserId) goto L15;
            if (r7.mUserId != this.this$0.mMyUserId) goto L8;
            return -1;
        L8:
            if (r8.mUserId != this.this$0.mMyUserId) goto L11;
            return 1;
        L11:
            if (r7.mUserId < r8.mUserId) goto L13;
            return 1;
        L13:
            return -1;
        L15:
            if (r7.mIsStarted == r8.mIsStarted) goto L21;
            if (r7.mIsStarted == true) goto L19;
            return 1;
        L19:
            return -1;
        L21:
            if (r7.mIsSystem == r8.mIsSystem) goto L28;
            if (r7.mIsSystem == false) goto L26;
            return 1;
        L26:
            return -1;
        L28:
            if (r7.mActiveSince != r8.mActiveSince) goto L30;
            return 0;
        L30:
            if (r7.mActiveSince > r8.mActiveSince) goto L32;
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

    static {
        sGlobalLock = new Object();
    }

    static CharSequence makeLabel(PackageManager r1, String r2, PackageItemInfo r3) {
        if (r3 != null) goto L4;
    L10:
        int r4 = r2.lastIndexOf(46);
        if (r4 >= 0) goto L13;
        return r2;
    L13:
        return r2.substring(r4 + 1, r2.length());
    L4:
        if (r3.labelRes == 0) goto L6;
    L7:
        CharSequence r5 = r3.loadLabel(r1);
        if (r5 == null) goto L10;
        return r5;
    L6:
        if (r3.nonLocalizedLabel == null) goto L10;
        goto L7
    }

    static RunningState getInstance(Context r2) {
        Object r0 = sGlobalLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L7;
        sInstance = new RunningState(r2);     // Catch: Throwable -> L10
    L7:
        RunningState r3 = sInstance;     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    }

    private RunningState(Context r3) {
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
        Context r4 = r3.getApplicationContext();
        this.mApplicationContext = r4;
        this.mAm = (ActivityManager) r4.getSystemService("activity");
        this.mPm = r4.getPackageManager();
        this.mUm = (UserManager) r4.getSystemService(PickApplicationActivity.EXTRA_USER);
        this.mMyUserId = UserHandle.myUserId();
        this.mResumed = false;
        HandlerThread r5 = new HandlerThread("RunningState:Background");
        this.mBackgroundThread = r5;
        r5.start();
        this.mBackgroundHandler = new BackgroundHandler(this, r5.getLooper());
    }

    void resume(OnRefreshUiListener r4) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mResumed = true;     // Catch: Throwable -> L13
        this.mRefreshUiListener = r4;     // Catch: Throwable -> L13
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

    void updateNow() {
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
        this.mRefreshUiListener = null;     // Catch: Throwable -> L8
        this.mHandler.removeMessages(4);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private boolean isInterestingProcess(ActivityManager.RunningAppProcessInfo r3) {
        if ((r3.flags & 1) == 0) goto L6;
        return true;
    L6:
        if ((r3.flags & 2) == 0) goto L8;
        return false;
    L8:
        if (r3.importance >= 100) goto L10;
        return false;
    L10:
        if (r3.importance < 350) goto L12;
        return false;
    L12:
        if (r3.importanceReasonCode != 0) goto L18;
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
        this.mAllProcessItems.clear();
        this.mUsers.clear();
    }

    private void addOtherUserItem(Context r6, ArrayList<MergedItem> r7, SparseArray<MergedItem> r8, MergedItem r9) {
        MergedItem r0 = r8.get(r9.mUserId);
        if (r0 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == false) goto L28;
        if (r0 != null) goto L12;
        r0 = new MergedItem(r9.mUserId);
        r8.put(r9.mUserId, r0);
    L13:
        r0.mCurSeq = this.mSequence;
        UserState r10 = this.mUsers.get(r9.mUserId);
        r0.mUser = r10;
        if (r10 != null) goto L27;
        r0.mUser = new UserState();
        UserInfo r11 = this.mUm.getUserInfo(r9.mUserId);
        r0.mUser.mInfo = r11;
        if (r11 == null) goto L18;
        r0.mUser.mIcon = Utils.getUserIcon(r6, this.mUm, r11);
    L18:
        if (r11 == null) goto L20;
        String r5 = r11.name;
    L21:
        if (r5 != null) goto L24;
        if (r11 == null) goto L24;
        r5 = Integer.toString(r11.id);
    L26:
        r0.mUser.mLabel = r6.getResources().getString(R.string.running_process_item_user_label, new Object[]{r5});
    L24:
        if (r11 != null) goto L26;
        r5 = r6.getString(R.string.unknown);
        goto L26
    L20:
        r5 = null;
    L27:
        r7.add(r0);
        goto L28
    L12:
        r0.mChildren.clear();
    L28:
        r0.mChildren.add(r9);
        return;
    L5:
        if (r0.mCurSeq != this.mSequence) goto L8;
        r3 = false;
        goto L9
    }

    public boolean updateSM(ActivityManager r13) {
        PackageManager r0 = this.mApplicationContext.getPackageManager();
        List<ActivityManager.RunningAppProcessInfo> r14 = r13.getRunningAppProcesses();
        ArrayList r1 = new ArrayList();
        Iterator<ActivityManager.RunningAppProcessInfo> r15 = r14.iterator();
        boolean r3 = false;
    L4:
        if (r15.hasNext() == false) goto L59;
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
    L59:
        int r16 = r1.size();     // Catch: RemoteException -> L58
        int[] r2 = new int[r16];     // Catch: RemoteException -> L58
        int r5 = 0;
    L16:
        if (r5 >= r16) goto L18;
        r2[r5] = ((ProcessItem) r1.get(r5)).mPid;     // Catch: RemoteException -> L58
        r5 = r5 + 1;     // Catch: RemoteException -> L58
        goto L16
    L18:
        long[] r7 = ActivityManagerNative.getDefault().getProcessPss(r2);     // Catch: RemoteException -> L58
        int r8 = 0;
    L19:
        if (r8 >= r16) goto L22;
        ProcessItem r9 = (ProcessItem) r1.get(r8);     // Catch: RemoteException -> L58
        r3 = r3 | r9.updateSize(this.mApplicationContext, r7[r8]);     // Catch: RemoteException -> L58
        r9.mMergeSize = r9.mSize;     // Catch: RemoteException -> L58
        r8 = r8 + 1;
    L22:
        ArrayList<MergedItem> r17 = new ArrayList();
        Iterator r10 = r1.iterator();
        long r11 = 0;
    L24:
        if (r10.hasNext() == false) goto L31;
        ProcessItem r12 = (ProcessItem) r10.next();
        if (r12.mPackageInfo == null) goto L24;
        MergedItem r18 = new MergedItem(r12.mUserId);
        r18.mMergeSize = r12.mMergeSize;
        r18.mSize = r12.mSize;
        r18.mProcess = r12;
        r18.mPackageInfo = r12.mPackageInfo;
        r18.mDisplayLabel = r12.mDisplayLabel;
        r17.add(r18);
        if (r12.mRunningProcessInfo.importance < 400) goto L24;
        r11 = r11 + r12.mSize;
        goto L24
    L31:
        if (r3 == true) goto L46;
        Iterator<MergedItem> r19 = this.mMergedItems.iterator();
    L34:
        if (r19.hasNext() == false) goto L46;
        MergedItem r20 = r19.next();
        Iterator<MergedItem> r21 = r17.iterator();
    L37:
        if (r21.hasNext() == false) goto L43;
        MergedItem r22 = r21.next();
        if (r20.mPackageInfo.packageName.equals(r22.mPackageInfo.packageName) == false) goto L37;
        if (r20.mPackageInfo.uid != r22.mPackageInfo.uid) goto L37;
        boolean r23 = true;
    L44:
        if (r23 == true) goto L34;
        r3 = true;
        goto L46
    L43:
        r23 = false;
    L46:
        Object r24 = this.mLock;
        monitor-enter(r24);
        this.mAllProcessItems.clear();     // Catch: Throwable -> L55
        this.mAllProcessItems.addAll(r1);     // Catch: Throwable -> L55
        if (this.mHaveData == true) goto L51;
        this.mHaveData = true;     // Catch: Throwable -> L55
        this.mLock.notifyAll();     // Catch: Throwable -> L55
    L51:
        if (r3 == false) goto L53;
        this.mMergedItems = r17;     // Catch: Throwable -> L55
        this.mBackgroundProcessMemory = r11;     // Catch: Throwable -> L55
    L53:
        monitor-exit(r24);     // Catch: Throwable -> L55
        return r3;
    L55:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Type inference failed for: r0v66, types: [com.android.settings.applications.RunningState$3] */
    /* JADX WARN: Type inference failed for: r3v7, types: [com.android.settings.applications.RunningState$4] */
    public boolean update(final Context r26, ActivityManager r27) {
        PackageManager r3 = r26.getPackageManager();
        boolean r4 = true;
        this.mSequence++;
        List<ActivityManager.RunningServiceInfo> r0 = r27.getRunningServices(100);     // Catch: Exception -> L5
    L7:
        if (r0 == null) goto L9;
        int r8 = r0.size();
    L10:
        int r9 = 0;
    L11:
        if (r9 >= r8) goto L22;
        ActivityManager.RunningServiceInfo r10 = r0.get(r9);
        if (r10.started == true) goto L18;
        if (r10.clientLabel != 0) goto L18;
        r0.remove(r9);
    L20:
        r9 = r9 - 1;
        r8 = r8 - 1;
    L21:
        r9 = r9 + 1;
    L18:
        if ((r10.flags & 8) == 0) goto L21;
        r0.remove(r9);
        goto L20
    L22:
        List<ActivityManager.RunningAppProcessInfo> r6 = r27.getRunningAppProcesses();
        if (r6 == null) goto L25;
        int r11 = r6.size();
    L26:
        this.mTmpAppProcesses.clear();
        int r12 = 0;
    L27:
        if (r12 >= r11) goto L29;
        ActivityManager.RunningAppProcessInfo r13 = r6.get(r12);
        this.mTmpAppProcesses.put(r13.pid, new AppProcessInfo(r13));
        r12 = r12 + 1;
        goto L27
    L29:
        int r14 = 0;
    L31:
        if (r14 >= r8) goto L42;
        ActivityManager.RunningServiceInfo r15 = r0.get(r14);
        if (r15.restarting != 0) goto L41;
        if (r15.pid <= 0) goto L41;
        AppProcessInfo r16 = this.mTmpAppProcesses.get(r15.pid);
        if (r16 == null) goto L41;
        r16.hasServices = true;
        if (r15.foreground == false) goto L41;
        r16.hasForegroundServices = true;
    L41:
        r14 = r14 + 1;
        goto L31
    L42:
        int r17 = 0;
        boolean r18 = false;
    L43:
        if (r17 >= r8) goto L94;
        ActivityManager.RunningServiceInfo r19 = r0.get(r17);
        int r110 = r8;
        if (r19.restarting == 0) goto L47;
    L68:
        HashMap<String, ProcessItem> r7 = this.mServiceProcessesByName.get(r19.uid);
        if (r7 != null) goto L71;
        r7 = new HashMap();
        this.mServiceProcessesByName.put(r19.uid, r7);
    L71:
        ProcessItem r20 = r7.get(r19.process);
        if (r20 != null) goto L75;
        r20 = new ProcessItem(r26, r19.uid, r19.process);
        r7.put(r19.process, r20);
        r18 = r4;
    L75:
        if (r20.mCurSeq != this.mSequence) goto L77;
    L92:
        r18 = r18 | r20.updateService(r26, r19);
    L93:
        r17 = r17 + 1;
        r8 = r110;
        r4 = true;
        goto L43
    L77:
        if (r19.restarting != 0) goto L79;
        int r111 = r19.pid;
    L81:
        if (r111 != r20.mPid) goto L83;
    L91:
        r20.mDependentProcesses.clear();
        r20.mCurSeq = this.mSequence;
        goto L92
    L83:
        if (r20.mPid != r111) goto L85;
    L90:
        r18 = true;
        goto L91
    L85:
        if (r20.mPid == 0) goto L87;
        this.mServiceProcessesByPid.remove(r20.mPid);
    L87:
        if (r111 == 0) goto L89;
        this.mServiceProcessesByPid.put(r111, r20);
    L89:
        r20.mPid = r111;
        goto L90
    L79:
        r111 = 0;
        goto L81
    L47:
        if (r19.pid <= 0) goto L68;
        AppProcessInfo r21 = this.mTmpAppProcesses.get(r19.pid);
        if (r21 == null) goto L68;
        if (r21.hasForegroundServices == true) goto L68;
        if (r21.info.importance >= 300) goto L68;
        if (r21.info.processName.equals("com.obric.recorder") == true) goto L68;
        AppProcessInfo r22 = this.mTmpAppProcesses.get(r21.info.importanceReasonPid);
    L57:
        if (r22 == null) goto L65;
        if (r22.hasServices == true) goto L64;
        if (isInterestingProcess(r22.info) == true) goto L64;
        r22 = this.mTmpAppProcesses.get(r22.info.importanceReasonPid);
    L64:
        boolean r112 = r4;
    L66:
        if (r112 == false) goto L68;
    L65:
        r112 = false;
        goto L66
    L94:
        int r1 = 0;
    L95:
        if (r1 >= r11) goto L110;
        ActivityManager.RunningAppProcessInfo r5 = r6.get(r1);
        ProcessItem r23 = this.mServiceProcessesByPid.get(r5.pid);
        if (r23 != null) goto L103;
        r23 = this.mRunningProcesses.get(r5.pid);
        if (r23 != null) goto L101;
        r23 = new ProcessItem(r26, r5.uid, r5.processName);
        r23.mPid = r5.pid;
        this.mRunningProcesses.put(r5.pid, r23);
        r18 = true;
    L101:
        r23.mDependentProcesses.clear();
    L103:
        if (isInterestingProcess(r5) == true) goto L105;
        r23.mInteresting = false;
    L109:
        r23.mRunningSeq = this.mSequence;
        r23.mRunningProcessInfo = r5;
        r1 = r1 + 1;
        goto L95
    L105:
        if (this.mInterestingProcesses.contains(r23) == true) goto L107;
        this.mInterestingProcesses.add(r23);
        r18 = true;
    L107:
        r23.mCurSeq = this.mSequence;
        r23.mInteresting = true;
        r23.ensureLabel(r3);
        goto L109
    L110:
        int r2 = this.mRunningProcesses.size();
        int r24 = 0;
    L111:
        if (r24 >= r2) goto L125;
        ProcessItem r25 = this.mRunningProcesses.valueAt(r24);
        if (r25.mRunningSeq == this.mSequence) goto L114;
        SparseArray<ProcessItem> r28 = this.mRunningProcesses;
        r28.remove(r28.keyAt(r24));
        r2 = r2 - 1;
        r18 = true;
        goto L111
    L114:
        int r29 = r25.mRunningProcessInfo.importanceReasonPid;
        if (r29 == 0) goto L122;
        ProcessItem r30 = this.mServiceProcessesByPid.get(r29);
        if (r30 != null) goto L119;
        r30 = this.mRunningProcesses.get(r29);
    L119:
        if (r30 == null) goto L123;
        r30.mDependentProcesses.put(r25.mPid, r25);
    L123:
        r24 = r24 + 1;
        goto L111
    L122:
        r25.mClient = null;
        goto L123
    L125:
        int r31 = this.mInterestingProcesses.size();
        int r32 = 0;
    L126:
        if (r32 >= r31) goto L135;
        ProcessItem r33 = this.mInterestingProcesses.get(r32);
        if (r33.mInteresting == true) goto L130;
    L133:
        this.mInterestingProcesses.remove(r32);
        r32 = r32 - 1;
        r31 = r31 - 1;
        int r34 = 1;
        r18 = true;
    L134:
        r32 = r32 + r34;
        goto L126
    L130:
        if (this.mRunningProcesses.get(r33.mPid) == null) goto L133;
        r34 = 1;
        goto L134
    L135:
        int r35 = this.mServiceProcessesByPid.size();
        int r36 = 0;
    L136:
        if (r36 >= r35) goto L141;
        ProcessItem r37 = this.mServiceProcessesByPid.valueAt(r36);
        int r38 = r37.mCurSeq;
        int r39 = this.mSequence;
        if (r38 != r39) goto L140;
        r18 = r37.buildDependencyChain(r26, r3, r39) | r18;
    L140:
        r36 = r36 + 1;
        goto L136
    L141:
        ArrayList r40 = null;
        int r41 = 0;
    L143:
        if (r41 >= this.mServiceProcessesByName.size()) goto L168;
        HashMap<String, ProcessItem> r42 = this.mServiceProcessesByName.valueAt(r41);
        Iterator<ProcessItem> r43 = r42.values().iterator();
    L146:
        if (r43.hasNext() == false) goto L167;
        ProcessItem r44 = r43.next();
        if (r44.mCurSeq == this.mSequence) goto L149;
        r43.remove();
        if (r42.size() != 0) goto L164;
        if (r40 != null) goto L162;
        r40 = new ArrayList();
    L162:
        r40.add(Integer.valueOf(this.mServiceProcessesByName.keyAt(r41)));
    L164:
        if (r44.mPid == 0) goto L166;
        this.mServiceProcessesByPid.remove(r44.mPid);
    L166:
        r18 = true;
        goto L146
    L149:
        r44.ensureLabel(r3);
        if (r44.mPid != 0) goto L152;
        r44.mDependentProcesses.clear();
    L152:
        Iterator<ServiceItem> r45 = r44.mServices.values().iterator();
    L154:
        if (r45.hasNext() == false) goto L146;
        if (r45.next().mCurSeq == this.mSequence) goto L154;
        r45.remove();
        r18 = true;
        goto L154
    L167:
        r41 = r41 + 1;
        goto L143
    L168:
        if (r40 == null) goto L173;
        int r46 = 0;
    L171:
        if (r46 >= r40.size()) goto L173;
        this.mServiceProcessesByName.remove(((Integer) r40.get(r46)).intValue());
        r46 = r46 + 1;
    L173:
        if (r18 == false) goto L254;
        ArrayList r47 = new ArrayList();
        int r48 = 0;
    L176:
        if (r48 >= this.mServiceProcessesByName.size()) goto L198;
        Iterator<ProcessItem> r49 = this.mServiceProcessesByName.valueAt(r48).values().iterator();
    L179:
        if (r49.hasNext() == false) goto L197;
        ProcessItem r50 = r49.next();
        r50.mIsSystem = false;
        r50.mIsStarted = true;
        r50.mActiveSince = Long.MAX_VALUE;
        Iterator<ServiceItem> r51 = r50.mServices.values().iterator();
    L182:
        if (r51.hasNext() == false) goto L196;
        ServiceItem r52 = r51.next();
        if (r52.mServiceInfo == null) goto L189;
        if ((r52.mServiceInfo.applicationInfo.flags & 1) == 0) goto L189;
        r50.mIsSystem = true;
    L189:
        if (r52.mRunningService == null) goto L182;
        if (r52.mRunningService.clientLabel == 0) goto L182;
        r50.mIsStarted = false;
        if (r50.mActiveSince <= r52.mRunningService.activeSince) goto L182;
        r50.mActiveSince = r52.mRunningService.activeSince;
        goto L182
    L196:
        r47.add(r50);
        goto L179
    L197:
        r48 = r48 + 1;
        goto L176
    L198:
        ArrayList<BaseItem> r53 = new ArrayList();
        ArrayList<MergedItem> r54 = new ArrayList();
        this.mProcessItems.clear();
        int r55 = r47.size();
        int r56 = 0;
    L199:
        if (r56 >= r55) goto L225;
        ProcessItem r57 = (ProcessItem) r47.get(r56);
        r57.mNeedDivider = false;
        int r58 = this.mProcessItems.size();
        r57.addDependentProcesses(r53, this.mProcessItems);
        r53.add(r57);
        if (r57.mPid <= 0) goto L203;
        this.mProcessItems.add(r57);
    L203:
        Iterator<ServiceItem> r59 = r57.mServices.values().iterator();
        boolean r113 = false;
        MergedItem r114 = null;
    L205:
        if (r59.hasNext() == false) goto L212;
        ServiceItem r115 = r59.next();
        r115.mNeedDivider = r113;
        r53.add(r115);
        if (r115.mMergedItem == null) goto L211;
        if (r114 == null) goto L210;
        MergedItem r116 = r115.mMergedItem;
    L210:
        r114 = r115.mMergedItem;
    L211:
        r113 = true;
        goto L205
    L212:
        MergedItem r60 = new MergedItem(r57.mUserId);
        Iterator<ServiceItem> r117 = r57.mServices.values().iterator();
    L214:
        if (r117.hasNext() == false) goto L216;
        ServiceItem r118 = r117.next();
        r60.mServices.add(r118);
        r118.mMergedItem = r60;
        goto L214
    L216:
        r60.mProcess = r57;
        r60.mOtherProcesses.clear();
    L218:
        if (r58 >= (this.mProcessItems.size() - 1)) goto L220;
        r60.mOtherProcesses.add(this.mProcessItems.get(r58));
        r58 = r58 + 1;
        goto L218
    L220:
        r60.update(r26, false);
        if (r60.mUserId == this.mMyUserId) goto L223;
        addOtherUserItem(r26, r54, this.mOtherUserMergedItems, r60);
    L224:
        r56 = r56 + 1;
        goto L199
    L223:
        r54.add(r60);
        goto L224
    L225:
        int r61 = this.mInterestingProcesses.size();
        int r62 = 0;
    L226:
        if (r62 >= r61) goto L240;
        ProcessItem r63 = this.mInterestingProcesses.get(r62);
        if (r63.mClient != null) goto L239;
        if (r63.mServices.size() > 0) goto L239;
        if (r63.mMergedItem != null) goto L234;
        r63.mMergedItem = new MergedItem(r63.mUserId);
        r63.mMergedItem.mProcess = r63;
    L234:
        r63.mMergedItem.update(r26, false);
        if (r63.mMergedItem.mUserId == this.mMyUserId) goto L237;
        addOtherUserItem(r26, r54, this.mOtherUserMergedItems, r63.mMergedItem);
    L238:
        this.mProcessItems.add(r63);
        goto L239
    L237:
        r54.add(0, r63.mMergedItem);
    L239:
        r62 = r62 + 1;
        goto L226
    L240:
        int r64 = this.mOtherUserMergedItems.size();
        int r65 = 0;
    L241:
        if (r65 >= r64) goto L246;
        MergedItem r66 = this.mOtherUserMergedItems.valueAt(r65);
        if (r66.mCurSeq != this.mSequence) goto L245;
        r66.update(r26, false);
    L245:
        r65 = r65 + 1;
        goto L241
    L246:
        Object r67 = this.mLock;
        monitor-enter(r67);
        this.mItems = r53;     // Catch: Throwable -> L251
        this.mMergedItems = r54;     // Catch: Throwable -> L251
        monitor-exit(r67);     // Catch: Throwable -> L251
        new AnonymousClass3(this, r26).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    L251:
        th = move-exception;
        throw th;
    L254:
        this.mAllProcessItems.clear();
        this.mAllProcessItems.addAll(this.mProcessItems);
        int r68 = this.mRunningProcesses.size();
        int r69 = 0;
        int r70 = 0;
        int r71 = 0;
        int r72 = 0;
    L256:
        if (r69 >= r68) goto L420;
        ProcessItem r119 = this.mRunningProcesses.valueAt(r69);
        if (r119.mCurSeq != this.mSequence) goto L260;
        r70 = r70 + 1;
    L267:
        r69 = r69 + 1;
        goto L256
    L260:
        if (r119.mRunningProcessInfo.importance < 400) goto L263;
        r71 = r71 + 1;
        this.mAllProcessItems.add(r119);
        goto L267
    L263:
        if (r119.mRunningProcessInfo.importance > 200) goto L265;
        r72 = r72 + 1;
        this.mAllProcessItems.add(r119);
        goto L267
    L265:
        OLog.i(TAG, "Unknown non-service process: " + r119.mProcessName + " #" + r119.mPid);
        goto L267
    L420:
        int r73 = this.mAllProcessItems.size();     // Catch: RemoteException -> L341
        int[] r74 = new int[r73];     // Catch: RemoteException -> L341
        int r120 = 0;
    L269:
        if (r120 >= r73) goto L271;
        r74[r120] = this.mAllProcessItems.get(r120).mPid;     // Catch: RemoteException -> L341
        r120 = r120 + 1;     // Catch: RemoteException -> L341
        goto L269
    L271:
        long[] r75 = ActivityManagerNative.getDefault().getProcessPss(r74);     // Catch: RemoteException -> L341
        boolean r121 = r18;
        int r76 = 0;
        ArrayList<MergedItem> r77 = null;
        boolean r122 = false;
        int r123 = 0;
        long r124 = 0;
        long r125 = 0;
        long r126 = 0;
    L418:
        if (r76 >= this.mAllProcessItems.size()) goto L338;
        ProcessItem r127 = this.mAllProcessItems.get(r76);     // Catch: RemoteException -> L397
        long[] r210 = r75;
        r121 = r121 | r127.updateSize(r26, r75[r76], this.mSequence);
    L336:
        boolean r211 = r121;
    L337:
        r18 = r211;
    L340:
        long r128 = r125;
        long r129 = r124;
    L342:
        boolean r78 = r122;
        long r130 = r128;
        long r131 = r129;
    L343:
        long r79 = r126;
        if (r77 == null) goto L346;
    L355:
        long r132 = r79;
        boolean r133 = r18;
        boolean r134 = r78;
    L356:
        final ArrayList<MergedItem> r80 = r77;
        if (r80 == null) goto L374;
        new AnonymousClass4(this, r80, r26).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        if (r134 == true) goto L361;
        ArrayList<MergedItem> r81 = r80;
    L375:
        int r82 = 0;
    L377:
        if (r82 >= this.mMergedItems.size()) goto L379;
        this.mMergedItems.get(r82).updateSize(r26);
        r82 = r82 + 1;
        goto L377
    L379:
        Object r83 = this.mLock;
        monitor-enter(r83);
        this.mNumBackgroundProcesses = r71;     // Catch: Throwable -> L391
        this.mNumForegroundProcesses = r72;     // Catch: Throwable -> L391
        this.mNumServiceProcesses = r70;     // Catch: Throwable -> L391
        this.mBackgroundProcessMemory = r130;     // Catch: Throwable -> L391
        this.mForegroundProcessMemory = r131;     // Catch: Throwable -> L391
        this.mServiceProcessMemory = r132;     // Catch: Throwable -> L391
        if (r80 == null) goto L387;
        this.mBackgroundItems = r80;     // Catch: Throwable -> L391
        this.mUserBackgroundItems = r81;     // Catch: Throwable -> L391
        if (this.mWatchingBackgroundItems == false) goto L387;
        r133 = true;
    L387:
        if (this.mHaveData == true) goto L389;
        this.mHaveData = true;     // Catch: Throwable -> L391
        this.mLock.notifyAll();     // Catch: Throwable -> L391
    L389:
        monitor-exit(r83);     // Catch: Throwable -> L391
        return r133;
    L391:
        th = move-exception;
        throw th;
    L361:
        r81 = new ArrayList();
        int r84 = r80.size();
        int r85 = 0;
    L362:
        if (r85 >= r84) goto L368;
        MergedItem r135 = r80.get(r85);
        if (r135.mUserId == this.mMyUserId) goto L366;
        addOtherUserItem(r26, r81, this.mOtherUserBackgroundItems, r135);
    L367:
        r85 = r85 + 1;
        goto L362
    L366:
        r81.add(r135);
        goto L367
    L368:
        int r86 = this.mOtherUserBackgroundItems.size();
        int r87 = 0;
    L369:
        if (r87 >= r86) goto L375;
        MergedItem r136 = this.mOtherUserBackgroundItems.valueAt(r87);
        if (r136.mCurSeq != this.mSequence) goto L373;
        r136.update(r26, true);
        r136.updateSize(r26);
    L373:
        r87 = r87 + 1;
        goto L369
    L374:
        r81 = null;
        goto L375
    L346:
        if (this.mBackgroundItems.size() <= r71) goto L355;
        r77 = new ArrayList(r71);
        boolean r88 = r78;
        int r89 = 0;
    L348:
        if (r89 >= r71) goto L354;
        MergedItem r90 = this.mBackgroundItems.get(r89);
        boolean r137 = r18;
        long r138 = r79;
        if (r90.mUserId == this.mMyUserId) goto L352;
        boolean r91 = true;
    L353:
        r88 = r88 | r91;
        r77.add(r90);
        r89 = r89 + 1;
        r18 = r137;
        r79 = r138;
        goto L348
    L352:
        r91 = false;
        goto L353
    L354:
        r132 = r79;
        r133 = r18;
        r134 = r88;
        goto L356
    L278:
        if (r127.mCurSeq != this.mSequence) goto L283;
        r126 = r126 + r127.mSize;
        r211 = r121;
    L335:
        r76 = r76 + 1;
        r75 = r210;
        r121 = r211;
        goto L418
    L283:
        if (r127.mRunningProcessInfo.importance >= 400) goto L285;
        r211 = r121;
        if (r127.mRunningProcessInfo.importance > 200) goto L335;
        r124 = r124 + r127.mSize;
        goto L335
    L285:
        long r92 = r125 + r127.mSize;
        if (r77 != null) goto L412;
        r125 = r92;
        if (r123 < this.mBackgroundItems.size()) goto L302;
    L307:
        ArrayList<MergedItem> r93 = new ArrayList(r71);     // Catch: RemoteException -> L336
        int r94 = 0;
    L309:
        if (r94 >= r123) goto L318;
        MergedItem r95 = this.mBackgroundItems.get(r94);     // Catch: RemoteException -> L317
        r211 = r121;
        if (r95.mUserId == this.mMyUserId) goto L315;
        boolean r96 = true;
    L316:
        r122 = r122 | r96;     // Catch: RemoteException -> L396
        r93.add(r95);     // Catch: RemoteException -> L396
        r94 = r94 + 1;     // Catch: RemoteException -> L396
        r121 = r211;
        goto L309
    L315:
        r96 = false;
    L329:
        r77 = r93;
    L317:
        r211 = r121;
        goto L329
    L318:
        r211 = r121;
        MergedItem r97 = new MergedItem(r127.mUserId);     // Catch: RemoteException -> L396
        r127.mMergedItem = r97;     // Catch: RemoteException -> L396
        r127.mMergedItem.mProcess = r127;     // Catch: RemoteException -> L396
        if (r97.mUserId == this.mMyUserId) goto L321;
        boolean r98 = true;
    L322:
        boolean r99 = r98 | r122;
        r93.add(r97);     // Catch: RemoteException -> L328
        boolean r100 = true;
        r77 = r93;
        MergedItem r101 = r97;
    L400:
        r101.update(r26, r100);     // Catch: RemoteException -> L394
        r101.updateSize(r26);     // Catch: RemoteException -> L394
        r123 = r123 + 1;
        r122 = r99;
    L327:
        r122 = r99;
    L328:
        r77 = r93;
        goto L327
    L321:
        r98 = false;
        goto L322
    L302:
        if (this.mBackgroundItems.get(r123).mProcess != r127) goto L307;
        r101 = this.mBackgroundItems.get(r123);     // Catch: RemoteException -> L397
        r99 = r122;
    L306:
        r211 = r121;
        r100 = true;
        goto L400
    L412:
        r125 = r92;
        r101 = new MergedItem(r127.mUserId);     // Catch: RemoteException -> L397
        r127.mMergedItem = r101;     // Catch: RemoteException -> L397
        r127.mMergedItem.mProcess = r127;     // Catch: RemoteException -> L397
        if (r101.mUserId == this.mMyUserId) goto L292;
        boolean r102 = true;
    L293:
        r99 = r102 | r122;
        r77.add(r101);     // Catch: RemoteException -> L296
    L296:
        r122 = r99;
        goto L339
    L292:
        r102 = false;
    L297:
        r125 = r92;
        goto L339
    L338:
        r78 = r122;
        r131 = r124;
        r18 = r121;
        r130 = r125;
    L339:
        r18 = r121;
    L341:
        r77 = null;
        r122 = false;
        r128 = 0;
        r129 = 0;
        r126 = 0;
        goto L342
    L25:
        r11 = 0;
        goto L26
    L9:
        r8 = 0;
    L5:
        e = move-exception;
        e.printStackTrace();
        r0 = null;
        goto L7
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

    void setWatchingBackgroundItems(boolean r2) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mWatchingBackgroundItems = r2;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    ArrayList<MergedItem> getCurrentMergedItems() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        ArrayList<MergedItem> r1 = this.mMergedItems;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
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
