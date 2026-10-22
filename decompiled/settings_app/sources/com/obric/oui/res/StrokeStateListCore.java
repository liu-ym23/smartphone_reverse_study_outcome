package com.obric.oui.res;

import android.R;
import android.util.StateSet;
import com.obric.oui.color.StrokeConfigCore;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class StrokeStateListCore {
    private static final int[] NORMAL = null;
    private final StrokeConfigCore defaultStroke;
    private final int[][] stateSpecs;
    private final StrokeConfigCore[] strokes;

    static {
        NORMAL = new int[]{R.attr.state_enabled};
    }

    private StrokeStateListCore(int[][] r3, StrokeConfigCore[] r4, StrokeConfigCore r5) {
        if (r3.length != r4.length) goto L11;
        if (r3.length == 0) goto L9;
        this.stateSpecs = r3;
        this.strokes = r4;
        this.defaultStroke = r5;
        return;
    L9:
        throw new IllegalArgumentException("stateSpecs must not be empty");
    L11:
        throw new IllegalArgumentException("stateSpecs.size(" + r3.length + ") must equal strokes.size(" + r4.length + ")");
    }

    public boolean isStateful() {
        int[][] r4 = this.stateSpecs;
        int r0 = r4.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        if (r4[r2].length > 0) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public StrokeConfigCore getDefaultStroke() {
        return this.defaultStroke;
    }

    public StrokeStateListCore deepCopy() {
        int[][] r0 = new int[this.stateSpecs.length][];
        int r1 = 0;
        int r2 = 0;
    L3:
        int[][] r3 = this.stateSpecs;
        if (r2 >= r3.length) goto L6;
        int[] r4 = r3[r2];
        r0[r2] = Arrays.copyOf(r4, r4.length);
        r2 = r2 + 1;
        goto L3
    L6:
        StrokeConfigCore[] r5 = new StrokeConfigCore[this.strokes.length];
    L7:
        StrokeConfigCore[] r6 = this.strokes;
        if (r1 >= r6.length) goto L11;
        r5[r1] = StrokeConfigCore.deepCopy(r6[r1]);
        r1 = r1 + 1;
        goto L7
    L11:
        return new StrokeStateListCore(r0, r5, StrokeConfigCore.deepCopy(this.defaultStroke));
    }

    public StrokeConfigCore getConfigForState(int[] r2) {
        return getConfigForState(r2, this.defaultStroke);
    }

    public StrokeConfigCore getConfigForState(int[] r4, StrokeConfigCore r5) {
        int r0 = 0;
    L3:
        int[][] r1 = this.stateSpecs;
        if (r0 >= r1.length) goto L10;
        if (StateSet.stateSetMatches(r1[r0], r4) == true) goto L8;
        r0 = r0 + 1;
        goto L3
    L8:
        return this.strokes[r0];
    L10:
        return r5;
    }

    public static StrokeConfigCore getConfigForTransition(StrokeConfigCore r0, StrokeConfigCore r1, float r2) {
        return StrokeConfigCore.lerp(r0, r1, r2);
    }

    public static StrokeStateListCore valueOf(StrokeConfigCore r5) {
        return new StrokeStateListCore(new int[][]{NORMAL}, new StrokeConfigCore[]{r5}, r5);
    }

    public static StrokeStateListCore of(int[][] r3, StrokeConfigCore[] r4) {
        if (r3.length != r4.length) goto L21;
        if (r3.length == 0) goto L19;
        int r1 = 0;
    L8:
        if (r1 >= r3.length) goto L13;
        if (r3[r1].length == 0) goto L11;
        r1 = r1 + 1;
        goto L8
    L11:
        StrokeConfigCore r2 = r4[r1];
    L14:
        if (r2 != null) goto L17;
        r2 = r4[0];
    L17:
        return new StrokeStateListCore(r3, r4, r2);
    L13:
        r2 = null;
        goto L14
    L19:
        throw new IllegalArgumentException("states must not be empty");
    L21:
        throw new IllegalArgumentException("states.size(" + r3.length + ") must equal strokes.size(" + r4.length + ")");
    }

    public static StrokeStateListCore of() {
        return of(null);
    }

    public static StrokeStateListCore of(StrokeConfigCore r0) {
        return of(r0, r0);
    }

    public static StrokeStateListCore of(StrokeConfigCore r0, StrokeConfigCore r1) {
        return of(r0, r1, r1);
    }

    public static StrokeStateListCore of(StrokeConfigCore r0, StrokeConfigCore r1, StrokeConfigCore r2) {
        return of(r0, r1, r2, r0);
    }

    public static StrokeStateListCore of(StrokeConfigCore r0, StrokeConfigCore r1, StrokeConfigCore r2, StrokeConfigCore r3) {
        return of(r0, r1, r2, r3, r0);
    }

    public static StrokeStateListCore of(StrokeConfigCore r6, StrokeConfigCore r7, StrokeConfigCore r8, StrokeConfigCore r9, StrokeConfigCore r10) {
        return of(r6, r7, r8, r9, r10, r6);
    }

    public static StrokeStateListCore of(StrokeConfigCore r9, StrokeConfigCore r10, StrokeConfigCore r11, StrokeConfigCore r12, StrokeConfigCore r13, StrokeConfigCore r14) {
        if (same(r9, r10) == false) goto L15;
        if (same(r9, r11) == false) goto L15;
        if (same(r9, r12) == false) goto L15;
        if (same(r9, r13) == false) goto L15;
        if (same(r9, r14) == false) goto L15;
        return valueOf(r9);
    L15:
        return new StrokeStateListCore(new int[][]{new int[]{R.attr.state_pressed}, new int[]{R.attr.state_hovered}, new int[]{R.attr.state_checked}, new int[]{R.attr.state_activated}, new int[]{-16842910}, new int[]{R.attr.state_enabled}}, new StrokeConfigCore[]{r12, r13, r11, r10, r14, r9}, r9);
    }

    private static boolean same(StrokeConfigCore r4, StrokeConfigCore r5) {
        if (r4 != r5) goto L6;
        return true;
    L6:
        if (r4 == null) goto L18;
        if (r5 == null) goto L18;
        if (r4.getWidth() != r5.getWidth()) goto L17;
        if (r4.getColor() != r5.getColor()) goto L17;
        if (r4.getBlendMode() != r5.getBlendMode()) goto L17;
        return true;
    L17:
        return false;
    L18:
        return false;
    }
}
