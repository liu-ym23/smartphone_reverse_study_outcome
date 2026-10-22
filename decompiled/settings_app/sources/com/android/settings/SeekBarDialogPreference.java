package com.android.settings;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;

/* JADX INFO: loaded from: classes2.dex */
public class SeekBarDialogPreference extends CustomDialogPreference {
    private final Drawable mMyIcon;

    public SeekBarDialogPreference(Context r1, AttributeSet r2) {
        super(r1, r2);
        setDialogLayoutResource(R.layout.preference_dialog_seekbar_material);
        createActionButtons();
        this.mMyIcon = getDialogIcon();
        setDialogIcon(null);
    }

    public SeekBarDialogPreference(Context r2) {
        this(r2, null);
    }

    public void createActionButtons() {
        setPositiveButtonText(android.R.string.ok);
        setNegativeButtonText(android.R.string.cancel);
    }

    @Override // com.android.settings.CustomDialogPreference
    protected void onBindDialogView(View r2) {
        super.onBindDialogView(r2);
        ImageView r3 = (ImageView) r2.findViewById(android.R.id.icon);
        Drawable r1 = this.mMyIcon;
        if (r1 == null) goto L5;
        r3.setImageDrawable(r1);
        return;
    L5:
        r3.setVisibility(8);
    }

    protected static SeekBar getSeekBar(View r1) {
        return (SeekBar) r1.findViewById(R.id.seekbar);
    }
}
