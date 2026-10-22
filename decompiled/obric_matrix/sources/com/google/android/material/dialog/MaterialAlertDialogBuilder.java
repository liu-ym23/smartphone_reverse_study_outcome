package com.google.android.material.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import androidx.annotation.ArrayRes;
import androidx.annotation.AttrRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

/* JADX INFO: loaded from: classes2.dex */
public class MaterialAlertDialogBuilder extends AlertDialog.Builder {

    @AttrRes
    private static final int DEF_STYLE_ATTR = 0;

    @StyleRes
    private static final int DEF_STYLE_RES = 0;

    @AttrRes
    private static final int MATERIAL_ALERT_DIALOG_THEME_OVERLAY = 0;

    @Nullable
    private Drawable background;

    @NonNull
    @Dimension
    private final Rect backgroundInsets;

    static {
        DEF_STYLE_ATTR = R.attr.alertDialogStyle;
        DEF_STYLE_RES = R.style.MaterialAlertDialog_MaterialComponents;
        MATERIAL_ALERT_DIALOG_THEME_OVERLAY = R.attr.materialAlertDialogTheme;
    }

    public MaterialAlertDialogBuilder(@NonNull Context r2) {
        this(r2, 0);
    }

    public MaterialAlertDialogBuilder(@NonNull Context r6, int r7) {
        super(createMaterialAlertDialogThemedContext(r6), getOverridingThemeResId(r6, r7));
        Context r8 = getContext();
        Resources.Theme r9 = r8.getTheme();
        int r0 = DEF_STYLE_ATTR;
        int r1 = DEF_STYLE_RES;
        this.backgroundInsets = MaterialDialogs.getDialogBackgroundInsets(r8, r0, r1);
        int r2 = MaterialColors.getColor(r8, R.attr.colorSurface, getClass().getCanonicalName());
        MaterialShapeDrawable r3 = new MaterialShapeDrawable(r8, null, r0, r1);
        r3.initializeElevationOverlay(r8);
        r3.setFillColor(ColorStateList.valueOf(r2));
        if (Build.VERSION.SDK_INT < 28) goto L9;
        TypedValue r10 = new TypedValue();
        r9.resolveAttribute(android.R.attr.dialogCornerRadius, r10, true);
        float r11 = r10.getDimension(getContext().getResources().getDisplayMetrics());
        if (r10.type != 5) goto L9;
        if (r11 < 0.0f) goto L9;
        r3.setCornerSize(r11);
    L9:
        this.background = r3;
    }

    private static Context createMaterialAlertDialogThemedContext(@NonNull Context r4) {
        int r0 = getMaterialAlertDialogThemeOverlay(r4);
        Context r5 = MaterialThemeOverlay.wrap(r4, null, DEF_STYLE_ATTR, DEF_STYLE_RES);
        if (r0 != 0) goto L6;
        return r5;
    L6:
        return new ContextThemeWrapper(r5, r0);
    }

    private static int getMaterialAlertDialogThemeOverlay(@NonNull Context r1) {
        TypedValue r2 = MaterialAttributes.resolve(r1, MATERIAL_ALERT_DIALOG_THEME_OVERLAY);
        if (r2 != null) goto L7;
        return 0;
    L7:
        return r2.data;
    }

    private static int getOverridingThemeResId(@NonNull Context r0, int r1) {
        if (r1 == 0) goto L4;
        return r1;
    L4:
        return getMaterialAlertDialogThemeOverlay(r0);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public AlertDialog create() {
        AlertDialog r0 = super.create();
        Window r1 = r0.getWindow();
        View r2 = r1.getDecorView();
        Drawable r3 = this.background;
        if ((r3 instanceof MaterialShapeDrawable) == false) goto L5;
        ((MaterialShapeDrawable) r3).setElevation(ViewCompat.getElevation(r2));
    L5:
        r1.setBackgroundDrawable(MaterialDialogs.insetDrawable(this.background, this.backgroundInsets));
        r2.setOnTouchListener(new InsetDialogOnTouchListener(r0, this.backgroundInsets));
        return r0;
    }

    @Nullable
    public Drawable getBackground() {
        return this.background;
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog.Builder setAdapter(@Nullable ListAdapter r1, @Nullable DialogInterface.OnClickListener r2) {
        return setAdapter(r1, r2);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setAdapter(@Nullable ListAdapter r1, @Nullable DialogInterface.OnClickListener r2) {
        return (MaterialAlertDialogBuilder) super.setAdapter(r1, r2);
    }

    @NonNull
    public MaterialAlertDialogBuilder setBackground(@Nullable Drawable r1) {
        this.background = r1;
        return this;
    }

    @NonNull
    public MaterialAlertDialogBuilder setBackgroundInsetBottom(@Px int r2) {
        this.backgroundInsets.bottom = r2;
        return this;
    }

    @NonNull
    public MaterialAlertDialogBuilder setBackgroundInsetEnd(@Px int r3) {
        if (Build.VERSION.SDK_INT >= 17) goto L5;
    L7:
        this.backgroundInsets.right = r3;
    L8:
        return this;
    L5:
        if (getContext().getResources().getConfiguration().getLayoutDirection() != 1) goto L7;
        this.backgroundInsets.left = r3;
        goto L8
    }

    @NonNull
    public MaterialAlertDialogBuilder setBackgroundInsetStart(@Px int r3) {
        if (Build.VERSION.SDK_INT >= 17) goto L5;
    L7:
        this.backgroundInsets.left = r3;
    L8:
        return this;
    L5:
        if (getContext().getResources().getConfiguration().getLayoutDirection() != 1) goto L7;
        this.backgroundInsets.right = r3;
        goto L8
    }

    @NonNull
    public MaterialAlertDialogBuilder setBackgroundInsetTop(@Px int r2) {
        this.backgroundInsets.top = r2;
        return this;
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog.Builder setCancelable(boolean r1) {
        return setCancelable(r1);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setCancelable(boolean r1) {
        return (MaterialAlertDialogBuilder) super.setCancelable(r1);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog.Builder setCursor(@Nullable Cursor r1, @Nullable DialogInterface.OnClickListener r2, @NonNull String r3) {
        return setCursor(r1, r2, r3);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setCursor(@Nullable Cursor r1, @Nullable DialogInterface.OnClickListener r2, @NonNull String r3) {
        return (MaterialAlertDialogBuilder) super.setCursor(r1, r2, r3);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog.Builder setCustomTitle(@Nullable View r1) {
        return setCustomTitle(r1);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setCustomTitle(@Nullable View r1) {
        return (MaterialAlertDialogBuilder) super.setCustomTitle(r1);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog.Builder setIcon(@DrawableRes int r1) {
        return setIcon(r1);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog.Builder setIcon(@Nullable Drawable r1) {
        return setIcon(r1);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setIcon(@DrawableRes int r1) {
        return (MaterialAlertDialogBuilder) super.setIcon(r1);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setIcon(@Nullable Drawable r1) {
        return (MaterialAlertDialogBuilder) super.setIcon(r1);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog.Builder setIconAttribute(@AttrRes int r1) {
        return setIconAttribute(r1);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setIconAttribute(@AttrRes int r1) {
        return (MaterialAlertDialogBuilder) super.setIconAttribute(r1);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog.Builder setItems(@ArrayRes int r1, @Nullable DialogInterface.OnClickListener r2) {
        return setItems(r1, r2);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog.Builder setItems(@Nullable CharSequence[] r1, @Nullable DialogInterface.OnClickListener r2) {
        return setItems(r1, r2);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setItems(@ArrayRes int r1, @Nullable DialogInterface.OnClickListener r2) {
        return (MaterialAlertDialogBuilder) super.setItems(r1, r2);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setItems(@Nullable CharSequence[] r1, @Nullable DialogInterface.OnClickListener r2) {
        return (MaterialAlertDialogBuilder) super.setItems(r1, r2);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog.Builder setMessage(@StringRes int r1) {
        return setMessage(r1);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog.Builder setMessage(@Nullable CharSequence r1) {
        return setMessage(r1);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setMessage(@StringRes int r1) {
        return (MaterialAlertDialogBuilder) super.setMessage(r1);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setMessage(@Nullable CharSequence r1) {
        return (MaterialAlertDialogBuilder) super.setMessage(r1);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog.Builder setMultiChoiceItems(@ArrayRes int r1, @Nullable boolean[] r2, @Nullable DialogInterface.OnMultiChoiceClickListener r3) {
        return setMultiChoiceItems(r1, r2, r3);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog.Builder setMultiChoiceItems(@Nullable Cursor r1, @NonNull String r2, @NonNull String r3, @Nullable DialogInterface.OnMultiChoiceClickListener r4) {
        return setMultiChoiceItems(r1, r2, r3, r4);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog.Builder setMultiChoiceItems(@Nullable CharSequence[] r1, @Nullable boolean[] r2, @Nullable DialogInterface.OnMultiChoiceClickListener r3) {
        return setMultiChoiceItems(r1, r2, r3);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setMultiChoiceItems(@ArrayRes int r1, @Nullable boolean[] r2, @Nullable DialogInterface.OnMultiChoiceClickListener r3) {
        return (MaterialAlertDialogBuilder) super.setMultiChoiceItems(r1, r2, r3);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setMultiChoiceItems(@Nullable Cursor r1, @NonNull String r2, @NonNull String r3, @Nullable DialogInterface.OnMultiChoiceClickListener r4) {
        return (MaterialAlertDialogBuilder) super.setMultiChoiceItems(r1, r2, r3, r4);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setMultiChoiceItems(@Nullable CharSequence[] r1, @Nullable boolean[] r2, @Nullable DialogInterface.OnMultiChoiceClickListener r3) {
        return (MaterialAlertDialogBuilder) super.setMultiChoiceItems(r1, r2, r3);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog.Builder setNegativeButton(@StringRes int r1, @Nullable DialogInterface.OnClickListener r2) {
        return setNegativeButton(r1, r2);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog.Builder setNegativeButton(@Nullable CharSequence r1, @Nullable DialogInterface.OnClickListener r2) {
        return setNegativeButton(r1, r2);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setNegativeButton(@StringRes int r1, @Nullable DialogInterface.OnClickListener r2) {
        return (MaterialAlertDialogBuilder) super.setNegativeButton(r1, r2);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setNegativeButton(@Nullable CharSequence r1, @Nullable DialogInterface.OnClickListener r2) {
        return (MaterialAlertDialogBuilder) super.setNegativeButton(r1, r2);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog.Builder setNegativeButtonIcon(@Nullable Drawable r1) {
        return setNegativeButtonIcon(r1);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setNegativeButtonIcon(@Nullable Drawable r1) {
        return (MaterialAlertDialogBuilder) super.setNegativeButtonIcon(r1);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog.Builder setNeutralButton(@StringRes int r1, @Nullable DialogInterface.OnClickListener r2) {
        return setNeutralButton(r1, r2);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog.Builder setNeutralButton(@Nullable CharSequence r1, @Nullable DialogInterface.OnClickListener r2) {
        return setNeutralButton(r1, r2);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setNeutralButton(@StringRes int r1, @Nullable DialogInterface.OnClickListener r2) {
        return (MaterialAlertDialogBuilder) super.setNeutralButton(r1, r2);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setNeutralButton(@Nullable CharSequence r1, @Nullable DialogInterface.OnClickListener r2) {
        return (MaterialAlertDialogBuilder) super.setNeutralButton(r1, r2);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog.Builder setNeutralButtonIcon(@Nullable Drawable r1) {
        return setNeutralButtonIcon(r1);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setNeutralButtonIcon(@Nullable Drawable r1) {
        return (MaterialAlertDialogBuilder) super.setNeutralButtonIcon(r1);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog.Builder setOnCancelListener(@Nullable DialogInterface.OnCancelListener r1) {
        return setOnCancelListener(r1);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setOnCancelListener(@Nullable DialogInterface.OnCancelListener r1) {
        return (MaterialAlertDialogBuilder) super.setOnCancelListener(r1);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog.Builder setOnDismissListener(@Nullable DialogInterface.OnDismissListener r1) {
        return setOnDismissListener(r1);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setOnDismissListener(@Nullable DialogInterface.OnDismissListener r1) {
        return (MaterialAlertDialogBuilder) super.setOnDismissListener(r1);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog.Builder setOnItemSelectedListener(@Nullable AdapterView.OnItemSelectedListener r1) {
        return setOnItemSelectedListener(r1);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setOnItemSelectedListener(@Nullable AdapterView.OnItemSelectedListener r1) {
        return (MaterialAlertDialogBuilder) super.setOnItemSelectedListener(r1);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog.Builder setOnKeyListener(@Nullable DialogInterface.OnKeyListener r1) {
        return setOnKeyListener(r1);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setOnKeyListener(@Nullable DialogInterface.OnKeyListener r1) {
        return (MaterialAlertDialogBuilder) super.setOnKeyListener(r1);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog.Builder setPositiveButton(@StringRes int r1, @Nullable DialogInterface.OnClickListener r2) {
        return setPositiveButton(r1, r2);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog.Builder setPositiveButton(@Nullable CharSequence r1, @Nullable DialogInterface.OnClickListener r2) {
        return setPositiveButton(r1, r2);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setPositiveButton(@StringRes int r1, @Nullable DialogInterface.OnClickListener r2) {
        return (MaterialAlertDialogBuilder) super.setPositiveButton(r1, r2);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setPositiveButton(@Nullable CharSequence r1, @Nullable DialogInterface.OnClickListener r2) {
        return (MaterialAlertDialogBuilder) super.setPositiveButton(r1, r2);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog.Builder setPositiveButtonIcon(@Nullable Drawable r1) {
        return setPositiveButtonIcon(r1);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setPositiveButtonIcon(@Nullable Drawable r1) {
        return (MaterialAlertDialogBuilder) super.setPositiveButtonIcon(r1);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog.Builder setSingleChoiceItems(@ArrayRes int r1, int r2, @Nullable DialogInterface.OnClickListener r3) {
        return setSingleChoiceItems(r1, r2, r3);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog.Builder setSingleChoiceItems(@Nullable Cursor r1, int r2, @NonNull String r3, @Nullable DialogInterface.OnClickListener r4) {
        return setSingleChoiceItems(r1, r2, r3, r4);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog.Builder setSingleChoiceItems(@Nullable ListAdapter r1, int r2, @Nullable DialogInterface.OnClickListener r3) {
        return setSingleChoiceItems(r1, r2, r3);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog.Builder setSingleChoiceItems(@Nullable CharSequence[] r1, int r2, @Nullable DialogInterface.OnClickListener r3) {
        return setSingleChoiceItems(r1, r2, r3);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setSingleChoiceItems(@ArrayRes int r1, int r2, @Nullable DialogInterface.OnClickListener r3) {
        return (MaterialAlertDialogBuilder) super.setSingleChoiceItems(r1, r2, r3);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setSingleChoiceItems(@Nullable Cursor r1, int r2, @NonNull String r3, @Nullable DialogInterface.OnClickListener r4) {
        return (MaterialAlertDialogBuilder) super.setSingleChoiceItems(r1, r2, r3, r4);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setSingleChoiceItems(@Nullable ListAdapter r1, int r2, @Nullable DialogInterface.OnClickListener r3) {
        return (MaterialAlertDialogBuilder) super.setSingleChoiceItems(r1, r2, r3);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setSingleChoiceItems(@Nullable CharSequence[] r1, int r2, @Nullable DialogInterface.OnClickListener r3) {
        return (MaterialAlertDialogBuilder) super.setSingleChoiceItems(r1, r2, r3);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog.Builder setTitle(@StringRes int r1) {
        return setTitle(r1);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog.Builder setTitle(@Nullable CharSequence r1) {
        return setTitle(r1);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setTitle(@StringRes int r1) {
        return (MaterialAlertDialogBuilder) super.setTitle(r1);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setTitle(@Nullable CharSequence r1) {
        return (MaterialAlertDialogBuilder) super.setTitle(r1);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog.Builder setView(int r1) {
        return setView(r1);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog.Builder setView(@Nullable View r1) {
        return setView(r1);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setView(int r1) {
        return (MaterialAlertDialogBuilder) super.setView(r1);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setView(@Nullable View r1) {
        return (MaterialAlertDialogBuilder) super.setView(r1);
    }
}
