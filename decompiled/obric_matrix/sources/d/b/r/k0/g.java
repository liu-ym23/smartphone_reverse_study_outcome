package d.b.r.k0;

import android.text.TextUtils;
import com.bytedance.frameworks.encryptor.EncryptorUtil;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class g extends a implements i {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f14464d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private byte[] f14465e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f14466f;

    public g(String r2, byte[] r3, String... r4) {
        if (r4 != null) goto L5;
    L7:
        String r5 = null;
    L8:
        if (r2 == null) goto L10;
    L13:
        Objects.requireNonNull(r3, "bytes null");
        this.f14464d = r2;
        this.f14465e = r3;
        this.f14466f = r5;
        return;
    L10:
        if (TextUtils.isEmpty(r5) == false) goto L12;
        r2 = "application/unknown";
        goto L13
    L12:
        r2 = "application/octet-stream";
        goto L13
    L5:
        if (r4.length <= 0) goto L7;
        r5 = r4[0];
        goto L8
    }

    @Override // d.b.r.k0.a, d.b.r.k0.j
    public String a() {
        return this.f14464d;
    }

    @Override // d.b.r.k0.a, d.b.r.k0.j
    public void b(OutputStream r1) {
        r1.write(this.f14465e);
    }

    @Override // d.b.r.k0.a, d.b.r.k0.j
    public String c() {
        if (TextUtils.isEmpty(this.f14466f) == false) goto L7;
        return null;
    L7:
        return this.f14466f;
    }

    @Override // d.b.r.k0.i
    public InputStream d() {
        return new ByteArrayInputStream(this.f14465e);
    }

    @Override // d.b.r.k0.a, d.b.r.k0.j
    public String e() {
        byte[] r0 = this.f14465e;
        if (r0 != null) goto L6;
        return null;
    L6:
        this.f14417c = b.c(r0);
        return this.f14417c;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L17:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L17;
        g r6 = (g) r5;
        if (Arrays.equals(this.f14465e, r6.f14465e) == true) goto L14;
        return false;
    L14:
        if (this.f14464d.equals(r6.f14464d) == true) goto L16;
        return false;
    L16:
        return true;
    }

    @Override // d.b.r.k0.a
    public f.b g(String r3, String r4, boolean r5) {
        byte[] r0 = this.f14465e;
        if (r0 != null) goto L6;
        return null;
    L6:
        f.b r6 = f.d(r0, r0.length, r3, r4, r5);
        if (r6 != null) goto L9;
    L12:
        return r6;
    L9:
        if (r6.f14447a == null) goto L12;
        int r7 = this.f14465e.length;
        this.f14465e = r6.f14447a;
        this.f14416b = r6.f14448b;
        goto L12
    }

    public int hashCode() {
        return (this.f14464d.hashCode() * 31) + Arrays.hashCode(this.f14465e);
    }

    @Override // d.b.r.k0.a
    public boolean i() {
        byte[] r0 = this.f14465e;
        if (r0 != null) goto L5;
    L12:
        return false;
    L5:
        if (r0.length > 102400) goto L12;
        byte[] r1 = EncryptorUtil.a(r0, r0.length);
        if (r1 != null) goto L10;
        return false;
    L10:
        this.f14465e = r1;
        this.f14415a = true;
        return true;
    }

    public byte[] k() {
        return this.f14465e;
    }

    @Override // d.b.r.k0.a, d.b.r.k0.j
    public long length() {
        return this.f14465e.length;
    }

    public String toString() {
        return "TypedByteArray[length=" + length() + "]";
    }
}
