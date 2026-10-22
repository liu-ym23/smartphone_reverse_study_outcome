package com.bytedanceos.security.permission;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.content.pm.PermissionInfo;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.UserHandle;
import android.util.ArrayMap;
import android.util.IconDrawableFactory;
import com.bytedanceos.security.Utils;
import com.bytedanceos.security.reflect.PackageManagerHelper;
import com.obric.olog.OLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class PermissionApps {
    private static final String LOG_TAG = "PermissionApps";
    private ArrayMap<String, PermissionApp> mAppLookup;
    private final Callback mCallback;
    private final Context mContext;
    private final NativePermission mNativePermission;
    private List<PermissionApp> mPermApps;
    private final PackageManager mPm;
    private boolean mRefreshing;
    private boolean mSkipUi;

    /* JADX INFO: renamed from: com.bytedanceos.security.permission.PermissionApps$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public interface Callback {
        void onPermissionsLoaded(PermissionApps permissionApps);
    }

    private class PermissionAppsLoader extends AsyncTask<Void, Void, List<PermissionApp>> {
        final /* synthetic */ PermissionApps this$0;

        private PermissionAppsLoader(final PermissionApps this$0) {
            this.this$0 = this$0;
        }

        /* synthetic */ PermissionAppsLoader(PermissionApps r1, AnonymousClass1 r2) {
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
            return PermissionApps.access$100(this.this$0);
        }

        /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        protected void onPostExecute2(List<PermissionApp> result) {
            PermissionApps.access$202(this.this$0, false);
            PermissionApps.access$300(this.this$0, result);
            if (PermissionApps.access$400(this.this$0) == null) goto L6;
            PermissionApps.access$400(this.this$0).onPermissionsLoaded(this.this$0);
            return;
        }
    }

    static /* synthetic */ List access$100(PermissionApps r0) {
        return r0.loadPermissionApps();
    }

    static /* synthetic */ boolean access$202(PermissionApps r0, boolean r1) {
        r0.mRefreshing = r1;
        return r1;
    }

    static /* synthetic */ void access$300(PermissionApps r0, List r1) {
        r0.createMap(r1);
    }

    static /* synthetic */ Callback access$400(PermissionApps r0) {
        return r0.mCallback;
    }

    public PermissionApps(Context context, NativePermission permission, Callback callback) {
        this.mContext = context;
        this.mPm = context.getPackageManager();
        this.mNativePermission = permission;
        this.mCallback = callback;
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
        PackageItemInfo r1 = getGroupInfo(this.mNativePermission.getDangerousGroupName());
        if (r1 == null) goto L5;
        List<PermissionInfo> r9 = getGroupPermissionInfos();
        if (r9 == null) goto L9;
        DangerousPermissionUtil.getAllLaunchApps(this.mPm);
        ArrayList r10 = new ArrayList();
        IconDrawableFactory r11 = IconDrawableFactory.newInstance(this.mContext);
        int r12 = 0;
        List r13 = this.mPm.getInstalledPackagesAsUser(4096, 0);     // Catch: RuntimeException -> L80
        List<PackageInfo> r2 = new PackageManagerHelper(this.mPm).getInstalledPackages(4096, 10);     // Catch: RuntimeException -> L80
        if (r2.size() <= 0) goto L14;
        r13.addAll(r2);     // Catch: RuntimeException -> L80
    L14:
        if (r13 == null) goto L79;
        int r15 = 1;
        if (r13.size() < 1) goto L79;
        PermissionInfo r16 = getBackgroundPermissionInfo();
        int r8 = r13.size();
        int r7 = 0;
    L19:
        if (r7 >= r8) goto L78;
        PackageInfo r6 = (PackageInfo) r13.get(r7);
        if (r6.requestedPermissions != null) goto L24;
    L76:
        int r19 = r7;
        int r20 = r8;
    L77:
        r7 = r19 + 1;
        r8 = r20;
        r12 = 0;
        r15 = 1;
        goto L19
    L24:
        if ((r6.applicationInfo.flags & r15) != 0) goto L76;
        if (UserHandle.isApp(r6.applicationInfo.uid) == false) goto L76;
        if (Utils.isHiddenApp(r6.packageName) == true) goto L76;
        int r5 = r12;
    L33:
        if (r5 >= r6.requestedPermissions.length) goto L76;
        String r3 = r6.requestedPermissions[r5];
        Iterator<PermissionInfo> r4 = r9.iterator();
    L35:
        Drawable r17 = null;
        if (r4.hasNext() == false) goto L41;
        PermissionInfo r14 = r4.next();
        if (r3.equals(r14.name) == false) goto L35;
    L42:
        if (r14 != null) goto L45;
    L43:
        PackageInfo r18 = r6;
        r19 = r7;
        r20 = r8;
    L55:
        r5 = r5 + 1;
        r6 = r18;
        r7 = r19;
        r8 = r20;
        r15 = 1;
        goto L33
    L45:
        if (this.mNativePermission.getPermissionType() != 3) goto L47;
    L53:
        r18 = r6;
        r19 = r7;
        r20 = r8;
        AppPermissionGroup r23 = AppPermissionGroup.create(this.mContext, r6, this.mNativePermission, r1, r9, r16, UserHandle.getUserHandleForUid(r6.applicationInfo.uid));
        if (r23 == null) goto L55;
        if (this.mSkipUi == false) goto L59;
        String r21 = r18.packageName;
    L60:
        String r24 = r21;
        if (this.mSkipUi == true) goto L71;
        Drawable r22 = r11.getBadgedIcon(r18.applicationInfo, UserHandle.getUserId(r23.getApp().applicationInfo.uid));
        if (UserHandle.getUserId(r18.applicationInfo.uid) != 10) goto L70;
        if (r22 == null) goto L70;
        if ((r22 instanceof BitmapDrawable) == false) goto L68;
    L69:
        r17 = this.mPm.getUserBadgedIcon(r22, new UserHandle(10));
        goto L71
    L68:
        if (r22.getClass().getSimpleName().equals("AdaptiveIconDrawable") == true) goto L69;
    L70:
        Drawable r25 = r22;
    L72:
        PermissionApp r26 = new PermissionApp(r18.packageName, r23, r24, r25, r18.applicationInfo);
        if (r26.getLabelEntry() != null) goto L75;
        r26.loadLabelEntry(this.mPm);
    L75:
        r10.add(r26);
    L71:
        r25 = r17;
        goto L72
    L59:
        r21 = r18.applicationInfo.loadLabel(this.mPm).toString();
        goto L60
    L47:
        if ((r14.protectionLevel & 15) != r15) goto L43;
        if ((r14.flags & 1073741824) == 0) goto L43;
        if ((r14.flags & 2) == 0) goto L53;
    L41:
        r14 = null;
        goto L42
    L78:
        Collections.sort(r10);
    L79:
        return r10;
    L80:
        e = move-exception;
        OLog.d(LOG_TAG, "load permission app exception=" + e);
        return r10;
    L9:
        return Collections.emptyList();
    L5:
        return Collections.emptyList();
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

    private PackageItemInfo getGroupInfo(String groupName) {
        PackageManager r2 = this.mContext.getPackageManager();
        if (r2 != null) goto L11;
        return null;
    L11:
        return r2.getPermissionGroupInfo(groupName, 0);
    L8:
        return r2.getPermissionInfo(groupName, 0);
    L10:
        return null;
    }

    private PermissionInfo getBackgroundPermissionInfo() {
        if (this.mNativePermission.hasBackgroundPermission() == false) goto L13;
        PackageManager r1 = this.mContext.getPackageManager();     // Catch: Exception -> L10
        if (r1 == null) goto L14;
        return r1.getPermissionInfo(this.mNativePermission.getBackgroundPermission(), 0);
    L14:
        return null;
    L13:
        return null;
    L15:
        return null;
    }

    private List<PermissionInfo> getGroupPermissionInfos() {
        if (this.mNativePermission != null) goto L5;
        return null;
    L5:
        PackageManager r0 = this.mContext.getPackageManager();
        if (r0 != null) goto L8;
        return null;
    L8:
        String[] r6 = this.mNativePermission.getPermissions();
        ArrayList r1 = new ArrayList();
        int r2 = r6.length;
        int r4 = 0;
    L9:
        if (r4 >= r2) goto L13;
        r1.add(r0.getPermissionInfo(r6[r4], 0));     // Catch: PackageManager.NameNotFoundException -> L14
    L12:
        r4 = r4 + 1;
        goto L9
    L13:
        return r1;
    }
}
