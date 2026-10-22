package com.android.settings.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.settings.R;

/* JADX INFO: loaded from: classes.dex */
public class TouchAreaTestView extends RelativeLayout {
    private static final String TAG = "TouchAreaTestView";
    private TextView mTestTextView;
    private TouchAreaAnimView mTouchAreaAnimView;

    public TouchAreaTestView(Context r2) {
        this(r2, null);
    }

    public TouchAreaTestView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public TouchAreaTestView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        LayoutInflater.from(r1).inflate(R.layout.touch_area_test_view_layout, this, true);
        this.mTouchAreaAnimView = (TouchAreaAnimView) findViewById(R.id.anim_area);
        TextView r4 = (TextView) findViewById(R.id.test_text);
        this.mTestTextView = r4;
        this.mTouchAreaAnimView.setTargetTextView(r4);
    }

    public void setTouchAreaType(int r1) {
        this.mTouchAreaAnimView.setTouchAreaType(r1);
    }

    public void cancelAnims() {
        this.mTouchAreaAnimView.cancelAnims();
    }
}
