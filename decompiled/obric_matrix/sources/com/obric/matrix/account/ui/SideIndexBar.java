package com.obric.matrix.account.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.i0.r;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 72\u00020\u0001:\u000278B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0014J(\u0010'\u001a\u00020$2\u0006\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u0007H\u0014J\u0010\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0016J\b\u00100\u001a\u00020-H\u0016J\u0014\u00101\u001a\u00020$2\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eJ\u0010\u00103\u001a\u00020\u00002\b\u00104\u001a\u0004\u0018\u00010\u0013J\u0010\u00105\u001a\u00020\u00002\b\u00106\u001a\u0004\u0018\u00010\u0015R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u00069"}, d2 = {"Lcom/obric/matrix/account/ui/SideIndexBar;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mCenterTextView", "Lcom/obric/matrix/account/ui/CenterTextView;", "mCurrentIndex", "mHeight", "mIndexItems", "", "", "mItemHeight", "", "mOnIndexChangedListener", "Lcom/obric/matrix/account/ui/SideIndexBar$OnIndexTouchedChangedListener;", "mOverlayTextView", "Landroid/widget/TextView;", "mPaint", "Landroid/graphics/Paint;", "mTextColor", "mTextSize", "mTextTouchedColor", "mTopMargin", "mTouchedPaint", "mWidth", "navigationBarHeight", "getNavigationBarHeight", "()I", "setNavigationBarHeight", "(I)V", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onSizeChanged", "w", "h", "oldw", "oldh", "onTouchEvent", "", NotificationCompat.CATEGORY_EVENT, "Landroid/view/MotionEvent;", "performClick", "setIndexItems", "mutableList", "setOnIndexChangedListener", "listener", "setOverlayTextView", "overlay", "Companion", "OnIndexTouchedChangedListener", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SideIndexBar extends View {
    private static final boolean u = false;
    private static final String[] v = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List<String> f8779f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f8780g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f8781h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f8782i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f8783j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f8784k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Paint f8785l;
    private final Paint m;
    private int n;
    private int o;
    private float p;
    private TextView q;
    private final CenterTextView r;
    private a s;
    private int t;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/obric/matrix/account/ui/SideIndexBar$OnIndexTouchedChangedListener;", "", "onIndexChanged", "", "index", "", "position", "", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface a {
        void a(String r1, int r2);
    }

    static {
        if (u == false) goto L5;
        String[] r0 = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "Y", "Z"};
    L6:
        v = r0;
        return;
    L5:
        r0 = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "J", "K", "L", "M", "N", "P", "R", "S", "T", "W", "X", "Y", "Z"};
        goto L6
    }

    public SideIndexBar(Context r8, AttributeSet r9) {
        kotlin.n0.d.o.f(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    public SideIndexBar(Context r4, AttributeSet r5, int r6) {
        kotlin.n0.d.o.f(r4, "context");
        new LinkedHashMap();
        super(r4, r5, r6);
        String[] r7 = v;
        this.f8779f = r.m(Arrays.copyOf(r7, r7.length));
        this.f8784k = -1;
        Paint r8 = new Paint(1);
        this.f8785l = r8;
        Paint r0 = new Paint(1);
        this.m = r0;
        this.f8781h = (int) TypedValue.applyDimension(2, 11.0f, r4.getResources().getDisplayMetrics());
        this.f8782i = ContextCompat.getColor(r4, com.obric.matrix.account.e.f8471b);
        this.f8783j = ContextCompat.getColor(r4, com.obric.matrix.account.e.f8470a);
        r8.setTextSize(this.f8781h);
        r8.setColor(this.f8782i);
        r0.setTextSize(this.f8781h);
        r0.setColor(this.f8783j);
    }

    public /* synthetic */ SideIndexBar(Context r1, AttributeSet r2, int r3, int r4, kotlin.n0.d.g r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public final SideIndexBar a(a r1) {
        this.s = r1;
        return this;
    }

    public final int getNavigationBarHeight() {
        return this.t;
    }

    @Override // android.view.View
    protected void onDraw(Canvas r10) {
        kotlin.n0.d.o.f(r10, "canvas");
        super.onDraw(r10);
        int r0 = this.f8779f.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L9;
        String r2 = this.f8779f.get(r1);
        Paint.FontMetrics r3 = this.f8785l.getFontMetrics();
        float r5 = 2;
        float r4 = (this.n - this.f8785l.measureText(r2)) / r5;
        float r6 = this.f8780g;
        float r8 = r3.bottom;
        float r7 = ((((r6 / r5) + ((r8 - r3.top) / r5)) - r8) + (r6 * r1)) + this.p;
        if (r1 != this.f8784k) goto L7;
        Paint r9 = this.m;
    L8:
        r10.drawText(r2, r4, r7, r9);
        r1 = r1 + 1;
        goto L3
    L7:
        r9 = this.f8785l;
        goto L8
    }

    @Override // android.view.View
    protected void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        this.n = getWidth();
        if (Math.abs(r2 - r4) == this.t) goto L6;
        r2 = kotlin.r0.e.c(getHeight(), r4);
    L6:
        this.o = r2;
        float r5 = r2 / this.f8779f.size();
        this.f8780g = r5;
        this.p = (this.o - (r5 * this.f8779f.size())) / 2;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r5) {
        kotlin.n0.d.o.f(r5, NotificationCompat.CATEGORY_EVENT);
        performClick();
        int r0 = r5.getAction();
        if (r0 == 0) goto L19;
        if (r0 != 1) goto L6;
    L10:
        this.f8784k = -1;
        TextView r6 = this.q;
        if (r6 == null) goto L14;
        r6.setVisibility(8);
    L14:
        CenterTextView r7 = this.r;
        if (r7 == null) goto L18;
        r7.setVisibility(8);
    L18:
        invalidate();
    L40:
        return true;
    L6:
        if (r0 == 2) goto L19;
        if (r0 == 3) goto L10;
    L19:
        float r8 = r5.getY();
        int r1 = this.f8779f.size();
        int r9 = (int) (r8 / this.f8780g);
        if (r9 >= 0) goto L22;
        r9 = 0;
    L25:
        if (this.s == null) goto L40;
        if (r9 < 0) goto L40;
        if (r9 >= r1) goto L40;
        if (r9 == this.f8784k) goto L40;
        this.f8784k = r9;
        String r2 = this.f8779f.get(r9);
        TextView r3 = this.q;
        if (r3 == null) goto L33;
        r3.setVisibility(0);
        r3.setText(r2);
    L33:
        CenterTextView r4 = this.r;
        if (r4 == null) goto L36;
        r4.setVisibility(0);
        r4.setText(r2);
    L36:
        a r10 = this.s;
        if (r10 == null) goto L39;
        r10.a(r2, r9);
    L39:
        invalidate();
        goto L40
    L22:
        if (r9 < r1) goto L25;
        r9 = r1 - 1;
        goto L25
    }

    @Override // android.view.View
    public boolean performClick() {
        return super.performClick();
    }

    public final void setIndexItems(List<String> r2) {
        kotlin.n0.d.o.f(r2, "mutableList");
        this.f8779f = r2;
    }

    public final void setNavigationBarHeight(int r1) {
        this.t = r1;
    }
}
