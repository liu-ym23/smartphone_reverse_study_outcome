package d.c.i.k;

import android.graphics.Bitmap;
import d.c.c.d.i;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {
    private static int a(int r0, int r1, int r2) {
        if (r0 < r1) goto L7;
        if (r0 > r2) goto L6;
        return r0;
    L6:
        return r2;
    L7:
        return r1;
    }

    public static void b(Bitmap r5, int r6, int r7) {
        i.g(r5);
        i.b(r5.isMutable());
        if (r5.getHeight() > 2048.0f) goto L5;
        boolean r0 = true;
    L6:
        i.b(r0);
        if (r5.getWidth() > 2048.0f) goto L9;
        boolean r1 = true;
    L10:
        i.b(r1);
        if (r7 > 0) goto L13;
    L15:
        boolean r2 = false;
    L16:
        i.b(r2);
        if (r6 <= 0) goto L19;
        boolean r3 = true;
    L20:
        i.b(r3);
        c(r5, r6, r7);     // Catch: OutOfMemoryError -> L23
        return;
    L23:
        e = move-exception;
        d.c.c.e.a.j("IterativeBoxBlurFilter", String.format(null, "OOM: %d iterations on %dx%d with %d radius", new Object[]{Integer.valueOf(r6), Integer.valueOf(r5.getWidth()), Integer.valueOf(r5.getHeight()), Integer.valueOf(r7)}));
        throw e;
    L19:
        r3 = false;
        goto L20
    L13:
        if (r7 > 25) goto L15;
        r2 = true;
        goto L16
    L9:
        r1 = false;
        goto L10
    L5:
        r0 = false;
        goto L6
    }

    private static void c(Bitmap r17, int r18, int r19) {
        int r8 = r17.getWidth();
        int r9 = r17.getHeight();
        int[] r10 = new int[r8 * r9];
        r17.getPixels(r10, 0, r8, 0, 0, r8, r9);
        int r0 = r19 + 1;
        int r7 = r0 + r19;
        int[] r11 = new int[r7 * 256];
        int r1 = 1;
    L3:
        int r12 = 0;
        if (r1 > 255) goto L8;
    L5:
        if (r12 >= r7) goto L7;
        r11[r0] = r1;
        r0 = r0 + 1;
        r12 = r12 + 1;
        goto L5
    L7:
        r1 = r1 + 1;
        goto L3
    L8:
        int[] r13 = new int[Math.max(r8, r9)];
        int r15 = 0;
    L9:
        if (r15 >= r18) goto L20;
        int r6 = 0;
    L11:
        if (r6 >= r9) goto L13;
        d(r10, r13, r8, r6, r7, r11);
        System.arraycopy(r13, 0, r10, r6 * r8, r8);
        r6 = r6 + 1;
        goto L11
    L13:
        int r14 = 0;
    L14:
        if (r14 >= r8) goto L19;
        int r16 = r14;
        e(r10, r13, r8, r9, r14, r7, r11);
        int r2 = 0;
        int r20 = r16;
    L16:
        if (r2 >= r9) goto L18;
        r10[r20] = r13[r2];
        r20 = r20 + r8;
        r2 = r2 + 1;
        goto L16
    L18:
        r14 = r16 + 1;
        goto L14
    L19:
        r15 = r15 + 1;
        goto L9
    L20:
        r17.setPixels(r10, 0, r8, 0, 0, r8, r9);
    }

    private static void d(int[] r10, int[] r11, int r12, int r13, int r14, int[] r15) {
        int r0 = r12 * r13;
        int r16 = ((r13 + 1) * r12) - 1;
        int r1 = r14 >> 1;
        int r2 = -r1;
        int r3 = 0;
        int r4 = 0;
        int r5 = 0;
        int r6 = 0;
    L4:
        if (r2 >= (r12 + r1)) goto L9;
        int r7 = r10[a(r0 + r2, r0, r16)];
        r3 = r3 + ((r7 >> 16) & 255);
        r4 = r4 + ((r7 >> 8) & 255);
        r5 = r5 + (r7 & 255);
        r6 = r6 + (r7 >>> 24);
        if (r2 < r1) goto L8;
        r11[r2 - r1] = (((r15[r6] << 24) | (r15[r3] << 16)) | (r15[r4] << 8)) | r15[r5];
        int r8 = r10[a((r2 - (r14 - 1)) + r0, r0, r16)];
        r3 = r3 - ((r8 >> 16) & 255);
        r4 = r4 - ((r8 >> 8) & 255);
        r5 = r5 - (r8 & 255);
        r6 = r6 - (r8 >>> 24);
    L8:
        r2 = r2 + 1;
        goto L4
    }

    private static void e(int[] r9, int[] r10, int r11, int r12, int r13, int r14, int[] r15) {
        int r16 = ((r12 - 1) * r11) + r13;
        int r0 = (r14 >> 1) * r11;
        int r17 = (r14 - 1) * r11;
        int r1 = r13 - r0;
        int r2 = 0;
        int r3 = 0;
        int r4 = 0;
        int r5 = 0;
        int r6 = 0;
    L4:
        if (r1 > (r16 + r0)) goto L9;
        int r7 = r9[a(r1, r13, r16)];
        r2 = r2 + ((r7 >> 16) & 255);
        r3 = r3 + ((r7 >> 8) & 255);
        r4 = r4 + (r7 & 255);
        r5 = r5 + (r7 >>> 24);
        if ((r1 - r0) < r13) goto L8;
        r10[r6] = (((r15[r5] << 24) | (r15[r2] << 16)) | (r15[r3] << 8)) | r15[r4];
        r6 = r6 + 1;
        int r8 = r9[a(r1 - r17, r13, r16)];
        r2 = r2 - ((r8 >> 16) & 255);
        r3 = r3 - ((r8 >> 8) & 255);
        r4 = r4 - (r8 & 255);
        r5 = r5 - (r8 >>> 24);
    L8:
        r1 = r1 + r11;
        goto L4
    }
}
