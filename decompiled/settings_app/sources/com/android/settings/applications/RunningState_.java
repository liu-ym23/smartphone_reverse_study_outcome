package com.android.settings.applications;

import android.app.ActivityManager;
import android.app.ActivityManagerNative;
import android.app.ActivityThread;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.content.pm.UserInfo;
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
import com.android.settings.R;
import com.android.settings.SettingsApplication;
import com.android.settings.SettingsInitialize;
import com.android.settings.utils.NullSafe;
import com.android.settingslib.Utils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Insert;

/* JADX INFO: loaded from: classes2.dex */
public class RunningState_ {
    static final long CONTENTS_UPDATE_DELAY = 2000;
    static final boolean DEBUG_COMPARE = false;
    static final int MAX_SERVICES = 100;
    static final int MSG_REFRESH_UI = 3;
    static final int MSG_RESET_CONTENTS = 1;
    static final int MSG_UPDATE_CONTENTS = 2;
    static final int MSG_UPDATE_TIME = 4;
    static final String TAG = "RunningState_";
    static final long TIME_UPDATE_DELAY = 1000;
    static Object sGlobalLock;
    static RunningState_ sInstance;
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
    final boolean mHideManagedProfiles;
    final com.android.settingslib.applications.InterestingConfigChanges mInterestingConfigChanges;
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
    private final UserManagerBroadcastReceiver mUmBroadcastReceiver;
    ArrayList<MergedItem> mUserBackgroundItems;
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
        final /* synthetic */ RunningState_ this$0;

        public BackgroundHandler(RunningState_ r1, Looper r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r5) {
            int r6 = r5.what;
            if (r6 != 1) goto L5;
            RunningState_.access$000(this.this$0);
            return;
        L5:
            if (r6 != 2) goto L22;
            Object r7 = this.this$0.mLock;
            monitor-enter(r7);
        L15:
            th = move-exception;
            throw th;
        L10:
            if (this.this$0.mResumed == true) goto L13;
            monitor-exit(r7);     // Catch: Throwable -> L15
            return;
        L13:
            monitor-exit(r7);     // Catch: Throwable -> L15
            Message r8 = this.this$0.mHandler.obtainMessage(3);
            RunningState_ r1 = this.this$0;
            r8.arg1 = RunningState_.access$100(r1, r1.mApplicationContext, this.this$0.mAm) ? 1 : 0;
            this.this$0.mHandler.sendMessage(r8);
            removeMessages(2);
            sendMessageDelayed(obtainMessage(2), RunningState_.CONTENTS_UPDATE_DELAY);
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
        final boolean mIsProcess;
        String mLabel;
        boolean mNeedDivider;
        PackageItemInfo mPackageInfo;
        long mSize;
        String mSizeStr;
        final int mUserId;

        public BaseItem(boolean r1, int r2) {
            this.mIsProcess = r1;
            this.mUserId = r2;
        }

        public Drawable loadIcon(Context r2, RunningState_ r3) {
            PackageItemInfo r4 = this.mPackageInfo;
            if (r4 == null) goto L6;
            Drawable r5 = r4.loadUnbadgedIcon(r3.mPm);
            return r3.mPm.getUserBadgedIcon(r5, new UserHandle(this.mUserId));
        L6:
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

        boolean update(Context r11, boolean r12) {
            this.mBackground = r12;
            if (this.mUser == null) goto L20;
            this.mPackageInfo = this.mChildren.get(0).mProcess.mPackageInfo;
            UserState r13 = this.mUser;
            if (r13 == null) goto L7;
            String r14 = r13.mLabel;
        L8:
            this.mLabel = r14;
            this.mDisplayLabel = this.mLabel;
            this.mActiveSince = -1;
            int r15 = 0;
            int r2 = 0;
            int r3 = 0;
        L10:
            if (r15 >= this.mChildren.size()) goto L18;
            MergedItem r5 = this.mChildren.get(r15);
            r2 = r2 + r5.mLastNumProcesses;
            r3 = r3 + r5.mLastNumServices;
            if (r5.mActiveSince < 0) goto L16;
            if (this.mActiveSince >= r5.mActiveSince) goto L16;
            this.mActiveSince = r5.mActiveSince;
        L16:
            r15 = r15 + 1;
            goto L10
        L18:
            if (this.mBackground == true) goto L36;
            setDescription(r11, r2, r3);
        L36:
            return false;
        L7:
            r14 = null;
            goto L8
        L20:
            this.mPackageInfo = this.mProcess.mPackageInfo;
            this.mDisplayLabel = this.mProcess.mDisplayLabel;
            this.mLabel = this.mProcess.mLabel;
            if (this.mBackground == false) goto L23;
        L27:
            this.mActiveSince = -1;
            int r16 = 0;
        L29:
            if (r16 >= this.mServices.size()) goto L36;
            ServiceItem r17 = this.mServices.get(r16);
            if (r17.mActiveSince < 0) goto L35;
            if (this.mActiveSince >= r17.mActiveSince) goto L35;
            this.mActiveSince = r17.mActiveSince;
        L35:
            r16 = r16 + 1;
            goto L29
        L23:
            if (this.mProcess.mPid <= 0) goto L25;
            int r18 = 1;
        L26:
            setDescription(r11, r18 + this.mOtherProcesses.size(), this.mServices.size());
            goto L27
        L25:
            r18 = 0;
            goto L26
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
            String r9 = Formatter.formatShortFileSize(r8, this.mSize);
            if (r9.equals(this.mSizeStr) == true) goto L15;
            this.mSizeStr = r9;
        L15:
            return false;
        L8:
            this.mSize = this.mProcess.mSize;
            int r1 = 0;
        L10:
            if (r1 >= this.mOtherProcesses.size()) goto L12;
            this.mSize += this.mOtherProcesses.get(r1).mSize;
            r1 = r1 + 1;
            goto L10
        }

        @Override // com.android.settings.applications.RunningState_.BaseItem
        public Drawable loadIcon(Context r2, RunningState_ r3) {
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
            return r2.getDrawable(android.R.drawable.pointer_arrow_vector);
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
            this.mDescription = r3.getResources().getString(R.string.service_process_name, new Object[]{r5});
            this.mUid = r4;
            this.mProcessName = r5;
        }

        void ensureLabel(PackageManager r10) {
            if (this.mLabel == null) goto L41;
            return;
        L41:
            ApplicationInfo r1 = r10.getApplicationInfo(this.mProcessName, 8192);     // Catch: PackageManager.NameNotFoundException -> L33
            if (r1.uid != this.mUid) goto L10;
            this.mDisplayLabel = r1.loadLabel(r10);     // Catch: PackageManager.NameNotFoundException -> L33
            this.mLabel = this.mDisplayLabel.toString();     // Catch: PackageManager.NameNotFoundException -> L33
            this.mPackageInfo = r1;     // Catch: PackageManager.NameNotFoundException -> L33
            return;
        L10:
            String[] r2 = r10.getPackagesForUid(this.mUid);
            if (r2.length == 1) goto L39;
        L14:
            int r3 = r2.length;
            int r4 = 0;
        L15:
            if (r4 >= r3) goto L25;
            String r5 = r2[r4];
            PackageInfo r6 = r10.getPackageInfo(r5, 0);     // Catch: PackageManager.NameNotFoundException -> L35
            if (r6.sharedUserLabel == 0) goto L23;
            CharSequence r7 = r10.getText(r5, r6.sharedUserLabel, r6.applicationInfo);     // Catch: PackageManager.NameNotFoundException -> L35
            if (r7 == null) goto L23;
            this.mDisplayLabel = r7;     // Catch: PackageManager.NameNotFoundException -> L35
            this.mLabel = r7.toString();     // Catch: PackageManager.NameNotFoundException -> L35
            this.mPackageInfo = r6.applicationInfo;     // Catch: PackageManager.NameNotFoundException -> L35
            return;
        L23:
            r4 = r4 + 1;
            goto L15
        L25:
            if (this.mServices.size() <= 0) goto L37;
            this.mPackageInfo = this.mServices.values().iterator().next().mServiceInfo.applicationInfo;
            this.mDisplayLabel = this.mPackageInfo.loadLabel(r10);
            this.mLabel = this.mDisplayLabel.toString();
            return;
        L37:
            ApplicationInfo r0 = r10.getApplicationInfo(r2[0], 8192);     // Catch: PackageManager.NameNotFoundException -> L36
            if (r0 != null) goto L31;
            return;
        L31:
            this.mDisplayLabel = r0.loadLabel(r10);     // Catch: PackageManager.NameNotFoundException -> L36
            this.mLabel = this.mDisplayLabel.toString();     // Catch: PackageManager.NameNotFoundException -> L36
            this.mPackageInfo = r0;     // Catch: PackageManager.NameNotFoundException -> L36
            return;
        L49:
            return;
        L39:
            ApplicationInfo r8 = r10.getApplicationInfo(r2[0], 8192);     // Catch: PackageManager.NameNotFoundException -> L34
            this.mDisplayLabel = r8.loadLabel(r10);     // Catch: PackageManager.NameNotFoundException -> L34
            this.mLabel = this.mDisplayLabel.toString();     // Catch: PackageManager.NameNotFoundException -> L34
            this.mPackageInfo = r8;     // Catch: PackageManager.NameNotFoundException -> L34
        }

        boolean updateService(Context r12, ActivityManager.RunningServiceInfo r13) {
            PackageManager r1 = (PackageManager) NullSafe.nonNull(r12.getPackageManager());
            ServiceItem r2 = this.mServices.get(r13.service);
            boolean r4 = true;
            if (r2 != null) goto L14;
            r2 = new ServiceItem(this.mUserId);
            r2.mRunningService = r13;
            r2.mServiceInfo = ActivityThread.getPackageManager().getServiceInfo(r13.service, 8192, UserHandle.getUserId(r13.uid));     // Catch: RemoteException -> L40
            if (r2.mServiceInfo != null) goto L9;
            OLog.d("RunningService", "getServiceInfo returned null for: " + r13.service);     // Catch: RemoteException -> L40
            return false;
        L9:
            r2.mDisplayLabel = RunningState_.makeLabel(r1, r2.mRunningService.service.getClassName(), r2.mServiceInfo);
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
            if (r13.clientPackage == null) goto L35;
            if (r13.clientLabel == 0) goto L35;
            if (r2.mShownAsStarted == false) goto L41;
            r2.mShownAsStarted = false;
            r3 = true;
        L41:
            Resources r11 = r1.getResourcesForApplication(r13.clientPackage);     // Catch: PackageManager.NameNotFoundException -> L33
            if (r11 == null) goto L45;
            r2.mDescription = r12.getResources().getString(R.string.service_client_name, new Object[]{r11.getString(r13.clientLabel)});     // Catch: PackageManager.NameNotFoundException -> L33
            return r3;
        L45:
            return r3;
        L33:
            r2.mDescription = null;
            return r3;
        L35:
            if (r2.mShownAsStarted == true) goto L37;
            r2.mShownAsStarted = true;
        L38:
            r2.mDescription = r12.getResources().getString(R.string.service_started_by_app);
            return r4;
        L37:
            r4 = r3;
            goto L38
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

        boolean updateSize(Context r3, long r4, int r6) {
            this.mSize = r4 * 1024;
            if (this.mCurSeq != r6) goto L7;
            String r5 = Formatter.formatShortFileSize(r3, this.mSize);
            if (r5.equals(this.mSizeStr) == true) goto L7;
            this.mSizeStr = r5;
        L7:
            return false;
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
        final /* synthetic */ RunningState_ this$0;

        ServiceProcessComparator(RunningState_ r1) {
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

    private final class UserManagerBroadcastReceiver extends BroadcastReceiver {
        final /* synthetic */ RunningState_ this$0;
        private volatile boolean usersChanged;

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r1, Intent r2) {
            com_android_settings_applications_RunningState_$UserManagerBroadcastReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(this, r1, r2);
        }

        private UserManagerBroadcastReceiver(RunningState_ r1) {
            this.this$0 = r1;
        }

        /* synthetic */ UserManagerBroadcastReceiver(RunningState_ r1, AnonymousClass1 r2) {
            this(r1);
        }

        public void com_android_settings_applications_RunningState_$UserManagerBroadcastReceiver__onReceive$___twin___(Context r3, Intent r4) {
            Object r5 = this.this$0.mLock;
            monitor-enter(r5);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (this.this$0.mResumed == false) goto L7;
            this.this$0.mHaveData = false;     // Catch: Throwable -> L10
            this.this$0.mBackgroundHandler.removeMessages(1);     // Catch: Throwable -> L10
            this.this$0.mBackgroundHandler.sendEmptyMessage(1);     // Catch: Throwable -> L10
            this.this$0.mBackgroundHandler.removeMessages(2);     // Catch: Throwable -> L10
            this.this$0.mBackgroundHandler.sendEmptyMessage(2);     // Catch: Throwable -> L10
        L8:
            monitor-exit(r5);     // Catch: Throwable -> L10
            return;
        L7:
            this.usersChanged = true;     // Catch: Throwable -> L10
            goto L8
        }

        public boolean checkUsersChangedLocked() {
            boolean r0 = this.usersChanged;
            this.usersChanged = false;
            return r0;
        }

        void register(Context r7) {
            IntentFilter r3 = new IntentFilter();
            r3.addAction("android.intent.action.USER_STOPPED");
            r3.addAction("android.intent.action.USER_STARTED");
            r3.addAction("android.intent.action.USER_INFO_CHANGED");
            r7.registerReceiverAsUser(this, UserHandle.ALL, r3, null, null);
        }

        @Insert("onReceive")
        public static void com_android_settings_applications_RunningState_$UserManagerBroadcastReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(UserManagerBroadcastReceiver r7, Context r8, Intent r9) {
            Intrinsics.checkNotNullParameter(r8, "context");
            String[] r0 = {"android.bluetooth.device.action.PAIRING_REQUEST", "android.bluetooth.device.action.BOND_STATE_CHANGED", "com.bytedanceos.launcher.new_message", "intent.provision.import_data", "com.android.settings.action.SHOW_IMPORT_DATA_NOTIFICATION"};
            Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.content.BroadcastReceiver");
            UserManagerBroadcastReceiver r1 = r7;
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
            r7.com_android_settings_applications_RunningState_$UserManagerBroadcastReceiver__onReceive$___twin___(r8, r9);
            return;
        L13:
            GrantUtil r11 = GrantUtil.INSTANCE;
            Application r12 = SettingsApplication.getApplication();
            Intrinsics.checkNotNullExpressionValue(r12, "getApplication(...)");
            if (r11.isSetupCompelete(r12) == true) goto L16;
            OLog.i("PrivacyHookForReceiver", "onReceive !isSetupCompeleted hooked for " + r3 + ", " + r2);
            r7.com_android_settings_applications_RunningState_$UserManagerBroadcastReceiver__onReceive$___twin___(r8, r9);
            return;
        L16:
            String r13 = r3;
            if (r13 != null) goto L19;
        L22:
            boolean r14 = true;
        L23:
            if (r14 == false) goto L26;
            OLog.i("PrivacyHookForReceiver", "onReceive !simpleName hooked for " + r3 + ", " + r2);
            r7.com_android_settings_applications_RunningState_$UserManagerBroadcastReceiver__onReceive$___twin___(r8, r9);
            return;
        L26:
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == true) goto L30;
            if (r4 == true) goto L30;
            OLog.i("PrivacyHookForReceiver", "onReceive !isPrivacyAllowed hooked for " + r3 + ", " + r2);
            return;
        L30:
            GrantUtil.INSTANCE.applicationInit();
            r7.com_android_settings_applications_RunningState_$UserManagerBroadcastReceiver__onReceive$___twin___(r8, r9);
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

    static class UserState {
        Drawable mIcon;
        UserInfo mInfo;
        String mLabel;

        UserState() {
        }
    }

    static /* synthetic */ void access$000(RunningState_ r0) {
        r0.reset();
    }

    static /* synthetic */ boolean access$100(RunningState_ r0, Context r1, ActivityManager r2) {
        return r0.update(r1, r2);
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

    static RunningState_ getInstance(Context r2) {
        Object r0 = sGlobalLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L7;
        sInstance = new RunningState_(r2);     // Catch: Throwable -> L10
    L7:
        RunningState_ r3 = sInstance;     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    }

    private RunningState_(Context r5) {
        this.mInterestingConfigChanges = new com.android.settingslib.applications.InterestingConfigChanges();
        this.mServiceProcessesByName = new SparseArray();
        this.mServiceProcessesByPid = new SparseArray();
        this.mServiceProcessComparator = new ServiceProcessComparator(this);
        this.mInterestingProcesses = new ArrayList();
        this.mRunningProcesses = new SparseArray();
        this.mProcessItems = new ArrayList();
        this.mAllProcessItems = new ArrayList();
        this.mOtherUserMergedItems = new SparseArray();
        this.mOtherUserBackgroundItems = new SparseArray();
        this.mTmpAppProcesses = new SparseArray();
        this.mSequence = 0;
        this.mBackgroundComparator = new AnonymousClass1(this);
        this.mLock = new Object();
        this.mItems = new ArrayList();
        this.mMergedItems = new ArrayList();
        this.mBackgroundItems = new ArrayList();
        this.mUserBackgroundItems = new ArrayList();
        this.mHandler = new AnonymousClass2(this);
        UserManagerBroadcastReceiver r1 = new UserManagerBroadcastReceiver(this, null);
        this.mUmBroadcastReceiver = r1;
        Context r6 = r5.getApplicationContext();
        this.mApplicationContext = r6;
        this.mAm = (ActivityManager) r6.getSystemService("activity");
        this.mPm = r6.getPackageManager();
        UserManager r2 = (UserManager) r6.getSystemService(PickApplicationActivity.EXTRA_USER);
        this.mUm = r2;
        int r3 = UserHandle.myUserId();
        this.mMyUserId = r3;
        UserInfo r4 = r2.getUserInfo(r3);
        if (r4 != null) goto L5;
    L8:
        boolean r7 = true;
    L9:
        this.mHideManagedProfiles = r7;
        this.mResumed = false;
        HandlerThread r0 = new HandlerThread("RunningState_:Background");
        this.mBackgroundThread = r0;
        r0.start();
        this.mBackgroundHandler = new BackgroundHandler(this, r0.getLooper());
        r1.register(r6);
        return;
    L5:
        if (r4.canHaveProfile() == false) goto L8;
        r7 = false;
        goto L9
    }

    void resume(OnRefreshUiListener r5) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mResumed = true;     // Catch: Throwable -> L15
        this.mRefreshUiListener = r5;     // Catch: Throwable -> L15
        boolean r6 = this.mUmBroadcastReceiver.checkUsersChangedLocked();     // Catch: Throwable -> L15
        boolean r2 = this.mInterestingConfigChanges.applyNewConfig(this.mApplicationContext.getResources());     // Catch: Throwable -> L15
        if (r6 == true) goto L8;
        if (r2 == true) goto L8;
    L10:
        if (this.mBackgroundHandler.hasMessages(2) == true) goto L12;
        this.mBackgroundHandler.sendEmptyMessage(2);     // Catch: Throwable -> L15
    L12:
        this.mHandler.sendEmptyMessage(4);     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L8:
        this.mHaveData = false;     // Catch: Throwable -> L15
        this.mBackgroundHandler.removeMessages(1);     // Catch: Throwable -> L15
        this.mBackgroundHandler.removeMessages(2);     // Catch: Throwable -> L15
        this.mBackgroundHandler.sendEmptyMessage(1);     // Catch: Throwable -> L15
    L15:
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
    }

    private void addOtherUserItem(Context r4, ArrayList<MergedItem> r5, SparseArray<MergedItem> r6, MergedItem r7) {
        MergedItem r0 = r6.get(r7.mUserId);
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L22;
        UserInfo r2 = this.mUm.getUserInfo(r7.mUserId);
        if (r2 != null) goto L14;
        return;
    L14:
        if (this.mHideManagedProfiles == true) goto L16;
    L18:
        if (r0 != null) goto L20;
        r0 = new MergedItem(r7.mUserId);
        r6.put(r7.mUserId, r0);
    L21:
        r0.mCurSeq = this.mSequence;
        r0.mUser = new UserState();
        r0.mUser.mInfo = r2;
        UserState r8 = r0.mUser;
        r8.mIcon = Utils.getUserIcon(r4, this.mUm, r2);
        UserState r3 = r0.mUser;
        r3.mLabel = Utils.getUserLabel(r4, r2);
        r5.add(r0);
        goto L22
    L20:
        r0.mChildren.clear();
        goto L21
    L16:
        if (r2.isManagedProfile() == false) goto L18;
        return;
    L22:
        r0.mChildren.add(r7);
        return;
    L5:
        if (r0.mCurSeq != this.mSequence) goto L8;
        r1 = false;
        goto L9
    }

    private boolean update(Context r26, ActivityManager r27) {
        PackageManager r2 = r26.getPackageManager();
        boolean r4 = true;
        this.mSequence++;
        List<ActivityManager.RunningServiceInfo> r3 = r27.getRunningServices(100);
        if (r3 == null) goto L5;
        int r7 = r3.size();
    L6:
        int r8 = 0;
    L7:
        if (r8 >= r7) goto L18;
        ActivityManager.RunningServiceInfo r9 = r3.get(r8);
        if (r9.started == true) goto L14;
        if (r9.clientLabel != 0) goto L14;
        r3.remove(r8);
    L16:
        r8 = r8 - 1;
        r7 = r7 - 1;
    L17:
        r8 = r8 + 1;
    L14:
        if ((r9.flags & 8) == 0) goto L17;
        r3.remove(r8);
        goto L16
    L18:
        List<ActivityManager.RunningAppProcessInfo> r5 = r27.getRunningAppProcesses();
        if (r5 == null) goto L21;
        int r10 = r5.size();
    L22:
        this.mTmpAppProcesses.clear();
        int r11 = 0;
    L23:
        if (r11 >= r10) goto L25;
        ActivityManager.RunningAppProcessInfo r12 = r5.get(r11);
        this.mTmpAppProcesses.put(r12.pid, new AppProcessInfo(r12));
        r11 = r11 + 1;
        goto L23
    L25:
        int r13 = 0;
    L26:
        long r14 = 0;
        if (r13 >= r7) goto L38;
        ActivityManager.RunningServiceInfo r15 = r3.get(r13);
        if (r15.restarting != 0) goto L37;
        if (r15.pid <= 0) goto L37;
        AppProcessInfo r16 = this.mTmpAppProcesses.get(r15.pid);
        if (r16 == null) goto L37;
        r16.hasServices = true;
        if (r15.foreground == false) goto L37;
        r16.hasForegroundServices = true;
    L37:
        r13 = r13 + 1;
        goto L26
    L38:
        int r17 = 0;
        boolean r18 = false;
    L39:
        if (r17 >= r7) goto L88;
        ActivityManager.RunningServiceInfo r19 = r3.get(r17);
        if (r19.restarting == 0) goto L43;
    L62:
        HashMap<String, ProcessItem> r6 = this.mServiceProcessesByName.get(r19.uid);
        if (r6 != null) goto L65;
        r6 = new HashMap();
        this.mServiceProcessesByName.put(r19.uid, r6);
    L65:
        ProcessItem r110 = r6.get(r19.process);
        if (r110 != null) goto L69;
        r110 = new ProcessItem(r26, r19.uid, r19.process);
        r6.put(r19.process, r110);
        r18 = r4;
    L69:
        if (r110.mCurSeq != this.mSequence) goto L71;
    L86:
        r18 = r18 | r110.updateService(r26, r19);
    L87:
        r17 = r17 + 1;
        r5 = r5;
        r4 = true;
        goto L39
    L71:
        if (r19.restarting != 0) goto L73;
        int r20 = r19.pid;
    L75:
        if (r20 != r110.mPid) goto L77;
    L85:
        r110.mDependentProcesses.clear();
        r110.mCurSeq = this.mSequence;
        goto L86
    L77:
        if (r110.mPid != r20) goto L79;
    L84:
        r18 = true;
        goto L85
    L79:
        if (r110.mPid == 0) goto L81;
        this.mServiceProcessesByPid.remove(r110.mPid);
    L81:
        if (r20 == 0) goto L83;
        this.mServiceProcessesByPid.put(r20, r110);
    L83:
        r110.mPid = r20;
        goto L84
    L73:
        r20 = 0;
        goto L75
    L43:
        if (r19.pid <= 0) goto L62;
        AppProcessInfo r111 = this.mTmpAppProcesses.get(r19.pid);
        if (r111 == null) goto L62;
        if (r111.hasForegroundServices == true) goto L62;
        if (r111.info.importance >= 300) goto L62;
        AppProcessInfo r21 = this.mTmpAppProcesses.get(r111.info.importanceReasonPid);
    L51:
        if (r21 == null) goto L59;
        if (r21.hasServices == true) goto L58;
        if (isInterestingProcess(r21.info) == true) goto L58;
        r21 = this.mTmpAppProcesses.get(r21.info.importanceReasonPid);
    L58:
        boolean r22 = r4;
    L60:
        if (r22 == false) goto L62;
    L59:
        r22 = false;
        goto L60
    L88:
        List<ActivityManager.RunningAppProcessInfo> r28 = r5;
        int r23 = 0;
    L89:
        if (r23 >= r10) goto L104;
        List<ActivityManager.RunningAppProcessInfo> r24 = r28;
        ActivityManager.RunningAppProcessInfo r25 = r24.get(r23);
        ProcessItem r29 = this.mServiceProcessesByPid.get(r25.pid);
        if (r29 != null) goto L97;
        r29 = this.mRunningProcesses.get(r25.pid);
        if (r29 != null) goto L95;
        r29 = new ProcessItem(r26, r25.uid, r25.processName);
        r29.mPid = r25.pid;
        this.mRunningProcesses.put(r25.pid, r29);
        r18 = true;
    L95:
        r29.mDependentProcesses.clear();
    L97:
        if (isInterestingProcess(r25) == true) goto L99;
        r29.mInteresting = false;
    L103:
        r29.mRunningSeq = this.mSequence;
        r29.mRunningProcessInfo = r25;
        r23 = r23 + 1;
        r28 = r24;
        goto L89
    L99:
        if (this.mInterestingProcesses.contains(r29) == true) goto L101;
        this.mInterestingProcesses.add(r29);
        r18 = true;
    L101:
        r29.mCurSeq = this.mSequence;
        r29.mInteresting = true;
        r29.ensureLabel(r2);
        goto L103
    L104:
        int r30 = this.mRunningProcesses.size();
        int r31 = 0;
    L106:
        if (r31 >= r30) goto L119;
        ProcessItem r32 = this.mRunningProcesses.valueAt(r31);
        if (r32.mRunningSeq == this.mSequence) goto L109;
        SparseArray<ProcessItem> r33 = this.mRunningProcesses;
        r33.remove(r33.keyAt(r31));
        r30 = r30 - 1;
        r18 = true;
        goto L106
    L109:
        int r34 = r32.mRunningProcessInfo.importanceReasonPid;
        if (r34 == 0) goto L116;
        ProcessItem r35 = this.mServiceProcessesByPid.get(r34);
        if (r35 != null) goto L114;
        r35 = this.mRunningProcesses.get(r34);
    L114:
        if (r35 == null) goto L117;
        r35.mDependentProcesses.put(r32.mPid, r32);
    L117:
        r31 = r31 + 1;
        goto L106
    L116:
        r32.mClient = null;
        goto L117
    L119:
        int r36 = this.mInterestingProcesses.size();
        int r37 = 0;
    L120:
        if (r37 >= r36) goto L129;
        ProcessItem r38 = this.mInterestingProcesses.get(r37);
        if (r38.mInteresting == true) goto L124;
    L127:
        this.mInterestingProcesses.remove(r37);
        r37 = r37 - 1;
        r36 = r36 - 1;
        int r39 = 1;
        r18 = true;
    L128:
        r37 = r37 + r39;
        goto L120
    L124:
        if (this.mRunningProcesses.get(r38.mPid) == null) goto L127;
        r39 = 1;
        goto L128
    L129:
        int r40 = this.mServiceProcessesByPid.size();
        int r41 = 0;
    L130:
        if (r41 >= r40) goto L135;
        ProcessItem r42 = this.mServiceProcessesByPid.valueAt(r41);
        int r43 = r42.mCurSeq;
        int r44 = this.mSequence;
        if (r43 != r44) goto L134;
        r18 = r42.buildDependencyChain(r26, r2, r44) | r18;
    L134:
        r41 = r41 + 1;
        goto L130
    L135:
        ArrayList r45 = null;
        int r46 = 0;
    L137:
        if (r46 >= this.mServiceProcessesByName.size()) goto L162;
        HashMap<String, ProcessItem> r47 = this.mServiceProcessesByName.valueAt(r46);
        Iterator<ProcessItem> r48 = r47.values().iterator();
    L140:
        if (r48.hasNext() == false) goto L161;
        ProcessItem r49 = r48.next();
        if (r49.mCurSeq == this.mSequence) goto L143;
        r48.remove();
        if (r47.size() != 0) goto L158;
        if (r45 != null) goto L156;
        r45 = new ArrayList();
    L156:
        r45.add(Integer.valueOf(this.mServiceProcessesByName.keyAt(r46)));
    L158:
        if (r49.mPid == 0) goto L160;
        this.mServiceProcessesByPid.remove(r49.mPid);
    L160:
        r18 = true;
        goto L140
    L143:
        r49.ensureLabel(r2);
        if (r49.mPid != 0) goto L146;
        r49.mDependentProcesses.clear();
    L146:
        Iterator<ServiceItem> r50 = r49.mServices.values().iterator();
    L148:
        if (r50.hasNext() == false) goto L140;
        if (r50.next().mCurSeq == this.mSequence) goto L148;
        r50.remove();
        r18 = true;
        goto L148
    L161:
        r46 = r46 + 1;
        goto L137
    L162:
        if (r45 == null) goto L167;
        int r51 = 0;
    L165:
        if (r51 >= r45.size()) goto L167;
        this.mServiceProcessesByName.remove(((Integer) r45.get(r51)).intValue());
        r51 = r51 + 1;
    L167:
        if (r18 == false) goto L250;
        ArrayList r52 = new ArrayList();
        int r53 = 0;
    L170:
        if (r53 >= this.mServiceProcessesByName.size()) goto L192;
        Iterator<ProcessItem> r54 = this.mServiceProcessesByName.valueAt(r53).values().iterator();
    L173:
        if (r54.hasNext() == false) goto L191;
        ProcessItem r55 = r54.next();
        r55.mIsSystem = false;
        r55.mIsStarted = true;
        r55.mActiveSince = Long.MAX_VALUE;
        Iterator<ServiceItem> r56 = r55.mServices.values().iterator();
    L176:
        if (r56.hasNext() == false) goto L190;
        ServiceItem r57 = r56.next();
        if (r57.mServiceInfo == null) goto L183;
        if ((r57.mServiceInfo.applicationInfo.flags & 1) == 0) goto L183;
        r55.mIsSystem = true;
    L183:
        if (r57.mRunningService == null) goto L176;
        if (r57.mRunningService.clientLabel == 0) goto L176;
        r55.mIsStarted = false;
        if (r55.mActiveSince <= r57.mRunningService.activeSince) goto L176;
        r55.mActiveSince = r57.mRunningService.activeSince;
        goto L176
    L190:
        r52.add(r55);
        goto L173
    L191:
        r53 = r53 + 1;
        goto L170
    L192:
        Collections.sort(r52, this.mServiceProcessComparator);
        ArrayList<BaseItem> r58 = new ArrayList();
        ArrayList<MergedItem> r59 = new ArrayList();
        this.mProcessItems.clear();
        int r60 = 0;
    L194:
        if (r60 >= r52.size()) goto L220;
        ProcessItem r61 = (ProcessItem) r52.get(r60);
        r61.mNeedDivider = false;
        int r62 = this.mProcessItems.size();
        r61.addDependentProcesses(r58, this.mProcessItems);
        r58.add(r61);
        if (r61.mPid <= 0) goto L198;
        this.mProcessItems.add(r61);
    L198:
        Iterator<ServiceItem> r63 = r61.mServices.values().iterator();
        boolean r64 = false;
        MergedItem r112 = null;
    L200:
        if (r63.hasNext() == false) goto L207;
        ServiceItem r113 = r63.next();
        r113.mNeedDivider = r64;
        r58.add(r113);
        if (r113.mMergedItem == null) goto L206;
        if (r112 == null) goto L205;
        MergedItem r65 = r113.mMergedItem;
    L205:
        r112 = r113.mMergedItem;
    L206:
        r64 = true;
        goto L200
    L207:
        MergedItem r66 = new MergedItem(r61.mUserId);
        Iterator<ServiceItem> r67 = r61.mServices.values().iterator();
    L209:
        if (r67.hasNext() == false) goto L211;
        ServiceItem r114 = r67.next();
        r66.mServices.add(r114);
        r114.mMergedItem = r66;
        goto L209
    L211:
        r66.mProcess = r61;
        r66.mOtherProcesses.clear();
    L213:
        if (r62 >= (this.mProcessItems.size() - 1)) goto L215;
        r66.mOtherProcesses.add(this.mProcessItems.get(r62));
        r62 = r62 + 1;
        goto L213
    L215:
        r66.update(r26, false);
        if (r66.mUserId == this.mMyUserId) goto L218;
        addOtherUserItem(r26, r59, this.mOtherUserMergedItems, r66);
    L219:
        r60 = r60 + 1;
        goto L194
    L218:
        r59.add(r66);
        goto L219
    L220:
        int r68 = this.mInterestingProcesses.size();
        int r69 = 0;
    L221:
        if (r69 >= r68) goto L235;
        ProcessItem r70 = this.mInterestingProcesses.get(r69);
        if (r70.mClient != null) goto L234;
        if (r70.mServices.size() > 0) goto L234;
        if (r70.mMergedItem != null) goto L229;
        r70.mMergedItem = new MergedItem(r70.mUserId);
        r70.mMergedItem.mProcess = r70;
    L229:
        r70.mMergedItem.update(r26, false);
        if (r70.mMergedItem.mUserId == this.mMyUserId) goto L232;
        addOtherUserItem(r26, r59, this.mOtherUserMergedItems, r70.mMergedItem);
    L233:
        this.mProcessItems.add(r70);
        goto L234
    L232:
        r59.add(0, r70.mMergedItem);
    L234:
        r69 = r69 + 1;
        goto L221
    L235:
        int r71 = this.mOtherUserMergedItems.size();
        int r72 = 0;
    L236:
        if (r72 >= r71) goto L242;
        MergedItem r73 = this.mOtherUserMergedItems.valueAt(r72);
        if (r73.mCurSeq != this.mSequence) goto L241;
        r73.update(r26, false);
    L241:
        r72 = r72 + 1;
        goto L236
    L242:
        int r74 = 0;
        Object r75 = this.mLock;
        monitor-enter(r75);
        this.mItems = r58;     // Catch: Throwable -> L247
        this.mMergedItems = r59;     // Catch: Throwable -> L247
        monitor-exit(r75);     // Catch: Throwable -> L247
    L251:
        this.mAllProcessItems.clear();
        this.mAllProcessItems.addAll(this.mProcessItems);
        int r76 = this.mRunningProcesses.size();
        int r77 = r74;
        int r78 = r77;
        int r79 = r78;
        int r80 = r79;
    L252:
        char r81 = 200;
        if (r80 >= r76) goto L389;
        ProcessItem r115 = this.mRunningProcesses.valueAt(r80);
        if (r115.mCurSeq != this.mSequence) goto L257;
        r77 = r77 + 1;
    L264:
        r80 = r80 + 1;
        goto L252
    L257:
        if (r115.mRunningProcessInfo.importance < 400) goto L260;
        r78 = r78 + 1;
        this.mAllProcessItems.add(r115);
        goto L264
    L260:
        if (r115.mRunningProcessInfo.importance > 200) goto L262;
        r79 = r79 + 1;
        this.mAllProcessItems.add(r115);
        goto L264
    L262:
        OLog.i(TAG, "Unknown non-service process: " + r115.mProcessName + " #" + r115.mPid);
        goto L264
    L389:
        int r82 = this.mAllProcessItems.size();     // Catch: RemoteException -> L331
        int[] r83 = new int[r82];     // Catch: RemoteException -> L331
        int r84 = r74;
    L267:
        if (r84 >= r82) goto L271;
        r83[r84] = this.mAllProcessItems.get(r84).mPid;     // Catch: RemoteException -> L270
        r84 = r84 + 1;
    L270:
        int r85 = r74;
        long r116 = 0;
        long r117 = 0;
        ArrayList<MergedItem> r86 = null;
    L332:
        long r118 = r14;
        boolean r119 = r18;
        long r87 = r116;
        int r120 = r85;
    L333:
        long r88 = r117;
        if (r86 == null) goto L336;
    L345:
        long r121 = r88;
    L346:
        if (r86 == null) goto L362;
        if (r120 != 0) goto L349;
        ArrayList<MergedItem> r89 = r86;
    L363:
        int r122 = 0;
    L365:
        if (r122 >= this.mMergedItems.size()) goto L367;
        this.mMergedItems.get(r122).updateSize(r26);
        r122 = r122 + 1;
        goto L365
    L367:
        Object r1 = this.mLock;
        monitor-enter(r1);
        this.mNumBackgroundProcesses = r78;     // Catch: Throwable -> L379
        this.mNumForegroundProcesses = r79;     // Catch: Throwable -> L379
        this.mNumServiceProcesses = r77;     // Catch: Throwable -> L379
        this.mBackgroundProcessMemory = r118;     // Catch: Throwable -> L379
        this.mForegroundProcessMemory = r87;     // Catch: Throwable -> L379
        this.mServiceProcessMemory = r121;     // Catch: Throwable -> L379
        if (r86 == null) goto L375;
        this.mBackgroundItems = r86;     // Catch: Throwable -> L379
        this.mUserBackgroundItems = r89;     // Catch: Throwable -> L379
        if (this.mWatchingBackgroundItems == false) goto L375;
        r119 = true;
    L375:
        if (this.mHaveData == true) goto L377;
        this.mHaveData = true;     // Catch: Throwable -> L379
        this.mLock.notifyAll();     // Catch: Throwable -> L379
    L377:
        monitor-exit(r1);     // Catch: Throwable -> L379
        return r119;
    L379:
        th = move-exception;
        throw th;
    L349:
        r89 = new ArrayList();
        int r90 = r86.size();
        int r123 = 0;
    L350:
        if (r123 >= r90) goto L356;
        MergedItem r124 = r86.get(r123);
        if (r124.mUserId == this.mMyUserId) goto L354;
        addOtherUserItem(r26, r89, this.mOtherUserBackgroundItems, r124);
    L355:
        r123 = r123 + 1;
        goto L350
    L354:
        r89.add(r124);
        goto L355
    L356:
        int r125 = this.mOtherUserBackgroundItems.size();
        int r126 = 0;
    L357:
        if (r126 >= r125) goto L363;
        MergedItem r127 = this.mOtherUserBackgroundItems.valueAt(r126);
        if (r127.mCurSeq != this.mSequence) goto L361;
        r127.update(r26, true);
        r127.updateSize(r26);
    L361:
        r126 = r126 + 1;
        goto L357
    L362:
        r89 = null;
        goto L363
    L336:
        if (this.mBackgroundItems.size() <= r78) goto L345;
        r86 = new ArrayList(r78);
        int r128 = r120;
        int r129 = 0;
    L338:
        if (r129 >= r78) goto L344;
        MergedItem r130 = this.mBackgroundItems.get(r129);
        long r131 = r88;
        if (r130.mUserId == this.mMyUserId) goto L342;
        int r91 = 1;
    L343:
        r128 = r128 | r91;
        r86.add(r130);
        r129 = r129 + 1;
        r88 = r131;
        goto L338
    L342:
        r91 = 0;
        goto L343
    L344:
        r121 = r88;
        r120 = r128;
        goto L346
    L271:
        long[] r92 = ActivityManagerNative.getDefault().getProcessPss(r83);     // Catch: RemoteException -> L331
        r118 = 0;
        r116 = 0;
        r117 = 0;
        r119 = r18;
        ArrayList<MergedItem> r93 = null;
        int r132 = r74;
        r120 = r132;
        int r133 = r120;
    L273:
        if (r132 >= r82) goto L330;
        ProcessItem r94 = this.mAllProcessItems.get(r132);     // Catch: RemoteException -> L328
        long r210 = r118;
        r119 = r119 | r94.updateSize(r26, r92[r132], this.mSequence);     // Catch: RemoteException -> L327
        if (r94.mCurSeq != this.mSequence) goto L280;
        r117 = r117 + r94.mSize;     // Catch: RemoteException -> L327
        int r211 = r82;
        r86 = r93;
        long[] r212 = r92;
        r118 = r210;
        char r95 = r81;
    L326:
        r132 = r132 + 1;
        r93 = r86;
        r81 = r95;
        r82 = r211;
        r92 = r212;
        goto L273
    L280:
        if (r94.mRunningProcessInfo.importance >= 400) goto L282;
        r211 = r82;
        r86 = r93;
        r212 = r92;
        r95 = 200;
        if (r94.mRunningProcessInfo.importance > 200) goto L325;
        r116 = r116 + r94.mSize;
    L325:
        r118 = r210;
    L329:
        r85 = r120;
        r18 = r119;
        r14 = r210;
        goto L332
    L282:
        long r134 = r210 + r94.mSize;
        if (r93 == null) goto L293;
        MergedItem r135 = new MergedItem(r94.mUserId);     // Catch: RemoteException -> L317
        r94.mMergedItem = r135;     // Catch: RemoteException -> L317
        r94.mMergedItem.mProcess = r94;     // Catch: RemoteException -> L317
        if (r135.mUserId == this.mMyUserId) goto L287;
        int r96 = 1;
    L288:
        int r97 = r96 | r120;
        r93.add(r135);     // Catch: RemoteException -> L291
        r211 = r82;
        ArrayList<MergedItem> r98 = r93;
        r212 = r92;
        boolean r99 = true;
        r85 = r97;
    L399:
        r135.update(r26, r99);     // Catch: RemoteException -> L315
        r135.updateSize(r26);     // Catch: RemoteException -> L315
        r133 = r133 + 1;
        r86 = r98;
        r120 = r85;
        r118 = r134;
        r95 = 200;
    L315:
        r86 = r98;
    L319:
        r14 = r134;
        r18 = r119;
    L291:
        r86 = r93;
        r85 = r97;
        goto L319
    L287:
        r96 = 0;
    L317:
        r86 = r93;
    L318:
        r85 = r120;
        goto L319
    L293:
        if (r133 < this.mBackgroundItems.size()) goto L295;
    L299:
        r98 = new ArrayList(r78);     // Catch: RemoteException -> L317
        int r100 = 0;
    L301:
        if (r100 >= r133) goto L307;
        MergedItem r136 = this.mBackgroundItems.get(r100);     // Catch: RemoteException -> L316
        int r213 = r82;
        long[] r214 = r92;
        if (r136.mUserId == this.mMyUserId) goto L305;
        int r101 = 1;
    L306:
        r120 = r120 | r101;     // Catch: RemoteException -> L316
        r98.add(r136);     // Catch: RemoteException -> L316
        r100 = r100 + 1;     // Catch: RemoteException -> L316
        r82 = r213;
        r92 = r214;
        goto L301
    L305:
        r101 = 0;
    L316:
        r86 = r98;
        goto L318
    L307:
        r211 = r82;
        r212 = r92;
        r135 = new MergedItem(r94.mUserId);     // Catch: RemoteException -> L316
        r94.mMergedItem = r135;     // Catch: RemoteException -> L316
        r94.mMergedItem.mProcess = r94;     // Catch: RemoteException -> L316
        if (r135.mUserId == this.mMyUserId) goto L310;
        int r102 = 1;
    L311:
        r85 = r120 | r102;
        r98.add(r135);     // Catch: RemoteException -> L315
    L298:
        r99 = true;
        goto L399
    L310:
        r102 = 0;
        goto L311
    L295:
        if (this.mBackgroundItems.get(r133).mProcess != r94) goto L299;
        r135 = this.mBackgroundItems.get(r133);     // Catch: RemoteException -> L317
        r211 = r82;
        r98 = r93;
        r212 = r92;
        r85 = r120;
    L327:
        r86 = r93;
    L328:
        r86 = r93;
        r210 = r118;
        goto L329
    L330:
        r86 = r93;
        r87 = r116;
    L331:
        r116 = 0;
        r117 = 0;
        r86 = null;
        r85 = 0;
    L247:
        th = move-exception;
        throw th;
    L250:
        r74 = 0;
        goto L251
    L21:
        r10 = 0;
        goto L22
    L5:
        r7 = 0;
        goto L6
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
