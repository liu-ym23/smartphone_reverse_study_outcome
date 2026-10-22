package com.android.settings.accessibility;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.android.internal.widget.SubtitleView;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public class EdgeTypePreference extends ListDialogPreference {
    private static final int DEFAULT_BACKGROUND_COLOR = 0;
    private static final int DEFAULT_EDGE_COLOR = -16777216;
    private static final float DEFAULT_FONT_SIZE = 32.0f;
    private static final int DEFAULT_FOREGROUND_COLOR = -1;

    public EdgeTypePreference(Context r1, AttributeSet r2) {
        super(r1, r2);
        Resources r3 = r1.getResources();
        setValues(r3.getIntArray(R.array.captioning_edge_type_selector_values));
        setTitles(r3.getStringArray(R.array.captioning_edge_type_selector_titles));
        setDialogLayoutResource(R.layout.grid_picker_dialog);
        setListItemLayoutResource(R.layout.preset_picker_item);
    }

    @Override // androidx.preference.Preference
    public boolean shouldDisableDependents() {
        if (getValue() != 0) goto L5;
    L8:
        return true;
    L5:
        if (super.shouldDisableDependents() == true) goto L8;
        return false;
    }

    @Override // com.android.settings.accessibility.ListDialogPreference
    protected void onBindListItem(View r4, int r5) {
        SubtitleView r0 = r4.findViewById(R.id.preview);
        r0.setForegroundColor(-1);
        r0.setBackgroundColor(0);
        r0.setTextSize(getContext().getResources().getDisplayMetrics().density * 32.0f);
        r0.setEdgeType(getValueAt(r5));
        r0.setEdgeColor(-16777216);
        CharSequence r3 = getTitleAt(r5);
        if (r3 == null) goto L6;
        ((TextView) r4.findViewById(R.id.summary)).setText(r3);
        return;
    }
}
