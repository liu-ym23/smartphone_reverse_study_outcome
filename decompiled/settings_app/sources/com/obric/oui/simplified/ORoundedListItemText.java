package com.obric.oui.simplified;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.settings.R;

/* JADX INFO: loaded from: classes5.dex */
public class ORoundedListItemText extends RelativeLayout {
    private ImageView iconView;
    private TextView titleView;
    private TextView trailingText;

    public ORoundedListItemText(Context r1) {
        super(r1);
        init(r1);
    }

    public ORoundedListItemText(Context r1, AttributeSet r2) {
        super(r1, r2);
        init(r1);
    }

    private void init(Context r2) {
        inflate(r2, R.layout.o_rounded_list_item_text, this);
        this.iconView = (ImageView) findViewById(R.id.iv_content_img);
        this.titleView = (TextView) findViewById(R.id.tv_content_title);
        this.trailingText = (TextView) findViewById(R.id.trailing_text);
    }

    public void setContentImage(Drawable r1) {
        this.iconView.setImageDrawable(r1);
    }

    public void setTitleString(CharSequence r1) {
        this.titleView.setText(r1);
    }

    public void setTrailingText(CharSequence r1) {
        this.trailingText.setText(r1);
    }
}
