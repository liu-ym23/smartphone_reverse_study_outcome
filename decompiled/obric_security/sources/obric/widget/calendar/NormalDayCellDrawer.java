package obric.widget.calendar;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import obric.widget.R;

/* JADX INFO: loaded from: classes5.dex */
public abstract class NormalDayCellDrawer extends DayCellViewDrawer {
    protected float mCellWidth;
    protected Context mContext;
    private boolean mDrawFocus;
    private int mNonthNumSize;
    protected int mNormalNumColor;
    protected int mNotFocusColor;
    public PaintFactory mPaintFactory;
    protected int mTodayColor;
    private int mTodaySize;
    protected String mTodayText;

    protected void drawDayNum(float xa, String dayNum, String lunar, Canvas canvas, float precents) {
    }

    protected abstract Paint getDayNumPaint();

    protected void prepareDrawView(int startX, String dayNum, String lunar, int eventType, int viewType) {
    }

    public NormalDayCellDrawer(Context context, boolean mDrawFocus, float cellWidth) {
        this.mDrawFocus = mDrawFocus;
        this.mContext = context;
        this.mCellWidth = cellWidth;
        this.mPaintFactory = new PaintFactory();
        initColor();
        this.mTodayText = context.getResources().getString(R.string.today_text);
        this.mTodaySize = context.getResources().getDimensionPixelSize(R.dimen.today_text_size_month_number);
        this.mNonthNumSize = context.getResources().getDimensionPixelSize(R.dimen.text_size_month_number);
    }

    private void initColor() {
        Resources r0 = this.mContext.getResources();
        this.mNormalNumColor = r0.getColor(R.color.black_60);
        this.mNotFocusColor = r0.getColor(R.color.month_day_number_other);
        this.mTodayColor = r0.getColor(R.color.month_today_number);
    }

    @Override // obric.widget.calendar.DayCellViewDrawer
    public void drawView(int startX, String dayNum, String lunar, int eventType, int viewType, Canvas canvas, float switchAnimProgress) {
        prepareDrawView(startX, dayNum, lunar, eventType, viewType);
        Paint r12 = getDayNumPaint();
        boolean r2 = true;
        if ((VIEW_TYPE_TODAY & viewType) != VIEW_TYPE_TODAY) goto L5;
        boolean r0 = true;
    L7:
        if ((VIEW_TYPE_SELECTED & viewType) != VIEW_TYPE_SELECTED) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == true) goto L14;
        if (r0 == true) goto L14;
        boolean r4 = false;
    L16:
        if ((VIEW_TYPE_NOT_FOCUS_MONTH & viewType) != VIEW_TYPE_NOT_FOCUS_MONTH) goto L18;
        boolean r5 = true;
    L20:
        if ((VIEW_TYPE_DAY_OUT_OF_RANGE & viewType) != VIEW_TYPE_DAY_OUT_OF_RANGE) goto L22;
        boolean r6 = true;
    L24:
        if ((viewType & VIEW_TYPE_DAY_NO_VALID) == VIEW_TYPE_DAY_NO_VALID) goto L28;
        r2 = false;
    L28:
        if (this.mDrawFocus == false) goto L42;
        if (r0 == true) goto L41;
        if (r1 == true) goto L41;
        if (r5 == false) goto L38;
        if (r6 == true) goto L37;
        if (r2 == true) goto L37;
        setFocusColor(r12, switchAnimProgress);
    L45:
        r12.setFakeBoldText(r4);
        if (r0 == false) goto L48;
        r12.setTextSize(this.mTodaySize);
        dayNum = this.mTodayText;
    L49:
        drawDayNum(startX, dayNum, lunar, canvas, switchAnimProgress);
        return;
    L48:
        r12.setTextSize(this.mNonthNumSize);
    L37:
        setFocusColor(r12, 0.0f);
        goto L45
    L38:
        if (r2 == false) goto L40;
        setFocusColor(r12, 0.0f);
        goto L45
    L40:
        setNormalColor(r12);
    L41:
        setTodayColor(r12);
        goto L45
    L42:
        if (r2 == false) goto L44;
        setFocusColor(r12, 0.0f);
        goto L45
    L44:
        setNormalColor(r12);
        goto L45
    L22:
        r6 = false;
        goto L24
    L18:
        r5 = false;
    L14:
        r4 = true;
        goto L16
    L9:
        r1 = false;
        goto L10
    L5:
        r0 = false;
        goto L7
    }

    @Override // obric.widget.calendar.DayCellViewDrawer
    public void setHasFocus(boolean hasFocus) {
        this.mDrawFocus = hasFocus;
    }

    protected void setNormalColor(Paint dayNumPaint) {
        dayNumPaint.setColor(this.mNormalNumColor);
    }

    protected void setFocusColor(Paint dayNumPaint, float switchAnimProgress) {
        if (switchAnimProgress >= 0.5f) goto L5;
        int r1 = this.mNotFocusColor;
    L6:
        dayNumPaint.setColor(r1);
        return;
    L5:
        r1 = this.mNormalNumColor;
        goto L6
    }

    protected void setTodayColor(Paint dayNumPaint) {
        dayNumPaint.setColor(this.mTodayColor);
    }

    protected float getCenterPosition(int startX, String dayNum, Paint paint) {
        return startX - ((this.mCellWidth - getStringWidth(dayNum, paint)) / 2.0f);
    }

    protected float getStringWidth(String text, Paint paint) {
        int r2 = text.length();
        float[] r0 = new float[r2];
        paint.getTextWidths(text, r0);
        float r3 = 0.0f;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L5;
        r3 = r3 + r0[r4];
        r4 = r4 + 1;
        goto L3
    L5:
        return r3;
    }
}
