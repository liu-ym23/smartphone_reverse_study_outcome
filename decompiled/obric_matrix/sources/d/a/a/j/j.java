package d.a.a.j;

import java.lang.reflect.Member;
import java.util.Collection;

/* JADX INFO: loaded from: classes.dex */
public final class j implements Comparable<j> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final d.a.a.k.a f12482f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected final boolean f12483g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected final int f12484h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected final String f12485i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected char[] f12486j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private a f12487k;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        t f12488a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Class<?> f12489b;

        public a(t r1, Class<?> r2) {
            this.f12488a = r1;
            this.f12489b = r2;
        }
    }

    public j(d.a.a.k.a r11) {
        this.f12482f = r11;
        d.a.a.h.b r0 = r11.g();
        String r1 = null;
        if (r0 == null) goto L15;
        a0[] r4 = r0.serialzeFeatures();
        int r5 = r4.length;
        int r6 = 0;
        boolean r7 = false;
    L5:
        if (r6 >= r5) goto L10;
        if (r4[r6] != a0.f12467i) goto L9;
        r7 = true;
    L9:
        r6 = r6 + 1;
        goto L5
    L10:
        String r8 = r0.format().trim();
        if (r8.length() == 0) goto L14;
        r1 = r8;
    L14:
        this.f12484h = a0.a(r0.serialzeFeatures());
    L16:
        this.f12483g = r7;
        this.f12485i = r1;
        String r12 = r11.f12528f;
        int r2 = r12.length();
        this.f12486j = new char[r2 + 3];
        r12.getChars(0, r12.length(), this.f12486j, 1);
        char[] r10 = this.f12486j;
        r10[0] = '\"';
        r10[r2 + 1] = '\"';
        r10[r2 + 2] = ':';
        return;
    L15:
        this.f12484h = 0;
        r7 = false;
        goto L16
    }

    public int a(j r1) {
        return this.f12482f.a(r1.f12482f);
    }

    public Object b(Object r4) {
        return this.f12482f.c(r4);
    L4:
        e = move-exception;
        d.a.a.k.a r3 = this.f12482f;
        Member r0 = r3.f12529g;
        if (r0 != null) goto L10;
        r0 = r3.f12530h;
    L10:
        throw new d.a.a.d("get property error。 " + (r0.getDeclaringClass().getName() + "." + r0.getName()), e);
    }

    public void c(m r4) {
        z r5 = r4.f12492b;
        int r0 = r5.f12526h;
        if ((a0.f12465g.f12471f & r0) != 0) goto L5;
    L8:
        r5.F(this.f12482f.f12528f, true);
        return;
    L5:
        if ((r0 & a0.f12466h.f12471f) != 0) goto L8;
        char[] r3 = this.f12486j;
        r5.write(r3, 0, r3.length);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(j r1) {
        return a(r1);
    }

    public void g(m r4, Object r5) {
        String r0 = this.f12485i;
        if (r0 == null) goto L7;
        r4.w(r5, r0);
        return;
    L7:
        if (this.f12487k != null) goto L12;
        if (r5 != null) goto L10;
        Class<?> r1 = this.f12482f.f12534l;
    L11:
        this.f12487k = new a(r4.f12491a.a(r1), r1);
        goto L12
    L10:
        r1 = r5.getClass();
    L12:
        a r2 = this.f12487k;
        if (r5 == null) goto L15;
        Class<?> r3 = r5.getClass();
        if (r3 != r2.f12489b) goto L38;
        t r6 = r2.f12488a;
        d.a.a.k.a r7 = this.f12482f;
        r6.b(r4, r5, r7.f12528f, r7.m);
        return;
    L38:
        t r8 = r4.f12491a.a(r3);
        d.a.a.k.a r9 = this.f12482f;
        r8.b(r4, r5, r9.f12528f, r9.m);
        return;
    L15:
        if ((this.f12484h & a0.n.f12471f) != 0) goto L17;
    L20:
        int r10 = this.f12484h;
        if ((a0.o.f12471f & r10) == 0) goto L27;
        if (Boolean.class != r2.f12489b) goto L27;
        r4.f12492b.write("false");
        return;
    L27:
        if ((r10 & a0.f12470l.f12471f) != 0) goto L29;
    L32:
        r2.f12488a.b(r4, null, this.f12482f.f12528f, r2.f12489b);
        return;
    L29:
        if (Collection.class.isAssignableFrom(r2.f12489b) == false) goto L32;
        r4.f12492b.write("[]");
        return;
    L17:
        if (Number.class.isAssignableFrom(r2.f12489b) == false) goto L20;
        r4.f12492b.write(48);
    }
}
