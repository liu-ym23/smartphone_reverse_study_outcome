package com.android.settingslib.applications;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.PermissionChecker;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.multiuser.Flags;
import android.os.UserHandle;
import android.os.UserManager;
import android.permission.PermissionManager;
import android.util.ArrayMap;
import android.util.IconDrawableFactory;
import com.GlobalProxyLancet;
import java.time.Clock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class RecentAppOpsAccess {
    public static final String ANDROID_SYSTEM_PACKAGE_NAME = "android";
    private static final int[] CAMERA_OPS = null;
    static final int[] LOCATION_OPS = null;
    private static final int[] MICROPHONE_OPS = null;
    private static final long RECENT_TIME_INTERVAL_MILLIS = 86400000;
    private static final String TAG = null;
    public static final int TRUSTED_STATE_FLAGS = 13;
    private final Clock mClock;
    private final Context mContext;
    private final IconDrawableFactory mDrawableFactory;
    private final int[] mOps;
    private final PackageManager mPackageManager;

    public static class Access {
        public final long accessFinishTime;
        public final CharSequence contentDescription;
        public final Drawable icon;
        public final CharSequence label;
        public final String packageName;
        public final UserHandle userHandle;

        public Access(String r1, UserHandle r2, Drawable r3, CharSequence r4, CharSequence r5, long r6) {
            this.packageName = r1;
            this.userHandle = r2;
            this.icon = r3;
            this.label = r4;
            this.contentDescription = r5;
            this.accessFinishTime = r6;
        }
    }

    static {
        LOCATION_OPS = new int[]{1, 0};
        MICROPHONE_OPS = new int[]{27, 100};
        CAMERA_OPS = new int[]{26};
        TAG = "RecentAppOpsAccess";
    }

    public RecentAppOpsAccess(Context r2, int[] r3) {
        this(r2, Clock.systemDefaultZone(), r3);
    }

    RecentAppOpsAccess(Context r2, Clock r3, int[] r4) {
        this.mContext = r2;
        this.mPackageManager = r2.getPackageManager();
        this.mOps = r4;
        this.mDrawableFactory = IconDrawableFactory.newInstance(r2);
        this.mClock = r3;
    }

    public static RecentAppOpsAccess createForLocation(Context r2) {
        return new RecentAppOpsAccess(r2, LOCATION_OPS);
    }

    public static RecentAppOpsAccess createForMicrophone(Context r2) {
        return new RecentAppOpsAccess(r2, MICROPHONE_OPS);
    }

    public static RecentAppOpsAccess createForCamera(Context r2) {
        return new RecentAppOpsAccess(r2, CAMERA_OPS);
    }

    public List<Access> getAppList(boolean r22) {
        List r1 = ((AppOpsManager) this.mContext.getSystemService(AppOpsManager.class)).getPackagesForOps(this.mOps);
        if (r1 == null) goto L5;
        int r3 = r1.size();
    L6:
        ArrayList r4 = new ArrayList(r3);
        long r5 = this.mClock.millis();
        UserManager r7 = (UserManager) this.mContext.getSystemService(UserManager.class);
        List<UserHandle> r8 = r7.getUserProfiles();
        ArrayMap r9 = new ArrayMap();
        int r10 = 0;
    L7:
        if (r10 >= r3) goto L41;
        AppOpsManager.PackageOps r11 = (AppOpsManager.PackageOps) r1.get(r10);
        String r12 = r11.getPackageName();
        int r13 = r11.getUid();
        UserHandle r14 = UserHandle.getUserHandleForUid(r13);
        if (r9.containsKey(r14) == true) goto L12;
        r9.put(r14, Boolean.valueOf(shouldHideUser(r7, r14)));
    L12:
        if (r8.contains(r14) == true) goto L14;
    L39:
        List r16 = r1;
        int r17 = r3;
        UserManager r19 = r7;
        List<UserHandle> r20 = r8;
    L40:
        r10 = r10 + 1;
        r1 = r16;
        r3 = r17;
        r7 = r19;
        r8 = r20;
        goto L7
    L14:
        if (((Boolean) r9.get(r14)).booleanValue() == true) goto L39;
        if (r22 == true) goto L31;
        int[] r15 = this.mOps;
        int r2 = r15.length;
        r16 = r1;
        int r6 = 0;
    L18:
        if (r6 >= r2) goto L32;
        int r18 = r2;
        String r21 = AppOpsManager.opToPermission(r15[r6]);
        if (r21 != null) goto L22;
        r17 = r3;
        r19 = r7;
        r20 = r8;
    L30:
        r6 = r6 + 1;
        r3 = r17;
        r2 = r18;
        r7 = r19;
        r8 = r20;
        goto L18
    L22:
        r17 = r3;
        int r23 = this.mPackageManager.getPermissionFlags(r21, r12, r14);
        r19 = r7;
        r20 = r8;
        if (PermissionChecker.checkPermissionForPreflight(this.mContext, r21, -1, r13, r12) != 0) goto L28;
        if ((r23 & 256) != 0) goto L30;
    L29:
        boolean r24 = false;
    L33:
        if (r24 == false) goto L40;
        if (PermissionManager.shouldShowPackageForIndicatorCached(this.mContext, r12) == false) goto L40;
        Access r25 = getAccessFromOps(r5, r11);
        if (r25 == null) goto L40;
        r4.add(r25);
        goto L40
    L28:
        if ((r23 & 512) != 0) goto L30;
    L32:
        r17 = r3;
        r19 = r7;
        r20 = r8;
        r24 = true;
        goto L33
    L31:
        r16 = r1;
        goto L32
    L41:
        return r4;
    L5:
        r3 = 0;
        goto L6
    }

    public List<Access> getAppListSorted(boolean r2) {
        List<Access> r3 = getAppList(r2);
        Collections.sort(r3, Collections.reverseOrder(new AnonymousClass1(this)));
        return r3;
    }

    private boolean shouldHideUser(UserManager r2, UserHandle r3) {
        if (Flags.enablePrivateSpaceFeatures() == true) goto L5;
        return false;
    L5:
        if (Flags.handleInterleavedSettingsForPrivateSpace() == true) goto L7;
        return false;
    L7:
        if (r2.isQuietModeEnabled(r3) == true) goto L9;
        return false;
    L9:
        if (r2.getUserProperties(r3).getShowInQuietMode() == 1) goto L11;
        return false;
    L11:
        return true;
    }

    private Access getAccessFromOps(long r11, AppOpsManager.PackageOps r13) {
        String r9 = r13.getPackageName();
        long r12 = r11 - 86400000;
        Iterator r1 = r13.getOps().iterator();
        long r2 = 0;
    L3:
        long r7 = r2;
    L5:
        if (r1.hasNext() == false) goto L10;
        r2 = ((AppOpsManager.OpEntry) r1.next()).getLastAccessTime(13);
        if (r2 <= r7) goto L5;
    L10:
        if (r7 >= r12) goto L12;
        return null;
    L12:
        int r14 = UserHandle.getUserId(r13.getUid());
        ApplicationInfo r15 = this.mPackageManager.getApplicationInfoAsUser(r9, 128, r14);     // Catch: PackageManager.NameNotFoundException -> L23
        if (r15 != null) goto L17;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "Null application info retrieved for package " + r9 + ", userId " + r14);     // Catch: PackageManager.NameNotFoundException -> L23
        return null;
    L17:
        UserHandle r3 = new UserHandle(r14);     // Catch: PackageManager.NameNotFoundException -> L23
        Drawable r4 = this.mDrawableFactory.getBadgedIcon(r15, r14);     // Catch: PackageManager.NameNotFoundException -> L23
        CharSequence r5 = this.mPackageManager.getApplicationLabel(r15);     // Catch: PackageManager.NameNotFoundException -> L23
        CharSequence r10 = this.mPackageManager.getUserBadgedLabel(r5, r3);     // Catch: PackageManager.NameNotFoundException -> L23
        if (r5.toString().contentEquals(r10) == false) goto L20;
        CharSequence r6 = null;
    L29:
        return new Access(r9, r3, r4, r5, r6, r7);
    L20:
        r6 = r10;
    L23:
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "package name not found for " + r9 + ", userId " + r14);
        return null;
    }
}
