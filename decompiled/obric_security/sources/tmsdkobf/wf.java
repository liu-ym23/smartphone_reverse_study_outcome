package tmsdkobf;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tmsdk.common.TMSDKContext;
import tmsdk.common.module.update.UpdateConfig;

/* JADX INFO: loaded from: classes5.dex */
public abstract class wf {
    private static void a(List r2, w9 r3) {
        if (TextUtils.isEmpty(r3.b) == false) goto L5;
        r2.add(r3);
        return;
    L5:
        int r0 = 0;
    L7:
        if (r0 >= r2.size()) goto L12;
        if (TextUtils.isEmpty(((w9) r2.get(r0)).b) == true) goto L12;
        r0 = r0 + 1;
    L12:
        r2.add(r0, r3);
    }

    private static List a(j2 r7) {
        ArrayList r0 = new ArrayList();
        if (qe.b(r7.c) == false) goto L5;
        return r0;
    L5:
        String[] r1 = r7.c.split("&");
        int r3 = r1.length;
        int r4 = 0;
    L6:
        if (r4 >= r3) goto L14;
        String r5 = r1[r4];
        w9 r6 = new w9();
        r6.b = r5;
        if (qe.c(r7.d) == false) goto L11;
        r6.n = r7.d;
    L11:
        if (qe.c(r7.e) == false) goto L13;
        r6.m = r7.e.split("&");
    L13:
        r0.add(r6);
        r4 = r4 + 1;
        goto L6
    L14:
        return r0;
    }

    public static List a() {
        k2 r0 = (k2) mg.b(TMSDKContext.getApplicaionContext(), UpdateConfig.PROCESSMANAGER_WHITE_LIST_NAME, UpdateConfig.intToString(40066), new k2(), "UTF-8");
        ArrayList r1 = new ArrayList();
        if (r0 == null) goto L31;
        ArrayList r2 = r0.f299a;
        if (r2 == null) goto L31;
        Iterator r3 = r2.iterator();
    L9:
        if (r3.hasNext() == false) goto L31;
        j2 r4 = (j2) r3.next();
        if (r4 == null) goto L9;
        if (TextUtils.isEmpty(r4.f281a) == true) goto L9;
        if (TextUtils.isEmpty(r4.b) == true) goto L9;
        int r5 = Integer.parseInt(r4.f281a);     // Catch: NumberFormatException -> L29
        int r6 = Integer.parseInt(r4.b);     // Catch: NumberFormatException -> L29
        if (r5 != 2) goto L9;
        if (r6 != 2) goto L9;
        List r7 = a(r4);     // Catch: NumberFormatException -> L29
        if (r7.isEmpty() == true) goto L9;
        Iterator r8 = r7.iterator();     // Catch: NumberFormatException -> L29
    L26:
        if (r8.hasNext() == false) goto L9;
        a(r1, (w9) r8.next());     // Catch: NumberFormatException -> L29
    L29:
        e = move-exception;
        e.printStackTrace();
    L31:
        return r1;
    }
}
