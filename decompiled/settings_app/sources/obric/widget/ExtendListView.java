package obric.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;

/* JADX INFO: loaded from: classes5.dex */
public class ExtendListView extends ListView {
    public ExtendListView(Context r1) {
        super(r1);
    }

    public ExtendListView(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public ExtendListView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    protected void onMeasure(int r2, int r3) {
        super.onMeasure(r2, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }
}
