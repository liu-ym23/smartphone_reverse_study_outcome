package com.obric.oui.simplified;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.settings.R;

/* JADX INFO: loaded from: classes5.dex */
public class OLocalListItemText extends RelativeLayout {
    private ImageView badgeView;
    private ImageView iconView;
    private TextView subTitleView;
    private TextView titleView;

    public OLocalListItemText(Context r1) {
        super(r1);
        init(r1);
    }

    public OLocalListItemText(Context r1, AttributeSet r2) {
        super(r1, r2);
        init(r1);
    }

    private void init(Context r2) {
        inflate(r2, R.layout.o_local_list_item_text, this);
        this.iconView = (ImageView) findViewById(R.id.iv_content_img);
        this.badgeView = (ImageView) findViewById(R.id.iv_doppleganger_icon);
        this.titleView = (TextView) findViewById(R.id.tv_content_title);
        this.subTitleView = (TextView) findViewById(R.id.tv_content_subtitle);
    }

    public void setContentImage(Drawable r1) {
        this.iconView.setImageDrawable(r1);
    }

    public void setBadgeImage(Drawable r1) {
        this.badgeView.setImageDrawable(r1);
    }

    public void setTitleString(CharSequence r1) {
        this.titleView.setText(r1);
    }

    public void setSubTitleString(CharSequence r3) {
        if (r3 != null) goto L4;
    L6:
        this.subTitleView.setVisibility(8);
    L7:
        this.subTitleView.setText(r3);
        return;
    L4:
        if (r3.length() <= 0) goto L6;
        this.subTitleView.setVisibility(0);
        goto L7
    }
}
