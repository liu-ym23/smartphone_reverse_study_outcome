package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitArray;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes4.dex */
public final class HighLevelEncoder {
    private static final int[][] CHAR_MAP = null;
    static final int[][] LATCH_TABLE = null;
    static final int MODE_DIGIT = 2;
    static final int MODE_LOWER = 1;
    static final int MODE_MIXED = 3;
    static final String[] MODE_NAMES = null;
    static final int MODE_PUNCT = 4;
    static final int MODE_UPPER = 0;
    static final int[][] SHIFT_TABLE = null;
    private final byte[] text;

    static {
        MODE_NAMES = new String[]{"UPPER", "LOWER", "DIGIT", "MIXED", "PUNCT"};
        LATCH_TABLE = new int[][]{new int[]{0, 327708, 327710, 327709, 656318}, new int[]{590318, 0, 327710, 327709, 656318}, new int[]{262158, 590300, 0, 590301, 932798}, new int[]{327709, 327708, 656318, 0, 327710}, new int[]{327711, 656380, 656382, 656381, 0}};
        int[][] r0 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{5, 256});
        CHAR_MAP = r0;
        r0[0][32] = 1;
        int r1 = 65;
    L4:
        if (r1 > 90) goto L6;
        CHAR_MAP[0][r1] = (r1 - 65) + 2;
        r1 = r1 + 1;
        goto L4
    L6:
        CHAR_MAP[1][32] = 1;
        int r2 = 97;
    L8:
        if (r2 > 122) goto L10;
        CHAR_MAP[1][r2] = (r2 - 97) + 2;
        r2 = r2 + 1;
        goto L8
    L10:
        CHAR_MAP[2][32] = 1;
        int r3 = 48;
    L12:
        if (r3 > 57) goto L14;
        CHAR_MAP[2][r3] = (r3 - 48) + 2;
        r3 = r3 + 1;
        goto L12
    L14:
        int[] r4 = CHAR_MAP[2];
        r4[44] = 12;
        r4[46] = 13;
        int[] r5 = {0, 32, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 27, 28, 29, 30, 31, 64, 92, 94, 95, 96, 124, 126, 127};
        int r7 = 0;
    L15:
        if (r7 >= 28) goto L17;
        CHAR_MAP[3][r5[r7]] = r7;
        r7 = r7 + 1;
        goto L15
    L17:
        int[] r8 = {0, 13, 0, 0, 0, 0, 33, 39, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 58, 59, 60, 61, 62, 63, 91, 93, 123, 125};
        int r9 = 0;
    L18:
        if (r9 >= 31) goto L23;
        int r10 = r8[r9];
        if (r10 <= 0) goto L22;
        CHAR_MAP[4][r10] = r9;
    L22:
        r9 = r9 + 1;
        goto L18
    L23:
        int[][] r6 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{6, 6});
        SHIFT_TABLE = r6;
        int r11 = r6.length;
        int r12 = 0;
    L24:
        if (r12 >= r11) goto L26;
        Arrays.fill(r6[r12], -1);
        r12 = r12 + 1;
        goto L24
    L26:
        int[][] r13 = SHIFT_TABLE;
        r13[0][4] = 0;
        int[] r14 = r13[1];
        r14[4] = 0;
        r14[0] = 28;
        r13[3][4] = 0;
        int[] r15 = r13[2];
        r15[4] = 0;
        r15[0] = 15;
    }

    public HighLevelEncoder(byte[] r1) {
        this.text = r1;
    }

    public BitArray encode() {
        Collection<State> r0 = Collections.singletonList(State.INITIAL_STATE);
        int r2 = 0;
    L3:
        byte[] r3 = this.text;
        if (r2 >= r3.length) goto L32;
        int r4 = r2 + 1;
        if (r4 >= r3.length) goto L8;
        byte r5 = r3[r4];
    L9:
        byte r6 = r3[r2];
        if (r6 == 13) goto L25;
        if (r6 != 44) goto L14;
        if (r5 == 32) goto L23;
    L17:
        int r7 = 0;
    L27:
        if (r7 <= 0) goto L29;
        r0 = updateStateListForPair(r0, r2, r7);
        r2 = r4;
    L30:
        r2 = r2 + 1;
        goto L3
    L29:
        r0 = updateStateListForChar(r0, r2);
        goto L30
    L23:
        r7 = 4;
        goto L27
    L14:
        if (r6 != 46) goto L16;
        if (r5 != 32) goto L17;
        r7 = 3;
        goto L27
    L16:
        if (r6 != 58) goto L17;
        if (r5 != 32) goto L17;
        r7 = 5;
        goto L27
    L25:
        if (r5 != 10) goto L17;
        r7 = 2;
        goto L27
    L8:
        r5 = 0;
        goto L9
    L32:
        return ((State) Collections.min(r0, new AnonymousClass1(this))).toBitArray(this.text);
    }

    private Collection<State> updateStateListForChar(Iterable<State> r3, int r4) {
        LinkedList r0 = new LinkedList();
        Iterator<State> r5 = r3.iterator();
    L4:
        if (r5.hasNext() == false) goto L7;
        updateStateForChar(r5.next(), r4, r0);
        goto L4
    L7:
        return simplifyStates(r0);
    }

    private void updateStateForChar(State r7, int r8, Collection<State> r9) {
        char r6 = (char) (this.text[r8] & 255);
        int r1 = 0;
        if (CHAR_MAP[r7.getMode()][r6] <= 0) goto L5;
        boolean r0 = true;
    L6:
        State r2 = null;
    L8:
        if (r1 > 4) goto L25;
        int r3 = CHAR_MAP[r1][r6];
        if (r3 <= 0) goto L23;
        if (r2 != null) goto L13;
        r2 = r7.endBinaryShift(r8);
    L13:
        if (r0 == true) goto L15;
    L18:
        r9.add(r2.latchAndAppend(r1, r3));
    L19:
        if (r0 == true) goto L23;
        if (SHIFT_TABLE[r7.getMode()][r1] < 0) goto L23;
        r9.add(r2.shiftAndAppend(r1, r3));
        goto L23
    L15:
        if (r1 == r7.getMode()) goto L18;
        if (r1 != 2) goto L19;
    L23:
        r1 = r1 + 1;
        goto L8
    L25:
        if (r7.getBinaryShiftByteCount() <= 0) goto L27;
    L28:
        r9.add(r7.addBinaryShiftChar(r8));
        return;
    L27:
        if (CHAR_MAP[r7.getMode()][r6] == 0) goto L28;
        return;
    L5:
        r0 = false;
        goto L6
    }

    private static Collection<State> updateStateListForPair(Iterable<State> r2, int r3, int r4) {
        LinkedList r0 = new LinkedList();
        Iterator<State> r5 = r2.iterator();
    L4:
        if (r5.hasNext() == false) goto L7;
        updateStateForPair(r5.next(), r3, r4, r0);
        goto L4
    L7:
        return simplifyStates(r0);
    }

    private static void updateStateForPair(State r4, int r5, int r6, Collection<State> r7) {
        State r0 = r4.endBinaryShift(r5);
        r7.add(r0.latchAndAppend(4, r6));
        if (r4.getMode() == 4) goto L6;
        r7.add(r0.shiftAndAppend(4, r6));
    L6:
        if (r6 == 3) goto L8;
        if (r6 == 4) goto L8;
    L10:
        if (r4.getBinaryShiftByteCount() <= 0) goto L13;
        r7.add(r4.addBinaryShiftChar(r5).addBinaryShiftChar(r5 + 1));
        return;
    L13:
        return;
    L8:
        r7.add(r0.latchAndAppend(2, 16 - r6).latchAndAppend(2, 1));
        goto L10
    }

    private static Collection<State> simplifyStates(Iterable<State> r5) {
        LinkedList r0 = new LinkedList();
        Iterator<State> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L17;
        State r1 = r6.next();
        Iterator r2 = r0.iterator();
    L7:
        if (r2.hasNext() == false) goto L14;
        State r3 = (State) r2.next();
        if (r3.isBetterThanOrEqualTo(r1) == true) goto L10;
        if (r1.isBetterThanOrEqualTo(r3) == false) goto L7;
        r2.remove();
        goto L7
    L10:
        boolean r4 = false;
    L15:
        if (r4 == false) goto L4;
        r0.add(r1);
        goto L4
    L14:
        r4 = true;
        goto L15
    L17:
        return r0;
    }
}
