package com.obric.oui.lisitem;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.obric.common.oui.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SettingsTrailingView.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\u000e\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001eR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/obric/oui/lisitem/SettingsTrailingView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "iconImageView", "Landroid/widget/ImageView;", "getIconImageView", "()Landroid/widget/ImageView;", "setIconImageView", "(Landroid/widget/ImageView;)V", "textView", "Landroid/widget/TextView;", "getTextView", "()Landroid/widget/TextView;", "setTextView", "(Landroid/widget/TextView;)V", "setTrailingImage", "", "drawable", "Landroid/graphics/drawable/Drawable;", "setTrailingText", "text", "", "showTrailingImageView", "isShow", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SettingsTrailingView extends LinearLayout {
    private ImageView iconImageView;
    private TextView textView;

    public SettingsTrailingView(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public SettingsTrailingView(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    public /* synthetic */ SettingsTrailingView(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public SettingsTrailingView(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        View r6 = LayoutInflater.from(r3).inflate(R.layout.o_settings_trailing_view_2, this, false);
        LinearLayout.LayoutParams r7 = new LinearLayout.LayoutParams(-1, -2);
        r7.gravity = 8388629;
        addView(r6, r7);
        View r8 = findViewById(R.id.trailingText);
        Intrinsics.checkNotNullExpressionValue(r8, "findViewById(R.id.trailingText)");
        this.textView = (TextView) r8;
        View r9 = findViewById(R.id.trailingImage);
        Intrinsics.checkNotNullExpressionValue(r9, "findViewById(R.id.trailingImage)");
        ImageView r10 = (ImageView) r9;
        this.iconImageView = r10;
        r10.setImageDrawable(r3.getDrawable(R.drawable.ic_arrow_forward_list_item));
    }

    public final TextView getTextView() {
        return this.textView;
    }

    public final void setTextView(TextView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.textView = r2;
    }

    public final ImageView getIconImageView() {
        return this.iconImageView;
    }

    public final void setIconImageView(ImageView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.iconImageView = r2;
    }

    public final void setTrailingText(String r2) {
        Intrinsics.checkNotNullParameter(r2, "text");
        this.textView.setText(r2);
    }

    public final void setTrailingImage(Drawable r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        this.iconImageView.setImageDrawable(r1);
    }

    public final void showTrailingImageView(boolean r1) {
        if (r1 == false) goto L4;
        this.iconImageView.setVisibility(0);
        return;
    L4:
        this.iconImageView.setVisibility(8);
    }
}
