package com.bytedanceos.common;

/* JADX INFO: loaded from: classes2.dex */
public final class CardPositionDecider {

    public interface HeaderIdProvider {
        long getHeaderId(int position);
    }

    public CardPositionDecider() {
    }

    public static int compute(int position, int itemCount, HeaderIdProvider provider) {
        long r0 = provider.getHeaderId(position);
        if (position != 0) goto L5;
        boolean r4 = true;
    L7:
        if (position != (itemCount - 1)) goto L9;
        boolean r8 = true;
    L10:
        if (r4 == false) goto L19;
        if (r8 == false) goto L14;
        return 0;
    L14:
        if (r0 == provider.getHeaderId(position + 1)) goto L17;
        return 0;
    L17:
        return 1;
    L19:
        if (r8 == true) goto L21;
        long r5 = provider.getHeaderId(position - 1);
        long r7 = provider.getHeaderId(position + 1);
        if (r0 != r5) goto L28;
    L30:
        if (r0 == r5) goto L32;
    L34:
        if (r0 != r5) goto L36;
        return 2;
    L36:
        if (r0 != r7) goto L42;
        return 1;
    L42:
        return 2;
    L32:
        if (r0 == r7) goto L34;
        return 3;
    L28:
        if (r0 == r7) goto L30;
        return 0;
    L21:
        if (r0 == provider.getHeaderId(position - 1)) goto L24;
        return 0;
    L24:
        return 3;
    L9:
        r8 = false;
        goto L10
    L5:
        r4 = false;
        goto L7
    }
}
