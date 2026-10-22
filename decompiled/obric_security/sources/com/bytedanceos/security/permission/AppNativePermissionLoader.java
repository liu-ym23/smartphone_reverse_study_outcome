package com.bytedanceos.security.permission;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PermissionInfo;
import android.os.AsyncTask;
import com.bytedanceos.security.reflect.OpsManagerHelper;
import com.obric.olog.OLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

/* JADX INFO: loaded from: classes2.dex */
public class AppNativePermissionLoader extends AsyncTask<Void, Void, List<NativePermissionGroup>> {
    private static final String[] InvisiblePermissionsR = null;
    private AppOpsManager mAppOpsManager;
    private AppPermissionLoaderListener mAppPermissionLoaderListener;
    private Context mContext;
    private OpsManagerHelper mOpsManagerHelper;
    private PackageInfo mPackageInfo;
    private PackageManager mPackageManager;

    public interface AppPermissionLoaderListener {
        void onLoadFinish(List<NativePermissionGroup> groups);
    }

    public static /* synthetic */ boolean $r8$lambda$7vnygv8KDh_0siXedbjU4N4ok2U(String r0, Object r1) {
        return r0.equals(r1);
    }

    @Override // android.os.AsyncTask
    protected /* bridge */ /* synthetic */ List<NativePermissionGroup> doInBackground(Void[] args) {
        return doInBackground2(args);
    }

    @Override // android.os.AsyncTask
    protected /* bridge */ /* synthetic */ void onPostExecute(List<NativePermissionGroup> result) {
        onPostExecute2(result);
    }

    public AppNativePermissionLoader(Context context, PackageInfo packageInfo, AppPermissionLoaderListener listener) {
        this.mContext = context;
        this.mPackageInfo = packageInfo;
        this.mPackageManager = context.getPackageManager();
        this.mAppPermissionLoaderListener = listener;
        this.mOpsManagerHelper = OpsManagerHelper.getInstance();
        this.mAppOpsManager = (AppOpsManager) context.getSystemService(AppOpsManager.class);
    }

    /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
    protected List<NativePermissionGroup> doInBackground2(Void... args) {
        return loadAppPermissionGroups();
    }

    /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
    protected void onPostExecute2(List<NativePermissionGroup> result) {
        AppPermissionLoaderListener r0 = this.mAppPermissionLoaderListener;
        if (r0 == null) goto L6;
        r0.onLoadFinish(result);
        return;
    }

    static {
        InvisiblePermissionsR = new String[]{"android.permission.READ_MEDIA_VIDEO", "android.permission.READ_MEDIA_IMAGES", "android.permission.READ_MEDIA_AUDIO"};
    }

    private static boolean isPermissionVisibleAfterSv2(ApplicationInfo appInfo, final String requestedPermission) {
        if (appInfo.targetSdkVersion <= 32) goto L5;
        return true;
    L5:
        Stream r2 = Arrays.stream(InvisiblePermissionsR);
        Objects.requireNonNull(requestedPermission);
        return !r2.anyMatch(new AppNativePermissionLoader$$ExternalSyntheticLambda0(requestedPermission));
    }

    public static boolean isPermissionVisible(PackageManager pm, ApplicationInfo appInfo, String requestedPermission) {
        PermissionInfo r3 = pm.getPermissionInfo(requestedPermission, 0);     // Catch: PackageManager.NameNotFoundException -> L22
        if ((r3.flags & 1073741824) != 0) goto L7;
    L21:
        return false;
    L7:
        if ((r3.flags & 2) != 0) goto L21;
        if (appInfo.isInstantApp() == false) goto L15;
        if ((r3.protectionLevel & 4096) != 0) goto L15;
        return false;
    L15:
        if (appInfo.targetSdkVersion >= 23) goto L20;
        if ((r3.protectionLevel & 8192) == 0) goto L20;
        return false;
    L20:
        return isPermissionVisibleAfterSv2(appInfo, requestedPermission);
    L22:
        e = move-exception;
        OLog.e("AppNativePermissionLoader", "isPermissionVisible Can't get permission info for " + requestedPermission, e);
        return false;
    }

    private List<NativePermissionGroup> loadAppPermissionGroups() {
        if (this.mPackageInfo != null) goto L5;
        return null;
    L5:
        List<NativePermissionGroup> r0 = NativePermissionManager.getAllGroups();
        boolean r2 = DangerousPermissionUtil.isOpenSystemApp(this.mPackageInfo.packageName);
        PackageInfo r3 = this.mPackageManager.getPackageInfo(this.mPackageInfo.packageName, 4096);     // Catch: Exception -> L12
        if (r3 == null) goto L11;
        String[] r4 = r3.requestedPermissions;     // Catch: Exception -> L12
        ApplicationInfo r5 = r3.applicationInfo;     // Catch: Exception -> L72
    L14:
        ArrayList r6 = new ArrayList();
        if (r4 != null) goto L17;
    L71:
        return null;
    L17:
        if (r4.length <= 0) goto L71;
        if (r5 == null) goto L28;
        int r7 = r4.length;
        int r8 = 0;
    L22:
        if (r8 >= r7) goto L27;
        String r9 = r4[r8];
        if (isPermissionVisible(this.mPackageManager, r5, r9) == false) goto L26;
        r6.add(r9);
    L26:
        r8 = r8 + 1;
        goto L22
    L27:
        r4 = (String[]) r6.toArray(new String[0]);
    L28:
        ArrayList r10 = new ArrayList();
        Iterator<NativePermissionGroup> r1 = r0.iterator();
    L30:
        if (r1.hasNext() == false) goto L70;
        NativePermissionGroup r11 = r1.next();
        List<NativePermission> r12 = NativePermissionManager.getGroupPermissions(r11.getType());
        ArrayList r13 = new ArrayList();
        Iterator<NativePermission> r14 = r12.iterator();
    L33:
        if (r14.hasNext() == false) goto L52;
        NativePermission r15 = r14.next();
        if (r2 == false) goto L42;
        if (r15.isDangerous() == false) goto L33;
        if (DangerousPermissionUtil.isOpenSystemAppHiddenPermission(this.mPackageInfo.packageName, r15.getPermissions()) == true) goto L33;
    L42:
        if (r15.isSepicalPermission() == true) goto L44;
        List<String> r16 = DangerousPermissionUtil.filterPermission(r15, r4);
        if (r16 == null) goto L33;
        if (r16.size() <= 0) goto L33;
        r13.add(new AppNativePermission(r15, r16));
        goto L33
    L44:
        if (DangerousPermissionUtil.validSepicalPermission(this.mContext, r15, r4) == false) goto L33;
        r13.add(new AppNativePermission(r15));
        goto L33
    L52:
        if (r13.size() <= 0) goto L30;
        Iterator<AppNativePermission> r17 = r13.iterator();
    L55:
        if (r17.hasNext() == false) goto L69;
        AppNativePermission r18 = r17.next();
        if (r18.isDangerous() == false) goto L58;
        int r19 = DangerousPermissionUtil.getDangerousPermissionMode(this.mAppOpsManager, this.mPackageManager, this.mPackageInfo, r18.getAppPermissions());
        r18.setPermissionStatus(r19);
        if (r18.hasBackgroundPermission() == false) goto L55;
        if (DangerousPermissionUtil.supportRuntimePermission(this.mPackageInfo) == true) goto L63;
        if (r19 != OpsManagerHelper.get_MODE_ALLOWED()) goto L67;
        int r20 = OpsManagerHelper.get_MODE_ALLOWED();
    L68:
        r18.setBackgroudStatusMode(r20);
        goto L55
    L67:
        r20 = OpsManagerHelper.get_MODE_IGNORED();
        goto L68
    L63:
        r18.setBackgroudStatusMode(DangerousPermissionUtil.getDangerousPermissionMode(this.mAppOpsManager, this.mPackageManager, this.mPackageInfo, r18.getBackgroundPermission()));
        goto L55
    L58:
        r18.setPermissionStatus(this.mOpsManagerHelper.getMode(this.mPackageInfo.applicationInfo.uid, this.mPackageInfo.packageName, new int[]{r18.getOpCode()}));
        goto L55
    L69:
        r11.addPermission(r13);
        r10.add(r11);
        goto L30
    L70:
        return r10;
    L13:
        r5 = null;
        goto L14
    L11:
        r5 = null;
        r4 = null;
    L12:
        r4 = null;
        goto L13
    }
}
