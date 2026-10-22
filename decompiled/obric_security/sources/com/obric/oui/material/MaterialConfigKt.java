package com.obric.oui.material;

import android.content.res.ColorStateList;
import android.os.Parcel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MaterialConfig.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u0000\u001a\f\u0010\u0002\u001a\u00020\u0003*\u00020\u0004H\u0000¨\u0006\u0005"}, d2 = {"deepCopy", "Landroid/content/res/ColorStateList;", "toConfig", "Lcom/obric/oui/material/MaterialConfig;", "Lcom/obric/oui/material/MaterialConfigCore;", "OUI_standardRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class MaterialConfigKt {
    public static final MaterialConfig toConfig(MaterialConfigCore r12) {
        Intrinsics.checkNotNullParameter(r12, "<this>");
        return new MaterialConfig(r12.getFallbackBgColor(), r12.getBlendConfigStateList(), r12.getBlendConfig(), r12.getStrokeStateList(), r12.getStroke(), r12.getOverlayBlendConfigStateList(), r12.getBlurConfig(), r12.getBlurRadius(), r12.getShadow(), r12.getFluid());
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
}
