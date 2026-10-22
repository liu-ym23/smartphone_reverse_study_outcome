package com.obric.oui.searchbar;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.obric.oui.common.util.ViewExtensionsKt;
import com.obric.oui.forms.OInputView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public class OSearchBar extends ConstraintLayout {

    /* JADX INFO: renamed from: com.obric.oui.searchbar.OSearchBar$setSearchAction$1, reason: invalid class name */
    @Metadata
    public static final class AnonymousClass1 implements View.OnClickListener {
        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            throw null;
        }
    }

    @NotNull
    public final OInputView getInputView() {
        return null;
    }

    @Nullable
    public final View getPostfixView() {
        return null;
    }

    @Nullable
    public final View getPrefixView() {
        throw null;
    }

    @NotNull
    public final String getText() {
        throw null;
    }

    @Override // android.view.View
    public void setEnabled(boolean r1) {
        throw null;
    }

    public final void setOnInputFocusChange(@NotNull View.OnFocusChangeListener r1) {
        Intrinsics.f(r1, "onFocusChangeListener");
        throw null;
    }

    public final void setSearchAction(@NotNull View.OnClickListener r1) {
        Intrinsics.f(r1, "click");
        throw null;
    }

    public final void setSearchActionText(@NotNull String r1) {
        Intrinsics.f(r1, "searchActionText");
        if (r1.length() != 0) goto L6;
        ViewExtensionsKt.d(null);
        throw null;
    L6:
        throw null;
    }

    public final void setText(@NotNull String r1) {
        Intrinsics.f(r1, "text");
        throw null;
    }
}
