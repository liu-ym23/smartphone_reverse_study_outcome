package tmsdkobf;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import tmsdk.common.OfflineVideo;
import tmsdk.common.creator.ManagerCreatorC;
import tmsdk.common.module.lang.MultiLangManager;

/* JADX INFO: loaded from: classes5.dex */
public class x9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    HashMap f615a;
    String[] b;
    final boolean c;

    class a implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ x9 f616a;

        a(x9 r1) {
            this.f616a = r1;
        }

        public int a(OfflineVideo r6, OfflineVideo r7) {
            int r5 = r6.getStatus();
            int r0 = r7.getStatus();
            if (r5 == r0) goto L8;
            if (r5 <= r0) goto L7;
            return -1;
        L7:
            return 1;
        L8:
            long r8 = r6.mSize;
            long r3 = r7.mSize;
            if (r8 != r3) goto L12;
            return 0;
        L12:
            if (r8 <= r3) goto L15;
            return -1;
        L15:
            return 1;
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(Object r1, Object r2) {
            return a((OfflineVideo) r1, (OfflineVideo) r2);
        }
    }

    public x9(String[] r4, boolean r5) {
        HashMap r0 = new HashMap();
        this.f615a = r0;
        this.c = r5;
        r0.put("youku", new og());
        this.f615a.put("qiyi", new ib());
        this.f615a.put("qqlive", new cb());
        this.f615a.put("sohu", new ie());
        this.f615a.put("storm", new pe(r5));
        this.b = r4;
    }

    private List a(List r1) {
        return r1;
    }

    private String[] a(String r7) {
        if (this.b != null) goto L5;
        return null;
    L5:
        String r8 = r7.toLowerCase();
        String[] r0 = this.b;
        int r2 = r0.length;
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L12;
        String r4 = r0[r3];
        if (r8.startsWith(r4) == true) goto L10;
        r3 = r3 + 1;
        goto L6
    L10:
        return b(r4);
    L12:
        return null;
    }

    private void c(List r2) {
        Collections.sort(r2, new a(this));
    }

    public String[] b(String r6) {
        q8.a("OfflineVideoScanner", "rootPath = " + r6);
        Map r5 = n8.a().a(r6, ((MultiLangManager) ManagerCreatorC.getManager(MultiLangManager.class)).isENG());
        if (r5 != null) goto L5;
        return null;
    L5:
        if (r5.size() == 0) goto L34;
        ArrayList r1 = new ArrayList();
        ArrayList r2 = new ArrayList();
        Iterator r3 = r5.keySet().iterator();
    L9:
        if (r3.hasNext() == false) goto L13;
        String r4 = (String) r3.next();
        r1.add(r4);     // Catch: Exception -> L26
        r2.add((String) r5.get(r4));     // Catch: Exception -> L26
        goto L9
    L13:
        v7 r7 = new v7();
        r7.a();
        String r8 = r7.a(r1);
        if (r8 != null) goto L19;
        int r9 = r7.b(r1);
        if (r9 != (-1)) goto L18;
        r9 = 0;
    L18:
        r8 = (String) r1.get(r9);
        String r10 = (String) r2.get(r9);
    L20:
        q8.a("OfflineVideoScanner", "pkg = " + r8 + ", app = " + r10);
        if (r10 == null) goto L33;
        if (r8 == null) goto L35;
        q8.b("xx", r8 + "  " + r10);
        return new String[]{r10.trim(), r8.trim()};
    L35:
        return null;
    L33:
        return null;
    L19:
        r10 = r7.a(r8);
        goto L20
    L34:
        return null;
    }

    private List b(List r6) {
        if (r6.size() != 0) goto L5;
        return r6;
    L5:
        ArrayList r0 = new ArrayList();
        ArrayList r1 = new ArrayList();
        Iterator r7 = r6.iterator();
        String r2 = null;
    L7:
        if (r7.hasNext() == false) goto L15;
        OfflineVideo r3 = (OfflineVideo) r7.next();
        if (r2 == null) goto L14;
        if (r2.equals(r3.mAdapter) == true) goto L14;
        c(r1);
        r0.addAll(r1);
        r1.clear();
    L14:
        r2 = r3.mAdapter;
        r1.add(r3);
        goto L7
    L15:
        c(r1);
        r0.addAll(r1);
        return r0;
    }

    public List a() {
        List r1 = wf.a();
        if (r1 != null) goto L5;
    L48:
        q8.a("OfflineVideoScanner", "rules.size() == 0");
        return null;
    L5:
        if (r1.size() == 0) goto L48;
        q8.a("OfflineVideoScanner", "rules.size() = " + r1.size());
        List r3 = ac.c();
        ArrayList r4 = new ArrayList();
        Iterator r2 = r1.iterator();
    L9:
        if (r2.hasNext() == false) goto L28;
        w9 r5 = (w9) r2.next();
        if (TextUtils.isEmpty(r5.n) == true) goto L9;
        v9 r8 = (v9) this.f615a.get(r5.n);
        q8.a("OfflineVideoScanner", "rule.mAdapter = " + r5.n);
        if (r8 == null) goto L9;
        List r9 = r8.a(r5);
        if (r9 == null) goto L9;
        if (r9.size() == 0) goto L9;
        String r10 = ac.a(((OfflineVideo) r9.get(0)).mPath, r3);
        String[] r11 = a(r10);
        q8.a("OfflineVideoScanner", "relativePath = " + r10);
        Iterator r12 = r9.iterator();
    L23:
        if (r12.hasNext() == false) goto L27;
        OfflineVideo r13 = (OfflineVideo) r12.next();
        r13.mAdapter = r5.n;
        r13.mPlayers = r5.m;
        if (r11 == null) goto L23;
        r13.mAppName = r11[0];
        r13.mPackage = r11[1];
        goto L23
    L27:
        r4.addAll(r9);
        goto L9
    L28:
        List r0 = b(a(r4));
        Iterator r6 = r0.iterator();
        long r7 = 0;
        long r14 = 0;
        long r15 = 0;
        int r16 = 0;
        int r17 = 0;
        int r18 = 0;
        int r19 = 0;
        long r20 = 0;
    L30:
        if (r6.hasNext() == false) goto L46;
        OfflineVideo r110 = (OfflineVideo) r6.next();
        int r21 = r110.getStatus();
        if (r21 == 0) goto L43;
        Iterator r111 = r6;
        if (r21 != 1) goto L36;
        r14 = r14 + r110.mSize;
        r17 = r17 + 1;
    L44:
        r6 = r111;
        r0 = r0;
        goto L30
    L36:
        if (r21 != 2) goto L38;
        r20 = r20 + r110.mSize;
        r18 = r18 + 1;
        goto L44
    L38:
        if (r21 == 3) goto L40;
        r6 = r111;
        goto L30
    L40:
        r15 = r15 + r110.mSize;
        r19 = r19 + 1;
        goto L44
    L43:
        r111 = r6;
        r7 = r7 + r110.mSize;
        r16 = r16 + 1;
        goto L44
    L46:
        List r22 = r0;
        q8.d("PiDeepClean", "EMID_Secure_DeepClean_OfflineVideo_ScanResult " + new StringBuilder().append((((r7 + r14) + r20) + r15) >> 10).append(",").append(((r16 + r17) + r18) + r19).append(",").append(r7 >> 10).append(",").append(r16).append(",").append(r14 >> 10).append(",").append(r17).append(",").append(r20 >> 10).append(",").append(r18).append(",").append(r15 >> 10).append(",").append(r19).toString());
        return r22;
    }
}
