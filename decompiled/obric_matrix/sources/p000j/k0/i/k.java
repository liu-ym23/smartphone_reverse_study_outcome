package p000j.k0.i;

import androidx.core.view.PointerIconCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import java.io.ByteArrayOutputStream;
import k.f;
import k.h;

/* JADX INFO: loaded from: classes2.dex */
class k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f18067b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final byte[] f18068c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final k f18069d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f18070a;

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final a[] f18071a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f18072b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f18073c;

        a() {
            this.f18071a = new a[256];
            this.f18072b = 0;
            this.f18073c = 0;
        }

        a(int r2, int r3) {
            this.f18071a = null;
            this.f18072b = r2;
            int r4 = r3 & 7;
            if (r4 != 0) goto L5;
            r4 = 8;
        L5:
            this.f18073c = r4;
        }
    }

    static {
        f18067b = new int[]{8184, 8388568, 268435426, 268435427, 268435428, 268435429, 268435430, 268435431, 268435432, 16777194, 1073741820, 268435433, 268435434, 1073741821, 268435435, 268435436, 268435437, 268435438, 268435439, 268435440, 268435441, 268435442, 1073741822, 268435443, 268435444, 268435445, 268435446, 268435447, 268435448, 268435449, 268435450, 268435451, 20, PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, PointerIconCompat.TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW, 4090, 8185, 21, 248, 2042, PointerIconCompat.TYPE_ZOOM_IN, PointerIconCompat.TYPE_ZOOM_OUT, 249, 2043, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 22, 23, 24, 0, 1, 2, 25, 26, 27, 28, 29, 30, 31, 92, 251, 32764, 32, 4091, PointerIconCompat.TYPE_GRAB, 8186, 33, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 252, 115, 253, 8187, 524272, 8188, 16380, 34, 32765, 3, 35, 4, 36, 5, 37, 38, 39, 6, 116, 117, 40, 41, 42, 7, 43, 118, 44, 8, 9, 45, 119, 120, 121, 122, 123, 32766, 2044, 16381, 8189, 268435452, 1048550, 4194258, 1048551, 1048552, 4194259, 4194260, 4194261, 8388569, 4194262, 8388570, 8388571, 8388572, 8388573, 8388574, 16777195, 8388575, 16777196, 16777197, 4194263, 8388576, 16777198, 8388577, 8388578, 8388579, 8388580, 2097116, 4194264, 8388581, 4194265, 8388582, 8388583, 16777199, 4194266, 2097117, 1048553, 4194267, 4194268, 8388584, 8388585, 2097118, 8388586, 4194269, 4194270, 16777200, 2097119, 4194271, 8388587, 8388588, 2097120, 2097121, 4194272, 2097122, 8388589, 4194273, 8388590, 8388591, 1048554, 4194274, 4194275, 4194276, 8388592, 4194277, 4194278, 8388593, 67108832, 67108833, 1048555, 524273, 4194279, 8388594, 4194280, 33554412, 67108834, 67108835, 67108836, 134217694, 134217695, 67108837, 16777201, 33554413, 524274, 2097123, 67108838, 134217696, 134217697, 67108839, 134217698, 16777202, 2097124, 2097125, 67108840, 67108841, 268435453, 134217699, 134217700, 134217701, 1048556, 16777203, 1048557, 2097126, 4194281, 2097127, 2097128, 8388595, 4194282, 4194283, 33554414, 33554415, 16777204, 16777205, 67108842, 8388596, 67108843, 134217702, 67108844, 67108845, 134217703, 134217704, 134217705, 134217706, 134217707, 268435454, 134217708, 134217709, 134217710, 134217711, 134217712, 67108846};
        f18068c = new byte[]{13, 23, 28, 28, 28, 28, 28, 28, 28, 24, 30, 28, 28, 30, 28, 28, 28, 28, 28, 28, 28, 28, 30, 28, 28, 28, 28, 28, 28, 28, 28, 28, 6, 10, 10, 12, 13, 6, 8, 11, 10, 10, 8, 11, 8, 6, 6, 6, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7, 8, 15, 6, 12, 10, 13, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 7, 8, 13, 19, 13, 14, 6, 15, 5, 6, 5, 6, 5, 6, 6, 6, 5, 7, 7, 6, 6, 6, 5, 6, 7, 6, 5, 5, 6, 7, 7, 7, 7, 7, 15, 11, 14, 13, 28, 20, 22, 20, 20, 22, 22, 22, 23, 22, 23, 23, 23, 23, 23, 24, 23, 24, 24, 22, 23, 24, 23, 23, 23, 23, 21, 22, 23, 22, 23, 23, 24, 22, 21, 20, 22, 22, 23, 23, 21, 23, 22, 22, 24, 21, 22, 23, 23, 21, 21, 22, 21, 23, 22, 23, 23, 20, 22, 22, 22, 23, 22, 22, 23, 26, 26, 20, 19, 22, 23, 22, 25, 26, 26, 26, 27, 27, 26, 24, 25, 19, 21, 26, 27, 27, 26, 27, 24, 21, 21, 26, 26, 28, 27, 27, 27, 20, 24, 20, 21, 22, 21, 21, 23, 22, 22, 25, 25, 24, 24, 26, 23, 26, 27, 26, 26, 27, 27, 27, 27, 27, 28, 27, 27, 27, 27, 27, 26};
        f18069d = new k();
    }

    private k() {
        this.f18070a = new a();
        b();
    }

    private void a(int r3, int r4, byte r5) {
        a r0 = new a(r3, r5);
        a r2 = this.f18070a;
    L4:
        if (r5 <= 8) goto L13;
        r5 = (byte) (r5 - 8);
        int r6 = (r4 >>> r5) & 255;
        a[] r7 = r2.f18071a;
        if (r7 == null) goto L12;
        if (r7[r6] != null) goto L10;
        r7[r6] = new a();
    L10:
        r2 = r7[r6];
        goto L4
    L12:
        throw new IllegalStateException("invalid dictionary: prefix not unique");
    L13:
        int r8 = 8 - r5;
        int r9 = (r4 << r8) & 255;
        int r10 = 1 << r8;
        int r11 = r9;
    L15:
        if (r11 >= (r9 + r10)) goto L17;
        r2.f18071a[r11] = r0;
        r11 = r11 + 1;
        goto L15
    }

    private void b() {
        int r0 = 0;
    L3:
        byte[] r1 = f18068c;
        if (r0 >= r1.length) goto L6;
        a(r0, f18067b[r0], r1[r0]);
        r0 = r0 + 1;
        goto L3
    }

    public static k f() {
        return f18069d;
    }

    byte[] c(byte[] r7) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        a r1 = this.f18070a;
        int r2 = 0;
        int r3 = 0;
        int r4 = 0;
    L4:
        if (r2 >= r7.length) goto L13;
        r3 = (r3 << 8) | (r7[r2] & 255);
        r4 = r4 + 8;
    L7:
        if (r4 < 8) goto L12;
        r1 = r1.f18071a[(r3 >>> (r4 - 8)) & 255];
        if (r1.f18071a == null) goto L10;
        r4 = r4 - 8;
        goto L7
    L10:
        r0.write(r1.f18072b);
        r4 = r4 - r1.f18073c;
        r1 = this.f18070a;
        goto L7
    L12:
        r2 = r2 + 1;
    L13:
        if (r4 <= 0) goto L21;
        a r8 = r1.f18071a[(r3 << (8 - r4)) & 255];
        if (r8.f18071a != null) goto L21;
        if (r8.f18073c > r4) goto L21;
        r0.write(r8.f18072b);
        r4 = r4 - r8.f18073c;
        r1 = this.f18070a;
    L21:
        return r0.toByteArray();
    }

    void d(h r7, f r8) {
        int r6 = 0;
        long r1 = 0;
        int r0 = 0;
    L4:
        if (r6 >= r7.size()) goto L10;
        int r3 = r7.l(r6) & 255;
        int r4 = f18067b[r3];
        byte r5 = f18068c[r3];
        r1 = (r1 << r5) | ((long) r4);
        r0 = r0 + r5;
    L7:
        if (r0 < 8) goto L9;
        r0 = r0 - 8;
        r8.w((int) (r1 >> r0));
        goto L7
    L9:
        r6 = r6 + 1;
        goto L4
    L10:
        if (r0 <= 0) goto L15;
        r8.w((int) ((r1 << (8 - r0)) | ((long) (255 >>> r0))));
        return;
    }

    int e(h r5) {
        long r0 = 0;
        int r4 = 0;
    L4:
        if (r4 >= r5.size()) goto L7;
        int r2 = r5.l(r4) & 255;
        r0 = r0 + ((long) f18068c[r2]);
        r4 = r4 + 1;
        goto L4
    L7:
        return (int) ((r0 + 7) >> 3);
    }
}
