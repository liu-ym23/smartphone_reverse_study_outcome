package com.bytedanceos.security.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.obric.oui.divider.ODivider;
import com.obric.oui.progress.OProgressView;
import com.obric.security.R;
import java.text.DecimalFormat;
import obric.widget.ListContentItem;

/* JADX INFO: loaded from: classes2.dex */
public class SecurityProgressItemText extends ListContentItem {
    private View mBottomSpliteView;
    private int mMaxProgress;
    private OProgressView mProgressBar;
    private TextView mProgressText;

    @Override // obric.widget.ListContentItem
    protected int getDefaultLeftLayout() {
        return R.layout.security_progress_item_text_left_layout;
    }

    @Override // obric.widget.ListContentItem
    protected int getDefaultMidLayout() {
        return R.layout.security_progress_item_text_mid_layout;
    }

    @Override // obric.widget.ListContentItem
    protected int getDefaultRightLayout() {
        return -1;
    }

    @Override // obric.widget.ListContentItem
    protected void initRightWidget() {
    }

    @Override // obric.widget.ListContentItem
    public void setBackgroundStyle(int style) {
    }

    @Override // obric.widget.ListContentItem
    public void setSummary(CharSequence s) {
    }

    public SecurityProgressItemText(Context context) {
        this(context, null);
    }

    public SecurityProgressItemText(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SecurityProgressItemText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray r3 = context.obtainStyledAttributes(attrs, R.styleable.SecurityItemText, defStyleAttr, 0);
        boolean r4 = r3.getBoolean(3, false);
        r3.recycle();
        showSpliteLine(r4);
    }

    public void showSpliteLine(boolean show) {
        View r0 = this.mBottomSpliteView;
        if (r0 != null) goto L5;
        return;
    L5:
        if (show == false) goto L7;
        int r1 = 0;
    L8:
        r0.setVisibility(r1);
        return;
    L7:
        r1 = 8;
        goto L8
    }

    public void setMaxProgress(int max) {
        if (this.mProgressBar != null) goto L5;
        return;
    L5:
        this.mMaxProgress = max;
    }

    public void setCurrentProgress(double current) {
        OProgressView r0 = this.mProgressBar;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setProgress((((int) current) * 100) / this.mMaxProgress);
        this.mProgressText.setText(new DecimalFormat("0.0").format((current * 100.0d) / ((double) this.mMaxProgress)) + "%");
    }

    @Override // obric.widget.ListContentItem
    protected void initMidWidget() {
        super.initMidWidget();
        this.mProgressBar = (OProgressView) findViewById(R.id.id_progress);
        this.mProgressText = (TextView) findViewById(R.id.item_progress_text);
        this.mBottomSpliteView = new ODivider(getContext());
        RelativeLayout.LayoutParams r1 = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.dimen_0_5));
        r1.addRule(12);
        r1.setMarginStart(getResources().getDimensionPixelSize(R.dimen.dimen_12));
        this.mBottomSpliteView.setLayoutParams(r1);
        addView(this.mBottomSpliteView);
    }
}
