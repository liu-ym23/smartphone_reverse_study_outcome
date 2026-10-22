package com.obric.oui.picker.reels.views;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.common.oui.k;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.h;
import kotlin.i;
import kotlin.i0.r;
import kotlin.n0.d.o;
import kotlin.n0.d.q;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\r\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010!\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B#\b\u0007\u0012\b\u0010²\u0001\u001a\u00030±\u0001\u0012\f\b\u0002\u0010´\u0001\u001a\u0005\u0018\u00010³\u0001¢\u0006\u0006\bµ\u0001\u0010¶\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0013\u0010\tJ\r\u0010\u0014\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0015J\u0017\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0017\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00022\b\b\u0002\u0010\u001b\u001a\u00020\u0010¢\u0006\u0004\b\u001c\u0010\u001dJ!\u0010 \u001a\u00020\u00052\u0012\u0010\u001f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00180\u001e\"\u00020\u0018¢\u0006\u0004\b \u0010!J\u001d\u0010 \u001a\u00020\u00052\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\"¢\u0006\u0004\b \u0010#J\u0015\u0010&\u001a\u00020\u00052\u0006\u0010%\u001a\u00020$¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u0005H\u0002¢\u0006\u0004\b(\u0010\tJ\u0017\u0010)\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b)\u0010\rJ\u0017\u0010*\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b*\u0010\rJ'\u0010,\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010+\u001a\u00020\u0002H\u0002¢\u0006\u0004\b,\u0010-J\u0019\u0010.\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0017\u001a\u00020\u0002H\u0002¢\u0006\u0004\b.\u0010\u001aJ\u0017\u0010/\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b/\u0010\rJ\u0017\u00100\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b0\u0010\rR\u0015\u00103\u001a\u0004\u0018\u00010\u00188F@\u0006¢\u0006\u0006\u001a\u0004\b1\u00102R*\u0010:\u001a\u00020\u00102\u0006\u00104\u001a\u00020\u00108\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R*\u0010A\u001a\u00020\u00022\u0006\u0010;\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010\u0015\"\u0004\b?\u0010@R\u0018\u0010E\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\"\u0010I\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bF\u00105\u001a\u0004\bG\u00107\"\u0004\bH\u00109R\u001d\u0010O\u001a\u00020J8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bK\u0010L\u001a\u0004\bM\u0010NR\u0013\u0010Q\u001a\u00020\u00028F@\u0006¢\u0006\u0006\u001a\u0004\bP\u0010\u0015R\u001d\u0010T\u001a\u00020J8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bR\u0010L\u001a\u0004\bS\u0010NR$\u0010X\u001a\u00020\u00022\u0006\u0010U\u001a\u00020\u00028F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bV\u0010\u0015\"\u0004\bW\u0010@R$\u0010[\u001a\u00020\u00022\u0006\u0010U\u001a\u00020\u00028F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bY\u0010\u0015\"\u0004\bZ\u0010@R\u0016\u0010]\u001a\u00020\u00028B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\\\u0010\u0015R$\u0010`\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00028F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b^\u0010\u0015\"\u0004\b_\u0010@R\"\u0010d\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\ba\u00105\u001a\u0004\bb\u00107\"\u0004\bc\u00109R\"\u0010h\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\be\u00105\u001a\u0004\bf\u00107\"\u0004\bg\u00109R$\u0010o\u001a\u00020i2\u0006\u0010j\u001a\u00020i8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR\u0018\u0010q\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010DR\u001d\u0010v\u001a\u00020r8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bs\u0010L\u001a\u0004\bt\u0010uR*\u0010z\u001a\u00020\u00102\u0006\u0010w\u001a\u00020\u00108\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bx\u00105\u001a\u0004\b<\u00107\"\u0004\by\u00109R$\u0010}\u001a\u00020\u00022\u0006\u0010U\u001a\u00020\u00028F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b{\u0010\u0015\"\u0004\b|\u0010@R%\u0010\u0080\u0001\u001a\u00020i2\u0006\u0010j\u001a\u00020i8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b~\u0010l\"\u0004\b\u007f\u0010nR \u0010\u0083\u0001\u001a\u00020r8B@\u0002X\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b\u0081\u0001\u0010L\u001a\u0005\b\u0082\u0001\u0010uR.\u0010\u0087\u0001\u001a\u00020\u00022\u0007\u0010\u0084\u0001\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0014\n\u0004\b\u001c\u0010=\u001a\u0005\b\u0085\u0001\u0010\u0015\"\u0005\b\u0086\u0001\u0010@R \u0010\u008a\u0001\u001a\u00020J8B@\u0002X\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b\u0088\u0001\u0010L\u001a\u0005\b\u0089\u0001\u0010NR\"\u0010\u008f\u0001\u001a\u00030\u008b\u00018B@\u0002X\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u008c\u0001\u0010L\u001a\u0006\b\u008d\u0001\u0010\u008e\u0001R0\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u0090\u00012\n\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u0090\u00018F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b\u0092\u0001\u0010\u0093\u0001\"\u0006\b\u0094\u0001\u0010\u0095\u0001R-\u0010\u0098\u0001\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0014\n\u0004\b.\u0010=\u001a\u0005\b\u0096\u0001\u0010\u0015\"\u0005\b\u0097\u0001\u0010@R\u0019\u0010\u0099\u0001\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010DR \u0010\u009d\u0001\u001a\t\u0012\u0004\u0012\u00020\u00180\u009a\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009b\u0001\u0010\u009c\u0001R/\u0010¢\u0001\u001a\u00020\u00022\u0007\u0010\u009e\u0001\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0015\n\u0005\b\u009f\u0001\u0010=\u001a\u0005\b \u0001\u0010\u0015\"\u0005\b¡\u0001\u0010@R\u0018\u0010¤\u0001\u001a\u00020\u00028B@\u0002X\u0082\u0004¢\u0006\u0007\u001a\u0005\b£\u0001\u0010\u0015R\u001b\u0010§\u0001\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¥\u0001\u0010¦\u0001R&\u0010«\u0001\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b¨\u0001\u00105\u001a\u0005\b©\u0001\u00107\"\u0005\bª\u0001\u00109R/\u0010°\u0001\u001a\u00020\u00022\u0007\u0010¬\u0001\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0015\n\u0005\b\u00ad\u0001\u0010=\u001a\u0005\b®\u0001\u0010\u0015\"\u0005\b¯\u0001\u0010@¨\u0006·\u0001"}, d2 = {"Lcom/obric/oui/picker/reels/views/WheelView;", "Landroid/view/View;", "", "widthMeasureSpec", "heightMeasureSpec", "Lkotlin/f0;", "onMeasure", "(II)V", "onAttachedToWindow", "()V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "Landroid/view/MotionEvent;", NotificationCompat.CATEGORY_EVENT, "", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "computeScroll", "getClipMiddleRectTop", "()I", "getClipMiddleRectBottom", "index", "", "f", "(I)Ljava/lang/String;", "animated", "i", "(IZ)V", "", "entries", "setEntries", "([Ljava/lang/String;)V", "", "(Ljava/util/List;)V", "", LocationMonitorConst.TAG, "setTagText", "(Ljava/lang/CharSequence;)V", "k", "e", "d", TypedValues.CycleType.S_WAVE_OFFSET, "c", "(Landroid/graphics/Canvas;II)V", "g", "b", "a", "getCurrentItem", "()Ljava/lang/String;", "currentItem", "isShow", "Z", "getShowDivider", "()Z", "setShowDivider", "(Z)V", "showDivider", "count", "h", "I", "getItemCount", "setItemCount", "(I)V", "itemCount", "Landroid/graphics/Rect;", "m", "Landroid/graphics/Rect;", "mClipRectBottom", "A", "getShowBottomRightCorner", "setShowBottomRightCorner", "showBottomRightCorner", "Landroid/text/TextPaint;", "o", "Lkotlin/h;", "getMTagTextPaint", "()Landroid/text/TextPaint;", "mTagTextPaint", "getItemSize", "itemSize", "p", "getMSelectedTextPaint", "mSelectedTextPaint", TypedValues.Custom.S_COLOR, "getTextColor", "setTextColor", "textColor", "getSelectedTextColor", "setSelectedTextColor", "selectedTextColor", "getWheelWidth", "wheelWidth", "getCurrentIndex", "setCurrentIndex", "currentIndex", "y", "getShowTopRightCorner", "setShowTopRightCorner", "showTopRightCorner", "z", "getShowBottomLeftCorner", "setShowBottomLeftCorner", "showBottomLeftCorner", "", "size", "getTextSizePx", "()F", "setTextSizePx", "(F)V", "textSizePx", "l", "mClipRectMiddle", "Landroid/graphics/Paint;", "q", "getMDividerPaint", "()Landroid/graphics/Paint;", "mDividerPaint", "cyclic", "w", "setCyclic", "isCyclic", "getHighlightColor", "setHighlightColor", "highlightColor", "getSelectedTextSizePx", "setSelectedTextSizePx", "selectedTextSizePx", "r", "getMHighlightPaint", "mHighlightPaint", "width", "getItemWidthPx", "setItemWidthPx", "itemWidthPx", "n", "getMTextPaint", "mTextPaint", "Lcom/obric/oui/picker/reels/views/d;", "s", "getMScroller", "()Lcom/obric/oui/picker/reels/views/d;", "mScroller", "Lcom/obric/oui/picker/reels/views/a;", "onWheelChangedListener", "getOnWheelChangedListener", "()Lcom/obric/oui/picker/reels/views/a;", "setOnWheelChangedListener", "(Lcom/obric/oui/picker/reels/views/a;)V", "getStartIndex", "setStartIndex", "startIndex", "mClipRectTop", "", "t", "Ljava/util/List;", "mEntries", "radius", BaseSwitches.V, "getHighlightConorRadiusPx", "setHighlightConorRadiusPx", "highlightConorRadiusPx", "getWheelHeight", "wheelHeight", "u", "Ljava/lang/CharSequence;", "mTag", "x", "getShowTopLeftCorner", "setShowTopLeftCorner", "showTopLeftCorner", "height", "j", "getItemHeightPx", "setItemHeightPx", "itemHeightPx", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "OUI_standardRelease"}, k = 1, mv = {1, 1, 15})
public final class WheelView extends View {
    private boolean A;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f11262f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f11263g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f11264h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f11265i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f11266j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Rect f11267k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Rect f11268l;
    private Rect m;
    private final h n;
    private final h o;
    private final h p;
    private final h q;
    private final h r;
    private final h s;
    private final List<String> t;
    private CharSequence u;
    private int v;
    private boolean w;
    private boolean x;
    private boolean y;
    private boolean z;

    static final class a extends q implements kotlin.n0.c.a<Paint> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f11269f = null;

        static {
            f11269f = new a();
        }

        a() {
            super(0);
        }

        public final Paint a() {
            return new Paint();
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Paint invoke() {
            return a();
        }
    }

    static final class b extends q implements kotlin.n0.c.a<Paint> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f11270f = null;

        static {
            f11270f = new b();
        }

        b() {
            super(0);
        }

        public final Paint a() {
            return new Paint();
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Paint invoke() {
            return a();
        }
    }

    static final class c extends q implements kotlin.n0.c.a<com.obric.oui.picker.reels.views.d> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ WheelView f11271f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Context f11272g;

        c(WheelView r1, Context r2) {
            this.f11271f = r1;
            this.f11272g = r2;
            super(0);
        }

        public final com.obric.oui.picker.reels.views.d a() {
            return new com.obric.oui.picker.reels.views.d(this.f11272g, this.f11271f);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ com.obric.oui.picker.reels.views.d invoke() {
            return a();
        }
    }

    static final class d extends q implements kotlin.n0.c.a<TextPaint> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final d f11273f = null;

        static {
            f11273f = new d();
        }

        d() {
            super(0);
        }

        public final TextPaint a() {
            TextPaint r1 = new TextPaint();
            r1.setAntiAlias(true);
            return r1;
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ TextPaint invoke() {
            return a();
        }
    }

    static final class e extends q implements kotlin.n0.c.a<TextPaint> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final e f11274f = null;

        static {
            f11274f = new e();
        }

        e() {
            super(0);
        }

        public final TextPaint a() {
            TextPaint r1 = new TextPaint();
            r1.setAntiAlias(true);
            return r1;
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ TextPaint invoke() {
            return a();
        }
    }

    static final class f extends q implements kotlin.n0.c.a<TextPaint> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final f f11275f = null;

        static {
            f11275f = new f();
        }

        f() {
            super(0);
        }

        public final TextPaint a() {
            TextPaint r1 = new TextPaint();
            r1.setAntiAlias(true);
            return r1;
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ TextPaint invoke() {
            return a();
        }
    }

    static {
    }

    public WheelView(Context r23, AttributeSet r24) {
        o.f(r23, "context");
        super(r23, r24);
        this.f11264h = 7;
        float r3 = 343;
        Resources r4 = Resources.getSystem();
        o.e(r4, "Resources.getSystem()");
        this.f11265i = kotlin.o0.a.a(TypedValue.applyDimension(1, r3, r4.getDisplayMetrics()));
        Resources r7 = Resources.getSystem();
        o.e(r7, "Resources.getSystem()");
        this.f11266j = kotlin.o0.a.a(TypedValue.applyDimension(1, 48, r7.getDisplayMetrics()));
        this.n = i.b(f.f11275f);
        this.o = i.b(e.f11274f);
        this.p = i.b(d.f11273f);
        this.q = i.b(a.f11269f);
        this.r = i.b(b.f11270f);
        this.s = i.b(new c(this, r23));
        this.t = new ArrayList();
        float r5 = 8;
        Resources r8 = Resources.getSystem();
        o.e(r8, "Resources.getSystem()");
        this.v = kotlin.o0.a.a(TypedValue.applyDimension(1, r5, r8.getDisplayMetrics()));
        TypedArray r9 = r23.obtainStyledAttributes(r24, k.a2);
        o.e(r9, "context.obtainStyledAttr…, R.styleable.OWheelView)");
        boolean r10 = r9.getBoolean(k.b2, false);
        int r11 = r9.getInt(k.l2, 0);
        boolean r12 = r9.getBoolean(k.k2, false);
        int r2 = r9.getInt(k.f2, 7);
        int r13 = k.h2;
        Resources r14 = Resources.getSystem();
        o.e(r14, "Resources.getSystem()");
        int r6 = r9.getDimensionPixelOffset(r13, kotlin.o0.a.a(TypedValue.applyDimension(1, r3, r14.getDisplayMetrics())));
        int r15 = k.g2;
        Resources r16 = Resources.getSystem();
        o.e(r16, "Resources.getSystem()");
        int r17 = r9.getDimensionPixelOffset(r15, kotlin.o0.a.a(TypedValue.applyDimension(1, 40, r16.getDisplayMetrics())));
        int r18 = k.n2;
        Resources r19 = Resources.getSystem();
        o.e(r19, "Resources.getSystem()");
        int r110 = r9.getDimensionPixelSize(r18, kotlin.o0.a.a(TypedValue.applyDimension(2, 16, r19.getDisplayMetrics())));
        Resources r20 = Resources.getSystem();
        o.e(r20, "Resources.getSystem()");
        int r21 = r9.getDimensionPixelSize(r18, kotlin.o0.a.a(TypedValue.applyDimension(2, 14, r20.getDisplayMetrics())));
        int r111 = r9.getColor(k.m2, ContextCompat.getColor(r23, d.g.b.a.a.f16735c));
        int r22 = r9.getColor(k.i2, ContextCompat.getColor(r23, d.g.b.a.a.f16733a));
        int r112 = k.j2;
        Resources r25 = Resources.getSystem();
        o.e(r25, "Resources.getSystem()");
        int r26 = r9.getDimensionPixelSize(r112, kotlin.o0.a.a(TypedValue.applyDimension(2, 20, r25.getDisplayMetrics())));
        int r27 = r9.getColor(k.d2, ContextCompat.getColor(r23, d.g.b.a.a.f16734b));
        int r113 = k.e2;
        Resources r114 = Resources.getSystem();
        o.e(r114, "Resources.getSystem()");
        int r28 = r9.getDimensionPixelOffset(r113, kotlin.o0.a.a(TypedValue.applyDimension(1, r5, r114.getDisplayMetrics())));
        CharSequence[] r29 = r9.getTextArray(k.c2);
        if (r29 == null) goto L7;
        ArrayList r115 = new ArrayList(r29.length);
        int r116 = r29.length;
        int r1 = 0;
    L5:
        if (r1 >= r116) goto L8;
        CharSequence r210 = r29[r1];
        r115.add(r210.toString());
        r1 = r1 + 1;
    L8:
        r9.recycle();
        setCyclic(r10);
        setShowDivider(r12);
        setStartIndex(r11);
        setItemCount(r2);
        setItemWidthPx(r6);
        setItemHeightPx(r17);
        setHighlightConorRadiusPx(r28);
        TextPaint r30 = getMTextPaint();
        r30.setTextAlign(Paint.Align.CENTER);
        r30.setTextSize(r110);
        r30.setColor(r111);
        r30.setTypeface(Typeface.create(null, 480, false));
        TextPaint r31 = getMTagTextPaint();
        r31.setTextAlign(Paint.Align.LEFT);
        r31.setTextSize(r21);
        r31.setColor(r111);
        r31.setTypeface(Typeface.create(null, 600, false));
        TextPaint r32 = getMSelectedTextPaint();
        r32.setTextAlign(Paint.Align.CENTER);
        r32.setTextSize(r26);
        r32.setColor(r22);
        r32.setTypeface(Typeface.create(null, 640, false));
        Paint r33 = getMDividerPaint();
        Resources r34 = Resources.getSystem();
        o.e(r34, "Resources.getSystem()");
        r33.setStrokeWidth(TypedValue.applyDimension(1, (float) 0.5d, r34.getDisplayMetrics()));
        r33.setColor(ContextCompat.getColor(r23, com.obric.common.oui.c.f8213l));
        Paint r35 = getMHighlightPaint();
        r35.setStyle(Paint.Style.FILL);
        r35.setColor(r27);
        if (r115 != null) goto L11;
    L14:
        boolean r36 = true;
    L15:
        if (r36 == true) goto L19;
        this.t.addAll(r115);
        j(this, r11, false, 2, null);
        return;
    L19:
        return;
    L11:
        if (r115.isEmpty() == true) goto L14;
        r36 = false;
        goto L15
    L7:
        r115 = null;
        goto L8
    }

    private final void a(Canvas r9) {
        if (this.f11262f == true) goto L5;
        return;
    L5:
        Rect r0 = this.f11268l;
        if (r0 == null) goto L9;
        float r3 = r0.left;
        int r1 = r0.top;
        r9.drawLine(r3, r1, r0.right, r1, getMDividerPaint());
        float r4 = r0.left;
        int r2 = r0.bottom;
        r9.drawLine(r4, r2, r0.right, r2, getMDividerPaint());
        return;
    }

    private final void b(Canvas r14) {
        Rect r0 = this.f11268l;
        if (r0 == null) goto L6;
        RectF r1 = new RectF(r0);
        float r3 = r1.left - getPaddingLeft();
        float r4 = r1.top;
        float r5 = r1.right + getPaddingRight();
        float r6 = r1.bottom;
        int r2 = this.v;
        r14.drawPath(com.obric.oui.picker.reels.views.b.a(r3, r4, r5, r6, r2, r2, this.x, this.y, this.A, this.z), getMHighlightPaint());
        return;
    }

    private final void c(Canvas r11, int r12, int r13) {
        String r7 = g(r12);
        if (r7 == null) goto L22;
        Rect r0 = this.f11268l;
        o.c(r0);
        int r1 = r0.centerX();
        Rect r2 = this.f11268l;
        o.c(r2);
        int r3 = r2.centerY();
        Paint.FontMetrics r4 = getMTextPaint().getFontMetrics();
        float r5 = r4.top + r4.bottom;
        float r6 = 2;
        int r8 = (int) (r5 / r6);
        Paint.FontMetrics r9 = getMSelectedTextPaint().getFontMetrics();
        int r10 = (int) ((r9.top + r9.bottom) / r6);
        int r14 = r12 - getMScroller().d();
        int r15 = this.f11266j;
        int r16 = (r14 * r15) - r13;
        if (1 > r16) goto L11;
        if (r15 <= r16) goto L11;
        r11.save();
        Rect r17 = this.f11268l;
        o.c(r17);
        r11.clipRect(r17);
        float r18 = r1;
        int r19 = r16 + r3;
        Canvas r20 = r11;
        String r21 = r7;
        float r22 = r18;
        r20.drawText(r21, 0, r7.length(), r22, r19 - r10, getMSelectedTextPaint());
        r11.restore();
        r11.save();
        Rect r110 = this.m;
    L9:
        o.c(r110);
        r11.clipRect(r110);
        int r23 = 0;
        int r24 = r7.length();
        float r25 = r19 - r8;
        TextPaint r26 = getMTextPaint();
    L10:
        r20.drawText(r21, r23, r24, r22, r25, r26);
        r11.restore();
        return;
    L11:
        if (r16 < r15) goto L14;
        r11.save();
        Rect r111 = this.m;
    L13:
        o.c(r111);
        r11.clipRect(r111);
        r23 = 0;
        r24 = r7.length();
        r22 = r1;
        r25 = (r3 + r16) - r8;
        r26 = getMTextPaint();
        r20 = r11;
        r21 = r7;
        goto L10
    L14:
        if (r16 < 0) goto L16;
    L18:
        int r112 = -r15;
        r11.save();
        if (r16 > r112) goto L21;
        r111 = this.f11267k;
        goto L13
    L21:
        Rect r113 = this.f11268l;
        o.c(r113);
        r11.clipRect(r113);
        r24 = r7.length();
        r22 = r1;
        r25 = (r3 + r16) - r10;
        r26 = getMSelectedTextPaint();
        r20 = r11;
        r21 = r7;
        r23 = 0;
        goto L10
    L16:
        if (r16 <= (-r15)) goto L18;
        r11.save();
        Rect r114 = this.f11268l;
        o.c(r114);
        r11.clipRect(r114);
        float r27 = r1;
        r19 = r16 + r3;
        r20 = r11;
        r21 = r7;
        r22 = r27;
        r20.drawText(r21, 0, r7.length(), r22, r19 - r10, getMSelectedTextPaint());
        r11.restore();
        r11.save();
        r110 = this.f11267k;
        goto L9
    }

    private final void d(Canvas r5) {
        int r0 = getMScroller().d();
        int r1 = getMScroller().e();
        int r2 = (this.f11264h + 1) / 2;
        int r3 = r0 - r2;
        if (r1 >= 0) goto L5;
        r3 = r3 - 1;
        int r4 = r0 + r2;
    L8:
        if (r3 >= r4) goto L10;
        c(r5, r3, r1);
        r3 = r3 + 1;
        goto L8
    L10:
        return;
    L5:
        r4 = r0 + r2;
        if (r1 <= 0) goto L8;
        r4 = r4 + 1;
        goto L8
    }

    private final void e(Canvas r11) {
        CharSequence r1 = this.u;
        if (r1 == null) goto L6;
        Rect r0 = this.f11268l;
        o.c(r0);
        int r2 = r0.centerY();
        Rect r3 = this.f11268l;
        o.c(r3);
        int r4 = r3.centerX();
        Paint.FontMetrics r5 = getMTagTextPaint().getFontMetrics();
        int r6 = (int) ((r5.top + r5.bottom) / 2);
        int r7 = r1.length();
        Resources r8 = Resources.getSystem();
        o.e(r8, "Resources.getSystem()");
        r11.drawText(r1, 0, r7, kotlin.o0.a.a(TypedValue.applyDimension(1, 14, r8.getDisplayMetrics())) + r4, r2 - r6, getMTagTextPaint());
        return;
    }

    private final String g(int r4) {
        int r0 = this.t.size();
        if (r0 != 0) goto L6;
        return null;
    L6:
        if (this.w == false) goto L11;
        r4 = r4 % r0;
        if (r4 >= 0) goto L15;
        r4 = r4 + r0;
    L15:
        return this.t.get(r4);
    L11:
        if (r4 < 0) goto L17;
        if (r0 > r4) goto L15;
        return null;
    L17:
        return null;
    }

    private final Paint getMDividerPaint() {
        return (Paint) this.q.getValue();
    }

    private final Paint getMHighlightPaint() {
        return (Paint) this.r.getValue();
    }

    private final com.obric.oui.picker.reels.views.d getMScroller() {
        return (com.obric.oui.picker.reels.views.d) this.s.getValue();
    }

    private final TextPaint getMSelectedTextPaint() {
        return (TextPaint) this.p.getValue();
    }

    private final TextPaint getMTagTextPaint() {
        return (TextPaint) this.o.getValue();
    }

    private final TextPaint getMTextPaint() {
        return (TextPaint) this.n.getValue();
    }

    private final int getWheelHeight() {
        int r0 = (getPaddingTop() + getPaddingBottom()) + (this.f11266j * this.f11264h);
        Resources r1 = Resources.getSystem();
        o.e(r1, "Resources.getSystem()");
        return r0 - kotlin.o0.a.a(TypedValue.applyDimension(1, 30, r1.getDisplayMetrics()));
    }

    private final int getWheelWidth() {
        return (getPaddingLeft() + getPaddingRight()) + this.f11265i;
    }

    public static /* synthetic */ void j(WheelView r0, int r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = false;
    L5:
        r0.i(r1, r2);
    }

    private final void k() {
        int r0 = getPaddingLeft();
        int r1 = getMeasuredWidth() - getPaddingRight();
        int r2 = getPaddingTop();
        int r3 = getMeasuredHeight() - getPaddingBottom();
        int r4 = (r2 + r3) / 2;
        Rect r5 = new Rect();
        r5.left = r0;
        r5.right = r1;
        int r6 = this.f11266j;
        r5.top = r4 - (r6 / 2);
        r5.bottom = (r6 / 2) + r4;
        f0 r7 = f0.f18324a;
        this.f11268l = r5;
        Rect r8 = new Rect();
        r8.left = r0;
        r8.right = r1;
        r8.top = r2;
        r8.bottom = r4 - (this.f11266j / 2);
        this.f11267k = r8;
        Rect r9 = new Rect();
        r9.left = r0;
        r9.right = r1;
        r9.top = r4 + (this.f11266j / 2);
        r9.bottom = r3;
        this.m = r9;
    }

    @Override // android.view.View
    public void computeScroll() {
        getMScroller().a();
    }

    public final String f(int r2) {
        if (r2 >= 0) goto L7;
        if (r2 < this.t.size()) goto L7;
        return null;
    L7:
        return this.t.get(r2);
    }

    public final int getClipMiddleRectBottom() {
        Rect r0 = this.f11268l;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.bottom;
    }

    public final int getClipMiddleRectTop() {
        Rect r0 = this.f11268l;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.top;
    }

    public final int getCurrentIndex() {
        return getMScroller().c();
    }

    public final String getCurrentItem() {
        return f(getCurrentIndex());
    }

    public final int getHighlightColor() {
        return getMHighlightPaint().getColor();
    }

    public final int getHighlightConorRadiusPx() {
        return this.v;
    }

    public final int getItemCount() {
        return this.f11264h;
    }

    public final int getItemHeightPx() {
        return this.f11266j;
    }

    public final int getItemSize() {
        return this.t.size();
    }

    public final int getItemWidthPx() {
        return this.f11265i;
    }

    public final com.obric.oui.picker.reels.views.a getOnWheelChangedListener() {
        return getMScroller().f();
    }

    public final int getSelectedTextColor() {
        return getMSelectedTextPaint().getColor();
    }

    public final float getSelectedTextSizePx() {
        return getMSelectedTextPaint().getTextSize();
    }

    public final boolean getShowBottomLeftCorner() {
        return this.z;
    }

    public final boolean getShowBottomRightCorner() {
        return this.A;
    }

    public final boolean getShowDivider() {
        return this.f11262f;
    }

    public final boolean getShowTopLeftCorner() {
        return this.x;
    }

    public final boolean getShowTopRightCorner() {
        return this.y;
    }

    public final int getStartIndex() {
        return this.f11263g;
    }

    public final int getTextColor() {
        return getMTextPaint().getColor();
    }

    public final float getTextSizePx() {
        return getMTextPaint().getTextSize();
    }

    public final boolean h() {
        return this.w;
    }

    public final void i(int r1, boolean r2) {
        getMScroller().n(r1, r2);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.obric.oui.picker.reels.views.d r0 = getMScroller();
        Context r2 = getContext();
        o.e(r2, "context");
        r0.k(r2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas r2) {
        o.f(r2, "canvas");
        b(r2);
        d(r2);
        a(r2);
        e(r2);
    }

    @Override // android.view.View
    protected void onMeasure(int r4, int r5) {
        int r0 = View.MeasureSpec.getMode(r4);
        int r6 = View.MeasureSpec.getSize(r4);
        int r1 = View.MeasureSpec.getMode(r5);
        int r7 = View.MeasureSpec.getSize(r5);
        if (r0 != 1073741824) goto L6;
        if (r1 != 1073741824) goto L6;
    L8:
        setMeasuredDimension(r6, r7);
        k();
        return;
    L6:
        if (r0 != 1073741824) goto L9;
    L7:
        r7 = getWheelHeight();
        goto L8
    L9:
        r6 = getWheelWidth();
        if (r1 != 1073741824) goto L7;
        goto L7
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r2) {
        o.f(r2, NotificationCompat.CATEGORY_EVENT);
        return getMScroller().j(r2);
    }

    public final void setCurrentIndex(int r4) {
        j(this, r4, false, 2, null);
    }

    public final void setCyclic(boolean r1) {
        this.w = r1;
        getMScroller().m();
        invalidate();
    }

    public final void setEntries(List<String> r4) {
        this.t.clear();
        if (r4 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L11;
        this.t.addAll(r4);
    L11:
        getMScroller().m();
        j(this, this.f11263g, false, 2, null);
        invalidate();
        return;
    L5:
        if (r4.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    public final void setEntries(String... r4) {
        o.f(r4, "entries");
        this.t.clear();
        if (r4.length != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        r.w(this.t, r4);
    L8:
        getMScroller().m();
        j(this, this.f11263g, false, 2, null);
        invalidate();
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void setHighlightColor(int r2) {
        getMHighlightPaint().setColor(r2);
        invalidate();
    }

    public final void setHighlightConorRadiusPx(int r1) {
        this.v = r1;
        invalidate();
    }

    public final void setItemCount(int r1) {
        this.f11264h = r1;
        invalidate();
    }

    public final void setItemHeightPx(int r1) {
        this.f11266j = r1;
        invalidate();
    }

    public final void setItemWidthPx(int r1) {
        this.f11265i = r1;
        invalidate();
    }

    public final void setOnWheelChangedListener(com.obric.oui.picker.reels.views.a r1) {
        getMScroller().o(r1);
    }

    public final void setSelectedTextColor(int r2) {
        getMSelectedTextPaint().setColor(r2);
        invalidate();
    }

    public final void setSelectedTextSizePx(float r2) {
        getMSelectedTextPaint().setTextSize(r2);
        invalidate();
    }

    public final void setShowBottomLeftCorner(boolean r1) {
        this.z = r1;
    }

    public final void setShowBottomRightCorner(boolean r1) {
        this.A = r1;
    }

    public final void setShowDivider(boolean r1) {
        this.f11262f = r1;
        invalidate();
    }

    public final void setShowTopLeftCorner(boolean r1) {
        this.x = r1;
    }

    public final void setShowTopRightCorner(boolean r1) {
        this.y = r1;
    }

    public final void setStartIndex(int r2) {
        this.f11263g = r2;
        getMScroller().n(r2, false);
    }

    public final void setTagText(CharSequence r2) {
        o.f(r2, LocationMonitorConst.TAG);
        if ((!kotlin.u0.k.q(r2)) == false) goto L6;
        this.u = r2;
        invalidate();
        return;
    }

    public final void setTextColor(int r2) {
        getMTextPaint().setColor(r2);
        invalidate();
    }

    public final void setTextSizePx(float r2) {
        getMTextPaint().setTextSize(r2);
        invalidate();
    }
}
