package com.bytedance.bdlocation.utils.cell;

import android.annotation.SuppressLint;
import android.os.Build;
import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import androidx.annotation.Nullable;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.permission.PermissionManager;
import com.bytedance.bdlocation.service.BDLocationExtrasService;
import com.bytedance.bdlocation.thread.AppExecutors;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CellInfoUtil {
    public CellInfoUtil() {
    }

    @Nullable
    @SuppressLint({"MissingPermission"})
    public static List<CellInfo> getAllCellInfo(TelephonyManager r4, Object r5, boolean r6) {
        int r0 = Build.VERSION.SDK_INT;
        List<CellInfo> r1 = null;
        if (r4 != null) goto L17;
        return null;
    L17:
    L15:
        Logger.e("LocationInfoCollector#getAllCellInfo occur throwable !");
        return r1;
    L6:
        if (PermissionManager.hasAnyPermission(new String[]{"android.permission.ACCESS_FINE_LOCATION"}) == false) goto L19;
        if (r6 == false) goto L12;
        if (r0 < 29) goto L12;
        BDLocationExtrasService.getBPEAManager().requestCellInfoUpdate(r4, AppExecutors.getInstance().networkIO(), new AnonymousClass1(), r5);     // Catch: Throwable -> L15
    L12:
        if (r0 < 17) goto L20;
        long r2 = System.currentTimeMillis();     // Catch: Throwable -> L15
        r1 = BDLocationExtrasService.getBPEAManager().getAllCellInfo(r4, r5);     // Catch: Throwable -> L15
        Logger.i("getAllCellInfo duration:" + (System.currentTimeMillis() - r2));     // Catch: Throwable -> L15
        return r1;
    L20:
        return null;
    L19:
        return null;
    }

    @Nullable
    public static CellLocation getCellLocation(TelephonyManager r2, Object r3) {
        if (r2 != null) goto L6;
        return null;
    L6:
        if (PermissionManager.hasAnyPermission(new String[]{"android.permission.ACCESS_FINE_LOCATION"}) == true) goto L8;
        return null;
    L8:
        return BDLocationExtrasService.getBPEAManager().getCellLocation(r2, r3);
    }
}
