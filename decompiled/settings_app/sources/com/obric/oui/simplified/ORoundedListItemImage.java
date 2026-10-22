package com.obric.oui.simplified;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.settings.R;

/* JADX INFO: loaded from: classes5.dex */
public class ORoundedListItemImage extends RelativeLayout {
    private ImageView iconView;
    private TextView titleView;
    private ImageView trailingImage;

    public ORoundedListItemImage(Context r1) {
        super(r1);
        init(r1);
    }

    public ORoundedListItemImage(Context r1, AttributeSet r2) {
        super(r1, r2);
        init(r1);
    }

    private void init(Context r2) {
        inflate(r2, R.layout.o_rounded_list_item_image, this);
        this.iconView = (ImageView) findViewById(R.id.iv_content_img);
        this.titleView = (TextView) findViewById(R.id.tv_content_title);
        this.trailingImage = (ImageView) findViewById(R.id.trailing_image);
    }

    public void setContentImage(Drawable r1) {
        this.iconView.setImageDrawable(r1);
    }

    public void setTitleString(CharSequence r1) {
        this.titleView.setText(r1);
    }

    public void setTrailingImage(Drawable r1) {
        this.trailingImage.setImageDrawable(r1);
    }
}
