package com.obric.oui.forms;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.obric.oui.common.util.ViewExtensionsKt;
import com.obric.oui.divider.ODivider;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class OLineInputView extends AbsOForm {
    public ConstraintLayout i;
    public ConstraintLayout j;
    public Config k;
    public int l;

    @Metadata
    public static final class Companion {
    }

    @Metadata
    public static final class Config {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public TextExceedLengthListener f226a;
        public TextClearedListener b;

        @Metadata
        public static final class Builder {
            public final boolean equals(Object r1) {
                if (this != r1) goto L4;
                return true;
            L4:
                if ((r1 instanceof Builder) == false) goto L40;
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
                if (Intrinsics.a(null, null) == true) goto L18;
                return false;
            L18:
                if (Intrinsics.a(null, null) == true) goto L20;
                return false;
            L20:
                if (Intrinsics.a(null, null) == true) goto L22;
                return false;
            L22:
                if (Intrinsics.a(null, null) == true) goto L24;
                return false;
            L24:
                if (Intrinsics.a(null, null) == true) goto L26;
                return false;
            L26:
                if (Intrinsics.a(null, null) == true) goto L28;
                return false;
            L28:
                if (Intrinsics.a(null, null) == true) goto L30;
                return false;
            L30:
                if (Intrinsics.a(null, null) == true) goto L32;
                return false;
            L32:
                if (Intrinsics.a(null, null) == true) goto L34;
                return false;
            L34:
                if (Intrinsics.a(null, null) == true) goto L36;
                return false;
            L36:
                if (Intrinsics.a(null, null) == true) goto L38;
                return false;
            L38:
                if (Intrinsics.a(null, null) == true) goto L61;
                return false;
            L61:
                return true;
            L40:
                return false;
            }

            public final int hashCode() {
                return Integer.hashCode(0) * 29791;
            }

            public final String toString() {
                return "Builder(title=null, inputTips=null, titleIcon=null, showCounter=false, lengthLimit=null, showClear=false, hintText=null, prefixView=null, suffixView=null, showDivider=false, actionText=null, actionTextColor=null, actionTextClickable=false, actionTextListener=null, actionImageDrawable=null, actionImageDrawableListener=null, textWatcher=null, editTextOnFocusChangeListener=null, inputBoxHeight=null, isInSearchBar=false, autoHideClearWhenTextEmpty=false, multiLine=false, mode=0, hideClearWhenNoFocus=false, textExceedLengthListener=null, textClearedListener=null)";
            }
        }
    }

    @Metadata
    public interface TextClearedListener {
    }

    @Metadata
    public interface TextExceedLengthListener {
    }

    @NotNull
    public final ViewGroup getActionContainer() {
        return null;
    }

    @Nullable
    public final ConstraintLayout getActiveBorderView() {
        return this.i;
    }

    public final int getArrangeDirection() {
        return this.l;
    }

    @NotNull
    public final Config getConfig() {
        return this.k;
    }

    @NotNull
    public final ODivider getDivider() {
        return null;
    }

    @NotNull
    public final OFormEditText getEditText() {
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
    public final ImageView getIvAction() {
        return null;
    }

    @NotNull
    public final LinearLayout getIvActionContainer() {
        return null;
    }

    @NotNull
    public final ImageView getIvClear() {
        return null;
    }

    @NotNull
    public final LinearLayout getIvClearContainer() {
        return null;
    }

    @NotNull
    public final ImageView getIvTitleIcon() {
        return null;
    }

    @Nullable
    public final ConstraintLayout getLeftContainer() {
        return this.j;
    }

    @NotNull
    public final RelativeLayout getPrefixContainer() {
        return null;
    }

    @NotNull
    public final RelativeLayout getSuffixContainer() {
        return null;
    }

    @NotNull
    public final String getText() {
        throw null;
    }

    @NotNull
    public final ViewGroup getTitleContainer() {
        return null;
    }

    @NotNull
    public final TextView getTvAction() {
        return null;
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
    public final TextView getTvInputTips() {
        return null;
    }

    @NotNull
    public final TextView getTvTitle() {
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        float r3 = 44;
        Resources r0 = Resources.getSystem();
        Intrinsics.e(r0, "Resources.getSystem()");
        MathKt.a(TypedValue.applyDimension(1, r3, r0.getDisplayMetrics()));
        Resources r1 = Resources.getSystem();
        Intrinsics.e(r1, "Resources.getSystem()");
        ViewExtensionsKt.a(null, MathKt.a(TypedValue.applyDimension(1, r3, r1.getDisplayMetrics())));
        throw null;
    }

    public final void setActiveBorderView(@Nullable ConstraintLayout r1) {
        this.i = r1;
    }

    public final void setArrangeDirection(int r1) {
        this.l = r1;
    }

    public final void setAutoHideClearWhenTextEmpty(boolean r3) {
        Config r4 = getConfig();
        r4.getClass();
        this.k = r4;
        Iterator<WeakReference<TextWatcher>> r5 = getTextWatchers().iterator();
        if (r5.hasNext() == true) goto L6;
        this.k.getClass();
        ViewExtensionsKt.d(null);
        throw null;
    L6:
        TextWatcher r2 = r5.next().get();
        throw null;
    }

    public final void setEditTextOnFocusChangeListener(@NotNull View.OnFocusChangeListener r1) {
        Intrinsics.f(r1, "listener");
        throw null;
    }

    @Override // android.view.View
    public void setEnabled(boolean r1) {
        throw null;
    }

    public final void setInputContainerBackground(@NotNull Drawable r1) {
        Intrinsics.f(r1, "drawable");
        throw null;
    }

    public final void setLeftContainer(@Nullable ConstraintLayout r1) {
        this.j = r1;
    }

    public final void setText(@Nullable String r1) {
        if (r1 != null) goto L5;
        return;
    L5:
        throw null;
    }

    public final void setTextClearedListener(@NotNull TextClearedListener r2) {
        Intrinsics.f(r2, "textClearedListener");
        this.k.b = r2;
    }

    public final void setTextExceedLengthListener(@NotNull TextExceedLengthListener r2) {
        Intrinsics.f(r2, "textExceedLengthListener");
        this.k.f226a = r2;
    }

    public final void setTextWatcher(@Nullable TextWatcher r1) {
        this.k.getClass();
        this.k.getClass();
        ViewExtensionsKt.d(null);
        throw null;
    }
}
