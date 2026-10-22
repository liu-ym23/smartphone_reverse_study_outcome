package com.obric.oui.indexscrollbar;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedanceos.security.Utils;
import com.obric.common.oui.R;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.haptic.VibratorSmt;
import com.obric.oui.utils.log.L;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: LettersBar.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u008f\u00012\u00020\u0001:\u0006\u008f\u0001\u0090\u0001\u0091\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010U\u001a\u0012\u0012\u0004\u0012\u00020\u00070Vj\b\u0012\u0004\u0012\u00020\u0007`WH\u0002J\u0010\u0010X\u001a\u00020\u00182\u0006\u0010Y\u001a\u00020ZH\u0016J(\u0010[\u001a\u00020\\2\u0006\u0010]\u001a\u00020\u00072\u0006\u0010^\u001a\u00020_2\u0006\u0010`\u001a\u00020\u000e2\u0006\u0010a\u001a\u00020\u000eH\u0002J(\u0010b\u001a\u00020\\2\u0006\u0010]\u001a\u00020\u00072\u0006\u0010^\u001a\u00020_2\u0006\u0010`\u001a\u00020\u000e2\u0006\u0010a\u001a\u00020\u000eH\u0002J(\u0010c\u001a\u00020\\2\u0006\u0010]\u001a\u00020\u00072\u0006\u0010^\u001a\u00020_2\u0006\u0010`\u001a\u00020\u000e2\u0006\u0010a\u001a\u00020\u000eH\u0002J(\u0010d\u001a\u00020\\2\u0006\u0010]\u001a\u00020\u00072\u0006\u0010^\u001a\u00020_2\u0006\u0010`\u001a\u00020\u000e2\u0006\u0010a\u001a\u00020\u000eH\u0002J(\u0010e\u001a\u00020\\2\u0006\u0010]\u001a\u00020\u00072\u0006\u0010^\u001a\u00020_2\u0006\u0010`\u001a\u00020\u000e2\u0006\u0010a\u001a\u00020\u000eH\u0002J\u0012\u0010f\u001a\u00020\u001f2\b\b\u0001\u0010g\u001a\u00020\u0007H\u0002J(\u0010h\u001a\u00020\u000e2\u0006\u0010i\u001a\u00020\u00072\u0016\u0010j\u001a\u0012\u0012\u0004\u0012\u00020\u00070Vj\b\u0012\u0004\u0012\u00020\u0007`WH\u0002J\u0010\u0010k\u001a\u00020\\2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010l\u001a\u00020\u00182\u0006\u0010]\u001a\u00020\u0007H\u0002J\u0010\u0010m\u001a\u00020\u00072\u0006\u0010n\u001a\u00020\u0007H\u0002J\u0012\u0010o\u001a\u00020\\2\b\u0010p\u001a\u0004\u0018\u00010qH\u0014J\u0010\u0010r\u001a\u00020\\2\u0006\u0010^\u001a\u00020_H\u0014J\u0018\u0010s\u001a\u00020\\2\u0006\u0010t\u001a\u00020\u00072\u0006\u0010u\u001a\u00020\u0007H\u0014J\b\u0010v\u001a\u00020\\H\u0002J\u001d\u0010w\u001a\u00020\\2\u0010\u0010x\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010#\u0018\u00010.¢\u0006\u0002\u0010yJ\u0016\u0010z\u001a\u00020\\2\u0006\u0010{\u001a\u00020\u00072\u0006\u0010|\u001a\u00020\u0007J\u0010\u0010}\u001a\u00020\\2\u0006\u0010]\u001a\u00020\u0007H\u0002J\u0016\u0010~\u001a\u00020\\2\u000e\u0010\u007f\u001a\n\u0012\u0004\u0012\u000207\u0018\u000106J\u0012\u0010\u0080\u0001\u001a\u00020\\2\t\u0010\u0081\u0001\u001a\u0004\u0018\u00010:J\u0012\u0010\u0082\u0001\u001a\u00020\\2\t\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u001dJ\u001c\u0010\u0083\u0001\u001a\u00020\\2\u0007\u0010\u0084\u0001\u001a\u00020\u00072\n\u0010\u0085\u0001\u001a\u0005\u0018\u00010\u0086\u0001J\u0010\u0010\u0087\u0001\u001a\u00020\\2\u0007\u0010\u0088\u0001\u001a\u00020\u0018J\u0010\u0010\u0089\u0001\u001a\u00020\\2\u0007\u0010\u008a\u0001\u001a\u00020\u0018J\u0011\u0010\u008b\u0001\u001a\u00020\\2\u0006\u0010]\u001a\u00020\u0007H\u0002J\u001b\u0010\u008c\u0001\u001a\u00020\\2\u0007\u0010\u008d\u0001\u001a\u00020\u001b2\u0007\u0010\u008e\u0001\u001a\u00020\u0007H\u0002R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00188BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0019R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010%\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0010\u0010*\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010-\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010#\u0018\u00010.X\u0082\u000e¢\u0006\u0004\n\u0002\u0010/R\u000e\u00100\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u00105\u001a\n\u0012\u0004\u0012\u000207\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u00010:X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010;\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010'\"\u0004\b=\u0010)R\u000e\u0010>\u001a\u00020?X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010D\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010'\"\u0004\bF\u0010)R\u001a\u0010G\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010'\"\u0004\bI\u0010)R\u0011\u0010J\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\bK\u0010\fR\u001a\u0010L\u001a\u00020MX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u001a\u0010R\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010'\"\u0004\bT\u0010)¨\u0006\u0092\u0001"}, d2 = {"Lcom/obric/oui/indexscrollbar/LettersBar;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "dismissPopupTask", "Ljava/lang/Runnable;", "getDismissPopupTask", "()Ljava/lang/Runnable;", "dotLetterTextSizePx", "", "downX", "getDownX", "()F", "setDownX", "(F)V", "downY", "getDownY", "setDownY", "isHolderState", "", "()Z", "lastPopupLetter", "", "mBackgroundChangeListener", "Lcom/obric/oui/indexscrollbar/LettersBar$OnBackgroundVisibleChangedListener;", "mBitmapPaint", "Landroid/graphics/Paint;", "mChosenLetterIndex", "mContext", "mDotIcon", "Landroid/graphics/Bitmap;", "mDotIconX", "mHasChosenLetterFontColor", "getMHasChosenLetterFontColor", "()I", "setMHasChosenLetterFontColor", "(I)V", "mHighlightIcon", "mHighlightIconHeight", "mHighlightIconStartX", "mIconsForSymbolsSelected", "", "[Landroid/graphics/Bitmap;", "mLetterBarHeight", "mLetterFontCenterX", "mLetterFontSize", "mLetterLocaleFontSize", "mLetterPaint", "mLetters", "", "Lcom/obric/oui/indexscrollbar/LBLetter;", "mLettersBarWidth", "mListener", "Lcom/obric/oui/indexscrollbar/LettersBar$LBListener;", "mNoChosenLetterFontColor", "getMNoChosenLetterFontColor", "setMNoChosenLetterFontColor", "mPopupWindow", "Lcom/obric/oui/indexscrollbar/OIndexPopupWindowController;", "mScreenWidth", "mSettled", "mShowBg", "mSingleLetterMinHeight", "newChosen", "getNewChosen", "setNewChosen", "oldChosen", "getOldChosen", "setOldChosen", "showPopupTask", "getShowPopupTask", "showPopupTaskStartTime", "", "getShowPopupTaskStartTime", "()J", "setShowPopupTaskStartTime", "(J)V", "touchSlop", "getTouchSlop", "setTouchSlop", "calculateVisibleLettersIndexes", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "drawDot", "", Utils.INTENT_KEY_INDEX, "canvas", "Landroid/graphics/Canvas;", "xPos", "yPos", "drawHighlightBackground", "drawHighlightIcon", "drawLetter", "drawSymbol", "getBitmapTintPaint", "tintColor", "getSingleLetterHeight", "totalHeight", "visibleLetters", "init", "isTouchedLetter", "measureHeight", "measureSpec", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDraw", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "refreshDimensionCache", "setBitmapsSelected", "bitmaps", "([Landroid/graphics/Bitmap;)V", "setLetterFontColor", "hasChosenColor", "noChosenColor", "setLetterPaint", "setLetters", "letters", "setListener", "listener", "setOnBackgroundVisibleChangedListener", "setPopupWindowStyle", "textColor", "background", "Landroid/graphics/drawable/Drawable;", "setSettled", "settled", "setShowBg", "showBg", "setTouchedLetter", "showPopupWindow", "scene", "c", "Companion", "LBListener", "OnBackgroundVisibleChangedListener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LettersBar extends View {
    public static final Companion Companion = null;
    public static final int POPUP_CONTAINER_MARGIN_DP = 10;
    private static final String TAG = "LettersBar";
    private final Runnable dismissPopupTask;
    private float dotLetterTextSizePx;
    private float downX;
    private float downY;
    private String lastPopupLetter;
    private OnBackgroundVisibleChangedListener mBackgroundChangeListener;
    private final Paint mBitmapPaint;
    private int mChosenLetterIndex;
    private Context mContext;
    private Bitmap mDotIcon;
    private int mDotIconX;
    private int mHasChosenLetterFontColor;
    private Bitmap mHighlightIcon;
    private int mHighlightIconHeight;
    private int mHighlightIconStartX;
    private Bitmap[] mIconsForSymbolsSelected;
    private int mLetterBarHeight;
    private int mLetterFontCenterX;
    private int mLetterFontSize;
    private int mLetterLocaleFontSize;
    private final Paint mLetterPaint;
    private List<LBLetter> mLetters;
    private int mLettersBarWidth;
    private LBListener mListener;
    private int mNoChosenLetterFontColor;
    private final OIndexPopupWindowController mPopupWindow;
    private int mScreenWidth;
    private boolean mSettled;
    private boolean mShowBg;
    private int mSingleLetterMinHeight;
    private int newChosen;
    private int oldChosen;
    private final Runnable showPopupTask;
    private long showPopupTaskStartTime;
    private int touchSlop;

    /* JADX INFO: compiled from: LettersBar.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/indexscrollbar/LettersBar$Companion;", "", "()V", "POPUP_CONTAINER_MARGIN_DP", "", "TAG", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: LettersBar.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/obric/oui/indexscrollbar/LettersBar$LBListener;", "", "onLetterChanged", "", "letter", "", "type", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface LBListener {
        boolean onLetterChanged(String r1, int r2);
    }

    /* JADX INFO: compiled from: LettersBar.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/indexscrollbar/LettersBar$OnBackgroundVisibleChangedListener;", "", "OnBackgroundVisibleChanged", "", "visible", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnBackgroundVisibleChangedListener {
        void OnBackgroundVisibleChanged(boolean r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$I6G7-ZDujXoZKNjGlrt0eGXragg, reason: not valid java name */
    public static /* synthetic */ void m359$r8$lambda$I6G7ZDujXoZKNjGlrt0eGXragg(LettersBar r0) {
        m362showPopupTask$lambda1(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$bj7aFOA1-n25WP6RBlJmP1oY3rc, reason: not valid java name */
    public static /* synthetic */ void m360$r8$lambda$bj7aFOA1n25WP6RBlJmP1oY3rc(LettersBar r0) {
        m361dismissPopupTask$lambda2(r0);
    }

    static {
        Companion = new Companion(null);
    }

    public LettersBar(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public LettersBar(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    public /* synthetic */ LettersBar(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public LettersBar(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.mChosenLetterIndex = -1;
        this.mSettled = true;
        this.mLetterPaint = new Paint();
        Paint r0 = new Paint(1);
        r0.setFilterBitmap(true);
        r0.setDither(true);
        this.mBitmapPaint = r0;
        this.mPopupWindow = new OIndexPopupWindowController(r2);
        init(r2);
        this.oldChosen = -1;
        this.newChosen = -1;
        this.showPopupTask = new LettersBar$$ExternalSyntheticLambda0(this);
        this.dismissPopupTask = new LettersBar$$ExternalSyntheticLambda1(this);
        this.showPopupTaskStartTime = -1;
    }

    public final int getMHasChosenLetterFontColor() {
        return this.mHasChosenLetterFontColor;
    }

    public final void setMHasChosenLetterFontColor(int r1) {
        this.mHasChosenLetterFontColor = r1;
    }

    public final int getMNoChosenLetterFontColor() {
        return this.mNoChosenLetterFontColor;
    }

    public final void setMNoChosenLetterFontColor(int r1) {
        this.mNoChosenLetterFontColor = r1;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration r1) {
        super.onConfigurationChanged(r1);
        refreshDimensionCache();
        invalidate();
    }

    public final void setLetters(List<LBLetter> r1) {
        this.mLetters = r1;
    }

    public final void setBitmapsSelected(Bitmap[] r1) {
        this.mIconsForSymbolsSelected = r1;
    }

    public final void setListener(LBListener r1) {
        this.mListener = r1;
    }

    public final void setSettled(boolean r1) {
        this.mSettled = r1;
        if (r1 == false) goto L5;
        setTouchedLetter(-1);
    L5:
        invalidate();
    }

    public final void setShowBg(boolean r2) {
        if (this.mShowBg == r2) goto L12;
        this.mShowBg = r2;
        if (r2 == false) goto L7;
        Drawable r3 = getResources().getDrawable(R.drawable.letters_bar_background);
    L8:
        setBackground(r3);
        OnBackgroundVisibleChangedListener r4 = this.mBackgroundChangeListener;
        if (r4 == null) goto L13;
        Intrinsics.checkNotNull(r4);
        r4.OnBackgroundVisibleChanged(this.mShowBg);
        return;
    L13:
        return;
    L7:
        r3 = null;
        goto L8
    }

    public final void setOnBackgroundVisibleChangedListener(OnBackgroundVisibleChangedListener r1) {
        this.mBackgroundChangeListener = r1;
    }

    public final void setPopupWindowStyle(int r1, Drawable r2) {
        this.mPopupWindow.setStyle(r1, r2);
    }

    public final void setLetterFontColor(int r1, int r2) {
        this.mHasChosenLetterFontColor = r1;
        this.mNoChosenLetterFontColor = r2;
    }

    private final void init(Context r5) {
        this.mContext = r5;
        refreshDimensionCache();
        Context r0 = this.mContext;
        Intrinsics.checkNotNull(r0);
        Resources r1 = r0.getResources();
        this.mSingleLetterMinHeight = r1.getDimensionPixelSize(R.dimen.letters_bar_single_letter_min_height);
        this.mLettersBarWidth = OUnitExtensionKt.vdp(this, 14);
        this.mLetterFontSize = r1.getDimensionPixelOffset(R.dimen.letters_bar_letter_font_size);
        this.mLetterLocaleFontSize = r1.getDimensionPixelOffset(R.dimen.letters_bar_letter_locale_font_size);
        this.mLetterFontCenterX = (this.mLettersBarWidth / 2) + getPaddingLeft();
        this.mHighlightIcon = BitmapFactory.decodeResource(r1, R.drawable.letters_bar_highlight_icon);
        Drawable r2 = r1.getDrawable(R.drawable.letters_bar_highlight_icon);
        this.mHighlightIconStartX = this.mLetterFontCenterX - (r2.getIntrinsicWidth() / 2);
        this.mHighlightIconHeight = r2.getIntrinsicHeight();
        this.mHasChosenLetterFontColor = r1.getColor(R.color.oui_functional_blue_6);
        this.mNoChosenLetterFontColor = r1.getColor(R.color.oui_text_3b);
        Bitmap r3 = BitmapFactory.decodeResource(r1, R.drawable.letters_bar_dot);
        this.mDotIcon = r3;
        int r4 = this.mLetterFontCenterX;
        Intrinsics.checkNotNull(r3);
        this.mDotIconX = r4 - (r3.getWidth() / 2);
        this.mLetterPaint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
        this.mLetterPaint.setTextSize(this.mLetterFontSize);
        this.mLetterPaint.setAntiAlias(true);
        this.mScreenWidth = r5.getResources().getDisplayMetrics().widthPixels;
    }

    private final void refreshDimensionCache() {
        this.dotLetterTextSizePx = OUnitExtensionKt.vdpFloat(this, 10);
    }

    @Override // android.view.View
    protected void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
        this.mLetterBarHeight = (measureHeight(r2) - getPaddingTop()) - getPaddingBottom();
    }

    public final float getDownX() {
        return this.downX;
    }

    public final void setDownX(float r1) {
        this.downX = r1;
    }

    public final float getDownY() {
        return this.downY;
    }

    public final void setDownY(float r1) {
        this.downY = r1;
    }

    public final int getTouchSlop() {
        return this.touchSlop;
    }

    public final void setTouchSlop(int r1) {
        this.touchSlop = r1;
    }

    public final int getOldChosen() {
        return this.oldChosen;
    }

    public final void setOldChosen(int r1) {
        this.oldChosen = r1;
    }

    public final int getNewChosen() {
        return this.newChosen;
    }

    public final void setNewChosen(int r1) {
        this.newChosen = r1;
    }

    public final Runnable getShowPopupTask() {
        return this.showPopupTask;
    }

    /* JADX INFO: renamed from: showPopupTask$lambda-1, reason: not valid java name */
    private static final void m362showPopupTask$lambda1(LettersBar r3) {
        Intrinsics.checkNotNullParameter(r3, "this$0");
        int r0 = r3.oldChosen;
        int r1 = r3.newChosen;
        if (r0 == r1) goto L11;
        if (r1 < 0) goto L11;
        List<LBLetter> r2 = r3.mLetters;
        Intrinsics.checkNotNull(r2);
        if (r1 >= r2.size()) goto L11;
        r3.showPopupWindow("ACTION_DOWN", r3.newChosen);
        LBListener r4 = r3.mListener;
        if (r4 == null) goto L10;
        Intrinsics.checkNotNull(r4);
        List<LBLetter> r5 = r3.mLetters;
        Intrinsics.checkNotNull(r5);
        r4.onLetterChanged(r5.get(r3.newChosen).getLetter(), 1);
    L10:
        VibratorSmt.INSTANCE.performHapticFeedbackAOSP(r3, 26);
        r3.setTouchedLetter(r3.newChosen);
    L11:
        r3.showPopupTaskStartTime = -1;
    }

    public final Runnable getDismissPopupTask() {
        return this.dismissPopupTask;
    }

    /* JADX INFO: renamed from: dismissPopupTask$lambda-2, reason: not valid java name */
    private static final void m361dismissPopupTask$lambda2(LettersBar r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        if (r1.mPopupWindow.isShowing() == false) goto L6;
        r1.mPopupWindow.hidePopup();
        r1.setTouchedLetter(-1);
        r1.setShowBg(false);
        return;
    }

    public final long getShowPopupTaskStartTime() {
        return this.showPopupTaskStartTime;
    }

    public final void setShowPopupTaskStartTime(long r1) {
        this.showPopupTaskStartTime = r1;
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent r12) {
        Intrinsics.checkNotNullParameter(r12, "event");
        super.dispatchTouchEvent(r12);
        int r0 = r12.getAction();
        float r1 = r12.getY();
        this.oldChosen = this.mChosenLetterIndex;
        float r2 = (r1 - getPaddingTop()) / ((getHeight() - getPaddingTop()) - getPaddingBottom());
        List<LBLetter> r3 = this.mLetters;
        Intrinsics.checkNotNull(r3);
        int r4 = (int) (r2 * r3.size());
        this.newChosen = r4;
        if (r0 != 0) goto L5;
        removeCallbacks(this.dismissPopupTask);
        this.downX = r12.getX();
        this.downY = r12.getY();
        this.touchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        if (this.mPopupWindow.isShowing() == true) goto L49;
        this.showPopupTaskStartTime = System.currentTimeMillis();
        postDelayed(this.showPopupTask, 200);
    L49:
        this.lastPopupLetter = null;
        setShowBg(false);
    L50:
        return true;
    L5:
        if (r0 != 1) goto L7;
        removeCallbacks(this.showPopupTask);
        if ((System.currentTimeMillis() - this.showPopupTaskStartTime) >= 100) goto L39;
        if (this.mPopupWindow.isShowing() == true) goto L39;
        this.showPopupTaskStartTime = -1;
        this.showPopupTask.run();
        postDelayed(this.dismissPopupTask, 200);
        return true;
    L39:
        if (this.mPopupWindow.isShowing() == false) goto L41;
        removeCallbacks(this.dismissPopupTask);
    L41:
        this.showPopupTaskStartTime = -1;
        if (this.mSettled == false) goto L44;
        this.mPopupWindow.hidePopup();
        setTouchedLetter(-1);
        setShowBg(false);
    L45:
        invalidate();
        goto L50
    L44:
        this.mPopupWindow.hidePopup();
        goto L45
    L7:
        if (r0 == 2) goto L16;
        if (r0 != 3) goto L50;
        removeCallbacks(this.showPopupTask);
        if (this.mPopupWindow.isShowing() == false) goto L14;
        removeCallbacks(this.dismissPopupTask);
    L14:
        this.showPopupTaskStartTime = -1;
        this.mPopupWindow.hidePopup();
        setTouchedLetter(-1);
        goto L50
    L16:
        if (Math.sqrt(Math.pow(r12.getX() - this.downX, 2.0d) + Math.pow(r12.getY() - this.downY, 2.0d)) >= this.touchSlop) goto L19;
        return true;
    L19:
        if (this.mPopupWindow.isShowing() == false) goto L31;
        if (r4 < 0) goto L31;
        List<LBLetter> r13 = this.mLetters;
        Intrinsics.checkNotNull(r13);
        if (r4 >= r13.size()) goto L31;
        if (this.mSettled == true) goto L26;
    L30:
        setTouchedLetter(r4);
        goto L31
    L26:
        if (this.oldChosen == r4) goto L30;
        if (this.mListener == null) goto L30;
        removeCallbacks(this.dismissPopupTask);
        showPopupWindow("ACTION_MOVE", r4);
        VibratorSmt.INSTANCE.performHapticFeedbackAOSP(this, 26);
        LBListener r14 = this.mListener;
        Intrinsics.checkNotNull(r14);
        List<LBLetter> r5 = this.mLetters;
        Intrinsics.checkNotNull(r5);
        r14.onLetterChanged(r5.get(r4).getLetter(), 0);
    L31:
        setShowBg(false);
        goto L50
    }

    private final void showPopupWindow(String r12, int r13) {
        float r0 = getSingleLetterHeight(this.mLetterBarHeight, calculateVisibleLettersIndexes());
        List<LBLetter> r1 = this.mLetters;
        Intrinsics.checkNotNull(r1);
        String r2 = r1.get(r13).getLetter();
        if (Intrinsics.areEqual(r2, this.lastPopupLetter) == false) goto L5;
        return;
    L5:
        L.d(TAG, "showPopupWindow, scene: " + r12 + ", c = " + r13 + ", letter = " + r2 + ", lastPopupLetter = " + this.lastPopupLetter);
        Bitmap[] r14 = this.mIconsForSymbolsSelected;
        if (r14 != null) goto L8;
        Integer r15 = null;
    L9:
        List<LBLetter> r3 = this.mLetters;
        Intrinsics.checkNotNull(r3);
        if (r3.get(r13).getType() != 2) goto L15;
        if (r15 == null) goto L15;
        if (Integer.parseInt(r2) > r15.intValue()) goto L15;
        Bitmap[] r16 = this.mIconsForSymbolsSelected;
        Intrinsics.checkNotNull(r16);
        Bitmap r17 = r16[Integer.parseInt(r2) - 1];
    L16:
        int r4 = getResources().getDimensionPixelSize(R.dimen.oui_h_title_bar_window);
        LettersBar r6 = this;
        int r7 = (this.mScreenWidth - getWidth()) - OUnitExtensionKt.vdp(r6, 68);
        int r5 = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (r5 <= 0) goto L19;
        r4 = r4 + getResources().getDimensionPixelSize(r5);
    L19:
        int r8 = r4;
        int[] r9 = new int[2];
        getLocationInWindow(r9);
        this.mPopupWindow.showPopup(r6, r2, r17, r7, (int) (((r9[1] + getPaddingTop()) + (r13 * r0)) + (r0 / 2)), r8);
        this.lastPopupLetter = r2;
        return;
    L15:
        r17 = null;
        goto L16
    L8:
        r15 = Integer.valueOf(r14.length);
        goto L9
    }

    @Override // android.view.View
    protected void onDraw(Canvas r10) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        super.onDraw(r10);
        r10.save();
        r10.translate(0.0f, getPaddingTop());
        ArrayList<Integer> r0 = calculateVisibleLettersIndexes();
        float r1 = getSingleLetterHeight(this.mLetterBarHeight, r0);
        Iterator<Integer> r2 = r0.iterator();
        int r3 = 0;
    L4:
        if (r2.hasNext() == false) goto L10;
        Integer r4 = r2.next();
        Intrinsics.checkNotNullExpressionValue(r4, Utils.INTENT_KEY_INDEX);
        setLetterPaint(r4.intValue());
        float r5 = this.mLetterFontCenterX;
        Paint r6 = this.mLetterPaint;
        List<LBLetter> r7 = this.mLetters;
        Intrinsics.checkNotNull(r7);
        float r8 = 2;
        float r9 = r5 - (r6.measureText(r7.get(r4.intValue()).getLetter()) / r8);
        float r11 = (r3 * r1) + (r1 / r8);
        drawHighlightBackground(r4.intValue(), r10, r9, r11);
        List<LBLetter> r12 = this.mLetters;
        Intrinsics.checkNotNull(r12);
        if (r12.get(r4.intValue()).getType() != 2) goto L8;
        drawSymbol(r4.intValue(), r10, r9, r11);
    L9:
        r3 = r3 + 1;
        goto L4
    L8:
        drawLetter(r4.intValue(), r10, r9, r11);
        goto L9
    L10:
        r10.restore();
    }

    private final void setLetterPaint(int r6) {
        if (isTouchedLetter(r6) == false) goto L5;
        this.mLetterPaint.setColor(this.mHasChosenLetterFontColor);
    L6:
        this.mLetterPaint.setFakeBoldText(false);
        this.mLetterPaint.setTextSize(this.dotLetterTextSizePx);
        List<LBLetter> r0 = this.mLetters;
        Intrinsics.checkNotNull(r0);
        if (StringsKt.startsWith$default(r0.get(r6).getLetter(), LibrarianImpl.Constants.DOT, false, 2, null) == true) goto L13;
        List<LBLetter> r1 = this.mLetters;
        Intrinsics.checkNotNull(r1);
        if (r1.get(r6).getType() != 1) goto L11;
        this.mLetterPaint.setTextSize(this.mLetterLocaleFontSize);
        this.mLetterPaint.setFakeBoldText(true);
        return;
    L11:
        this.mLetterPaint.setTextSize(this.mLetterFontSize);
        return;
    L13:
        return;
    L5:
        this.mLetterPaint.setColor(this.mNoChosenLetterFontColor);
        goto L6
    }

    private final void drawHighlightIcon(int r2, Canvas r3, float r4, float r5) {
        if (isTouchedLetter(r2) == true) goto L5;
        return;
    L5:
        if (this.mSettled == false) goto L9;
        Bitmap r6 = this.mHighlightIcon;
        Intrinsics.checkNotNull(r6);
        r3.drawBitmap(r6, this.mHighlightIconStartX, r5 - (this.mHighlightIconHeight / 2), getBitmapTintPaint(this.mHasChosenLetterFontColor));
        return;
    }

    private final void drawHighlightBackground(int r4, Canvas r5, float r6, float r7) {
        if (isTouchedLetter(r4) == true) goto L5;
        return;
    L5:
        if (this.mSettled == false) goto L9;
        Paint r8 = new Paint();
        r8.setColor(getContext().getResources().getColor(R.color.Transparent));
        LettersBar r9 = this;
        int r1 = OUnitExtensionKt.vdp(r9, 14);
        OUnitExtensionKt.vdp(r9, 14);
        float r10 = r1 / 2.0f;
        int r3 = this.mLetterFontCenterX;
        r5.drawRoundRect(new RectF(r3 - r10, r7 - r10, r3 + r10, r7 + r10), r10, r10, r8);
        return;
    }

    private final void drawSymbol(int r5, Canvas r6, float r7, float r8) {
        List<LBLetter> r9 = this.mLetters;
        if (r9 != null) goto L5;
        LBLetter r10 = null;
    L6:
        if (r10 != null) goto L8;
        return;
    L8:
        Bitmap[] r11 = r10.getLetterBitmaps();
        if (r11 != null) goto L12;
        return;
    L12:
        if (isTouchedLetter(r5) == true) goto L14;
    L16:
        boolean r12 = false;
    L18:
        if (isHolderState() == false) goto L20;
    L23:
        boolean r2 = true;
    L25:
        if (r12 == false) goto L27;
        Bitmap r0 = r11[2];
    L30:
        if (r0 != null) goto L34;
        r0 = r11[0];
        if (r0 != null) goto L34;
        return;
    L34:
        if (r12 == false) goto L36;
        int r13 = this.mHasChosenLetterFontColor;
    L37:
        r6.drawBitmap(r0, this.mLetterFontCenterX - (r0.getWidth() / 2), r8 - (r0.getHeight() / 2), getBitmapTintPaint(r13));
        return;
    L36:
        r13 = this.mNoChosenLetterFontColor;
        goto L37
    L27:
        if (r2 == false) goto L29;
        r0 = r11[1];
        goto L30
    L29:
        r0 = r11[0];
        goto L30
    L20:
        if (this.mSettled == false) goto L23;
        r2 = false;
        goto L25
    L14:
        if (this.mSettled == false) goto L16;
        r12 = true;
        goto L18
    L5:
        r10 = (LBLetter) CollectionsKt.getOrNull(r9, r5);
        goto L6
    }

    private final void drawLetter(int r6, Canvas r7, float r8, float r9) {
        List<LBLetter> r0 = this.mLetters;
        Intrinsics.checkNotNull(r0);
        String r1 = r0.get(r6).getLetter();
        if (StringsKt.startsWith$default(r1, LibrarianImpl.Constants.DOT, false, 2, null) == false) goto L5;
        drawDot(r6, r7, r8, r9);
        return;
    L5:
        Paint.FontMetricsInt r10 = this.mLetterPaint.getFontMetricsInt();
        r7.drawText(r1, r8, (r9 - ((r10.bottom - r10.top) / 2)) - r10.top, this.mLetterPaint);
    }

    private final void drawDot(int r2, Canvas r3, float r4, float r5) {
        Bitmap r6 = this.mDotIcon;
        if (r6 == null) goto L7;
        r3.drawBitmap(r6, this.mDotIconX, r5 - (r6.getHeight() / 2), getBitmapTintPaint(this.mLetterPaint.getColor()));
        return;
    }

    private final Paint getBitmapTintPaint(int r4) {
        this.mBitmapPaint.setColorFilter(new PorterDuffColorFilter(r4, PorterDuff.Mode.SRC_IN));
        return this.mBitmapPaint;
    }

    private final int measureHeight(int r2) {
        int r1 = View.MeasureSpec.getMode(r2);
        int r3 = View.MeasureSpec.getSize(r2);
        if (r1 != Integer.MIN_VALUE) goto L5;
        return r3;
    L5:
        if (r1 == 1073741824) goto L9;
        return 0;
    L9:
        return r3;
    }

    private final float getSingleLetterHeight(int r3, ArrayList<Integer> r4) {
        return (float) Math.max(r3 / r4.size(), this.mSingleLetterMinHeight);
    }

    private final ArrayList<Integer> calculateVisibleLettersIndexes() {
        ArrayList<Integer> r0 = new ArrayList();
        int r1 = this.mLetterBarHeight;
        List<LBLetter> r2 = this.mLetters;
        Intrinsics.checkNotNull(r2);
        if ((r1 / r2.size()) >= this.mSingleLetterMinHeight) goto L5;
        List<LBLetter> r3 = this.mLetters;
        Intrinsics.checkNotNull(r3);
        int r4 = (int) Math.max(2.0d, ((int) Math.ceil(r3.size() / ((this.mLetterBarHeight / this.mSingleLetterMinHeight) - 2))) * 2);
    L6:
        r0.add(0);
        List<LBLetter> r5 = this.mLetters;
        Intrinsics.checkNotNull(r5);
        if (r4 >= (r5.size() / 2)) goto L12;
        int r6 = r4;
    L9:
        List<LBLetter> r7 = this.mLetters;
        Intrinsics.checkNotNull(r7);
        if (r6 >= (r7.size() - 1)) goto L12;
        r0.add(Integer.valueOf(r6));
        r6 = r6 + r4;
    L12:
        List<LBLetter> r8 = this.mLetters;
        Intrinsics.checkNotNull(r8);
        if (r4 >= r8.size()) goto L15;
        List<LBLetter> r9 = this.mLetters;
        Intrinsics.checkNotNull(r9);
        r0.add(Integer.valueOf(r9.size() - 1));
    L15:
        return r0;
    L5:
        r4 = 1;
        goto L6
    }

    private final boolean isHolderState() {
        if (this.mChosenLetterIndex == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    private final boolean isTouchedLetter(int r1) {
        if (this.mChosenLetterIndex != r1) goto L5;
        return true;
    L5:
        return false;
    }

    private final void setTouchedLetter(int r1) {
        this.mChosenLetterIndex = r1;
        invalidate();
    }
}
