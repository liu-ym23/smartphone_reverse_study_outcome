package com.bytedanceos.security.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import com.obric.oui.button.OButton;
import com.obric.oui.lisitem.OListItemGeneral;
import com.obric.oui.oswitch.OSwitch;
import com.obric.security.R;

/* JADX INFO: loaded from: classes2.dex */
public class SecurityItemText2 extends OListItemGeneral {
    public static final int RIGHT_LAYOUT_MODE_BUTTON = 2;
    public static final int RIGHT_LAYOUT_MODE_CHECKBOX = 3;
    public static final int RIGHT_LAYOUT_MODE_TEXT_WITH_ARROW = 1;
    private CompoundButton.OnCheckedChangeListener mOnCheckedChangeListener;
    private OButton mTrailingButton;
    private ImageView mTrailingImage;
    private OSwitch mTrailingSwitch;

    public void setBtnBackgroudResource(int resid) {
    }

    public void setBtnTextColor(int color) {
    }

    public void setSummaryTextColor(int color) {
    }

    public void setTitleTextColor(int color) {
    }

    static /* synthetic */ CompoundButton.OnCheckedChangeListener access$000(SecurityItemText2 r0) {
        return r0.mOnCheckedChangeListener;
    }

    public SecurityItemText2(Context context) {
        this(context, null);
    }

    public SecurityItemText2(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SecurityItemText2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs);
        initRightWidget(context);
        setRightLayout(2);
        OSwitch r1 = this.mTrailingSwitch;
        if (r1 == null) goto L6;
        r1.setOnCheckedChangeListener(new AnonymousClass1(this));
        return;
    }

    public void setSummary(String string) {
        setSubTitleString(string);
    }

    public void setRightLayout(int layoutMode) {
        if (layoutMode != 1) goto L6;
        setTrailingView(this.mTrailingImage);
        return;
    L6:
        if (layoutMode != 2) goto L9;
        setTrailingView(this.mTrailingButton);
        return;
    L9:
        if (layoutMode != 3) goto L14;
        setTrailingView(this.mTrailingSwitch);
        return;
    }

    public void setBtnClickListener(View.OnClickListener listener) {
        OButton r0 = this.mTrailingButton;
        if (r0 == null) goto L6;
        r0.setOnClickListener(listener);
        return;
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener listener) {
        this.mOnCheckedChangeListener = listener;
    }

    public void setChecked(boolean isChecked) {
        OSwitch r0 = this.mTrailingSwitch;
        if (r0 != null) goto L5;
        return;
    L5:
        CompoundButton.OnCheckedChangeListener r1 = this.mOnCheckedChangeListener;
        this.mOnCheckedChangeListener = null;
        r0.setChecked(isChecked);
        this.mOnCheckedChangeListener = r1;
    }

    public void setBtnText(String message) {
        OButton r0 = this.mTrailingButton;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setText(message);
    }

    @Override // com.obric.oui.lisitem.OListItemGeneral
    public int getContentDefaultOneChildWidth() {
        return (int) getResources().getDimension(R.dimen.oui_listitem_content_width_large);
    }

    protected void initRightWidget(Context context) {
        this.mTrailingButton = (OButton) LayoutInflater.from(context).inflate(R.layout.o_security_item_text_trailing_button, this, false);
        ImageView r0 = new ImageView(context);
        this.mTrailingImage = r0;
        r0.setImageResource(R.drawable.ic_arrow_forward);
        OSwitch r1 = new OSwitch(context);
        this.mTrailingSwitch = r1;
        r1.setClickable(true);
    }
}
