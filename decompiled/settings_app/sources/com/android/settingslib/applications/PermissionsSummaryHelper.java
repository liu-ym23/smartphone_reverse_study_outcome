package com.android.settingslib.applications;

import android.content.Context;
import android.permission.PermissionControllerManager;
import android.permission.RuntimePermissionPresentationInfo;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class PermissionsSummaryHelper {

    public interface PermissionsResultCallback {
        void onPermissionSummaryResult(int r1, int r2, List<CharSequence> r3);
    }

    public PermissionsSummaryHelper() {
    }

    public static void getPermissionSummary(Context r1, String r2, final PermissionsResultCallback r3) {
        ((PermissionControllerManager) r1.getSystemService(PermissionControllerManager.class)).getAppPermissions(r2, new PermissionsSummaryHelper$$ExternalSyntheticLambda0(r3), null);
    }

    static /* synthetic */ void lambda$getPermissionSummary$0(PermissionsResultCallback r6, List r7) {
        List<CharSequence> r0 = new ArrayList();
        Iterator r8 = r7.iterator();
        int r2 = 0;
        int r3 = 0;
    L4:
        if (r8.hasNext() == false) goto L11;
        RuntimePermissionPresentationInfo r4 = (RuntimePermissionPresentationInfo) r8.next();
        r2 = r2 + 1;
        if (r4.isGranted() == false) goto L4;
        if (r4.isStandard() == true) goto L9;
        r3 = r3 + 1;
        goto L4
    L9:
        r0.add(r4.getLabel());
        goto L4
    L11:
        Collator r9 = Collator.getInstance();
        r9.setStrength(0);
        r0.sort(r9);
        r6.onPermissionSummaryResult(r2, r3, r0);
    }
}
