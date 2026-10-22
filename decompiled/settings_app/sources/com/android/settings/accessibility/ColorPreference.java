package com.android.settings.accessibility;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.preference.PreferenceViewHolder;
import com.android.settings.R;
import com.android.settings.utils.NullSafe;

/* JADX INFO: loaded from: classes2.dex */
public class ColorPreference extends ListDialogPreference {
    private static final float ALPHA_VALUE = 0.2f;
    private static final int VALUE = 255;
    private ColorDrawable mPreviewColor;
    private boolean mPreviewEnabled;

    public ColorPreference(Context r1, AttributeSet r2) {
        super(r1, r2);
        setDialogLayoutResource(R.layout.grid_picker_dialog);
        setListItemLayoutResource(R.layout.color_picker_item);
    }

    public void setPreviewEnabled(boolean r2) {
        if (this.mPreviewEnabled == r2) goto L9;
        this.mPreviewEnabled = r2;
        if (r2 == false) goto L7;
        setWidgetLayoutResource(R.layout.preference_color);
        return;
    L7:
        setWidgetLayoutResource(0);
        return;
    }

    @Override // androidx.preference.Preference
    public boolean shouldDisableDependents() {
        if (Color.alpha(getValue()) != 0) goto L5;
    L8:
        return true;
    L5:
        if (super.shouldDisableDependents() == true) goto L8;
        return false;
    }

    @Override // com.android.settings.accessibility.ListDialogPreference
    protected CharSequence getTitleAt(int r5) {
        CharSequence r0 = super.getTitleAt(r5);
        if (r0 == null) goto L5;
        return r0;
    L5:
        int r6 = getValueAt(r5);
        int r1 = Color.red(r6);
        int r2 = Color.green(r6);
        int r7 = Color.blue(r6);
        return getContext().getString(R.string.color_custom, new Object[]{Integer.valueOf(r1), Integer.valueOf(r2), Integer.valueOf(r7)});
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder r5) {
        super.onBindViewHolder(r5);
        if (this.mPreviewEnabled == false) goto L24;
        ImageView r6 = (ImageView) r5.findViewById(R.id.color_preview);
        int r0 = getValue();
        if (r6 != null) goto L7;
        return;
    L7:
        if (Color.alpha(r0) >= 255) goto L9;
        r6.setBackgroundResource(R.drawable.transparency_tileable);
    L10:
        ColorDrawable r1 = this.mPreviewColor;
        if (r1 != null) goto L13;
        ColorDrawable r2 = new ColorDrawable(r0);
        this.mPreviewColor = r2;
        r6.setImageDrawable(r2);
    L14:
        CharSequence r3 = getSummary();
        if (TextUtils.isEmpty(r3) == true) goto L17;
        r6.setContentDescription(r3);
    L19:
        if (isEnabled() == false) goto L21;
        float r4 = 1.0f;
    L22:
        r6.setAlpha(r4);
        return;
    L21:
        r4 = 0.2f;
        goto L22
    L17:
        r6.setContentDescription(null);
        goto L19
    L13:
        r1.setColor(r0);
        goto L14
    L9:
        r6.setBackground(null);
        goto L10
    }

    @Override // com.android.settings.accessibility.ListDialogPreference
    protected void onBindListItem(View r5, int r6) {
        int r0 = getValueAt(r6);
        int r1 = Color.alpha(r0);
        ImageView r2 = (ImageView) NullSafe.nonNull(r5.findViewById(R.id.color_swatch));
        if (r2 != null) goto L5;
        return;
    L5:
        if (r1 >= 255) goto L7;
        r2.setBackgroundResource(R.drawable.transparency_tileable);
    L8:
        Drawable r3 = r2.getDrawable();
        if ((r3 instanceof ColorDrawable) == false) goto L11;
        ((ColorDrawable) r3).setColor(r0);
    L12:
        CharSequence r4 = getTitleAt(r6);
        if (r4 == null) goto L17;
        ((TextView) NullSafe.nonNull(r5.findViewById(R.id.summary))).setText(r4);
        return;
    L17:
        return;
    L11:
        r2.setImageDrawable(new ColorDrawable(r0));
        goto L12
    L7:
        r2.setBackground(null);
        goto L8
    }
}
