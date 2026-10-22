package com.obric.oui.panel.header;

import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\n\u001a\u00020\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/obric/oui/panel/header/OPanelPadHeaderView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroidx/appcompat/widget/AppCompatImageView;", "getCloseIconView", "()Landroidx/appcompat/widget/AppCompatImageView;", "Landroid/widget/TextView;", "getTitleView", "()Landroid/widget/TextView;", "g", "Landroid/widget/TextView;", "tvTitle", "f", "Landroidx/appcompat/widget/AppCompatImageView;", "ivClose", "OUI_standardRelease"}, k = 1, mv = {1, 1, 15})
public final class OPanelPadHeaderView extends ConstraintLayout {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AppCompatImageView f11238f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final TextView f11239g;

    public final AppCompatImageView getCloseIconView() {
        return this.f11238f;
    }

    public final TextView getTitleView() {
        return this.f11239g;
    }
}
