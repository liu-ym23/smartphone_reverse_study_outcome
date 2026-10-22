package com.obric.oui.indexscrollbar;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.obric.common.oui.R;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.material.MaterialConfigFormatNames;
import com.ttnet.org.chromium.net.NetError;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tmsdk.common.ErrorCode;

/* JADX INFO: compiled from: OIndexScrollbar.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\bF\u0018\u0000 §\u00012\u00020\u0001:\n¦\u0001§\u0001¨\u0001©\u0001ª\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010^\u001a\u00020\b2\u0006\u0010_\u001a\u00020`H\u0002J\b\u0010a\u001a\u00020bH\u0002J\u0010\u0010c\u001a\u00020\n2\u0006\u0010d\u001a\u00020eH\u0016J\b\u0010f\u001a\u0004\u0018\u000105J\b\u0010g\u001a\u00020bH\u0002J\b\u0010h\u001a\u00020\bH\u0002J\u0006\u0010i\u001a\u00020bJ\u000e\u0010i\u001a\u00020b2\u0006\u0010j\u001a\u00020\nJ\b\u0010k\u001a\u00020bH\u0002J\u000e\u0010l\u001a\u00020b2\u0006\u0010\u0002\u001a\u00020\u0003J\b\u0010m\u001a\u00020bH\u0002J\u0006\u0010n\u001a\u00020bJ\b\u0010o\u001a\u00020bH\u0002J-\u0010p\u001a\u00020b2\b\u0010q\u001a\u0004\u0018\u00010\\2\u0016\u0010r\u001a\u0012\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010+0*\u0018\u00010*¢\u0006\u0002\u0010sJ\u001d\u0010t\u001a\u00020b2\u0010\u0010u\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010+\u0018\u00010*¢\u0006\u0002\u0010vJ\u0006\u0010w\u001a\u00020\nJ\u0006\u0010x\u001a\u00020\nJ\u0006\u0010y\u001a\u00020\nJ\u0006\u0010z\u001a\u00020\nJ\u0006\u0010{\u001a\u00020\nJ\u0010\u0010|\u001a\u00020\b2\u0006\u0010}\u001a\u00020\bH\u0002J\u0019\u0010~\u001a\u00020b2\u0006\u0010\u007f\u001a\u00020#2\u0007\u0010\u0080\u0001\u001a\u00020#H\u0002J\t\u0010\u0081\u0001\u001a\u00020bH\u0002J6\u0010\u0082\u0001\u001a\u00020b2\u0007\u0010\u0083\u0001\u001a\u00020\n2\u0007\u0010\u0084\u0001\u001a\u00020\b2\u0007\u0010\u0085\u0001\u001a\u00020\b2\u0007\u0010\u0086\u0001\u001a\u00020\b2\u0007\u0010\u0087\u0001\u001a\u00020\bH\u0014J\u001b\u0010\u0088\u0001\u001a\u00020b2\u0007\u0010\u0089\u0001\u001a\u00020\b2\u0007\u0010\u008a\u0001\u001a\u00020\bH\u0014J\u0011\u0010\u008b\u0001\u001a\u00020b2\u0006\u0010d\u001a\u00020eH\u0002J\t\u0010\u008c\u0001\u001a\u00020bH\u0002J\u001b\u0010\u008d\u0001\u001a\u00020b2\u0007\u0010\u008e\u0001\u001a\u00020N2\u0007\u0010\u008f\u0001\u001a\u00020\bH\u0014J\u0012\u0010\u0090\u0001\u001a\u00020b2\u0007\u0010\u0091\u0001\u001a\u00020\bH\u0002J\u0012\u0010\u0092\u0001\u001a\u00020b2\u0007\u0010\u0093\u0001\u001a\u00020\nH\u0002J\u0010\u0010\u0094\u0001\u001a\u00020b2\u0007\u0010\u0095\u0001\u001a\u00020\nJ\u0010\u0010\u0096\u0001\u001a\u00020b2\u0007\u0010\u0097\u0001\u001a\u00020\bJ\u0010\u0010\u0098\u0001\u001a\u00020b2\u0007\u0010\u0099\u0001\u001a\u00020\nJ\u0012\u0010\u009a\u0001\u001a\u00020b2\t\u0010\u009b\u0001\u001a\u0004\u0018\u00010IJ\u0012\u0010\u009c\u0001\u001a\u00020b2\u0007\u0010\u0099\u0001\u001a\u00020\nH\u0002J\u0012\u0010\u009d\u0001\u001a\u00020b2\u0007\u0010\u009e\u0001\u001a\u00020\bH\u0002J\u0012\u0010\u009f\u0001\u001a\u00020b2\t\u0010\u009b\u0001\u001a\u0004\u0018\u00010ZJ\u001b\u0010 \u0001\u001a\u00020b2\u0007\u0010¡\u0001\u001a\u00020N2\u0007\u0010\u0097\u0001\u001a\u00020\bH\u0002J\u001b\u0010¢\u0001\u001a\u00020b2\u0007\u0010¡\u0001\u001a\u00020N2\u0007\u0010\u0097\u0001\u001a\u00020\bH\u0002J\t\u0010£\u0001\u001a\u00020bH\u0002J\u0014\u0010¤\u0001\u001a\u00020b2\t\u0010¥\u0001\u001a\u0004\u0018\u00010NH\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000eX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\bX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\bX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u000e\u0010\u0016\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\u00020\bX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0018\u00010\u001fR\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010)\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010+0*0*X\u0082.¢\u0006\u0004\n\u0002\u0010,R\u000e\u0010-\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00101\u001a\b\u0012\u0004\u0012\u00020302X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u0004\u0018\u00010<X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010B\u001a\u0004\u0018\u00010CX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010H\u001a\u0004\u0018\u00010IX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010J\u001a\u0004\u0018\u00010CX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010K\u001a\u0004\u0018\u00010LX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010M\u001a\u0004\u0018\u00010NX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010O\u001a\u0004\u0018\u00010PX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Q\u001a\u0004\u0018\u00010NX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Y\u001a\u0004\u0018\u00010ZX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010[\u001a\u0004\u0018\u00010\\X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010]\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006«\u0001"}, d2 = {"Lcom/obric/oui/indexscrollbar/OIndexScrollbar;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "DEFAULTX", "", "OIndexScrollbar_DEBUG", "", "getOIndexScrollbar_DEBUG", "()Z", "OIndexScrollbar_TAG", "", "getOIndexScrollbar_TAG", "()Ljava/lang/String;", "POUND_POSITION_BOTTOM", "getPOUND_POSITION_BOTTOM", "()I", "POUND_POSITION_TOP", "getPOUND_POSITION_TOP", "STATE_END", "STATE_MOVE", "STATE_START", "SURNAME_NUM_COLUMNS_THRESHOLD", "SURNAME_NUM_ROWS_THRESHOLD", "VISIBILITY_LIMIT", "getVISIBILITY_LIMIT", "lastVibratedLetter", "mAlphabetsAdapter", "Lcom/obric/oui/indexscrollbar/OIndexScrollbar$AlphabetsAdapter;", "mColumnCount", "mContext", "mCurrentRawX", "", "mEndX", "mGridView", "Landroid/widget/GridView;", "mHasPerformedLongPress", "mHostX", "mIconsForSymbols", "", "Landroid/graphics/Bitmap;", "[[Landroid/graphics/Bitmap;", "mIsPerformingHideAnim", "mIsPerformingShowAnim", "mLastRawX", "mLetterbarShadowWidth", "mLetters", "", "Lcom/obric/oui/indexscrollbar/LBLetter;", "mLettersBar", "Lcom/obric/oui/indexscrollbar/LettersBar;", "mLettersBarOccupiedWidth", "mLongPressEnabled", "mMeasuredHeight", "mMinXDistance", "mMissX", "mPopupFlowLayout", "Lcom/obric/oui/indexscrollbar/SurnameFlowLayout;", "mPopupGridView", "Lcom/obric/oui/indexscrollbar/SurnameGridView;", "mPopupViewMaxHeight", "mPopupViewPendingHorizontal", "mPopupViewPendingVertical", "mPopupWindow", "Landroid/widget/PopupWindow;", "mPopupYOffset", "mPoundPosition", "mPoundVisibility", "mPrePosition", "mQBListener", "Lcom/obric/oui/indexscrollbar/OIndexScrollbar$QBListener;", "mSecondPopup", "mSecondPopupView", "Landroid/widget/TextView;", "mSecondPopupViewArrow", "Landroid/view/View;", "mSecondPopupViewParent", "Landroid/view/ViewGroup;", "mShadowView", "mStartX", "mState", "mSurnameGridViewColumnsThreshold", "mSurnameGridViewItemHeight", "mSurnameGridViewItemWidth", "mSurnameGridViewNumColumns", "mSurnameGridViewNumRows", "mSurnameListener", "Lcom/obric/oui/indexscrollbar/OIndexScrollbar$SurnameListener;", "mSymbols", "", "mWidth", "dipToPx", "dipValue", "", "dismissPopupWindow", "", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "getLetterBar", "getParentxPos", "getScreenWidth", "hideLetterGrid", "withAnim", "hideLetterGridWithAnim", "init", "initGridView", "initLetters", "initLettersBar", "initSpecialIcons", "symbols", "bitmaps", "([I[[Landroid/graphics/Bitmap;)V", "initSpecialSelectedIcons", "bitmapsSelected", "([Landroid/graphics/Bitmap;)V", "isLetterGridHidden", "isLetterGridHide", "isLetterGridShow", "isLetterGridShown", "isPerformingAnim", "measureHeight", "measureSpec", "moveQuickBar", MaterialConfigFormatNames.X, "missX", "onHideLetterGridAnimationEnd", "onLayout", "changed", "l", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onMoveInLongPressState", "onShowLetterGridAnimationEnd", "onVisibilityChanged", "changedView", "visibility", "setHostWidth", "hostWidth", "setLettersBarBg", "showBg", "setLongPressEnabled", "enabled", "setPoundPosition", "position", "setPoundVisibility", "visible", "setQBListener", "listener", "setShadowVisible", "setState", "state", "setSurnameListener", "showFlowPopupWindow", "alphabetView", "showGridPopupWindow", "showLetterGridWithAnim", "showSecondPopupWindow", "anchorView", "AlphabetsAdapter", "Companion", "QBListener", "SurnameAdapter", "SurnameListener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OIndexScrollbar extends LinearLayout {
    public static final Companion Companion = null;
    public static final int LETTER_CHANGED_CLICK = 1;
    public static final int LETTER_CHANGED_SLIDE = 0;
    private final int DEFAULTX;
    private final boolean OIndexScrollbar_DEBUG;
    private final String OIndexScrollbar_TAG;
    private final int POUND_POSITION_BOTTOM;
    private final int POUND_POSITION_TOP;
    private final int STATE_END;
    private final int STATE_MOVE;
    private final int STATE_START;
    private final int SURNAME_NUM_COLUMNS_THRESHOLD;
    private final int SURNAME_NUM_ROWS_THRESHOLD;
    private final int VISIBILITY_LIMIT;
    private String lastVibratedLetter;
    private AlphabetsAdapter mAlphabetsAdapter;
    private final int mColumnCount;
    private Context mContext;
    private float mCurrentRawX;
    private int mEndX;
    private GridView mGridView;
    private boolean mHasPerformedLongPress;
    private int mHostX;
    private Bitmap[][] mIconsForSymbols;
    private boolean mIsPerformingHideAnim;
    private boolean mIsPerformingShowAnim;
    private float mLastRawX;
    private int mLetterbarShadowWidth;
    private final List<LBLetter> mLetters;
    private LettersBar mLettersBar;
    private int mLettersBarOccupiedWidth;
    private boolean mLongPressEnabled;
    private int mMeasuredHeight;
    private int mMinXDistance;
    private float mMissX;
    private SurnameFlowLayout mPopupFlowLayout;
    private SurnameGridView mPopupGridView;
    private int mPopupViewMaxHeight;
    private int mPopupViewPendingHorizontal;
    private int mPopupViewPendingVertical;
    private PopupWindow mPopupWindow;
    private int mPopupYOffset;
    private int mPoundPosition;
    private boolean mPoundVisibility;
    private int mPrePosition;
    private QBListener mQBListener;
    private PopupWindow mSecondPopup;
    private TextView mSecondPopupView;
    private View mSecondPopupViewArrow;
    private ViewGroup mSecondPopupViewParent;
    private View mShadowView;
    private int mStartX;
    private int mState;
    private int mSurnameGridViewColumnsThreshold;
    private int mSurnameGridViewItemHeight;
    private int mSurnameGridViewItemWidth;
    private int mSurnameGridViewNumColumns;
    private int mSurnameGridViewNumRows;
    private SurnameListener mSurnameListener;
    private int[] mSymbols;
    private int mWidth;

    /* JADX INFO: compiled from: OIndexScrollbar.kt */
    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0080\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0014\u001a\u00020\u0010H\u0016J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0010H\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u0010H\u0016J\"\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u00102\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0010H\u0016J\u0010\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0010H\u0002J\u001b\u0010 \u001a\u00020!2\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0002\u0010#R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0007R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082.¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006$"}, d2 = {"Lcom/obric/oui/indexscrollbar/OIndexScrollbar$AlphabetsAdapter;", "Landroid/widget/BaseAdapter;", "mContext", "Landroid/content/Context;", "(Lcom/obric/oui/indexscrollbar/OIndexScrollbar;Landroid/content/Context;)V", "isNeedIncreaseHeight", "", "()Z", "mAlphabets", "", "", "[Ljava/lang/String;", "mCurrentLanguage", "mNumRows", "", "mTotalVerticalSpacing", "", "singleCellHeight", "getSingleCellHeight", "()I", "getCount", "getItem", "position", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "isEnabled", "isNeedInsreaseHeightPosition", "setAlphabets", "", "alphabets", "([Ljava/lang/String;)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class AlphabetsAdapter extends BaseAdapter {
        private String[] mAlphabets;
        private final Context mContext;
        private final String mCurrentLanguage;
        private final float mNumRows;
        private final int mTotalVerticalSpacing;
        final /* synthetic */ OIndexScrollbar this$0;

        @Override // android.widget.Adapter
        public long getItemId(int r1) {
            return r1;
        }

        public AlphabetsAdapter(OIndexScrollbar r3, Context r4) {
            Intrinsics.checkNotNullParameter(r3, "this$0");
            this.this$0 = r3;
            this.mContext = r4;
            String r5 = Locale.getDefault().getLanguage();
            Intrinsics.checkNotNullExpressionValue(r5, "getDefault().language");
            this.mCurrentLanguage = r5;
            float r6 = AlphabetsConfig.INSTANCE.numRowsByLanguage(r5);
            this.mNumRows = r6;
            int r7 = ((int) Math.ceil(r6)) - 1;
            GridView r8 = OIndexScrollbar.access$getMGridView$p(r3);
            Intrinsics.checkNotNull(r8);
            this.mTotalVerticalSpacing = r7 * r8.getVerticalSpacing();
        }

        @Override // android.widget.Adapter
        public /* bridge */ /* synthetic */ Object getItem(int r1) {
            return getItem(r1);
        }

        public final void setAlphabets(String[] r1) {
            if (r1 == null) goto L5;
            this.mAlphabets = r1;
            return;
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean isEnabled(int r5) {
            AlphabetsConfig r0 = AlphabetsConfig.INSTANCE;
            String[] r1 = this.mAlphabets;
            String[] r2 = null;
            if (r1 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("mAlphabets");
            r1 = null;
        L6:
            if (r0.isPlaceholder(r1[r5]) == true) goto L14;
            AlphabetsConfig r3 = AlphabetsConfig.INSTANCE;
            String[] r4 = this.mAlphabets;
            if (r4 != null) goto L10;
            Intrinsics.throwUninitializedPropertyAccessException("mAlphabets");
        L12:
            if (r3.isDisabled(r2[r5]) == true) goto L14;
            return true;
        L10:
            r2 = r4;
        L14:
            return false;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.mAlphabets != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("mAlphabets");
        L5:
            String[] r2 = this.mAlphabets;
            if (r2 != null) goto L9;
            Intrinsics.throwUninitializedPropertyAccessException("mAlphabets");
            r2 = null;
        L9:
            return r2.length;
        }

        @Override // android.widget.Adapter
        public String getItem(int r1) {
            String[] r0 = this.mAlphabets;
            if (r0 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("mAlphabets");
            r0 = null;
        L6:
            return r0[r1];
        }

        private final boolean isNeedIncreaseHeight() {
            if (((int) ((OIndexScrollbar.access$getMMeasuredHeight$p(this.this$0) - this.mTotalVerticalSpacing) % this.mNumRows)) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        private final int getSingleCellHeight() {
            return (int) ((OIndexScrollbar.access$getMMeasuredHeight$p(this.this$0) - this.mTotalVerticalSpacing) / this.mNumRows);
        }

        private final boolean isNeedInsreaseHeightPosition(int r3) {
            if (r3 != (getCount() - 1)) goto L5;
            return true;
        L5:
            if (r3 != (getCount() - 2)) goto L7;
            return true;
        L7:
            if (r3 == (getCount() - 3)) goto L13;
            return false;
        L13:
            return true;
        }

        @Override // android.widget.Adapter
        public View getView(int r13, AlphabetView r14, ViewGroup r15) {
            Intrinsics.checkNotNullParameter(r15, "parent");
            String[] r16 = this.mAlphabets;
            if (r16 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("mAlphabets");
            r16 = null;
        L5:
            String r17 = r16[r13];
            int r1 = getSingleCellHeight();
            float r2 = OIndexScrollbar.access$getMMeasuredHeight$p(this.this$0) - this.mTotalVerticalSpacing;
            float r4 = this.mNumRows;
            int r3 = (int) (r2 - (r1 * r4));
            if (r4 != 9.0f) goto L8;
            boolean r5 = true;
        L9:
            if (r5 == true) goto L11;
        L15:
            if (r14 != null) goto L30;
            if (AlphabetsConfig.INSTANCE.isSymbol(r17) == false) goto L19;
            ImageView r18 = new ImageView(this.mContext);
            r18.setImageResource(R.drawable.letter_bar_unfold_button);
            r18.setScaleType(ImageView.ScaleType.CENTER);
            r18.setMinimumHeight(r1);
            r14 = r18;
            goto L30
        L19:
            AlphabetView r19 = new AlphabetView(this.mContext, null, 0, 6, null);
            r19.setHeight(r1);
            if (AlphabetsConfig.INSTANCE.isDisabled(r17) == false) goto L23;
            r19.setTextColor(Color.parseColor("#80000000"));
            r17 = r17.substring(1);
            Intrinsics.checkNotNullExpressionValue(r17, "this as java.lang.String).substring(startIndex)");
        L23:
            if (AlphabetsConfig.INSTANCE.isPlaceholder(r17) == true) goto L26;
            r19.setText(r17);
        L26:
            if (AlphabetsConfig.INSTANCE.isRussianAlphabet(r17) == false) goto L28;
            r19.setTypeface(null, 0);
        L28:
            r14 = r19;
        L30:
            if (((r13 / 3) % 2) != 0) goto L32;
            Context r12 = this.mContext;
            Intrinsics.checkNotNull(r12);
            Drawable r110 = r12.getResources().getDrawable(R.drawable.quickbar_ex_alphabet_text_light_colorlist);
        L33:
            r14.setBackground(r110);
            return r14;
        L32:
            Context r111 = this.mContext;
            Intrinsics.checkNotNull(r111);
            r110 = r111.getResources().getDrawable(R.drawable.quickbar_ex_alphabet_text_dark_colorlist);
            goto L33
        L11:
            if (isNeedIncreaseHeight() == false) goto L15;
            if (isNeedInsreaseHeightPosition(r13) == false) goto L15;
            r1 = r1 + r3;
            goto L15
        L8:
            r5 = false;
            goto L9
        }
    }

    /* JADX INFO: compiled from: OIndexScrollbar.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/indexscrollbar/OIndexScrollbar$Companion;", "", "()V", "LETTER_CHANGED_CLICK", "", "LETTER_CHANGED_SLIDE", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: OIndexScrollbar.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\tH&¨\u0006\u000b"}, d2 = {"Lcom/obric/oui/indexscrollbar/OIndexScrollbar$QBListener;", "", "onLetterChanged", "", "letter", "", "type", "", "onLetterGridHidden", "", "onLetterGridShow", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface QBListener {
        boolean onLetterChanged(String r1, int r2);

        void onLetterGridHidden();

        void onLetterGridShow();
    }

    /* JADX INFO: compiled from: OIndexScrollbar.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\tH\u0016J\"\u0010\u000f\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/obric/oui/indexscrollbar/OIndexScrollbar$SurnameAdapter;", "Landroid/widget/BaseAdapter;", "context", "Landroid/content/Context;", "surnames", "", "", "(Lcom/obric/oui/indexscrollbar/OIndexScrollbar;Landroid/content/Context;Ljava/util/List;)V", "getCount", "", "getItem", "", "position", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private final class SurnameAdapter extends BaseAdapter {
        private final Context context;
        private final List<String> surnames;
        final /* synthetic */ OIndexScrollbar this$0;

        @Override // android.widget.Adapter
        public long getItemId(int r1) {
            return 0;
        }

        public SurnameAdapter(OIndexScrollbar r2, Context r3, List<String> r4) {
            Intrinsics.checkNotNullParameter(r2, "this$0");
            this.this$0 = r2;
            this.context = r3;
            this.surnames = r4;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            List<String> r0 = this.surnames;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int r1) {
            List<String> r0 = this.surnames;
            if (r0 != null) goto L5;
            String r2 = null;
        L6:
            Intrinsics.checkNotNull(r2);
            return r2;
        L5:
            r2 = r0.get(r1);
            goto L6
        }

        @Override // android.widget.Adapter
        public View getView(int r3, View r4, ViewGroup r5) {
            Intrinsics.checkNotNullParameter(r5, "parent");
            if (r4 != null) goto L5;
            r4 = LayoutInflater.from(this.context).inflate(R.layout.o_surname_popup_item_ex, null);
            r4.setLayoutParams(new AbsListView.LayoutParams(OIndexScrollbar.access$getMSurnameGridViewItemWidth$p(this.this$0), OIndexScrollbar.access$getMSurnameGridViewItemHeight$p(this.this$0)));
        L5:
            int r6 = r3 % OIndexScrollbar.access$getMSurnameGridViewColumnsThreshold$p(this.this$0);
            if (r6 == 0) goto L8;
        L12:
            if (r6 != 0) goto L17;
            if (r4 == null) goto L27;
            r4.setBackgroundResource(R.drawable.surname_popup_item_right);
        L27:
            if (r4 == null) goto L31;
            List<String> r2 = this.surnames;
            Intrinsics.checkNotNull(r2);
            ((TextView) r4).setText(r2.get(r3).toString());
            return r4;
        L31:
            throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
        L17:
            if (r6 != (OIndexScrollbar.access$getMSurnameGridViewColumnsThreshold$p(this.this$0) - 1)) goto L19;
        L24:
            if (r4 == null) goto L27;
            r4.setBackgroundResource(R.drawable.surname_popup_item_left);
            goto L27
        L19:
            if (r3 == (getCount() - 1)) goto L24;
            if (r4 == null) goto L27;
            r4.setBackgroundResource(R.drawable.surname_popup_item_middle);
            goto L27
        L8:
            if (r3 != (getCount() - 1)) goto L12;
            if (r4 == null) goto L27;
            r4.setBackgroundResource(R.drawable.surname_popup_item_special);
            goto L27
        }
    }

    /* JADX INFO: compiled from: OIndexScrollbar.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0004H&¨\u0006\t"}, d2 = {"Lcom/obric/oui/indexscrollbar/OIndexScrollbar$SurnameListener;", "", "getMatchedSurnames", "", "", "letter", "onSurnameClicked", "", "surname", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface SurnameListener {
        List<String> getMatchedSurnames(String r1);

        void onSurnameClicked(String r1);
    }

    /* JADX INFO: renamed from: com.obric.oui.indexscrollbar.OIndexScrollbar$showGridPopupWindow$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: OIndexScrollbar.kt */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/oui/indexscrollbar/OIndexScrollbar$showGridPopupWindow$2", "Lcom/obric/oui/indexscrollbar/SurnameGridView$OnPressChangeListener;", "onTouched", "", "position", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class C02782 implements SurnameGridView.OnPressChangeListener {
        final /* synthetic */ OIndexScrollbar this$0;

        public static /* synthetic */ void $r8$lambda$jcPBojrYFSDRAX9UYYLZMKg3iE8(OIndexScrollbar r0) {
            m371onTouched$lambda0(r0);
        }

        C02782(OIndexScrollbar r1) {
            this.this$0 = r1;
        }

        @Override // com.obric.oui.indexscrollbar.SurnameGridView.OnPressChangeListener
        public void onTouched(int r4) {
            if (r4 != (-1)) goto L5;
            Handler r5 = new Handler(Looper.getMainLooper());
            final OIndexScrollbar r3 = this.this$0;
            r5.postDelayed(new OIndexScrollbar$showGridPopupWindow$2$$ExternalSyntheticLambda0(r3), 100);
            return;
        L5:
            SurnameGridView r0 = OIndexScrollbar.access$getMPopupGridView$p(this.this$0);
            Intrinsics.checkNotNull(r0);
            SurnameGridView r1 = OIndexScrollbar.access$getMPopupGridView$p(this.this$0);
            Intrinsics.checkNotNull(r1);
            View r2 = r0.getChildAt(r4 - r1.getFirstVisiblePosition());
            Intrinsics.checkNotNullExpressionValue(r2, "mPopupGridView!!.getChil…etFirstVisiblePosition())");
            SurnameGridView r6 = OIndexScrollbar.access$getMPopupGridView$p(this.this$0);
            Intrinsics.checkNotNull(r6);
            Object r7 = r6.getAdapter().getItem(r4);
            if (r7 == null) goto L10;
            r2.setTag((String) r7);
            OIndexScrollbar.access$showSecondPopupWindow(this.this$0, r2);
            return;
        L10:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }

        /* JADX INFO: renamed from: onTouched$lambda-0, reason: not valid java name */
        private static final void m371onTouched$lambda0(OIndexScrollbar r1) {
            Intrinsics.checkNotNullParameter(r1, "this$0");
            OIndexScrollbar.access$showSecondPopupWindow(r1, null);
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$GQ8NdoATk-d1fv1bwVtpK4MutQo, reason: not valid java name */
    public static /* synthetic */ void m363$r8$lambda$GQ8NdoATkd1fv1bwVtpK4MutQo(OIndexScrollbar r0, AdapterView r1, View r2, int r3, long r4) {
        m365initGridView$lambda2(r0, r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: $r8$lambda$HdsU6sFLUJSmA6H1ocPY-Fo67-g, reason: not valid java name */
    public static /* synthetic */ boolean m364$r8$lambda$HdsU6sFLUJSmA6H1ocPYFo67g(OIndexScrollbar r0, View r1, MotionEvent r2) {
        return m366initGridView$lambda3(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$Jphieuf6Qd8inCKs5D9CwZELcJs(OIndexScrollbar r0, AdapterView r1, View r2, int r3, long r4) {
        m370showGridPopupWindow$lambda10(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ boolean $r8$lambda$VNcMtYMUsAeFbwmoHzZoNp21JUc(OIndexScrollbar r0, AdapterView r1, View r2, int r3, long r4) {
        return m367initGridView$lambda4(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ void $r8$lambda$oWTs8i3tcMMMHMNLbHw_Zsl7zcs(OIndexScrollbar r0, View r1) {
        m368showFlowPopupWindow$lambda7(r0, r1);
    }

    public static /* synthetic */ boolean $r8$lambda$pD_j6uGb4vziMVkotCX0WWNCTpQ(OIndexScrollbar r0, TextView r1, View r2, MotionEvent r3) {
        return m369showFlowPopupWindow$lambda8(r0, r1, r2, r3);
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ OIndexScrollbar(Context r1, AttributeSet r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public static final /* synthetic */ GridView access$getMGridView$p(OIndexScrollbar r0) {
        return r0.mGridView;
    }

    public static final /* synthetic */ int access$getMMeasuredHeight$p(OIndexScrollbar r0) {
        return r0.mMeasuredHeight;
    }

    public static final /* synthetic */ SurnameGridView access$getMPopupGridView$p(OIndexScrollbar r0) {
        return r0.mPopupGridView;
    }

    public static final /* synthetic */ QBListener access$getMQBListener$p(OIndexScrollbar r0) {
        return r0.mQBListener;
    }

    public static final /* synthetic */ int access$getMSurnameGridViewColumnsThreshold$p(OIndexScrollbar r0) {
        return r0.mSurnameGridViewColumnsThreshold;
    }

    public static final /* synthetic */ int access$getMSurnameGridViewItemHeight$p(OIndexScrollbar r0) {
        return r0.mSurnameGridViewItemHeight;
    }

    public static final /* synthetic */ int access$getMSurnameGridViewItemWidth$p(OIndexScrollbar r0) {
        return r0.mSurnameGridViewItemWidth;
    }

    public static final /* synthetic */ void access$onHideLetterGridAnimationEnd(OIndexScrollbar r0) {
        r0.onHideLetterGridAnimationEnd();
    }

    public static final /* synthetic */ void access$onShowLetterGridAnimationEnd(OIndexScrollbar r0) {
        r0.onShowLetterGridAnimationEnd();
    }

    public static final /* synthetic */ void access$setLastVibratedLetter$p(OIndexScrollbar r0, String r1) {
        r0.lastVibratedLetter = r1;
    }

    public static final /* synthetic */ void access$setLettersBarBg(OIndexScrollbar r0, boolean r1) {
        r0.setLettersBarBg(r1);
    }

    public static final /* synthetic */ void access$setMIsPerformingHideAnim$p(OIndexScrollbar r0, boolean r1) {
        r0.mIsPerformingHideAnim = r1;
    }

    public static final /* synthetic */ void access$setMIsPerformingShowAnim$p(OIndexScrollbar r0, boolean r1) {
        r0.mIsPerformingShowAnim = r1;
    }

    public static final /* synthetic */ void access$setShadowVisible(OIndexScrollbar r0, boolean r1) {
        r0.setShadowVisible(r1);
    }

    public static final /* synthetic */ void access$showSecondPopupWindow(OIndexScrollbar r0, View r1) {
        r0.showSecondPopupWindow(r1);
    }

    public OIndexScrollbar(Context r4, AttributeSet r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5);
        this.OIndexScrollbar_TAG = "OIndexScrollbar";
        this.OIndexScrollbar_DEBUG = Log.isLoggable("OIndexScrollbar", 3);
        this.STATE_START = 1;
        this.STATE_MOVE = 2;
        this.STATE_END = 3;
        this.mState = 1;
        this.mLetters = new ArrayList();
        this.mPoundVisibility = true;
        this.POUND_POSITION_TOP = 1;
        this.POUND_POSITION_BOTTOM = 2;
        this.mPoundPosition = 2;
        this.SURNAME_NUM_COLUMNS_THRESHOLD = 8;
        this.SURNAME_NUM_ROWS_THRESHOLD = 8;
        this.mColumnCount = 3;
        this.DEFAULTX = ErrorCode.ERR_LICENSE_EXPIRED;
        this.mHostX = ErrorCode.ERR_LICENSE_EXPIRED;
        init(r4);
        this.VISIBILITY_LIMIT = 30;
        this.mPrePosition = -1;
        this.mLongPressEnabled = true;
    }

    public final String getOIndexScrollbar_TAG() {
        return this.OIndexScrollbar_TAG;
    }

    public final boolean getOIndexScrollbar_DEBUG() {
        return this.OIndexScrollbar_DEBUG;
    }

    public final int getPOUND_POSITION_TOP() {
        return this.POUND_POSITION_TOP;
    }

    public final int getPOUND_POSITION_BOTTOM() {
        return this.POUND_POSITION_BOTTOM;
    }

    public final int getVISIBILITY_LIMIT() {
        return this.VISIBILITY_LIMIT;
    }

    public final void setQBListener(QBListener r1) {
        this.mQBListener = r1;
    }

    public final void setSurnameListener(SurnameListener r1) {
        this.mSurnameListener = r1;
    }

    public final void initSpecialIcons(int[] r5, Bitmap[][] r6) {
        if (r5 == null) goto L26;
        if (r6 != null) goto L6;
        return;
    L6:
        if (r5.length == 0) goto L27;
        Bitmap[][] r0 = r6;
        if (r0.length == 0) goto L29;
        boolean r2 = true;
        if (r5.length != r0.length) goto L13;
        boolean r1 = true;
    L14:
        if (r1 == false) goto L25;
        if (r6[0].length == 3) goto L19;
        r2 = false;
    L19:
        if (r2 == false) goto L23;
        this.mSymbols = r5;
        this.mIconsForSymbols = r6;
        initLetters();
        return;
    L23:
        throw new IllegalArgumentException("Paramer bitmaps[x][y], y must is 3 !!!".toString());
    L25:
        throw new IllegalArgumentException("The symbols.length must equals bitmaps.length !".toString());
    L13:
        r1 = false;
        goto L14
    L29:
        return;
    L27:
        return;
    }

    public final void initSpecialSelectedIcons(Bitmap[] r3) {
        if (r3 == null) goto L21;
        int[] r0 = this.mSymbols;
        boolean r1 = false;
        if (r0 != null) goto L7;
    L9:
        if (r1 == true) goto L22;
        Integer r2 = Integer.valueOf(r3.length);
        int[] r4 = this.mSymbols;
        if (r4 != null) goto L14;
        Integer r5 = null;
    L16:
        if (Intrinsics.areEqual(r2, r5) == true) goto L19;
        Log.e(this.OIndexScrollbar_TAG, "Selected icon bitmaps' size is not equal to symbols' size. They should be equal.");
        return;
    L19:
        LettersBar r6 = this.mLettersBar;
        Intrinsics.checkNotNull(r6);
        r6.setBitmapsSelected(r3);
        return;
    L14:
        r5 = Integer.valueOf(r4.length);
        goto L16
    L22:
        return;
    L7:
        if (r0.length != 0) goto L9;
        r1 = true;
        goto L9
    }

    public final void initLetters() {
        this.mLetters.clear();
        int[] r0 = this.mSymbols;
        int r1 = 0;
        if (r0 == null) goto L11;
        Intrinsics.checkNotNull(r0);
        int r2 = r0.length;
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L10;
        int r4 = r3 + 1;
        List<LBLetter> r5 = this.mLetters;
        LBLetter.Companion r6 = LBLetter.Companion;
        int[] r7 = this.mSymbols;
        Intrinsics.checkNotNull(r7);
        String r8 = String.valueOf(r7[r3]);
        Bitmap[][] r9 = this.mIconsForSymbols;
        if (r9 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mIconsForSymbols");
        r9 = null;
    L9:
        r5.add(r6.fromSymbol(r8, r9[r3]));
        r3 = r4;
        goto L5
    L10:
        int[] r10 = this.mSymbols;
        Intrinsics.checkNotNull(r10);
        int r11 = r10.length;
    L12:
        LettersConfig r12 = LettersConfig.INSTANCE;
        String r13 = Locale.getDefault().getLanguage();
        Intrinsics.checkNotNullExpressionValue(r13, "getDefault().language");
        String[] r14 = r12.lettersByLanguage(r13);
        int r15 = r14.length - 1;
    L13:
        if (r1 >= r15) goto L20;
        int r16 = r1 + 1;
        LettersConfig r17 = LettersConfig.INSTANCE;
        String r18 = Locale.getDefault().getLanguage();
        Intrinsics.checkNotNullExpressionValue(r18, "getDefault().language");
        if (r17.isLocaleLetter(r18, r1) == false) goto L17;
        this.mLetters.add(LBLetter.Companion.fromLocaleLetter(r14[r1]));
    L18:
        r1 = r16;
        goto L13
    L17:
        this.mLetters.add(LBLetter.Companion.fromLetter(r14[r1]));
        goto L18
    L20:
        if (this.mPoundVisibility == true) goto L22;
    L25:
        invalidate();
        return;
    L22:
        if (this.mPoundPosition != this.POUND_POSITION_TOP) goto L24;
        this.mLetters.add(r11, LBLetter.Companion.getPOUND());
        goto L25
    L24:
        this.mLetters.add(LBLetter.Companion.getPOUND());
        goto L25
    L11:
        r11 = 0;
        goto L12
    }

    public final void setPoundVisibility(boolean r1) {
        this.mPoundVisibility = r1;
    }

    public final void setPoundPosition(int r1) {
        this.mPoundPosition = r1;
    }

    public final boolean isLetterGridShow() {
        if (this.mIsPerformingShowAnim == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mState == this.STATE_END) goto L8;
        return false;
    }

    public final boolean isLetterGridShown() {
        if (this.mState != this.STATE_END) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isLetterGridHide() {
        if (this.mIsPerformingHideAnim == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mState == this.STATE_START) goto L8;
        return false;
    }

    public final boolean isLetterGridHidden() {
        if (this.mState != this.STATE_START) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isPerformingAnim() {
        if (this.mIsPerformingShowAnim == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mIsPerformingHideAnim == true) goto L8;
        return false;
    }

    public final void hideLetterGrid() {
        hideLetterGrid(true);
    }

    public final void hideLetterGrid(boolean r2) {
        dismissPopupWindow();
        if (isLetterGridHide() == true) goto L8;
        if (r2 == false) goto L6;
        hideLetterGridWithAnim();
        return;
    L6:
        onHideLetterGridAnimationEnd();
        return;
    }

    public final void setLongPressEnabled(boolean r1) {
        this.mLongPressEnabled = r1;
    }

    public final void init(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this.mContext = r5;
        Intrinsics.checkNotNull(r5);
        Resources r6 = r5.getResources();
        LayoutInflater.from(this.mContext).inflate(R.layout.o_index_scrollbar, this, true);
        this.mLettersBarOccupiedWidth = OUnitExtensionKt.vdp(this, 22);
        int r0 = r6.getDimensionPixelOffset(R.dimen.bytedance_quickbar_grid_item_space);
        int r1 = r6.getDimensionPixelOffset(R.dimen.quickbar_ex_grid_column_width);
        this.mMinXDistance = r6.getDimensionPixelOffset(R.dimen.bytedance_quickbar_min_distance);
        this.mLetterbarShadowWidth = r6.getDrawable(R.drawable.letters_bar_background_shadow).getIntrinsicWidth();
        int r2 = (r0 * 2) + this.mLettersBarOccupiedWidth;
        Context r7 = this.mContext;
        Intrinsics.checkNotNull(r7);
        this.mWidth = (r2 + (r1 * r7.getResources().getInteger(R.integer.bytedance_letterbar_gridview_column_num))) + this.mLetterbarShadowWidth;
        initLettersBar();
        initGridView();
        this.mShadowView = findViewById(R.id.iv_letter_bar_shadow);
        setLettersBarBg(false);
    }

    private final void initLettersBar() {
        View r0 = findViewById(R.id.quickbar_left_letters_bar);
        if (r0 == null) goto L7;
        LettersBar r1 = (LettersBar) r0;
        this.mLettersBar = r1;
        Intrinsics.checkNotNull(r1);
        r1.setLetters(this.mLetters);
        LettersBar r2 = this.mLettersBar;
        Intrinsics.checkNotNull(r2);
        r2.setListener(new C02771(this));
        LettersBar r3 = this.mLettersBar;
        Intrinsics.checkNotNull(r3);
        r3.setOnBackgroundVisibleChangedListener(new AnonymousClass2(this));
        initLetters();
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.indexscrollbar.LettersBar");
    }

    private final void initGridView() {
        View r0 = findViewById(R.id.quickbar_right_grid_view);
        if (r0 == null) goto L7;
        this.mGridView = (GridView) r0;
        AlphabetsAdapter r1 = new AlphabetsAdapter(this, this.mContext);
        this.mAlphabetsAdapter = r1;
        Intrinsics.checkNotNull(r1);
        AlphabetsConfig r2 = AlphabetsConfig.INSTANCE;
        String r3 = Locale.getDefault().getLanguage();
        Intrinsics.checkNotNullExpressionValue(r3, "getDefault().language");
        r1.setAlphabets(r2.alphabetsByLanguage(r3));
        GridView r4 = this.mGridView;
        Intrinsics.checkNotNull(r4);
        r4.setAdapter(this.mAlphabetsAdapter);
        GridView r5 = this.mGridView;
        Intrinsics.checkNotNull(r5);
        r5.setOnItemClickListener(new OIndexScrollbar$$ExternalSyntheticLambda0(this));
        GridView r6 = this.mGridView;
        Intrinsics.checkNotNull(r6);
        r6.setOnTouchListener(new OIndexScrollbar$$ExternalSyntheticLambda1(this));
        GridView r7 = this.mGridView;
        Intrinsics.checkNotNull(r7);
        r7.setOnItemLongClickListener(new OIndexScrollbar$$ExternalSyntheticLambda2(this));
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.GridView");
    }

    /* JADX INFO: renamed from: initGridView$lambda-2, reason: not valid java name */
    private static final void m365initGridView$lambda2(OIndexScrollbar r0, AdapterView r1, View r2, int r3, long r4) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        AlphabetsConfig r5 = AlphabetsConfig.INSTANCE;
        AlphabetsAdapter r6 = r0.mAlphabetsAdapter;
        Intrinsics.checkNotNull(r6);
        if (r5.isSymbol(r6.getItem(r3)) == true) goto L7;
        QBListener r7 = r0.mQBListener;
        Intrinsics.checkNotNull(r7);
        AlphabetsAdapter r8 = r0.mAlphabetsAdapter;
        Intrinsics.checkNotNull(r8);
        if (r7.onLetterChanged(r8.getItem(r3), 1) == false) goto L7;
        r0.invalidate();
    L7:
        r0.hideLetterGridWithAnim();
    }

    /* JADX INFO: renamed from: initGridView$lambda-3, reason: not valid java name */
    private static final boolean m366initGridView$lambda3(OIndexScrollbar r1, View r2, MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        if (r1.mState == r1.STATE_END) goto L5;
        return false;
    L5:
        if (r3.getAction() != 0) goto L14;
        PopupWindow r4 = r1.mPopupWindow;
        if (r4 == null) goto L15;
        Intrinsics.checkNotNull(r4);
        if (r4.isShowing() == false) goto L16;
        PopupWindow r5 = r1.mPopupWindow;
        Intrinsics.checkNotNull(r5);
        r5.dismiss();
        return true;
    L16:
        return false;
    L15:
        return false;
    L14:
        return false;
    }

    /* JADX INFO: renamed from: initGridView$lambda-4, reason: not valid java name */
    private static final boolean m367initGridView$lambda4(OIndexScrollbar r0, AdapterView r1, View r2, int r3, long r4) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        if (r0.mLongPressEnabled == true) goto L5;
        return false;
    L5:
        AlphabetsConfig r5 = AlphabetsConfig.INSTANCE;
        AlphabetsAdapter r6 = r0.mAlphabetsAdapter;
        Intrinsics.checkNotNull(r6);
        if (r5.isSymbol(r6.getItem(r3)) == true) goto L13;
        AlphabetsConfig r7 = AlphabetsConfig.INSTANCE;
        String r8 = Locale.getDefault().getLanguage();
        Intrinsics.checkNotNullExpressionValue(r8, "getDefault().language");
        if (r7.surnameTypeSupportedByLanguage(r8) != 1) goto L10;
        Intrinsics.checkNotNullExpressionValue(r2, "view");
        r0.showFlowPopupWindow(r2, r3);
    L11:
        r0.mHasPerformedLongPress = true;
        return true;
    L10:
        Intrinsics.checkNotNullExpressionValue(r2, "view");
        r0.showGridPopupWindow(r2, r3);
        goto L11
    L13:
        return false;
    }

    private final void setHostWidth(int r4) {
        int r0 = (r4 - this.mLettersBarOccupiedWidth) - this.mLetterbarShadowWidth;
        this.mStartX = r0;
        int r5 = r4 - this.mWidth;
        this.mEndX = r5;
        int r1 = this.mState;
        if (r1 != this.STATE_START) goto L6;
        float r6 = r0;
    L9:
        setX(r6);
        if (this.OIndexScrollbar_DEBUG == false) goto L12;
        Log.d(this.OIndexScrollbar_TAG, Intrinsics.stringPlus("mStartX = ", Integer.valueOf(this.mStartX)));
    L12:
        invalidate();
        return;
    L6:
        if (r1 != this.STATE_END) goto L8;
        r6 = r5;
        goto L9
    L8:
        r6 = getX();
        goto L9
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int r3, int r4) {
        super.onMeasure(r3, r4);
        this.mMeasuredHeight = measureHeight(r4);
        int r5 = View.MeasureSpec.getSize(r3);
        Object r6 = getParent();
        if (r6 == null) goto L7;
        int r7 = ((View) r6).getMeasuredWidth();
        if (r7 <= 0) goto L9;
        setHostWidth(r7);
    L9:
        if (this.OIndexScrollbar_DEBUG == false) goto L12;
        Log.d(this.OIndexScrollbar_TAG, "measure width:" + r5 + "  parentWidth:" + r7);
        return;
    L12:
        return;
    L7:
        r7 = 0;
        goto L9
    }

    private final int measureHeight(int r1) {
        return View.MeasureSpec.getSize(r1);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r9) {
        Intrinsics.checkNotNullParameter(r9, "event");
        AlphabetsConfig r0 = AlphabetsConfig.INSTANCE;
        String r1 = Locale.getDefault().getLanguage();
        Intrinsics.checkNotNullExpressionValue(r1, "getDefault().language");
        if (r0.isAlphabetsSupportedByLanguage(r1) == false) goto L5;
        getParentxPos();
        int r2 = r9.getAction();
        r9.getX();
        r9.getY();
        float r3 = r9.getRawX() - this.mHostX;
        if (r2 == 0) goto L59;
        if (r2 == 1) goto L31;
        if (r2 == 2) goto L15;
        if (r2 == 3) goto L31;
    L71:
        boolean r4 = false;
    L72:
        if (r4 == false) goto L74;
        return true;
    L74:
        if (super.dispatchTouchEvent(r9) == false) goto L77;
        return true;
    L77:
        return false;
    L15:
        if (this.mHasPerformedLongPress == false) goto L17;
        onMoveInLongPressState(r9);
        goto L71
    L17:
        float r5 = this.mCurrentRawX;
        this.mLastRawX = r5;
        this.mCurrentRawX = r3;
        int r6 = this.mState;
        if (r6 != this.STATE_START) goto L21;
        int r7 = (r3 > this.mStartX ? 1 : (r3 == this.mStartX ? 0 : -1));
        goto L71
    L21:
        if (r6 == this.STATE_MOVE) goto L71;
        if (r6 != this.STATE_END) goto L71;
        if ((r3 - r5) <= this.mMinXDistance) goto L71;
        if (r5 <= this.mEndX) goto L71;
    L29:
        r4 = true;
    L31:
        if (this.mHasPerformedLongPress == false) goto L45;
        AlphabetsConfig r8 = AlphabetsConfig.INSTANCE;
        String r10 = Locale.getDefault().getLanguage();
        Intrinsics.checkNotNullExpressionValue(r10, "getDefault().language");
        if (r8.surnameTypeSupportedByLanguage(r10) != 1) goto L40;
        if (this.mPrePosition < 0) goto L44;
        SurnameFlowLayout r11 = this.mPopupFlowLayout;
        if (r11 == null) goto L44;
        Intrinsics.checkNotNull(r11);
        View r12 = r11.getChildAt(this.mPrePosition);
        Intrinsics.checkNotNullExpressionValue(r12, "mPopupFlowLayout!!.getChildAt(mPrePosition)");
        r12.setPressed(false);
        r12.performClick();
    L44:
        this.mPrePosition = -1;
        goto L71
    L40:
        if (this.mPrePosition < 0) goto L44;
        SurnameGridView r13 = this.mPopupGridView;
        if (r13 == null) goto L44;
        Intrinsics.checkNotNull(r13);
        View r14 = r13.getChildAt(this.mPrePosition);
        Intrinsics.checkNotNullExpressionValue(r14, "mPopupGridView!!.getChildAt(mPrePosition)");
        r14.setPressed(false);
        SurnameGridView r15 = this.mPopupGridView;
        Intrinsics.checkNotNull(r15);
        r15.performItemClick(r14, this.mPrePosition, -1);
        goto L44
    L45:
        this.mMissX = 0.0f;
        if (getX() != this.mStartX) goto L48;
        boolean r16 = true;
    L49:
        if (r16 == false) goto L52;
        setLettersBarBg(false);
        goto L71
    L52:
        if (this.mState != this.STATE_MOVE) goto L71;
        if ((this.mCurrentRawX - this.mLastRawX) <= 0.0f) goto L56;
    L58:
        hideLetterGridWithAnim();
        goto L29
    L56:
        if (getX() >= (getScreenWidth() + NetError.ERR_SSL_PINNED_KEY_NOT_IN_CERT_CHAIN)) goto L58;
        showLetterGridWithAnim();
        goto L29
    L48:
        r16 = false;
        goto L49
    L59:
        this.mHasPerformedLongPress = false;
        this.mCurrentRawX = r3;
        this.mLastRawX = r3;
        int r17 = this.mState;
        if (r17 != this.STATE_START) goto L62;
        this.mMissX = 0.0f;
    L62:
        int r18 = this.STATE_END;
        if (r17 != r18) goto L65;
        this.mMissX = r3 - this.mEndX;
    L65:
        if (r17 != r18) goto L71;
        PopupWindow r19 = this.mPopupWindow;
        if (r19 == null) goto L71;
        Intrinsics.checkNotNull(r19);
        if (r19.isShowing() == false) goto L71;
        PopupWindow r20 = this.mPopupWindow;
        Intrinsics.checkNotNull(r20);
        r20.dismiss();
        goto L71
    L5:
        return super.dispatchTouchEvent(r9);
    }

    private final void onMoveInLongPressState(MotionEvent r13) {
        PopupWindow r0 = this.mPopupWindow;
        if (r0 == null) goto L45;
        Intrinsics.checkNotNull(r0);
        if (r0.isShowing() == false) goto L49;
        int r1 = (int) r13.getRawX();
        int r14 = (int) r13.getRawY();
        AlphabetsConfig r2 = AlphabetsConfig.INSTANCE;
        String r3 = Locale.getDefault().getLanguage();
        Intrinsics.checkNotNullExpressionValue(r3, "getDefault().language");
        if (r2.surnameTypeSupportedByLanguage(r3) != 1) goto L29;
        SurnameFlowLayout r4 = this.mPopupFlowLayout;
        if (r4 == null) goto L46;
        int[] r5 = new int[2];
        Intrinsics.checkNotNull(r4);
        r4.getLocationOnScreen(r5);
        SurnameFlowLayout r6 = this.mPopupFlowLayout;
        Intrinsics.checkNotNull(r6);
        int r7 = r6.getChildCount();
        int r8 = 0;
    L12:
        if (r8 >= r7) goto L17;
        int r9 = r8 + 1;
        SurnameFlowLayout r10 = this.mPopupFlowLayout;
        Intrinsics.checkNotNull(r10);
        View r11 = r10.getChildAt(r8);
        Intrinsics.checkNotNullExpressionValue(r11, "mPopupFlowLayout!!.getChildAt(i)");
        Rect r12 = new Rect();
        r11.getHitRect(r12);
        if (r12.contains(r1 - r5[0], r14 - r5[1]) == true) goto L19;
        r8 = r9;
    L19:
        if (r8 >= 0) goto L21;
        SurnameFlowLayout r15 = this.mPopupFlowLayout;
        Intrinsics.checkNotNull(r15);
        View r16 = r15.getChildAt(this.mPrePosition);
        Intrinsics.checkNotNullExpressionValue(r16, "mPopupFlowLayout!!.getChildAt(mPrePosition)");
        r16.setPressed(false);
        showSecondPopupWindow(null);
    L28:
        this.mPrePosition = r8;
        return;
    L21:
        if (this.mPrePosition == r8) goto L28;
        SurnameFlowLayout r17 = this.mPopupFlowLayout;
        Intrinsics.checkNotNull(r17);
        View r18 = r17.getChildAt(this.mPrePosition);
        Intrinsics.checkNotNullExpressionValue(r18, "mPopupFlowLayout!!.getChildAt(mPrePosition)");
        r18.setPressed(false);
        showSecondPopupWindow(null);
        SurnameFlowLayout r19 = this.mPopupFlowLayout;
        Intrinsics.checkNotNull(r19);
        View r110 = r19.getChildAt(r8);
        Intrinsics.checkNotNullExpressionValue(r110, "mPopupFlowLayout!!.getChildAt(position)");
        r110.setPressed(true);
        CharSequence r20 = ((TextView) r110).getText();
        if (r20 == null) goto L26;
        r110.setTag((String) r20);
        showSecondPopupWindow(r110);
        goto L28
    L26:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    L17:
        r8 = -1;
        goto L19
    L46:
        return;
    L29:
        SurnameGridView r21 = this.mPopupGridView;
        if (r21 == null) goto L48;
        int[] r22 = new int[2];
        Intrinsics.checkNotNull(r21);
        r21.getLocationOnScreen(r22);
        int r23 = r1 - r22[0];
        int r111 = r14 - r22[1];
        SurnameGridView r24 = this.mPopupGridView;
        Intrinsics.checkNotNull(r24);
        int r112 = r24.pointToPosition(r23, r111);
        if (r112 >= 0) goto L34;
        SurnameGridView r25 = this.mPopupGridView;
        Intrinsics.checkNotNull(r25);
        View r26 = r25.getChildAt(this.mPrePosition);
        Intrinsics.checkNotNullExpressionValue(r26, "mPopupGridView!!.getChildAt(mPrePosition)");
        r26.setPressed(false);
        showSecondPopupWindow(null);
    L41:
        this.mPrePosition = r112;
        return;
    L34:
        if (this.mPrePosition == r112) goto L41;
        SurnameGridView r27 = this.mPopupGridView;
        Intrinsics.checkNotNull(r27);
        View r28 = r27.getChildAt(this.mPrePosition);
        Intrinsics.checkNotNullExpressionValue(r28, "mPopupGridView!!.getChildAt(mPrePosition)");
        r28.setPressed(false);
        showSecondPopupWindow(null);
        SurnameGridView r29 = this.mPopupGridView;
        Intrinsics.checkNotNull(r29);
        View r30 = r29.getChildAt(r112);
        Intrinsics.checkNotNullExpressionValue(r30, "mPopupGridView!!.getChildAt(position)");
        r30.setPressed(true);
        SurnameGridView r31 = this.mPopupGridView;
        Intrinsics.checkNotNull(r31);
        Object r32 = r31.getAdapter().getItem(r112);
        if (r32 == null) goto L39;
        r30.setTag((String) r32);
        showSecondPopupWindow(r30);
        goto L41
    L39:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    L48:
        return;
    L49:
        return;
    }

    private final void setState(int r2) {
        this.mState = r2;
        LettersBar r0 = this.mLettersBar;
        Intrinsics.checkNotNull(r0);
        if (r2 != this.STATE_START) goto L5;
        boolean r1 = true;
    L6:
        r0.setSettled(r1);
        return;
    L5:
        r1 = false;
        goto L6
    }

    private final void moveQuickBar(float r2, float r3) {
        float r4 = r2 - r3;
        int r5 = this.mStartX;
        if (r4 < r5) goto L5;
        setX(r5);
        setState(this.STATE_START);
        return;
    L5:
        int r6 = this.mEndX;
        if (r4 > r6) goto L9;
        setX(r6);
        setState(this.STATE_END);
        return;
    L9:
        if (r4 <= r6) goto L14;
        setX(r4);
        setState(this.STATE_MOVE);
        return;
    }

    private final void showLetterGridWithAnim() {
        QBListener r0 = this.mQBListener;
        if (r0 == null) goto L5;
        Intrinsics.checkNotNull(r0);
        r0.onLetterGridShow();
    L5:
        AnimatorSet r1 = new AnimatorSet();
        ObjectAnimator r2 = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(MaterialConfigFormatNames.X, new float[]{getX(), this.mEndX})});
        Intrinsics.checkNotNullExpressionValue(r2, "ofPropertyValuesHolder(this, pvhX)");
        r1.play(r2);
        r1.setDuration(200);
        r1.addListener(new C02791(this));
        r1.start();
    }

    private final void onShowLetterGridAnimationEnd() {
        setX(this.mEndX);
        setState(this.STATE_END);
        setLettersBarBg(true);
    }

    private final void hideLetterGridWithAnim() {
        dismissPopupWindow();
        AnimatorSet r0 = new AnimatorSet();
        ObjectAnimator r1 = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(MaterialConfigFormatNames.X, new float[]{getX(), this.mStartX})});
        Intrinsics.checkNotNullExpressionValue(r1, "ofPropertyValuesHolder(this, pvhX)");
        r0.play(r1);
        r0.setDuration(200);
        r0.addListener(new AnonymousClass1(this));
        r0.start();
    }

    private final void onHideLetterGridAnimationEnd() {
        setState(this.STATE_START);
        setX(this.mStartX);
        setLettersBarBg(false);
    }

    private final void setLettersBarBg(boolean r2) {
        LettersBar r0 = this.mLettersBar;
        Intrinsics.checkNotNull(r0);
        r0.setShowBg(r2);
        setShadowVisible(r2);
    }

    private final void setShadowVisible(boolean r1) {
        View r0 = this.mShadowView;
        Intrinsics.checkNotNull(r0);
        if (r1 == false) goto L5;
        int r2 = 0;
    L6:
        r0.setVisibility(r2);
        return;
    L5:
        r2 = 4;
        goto L6
    }

    private final int getScreenWidth() {
        Point r0 = new Point();
        Context r2 = this.mContext;
        Intrinsics.checkNotNull(r2);
        Object r3 = r2.getSystemService("window");
        if (r3 == null) goto L7;
        ((WindowManager) r3).getDefaultDisplay().getSize(r0);
        return r0.x;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
    }

    private final int dipToPx(double r3) {
        Context r2 = this.mContext;
        Intrinsics.checkNotNull(r2);
        return (int) ((r3 * ((double) r2.getResources().getDisplayMetrics().density)) + ((double) 0.5f));
    }

    private final void showFlowPopupWindow(View r20, int r21) {
        if (this.mSurnameListener == null) goto L142;
        AlphabetsConfig r2 = AlphabetsConfig.INSTANCE;
        String r3 = Locale.getDefault().getLanguage();
        Intrinsics.checkNotNullExpressionValue(r3, "getDefault().language");
        AlphabetsAdapter r4 = this.mAlphabetsAdapter;
        Intrinsics.checkNotNull(r4);
        if (r2.isSurnameSupportedByLanguage(r3, r4.getItem(r21)) == true) goto L7;
        return;
    L7:
        SurnameListener r5 = this.mSurnameListener;
        Intrinsics.checkNotNull(r5);
        AlphabetsAdapter r6 = this.mAlphabetsAdapter;
        Intrinsics.checkNotNull(r6);
        List<String> r7 = r5.getMatchedSurnames(r6.getItem(r21));
        if (r7 != null) goto L10;
        return;
    L10:
        if (r7.size() == 0) goto L147;
        ViewGroup r8 = null;
        View r9 = LayoutInflater.from(this.mContext).inflate(R.layout.o_surname_flow_popup, null);
        Intrinsics.checkNotNullExpressionValue(r9, "from(mContext).inflate(R…surname_flow_popup, null)");
        View r10 = r9.findViewById(R.id.surname_content);
        if (r10 == null) goto L139;
        this.mPopupFlowLayout = (SurnameFlowLayout) r10;
        this.mPopupYOffset = dipToPx(7.0d);
        this.mPopupViewMaxHeight = dipToPx((this.SURNAME_NUM_ROWS_THRESHOLD * 33) + 19);
        this.mSurnameGridViewItemWidth = dipToPx(40.0d);
        this.mSurnameGridViewItemHeight = dipToPx(33.0d);
        this.mSurnameGridViewColumnsThreshold = this.SURNAME_NUM_COLUMNS_THRESHOLD;
        int r11 = dipToPx(98.0d);
        Drawable r12 = getResources().getDrawable(R.drawable.surname_popup_item_left);
        int r13 = this.mSurnameGridViewColumnsThreshold * this.mSurnameGridViewItemWidth;
        Iterator<String> r14 = r7.iterator();
        int r15 = 1;
        int r16 = 0;
        int r17 = 0;
    L16:
        if (r14.hasNext() == false) goto L44;
        String r18 = r14.next();
        View r19 = LayoutInflater.from(this.mContext).inflate(R.layout.o_surname_popup_item_ex, r8);
        if (r19 == null) goto L43;
        final TextView r22 = (TextView) r19;
        r22.setText(r18);
        ViewGroup.MarginLayoutParams r110 = new ViewGroup.MarginLayoutParams(-2, -2);
        r110.height = this.mSurnameGridViewItemHeight;
        r22.setLayoutParams(r110);
        Drawable r111 = r12;
        r22.setPadding(dipToPx(10.0d), 0, dipToPx(10.0d), 0);
        if (r7.size() != 1) goto L22;
        r22.setBackgroundResource(R.drawable.surname_popup_item_special);
    L23:
        int r23 = (int) Math.ceil(r22.getPaint().measureText(r18));
        if (r111 == null) goto L30;
        int r112 = r111.getIntrinsicWidth();
        if (r112 <= 0) goto L30;
        int r113 = r15;
        double r114 = 20.0d;
        if (r112 <= (r23 + dipToPx(20.0d))) goto L31;
        r23 = r112 - dipToPx(20.0d);
    L31:
        if (r23 <= r11) goto L33;
        r23 = r11;
    L33:
        int r24 = r23 + dipToPx(r114);
        if ((r17 + r24) <= r13) goto L36;
        r15 = r113 + 1;
        r17 = 0;
    L37:
        r17 = r17 + r24;
        if (r16 > r17) goto L41;
        r16 = r17;
    L41:
        r22.setOnClickListener(new OIndexScrollbar$$ExternalSyntheticLambda3(this));
        r22.setOnTouchListener(new OIndexScrollbar$$ExternalSyntheticLambda4(this, r22));
        SurnameFlowLayout r25 = this.mPopupFlowLayout;
        Intrinsics.checkNotNull(r25);
        r25.addView(r22);
        r12 = r111;
        r8 = null;
        goto L16
    L36:
        r15 = r113;
    L30:
        r113 = r15;
        r114 = 20.0d;
        goto L31
    L22:
        r22.setBackgroundResource(R.drawable.surname_popup_item_left);
        goto L23
    L43:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L44:
        this.mSurnameGridViewNumRows = r15;
        SurnameFlowLayout r26 = this.mPopupFlowLayout;
        Intrinsics.checkNotNull(r26);
        r26.measure(0, 0);
        if (this.OIndexScrollbar_DEBUG == false) goto L47;
        Log.d(this.OIndexScrollbar_TAG, Intrinsics.stringPlus("surname FlowLayout, width = ", Integer.valueOf(r16)));
        String r27 = this.OIndexScrollbar_TAG;
        SurnameFlowLayout r28 = this.mPopupFlowLayout;
        Intrinsics.checkNotNull(r28);
        Log.d(r27, Intrinsics.stringPlus("surname FlowLayout, measuredHeight = ", Integer.valueOf(r28.getMeasuredHeight())));
    L47:
        SurnameFlowLayout r29 = this.mPopupFlowLayout;
        Intrinsics.checkNotNull(r29);
        ViewGroup.LayoutParams r30 = r29.getLayoutParams();
        if (r30 == null) goto L137;
        FrameLayout.LayoutParams r31 = (FrameLayout.LayoutParams) r30;
        r31.width = r16;
        SurnameFlowLayout r32 = this.mPopupFlowLayout;
        Intrinsics.checkNotNull(r32);
        r32.setLayoutParams(r31);
        if (this.mPopupWindow != null) goto L52;
        PopupWindow r33 = new PopupWindow();
        this.mPopupWindow = r33;
        Intrinsics.checkNotNull(r33);
        r33.setWindowLayoutMode(-2, -2);
        PopupWindow r34 = this.mPopupWindow;
        Intrinsics.checkNotNull(r34);
        r34.setBackgroundDrawable(getResources().getDrawable(R.color.Transparent));
        PopupWindow r35 = this.mPopupWindow;
        Intrinsics.checkNotNull(r35);
        r35.setClippingEnabled(true);
    L52:
        PopupWindow r36 = this.mPopupWindow;
        Intrinsics.checkNotNull(r36);
        r36.setContentView(r9);
        getLocationOnScreen(new int[2]);
        getLocationInWindow(new int[2]);
        int[] r37 = new int[2];
        r20.getLocationOnScreen(r37);
        int r38 = r37[0] + (r20.getWidth() / 2);
        int r39 = r37[1] + (r20.getHeight() / 2);
        if (this.OIndexScrollbar_DEBUG == false) goto L55;
        int r115 = 0;
        Log.d(this.OIndexScrollbar_TAG, "alphabet anchorX = " + r37[0] + ", anchorY = " + r37[1]);
    L56:
        r9.measure(r115, r115);
        int r40 = r9.getMeasuredWidth();
        int r41 = r9.getMeasuredHeight();
        if (this.OIndexScrollbar_DEBUG == false) goto L59;
        Log.d(this.OIndexScrollbar_TAG, "popMeasureWidth = " + r40 + ", popMeasureHeight = " + r41);
    L59:
        int r42 = this.mColumnCount;
        if (r21 >= r42) goto L64;
        boolean r116 = true;
        if (this.mSurnameGridViewNumRows > 1) goto L85;
    L65:
        if (r21 < r42) goto L71;
        if (r21 >= (r42 * 2)) goto L71;
        if (this.mSurnameGridViewNumRows > 3) goto L85;
    L71:
        if (r21 < (r42 * 2)) goto L77;
        if (r21 >= (r42 * 3)) goto L77;
        if (this.mSurnameGridViewNumRows > 5) goto L85;
    L77:
        if (r21 >= (r42 * 3)) goto L79;
    L83:
        r116 = false;
        goto L85
    L79:
        if (r21 >= (r42 * 4)) goto L83;
        if (this.mSurnameGridViewNumRows <= 7) goto L83;
    L85:
        if (r116 == false) goto L91;
        View r43 = r9.findViewById(R.id.surname_popup_top_arrow);
        if (r43 == null) goto L90;
        ImageView r44 = (ImageView) r43;
        int r45 = r39 + this.mPopupYOffset;
    L94:
        r44.setVisibility(0);
        r44.measure(0, 0);
        int r46 = r44.getMeasuredWidth();
        if (this.OIndexScrollbar_DEBUG == false) goto L97;
        Log.d(this.OIndexScrollbar_TAG, Intrinsics.stringPlus("arrowWidth = ", Integer.valueOf(r46)));
    L97:
        int r117 = r40 / 2;
        int r118 = (int) Math.min(getScreenWidth() - r38, r117);
        int r47 = r38 - r117;
        int r48 = (r40 - r118) - (r46 / 2);
        View r49 = r9.findViewById(R.id.surname_top_mask);
        if (r49 == null) goto L133;
        ImageView r50 = (ImageView) r49;
        ViewGroup.LayoutParams r51 = r50.getLayoutParams();
        if (r51 == null) goto L131;
        FrameLayout.LayoutParams r52 = (FrameLayout.LayoutParams) r51;
        r52.width = r16;
        View r119 = r9.findViewById(R.id.surname_bottom_mask);
        if (r119 == null) goto L129;
        ImageView r120 = (ImageView) r119;
        ViewGroup.LayoutParams r1 = r120.getLayoutParams();
        if (r1 == null) goto L127;
        FrameLayout.LayoutParams r53 = (FrameLayout.LayoutParams) r1;
        r53.width = r16;
        View r54 = r9.findViewById(R.id.surname_container);
        if (r54 == null) goto L125;
        LinearLayout r55 = (LinearLayout) r54;
        ViewGroup.LayoutParams r121 = r55.getLayoutParams();
        if (r121 == null) goto L123;
        FrameLayout.LayoutParams r122 = (FrameLayout.LayoutParams) r121;
        SurnameFlowLayout r56 = this.mPopupFlowLayout;
        Intrinsics.checkNotNull(r56);
        int r57 = r56.getMeasuredHeight();
        int r123 = this.mPopupViewMaxHeight;
        if (r57 <= r123) goto L112;
        r122.height = r123;
    L112:
        r55.setLayoutParams(r122);
        if (r16 != (this.mSurnameGridViewColumnsThreshold * this.mSurnameGridViewItemWidth)) goto L115;
        r55.setPadding(dipToPx(14.0d), dipToPx(1.5d), dipToPx(17.0d), dipToPx(4.0d));
        r48 = r48 + getResources().getDimensionPixelSize(R.dimen.surname_arrow_offset_x);
        r52.leftMargin = dipToPx(20.0d);
        r53.leftMargin = dipToPx(20.0d);
        r52.width -= dipToPx(10.0d);
        r53.width -= dipToPx(10.0d);
    L116:
        r50.setLayoutParams(r52);
        r120.setLayoutParams(r53);
        r44.setTranslationX(r48);
        if (Math.abs(getX() - this.mEndX) <= dipToPx(1.0d)) goto L120;
        Log.d(this.OIndexScrollbar_TAG, "GridView is hiding now...");
        return;
    L120:
        PopupWindow r58 = this.mPopupWindow;
        Intrinsics.checkNotNull(r58);
        r58.showAtLocation(this, 0, r47, r45);
        return;
    L115:
        r47 = r47 - 1;
        goto L116
    L123:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L125:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout");
    L127:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L129:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
    L131:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L133:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
    L90:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
    L91:
        View r59 = r9.findViewById(R.id.surname_popup_bottom_arrow);
        if (r59 == null) goto L135;
        r45 = (r39 - r41) - this.mPopupYOffset;
        r44 = (ImageView) r59;
        goto L94
    L135:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
    L64:
        r116 = true;
        goto L65
    L55:
        r115 = 0;
        goto L56
    L137:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L139:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.indexscrollbar.SurnameFlowLayout");
    L147:
        return;
    L142:
        throw new IllegalArgumentException("You must implements SurnameListener".toString());
    }

    /* JADX INFO: renamed from: showFlowPopupWindow$lambda-7, reason: not valid java name */
    private static final void m368showFlowPopupWindow$lambda7(OIndexScrollbar r1, View r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        if (r2 == null) goto L7;
        String r3 = ((TextView) r2).getText().toString();
        SurnameListener r0 = r1.mSurnameListener;
        Intrinsics.checkNotNull(r0);
        r0.onSurnameClicked(r3);
        r1.hideLetterGrid();
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    }

    /* JADX INFO: renamed from: showFlowPopupWindow$lambda-8, reason: not valid java name */
    private static final boolean m369showFlowPopupWindow$lambda8(OIndexScrollbar r1, TextView r2, View r3, MotionEvent r4) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullParameter(r2, "$surnameView");
        if (r4.getAction() == 0) goto L9;
        if (r4.getAction() == 2) goto L9;
        r1.showSecondPopupWindow(null);
        return false;
    L9:
        if (r1.mSecondPopup != null) goto L11;
    L15:
        r3.setTag(r2.getText());
        r1.showSecondPopupWindow(r3);
        return false;
    L11:
        if (r1.mSecondPopupView == null) goto L15;
        CharSequence r5 = r2.getText();
        TextView r0 = r1.mSecondPopupView;
        Intrinsics.checkNotNull(r0);
        if (Intrinsics.areEqual(r5, r0.getText()) == true) goto L15;
        PopupWindow r6 = r1.mSecondPopup;
        Intrinsics.checkNotNull(r6);
        r6.dismiss();
        goto L15
    }

    private final void showGridPopupWindow(View r18, int r19) {
        if (this.mSurnameListener == null) goto L115;
        AlphabetsConfig r2 = AlphabetsConfig.INSTANCE;
        String r3 = Locale.getDefault().getLanguage();
        Intrinsics.checkNotNullExpressionValue(r3, "getDefault().language");
        AlphabetsAdapter r4 = this.mAlphabetsAdapter;
        Intrinsics.checkNotNull(r4);
        if (r2.isSurnameSupportedByLanguage(r3, r4.getItem(r19)) == true) goto L7;
        return;
    L7:
        SurnameListener r5 = this.mSurnameListener;
        Intrinsics.checkNotNull(r5);
        AlphabetsAdapter r6 = this.mAlphabetsAdapter;
        Intrinsics.checkNotNull(r6);
        List<String> r7 = r5.getMatchedSurnames(r6.getItem(r19));
        if (r7 != null) goto L10;
        return;
    L10:
        if (r7.size() == 0) goto L116;
        SurnameAdapter r8 = new SurnameAdapter(this, this.mContext, r7);
        View r9 = LayoutInflater.from(this.mContext).inflate(R.layout.o_surname_popup, null);
        Intrinsics.checkNotNullExpressionValue(r9, "from(mContext).inflate(R…ut.o_surname_popup, null)");
        View r10 = r9.findViewById(R.id.surname_content);
        if (r10 == null) goto L112;
        this.mPopupGridView = (SurnameGridView) r10;
        this.mPopupYOffset = dipToPx(7.0d);
        this.mSurnameGridViewItemHeight = dipToPx(33.0d);
        this.mPopupViewMaxHeight = dipToPx((this.SURNAME_NUM_ROWS_THRESHOLD * 33) + 19);
        this.mPopupViewPendingVertical = dipToPx(16.0d);
        this.mPopupViewPendingHorizontal = dipToPx(6.0d);
        this.mSurnameGridViewColumnsThreshold = this.SURNAME_NUM_COLUMNS_THRESHOLD;
        this.mSurnameGridViewItemWidth = dipToPx(40.0d);
        int r11 = r7.size();
        int r12 = this.mSurnameGridViewColumnsThreshold;
        if (r11 >= r12) goto L18;
        r12 = r7.size();
    L18:
        this.mSurnameGridViewNumColumns = r12;
        int r13 = (int) Math.ceil((((double) r7.size()) * 1.0d) / ((double) this.mSurnameGridViewNumColumns));
        this.mSurnameGridViewNumRows = r13;
        int r14 = (this.mSurnameGridViewNumColumns * this.mSurnameGridViewItemWidth) + (this.mPopupViewPendingHorizontal * 2);
        if (r13 <= this.SURNAME_NUM_ROWS_THRESHOLD) goto L21;
        int r15 = this.mPopupViewMaxHeight;
    L22:
        int r16 = r15 + (this.mPopupViewPendingVertical * 2);
        if (this.OIndexScrollbar_DEBUG == false) goto L25;
        Log.d(this.OIndexScrollbar_TAG, "surname GridView, width = " + r14 + ", height = " + r16);
    L25:
        SurnameGridView r17 = this.mPopupGridView;
        Intrinsics.checkNotNull(r17);
        r17.setNumColumns(this.mSurnameGridViewNumColumns);
        SurnameGridView r20 = this.mPopupGridView;
        Intrinsics.checkNotNull(r20);
        r20.setLayoutParams(new LinearLayout.LayoutParams(r14, r16));
        SurnameGridView r21 = this.mPopupGridView;
        Intrinsics.checkNotNull(r21);
        r21.setGravity(17);
        SurnameGridView r22 = this.mPopupGridView;
        Intrinsics.checkNotNull(r22);
        r22.setAdapter(r8);
        SurnameGridView r23 = this.mPopupGridView;
        Intrinsics.checkNotNull(r23);
        r23.setOnPressChangeListener(new C02782(this));
        SurnameGridView r24 = this.mPopupGridView;
        Intrinsics.checkNotNull(r24);
        r24.setOnItemClickListener(new OIndexScrollbar$$ExternalSyntheticLambda5(this));
        boolean r25 = true;
        if (this.mPopupWindow != null) goto L28;
        PopupWindow r26 = new PopupWindow();
        this.mPopupWindow = r26;
        Intrinsics.checkNotNull(r26);
        r26.setWindowLayoutMode(-2, -2);
        PopupWindow r27 = this.mPopupWindow;
        Intrinsics.checkNotNull(r27);
        r27.setBackgroundDrawable(getResources().getDrawable(R.color.Transparent));
        PopupWindow r28 = this.mPopupWindow;
        Intrinsics.checkNotNull(r28);
        r28.setClippingEnabled(true);
    L28:
        PopupWindow r29 = this.mPopupWindow;
        Intrinsics.checkNotNull(r29);
        r29.setContentView(r9);
        getLocationOnScreen(new int[2]);
        getLocationInWindow(new int[2]);
        int[] r30 = new int[2];
        r18.getLocationOnScreen(r30);
        if (this.OIndexScrollbar_DEBUG == false) goto L31;
        Log.d(this.OIndexScrollbar_TAG, "alphabetView.getWidth = " + r18.getWidth() + ", alphabetView.getHeight = " + r18.getHeight());
    L31:
        int r110 = r30[0] + (r18.getWidth() / 2);
        int r111 = r30[1] + (r18.getHeight() / 2);
        if (this.OIndexScrollbar_DEBUG == false) goto L34;
        Log.d(this.OIndexScrollbar_TAG, "alphabet anchorX = " + r30[0] + ", anchorY = " + r30[1]);
    L34:
        r9.measure(0, 0);
        int r31 = r9.getMeasuredWidth();
        int r32 = r9.getMeasuredHeight();
        if (this.OIndexScrollbar_DEBUG == false) goto L37;
        Log.d(this.OIndexScrollbar_TAG, "popMeasureWidth = " + r31 + ", popMeasureHeight = " + r32);
    L37:
        int r33 = this.mColumnCount;
        if (r19 < r33) goto L40;
    L41:
        if (r19 < r33) goto L47;
        if (r19 >= (r33 * 2)) goto L47;
        if (this.mSurnameGridViewNumRows <= 3) goto L47;
    L61:
        if (r25 == false) goto L67;
        View r34 = r9.findViewById(R.id.surname_popup_top_arrow);
        if (r34 == null) goto L66;
        ImageView r35 = (ImageView) r34;
        int r112 = r111 + this.mPopupYOffset;
    L70:
        r35.setVisibility(0);
        r35.measure(0, 0);
        int r36 = r35.getMeasuredWidth();
        if (this.OIndexScrollbar_DEBUG == false) goto L73;
        Log.d(this.OIndexScrollbar_TAG, Intrinsics.stringPlus("arrowWidth = ", Integer.valueOf(r36)));
    L73:
        int r113 = r31 / 2;
        int r37 = r110 - r113;
        int r38 = r36 / 2;
        int r39 = (r31 - ((int) Math.min(getScreenWidth() - r110, r113))) - r38;
        View r40 = r9.findViewById(R.id.surname_top_mask);
        if (r40 == null) goto L108;
        ImageView r41 = (ImageView) r40;
        ViewGroup.LayoutParams r42 = r41.getLayoutParams();
        if (r42 == null) goto L106;
        FrameLayout.LayoutParams r43 = (FrameLayout.LayoutParams) r42;
        r43.width = this.mSurnameGridViewNumColumns * this.mSurnameGridViewItemWidth;
        View r114 = r9.findViewById(R.id.surname_bottom_mask);
        if (r114 == null) goto L104;
        ImageView r115 = (ImageView) r114;
        ViewGroup.LayoutParams r1 = r115.getLayoutParams();
        if (r1 == null) goto L102;
        FrameLayout.LayoutParams r44 = (FrameLayout.LayoutParams) r1;
        r44.width = this.mSurnameGridViewNumColumns * this.mSurnameGridViewItemWidth;
        View r45 = r9.findViewById(R.id.surname_container);
        if (r45 == null) goto L100;
        LinearLayout r46 = (LinearLayout) r45;
        int r116 = this.mSurnameGridViewNumColumns;
        int r117 = this.mSurnameGridViewColumnsThreshold;
        if (r116 != r117) goto L89;
        int r118 = this.SURNAME_NUM_COLUMNS_THRESHOLD;
        if (r117 != r118) goto L88;
        r46.setPadding(dipToPx(14.0d), dipToPx(1.5d), dipToPx(17.0d), dipToPx(4.0d));
        r39 = r39 + getResources().getDimensionPixelSize(R.dimen.surname_arrow_offset_x);
        FrameLayout.LayoutParams r119 = r43;
        r119.leftMargin = dipToPx(20.0d);
        r44.leftMargin = dipToPx(20.0d);
    L91:
        if (this.OIndexScrollbar_DEBUG == false) goto L93;
        Log.d(this.OIndexScrollbar_TAG, Intrinsics.stringPlus("arrowTranslationX = ", Integer.valueOf(r39)));
    L93:
        r35.setTranslationX(r39);
        r41.setLayoutParams(r119);
        r115.setLayoutParams(r44);
        if (Math.abs(getX() - this.mEndX) <= dipToPx(1.0d)) goto L97;
        Log.d(this.OIndexScrollbar_TAG, "GridView is hiding now...");
        return;
    L97:
        PopupWindow r47 = this.mPopupWindow;
        Intrinsics.checkNotNull(r47);
        r47.showAtLocation(this, 0, r37, r112);
        return;
    L88:
        r119 = r43;
        int r120 = ((r118 * dipToPx(40.0d)) - (this.mSurnameGridViewNumColumns * this.mSurnameGridViewItemWidth)) / 2;
        r46.setPadding(dipToPx(14.0d) + r120, dipToPx(1.5d), dipToPx(17.0d) + r120, dipToPx(4.0d));
        r39 = r110 - r38;
        r119.leftMargin = dipToPx(20.0d) + r120;
        r44.leftMargin = dipToPx(20.0d) + r120;
        goto L91
    L89:
        r119 = r43;
        r37 = r37 - 1;
        goto L91
    L100:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout");
    L102:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L104:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
    L106:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L108:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
    L66:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
    L67:
        View r48 = r9.findViewById(R.id.surname_popup_bottom_arrow);
        if (r48 == null) goto L110;
        r35 = (ImageView) r48;
        r112 = (r111 - r32) - this.mPopupYOffset;
        goto L70
    L110:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
    L47:
        if (r19 < (r33 * 2)) goto L53;
        if (r19 >= (r33 * 3)) goto L53;
        if (this.mSurnameGridViewNumRows > 5) goto L61;
    L53:
        if (r19 >= (r33 * 3)) goto L55;
    L59:
        r25 = false;
        goto L61
    L55:
        if (r19 >= (r33 * 4)) goto L59;
        if (this.mSurnameGridViewNumRows <= 7) goto L59;
    L40:
        if (this.mSurnameGridViewNumRows > 1) goto L61;
    L21:
        r15 = r13 * this.mSurnameGridViewItemHeight;
        goto L22
    L112:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.indexscrollbar.SurnameGridView");
    L116:
        return;
    L115:
        throw new IllegalArgumentException("You must implements SurnameListener".toString());
    }

    /* JADX INFO: renamed from: showGridPopupWindow$lambda-10, reason: not valid java name */
    private static final void m370showGridPopupWindow$lambda10(OIndexScrollbar r0, AdapterView r1, View r2, int r3, long r4) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        Object r5 = r1.getItemAtPosition(r3);
        if (r5 == null) goto L7;
        SurnameListener r6 = r0.mSurnameListener;
        Intrinsics.checkNotNull(r6);
        r6.onSurnameClicked((String) r5);
        r0.hideLetterGrid();
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    private final void dismissPopupWindow() {
        PopupWindow r0 = this.mPopupWindow;
        if (r0 == null) goto L5;
        Intrinsics.checkNotNull(r0);
        r0.dismiss();
        this.mPopupWindow = null;
        this.mPopupGridView = null;
        this.mPopupFlowLayout = null;
    L5:
        PopupWindow r1 = this.mSecondPopup;
        if (r1 == null) goto L9;
        Intrinsics.checkNotNull(r1);
        r1.dismiss();
        this.mSecondPopup = null;
        this.mSecondPopupView = null;
        return;
    }

    private final void showSecondPopupWindow(View r11) {
        if (r11 != null) goto L8;
        PopupWindow r10 = this.mSecondPopup;
        if (r10 == null) goto L28;
        Intrinsics.checkNotNull(r10);
        r10.dismiss();
        return;
    L28:
        return;
    L8:
        if (this.mSecondPopup != null) goto L14;
        PopupWindow r0 = new PopupWindow();
        this.mSecondPopup = r0;
        Intrinsics.checkNotNull(r0);
        r0.setWindowLayoutMode(-2, -2);
        PopupWindow r1 = this.mSecondPopup;
        Intrinsics.checkNotNull(r1);
        r1.setBackgroundDrawable(getResources().getDrawable(R.color.Transparent));
        PopupWindow r2 = this.mSecondPopup;
        Intrinsics.checkNotNull(r2);
        r2.setClippingEnabled(true);
        ViewGroup r3 = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.o_surname_second_popup_ex, null);
        this.mSecondPopupViewParent = r3;
        Intrinsics.checkNotNull(r3);
        this.mSecondPopupViewArrow = r3.getChildAt(1);
        ViewGroup r4 = this.mSecondPopupViewParent;
        Intrinsics.checkNotNull(r4);
        View r5 = r4.getChildAt(0);
        if (r5 == null) goto L13;
        this.mSecondPopupView = (TextView) r5;
        goto L14
    L13:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L14:
        PopupWindow r6 = this.mSecondPopup;
        Intrinsics.checkNotNull(r6);
        r6.setContentView(this.mSecondPopupViewParent);
        int[] r7 = new int[2];
        r11.getLocationOnScreen(r7);
        Log.d(this.OIndexScrollbar_TAG, "original anchorViewLocation[0] = " + r7[0] + ", anchorViewLocation[1] = " + r7[1]);
        int[] r8 = new int[2];
        getRootView().getLocationOnScreen(r8);
        Log.d(this.OIndexScrollbar_TAG, "rootViewLocation[0] = " + r8[0] + ", rootViewLocation[1] = " + r8[1]);
        String r9 = r11.getTag().toString();
        TextView r12 = this.mSecondPopupView;
        Intrinsics.checkNotNull(r12);
        r12.setText(r9);
        TextView r13 = this.mSecondPopupView;
        Intrinsics.checkNotNull(r13);
        r13.measure(0, 0);
        TextView r14 = this.mSecondPopupView;
        Intrinsics.checkNotNull(r14);
        int r15 = ((int) r14.getPaint().measureText(r9)) + dipToPx(40.0d);
        int r16 = dipToPx(320.0d);
        if (r15 <= r16) goto L17;
        r15 = r16;
    L17:
        TextView r17 = this.mSecondPopupView;
        Intrinsics.checkNotNull(r17);
        int r18 = r17.getMeasuredHeight();
        int r19 = r11.getWidth();
        int r20 = r11.getHeight();
        int r21 = (r7[0] - r8[0]) + (r19 / 2);
        int r22 = (r7[1] - r8[1]) + (r20 / 2);
        int r23 = r15 / 2;
        int r24 = r21 - r23;
        int r25 = (r22 - r18) - 20;
        View r26 = this.mSecondPopupViewArrow;
        Intrinsics.checkNotNull(r26);
        r26.getLocationOnScreen(new int[2]);
        View r27 = this.mSecondPopupViewArrow;
        Intrinsics.checkNotNull(r27);
        r27.setTranslationX(0.0f);
        if (r24 >= 0) goto L20;
        View r28 = this.mSecondPopupViewArrow;
        Intrinsics.checkNotNull(r28);
        r28.setTranslationX(r24);
    L24:
        if (this.OIndexScrollbar_DEBUG == false) goto L26;
        Log.d(this.OIndexScrollbar_TAG, "x = " + r24 + ", width = " + r15 + ", anchorView.getWidth() = " + r11.getWidth());
        Log.d(this.OIndexScrollbar_TAG, "y = " + r25 + ", height = " + r18 + ", anchorView.getHeight() = " + r11.getHeight());
    L26:
        PopupWindow r110 = this.mSecondPopup;
        Intrinsics.checkNotNull(r110);
        r110.showAtLocation(this, 51, r24, r25);
        return;
    L20:
        int r29 = r21 + r23;
        if (r29 <= getScreenWidth()) goto L24;
        View r30 = this.mSecondPopupViewArrow;
        Intrinsics.checkNotNull(r30);
        r30.setTranslationX(r29 - getScreenWidth());
        goto L24
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "changedView");
        super.onVisibilityChanged(r2, r3);
        if (r3 != 8) goto L11;
        if (r2 != this) goto L12;
        PopupWindow r4 = this.mPopupWindow;
        if (r4 == null) goto L13;
        Intrinsics.checkNotNull(r4);
        if (r4.isShowing() == false) goto L14;
        PopupWindow r1 = this.mPopupWindow;
        Intrinsics.checkNotNull(r1);
        r1.dismiss();
        return;
    L14:
        return;
    L13:
        return;
    L12:
        return;
    }

    private final void getParentxPos() {
        if (this.mHostX == this.DEFAULTX) goto L5;
        return;
    L5:
        Object r0 = getParent();
        Intrinsics.checkNotNullExpressionValue(r0, "this@OIndexScrollbar.getParent()");
        if ((r0 instanceof View) == false) goto L9;
        int[] r1 = new int[2];
        ((View) r0).getLocationInWindow(r1);
        this.mHostX = r1[0];
        return;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }

    public final LettersBar getLetterBar() {
        return this.mLettersBar;
    }
}
