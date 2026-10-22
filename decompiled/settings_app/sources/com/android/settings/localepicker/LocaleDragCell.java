package com.android.settings.localepicker;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public class LocaleDragCell extends RelativeLayout {
    private CheckBox mCheckbox;
    private ImageView mDragHandle;
    private TextView mLabel;
    private TextView mLocalized;
    private TextView mMiniLabel;

    public LocaleDragCell(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.mLabel = (TextView) findViewById(R.id.label);
        this.mLocalized = (TextView) findViewById(R.id.l10nWarn);
        this.mMiniLabel = (TextView) findViewById(R.id.miniLabel);
        this.mCheckbox = (CheckBox) findViewById(R.id.checkbox);
        this.mDragHandle = (ImageView) findViewById(R.id.dragHandle);
    }

    public void setShowHandle(boolean r2) {
        ImageView r0 = this.mDragHandle;
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        invalidate();
        requestLayout();
        return;
    L5:
        r3 = 4;
        goto L6
    }

    public void setShowCheckbox(boolean r3) {
        if (r3 == false) goto L5;
        this.mCheckbox.setVisibility(0);
        this.mLabel.setVisibility(4);
    L6:
        invalidate();
        requestLayout();
        return;
    L5:
        this.mCheckbox.setVisibility(4);
        this.mLabel.setVisibility(0);
        goto L6
    }

    public void setChecked(boolean r1) {
        this.mCheckbox.setChecked(r1);
    }

    public void setShowMiniLabel(boolean r2) {
        TextView r0 = this.mMiniLabel;
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        invalidate();
        requestLayout();
        return;
    L5:
        r3 = 8;
        goto L6
    }

    public void setMiniLabel(String r2) {
        this.mMiniLabel.setText(r2);
        invalidate();
    }

    public void setLabelAndDescription(String r2, String r3) {
        this.mLabel.setText(r2);
        this.mCheckbox.setText(r2);
        this.mLabel.setContentDescription(r3);
        this.mCheckbox.setContentDescription(r3);
        invalidate();
    }

    public void setLocalized(boolean r2) {
        TextView r0 = this.mLocalized;
        if (r2 == false) goto L5;
        int r3 = 8;
    L6:
        r0.setVisibility(r3);
        invalidate();
        return;
    L5:
        r3 = 0;
        goto L6
    }

    public ImageView getDragHandle() {
        return this.mDragHandle;
    }

    public CheckBox getCheckbox() {
        return this.mCheckbox;
    }
}
