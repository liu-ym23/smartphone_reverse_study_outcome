package d.b.r.k0;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public final class e implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<a> f14423a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final byte[] f14424b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f14425c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f14426d;

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final j f14427a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f14428b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f14429c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f14430d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final String f14431e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private byte[] f14432f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private byte[] f14433g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f14434h;

        public a(String r1, String r2, j r3, String r4, boolean r5) {
            this.f14428b = r1;
            this.f14429c = r2;
            this.f14427a = r3;
            this.f14430d = r5;
            this.f14431e = r4;
        }

        private void a() {
            if (this.f14434h == false) goto L5;
            return;
        L5:
            this.f14432f = e.d(this.f14431e, this.f14430d, false);
            this.f14433g = e.f(this.f14428b, this.f14429c, this.f14427a);
            this.f14434h = true;
        }

        public long b() {
            a();
            if (this.f14427a.length() > (-1)) goto L5;
            return -1;
        L5:
            return (this.f14427a.length() + ((long) this.f14432f.length)) + ((long) this.f14433g.length);
        }

        public void c(OutputStream r2) {
            a();
            r2.write(this.f14432f);
            r2.write(this.f14433g);
            this.f14427a.b(r2);
        }
    }

    public e() {
        this(UUID.randomUUID().toString());
    }

    e(String r3) {
        this.f14423a = new LinkedList();
        this.f14425c = r3;
        byte[] r4 = i(r3, false, true);
        this.f14424b = r4;
        this.f14426d = r4.length;
    }

    static /* synthetic */ byte[] d(String r0, boolean r1, boolean r2) {
        return i(r0, r1, r2);
    }

    static /* synthetic */ byte[] f(String r0, String r1, j r2) {
        return j(r0, r1, r2);
    }

    private static byte[] i(String r3, boolean r4, boolean r5) {
        StringBuilder r1 = new StringBuilder(r3.length() + 8);     // Catch: IOException -> L12
        if (r4 == true) goto L7;
        r1.append("\r\n");     // Catch: IOException -> L12
    L7:
        r1.append("--");     // Catch: IOException -> L12
        r1.append(r3);     // Catch: IOException -> L12
        if (r5 == false) goto L10;
        r1.append("--");     // Catch: IOException -> L12
    L10:
        r1.append("\r\n");     // Catch: IOException -> L12
        return r1.toString().getBytes("UTF-8");
    L12:
        e = move-exception;
        throw new RuntimeException("Unable to write multipart boundary", e);
    }

    private static byte[] j(String r5, String r6, j r7) {
        StringBuilder r0 = new StringBuilder(128);     // Catch: IOException -> L10
        r0.append("Content-Disposition: form-data; name=\"");     // Catch: IOException -> L10
        r0.append(r5);     // Catch: IOException -> L10
        String r8 = r7.c();     // Catch: IOException -> L10
        if (r8 == null) goto L5;
        r0.append("\"; filename=\"");     // Catch: IOException -> L10
        r0.append(r8);     // Catch: IOException -> L10
    L5:
        r0.append("\"\r\nContent-Type: ");     // Catch: IOException -> L10
        r0.append(r7.a());     // Catch: IOException -> L10
        long r1 = r7.length();     // Catch: IOException -> L10
        if (r1 == (-1)) goto L8;
        r0.append("\r\nContent-Length: ");     // Catch: IOException -> L10
        r0.append(r1);     // Catch: IOException -> L10
    L8:
        r0.append("\r\nContent-Transfer-Encoding: ");     // Catch: IOException -> L10
        r0.append(r6);     // Catch: IOException -> L10
        r0.append("\r\n\r\n");     // Catch: IOException -> L10
        return r0.toString().getBytes("UTF-8");
    L10:
        e = move-exception;
        throw new RuntimeException("Unable to write multipart header", e);
    }

    @Override // d.b.r.k0.j
    public String a() {
        return "multipart/form-data; boundary=" + this.f14425c;
    }

    @Override // d.b.r.k0.j
    public void b(OutputStream r3) {
        Iterator<a> r0 = this.f14423a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().c(r3);
        goto L4
    L6:
        r3.write(this.f14424b);
    }

    @Override // d.b.r.k0.j
    public String c() {
        return null;
    }

    @Override // d.b.r.k0.j
    public String e() {
        if (this.f14426d != (-1)) goto L31;
        return null;
    L31:
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();     // Catch: Throwable -> L12
        b(r0);     // Catch: Throwable -> L11
        ByteArrayInputStream r4 = new ByteArrayInputStream(r0.toByteArray());     // Catch: Throwable -> L11
        String r1 = b.b(r4);     // Catch: Throwable -> L20
        r0.close();     // Catch: Throwable -> L18
    L27:
        r4.close();     // Catch: Throwable -> L19
    L10:
        return r1;
    L13:
        if (r0 != null) goto L35;
    L15:
        if (r4 != null) goto L25;
    L17:
        return null;
    L25:
        r4.close();     // Catch: Throwable -> L22
        goto L17
    L35:
        r0.close();     // Catch: Throwable -> L21
    L11:
        r4 = null;
    L12:
        r4 = null;
        r0 = null;
        goto L13
    }

    public void g(String r2, j r3) {
        h(r2, "binary", r3);
    }

    public void h(String r8, String r9, j r10) {
        Objects.requireNonNull(r8, "Part name must not be null.");
        Objects.requireNonNull(r9, "Transfer encoding must not be null.");
        Objects.requireNonNull(r10, "Part body must not be null.");
        a r0 = new a(r8, r9, r10, this.f14425c, this.f14423a.isEmpty());
        this.f14423a.add(r0);
        long r11 = r0.b();
        if (r11 != (-1)) goto L5;
        this.f14426d = -1;
        return;
    L5:
        long r2 = this.f14426d;
        if (r2 == (-1)) goto L10;
        this.f14426d = r2 + r11;
        return;
    }

    public int k() {
        return this.f14423a.size();
    }

    @Override // d.b.r.k0.j
    public long length() {
        return this.f14426d;
    }
}
