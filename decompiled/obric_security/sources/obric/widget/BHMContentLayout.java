package obric.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: classes5.dex */
public class BHMContentLayout extends LinearLayout {
    private int mMaxHeight;

    public BHMContentLayout(Context context) {
        this(context, null);
    }

    public BHMContentLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BHMContentLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setMaxHeight(int height) {
        this.mMaxHeight = height;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int r0 = View.MeasureSpec.getSize(heightMeasureSpec);
        int r1 = View.MeasureSpec.getMode(heightMeasureSpec);
        int r2 = this.mMaxHeight;
        if (r0 <= r2) goto L6;
        if (r2 == 0) goto L6;
        heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(r2, r1);
    L6:
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
