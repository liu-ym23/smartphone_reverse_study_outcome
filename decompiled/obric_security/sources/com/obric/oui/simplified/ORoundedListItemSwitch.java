package com.obric.oui.simplified;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.obric.oui.oswitch.OSwitch;
import com.obric.security.R;

/* JADX INFO: loaded from: classes3.dex */
public class ORoundedListItemSwitch extends RelativeLayout {
    private ImageView badgeView;
    private ImageView iconView;
    private OSwitch mOSwitch;
    private CompoundButton.OnCheckedChangeListener mOnCheckedChangeListener;
    private TextView titleView;

    static /* synthetic */ CompoundButton.OnCheckedChangeListener access$000(ORoundedListItemSwitch r0) {
        return r0.mOnCheckedChangeListener;
    }

    public ORoundedListItemSwitch(Context context) {
        super(context);
        init(context);
    }

    public ORoundedListItemSwitch(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        inflate(context, R.layout.o_rounded_list_item_switch, this);
        this.iconView = (ImageView) findViewById(R.id.iv_content_img);
        this.badgeView = (ImageView) findViewById(R.id.iv_doppleganger_icon);
        this.titleView = (TextView) findViewById(R.id.tv_content_title);
        OSwitch r2 = (OSwitch) findViewById(R.id.trailing_switch);
        this.mOSwitch = r2;
        r2.setClickable(true);
        this.mOSwitch.setOnCheckedChangeListener(new AnonymousClass1(this));
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener listener) {
        this.mOnCheckedChangeListener = listener;
    }

    public void setChecked(boolean checked) {
        this.mOSwitch.setChecked(checked);
    }

    public boolean isChecked() {
        return this.mOSwitch.isChecked();
    }

    public void setContentImage(Drawable drawable) {
        this.iconView.setImageDrawable(drawable);
    }

    public void setTitleString(CharSequence cs) {
        this.titleView.setText(cs);
    }

    public OSwitch getSwitch() {
        return this.mOSwitch;
    }

    public void setDoppleganger(boolean isDoppleganger) {
        if (isDoppleganger == false) goto L4;
        this.badgeView.setImageResource(R.drawable.oic_doppleganger_badge);
        return;
    L4:
        this.badgeView.setImageResource(R.color.transparent);
    }
}
