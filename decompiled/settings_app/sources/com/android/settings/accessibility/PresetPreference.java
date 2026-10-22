package com.android.settings.accessibility;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.CaptioningManager;
import android.widget.TextView;
import com.android.internal.widget.SubtitleView;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public class PresetPreference extends ListDialogPreference {
    private static final float DEFAULT_FONT_SIZE = 32.0f;
    private final CaptioningManager mCaptioningManager;

    public PresetPreference(Context r1, AttributeSet r2) {
        super(r1, r2);
        setDialogLayoutResource(R.layout.grid_picker_dialog);
        setListItemLayoutResource(R.layout.preset_picker_item);
        this.mCaptioningManager = (CaptioningManager) r1.getSystemService("captioning");
    }

    @Override // androidx.preference.Preference
    public boolean shouldDisableDependents() {
        if (getValue() == (-1)) goto L5;
    L8:
        return true;
    L5:
        if (super.shouldDisableDependents() == true) goto L8;
        return false;
    }

    @Override // com.android.settings.accessibility.ListDialogPreference
    protected void onBindListItem(View r5, int r6) {
        View r0 = r5.findViewById(R.id.preview_viewport);
        SubtitleView r1 = r5.findViewById(R.id.preview);
        int r2 = getValueAt(r6);
        CaptionPropertiesFragment.applyCaptionProperties(this.mCaptioningManager, r1, r0, r2);
        r1.setTextSize(getContext().getResources().getDisplayMetrics().density * 32.0f);
        CharSequence r4 = getTitleAt(r6);
        if (r4 == null) goto L6;
        ((TextView) r5.findViewById(R.id.summary)).setText(r4);
        return;
    }
}
