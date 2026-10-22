package com.qihoo360.mobilesafe.common.ui.base;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.qihoo360.mobilesafe.common.ui.R;

/* JADX INFO: loaded from: classes4.dex */
public class CommonListRowDivider extends View {
    private int dividerColor;
    private DIVIDER_TYPE dividerType;
    private int leftMargin;
    private Drawable paddingDrawable;
    private Paint paint;

    public static final enum DIVIDER_TYPE extends Enum<DIVIDER_TYPE> {
        private static final /* synthetic */ DIVIDER_TYPE[] $VALUES = null;
        public static final DIVIDER_TYPE TYPE_FULL = null;
        public static final DIVIDER_TYPE TYPE_MARGIN_LEFT = null;
        public static final DIVIDER_TYPE TYPE_NONE = null;

        private DIVIDER_TYPE(String r1, int r2) {
            super(r1, r2);
        }

        public static DIVIDER_TYPE valueOf(String r1) {
            return (DIVIDER_TYPE) Enum.valueOf(DIVIDER_TYPE.class, r1);
        }

        public static DIVIDER_TYPE[] values() {
            return (DIVIDER_TYPE[]) $VALUES.clone();
        }

        static {
            DIVIDER_TYPE r0 = new DIVIDER_TYPE("TYPE_MARGIN_LEFT", 0);
            TYPE_MARGIN_LEFT = r0;
            DIVIDER_TYPE r1 = new DIVIDER_TYPE("TYPE_FULL", 1);
            TYPE_FULL = r1;
            DIVIDER_TYPE r3 = new DIVIDER_TYPE("TYPE_NONE", 2);
            TYPE_NONE = r3;
            $VALUES = new DIVIDER_TYPE[]{r0, r1, r3};
        }
    }

    public CommonListRowDivider(Context r2) {
        this(r2, null);
    }

    public CommonListRowDivider(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public CommonListRowDivider(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        init();
    }

    private void init() {
        Paint r0 = new Paint();
        this.paint = r0;
        r0.setStyle(Paint.Style.FILL);
        setDividerColor(getResources().getColor(R.color.inner_common_bg_color_7));
        setDividerType(DIVIDER_TYPE.TYPE_MARGIN_LEFT);
    }

    public void setPaddingDrawable(int r3, Drawable r4) {
        this.leftMargin = r3;
        if (r4 != null) goto L5;
        this.paddingDrawable = null;
    L6:
        invalidate();
        return;
    L5:
        Drawable r5 = r4.mutate();
        this.paddingDrawable = r5;
        r5.setBounds(0, 0, this.leftMargin, 1);
        goto L6
    }

    public void setDividerColor(int r2) {
        if (r2 == this.dividerColor) goto L6;
        this.dividerColor = r2;
        invalidate();
        return;
    }

    public void setDividerType(DIVIDER_TYPE r2) {
        if (r2 != this.dividerType) goto L5;
        return;
    L5:
        if (r2 != DIVIDER_TYPE.TYPE_NONE) goto L7;
        setVisibility(8);
    L8:
        this.dividerType = r2;
        invalidate();
        return;
    L7:
        setVisibility(0);
        goto L8
    }

    @Override // android.view.View
    protected void onDraw(Canvas r9) {
        this.paint.setColor(this.dividerColor);
        if (this.dividerType != DIVIDER_TYPE.TYPE_MARGIN_LEFT) goto L9;
        Drawable r0 = this.paddingDrawable;
        if (r0 == null) goto L7;
        r0.draw(r9);
    L7:
        r9.drawRect(this.leftMargin, 0.0f, getWidth(), 1.0f, this.paint);
        return;
    L9:
        if (this.dividerType != DIVIDER_TYPE.TYPE_FULL) goto L13;
        r9.drawRect(0.0f, 0.0f, getWidth(), 1.0f, this.paint);
        return;
    }

    @Override // android.view.View
    protected void onMeasure(int r2, int r3) {
        super.onMeasure(r2, View.MeasureSpec.makeMeasureSpec(1, 1073741824));
    }
}
