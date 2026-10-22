package com.bytedanceos.security.permission;

import android.app.ActivityManager;
import android.app.AppGlobals;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.IPackageManager;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.RemoteException;
import android.os.UserHandle;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.IconDrawableFactory;
import com.obric.olog.OLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class SpecialPermissionApps {
    private static final String TAG = "SpecialPermissionApps";
    private ArrayMap<String, PermissionApp> mAppLookup;
    private final Callback mCallback;
    private final Context mContext;
    private final NativePermission mNativePermission;
    private NotificationManager mNoMan;
    private List<PermissionApp> mPermApps;
    private final PackageManager mPm;
    private boolean mRefreshing;
    private boolean mSkipUi;

    /* JADX INFO: renamed from: com.bytedanceos.security.permission.SpecialPermissionApps$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public interface Callback {
        void onPermissionsLoaded(SpecialPermissionApps permissionApps);
    }

    private class PermissionAppsLoader extends AsyncTask<Void, Void, List<PermissionApp>> {
        final /* synthetic */ SpecialPermissionApps this$0;

        private PermissionAppsLoader(final SpecialPermissionApps this$0) {
            this.this$0 = this$0;
        }

        /* synthetic */ PermissionAppsLoader(SpecialPermissionApps r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ List<PermissionApp> doInBackground(Void[] args) {
            return doInBackground2(args);
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ void onPostExecute(List<PermissionApp> result) {
            onPostExecute2(result);
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        protected List<PermissionApp> doInBackground2(Void... args) {
            return SpecialPermissionApps.access$100(this.this$0);
        }

        /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        protected void onPostExecute2(List<PermissionApp> result) {
            SpecialPermissionApps.access$202(this.this$0, false);
            SpecialPermissionApps.access$300(this.this$0, result);
            if (SpecialPermissionApps.access$400(this.this$0) == null) goto L6;
            SpecialPermissionApps.access$400(this.this$0).onPermissionsLoaded(this.this$0);
            return;
        }
    }

    static /* synthetic */ List access$100(SpecialPermissionApps r0) {
        return r0.loadPermissionApps();
    }

    static /* synthetic */ boolean access$202(SpecialPermissionApps r0, boolean r1) {
        r0.mRefreshing = r1;
        return r1;
    }

    static /* synthetic */ void access$300(SpecialPermissionApps r0, List r1) {
        r0.createMap(r1);
    }

    static /* synthetic */ Callback access$400(SpecialPermissionApps r0) {
        return r0.mCallback;
    }

    public SpecialPermissionApps(Context context, NativePermission permission, Callback callback) {
        this.mContext = context;
        this.mPm = context.getPackageManager();
        this.mNativePermission = permission;
        this.mCallback = callback;
        this.mNoMan = (NotificationManager) context.getSystemService(NotificationManager.class);
    }

    public void refresh(boolean getUiInfo) {
        if (this.mCallback == null) goto L9;
        if (this.mRefreshing == true) goto L10;
        this.mRefreshing = true;
        this.mSkipUi = !getUiInfo;
        new PermissionAppsLoader(this, null).execute(new Void[0]);
        return;
    L10:
        return;
    L9:
        throw new IllegalStateException("callback needs to be set");
    }

    public List<PermissionApp> getApps() {
        return this.mPermApps;
    }

    private List<PermissionApp> loadPermissionApps() {
        ArrayList r0 = new ArrayList();
        IconDrawableFactory r1 = IconDrawableFactory.newInstance(this.mContext);
        Set<String> r2 = getPackagesRequestingNotificationPolicyAccess();
        if (r2.isEmpty() == true) goto L34;
        List<ApplicationInfo> r3 = this.mPm.getInstalledApplications(0);
        if (r3 == null) goto L31;
        Iterator<ApplicationInfo> r4 = r3.iterator();
    L8:
        if (r4.hasNext() == false) goto L31;
        ApplicationInfo r10 = r4.next();
        if (r2.contains(r10.packageName) == false) goto L8;
        if (this.mSkipUi == false) goto L15;
        String r5 = r10.packageName;
    L16:
        String r8 = r5;
        if (this.mSkipUi == true) goto L26;
        Drawable r6 = r1.getBadgedIcon(r10, UserHandle.getUserId(r10.uid));
        if (UserHandle.getUserId(r10.uid) != 10) goto L27;
        if (r6 == null) goto L27;
        if ((r6 instanceof BitmapDrawable) == false) goto L24;
    L25:
        r6 = this.mPm.getUserBadgedIcon(r6, new UserHandle(10));
        goto L27
    L24:
        if (r6.getClass().getSimpleName().equals("AdaptiveIconDrawable") == true) goto L25;
    L27:
        String r7 = r10.packageName;
        AppPermissionGroup r9 = new AppPermissionGroup(this.mContext, this.mNativePermission, "", UserHandle.getUserHandleForUid(r10.uid));
        PermissionApp r11 = new PermissionApp(r7, r9, r8, r6, r10);
        if (r11.getLabelEntry() != null) goto L30;
        r11.loadLabelEntry(this.mPm);
    L30:
        r0.add(r11);
        goto L8
    L26:
        r6 = null;
        goto L27
    L15:
        r5 = r10.loadLabel(this.mPm).toString();
    L31:
        Collections.sort(r0);
        return r0;
    L34:
        return Collections.emptyList();
    }

    public static Set<String> getPackagesRequestingNotificationPolicyAccess() {
        ArraySet r0 = new ArraySet();
        IPackageManager r2 = AppGlobals.getPackageManager();     // Catch: RemoteException -> L12
        List r1 = r2.getPackagesHoldingPermissions(new String[]{"android.permission.ACCESS_NOTIFICATION_POLICY"}, 0, ActivityManager.getCurrentUser()).getList();     // Catch: RemoteException -> L12
        if (r1 == null) goto L14;
        Iterator r3 = r1.iterator();     // Catch: RemoteException -> L12
    L7:
        if (r3.hasNext() == false) goto L14;
        PackageInfo r4 = (PackageInfo) r3.next();     // Catch: RemoteException -> L12
        if (r4.applicationInfo.enabled == false) goto L7;
        r0.add(r4.packageName);     // Catch: RemoteException -> L12
    L14:
        return r0;
    L12:
        e = move-exception;
        OLog.e(TAG, "Cannot reach packagemanager", e);
        goto L14
    }

    private void createMap(List<PermissionApp> result) {
        this.mAppLookup = new ArrayMap();
        Iterator<PermissionApp> r0 = result.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        PermissionApp r1 = r0.next();
        this.mAppLookup.put(r1.getKey(), r1);
        goto L4
    L6:
        this.mPermApps = result;
    }
}
