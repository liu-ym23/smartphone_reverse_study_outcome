package d.b.h.a.a.h.m;

import com.bytedance.bdlocation.client.LocationInfoConst;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class l implements Serializable {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final char[] f13465h = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private transient g f13466f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f13467g;

    static {
        f13465h = "0123456789ABCDEF".toCharArray();
    }

    public l(g r3) {
        this.f13466f = r3;
        this.f13467g = System.currentTimeMillis();
    }

    private String a(byte[] r6) {
        char[] r5 = new char[r6.length * 2];
        int r0 = 0;
    L4:
        if (r0 >= r6.length) goto L7;
        int r1 = r6[r0] & 255;
        int r2 = r0 * 2;
        char[] r3 = f13465h;
        r5[r2] = r3[r1 >>> 4];
        r5[r2 + 1] = r3[r1 & 15];
        r0 = r0 + 1;
        goto L4
    L7:
        return new String(r5);
    }

    public static l b(String r5) {
        if (r5 != null) goto L5;
    L10:
        return null;
    L5:
        if (r5.isEmpty() == true) goto L10;
        return (l) new d.b.h.a.a.h.n.a(new ByteArrayInputStream(h(r5)), new Class[]{l.class}).readObject();
    }

    public static int d(String r1, int r2) {
        if (r2 == (-1)) goto L6;
        return r2;
    L6:
        if ("http".equalsIgnoreCase(r1) == false) goto L10;
        return 80;
    L10:
        if (LocationInfoConst.HTTPS.equalsIgnoreCase(r1) == false) goto L13;
        return 443;
    L13:
        return -1;
    }

    private static byte[] h(String r7) {
        int r0 = r7.length();
        byte[] r1 = new byte[r0 / 2];
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r1[r2 / 2] = (byte) ((Character.digit(r7.charAt(r2), 16) << 4) + Character.digit(r7.charAt(r2 + 1), 16));
        r2 = r2 + 2;
        goto L3
    L5:
        return r1;
    }

    public String c() {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        new ObjectOutputStream(r0).writeObject(this);     // Catch: IOException -> L6
        return a(r0.toByteArray());
    L6:
        return null;
    }

    public g e() {
        return this.f13466f;
    }

    public boolean equals(Object r2) {
        if ((r2 instanceof g) == false) goto L8;
        g r1 = this.f13466f;
    L6:
        return r1.equals(r2);
    L8:
        if ((r2 instanceof l) == false) goto L10;
        r1 = this.f13466f;
        r2 = ((l) r2).f13466f;
        goto L6
    L10:
        return false;
    }

    public Long f() {
        return Long.valueOf(this.f13467g);
    }

    public boolean g() {
        long r0 = this.f13466f.z();
        if (r0 != (-1)) goto L6;
        return false;
    L6:
        if (((System.currentTimeMillis() - this.f13467g) / 1000) <= r0) goto L9;
        return true;
    L9:
        return false;
    }

    public int hashCode() {
        return this.f13466f.hashCode();
    }
}
