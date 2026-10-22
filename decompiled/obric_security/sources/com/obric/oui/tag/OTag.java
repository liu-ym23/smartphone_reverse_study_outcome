package com.obric.oui.tag;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.obric.common.oui.R;
import com.obric.oui.common.util.OUnitExtensionKt;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OTag.kt */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated(message = "use OTextTag")
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0012\u0010\t\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u0007X\u0082\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/obric/oui/tag/OTag;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bgEndColor", "bgStartColor", "borderColor", "bordered", "", "tagSize", "getTagSize$annotations", "()V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OTag extends AppCompatTextView {
    private int bgEndColor;
    private int bgStartColor;
    private int borderColor;
    private boolean bordered;
    private int tagSize;

    public OTag(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public OTag(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    private static /* synthetic */ void getTagSize$annotations() {
    }

    public /* synthetic */ OTag(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public OTag(Context r5, AttributeSet r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6, r7);
        TypedArray r8 = r5.getTheme().obtainStyledAttributes(r6, R.styleable.OTag, 0, 0);
        this.tagSize = r8.getInteger(R.styleable.OTag_oui_size, 0);     // Catch: Throwable -> L18
        this.bordered = r8.getBoolean(R.styleable.OTag_oui_bordered, false);     // Catch: Throwable -> L18
        this.borderColor = r8.getColor(R.styleable.OTag_oui_borderColor, 0);     // Catch: Throwable -> L18
        this.bgStartColor = r8.getColor(R.styleable.OTag_oui_bgGradientStartColor, 0);     // Catch: Throwable -> L18
        this.bgEndColor = r8.getColor(R.styleable.OTag_oui_bgGradientEndColor, 0);     // Catch: Throwable -> L18
        r8.recycle();
        int r9 = this.tagSize;
        if (r9 == 0) goto L9;
        if (r9 == 2) goto L8;
        OTag r10 = this;
        int r2 = OUnitExtensionKt.vdp(r10, 1);
        int r11 = OUnitExtensionKt.vdp(r10, 3);
    L10:
        setPadding(r11, r2, r11, r2);
        if (this.bgStartColor != 0) goto L13;
    L15:
        GradientDrawable r12 = new GradientDrawable();
    L16:
        r12.setCornerRadius(OUnitExtensionKt.vdp(this, 2));
        setBackground(r12);
        return;
    L13:
        if (this.bgEndColor == 0) goto L15;
        r12 = new GradientDrawable(GradientDrawable.Orientation.TL_BR, new int[]{this.bgStartColor, this.bgEndColor});
        goto L16
    L8:
        OTag r13 = this;
        r2 = OUnitExtensionKt.vdp(r13, 2);
        r11 = OUnitExtensionKt.vdp(r13, 4);
        goto L10
    L9:
        OTag r14 = this;
        int r15 = OUnitExtensionKt.vdp(r14, 3);
        r2 = OUnitExtensionKt.vdp(r14, 1);
        r11 = r15;
    L18:
        th = move-exception;
        r8.recycle();
        throw th;
    }
}
