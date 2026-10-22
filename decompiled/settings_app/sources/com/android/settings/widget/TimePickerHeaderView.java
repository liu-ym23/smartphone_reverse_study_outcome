package com.android.settings.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.android.settings.R;
import com.obric.oui.button.OIconButton;
import com.obric.oui.text.OTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TimePickerHeaderView.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/android/settings/widget/TimePickerHeaderView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "btnNegative", "Lcom/obric/oui/button/OIconButton;", "getBtnNegative", "()Lcom/obric/oui/button/OIconButton;", "btnPositive", "getBtnPositive", "tvTitle", "Lcom/obric/oui/text/OTextView;", "getTvTitle", "()Lcom/obric/oui/text/OTextView;", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TimePickerHeaderView extends RelativeLayout {
    private final OIconButton btnNegative;
    private final OIconButton btnPositive;
    private final OTextView tvTitle;

    /* JADX WARN: Multi-variable type inference failed */
    public TimePickerHeaderView(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, null, 2, 0 == true ? 1 : 0);
    }

    public /* synthetic */ TimePickerHeaderView(Context r1, AttributeSet r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public TimePickerHeaderView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        RelativeLayout.inflate(r2, R.layout.time_picker_header_view, this);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        View r4 = findViewById(R.id.btn_negative);
        Intrinsics.checkNotNull(r4);
        this.btnNegative = (OIconButton) r4;
        View r5 = findViewById(R.id.btn_positive);
        Intrinsics.checkNotNull(r5);
        this.btnPositive = (OIconButton) r5;
        View r6 = findViewById(R.id.tv_title);
        Intrinsics.checkNotNull(r6);
        this.tvTitle = (OTextView) r6;
    }

    public final OIconButton getBtnNegative() {
        return this.btnNegative;
    }

    public final OIconButton getBtnPositive() {
        return this.btnPositive;
    }

    public final OTextView getTvTitle() {
        return this.tvTitle;
    }
}
