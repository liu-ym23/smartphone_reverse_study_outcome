package com.obric.oui.filterpanel;

import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.obric.oui.button.OButton;
import java.util.Set;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\tJ\u0013\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0013¨\u0006\u001d"}, d2 = {"Lcom/obric/oui/filterpanel/OFilterPanelView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "count", "Lkotlin/f0;", "setMaxSelectCount", "(I)V", "Lcom/obric/oui/button/OButton;", "getResetBtn", "()Lcom/obric/oui/button/OButton;", "getConfirmBtn", "", "Lcom/obric/oui/filterpanel/OFilterGroupView;", "getFilterGroupViewSet", "()Ljava/util/Set;", "Landroid/widget/LinearLayout;", "getFilterGroupContainer", "()Landroid/widget/LinearLayout;", "g", "Lcom/obric/oui/button/OButton;", "btnReset", "f", "Landroid/widget/LinearLayout;", "filterGroupContainer", "i", "Ljava/util/Set;", "filterGroupViewList", "h", "btnConfirm", "OUI_standardRelease"}, k = 1, mv = {1, 1, 15})
public final class OFilterPanelView extends ConstraintLayout {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final LinearLayout f10989f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final OButton f10990g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final OButton f10991h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Set<OFilterGroupView> f10992i;

    public final OButton getConfirmBtn() {
        return this.f10991h;
    }

    public final LinearLayout getFilterGroupContainer() {
        return this.f10989f;
    }

    public final Set<OFilterGroupView> getFilterGroupViewSet() {
        return this.f10992i;
    }

    public final OButton getResetBtn() {
        return this.f10990g;
    }

    public final void setMaxSelectCount(int r1) {
    }
}
