package obric.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/* JADX INFO: loaded from: classes5.dex */
public class MarqueeView extends LinearLayout {
    private static final float MAX_FONT_SCALE_WITH_SUBTITLE = 1.1f;
    TextView mSubTitle;
    TextView mTitle;

    public MarqueeView(Context context) {
        this(context, null);
    }

    public MarqueeView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MarqueeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        setOrientation(1);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        View r4 = LayoutInflater.from(context).inflate(R.layout.marquee_title_center_layout, this, true);
        TextView r0 = (TextView) r4.findViewById(R.id.tv_title);
        this.mTitle = r0;
        r0.getPaint().setFlags(33);
        this.mSubTitle = (TextView) r4.findViewById(R.id.tv_sub_title);
        initTextSize();
    }

    private void initTextSize() {
        Resources r0 = getResources();
        Configuration r1 = r0.getConfiguration();
        float r2 = (r0.getDimensionPixelSize(R.dimen.title_bar_title_text_size) / r1.fontScale) * MAX_FONT_SCALE_WITH_SUBTITLE;
        TextView r4 = this.mTitle;
        r4.setTextSize(0, Math.min(r4.getTextSize(), r2));
        float r3 = (r0.getDimensionPixelSize(R.dimen.item_sub_title_size) / r1.fontScale) * MAX_FONT_SCALE_WITH_SUBTITLE;
        TextView r6 = this.mSubTitle;
        r6.setTextSize(0, Math.min(r6.getTextSize(), r3));
    }

    public void setTitle(String title) {
        this.mTitle.setText(title);
        checkSubContext();
    }

    public void setSubTitle(CharSequence subTitle) {
        if (subTitle == null) goto L4;
        setSubTitle(subTitle.toString());
        return;
    L4:
        setSubTitle(null);
    }

    public void setSubTitle(String subTitle) {
        this.mSubTitle.setText(subTitle);
        checkSubContext();
    }

    private void checkSubContext() {
        TextView r1 = this.mSubTitle;
        if (TextUtils.isEmpty(r1.getText().toString()) == false) goto L5;
        int r0 = 8;
    L6:
        r1.setVisibility(r0);
        return;
    L5:
        r0 = 0;
        goto L6
    }

    public void setTitleColor(int colorValue) {
        this.mTitle.setTextColor(colorValue);
    }

    public void setSubTitleColor(int colorValue) {
        this.mSubTitle.setTextColor(colorValue);
    }

    public void setTitleSize(float size) {
        this.mTitle.setTextSize(0, size);
    }

    public void setSubTitleSize(float size) {
        this.mSubTitle.setTextSize(0, size);
    }
}
