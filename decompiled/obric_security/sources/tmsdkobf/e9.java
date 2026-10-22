package tmsdkobf;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import tmsdk.common.TMSDKContext;
import tmsdk.common.module.update.UpdateConfig;

/* JADX INFO: loaded from: classes5.dex */
public class e9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List f175a;
    public List b;
    public List c;
    public List d;

    public static class a extends kd {
        public String[] m;
        public String n;

        public a() {
        }
    }

    public e9() {
        this.f175a = new ArrayList();
        this.b = new ArrayList();
        this.c = new ArrayList();
        this.d = new ArrayList();
    }

    private static List b(j2 r7) {
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
        a r6 = new a();
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

    public boolean a(Context r1) {
        return b(r1);
    }

    private static void a(List r2, a r3) {
        if (qe.b(r3.b) == false) goto L5;
        r2.add(r3);
        return;
    L5:
        int r0 = 0;
    L7:
        if (r0 >= r2.size()) goto L12;
        if (qe.b(((a) r2.get(r0)).b) == true) goto L12;
        r0 = r0 + 1;
    L12:
        r2.add(r0, r3);
    }

    private boolean b(Context r6) {
        k2 r7 = (k2) mg.b(TMSDKContext.getApplicaionContext(), UpdateConfig.PROCESSMANAGER_WHITE_LIST_NAME, UpdateConfig.intToString(40066), new k2(), "UTF-8");
        if (r7 == null) goto L43;
        ArrayList r8 = r7.f299a;
        if (r8 == null) goto L77;
        Iterator r9 = r8.iterator();
    L9:
        if (r9.hasNext() == false) goto L42;
        j2 r0 = (j2) r9.next();
        if (r0 == null) goto L9;
        if (TextUtils.isEmpty(r0.f281a) == true) goto L9;
        if (TextUtils.isEmpty(r0.b) == true) goto L9;
        int r2 = Integer.parseInt(r0.f281a);     // Catch: NumberFormatException -> L40
        int r3 = Integer.parseInt(r0.b);     // Catch: NumberFormatException -> L40
        if (r2 != 1) goto L20;
        if (r3 != 1) goto L9;
        String[] r1 = r0.c.split("&");     // Catch: NumberFormatException -> L40
        Collections.addAll(this.f175a, r1);     // Catch: NumberFormatException -> L40
        goto L9
    L20:
        if (r2 != 2) goto L22;
        if (r3 == 1) goto L27;
        if (r3 != 2) goto L9;
        List r4 = b(r0);     // Catch: NumberFormatException -> L40
        if (r4.isEmpty() == true) goto L9;
        Iterator r5 = r4.iterator();     // Catch: NumberFormatException -> L40
    L35:
        if (r5.hasNext() == false) goto L9;
        a r10 = (a) r5.next();     // Catch: NumberFormatException -> L40
        a(this.d, r10);     // Catch: NumberFormatException -> L40
        goto L35
    L27:
        a r11 = a(r0);     // Catch: NumberFormatException -> L40
        List r12 = this.c;     // Catch: NumberFormatException -> L40
    L28:
        a(r12, r11);     // Catch: NumberFormatException -> L40
        goto L9
    L22:
        if (r2 != 3) goto L9;
        if (r3 != 1) goto L9;
        r11 = a(r0);     // Catch: NumberFormatException -> L40
        r12 = this.b;     // Catch: NumberFormatException -> L40
    L40:
        e = move-exception;
        e.printStackTrace();
        goto L9
    L42:
        return true;
    L77:
        return false;
    L43:
        return false;
    }

    private static a a(j2 r9) {
        a r0 = new a();
        if (qe.c(r9.c) == false) goto L21;
        String[] r1 = r9.c.split("&");
        if (r1 == null) goto L21;
        int r3 = r1.length;
        int r5 = 0;
    L7:
        if (r5 >= r3) goto L21;
        String r6 = r1[r5];
        if (r6.length() <= 2) goto L19;
        char r7 = r6.charAt(0);
        String r8 = r6.substring(2);
        switch(r7) {
            case 49: goto L18;
            case 50: goto L17;
            case 51: goto L16;
            case 52: goto L15;
            case 53: goto L14;
            default: goto L19;
        };
    L14:
        r0.g = r8;
        goto L19
    L15:
        r0.f = r8;
        goto L19
    L16:
        r0.e = r8;
        goto L19
    L17:
        r0.d = r8;
        goto L19
    L18:
        r0.c = r8;
    L19:
        r5 = r5 + 1;
    L21:
        if (qe.c(r9.d) == false) goto L24;
        r0.n = r9.d;
    L24:
        if (qe.c(r9.e) == false) goto L26;
        r0.m = r9.e.split("&");
    L26:
        return r0;
    }
}
