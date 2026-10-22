package obric.widget;

import android.content.Context;
import android.util.AttributeSet;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class NumberPickerExtended extends NumberPickerEx {
    private int mFackIndex;
    private int mTempMaxValue;

    class FackValueWrapperFormatter implements NumberPickerEx.Formatter {
        private NumberPickerEx.Formatter mFormatter;
        final /* synthetic */ NumberPickerExtended this$0;

        FackValueWrapperFormatter(final NumberPickerExtended this$0, NumberPickerEx.Formatter formatter) {
            this.this$0 = this$0;
            this.mFormatter = formatter;
        }

        @Override // obric.widget.NumberPickerEx.Formatter
        public String format(int value) {
            if ((this.this$0.getMaxValue() - value) > NumberPickerExtended.access$000(this.this$0)) goto L7;
            return "";
        L7:
            return this.mFormatter.format(value);
        }
    }

    static /* synthetic */ int access$000(NumberPickerExtended r0) {
        return r0.mFackIndex;
    }

    public NumberPickerExtended(Context context) {
        super(context);
        this.mFackIndex = 3;
    }

    public NumberPickerExtended(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mFackIndex = 3;
    }

    public NumberPickerExtended(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mFackIndex = 3;
    }

    @Override // obric.widget.NumberPickerEx
    public void setMaxValue(int maxValue) {
        int r2 = maxValue + this.mFackIndex;
        this.mTempMaxValue = r2;
        super.setMaxValue(r2);
    }

    public void setFackIndex(int fackIndex) {
        this.mFackIndex = fackIndex;
        setMaxValue(getMaxValue());
    }

    @Override // obric.widget.NumberPickerEx
    public void setFormatter(NumberPickerEx.Formatter formatter) {
        super.setFormatter(new FackValueWrapperFormatter(this, formatter));
    }

    @Override // obric.widget.NumberPickerEx, android.view.View
    public void scrollBy(int x, int y) {
        if (y > 0) goto L5;
    L7:
        if (y < 0) goto L9;
    L11:
        super.scrollBy(x, y);
        return;
    L9:
        if (getValue() < ((getMaxValue() - this.mFackIndex) - 1)) goto L11;
        super.scrollBy(x, 0);
        return;
    L5:
        if (getValue() != getMinValue()) goto L7;
        super.scrollBy(x, 0);
    }
}
