package com.obric.oui.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.ViewGroupKt;
import com.android.settings.search.IndexDatabaseHelper;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OUILinearLayoutDisableChildren.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0016\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lcom/obric/oui/layout/OUILinearLayoutDisableChildren;", "Lcom/obric/oui/layout/OUILinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "setEnabled", "", IndexDatabaseHelper.IndexColumns.ENABLED, "", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class OUILinearLayoutDisableChildren extends OUILinearLayout {
    public OUILinearLayoutDisableChildren(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public OUILinearLayoutDisableChildren(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    public /* synthetic */ OUILinearLayoutDisableChildren(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public OUILinearLayoutDisableChildren(Context r9, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r9, "context");
        super(r9, r10, r11, null, 8, null);
        setChangeAlphaWhenDisable(false);
    }

    @Override // com.obric.oui.layout.OUILinearLayout, android.view.View
    public void setEnabled(boolean r4) {
        super.setEnabled(r4);
        setAlpha(1.0f);
        Iterator<View> r3 = ViewGroupKt.getChildren(this).iterator();
    L4:
        if (r3.hasNext() == false) goto L10;
        View r1 = r3.next();
        if (r4 == false) goto L8;
        float r2 = 1.0f;
    L9:
        r1.setAlpha(r2);
        goto L4
    L8:
        r2 = 0.3f;
        goto L9
    }
}
