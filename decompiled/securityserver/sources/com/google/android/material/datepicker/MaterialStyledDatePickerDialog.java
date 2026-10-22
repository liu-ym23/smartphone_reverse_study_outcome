package com.google.android.material.datepicker;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import com.google.android.material.R;
import com.google.android.material.dialog.InsetDialogOnTouchListener;
import com.google.android.material.dialog.MaterialDialogs;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.shape.MaterialShapeDrawable;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP, RestrictTo.Scope.TESTS})
public class MaterialStyledDatePickerDialog extends DatePickerDialog {

    @AttrRes
    private static final int DEF_STYLE_ATTR = 16843612;

    @StyleRes
    private static final int DEF_STYLE_RES = 0;

    @NonNull
    private final Drawable background;

    @NonNull
    private final Rect backgroundInsets;

    static {
        DEF_STYLE_RES = R.style.MaterialAlertDialog_MaterialComponents_Picker_Date_Spinner;
    }

    public MaterialStyledDatePickerDialog(@NonNull Context r2) {
        this(r2, 0);
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle r3) {
        super.onCreate(r3);
        getWindow().setBackgroundDrawable(this.background);
        getWindow().getDecorView().setOnTouchListener(new InsetDialogOnTouchListener(this, this.backgroundInsets));
    }

    public MaterialStyledDatePickerDialog(@NonNull Context r8, int r9) {
        this(r8, r9, null, -1, -1, -1);
    }

    public MaterialStyledDatePickerDialog(@NonNull Context r8, @Nullable DatePickerDialog.OnDateSetListener r9, int r10, int r11, int r12) {
        this(r8, 0, r9, r10, r11, r12);
    }

    public MaterialStyledDatePickerDialog(@NonNull Context r1, int r2, @Nullable DatePickerDialog.OnDateSetListener r3, int r4, int r5, int r6) {
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
}
