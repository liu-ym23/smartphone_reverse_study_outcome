package com.obric.oui.dialog.v2.action;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.obric.common.oui.R;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.dialog.base.OBaseDialogModal;
import com.obric.oui.text.OTextView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OActionDialogModal.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001#B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\u000e\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010!\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020 R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u000f\u001a\u00020\u00108FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\f\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0014\u001a\u00020\u00108FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0015\u0010\u0012¨\u0006$"}, d2 = {"Lcom/obric/oui/dialog/v2/action/OActionDialogModal;", "Lcom/obric/oui/dialog/base/OBaseDialogModal;", "context", "Landroid/content/Context;", "modifier", "Lcom/obric/oui/dialog/v2/action/OActionDialogModal$Modifier;", "(Landroid/content/Context;Lcom/obric/oui/dialog/v2/action/OActionDialogModal$Modifier;)V", "bodyContainerView", "Landroid/view/ViewGroup;", "getBodyContainerView", "()Landroid/view/ViewGroup;", "bodyContainerView$delegate", "Lkotlin/Lazy;", "getModifier", "()Lcom/obric/oui/dialog/v2/action/OActionDialogModal$Modifier;", "subtitleTextView", "Lcom/obric/oui/text/OTextView;", "getSubtitleTextView", "()Lcom/obric/oui/text/OTextView;", "subtitleTextView$delegate", "titleTextView", "getTitleTextView", "titleTextView$delegate", "getLayout", "", "initBody", "", "setContainerView", "view", "Landroid/view/View;", "setSubtitleText", "message", "", "setTitleText", "title", "Modifier", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OActionDialogModal extends OBaseDialogModal {
    private final Lazy bodyContainerView$delegate;
    private final Modifier modifier;
    private final Lazy subtitleTextView$delegate;
    private final Lazy titleTextView$delegate;

    /* JADX INFO: compiled from: OActionDialogModal.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B<\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012%\b\u0002\u0010\u0005\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006¢\u0006\u0002\u0010\fR.\u0010\u0005\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/obric/oui/dialog/v2/action/OActionDialogModal$Modifier;", "", "title", "", "subtitle", "bodyCustomizer", "Lkotlin/Function1;", "Landroid/view/ViewGroup;", "Lkotlin/ParameterName;", "name", "parent", "Landroid/view/View;", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)V", "getBodyCustomizer", "()Lkotlin/jvm/functions/Function1;", "getSubtitle", "()Ljava/lang/CharSequence;", "getTitle", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Modifier {
        private final Function1<ViewGroup, View> bodyCustomizer;
        private final CharSequence subtitle;
        private final CharSequence title;

        /* JADX WARN: Multi-variable type inference failed */
        public Modifier(CharSequence r2, CharSequence r3, Function1<? super ViewGroup, ? extends View> r4) {
            Intrinsics.checkNotNullParameter(r2, "title");
            Intrinsics.checkNotNullParameter(r3, "subtitle");
            this.title = r2;
            this.subtitle = r3;
            this.bodyCustomizer = r4;
        }

        public /* synthetic */ Modifier(CharSequence r1, CharSequence r2, Function1 r3, int r4, DefaultConstructorMarker r5) {
            if ((r4 & 4) == 0) goto L5;
            r3 = null;
        L5:
            this(r1, r2, r3);
        }

        public final CharSequence getTitle() {
            return this.title;
        }

        public final CharSequence getSubtitle() {
            return this.subtitle;
        }

        public final Function1<ViewGroup, View> getBodyCustomizer() {
            return this.bodyCustomizer;
        }
    }

    public OActionDialogModal(Context r2, Modifier r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "modifier");
        super(r2);
        this.modifier = r3;
        this.titleTextView$delegate = LazyKt.lazy(new OActionDialogModal$titleTextView$2(this));
        this.subtitleTextView$delegate = LazyKt.lazy(new OActionDialogModal$subtitleTextView$2(this));
        this.bodyContainerView$delegate = LazyKt.lazy(new OActionDialogModal$bodyContainerView$2(this));
        getTitleTextView().setIncludeFontPadding(true);
        getSubtitleTextView().setIncludeFontPadding(true);
        setTitleText(r3.getTitle());
        setSubtitleText(r3.getSubtitle());
        initBody();
        setAutoDismiss(true);
    }

    public final Modifier getModifier() {
        return this.modifier;
    }

    public final OTextView getTitleTextView() {
        Object r1 = this.titleTextView$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(r1, "<get-titleTextView>(...)");
        return (OTextView) r1;
    }

    public final OTextView getSubtitleTextView() {
        Object r1 = this.subtitleTextView$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(r1, "<get-subtitleTextView>(...)");
        return (OTextView) r1;
    }

    private final ViewGroup getBodyContainerView() {
        Object r1 = this.bodyContainerView$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(r1, "<get-bodyContainerView>(...)");
        return (ViewGroup) r1;
    }

    @Override // com.obric.oui.dialog.base.AbstractDialogModal
    public int getLayout() {
        return R.layout.o_action_dialog;
    }

    public final void setTitleText(CharSequence r5) {
        Intrinsics.checkNotNullParameter(r5, "title");
        if (r5.length() != 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L13;
        getTitleTextView().setVisibility(8);
        ViewGroup.LayoutParams r4 = getSubtitleTextView().getLayoutParams();
        if (r4 == null) goto L12;
        ((ViewGroup.MarginLayoutParams) r4).topMargin = 0;
        return;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L13:
        OTextView r1 = getTitleTextView();
        r1.setVisibility(0);
        r1.setText(r5);
        OTextView r6 = getSubtitleTextView();
        ViewGroup.LayoutParams r7 = r6.getLayoutParams();
        if (r7 == null) goto L18;
        ((ViewGroup.MarginLayoutParams) r7).topMargin = OUnitExtensionKt.vdp(r6, 8);
        return;
    L18:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L5:
        r0 = false;
        goto L7
    }

    public final void setSubtitleText(CharSequence r3) {
        Intrinsics.checkNotNullParameter(r3, "message");
        if (r3.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        getSubtitleTextView().setVisibility(8);
        return;
    L8:
        OTextView r2 = getSubtitleTextView();
        r2.setVisibility(0);
        r2.setText(r3);
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void setContainerView(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        getBodyContainerView().removeAllViews();
        getBodyContainerView().addView(r2);
    }

    private final void initBody() {
        Function1<ViewGroup, View> r0 = this.modifier.getBodyCustomizer();
        if (r0 == null) goto L7;
        View r1 = r0.invoke(getBodyContainerView());
        getBodyContainerView().removeAllViews();
        getBodyContainerView().addView(r1);
        return;
    }
}
