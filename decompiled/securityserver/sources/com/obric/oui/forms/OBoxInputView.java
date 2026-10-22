package com.obric.oui.forms;

import a.a;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import d.b;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class OBoxInputView extends AbsOForm {
    public static final /* synthetic */ int k = 0;
    public ViewGroup i;
    public int j;

    /* JADX INFO: renamed from: com.obric.oui.forms.OBoxInputView$2, reason: invalid class name */
    @Metadata
    final class AnonymousClass2 implements View.OnFocusChangeListener {
        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View r1, boolean r2) {
            if (r2 == false) goto L6;
            int r3 = OBoxInputView.k;
            throw null;
        L6:
            int r4 = OBoxInputView.k;
            throw null;
        }
    }

    @Metadata
    public static final class Companion {
    }

    @Metadata
    public static final class Config {

        @Metadata
        public static final class Builder {
            public final boolean equals(Object r1) {
                if (this != r1) goto L4;
                return true;
            L4:
                if ((r1 instanceof Builder) == false) goto L18;
                ((Builder) r1).getClass();
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
                return a.c(0, Integer.hashCode(0) * 31, 961);
            }

            public final String toString() {
                return "Builder(showTitle=false, title=null, showCounter=false, lengthLimit=null, hintText=null, prefixView=null, textWatcher=null, inputBoxHeight=0, inputBoxMaxHeight=0, autoAdjustHeight=false, ivTitleIcon=null)";
            }
        }
    }

    static {
        b.b("Resources.getSystem()", 1, 144);
    }

    private final void setPrefixView(View r1) {
        if (r1 != null) goto L5;
        return;
    L5:
        throw null;
    }

    public final int getArrangeDirection() {
        return this.j;
    }

    @NotNull
    public final Config getConfig() {
        return null;
    }

    @NotNull
    public final AppCompatEditText getEditText() {
        return null;
    }

    @NotNull
    public final ViewGroup getInputContainer() {
        return null;
    }

    @Override // com.obric.oui.forms.AbsOForm
    @NotNull
    public EditText getInterEditText() {
        return null;
    }

    @NotNull
    public final ImageView getIvTitleIcon() {
        return null;
    }

    @NotNull
    public final ViewGroup getPrefixContainer() {
        return null;
    }

    @NotNull
    public final String getText() {
        throw null;
    }

    @NotNull
    public final ViewGroup getTitleContainer() {
        return this.i;
    }

    @NotNull
    public final TextView getTvCounter() {
        return null;
    }

    @NotNull
    public final TextView getTvErrorTips() {
        return null;
    }

    @NotNull
    public final TextView getTvTitle() {
        return null;
    }

    public final void setArrangeDirection(int r1) {
        this.j = r1;
    }

    public final void setText(@Nullable String r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (r1.length() != 0) goto L7;
        return;
    L7:
        throw null;
    }

    public final void setTextWatcher(@NotNull TextWatcher r4) {
        Intrinsics.f(r4, "textWatcher");
        Iterator<WeakReference<TextWatcher>> r0 = getTextWatchers().iterator();
        if (r0.hasNext() == true) goto L6;
        getTextWatchers().add(new WeakReference(r4));
        throw null;
    L6:
        TextWatcher r3 = r0.next().get();
        throw null;
    }

    public final void setTitleContainer(@NotNull ViewGroup r2) {
        Intrinsics.f(r2, "<set-?>");
        this.i = r2;
    }
}
