package com.obric.oui.forms;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.CompletionInfo;
import androidx.appcompat.widget.AppCompatEditText;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.c.l;
import kotlin.n0.c.r;
import kotlin.n0.d.g;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0004\u0010\u0006\t\rB'\b\u0007\u0012\u0006\u0010S\u001a\u00020R\u0012\n\b\u0002\u0010U\u001a\u0004\u0018\u00010T\u0012\b\b\u0002\u0010V\u001a\u00020\f¢\u0006\u0004\bW\u0010XJ#\u0010\u0006\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0000¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\t\u001a\u00020\u00042\u0014\u0010\u0005\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u00040\u0002H\u0000¢\u0006\u0004\b\t\u0010\u0007J7\u0010\r\u001a\u00020\u00042&\u0010\u0005\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00040\nH\u0000¢\u0006\u0004\b\r\u0010\u000eJ%\u0010\u0010\u001a\u00020\u00042\u0014\u0010\u0005\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0004\u0012\u00020\u00040\u0002H\u0000¢\u0006\u0004\b\u0010\u0010\u0007J\u000f\u0010\u0012\u001a\u00020\u0011H\u0014¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0011H\u0014¢\u0006\u0004\b\u0014\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0011H\u0014¢\u0006\u0004\b\u0015\u0010\u0013J\u000f\u0010\u0016\u001a\u00020\u0011H\u0014¢\u0006\u0004\b\u0016\u0010\u0013J\u0019\u0010\u0019\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u001d\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0011\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016¢\u0006\u0004\b \u0010!J\u0019\u0010\"\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u001fH\u0016¢\u0006\u0004\b\"\u0010#J\u001f\u0010&\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020\fH\u0014¢\u0006\u0004\b&\u0010'J7\u0010-\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\f2\u0006\u0010*\u001a\u00020\f2\u0006\u0010+\u001a\u00020\f2\u0006\u0010,\u001a\u00020\fH\u0014¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\u0003H\u0016¢\u0006\u0004\b/\u00100J\u001f\u00103\u001a\u00020\u00042\u0006\u00101\u001a\u00020\f2\u0006\u00102\u001a\u00020\fH\u0014¢\u0006\u0004\b3\u0010'R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010B\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010D\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010AR$\u0010L\u001a\u0004\u0018\u00010E8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u0016\u0010N\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010AR\u0016\u0010P\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010AR\u0016\u0010Q\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010A¨\u0006Y"}, d2 = {"Lcom/obric/oui/forms/OEditText;", "Landroidx/appcompat/widget/AppCompatEditText;", "Lkotlin/Function1;", "", "Lkotlin/f0;", "action", "b", "(Lkotlin/n0/c/l;)V", "Landroid/view/MotionEvent;", "c", "Lkotlin/Function4;", "", "", "d", "(Lkotlin/n0/c/r;)V", "Landroid/text/Editable;", "a", "", "getLeftFadingEdgeStrength", "()F", "getRightFadingEdgeStrength", "getTopFadingEdgeStrength", "getBottomFadingEdgeStrength", "Landroid/view/View$OnTouchListener;", "l", "setOnTouchListener", "(Landroid/view/View$OnTouchListener;)V", "Landroid/view/inputmethod/CompletionInfo;", "text", "onCommitCompletion", "(Landroid/view/inputmethod/CompletionInfo;)V", "Landroid/view/View$OnFocusChangeListener;", "getOnFocusChangeListener", "()Landroid/view/View$OnFocusChangeListener;", "setOnFocusChangeListener", "(Landroid/view/View$OnFocusChangeListener;)V", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "changed", "left", "top", "right", "bottom", "onLayout", "(ZIIII)V", "performLongClick", "()Z", "selStart", "selEnd", "onSelectionChanged", "Lcom/obric/oui/forms/OEditText$b;", "f", "Lcom/obric/oui/forms/OEditText$b;", "onFocusChangeListenerWrapper", "Lcom/obric/oui/forms/OEditText$c;", "g", "Lcom/obric/oui/forms/OEditText$c;", "onTouchListenerWrapper", "Lcom/obric/oui/forms/OEditText$d;", "h", "Lcom/obric/oui/forms/OEditText$d;", "textWatcherWrapper", "m", "Z", "isBottomFading", "k", "isRightFading", "Lcom/obric/oui/forms/OEditText$a;", "i", "Lcom/obric/oui/forms/OEditText$a;", "getCommitCompletionListener", "()Lcom/obric/oui/forms/OEditText$a;", "setCommitCompletionListener", "(Lcom/obric/oui/forms/OEditText$a;)V", "commitCompletionListener", "n", "isPerformingLongClick", "j", "isLeftFading", "isTopFading", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OUI_standardRelease"}, k = 1, mv = {1, 1, 15})
public final class OEditText extends AppCompatEditText {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final b f11003f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final c f11004g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final d f11005h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private a f11006i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f11007j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f11008k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f11009l;
    private boolean m;
    private boolean n;

    public interface a {
        void a(CompletionInfo r1);
    }

    private static final class b implements View.OnFocusChangeListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private l<? super Boolean, f0> f11010f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private View.OnFocusChangeListener f11011g;

        public b() {
        }

        public final View.OnFocusChangeListener a() {
            return this.f11011g;
        }

        public final void b(l<? super Boolean, f0> r1) {
            this.f11010f = r1;
        }

        public final void c(View.OnFocusChangeListener r1) {
            this.f11011g = r1;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View r3, boolean r4) {
            l<? super Boolean, f0> r0 = this.f11010f;
            if (r0 == null) goto L5;
            f0 r1 = r0.invoke(Boolean.valueOf(r4));
        L5:
            View.OnFocusChangeListener r2 = this.f11011g;
            if (r2 == null) goto L9;
            r2.onFocusChange(r3, r4);
            return;
        }
    }

    private static final class c implements View.OnTouchListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private l<? super MotionEvent, f0> f11012f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private View.OnTouchListener f11013g;

        public c() {
        }

        public final void a(l<? super MotionEvent, f0> r1) {
            this.f11012f = r1;
        }

        public final void b(View.OnTouchListener r1) {
            this.f11013g = r1;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View r2, MotionEvent r3) {
            l<? super MotionEvent, f0> r0 = this.f11012f;
            if (r0 == null) goto L5;
            f0 r1 = r0.invoke(r3);
        L5:
            View.OnTouchListener r4 = this.f11013g;
            if (r4 != null) goto L10;
            return false;
        L10:
            return r4.onTouch(r2, r3);
        }
    }

    private static final class d implements TextWatcher {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private r<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, f0> f11014f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private r<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, f0> f11015g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private l<? super Editable, f0> f11016h;

        public d() {
        }

        public final void a(l<? super Editable, f0> r1) {
            this.f11016h = r1;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable r1) {
            l<? super Editable, f0> r0 = this.f11016h;
            if (r0 == null) goto L6;
            f0 r2 = r0.invoke(r1);
            return;
        }

        public final void b(r<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, f0> r1) {
            this.f11014f = r1;
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
            r<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, f0> r0 = this.f11015g;
            if (r0 == null) goto L6;
            f0 r5 = r0.invoke(r1, Integer.valueOf(r2), Integer.valueOf(r3), Integer.valueOf(r4));
            return;
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
            r<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, f0> r0 = this.f11014f;
            if (r0 == null) goto L6;
            f0 r5 = r0.invoke(r1, Integer.valueOf(r2), Integer.valueOf(r3), Integer.valueOf(r4));
            return;
        }
    }

    public OEditText(Context r7, AttributeSet r8) {
        this(r7, r8, 0, 4, null);
    }

    public OEditText(Context r2, AttributeSet r3, int r4) {
        o.f(r2, "context");
        super(r2, r3, r4);
        b r5 = new b();
        this.f11003f = r5;
        c r6 = new c();
        this.f11004g = r6;
        d r0 = new d();
        this.f11005h = r0;
        setOnFocusChangeListener(r5);
        super.setOnTouchListener(r6);
        addTextChangedListener(r0);
        setHighlightColor(r2.getColor(com.obric.common.oui.c.S));
    }

    public /* synthetic */ OEditText(Context r1, AttributeSet r2, int r3, int r4, g r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public final void a(l<? super Editable, f0> r2) {
        o.f(r2, "action");
        this.f11005h.a(r2);
    }

    public final void b(l<? super Boolean, f0> r2) {
        o.f(r2, "action");
        this.f11003f.b(r2);
    }

    public final void c(l<? super MotionEvent, f0> r2) {
        o.f(r2, "action");
        this.f11004g.a(r2);
    }

    public final void d(r<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, f0> r2) {
        o.f(r2, "action");
        this.f11005h.b(r2);
    }

    @Override // android.view.View
    protected float getBottomFadingEdgeStrength() {
        if (this.m == true) goto L7;
        return 0.0f;
    L7:
        return super.getBottomFadingEdgeStrength();
    }

    public final a getCommitCompletionListener() {
        return this.f11006i;
    }

    @Override // android.widget.TextView, android.view.View
    protected float getLeftFadingEdgeStrength() {
        if (this.f11007j == true) goto L7;
        return 0.0f;
    L7:
        return super.getLeftFadingEdgeStrength();
    }

    @Override // android.view.View
    public View.OnFocusChangeListener getOnFocusChangeListener() {
        View.OnFocusChangeListener r1 = super.getOnFocusChangeListener();
        if ((r1 instanceof b) == true) goto L5;
        return r1;
    L5:
        return ((b) r1).a();
    }

    @Override // android.widget.TextView, android.view.View
    protected float getRightFadingEdgeStrength() {
        if (this.f11008k == true) goto L7;
        return 0.0f;
    L7:
        return super.getRightFadingEdgeStrength();
    }

    @Override // android.view.View
    protected float getTopFadingEdgeStrength() {
        if (this.f11009l == true) goto L7;
        return 0.0f;
    L7:
        return super.getTopFadingEdgeStrength();
    }

    @Override // android.widget.TextView
    public void onCommitCompletion(CompletionInfo r1) {
        super.onCommitCompletion(r1);
        a r0 = this.f11006i;
        if (r0 == null) goto L6;
        r0.a(r1);
        return;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    @Override // android.widget.TextView
    protected void onSelectionChanged(int r1, int r2) {
        super.onSelectionChanged(r1, r2);
        if (r1 == r2) goto L5;
        boolean r3 = true;
    L7:
        if (this.n == true) goto L11;
        if (r3 == false) goto L12;
        d.g.d.d.a.b(getContext(), 3);
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r3 = false;
        goto L7
    }

    @Override // android.widget.TextView, android.view.View
    public boolean performLongClick() {
        this.n = true;
        boolean r0 = super.performLongClick();
        this.n = false;
        return r0;
    }

    public final void setCommitCompletionListener(a r1) {
        this.f11006i = r1;
    }

    @Override // android.view.View
    public void setOnFocusChangeListener(View.OnFocusChangeListener r2) {
        if ((r2 instanceof b) == false) goto L5;
        super.setOnFocusChangeListener(r2);
        return;
    L5:
        this.f11003f.c(r2);
    }

    @Override // android.view.View
    public void setOnTouchListener(View.OnTouchListener r1) {
        this.f11004g.b(r1);
    }
}
