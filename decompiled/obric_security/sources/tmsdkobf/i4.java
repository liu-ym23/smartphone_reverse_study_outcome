package tmsdkobf;

import android.text.TextUtils;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedanceos.utils.Constants;
import com.qq.taf.jce.JceStruct;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import obric.view.WindowManagerHelper;
import tmsdk.common.TMSDKContext;
import tmsdk.common.TMServiceFactory;

/* JADX INFO: loaded from: classes5.dex */
public abstract class i4 {

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f260a;

        a(List r1) {
            this.f260a = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            i4.a(this.f260a);     // Catch: Throwable -> L4
            return;
        }
    }

    class b implements FileFilter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String[] f261a;

        b(String[] r1) {
            this.f261a = r1;
        }

        @Override // java.io.FileFilter
        public boolean accept(File r8) {
        L14:
            th = move-exception;
            r8.b("DyncOp", th.getMessage());
        L16:
            return false;
        L4:
            if (r8.isDirectory() == false) goto L7;
            return true;
        L7:
            if (r8.isFile() == false) goto L16;
            String r9 = r8.getAbsolutePath().toLowerCase();     // Catch: Throwable -> L14
            String[] r7 = this.f261a;     // Catch: Throwable -> L14
            int r1 = r7.length;     // Catch: Throwable -> L14
            int r3 = 0;
        L9:
            if (r3 >= r1) goto L16;
            if (r9.endsWith(LibrarianImpl.Constants.DOT + r7[r3]) == true) goto L12;
            r3 = r3 + 1;
            goto L9
        L12:
            return true;
        }
    }

    class c implements x4.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f262a;
        final /* synthetic */ ArrayList b;

        c(String r1, ArrayList r2) {
            this.f262a = r1;
            this.b = r2;
        }

        @Override // tmsdkobf.x4.a
        public boolean a(File r4) {
            if (r4 == null) goto L13;
        L7:
            th = move-exception;
            r8.b("DyncOp", th.getMessage());
            return false;
        L4:
            if (r4.exists() == false) goto L14;
            g r0 = new g();     // Catch: Throwable -> L7
            r0.b = r4.getName();     // Catch: Throwable -> L7
            r0.c = r4.length();     // Catch: Throwable -> L7
            r0.d = r4.lastModified();     // Catch: Throwable -> L7
            r0.f263a = x4.a(r4);     // Catch: Throwable -> L7
            r0.e = this.f262a;     // Catch: Throwable -> L7
            this.b.add(r0);     // Catch: Throwable -> L7
            return false;
        L14:
            return false;
        L13:
            return false;
        }
    }

    class d implements Comparator {
        d() {
        }

        public int a(g r3, g r4) {
            long r2 = r3.d;
            long r0 = r4.d;
            if (r2 <= r0) goto L6;
            return -1;
        L6:
            if (r2 >= r0) goto L9;
            return 1;
        L9:
            return 0;
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(Object r1, Object r2) {
            return a((g) r1, (g) r2);
        }
    }

    class e implements w6 {
        e() {
        }

        @Override // tmsdkobf.w6
        public void onFinish(int r1, int r2, int r3, int r4, JceStruct r5) {
        }
    }

    class f implements w6 {
        f() {
        }

        @Override // tmsdkobf.w6
        public void onFinish(int r1, int r2, int r3, int r4, JceStruct r5) {
        }
    }

    static class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f263a;
        public String b;
        public long c;
        public long d;
        public String e;

        g() {
            this.f263a = "";
            this.b = "";
            this.c = 0;
            this.d = 0;
            this.e = "";
        }
    }

    static void a(List r24) {
        String r1 = "2009";
        Iterator r4 = r24.iterator();
    L4:
        if (r4.hasNext() == false) goto L157;
        String[] r5 = ((String) r4.next()).split(";");     // Catch: Throwable -> L155
        if (r5 == null) goto L4;
        int r6 = 1;
        if (r5.length <= 1) goto L4;
        int r0 = d3.c(r5[0]);     // Catch: Throwable -> L155
        if (r0 == 10) goto L146;
        if (r0 == 11) goto L139;
        if (r0 == 20) goto L114;
        if (r0 != 50) goto L4;
    L30:
        th = move-exception;
        r8.b("DyncOp", th.getMessage());     // Catch: Throwable -> L155
    L177:
    L38:
        th = move-exception;
        r8.b("DyncOp", th.getMessage());     // Catch: Throwable -> L155
    L40:
        String[] r9 = null;
    L165:
    L47:
        th = move-exception;
        r8.b("DyncOp", th.getMessage());     // Catch: Throwable -> L155
    L49:
        int r2 = 500;
    L50:
        int r13 = r2;
        String r14 = "";
    L57:
        th = move-exception;
        r8.b("DyncOp", th.getMessage());     // Catch: Throwable -> L155
    L59:
        ArrayList r15 = new ArrayList();     // Catch: Throwable -> L155
        if (r9 != null) goto L171;
    L70:
        b r7 = null;
    L71:
        x4.a(r5[1], r7, new c(r14, r15));     // Catch: Throwable -> L73
    L175:
        if (r15.size() <= 0) goto L77;
        if (r15.size() <= r13) goto L81;
        Collections.sort(r15, new d());     // Catch: Throwable -> L110
    L81:
        e1 r3 = new e1(2009, new ArrayList());     // Catch: Throwable -> L110
        StringBuilder r8 = new StringBuilder();     // Catch: Throwable -> L110
        StringBuilder r10 = new StringBuilder();     // Catch: Throwable -> L110
        StringBuilder r11 = new StringBuilder();     // Catch: Throwable -> L110
        StringBuilder r12 = new StringBuilder();     // Catch: Throwable -> L110
        StringBuilder r16 = new StringBuilder();     // Catch: Throwable -> L110
        Iterator r17 = r15.iterator();     // Catch: Throwable -> L110
        StringBuilder r18 = r12;
        StringBuilder r19 = r16;
        StringBuilder r20 = r10;
        StringBuilder r110 = r11;
        int r21 = 0;
        StringBuilder r22 = r8;
        int r23 = 0;
    L83:
        if (r17.hasNext() == false) goto L98;
        g r111 = (g) r17.next();     // Catch: Throwable -> L110
        int r25 = r23 + r6;     // Catch: Throwable -> L110
        if (r25 > r13) goto L98;
        r1 = r1;
        r22.append(new StringBuilder().append(r111.f263a).append(";").toString());     // Catch: Throwable -> L96
        r20.append(r111.b + ";");     // Catch: Throwable -> L96
        r4 = r4;
        r23 = r25;
        r110.append(new StringBuilder().append(r111.c).append(";").toString());     // Catch: Throwable -> L108
        r18.append(r111.d + ";");     // Catch: Throwable -> L108
        r19.append(r111.e + ";");     // Catch: Throwable -> L108
        r21 = r21 + 1;     // Catch: Throwable -> L108
        if (r21 < 100) goto L94;
        ob r26 = new ob(new HashMap());     // Catch: Throwable -> L108
        r26.f394a.put(1, r22.toString());     // Catch: Throwable -> L108
        r26.f394a.put(2, r20.toString());     // Catch: Throwable -> L108
        r26.f394a.put(3, r110.toString());     // Catch: Throwable -> L108
        r26.f394a.put(4, r18.toString());     // Catch: Throwable -> L108
        r26.f394a.put(5, r19.toString());     // Catch: Throwable -> L108
        r3.b.add(r26);     // Catch: Throwable -> L108
        r22 = new StringBuilder();     // Catch: Throwable -> L108
        r20 = new StringBuilder();     // Catch: Throwable -> L108
        r110 = new StringBuilder();     // Catch: Throwable -> L108
        r18 = new StringBuilder();     // Catch: Throwable -> L108
        r19 = new StringBuilder();     // Catch: Throwable -> L108
        r6 = 1;
        r21 = 0;
        goto L83
    L94:
        r6 = 1;
    L108:
        th = th;
    L173:
        r8.b("DyncOp", th.getMessage());     // Catch: Throwable -> L158
    L156:
        r4 = r4;
        r1 = r1;
    L96:
        th = th;
    L112:
        r4 = r4;
    L98:
        r1 = r1;
        r4 = r4;
        if (r21 > 0) goto L101;
    L103:
        za r112 = ve.e();     // Catch: Throwable -> L108
        if (r3.b.size() <= 0) goto L156;
        if (r112 == null) goto L156;
        r112.a(4060, r3, null, 0, new e());     // Catch: Throwable -> L108
        goto L156
    L101:
        if (TextUtils.isEmpty(r22.toString()) == true) goto L103;
        ob r27 = new ob(new HashMap());     // Catch: Throwable -> L108
        r27.f394a.put(1, r22.toString());     // Catch: Throwable -> L108
        r27.f394a.put(2, r20.toString());     // Catch: Throwable -> L108
        r27.f394a.put(3, r110.toString());     // Catch: Throwable -> L108
        r27.f394a.put(4, r18.toString());     // Catch: Throwable -> L108
        r27.f394a.put(5, r19.toString());     // Catch: Throwable -> L108
        r3.b.add(r27);     // Catch: Throwable -> L108
        goto L103
    L77:
        e1 r28 = new e1(WindowManagerHelper.LayoutParamsSmt.TYPE_BYTEDANCE_CONTEXT_MENU, new ArrayList());     // Catch: Throwable -> L110
        ob r29 = new ob(new HashMap());     // Catch: Throwable -> L110
        r29.f394a.put(1, r1);     // Catch: Throwable -> L110
        r29.f394a.put(2, "11,[fileItemlist.size() <= 0]");     // Catch: Throwable -> L110
        r28.b.add(r29);     // Catch: Throwable -> L110
        a(r28);     // Catch: Throwable -> L110
    L110:
        th = th;
        r1 = r1;
        goto L112
    L171:
        if (r9.length <= 0) goto L70;
        int r30 = r9.length;     // Catch: Throwable -> L73
        int r31 = 0;
    L64:
        if (r31 >= r30) goto L69;
        if (r9[r31].compareToIgnoreCase("*") == 0) goto L70;
        r31 = r31 + 1;     // Catch: Throwable -> L73
        goto L64
    L69:
        r7 = new b(r9);     // Catch: Throwable -> L73
        goto L71
    L73:
        th = move-exception;
        r8.b("DyncOp", th.getMessage());     // Catch: Throwable -> L155
        goto L175
    L52:
        if (r5.length <= 4) goto L59;
        if (TextUtils.isEmpty(r5[4]) == true) goto L59;
        r14 = r5[4];     // Catch: Throwable -> L57
    L42:
        if (r5.length <= 3) goto L49;
        if (TextUtils.isEmpty(r5[3]) == true) goto L49;
        r2 = d3.c(r5[3]);     // Catch: Throwable -> L47
    L33:
        if (r5.length <= 2) goto L40;
        if (TextUtils.isEmpty(r5[2]) == true) goto L40;
        r9 = r5[2].split("|");     // Catch: Throwable -> L38
        goto L165
    L23:
        if (r5.length <= 1) goto L4;
        if (TextUtils.isEmpty(r5[1]) == true) goto L4;
        if (new File(r5[1]).exists() == true) goto L177;
        e1 r32 = new e1(WindowManagerHelper.LayoutParamsSmt.TYPE_BYTEDANCE_CONTEXT_MENU, new ArrayList());     // Catch: Throwable -> L30
        ob r113 = new ob(new HashMap());     // Catch: Throwable -> L30
        r113.f394a.put(1, r1);     // Catch: Throwable -> L30
        r113.f394a.put(2, "11,[" + r5[1] + " not exists]");     // Catch: Throwable -> L30
        r32.b.add(r113);     // Catch: Throwable -> L30
        a(r32);     // Catch: Throwable -> L30
    L114:
        r1 = r1;
        r4 = r4;
        if (r5.length < 5) goto L156;
        if (TextUtils.isEmpty(r5[1]) == true) goto L156;
        if (TextUtils.isEmpty(r5[2]) == true) goto L156;
        if (TextUtils.isEmpty(r5[3]) == true) goto L156;
        if (TextUtils.isEmpty(r5[4]) == true) goto L156;
        p6 r33 = TMServiceFactory.getPreferenceService(r5[1]);     // Catch: Throwable -> L158
        if (r5[4].compareToIgnoreCase("Int") != 0) goto L128;
        r33.putInt(r5[2], d3.c(r5[3]));     // Catch: Throwable -> L158
        goto L156
    L128:
        if (r5[4].compareToIgnoreCase("String") != 0) goto L131;
        r33.putString(r5[2], r5[3]);     // Catch: Throwable -> L158
        goto L156
    L131:
        if (r5[4].compareToIgnoreCase("Boolean") != 0) goto L156;
        if (r5[3].compareToIgnoreCase(Constants.IS_SET) != 0) goto L137;
        String r34 = r5[2];     // Catch: Throwable -> L158
        boolean r35 = true;
    L135:
        r33.putBoolean(r34, r35);     // Catch: Throwable -> L158
        goto L156
    L137:
        if (r5[3].compareToIgnoreCase("false") != 0) goto L156;
        r34 = r5[2];     // Catch: Throwable -> L158
        r35 = false;
        goto L135
    L139:
        r1 = r1;
        r4 = r4;
        if (r5.length <= 1) goto L156;
        if (TextUtils.isEmpty(r5[1]) == true) goto L156;
        File r36 = TMSDKContext.getApplicaionContext().getDir(r5[1], 0);     // Catch: Throwable -> L158
        if (r36.exists() == false) goto L156;
        z4.a(r36);     // Catch: Throwable -> L158
        String r37 = r36.getAbsolutePath();     // Catch: Throwable -> L158
    L153:
        z4.b(r37);     // Catch: Throwable -> L158
        goto L156
    L146:
        r1 = r1;
        r4 = r4;
        if (r5.length <= 1) goto L156;
        if (TextUtils.isEmpty(r5[1]) == true) goto L156;
        r37 = TMSDKContext.getApplicaionContext().getFilesDir().getAbsolutePath() + File.separator + r5[1];     // Catch: Throwable -> L158
        File r38 = new File(r37);     // Catch: Throwable -> L158
        if (r38.exists() == false) goto L156;
        z4.a(r38);     // Catch: Throwable -> L158
    L155:
        r1 = r1;
        r4 = r4;
        goto L156
    }

    public static synchronized void b(List r3) {
        monitor-enter(i4.class);
        ve.f().a(new a(r3), "do_dync");     // Catch: Throwable -> L7
        monitor-exit(i4.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    static void a(e1 r6) {
        ve.e().a(4060, r6, null, 0, new f());     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        r8.b("DyncOp", th.getMessage());
    }
}
