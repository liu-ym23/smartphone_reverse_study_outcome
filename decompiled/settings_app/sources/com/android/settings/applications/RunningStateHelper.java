package com.android.settings.applications;

import android.app.ActivityManager;
import android.app.ActivityManagerNative;
import android.app.IActivityManager;
import android.app.SmtPCUtils;
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
import bytedanceos.util.Features;
import com.android.settings.R;
import com.android.settings.SettingsApplication;
import com.android.settings.SettingsFeature;
import com.android.settings.ToastUtils;
import com.android.settings.Utils;
import com.android.settings.inputmethod.InputMethodSettingValuesWrapper;
import com.android.settings.utils.NullSafe;
import com.obric.olog.OLog;
import com.obric.recorder.service.IRecorderCreatorService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
    private static final String GOOGLE_ANDROID_GMS = "com.google.android.gms";
    private static final String GOOGLE_ANDROID_GSF_LOGIN = "com.google.android.gsf.login";
    private static final String NEW_NUMBER_ASSISTANT = "com.obric.numberassistant";
    private static final String OLD_NUMBER_ASSISTANT = "com.bytedanceos.phone_number_assistant";
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
        Context r0 = SettingsApplication.getContext();
        this.mContext = r0;
        String[] r1 = r0.getResources().getStringArray(R.array.clear_packages_white_list);
        this.mWhitePackageSet = new HashSet(r1.length);
        List r2 = Arrays.asList(r1);
        if (SettingsFeature.isSupportNewNumberAssistant() == false) goto L5;
        Collections.replaceAll(r2, "com.bytedanceos.phone_number_assistant", NEW_NUMBER_ASSISTANT);
    L5:
        this.mWhitePackageSet.addAll(r2);
        if (Features.isFeatureCMCCEnabled(this.mContext).booleanValue() == false) goto L8;
        this.mWhitePackageSet.add("com.greenpoint.android.mc10086.activity");
    L8:
        String[] r3 = this.mContext.getResources().getStringArray(R.array.careful_clear_packages);
        HashSet r4 = new HashSet(r3.length);
        this.mCarefulClearPackageSet = r4;
        r4.addAll(Arrays.asList(r3));
        this.mDefaultHome = getDefaultHome(this.mContext);
        this.mAm = (ActivityManager) this.mContext.getSystemService("activity");
        this.mIActivityManager = ActivityManagerNative.getDefault();
    }

    static {
        sInstance = new RunningStateHelper();
    }

    public static RunningStateHelper getInstance() {
        return sInstance;
    }

    public List<RunningState.MergedItem> mergedPackages(List<RunningState.MergedItem> r9) {
        PackageManager r0 = this.mContext.getPackageManager();
        SparseArray r1 = new SparseArray();
        Iterator<RunningState.MergedItem> r2 = r9.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        RunningState.MergedItem r3 = r2.next();
        r3.mMergeSize = r3.mSize;
        goto L4
    L6:
        Iterator<RunningState.MergedItem> r10 = r9.iterator();
    L8:
        if (r10.hasNext() == false) goto L33;
        RunningState.MergedItem r4 = r10.next();
        if (r4.mPackageInfo == null) goto L12;
    L14:
        Map r5 = (Map) r1.get(r4.mUserId);
        if (r5 != null) goto L18;
        r5 = new HashMap();
        r1.put(r4.mUserId, r5);
    L18:
        if (r4.mPackageInfo == null) goto L8;
        RunningState.MergedItem r6 = (RunningState.MergedItem) r5.get(r4.mPackageInfo.packageName);
        if (r6 == null) goto L22;
        r6.mMergeSize += r4.mMergeSize;
        goto L8
    L22:
        if (skipPackage(r4.mPackageInfo) == true) goto L8;
        if (r4.mPackageInfo.packageName.equals("com.obric.recorder") == true) goto L27;
    L31:
        r5.put(r4.mPackageInfo.packageName, r4);
        r4.mIsRecommendClear = !this.mCarefulClearPackageSet.contains(r4.mPackageInfo.packageName);
        goto L8
    L27:
        if (this.mRecordingService != null) goto L31;
        if (this.mHasBound == true) goto L31;
        Intent r7 = new Intent(RECORDING_SERVICE_ACTION);
        r7.setPackage("com.obric.recorder");
        this.mHasBound = true;
        this.mContext.bindService(r7, this.mRecorderConnection, 1);
        goto L31
    L12:
        if (r4.mProcess == null) goto L14;
        r4.mProcess.ensureLabel(r0);
        r4.mPackageInfo = r4.mProcess.mPackageInfo;
        r4.mDisplayLabel = r4.mProcess.mDisplayLabel;
        goto L14
    L33:
        Map r8 = (Map) r1.get(this.mContext.getUserId());
        if (r8 == null) goto L40;
        RunningState.MergedItem r11 = (RunningState.MergedItem) r8.get(CLOUDSYNC_PACAKGE);
        if (r11 == null) goto L40;
        RunningState.MergedItem r12 = (RunningState.MergedItem) r8.remove(CLOUDGALLER_PACAKGE);
        if (r12 == null) goto L40;
        r11.mMergeSize += r12.mMergeSize;
    L40:
        ArrayList r13 = new ArrayList();
        int r14 = 0;
    L42:
        if (r14 >= r1.size()) goto L44;
        r13.addAll(((Map) r1.valueAt(r14)).values());
        r14 = r14 + 1;
        goto L42
    L44:
        return r13;
    }

    public boolean skipPackage(ApplicationInfo r5) {
        if (r5 != null) goto L5;
    L46:
        return true;
    L5:
        if (r5.packageName == null) goto L46;
        String r1 = r5.packageName;
        if (r5.flags != 8) goto L11;
        return true;
    L11:
        if (r5.uid >= 10000) goto L20;
        if (r1.equals(SmtPCUtils.PKG_CAMERA_2) == true) goto L20;
        if (r1.equals("com.bytedanceos.sara") == true) goto L20;
        if (r1.equals("com.obric.quicksearch") == true) goto L20;
        return true;
    L20:
        if (this.mWhitePackageSet.contains(r1) == true) goto L46;
        if (r1.startsWith("com.qualcomm") == true) goto L46;
        ResolveInfo r2 = this.mDefaultHome;
        if (r2 == null) goto L30;
        if (r2.activityInfo.packageName.equals(r1) == false) goto L30;
        return true;
    L30:
        if (Features.isFeatureCMCCEnabled(this.mContext).booleanValue() == true) goto L32;
    L34:
        InputMethodInfo r3 = InputMethodSettingValuesWrapper.getInstance(this.mContext).getCurrentInputMethodInfo();
        if (r3 == null) goto L40;
        if (TextUtils.equals(r3.getPackageName(), r1) == false) goto L40;
        return true;
    L40:
        if (r5.packageName.equals("com.bytedanceos.screenrecorder") == true) goto L42;
        return false;
    L42:
        if (isRecordScreen(this.mContext) == false) goto L47;
        return true;
    L47:
        return false;
    L32:
        if (r1.equals(Utils.APP_STORE_PACKAGE) == false) goto L34;
        return true;
    }

    private static ResolveInfo getDefaultHome(Context r2) {
        Intent r0 = new Intent("android.intent.action.MAIN");
        r0.addCategory("android.intent.category.HOME");
        r0.addCategory("android.intent.category.DEFAULT");
        return ((PackageManager) NullSafe.nonNull(r2.getPackageManager())).resolveActivity(r0, 65536);
    }

    public boolean stopPackage(RunningState.MergedItem r6, boolean r7) {
        if (r6.mIsTaskPersist == false) goto L5;
        return false;
    L5:
        String r0 = r6.mPackageInfo.packageName;
        if (CLOCK_PACAKGE.equals(r0) == false) goto L8;
    L54:
        this.mAm.killBackgroundProcesses(r0);
        if (r6.mServices != null) goto L57;
    L62:
        return true;
    L57:
        if (r6.mServices.size() <= 0) goto L62;
        Iterator<RunningState.ServiceItem> r8 = r6.mServices.iterator();
    L60:
        if (r8.hasNext() == false) goto L62;
        RunningState.ServiceItem r9 = r8.next();
        this.mContext.stopService(new Intent().setComponent(r9.mRunningService.service));
        goto L60
    L8:
        if (EMAIL_PACAKGE.equals(r0) == true) goto L54;
        if (WEATHER_PACKAGE.equals(r0) == true) goto L54;
        if (CALENDAR_PACAKGE.equals(r0) == true) goto L54;
        if ("com.obric.recorder".equals(r0) == false) goto L30;
        IRecorderCreatorService r4 = this.mRecordingService;
        if (r4 == null) goto L30;
    L27:
        e = move-exception;
        e.printStackTrace();
        goto L30
    L19:
        if (r4.getRecordingState() != 0) goto L21;
        this.mRecordingService = null;     // Catch: Exception -> L27
        this.mHasBound = false;     // Catch: Exception -> L27
        this.mContext.unbindService(this.mRecorderConnection);     // Catch: Exception -> L27
        goto L30
    L21:
        if ("com.obric.recorder".equals(r6.mPackageInfo.packageName) == false) goto L24;
        if (r7 == false) goto L24;
        Context r2 = this.mContext;     // Catch: Exception -> L27
        ToastUtils.show(r2, r2.getString(R.string.cannot_clean_recorder));     // Catch: Exception -> L27
    L24:
        return false;
    L30:
        if ("com.bytedanceos.screenrecorder".equals(r0) == true) goto L32;
    L64:
        this.mIActivityManager.forceStopPackage(r0, r6.mUserId);     // Catch: RemoteException -> L63
        if (GOOGLE_ANDROID_GSF_LOGIN.equals(r0) == false) goto L48;
        this.mIActivityManager.forceStopPackage(GOOGLE_ANDROID_GMS, r6.mUserId);     // Catch: RemoteException -> L63
    L48:
        if (r0.equals(CLOUDSYNC_PACAKGE) == false) goto L51;
        this.mIActivityManager.forceStopPackage(CLOUDGALLER_PACAKGE, r6.mUserId);     // Catch: RemoteException -> L63
        goto L53
    L51:
        if (r0.equals("com.obric.quicksearch") == false) goto L53;
        this.mIActivityManager.forceStopPackage(APPLICATIONS_PROVIDER_PACKAGE, r6.mUserId);     // Catch: RemoteException -> L63
    L53:
        return true;
    L32:
        if (isRecordScreen(this.mContext) == false) goto L36;
        if (r7 == false) goto L35;
        Context r5 = this.mContext;
        ToastUtils.show(r5, r5.getString(R.string.cannot_clean_screen_recorder));
    L35:
        return false;
    L36:
        this.mAm.killBackgroundProcesses(r0);
        if (r6.mServices == null) goto L64;
        if (r6.mServices.size() <= 0) goto L64;
        Iterator<RunningState.ServiceItem> r10 = r6.mServices.iterator();
    L42:
        if (r10.hasNext() == false) goto L64;
        RunningState.ServiceItem r1 = r10.next();
        this.mContext.stopService(new Intent().setComponent(r1.mRunningService.service));
        goto L42
    }

    public void stopPackage(PackageInfo r2) {
        if (r2 == null) goto L13;
        IActivityManager r1 = this.mIActivityManager;
        if (r1 == null) goto L14;
        r1.forceStopPackage(r2.packageName, UserHandle.getUserId(r2.applicationInfo.uid));     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        OLog.d("RunningStateHelper", "stopPackage for permission exception =" + e);
        return;
    L14:
        return;
    }

    public void restartPackage(PackageInfo r2) {
        if (r2 == null) goto L13;
        IActivityManager r1 = this.mIActivityManager;
        if (r1 == null) goto L14;
        r1.startUserInBackground(UserHandle.getUserId(r2.applicationInfo.uid));     // Catch: RemoteException -> L8
        return;
    L8:
        e = move-exception;
        OLog.d("RunningStateHelper", "restartPackage for permission exception =" + e);
        return;
    L14:
        return;
    }

    private boolean isRecordScreen(Context r3) {
        if (Settings.Global.getInt(r3.getContentResolver(), SCREEN_RECORDER_STATUS, 0) == 1) goto L7;
        if (Settings.Global.getInt(r3.getContentResolver(), SCREEN_RECORDER_SHOW_STATUS, 0) == 1) goto L7;
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
