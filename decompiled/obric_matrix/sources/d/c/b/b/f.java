package d.c.b.b;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class f implements d.c.b.a.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d.c.b.a.d f15346a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, String> f15347b;

    public f(d.c.b.a.d r1, Map<String, String> r2) {
        this.f15346a = r1;
        this.f15347b = r2;
    }

    @Override // d.c.b.a.d
    public String a() {
        return this.f15346a.a();
    }

    public Map<String, String> b() {
        return this.f15347b;
    }

    @Override // d.c.b.a.d
    public boolean equals(Object r1) {
        return this.f15346a.equals(r1);
    }

    @Override // d.c.b.a.d
    public int hashCode() {
        return this.f15346a.hashCode();
    }

    @Override // d.c.b.a.d
    public String toString() {
        return this.f15346a.toString();
    }
}
