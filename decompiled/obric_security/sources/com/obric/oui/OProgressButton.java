package com.obric.oui;

import android.content.Context;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.obric.oui.button.OButton;
import com.obric.security.R;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OProgressButton.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\u0018\u00002\u00020\u0001B#\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u000f\u001a\u00020\u0010H\u0002J\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\fJ\u000e\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\fJ\b\u0010\u0014\u001a\u00020\u0010H\u0002J\u0016\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u001aR\u0012\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/obric/oui/OProgressButton;", "Lcom/obric/oui/button/OButton;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defaultBackgroundColor", "Ljava/lang/Integer;", "isInProgressMode", "", "noProcessColor", "processColor", "changeToProgressDrawable", "", "setProgressMode", "isProgressMode", "setUpdateProgressMode", "updateButtonMode", "updateInstallProgress", "progressPercentage", "txt", "", "updateProgress", "", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class OProgressButton extends OButton {
    private HashMap _$_findViewCache;
    private Integer defaultBackgroundColor;
    private boolean isInProgressMode;
    private int noProcessColor;
    private int processColor;

    public OProgressButton(Context r7, AttributeSet r8) {
        this(r7, r8, 0, 4, null);
    }

    public void _$_clearFindViewByIdCache() {
        HashMap r0 = this._$_findViewCache;
        if (r0 == null) goto L6;
        r0.clear();
        return;
    }

    public View _$_findCachedViewById(int r3) {
        if (this._$_findViewCache != null) goto L5;
        this._$_findViewCache = new HashMap();
    L5:
        View r0 = (View) this._$_findViewCache.get(Integer.valueOf(r3));
        if (r0 != null) goto L9;
        View r1 = findViewById(r3);
        this._$_findViewCache.put(Integer.valueOf(r3), r1);
        return r1;
    L9:
        return r0;
    }

    public /* synthetic */ OProgressButton(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = 0;
    L5:
        this(r1, r2, r3);
    }

    public OProgressButton(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12, 0, null, 24, null);
        this.processColor = ContextCompat.getColor(r10, R.color.oui_blue_7);
        this.noProcessColor = ContextCompat.getColor(r10, R.color.oui_text_1);
        Drawable r13 = getBackground();
        if ((r13 instanceof ColorDrawable) == false) goto L6;
        this.defaultBackgroundColor = Integer.valueOf(((ColorDrawable) r13).getColor());
        return;
    }

    public final void setProgressMode(boolean r2) {
        if (this.isInProgressMode == r2) goto L6;
        this.isInProgressMode = r2;
        updateButtonMode();
    L6:
        if (this.isInProgressMode == false) goto L8;
        setTextColor(this.processColor);
        return;
    L8:
        setTextColor(this.noProcessColor);
    }

    public final void setUpdateProgressMode(boolean r2) {
        if (this.isInProgressMode == r2) goto L6;
        this.isInProgressMode = r2;
        updateButtonMode();
    L6:
        if (this.isInProgressMode == false) goto L8;
        setTextColor(this.processColor);
        return;
    L8:
        setTextColor(this.noProcessColor);
    }

    public final void updateInstallProgress(int r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "txt");
        if (this.isInProgressMode == true) goto L5;
        return;
    L5:
        Drawable r0 = getBackground();
        if ((r0 instanceof LayerDrawable) == false) goto L16;
        LayerDrawable r1 = (LayerDrawable) r0;
        Drawable r2 = r1.findDrawableByLayerId(R.id.progress_layer);
        if (r2 == null) goto L15;
        ClipDrawable r3 = (ClipDrawable) r2;
        Drawable r6 = r1.findDrawableByLayerId(R.id.background_layer);
        if (r6 == null) goto L13;
        int r7 = r4 * 100;
        ((ScaleDrawable) r6).setLevel(10000 - r7);
        r3.setLevel(r7);
        goto L16
    L13:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.ScaleDrawable");
    L15:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.ClipDrawable");
    L16:
        setText(r5);
    }

    public final void updateProgress(float r5) {
        if (this.isInProgressMode == true) goto L5;
        return;
    L5:
        Drawable r0 = getBackground();
        if ((r0 instanceof LayerDrawable) == false) goto L16;
        LayerDrawable r1 = (LayerDrawable) r0;
        Drawable r2 = r1.findDrawableByLayerId(R.id.progress_layer);
        if (r2 == null) goto L15;
        ClipDrawable r3 = (ClipDrawable) r2;
        Drawable r4 = r1.findDrawableByLayerId(R.id.background_layer);
        if (r4 == null) goto L13;
        int r6 = (int) (100 * r5);
        ((ScaleDrawable) r4).setLevel(10000 - r6);
        r3.setLevel(r6);
        goto L16
    L13:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.ScaleDrawable");
    L15:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.ClipDrawable");
    L16:
        setText(new StringBuilder().append(r5).append('%').toString());
    }

    private final void updateButtonMode() {
        if (this.isInProgressMode == false) goto L6;
        changeToProgressDrawable();
        return;
    L6:
        if (this.defaultBackgroundColor == null) goto L8;
        Integer r1 = this.defaultBackgroundColor;
        Intrinsics.checkNotNull(r1);
        setBackground(new ColorDrawable(r1.intValue()));
    L8:
        setTextSize(14.0f);
        setTextColor(this.noProcessColor);
    }

    private final void changeToProgressDrawable() {
        setBackgroundResource(R.drawable.o_button_progress);
        setTextSize(12.0f);
        setTextColor(this.processColor);
    }
}
