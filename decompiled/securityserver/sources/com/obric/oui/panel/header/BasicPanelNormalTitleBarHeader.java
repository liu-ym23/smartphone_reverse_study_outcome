package com.obric.oui.panel.header;

import a.a;
import android.view.View;
import android.widget.ImageView;
import com.obric.oui.titlebar.ONormalTitleBar;
import com.obric.oui.titlebar.OTitleBar;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class BasicPanelNormalTitleBarHeader extends BasicPanelHeader {

    /* JADX INFO: renamed from: com.obric.oui.panel.header.BasicPanelNormalTitleBarHeader$1, reason: invalid class name */
    @Metadata
    final class AnonymousClass1 extends Lambda implements Function1<OTitleBar, Unit> {
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object r8) {
            OTitleBar r9 = (OTitleBar) r8;
            Intrinsics.f(r9, "$receiver");
            if ((r9 instanceof ONormalTitleBar) == false) goto L11;
            ONormalTitleBar r10 = (ONormalTitleBar) r9;
            ImageView r7 = r10.getStartBtn();
            if (r7 == null) goto L7;
            float r3 = 10;
            r7.setPadding(a.d("Resources.getSystem()", 1, r3), a.d("Resources.getSystem()", 1, r3), a.d("Resources.getSystem()", 1, r3), a.d("Resources.getSystem()", 1, r3));
        L7:
            ImageView r11 = r10.getEndBtn();
            if (r11 == null) goto L11;
            float r12 = 10;
            r11.setPadding(a.d("Resources.getSystem()", 1, r12), a.d("Resources.getSystem()", 1, r12), a.d("Resources.getSystem()", 1, r12), a.d("Resources.getSystem()", 1, r12));
        L11:
            return Unit.f330a;
        }
    }

    @Override // com.obric.oui.panel.header.BasicPanelHeader
    public final View b() {
        return null;
    }
}
