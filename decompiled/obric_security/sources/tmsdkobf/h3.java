package tmsdkobf;

import android.content.pm.PackageManager;
import android.text.TextUtils;
import java.io.File;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import tmsdk.common.TMSDKContext;
import tmsdk.fg.module.cleanV2.RubbishEntity;

/* JADX INFO: loaded from: classes5.dex */
public class h3 {
    public h3() {
    }

    private int b(m r2, Map r3) {
        m r1 = (m) r3.get(r2.k());
        if (r1 != null) goto L7;
        return -1;
    L7:
        if (r1.q() <= r2.q()) goto L11;
        return 2;
    L11:
        if (r1.q() != r2.q()) goto L14;
        return 0;
    L14:
        return 1;
    }

    protected RubbishEntity a(ad r12, boolean r13, String r14, long r15, Map r17, Map r18, List r19) {
        m r0 = n.a(true, r14);     // Catch: Throwable -> L5
    L7:
        if (r0 == null) goto L31;
        if (r0.k() == null) goto L31;
        a(r0);
        int r7 = b(r0, r18);
        String r8 = a(r12, r7);
        if (a(r0, r17) == false) goto L15;
        q8.c("CreateRubbishUtil", "________ findSameApk ________");
        RubbishEntity r10 = new RubbishEntity(2, r14, true, r15, r0.b(), r0.k(), tb.a("apk_repeated"));
        r10.setVersionCode(r0.q());
        return r10;
    L15:
        if (r8 != null) goto L17;
        String r9 = Integer.toString(r0.q());
    L18:
        boolean r1 = a(r12, r14, r19);
        if (2 != r7) goto L21;
        r1 = true;
    L21:
        if (r7 != 0) goto L23;
        boolean r4 = true;
    L24:
        if (r13 == false) goto L27;
        if (r4 == false) goto L34;
        RubbishEntity r11 = new RubbishEntity(2, r14, r4, r15, r0.b(), r0.k(), r9);
    L28:
        r11.setVersionCode(r0.q());
        return r11;
    L34:
        return null;
    L27:
        r11 = new RubbishEntity(2, r14, r4, r15, r0.b(), r0.k(), r9);
        goto L28
    L23:
        r4 = r1;
        goto L24
    L17:
        r9 = r8;
    L31:
        return new RubbishEntity(2, r14, true, r15, a(r14), null, tb.a("broken_apk"));
    L5:
        th = move-exception;
        q8.b("CreateRubbishUtil", th);
        r0 = null;
        goto L7
    }

    private boolean a(m r2, Map r3) {
        if (r2 == null) goto L14;
        if (r3 == null) goto L15;
        List r4 = (List) r3.get(r2.k());
        if (r4 != null) goto L10;
        return false;
    L10:
        if (r4.indexOf(Integer.valueOf(r2.q())) != (-1)) goto L12;
        return false;
    L12:
        return true;
    L15:
        return false;
    L14:
        return false;
    }

    private int[] b(String r4) {
        String[] r3 = r4.split(",");
        int[] r5 = new int[2];
        if (r3[0].equals("-") == false) goto L5;
        int r1 = Integer.MIN_VALUE;
    L6:
        r5[0] = r1;
        if (r3[1].equals("-") == false) goto L9;
        int r6 = Integer.MAX_VALUE;
    L10:
        r5[1] = r6;
        return r5;
    L9:
        r6 = Integer.parseInt(r3[1]);
        goto L10
    L5:
        r1 = Integer.parseInt(r3[0]);
        goto L6
    }

    private String a(ad r1, int r2) {
        if (r2 == (-1)) goto L16;
        if (r2 != 0) goto L6;
        String r0 = "apk_installed";
    L13:
        return tb.a(r0);
    L6:
        if (r2 != 1) goto L8;
        r0 = "apk_new_version";
        goto L13
    L8:
        if (r2 == 2) goto L11;
        return null;
    L11:
        r0 = "apk_old_version";
        goto L13
    L16:
        r0 = "apk_not_installed";
        goto L13
    }

    private String a(String r1) {
        int r0 = r1.lastIndexOf(File.separator);
        if (r0 >= 0) goto L5;
        return r1;
    L5:
        return r1.substring(r0 + 1);
    }

    private void a(m r3) {
        if (r3.b() != null) goto L11;
        PackageManager r2 = TMSDKContext.getApplicaionContext().getPackageManager();     // Catch: PackageManager.NameNotFoundException -> L6
        r3.b(r2.getApplicationLabel(r2.getApplicationInfo(r3.k(), 0)).toString());     // Catch: PackageManager.NameNotFoundException -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    private boolean a(ad r6, String r7, List r8) {
        List r9 = r6.o;
        if (r9 == null) goto L37;
        Iterator r10 = r9.iterator();
        String r1 = null;
    L6:
        if (r10.hasNext() == false) goto L10;
        String r2 = (String) r10.next();
        if (r7.startsWith(r2) == false) goto L6;
        r1 = r2;
        goto L6
    L10:
        if (r8 == null) goto L38;
        if (r1 == null) goto L39;
        long r3 = (Calendar.getInstance().getTimeInMillis() - new File(r7).lastModified()) / 86400000;
        Iterator r11 = r8.iterator();
    L14:
        if (r11.hasNext() == false) goto L40;
        kd r12 = (kd) r11.next();
        if (TextUtils.isEmpty(r12.e) == true) goto L14;
        int[] r13 = b(r12.e);
        if (r3 < r13[0]) goto L14;
        if (r3 > r13[1]) goto L14;
        return true;
    L40:
        return false;
    L39:
        return false;
    L38:
        return false;
    L37:
        return false;
    }
}
