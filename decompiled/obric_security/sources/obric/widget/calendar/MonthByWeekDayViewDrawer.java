package obric.widget.calendar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import obric.widget.R;

/* JADX INFO: loaded from: classes5.dex */
public class MonthByWeekDayViewDrawer extends NormalDayCellDrawer {
    private int mMonthNumTop;
    private int mWeekNumTop;

    public MonthByWeekDayViewDrawer(Context context, boolean mDrawFocus, float cellWidth) {
        super(context, mDrawFocus, cellWidth);
        this.mWeekNumTop = (int) context.getResources().getDimension(R.dimen.monthweek_relative_week_en_num);
        this.mMonthNumTop = (int) context.getResources().getDimension(R.dimen.monthweek_relative_month_num);
    }

    @Override // obric.widget.calendar.NormalDayCellDrawer
    protected void drawDayNum(float xa, String dayNum, String lunnar, Canvas canvas, float switchAnimProgress) {
        int r4 = this.mMonthNumTop;
        canvas.drawText(dayNum, getCenterPosition((int) xa, dayNum, getDayNumPaint()), r4 + ((int) (switchAnimProgress * (this.mWeekNumTop - r4))), getDayNumPaint());
    }

    @Override // obric.widget.calendar.NormalDayCellDrawer
    protected Paint getDayNumPaint() {
        return this.mPaintFactory.getWeekNumPaint(this.mContext);
    }
}
