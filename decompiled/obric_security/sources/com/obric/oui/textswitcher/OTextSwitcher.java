package com.obric.oui.textswitcher;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.widget.TextSwitcher;
import android.widget.ViewSwitcher;
import com.obric.common.oui.R;
import com.obric.oui.common.util.ToolsExtKt;
import java.util.ArrayList;
import java.util.Timer;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: OTextSwitcher.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000U\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u001a\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0018H\u0016J\u0010\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020\u001dH\u0016J\b\u0010#\u001a\u00020\u001dH\u0016R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\r\u001a\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001b¨\u0006$"}, d2 = {"Lcom/obric/oui/textswitcher/OTextSwitcher;", "Landroid/widget/TextSwitcher;", "Lcom/obric/oui/textswitcher/IOTextSwitcher;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defaultViewFactory", "Landroid/widget/ViewSwitcher$ViewFactory;", "getDefaultViewFactory", "()Landroid/widget/ViewSwitcher$ViewFactory;", "defaultViewFactory$delegate", "Lkotlin/Lazy;", "hadStart", "", "mOTextSwitcherTimer", "Ljava/util/Timer;", "mUiHander", "Landroid/os/Handler;", "getMUiHander", "()Landroid/os/Handler;", "mUiHander$delegate", "oTextSwitcherSpec", "Lcom/obric/oui/textswitcher/TextSwitcherSpec;", "textSwitcherOnAttachStateChangeListener", "com/obric/oui/textswitcher/OTextSwitcher$textSwitcherOnAttachStateChangeListener$1", "Lcom/obric/oui/textswitcher/OTextSwitcher$textSwitcherOnAttachStateChangeListener$1;", "build", "", "spec", "safeUpdateText", "text", "", "startAfterBuild", "stopAnim", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OTextSwitcher extends TextSwitcher implements IOTextSwitcher {
    private final Lazy defaultViewFactory$delegate;
    private boolean hadStart;
    private Timer mOTextSwitcherTimer;
    private final Lazy mUiHander$delegate;
    private TextSwitcherSpec oTextSwitcherSpec;
    private final OTextSwitcher$textSwitcherOnAttachStateChangeListener$1 textSwitcherOnAttachStateChangeListener;

    public static /* synthetic */ void $r8$lambda$mycTaU_oKlXc4biSi_0mXnzZd3g(ArrayList r0, OTextSwitcher r1) {
        m554startAfterBuild$lambda11(r0, r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OTextSwitcher(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, null, 2, 0 == true ? 1 : 0);
    }

    public /* synthetic */ OTextSwitcher(Context r1, AttributeSet r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public static final /* synthetic */ Handler access$getMUiHander(OTextSwitcher r0) {
        return r0.getMUiHander();
    }

    public static final /* synthetic */ TextSwitcherSpec access$getOTextSwitcherSpec$p(OTextSwitcher r0) {
        return r0.oTextSwitcherSpec;
    }

    public static final /* synthetic */ void access$safeUpdateText(OTextSwitcher r0, String r1) {
        r0.safeUpdateText(r1);
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.obric.oui.textswitcher.OTextSwitcher$textSwitcherOnAttachStateChangeListener$1] */
    public OTextSwitcher(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.mUiHander$delegate = LazyKt.lazy(OTextSwitcher$mUiHander$2.INSTANCE);
        this.defaultViewFactory$delegate = LazyKt.lazy(new OTextSwitcher$defaultViewFactory$2(r2, this));
        this.textSwitcherOnAttachStateChangeListener = new OTextSwitcher$textSwitcherOnAttachStateChangeListener$1(this);
    }

    private final Handler getMUiHander() {
        return (Handler) this.mUiHander$delegate.getValue();
    }

    private final ViewSwitcher.ViewFactory getDefaultViewFactory() {
        return (ViewSwitcher.ViewFactory) this.defaultViewFactory$delegate.getValue();
    }

    @Override // com.obric.oui.textswitcher.IOTextSwitcher
    public void build(TextSwitcherSpec r4) {
        Intrinsics.checkNotNullParameter(r4, "spec");
        this.oTextSwitcherSpec = r4;
        if (getChildCount() <= 0) goto L5;
        removeAllViews();
    L5:
        TextSwitcherSpec r5 = this.oTextSwitcherSpec;
        if (r5 == null) goto L31;
        Unit r0 = null;
        ViewSwitcher.ViewFactory r6 = r5.getViewFactory();     // Catch: Exception -> L17
        if (r6 != null) goto L12;
        Unit r7 = null;
    L13:
        if (r7 != null) goto L15;
        setFactory(getDefaultViewFactory());     // Catch: Exception -> L17
    L15:
        Unit r8 = Unit.INSTANCE;     // Catch: Exception -> L17
    L19:
        Animation r9 = getInAnimation();
        if (r9 != null) goto L22;
        Unit r10 = null;
    L23:
        if (r10 != null) goto L25;
        setInAnimation(getContext(), R.anim.o_textswitcher_vertical_in);
    L25:
        Animation r11 = getOutAnimation();
        if (r11 == null) goto L29;
        setOutAnimation(r11);
        r0 = Unit.INSTANCE;
    L29:
        if (r0 != null) goto L31;
        setOutAnimation(getContext(), R.anim.o_textswitcher_vertical_out);
        goto L31
    L22:
        setInAnimation(r9);
        r10 = Unit.INSTANCE;
        goto L23
    L12:
        setFactory(r6);     // Catch: Exception -> L17
        r7 = Unit.INSTANCE;     // Catch: Exception -> L17
    L17:
        e = move-exception;
        ToolsExtKt.printLog(Intrinsics.stringPlus("Try exception occur ", e.getMessage()));
        ToolsExtKt.printLog(Intrinsics.stringPlus("viewFratory exception occur, error msg = ", e.getMessage()));
        Unit r12 = Unit.INSTANCE;
    L31:
        removeOnAttachStateChangeListener(this.textSwitcherOnAttachStateChangeListener);
        addOnAttachStateChangeListener(this.textSwitcherOnAttachStateChangeListener);
    }

    @Override // com.obric.oui.textswitcher.IOTextSwitcher
    public void startAfterBuild() {
        Ref.IntRef r0 = new Ref.IntRef();
        TextSwitcherSpec r1 = this.oTextSwitcherSpec;
        if (r1 != null) goto L5;
    L4:
        final ArrayList<String> r2 = null;
    L9:
        if (r2 != null) goto L11;
        return;
    L11:
        boolean r4 = true;
        if (r2.size() != 1) goto L24;
        TextSwitcherSpec r3 = this.oTextSwitcherSpec;
        if (r3 != null) goto L16;
    L15:
        r4 = false;
    L21:
        if (r4 == false) goto L24;
        getMUiHander().post(new OTextSwitcher$$ExternalSyntheticLambda0(r2, this));
        return;
    L16:
        TextSwitcherTriggerSpec r5 = r3.getTriggerSpec();
        if (r5 == null) goto L15;
        if (r5.isOneLineNeedSwitch() == true) goto L15;
    L24:
        OTextSwitcher$startAfterBuild$timerTask$1 r6 = new OTextSwitcher$startAfterBuild$timerTask$1(this, r2, r0);
        TextSwitcherSpec r7 = this.oTextSwitcherSpec;
        long r8 = 0;
        if (r7 != null) goto L27;
    L26:
        long r9 = r8;
        TextSwitcherSpec r10 = this.oTextSwitcherSpec;
        if (r10 != null) goto L34;
    L33:
        long r11 = 1000;
    L49:
        Timer r12 = this.mOTextSwitcherTimer;     // Catch: Exception -> L46
        if (r12 == null) goto L44;
        if (r12 == null) goto L43;
        r12.cancel();     // Catch: Exception -> L46
    L43:
        this.mOTextSwitcherTimer = null;     // Catch: Exception -> L46
    L44:
        Timer r13 = new Timer();     // Catch: Exception -> L46
        this.mOTextSwitcherTimer = r13;     // Catch: Exception -> L46
        r13.schedule(r6, r9, r11);     // Catch: Exception -> L46
        Unit r14 = Unit.INSTANCE;     // Catch: Exception -> L46
        return;
    L46:
        e = move-exception;
        ToolsExtKt.printLog(Intrinsics.stringPlus("Try exception occur ", e.getMessage()));
        Unit r15 = Unit.INSTANCE;
        return;
    L34:
        TextSwitcherTriggerSpec r16 = r10.getTriggerSpec();
        if (r16 == null) goto L33;
        r11 = r16.getShowInternalMs();
        goto L49
    L27:
        TextSwitcherTriggerSpec r17 = r7.getTriggerSpec();
        if (r17 == null) goto L26;
        r8 = r17.getStartDelayMs();
        goto L26
    L5:
        TextSwitcherDataSpec r18 = r1.getDataSpec();
        if (r18 == null) goto L4;
        r2 = r18.getTextList();
        goto L9
    }

    /* JADX INFO: renamed from: startAfterBuild$lambda-11, reason: not valid java name */
    private static final void m554startAfterBuild$lambda11(ArrayList r1, OTextSwitcher r2) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Object r3 = r1.get(0);     // Catch: Exception -> L5
        Intrinsics.checkNotNullExpressionValue(r3, "dataArrayList[0]");     // Catch: Exception -> L5
        r2.setCurrentText((String) r3);     // Catch: Exception -> L5
        Unit r4 = Unit.INSTANCE;     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        ToolsExtKt.printLog(Intrinsics.stringPlus("Try exception occur ", e.getMessage()));
        Unit r5 = Unit.INSTANCE;
    }

    private final void safeUpdateText(String r2) {
        setText(r2);     // Catch: Exception -> L4
        Unit r1 = Unit.INSTANCE;     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        ToolsExtKt.printLog(Intrinsics.stringPlus("Try exception occur ", e.getMessage()));
        Unit r3 = Unit.INSTANCE;
    }

    @Override // com.obric.oui.textswitcher.IOTextSwitcher
    public void stopAnim() {
        this.hadStart = false;
        clearAnimation();     // Catch: Exception -> L9
        Timer r0 = this.mOTextSwitcherTimer;     // Catch: Exception -> L9
        if (r0 == null) goto L7;
        r0.cancel();     // Catch: Exception -> L9
    L7:
        this.mOTextSwitcherTimer = null;     // Catch: Exception -> L9
        Unit r2 = Unit.INSTANCE;     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        ToolsExtKt.printLog(Intrinsics.stringPlus("Try exception occur ", e.getMessage()));
        Unit r3 = Unit.INSTANCE;
    }
}
