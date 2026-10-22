package com.android.setupwizardlib.template;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;
import com.android.setupwizardlib.R;
import com.android.setupwizardlib.TemplateLayout;

/* JADX INFO: loaded from: classes.dex */
public class ColoredHeaderMixin extends HeaderMixin {
    public ColoredHeaderMixin(TemplateLayout r3, AttributeSet r4, int r5) {
        super(r3, r4, r5);
        TypedArray r6 = r3.getContext().obtainStyledAttributes(r4, R.styleable.SuwColoredHeaderMixin, r5, 0);
        ColorStateList r7 = r6.getColorStateList(R.styleable.SuwColoredHeaderMixin_suwHeaderColor);
        if (r7 == null) goto L5;
        setColor(r7);
    L5:
        r6.recycle();
    }

    public void setColor(ColorStateList r1) {
        TextView r0 = getTextView();
        if (r0 == null) goto L6;
        r0.setTextColor(r1);
        return;
    }

    public ColorStateList getColor() {
        TextView r0 = getTextView();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getTextColors();
    }
}
