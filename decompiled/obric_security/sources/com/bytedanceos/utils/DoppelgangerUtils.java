package com.bytedanceos.utils;

import android.R;
import android.app.ActivityManager;
import android.app.AppGlobals;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.IPackageManager;
import android.content.pm.ParceledListSlice;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Binder;
import android.os.UserHandle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class DoppelgangerUtils {
    public static final int DEFAULT_ICON_SIZE = 76;
    public static final String EXTRA_HAD_CHOOSE = "com.bytedanceos.doppelganger.had_choose";
    private static final Set<String> SPECIAL_KEYS = null;
    public static Paint paint;

    public static int adjustDoppelgangerUser(int callingUserId) {
        if (callingUserId != 10) goto L6;
        return 0;
    L6:
        return callingUserId;
    }

    static {
        Paint r0 = new Paint();
        paint = r0;
        r0.setAntiAlias(true);
        paint.setFilterBitmap(true);
        SPECIAL_KEYS = new HashSet(Arrays.asList(new String[]{"selected_spell_checker"}));
    }

    public DoppelgangerUtils() {
    }

    public static Bitmap getDoppelgangerBitmap(Bitmap bitmap) {
        if (bitmap != null) goto L5;
        return null;
    L5:
        int r1 = bitmap.getHeight();
        Resources.Theme r3 = (Resources.Theme) null;
        Drawable r0 = Resources.getSystem().getDrawable(R.drawable.ic_media_route_off_holo_light, null);
        Bitmap r2 = bitmap.copy(Bitmap.Config.ARGB_8888, true);
        Canvas r4 = new Canvas(r2);
        r4.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        int r7 = (r0.getIntrinsicWidth() * r1) / dp2Pixels(76.0f);
        int r6 = (r0.getIntrinsicHeight() * r1) / dp2Pixels(76.0f);
        r0.setBounds(0, 0, r7, r6);
        r4.translate(0.0f, r1 - r6);
        r0.draw(r4);
        return r2;
    }

    private static final int dp2Pixels(float dip) {
        return (int) ((dip * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    public static ApplicationInfo getApplicationInfo(IPackageManager pm, String packageName, int flags) {
        return pm.getApplicationInfo(packageName, flags, 0);
    L5:
        e = move-exception;
        throw e.rethrowFromSystemServer();
    }

    public static ParceledListSlice<ResolveInfo> queryIntentServicesAsUser(IPackageManager pm, Context context, Intent intent, int flags) {
        return pm.queryIntentServices(intent, intent.resolveTypeIfNeeded(context.getContentResolver()), flags, 0);
    L4:
        e = move-exception;
        throw e.rethrowFromSystemServer();
    }

    public static ProviderInfo resolveContentProvider(String authority) {
        return AppGlobals.getPackageManager().resolveContentProvider(authority, 790016, 0);
    L4:
        e = move-exception;
        throw e.rethrowFromSystemServer();
    }

    public static void computeGidsForProcess(ArrayList<Integer> gidList, int uid) {
        int r0 = UserHandle.getUserGid(0);
        int r2 = UserHandle.getUserGid(10);
        int r4 = UserHandle.getUserId(uid);
        if (r4 != 0) goto L5;
        gidList.add(Integer.valueOf(r2));
        return;
    L5:
        if (r4 != 10) goto L9;
        gidList.add(Integer.valueOf(r0));
        return;
    }

    public static int adjustDoppelgangerUser(int callingUserId, String name) {
        if (SPECIAL_KEYS.contains(name) == false) goto L6;
        return callingUserId;
    L6:
        if (callingUserId != 10) goto L9;
        return 0;
    L9:
        return callingUserId;
    }

    public static int resolveCallingUserIdEnforcingPermissionsLocked(int requestingUserId, String name) {
        if (requestingUserId == UserHandle.getCallingUserId()) goto L5;
        String r2 = (String) null;
        return adjustDoppelgangerUser(ActivityManager.handleIncomingUser(Binder.getCallingPid(), Binder.getCallingUid(), requestingUserId, false, true, "get/set setting for user", null), name);
    L5:
        return adjustDoppelgangerUser(requestingUserId, name);
    }
}
