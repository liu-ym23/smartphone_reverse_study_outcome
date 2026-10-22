package com.google.android.material.textview;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

/* JADX INFO: loaded from: classes3.dex */
public class MaterialTextView extends AppCompatTextView {
    public MaterialTextView(Context r2) {
        this(r2, null);
    }

    public MaterialTextView(Context r2, AttributeSet r3) {
        this(r2, r3, R.attr.textViewStyle);
    }

    public MaterialTextView(Context r2, AttributeSet r3, int r4) {
        this(r2, r3, r4, 0);
    }

    public MaterialTextView(Context r2, AttributeSet r3, int r4, int r5) {
        super(MaterialThemeOverlay.wrap(r2, r3, r4, r5), r3, r4);
        Context r6 = getContext();
        if (canApplyTextAppearanceLineHeight(r6) == false) goto L10;
        Resources.Theme r0 = r6.getTheme();
        if (viewAttrsHasLineHeight(r6, r0, r3, r4, r5) == true) goto L11;
        int r7 = findViewAppearanceResourceId(r0, r3, r4, r5);
        if (r7 == (-1)) goto L12;
        applyLineHeightFromViewAppearance(r0, r7);
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public void setTextAppearance(Context r2, int r3) {
        super.setTextAppearance(r2, r3);
        if (canApplyTextAppearanceLineHeight(r2) == false) goto L6;
        applyLineHeightFromViewAppearance(r2.getTheme(), r3);
        return;
    }

    private void applyLineHeightFromViewAppearance(Resources.Theme r4, int r5) {
        TypedArray r6 = r4.obtainStyledAttributes(r5, com.google.android.material.R.styleable.MaterialTextAppearance);
        int r7 = readFirstAvailableDimension(getContext(), r6, new int[]{com.google.android.material.R.styleable.MaterialTextAppearance_android_lineHeight, com.google.android.material.R.styleable.MaterialTextAppearance_lineHeight});
        r6.recycle();
        if (r7 < 0) goto L6;
        setLineHeight(r7);
        return;
    }

    private static boolean canApplyTextAppearanceLineHeight(Context r2) {
        return MaterialAttributes.resolveBoolean(r2, com.google.android.material.R.attr.textAppearanceLineHeightEnabled, true);
    }

    private static int readFirstAvailableDimension(Context r4, TypedArray r5, int... r6) {
        int r1 = 0;
        int r2 = -1;
    L4:
        if (r1 >= r6.length) goto L7;
        if (r2 >= 0) goto L7;
        r2 = MaterialResources.getDimensionPixelSize(r4, r5, r6[r1], -1);
        r1 = r1 + 1;
    L7:
        return r2;
    }

    private static boolean viewAttrsHasLineHeight(Context r1, Resources.Theme r2, AttributeSet r3, int r4, int r5) {
        TypedArray r6 = r2.obtainStyledAttributes(r3, com.google.android.material.R.styleable.MaterialTextView, r4, r5);
        int r7 = readFirstAvailableDimension(r1, r6, new int[]{com.google.android.material.R.styleable.MaterialTextView_android_lineHeight, com.google.android.material.R.styleable.MaterialTextView_lineHeight});
        r6.recycle();
        if (r7 != (-1)) goto L5;
        return false;
    L5:
        return true;
    }

    private static int findViewAppearanceResourceId(Resources.Theme r1, AttributeSet r2, int r3, int r4) {
        TypedArray r5 = r1.obtainStyledAttributes(r2, com.google.android.material.R.styleable.MaterialTextView, r3, r4);
        int r6 = r5.getResourceId(com.google.android.material.R.styleable.MaterialTextView_android_textAppearance, -1);
        r5.recycle();
        return r6;
    }
}
