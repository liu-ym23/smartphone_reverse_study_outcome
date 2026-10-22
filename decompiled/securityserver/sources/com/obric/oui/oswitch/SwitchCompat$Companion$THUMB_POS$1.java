package com.obric.oui.oswitch;

import android.util.Property;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class SwitchCompat$Companion$THUMB_POS$1 extends Property<SwitchCompat, Float> {
    @Override // android.util.Property
    public final Float get(SwitchCompat r1) {
        SwitchCompat r2 = r1;
        Intrinsics.f(r2, "object");
        return Float.valueOf(r2.getMThumbPosition());
    }

    @Override // android.util.Property
    public final void set(SwitchCompat r1, Float r2) {
        SwitchCompat r3 = r1;
        float r0 = r2.floatValue();
        Intrinsics.f(r3, "object");
        r3.setThumbPosition(r0);
    }
}
