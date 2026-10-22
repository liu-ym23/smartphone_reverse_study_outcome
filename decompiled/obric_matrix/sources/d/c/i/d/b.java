package d.c.i.d;

import d.c.c.g.h;
import d.c.c.g.i;
import d.c.c.g.k;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final byte[] f15905b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final byte[] f15906c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final i f15907a;

    static {
        f15905b = new byte[]{-1, -40, -1, -37, 0, 67, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -64, 0, 17, 8};
        f15906c = new byte[]{3, 1, 34, 0, 2, 17, 0, 3, 17, 0, -1, -60, 0, 31, 0, 0, 1, 5, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, -1, -60, 0, -75, 16, 0, 2, 1, 3, 3, 2, 4, 3, 5, 5, 4, 4, 0, 0, 1, 125, 1, 2, 3, 0, 4, 17, 5, 18, 33, 49, 65, 6, 19, 81, 97, 7, 34, 113, 20, 50, -127, -111, -95, 8, 35, 66, -79, -63, 21, 82, -47, -16, 36, 51, 98, 114, -126, 9, 10, 22, 23, 24, 25, 26, 37, 38, 39, 40, 41, 42, 52, 53, 54, 55, 56, 57, 58, 67, 68, 69, 70, 71, 72, 73, 74, 83, 84, 85, 86, 87, 88, 89, 90, 99, 100, 101, 102, 103, 104, 105, 106, 115, 116, 117, 118, 119, 120, 121, 122, -125, -124, -123, -122, -121, -120, -119, -118, -110, -109, -108, -107, -106, -105, -104, -103, -102, -94, -93, -92, -91, -90, -89, -88, -87, -86, -78, -77, -76, -75, -74, -73, -72, -71, -70, -62, -61, -60, -59, -58, -57, -56, -55, -54, -46, -45, -44, -43, -42, -41, -40, -39, -38, -31, -30, -29, -28, -27, -26, -25, -24, -23, -22, -15, -14, -13, -12, -11, -10, -9, -8, -7, -6, -1, -60, 0, 31, 1, 0, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, -1, -60, 0, -75, 17, 0, 2, 1, 2, 4, 4, 3, 4, 7, 5, 4, 4, 0, 1, 2, 119, 0, 1, 2, 3, 17, 4, 5, 33, 49, 6, 18, 65, 81, 7, 97, 113, 19, 34, 50, -127, 8, 20, 66, -111, -95, -79, -63, 9, 35, 51, 82, -16, 21, 98, 114, -47, 10, 22, 36, 52, -31, 37, -15, 23, 24, 25, 26, 38, 39, 40, 41, 42, 53, 54, 55, 56, 57, 58, 67, 68, 69, 70, 71, 72, 73, 74, 83, 84, 85, 86, 87, 88, 89, 90, 99, 100, 101, 102, 103, 104, 105, 106, 115, 116, 117, 118, 119, 120, 121, 122, -126, -125, -124, -123, -122, -121, -120, -119, -118, -110, -109, -108, -107, -106, -105, -104, -103, -102, -94, -93, -92, -91, -90, -89, -88, -87, -86, -78, -77, -76, -75, -74, -73, -72, -71, -70, -62, -61, -60, -59, -58, -57, -56, -55, -54, -46, -45, -44, -43, -42, -41, -40, -39, -38, -30, -29, -28, -27, -26, -25, -24, -23, -22, -14, -13, -12, -11, -10, -9, -8, -7, -6, -1, -38, 0, 12, 3, 1, 0, 2, 17, 3, 17, 0, 63, 0, -114, -118, 40, -96, 15, -1, -39};
    }

    public b(i r1) {
        this.f15907a = r1;
    }

    public d.c.c.h.a<h> a(short r6, short r7) {
        k r0 = null;
        i r5 = this.f15907a;     // Catch: Throwable -> L7 IOException -> L9
        byte[] r1 = f15905b;     // Catch: Throwable -> L7 IOException -> L9
        int r2 = r1.length;     // Catch: Throwable -> L7 IOException -> L9
        byte[] r3 = f15906c;     // Catch: Throwable -> L7 IOException -> L9
        r0 = r5.f((r2 + r3.length) + 4);     // Catch: Throwable -> L7 IOException -> L9
        r0.write(r1);     // Catch: Throwable -> L7 IOException -> L9
        r0.write((byte) (r7 >> 8));     // Catch: Throwable -> L7 IOException -> L9
        r0.write((byte) (r7 & 255));     // Catch: Throwable -> L7 IOException -> L9
        r0.write((byte) (r6 >> 8));     // Catch: Throwable -> L7 IOException -> L9
        r0.write((byte) (r6 & 255));     // Catch: Throwable -> L7 IOException -> L9
        r0.write(r3);     // Catch: Throwable -> L7 IOException -> L9
        d.c.c.h.a<h> r8 = d.c.c.h.a.V(r0.a());     // Catch: Throwable -> L7 IOException -> L9
        if (r0 == null) goto L6;
        r0.close();
    L6:
        return r8;
    L7:
        th = move-exception;
        if (r0 == null) goto L14;
        r0.close();
    L14:
        throw th;
    L9:
        e = move-exception;
        throw new RuntimeException(e);     // Catch: Throwable -> L7
    }
}
