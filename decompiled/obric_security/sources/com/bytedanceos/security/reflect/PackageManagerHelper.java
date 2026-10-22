package com.bytedanceos.security.reflect;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class PackageManagerHelper {
    private PackageManager mPm;

    public PackageManagerHelper(PackageManager pm) {
        this.mPm = pm;
    }

    public List<PackageInfo> getInstalledPackages(int flags, int userId) {
        return (List) ReflectHelper.invokeProxyMethod("android.content.pm.PackageManager", "getInstalledPackagesAsUser", this.mPm, new Class[]{Integer.TYPE, Integer.TYPE}, new Object[]{Integer.valueOf(flags), Integer.valueOf(userId)});
    }
}
