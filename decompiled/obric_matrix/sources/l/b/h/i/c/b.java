package l.b.h.i.c;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class b implements c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final List f22307d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f22308a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List f22309b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private byte[] f22310c;

    static {
        f22307d = Collections.unmodifiableList(new ArrayList());
    }

    public b(String r1, List r2, byte[] r3) {
        this.f22308a = r1;
        this.f22309b = Collections.unmodifiableList(r2);
        this.f22310c = r3;
    }

    public b(String r2, byte[] r3) {
        this(r2, f22307d, r3);
    }

    @Override // l.b.h.i.c.c
    public b a() {
        return this;
    }

    public byte[] b() {
        return this.f22310c;
    }

    public List c() {
        return this.f22309b;
    }

    public String d() {
        return this.f22308a;
    }
}
