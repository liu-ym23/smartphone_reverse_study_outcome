package com.obric.oui.dialog.alert.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.obric.common.oui.R;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DialogEntranceView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated(message = "已废弃")
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000b\u001a\u00020\bJ\u0006\u0010\f\u001a\u00020\nR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/oui/dialog/alert/view/DialogEntranceView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ivIcon", "Landroid/widget/ImageView;", "tvTitle", "Landroid/widget/TextView;", "getImageView", "getTextView", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DialogEntranceView extends ConstraintLayout {
    private final ImageView ivIcon;
    private final TextView tvTitle;

    /* JADX WARN: Multi-variable type inference failed */
    public DialogEntranceView(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, null, 2, 0 == true ? 1 : 0);
    }

    public /* synthetic */ DialogEntranceView(Context r1, AttributeSet r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public DialogEntranceView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        ConstraintLayout.inflate(r2, R.layout.o_layout_dialog_entrance, this);
        View r4 = findViewById(R.id.tv_normal);
        Intrinsics.checkNotNullExpressionValue(r4, "findViewById(R.id.tv_normal)");
        this.tvTitle = (TextView) r4;
        View r5 = findViewById(R.id.icon);
        Intrinsics.checkNotNullExpressionValue(r5, "findViewById(R.id.icon)");
        this.ivIcon = (ImageView) r5;
    }

    public final TextView getTextView() {
        return this.tvTitle;
    }

    public final ImageView getImageView() {
        return this.ivIcon;
    }
}
