package obric.widget.calendar;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import obric.widget.R;

/* JADX INFO: loaded from: classes5.dex */
public class PaintFactory {
    private Paint mMonthNumPaint;
    private Paint mWeekNumPaint;

    public PaintFactory() {
    }

    public Paint getWeekNumPaint(Context context) {
        if (this.mWeekNumPaint != null) goto L6;
        Paint r0 = new Paint();
        this.mWeekNumPaint = r0;
        r0.setFakeBoldText(false);
        this.mWeekNumPaint.setAntiAlias(true);
        this.mWeekNumPaint.setStyle(Paint.Style.FILL);
        this.mWeekNumPaint.setTextAlign(Paint.Align.RIGHT);
        float r3 = context.getResources().getDimension(R.dimen.text_size_month_number);
        this.mWeekNumPaint.setTextSize(r3);
    L6:
        return this.mWeekNumPaint;
    }

    public Paint getMonthNumWithoutLunarPaint(Context context) {
        if (this.mMonthNumPaint != null) goto L6;
        Paint r0 = new Paint();
        this.mMonthNumPaint = r0;
        r0.setFakeBoldText(false);
        this.mMonthNumPaint.setAntiAlias(true);
        this.mMonthNumPaint.setStyle(Paint.Style.FILL);
        this.mMonthNumPaint.setTextAlign(Paint.Align.RIGHT);
        this.mMonthNumPaint.setTypeface(Typeface.DEFAULT);
        float r3 = context.getResources().getDimension(R.dimen.text_size_month_number);
        this.mMonthNumPaint.setTextSize(r3);
    L6:
        return this.mMonthNumPaint;
    }
}
