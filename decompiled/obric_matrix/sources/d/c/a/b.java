package d.c.a;

import d.c.c.d.i;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final File f15255a;

    private b(File r1) {
        i.g(r1);
        this.f15255a = r1;
    }

    public static b b(File r1) {
        if (r1 != null) goto L6;
        return null;
    L6:
        return new b(r1);
    }

    @Override // d.c.a.a
    public InputStream a() {
        return new FileInputStream(this.f15255a);
    }

    public File c() {
        return this.f15255a;
    }

    public boolean equals(Object r2) {
        if (r2 != null) goto L4;
        return false;
    L4:
        if ((r2 instanceof b) == true) goto L7;
        return false;
    L7:
        return this.f15255a.equals(((b) r2).f15255a);
    }

    public int hashCode() {
        return this.f15255a.hashCode();
    }

    @Override // d.c.a.a
    public long size() {
        return this.f15255a.length();
    }
}
