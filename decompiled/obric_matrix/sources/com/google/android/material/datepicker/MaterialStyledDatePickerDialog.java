package com.google.android.material.datepicker;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
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

/* JADX INFO: loaded from: classes2.dex */
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

    public MaterialStyledDatePickerDialog(@NonNull Context r8, int r9) {
        this(r8, r9, null, -1, -1, -1);
    }

    public MaterialStyledDatePickerDialog(@NonNull Context r2, int r3, @Nullable DatePickerDialog.OnDateSetListener r4, int r5, int r6, int r7) {
        super(r2, r3, r4, r5, r6, r7);
        Context r8 = getContext();
        int r9 = MaterialAttributes.resolveOrThrow(getContext(), R.attr.colorSurface, getClass().getCanonicalName());
        int r10 = DEF_STYLE_RES;
        MaterialShapeDrawable r11 = new MaterialShapeDrawable(r8, null, 16843612, r10);
        if (Build.VERSION.SDK_INT >= 21) goto L6;
        r9 = 0;
    L6:
        r11.setFillColor(ColorStateList.valueOf(r9));
        Rect r12 = MaterialDialogs.getDialogBackgroundInsets(r8, 16843612, r10);
        this.backgroundInsets = r12;
        this.background = MaterialDialogs.insetDrawable(r11, r12);
    }

    public MaterialStyledDatePickerDialog(@NonNull Context r8, @Nullable DatePickerDialog.OnDateSetListener r9, int r10, int r11, int r12) {
        this(r8, 0, r9, r10, r11, r12);
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle r3) {
        super.onCreate(r3);
        getWindow().setBackgroundDrawable(this.background);
        getWindow().getDecorView().setOnTouchListener(new InsetDialogOnTouchListener(this, this.backgroundInsets));
    }
}
