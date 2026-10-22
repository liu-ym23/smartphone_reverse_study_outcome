package com.android.settingslib.location;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.PermissionChecker;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.UserHandle;
import android.os.UserManager;
import android.util.IconDrawableFactory;
import android.util.Log;
import com.GlobalProxyLancet;
import com.android.settings.applications.PickApplicationActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class RecentLocationApps {
    static final String ANDROID_SYSTEM_PACKAGE_NAME = "android";
    static final int[] LOCATION_PERMISSION_OPS = null;
    static final int[] LOCATION_REQUEST_OPS = null;
    private static final long RECENT_TIME_INTERVAL_MILLIS = 86400000;
    private static final String TAG = "RecentLocationApps";
    private final Context mContext;
    private final IconDrawableFactory mDrawableFactory;
    private final PackageManager mPackageManager;

    public static class Request {
        public final CharSequence contentDescription;
        public final Drawable icon;
        public final boolean isHighBattery;
        public final CharSequence label;
        public final String packageName;
        public final long requestFinishTime;
        public final UserHandle userHandle;

        public Request(String r1, UserHandle r2, Drawable r3, CharSequence r4, boolean r5, CharSequence r6, long r7) {
            this.packageName = r1;
            this.userHandle = r2;
            this.icon = r3;
            this.label = r4;
            this.isHighBattery = r5;
            this.contentDescription = r6;
            this.requestFinishTime = r7;
        }
    }

    static {
        LOCATION_REQUEST_OPS = new int[]{41, 42};
        LOCATION_PERMISSION_OPS = new int[]{1, 0};
    }

    public RecentLocationApps(Context r2) {
        this.mContext = r2;
        this.mPackageManager = r2.getPackageManager();
        this.mDrawableFactory = IconDrawableFactory.newInstance(r2);
    }

    public List<Request> getAppList(boolean r21) {
        PackageManager r1 = this.mContext.getPackageManager();
        List r2 = ((AppOpsManager) this.mContext.getSystemService("appops")).getPackagesForOps(LOCATION_REQUEST_OPS);
        if (r2 == null) goto L5;
        int r4 = r2.size();
    L6:
        ArrayList r5 = new ArrayList(r4);
        long r6 = System.currentTimeMillis();
        List<UserHandle> r8 = ((UserManager) this.mContext.getSystemService(PickApplicationActivity.EXTRA_USER)).getUserProfiles();
        int r9 = 0;
    L7:
        if (r9 >= r4) goto L37;
        AppOpsManager.PackageOps r10 = (AppOpsManager.PackageOps) r2.get(r9);
        String r11 = r10.getPackageName();
        int r12 = r10.getUid();
        UserHandle r13 = UserHandle.getUserHandleForUid(r12);
        if (r12 == 1000) goto L11;
    L13:
        boolean r14 = false;
    L14:
        if (r14 == false) goto L16;
    L35:
        PackageManager r18 = r1;
        List r17 = r2;
        int r19 = r4;
    L36:
        r9 = r9 + 1;
        r2 = r17;
        r1 = r18;
        r4 = r19;
        goto L7
    L16:
        if (r8.contains(r13) == false) goto L35;
        if (r21 == true) goto L30;
        int[] r15 = LOCATION_PERMISSION_OPS;
        int r3 = r15.length;
        int r16 = 0;
    L20:
        if (r16 >= r3) goto L30;
        r17 = r2;
        String r7 = AppOpsManager.opToPermission(r15[r16]);
        int r110 = r3;
        int r20 = r1.getPermissionFlags(r7, r11, r13);
        r18 = r1;
        r19 = r4;
        if (PermissionChecker.checkPermissionForPreflight(this.mContext, r7, -1, r12, r11) != 0) goto L27;
        if ((r20 & 256) != 0) goto L29;
    L28:
        boolean r111 = false;
    L31:
        if (r111 == false) goto L36;
        Request r22 = getRequestFromOps(r6, r10);
        if (r22 == null) goto L36;
        r5.add(r22);
    L29:
        r16 = r16 + 1;
        r3 = r110;
        r2 = r17;
        r1 = r18;
        r4 = r19;
        goto L20
    L27:
        if ((r20 & 512) != 0) goto L29;
    L30:
        r18 = r1;
        r17 = r2;
        r19 = r4;
        r111 = true;
        goto L31
    L11:
        if ("android".equals(r11) == false) goto L13;
        r14 = true;
        goto L14
    L37:
        return r5;
    L5:
        r4 = 0;
        goto L6
    }

    public List<Request> getAppListSorted(boolean r2) {
        List<Request> r3 = getAppList(r2);
        Collections.sort(r3, Collections.reverseOrder(new AnonymousClass1(this)));
        return r3;
    }

    private Request getRequestFromOps(long r12, AppOpsManager.PackageOps r14) {
        String r10 = r14.getPackageName();
        long r13 = r12 - 86400000;
        Iterator r1 = r14.getOps().iterator();
        boolean r2 = false;
        boolean r6 = false;
        long r8 = 0;
    L4:
        if (r1.hasNext() == false) goto L17;
        AppOpsManager.OpEntry r3 = (AppOpsManager.OpEntry) r1.next();
        if (r3.isRunning() == true) goto L9;
        if (r3.getTime() < r13) goto L4;
    L9:
        r8 = r3.getTime() + r3.getDuration();
        int r4 = r3.getOp();
        if (r4 != 41) goto L12;
        r2 = true;
        goto L4
    L12:
        if (r4 != 42) goto L4;
        r6 = true;
        goto L4
    L17:
        if (r6 == true) goto L23;
        if (r2 == true) goto L23;
        String r11 = TAG;
        if (Log.isLoggable(r11, 2) == false) goto L22;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_v(r11, r10 + " hadn't used location within the time interval.");
    L22:
        return null;
    L23:
        int r15 = UserHandle.getUserId(r14.getUid());
        ApplicationInfo r16 = this.mPackageManager.getApplicationInfoAsUser(r10, 128, r15);     // Catch: PackageManager.NameNotFoundException -> L34
        if (r16 != null) goto L28;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "Null application info retrieved for package " + r10 + ", userId " + r15);     // Catch: PackageManager.NameNotFoundException -> L34
        return null;
    L28:
        UserHandle r5 = new UserHandle(r15);     // Catch: PackageManager.NameNotFoundException -> L34
        Drawable r7 = this.mDrawableFactory.getBadgedIcon(r16, r15);     // Catch: PackageManager.NameNotFoundException -> L34
        CharSequence r9 = this.mPackageManager.getApplicationLabel(r16);     // Catch: PackageManager.NameNotFoundException -> L34
        CharSequence r17 = this.mPackageManager.getUserBadgedLabel(r9, r5);     // Catch: PackageManager.NameNotFoundException -> L34
        if (r9.toString().contentEquals(r17) == false) goto L31;
        CharSequence r18 = null;
    L48:
        return new Request(r10, r5, r7, r9, r6, r18, r8);
    L31:
        r18 = r17;
    L34:
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "package name not found for " + r10 + ", userId " + r15);
        return null;
    }
}
