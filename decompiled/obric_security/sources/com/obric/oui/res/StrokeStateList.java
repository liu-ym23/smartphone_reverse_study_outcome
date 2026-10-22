package com.obric.oui.res;

import android.R;
import android.util.StateSet;
import com.obric.oui.color.StrokeConfig;
import com.obric.oui.material.MaterialConfigFormatNames;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StrokeStateList.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B/\b\u0002\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u0006\u0010\u000b\u001a\u00020\u0000J\u001e\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007J\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006J\u0006\u0010\u000f\u001a\u00020\u0010R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0018\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/obric/oui/res/StrokeStateList;", "", "stateSpecs", "", "", "strokes", "Lcom/obric/oui/color/StrokeConfig;", "defaultStroke", "([[I[Lcom/obric/oui/color/StrokeConfig;Lcom/obric/oui/color/StrokeConfig;)V", "[[I", "[Lcom/obric/oui/color/StrokeConfig;", "deepCopy", "getConfigForState", "stateSet", "getDefaultStroke", "isStateful", "", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class StrokeStateList {
    public static final Companion Companion = null;
    private static final int[] NORMAL = null;
    private final StrokeConfig defaultStroke;
    private final int[][] stateSpecs;
    private final StrokeConfig[] strokes;

    /* JADX INFO: compiled from: StrokeStateList.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0007JP\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0006H\u0007J+\u0010\u000b\u001a\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u00142\u000e\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0014H\u0007¢\u0006\u0002\u0010\u0016J\u0012\u0010\u0017\u001a\u00020\f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0006H\u0007J\u001e\u0010\u0017\u001a\u00020\f2\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/obric/oui/res/StrokeStateList$Companion;", "", "()V", "NORMAL", "", "getConfigForTransition", "Lcom/obric/oui/color/StrokeConfig;", "fromConfig", "toConfig", "progress", "", "of", "Lcom/obric/oui/res/StrokeStateList;", "normal", "activated", "checked", "pressed", "hovered", "disabled", "states", "", "strokes", "([[I[Lcom/obric/oui/color/StrokeConfig;)Lcom/obric/oui/res/StrokeStateList;", "valueOf", MaterialConfigFormatNames.STROKE, "Lkotlin/Pair;", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        @JvmStatic
        public final StrokeStateList of() {
            return of$default(this, null, null, null, null, null, null, 63, null);
        }

        @JvmStatic
        public final StrokeStateList of(StrokeConfig r10) {
            return of$default(this, r10, null, null, null, null, null, 62, null);
        }

        @JvmStatic
        public final StrokeStateList of(StrokeConfig r10, StrokeConfig r11) {
            return of$default(this, r10, r11, null, null, null, null, 60, null);
        }

        @JvmStatic
        public final StrokeStateList of(StrokeConfig r10, StrokeConfig r11, StrokeConfig r12) {
            return of$default(this, r10, r11, r12, null, null, null, 56, null);
        }

        @JvmStatic
        public final StrokeStateList of(StrokeConfig r10, StrokeConfig r11, StrokeConfig r12, StrokeConfig r13) {
            return of$default(this, r10, r11, r12, r13, null, null, 48, null);
        }

        @JvmStatic
        public final StrokeStateList of(StrokeConfig r10, StrokeConfig r11, StrokeConfig r12, StrokeConfig r13, StrokeConfig r14) {
            return of$default(this, r10, r11, r12, r13, r14, null, 32, null);
        }

        private Companion() {
        }

        @JvmStatic
        public final StrokeConfig getConfigForTransition(StrokeConfig r1, StrokeConfig r2, float r3) {
            Intrinsics.checkNotNullParameter(r1, "fromConfig");
            Intrinsics.checkNotNullParameter(r2, "toConfig");
            return StrokeConfig.Companion.lerp(r1, r2, r3);
        }

        @JvmStatic
        public final StrokeStateList valueOf(StrokeConfig r5) {
            return new StrokeStateList(new int[][]{StrokeStateList.access$getNORMAL$cp()}, new StrokeConfig[]{r5}, r5, null);
        }

        @JvmStatic
        public final StrokeStateList of(int[][] r7, StrokeConfig[] r8) {
            Intrinsics.checkNotNullParameter(r7, "states");
            Intrinsics.checkNotNullParameter(r8, "strokes");
            int[][] r6 = r7;
            if (r6.length != r8.length) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L31;
            if (r6.length != 0) goto L10;
            boolean r1 = true;
        L12:
            if ((!r1) == false) goto L29;
            int r9 = r6.length;
            int r2 = 0;
        L14:
            DefaultConstructorMarker r3 = null;
            if (r2 >= r9) goto L23;
            int r4 = r2 + 1;
            if (r7[r2].length != 0) goto L19;
            boolean r5 = true;
        L20:
            if (r5 == true) goto L21;
            r2 = r4;
            goto L14
        L21:
            StrokeConfig r10 = r8[r2];
        L24:
            if (r10 != null) goto L27;
            r10 = r8[0];
        L27:
            return new StrokeStateList(r7, r8, r10, r3);
        L19:
            r5 = false;
            goto L20
        L23:
            r10 = null;
            goto L24
        L29:
            throw new IllegalArgumentException("states must not be empty".toString());
        L10:
            r1 = false;
            goto L12
        L31:
            throw new IllegalArgumentException(("states.size(" + r6.length + ") must equal strokes.size(" + r8.length + ')').toString());
        L5:
            r0 = false;
            goto L6
        }

        public static /* synthetic */ StrokeStateList of$default(Companion r4, StrokeConfig r5, StrokeConfig r6, StrokeConfig r7, StrokeConfig r8, StrokeConfig r9, StrokeConfig r10, int r11, Object r12) {
            if ((r11 & 1) == 0) goto L6;
            r5 = null;
        L6:
            if ((r11 & 2) == 0) goto L8;
            StrokeConfig r13 = r5;
        L10:
            if ((r11 & 4) == 0) goto L12;
            StrokeConfig r0 = r13;
        L14:
            if ((r11 & 8) == 0) goto L16;
            StrokeConfig r1 = r5;
        L18:
            if ((r11 & 16) == 0) goto L20;
            StrokeConfig r2 = r5;
        L22:
            if ((r11 & 32) == 0) goto L24;
            StrokeConfig r3 = r5;
        L26:
            return r4.of(r5, r13, r0, r1, r2, r3);
        L24:
            r3 = r10;
            goto L26
        L20:
            r2 = r9;
            goto L22
        L16:
            r1 = r8;
            goto L18
        L12:
            r0 = r7;
            goto L14
        L8:
            r13 = r6;
            goto L10
        }

        @JvmStatic
        public final StrokeStateList of(StrokeConfig r9, StrokeConfig r10, StrokeConfig r11, StrokeConfig r12, StrokeConfig r13, StrokeConfig r14) {
            if (Intrinsics.areEqual(r9, r10) == false) goto L15;
            if (Intrinsics.areEqual(r9, r11) == false) goto L15;
            if (Intrinsics.areEqual(r9, r12) == false) goto L15;
            if (Intrinsics.areEqual(r9, r13) == false) goto L15;
            if (Intrinsics.areEqual(r9, r14) == false) goto L15;
            return valueOf(r9);
        L15:
            return new StrokeStateList(new int[][]{new int[]{R.attr.state_pressed}, new int[]{R.attr.state_hovered}, new int[]{R.attr.state_checked}, new int[]{R.attr.state_activated}, new int[]{-16842910}, new int[]{R.attr.state_enabled}}, new StrokeConfig[]{r12, r13, r11, r10, r14, r9}, r9, null);
        }

        @JvmStatic
        public final StrokeStateList valueOf(Pair<Float, Integer> r8) {
            if (r8 != null) goto L4;
            StrokeConfig r9 = null;
        L6:
            return valueOf(r9);
        L4:
            r9 = new StrokeConfig(r8.getFirst().floatValue(), r8.getSecond().intValue(), null, 4, null);
            goto L6
        }
    }

    public /* synthetic */ StrokeStateList(int[][] r1, StrokeConfig[] r2, StrokeConfig r3, DefaultConstructorMarker r4) {
        this(r1, r2, r3);
    }

    @JvmStatic
    public static final StrokeConfig getConfigForTransition(StrokeConfig r1, StrokeConfig r2, float r3) {
        return Companion.getConfigForTransition(r1, r2, r3);
    }

    @JvmStatic
    public static final StrokeStateList of() {
        return Companion.of();
    }

    @JvmStatic
    public static final StrokeStateList of(StrokeConfig r1) {
        return Companion.of(r1);
    }

    @JvmStatic
    public static final StrokeStateList of(StrokeConfig r1, StrokeConfig r2) {
        return Companion.of(r1, r2);
    }

    @JvmStatic
    public static final StrokeStateList of(StrokeConfig r1, StrokeConfig r2, StrokeConfig r3) {
        return Companion.of(r1, r2, r3);
    }

    @JvmStatic
    public static final StrokeStateList of(StrokeConfig r1, StrokeConfig r2, StrokeConfig r3, StrokeConfig r4) {
        return Companion.of(r1, r2, r3, r4);
    }

    @JvmStatic
    public static final StrokeStateList of(StrokeConfig r6, StrokeConfig r7, StrokeConfig r8, StrokeConfig r9, StrokeConfig r10) {
        return Companion.of(r6, r7, r8, r9, r10);
    }

    @JvmStatic
    public static final StrokeStateList of(StrokeConfig r7, StrokeConfig r8, StrokeConfig r9, StrokeConfig r10, StrokeConfig r11, StrokeConfig r12) {
        return Companion.of(r7, r8, r9, r10, r11, r12);
    }

    @JvmStatic
    public static final StrokeStateList of(int[][] r1, StrokeConfig[] r2) {
        return Companion.of(r1, r2);
    }

    @JvmStatic
    public static final StrokeStateList valueOf(StrokeConfig r1) {
        return Companion.valueOf(r1);
    }

    @JvmStatic
    public static final StrokeStateList valueOf(Pair<Float, Integer> r1) {
        return Companion.valueOf(r1);
    }

    public final StrokeConfig getConfigForState(int[] r3) {
        Intrinsics.checkNotNullParameter(r3, "stateSet");
        return getConfigForState$default(this, r3, null, 2, null);
    }

    private StrokeStateList(int[][] r3, StrokeConfig[] r4, StrokeConfig r5) {
        this.stateSpecs = r3;
        this.strokes = r4;
        this.defaultStroke = r5;
        boolean r0 = false;
        if (r3.length != r4.length) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L16;
        if (r3.length != 0) goto L11;
        r0 = true;
    L11:
        if ((!r0) == false) goto L14;
        return;
    L14:
        throw new IllegalArgumentException("stateSpecs must not be empty".toString());
    L16:
        throw new IllegalArgumentException(("stateSpecs.size(" + r3.length + ") must equal strokes.size(" + r4.length + ')').toString());
    L5:
        r2 = false;
        goto L6
    }

    public static final /* synthetic */ int[] access$getNORMAL$cp() {
        return NORMAL;
    }

    public final boolean isStateful() {
        int[][] r5 = this.stateSpecs;
        int r0 = r5.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L15;
        if (r5[r2].length != 0) goto L7;
        boolean r3 = true;
    L9:
        if ((!r3) == true) goto L12;
        r2 = r2 + 1;
        goto L3
    L12:
        return true;
    L7:
        r3 = false;
        goto L9
    L15:
        return false;
    }

    public final StrokeConfig getDefaultStroke() {
        return this.defaultStroke;
    }

    public final StrokeStateList deepCopy() {
        int[][] r0 = this.stateSpecs;
        ArrayList r1 = new ArrayList(r0.length);
        int r2 = r0.length;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L5;
        int[] r5 = r0[r4];
        int[] r6 = Arrays.copyOf(r5, r5.length);
        Intrinsics.checkNotNullExpressionValue(r6, "copyOf(this, size)");
        r1.add(r6);
        r4 = r4 + 1;
        goto L3
    L5:
        Object[] r3 = r1.toArray(new int[0][]);
        if (r3 == null) goto L26;
        int[][] r7 = (int[][]) r3;
        StrokeConfig[] r8 = this.strokes;
        ArrayList r9 = new ArrayList(r8.length);
        int r10 = r8.length;
        int r11 = 0;
    L8:
        StrokeConfig r12 = null;
        if (r11 >= r10) goto L15;
        StrokeConfig r13 = r8[r11];
        if (r13 == null) goto L14;
        r12 = r13.copy();
    L14:
        r9.add(r12);
        r11 = r11 + 1;
        goto L8
    L15:
        Object[] r14 = r9.toArray(new StrokeConfig[0]);
        if (r14 == null) goto L24;
        StrokeConfig[] r15 = (StrokeConfig[]) r14;
        StrokeConfig r16 = this.defaultStroke;
        if (r16 == null) goto L22;
        r12 = r16.copy();
    L22:
        return new StrokeStateList(r7, r15, r12);
    L24:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    L26:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    public static /* synthetic */ StrokeConfig getConfigForState$default(StrokeStateList r0, int[] r1, StrokeConfig r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = r0.defaultStroke;
    L6:
        return r0.getConfigForState(r1, r2);
    }

    public final StrokeConfig getConfigForState(int[] r5, StrokeConfig r6) {
        Intrinsics.checkNotNullParameter(r5, "stateSet");
        int r0 = this.stateSpecs.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L9;
        int r2 = r1 + 1;
        if (StateSet.stateSetMatches(this.stateSpecs[r1], r5) == true) goto L7;
        r1 = r2;
        goto L3
    L7:
        return this.strokes[r1];
    L9:
        return r6;
    }

    static {
        Companion = new Companion(null);
        NORMAL = new int[]{R.attr.state_enabled};
    }
}
