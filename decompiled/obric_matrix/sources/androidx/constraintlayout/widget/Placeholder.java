package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.core.widgets.ConstraintWidget;

/* JADX INFO: loaded from: classes.dex */
public class Placeholder extends View {
    private View mContent;
    private int mContentId;
    private int mEmptyVisibility;

    public Placeholder(Context r2) {
        super(r2);
        this.mContentId = -1;
        this.mContent = null;
        this.mEmptyVisibility = 4;
        init(null);
    }

    public Placeholder(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.mContentId = -1;
        this.mContent = null;
        this.mEmptyVisibility = 4;
        init(r2);
    }

    public Placeholder(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.mContentId = -1;
        this.mContent = null;
        this.mEmptyVisibility = 4;
        init(r2);
    }

    public Placeholder(Context r1, AttributeSet r2, int r3, int r4) {
        super(r1, r2, r3);
        this.mContentId = -1;
        this.mContent = null;
        this.mEmptyVisibility = 4;
        init(r2);
    }

    private void init(AttributeSet r5) {
        super.setVisibility(this.mEmptyVisibility);
        this.mContentId = -1;
        if (r5 == null) goto L19;
        TypedArray r6 = getContext().obtainStyledAttributes(r5, R.styleable.ConstraintLayout_placeholder);
        int r0 = r6.getIndexCount();
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L13;
        int r2 = r6.getIndex(r1);
        if (r2 != R.styleable.ConstraintLayout_placeholder_content) goto L10;
        this.mContentId = r6.getResourceId(r2, this.mContentId);
    L12:
        r1 = r1 + 1;
        goto L5
    L10:
        if (r2 != R.styleable.ConstraintLayout_placeholder_placeholder_emptyVisibility) goto L12;
        this.mEmptyVisibility = r6.getInt(r2, this.mEmptyVisibility);
        goto L12
    L13:
        r6.recycle();
        return;
    }

    public View getContent() {
        return this.mContent;
    }

    public int getEmptyVisibility() {
        return this.mEmptyVisibility;
    }

    @Override // android.view.View
    public void onDraw(Canvas r7) {
        if (isInEditMode() == false) goto L6;
        r7.drawRGB(223, 223, 223);
        Paint r6 = new Paint();
        r6.setARGB(255, 210, 210, 210);
        r6.setTextAlign(Paint.Align.CENTER);
        r6.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
        Rect r0 = new Rect();
        r7.getClipBounds(r0);
        r6.setTextSize(r0.height());
        int r2 = r0.height();
        int r3 = r0.width();
        r6.setTextAlign(Paint.Align.LEFT);
        r6.getTextBounds("?", 0, 1, r0);
        r7.drawText("?", ((r3 / 2.0f) - (r0.width() / 2.0f)) - r0.left, ((r2 / 2.0f) + (r0.height() / 2.0f)) - r0.bottom, r6);
        return;
    }

    public void setContentId(int r3) {
        if (this.mContentId != r3) goto L5;
        return;
    L5:
        View r0 = this.mContent;
        if (r0 == null) goto L8;
        r0.setVisibility(0);
        ((ConstraintLayout.LayoutParams) this.mContent.getLayoutParams()).isInPlaceholder = false;
        this.mContent = null;
    L8:
        this.mContentId = r3;
        if (r3 == (-1)) goto L14;
        View r2 = ((View) getParent()).findViewById(r3);
        if (r2 == null) goto L15;
        r2.setVisibility(8);
        return;
    L15:
        return;
    }

    public void setEmptyVisibility(int r1) {
        this.mEmptyVisibility = r1;
    }

    public void updatePostMeasure(ConstraintLayout r4) {
        if (this.mContent != null) goto L5;
        return;
    L5:
        ConstraintLayout.LayoutParams r5 = (ConstraintLayout.LayoutParams) getLayoutParams();
        ConstraintLayout.LayoutParams r3 = (ConstraintLayout.LayoutParams) this.mContent.getLayoutParams();
        r3.widget.setVisibility(0);
        ConstraintWidget.DimensionBehaviour r0 = r5.widget.getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour r1 = ConstraintWidget.DimensionBehaviour.FIXED;
        if (r0 == r1) goto L9;
        r5.widget.setWidth(r3.widget.getWidth());
    L9:
        if (r5.widget.getVerticalDimensionBehaviour() == r1) goto L11;
        r5.widget.setHeight(r3.widget.getHeight());
    L11:
        r3.widget.setVisibility(8);
    }

    public void updatePreLayout(ConstraintLayout r3) {
        if (this.mContentId == (-1)) goto L5;
    L7:
        View r4 = r3.findViewById(this.mContentId);
        this.mContent = r4;
        if (r4 == null) goto L11;
        ((ConstraintLayout.LayoutParams) r4.getLayoutParams()).isInPlaceholder = true;
        this.mContent.setVisibility(0);
        setVisibility(0);
        return;
    L11:
        return;
    L5:
        if (isInEditMode() == true) goto L7;
        setVisibility(this.mEmptyVisibility);
        goto L7
    }
}
