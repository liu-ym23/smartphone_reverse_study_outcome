package com.obric.oui.dropdown;

import android.graphics.Rect;
import android.view.View;
import com.obric.oui.material.MaterialConfigFormatNames;
import com.obric.oui.popover.OPopover;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ODropdownPopoverExt.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a,\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"showInBound", "", "Lcom/obric/oui/popover/OPopover;", "anchor", "Landroid/view/View;", MaterialConfigFormatNames.X, "", MaterialConfigFormatNames.Y, "bound", "Landroid/graphics/Rect;", "OUI_standardRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ODropdownPopoverExtKt {
    @Deprecated(message = "use CardListItem")
    public static final void showInBound(OPopover r7, View r8, int r9, int r10, Rect r11) throws IllegalArgumentException {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r8, "anchor");
        Intrinsics.checkNotNullParameter(r11, "bound");
        boolean r2 = false;
        if (r11.right >= r11.left) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L32;
        int r1 = r7.getMeasuredHeight();
        int r3 = r7.getMeasuredWidth();
        int r12 = Math.min(Math.max(r9, r11.left), r11.right);
        int r13 = Math.min(Math.max(r10, r11.top), r11.bottom);
        if ((r12 + r3) <= r11.right) goto L21;
        if ((r11.left + r3) > r12) goto L15;
        boolean r4 = true;
    L16:
        if (r4 == false) goto L19;
        r12 = r12 - r3;
        goto L21
    L19:
        throw new IllegalArgumentException(("This pop is too wide: width = " + r3 + ", bound = " + r11).toString());
    L15:
        r4 = false;
    L21:
        if ((r13 + r1) > r11.bottom) goto L23;
    L29:
        r7.showAtLocation(r8, 51, r12, r13);
        return;
    L23:
        if ((r11.top + r3) > r13) goto L25;
        r2 = true;
    L25:
        if (r2 == false) goto L28;
        r13 = r13 - r1;
        goto L29
    L28:
        throw new IllegalArgumentException(("This pop is too high: height = " + r1 + ", bound = " + r11).toString());
    L32:
        throw new IllegalArgumentException(Intrinsics.stringPlus("Invalid bound = ", r11).toString());
    L5:
        if (r11.bottom < r11.top) goto L8;
        r0 = false;
        goto L9
    }
}
