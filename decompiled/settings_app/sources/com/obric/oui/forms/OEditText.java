package com.obric.oui.forms;

import android.content.Context;
import android.icu.text.DateFormat;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.CompletionInfo;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.content.ContextCompat;
import com.obric.common.oui.R;
import com.obric.oui.haptic.VibratorSmt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: OEditText.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001:\u0004abcdB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ2\u0010\u001f\u001a\u00020 2#\u0010!\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010#¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020 0\"H\u0000¢\u0006\u0002\b'J\b\u0010(\u001a\u00020 H\u0002Jq\u0010)\u001a\u00020 2b\u0010!\u001a^\u0012\u0015\u0012\u0013\u0018\u00010+¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(,\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(-\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020 0*H\u0000¢\u0006\u0002\b/J\u0006\u00100\u001a\u00020 J\b\u00101\u001a\u00020\u0017H\u0014J\b\u00102\u001a\u00020\u0017H\u0014J\n\u00103\u001a\u0004\u0018\u000104H\u0016J\b\u00105\u001a\u00020\u0017H\u0014J\b\u00106\u001a\u00020\u0017H\u0014J\u0010\u00107\u001a\u00020\u00102\u0006\u00108\u001a\u00020\u0007H\u0002J\u0012\u00109\u001a\u00020 2\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J0\u0010<\u001a\u00020 2!\u0010!\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(=\u0012\u0004\u0012\u00020 0\"H\u0000¢\u0006\u0002\b>J0\u0010?\u001a\u00020 2\u0006\u0010@\u001a\u00020\u00102\u0006\u0010A\u001a\u00020\u00072\u0006\u0010B\u001a\u00020\u00072\u0006\u0010C\u001a\u00020\u00072\u0006\u0010D\u001a\u00020\u0007H\u0014J\u0018\u0010E\u001a\u00020 2\u0006\u0010F\u001a\u00020\u00072\u0006\u0010G\u001a\u00020\u0007H\u0014J2\u0010H\u001a\u00020 2#\u0010!\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010I¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(J\u0012\u0004\u0012\u00020 0\"H\u0000¢\u0006\u0002\bKJ\u0018\u0010L\u001a\u00020 2\u0006\u0010M\u001a\u00020\u00072\u0006\u0010N\u001a\u00020\u0007H\u0014Jq\u0010O\u001a\u00020 2b\u0010!\u001a^\u0012\u0015\u0012\u0013\u0018\u00010+¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(,\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(P\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020 0*H\u0000¢\u0006\u0002\bQJ\b\u0010R\u001a\u00020\u0010H\u0016J\u0010\u0010S\u001a\u00020 2\u0006\u00108\u001a\u00020\u0007H\u0016J\u0012\u0010T\u001a\u00020 2\b\u0010U\u001a\u0004\u0018\u000104H\u0016J\u0012\u0010V\u001a\u00020 2\b\u0010U\u001a\u0004\u0018\u00010WH\u0016J\u001a\u0010X\u001a\u00020 2\b\b\u0002\u0010Y\u001a\u00020\u00172\b\b\u0002\u0010Z\u001a\u00020\u0017J6\u0010[\u001a\u00020 2\b\b\u0002\u0010\\\u001a\u00020\u00102\b\b\u0002\u0010]\u001a\u00020\u00102\b\b\u0002\u0010^\u001a\u00020\u00102\b\b\u0002\u0010_\u001a\u00020\u00102\u0006\u0010`\u001a\u00020\u0007R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006e"}, d2 = {"Lcom/obric/oui/forms/OEditText;", "Landroidx/appcompat/widget/AppCompatEditText;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "commitCompletionListener", "Lcom/obric/oui/forms/OEditText$CommitCompletionListener;", "getCommitCompletionListener", "()Lcom/obric/oui/forms/OEditText$CommitCompletionListener;", "setCommitCompletionListener", "(Lcom/obric/oui/forms/OEditText$CommitCompletionListener;)V", "isBottomFading", "", "isLeftFading", "isPerformingLongClick", "isRightFading", "isTopFading", "mErrorBackgroundColor", "mPasswordMaskDotSizeRatio", "", "mPasswordMaskDotSpacingRatio", "onFocusChangeListenerWrapper", "Lcom/obric/oui/forms/OEditText$OnFocusChangeListenerWrapper;", "onTouchListenerWrapper", "Lcom/obric/oui/forms/OEditText$OnTouchListenerWrapper;", "textWatcherWrapper", "Lcom/obric/oui/forms/OEditText$TextWatcherWrapper;", "afterTextChanged", "", "action", "Lkotlin/Function1;", "Landroid/text/Editable;", "Lkotlin/ParameterName;", "name", DateFormat.SECOND, "afterTextChanged$OUI_standardRelease", "applyPasswordTransformationIfNeeded", "beforeTextChanged", "Lkotlin/Function4;", "", "start", "count", "after", "beforeTextChanged$OUI_standardRelease", "clearPasswordMask", "getBottomFadingEdgeStrength", "getLeftFadingEdgeStrength", "getOnFocusChangeListener", "Landroid/view/View$OnFocusChangeListener;", "getRightFadingEdgeStrength", "getTopFadingEdgeStrength", "isHiddenPasswordInputType", "type", "onCommitCompletion", "text", "Landroid/view/inputmethod/CompletionInfo;", "onFocusChange", "hasFocus", "onFocusChange$OUI_standardRelease", "onLayout", "changed", "left", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onOnTouchEvent", "Landroid/view/MotionEvent;", "event", "onOnTouchEvent$OUI_standardRelease", "onSelectionChanged", "selStart", "selEnd", "onTextChanged", "before", "onTextChanged$OUI_standardRelease", "performLongClick", "setInputType", "setOnFocusChangeListener", "l", "setOnTouchListener", "Landroid/view/View$OnTouchListener;", "setPasswordMask", "dotSizeRatio", "dotSpacingRatio", "setTextFading", "leftFading", "topFading", "rightFading", "bottomFading", "fadingLength", "CommitCompletionListener", "OnFocusChangeListenerWrapper", "OnTouchListenerWrapper", "TextWatcherWrapper", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OEditText extends AppCompatEditText {
    private CommitCompletionListener commitCompletionListener;
    private boolean isBottomFading;
    private boolean isLeftFading;
    private boolean isPerformingLongClick;
    private boolean isRightFading;
    private boolean isTopFading;
    private int mErrorBackgroundColor;
    private float mPasswordMaskDotSizeRatio;
    private float mPasswordMaskDotSpacingRatio;
    private final OnFocusChangeListenerWrapper onFocusChangeListenerWrapper;
    private final OnTouchListenerWrapper onTouchListenerWrapper;
    private final TextWatcherWrapper textWatcherWrapper;

    /* JADX INFO: compiled from: OEditText.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/forms/OEditText$CommitCompletionListener;", "", "onCommitCompletion", "", "text", "Landroid/view/inputmethod/CompletionInfo;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface CommitCompletionListener {
        void onCommitCompletion(CompletionInfo r1);
    }

    /* JADX INFO: compiled from: OEditText.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0013\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\b\u001a\u00020\u0005H\u0016R7\u0010\u0003\u001a\u001f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/obric/oui/forms/OEditText$OnFocusChangeListenerWrapper;", "Landroid/view/View$OnFocusChangeListener;", "()V", "action", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "hasFocus", "", "getAction", "()Lkotlin/jvm/functions/Function1;", "setAction", "(Lkotlin/jvm/functions/Function1;)V", "listener", "getListener", "()Landroid/view/View$OnFocusChangeListener;", "setListener", "(Landroid/view/View$OnFocusChangeListener;)V", "onFocusChange", "v", "Landroid/view/View;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class OnFocusChangeListenerWrapper implements View.OnFocusChangeListener {
        private Function1<? super Boolean, Unit> action;
        private View.OnFocusChangeListener listener;

        public OnFocusChangeListenerWrapper() {
        }

        public final Function1<Boolean, Unit> getAction() {
            return this.action;
        }

        public final void setAction(Function1<? super Boolean, Unit> r1) {
            this.action = r1;
        }

        public final View.OnFocusChangeListener getListener() {
            return this.listener;
        }

        public final void setListener(View.OnFocusChangeListener r1) {
            this.listener = r1;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View r3, boolean r4) {
            Function1<? super Boolean, Unit> r0 = this.action;
            if (r0 == null) goto L6;
            r0.invoke(Boolean.valueOf(r4));
        L6:
            View.OnFocusChangeListener r2 = this.listener;
            if (r2 == null) goto L11;
            r2.onFocusChange(r3, r4);
            return;
        }
    }

    /* JADX INFO: compiled from: OEditText.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0016R9\u0010\u0003\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0017"}, d2 = {"Lcom/obric/oui/forms/OEditText$OnTouchListenerWrapper;", "Landroid/view/View$OnTouchListener;", "()V", "action", "Lkotlin/Function1;", "Landroid/view/MotionEvent;", "Lkotlin/ParameterName;", "name", "event", "", "getAction", "()Lkotlin/jvm/functions/Function1;", "setAction", "(Lkotlin/jvm/functions/Function1;)V", "listener", "getListener", "()Landroid/view/View$OnTouchListener;", "setListener", "(Landroid/view/View$OnTouchListener;)V", "onTouch", "", "v", "Landroid/view/View;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class OnTouchListenerWrapper implements View.OnTouchListener {
        private Function1<? super MotionEvent, Unit> action;
        private View.OnTouchListener listener;

        public OnTouchListenerWrapper() {
        }

        public final Function1<MotionEvent, Unit> getAction() {
            return this.action;
        }

        public final void setAction(Function1<? super MotionEvent, Unit> r1) {
            this.action = r1;
        }

        public final View.OnTouchListener getListener() {
            return this.listener;
        }

        public final void setListener(View.OnTouchListener r1) {
            this.listener = r1;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View r2, MotionEvent r3) {
            Function1<? super MotionEvent, Unit> r0 = this.action;
            if (r0 == null) goto L6;
            r0.invoke(r3);
        L6:
            View.OnTouchListener r1 = this.listener;
            if (r1 != null) goto L10;
            return false;
        L10:
            return r1.onTouch(r2, r3);
        }
    }

    /* JADX INFO: compiled from: OEditText.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\u0010\b\n\u0002\b\u000f\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u001d\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u001e\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0011H\u0016J*\u0010\u001f\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0016R9\u0010\u0003\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rRx\u0010\u000e\u001a`\u0012\u0015\u0012\u0013\u0018\u00010\u0010¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\t\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018Rx\u0010\u0019\u001a`\u0012\u0015\u0012\u0013\u0018\u00010\u0010¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\t\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018¨\u0006 "}, d2 = {"Lcom/obric/oui/forms/OEditText$TextWatcherWrapper;", "Landroid/text/TextWatcher;", "()V", "afterTextChangedAction", "Lkotlin/Function1;", "Landroid/text/Editable;", "Lkotlin/ParameterName;", "name", DateFormat.SECOND, "", "getAfterTextChangedAction", "()Lkotlin/jvm/functions/Function1;", "setAfterTextChangedAction", "(Lkotlin/jvm/functions/Function1;)V", "beforeTextChangedAction", "Lkotlin/Function4;", "", "", "start", "count", "after", "getBeforeTextChangedAction", "()Lkotlin/jvm/functions/Function4;", "setBeforeTextChangedAction", "(Lkotlin/jvm/functions/Function4;)V", "onTextChangedAction", "before", "getOnTextChangedAction", "setOnTextChangedAction", "afterTextChanged", "beforeTextChanged", "onTextChanged", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class TextWatcherWrapper implements TextWatcher {
        private Function1<? super Editable, Unit> afterTextChangedAction;
        private Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> beforeTextChangedAction;
        private Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> onTextChangedAction;

        public TextWatcherWrapper() {
        }

        public final Function4<CharSequence, Integer, Integer, Integer, Unit> getOnTextChangedAction() {
            return this.onTextChangedAction;
        }

        public final void setOnTextChangedAction(Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> r1) {
            this.onTextChangedAction = r1;
        }

        public final Function4<CharSequence, Integer, Integer, Integer, Unit> getBeforeTextChangedAction() {
            return this.beforeTextChangedAction;
        }

        public final void setBeforeTextChangedAction(Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> r1) {
            this.beforeTextChangedAction = r1;
        }

        public final Function1<Editable, Unit> getAfterTextChangedAction() {
            return this.afterTextChangedAction;
        }

        public final void setAfterTextChangedAction(Function1<? super Editable, Unit> r1) {
            this.afterTextChangedAction = r1;
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
            Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> r0 = this.beforeTextChangedAction;
            if (r0 == null) goto L7;
            r0.invoke(r1, Integer.valueOf(r2), Integer.valueOf(r3), Integer.valueOf(r4));
            return;
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
            Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> r0 = this.onTextChangedAction;
            if (r0 == null) goto L7;
            r0.invoke(r1, Integer.valueOf(r2), Integer.valueOf(r3), Integer.valueOf(r4));
            return;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable r1) {
            Function1<? super Editable, Unit> r0 = this.afterTextChangedAction;
            if (r0 == null) goto L7;
            r0.invoke(r1);
            return;
        }
    }

    public OEditText(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public OEditText(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    private final boolean isHiddenPasswordInputType(int r5) {
        int r4 = r5 & 4095;
        if (r4 != 129) goto L5;
        boolean r6 = true;
    L7:
        if (r4 != 225) goto L9;
        boolean r2 = true;
    L11:
        if (r4 != 18) goto L13;
        boolean r7 = true;
    L14:
        if (r6 == true) goto L20;
        if (r2 == true) goto L21;
        if (r7 == false) goto L19;
        return true;
    L19:
        return false;
    L21:
        return true;
    L20:
        return true;
    L13:
        r7 = false;
        goto L14
    L9:
        r2 = false;
        goto L11
    L5:
        r6 = false;
        goto L7
    }

    public /* synthetic */ OEditText(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public OEditText(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        OnFocusChangeListenerWrapper r6 = new OnFocusChangeListenerWrapper();
        this.onFocusChangeListenerWrapper = r6;
        OnTouchListenerWrapper r7 = new OnTouchListenerWrapper();
        this.onTouchListenerWrapper = r7;
        TextWatcherWrapper r0 = new TextWatcherWrapper();
        this.textWatcherWrapper = r0;
        this.mPasswordMaskDotSizeRatio = 0.38f;
        this.mPasswordMaskDotSpacingRatio = 0.19f;
        this.mErrorBackgroundColor = ContextCompat.getColor(r3, R.color.oui_functional_red_2);
        setOnFocusChangeListener(r6);
        super.setOnTouchListener(r7);
        addTextChangedListener(r0);
        setHighlightColor(r3.getColor(R.color.oui_text_highlight_color));
        applyPasswordTransformationIfNeeded();
    }

    public final CommitCompletionListener getCommitCompletionListener() {
        return this.commitCompletionListener;
    }

    public final void setCommitCompletionListener(CommitCompletionListener r1) {
        this.commitCompletionListener = r1;
    }

    public static /* synthetic */ void setTextFading$default(OEditText r7, boolean r8, boolean r9, boolean r10, boolean r11, int r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L5;
        boolean r2 = false;
    L7:
        if ((r13 & 2) == 0) goto L9;
        boolean r3 = false;
    L11:
        if ((r13 & 4) == 0) goto L13;
        boolean r4 = false;
    L15:
        if ((r13 & 8) == 0) goto L17;
        boolean r5 = false;
    L18:
        r7.setTextFading(r2, r3, r4, r5, r12);
        return;
    L17:
        r5 = r11;
        goto L18
    L13:
        r4 = r10;
        goto L15
    L9:
        r3 = r9;
        goto L11
    L5:
        r2 = r8;
        goto L7
    }

    public final void setTextFading(boolean r1, boolean r2, boolean r3, boolean r4, int r5) {
        setFadingEdgeLength(r5);
        this.isLeftFading = r1;
        this.isTopFading = r2;
        this.isRightFading = r3;
        this.isBottomFading = r4;
        boolean r6 = false;
        if (r1 == true) goto L7;
        if (r3 == true) goto L7;
        boolean r7 = false;
    L8:
        setHorizontalFadingEdgeEnabled(r7);
        if (this.isTopFading == false) goto L11;
    L12:
        r6 = true;
    L13:
        setVerticalFadingEdgeEnabled(r6);
        return;
    L11:
        if (this.isBottomFading == false) goto L13;
    L7:
        r7 = true;
        goto L8
    }

    public final void onFocusChange$OUI_standardRelease(Function1<? super Boolean, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        this.onFocusChangeListenerWrapper.setAction(r2);
    }

    public final void onOnTouchEvent$OUI_standardRelease(Function1<? super MotionEvent, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        this.onTouchListenerWrapper.setAction(r2);
    }

    public final void beforeTextChanged$OUI_standardRelease(Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        this.textWatcherWrapper.setBeforeTextChangedAction(r2);
    }

    public final void onTextChanged$OUI_standardRelease(Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        this.textWatcherWrapper.setOnTextChangedAction(r2);
    }

    public final void afterTextChanged$OUI_standardRelease(Function1<? super Editable, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        this.textWatcherWrapper.setAfterTextChangedAction(r2);
    }

    @Override // android.widget.TextView, android.view.View
    protected float getLeftFadingEdgeStrength() {
        if (this.isLeftFading == true) goto L7;
        return 0.0f;
    L7:
        return super.getLeftFadingEdgeStrength();
    }

    @Override // android.widget.TextView, android.view.View
    protected float getRightFadingEdgeStrength() {
        if (this.isRightFading == true) goto L7;
        return 0.0f;
    L7:
        return super.getRightFadingEdgeStrength();
    }

    @Override // android.view.View
    protected float getTopFadingEdgeStrength() {
        if (this.isTopFading == true) goto L7;
        return 0.0f;
    L7:
        return super.getTopFadingEdgeStrength();
    }

    @Override // android.view.View
    protected float getBottomFadingEdgeStrength() {
        if (this.isBottomFading == true) goto L7;
        return 0.0f;
    L7:
        return super.getBottomFadingEdgeStrength();
    }

    @Override // android.view.View
    public void setOnTouchListener(View.OnTouchListener r1) {
        this.onTouchListenerWrapper.setListener(r1);
    }

    @Override // android.widget.TextView
    public void onCommitCompletion(CompletionInfo r1) {
        super.onCommitCompletion(r1);
        CommitCompletionListener r0 = this.commitCompletionListener;
        if (r0 == null) goto L7;
        r0.onCommitCompletion(r1);
        return;
    }

    @Override // android.widget.TextView
    public void setInputType(int r1) {
        super.setInputType(r1);
        applyPasswordTransformationIfNeeded();
    }

    @Override // android.view.View
    public View.OnFocusChangeListener getOnFocusChangeListener() {
        View.OnFocusChangeListener r1 = super.getOnFocusChangeListener();
        if ((r1 instanceof OnFocusChangeListenerWrapper) == true) goto L5;
        return r1;
    L5:
        return ((OnFocusChangeListenerWrapper) r1).getListener();
    }

    @Override // android.view.View
    public void setOnFocusChangeListener(View.OnFocusChangeListener r2) {
        if ((r2 instanceof OnFocusChangeListenerWrapper) == false) goto L5;
        super.setOnFocusChangeListener(r2);
        return;
    L5:
        this.onFocusChangeListenerWrapper.setListener(r2);
    }

    public static /* synthetic */ void setPasswordMask$default(OEditText r1, float r2, float r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = 0.0f;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = 0.0f;
    L8:
        r1.setPasswordMask(r2, r3);
    }

    public final void setPasswordMask(float r4, float r5) {
        float r6 = RangesKt.coerceAtLeast(r4, 0.0f);
        float r7 = RangesKt.coerceAtLeast(r5, 0.0f);
        boolean r1 = true;
        if (this.mPasswordMaskDotSizeRatio != r6) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
    L13:
        this.mPasswordMaskDotSizeRatio = r6;
        this.mPasswordMaskDotSpacingRatio = r7;
        applyPasswordTransformationIfNeeded();
        return;
    L8:
        if (this.mPasswordMaskDotSpacingRatio == r7) goto L11;
        r1 = false;
    L11:
        if (r1 == false) goto L13;
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void clearPasswordMask() {
        setPasswordMask(0.0f, 0.0f);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean performLongClick() {
        this.isPerformingLongClick = true;
        boolean r0 = super.performLongClick();
        this.isPerformingLongClick = false;
        return r0;
    }

    @Override // android.widget.TextView
    protected void onSelectionChanged(int r1, int r2) {
        super.onSelectionChanged(r1, r2);
        if (r1 == r2) goto L5;
        boolean r3 = true;
    L7:
        if (this.isPerformingLongClick == true) goto L11;
        if (r3 == false) goto L12;
        VibratorSmt.vibrateEffectWithHapticPlayer(getContext(), 3);
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r3 = false;
        goto L7
    }

    private final void applyPasswordTransformationIfNeeded() {
        if (isHiddenPasswordInputType(getInputType()) == false) goto L5;
        TransformationMethod r0 = getTransformationMethod();
        if ((r0 instanceof OPasswordTransformationMethod) == false) goto L21;
        OPasswordTransformationMethod r1 = (OPasswordTransformationMethod) r0;
        boolean r2 = true;
        if (r1.getDotSizeRatio() != this.mPasswordMaskDotSizeRatio) goto L13;
        boolean r3 = true;
    L14:
        if (r3 == false) goto L21;
        if (r1.getDotSpacingRatio() == this.mPasswordMaskDotSpacingRatio) goto L19;
        r2 = false;
    L19:
        if (r2 == false) goto L21;
        return;
    L13:
        r3 = false;
    L21:
        super.setTransformationMethod(new OPasswordTransformationMethod(this.mPasswordMaskDotSizeRatio, this.mPasswordMaskDotSpacingRatio, this.mErrorBackgroundColor));
        return;
    L5:
        if ((getTransformationMethod() instanceof PasswordTransformationMethod) == false) goto L23;
        super.setTransformationMethod(null);
        return;
    }
}
