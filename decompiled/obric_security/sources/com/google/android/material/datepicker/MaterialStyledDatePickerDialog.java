package com.google.android.material.datepicker;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.google.android.material.R;
import com.google.android.material.dialog.InsetDialogOnTouchListener;
import com.google.android.material.dialog.MaterialDialogs;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.shape.MaterialShapeDrawable;

/* JADX INFO: loaded from: classes2.dex */
public class MaterialStyledDatePickerDialog extends DatePickerDialog {
    private static final int DEF_STYLE_ATTR = 16843612;
    private static final int DEF_STYLE_RES = 0;
    private final Drawable background;
    private final Rect backgroundInsets;

    static {
        DEF_STYLE_RES = R.style.MaterialAlertDialog_MaterialComponents_Picker_Date_Spinner;
    }

    public MaterialStyledDatePickerDialog(Context r2) {
        this(r2, 0);
    }

    public MaterialStyledDatePickerDialog(Context r8, int r9) {
        this(r8, r9, null, -1, -1, -1);
    }

    public MaterialStyledDatePickerDialog(Context r8, DatePickerDialog.OnDateSetListener r9, int r10, int r11, int r12) {
        this(r8, 0, r9, r10, r11, r12);
    }

    public MaterialStyledDatePickerDialog(Context r1, int r2, DatePickerDialog.OnDateSetListener r3, int r4, int r5, int r6) {
        super(r1, r2, r3, r4, r5, r6);
        Context r7 = getContext();
        int r8 = MaterialAttributes.resolveOrThrow(getContext(), R.attr.colorSurface, getClass().getCanonicalName());
        int r9 = DEF_STYLE_RES;
        MaterialShapeDrawable r10 = new MaterialShapeDrawable(r7, null, 16843612, r9);
        r10.setFillColor(ColorStateList.valueOf(r8));
        Rect r11 = MaterialDialogs.getDialogBackgroundInsets(r7, 16843612, r9);
        this.backgroundInsets = r11;
        this.background = MaterialDialogs.insetDrawable(r10, r11);
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle r3) {
        super.onCreate(r3);
        getWindow().setBackgroundDrawable(this.background);
        getWindow().getDecorView().setOnTouchListener(new InsetDialogOnTouchListener(this, this.backgroundInsets));
    }
}
