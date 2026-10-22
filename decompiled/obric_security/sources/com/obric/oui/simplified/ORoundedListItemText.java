package com.obric.oui.simplified;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.obric.security.R;

/* JADX INFO: loaded from: classes3.dex */
public class ORoundedListItemText extends RelativeLayout {
    private ImageView badgeView;
    private ImageView iconView;
    private FrameLayout leadingElement;
    private TextView titleView;
    private ImageView trailingIconView;
    private TextView trailingTextView;

    public ORoundedListItemText(Context context) {
        super(context);
        init(context);
    }

    public ORoundedListItemText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        inflate(context, R.layout.o_rounded_list_item_text, this);
        this.leadingElement = (FrameLayout) findViewById(R.id.fl_leading_element);
        this.iconView = (ImageView) findViewById(R.id.iv_content_img);
        this.badgeView = (ImageView) findViewById(R.id.iv_doppleganger_icon);
        this.titleView = (TextView) findViewById(R.id.tv_content_title);
        this.trailingTextView = (TextView) findViewById(R.id.tv_content_trailing_text);
        this.trailingIconView = (ImageView) findViewById(R.id.iv_content_trailing_icon);
    }

    public void setContentImage(Drawable drawable) {
        this.iconView.setImageDrawable(drawable);
    }

    public void setTitleString(CharSequence cs) {
        this.titleView.setText(cs);
    }

    public void setTrailingText(CharSequence cs) {
        this.trailingTextView.setText(cs);
    }

    public ViewGroup getMLeadingElement() {
        return this.leadingElement;
    }

    public void setTrailingImage(Drawable drawable) {
        this.trailingIconView.setImageDrawable(drawable);
    }

    public View getTrailingIconView() {
        return this.trailingIconView;
    }

    public void setDoppleganger(boolean isDoppleganger) {
        if (isDoppleganger == false) goto L4;
        this.badgeView.setImageResource(R.drawable.oic_doppleganger_badge);
        return;
    L4:
        this.badgeView.setImageResource(R.color.transparent);
    }
}
