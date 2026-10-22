package com.android.settings.display;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public class MessageBubbleBackground extends LinearLayout {
    private final int mSnapWidthPixels;

    public MessageBubbleBackground(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.mSnapWidthPixels = r1.getResources().getDimensionPixelSize(R.dimen.conversation_bubble_width_snap);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int r6, int r7) {
        super.onMeasure(r6, r7);
        int r0 = getPaddingLeft() + getPaddingRight();
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(r6) - r0, (int) (Math.ceil((getMeasuredWidth() - r0) / this.mSnapWidthPixels) * ((double) this.mSnapWidthPixels))) + r0, 1073741824), r7);
    }
}
