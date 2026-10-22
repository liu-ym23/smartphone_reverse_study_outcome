package com.obric.oui.titlebar.optimize;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import com.obric.common.oui.R;
import com.obric.oui.button.OButton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OCTitleBarExt.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u001a\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004\u001a\u0012\u0010\t\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\n\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u001a\u0010\u000b\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0004\u001a\u0012\u0010\u000f\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\f\u001a\u00020\r\u001a\u0012\u0010\u0010\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\f\u001a\u00020\r\u001a\u0012\u0010\u0011\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\f\u001a\u00020\r\u001a\u0012\u0010\u0012\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\f\u001a\u00020\r\u001a\u0012\u0010\u0013\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\f\u001a\u00020\r¨\u0006\u0014"}, d2 = {"addLeftImageView", "Landroid/widget/ImageView;", "Lcom/obric/oui/titlebar/optimize/OCTitleBar;", "drawableId", "", "addRightButton", "Lcom/obric/oui/button/OButton;", "style", "stringId", "addRightImageView", "addRightTransButton", "createButton", "context", "Landroid/content/Context;", "layoutResId", "createNeutralButton", "createPrimaryButton", "createPrimaryLightButton", "createTransButton", "createTransIconButton", "OUI_standardRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class OCTitleBarExtKt {
    public static final OButton createNeutralButton(OCTitleBar r1, Context r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "context");
        return createButton(r1, r2, R.layout.o_widget_titlebar_button_neutral);
    }

    public static final OButton createPrimaryLightButton(OCTitleBar r1, Context r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "context");
        return createButton(r1, r2, R.layout.o_widget_titlebar_primarylight_button);
    }

    public static final OButton createTransButton(OCTitleBar r1, Context r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "context");
        return createButton(r1, r2, R.layout.o_widget_titlebar_trans_button);
    }

    public static final OButton createTransIconButton(OCTitleBar r1, Context r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "context");
        return createButton(r1, r2, R.layout.o_widget_titlebar_trans_icon_button);
    }

    public static final OButton createPrimaryButton(OCTitleBar r1, Context r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "context");
        return createButton(r1, r2, R.layout.o_widget_titlebar_primary_button);
    }

    public static final OButton createButton(OCTitleBar r1, Context r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "context");
        View r4 = LayoutInflater.from(r2).inflate(r3, r1, false);
        if (r4 == null) goto L7;
        return (OButton) r4;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.button.OButton");
    }

    public static final ImageView addLeftImageView(OCTitleBar r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        ImageView r0 = new ImageView(r2.getContext());
        r0.setImageResource(r3);
        r2.addLeftView(r0);
        return r0;
    }

    public static final ImageView addRightImageView(OCTitleBar r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        ImageView r0 = new ImageView(r2.getContext());
        r0.setImageResource(r3);
        r2.addRightView(r0);
        return r0;
    }

    public static final OButton addRightButton(OCTitleBar r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (r3 != 0) goto L5;
        Context r5 = r2.getContext();
        Intrinsics.checkNotNullExpressionValue(r5, "context");
        OButton r6 = createNeutralButton(r2, r5);
    L9:
        r6.setText(r4);
        r2.addRightView(r6);
        return r6;
    L5:
        if (r3 == 1) goto L7;
        Context r7 = r2.getContext();
        Intrinsics.checkNotNullExpressionValue(r7, "context");
        r6 = createPrimaryLightButton(r2, r7);
        goto L9
    L7:
        Context r8 = r2.getContext();
        Intrinsics.checkNotNullExpressionValue(r8, "context");
        r6 = createPrimaryLightButton(r2, r8);
        goto L9
    }

    public static final OButton addRightTransButton(OCTitleBar r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Context r0 = r2.getContext();
        Intrinsics.checkNotNullExpressionValue(r0, "context");
        OButton r1 = createTransIconButton(r2, r0);
        r1.setButtonSourceBitmap(r3);
        r2.addRightView(r1);
        return r1;
    }
}
