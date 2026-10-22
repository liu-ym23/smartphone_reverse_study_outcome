package d.b.b.e.a.j;

import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f12629a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f12630b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f12631c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private File f12632d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<b> f12633e;

    public a(long r1, int r3, int r4, List<b> r5) {
        this.f12629a = r1;
        this.f12630b = r3;
        this.f12631c = r4;
        this.f12633e = r5;
    }

    public static a a(File r2) {
        byte[] r0 = d.b.b.o.c.e(r2);     // Catch: Throwable -> L11
        if (r0 == null) goto L9;
        a r1 = b(ByteBuffer.wrap(r0));     // Catch: Throwable -> L11
        if (r1 == null) goto L7;
        r1.f12632d = r2;     // Catch: Throwable -> L11
    L8:
        return r1;
    L7:
        d.b.b.o.m.b.b(d.b.b.e.a.a.f12571a, "fromMemory bytes is null");     // Catch: Throwable -> L11
        goto L8
    L9:
        d.b.b.o.m.b.b(d.b.b.e.a.a.f12571a, "fromFile bytes is null");     // Catch: Throwable -> L11
        return null;
    L11:
        th = move-exception;
        d.b.b.o.m.b.c(d.b.b.e.a.a.f12571a, "fromFile", th);
        return null;
    }

    public static a b(ByteBuffer r10) {
    L14:
        return null;
    L4:
        if (r10.getShort() == 2082) goto L6;
        return null;
    L6:
        long r4 = r10.getLong();     // Catch: Throwable -> L14
        int r6 = r10.getInt();     // Catch: Throwable -> L14
        int r7 = r10.getInt();     // Catch: Throwable -> L14
        ArrayList r8 = new ArrayList();     // Catch: Throwable -> L14
        int r1 = 0;
        int r2 = 0;
    L7:
        if (r1 >= r6) goto L12;
        int r3 = r10.getInt();     // Catch: Throwable -> L14
        r2 = r2 + r3;     // Catch: Throwable -> L14
        if (r2 > r7) goto L10;
        byte[] r5 = new byte[r3];     // Catch: Throwable -> L14
        r10.get(r5);     // Catch: Throwable -> L14
        r8.add(new b(r5));     // Catch: Throwable -> L14
        r1 = r1 + 1;     // Catch: Throwable -> L14
        goto L7
    L10:
        return null;
    L12:
        return new a(r4, r6, r7, r8);
    }

    public List<b> c() {
        return this.f12633e;
    }

    public File d() {
        return this.f12632d;
    }

    public long e() {
        return this.f12629a;
    }

    public int f() {
        return this.f12631c;
    }

    public int g() {
        return this.f12630b;
    }

    public String toString() {
        return "LogFile{startID=" + this.f12629a + ", totalCount=" + this.f12630b + ", totalBytes=" + this.f12631c + ", source=" + this.f12632d + ", logList=" + this.f12633e + '}';
    }
}
