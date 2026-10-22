package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.icu.lang.UCharacter;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.core.widgets.ConstraintWidget;

/* JADX INFO: loaded from: classes.dex */
public class Placeholder extends View {
    private View mContent;
    private int mContentId;
    private int mEmptyVisibility;

    public Placeholder(Context context) {
        super(context);
        this.mContentId = -1;
        this.mContent = null;
        this.mEmptyVisibility = 4;
        init(null);
    }

    public Placeholder(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContentId = -1;
        this.mContent = null;
        this.mEmptyVisibility = 4;
        init(attrs);
    }

    public Placeholder(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContentId = -1;
        this.mContent = null;
        this.mEmptyVisibility = 4;
        init(attrs);
    }

    public Placeholder(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr);
        this.mContentId = -1;
        this.mContent = null;
        this.mEmptyVisibility = 4;
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        super.setVisibility(this.mEmptyVisibility);
        this.mContentId = -1;
        if (attrs == null) goto L19;
        TypedArray r5 = getContext().obtainStyledAttributes(attrs, R.styleable.ConstraintLayout_placeholder);
        int r0 = r5.getIndexCount();
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L13;
        int r2 = r5.getIndex(r1);
        if (r2 != R.styleable.ConstraintLayout_placeholder_content) goto L10;
        this.mContentId = r5.getResourceId(r2, this.mContentId);
    L12:
        r1 = r1 + 1;
        goto L5
    L10:
        if (r2 != R.styleable.ConstraintLayout_placeholder_placeholder_emptyVisibility) goto L12;
        this.mEmptyVisibility = r5.getInt(r2, this.mEmptyVisibility);
        goto L12
    L13:
        r5.recycle();
        return;
    }

    public void setEmptyVisibility(int visibility) {
        this.mEmptyVisibility = visibility;
    }

    public int getEmptyVisibility() {
        return this.mEmptyVisibility;
    }

    public View getContent() {
        return this.mContent;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (isInEditMode() == false) goto L6;
        canvas.drawRGB(UCharacter.UnicodeBlock.COPTIC_EPACT_NUMBERS_ID, UCharacter.UnicodeBlock.COPTIC_EPACT_NUMBERS_ID, UCharacter.UnicodeBlock.COPTIC_EPACT_NUMBERS_ID);
        Paint r6 = new Paint();
        r6.setARGB(255, 210, 210, 210);
        r6.setTextAlign(Paint.Align.CENTER);
        r6.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
        Rect r0 = new Rect();
        canvas.getClipBounds(r0);
        r6.setTextSize(r0.height());
        int r2 = r0.height();
        int r3 = r0.width();
        r6.setTextAlign(Paint.Align.LEFT);
        r6.getTextBounds("?", 0, 1, r0);
        canvas.drawText("?", ((r3 / 2.0f) - (r0.width() / 2.0f)) - r0.left, ((r2 / 2.0f) + (r0.height() / 2.0f)) - r0.bottom, r6);
        return;
    }

    public void updatePreLayout(ConstraintLayout container) {
        if (this.mContentId == (-1)) goto L5;
    L7:
        View r3 = container.findViewById(this.mContentId);
        this.mContent = r3;
        if (r3 == null) goto L11;
        ((ConstraintLayout.LayoutParams) r3.getLayoutParams()).isInPlaceholder = true;
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

    public void setContentId(int id) {
        if (this.mContentId != id) goto L5;
        return;
    L5:
        View r0 = this.mContent;
        if (r0 == null) goto L8;
        r0.setVisibility(0);
        ((ConstraintLayout.LayoutParams) this.mContent.getLayoutParams()).isInPlaceholder = false;
        this.mContent = null;
    L8:
        this.mContentId = id;
        if (id == (-1)) goto L14;
        View r2 = ((View) getParent()).findViewById(id);
        if (r2 == null) goto L15;
        r2.setVisibility(8);
        return;
    L15:
        return;
    }

    public void updatePostMeasure(ConstraintLayout container) {
        if (this.mContent != null) goto L5;
        return;
    L5:
        ConstraintLayout.LayoutParams r3 = (ConstraintLayout.LayoutParams) getLayoutParams();
        ConstraintLayout.LayoutParams r2 = (ConstraintLayout.LayoutParams) this.mContent.getLayoutParams();
        r2.widget.setVisibility(0);
        if (r3.widget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.FIXED) goto L9;
        r3.widget.setWidth(r2.widget.getWidth());
    L9:
        if (r3.widget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.FIXED) goto L11;
        r3.widget.setHeight(r2.widget.getHeight());
    L11:
        r2.widget.setVisibility(8);
    }
}
