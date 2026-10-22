package com.android.settings.doppelganger;

import android.app.ActivityManagerNative;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.IPackageManager;
import android.content.pm.LauncherApps;
import android.content.pm.PackageManager;
import android.content.pm.UserInfo;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.ServiceManager;
import android.os.SystemClock;
import android.os.UserManager;
import android.provider.Settings;
import android.text.TextUtils;
import com.android.settings.applications.PickApplicationActivity;
import com.obric.olog.OLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class DoppelgangerManagerHelper {
    public static String ACTION_DOPPELGANGER_PACKAGE_ADDED = "com.settings.action_DOPPELGANGER_ADDED";
    public static String ACTION_DOPPELGANGER_PACKAGE_REMOVED = "com.settings.action.DOPPELGANGER_REMOVED";
    public static final int DOPPELGANGER_USER_ID = 10;
    private static final String ENABLED_APP_DOPPELGANGER_TIME = "enabled_app_doppelganger_time";
    public static String EXTRA_PACKAGENAME = "extra_packagename";
    public static String EXTRA_USERID = "extra_userid";
    private static final int FLAG_DOPPELGANGER = 1073741824;
    private static final String TAG = "DoppelgangerManager";
    private final Context mContext;
    private final Handler mDoppelgangerHandler;
    private DoppelgangerListener mDoppelgangerListener;
    private volatile UserInfo mDoppelgangerUserInfo;
    private HandlerThread mHandlerThread;
    private IPackageManager mIPackageManager;
    private Map<String, Long> mInstallTime;
    private LauncherApps.Callback mLauncherCallback;
    private PackageManager mPackageManager;
    private UserManager mUserManager;

    interface DoppelgangerListener {
        public static final int ADD = 1;
        public static final int ERROR = 0;
        public static final int REMOVE = 2;

        void onDoppelgangerApp(String r1, int r2);
    }

    static {
    }

    static /* synthetic */ IPackageManager access$000(DoppelgangerManagerHelper r0) {
        return r0.mIPackageManager;
    }

    static /* synthetic */ PackageManager access$100(DoppelgangerManagerHelper r0) {
        return r0.mPackageManager;
    }

    static /* synthetic */ void access$200(DoppelgangerManagerHelper r0, String r1, boolean r2) {
        r0.updateInstallTime(r1, r2);
    }

    static /* synthetic */ DoppelgangerListener access$300(DoppelgangerManagerHelper r0) {
        return r0.mDoppelgangerListener;
    }

    static /* synthetic */ UserInfo access$400(DoppelgangerManagerHelper r0) {
        return r0.mDoppelgangerUserInfo;
    }

    static /* synthetic */ void access$500(DoppelgangerManagerHelper r0, Runnable r1) {
        r0.createDoppelgangerUser(r1);
    }

    DoppelgangerManagerHelper(Context r7, DoppelgangerListener r8) {
        this.mInstallTime = new HashMap();
        this.mContext = r7;
        this.mUserManager = (UserManager) r7.getSystemService(PickApplicationActivity.EXTRA_USER);
        this.mIPackageManager = IPackageManager.Stub.asInterface(ServiceManager.getService("package"));
        this.mPackageManager = r7.getPackageManager();
        this.mDoppelgangerUserInfo = getDoppelgangerUserInfo();
        this.mDoppelgangerListener = r8;
        HandlerThread r9 = new HandlerThread("doppelganger");
        this.mHandlerThread = r9;
        r9.start();
        this.mDoppelgangerHandler = new Handler(this.mHandlerThread.getLooper());
        registerPackageChangeCallback();
        String r10 = Settings.Secure.getString(r7.getContentResolver(), ENABLED_APP_DOPPELGANGER_TIME);
        if (TextUtils.isEmpty(r10) == true) goto L7;
        String[] r11 = r10.split(";");
        int r12 = r11.length;
        int r1 = 0;
    L5:
        if (r1 >= r12) goto L9;
        String[] r2 = r11[r1].split(":");
        this.mInstallTime.put(r2[0], Long.valueOf(r2[1]));
        r1 = r1 + 1;
        goto L5
    L9:
        return;
    }

    private void createDoppelgangerUser(Runnable r9) {
        if (DoppelgangerSettingsFragment.DEBUG == false) goto L6;
        OLog.d(TAG, "createDoppelgangerUser");
    L6:
        if (this.mUserManager.hasUserRestriction("no_add_user") == false) goto L9;
        this.mUserManager.setUserRestriction("no_add_user", false);
    L9:
        if (this.mDoppelgangerUserInfo != null) goto L11;
        OLog.i(TAG, "DoppelgangerUserInfo is null ");
        this.mDoppelgangerUserInfo = this.mUserManager.createProfileForUser("doppelganger", "android.os.usertype.profile.CLONE", 1073741824, 0);
    L11:
        OLog.i(TAG, "createDoppelgangerUser " + this.mDoppelgangerUserInfo);
        if (this.mDoppelgangerUserInfo != null) goto L29;
        this.mDoppelgangerListener.onDoppelgangerApp(null, 0);
        return;
    L29:
        boolean r2 = ActivityManagerNative.getDefault().isUserRunning(this.mDoppelgangerUserInfo.id, 0);     // Catch: Exception -> L26
        OLog.i(TAG, "ENABLED_APP_DOPPELGANGER " + r2);     // Catch: Exception -> L26
        if (r2 == true) goto L22;
        boolean r1 = ActivityManagerNative.getDefault().startProfile(this.mDoppelgangerUserInfo.id);     // Catch: Exception -> L26
        OLog.d(TAG, "createDoppelgangerUser startProfile: " + r1);     // Catch: Exception -> L26
        if (r1 == false) goto L21;
        this.mUserManager.setUserEnabled(this.mDoppelgangerUserInfo.id);     // Catch: Exception -> L26
        goto L22
    L21:
        throw new RuntimeException("start doppelganger user error");     // Catch: Exception -> L26
    L22:
        if (r9 == null) goto L24;
        OLog.d(TAG, "createDoppelgangerUser before dopAppRunnable");     // Catch: Exception -> L26
        r9.run();     // Catch: Exception -> L26
    L24:
        OLog.d(TAG, "createDoppelgangerUser after dopAppRunnable");     // Catch: Exception -> L26
        Settings.Secure.putInt(this.mContext.getContentResolver(), "enabled_app_doppelganger", 1);     // Catch: Exception -> L26
        OLog.d(TAG, "createDoppelgangerUser after ENABLED_APP_DOPPELGANGER");     // Catch: Exception -> L26
        Settings.Secure.putIntForUser(this.mContext.getContentResolver(), "user_setup_complete", 1, this.mDoppelgangerUserInfo.id);     // Catch: Exception -> L26
        OLog.d(TAG, "createDoppelgangerUser after USER_SETUP_COMPLETE");     // Catch: Exception -> L26
        return;
    L26:
        e = move-exception;
        removeUser(10);
        this.mDoppelgangerListener.onDoppelgangerApp(null, 0);
        OLog.e(TAG, "createDoppelgangerUser error " + e);
    }

    void doppelgangerApp(final ApplicationInfo r3, final boolean r4) {
        if (DoppelgangerSettingsFragment.DEBUG == false) goto L5;
        OLog.d(TAG, "doppelgangerApp");
    L5:
        final Runnable r0 = new AnonymousClass1(this, r4, r3);
        this.mDoppelgangerHandler.post(new AnonymousClass2(this, r0));
    }

    public synchronized boolean hasDoppelgangerUser() {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (DoppelgangerSettingsFragment.DEBUG == false) goto L6;
        OLog.d(TAG, "hasDoppelgangerUser");     // Catch: Throwable -> L12
    L6:
        if (this.mDoppelgangerUserInfo == null) goto L9;
        boolean r0 = true;
    L10:
        monitor-exit(this);
        return r0;
    L9:
        r0 = false;
        goto L10
    }

    private void updateInstallTime(String r4, boolean r5) {
        long r0 = SystemClock.currentThreadTimeMillis();
        if (r5 == false) goto L5;
        this.mInstallTime.put(r4, Long.valueOf(r0));
    L6:
        Set<Map.Entry<String, Long>> r6 = this.mInstallTime.entrySet();
        StringBuilder r7 = new StringBuilder();
        Iterator<Map.Entry<String, Long>> r8 = r6.iterator();
    L8:
        if (r8.hasNext() == false) goto L11;
        Map.Entry<String, Long> r1 = r8.next();
        String r2 = r1.getKey();
        r7.append(r2).append(":").append(r1.getValue()).append(";");
        goto L8
    L11:
        if (r7.length() <= 0) goto L13;
        String r9 = r7.substring(0, r7.length() - 1);
    L14:
        Settings.Secure.putString(this.mContext.getContentResolver(), ENABLED_APP_DOPPELGANGER_TIME, r9);
        return;
    L13:
        r9 = "";
        goto L14
    L5:
        this.mInstallTime.remove(r4);
        goto L6
    }

    private void registerPackageChangeCallback() {
        this.mLauncherCallback = new AnonymousClass3(this);
        LauncherApps r0 = (LauncherApps) this.mContext.getSystemService("launcherapps");
        if (r0 == null) goto L6;
        r0.registerCallback(this.mLauncherCallback, this.mDoppelgangerHandler);
        return;
    }

    public void onDestroy() {
        if (DoppelgangerSettingsFragment.DEBUG == false) goto L5;
        OLog.d(TAG, "onDestroy");
    L5:
        LauncherApps r0 = (LauncherApps) this.mContext.getSystemService("launcherapps");
        if (r0 == null) goto L8;
        r0.unregisterCallback(this.mLauncherCallback);
    L8:
        HandlerThread r2 = this.mHandlerThread;
        if (r2 == null) goto L12;
        r2.quit();
        return;
    }

    boolean removeUser(int r3) {
        if (DoppelgangerSettingsFragment.DEBUG == false) goto L6;
        OLog.d(TAG, "removeUser: " + r3);
    L6:
        return this.mUserManager.removeUser(r3);
    }

    private UserInfo getDoppelgangerUserInfo() {
        Iterator r3 = this.mUserManager.getUsers().iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        UserInfo r0 = (UserInfo) r3.next();
        if (r0.id != 10) goto L4;
        return r0;
    L8:
        return null;
    }
}
