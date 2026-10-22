package com.obric.oui.indexscrollbar;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.app.NotificationCompat;
import com.obric.common.oui.c;
import com.obric.common.oui.d;
import com.obric.common.oui.e;
import com.obric.oui.common.util.f;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.n0.d.g;
import kotlin.n0.d.o;
import kotlin.u0.k;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002C9B,\b\u0007\u0012\u0006\u0010(\u001a\u00020'\u0012\f\b\u0002\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0085\u0001\u0012\t\b\u0002\u0010\u0087\u0001\u001a\u00020\u001a¢\u0006\u0006\b\u0088\u0001\u0010\u0089\u0001J\u001d\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\u000b\u001a\u00020\u00052\u0010\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0011¢\u0006\u0004\b\u0016\u0010\u0014J\u0017\u0010\u0018\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001aH\u0014¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b!\u0010\"J\u0017\u0010%\u001a\u00020\u00052\u0006\u0010$\u001a\u00020#H\u0014¢\u0006\u0004\b%\u0010&J\u0017\u0010)\u001a\u00020\u00052\u0006\u0010(\u001a\u00020'H\u0002¢\u0006\u0004\b)\u0010*J\u001f\u0010.\u001a\u00020\u00052\u0006\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020\u001aH\u0002¢\u0006\u0004\b.\u0010/J\u0017\u00101\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u001aH\u0002¢\u0006\u0004\b1\u00102J/\u0010-\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020#2\u0006\u00104\u001a\u0002032\u0006\u00105\u001a\u000203H\u0002¢\u0006\u0004\b-\u00106J/\u00107\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020#2\u0006\u00104\u001a\u0002032\u0006\u00105\u001a\u000203H\u0002¢\u0006\u0004\b7\u00106J/\u00108\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020#2\u0006\u00104\u001a\u0002032\u0006\u00105\u001a\u000203H\u0002¢\u0006\u0004\b8\u00106J/\u00109\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020#2\u0006\u00104\u001a\u0002032\u0006\u00105\u001a\u000203H\u0002¢\u0006\u0004\b9\u00106J\u0017\u0010;\u001a\u00020\u001a2\u0006\u0010:\u001a\u00020\u001aH\u0002¢\u0006\u0004\b;\u0010<J/\u0010A\u001a\u0002032\u0006\u0010=\u001a\u00020\u001a2\u0016\u0010@\u001a\u0012\u0012\u0004\u0012\u00020\u001a0>j\b\u0012\u0004\u0012\u00020\u001a`?H\u0002¢\u0006\u0004\bA\u0010BJ\u001f\u0010C\u001a\u0012\u0012\u0004\u0012\u00020\u001a0>j\b\u0012\u0004\u0012\u00020\u001a`?H\u0002¢\u0006\u0004\bC\u0010DJ\u0017\u0010E\u001a\u00020\u00112\u0006\u00100\u001a\u00020\u001aH\u0002¢\u0006\u0004\bE\u0010FJ\u0017\u0010G\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u001aH\u0002¢\u0006\u0004\bG\u00102R\u0016\u0010J\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010M\u001a\u00020\u00118B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bK\u0010LR\u0016\u0010O\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010IR\u001e\u0010Q\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010PR\u0016\u0010R\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010IR\u0016\u0010V\u001a\u00020S8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010X\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010IR\"\u0010]\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bY\u0010I\u001a\u0004\bZ\u0010[\"\u0004\b\\\u00102R\u0016\u0010_\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b^\u0010IR\u0016\u0010a\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b`\u0010IR\u0016\u0010c\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010bR\u0016\u0010g\u001a\u00020d8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\be\u0010fR\u0016\u0010i\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bh\u0010IR\"\u0010m\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bj\u0010I\u001a\u0004\bk\u0010[\"\u0004\bl\u00102R\u0018\u0010p\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bn\u0010oR\u0016\u0010r\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bq\u0010IR\u0018\u0010u\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bs\u0010tR\u0016\u0010v\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010IR\u0016\u0010x\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bw\u0010bR\u0018\u0010z\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010yR\u0016\u0010|\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b{\u0010IR\u0018\u0010\u007f\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b}\u0010~R\"\u0010\u0081\u0001\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b;\u0010\u0080\u0001R\u001b\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0082\u0001\u0010\u0083\u0001¨\u0006\u008a\u0001"}, d2 = {"Lcom/obric/oui/indexscrollbar/LettersBar;", "Landroid/view/View;", "", "Lcom/obric/oui/indexscrollbar/a;", "letters", "Lkotlin/f0;", "setLetters", "(Ljava/util/List;)V", "", "Landroid/graphics/Bitmap;", "bitmaps", "setBitmapsSelected", "([Landroid/graphics/Bitmap;)V", "Lcom/obric/oui/indexscrollbar/LettersBar$a;", "listener", "setListener", "(Lcom/obric/oui/indexscrollbar/LettersBar$a;)V", "", "settled", "setSettled", "(Z)V", "showBg", "setShowBg", "Lcom/obric/oui/indexscrollbar/LettersBar$b;", "setOnBackgroundVisibleChangedListener", "(Lcom/obric/oui/indexscrollbar/LettersBar$b;)V", "", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "Landroid/view/MotionEvent;", NotificationCompat.CATEGORY_EVENT, "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "Landroid/content/Context;", "context", "g", "(Landroid/content/Context;)V", "", "scene", "c", "k", "(Ljava/lang/String;I)V", "index", "setLetterPaint", "(I)V", "", "xPos", "yPos", "(ILandroid/graphics/Canvas;FF)V", "e", "d", "b", "measureSpec", "j", "(I)I", "totalHeight", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "visibleLetters", "f", "(ILjava/util/ArrayList;)F", "a", "()Ljava/util/ArrayList;", "i", "(I)Z", "setTouchedLetter", "q", "I", "mLetterBarMargin", "h", "()Z", "isHolderState", "p", "mLetterBarHeight", "Ljava/util/List;", "mLetters", "mLettersBarWidth", "Lcom/obric/oui/indexscrollbar/b;", "z", "Lcom/obric/oui/indexscrollbar/b;", "mPopupWindow", "m", "mLetterFontSize", "s", "getMHasChosenLetterFontColor", "()I", "setMHasChosenLetterFontColor", "mHasChosenLetterFontColor", BaseSwitches.V, "mDotIconX", "o", "mLetterFontCenterX", "Z", "mSettled", "Landroid/graphics/Paint;", "r", "Landroid/graphics/Paint;", "mLetterPaint", "A", "mScreenWidth", "t", "getMNoChosenLetterFontColor", "setMNoChosenLetterFontColor", "mNoChosenLetterFontColor", "w", "Lcom/obric/oui/indexscrollbar/LettersBar$a;", "mListener", "n", "mLetterLocaleFontSize", "u", "Landroid/graphics/Bitmap;", "mDotIcon", "mChosenLetterIndex", "x", "mShowBg", "Landroid/content/Context;", "mContext", "l", "mSingleLetterMinHeight", "B", "Ljava/lang/String;", "lastPopupLetter", "[Landroid/graphics/Bitmap;", "mIconsForSymbolsSelected", "y", "Lcom/obric/oui/indexscrollbar/LettersBar$b;", "mBackgroundChangeListener", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OUI_standardRelease"}, k = 1, mv = {1, 1, 15})
public final class LettersBar extends View {
    private int A;
    private String B;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Context f11062f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private List<com.obric.oui.indexscrollbar.a> f11063g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f11064h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f11065i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Bitmap[] f11066j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f11067k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f11068l;
    private int m;
    private int n;
    private int o;
    private int p;
    private int q;
    private final Paint r;
    private int s;
    private int t;
    private Bitmap u;
    private int v;
    private a w;
    private boolean x;
    private b y;
    private final com.obric.oui.indexscrollbar.b z;

    public interface a {
        boolean a(String r1);
    }

    public interface b {
        void a(boolean r1);
    }

    static {
    }

    public LettersBar(Context r7, AttributeSet r8) {
        this(r7, r8, 0, 4, null);
    }

    public LettersBar(Context r2, AttributeSet r3, int r4) {
        o.f(r2, "context");
        super(r2, r3, r4);
        this.f11064h = -1;
        this.f11065i = true;
        this.r = new Paint();
        this.z = new com.obric.oui.indexscrollbar.b(r2, null, 2, null);
        g(r2);
    }

    public /* synthetic */ LettersBar(Context r1, AttributeSet r2, int r3, int r4, g r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    private final ArrayList<Integer> a() {
        ArrayList<Integer> r0 = new ArrayList();
        int r1 = this.p;
        List<com.obric.oui.indexscrollbar.a> r2 = this.f11063g;
        o.c(r2);
        if ((r1 / r2.size()) >= this.f11068l) goto L5;
        List<com.obric.oui.indexscrollbar.a> r4 = this.f11063g;
        o.c(r4);
        int r3 = (int) Math.max(2.0d, ((int) Math.ceil(r4.size() / ((this.p / this.f11068l) - 2))) * 2);
    L6:
        r0.add(0);
        List<com.obric.oui.indexscrollbar.a> r5 = this.f11063g;
        o.c(r5);
        if (r3 >= (r5.size() / 2)) goto L12;
        int r6 = r3;
    L9:
        List<com.obric.oui.indexscrollbar.a> r7 = this.f11063g;
        o.c(r7);
        if (r6 >= (r7.size() - 1)) goto L12;
        r0.add(Integer.valueOf(r6));
        r6 = r6 + r3;
    L12:
        List<com.obric.oui.indexscrollbar.a> r8 = this.f11063g;
        o.c(r8);
        if (r3 >= r8.size()) goto L15;
        List<com.obric.oui.indexscrollbar.a> r9 = this.f11063g;
        o.c(r9);
        r0.add(Integer.valueOf(r9.size() - 1));
    L15:
        return r0;
    L5:
        r3 = 1;
        goto L6
    }

    private final void b(int r1, Canvas r2, float r3, float r4) {
        Bitmap r5 = this.u;
        o.c(r5);
        float r6 = r4 - (r5.getHeight() / 2);
        Bitmap r7 = this.u;
        o.c(r7);
        r2.drawBitmap(r7, this.v, r6, null);
    }

    private final void c(int r4, Canvas r5, float r6, float r7) {
        if (i(r4) == true) goto L5;
        return;
    L5:
        if (this.f11065i == false) goto L9;
        Paint r8 = new Paint();
        Context r9 = getContext();
        o.e(r9, "context");
        r8.setColor(r9.getResources().getColor(c.u));
        int r0 = f.a(14);
        f.a(14);
        float r10 = r0 / 2.0f;
        int r3 = this.o;
        r5.drawRoundRect(new RectF(r3 - r10, r7 - r10, r3 + r10, r7 + r10), r10, r10, r8);
        return;
    }

    private final void d(int r6, Canvas r7, float r8, float r9) {
        List<com.obric.oui.indexscrollbar.a> r0 = this.f11063g;
        o.c(r0);
        String r1 = r0.get(r6).a();
        if (k.A(r1, ".", false, 2, null) == false) goto L5;
        b(r6, r7, r8, r9);
        return;
    L5:
        Paint.FontMetricsInt r10 = this.r.getFontMetricsInt();
        int r2 = r10.bottom;
        int r11 = r10.top;
        r7.drawText(r1, r8, (r9 - ((r2 - r11) / 2)) - r11, this.r);
    }

    private final void e(int r6, Canvas r7, float r8, float r9) {
        List<com.obric.oui.indexscrollbar.a> r10 = this.f11063g;
        o.c(r10);
        Bitmap[] r11 = r10.get(r6).b();
        o.c(r11);
        if (i(r6) == true) goto L5;
    L7:
        boolean r12 = false;
    L9:
        if (h() == false) goto L11;
    L14:
        boolean r2 = true;
    L16:
        if (r12 == false) goto L19;
        Bitmap r13 = r11[2];
        o.c(r13);
        int r14 = r13.getHeight();
        Bitmap r0 = r11[2];
        o.c(r0);
        float r5 = this.o - (r0.getWidth() / 2);
        Bitmap r15 = r11[2];
    L18:
        o.c(r15);
        r7.drawBitmap(r15, r5, r9 - (r14 / 2), null);
        return;
    L19:
        if (r2 == false) goto L21;
        Bitmap r16 = r11[1];
        o.c(r16);
        r14 = r16.getHeight();
        Bitmap r1 = r11[1];
        o.c(r1);
        r5 = this.o - (r1.getWidth() / 2);
        r15 = r11[1];
        goto L18
    L21:
        Bitmap r17 = r11[0];
        o.c(r17);
        r14 = r17.getHeight();
        Bitmap r3 = r11[0];
        o.c(r3);
        r5 = this.o - (r3.getWidth() / 2);
        r15 = r11[0];
        goto L18
    L11:
        if (this.f11065i == false) goto L14;
        r2 = false;
        goto L16
    L5:
        if (this.f11065i == false) goto L7;
        r12 = true;
        goto L9
    }

    private final float f(int r3, ArrayList<Integer> r4) {
        return (float) Math.max(r3 / r4.size(), this.f11068l);
    }

    private final void g(Context r4) {
        this.f11062f = r4;
        o.c(r4);
        Resources r0 = r4.getResources();
        this.f11068l = r0.getDimensionPixelSize(d.f8217d);
        this.f11067k = f.a(24);
        this.m = r0.getDimensionPixelOffset(d.f8215b);
        this.n = r0.getDimensionPixelOffset(d.f8216c);
        this.o = this.f11067k / 2;
        int r1 = e.f8228c;
        BitmapFactory.decodeResource(r0, r1);
        Drawable r2 = r0.getDrawable(r1);
        o.e(r2, "iconDrawable");
        int r3 = r2.getIntrinsicWidth() / 2;
        r2.getIntrinsicHeight();
        this.q = (int) r0.getDimension(d.f8214a);
        int r5 = c.Q;
        this.s = r0.getColor(r5);
        this.t = r0.getColor(r5);
        Bitmap r6 = BitmapFactory.decodeResource(r0, e.f8227b);
        this.u = r6;
        int r7 = this.o;
        o.c(r6);
        this.v = r7 - (r6.getWidth() / 2);
        this.r.setTypeface(Typeface.DEFAULT_BOLD);
        this.r.setTextSize(this.m);
        this.r.setAntiAlias(true);
        Resources r8 = r4.getResources();
        o.e(r8, "context.resources");
        this.A = r8.getDisplayMetrics().widthPixels;
    }

    private final boolean h() {
        if (this.f11064h == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    private final boolean i(int r1) {
        if (this.f11064h != r1) goto L5;
        return true;
    L5:
        return false;
    }

    private final int j(int r2) {
        int r1 = View.MeasureSpec.getMode(r2);
        int r3 = View.MeasureSpec.getSize(r2);
        if (r1 != Integer.MIN_VALUE) goto L6;
        return r3;
    L6:
        if (r1 == 1073741824) goto L11;
        return 0;
    L11:
        return r3;
    }

    private final void k(String r11, int r12) {
        float r0 = f(this.p, a());
        List<com.obric.oui.indexscrollbar.a> r1 = this.f11063g;
        o.c(r1);
        String r2 = r1.get(r12).a();
        if (o.a(r2, this.B) == false) goto L5;
        return;
    L5:
        d.g.d.f.f.b.a("LettersBar", "showPopupWindow, scene: " + r11 + ", c = " + r12 + ", letter = " + r2 + ", lastPopupLetter = " + this.B);
        Bitmap[] r13 = this.f11066j;
        Bitmap r3 = null;
        if (r13 == null) goto L8;
        Integer r14 = Integer.valueOf(r13.length);
    L9:
        List<com.obric.oui.indexscrollbar.a> r4 = this.f11063g;
        o.c(r4);
        if (r4.get(r12).c() != 2) goto L15;
        if (r14 == null) goto L15;
        if (Integer.parseInt(r2) > r14.intValue()) goto L15;
        Bitmap[] r15 = this.f11066j;
        o.c(r15);
        r3 = r15[Integer.parseInt(r2) - 1];
    L15:
        int r16 = getResources().getDimensionPixelSize(d.f8220g);
        int r5 = ((this.A - getWidth()) - f.a(24)) - f.a(18);
        int r6 = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (r6 <= 0) goto L18;
        r16 = r16 + getResources().getDimensionPixelSize(r6);
    L18:
        int[] r7 = new int[2];
        getLocationInWindow(r7);
        this.z.b(r2, r3, r5, Math.max((int) ((r0 * (r12 - 1)) + r7[1]), r16));
        this.B = r2;
        return;
    L8:
        r14 = null;
        goto L9
    }

    private final void setLetterPaint(int r7) {
        if (i(r7) == true) goto L5;
    L9:
        Paint r0 = this.r;
        if (h() == false) goto L12;
    L7:
        int r5 = this.s;
    L8:
        r0.setColor(r5);
        this.r.setFakeBoldText(false);
        Paint r1 = this.r;
        Resources r6 = Resources.getSystem();
        o.e(r6, "Resources.getSystem()");
        r1.setTextSize(TypedValue.applyDimension(1, 10, r6.getDisplayMetrics()));
        List<com.obric.oui.indexscrollbar.a> r2 = this.f11063g;
        o.c(r2);
        if (k.A(r2.get(r7).a(), ".", false, 2, null) == true) goto L22;
        List<com.obric.oui.indexscrollbar.a> r3 = this.f11063g;
        o.c(r3);
        if (r3.get(r7).c() != 1) goto L20;
        this.r.setTextSize(this.n);
        this.r.setFakeBoldText(true);
        return;
    L20:
        this.r.setTextSize(this.m);
        return;
    L22:
        return;
    L12:
        if (this.f11065i == false) goto L7;
        r5 = this.t;
        goto L8
    L5:
        if (this.f11065i == false) goto L9;
        r0 = this.r;
        goto L7
    }

    private final void setTouchedLetter(int r1) {
        this.f11064h = r1;
        invalidate();
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent r7) {
        o.f(r7, NotificationCompat.CATEGORY_EVENT);
        super.dispatchTouchEvent(r7);
        int r0 = r7.getAction();
        float r8 = r7.getY();
        int r1 = this.f11064h;
        float r9 = (r8 - getPaddingTop()) / ((getHeight() - getPaddingTop()) - getPaddingBottom());
        List<com.obric.oui.indexscrollbar.a> r2 = this.f11063g;
        o.c(r2);
        int r10 = (int) (r9 * r2.size());
        if (r0 != 0) goto L5;
        this.B = null;
        if (r1 == r10) goto L42;
        if (r10 < 0) goto L42;
        List<com.obric.oui.indexscrollbar.a> r3 = this.f11063g;
        o.c(r3);
        if (r10 >= r3.size()) goto L42;
        k("ACTION_DOWN", r10);
    L41:
        setTouchedLetter(r10);
    L42:
        setShowBg(false);
    L43:
        return true;
    L5:
        if (r0 == 1) goto L24;
        if (r0 == 2) goto L13;
        if (r0 != 3) goto L43;
        this.z.a();
        setTouchedLetter(-1);
        goto L43
    L13:
        if (this.f11065i == false) goto L42;
        if (r1 == r10) goto L42;
        if (this.w == null) goto L42;
        if (r10 < 0) goto L42;
        List<com.obric.oui.indexscrollbar.a> r4 = this.f11063g;
        o.c(r4);
        if (r10 >= r4.size()) goto L42;
        k("ACTION_MOVE", r10);
        a r5 = this.w;
        o.c(r5);
        List<com.obric.oui.indexscrollbar.a> r6 = this.f11063g;
        o.c(r6);
        if (r5.a(r6.get(r10).a()) == false) goto L42;
    L24:
        if (this.f11065i == true) goto L26;
    L34:
        this.z.a();
        invalidate();
        goto L43
    L26:
        if (this.w == null) goto L33;
        if (r10 < 0) goto L33;
        List<com.obric.oui.indexscrollbar.a> r11 = this.f11063g;
        o.c(r11);
        if (r10 >= r11.size()) goto L33;
        a r12 = this.w;
        o.c(r12);
        List<com.obric.oui.indexscrollbar.a> r13 = this.f11063g;
        o.c(r13);
        if (r12.a(r13.get(r10).a()) == false) goto L33;
        setTouchedLetter(r10);
    L33:
        this.z.a();
        setTouchedLetter(-1);
        setShowBg(false);
        goto L34
    }

    public final int getMHasChosenLetterFontColor() {
        return this.s;
    }

    public final int getMNoChosenLetterFontColor() {
        return this.t;
    }

    @Override // android.view.View
    protected void onDraw(Canvas r10) {
        o.f(r10, "canvas");
        super.onDraw(r10);
        r10.save();
        r10.translate(0.0f, getPaddingTop());
        ArrayList<Integer> r0 = a();
        float r1 = f(this.p, r0);
        Iterator<Integer> r2 = r0.iterator();
        int r3 = 0;
    L4:
        if (r2.hasNext() == false) goto L10;
        Integer r4 = r2.next();
        o.e(r4, "index");
        setLetterPaint(r4.intValue());
        float r5 = this.o;
        Paint r6 = this.r;
        List<com.obric.oui.indexscrollbar.a> r7 = this.f11063g;
        o.c(r7);
        float r8 = 2;
        float r9 = r5 - (r6.measureText(r7.get(r4.intValue()).a()) / r8);
        float r11 = ((r3 * r1) + (r1 / r8)) + this.q;
        c(r4.intValue(), r10, r9, r11);
        List<com.obric.oui.indexscrollbar.a> r12 = this.f11063g;
        o.c(r12);
        int r13 = r12.get(r4.intValue()).c();
        int r14 = r4.intValue();
        if (r13 != 2) goto L8;
        e(r14, r10, r9, r11);
    L9:
        r3 = r3 + 1;
        goto L4
    L8:
        d(r14, r10, r9, r11);
        goto L9
    L10:
        r10.restore();
    }

    @Override // android.view.View
    protected void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
        this.p = ((j(r2) - (this.q * 2)) - getPaddingTop()) - getPaddingBottom();
    }

    public final void setBitmapsSelected(Bitmap[] r1) {
        this.f11066j = r1;
    }

    public final void setLetters(List<com.obric.oui.indexscrollbar.a> r1) {
        this.f11063g = r1;
    }

    public final void setListener(a r1) {
        this.w = r1;
    }

    public final void setMHasChosenLetterFontColor(int r1) {
        this.s = r1;
    }

    public final void setMNoChosenLetterFontColor(int r1) {
        this.t = r1;
    }

    public final void setOnBackgroundVisibleChangedListener(b r1) {
        this.y = r1;
    }

    public final void setSettled(boolean r1) {
        this.f11065i = r1;
        if (r1 == false) goto L5;
        setTouchedLetter(-1);
    L5:
        invalidate();
    }

    public final void setShowBg(boolean r2) {
        if (this.x == r2) goto L12;
        this.x = r2;
        if (r2 == false) goto L7;
        Drawable r3 = getResources().getDrawable(e.f8226a);
    L8:
        setBackground(r3);
        b r4 = this.y;
        if (r4 == null) goto L13;
        o.c(r4);
        r4.a(this.x);
        return;
    L13:
        return;
    L7:
        r3 = null;
        goto L8
    }
}
