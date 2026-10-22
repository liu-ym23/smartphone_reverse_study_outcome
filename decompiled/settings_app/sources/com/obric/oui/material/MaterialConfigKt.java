package com.obric.oui.material;

import android.content.res.ColorStateList;
import android.os.Parcel;
import com.obric.oui.blur.BlurConfig;
import com.obric.oui.blur.BlurConfigCore;
import com.obric.oui.blur.BlurConfigKt;
import com.obric.oui.color.BlendConfig;
import com.obric.oui.color.BlendConfigCore;
import com.obric.oui.color.BlendConfigKt;
import com.obric.oui.color.StrokeConfig;
import com.obric.oui.color.StrokeConfigCore;
import com.obric.oui.color.StrokeConfigKt;
import com.obric.oui.fluid.FluidConfig;
import com.obric.oui.fluid.FluidConfigCore;
import com.obric.oui.fluid.FluidConfigKt;
import com.obric.oui.res.BlendConfigStateList;
import com.obric.oui.res.BlendConfigStateListCore;
import com.obric.oui.res.StrokeStateList;
import com.obric.oui.res.StrokeStateListCore;
import com.obric.oui.shadow.ShadowConfig;
import com.obric.oui.shadow.ShadowConfigCore;
import com.obric.oui.shadow.ShadowConfigKt;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MaterialConfig.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u0000\u001a\f\u0010\u0002\u001a\u00020\u0003*\u00020\u0004H\u0000\u001a\f\u0010\u0002\u001a\u00020\u0005*\u00020\u0006H\u0000\u001a\f\u0010\u0002\u001a\u00020\u0007*\u00020\bH\u0000\u001a\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n*\b\u0012\u0004\u0012\u00020\u00040\nH\u0000¢\u0006\u0002\u0010\u000b\u001a\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\f0\n*\b\u0012\u0004\u0012\u00020\r0\nH\u0000¢\u0006\u0002\u0010\u000e\u001a\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\n*\b\u0012\u0004\u0012\u00020\f0\nH\u0000¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"deepCopy", "Landroid/content/res/ColorStateList;", "toConfig", "Lcom/obric/oui/material/MaterialConfig;", "Lcom/obric/oui/material/MaterialConfigCore;", "Lcom/obric/oui/res/BlendConfigStateList;", "Lcom/obric/oui/res/BlendConfigStateListCore;", "Lcom/obric/oui/res/StrokeStateList;", "Lcom/obric/oui/res/StrokeStateListCore;", "toConfigArray", "", "([Lcom/obric/oui/material/MaterialConfigCore;)[Lcom/obric/oui/material/MaterialConfig;", "Lcom/obric/oui/shadow/ShadowConfig;", "Lcom/obric/oui/shadow/ShadowConfigCore;", "([Lcom/obric/oui/shadow/ShadowConfigCore;)[Lcom/obric/oui/shadow/ShadowConfig;", "toCoreArray", "([Lcom/obric/oui/shadow/ShadowConfig;)[Lcom/obric/oui/shadow/ShadowConfigCore;", "OUI_standardRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class MaterialConfigKt {
    public static final MaterialConfig toConfig(MaterialConfigCore r12) {
        Intrinsics.checkNotNullParameter(r12, "<this>");
        ColorStateList r2 = r12.getFallbackBgColor();
        BlendConfigStateListCore r1 = r12.getBlendConfigStateList();
        if (r1 != null) goto L5;
        BlendConfigStateList r4 = null;
    L6:
        BlendConfigCore[] r3 = r12.getBlendConfig();
        if (r3 != null) goto L9;
        BlendConfig[] r5 = null;
    L10:
        StrokeStateListCore r6 = r12.getStrokeStateList();
        if (r6 != null) goto L13;
        StrokeStateList r7 = null;
    L14:
        StrokeConfigCore r8 = r12.getStroke();
        if (r8 != null) goto L17;
        StrokeConfig r9 = null;
    L18:
        BlendConfigStateListCore r10 = r12.getOverlayBlendConfigStateList();
        if (r10 != null) goto L21;
        BlendConfigStateList r11 = null;
    L22:
        BlurConfigCore r13 = r12.getBlurConfig();
        if (r13 != null) goto L25;
        BlurConfig r14 = null;
    L26:
        Float r15 = r12.getBlurRadius();
        ShadowConfigCore[] r16 = r12.getShadow();
        if (r16 != null) goto L29;
        ShadowConfig[] r17 = null;
    L30:
        FluidConfigCore r18 = r12.getFluid();
        if (r18 != null) goto L33;
        FluidConfig r19 = null;
    L35:
        return new MaterialConfig(r2, r4, r5, r7, r9, r11, r14, r15, r17, r19);
    L33:
        r19 = FluidConfigKt.toConfig(r18);
        goto L35
    L29:
        r17 = toConfigArray(r16);
        goto L30
    L25:
        r14 = BlurConfigKt.toConfig(r13);
        goto L26
    L21:
        r11 = toConfig(r10);
        goto L22
    L17:
        r9 = StrokeConfigKt.toConfig(r8);
        goto L18
    L13:
        r7 = toConfig(r6);
        goto L14
    L9:
        r5 = BlendConfigKt.toConfigArray(r3);
        goto L10
    L5:
        r4 = toConfig(r1);
        goto L6
    }

    public static final BlendConfigStateList toConfig(BlendConfigStateListCore r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return BlendConfigStateList.Companion.fromCore$OUI_standardRelease(r1);
    }

    public static final StrokeStateList toConfig(StrokeStateListCore r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return StrokeStateList.Companion.fromCore$OUI_standardRelease(r1);
    }

    public static final ColorStateList deepCopy(ColorStateList r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Parcel r0 = Parcel.obtain();
        Intrinsics.checkNotNullExpressionValue(r0, "obtain()");
        r2.writeToParcel(r0, 0);     // Catch: Throwable -> L6
        r0.setDataPosition(0);     // Catch: Throwable -> L6
        Object r3 = ColorStateList.CREATOR.createFromParcel(r0);     // Catch: Throwable -> L6
        Intrinsics.checkNotNullExpressionValue(r3, "{\n        writeToParcel(…eFromParcel(parcel)\n    }");     // Catch: Throwable -> L6
        ColorStateList r4 = (ColorStateList) r3;     // Catch: Throwable -> L6
        r0.recycle();
        return r4;
    L6:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public static final MaterialConfig[] toConfigArray(MaterialConfigCore[] r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        ArrayList r0 = new ArrayList(r5.length);
        int r1 = r5.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L5;
        r0.add(toConfig(r5[r3]));
        r3 = r3 + 1;
        goto L3
    L5:
        Object[] r6 = r0.toArray(new MaterialConfig[0]);
        if (r6 == null) goto L10;
        return (MaterialConfig[]) r6;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    public static final ShadowConfigCore[] toCoreArray(ShadowConfig[] r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        ArrayList r0 = new ArrayList(r5.length);
        int r1 = r5.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L5;
        r0.add(r5[r3].toCore$OUI_standardRelease());
        r3 = r3 + 1;
        goto L3
    L5:
        Object[] r6 = r0.toArray(new ShadowConfigCore[0]);
        if (r6 == null) goto L10;
        return (ShadowConfigCore[]) r6;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    public static final ShadowConfig[] toConfigArray(ShadowConfigCore[] r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        ArrayList r0 = new ArrayList(r5.length);
        int r1 = r5.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L5;
        r0.add(ShadowConfigKt.toConfig(r5[r3]));
        r3 = r3 + 1;
        goto L3
    L5:
        Object[] r6 = r0.toArray(new ShadowConfig[0]);
        if (r6 == null) goto L10;
        return (ShadowConfig[]) r6;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }
}
