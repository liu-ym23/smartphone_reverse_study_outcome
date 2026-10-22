package d.b.r.k0;

import com.bytedance.frameworks.encryptor.EncryptorUtil;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class c extends a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    ByteArrayOutputStream f14419d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f14420e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Map<String, List<String>> f14421f;

    public c() {
        this.f14419d = new ByteArrayOutputStream();
        this.f14421f = new HashMap();
        this.f14420e = false;
    }

    public c(boolean r2) {
        this.f14419d = new ByteArrayOutputStream();
        this.f14421f = new HashMap();
        this.f14420e = r2;
    }

    @Override // d.b.r.k0.a, d.b.r.k0.j
    public String a() {
        return "application/x-www-form-urlencoded; charset=UTF-8";
    }

    @Override // d.b.r.k0.a, d.b.r.k0.j
    public void b(OutputStream r1) {
        r1.write(this.f14419d.toByteArray());
    }

    @Override // d.b.r.k0.a, d.b.r.k0.j
    public String c() {
        return null;
    }

    @Override // d.b.r.k0.a, d.b.r.k0.j
    public String e() {
        this.f14417c = b.c(this.f14419d.toByteArray());
        return this.f14417c;
    }

    @Override // d.b.r.k0.a
    public f.b g(String r3, String r4, boolean r5) {
        byte[] r0 = this.f14419d.toByteArray();
        if (r0 != null) goto L6;
        return null;
    L6:
        f.b r6 = f.d(r0, r0.length, r3, r4, r5);
        if (r6 != null) goto L9;
    L12:
        return r6;
    L9:
        if (r6.f14447a == null) goto L12;
        int r7 = r0.length;
        ByteArrayOutputStream r8 = new ByteArrayOutputStream(r6.f14447a.length);
        this.f14419d = r8;
        byte[] r9 = r6.f14447a;
        r8.write(r9, 0, r9.length);
        this.f14416b = r6.f14448b;
        goto L12
    }

    @Override // d.b.r.k0.a
    public boolean i() {
        byte[] r0 = this.f14419d.toByteArray();
        if (r0 != null) goto L5;
    L12:
        return false;
    L5:
        if (r0.length > 102400) goto L12;
        byte[] r1 = EncryptorUtil.a(r0, r0.length);
        if (r1 != null) goto L10;
        return false;
    L10:
        ByteArrayOutputStream r2 = new ByteArrayOutputStream(r1.length);
        this.f14419d = r2;
        r2.write(r1, 0, r1.length);
        this.f14415a = true;
        return true;
    }

    public void k(String r2, String r3) {
        l(r2, true, r3, true);
    }

    public void l(String r3, boolean r4, String r5, boolean r6) {
        Objects.requireNonNull(r3, "name");
        Objects.requireNonNull(r5, "value");
        if (this.f14419d.size() <= 0) goto L6;
        this.f14419d.write(38);
    L6:
        if (this.f14420e == false) goto L12;
        if (this.f14421f.containsKey(r3) == false) goto L10;
        this.f14421f.get(r3).add(r5);
        goto L12
    L10:
        ArrayList r0 = new ArrayList();
        r0.add(r5);
        this.f14421f.put(r3, r0);
    L12:
        if (r4 == true) goto L21;
    L14:
        if (r6 == false) goto L16;
        r5 = URLEncoder.encode(r5, "UTF-8");     // Catch: IOException -> L18
    L16:
        this.f14419d.write(r3.getBytes("UTF-8"));     // Catch: IOException -> L18
        this.f14419d.write(61);     // Catch: IOException -> L18
        this.f14419d.write(r5.getBytes("UTF-8"));     // Catch: IOException -> L18
        return;
    L18:
        e = move-exception;
        throw new RuntimeException(e);
    L21:
        r3 = URLEncoder.encode(r3, "UTF-8");     // Catch: IOException -> L18
        goto L14
    }

    @Override // d.b.r.k0.a, d.b.r.k0.j
    public long length() {
        return this.f14419d.size();
    }
}
