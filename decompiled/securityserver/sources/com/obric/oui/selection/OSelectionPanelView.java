package com.obric.oui.selection;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.obric.oui.common.util.ViewExtensionsKt;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public abstract class OSelectionPanelView extends LinearLayout {
    public IIconLoader b;
    public View c;
    public OSingleSelectionPanelView.OnItemSelectListener e;
    public OMultiSelectionPanelView.OnMultiItemSelectListener f;

    @Metadata
    public static final class DrawableIconLoader implements IIconLoader {
        @Override // com.obric.oui.selection.OSelectionPanelView.IIconLoader
        public final void a(ImageView r1, SelectionItemData r2, Context r3) {
            Intrinsics.f(r1, "iconImageView");
            r1.setImageDrawable(null);
        }
    }

    @Metadata
    public interface IIconLoader {
        void a(ImageView r1, SelectionItemData r2, Context r3);
    }

    @Metadata
    public static final class SelectionItemData {
        public final boolean equals(Object r1) {
            if (this != r1) goto L4;
            return true;
        L4:
            if ((r1 instanceof SelectionItemData) == false) goto L12;
            ((SelectionItemData) r1).getClass();
            if (Intrinsics.a(null, null) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.a(null, null) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.a(null, null) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            return 0;
        }

        public final String toString() {
            return "SelectionItemData(iconDrawable=null, title=null, iconUrl=null)";
        }
    }

    public abstract boolean a();

    @NotNull
    public final View getBottomDivider() {
        View r0 = this.c;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.m("bottomDivider");
        throw null;
    }

    @NotNull
    public final List<OSelectionPanelItemView> getItemViews() {
        return null;
    }

    @Nullable
    public final OSingleSelectionPanelView.OnItemSelectListener getOnItemSelectListener() {
        return this.e;
    }

    @Nullable
    public final OMultiSelectionPanelView.OnMultiItemSelectListener getOnMultiItemSelectListener() {
        return this.f;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    public final void setBottomDivider(@NotNull View r2) {
        Intrinsics.f(r2, "<set-?>");
        this.c = r2;
    }

    public final void setIconLoader(@NotNull IIconLoader r2) {
        Intrinsics.f(r2, "loader");
        this.b = r2;
    }

    public final void setItems(@NotNull List<SelectionItemData> r7) {
        Intrinsics.f(r7, "items");
        Iterator<T> r8 = r7.iterator();
        if (r8.hasNext() == false) goto L10;
        SelectionItemData r9 = (SelectionItemData) r8.next();
        Context r2 = getContext();
        Intrinsics.e(r2, "context");
        final OSelectionPanelItemView r0 = new OSelectionPanelItemView(r2);
        r0.setSelectMode(a());
        r0.p = false;
        ViewExtensionsKt.d(r0.n);
        ViewExtensionsKt.d(r0.m);
        r9.getClass();
        if (TextUtils.isEmpty(null) == false) goto L7;
        ViewExtensionsKt.d(r0.getIconView());
    L8:
        r0.getTextView().setText(null);
        r0.setOnClickListener(new OSelectionPanelView$setItems$$inlined$forEachIndexed$lambda$1(r0, this));
        throw null;
    L7:
        ViewExtensionsKt.e(r0.getIconView());
        IIconLoader r3 = this.b;
        ImageView r4 = r0.getIconView();
        Context r5 = r0.getContext();
        Intrinsics.e(r5, "context");
        r3.a(r4, r9, r5);
        goto L8
    L10:
        Intrinsics.f(null, "<this>");
        throw null;
    }

    public final void setOnItemSelectListener(@Nullable OSingleSelectionPanelView.OnItemSelectListener r1) {
        this.e = r1;
    }

    public final void setOnMultiItemSelectListener(@Nullable OMultiSelectionPanelView.OnMultiItemSelectListener r1) {
        this.f = r1;
    }

    public final void setScrollViewHeight(int r2) {
        new ConstraintLayout.LayoutParams(-1, r2);
        throw null;
    }
}
