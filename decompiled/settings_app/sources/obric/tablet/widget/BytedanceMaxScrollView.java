package obric.tablet.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;
import com.android.settings.R;

/* JADX INFO: loaded from: classes5.dex */
public class BytedanceMaxScrollView extends ScrollView {
    private int mMaxHeight;

    public BytedanceMaxScrollView(Context r2) {
        this(r2, null);
    }

    public BytedanceMaxScrollView(Context r1, AttributeSet r2) {
        super(r1, r2);
        init(r1);
    }

    public BytedanceMaxScrollView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        init(r1);
    }

    private void init(Context r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        this.mMaxHeight = r2.getResources().getDimensionPixelSize(R.dimen.revone_scrollview_default_max_height);
    }

    public void setMaxHeight(int r1) {
        this.mMaxHeight = r1;
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int r3, int r4) {
        int r0 = View.MeasureSpec.getMode(r4);
        int r5 = View.MeasureSpec.getSize(r4);
        int r1 = this.mMaxHeight;
        if (r5 <= r1) goto L6;
        r5 = r1;
    L6:
        super.onMeasure(r3, View.MeasureSpec.makeMeasureSpec(r5, r0));
    }
}
