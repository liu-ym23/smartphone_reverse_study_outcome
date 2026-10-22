package com.bytedanceos.security.permission;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.bytedanceos.application.ApplicationLabelCache;
import com.bytedanceos.application.LabelEntry;
import com.bytedanceos.security.PackagePermissions;
import com.bytedanceos.security.PackagesListLoader;
import com.bytedanceos.security.Utils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class NativePackagesListLoader extends PackagesListLoader {
    private static final String TAG = "NativePackagesListLoader";
    private Context mContext;

    public NativePackagesListLoader(Context context) {
        super(context);
        this.mContext = context;
    }

    @Override // com.bytedanceos.security.PackagesListLoader
    public PackagePermissions queryEntry(PackageInfo packageInfo, final PackageManager pm) {
        return getEntryWithDangerous(this.mContext, packageInfo, pm);
    }

    public static PackagePermissions getEntryWithDangerous(Context context, PackageInfo packageInfo, final PackageManager pm) {
        PackagePermissions r0 = null;
        PackageInfo r1 = pm.getPackageInfo(packageInfo.packageName, 4096);     // Catch: PackageManager.NameNotFoundException -> L54
        ArrayList r2 = new ArrayList();     // Catch: PackageManager.NameNotFoundException -> L54
        boolean r3 = false;
        if (r1 == null) goto L19;
        String[] r4 = r1.requestedPermissions;     // Catch: PackageManager.NameNotFoundException -> L54
        ApplicationInfo r5 = r1.applicationInfo;     // Catch: PackageManager.NameNotFoundException -> L54
        if (r4 != null) goto L8;
    L18:
        return null;
    L8:
        if (r4.length <= 0) goto L18;
        if (r5 == null) goto L20;
        int r6 = r4.length;     // Catch: PackageManager.NameNotFoundException -> L54
        int r7 = 0;
    L12:
        if (r7 >= r6) goto L17;
        String r8 = r4[r7];     // Catch: PackageManager.NameNotFoundException -> L54
        if (AppNativePermissionLoader.isPermissionVisible(pm, r5, r8) == false) goto L16;
        r2.add(r8);     // Catch: PackageManager.NameNotFoundException -> L54
    L16:
        r7 = r7 + 1;     // Catch: PackageManager.NameNotFoundException -> L54
        goto L12
    L17:
        r4 = (String[]) r2.toArray(new String[0]);     // Catch: PackageManager.NameNotFoundException -> L54
    L20:
        boolean r9 = DangerousPermissionUtil.isOpenSystemApp(packageInfo.packageName);     // Catch: PackageManager.NameNotFoundException -> L54
        PackagePermissions r10 = new PackagePermissions(packageInfo.packageName, packageInfo.applicationInfo.uid);     // Catch: PackageManager.NameNotFoundException -> L54
        Iterator<NativePermission> r11 = NativePermissionManager.getAllPermissions().iterator();     // Catch: PackageManager.NameNotFoundException -> L52
    L23:
        if (r11.hasNext() == false) goto L42;
        NativePermission r12 = r11.next();     // Catch: PackageManager.NameNotFoundException -> L52
        if (r9 == false) goto L32;
        if (r12.isDangerous() == false) goto L23;
        if (DangerousPermissionUtil.isOpenSystemAppHiddenPermission(packageInfo.packageName, r12.getPermissions()) == true) goto L23;
    L32:
        if (r12.isSepicalPermission() == true) goto L34;
        List<String> r13 = DangerousPermissionUtil.filterPermission(r12, r4);     // Catch: PackageManager.NameNotFoundException -> L52
        if (r13 == null) goto L23;
        if (r13.size() <= 0) goto L23;
        r10.addNativePermission(r12);     // Catch: PackageManager.NameNotFoundException -> L52
    L36:
        r3 = true;
        goto L23
    L34:
        if (DangerousPermissionUtil.validSepicalPermission(context, r12, r4) == false) goto L23;
        r10.addNativePermission(r12);     // Catch: PackageManager.NameNotFoundException -> L52
        goto L36
    L42:
        if (r3 == true) goto L44;
        return null;
    L44:
        ApplicationInfo r14 = packageInfo.applicationInfo;     // Catch: PackageManager.NameNotFoundException -> L52
        LabelEntry r15 = ApplicationLabelCache.getInstance().getLabelEntry(pm, r14.packageName);     // Catch: PackageManager.NameNotFoundException -> L52
        if (r15 == null) goto L47;
        r10.setLabel(r15.label);     // Catch: PackageManager.NameNotFoundException -> L52
    L48:
        r10.setIcon(Utils.getResizedApkIcon(r14, pm));     // Catch: PackageManager.NameNotFoundException -> L52
        if (r10.mLabelEntry != null) goto L81;
        r10.ensureLabelEntry(pm);     // Catch: PackageManager.NameNotFoundException -> L52
        return r10;
    L81:
        return r10;
    L47:
        r10.setLabel(r14.loadLabel(pm).toString());     // Catch: PackageManager.NameNotFoundException -> L52
    L52:
        e = e;
        r0 = r10;
    L55:
        e.printStackTrace();
        return r0;
    L19:
        r4 = null;
    L54:
        e = e;
        goto L55
    }
}
