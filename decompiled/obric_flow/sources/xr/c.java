package xr;

import android.util.Property;
import com.obric.oui.oswitch.SwitchCompat;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends Property {
    @Override // android.util.Property
    public final Object get(Object r5) {
        SwitchCompat r10 = (SwitchCompat) r5;
        Intrinsics.checkNotNullParameter(r10, "object");
        return Float.valueOf(r10.getMThumbPosition());
    }

    @Override // android.util.Property
    public final void set(Object r5, Object r10) {
        SwitchCompat r11 = (SwitchCompat) r5;
        float r12 = ((Number) r10).floatValue();
        Intrinsics.checkNotNullParameter(r11, "object");
        r11.setThumbPosition(r12);
    }
}
