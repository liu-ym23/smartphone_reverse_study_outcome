package d.d.a.a;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final C0436a f16535a = null;

    /* JADX INFO: renamed from: d.d.a.a.a$a, reason: collision with other inner class name */
    static final class C0436a implements Comparator<l.a.b.a> {
        C0436a() {
        }

        public int a(l.a.b.a r5, l.a.b.a r6) {
            if (r5.getStart() != r6.getStart()) goto L13;
            if (r5.size() >= r6.size()) goto L8;
            return 1;
        L8:
            if (r5.size() != r6.size()) goto L11;
            return 0;
        L11:
            return -1;
        L13:
            if (r5.getStart() >= r6.getStart()) goto L16;
            return -1;
        L16:
            if (r5.getStart() != r6.getStart()) goto L19;
            return 0;
        L19:
            return 1;
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(l.a.b.a r1, l.a.b.a r2) {
            return a(r1, r2);
        }
    }

    static {
        f16535a = new C0436a();
    }

    static String[] a(String r2, List<h> r3) {
        if (r3 == null) goto L15;
        Iterator<h> r4 = r3.iterator();
    L5:
        if (r4.hasNext() == false) goto L15;
        h r0 = r4.next();
        if (r0 == null) goto L5;
        if (r0.a() == null) goto L5;
        if (r0.a().contains(r2) == false) goto L5;
        return r0.b(r2);
    L15:
        throw new IllegalArgumentException("No pinyin dict contains word: " + r2);
    }

    static String b(String r6, l.a.b.c r7, List<h> r8, String r9, i r10) {
        if (r6 != null) goto L4;
        return r6;
    L4:
        if (r6.length() == 0) goto L52;
        int r0 = 0;
        if (r7 == null) goto L31;
        if (r10 == null) goto L31;
        List<l.a.b.a> r11 = r10.a(r7.h(r6));
        Collections.sort(r11, f16535a);
        StringBuffer r12 = new StringBuffer();
        int r1 = 0;
        int r2 = 0;
    L12:
        if (r1 >= r6.length()) goto L30;
        if (r2 < r11.size()) goto L16;
    L25:
        r12.append(c.f(r6.charAt(r1)));
        r1 = r1 + 1;
    L27:
        if (r1 == r6.length()) goto L12;
        r12.append(r9);
        goto L12
    L16:
        if (r1 != r11.get(r2).getStart()) goto L25;
        String[] r3 = a(r11.get(r2).a(), r8);
        int r4 = 0;
    L19:
        if (r4 >= r3.length) goto L24;
        r12.append(r3[r4].toUpperCase());
        if (r4 == (r3.length - 1)) goto L23;
        r12.append(r9);
    L23:
        r4 = r4 + 1;
        goto L19
    L24:
        r1 = r1 + r11.get(r2).size();
        r2 = r2 + 1;
        goto L27
    L30:
        return r12.toString();
    L31:
        StringBuffer r13 = new StringBuffer();
    L33:
        if (r0 >= r6.length()) goto L39;
        r13.append(c.f(r6.charAt(r0)));
        if (r0 == (r6.length() - 1)) goto L37;
        r13.append(r9);
    L37:
        r0 = r0 + 1;
        goto L33
    L39:
        return r13.toString();
    L52:
        return r6;
    }
}
