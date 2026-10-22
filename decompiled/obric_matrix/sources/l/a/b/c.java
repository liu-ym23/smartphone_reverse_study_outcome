package l.a.b;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d f21496a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private l.a.b.b f21497b;

    static /* synthetic */ class a {
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private d f21498a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private c f21499b;

        private b() {
            d r0 = new d();
            this.f21498a = r0;
            this.f21499b = new c(r0, null);
        }

        /* synthetic */ b(a r1) {
            this();
        }

        public b a(String r2) {
            c.a(this.f21499b, r2);
            return this;
        }

        public c b() {
            c.b(this.f21499b);
            return this.f21499b;
        }
    }

    private c(d r1) {
        this.f21496a = r1;
        this.f21497b = new l.a.b.b();
    }

    /* synthetic */ c(d r1, a r2) {
        this(r1);
    }

    static /* synthetic */ void a(c r0, String r1) {
        r0.c(r1);
    }

    static /* synthetic */ void b(c r0) {
        r0.e();
    }

    private void c(String r7) {
        if (r7 != null) goto L4;
        return;
    L4:
        if (r7.length() == 0) goto L21;
        l.a.b.b r0 = this.f21497b;
        char[] r1 = r7.toCharArray();
        int r2 = r1.length;
        int r3 = 0;
    L7:
        if (r3 >= r2) goto L13;
        Character r4 = Character.valueOf(r1[r3]);
        if (this.f21496a.b() == false) goto L11;
        r4 = Character.valueOf(Character.toLowerCase(r4.charValue()));
    L11:
        r0 = r0.c(r4);
        r3 = r3 + 1;
        goto L7
    L13:
        if (this.f21496a.b() == false) goto L15;
        r7 = r7.toLowerCase();
    L15:
        r0.a(r7);
        return;
    }

    public static b d() {
        return new b(null);
    }

    private void e() {
        LinkedBlockingDeque r0 = new LinkedBlockingDeque();
        Iterator<l.a.b.b> r1 = this.f21497b.f().iterator();
    L4:
        if (r1.hasNext() == false) goto L7;
        l.a.b.b r2 = r1.next();
        r2.k(this.f21497b);
        r0.add(r2);
    L7:
        if (r0.isEmpty() == true) goto L16;
        l.a.b.b r6 = (l.a.b.b) r0.remove();
        Iterator<Character> r3 = r6.g().iterator();
    L10:
        if (r3.hasNext() == false) goto L7;
        Character r4 = r3.next();
        l.a.b.b r5 = r6.h(r4);
        r0.add(r5);
        l.a.b.b r7 = r6.e();
    L13:
        if (r7.h(r4) != null) goto L15;
        r7 = r7.e();
        goto L13
    L15:
        l.a.b.b r8 = r7.h(r4);
        r5.k(r8);
        r5.b(r8.d());
        goto L10
    }

    private l.a.b.b f(l.a.b.b r1, Character r2) {
    L2:
        l.a.b.b r0 = r1.h(r2);
        if (r0 != null) goto L5;
        r1 = r1.e();
        goto L2
    L5:
        return r0;
    }

    private boolean g(CharSequence r3, l.a.b.a r4) {
        if (r4.getStart() == 0) goto L7;
        if (Character.isAlphabetic(r3.charAt(r4.getStart() - 1)) == false) goto L7;
        return true;
    L7:
        if ((r4.h() + 1) != r3.length()) goto L9;
    L11:
        return false;
    L9:
        if (Character.isAlphabetic(r3.charAt(r4.h() + 1)) == false) goto L11;
        return true;
    }

    private void j(CharSequence r5, List<l.a.b.a> r6) {
        ArrayList r0 = new ArrayList();
        Iterator<l.a.b.a> r1 = r6.iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        l.a.b.a r2 = r1.next();
        if (g(r5, r2) == false) goto L4;
        r0.add(r2);
        goto L4
    L8:
        Iterator r4 = r0.iterator();
    L10:
        if (r4.hasNext() == false) goto L12;
        r6.remove((l.a.b.a) r4.next());
        goto L10
    }

    private void k(CharSequence r7, List<l.a.b.a> r8) {
        long r0 = r7.length();
        ArrayList r6 = new ArrayList();
        Iterator<l.a.b.a> r2 = r8.iterator();
    L4:
        if (r2.hasNext() == false) goto L15;
        l.a.b.a r3 = r2.next();
        if (r3.getStart() == 0) goto L10;
        if (Character.isWhitespace(r7.charAt(r3.getStart() - 1)) == true) goto L10;
    L14:
        r6.add(r3);
    L10:
        if ((r3.h() + 1) == r0) goto L4;
        if (Character.isWhitespace(r7.charAt(r3.h() + 1)) == false) goto L14;
    L15:
        Iterator r9 = r6.iterator();
    L17:
        if (r9.hasNext() == false) goto L19;
        r8.remove((l.a.b.a) r9.next());
        goto L17
    }

    private boolean l(int r4, l.a.b.b r5, l.a.b.e.b r6) {
        Collection<String> r3 = r5.d();
        boolean r7 = false;
        if (r3 != null) goto L5;
    L10:
        return r7;
    L5:
        if (r3.isEmpty() == true) goto L10;
        Iterator<String> r8 = r3.iterator();
    L8:
        if (r8.hasNext() == false) goto L10;
        String r9 = r8.next();
        r6.a(new l.a.b.a((r4 - r9.length()) + 1, r4, r9));
        r7 = true;
        goto L8
    }

    public Collection<l.a.b.a> h(CharSequence r3) {
        l.a.b.e.a r0 = new l.a.b.e.a();
        i(r3, r0);
        List<l.a.b.a> r1 = r0.b();
        if (this.f21496a.c() == false) goto L6;
        j(r3, r1);
    L6:
        if (this.f21496a.d() == false) goto L9;
        k(r3, r1);
    L9:
        if (this.f21496a.a() == true) goto L11;
        new l.a.a.c(r1).b(r1);
    L11:
        return r1;
    }

    public void i(CharSequence r5, l.a.b.e.b r6) {
        l.a.b.b r0 = this.f21497b;
        int r1 = 0;
    L4:
        if (r1 >= r5.length()) goto L14;
        Character r2 = Character.valueOf(r5.charAt(r1));
        if (this.f21496a.b() == false) goto L8;
        r2 = Character.valueOf(Character.toLowerCase(r2.charValue()));
    L8:
        r0 = f(r0, r2);
        if (l(r1, r0, r6) == false) goto L13;
        if (this.f21496a.e() == false) goto L13;
        return;
    L13:
        r1 = r1 + 1;
        goto L4
    }
}
