package com.obric.oui.checkbox;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: classes4.dex */
public class OCheckBoxSecurity extends OCheckBox {
    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener r1) {
    }

    public OCheckBoxSecurity(Context r1) {
        super(r1);
        setClickable(false);
    }

    public OCheckBoxSecurity(Context r1, AttributeSet r2) {
        super(r1, r2);
        setClickable(false);
    }

    public OCheckBoxSecurity(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        setClickable(false);
    }
}
