package com.obric.oui.optinput;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import androidx.core.content.ContextCompat;
import com.bytedance.apm.alog.AlogMonitor;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.obric.common.oui.R;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.material.MaterialConfigFormatNames;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import obric.widget.ChipsView;

/* JADX INFO: compiled from: OOtpInputView.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u00ad\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0019\n\u0002\b\u0003\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u001f*\u0001!\u0018\u0000 \u008e\u00012\u00020\u0001:\b\u008e\u0001\u008f\u0001\u0090\u0001\u0091\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\u0007H\u0002J\u0006\u0010@\u001a\u00020>J\u0010\u0010A\u001a\u00020>2\u0006\u0010B\u001a\u00020\fH\u0002J\u0015\u0010C\u001a\u00020>2\u0006\u0010D\u001a\u00020EH\u0000¢\u0006\u0002\bFJ\b\u0010G\u001a\u00020\fH\u0002J\b\u0010H\u001a\u00020\u0007H\u0002J\u0006\u0010I\u001a\u00020JJ\u0006\u0010K\u001a\u00020\u0007J\r\u0010L\u001a\u00020\fH\u0000¢\u0006\u0002\bMJ\b\u0010N\u001a\u00020>H\u0002J\b\u0010O\u001a\u00020\fH\u0002J\u0006\u0010P\u001a\u00020\fJ\b\u0010Q\u001a\u00020>H\u0002J\b\u0010R\u001a\u00020>H\u0002J\b\u0010S\u001a\u00020>H\u0014J\b\u0010T\u001a\u00020\fH\u0016J\u0012\u0010U\u001a\u00020>2\b\u0010V\u001a\u0004\u0018\u00010WH\u0014J\u0010\u0010X\u001a\u00020Y2\u0006\u0010Z\u001a\u00020[H\u0016J\b\u0010\\\u001a\u00020>H\u0014J\u0010\u0010]\u001a\u00020>2\u0006\u0010^\u001a\u00020_H\u0014J\"\u0010`\u001a\u00020>2\u0006\u0010a\u001a\u00020\f2\u0006\u0010b\u001a\u00020\u00072\b\u0010c\u001a\u0004\u0018\u00010dH\u0014J\u0018\u0010e\u001a\u00020\f2\u0006\u0010f\u001a\u00020\u00072\u0006\u0010g\u001a\u00020hH\u0016J0\u0010i\u001a\u00020>2\u0006\u0010j\u001a\u00020\f2\u0006\u0010k\u001a\u00020\u00072\u0006\u0010l\u001a\u00020\u00072\u0006\u0010m\u001a\u00020\u00072\u0006\u0010n\u001a\u00020\u0007H\u0014J\u0018\u0010o\u001a\u00020>2\u0006\u0010p\u001a\u00020\u00072\u0006\u0010q\u001a\u00020\u0007H\u0014J\u0010\u0010r\u001a\u00020\f2\u0006\u0010g\u001a\u00020sH\u0016J\b\u0010t\u001a\u00020\fH\u0016J\b\u0010u\u001a\u00020>H\u0002J\b\u0010v\u001a\u00020>H\u0002J\u0010\u0010w\u001a\u00020>2\b\b\u0001\u0010x\u001a\u00020\u0007J\u000e\u0010y\u001a\u00020>2\u0006\u0010z\u001a\u00020\nJ\u000e\u0010{\u001a\u00020>2\u0006\u0010z\u001a\u00020\nJ\u0010\u0010|\u001a\u00020>2\b\b\u0001\u0010x\u001a\u00020\u0007J\u000e\u0010}\u001a\u00020>2\u0006\u0010z\u001a\u00020\nJ\u0010\u0010~\u001a\u00020>2\b\u0010\u007f\u001a\u0004\u0018\u00010JJ\u000f\u0010\u0080\u0001\u001a\u00020>2\u0006\u0010?\u001a\u00020\u0007J\u0011\u0010\u0081\u0001\u001a\u00020>2\b\b\u0001\u0010x\u001a\u00020\u0007J\u0010\u0010\u0082\u0001\u001a\u00020>2\u0007\u0010\u0083\u0001\u001a\u00020\fJ\u0010\u0010\u0084\u0001\u001a\u00020>2\u0007\u0010\u0085\u0001\u001a\u00020\fJ\u0011\u0010\u0086\u0001\u001a\u00020>2\b\b\u0001\u0010x\u001a\u00020\u0007J\u0010\u0010\u0087\u0001\u001a\u00020>2\u0007\u0010\u0088\u0001\u001a\u00020\nJ\t\u0010\u0089\u0001\u001a\u00020\fH\u0002J\t\u0010\u008a\u0001\u001a\u00020>H\u0002J\t\u0010\u008b\u0001\u001a\u00020>H\u0002J\t\u0010\u008c\u0001\u001a\u00020>H\u0002J\t\u0010\u008d\u0001\u001a\u00020>H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\"R\u0012\u0010#\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010(\u001a\u0004\u0018\u00010)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001c\u0010.\u001a\u0004\u0018\u00010/X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u000e\u00104\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u00108\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020:X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0092\u0001"}, d2 = {"Lcom/obric/oui/optinput/OOtpInputView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "actualCellSpacing", "", "blinkStarted", "", "boxPaintFill", "Landroid/graphics/Paint;", "boxPaintStroke", "cellBackgroundColor", "cellCenterY", "cellCornerRadius", "cellHeight", "cellRect", "Landroid/graphics/RectF;", "cellSpacing", "cellStrokeColor", "cellStrokeWidth", "cellWidth", "cellsStartX", "cellsTop", "codeChars", "", "codeLength", "cursorBlinkOn", "cursorBlinkRunnable", "com/obric/oui/optinput/OOtpInputView$cursorBlinkRunnable$1", "Lcom/obric/oui/optinput/OOtpInputView$cursorBlinkRunnable$1;", "cursorColor", "cursorHalfWidth", "cursorPaint", "cursorVisible", "inputIndex", "onCodeChangeListener", "Lcom/obric/oui/optinput/OOtpInputView$OnCodeChangeListener;", "getOnCodeChangeListener", "()Lcom/obric/oui/optinput/OOtpInputView$OnCodeChangeListener;", "setOnCodeChangeListener", "(Lcom/obric/oui/optinput/OOtpInputView$OnCodeChangeListener;)V", "onCodeCompleteListener", "Lcom/obric/oui/optinput/OOtpInputView$OnCodeCompleteListener;", "getOnCodeCompleteListener", "()Lcom/obric/oui/optinput/OOtpInputView$OnCodeCompleteListener;", "setOnCodeCompleteListener", "(Lcom/obric/oui/optinput/OOtpInputView$OnCodeCompleteListener;)V", "oneCharArray", "passwordCircleRadius", "passwordMode", "textCenterYOffset", "textColor", "textFontMetrics", "Landroid/graphics/Paint$FontMetrics;", "textPaint", "textSizePx", "applyCodeLengthFromAttribute", "", "length", "clear", "clearInternal", "silence", "commitTextFromIme", "text", "", "commitTextFromIme$OUI_standardRelease", "deleteLastChar", "findFirstEmptyIndex", "getCode", "", "getCodeLength", "handleDeleteFromIme", "handleDeleteFromIme$OUI_standardRelease", "hideKeyboard", "isCodeComplete", "isPasswordMode", "notifyCodeChanged", "notifyCodeComplete", "onAttachedToWindow", "onCheckIsTextEditor", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreateInputConnection", "Landroid/view/inputmethod/InputConnection;", "outAttrs", "Landroid/view/inputmethod/EditorInfo;", "onDetachedFromWindow", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onFocusChanged", "gainFocus", MaterialConfigFormatNames.DIRECTION, "previouslyFocusedRect", "Landroid/graphics/Rect;", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onLayout", "changed", "left", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onTouchEvent", "Landroid/view/MotionEvent;", "performClick", "refreshDimensionCache", "restartInput", "setCellBackgroundColor", "color", "setCellCornerRadius", "px", "setCellSpacing", "setCellStrokeColor", "setCellStrokeWidth", "setCode", AlogMonitor.ALOG_RESULT_CODE, "setCodeLength", "setCursorColor", "setCursorVisible", "visible", "setPasswordMode", "enabled", "setTextColor", "setTextSizeSp", CloudControlInf.SP, "shouldDrawCursor", "showKeyboard", "startBlink", "stopBlink", "updateTextMetrics", "Companion", "OnCodeChangeListener", "OnCodeCompleteListener", "OtpInputConnection", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OOtpInputView extends View {
    private static final float CIRCLE_RADIUS = 4.0f;
    private static final float CURSOR_HEIGHT_FACTOR = 0.375f;
    private static final float CURSOR_WIDTH = 2.0f;
    public static final Companion Companion = null;
    private static final long DEFAULT_BLINK_INTERVAL = 500;
    private static final float DEFAULT_CELL_HEIGHT_DP = 48.0f;
    private static final float DEFAULT_CELL_RADIUS_DP = 10.0f;
    private static final float DEFAULT_CELL_SPACING_DP = 12.0f;
    private static final float DEFAULT_CELL_STROKE_DP = 1.0f;
    private static final float DEFAULT_CELL_WIDTH_DP = 42.0f;
    public static final int DEFAULT_CODE_LENGTH = 6;
    private static final float DEFAULT_TEXT_SIZE_SP = 20.0f;
    private static final char EMPTY_CHAR = 0;
    public static final int MAX_CODE_LENGTH = 6;
    public static final int MIN_CODE_LENGTH = 1;
    private float actualCellSpacing;
    private boolean blinkStarted;
    private final Paint boxPaintFill;
    private final Paint boxPaintStroke;
    private int cellBackgroundColor;
    private float cellCenterY;
    private float cellCornerRadius;
    private float cellHeight;
    private final RectF cellRect;
    private float cellSpacing;
    private int cellStrokeColor;
    private float cellStrokeWidth;
    private float cellWidth;
    private float cellsStartX;
    private float cellsTop;
    private char[] codeChars;
    private int codeLength;
    private boolean cursorBlinkOn;
    private final OOtpInputView$cursorBlinkRunnable$1 cursorBlinkRunnable;
    private int cursorColor;
    private float cursorHalfWidth;
    private final Paint cursorPaint;
    private boolean cursorVisible;
    private int inputIndex;
    private OnCodeChangeListener onCodeChangeListener;
    private OnCodeCompleteListener onCodeCompleteListener;
    private final char[] oneCharArray;
    private float passwordCircleRadius;
    private boolean passwordMode;
    private float textCenterYOffset;
    private int textColor;
    private final Paint.FontMetrics textFontMetrics;
    private final Paint textPaint;
    private float textSizePx;

    /* JADX INFO: compiled from: OOtpInputView.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000fX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/obric/oui/optinput/OOtpInputView$Companion;", "", "()V", "CIRCLE_RADIUS", "", "CURSOR_HEIGHT_FACTOR", "CURSOR_WIDTH", "DEFAULT_BLINK_INTERVAL", "", "DEFAULT_CELL_HEIGHT_DP", "DEFAULT_CELL_RADIUS_DP", "DEFAULT_CELL_SPACING_DP", "DEFAULT_CELL_STROKE_DP", "DEFAULT_CELL_WIDTH_DP", "DEFAULT_CODE_LENGTH", "", "DEFAULT_TEXT_SIZE_SP", "EMPTY_CHAR", "", "MAX_CODE_LENGTH", "MIN_CODE_LENGTH", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: OOtpInputView.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/optinput/OOtpInputView$OnCodeChangeListener;", "", "onCodeChange", "", AlogMonitor.ALOG_RESULT_CODE, "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnCodeChangeListener {
        void onCodeChange(String r1);
    }

    /* JADX INFO: compiled from: OOtpInputView.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/optinput/OOtpInputView$OnCodeCompleteListener;", "", "onCodeComplete", "", AlogMonitor.ALOG_RESULT_CODE, "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnCodeCompleteListener {
        void onCodeComplete(String r1);
    }

    /* JADX INFO: compiled from: OOtpInputView.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/obric/oui/optinput/OOtpInputView$OtpInputConnection;", "Landroid/view/inputmethod/BaseInputConnection;", "view", "Lcom/obric/oui/optinput/OOtpInputView;", "(Lcom/obric/oui/optinput/OOtpInputView;)V", "commitText", "", "text", "", "newCursorPosition", "", "deleteSurroundingText", "beforeLength", "afterLength", "sendKeyEvent", "event", "Landroid/view/KeyEvent;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class OtpInputConnection extends BaseInputConnection {
        private final OOtpInputView view;

        public OtpInputConnection(OOtpInputView r3) {
            Intrinsics.checkNotNullParameter(r3, "view");
            super(r3, false);
            this.view = r3;
        }

        @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
        public boolean commitText(CharSequence r2, int r3) {
            if (r2 != null) goto L5;
        L8:
            boolean r0 = true;
        L9:
            if (r0 == false) goto L11;
            return true;
        L11:
            this.view.commitTextFromIme$OUI_standardRelease(r2);
            return true;
        L5:
            if (r2.length() == 0) goto L8;
            r0 = false;
            goto L9
        }

        @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
        public boolean deleteSurroundingText(int r2, int r3) {
            if (this.view.handleDeleteFromIme$OUI_standardRelease() == false) goto L6;
            return true;
        L6:
            return super.deleteSurroundingText(r2, r3);
        }

        @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
        public boolean sendKeyEvent(KeyEvent r4) {
            Intrinsics.checkNotNullParameter(r4, "event");
            if (r4.getAction() != 0) goto L14;
            if (r4.getKeyCode() == 67) goto L7;
            char r0 = (char) r4.getUnicodeChar();
            if (Character.isDigit(r0) == false) goto L14;
            this.view.commitTextFromIme$OUI_standardRelease(String.valueOf(r0));
            return true;
        L7:
            if (this.view.handleDeleteFromIme$OUI_standardRelease() == false) goto L14;
            return true;
        L14:
            return super.sendKeyEvent(r4);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public OOtpInputView(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public OOtpInputView(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    @Override // android.view.View
    public boolean onCheckIsTextEditor() {
        return true;
    }

    public /* synthetic */ OOtpInputView(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public static final /* synthetic */ boolean access$getBlinkStarted$p(OOtpInputView r0) {
        return r0.blinkStarted;
    }

    public static final /* synthetic */ boolean access$getCursorBlinkOn$p(OOtpInputView r0) {
        return r0.cursorBlinkOn;
    }

    public static final /* synthetic */ void access$setCursorBlinkOn$p(OOtpInputView r0, boolean r1) {
        r0.cursorBlinkOn = r1;
    }

    /* JADX WARN: Type inference failed for: r6v3, types: [com.obric.oui.optinput.OOtpInputView$cursorBlinkRunnable$1] */
    public OOtpInputView(Context r9, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r9, "context");
        super(r9, r10, r11);
        this.codeLength = 6;
        this.codeChars = new char[6];
        Paint r1 = new Paint(1);
        this.boxPaintFill = r1;
        Paint r3 = new Paint(1);
        this.boxPaintStroke = r3;
        Paint r4 = new Paint(1);
        this.textPaint = r4;
        Paint r5 = new Paint(1);
        this.cursorPaint = r5;
        this.cellRect = new RectF();
        this.textFontMetrics = new Paint.FontMetrics();
        this.oneCharArray = new char[1];
        this.cursorBlinkOn = true;
        this.cursorBlinkRunnable = new OOtpInputView$cursorBlinkRunnable$1(this);
        refreshDimensionCache();
        OOtpInputView r6 = this;
        this.cellWidth = OUnitExtensionKt.vdpFloat(r6, DEFAULT_CELL_WIDTH_DP);
        this.cellHeight = OUnitExtensionKt.vdpFloat(r6, DEFAULT_CELL_HEIGHT_DP);
        this.cellSpacing = OUnitExtensionKt.vdpFloat(r6, 12.0f);
        this.cellCornerRadius = OUnitExtensionKt.vdpFloat(r6, 10.0f);
        this.cellStrokeWidth = OUnitExtensionKt.vdpFloat(r6, 1.0f);
        this.textSizePx = OUnitExtensionKt.vspFloat(r6, 20.0f);
        this.cellBackgroundColor = ContextCompat.getColor(r9, R.color.oui_advanced_fill_list_item_card);
        this.cellStrokeColor = ContextCompat.getColor(r9, R.color.oui_advanced_fill_list_item_card);
        this.textColor = ContextCompat.getColor(r9, R.color.oui_basic_text_1);
        this.cursorColor = ContextCompat.getColor(r9, R.color.oui_functional_blue_6);
        this.passwordMode = false;
        this.cursorVisible = true;
        if (r10 == null) goto L10;
        TypedArray r12 = r9.obtainStyledAttributes(r10, R.styleable.OOtpInputView, r11, 0);
        Intrinsics.checkNotNullExpressionValue(r12, "context.obtainStyledAttr…putView, defStyleAttr, 0)");
        applyCodeLengthFromAttribute(r12.getInt(R.styleable.OOtpInputView_o_otpCodeLength, 6));     // Catch: Throwable -> L7
        this.cellWidth = r12.getDimension(R.styleable.OOtpInputView_o_otpCellWidth, this.cellWidth);     // Catch: Throwable -> L7
        this.cellHeight = r12.getDimension(R.styleable.OOtpInputView_o_otpCellHeight, this.cellHeight);     // Catch: Throwable -> L7
        this.cellSpacing = r12.getDimension(R.styleable.OOtpInputView_o_otpCellSpacing, this.cellSpacing);     // Catch: Throwable -> L7
        this.cellCornerRadius = r12.getDimension(R.styleable.OOtpInputView_o_otpCellCornerRadius, this.cellCornerRadius);     // Catch: Throwable -> L7
        this.cellStrokeWidth = r12.getDimension(R.styleable.OOtpInputView_o_otpCellStrokeWidth, this.cellStrokeWidth);     // Catch: Throwable -> L7
        this.cellBackgroundColor = r12.getColor(R.styleable.OOtpInputView_o_otpCellBackgroundColor, this.cellBackgroundColor);     // Catch: Throwable -> L7
        this.cellStrokeColor = r12.getColor(R.styleable.OOtpInputView_o_otpCellStrokeColor, this.cellStrokeColor);     // Catch: Throwable -> L7
        this.textColor = r12.getColor(R.styleable.OOtpInputView_o_otpTextColor, this.textColor);     // Catch: Throwable -> L7
        this.textSizePx = r12.getDimension(R.styleable.OOtpInputView_o_otpTextSize, this.textSizePx);     // Catch: Throwable -> L7
        this.cursorColor = r12.getColor(R.styleable.OOtpInputView_o_otpCursorColor, this.cursorColor);     // Catch: Throwable -> L7
        this.passwordMode = r12.getBoolean(R.styleable.OOtpInputView_o_otpPasswordMode, this.passwordMode);     // Catch: Throwable -> L7
        this.cursorVisible = r12.getBoolean(R.styleable.OOtpInputView_o_otpCursorVisible, this.cursorVisible);     // Catch: Throwable -> L7
        r12.recycle();
    L7:
        th = move-exception;
        r12.recycle();
        throw th;
    L10:
        setFocusable(true);
        setFocusableInTouchMode(true);
        setWillNotDraw(false);
        r1.setStyle(Paint.Style.FILL);
        r3.setStyle(Paint.Style.STROKE);
        r3.setStrokeWidth(this.cellStrokeWidth);
        r4.setColor(this.textColor);
        r4.setTextSize(this.textSizePx);
        r4.setTextAlign(Paint.Align.CENTER);
        r4.setTypeface(Typeface.create(Typeface.DEFAULT, 400, false));
        r5.setColor(this.cursorColor);
        r5.setStyle(Paint.Style.FILL);
        updateTextMetrics();
    }

    public final OnCodeCompleteListener getOnCodeCompleteListener() {
        return this.onCodeCompleteListener;
    }

    public final void setOnCodeCompleteListener(OnCodeCompleteListener r1) {
        this.onCodeCompleteListener = r1;
    }

    public final OnCodeChangeListener getOnCodeChangeListener() {
        return this.onCodeChangeListener;
    }

    public final void setOnCodeChangeListener(OnCodeChangeListener r1) {
        this.onCodeChangeListener = r1;
    }

    public final void setCodeLength(int r6) {
        int r7 = RangesKt.coerceIn(r6, 1, 6);
        if (r7 != this.codeLength) goto L5;
        return;
    L5:
        this.codeLength = r7;
        char[] r0 = this.codeChars;
        this.codeChars = new char[r7];
        int r8 = Math.min(r0.length, r7);
        int r1 = 0;
    L6:
        if (r1 >= r8) goto L8;
        this.codeChars[r1] = r0[r1];
        r1 = r1 + 1;
        goto L6
    L8:
        this.inputIndex = findFirstEmptyIndex();
        requestLayout();
        invalidate();
    }

    public final int getCodeLength() {
        return this.codeLength;
    }

    public final String getCode() {
        StringBuilder r0 = new StringBuilder(this.codeLength);
        int r1 = this.codeLength;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L7;
        int r3 = r2 + 1;
        char r4 = this.codeChars[r2];
        if (r4 == 0) goto L7;
        r0.append(r4);
        r2 = r3;
    L7:
        String r5 = r0.toString();
        Intrinsics.checkNotNullExpressionValue(r5, "builder.toString()");
        return r5;
    }

    public final void setCode(String r5) {
        boolean r0 = true;
        clearInternal(true);
        String r1 = r5;
        int r2 = 0;
        if (r1 != null) goto L5;
    L8:
        if (r0 == false) goto L11;
        invalidate();
        return;
    L11:
        int r3 = 0;
    L13:
        if (r2 >= r5.length()) goto L21;
        char r4 = r5.charAt(r2);
        r2 = r2 + 1;
        if (Character.isDigit(r4) == false) goto L13;
        if (r3 >= this.codeLength) goto L21;
        this.codeChars[r3] = r4;
        r3 = r3 + 1;
    L21:
        this.inputIndex = r3;
        notifyCodeChanged();
        invalidate();
        if (isCodeComplete() == false) goto L31;
        notifyCodeComplete();
        return;
    L31:
        return;
    L5:
        if (r1.length() == 0) goto L8;
        r0 = false;
        goto L8
    }

    public final void clear() {
        clearInternal(false);
    }

    public final void setPasswordMode(boolean r2) {
        if (this.passwordMode != r2) goto L5;
        return;
    L5:
        this.passwordMode = r2;
        invalidate();
        restartInput();
    }

    public final boolean isPasswordMode() {
        return this.passwordMode;
    }

    public final void setCursorVisible(boolean r2) {
        if (this.cursorVisible != r2) goto L5;
        return;
    L5:
        this.cursorVisible = r2;
        if (r2 == true) goto L9;
        stopBlink();
    L11:
        invalidate();
        return;
    L9:
        if (hasFocus() == false) goto L11;
        startBlink();
        goto L11
    }

    public final void setCursorColor(int r2) {
        if (this.cursorColor != r2) goto L5;
        return;
    L5:
        this.cursorColor = r2;
        this.cursorPaint.setColor(r2);
        invalidate();
    }

    public final void setCellSpacing(float r2) {
        if (this.cellSpacing != r2) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        this.cellSpacing = r2;
        requestLayout();
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void setCellCornerRadius(float r2) {
        if (this.cellCornerRadius != r2) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        this.cellCornerRadius = r2;
        invalidate();
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void setCellStrokeWidth(float r2) {
        if (this.cellStrokeWidth != r2) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        this.cellStrokeWidth = r2;
        this.boxPaintStroke.setStrokeWidth(r2);
        invalidate();
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void setCellStrokeColor(int r2) {
        if (this.cellStrokeColor != r2) goto L5;
        return;
    L5:
        this.cellStrokeColor = r2;
        invalidate();
    }

    public final void setCellBackgroundColor(int r2) {
        if (this.cellBackgroundColor != r2) goto L5;
        return;
    L5:
        this.cellBackgroundColor = r2;
        invalidate();
    }

    public final void setTextSizeSp(float r2) {
        float r3 = OUnitExtensionKt.vspFloat(this, r2);
        if (this.textSizePx != r3) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        this.textSizePx = r3;
        this.textPaint.setTextSize(r3);
        updateTextMetrics();
        invalidate();
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void setTextColor(int r2) {
        if (this.textColor != r2) goto L5;
        return;
    L5:
        this.textColor = r2;
        this.textPaint.setColor(r2);
        invalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int r4, int r5) {
        float r0 = this.cellWidth;
        int r1 = this.codeLength;
        setMeasuredDimension(View.resolveSize((int) ((getPaddingLeft() + getPaddingRight()) + ((r0 * r1) + (this.cellSpacing * (r1 - 1)))), r4), View.resolveSize((int) ((getPaddingTop() + getPaddingBottom()) + this.cellHeight), r5));
    }

    @Override // android.view.View
    protected void onLayout(boolean r4, int r5, int r6, int r7, int r8) {
        super.onLayout(r4, r5, r6, r7, r8);
        int r9 = ((r7 - r5) - getPaddingLeft()) - getPaddingRight();
        int r10 = ((r8 - r6) - getPaddingTop()) - getPaddingBottom();
        float r11 = this.cellSpacing;
        float r12 = this.cellWidth;
        int r13 = this.codeLength;
        float r14 = r9;
        if (((r13 * r12) + ((r13 - 1) * r11)) <= r14) goto L8;
        if (r13 <= 1) goto L8;
        r11 = (r14 - (r13 * r12)) / (r13 - 1);
        if (r11 >= 0.0f) goto L8;
        r11 = 0.0f;
    L8:
        this.actualCellSpacing = r11;
        this.cellsStartX = getPaddingLeft() + ((r14 - ((r12 * r13) + (r11 * (r13 - 1)))) / 2.0f);
        float r15 = getPaddingTop();
        float r16 = this.cellHeight;
        float r17 = r15 + ((r10 - r16) / 2.0f);
        this.cellsTop = r17;
        this.cellCenterY = r17 + (r16 / 2.0f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas r13) {
        Intrinsics.checkNotNullParameter(r13, "canvas");
        super.onDraw(r13);
        this.boxPaintFill.setColor(this.cellBackgroundColor);
        this.boxPaintStroke.setColor(this.cellStrokeColor);
        int r0 = this.codeLength;
        int r2 = 0;
    L4:
        if (r2 >= r0) goto L16;
        int r4 = r2 + 1;
        float r5 = this.cellsStartX;
        float r7 = this.cellWidth;
        float r6 = r5 + (r2 * (this.actualCellSpacing + r7));
        float r8 = this.cellsTop;
        float r9 = this.cellHeight + r8;
        this.cellRect.set(r6, r8, r7 + r6, r9);
        RectF r10 = this.cellRect;
        float r11 = this.cellCornerRadius;
        r13.drawRoundRect(r10, r11, r11, this.boxPaintFill);
        float r12 = this.cellStrokeWidth;
        if (r12 <= 0.0f) goto L8;
        float r14 = r12 / 2.0f;
        float r3 = RangesKt.coerceAtLeast(this.cellCornerRadius - r14, 0.0f);
        this.cellRect.inset(r14, r14);
        r13.drawRoundRect(this.cellRect, r3, r3, this.boxPaintStroke);
        float r15 = -r14;
        this.cellRect.inset(r15, r15);
    L8:
        char r16 = this.codeChars[r2];
        if (r16 == 0) goto L14;
        float r17 = this.cellRect.centerX();
        if (this.passwordMode == false) goto L13;
        r13.drawCircle(r17, this.cellCenterY, this.passwordCircleRadius, this.textPaint);
        goto L14
    L13:
        char[] r18 = this.oneCharArray;
        r18[0] = r16;
        r13.drawText(r18, 0, 1, r17, this.cellCenterY + this.textCenterYOffset, this.textPaint);
    L14:
        r2 = r4;
        goto L4
    L16:
        if (shouldDrawCursor() == false) goto L23;
        int r1 = RangesKt.coerceIn(this.inputIndex, 0, this.codeLength - 1);
        float r19 = this.cellsStartX;
        float r20 = this.cellWidth;
        float r21 = r19 + (r1 * (this.actualCellSpacing + r20));
        float r22 = (r21 + (r20 + r21)) / 2.0f;
        float r23 = this.cellHeight * CURSOR_HEIGHT_FACTOR;
        float r24 = this.cellCenterY;
        float r25 = r23 / 2.0f;
        float r26 = r24 - r25;
        float r27 = r24 + r25;
        float r28 = this.cursorHalfWidth;
        r13.drawRect(r22 - r28, r26, r22 + r28, r27, this.cursorPaint);
        return;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration r1) {
        super.onConfigurationChanged(r1);
        refreshDimensionCache();
    }

    private final void refreshDimensionCache() {
        OOtpInputView r0 = this;
        this.passwordCircleRadius = OUnitExtensionKt.vdpFloat(r0, CIRCLE_RADIUS);
        this.cursorHalfWidth = OUnitExtensionKt.vdpFloat(r0, 1.0f);
    }

    private final boolean shouldDrawCursor() {
        if (isFocused() == true) goto L5;
    L15:
        return false;
    L5:
        if (this.cursorVisible == false) goto L15;
        if (this.cursorBlinkOn == true) goto L11;
        return false;
    L11:
        if (this.inputIndex < this.codeLength) goto L13;
        return false;
    L13:
        return true;
    }

    private final void updateTextMetrics() {
        this.textPaint.getFontMetrics(this.textFontMetrics);
        this.textCenterYOffset = -((this.textFontMetrics.ascent + this.textFontMetrics.descent) / 2.0f);
    }

    @Override // android.view.View
    public InputConnection onCreateInputConnection(EditorInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "outAttrs");
        if (this.passwordMode == false) goto L5;
        int r0 = 16;
    L6:
        r2.inputType = r0 | 2;
        r2.imeOptions = 268435462;
        r2.initialSelStart = this.inputIndex;
        r2.initialSelEnd = this.inputIndex;
        return new OtpInputConnection(this);
    L5:
        r0 = 0;
        goto L6
    }

    public final void commitTextFromIme$OUI_standardRelease(CharSequence r6) {
        Intrinsics.checkNotNullParameter(r6, "text");
        if (isCodeComplete() == false) goto L5;
        return;
    L5:
        int r0 = 0;
        boolean r1 = false;
    L7:
        if (r0 >= r6.length()) goto L16;
        char r2 = r6.charAt(r0);
        r0 = r0 + 1;
        if (Character.isDigit(r2) == false) goto L7;
        int r3 = this.inputIndex;
        int r4 = this.codeLength;
        if (r3 >= r4) goto L16;
        this.codeChars[r3] = r2;
        int r5 = r3 + 1;
        this.inputIndex = r5;
        r1 = true;
        if (r5 < r4) goto L7;
    L16:
        if (r1 == false) goto L28;
        notifyCodeChanged();
        invalidate();
        if (isCodeComplete() == false) goto L29;
        notifyCodeComplete();
        return;
    L29:
        return;
    }

    public final boolean handleDeleteFromIme$OUI_standardRelease() {
        boolean r0 = deleteLastChar();
        if (r0 == false) goto L5;
        notifyCodeChanged();
        invalidate();
    L5:
        return r0;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int r4, KeyEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        if (r4 != 67) goto L8;
        if (handleDeleteFromIme$OUI_standardRelease() == false) goto L8;
        return true;
    L8:
        if (r4 < 7) goto L14;
        if (r4 > 16) goto L14;
        commitTextFromIme$OUI_standardRelease(String.valueOf((char) ((r4 - 7) + 48)));
        return true;
    L14:
        if (r4 < 144) goto L20;
        if (r4 > 153) goto L20;
        commitTextFromIme$OUI_standardRelease(String.valueOf((char) ((r4 - ChipsView.HISTORY) + 48)));
        return true;
    L20:
        return super.onKeyDown(r4, r5);
    }

    private final boolean deleteLastChar() {
        int r0 = this.inputIndex;
        if (r0 > 0) goto L5;
        return false;
    L5:
        int r1 = RangesKt.coerceAtLeast(r0 - 1, 0);
        char[] r3 = this.codeChars;
        if (r3[r1] != 0) goto L17;
        if (r1 < 0) goto L15;
    L8:
        int r4 = r1 - 1;
        char[] r5 = this.codeChars;
        if (r5[r1] != 0) goto L10;
        if (r4 < 0) goto L15;
        r1 = r4;
        goto L8
    L10:
        r5[r1] = 0;
        this.inputIndex = r1;
        return true;
    L15:
        this.inputIndex = 0;
        return false;
    L17:
        r3[r1] = 0;
        this.inputIndex = r1;
        return true;
    }

    private final boolean isCodeComplete() {
        if (this.inputIndex < this.codeLength) goto L5;
        return true;
    L5:
        return false;
    }

    private final void notifyCodeComplete() {
        OnCodeCompleteListener r0 = this.onCodeCompleteListener;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.onCodeComplete(getCode());
    }

    private final void notifyCodeChanged() {
        OnCodeChangeListener r0 = this.onCodeChangeListener;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.onCodeChange(getCode());
    }

    private final void clearInternal(boolean r6) {
        int r0 = this.codeLength;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        this.codeChars[r2] = 0;
        r2 = r2 + 1;
        goto L3
    L5:
        this.inputIndex = 0;
        if (r6 == true) goto L10;
        notifyCodeChanged();
        invalidate();
        return;
    }

    private final int findFirstEmptyIndex() {
        int r0 = this.codeLength;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L9;
        int r2 = r1 + 1;
        if (this.codeChars[r1] == 0) goto L6;
        r1 = r2;
        goto L3
    L6:
        return r1;
    L9:
        return this.codeLength;
    }

    private final void applyCodeLengthFromAttribute(int r3) {
        int r4 = RangesKt.coerceIn(r3, 1, 6);
        if (r4 != this.codeLength) goto L5;
        return;
    L5:
        this.codeLength = r4;
        this.codeChars = new char[r4];
        this.inputIndex = 0;
    }

    private final void restartInput() {
        Object r0 = getContext().getSystemService("input_method");
        if ((r0 instanceof InputMethodManager) == false) goto L5;
        InputMethodManager r1 = (InputMethodManager) r0;
    L6:
        if (r1 == null) goto L10;
        r1.restartInput(this);
        return;
    L10:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // android.view.View
    protected void onFocusChanged(boolean r1, int r2, Rect r3) {
        super.onFocusChanged(r1, r2, r3);
        if (r1 == true) goto L5;
        stopBlink();
        hideKeyboard();
    L9:
        invalidate();
        return;
    L5:
        if (this.cursorVisible == false) goto L7;
        startBlink();
    L7:
        showKeyboard();
        goto L9
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        int r0 = r3.getAction();
        if (r0 == 0) goto L9;
        if (r0 != 1) goto L6;
        performClick();
        return true;
    L6:
        return super.onTouchEvent(r3);
    L9:
        requestFocus();
        showKeyboard();
        return true;
    }

    @Override // android.view.View
    public boolean performClick() {
        super.performClick();
        return true;
    }

    private final void showKeyboard() {
        Object r0 = getContext().getSystemService("input_method");
        if ((r0 instanceof InputMethodManager) == false) goto L5;
        InputMethodManager r1 = (InputMethodManager) r0;
    L6:
        if (r1 == null) goto L10;
        r1.showSoftInput(this, 1);
        return;
    L10:
        return;
    L5:
        r1 = null;
        goto L6
    }

    private final void hideKeyboard() {
        Object r0 = getContext().getSystemService("input_method");
        if ((r0 instanceof InputMethodManager) == false) goto L5;
        InputMethodManager r1 = (InputMethodManager) r0;
    L6:
        if (r1 == null) goto L10;
        r1.hideSoftInputFromWindow(getWindowToken(), 0);
        return;
    L10:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isFocusable() == false) goto L10;
        if (isFocusableInTouchMode() == false) goto L10;
        if (isInEditMode() == true) goto L10;
        requestFocus();
        showKeyboard();
    L10:
        if (hasFocus() == true) goto L12;
        return;
    L12:
        if (this.cursorVisible == false) goto L16;
        startBlink();
        return;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopBlink();
    }

    private final void startBlink() {
        if (this.blinkStarted == false) goto L5;
        return;
    L5:
        this.blinkStarted = true;
        this.cursorBlinkOn = true;
        removeCallbacks(this.cursorBlinkRunnable);
        postDelayed(this.cursorBlinkRunnable, 500);
    }

    private final void stopBlink() {
        this.blinkStarted = false;
        removeCallbacks(this.cursorBlinkRunnable);
    }
}
