package com.android.settings.utils;

import android.content.Context;
import android.content.DialogInterface;
import com.obric.oui.button.OButton;
import com.obric.oui.dialog.v2.alert.style.ButtonStyleController;
import com.obric.oui.dialog.v2.alert.style.DefaultButtonStyleController;

/* JADX INFO: loaded from: classes2.dex */
public class ColorButtonStyleController extends DefaultButtonStyleController {
    private int nBackgroundColor;
    private int nTextColor;
    private int pBackgroundColor;
    private int pTextColor;

    public ColorButtonStyleController(Context r1, int r2) {
        super(r1, r2);
        this.pBackgroundColor = -1;
        this.pTextColor = -1;
        this.nBackgroundColor = -1;
        this.nTextColor = -1;
    }

    public ColorButtonStyleController positiveColor(int r1, int r2) {
        this.pBackgroundColor = r2;
        this.pTextColor = r1;
        return this;
    }

    public ColorButtonStyleController negativeColor(int r1, int r2) {
        this.nBackgroundColor = r2;
        this.nTextColor = r1;
        return this;
    }

    @Override // com.obric.oui.dialog.v2.alert.style.DefaultButtonStyleController, com.obric.oui.dialog.v2.alert.style.ButtonStyleController
    public void setNegativeButton(CharSequence r1, DialogInterface.OnClickListener r2, ButtonStyleController.TextColorType r3) {
        super.setNegativeButton(r1, r2, r3);
        OButton r4 = getNegativeButton();
        if (r4 == null) goto L11;
        int r5 = this.nBackgroundColor;
        if (r5 == (-1)) goto L8;
        r4.setBackgroundResource(r5);
    L8:
        if (this.nTextColor == (-1)) goto L12;
        r4.setTextColor(r4.getContext().getColor(this.nTextColor));
        return;
    L12:
        return;
    }

    @Override // com.obric.oui.dialog.v2.alert.style.DefaultButtonStyleController, com.obric.oui.dialog.v2.alert.style.ButtonStyleController
    public void setPositiveButton(CharSequence r1, DialogInterface.OnClickListener r2, ButtonStyleController.TextColorType r3, boolean r4) {
        super.setPositiveButton(r1, r2, r3, r4);
        OButton r5 = getPositiveButton();
        if (r5 == null) goto L11;
        int r6 = this.pBackgroundColor;
        if (r6 == (-1)) goto L8;
        r5.setBackgroundResource(r6);
    L8:
        if (this.pTextColor == (-1)) goto L12;
        r5.setTextColor(r5.getContext().getColor(this.pTextColor));
        return;
    L12:
        return;
    }
}
