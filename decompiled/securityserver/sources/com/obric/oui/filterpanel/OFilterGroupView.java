package com.obric.oui.filterpanel;

import a.a;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.obric.oui.filter.OFilter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class OFilterGroupView extends ConstraintLayout {
    public int b;

    /* JADX INFO: renamed from: com.obric.oui.filterpanel.OFilterGroupView$1, reason: invalid class name */
    @Metadata
    final class AnonymousClass1 implements View.OnClickListener {
        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            throw null;
        }
    }

    @Metadata
    public static final class Config {
        public final boolean equals(Object r1) {
            if (this != r1) goto L4;
            return true;
        L4:
            if ((r1 instanceof Config) == false) goto L18;
            ((Config) r1).getClass();
            if (Intrinsics.a(null, null) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.a(null, null) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.a(null, null) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.a(null, null) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.a(null, null) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.a(null, null) == true) goto L28;
            return false;
        L28:
            return true;
        L18:
            return false;
        }

        public final int hashCode() {
            return a.c(0, Integer.hashCode(0) * 923521, 31);
        }

        public final String toString() {
            return "Config(title=null, filterStyle=null, maxSelectCount=null, columnCount=0, defaultSelectIndex=null, filterItems=null, onFilterSelectListener=null, initRowCount=0, enableClickWhenSelected=false)";
        }
    }

    @Metadata
    public interface OnFilterClickedListener {
    }

    @Metadata
    public interface OnFilterDataChangeListener {
    }

    @Metadata
    public interface OnFilterSelectedListener {
    }

    @NotNull
    public final GridLayout getGridLayout() {
        return null;
    }

    public final int getMaxSelectCount() {
        return this.b;
    }

    @NotNull
    public final List<OFilter> getSelectedFilters() {
        new ArrayList();
        throw null;
    }

    @NotNull
    public final List<Integer> getSelectedIndexes() {
        new ArrayList();
        throw null;
    }

    @NotNull
    public final TextView getTitle() {
        return null;
    }

    public final void setEnableClickWhenSelected(boolean r1) {
    }

    public final void setMaxSelectCount(int r1) {
        this.b = r1;
    }

    public final void setTitle(@Nullable CharSequence r1) {
        throw null;
    }
}
