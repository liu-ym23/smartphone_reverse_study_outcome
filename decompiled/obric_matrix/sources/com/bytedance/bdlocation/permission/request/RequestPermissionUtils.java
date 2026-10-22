package com.bytedance.bdlocation.permission.request;

import android.app.Activity;
import android.content.Context;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class RequestPermissionUtils {

    public interface OnPermissionListener {
        void onPermissionDenied();

        void onPermissionGranted();
    }

    public RequestPermissionUtils() {
    }

    static /* synthetic */ boolean access$000(int[] r0) {
        return verifyPermissions(r0);
    }

    private static List<String> getDeniedPermissions(Context r6, String... r7) {
        if (r6 != null) goto L5;
        return null;
    L5:
        ArrayList r0 = new ArrayList();
        int r1 = r7.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L11;
        String r3 = r7[r2];
        if (ContextCompat.checkSelfPermission(r6, r3) != (-1)) goto L10;
        r0.add(r3);
    L10:
        r2 = r2 + 1;
        goto L6
    L11:
        return r0;
    }

    public static void requestPermissionsLimited(Activity r1, String[] r2, final OnPermissionListener r3) {
        if (r1 == null) goto L11;
        List<String> r0 = getDeniedPermissions(r1, r2);
        if (r0 != null) goto L6;
    L8:
        if (r3 == null) goto L13;
        r3.onPermissionGranted();
        return;
    L13:
        return;
    L6:
        if (r0.isEmpty() == true) goto L8;
        Permissions.requestPermissions(r1, r2, new AnonymousClass1(r3));
        return;
    }

    private static boolean verifyPermissions(int[] r4) {
        int r0 = r4.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L8;
        if (r4[r2] != 0) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }
}
