package d.b.b.d.b;

import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Set<String> f12558a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Set<String> f12559b;

    public a(Set<String> r1, Set<String> r2) {
        this.f12558a = r1;
        this.f12559b = r2;
    }

    public boolean a(String r1) {
        Set<String> r0 = this.f12559b;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.contains(r1) == false) goto L7;
        return true;
    }

    public boolean b(String r1) {
        Set<String> r0 = this.f12558a;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.contains(r1) == false) goto L7;
        return true;
    }

    public String toString() {
        return "CommonEventConfig{sampledService=" + this.f12558a + ", sampledLogType=" + this.f12559b + '}';
    }
}
