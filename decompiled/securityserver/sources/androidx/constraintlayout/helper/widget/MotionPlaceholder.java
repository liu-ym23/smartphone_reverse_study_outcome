package androidx.constraintlayout.helper.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Helper;
import androidx.constraintlayout.core.widgets.Placeholder;
import androidx.constraintlayout.widget.VirtualLayout;

/* JADX INFO: loaded from: classes.dex */
public class MotionPlaceholder extends VirtualLayout {
    private static final String TAG = "MotionPlaceholder";
    Placeholder mPlaceholder;

    public MotionPlaceholder(Context r1) {
        super(r1);
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout, androidx.constraintlayout.widget.ConstraintHelper
    public void init(AttributeSet r1) {
        super.init(r1);
        this.mHelperWidget = new Placeholder();
        validateParams();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    @SuppressLint({"WrongCall"})
    public void onMeasure(int r2, int r3) {
        onMeasure(this.mPlaceholder, r2, r3);
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void updatePreLayout(ConstraintWidgetContainer r1, Helper r2, SparseArray<ConstraintWidget> r3) {
    }

    public MotionPlaceholder(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout
    public void onMeasure(androidx.constraintlayout.core.widgets.VirtualLayout r3, int r4, int r5) {
        int r0 = View.MeasureSpec.getMode(r4);
        int r6 = View.MeasureSpec.getSize(r4);
        int r1 = View.MeasureSpec.getMode(r5);
        int r7 = View.MeasureSpec.getSize(r5);
        if (r3 == null) goto L5;
        r3.measure(r0, r6, r1, r7);
        setMeasuredDimension(r3.getMeasuredWidth(), r3.getMeasuredHeight());
        return;
    L5:
        setMeasuredDimension(0, 0);
    }

    public MotionPlaceholder(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }

    public MotionPlaceholder(Context r1, AttributeSet r2, int r3, int r4) {
        super(r1, r2, r3);
    }
}
