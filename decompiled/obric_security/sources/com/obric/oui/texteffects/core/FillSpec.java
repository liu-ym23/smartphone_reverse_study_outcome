package com.obric.oui.texteffects.core;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TextEffectProtocol.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/texteffects/core/FillSpec;", "", "()V", "LinearGradient", "TextColor", "Lcom/obric/oui/texteffects/core/FillSpec$TextColor;", "Lcom/obric/oui/texteffects/core/FillSpec$LinearGradient;", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class FillSpec {

    /* JADX INFO: compiled from: TextEffectProtocol.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0014\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/obric/oui/texteffects/core/FillSpec$LinearGradient;", "Lcom/obric/oui/texteffects/core/FillSpec;", "colors", "", "positions", "", "([I[F)V", "getColors", "()[I", "getPositions", "()[F", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class LinearGradient extends FillSpec {
        private final int[] colors;
        private final float[] positions;

        public static /* synthetic */ LinearGradient copy$default(LinearGradient r0, int[] r1, float[] r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.colors;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.positions;
        L9:
            return r0.copy(r1, r2);
        }

        public final int[] component1() {
            return this.colors;
        }

        public final float[] component2() {
            return this.positions;
        }

        public final LinearGradient copy(int[] r1, float[] r2) {
            Intrinsics.checkNotNullParameter(r1, "colors");
            Intrinsics.checkNotNullParameter(r2, "positions");
            return new LinearGradient(r1, r2);
        }

        public String toString() {
            return "LinearGradient(colors=" + Arrays.toString(this.colors) + ", positions=" + Arrays.toString(this.positions) + ')';
        }

        public final int[] getColors() {
            return this.colors;
        }

        public final float[] getPositions() {
            return this.positions;
        }

        public LinearGradient(int[] r2, float[] r3) {
            Intrinsics.checkNotNullParameter(r2, "colors");
            Intrinsics.checkNotNullParameter(r3, "positions");
            super(null);
            this.colors = r2;
            this.positions = r3;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof LinearGradient) == true) goto L8;
            return false;
        L8:
            LinearGradient r6 = (LinearGradient) r5;
            if (Arrays.equals(this.colors, r6.colors) == false) goto L14;
            if (Arrays.equals(this.positions, r6.positions) == false) goto L14;
            return true;
        L14:
            return false;
        }

        public int hashCode() {
            return (Arrays.hashCode(this.colors) * 31) + Arrays.hashCode(this.positions);
        }
    }

    /* JADX INFO: compiled from: TextEffectProtocol.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/obric/oui/texteffects/core/FillSpec$TextColor;", "Lcom/obric/oui/texteffects/core/FillSpec;", "()V", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class TextColor extends FillSpec {
        public static final TextColor INSTANCE = null;

        static {
            INSTANCE = new TextColor();
        }

        private TextColor() {
            super(null);
        }
    }

    public /* synthetic */ FillSpec(DefaultConstructorMarker r1) {
        this();
    }

    private FillSpec() {
    }
}
