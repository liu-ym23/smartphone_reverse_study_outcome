package com.obric.oui.sectiontitlebar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.obric.common.oui.R;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OSectionSupportiveText.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/obric/oui/sectiontitlebar/OSectionSupportiveText;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "sectionDes", "Landroid/widget/TextView;", "getSectionDes", "()Landroid/widget/TextView;", "sectionDes$delegate", "Lkotlin/Lazy;", "setSectionDes", "", "sectionText", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OSectionSupportiveText extends FrameLayout {
    private final Lazy sectionDes$delegate;

    public OSectionSupportiveText(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public OSectionSupportiveText(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    public /* synthetic */ OSectionSupportiveText(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public OSectionSupportiveText(Context r5, AttributeSet r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6, r7);
        this.sectionDes$delegate = LazyKt.lazy(new OSectionSupportiveText$sectionDes$2(this));
        LayoutInflater.from(r5).inflate(R.layout.o_view_section_supportive_text, this, true);
        int[] r0 = R.styleable.OSectionSupportiveText;
        Intrinsics.checkNotNullExpressionValue(r0, "OSectionSupportiveText");
        TypedArray r8 = r5.obtainStyledAttributes(r6, r0, r7, 0);
        Intrinsics.checkNotNullExpressionValue(r8, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        String r9 = r8.getString(R.styleable.OSectionSupportiveText_section_des_text);
        getSectionDes().setText(r9);
        r8.recycle();
    }

    private final TextView getSectionDes() {
        Object r1 = this.sectionDes$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(r1, "<get-sectionDes>(...)");
        return (TextView) r1;
    }

    public final void setSectionDes(String r2) {
        Intrinsics.checkNotNullParameter(r2, "sectionText");
        getSectionDes().setText(r2);
    }
}
