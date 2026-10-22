package com.obric.oui.popover;

import android.view.View;
import com.bytedance.securityserver.R;
import com.obric.oui.animation.engine.FloatPropertyCompat;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class OPopover$animFloatP$1 extends FloatPropertyCompat<View> {
    @Override // com.obric.oui.animation.engine.FloatPropertyCompat
    public final float a(Object r2) {
        View r3 = (View) r2;
        if (r3 == null) goto L15;
        Object r1 = r3.getTag(R.id.o_popover_anim_p);
        if (r1 == null) goto L15;
        Float r0 = null;
        if ((r1 instanceof OPopover.CommonFloatProperty) == true) goto L10;
        r1 = null;
    L10:
        OPopover.CommonFloatProperty r4 = (OPopover.CommonFloatProperty) r1;
        if (r4 == null) goto L13;
        r0 = Float.valueOf(r4.f265a);
    L13:
        if (r0 == null) goto L15;
        return r0.floatValue();
    L15:
        return 0.0f;
    }

    @Override // com.obric.oui.animation.engine.FloatPropertyCompat
    public final void b(Object r1, float r2) {
        View r3 = (View) r1;
        if (r3 == null) goto L14;
        Object r0 = r3.getTag(R.id.o_popover_anim_p);
        if (r0 != null) goto L7;
        return;
    L7:
        if ((r0 instanceof OPopover.CommonFloatProperty) == true) goto L10;
        r0 = null;
    L10:
        OPopover.CommonFloatProperty r4 = (OPopover.CommonFloatProperty) r0;
        if (r4 == null) goto L16;
        r4.f265a = r2;
        return;
    L16:
        return;
    }
}
