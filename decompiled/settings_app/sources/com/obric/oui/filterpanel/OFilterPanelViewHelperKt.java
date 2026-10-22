package com.obric.oui.filterpanel;

import android.content.Context;
import android.view.ViewGroup;
import androidx.core.widget.NestedScrollView;
import com.obric.common.oui.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OFilterPanelViewHelper.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, d2 = {"buildOFilterPanelViewWithWrapContent", "Lcom/obric/oui/filterpanel/OFilterPanelView;", "context", "Landroid/content/Context;", "OUI_standardRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class OFilterPanelViewHelperKt {
    public static final OFilterPanelView buildOFilterPanelViewWithWrapContent(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        OFilterPanelView r0 = new OFilterPanelView(r3, null, 2, null);
        NestedScrollView r4 = (NestedScrollView) r0.findViewById(R.id.scrollView);
        if (r4 == null) goto L6;
        ViewGroup.LayoutParams r1 = r4.getLayoutParams();
        r1.height = -2;
        r4.setLayoutParams(r1);
    L6:
        return r0;
    }
}
