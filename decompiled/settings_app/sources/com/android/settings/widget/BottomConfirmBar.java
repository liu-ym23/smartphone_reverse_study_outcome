package com.android.settings.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.settings.R;

/* JADX INFO: loaded from: classes.dex */
public class BottomConfirmBar extends RelativeLayout {
    private ImageView mApplyBtn;
    private ImageView mCancelBtn;
    private TextView mTitle;

    public BottomConfirmBar(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public BottomConfirmBar(Context r2, AttributeSet r3, int r4) {
        this(r2, r3, r4, 0);
    }

    public BottomConfirmBar(Context r1, AttributeSet r2, int r3, int r4) {
        super(r1, r2, r3, r4);
        setGravity(16);
        View r5 = LayoutInflater.from(r1).inflate(R.layout.bottom_confirm_bar, this, true);
        r5.setBackgroundResource(R.drawable.bottom_confirm_bar_bg);
        this.mCancelBtn = (ImageView) r5.findViewById(R.id.cancel_btn);
        this.mApplyBtn = (ImageView) r5.findViewById(R.id.ok_btn);
        this.mTitle = (TextView) r5.findViewById(R.id.title);
    }

    public void setTitle(CharSequence r1) {
        this.mTitle.setText(r1);
    }

    public void setTitle(int r1) {
        this.mTitle.setText(r1);
    }

    public void setOnCancelListener(View.OnClickListener r1) {
        this.mCancelBtn.setOnClickListener(r1);
    }

    public void setOnApplyListener(View.OnClickListener r1) {
        this.mApplyBtn.setOnClickListener(r1);
    }
}
