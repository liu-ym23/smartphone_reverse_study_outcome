package com.obric.oui.color;

import android.content.Context;
import android.content.res.Resources;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.obric.oui.graphic.BlendMode;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import obric.widget.search.data.SearchConfigType;

/* JADX INFO: compiled from: BlendConfig.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0006\u0010\u0011\u001a\u00020\u0000J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\u0012\u001a\u00020\u0000J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\r\u0010\u0017\u001a\u00020\u0018H\u0000¢\u0006\u0002\b\u0019J\b\u0010\u001a\u001a\u00020\u001bH\u0016R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\f¨\u0006\u001d"}, d2 = {"Lcom/obric/oui/color/BlendConfig;", "", "color", "", SearchConfigType.KEY_MODE, "Lcom/obric/oui/graphic/BlendMode;", "(ILcom/obric/oui/graphic/BlendMode;)V", "blendMode", "(II)V", "getBlendMode", "()I", "setBlendMode", "(I)V", "getColor", "setColor", "component1", "component2", "copy", "deepCopy", "equals", "", "other", "hashCode", "toCore", "Lcom/obric/oui/color/BlendConfigCore;", "toCore$OUI_standardRelease", "toString", "", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BlendConfig {
    public static final Companion Companion = null;
    public static final BlendConfig TRANSPARENT = null;
    private int blendMode;
    private int color;

    /* JADX INFO: compiled from: BlendConfig.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J'\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ%\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00062\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0002\u0010\rJ'\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00062\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0001\u0010\u0011\u001a\u00020\u0012H\u0007¢\u0006\u0002\u0010\u0013J'\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00062\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0001\u0010\u0011\u001a\u00020\u0012H\u0007¢\u0006\u0002\u0010\u0016J\u001f\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0007¢\u0006\u0002\u0010\u001aJ \u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007J7\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\u001eR\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/obric/oui/color/BlendConfig$Companion;", "", "()V", "TRANSPARENT", "Lcom/obric/oui/color/BlendConfig;", "alpha", "", "origin", "progress", "", "([Lcom/obric/oui/color/BlendConfig;F)[Lcom/obric/oui/color/BlendConfig;", "deepCopy", Constants.KEY_CONFIG, "([Lcom/obric/oui/color/BlendConfig;)[Lcom/obric/oui/color/BlendConfig;", "fromArrayRes", "context", "Landroid/content/Context;", "arrayResId", "", "(Landroid/content/Context;I)[Lcom/obric/oui/color/BlendConfig;", "resources", "Landroid/content/res/Resources;", "(Landroid/content/res/Resources;I)[Lcom/obric/oui/color/BlendConfig;", "fromIntArray", "packed", "", "([I)[Lcom/obric/oui/color/BlendConfig;", "lerp", "from", "to", "([Lcom/obric/oui/color/BlendConfig;[Lcom/obric/oui/color/BlendConfig;F)[Lcom/obric/oui/color/BlendConfig;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final BlendConfig[] fromIntArray(int[] r7) {
            BlendConfigCore[] r6 = BlendConfigCore.fromIntArray(r7);
            if (r6 != null) goto L5;
            return null;
        L5:
            ArrayList r8 = new ArrayList(r6.length);
            int r0 = r6.length;
            int r2 = 0;
        L6:
            if (r2 >= r0) goto L8;
            BlendConfigCore r3 = r6[r2];
            r8.add(new BlendConfig(r3.getColor(), r3.getBlendMode()));
            r2 = r2 + 1;
            goto L6
        L8:
            Object[] r9 = r8.toArray(new BlendConfig[0]);
            if (r9 == null) goto L13;
            return (BlendConfig[]) r9;
        L13:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }

        @JvmStatic
        public final BlendConfig[] fromArrayRes(Context r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "context");
            return fromIntArray(r2.getResources().getIntArray(r3));
        }

        @JvmStatic
        public final BlendConfig[] fromArrayRes(Resources r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "resources");
            return fromIntArray(r2.getIntArray(r3));
        }

        @JvmStatic
        public final BlendConfig lerp(BlendConfig r1, BlendConfig r2, float r3) {
            Intrinsics.checkNotNullParameter(r1, "from");
            Intrinsics.checkNotNullParameter(r2, "to");
            BlendConfigCore r0 = BlendConfigCore.lerp(r1.toCore$OUI_standardRelease(), r2.toCore$OUI_standardRelease(), r3);
            return new BlendConfig(r0.getColor(), r0.getBlendMode());
        }

        @JvmStatic
        public final BlendConfig[] lerp(BlendConfig[] r6, BlendConfig[] r7, float r8) {
            Intrinsics.checkNotNullParameter(r6, "from");
            Intrinsics.checkNotNullParameter(r7, "to");
            ArrayList r5 = new ArrayList(r6.length);
            int r0 = r6.length;
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L5;
            r5.add(r6[r2].toCore$OUI_standardRelease());
            r2 = r2 + 1;
            goto L3
        L5:
            Object[] r9 = r5.toArray(new BlendConfigCore[0]);
            if (r9 == null) goto L24;
            BlendConfigCore[] r10 = (BlendConfigCore[]) r9;
            ArrayList r1 = new ArrayList(r7.length);
            int r3 = r7.length;
            int r4 = 0;
        L8:
            if (r4 >= r3) goto L10;
            r1.add(r7[r4].toCore$OUI_standardRelease());
            r4 = r4 + 1;
            goto L8
        L10:
            Object[] r11 = r1.toArray(new BlendConfigCore[0]);
            if (r11 == null) goto L22;
            BlendConfigCore[] r12 = BlendConfigCore.lerp(r10, (BlendConfigCore[]) r11, r8);
            Intrinsics.checkNotNullExpressionValue(r12, "lerp(\n                fr…   progress\n            )");
            BlendConfigCore[] r13 = r12;
            ArrayList r14 = new ArrayList(r13.length);
            int r15 = r13.length;
            int r16 = 0;
        L13:
            if (r16 >= r15) goto L15;
            BlendConfigCore r17 = r13[r16];
            r14.add(new BlendConfig(r17.getColor(), r17.getBlendMode()));
            r16 = r16 + 1;
            goto L13
        L15:
            Object[] r18 = r14.toArray(new BlendConfig[0]);
            if (r18 == null) goto L20;
            return (BlendConfig[]) r18;
        L20:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        L22:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        L24:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }

        public final BlendConfig[] alpha(BlendConfig[] r7, float r8) {
            Intrinsics.checkNotNullParameter(r7, "origin");
            ArrayList r6 = new ArrayList(r7.length);
            int r0 = r7.length;
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L5;
            r6.add(r7[r2].toCore$OUI_standardRelease());
            r2 = r2 + 1;
            goto L3
        L5:
            Object[] r9 = r6.toArray(new BlendConfigCore[0]);
            if (r9 == null) goto L17;
            BlendConfigCore[] r10 = BlendConfigCore.alpha((BlendConfigCore[]) r9, r8);
            Intrinsics.checkNotNullExpressionValue(r10, "alpha(origin.map { it.to…toTypedArray(), progress)");
            BlendConfigCore[] r11 = r10;
            ArrayList r12 = new ArrayList(r11.length);
            int r1 = r11.length;
            int r3 = 0;
        L8:
            if (r3 >= r1) goto L10;
            BlendConfigCore r4 = r11[r3];
            r12.add(new BlendConfig(r4.getColor(), r4.getBlendMode()));
            r3 = r3 + 1;
            goto L8
        L10:
            Object[] r13 = r12.toArray(new BlendConfig[0]);
            if (r13 == null) goto L15;
            return (BlendConfig[]) r13;
        L15:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        L17:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }

        @JvmStatic
        public final BlendConfig[] deepCopy(BlendConfig[] r8) {
            if (r8 != null) goto L5;
            BlendConfigCore[] r9 = null;
        L11:
            BlendConfigCore[] r10 = BlendConfigCore.deepCopy(r9);
            if (r10 == null) goto L27;
            ArrayList r0 = new ArrayList(r10.length);
            int r2 = r10.length;
            int r3 = 0;
        L15:
            if (r3 >= r2) goto L17;
            BlendConfigCore r4 = r10[r3];
            r0.add(new BlendConfig(r4.getColor(), r4.getBlendMode()));
            r3 = r3 + 1;
            goto L15
        L17:
            Object[] r11 = r0.toArray(new BlendConfig[0]);
            if (r11 == null) goto L22;
            return (BlendConfig[]) r11;
        L22:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        L27:
            return null;
        L5:
            ArrayList r5 = new ArrayList(r8.length);
            int r6 = r8.length;
            int r7 = 0;
        L6:
            if (r7 >= r6) goto L8;
            r5.add(r8[r7].toCore$OUI_standardRelease());
            r7 = r7 + 1;
            goto L6
        L8:
            Object[] r12 = r5.toArray(new BlendConfigCore[0]);
            if (r12 == null) goto L24;
            r9 = (BlendConfigCore[]) r12;
            goto L11
        L24:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
    }

    public static /* synthetic */ BlendConfig copy$default(BlendConfig r0, int r1, int r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.color;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.blendMode;
    L9:
        return r0.copy(r1, r2);
    }

    @JvmStatic
    public static final BlendConfig[] deepCopy(BlendConfig[] r1) {
        return Companion.deepCopy(r1);
    }

    @JvmStatic
    public static final BlendConfig[] fromArrayRes(Context r1, int r2) {
        return Companion.fromArrayRes(r1, r2);
    }

    @JvmStatic
    public static final BlendConfig[] fromArrayRes(Resources r1, int r2) {
        return Companion.fromArrayRes(r1, r2);
    }

    @JvmStatic
    public static final BlendConfig[] fromIntArray(int[] r1) {
        return Companion.fromIntArray(r1);
    }

    @JvmStatic
    public static final BlendConfig lerp(BlendConfig r1, BlendConfig r2, float r3) {
        return Companion.lerp(r1, r2, r3);
    }

    @JvmStatic
    public static final BlendConfig[] lerp(BlendConfig[] r1, BlendConfig[] r2, float r3) {
        return Companion.lerp(r1, r2, r3);
    }

    public final int component1() {
        return this.color;
    }

    public final int component2() {
        return this.blendMode;
    }

    public final BlendConfig copy(int r1, int r2) {
        return new BlendConfig(r1, r2);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof BlendConfig) == true) goto L8;
        return false;
    L8:
        BlendConfig r6 = (BlendConfig) r5;
        if (this.color == r6.color) goto L12;
        return false;
    L12:
        if (this.blendMode == r6.blendMode) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (Integer.hashCode(this.color) * 31) + Integer.hashCode(this.blendMode);
    }

    public BlendConfig(int r1, int r2) {
        this.color = r1;
        this.blendMode = r2;
    }

    public final int getColor() {
        return this.color;
    }

    public final void setColor(int r1) {
        this.color = r1;
    }

    public final int getBlendMode() {
        return this.blendMode;
    }

    public final void setBlendMode(int r1) {
        this.blendMode = r1;
    }

    public BlendConfig(int r2, BlendMode r3) {
        Intrinsics.checkNotNullParameter(r3, SearchConfigType.KEY_MODE);
        this(r2, BlendMode.mapToLegacyObricBlend(r3));
    }

    public final BlendConfigCore toCore$OUI_standardRelease() {
        return new BlendConfigCore(this.color, this.blendMode);
    }

    public final BlendConfig deepCopy() {
        BlendConfigCore r2 = BlendConfigCore.deepCopy(toCore$OUI_standardRelease());
        return new BlendConfig(r2.getColor(), r2.getBlendMode());
    }

    public final BlendConfig copy() {
        return deepCopy();
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("BlendConfig#").append(hashCode()).append("(color=");
        String r1 = String.format("#%08X", Arrays.copyOf(new Object[]{Integer.valueOf(this.color)}, 1));
        Intrinsics.checkNotNullExpressionValue(r1, "format(this, *args)");
        return r0.append(r1).append(", blendMode=").append(this.blendMode).append(')').toString();
    }

    static {
        Companion = new Companion(null);
        TRANSPARENT = new BlendConfig(0, BlendMode.SRC_OVER);
    }
}
