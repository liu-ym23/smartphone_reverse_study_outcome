package kotlin.s0.w.d.l0.i;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes2.dex */
public class n extends AbstractList<String> implements RandomAccess, o {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final o f20367g = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List<Object> f20368f;

    static {
        f20367g = new n().h();
    }

    public n() {
        this.f20368f = new ArrayList();
    }

    public n(o r3) {
        this.f20368f = new ArrayList(r3.size());
        addAll(r3);
    }

    private static d b(Object r1) {
        if ((r1 instanceof d) == false) goto L7;
        return (d) r1;
    L7:
        if ((r1 instanceof String) == false) goto L11;
        return d.l((String) r1);
    L11:
        return d.d((byte[]) r1);
    }

    private static String c(Object r1) {
        if ((r1 instanceof String) == false) goto L7;
        return (String) r1;
    L7:
        if ((r1 instanceof d) == false) goto L11;
        return ((d) r1).z();
    L11:
        return j.b((byte[]) r1);
    }

    public void a(int r2, String r3) {
        this.f20368f.add(r2, r3);
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ void add(int r1, Object r2) {
        a(r1, (String) r2);
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int r2, Collection<? extends String> r3) {
        if ((r3 instanceof o) == false) goto L5;
        r3 = ((o) r3).e();
    L5:
        boolean r4 = this.f20368f.addAll(r2, r3);
        ((AbstractList) this).modCount++;
        return r4;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends String> r2) {
        return addAll(size(), r2);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.f20368f.clear();
        ((AbstractList) this).modCount++;
    }

    public String d(int r3) {
        Object r0 = this.f20368f.get(r3);
        if ((r0 instanceof String) == false) goto L7;
        return (String) r0;
    L7:
        if ((r0 instanceof d) == false) goto L12;
        d r1 = (d) r0;
        String r2 = r1.z();
        if (r1.q() == false) goto L11;
        this.f20368f.set(r3, r2);
    L11:
        return r2;
    L12:
        byte[] r4 = (byte[]) r0;
        String r5 = j.b(r4);
        if (j.a(r4) == false) goto L15;
        this.f20368f.set(r3, r5);
    L15:
        return r5;
    }

    @Override // kotlin.s0.w.d.l0.i.o
    public List<?> e() {
        return Collections.unmodifiableList(this.f20368f);
    }

    @Override // kotlin.s0.w.d.l0.i.o
    public d f(int r3) {
        Object r0 = this.f20368f.get(r3);
        d r1 = b(r0);
        if (r1 == r0) goto L5;
        this.f20368f.set(r3, r1);
    L5:
        return r1;
    }

    public String g(int r2) {
        Object r3 = this.f20368f.remove(r2);
        ((AbstractList) this).modCount++;
        return c(r3);
    }

    @Override // java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object get(int r1) {
        return d(r1);
    }

    @Override // kotlin.s0.w.d.l0.i.o
    public o h() {
        return new x(this);
    }

    @Override // kotlin.s0.w.d.l0.i.o
    public void j(d r2) {
        this.f20368f.add(r2);
        ((AbstractList) this).modCount++;
    }

    public String l(int r1, String r2) {
        return c(this.f20368f.set(r1, r2));
    }

    @Override // java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object remove(int r1) {
        return g(r1);
    }

    @Override // java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object set(int r1, Object r2) {
        return l(r1, (String) r2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f20368f.size();
    }
}
