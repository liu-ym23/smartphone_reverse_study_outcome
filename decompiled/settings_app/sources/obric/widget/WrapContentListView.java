package obric.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;

/* JADX INFO: loaded from: classes5.dex */
public class WrapContentListView extends ListView {
    private int mMaxHeight;

    public WrapContentListView(Context context) {
        super(context);
        this.mMaxHeight = 536870911;
    }

    public WrapContentListView(Context context, int maxHeight) {
        super(context);
        this.mMaxHeight = maxHeight;
    }

    public WrapContentListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mMaxHeight = 536870911;
    }

    public WrapContentListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mMaxHeight = 536870911;
    }

    public void setMaxHeight(int maxHeight) {
        if (this.mMaxHeight == maxHeight) goto L6;
        this.mMaxHeight = maxHeight;
        requestLayout();
        return;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int r0 = this.mMaxHeight;
        if (r0 <= 0) goto L5;
        heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(r0, Integer.MIN_VALUE);
    L5:
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
