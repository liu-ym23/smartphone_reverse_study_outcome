package com.obric.oui.res;

import com.obric.oui.color.StrokeConfig;
import com.obric.oui.color.StrokeConfigCore;
import com.obric.oui.color.StrokeConfigKt;
import com.obric.oui.material.MaterialConfigFormatNames;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StrokeStateList.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0000J\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0007J\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007J\u0006\u0010\f\u001a\u00020\rJ\r\u0010\u000e\u001a\u00020\u0003H\u0000¢\u0006\u0002\b\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/obric/oui/res/StrokeStateList;", "", "core", "Lcom/obric/oui/res/StrokeStateListCore;", "(Lcom/obric/oui/res/StrokeStateListCore;)V", "deepCopy", "getConfigForState", "Lcom/obric/oui/color/StrokeConfig;", "stateSet", "", "defaultStroke", "getDefaultStroke", "isStateful", "", "toCore", "toCore$OUI_standardRelease", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class StrokeStateList {
    public static final Companion Companion = null;
    private final StrokeStateListCore core;

    /* JADX INFO: compiled from: StrokeStateList.kt */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u0007J\"\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0007JP\u0010\u000e\u001a\u00020\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\tH\u0007J+\u0010\u000e\u001a\u00020\u00042\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u000e\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0016H\u0007¢\u0006\u0002\u0010\u0019J\u0012\u0010\u001a\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\tH\u0007J\u001e\u0010\u001a\u001a\u00020\u00042\u0014\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cH\u0007J!\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u0016*\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0016H\u0002¢\u0006\u0002\u0010 ¨\u0006!"}, d2 = {"Lcom/obric/oui/res/StrokeStateList$Companion;", "", "()V", "fromCore", "Lcom/obric/oui/res/StrokeStateList;", "core", "Lcom/obric/oui/res/StrokeStateListCore;", "fromCore$OUI_standardRelease", "getConfigForTransition", "Lcom/obric/oui/color/StrokeConfig;", "fromConfig", "toConfig", "progress", "", "of", "normal", "activated", "checked", "pressed", "hovered", "disabled", "states", "", "", "strokes", "([[I[Lcom/obric/oui/color/StrokeConfig;)Lcom/obric/oui/res/StrokeStateList;", "valueOf", MaterialConfigFormatNames.STROKE, "Lkotlin/Pair;", "", "toCoreArray", "Lcom/obric/oui/color/StrokeConfigCore;", "([Lcom/obric/oui/color/StrokeConfig;)[Lcom/obric/oui/color/StrokeConfigCore;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
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

        public final StrokeStateList fromCore$OUI_standardRelease(StrokeStateListCore r2) {
            Intrinsics.checkNotNullParameter(r2, "core");
            return new StrokeStateList(r2, null);
        }

        @JvmStatic
        public final StrokeConfig getConfigForTransition(StrokeConfig r1, StrokeConfig r2, float r3) {
            Intrinsics.checkNotNullParameter(r1, "fromConfig");
            Intrinsics.checkNotNullParameter(r2, "toConfig");
            StrokeConfigCore r0 = StrokeStateListCore.getConfigForTransition(r1.toCore$OUI_standardRelease(), r2.toCore$OUI_standardRelease(), r3);
            if (r0 != null) goto L6;
            return null;
        L6:
            return StrokeConfigKt.toConfig(r0);
        }

        @JvmStatic
        public final StrokeStateList valueOf(StrokeConfig r3) {
            DefaultConstructorMarker r0 = null;
            if (r3 != null) goto L5;
            StrokeConfigCore r4 = null;
        L6:
            StrokeStateListCore r5 = StrokeStateListCore.valueOf(r4);
            Intrinsics.checkNotNullExpressionValue(r5, "valueOf(stroke?.toCore())");
            return new StrokeStateList(r5, r0);
        L5:
            r4 = r3.toCore$OUI_standardRelease();
            goto L6
        }

        @JvmStatic
        public final StrokeStateList of(int[][] r2, StrokeConfig[] r3) {
            Intrinsics.checkNotNullParameter(r2, "states");
            Intrinsics.checkNotNullParameter(r3, "strokes");
            StrokeStateListCore r1 = StrokeStateListCore.of(r2, toCoreArray(r3));
            Intrinsics.checkNotNullExpressionValue(r1, "of(states, strokes.toCoreArray())");
            return new StrokeStateList(r1, null);
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
        public final StrokeStateList of(StrokeConfig r8, StrokeConfig r9, StrokeConfig r10, StrokeConfig r11, StrokeConfig r12, StrokeConfig r13) {
            DefaultConstructorMarker r0 = null;
            if (r8 != null) goto L5;
            StrokeConfigCore r1 = null;
        L6:
            if (r9 != null) goto L8;
            StrokeConfigCore r2 = null;
        L9:
            if (r10 != null) goto L11;
            StrokeConfigCore r3 = null;
        L12:
            if (r11 != null) goto L14;
            StrokeConfigCore r4 = null;
        L15:
            if (r12 != null) goto L17;
            StrokeConfigCore r5 = null;
        L18:
            if (r13 != null) goto L20;
            StrokeConfigCore r6 = null;
        L21:
            StrokeStateListCore r14 = StrokeStateListCore.of(r1, r2, r3, r4, r5, r6);
            Intrinsics.checkNotNullExpressionValue(r14, "of(\n                    …Core(),\n                )");
            return new StrokeStateList(r14, r0);
        L20:
            r6 = r13.toCore$OUI_standardRelease();
            goto L21
        L17:
            r5 = r12.toCore$OUI_standardRelease();
            goto L18
        L14:
            r4 = r11.toCore$OUI_standardRelease();
            goto L15
        L11:
            r3 = r10.toCore$OUI_standardRelease();
            goto L12
        L8:
            r2 = r9.toCore$OUI_standardRelease();
            goto L9
        L5:
            r1 = r8.toCore$OUI_standardRelease();
            goto L6
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

        private final StrokeConfigCore[] toCoreArray(StrokeConfig[] r5) {
            ArrayList r4 = new ArrayList(r5.length);
            int r0 = r5.length;
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L9;
            StrokeConfig r3 = r5[r2];
            if (r3 != null) goto L7;
            StrokeConfigCore r6 = null;
        L8:
            r4.add(r6);
            r2 = r2 + 1;
            goto L3
        L7:
            r6 = r3.toCore$OUI_standardRelease();
            goto L8
        L9:
            Object[] r7 = r4.toArray(new StrokeConfigCore[0]);
            if (r7 == null) goto L14;
            return (StrokeConfigCore[]) r7;
        L14:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ StrokeStateList(StrokeStateListCore r1, DefaultConstructorMarker r2) {
        this(r1);
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

    private StrokeStateList(StrokeStateListCore r1) {
        this.core = r1;
    }

    public final boolean isStateful() {
        return this.core.isStateful();
    }

    public final StrokeConfig getDefaultStroke() {
        StrokeConfigCore r0 = this.core.getDefaultStroke();
        if (r0 != null) goto L6;
        return null;
    L6:
        return StrokeConfigKt.toConfig(r0);
    }

    public final StrokeStateList deepCopy() {
        StrokeStateListCore r2 = this.core.deepCopy();
        Intrinsics.checkNotNullExpressionValue(r2, "core.deepCopy()");
        return new StrokeStateList(r2);
    }

    public static /* synthetic */ StrokeConfig getConfigForState$default(StrokeStateList r0, int[] r1, StrokeConfig r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = r0.getDefaultStroke();
    L6:
        return r0.getConfigForState(r1, r2);
    }

    public final StrokeConfig getConfigForState(int[] r2, StrokeConfig r3) {
        Intrinsics.checkNotNullParameter(r2, "stateSet");
        StrokeStateListCore r1 = this.core;
        if (r3 != null) goto L5;
        StrokeConfigCore r4 = null;
    L6:
        StrokeConfigCore r5 = r1.getConfigForState(r2, r4);
        if (r5 != null) goto L10;
        return null;
    L10:
        return StrokeConfigKt.toConfig(r5);
    L5:
        r4 = r3.toCore$OUI_standardRelease();
        goto L6
    }

    public final StrokeStateListCore toCore$OUI_standardRelease() {
        return this.core;
    }
}
