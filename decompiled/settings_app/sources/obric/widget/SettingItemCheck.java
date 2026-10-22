package obric.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;

/* JADX INFO: loaded from: classes5.dex */
public class SettingItemCheck extends ListContentItemCheck {
    public SettingItemCheck(Context context) {
        this(context, null);
    }

    public SettingItemCheck(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SettingItemCheck(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        TypedArray r3 = context.obtainStyledAttributes(attrs, R.styleable.SettingItemCheck, defStyle, 0);
        CharSequence r4 = r3.getText(R.styleable.SettingItemCheck_itemTitle);
        if (TextUtils.isEmpty(r4) == true) goto L5;
        setTitle(r4);
    L5:
        r3.recycle();
    }

    public ImageView getIcon() {
        return getIconView();
    }

    public void setIconVisibility(int visibility) {
        if (visibility != 0) goto L4;
    L10:
        ImageView r1 = getIconView();
        if (r1 == null) goto L14;
        r1.setVisibility(visibility);
        return;
    L14:
        return;
    L4:
        if (visibility == 4) goto L10;
        if (visibility == 8) goto L10;
        throw new IllegalArgumentException("the params for setIconVisibility method is illegal!");
    }

    public void setSummaryMarqueeEnable(boolean enable) {
        if (this.mSummary != null) goto L5;
        return;
    L5:
        TextView r0 = this.mSummary;
        if (enable == false) goto L8;
        TextUtils.TruncateAt r1 = TextUtils.TruncateAt.MARQUEE;
    L9:
        r0.setEllipsize(r1);
        this.mSummary.setFocusable(enable);
        this.mSummary.setFocusableInTouchMode(enable);
        return;
    L8:
        r1 = TextUtils.TruncateAt.END;
        goto L9
    }

    @Override // obric.widget.ListContentItemCheck
    public void setCheckedIconLight(boolean light) {
        super.setCheckedIconLight(light);
    }
}
