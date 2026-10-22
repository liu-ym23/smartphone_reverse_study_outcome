package com.android.setupwizardlib.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.widget.Button;

/* JADX INFO: loaded from: classes.dex */
public class NavigationBarButton extends Button {

    private static class TintedDrawable extends LayerDrawable {
        private ColorStateList tintList;

        @Override // android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
        public boolean isStateful() {
            return true;
        }

        public static TintedDrawable wrap(Drawable r1) {
            if ((r1 instanceof TintedDrawable) == false) goto L7;
            return (TintedDrawable) r1;
        L7:
            return new TintedDrawable(r1.mutate());
        }

        TintedDrawable(Drawable r3) {
            super(new Drawable[]{r3});
            this.tintList = null;
        }

        @Override // android.graphics.drawable.Drawable
        public boolean setState(int[] r1) {
            boolean r2 = super.setState(r1);
            boolean r0 = updateState();
            if (r2 == true) goto L7;
            if (r0 == true) goto L7;
            return false;
        L7:
            return true;
        }

        public void setTintListCompat(ColorStateList r1) {
            this.tintList = r1;
            if (updateState() == false) goto L6;
            invalidateSelf();
            return;
        }

        private boolean updateState() {
            ColorStateList r0 = this.tintList;
            if (r0 == null) goto L6;
            setColorFilter(r0.getColorForState(getState(), 0), PorterDuff.Mode.SRC_IN);
            return true;
        L6:
            return false;
        }
    }

    public NavigationBarButton(Context r1) {
        super(r1);
        init();
    }

    public NavigationBarButton(Context r1, AttributeSet r2) {
        super(r1, r2);
        init();
    }

    private void init() {
        Drawable[] r0 = getCompoundDrawablesRelative();
        int r2 = 0;
    L4:
        if (r2 >= r0.length) goto L9;
        Drawable r3 = r0[r2];
        if (r3 == null) goto L8;
        r0[r2] = TintedDrawable.wrap(r3);
    L8:
        r2 = r2 + 1;
        goto L4
    L9:
        setCompoundDrawablesRelativeWithIntrinsicBounds(r0[0], r0[1], r0[2], r0[3]);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable r1, Drawable r2, Drawable r3, Drawable r4) {
        if (r1 == null) goto L4;
        r1 = TintedDrawable.wrap(r1);
    L4:
        if (r2 == null) goto L6;
        r2 = TintedDrawable.wrap(r2);
    L6:
        if (r3 == null) goto L8;
        r3 = TintedDrawable.wrap(r3);
    L8:
        if (r4 == null) goto L10;
        r4 = TintedDrawable.wrap(r4);
    L10:
        super.setCompoundDrawables(r1, r2, r3, r4);
        tintDrawables();
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable r1, Drawable r2, Drawable r3, Drawable r4) {
        if (r1 == null) goto L4;
        r1 = TintedDrawable.wrap(r1);
    L4:
        if (r2 == null) goto L6;
        r2 = TintedDrawable.wrap(r2);
    L6:
        if (r3 == null) goto L8;
        r3 = TintedDrawable.wrap(r3);
    L8:
        if (r4 == null) goto L10;
        r4 = TintedDrawable.wrap(r4);
    L10:
        super.setCompoundDrawablesRelative(r1, r2, r3, r4);
        tintDrawables();
    }

    @Override // android.widget.TextView
    public void setTextColor(ColorStateList r1) {
        super.setTextColor(r1);
        tintDrawables();
    }

    private void tintDrawables() {
        ColorStateList r0 = getTextColors();
        if (r0 == null) goto L15;
        Drawable[] r1 = getAllCompoundDrawables();
        int r2 = r1.length;
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L10;
        Drawable r4 = r1[r3];
        if ((r4 instanceof TintedDrawable) == false) goto L9;
        ((TintedDrawable) r4).setTintListCompat(r0);
    L9:
        r3 = r3 + 1;
        goto L5
    L10:
        invalidate();
        return;
    }

    private Drawable[] getAllCompoundDrawables() {
        Drawable[] r1 = getCompoundDrawables();
        Drawable[] r5 = getCompoundDrawablesRelative();
        return new Drawable[]{r1[0], r1[1], r1[2], r1[3], r5[0], r5[2]};
    }
}
