package d.c.c.g;

import android.text.TextUtils;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f15412a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f15413b;

    public l(a r2) {
        this(r2, 16384);
    }

    public l(a r2, int r3) {
        if (r3 <= 0) goto L5;
        boolean r0 = true;
    L6:
        d.c.c.d.i.b(r0);
        this.f15412a = r3;
        this.f15413b = r2;
        return;
    L5:
        r0 = false;
        goto L6
    }

    public static String a(byte[] r6) {
        StringBuilder r0 = new StringBuilder();
        int r1 = r6.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L9;
        int r4 = r6[r3] & 255;
        if (r4 >= 16) goto L7;
        r0.append(0);
    L7:
        r0.append(Integer.toHexString(r4));
        r3 = r3 + 1;
        goto L3
    L9:
        return r0.toString();
    }

    public long b(InputStream r7, OutputStream r8) {
        byte[] r0 = this.f15413b.get(this.f15412a);
        long r1 = 0;
    L13:
        int r3 = r7.read(r0, 0, this.f15412a);     // Catch: Throwable -> L10
        if (r3 == (-1)) goto L6;
        r8.write(r0, 0, r3);     // Catch: Throwable -> L10
        r1 = r1 + ((long) r3);
        goto L13
    L6:
        this.f15413b.release(r0);
        return r1;
    L10:
        th = move-exception;
        this.f15413b.release(r0);
        throw th;
    }

    public long c(InputStream r10, OutputStream r11, String r12) {
        byte[] r0 = this.f15413b.get(this.f15412a);
        String r1 = null;
        long r2 = 0;
        MessageDigest r4 = MessageDigest.getInstance("MD5");     // Catch: Exception -> L5
    L31:
        int r5 = r10.read(r0, 0, this.f15412a);     // Catch: Throwable -> L28
        if (r5 == (-1)) goto L8;
        r11.write(r0, 0, r5);     // Catch: Throwable -> L28
        r2 = r2 + ((long) r5);     // Catch: Throwable -> L28
        if (r4 == null) goto L31;
        if (r5 <= 0) goto L31;
        r4.update(r0, 0, r5);     // Catch: Throwable -> L28
        goto L31
    L8:
        if (r4 == null) goto L11;
        r1 = a(r4.digest());     // Catch: Throwable -> L28
    L11:
        if (TextUtils.isEmpty(r1) == false) goto L16;
        Class<?> r13 = getClass();     // Catch: Throwable -> L28
        String r14 = "the image md5 should not be null, you should check the image is valid or not";
    L13:
        d.c.c.e.a.y(r13, r14);     // Catch: Throwable -> L28
    L14:
        this.f15413b.release(r0);
        return r2;
    L16:
        if (r12 != null) goto L19;
        r13 = getClass();     // Catch: Throwable -> L28
        r14 = "the target md5 should not be null, you should check the md5 file has been remove or not";
        goto L13
    L19:
        if (r12.equals(r1) == true) goto L14;
        this.f15413b.release(r0);
        return -1;
    L28:
        th = move-exception;
        this.f15413b.release(r0);
        throw th;
    L5:
        r4 = null;
        goto L31
    }
}
