package com.android.settings.applications;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public class ApplicationItemView extends RelativeLayout {
    private String mDisableString;
    private ImageView mImageCheckView;
    private ImageView mImageIconView;
    private TextView mTextSummaryView;
    private TextView mTextTitleView;

    public ApplicationItemView(Context r2) {
        this(r2, null);
    }

    public ApplicationItemView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public ApplicationItemView(Context r2, AttributeSet r3, int r4) {
        super(r2, r3, r4);
        LayoutInflater.from(r2).inflate(R.layout.application_item_layout, this, true);
        setGravity(16);
        this.mImageIconView = (ImageView) findViewById(R.id.item_icon);
        this.mImageCheckView = (ImageView) findViewById(R.id.item_check);
        this.mTextTitleView = (TextView) findViewById(R.id.item_title);
        this.mTextSummaryView = (TextView) findViewById(R.id.item_summary);
        this.mDisableString = r2.getString(R.string.item_disabled);
    }

    public void setTitle(CharSequence r1) {
        this.mTextTitleView.setText(r1);
    }

    public void setTitle(int r1) {
        this.mTextTitleView.setText(r1);
    }

    public void setSummary(CharSequence r1) {
        this.mTextSummaryView.setText(r1);
    }

    public void setSummary(int r1) {
        this.mTextSummaryView.setText(r1);
    }

    public void setSummaryVisible(boolean r1) {
        TextView r0 = this.mTextSummaryView;
        if (r1 == false) goto L5;
        int r2 = 0;
    L6:
        r0.setVisibility(r2);
        return;
    L5:
        r2 = 8;
        goto L6
    }

    public void setIcon(int r1) {
        this.mImageIconView.setImageResource(r1);
    }

    public void setIcon(Drawable r1) {
        this.mImageIconView.setImageDrawable(r1);
    }

    public void setCheck(boolean r1) {
        ImageView r0 = this.mImageCheckView;
        if (r1 == false) goto L5;
        int r2 = 0;
    L6:
        r0.setVisibility(r2);
        return;
    L5:
        r2 = 4;
        goto L6
    }

    public boolean isChecked() {
        if (this.mImageCheckView.getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r1) {
        super.onInitializeAccessibilityNodeInfo(r1);
        r1.setSelected(isChecked());
    }

    public void setAccessibilityState(boolean r2) {
        if (r2 == true) goto L5;
        setContentDescription(this.mTextTitleView.getText() + ", " + this.mDisableString);
        return;
    }
}
