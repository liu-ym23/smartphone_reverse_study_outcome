package com.bytedanceos.utils;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.text.OTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OCardListItemExt.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0002\u001a\u0014\u0010\u0003\u001a\u00020\u0004*\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u0016\u0010\u0007\u001a\u00020\u0004*\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0001\u001a\u0016\u0010\t\u001a\u00020\u0004*\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u001a\u0016\u0010\f\u001a\u00020\u0004*\u0004\u0018\u00010\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u001a\u0014\u0010\u000f\u001a\u00020\u0004*\u0004\u0018\u00010\u00022\u0006\u0010\u0010\u001a\u00020\u0001\u001a\u0014\u0010\u0011\u001a\u00020\u0004*\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0012"}, d2 = {"getEndText", "", "Lcom/obric/oui/lisitem/OCardListItem;", "setCustomTailIcon", "", "type", "", "setEndText", "text", "setStartIcon", "drawable", "Landroid/graphics/drawable/Drawable;", "setStartView", "view", "Landroid/view/View;", "setSubTitleText", "subTitle", "setTailType", "app_neridaCnRelease"}, k = 2, mv = {1, 4, 3})
public final class OCardListItemExtKt {
    public static final void setEndText(OCardListItem r3, String r4) {
        String r5 = r4;
        TextUtils.isEmpty(r5);
        if (r3 == null) goto L5;
        OTextView r1 = r3.getEndDetail();
    L6:
        if (r1 != null) goto L11;
        if (r3 == null) goto L9;
        OCardListItem.setEndDetailText$default(r3, r5, 0, 2, null);
    L9:
        if (r3 == null) goto L13;
        r3.showCustomEnd(true);
        return;
    L13:
        return;
    L11:
        r1.setText(r5);
        return;
    L5:
        r1 = null;
        goto L6
    }

    public static final String getEndText(OCardListItem r0) {
        if (r0 == null) goto L8;
        OTextView r1 = r0.getEndDetail();
        if (r1 == null) goto L8;
        CharSequence r2 = r1.getText();
        if (r2 == null) goto L8;
        return r2.toString();
    L8:
        return null;
    }

    public static final void setTailType(OCardListItem r0, int r1) {
        if (r0 == null) goto L4;
        r0.setDefaultTailIcon(r1);
    L4:
        if (r0 == null) goto L7;
        r0.showTailIcon(true);
        return;
    }

    public static final void setCustomTailIcon(OCardListItem r0, int r1) {
        if (r0 == null) goto L4;
        r0.setTailIcon(r1);
    L4:
        if (r0 == null) goto L7;
        r0.showTailIcon(true);
        return;
    }

    public static final void setStartView(OCardListItem r0, View r1) {
        if (r0 == null) goto L4;
        r0.setCustomStartView(r1);
    L4:
        if (r0 == null) goto L7;
        r0.showCustomStart(true);
        return;
    }

    public static final void setStartIcon(OCardListItem r0, Drawable r1) {
        if (r0 == null) goto L4;
        r0.setAppIcon(r1);
    L4:
        if (r0 == null) goto L7;
        r0.showIcon(true);
        return;
    }

    public static final void setSubTitleText(OCardListItem r1, String r2) {
        Intrinsics.checkNotNullParameter(r2, "subTitle");
        if (r1 == null) goto L5;
        r1.setSubTitle(r2);
    L5:
        if (r1 == null) goto L8;
        r1.showSubTitle(true);
        return;
    }
}
