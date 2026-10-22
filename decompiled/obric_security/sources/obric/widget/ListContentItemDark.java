package obric.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ListContentItemDark extends ListContentItem {
    private static final String TAG = "ListContentItemDark";
    private int mBackStyle;

    public ListContentItemDark(Context context) {
        this(context, null);
    }

    public ListContentItemDark(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ListContentItemDark(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray r3 = context.obtainStyledAttributes(attrs, R.styleable.ListContentItem, defStyleAttr, 0);
        this.mBackStyle = r3.getInt(R.styleable.ListContentItem_backgroundStyle, -1);
        r3.recycle();
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        TextView r0 = getTitleView();
        if (r0 == null) goto L5;
        r0.setTextColor(getResources().getColor(R.color.qs_item_text_color));
    L5:
        TextView r1 = getSummaryView();
        if (r1 == null) goto L8;
        r1.setTextColor(getResources().getColor(R.color.qs_item_summay_text_color));
    L8:
        Log.d(TAG, "onFinishInflate mBackStyle:" + this.mBackStyle);
        int r2 = this.mBackStyle;
        if (r2 != 1) goto L11;
        int r3 = R.drawable.group_list_item_bg_dark_single;
    L21:
        if (r3 == 0) goto L24;
        setBackgroundResource(r3);
        return;
    L24:
        return;
    L11:
        if (r2 != 2) goto L13;
        r3 = R.drawable.group_list_item_bg_dark_top;
        goto L21
    L13:
        if (r2 != 3) goto L15;
        r3 = R.drawable.group_list_item_bg_dark_mid;
        goto L21
    L15:
        if (r2 == 4) goto L17;
        r3 = 0;
        goto L21
    L17:
        r3 = R.drawable.group_list_item_bg_dark_bottom;
        goto L21
    }

    @Override // android.view.View
    public void setBackgroundResource(int resid) {
        if (resid != R.drawable.group_list_item_bg_top) goto L6;
        resid = R.drawable.group_list_item_bg_dark_top;
    L14:
        super.setBackgroundResource(resid);
        return;
    L6:
        if (resid != R.drawable.group_list_item_bg_bottom) goto L9;
        resid = R.drawable.group_list_item_bg_dark_bottom;
        goto L14
    L9:
        if (resid != R.drawable.group_list_item_bg_mid) goto L12;
        resid = R.drawable.group_list_item_bg_dark_mid;
        goto L14
    L12:
        if (resid != R.drawable.group_list_item_bg_single) goto L14;
        resid = R.drawable.group_list_item_bg_dark_single;
        goto L14
    }
}
