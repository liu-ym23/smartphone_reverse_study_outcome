package d.b.r.k0;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class h implements i, j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f14467a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final File f14468b;

    public h(String r2, File r3) {
        if (r2 != null) goto L5;
        r2 = "application/octet-stream";
    L5:
        Objects.requireNonNull(r3, "file");
        this.f14467a = r2;
        this.f14468b = r3;
    }

    @Override // d.b.r.k0.i
    public String a() {
        return this.f14467a;
    }

    @Override // d.b.r.k0.j
    public void b(OutputStream r4) {
        byte[] r0 = new byte[4096];
        FileInputStream r1 = new FileInputStream(this.f14468b);
    L12:
        int r3 = r1.read(r0);     // Catch: Throwable -> L9
        if (r3 == (-1)) goto L7;
        r4.write(r0, 0, r3);     // Catch: Throwable -> L9
        goto L12
    L7:
        r1.close();
        return;
    L9:
        th = move-exception;
        r1.close();
        throw th;
    }

    @Override // d.b.r.k0.j
    public String c() {
        return this.f14468b.getName();
    }

    @Override // d.b.r.k0.i
    public InputStream d() {
        return new FileInputStream(this.f14468b);
    }

    @Override // d.b.r.k0.j
    public String e() {
        return null;
    }

    public boolean equals(Object r2) {
        if (this != r2) goto L6;
        return true;
    L6:
        if ((r2 instanceof h) == true) goto L8;
        return false;
    L8:
        return this.f14468b.equals(((h) r2).f14468b);
    }

    public int hashCode() {
        return this.f14468b.hashCode();
    }

    @Override // d.b.r.k0.j
    public long length() {
        return this.f14468b.length();
    }

    public String toString() {
        return this.f14468b.getAbsolutePath() + " (" + a() + ")";
    }
}
