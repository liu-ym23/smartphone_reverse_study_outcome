package com.obric.oui.color;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BlendConfig.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\u001d\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004*\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0000¢\u0006\u0002\u0010\u0005\u001a\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u0004H\u0000¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"toConfig", "Lcom/obric/oui/color/BlendConfig;", "Lcom/obric/oui/color/BlendConfigCore;", "toConfigArray", "", "([Lcom/obric/oui/color/BlendConfigCore;)[Lcom/obric/oui/color/BlendConfig;", "toCoreArray", "([Lcom/obric/oui/color/BlendConfig;)[Lcom/obric/oui/color/BlendConfigCore;", "OUI_standardRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class BlendConfigKt {
    public static final BlendConfig toConfig(BlendConfigCore r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return new BlendConfig(r2.getColor(), r2.getBlendMode());
    }

    public static final BlendConfigCore[] toCoreArray(BlendConfig[] r5) {
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
        Object[] r6 = r0.toArray(new BlendConfigCore[0]);
        if (r6 == null) goto L10;
        return (BlendConfigCore[]) r6;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    public static final BlendConfig[] toConfigArray(BlendConfigCore[] r5) {
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
        Object[] r6 = r0.toArray(new BlendConfig[0]);
        if (r6 == null) goto L10;
        return (BlendConfig[]) r6;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }
}
