package com.android.settings.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import bytedanceos.api.ViewSmt;
import com.obric.oui.bouncelayout.OListView;

/* JADX INFO: loaded from: classes.dex */
public class SettingsListView extends OListView {
    public SettingsListView(Context r2) {
        this(r2, null);
    }

    public SettingsListView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public SettingsListView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onGenericMotionEvent(MotionEvent r3) {
        if (r3.isFromSource(2) == false) goto L9;
        if (r3.getAction() != 8) goto L9;
        ViewSmt.getInstance().setDrawScrollBar(this, true);
    L9:
        return super.onGenericMotionEvent(r3);
    }
}
