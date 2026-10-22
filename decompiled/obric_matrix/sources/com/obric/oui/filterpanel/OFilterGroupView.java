package com.obric.oui.filterpanel;

import android.widget.GridLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.obric.oui.filter.OFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.i0.r;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0007\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\u000fJ\u0013\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0010¢\u0006\u0004\b\u0014\u0010\u0012J\u0015\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0019\u0010!\u001a\u00020\u001c8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001c\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00130\"8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010(\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'¨\u0006)"}, d2 = {"Lcom/obric/oui/filterpanel/OFilterGroupView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "title", "Lkotlin/f0;", "setTitle", "(Ljava/lang/CharSequence;)V", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "", "count", "setMaxSelectCount", "(I)V", "getMaxSelectCount", "()I", "", "getSelectedIndexes", "()Ljava/util/List;", "Lcom/obric/oui/filter/OFilter;", "getSelectedFilters", "", "enableClickWhenSelected", "setEnableClickWhenSelected", "(Z)V", "f", "Landroid/widget/TextView;", "tvTitle", "Landroid/widget/GridLayout;", "g", "Landroid/widget/GridLayout;", "getGridLayout", "()Landroid/widget/GridLayout;", "gridLayout", "", "i", "Ljava/util/List;", "filtersList", "h", "I", "maxSelectCount", "OUI_standardRelease"}, k = 1, mv = {1, 1, 15})
public final class OFilterGroupView extends ConstraintLayout {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final TextView f10985f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final GridLayout f10986g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f10987h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final List<OFilter> f10988i;

    public final GridLayout getGridLayout() {
        return this.f10986g;
    }

    public final int getMaxSelectCount() {
        return this.f10987h;
    }

    public final List<OFilter> getSelectedFilters() {
        ArrayList r0 = new ArrayList();
        Iterator<T> r3 = this.f10988i.iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        OFilter r1 = (OFilter) r3.next();
        if (r1.isSelected() == false) goto L4;
        r0.add(r1);
        goto L4
    L8:
        return r0;
    }

    public final List<Integer> getSelectedIndexes() {
        ArrayList r0 = new ArrayList();
        Iterator<T> r4 = this.f10988i.iterator();
        int r1 = 0;
    L4:
        if (r4.hasNext() == false) goto L13;
        Object r2 = r4.next();
        int r3 = r1 + 1;
        if (r1 < 0) goto L11;
        if (((OFilter) r2).isSelected() == false) goto L10;
        r0.add(Integer.valueOf(r1));
    L10:
        r1 = r3;
        goto L4
    L11:
        r.p();
        throw null;
    L13:
        return r0;
    }

    public final TextView getTitle() {
        return this.f10985f;
    }

    public final void setEnableClickWhenSelected(boolean r1) {
    }

    public final void setMaxSelectCount(int r1) {
        this.f10987h = r1;
    }

    public final void setTitle(CharSequence r1) {
        this.f10985f.setText(r1);
    }
}
