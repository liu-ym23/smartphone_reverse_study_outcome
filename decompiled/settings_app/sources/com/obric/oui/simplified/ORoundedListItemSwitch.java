package com.obric.oui.simplified;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.settings.R;
import com.obric.oui.oswitch.OSwitch;

/* JADX INFO: loaded from: classes5.dex */
public class ORoundedListItemSwitch extends RelativeLayout {
    private View iconContainer;
    private ImageView iconView;
    private OSwitch mOSwitch;
    private CompoundButton.OnCheckedChangeListener mOnCheckedChangeListener;
    private TextView titleView;

    static /* synthetic */ CompoundButton.OnCheckedChangeListener access$000(ORoundedListItemSwitch r0) {
        return r0.mOnCheckedChangeListener;
    }

    public ORoundedListItemSwitch(Context r1) {
        super(r1);
        init(r1);
    }

    public ORoundedListItemSwitch(Context r1, AttributeSet r2) {
        super(r1, r2);
        init(r1);
    }

    private void init(Context r2) {
        inflate(r2, R.layout.o_rounded_list_item_switch, this);
        this.iconContainer = findViewById(R.id.icon_container);
        this.iconView = (ImageView) findViewById(R.id.iv_content_img);
        this.titleView = (TextView) findViewById(R.id.tv_content_title);
        OSwitch r3 = (OSwitch) findViewById(R.id.trailing_switch);
        this.mOSwitch = r3;
        r3.setClickable(true);
        this.mOSwitch.setOnCheckedChangeListener(new AnonymousClass1(this));
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener r1) {
        this.mOnCheckedChangeListener = r1;
    }

    public void setChecked(boolean r1) {
        this.mOSwitch.setChecked(r1);
    }

    public boolean isChecked() {
        return this.mOSwitch.isChecked();
    }

    public void setContentImage(Drawable r1) {
        this.iconView.setImageDrawable(r1);
    }

    public void setTitleString(CharSequence r1) {
        this.titleView.setText(r1);
    }

    public OSwitch getSwitch() {
        return this.mOSwitch;
    }

    public void setIconVisibility(int r1) {
        View r0 = this.iconContainer;
        if (r0 == null) goto L6;
        r0.setVisibility(r1);
        return;
    }
}
