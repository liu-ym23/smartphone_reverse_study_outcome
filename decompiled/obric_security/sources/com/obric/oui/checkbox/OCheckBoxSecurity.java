package com.obric.oui.checkbox;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public class OCheckBoxSecurity extends OCheckBox {
    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener l) {
    }

    public OCheckBoxSecurity(Context context) {
        super(context);
        setClickable(false);
    }

    public OCheckBoxSecurity(Context context, AttributeSet attrs) {
        super(context, attrs);
        setClickable(false);
    }

    public OCheckBoxSecurity(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setClickable(false);
    }
}
