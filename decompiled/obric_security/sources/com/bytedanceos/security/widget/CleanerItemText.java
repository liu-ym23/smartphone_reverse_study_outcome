package com.bytedanceos.security.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.obric.security.R;

/* JADX INFO: loaded from: classes2.dex */
public class CleanerItemText extends SecurityItemText {
    @Override // com.bytedanceos.security.widget.SecurityItemText, obric.widget.ListContentItem
    protected int getDefaultLeftLayout() {
        return R.layout.cleaner_item_text_left_layout;
    }

    @Override // com.bytedanceos.security.widget.SecurityItemText, obric.widget.ListContentItem
    protected int getDefaultMidLayout() {
        return R.layout.cleaner_item_text_mid_layout;
    }

    @Override // com.bytedanceos.security.widget.SecurityItemText, obric.widget.ListContentItem
    protected int getDefaultRightLayout() {
        return R.layout.cleaner_item_text_right_layout;
    }

    public CleanerItemText(Context context) {
        this(context, null);
    }

    public CleanerItemText(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CleanerItemText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override // obric.widget.ListContentItem
    protected void initLeftWidget() {
        super.initLeftWidget();
    }
}
