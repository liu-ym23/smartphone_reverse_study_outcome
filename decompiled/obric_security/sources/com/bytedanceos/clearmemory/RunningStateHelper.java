package com.bytedanceos.clearmemory;

import android.app.ActivityManager;
import android.app.ActivityManagerNative;
import android.app.IActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.RemoteException;
import android.os.UserHandle;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.inputmethod.InputMethodInfo;
import android.widget.Toast;
import bytedanceos.util.Features;
import com.android.calendar.privacy.GrantUtil;
import com.bytedanceos.application.AppListLoader;
import com.bytedanceos.cloud.SecurityPackageWhiteListDataCache;
import com.bytedanceos.powerusage.BatteryEntry;
import com.bytedanceos.recorder.service.IRecorderCreatorService;
import com.bytedanceos.security.Utils;
import com.bytedanceos.securitycenter.SecurityCenterApplication;
import com.obric.olog.OLog;
import com.obric.security.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class RunningStateHelper {
    private static final String APPLICATIONS_PROVIDER_PACKAGE = "com.android.providers.applications";
    private static final String CALENDAR_PACAKGE = "com.android.calendar";
    private static final String CLOCK_PACAKGE = "com.bytedanceos.clock";
    private static final String CLOUDGALLER_PACAKGE = "com.bytedanceos.cloudgallery";
    private static final String CLOUDSYNC_PACAKGE = "com.bytedanceos.cloudsync";
    private static final String EMAIL_PACAKGE = "com.android.email";
    private static final String FILEMANAGER_PACKAGE = "com.obric.filemanager";
    private static final String GOOGLE_ANDROID_GMS = "com.google.android.gms";
    private static final String GOOGLE_ANDROID_GSF_LOGIN = "com.google.android.gsf.login";
    public static final String RECORDER_PACKAGE = "com.obric.recorder";
    private static final String RECORDING_SERVICE_ACTION = "action_get_recorder_creator_service";
    private static final int RECORD_STATE_IDLE = 0;
    private static final int RECORD_STATE_PAUSE = 2;
    private static final int RECORD_STATE_PAUSE_BY_CALL = 3;
    private static final int RECORD_STATE_RUNNING = 1;
    private static final int RECORD_STATE_STOP = 4;
    private static final String SCREENRECORDER_PACKAGE = "com.bytedanceos.screenrecorder";
    private static final String SCREEN_RECORDER_SHOW_STATUS = "screen_recorder_show_status";
    private static final String SCREEN_RECORDER_STATUS = "screen_recorder_status";
    private static final String SEARCH_PACKAGE = "com.obric.quicksearch";
    private static final String WEATHER_PACKAGE = "com.bytedanceos.weather";
    private static RunningStateHelper sInstance;
    private ActivityManager mAm;
    private Set<String> mCarefulClearPackageSet;
    private SecurityPackageWhiteListDataCache mCloudWhitePackageCache;
    private Context mContext;
    private ResolveInfo mDefaultHome;
    private boolean mHasBound;
    private IActivityManager mIActivityManager;
    private ServiceConnection mRecorderConnection;
    private IRecorderCreatorService mRecordingService;
    private Set<String> mWhitePackageSet;

    static /* synthetic */ IRecorderCreatorService access$002(RunningStateHelper r0, IRecorderCreatorService r1) {
        r0.mRecordingService = r1;
        return r1;
    }

    private RunningStateHelper() {
        this.mRecordingService = null;
        this.mHasBound = false;
        this.mRecorderConnection = new AnonymousClass1(this);
        SecurityCenterApplication r0 = SecurityCenterApplication.getApplication();
        this.mContext = r0;
        String[] r1 = r0.getResources().getStringArray(R.array.clear_packages_white_list);
        HashSet r2 = new HashSet(r1.length);
        this.mWhitePackageSet = r2;
        r2.addAll(Arrays.asList(r1));
        if (Features.isFeatureCMCCEnabled(this.mContext).booleanValue() == false) goto L5;
        this.mWhitePackageSet.add(AppListLoader.CMCC10086);
    L5:
        String[] r3 = this.mContext.getResources().getStringArray(R.array.careful_clear_packages);
        HashSet r4 = new HashSet(r3.length);
        this.mCarefulClearPackageSet = r4;
        r4.addAll(Arrays.asList(r3));
        this.mDefaultHome = getDefaultHome(this.mContext);
        this.mAm = (ActivityManager) this.mContext.getSystemService("activity");
        this.mIActivityManager = ActivityManagerNative.getDefault();
        this.mCloudWhitePackageCache = SecurityPackageWhiteListDataCache.getInstance();
    }

    public void stopPackage(PackageInfo packageInfo) {
        if (packageInfo == null) goto L13;
        IActivityManager r1 = this.mIActivityManager;
        if (r1 == null) goto L14;
        r1.forceStopPackage(packageInfo.packageName, UserHandle.getUserId(packageInfo.applicationInfo.uid));     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        OLog.d("RunningStateHelper", "stopPackage for permission exception =" + e);
        return;
    L14:
        return;
    }

    public void restartPackage(PackageInfo packageInfo) {
        if (packageInfo == null) goto L13;
        IActivityManager r1 = this.mIActivityManager;
        if (r1 == null) goto L14;
        r1.startUserInBackground(UserHandle.getUserId(packageInfo.applicationInfo.uid));     // Catch: RemoteException -> L8
        return;
    L8:
        e = move-exception;
        OLog.d("RunningStateHelper", "restartPackage for permission exception =" + e);
        return;
    L14:
        return;
    }

    static {
        sInstance = new RunningStateHelper();
    }

    public static RunningStateHelper getInstance() {
        return sInstance;
    }

    public List<RunningState.MergedItem> mergedPackages(List<RunningState.MergedItem> mergedItems) {
        PackageManager r0 = this.mContext.getPackageManager();
        if (r0 != null) goto L6;
        return null;
    L6:
        SparseArray r1 = new SparseArray();
        Iterator<RunningState.MergedItem> r2 = mergedItems.iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        RunningState.MergedItem r3 = r2.next();
        r3.mMergeSize = r3.mSize;
        goto L8
    L10:
        Iterator<RunningState.MergedItem> r9 = mergedItems.iterator();
    L12:
        if (r9.hasNext() == false) goto L37;
        RunningState.MergedItem r4 = r9.next();
        if (r4.mPackageInfo == null) goto L16;
    L18:
        Map r5 = (Map) r1.get(r4.mUserId);
        if (r5 != null) goto L22;
        r5 = new HashMap();
        r1.put(r4.mUserId, r5);
    L22:
        if (r4.mPackageInfo == null) goto L12;
        RunningState.MergedItem r6 = (RunningState.MergedItem) r5.get(r4.mPackageInfo.packageName);
        if (r6 == null) goto L26;
        r6.mMergeSize += r4.mMergeSize;
        goto L12
    L26:
        if (skipPackage(r4.mPackageInfo) == true) goto L12;
        if (r4.mPackageInfo.packageName.equals("com.obric.recorder") == true) goto L31;
    L35:
        r5.put(r4.mPackageInfo.packageName, r4);
        r4.mIsRecommendClear = !this.mCarefulClearPackageSet.contains(r4.mPackageInfo.packageName);
        goto L12
    L31:
        if (this.mRecordingService != null) goto L35;
        if (this.mHasBound == true) goto L35;
        Intent r7 = new Intent(RECORDING_SERVICE_ACTION);
        r7.setPackage("com.obric.recorder");
        this.mHasBound = true;
        this.mContext.bindService(r7, this.mRecorderConnection, 1);
        goto L35
    L16:
        if (r4.mProcess == null) goto L18;
        r4.mProcess.ensureLabel(r0);
        r4.mPackageInfo = r4.mProcess.mPackageInfo;
        r4.mDisplayLabel = r4.mProcess.mDisplayLabel;
        goto L18
    L37:
        Map r8 = (Map) r1.get(this.mContext.getUserId());
        if (r8 == null) goto L44;
        RunningState.MergedItem r10 = (RunningState.MergedItem) r8.get("com.bytedanceos.cloudsync");
        if (r10 == null) goto L44;
        RunningState.MergedItem r11 = (RunningState.MergedItem) r8.remove(CLOUDGALLER_PACAKGE);
        if (r11 == null) goto L44;
        r10.mMergeSize += r11.mMergeSize;
    L44:
        ArrayList r12 = new ArrayList();
        int r13 = 0;
    L46:
        if (r13 >= r1.size()) goto L48;
        r12.addAll(((Map) r1.valueAt(r13)).values());
        r13 = r13 + 1;
        goto L46
    L48:
        return r12;
    }

    public boolean skipPackage(ApplicationInfo packageInfo) {
        if (packageInfo != null) goto L5;
    L59:
        return true;
    L5:
        if (packageInfo.packageName == null) goto L59;
        String r1 = packageInfo.packageName;
        if (packageInfo.flags != 8) goto L11;
        return true;
    L11:
        if (packageInfo.packageName.equals(GrantUtil.securitymanager) == false) goto L14;
        return true;
    L14:
        if (packageInfo.uid >= 10000) goto L23;
        if (r1.equals(BatteryEntry.CAMERA_PACKAGE) == true) goto L23;
        if (r1.equals("com.bytedanceos.sara") == true) goto L23;
        if (r1.equals(SEARCH_PACKAGE) == true) goto L23;
        return true;
    L23:
        if (Utils.isDesktop(this.mContext) == true) goto L25;
    L27:
        List<String> r2 = this.mCloudWhitePackageCache.getMemoryPackages();
        if (this.mWhitePackageSet.contains(r1) == true) goto L59;
        if (r1.startsWith("com.qualcomm") == true) goto L59;
        if (isHiddenApp(packageInfo) == true) goto L59;
        if (r2 != null) goto L35;
    L37:
        ResolveInfo r3 = this.mDefaultHome;
        if (r3 == null) goto L43;
        if (r3.activityInfo.packageName.equals(r1) == false) goto L43;
        return true;
    L43:
        if (Features.isFeatureCMCCEnabled(this.mContext).booleanValue() == true) goto L45;
    L47:
        InputMethodInfo r4 = InputMethodSettingValuesWrapper.getInstance(this.mContext).getCurrentInputMethodInfo();
        if (r4 == null) goto L53;
        if (TextUtils.equals(r4.getPackageName(), r1) == false) goto L53;
        return true;
    L53:
        if (packageInfo.packageName.equals(SCREENRECORDER_PACKAGE) == true) goto L55;
        return false;
    L55:
        if (isRecordScreen(this.mContext) == false) goto L60;
        return true;
    L60:
        return false;
    L45:
        if (r1.equals("com.obric.appstore") == false) goto L47;
        return true;
    L35:
        if (r2.contains(r1) == false) goto L37;
    L25:
        if ("com.obric.filemanager".equals(r1) == false) goto L27;
        return true;
    }

    public boolean isHiddenApp(ApplicationInfo appInfo) {
        String r0 = appInfo.packageName;
        if ((appInfo.flags & 129) == 0) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == true) goto L12;
        if (r0.startsWith("com.bytedanceos.") == true) goto L12;
        return false;
    L12:
        return !RunningState.getInstance(this.mContext).getLuanchApps().contains(r0);
    L5:
        r4 = false;
        goto L6
    }

    private static ResolveInfo getDefaultHome(Context context) {
        Intent r0 = new Intent("android.intent.action.MAIN");
        r0.addCategory("android.intent.category.HOME");
        r0.addCategory("android.intent.category.DEFAULT");
        PackageManager r2 = context.getPackageManager();
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.resolveActivity(r0, 65536);
    }

    public boolean stopPackage(RunningState.MergedItem mi, boolean notify) {
        if (mi != null) goto L5;
    L59:
        return false;
    L5:
        if (mi.mPackageInfo == null) goto L59;
        if (mi.mPackageInfo.packageName == null) goto L59;
        if (this.mIActivityManager == null) goto L59;
        if (this.mAm == null) goto L59;
        if (mi.mIsTaskPersist == false) goto L17;
        return false;
    L17:
        String r1 = mi.mPackageInfo.packageName;
        if ("com.obric.recorder".equals(r1) == false) goto L34;
        IRecorderCreatorService r3 = this.mRecordingService;
        if (r3 == null) goto L34;
    L31:
        e = move-exception;
        e.printStackTrace();
        goto L34
    L22:
        if (r3.getRecordingState() != 0) goto L24;
        this.mRecordingService = null;     // Catch: Exception -> L31
        this.mHasBound = false;     // Catch: Exception -> L31
        this.mContext.unbindService(this.mRecorderConnection);     // Catch: Exception -> L60
        goto L34
    L24:
        if ("com.obric.recorder".equals(mi.mPackageInfo.packageName) == false) goto L27;
        if (notify == false) goto L27;
        Context r2 = this.mContext;     // Catch: Exception -> L31
        Toast.makeText(r2, r2.getString(R.string.cannot_clean_recorder), 0).show();     // Catch: Exception -> L31
    L27:
        return false;
    L34:
        if (SCREENRECORDER_PACKAGE.equals(r1) == true) goto L36;
    L63:
        this.mIActivityManager.forceStopPackage(r1, mi.mUserId);     // Catch: Exception -> L61
        if (GOOGLE_ANDROID_GSF_LOGIN.equals(r1) == false) goto L52;
        this.mIActivityManager.forceStopPackage(GOOGLE_ANDROID_GMS, mi.mUserId);     // Catch: Exception -> L61
    L52:
        if (r1.equals("com.bytedanceos.cloudsync") == false) goto L55;
        this.mIActivityManager.forceStopPackage(CLOUDGALLER_PACAKGE, mi.mUserId);     // Catch: Exception -> L61
        return true;
    L55:
        if (r1.equals(SEARCH_PACKAGE) == false) goto L67;
        this.mIActivityManager.forceStopPackage(APPLICATIONS_PROVIDER_PACKAGE, mi.mUserId);     // Catch: Exception -> L61
        return true;
    L67:
        return true;
    L68:
        return true;
    L36:
        if (isRecordScreen(this.mContext) == false) goto L40;
        if (notify == false) goto L39;
        Context r4 = this.mContext;
        Toast.makeText(r4, r4.getString(R.string.cannot_clean_screen_recorder), 0).show();
    L39:
        return false;
    L40:
        this.mAm.killBackgroundProcesses(r1);
        if (mi.mServices == null) goto L63;
        if (mi.mServices.size() <= 0) goto L63;
        Iterator<RunningState.ServiceItem> r6 = mi.mServices.iterator();
    L46:
        if (r6.hasNext() == false) goto L63;
        RunningState.ServiceItem r0 = r6.next();
        this.mContext.stopService(new Intent().setComponent(r0.mRunningService.service));
        goto L46
    }

    private boolean isRecordScreen(Context context) {
        if (Settings.Global.getInt(context.getContentResolver(), SCREEN_RECORDER_STATUS, 0) == 1) goto L7;
        if (Settings.Global.getInt(context.getContentResolver(), SCREEN_RECORDER_SHOW_STATUS, 0) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public void doDestroy() {
        if (this.mRecordingService != null) goto L5;
        return;
    L5:
        if (this.mHasBound == false) goto L9;
        this.mRecordingService = null;
        this.mHasBound = false;
        this.mContext.unbindService(this.mRecorderConnection);
        return;
    }
}
