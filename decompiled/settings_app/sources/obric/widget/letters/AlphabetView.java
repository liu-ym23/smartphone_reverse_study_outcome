package obric.widget.letters;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.TextView;
import obric.widget.R;

/* JADX INFO: loaded from: classes5.dex */
public class AlphabetView extends TextView {
    public AlphabetView(Context context) {
        this(context, null);
    }

    public AlphabetView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AlphabetView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        setGravity(17);
        setTextSize(0, getResources().getDimension(R.dimen.obric_quickbarex_gridview_font_size));
        setTypeface(null, 1);
        setTextColor(Color.parseColor("#80000000"));
    }
}
