package com.android.settings;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.preference.Preference;
import androidx.preference.PreferenceViewHolder;

/* JADX INFO: loaded from: classes2.dex */
public class IconPreferenceScreen extends Preference {
    private boolean mHighlight;
    private Drawable mIcon;

    public IconPreferenceScreen(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public IconPreferenceScreen(Context r3, AttributeSet r4, int r5) {
        super(r3, r4, r5);
        setLayoutResource(R.layout.preference_icon);
        TypedArray r6 = r3.obtainStyledAttributes(r4, R.styleable.IconPreferenceScreen, r5, 0);
        this.mIcon = r6.getDrawable(0);
        r6.recycle();
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder r2) {
        super.onBindViewHolder(r2);
        ImageView r0 = (ImageView) r2.findViewById(R.id.icon);
        if (r0 == null) goto L7;
        Drawable r1 = this.mIcon;
        if (r1 == null) goto L7;
        r0.setImageDrawable(r1);
    L7:
        TextView r3 = (TextView) r2.findViewById(android.R.id.title);
    }

    @Override // androidx.preference.Preference
    public void setIcon(Drawable r2) {
        if (r2 == null) goto L4;
    L5:
        if (r2 != null) goto L7;
        return;
    L7:
        if (r2.equals(this.mIcon) == true) goto L11;
    L8:
        this.mIcon = r2;
        notifyChanged();
        return;
    L11:
        return;
    L4:
        if (this.mIcon != null) goto L8;
        goto L5
    }

    @Override // androidx.preference.Preference
    public Drawable getIcon() {
        return this.mIcon;
    }

    public void setHighlighted(boolean r1) {
        this.mHighlight = r1;
        notifyChanged();
    }
}
