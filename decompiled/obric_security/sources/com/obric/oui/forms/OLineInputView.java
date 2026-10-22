package com.obric.oui.forms;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.bytedanceos.datausage.DataUsageDetailActivity;
import com.bytedanceos.security.invokeHistory.InvokeHistoryActivity;
import com.obric.common.oui.R;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.common.util.ViewExtensionsKt;
import com.obric.oui.divider.ODivider;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import obric.widget.search.data.SearchConfigType;

/* JADX INFO: compiled from: OLineInputView.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000Ê\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u0000 ¬\u00012\u00020\u0001:\b¬\u0001\u00ad\u0001®\u0001¯\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\b\u0010]\u001a\u00020^H\u0002J@\u0010_\u001a\u00020^28\u0010`\u001a4\u0012\u0015\u0012\u0013\u0018\u00010b¢\u0006\f\bc\u0012\b\bd\u0012\u0004\b\b(e\u0012\u0013\u0012\u00110+¢\u0006\f\bc\u0012\b\bd\u0012\u0004\b\b(f\u0012\u0004\u0012\u00020^0aJ\u000e\u0010g\u001a\u00020^2\u0006\u0010h\u001a\u00020+J\u0006\u0010i\u001a\u00020\u001aJ\b\u0010j\u001a\u00020kH\u0016J\u0006\u0010l\u001a\u00020&J\u0006\u0010m\u001a\u00020^J\u0006\u0010n\u001a\u00020^J\u0006\u0010o\u001a\u00020^J\u0006\u0010p\u001a\u00020^J\u0006\u0010q\u001a\u00020^J\u0006\u0010r\u001a\u00020^J\u0006\u0010s\u001a\u00020^J\b\u0010t\u001a\u00020^H\u0002J\u0006\u0010u\u001a\u00020^J\u0006\u0010v\u001a\u00020^J\u0006\u0010w\u001a\u00020^J\b\u0010x\u001a\u00020^H\u0014J)\u0010y\u001a\u00020^2!\u0010`\u001a\u001d\u0012\u0013\u0012\u00110&¢\u0006\f\bc\u0012\b\bd\u0012\u0004\b\b({\u0012\u0004\u0012\u00020^0zJ\b\u0010|\u001a\u00020^H\u0002J\u0010\u0010}\u001a\u00020^2\b\b\u0002\u0010~\u001a\u00020+J\u0010\u0010\u007f\u001a\u00020^2\b\u0010\u0080\u0001\u001a\u00030\u0081\u0001J\u0012\u0010\u0082\u0001\u001a\u00020^2\u0007\u0010\u0083\u0001\u001a\u00020+H\u0016J\u0011\u0010\u0084\u0001\u001a\u00020^2\b\u0010\u0085\u0001\u001a\u00030\u0086\u0001J+\u0010\u0087\u0001\u001a\u00020^2\u0007\u0010\u0088\u0001\u001a\u00020\u00072\u0007\u0010\u0089\u0001\u001a\u00020\u00072\u0007\u0010\u008a\u0001\u001a\u00020\u00072\u0007\u0010\u008b\u0001\u001a\u00020\u0007J\u0007\u0010\u008c\u0001\u001a\u00020^J\u0007\u0010\u008d\u0001\u001a\u00020^J\u0007\u0010\u008e\u0001\u001a\u00020^J\u0007\u0010\u008f\u0001\u001a\u00020^J\u001e\u0010\u0090\u0001\u001a\u00020^2\u0007\u0010\u0091\u0001\u001a\u00020\u00072\f\b\u0002\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0093\u0001J\u0007\u0010\u0094\u0001\u001a\u00020^J\u0011\u0010\u0095\u0001\u001a\u00020^2\b\u0010L\u001a\u0004\u0018\u00010&J\u0011\u0010\u0096\u0001\u001a\u00020^2\b\u0010\u0097\u0001\u001a\u00030\u0098\u0001J\u0011\u0010\u0099\u0001\u001a\u00020^2\b\u0010\u009a\u0001\u001a\u00030\u009b\u0001J\u0012\u0010\u009c\u0001\u001a\u00020^2\t\u0010\u009d\u0001\u001a\u0004\u0018\u00010\u001cJ\u0007\u0010\u009e\u0001\u001a\u00020^J\u0007\u0010\u009f\u0001\u001a\u00020^J\u0007\u0010 \u0001\u001a\u00020^J\u0007\u0010¡\u0001\u001a\u00020^J\u0012\u0010¢\u0001\u001a\u00020^2\t\u0010£\u0001\u001a\u0004\u0018\u00010&J\u0012\u0010¤\u0001\u001a\u00020^2\t\u0010£\u0001\u001a\u0004\u0018\u00010&J\u0007\u0010¥\u0001\u001a\u00020^J\t\u0010¦\u0001\u001a\u00020^H\u0002J\u0007\u0010§\u0001\u001a\u00020^J\u0007\u0010¨\u0001\u001a\u00020^J\u0007\u0010©\u0001\u001a\u00020^J\u0010\u0010ª\u0001\u001a\u00020^2\u0007\u0010«\u0001\u001a\u00020\u001aR\u000e\u0010\n\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001d\u001a\u00020\u001e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010!\u001a\u00020\"¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010'\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u000eR\u000e\u0010)\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u00104\u001a\u000205¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0011\u00108\u001a\u000209¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0011\u0010<\u001a\u000205¢\u0006\b\n\u0000\u001a\u0004\b=\u00107R\u0011\u0010>\u001a\u000209¢\u0006\b\n\u0000\u001a\u0004\b?\u0010;R\u0011\u0010@\u001a\u000205¢\u0006\b\n\u0000\u001a\u0004\bA\u00107R\u001c\u0010B\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u0012\"\u0004\bD\u0010\u0014R\u0011\u0010E\u001a\u00020F¢\u0006\b\n\u0000\u001a\u0004\bG\u0010HR\u000e\u0010I\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010J\u001a\u00020F¢\u0006\b\n\u0000\u001a\u0004\bK\u0010HR\u0010\u0010L\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010N\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\bO\u0010\u000eR\u000e\u0010P\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010Q\u001a\u00020R¢\u0006\b\n\u0000\u001a\u0004\bS\u0010TR\u0011\u0010U\u001a\u00020R¢\u0006\b\n\u0000\u001a\u0004\bV\u0010TR\u0011\u0010W\u001a\u00020R¢\u0006\b\n\u0000\u001a\u0004\bX\u0010TR\u0011\u0010Y\u001a\u00020R¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010TR\u0011\u0010[\u001a\u00020R¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010T¨\u0006°\u0001"}, d2 = {"Lcom/obric/oui/forms/OLineInputView;", "Lcom/obric/oui/forms/AbsOForm;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "arrangeDirection", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "DEFAULT_MAX_LINES", "actionContainer", "Landroid/view/ViewGroup;", "getActionContainer", "()Landroid/view/ViewGroup;", "activeBorderView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getActiveBorderView", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setActiveBorderView", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "getArrangeDirection", "()I", "setArrangeDirection", "(I)V", "config", "Lcom/obric/oui/forms/OLineInputView$Config;", "counterTextWatcher", "Landroid/text/TextWatcher;", "divider", "Lcom/obric/oui/divider/ODivider;", "getDivider", "()Lcom/obric/oui/divider/ODivider;", "editText", "Lcom/obric/oui/forms/OFormEditText;", "getEditText", "()Lcom/obric/oui/forms/OFormEditText;", "errorTips", "", "inputContainer", "getInputContainer", "inputTips", "isErrorState", "", "isShowActionImage", "isShowActionText", "isShowErrorTips", "isShowInputTips", "isShowPrefix", "isShowSuffix", "isShowTitle", "isShowTitleIcon", "ivAction", "Landroid/widget/ImageView;", "getIvAction", "()Landroid/widget/ImageView;", "ivActionContainer", "Landroid/widget/LinearLayout;", "getIvActionContainer", "()Landroid/widget/LinearLayout;", "ivClear", "getIvClear", "ivClearContainer", "getIvClearContainer", "ivTitleIcon", "getIvTitleIcon", "leftContainer", "getLeftContainer", "setLeftContainer", "prefixContainer", "Landroid/widget/RelativeLayout;", "getPrefixContainer", "()Landroid/widget/RelativeLayout;", "showTitleDefaultIcon", "suffixContainer", "getSuffixContainer", "text", "textGravity", "titleContainer", "getTitleContainer", "titleDefaultIconSize", "tvAction", "Landroid/widget/TextView;", "getTvAction", "()Landroid/widget/TextView;", "tvCounter", "getTvCounter", "tvErrorTips", "getTvErrorTips", "tvInputTips", "getTvInputTips", "tvTitle", "getTvTitle", "clear", "", "editTextOnFocusChangeListener", "handler", "Lkotlin/Function2;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", BaseSwitches.V, "hasFocus", "enableVerticalScrollBar", "enable", "getConfig", "getInterEditText", "Landroid/widget/EditText;", "getText", "hideActionImage", "hideActionText", "hideClear", "hideDivider", "hideErrorTips", "hideInputTips", "hidePrefixView", "hideSoftInput", "hideSuffixView", "hideTitle", "hideTitleIcon", "onAttachedToWindow", "onTextExceedLengthListener", "Lkotlin/Function1;", "s", "refreshConfig", "setAutoHideClearWhenTextEmpty", "flag", "setEditTextOnFocusChangeListener", "listener", "Landroid/view/View$OnFocusChangeListener;", "setEnabled", "enabled", "setInputContainerBackground", "drawable", "Landroid/graphics/drawable/Drawable;", "setInputContainerPadding", "left", "top", "right", "bottom", "setInputViewActived", "setInputViewError", "setInputViewNormal", "setMiddleTitleIcon", "setMode", SearchConfigType.KEY_MODE, "clickListener", "Landroid/view/View$OnClickListener;", "setSmallTitleIcon", "setText", "setTextClearedListener", "textClearedListener", "Lcom/obric/oui/forms/OLineInputView$TextClearedListener;", "setTextExceedLengthListener", "textExceedLengthListener", "Lcom/obric/oui/forms/OLineInputView$TextExceedLengthListener;", "setTextWatcher", "textWatcher", "showActionImage", "showActionText", "showClear", "showDivider", "showErrorTips", "tips", "showInputTips", "showPrefixView", "showSoftInput", "showSuffixView", "showTitle", "showTitleIcon", "updateConfig", "newConfig", "Companion", "Config", "TextClearedListener", "TextExceedLengthListener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OLineInputView extends AbsOForm {
    public static final int ARRANGE_DIRECTION_HORIZONTAL = 1;
    public static final int ARRANGE_DIRECTION_VERTICAL = 0;
    public static final int ARRANGE_DIRECTION_VERTICAL_SINGEL_BOX = 2;
    public static final int CLICK_MODE = 3;
    public static final Companion Companion = null;
    public static final int INPUT_MODE = 2;
    public static final int SIZE_MEDIUM = 1;
    public static final int SIZE_SMALL = 0;
    private final int DEFAULT_MAX_LINES;
    private final ViewGroup actionContainer;
    private ConstraintLayout activeBorderView;
    private int arrangeDirection;
    private Config config;
    private TextWatcher counterTextWatcher;
    private final ODivider divider;
    private final OFormEditText editText;
    private String errorTips;
    private final ViewGroup inputContainer;
    private String inputTips;
    private boolean isErrorState;
    private boolean isShowActionImage;
    private boolean isShowActionText;
    private boolean isShowErrorTips;
    private boolean isShowInputTips;
    private boolean isShowPrefix;
    private boolean isShowSuffix;
    private boolean isShowTitle;
    private boolean isShowTitleIcon;
    private final ImageView ivAction;
    private final LinearLayout ivActionContainer;
    private final ImageView ivClear;
    private final LinearLayout ivClearContainer;
    private final ImageView ivTitleIcon;
    private ConstraintLayout leftContainer;
    private final RelativeLayout prefixContainer;
    private boolean showTitleDefaultIcon;
    private final RelativeLayout suffixContainer;
    private String text;
    private int textGravity;
    private final ViewGroup titleContainer;
    private int titleDefaultIconSize;
    private final TextView tvAction;
    private final TextView tvCounter;
    private final TextView tvErrorTips;
    private final TextView tvInputTips;
    private final TextView tvTitle;

    /* JADX INFO: compiled from: OLineInputView.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/oui/forms/OLineInputView$Companion;", "", "()V", "ARRANGE_DIRECTION_HORIZONTAL", "", "ARRANGE_DIRECTION_VERTICAL", "ARRANGE_DIRECTION_VERTICAL_SINGEL_BOX", "CLICK_MODE", "INPUT_MODE", "SIZE_MEDIUM", "SIZE_SMALL", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: OLineInputView.kt */
    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b]\u0018\u00002\u00020\u0001:\u0002\u0081\u0001B«\u0002\b\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0005\u0012\b\b\u0002\u0010 \u001a\u00020\f\u0012\b\b\u0002\u0010!\u001a\u00020\u0005\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%¢\u0006\u0002\u0010&J\u0016\u0010\u0014\u001a\u00020\u00002\u0006\u0010q\u001a\u00020\u00152\u0006\u0010r\u001a\u00020\u0017J3\u0010\u000e\u001a\u00020\u00002\u0006\u0010s\u001a\u00020\u00032\u0006\u0010t\u001a\u00020\u00052\n\b\u0002\u0010r\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010u\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010vJ\u000e\u0010\u001e\u001a\u00020\u00002\u0006\u0010w\u001a\u00020\u0005J\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010x\u001a\u00020\u0012J\u000e\u0010!\u001a\u00020\u00002\u0006\u0010y\u001a\u00020\u0005J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010s\u001a\u00020\u0003J\u000e\u0010\u001b\u001a\u00020\u00002\u0006\u0010z\u001a\u00020\fJ\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010{\u001a\u00020\u0003J\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0005J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010|\u001a\u00020\fJ\u000e\u0010 \u001a\u00020\u00002\u0006\u0010 \u001a\u00020\fJ\u000e\u0010V\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u0005J\u000e\u0010Y\u001a\u00020\u00002\u0006\u0010}\u001a\u00020\tJ\u000e\u0010b\u001a\u00020\u00002\u0006\u0010}\u001a\u00020\tJ\u000e\u0010~\u001a\u00020\u00002\u0006\u0010q\u001a\u00020\u0015J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u007f\u001a\u00020\u0005J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\u007f\u001a\u00020\u0005J\u0010\u0010$\u001a\u00020\u00002\b\u0010$\u001a\u0004\u0018\u00010%J\u000e\u0010\"\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020#J\u000f\u0010\u000f\u001a\u00020\u00002\u0007\u0010\u0080\u0001\u001a\u00020\u0010J\u000e\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0003R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u0010\u0013\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010;\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010,\"\u0004\b=\u0010.R\u001a\u0010\u001e\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u00104\"\u0004\b?\u00106R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u001a\u0010!\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u00104\"\u0004\bE\u00106R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u00100\"\u0004\bG\u00102R\u001e\u0010\u001b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010;\u001a\u0004\bH\u00108\"\u0004\bI\u0010:R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u00100\"\u0004\bK\u00102R\u001a\u0010\u001d\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u00104\"\u0004\bL\u00106R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010(\"\u0004\bN\u0010*R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010;\u001a\u0004\bO\u00108\"\u0004\bP\u0010:R\u001a\u0010 \u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u001a\u0010\u001f\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u00104\"\u0004\bV\u00106R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u00104\"\u0004\b\\\u00106R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u00104\"\u0004\b^\u00106R\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u00104\"\u0004\b`\u00106R\u001c\u0010\n\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010X\"\u0004\bb\u0010ZR\u001c\u0010$\u001a\u0004\u0018\u00010%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010d\"\u0004\be\u0010fR\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bo\u00100\"\u0004\bp\u00102¨\u0006\u0082\u0001"}, d2 = {"Lcom/obric/oui/forms/OLineInputView$Config;", "", "title", "", "showCounter", "", "showClear", "hintText", "prefixView", "Landroid/view/View;", "suffixView", "lengthLimit", "", "showDivider", "actionText", "textWatcher", "Landroid/text/TextWatcher;", "editTextOnFocusChangeListener", "Landroid/view/View$OnFocusChangeListener;", "actionTextClickable", "actionImageDrawable", "Landroid/graphics/drawable/Drawable;", "actionTextListener", "Landroid/view/View$OnClickListener;", "actionImageDrawableListener", "inputTips", "actionTextColor", "inputBoxHeight", "ivTitleIcon", "isInSearchBar", "autoHideClearWhenTextEmpty", "multiLine", SearchConfigType.KEY_MODE, "hideClearWhenNoFocus", "textExceedLengthListener", "Lcom/obric/oui/forms/OLineInputView$TextExceedLengthListener;", "textClearedListener", "Lcom/obric/oui/forms/OLineInputView$TextClearedListener;", "(Ljava/lang/String;ZZLjava/lang/String;Landroid/view/View;Landroid/view/View;Ljava/lang/Integer;ZLjava/lang/String;Landroid/text/TextWatcher;Landroid/view/View$OnFocusChangeListener;ZLandroid/graphics/drawable/Drawable;Landroid/view/View$OnClickListener;Landroid/view/View$OnClickListener;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Landroid/graphics/drawable/Drawable;ZZZIZLcom/obric/oui/forms/OLineInputView$TextExceedLengthListener;Lcom/obric/oui/forms/OLineInputView$TextClearedListener;)V", "getActionImageDrawable", "()Landroid/graphics/drawable/Drawable;", "setActionImageDrawable", "(Landroid/graphics/drawable/Drawable;)V", "getActionImageDrawableListener", "()Landroid/view/View$OnClickListener;", "setActionImageDrawableListener", "(Landroid/view/View$OnClickListener;)V", "getActionText", "()Ljava/lang/String;", "setActionText", "(Ljava/lang/String;)V", "getActionTextClickable", "()Z", "setActionTextClickable", "(Z)V", "getActionTextColor", "()Ljava/lang/Integer;", "setActionTextColor", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getActionTextListener", "setActionTextListener", "getAutoHideClearWhenTextEmpty", "setAutoHideClearWhenTextEmpty", "getEditTextOnFocusChangeListener", "()Landroid/view/View$OnFocusChangeListener;", "setEditTextOnFocusChangeListener", "(Landroid/view/View$OnFocusChangeListener;)V", "getHideClearWhenNoFocus", "setHideClearWhenNoFocus", "getHintText", "setHintText", "getInputBoxHeight", "setInputBoxHeight", "getInputTips", "setInputTips", "setInSearchBar", "getIvTitleIcon", "setIvTitleIcon", "getLengthLimit", "setLengthLimit", "getMode", "()I", "setMode", "(I)V", "getMultiLine", "setMultiLine", "getPrefixView", "()Landroid/view/View;", "setPrefixView", "(Landroid/view/View;)V", "getShowClear", "setShowClear", "getShowCounter", "setShowCounter", "getShowDivider", "setShowDivider", "getSuffixView", "setSuffixView", "getTextClearedListener", "()Lcom/obric/oui/forms/OLineInputView$TextClearedListener;", "setTextClearedListener", "(Lcom/obric/oui/forms/OLineInputView$TextClearedListener;)V", "getTextExceedLengthListener", "()Lcom/obric/oui/forms/OLineInputView$TextExceedLengthListener;", "setTextExceedLengthListener", "(Lcom/obric/oui/forms/OLineInputView$TextExceedLengthListener;)V", "getTextWatcher", "()Landroid/text/TextWatcher;", "setTextWatcher", "(Landroid/text/TextWatcher;)V", "getTitle", "setTitle", "drawable", "onClickListener", "text", "clickable", "color", "(Ljava/lang/String;ZLandroid/view/View$OnClickListener;Ljava/lang/Integer;)Lcom/obric/oui/forms/OLineInputView$Config;", "autoHide", "listener", "hide", "h", "tips", DataUsageDetailActivity.INTENT_EXTRA_LIMIT, "view", "setTitleIcon", InvokeHistoryActivity.PREF_SHOW, "watcher", "Builder", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Config {
        private Drawable actionImageDrawable;
        private View.OnClickListener actionImageDrawableListener;
        private String actionText;
        private boolean actionTextClickable;
        private Integer actionTextColor;
        private View.OnClickListener actionTextListener;
        private boolean autoHideClearWhenTextEmpty;
        private View.OnFocusChangeListener editTextOnFocusChangeListener;
        private boolean hideClearWhenNoFocus;
        private String hintText;
        private Integer inputBoxHeight;
        private String inputTips;
        private boolean isInSearchBar;
        private Drawable ivTitleIcon;
        private Integer lengthLimit;
        private int mode;
        private boolean multiLine;
        private View prefixView;
        private boolean showClear;
        private boolean showCounter;
        private boolean showDivider;
        private View suffixView;
        private TextClearedListener textClearedListener;
        private TextExceedLengthListener textExceedLengthListener;
        private TextWatcher textWatcher;
        private String title;

        /* JADX INFO: compiled from: OLineInputView.kt */
        @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bS\n\u0002\u0018\u0002\n\u0002\b)\b\u0086\b\u0018\u00002\u00020\u0001B©\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\b\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u0013\u001a\u00020\b\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u001d\u001a\u00020\b\u0012\b\b\u0002\u0010\u001e\u001a\u00020\b\u0012\b\b\u0002\u0010\u001f\u001a\u00020\b\u0012\b\b\u0002\u0010 \u001a\u00020\n\u0012\b\b\u0002\u0010!\u001a\u00020\b\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%¢\u0006\u0002\u0010&J\u0016\u0010\u0016\u001a\u00020\u00002\u0006\u0010q\u001a\u00020\u00062\u0006\u0010r\u001a\u00020\u0015J3\u0010\u0011\u001a\u00020\u00002\u0006\u0010s\u001a\u00020\u00032\u0006\u0010t\u001a\u00020\b2\n\b\u0002\u0010r\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010u\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010vJ\u000e\u0010\u001e\u001a\u00020\u00002\u0006\u0010w\u001a\u00020\bJ\u0006\u0010x\u001a\u00020yJ\t\u0010z\u001a\u00020\u0003HÆ\u0003J\t\u0010{\u001a\u00020\bHÆ\u0003J\u000b\u0010|\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010}\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u00108J\t\u0010~\u001a\u00020\bHÆ\u0003J\u000b\u0010\u007f\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\f\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\f\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\f\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u001bHÆ\u0003J\u0011\u0010\u0084\u0001\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u00108J\f\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\n\u0010\u0086\u0001\u001a\u00020\bHÆ\u0003J\n\u0010\u0087\u0001\u001a\u00020\bHÆ\u0003J\n\u0010\u0088\u0001\u001a\u00020\bHÆ\u0003J\n\u0010\u0089\u0001\u001a\u00020\nHÆ\u0003J\n\u0010\u008a\u0001\u001a\u00020\bHÆ\u0003J\f\u0010\u008b\u0001\u001a\u0004\u0018\u00010#HÆ\u0003J\f\u0010\u008c\u0001\u001a\u0004\u0018\u00010%HÆ\u0003J\f\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\n\u0010\u008e\u0001\u001a\u00020\bHÆ\u0003J\u0011\u0010\u008f\u0001\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u00108J\n\u0010\u0090\u0001\u001a\u00020\bHÆ\u0003J\f\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0092\u0001\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\f\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u000eHÆ\u0003J´\u0002\u0010\u0094\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u0013\u001a\u00020\b2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u001d\u001a\u00020\b2\b\b\u0002\u0010\u001e\u001a\u00020\b2\b\b\u0002\u0010\u001f\u001a\u00020\b2\b\b\u0002\u0010 \u001a\u00020\n2\b\b\u0002\u0010!\u001a\u00020\b2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%HÆ\u0001¢\u0006\u0003\u0010\u0095\u0001J\u000f\u0010\u001a\u001a\u00020\u00002\u0007\u0010\u0096\u0001\u001a\u00020\u001bJ\u0015\u0010\u0097\u0001\u001a\u00020\b2\t\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\n\u0010\u0099\u0001\u001a\u00020\nHÖ\u0001J\u000f\u0010!\u001a\u00020\u00002\u0007\u0010\u009a\u0001\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010s\u001a\u00020\u0003J\u000f\u0010\u001c\u001a\u00020\u00002\u0007\u0010\u009b\u0001\u001a\u00020\nJ\u000f\u0010\u0004\u001a\u00020\u00002\u0007\u0010\u009c\u0001\u001a\u00020\u0003J\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\bJ\u000f\u0010\t\u001a\u00020\u00002\u0007\u0010\u009d\u0001\u001a\u00020\nJ\u000e\u0010 \u001a\u00020\u00002\u0006\u0010 \u001a\u00020\nJ\u000e\u0010T\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\bJ\u000f\u0010W\u001a\u00020\u00002\u0007\u0010\u009e\u0001\u001a\u00020\u000eJ\u000f\u0010`\u001a\u00020\u00002\u0007\u0010\u009e\u0001\u001a\u00020\u000eJ\u000e\u0010p\u001a\u00020\u00002\u0006\u0010q\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\bJ\u000f\u0010\u0007\u001a\u00020\u00002\u0007\u0010\u009f\u0001\u001a\u00020\bJ\u000f\u0010\u0010\u001a\u00020\u00002\u0007\u0010\u009f\u0001\u001a\u00020\bJ\u0010\u0010$\u001a\u00020\u00002\b\u0010$\u001a\u0004\u0018\u00010%J\u000e\u0010\"\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020#J\u000f\u0010\u0018\u001a\u00020\u00002\u0007\u0010 \u0001\u001a\u00020\u0019J\u000e\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0003J\n\u0010¡\u0001\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u0010\u0013\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010;\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010,\"\u0004\b=\u0010.R\u001a\u0010\u001e\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u00104\"\u0004\b?\u00106R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u001a\u0010!\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u00104\"\u0004\bE\u00106R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u00100\"\u0004\bG\u00102R\u001e\u0010\u001c\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010;\u001a\u0004\bH\u00108\"\u0004\bI\u0010:R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u00100\"\u0004\bK\u00102R\u001a\u0010\u001d\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u00104\"\u0004\bL\u00106R\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010;\u001a\u0004\bM\u00108\"\u0004\bN\u0010:R\u001a\u0010 \u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u001a\u0010\u001f\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u00104\"\u0004\bT\u00106R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u001a\u0010\u000b\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u00104\"\u0004\bZ\u00106R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u00104\"\u0004\b\\\u00106R\u001a\u0010\u0010\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u00104\"\u0004\b^\u00106R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010V\"\u0004\b`\u0010XR\u001c\u0010$\u001a\u0004\u0018\u00010%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010j\"\u0004\bk\u0010lR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u00100\"\u0004\bn\u00102R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bo\u0010(\"\u0004\bp\u0010*¨\u0006¢\u0001"}, d2 = {"Lcom/obric/oui/forms/OLineInputView$Config$Builder;", "", "title", "", "inputTips", "titleIcon", "Landroid/graphics/drawable/Drawable;", "showCounter", "", "lengthLimit", "", "showClear", "hintText", "prefixView", "Landroid/view/View;", "suffixView", "showDivider", "actionText", "actionTextColor", "actionTextClickable", "actionTextListener", "Landroid/view/View$OnClickListener;", "actionImageDrawable", "actionImageDrawableListener", "textWatcher", "Landroid/text/TextWatcher;", "editTextOnFocusChangeListener", "Landroid/view/View$OnFocusChangeListener;", "inputBoxHeight", "isInSearchBar", "autoHideClearWhenTextEmpty", "multiLine", SearchConfigType.KEY_MODE, "hideClearWhenNoFocus", "textExceedLengthListener", "Lcom/obric/oui/forms/OLineInputView$TextExceedLengthListener;", "textClearedListener", "Lcom/obric/oui/forms/OLineInputView$TextClearedListener;", "(Ljava/lang/String;Ljava/lang/String;Landroid/graphics/drawable/Drawable;ZLjava/lang/Integer;ZLjava/lang/String;Landroid/view/View;Landroid/view/View;ZLjava/lang/String;Ljava/lang/Integer;ZLandroid/view/View$OnClickListener;Landroid/graphics/drawable/Drawable;Landroid/view/View$OnClickListener;Landroid/text/TextWatcher;Landroid/view/View$OnFocusChangeListener;Ljava/lang/Integer;ZZZIZLcom/obric/oui/forms/OLineInputView$TextExceedLengthListener;Lcom/obric/oui/forms/OLineInputView$TextClearedListener;)V", "getActionImageDrawable", "()Landroid/graphics/drawable/Drawable;", "setActionImageDrawable", "(Landroid/graphics/drawable/Drawable;)V", "getActionImageDrawableListener", "()Landroid/view/View$OnClickListener;", "setActionImageDrawableListener", "(Landroid/view/View$OnClickListener;)V", "getActionText", "()Ljava/lang/String;", "setActionText", "(Ljava/lang/String;)V", "getActionTextClickable", "()Z", "setActionTextClickable", "(Z)V", "getActionTextColor", "()Ljava/lang/Integer;", "setActionTextColor", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getActionTextListener", "setActionTextListener", "getAutoHideClearWhenTextEmpty", "setAutoHideClearWhenTextEmpty", "getEditTextOnFocusChangeListener", "()Landroid/view/View$OnFocusChangeListener;", "setEditTextOnFocusChangeListener", "(Landroid/view/View$OnFocusChangeListener;)V", "getHideClearWhenNoFocus", "setHideClearWhenNoFocus", "getHintText", "setHintText", "getInputBoxHeight", "setInputBoxHeight", "getInputTips", "setInputTips", "setInSearchBar", "getLengthLimit", "setLengthLimit", "getMode", "()I", "setMode", "(I)V", "getMultiLine", "setMultiLine", "getPrefixView", "()Landroid/view/View;", "setPrefixView", "(Landroid/view/View;)V", "getShowClear", "setShowClear", "getShowCounter", "setShowCounter", "getShowDivider", "setShowDivider", "getSuffixView", "setSuffixView", "getTextClearedListener", "()Lcom/obric/oui/forms/OLineInputView$TextClearedListener;", "setTextClearedListener", "(Lcom/obric/oui/forms/OLineInputView$TextClearedListener;)V", "getTextExceedLengthListener", "()Lcom/obric/oui/forms/OLineInputView$TextExceedLengthListener;", "setTextExceedLengthListener", "(Lcom/obric/oui/forms/OLineInputView$TextExceedLengthListener;)V", "getTextWatcher", "()Landroid/text/TextWatcher;", "setTextWatcher", "(Landroid/text/TextWatcher;)V", "getTitle", "setTitle", "getTitleIcon", "setTitleIcon", "drawable", "onClickListener", "text", "clickable", "color", "(Ljava/lang/String;ZLandroid/view/View$OnClickListener;Ljava/lang/Integer;)Lcom/obric/oui/forms/OLineInputView$Config$Builder;", "autoHide", "build", "Lcom/obric/oui/forms/OLineInputView$Config;", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Landroid/graphics/drawable/Drawable;ZLjava/lang/Integer;ZLjava/lang/String;Landroid/view/View;Landroid/view/View;ZLjava/lang/String;Ljava/lang/Integer;ZLandroid/view/View$OnClickListener;Landroid/graphics/drawable/Drawable;Landroid/view/View$OnClickListener;Landroid/text/TextWatcher;Landroid/view/View$OnFocusChangeListener;Ljava/lang/Integer;ZZZIZLcom/obric/oui/forms/OLineInputView$TextExceedLengthListener;Lcom/obric/oui/forms/OLineInputView$TextClearedListener;)Lcom/obric/oui/forms/OLineInputView$Config$Builder;", "listener", "equals", "other", "hashCode", "hide", "h", "tips", DataUsageDetailActivity.INTENT_EXTRA_LIMIT, "view", InvokeHistoryActivity.PREF_SHOW, "watcher", "toString", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Builder {
            private Drawable actionImageDrawable;
            private View.OnClickListener actionImageDrawableListener;
            private String actionText;
            private boolean actionTextClickable;
            private Integer actionTextColor;
            private View.OnClickListener actionTextListener;
            private boolean autoHideClearWhenTextEmpty;
            private View.OnFocusChangeListener editTextOnFocusChangeListener;
            private boolean hideClearWhenNoFocus;
            private String hintText;
            private Integer inputBoxHeight;
            private String inputTips;
            private boolean isInSearchBar;
            private Integer lengthLimit;
            private int mode;
            private boolean multiLine;
            private View prefixView;
            private boolean showClear;
            private boolean showCounter;
            private boolean showDivider;
            private View suffixView;
            private TextClearedListener textClearedListener;
            private TextExceedLengthListener textExceedLengthListener;
            private TextWatcher textWatcher;
            private String title;
            private Drawable titleIcon;

            public Builder() {
                this(null, null, null, false, null, false, null, null, null, false, null, null, false, null, null, null, null, null, null, false, false, false, 0, false, null, null, 67108863, null);
            }

            public static /* synthetic */ Builder copy$default(Builder r17, String r18, String r19, Drawable r20, boolean r21, Integer r22, boolean r23, String r24, View r25, View r26, boolean r27, String r28, Integer r29, boolean r30, View.OnClickListener r31, Drawable r32, View.OnClickListener r33, TextWatcher r34, View.OnFocusChangeListener r35, Integer r36, boolean r37, boolean r38, boolean r39, int r40, boolean r41, TextExceedLengthListener r42, TextClearedListener r43, int r44, Object r45) {
                if ((r44 & 1) == 0) goto L5;
                String r2 = r17.title;
            L7:
                if ((r44 & 2) == 0) goto L9;
                String r3 = r17.inputTips;
            L11:
                if ((r44 & 4) == 0) goto L13;
                Drawable r4 = r17.titleIcon;
            L15:
                if ((r44 & 8) == 0) goto L17;
                boolean r5 = r17.showCounter;
            L19:
                if ((r44 & 16) == 0) goto L21;
                Integer r6 = r17.lengthLimit;
            L23:
                if ((r44 & 32) == 0) goto L25;
                boolean r7 = r17.showClear;
            L27:
                if ((r44 & 64) == 0) goto L29;
                String r8 = r17.hintText;
            L31:
                if ((r44 & 128) == 0) goto L33;
                View r9 = r17.prefixView;
            L35:
                if ((r44 & 256) == 0) goto L37;
                View r10 = r17.suffixView;
            L39:
                if ((r44 & 512) == 0) goto L41;
                boolean r11 = r17.showDivider;
            L43:
                if ((r44 & 1024) == 0) goto L45;
                String r12 = r17.actionText;
            L47:
                if ((r44 & 2048) == 0) goto L49;
                Integer r13 = r17.actionTextColor;
            L51:
                if ((r44 & 4096) == 0) goto L53;
                boolean r14 = r17.actionTextClickable;
            L55:
                if ((r44 & 8192) == 0) goto L57;
                View.OnClickListener r15 = r17.actionTextListener;
            L58:
                View.OnClickListener r310 = r15;
                if ((r44 & 16384) == 0) goto L61;
                Drawable r16 = r17.actionImageDrawable;
            L62:
                Drawable r311 = r16;
                if ((r44 & 32768) == 0) goto L65;
                View.OnClickListener r110 = r17.actionImageDrawableListener;
            L66:
                View.OnClickListener r312 = r110;
                if ((r44 & 65536) == 0) goto L69;
                TextWatcher r111 = r17.textWatcher;
            L70:
                TextWatcher r313 = r111;
                if ((r44 & 131072) == 0) goto L73;
                View.OnFocusChangeListener r112 = r17.editTextOnFocusChangeListener;
            L74:
                View.OnFocusChangeListener r314 = r112;
                if ((r44 & 262144) == 0) goto L77;
                Integer r113 = r17.inputBoxHeight;
            L78:
                Integer r315 = r113;
                if ((r44 & 524288) == 0) goto L81;
                boolean r114 = r17.isInSearchBar;
            L82:
                boolean r316 = r114;
                if ((r44 & 1048576) == 0) goto L85;
                boolean r115 = r17.autoHideClearWhenTextEmpty;
            L86:
                boolean r317 = r115;
                if ((r44 & 2097152) == 0) goto L89;
                boolean r116 = r17.multiLine;
            L90:
                boolean r318 = r116;
                if ((r44 & 4194304) == 0) goto L93;
                int r117 = r17.mode;
            L94:
                int r46 = r117;
                if ((r44 & 8388608) == 0) goto L97;
                boolean r118 = r17.hideClearWhenNoFocus;
            L98:
                boolean r47 = r118;
                if ((r44 & 16777216) == 0) goto L101;
                TextExceedLengthListener r119 = r17.textExceedLengthListener;
            L103:
                if ((r44 & 33554432) == 0) goto L105;
                TextClearedListener r1 = r17.textClearedListener;
            L107:
                return r17.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r310, r311, r312, r313, r314, r315, r316, r317, r318, r46, r47, r119, r1);
            L105:
                r1 = r43;
                goto L107
            L101:
                r119 = r42;
                goto L103
            L97:
                r118 = r41;
                goto L98
            L93:
                r117 = r40;
                goto L94
            L89:
                r116 = r39;
                goto L90
            L85:
                r115 = r38;
                goto L86
            L81:
                r114 = r37;
                goto L82
            L77:
                r113 = r36;
                goto L78
            L73:
                r112 = r35;
                goto L74
            L69:
                r111 = r34;
                goto L70
            L65:
                r110 = r33;
                goto L66
            L61:
                r16 = r32;
                goto L62
            L57:
                r15 = r31;
                goto L58
            L53:
                r14 = r30;
                goto L55
            L49:
                r13 = r29;
                goto L51
            L45:
                r12 = r28;
                goto L47
            L41:
                r11 = r27;
                goto L43
            L37:
                r10 = r26;
                goto L39
            L33:
                r9 = r25;
                goto L35
            L29:
                r8 = r24;
                goto L31
            L25:
                r7 = r23;
                goto L27
            L21:
                r6 = r22;
                goto L23
            L17:
                r5 = r21;
                goto L19
            L13:
                r4 = r20;
                goto L15
            L9:
                r3 = r19;
                goto L11
            L5:
                r2 = r18;
                goto L7
            }

            public final String component1() {
                return this.title;
            }

            public final boolean component10() {
                return this.showDivider;
            }

            public final String component11() {
                return this.actionText;
            }

            public final Integer component12() {
                return this.actionTextColor;
            }

            public final boolean component13() {
                return this.actionTextClickable;
            }

            public final View.OnClickListener component14() {
                return this.actionTextListener;
            }

            public final Drawable component15() {
                return this.actionImageDrawable;
            }

            public final View.OnClickListener component16() {
                return this.actionImageDrawableListener;
            }

            public final TextWatcher component17() {
                return this.textWatcher;
            }

            public final View.OnFocusChangeListener component18() {
                return this.editTextOnFocusChangeListener;
            }

            public final Integer component19() {
                return this.inputBoxHeight;
            }

            public final String component2() {
                return this.inputTips;
            }

            public final boolean component20() {
                return this.isInSearchBar;
            }

            public final boolean component21() {
                return this.autoHideClearWhenTextEmpty;
            }

            public final boolean component22() {
                return this.multiLine;
            }

            public final int component23() {
                return this.mode;
            }

            public final boolean component24() {
                return this.hideClearWhenNoFocus;
            }

            public final TextExceedLengthListener component25() {
                return this.textExceedLengthListener;
            }

            public final TextClearedListener component26() {
                return this.textClearedListener;
            }

            public final Drawable component3() {
                return this.titleIcon;
            }

            public final boolean component4() {
                return this.showCounter;
            }

            public final Integer component5() {
                return this.lengthLimit;
            }

            public final boolean component6() {
                return this.showClear;
            }

            public final String component7() {
                return this.hintText;
            }

            public final View component8() {
                return this.prefixView;
            }

            public final View component9() {
                return this.suffixView;
            }

            public final Builder copy(String r29, String r30, Drawable r31, boolean r32, Integer r33, boolean r34, String r35, View r36, View r37, boolean r38, String r39, Integer r40, boolean r41, View.OnClickListener r42, Drawable r43, View.OnClickListener r44, TextWatcher r45, View.OnFocusChangeListener r46, Integer r47, boolean r48, boolean r49, boolean r50, int r51, boolean r52, TextExceedLengthListener r53, TextClearedListener r54) {
                Intrinsics.checkNotNullParameter(r29, "title");
                return new Builder(r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54);
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if ((r5 instanceof Builder) == true) goto L8;
                return false;
            L8:
                Builder r6 = (Builder) r5;
                if (Intrinsics.areEqual(this.title, r6.title) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.inputTips, r6.inputTips) == true) goto L15;
                return false;
            L15:
                if (Intrinsics.areEqual(this.titleIcon, r6.titleIcon) == true) goto L18;
                return false;
            L18:
                if (this.showCounter == r6.showCounter) goto L21;
                return false;
            L21:
                if (Intrinsics.areEqual(this.lengthLimit, r6.lengthLimit) == true) goto L24;
                return false;
            L24:
                if (this.showClear == r6.showClear) goto L27;
                return false;
            L27:
                if (Intrinsics.areEqual(this.hintText, r6.hintText) == true) goto L30;
                return false;
            L30:
                if (Intrinsics.areEqual(this.prefixView, r6.prefixView) == true) goto L33;
                return false;
            L33:
                if (Intrinsics.areEqual(this.suffixView, r6.suffixView) == true) goto L36;
                return false;
            L36:
                if (this.showDivider == r6.showDivider) goto L39;
                return false;
            L39:
                if (Intrinsics.areEqual(this.actionText, r6.actionText) == true) goto L42;
                return false;
            L42:
                if (Intrinsics.areEqual(this.actionTextColor, r6.actionTextColor) == true) goto L45;
                return false;
            L45:
                if (this.actionTextClickable == r6.actionTextClickable) goto L48;
                return false;
            L48:
                if (Intrinsics.areEqual(this.actionTextListener, r6.actionTextListener) == true) goto L51;
                return false;
            L51:
                if (Intrinsics.areEqual(this.actionImageDrawable, r6.actionImageDrawable) == true) goto L54;
                return false;
            L54:
                if (Intrinsics.areEqual(this.actionImageDrawableListener, r6.actionImageDrawableListener) == true) goto L57;
                return false;
            L57:
                if (Intrinsics.areEqual(this.textWatcher, r6.textWatcher) == true) goto L60;
                return false;
            L60:
                if (Intrinsics.areEqual(this.editTextOnFocusChangeListener, r6.editTextOnFocusChangeListener) == true) goto L63;
                return false;
            L63:
                if (Intrinsics.areEqual(this.inputBoxHeight, r6.inputBoxHeight) == true) goto L66;
                return false;
            L66:
                if (this.isInSearchBar == r6.isInSearchBar) goto L69;
                return false;
            L69:
                if (this.autoHideClearWhenTextEmpty == r6.autoHideClearWhenTextEmpty) goto L72;
                return false;
            L72:
                if (this.multiLine == r6.multiLine) goto L75;
                return false;
            L75:
                if (this.mode == r6.mode) goto L78;
                return false;
            L78:
                if (this.hideClearWhenNoFocus == r6.hideClearWhenNoFocus) goto L81;
                return false;
            L81:
                if (Intrinsics.areEqual(this.textExceedLengthListener, r6.textExceedLengthListener) == true) goto L84;
                return false;
            L84:
                if (Intrinsics.areEqual(this.textClearedListener, r6.textClearedListener) == true) goto L86;
                return false;
            L86:
                return true;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v7, types: [int] */
            /* JADX WARN: Type inference failed for: r1v12, types: [int] */
            /* JADX WARN: Type inference failed for: r1v23, types: [int] */
            /* JADX WARN: Type inference failed for: r1v31, types: [int] */
            /* JADX WARN: Type inference failed for: r1v51, types: [int] */
            /* JADX WARN: Type inference failed for: r1v53, types: [int] */
            /* JADX WARN: Type inference failed for: r1v55, types: [int] */
            /* JADX WARN: Type inference failed for: r1v63 */
            /* JADX WARN: Type inference failed for: r1v64 */
            /* JADX WARN: Type inference failed for: r1v65 */
            /* JADX WARN: Type inference failed for: r1v7, types: [int] */
            /* JADX WARN: Type inference failed for: r1v72 */
            /* JADX WARN: Type inference failed for: r1v75 */
            /* JADX WARN: Type inference failed for: r1v79 */
            /* JADX WARN: Type inference failed for: r1v81 */
            /* JADX WARN: Type inference failed for: r1v84 */
            /* JADX WARN: Type inference failed for: r1v85 */
            /* JADX WARN: Type inference failed for: r1v86 */
            /* JADX WARN: Type inference failed for: r1v87 */
            /* JADX WARN: Type inference failed for: r1v88 */
            /* JADX WARN: Type inference failed for: r1v89 */
            /* JADX WARN: Type inference failed for: r1v90 */
            /* JADX WARN: Type inference failed for: r3v0 */
            /* JADX WARN: Type inference failed for: r3v1, types: [int] */
            /* JADX WARN: Type inference failed for: r3v2 */
            public int hashCode() {
                int r0 = this.title.hashCode() * 31;
                String r1 = this.inputTips;
                int r2 = 0;
                if (r1 != null) goto L5;
                int r3 = 0;
            L6:
                int r4 = (r0 + r3) * 31;
                Drawable r5 = this.titleIcon;
                if (r5 != null) goto L9;
                int r6 = 0;
            L10:
                int r7 = (r4 + r6) * 31;
                boolean r8 = this.showCounter;
                ?? r9 = 1;
                ?? r10 = r8;
                if (r8 == false) goto L13;
                r10 = 1;
            L13:
                int r11 = (r7 + r10) * 31;
                Integer r12 = this.lengthLimit;
                if (r12 != null) goto L16;
                int r13 = 0;
            L17:
                int r14 = (r11 + r13) * 31;
                boolean r15 = this.showClear;
                ?? r16 = r15;
                if (r15 == false) goto L20;
                r16 = 1;
            L20:
                int r17 = (r14 + r16) * 31;
                String r18 = this.hintText;
                if (r18 != null) goto L23;
                int r19 = 0;
            L24:
                int r20 = (r17 + r19) * 31;
                View r21 = this.prefixView;
                if (r21 != null) goto L27;
                int r22 = 0;
            L28:
                int r23 = (r20 + r22) * 31;
                View r24 = this.suffixView;
                if (r24 != null) goto L31;
                int r25 = 0;
            L32:
                int r26 = (r23 + r25) * 31;
                boolean r27 = this.showDivider;
                ?? r28 = r27;
                if (r27 == false) goto L35;
                r28 = 1;
            L35:
                int r29 = (r26 + r28) * 31;
                String r30 = this.actionText;
                if (r30 != null) goto L38;
                int r31 = 0;
            L39:
                int r32 = (r29 + r31) * 31;
                Integer r33 = this.actionTextColor;
                if (r33 != null) goto L42;
                int r34 = 0;
            L43:
                int r35 = (r32 + r34) * 31;
                boolean r36 = this.actionTextClickable;
                ?? r37 = r36;
                if (r36 == false) goto L46;
                r37 = 1;
            L46:
                int r38 = (r35 + r37) * 31;
                View.OnClickListener r39 = this.actionTextListener;
                if (r39 != null) goto L49;
                int r40 = 0;
            L50:
                int r41 = (r38 + r40) * 31;
                Drawable r42 = this.actionImageDrawable;
                if (r42 != null) goto L53;
                int r43 = 0;
            L54:
                int r44 = (r41 + r43) * 31;
                View.OnClickListener r45 = this.actionImageDrawableListener;
                if (r45 != null) goto L57;
                int r46 = 0;
            L58:
                int r47 = (r44 + r46) * 31;
                TextWatcher r48 = this.textWatcher;
                if (r48 != null) goto L61;
                int r49 = 0;
            L62:
                int r50 = (r47 + r49) * 31;
                View.OnFocusChangeListener r51 = this.editTextOnFocusChangeListener;
                if (r51 != null) goto L65;
                int r52 = 0;
            L66:
                int r53 = (r50 + r52) * 31;
                Integer r54 = this.inputBoxHeight;
                if (r54 != null) goto L69;
                int r55 = 0;
            L70:
                int r56 = (r53 + r55) * 31;
                boolean r57 = this.isInSearchBar;
                ?? r58 = r57;
                if (r57 == false) goto L73;
                r58 = 1;
            L73:
                int r59 = (r56 + r58) * 31;
                boolean r60 = this.autoHideClearWhenTextEmpty;
                ?? r61 = r60;
                if (r60 == false) goto L76;
                r61 = 1;
            L76:
                int r62 = (r59 + r61) * 31;
                boolean r63 = this.multiLine;
                ?? r64 = r63;
                if (r63 == false) goto L79;
                r64 = 1;
            L79:
                int r65 = (((r62 + r64) * 31) + Integer.hashCode(this.mode)) * 31;
                boolean r66 = this.hideClearWhenNoFocus;
                if (r66 == true) goto L83;
                r9 = r66;
            L83:
                int r67 = (r65 + r9) * 31;
                TextExceedLengthListener r68 = this.textExceedLengthListener;
                if (r68 != null) goto L86;
                int r69 = 0;
            L87:
                int r70 = (r67 + r69) * 31;
                TextClearedListener r71 = this.textClearedListener;
                if (r71 == null) goto L92;
                r2 = r71.hashCode();
            L92:
                return r70 + r2;
            L86:
                r69 = r68.hashCode();
                goto L87
            L69:
                r55 = r54.hashCode();
                goto L70
            L65:
                r52 = r51.hashCode();
                goto L66
            L61:
                r49 = r48.hashCode();
                goto L62
            L57:
                r46 = r45.hashCode();
                goto L58
            L53:
                r43 = r42.hashCode();
                goto L54
            L49:
                r40 = r39.hashCode();
                goto L50
            L42:
                r34 = r33.hashCode();
                goto L43
            L38:
                r31 = r30.hashCode();
                goto L39
            L31:
                r25 = r24.hashCode();
                goto L32
            L27:
                r22 = r21.hashCode();
                goto L28
            L23:
                r19 = r18.hashCode();
                goto L24
            L16:
                r13 = r12.hashCode();
                goto L17
            L9:
                r6 = r5.hashCode();
                goto L10
            L5:
                r3 = r1.hashCode();
                goto L6
            }

            public String toString() {
                StringBuilder r0 = new StringBuilder("Builder(title=");
                r0.append(this.title).append(", inputTips=").append(this.inputTips).append(", titleIcon=").append(this.titleIcon).append(", showCounter=").append(this.showCounter).append(", lengthLimit=").append(this.lengthLimit).append(", showClear=").append(this.showClear).append(", hintText=").append(this.hintText).append(", prefixView=").append(this.prefixView).append(", suffixView=").append(this.suffixView).append(", showDivider=").append(this.showDivider).append(", actionText=").append(this.actionText).append(", actionTextColor=");
                r0.append(this.actionTextColor).append(", actionTextClickable=").append(this.actionTextClickable).append(", actionTextListener=").append(this.actionTextListener).append(", actionImageDrawable=").append(this.actionImageDrawable).append(", actionImageDrawableListener=").append(this.actionImageDrawableListener).append(", textWatcher=").append(this.textWatcher).append(", editTextOnFocusChangeListener=").append(this.editTextOnFocusChangeListener).append(", inputBoxHeight=").append(this.inputBoxHeight).append(", isInSearchBar=").append(this.isInSearchBar).append(", autoHideClearWhenTextEmpty=").append(this.autoHideClearWhenTextEmpty).append(", multiLine=").append(this.multiLine).append(", mode=").append(this.mode);
                r0.append(", hideClearWhenNoFocus=").append(this.hideClearWhenNoFocus).append(", textExceedLengthListener=").append(this.textExceedLengthListener).append(", textClearedListener=").append(this.textClearedListener).append(')');
                return r0.toString();
            }

            public Builder(String r4, String r5, Drawable r6, boolean r7, Integer r8, boolean r9, String r10, View r11, View r12, boolean r13, String r14, Integer r15, boolean r16, View.OnClickListener r17, Drawable r18, View.OnClickListener r19, TextWatcher r20, View.OnFocusChangeListener r21, Integer r22, boolean r23, boolean r24, boolean r25, int r26, boolean r27, TextExceedLengthListener r28, TextClearedListener r29) {
                Intrinsics.checkNotNullParameter(r4, "title");
                this.title = r4;
                this.inputTips = r5;
                this.titleIcon = r6;
                this.showCounter = r7;
                this.lengthLimit = r8;
                this.showClear = r9;
                this.hintText = r10;
                this.prefixView = r11;
                this.suffixView = r12;
                this.showDivider = r13;
                this.actionText = r14;
                this.actionTextColor = r15;
                this.actionTextClickable = r16;
                this.actionTextListener = r17;
                this.actionImageDrawable = r18;
                this.actionImageDrawableListener = r19;
                this.textWatcher = r20;
                this.editTextOnFocusChangeListener = r21;
                this.inputBoxHeight = r22;
                this.isInSearchBar = r23;
                this.autoHideClearWhenTextEmpty = r24;
                this.multiLine = r25;
                this.mode = r26;
                this.hideClearWhenNoFocus = r27;
                this.textExceedLengthListener = r28;
                this.textClearedListener = r29;
            }

            public /* synthetic */ Builder(String r28, String r29, Drawable r30, boolean r31, Integer r32, boolean r33, String r34, View r35, View r36, boolean r37, String r38, Integer r39, boolean r40, View.OnClickListener r41, Drawable r42, View.OnClickListener r43, TextWatcher r44, View.OnFocusChangeListener r45, Integer r46, boolean r47, boolean r48, boolean r49, int r50, boolean r51, TextExceedLengthListener r52, TextClearedListener r53, int r54, DefaultConstructorMarker r55) {
                if ((r54 & 1) == 0) goto L5;
                String r1 = "标题";
            L7:
                if ((r54 & 2) == 0) goto L9;
                String r2 = null;
            L11:
                if ((r54 & 4) == 0) goto L13;
                Drawable r4 = null;
            L15:
                if ((r54 & 8) == 0) goto L17;
                boolean r5 = false;
            L19:
                if ((r54 & 16) == 0) goto L21;
                Integer r7 = null;
            L23:
                if ((r54 & 32) == 0) goto L25;
                boolean r8 = false;
            L27:
                if ((r54 & 64) == 0) goto L29;
                String r9 = null;
            L31:
                if ((r54 & 128) == 0) goto L33;
                View r10 = null;
            L35:
                if ((r54 & 256) == 0) goto L37;
                View r11 = null;
            L39:
                if ((r54 & 512) == 0) goto L41;
                boolean r12 = true;
            L43:
                if ((r54 & 1024) == 0) goto L45;
                String r14 = null;
            L47:
                if ((r54 & 2048) == 0) goto L49;
                Integer r15 = null;
            L51:
                if ((r54 & 4096) == 0) goto L53;
                boolean r3 = false;
            L55:
                if ((r54 & 8192) == 0) goto L57;
                View.OnClickListener r6 = null;
            L59:
                if ((r54 & 16384) == 0) goto L61;
                Drawable r13 = null;
            L63:
                if ((r54 & 32768) == 0) goto L65;
                View.OnClickListener r16 = null;
            L67:
                if ((r54 & 65536) == 0) goto L69;
                TextWatcher r17 = null;
            L71:
                if ((r54 & 131072) == 0) goto L73;
                View.OnFocusChangeListener r18 = null;
            L75:
                if ((r54 & 262144) == 0) goto L77;
                Integer r19 = null;
            L79:
                if ((r54 & 524288) == 0) goto L81;
                boolean r20 = false;
            L83:
                if ((r54 & 1048576) == 0) goto L85;
                boolean r21 = false;
            L87:
                if ((r54 & 2097152) == 0) goto L89;
                boolean r22 = false;
            L91:
                if ((r54 & 4194304) == 0) goto L93;
                int r23 = 2;
            L95:
                if ((r54 & 8388608) == 0) goto L97;
                boolean r24 = true;
            L99:
                if ((r54 & 16777216) == 0) goto L101;
                TextExceedLengthListener r25 = null;
            L103:
                if ((r54 & 33554432) == 0) goto L105;
                TextClearedListener r0 = null;
            L106:
                this(r1, r2, r4, r5, r7, r8, r9, r10, r11, r12, r14, r15, r3, r6, r13, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r0);
                return;
            L105:
                r0 = r53;
                goto L106
            L101:
                r25 = r52;
                goto L103
            L97:
                r24 = r51;
                goto L99
            L93:
                r23 = r50;
                goto L95
            L89:
                r22 = r49;
                goto L91
            L85:
                r21 = r48;
                goto L87
            L81:
                r20 = r47;
                goto L83
            L77:
                r19 = r46;
                goto L79
            L73:
                r18 = r45;
                goto L75
            L69:
                r17 = r44;
                goto L71
            L65:
                r16 = r43;
                goto L67
            L61:
                r13 = r42;
                goto L63
            L57:
                r6 = r41;
                goto L59
            L53:
                r3 = r40;
                goto L55
            L49:
                r15 = r39;
                goto L51
            L45:
                r14 = r38;
                goto L47
            L41:
                r12 = r37;
                goto L43
            L37:
                r11 = r36;
                goto L39
            L33:
                r10 = r35;
                goto L35
            L29:
                r9 = r34;
                goto L31
            L25:
                r8 = r33;
                goto L27
            L21:
                r7 = r32;
                goto L23
            L17:
                r5 = r31;
                goto L19
            L13:
                r4 = r30;
                goto L15
            L9:
                r2 = r29;
                goto L11
            L5:
                r1 = r28;
                goto L7
            }

            public final String getTitle() {
                return this.title;
            }

            public final void setTitle(String r2) {
                Intrinsics.checkNotNullParameter(r2, "<set-?>");
                this.title = r2;
            }

            public final String getInputTips() {
                return this.inputTips;
            }

            public final void setInputTips(String r1) {
                this.inputTips = r1;
            }

            public final Drawable getTitleIcon() {
                return this.titleIcon;
            }

            /* JADX INFO: renamed from: setTitleIcon, reason: collision with other method in class */
            public final void m358setTitleIcon(Drawable r1) {
                this.titleIcon = r1;
            }

            public final boolean getShowCounter() {
                return this.showCounter;
            }

            public final void setShowCounter(boolean r1) {
                this.showCounter = r1;
            }

            public final Integer getLengthLimit() {
                return this.lengthLimit;
            }

            public final void setLengthLimit(Integer r1) {
                this.lengthLimit = r1;
            }

            public final boolean getShowClear() {
                return this.showClear;
            }

            public final void setShowClear(boolean r1) {
                this.showClear = r1;
            }

            public final String getHintText() {
                return this.hintText;
            }

            public final void setHintText(String r1) {
                this.hintText = r1;
            }

            public final View getPrefixView() {
                return this.prefixView;
            }

            /* JADX INFO: renamed from: setPrefixView, reason: collision with other method in class */
            public final void m356setPrefixView(View r1) {
                this.prefixView = r1;
            }

            public final View getSuffixView() {
                return this.suffixView;
            }

            /* JADX INFO: renamed from: setSuffixView, reason: collision with other method in class */
            public final void m357setSuffixView(View r1) {
                this.suffixView = r1;
            }

            public final boolean getShowDivider() {
                return this.showDivider;
            }

            public final void setShowDivider(boolean r1) {
                this.showDivider = r1;
            }

            public final String getActionText() {
                return this.actionText;
            }

            public final void setActionText(String r1) {
                this.actionText = r1;
            }

            public final Integer getActionTextColor() {
                return this.actionTextColor;
            }

            public final void setActionTextColor(Integer r1) {
                this.actionTextColor = r1;
            }

            public final boolean getActionTextClickable() {
                return this.actionTextClickable;
            }

            public final void setActionTextClickable(boolean r1) {
                this.actionTextClickable = r1;
            }

            public final View.OnClickListener getActionTextListener() {
                return this.actionTextListener;
            }

            public final void setActionTextListener(View.OnClickListener r1) {
                this.actionTextListener = r1;
            }

            public final Drawable getActionImageDrawable() {
                return this.actionImageDrawable;
            }

            public final void setActionImageDrawable(Drawable r1) {
                this.actionImageDrawable = r1;
            }

            public final View.OnClickListener getActionImageDrawableListener() {
                return this.actionImageDrawableListener;
            }

            public final void setActionImageDrawableListener(View.OnClickListener r1) {
                this.actionImageDrawableListener = r1;
            }

            public final TextWatcher getTextWatcher() {
                return this.textWatcher;
            }

            public final void setTextWatcher(TextWatcher r1) {
                this.textWatcher = r1;
            }

            public final View.OnFocusChangeListener getEditTextOnFocusChangeListener() {
                return this.editTextOnFocusChangeListener;
            }

            public final void setEditTextOnFocusChangeListener(View.OnFocusChangeListener r1) {
                this.editTextOnFocusChangeListener = r1;
            }

            public final Integer getInputBoxHeight() {
                return this.inputBoxHeight;
            }

            public final void setInputBoxHeight(Integer r1) {
                this.inputBoxHeight = r1;
            }

            public final boolean isInSearchBar() {
                return this.isInSearchBar;
            }

            public final void setInSearchBar(boolean r1) {
                this.isInSearchBar = r1;
            }

            public final boolean getAutoHideClearWhenTextEmpty() {
                return this.autoHideClearWhenTextEmpty;
            }

            public final void setAutoHideClearWhenTextEmpty(boolean r1) {
                this.autoHideClearWhenTextEmpty = r1;
            }

            public final boolean getMultiLine() {
                return this.multiLine;
            }

            /* JADX INFO: renamed from: setMultiLine, reason: collision with other method in class */
            public final void m355setMultiLine(boolean r1) {
                this.multiLine = r1;
            }

            public final int getMode() {
                return this.mode;
            }

            public final void setMode(int r1) {
                this.mode = r1;
            }

            public final boolean getHideClearWhenNoFocus() {
                return this.hideClearWhenNoFocus;
            }

            public final void setHideClearWhenNoFocus(boolean r1) {
                this.hideClearWhenNoFocus = r1;
            }

            public final TextExceedLengthListener getTextExceedLengthListener() {
                return this.textExceedLengthListener;
            }

            public final void setTextExceedLengthListener(TextExceedLengthListener r1) {
                this.textExceedLengthListener = r1;
            }

            public final TextClearedListener getTextClearedListener() {
                return this.textClearedListener;
            }

            public final void setTextClearedListener(TextClearedListener r1) {
                this.textClearedListener = r1;
            }

            public final Builder textClearedListener(TextClearedListener r2) {
                setTextClearedListener(r2);
                return this;
            }

            public final Builder textExceedLengthListener(TextExceedLengthListener r2) {
                Intrinsics.checkNotNullParameter(r2, "textExceedLengthListener");
                setTextExceedLengthListener(r2);
                return this;
            }

            public final Builder title(String r2) {
                Intrinsics.checkNotNullParameter(r2, "title");
                setTitle(r2);
                return this;
            }

            public final Builder inputTips(String r2) {
                Intrinsics.checkNotNullParameter(r2, "tips");
                setInputTips(r2);
                return this;
            }

            public final Builder setTitleIcon(Drawable r2) {
                Intrinsics.checkNotNullParameter(r2, "drawable");
                m358setTitleIcon(r2);
                return this;
            }

            public final Builder showCounter(boolean r2) {
                setShowCounter(r2);
                return this;
            }

            public final Builder lengthLimit(int r2) {
                setLengthLimit(Integer.valueOf(r2));
                return this;
            }

            public final Builder showClear(boolean r2) {
                setShowClear(r2);
                return this;
            }

            public final Builder hintText(String r2) {
                Intrinsics.checkNotNullParameter(r2, "text");
                setHintText(r2);
                return this;
            }

            public final Builder setPrefixView(View r2) {
                Intrinsics.checkNotNullParameter(r2, "view");
                m356setPrefixView(r2);
                return this;
            }

            public final Builder setSuffixView(View r2) {
                Intrinsics.checkNotNullParameter(r2, "view");
                m357setSuffixView(r2);
                return this;
            }

            public final Builder showDivider(boolean r2) {
                setShowDivider(r2);
                return this;
            }

            public static /* synthetic */ Builder actionText$default(Builder r1, String r2, boolean r3, View.OnClickListener r4, Integer r5, int r6, Object r7) {
                if ((r6 & 4) == 0) goto L6;
                r4 = null;
            L6:
                if ((r6 & 8) == 0) goto L9;
                r5 = null;
            L9:
                return r1.actionText(r2, r3, r4, r5);
            }

            public final Builder actionText(String r2, boolean r3, View.OnClickListener r4, Integer r5) {
                Intrinsics.checkNotNullParameter(r2, "text");
                setActionText(r2);
                setActionTextClickable(r3);
                setActionTextListener(r4);
                if (r5 == null) goto L5;
                setActionTextColor(r5);
            L5:
                return this;
            }

            public final Builder actionImageDrawable(Drawable r2, View.OnClickListener r3) {
                Intrinsics.checkNotNullParameter(r2, "drawable");
                Intrinsics.checkNotNullParameter(r3, "onClickListener");
                setActionImageDrawable(r2);
                setActionImageDrawableListener(r3);
                return this;
            }

            public final Builder textWatcher(TextWatcher r2) {
                Intrinsics.checkNotNullParameter(r2, "watcher");
                setTextWatcher(r2);
                return this;
            }

            public final Builder editTextOnFocusChangeListener(View.OnFocusChangeListener r2) {
                Intrinsics.checkNotNullParameter(r2, "listener");
                setEditTextOnFocusChangeListener(r2);
                return this;
            }

            public final Builder inputBoxHeight(int r2) {
                setInputBoxHeight(Integer.valueOf(r2));
                return this;
            }

            public final Builder setMultiLine(boolean r2) {
                m355setMultiLine(r2);
                return this;
            }

            public final Builder isInSearchBar(boolean r2) {
                setInSearchBar(r2);
                if (r2 == false) goto L5;
                setShowDivider(false);
                setAutoHideClearWhenTextEmpty(true);
            L5:
                return this;
            }

            public final Builder autoHideClearWhenTextEmpty(boolean r2) {
                setAutoHideClearWhenTextEmpty(r2);
                return this;
            }

            public final Builder mode(int r2) {
                setMode(r2);
                return this;
            }

            public final Builder hideClearWhenNoFocus(boolean r2) {
                setHideClearWhenNoFocus(r2);
                return this;
            }

            public final Config build() {
                String r2 = this.title;
                String r1 = this.inputTips;
                Drawable r3 = this.titleIcon;
                boolean r4 = this.showCounter;
                boolean r5 = this.showClear;
                String r6 = this.hintText;
                Integer r8 = this.lengthLimit;
                boolean r9 = this.showDivider;
                String r10 = this.actionText;
                TextWatcher r11 = this.textWatcher;
                View r7 = this.prefixView;
                View r12 = this.suffixView;
                boolean r13 = this.actionTextClickable;
                View.OnClickListener r15 = this.actionTextListener;
                Drawable r14 = this.actionImageDrawable;
                View.OnClickListener r16 = this.actionImageDrawableListener;
                Integer r17 = this.actionTextColor;
                return new Config(r2, r4, r5, r6, r7, r12, r8, r9, r10, r11, this.editTextOnFocusChangeListener, r13, r14, r15, r16, r1, r17, this.inputBoxHeight, r3, this.isInSearchBar, this.autoHideClearWhenTextEmpty, this.multiLine, this.mode, this.hideClearWhenNoFocus, this.textExceedLengthListener, this.textClearedListener, null);
            }
        }

        public /* synthetic */ Config(String r1, boolean r2, boolean r3, String r4, View r5, View r6, Integer r7, boolean r8, String r9, TextWatcher r10, View.OnFocusChangeListener r11, boolean r12, Drawable r13, View.OnClickListener r14, View.OnClickListener r15, String r16, Integer r17, Integer r18, Drawable r19, boolean r20, boolean r21, boolean r22, int r23, boolean r24, TextExceedLengthListener r25, TextClearedListener r26, DefaultConstructorMarker r27) {
            this(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26);
        }

        private Config(String r3, boolean r4, boolean r5, String r6, View r7, View r8, Integer r9, boolean r10, String r11, TextWatcher r12, View.OnFocusChangeListener r13, boolean r14, Drawable r15, View.OnClickListener r16, View.OnClickListener r17, String r18, Integer r19, Integer r20, Drawable r21, boolean r22, boolean r23, boolean r24, int r25, boolean r26, TextExceedLengthListener r27, TextClearedListener r28) {
            this.title = r3;
            this.showCounter = r4;
            this.showClear = r5;
            this.hintText = r6;
            this.prefixView = r7;
            this.suffixView = r8;
            this.lengthLimit = r9;
            this.showDivider = r10;
            this.actionText = r11;
            this.textWatcher = r12;
            this.editTextOnFocusChangeListener = r13;
            this.actionTextClickable = r14;
            this.actionImageDrawable = r15;
            this.actionTextListener = r16;
            this.actionImageDrawableListener = r17;
            this.inputTips = r18;
            this.actionTextColor = r19;
            this.inputBoxHeight = r20;
            this.ivTitleIcon = r21;
            this.isInSearchBar = r22;
            this.autoHideClearWhenTextEmpty = r23;
            this.multiLine = r24;
            this.mode = r25;
            this.hideClearWhenNoFocus = r26;
            this.textExceedLengthListener = r27;
            this.textClearedListener = r28;
        }

        /* synthetic */ Config(String r28, boolean r29, boolean r30, String r31, View r32, View r33, Integer r34, boolean r35, String r36, TextWatcher r37, View.OnFocusChangeListener r38, boolean r39, Drawable r40, View.OnClickListener r41, View.OnClickListener r42, String r43, Integer r44, Integer r45, Drawable r46, boolean r47, boolean r48, boolean r49, int r50, boolean r51, TextExceedLengthListener r52, TextClearedListener r53, int r54, DefaultConstructorMarker r55) {
            if ((r54 & 1) == 0) goto L5;
            String r1 = "标题";
        L7:
            if ((r54 & 2) == 0) goto L9;
            boolean r2 = false;
        L11:
            if ((r54 & 4) == 0) goto L13;
            boolean r4 = false;
        L15:
            if ((r54 & 8) == 0) goto L17;
            String r5 = null;
        L19:
            if ((r54 & 16) == 0) goto L21;
            View r7 = null;
        L23:
            if ((r54 & 32) == 0) goto L25;
            View r8 = null;
        L27:
            if ((r54 & 64) == 0) goto L29;
            Integer r9 = null;
        L31:
            if ((r54 & 128) == 0) goto L33;
            boolean r10 = true;
        L35:
            if ((r54 & 256) == 0) goto L37;
            String r12 = null;
        L39:
            if ((r54 & 512) == 0) goto L41;
            TextWatcher r13 = null;
        L43:
            if ((r54 & 1024) == 0) goto L45;
            View.OnFocusChangeListener r14 = null;
        L47:
            if ((r54 & 2048) == 0) goto L49;
            boolean r15 = false;
        L51:
            if ((r54 & 4096) == 0) goto L53;
            Drawable r3 = null;
        L55:
            if ((r54 & 8192) == 0) goto L57;
            View.OnClickListener r6 = null;
        L59:
            if ((r54 & 16384) == 0) goto L61;
            View.OnClickListener r11 = null;
        L63:
            if ((r54 & 32768) == 0) goto L65;
            String r16 = null;
        L67:
            if ((r54 & 65536) == 0) goto L69;
            Integer r17 = null;
        L71:
            if ((r54 & 131072) == 0) goto L73;
            Integer r18 = null;
        L75:
            if ((r54 & 262144) == 0) goto L77;
            Drawable r19 = null;
        L79:
            if ((r54 & 524288) == 0) goto L81;
            boolean r20 = false;
        L83:
            if ((r54 & 1048576) == 0) goto L85;
            boolean r21 = false;
        L87:
            if ((r54 & 2097152) == 0) goto L89;
            boolean r22 = false;
        L91:
            if ((r54 & 4194304) == 0) goto L93;
            int r23 = 2;
        L95:
            if ((r54 & 8388608) == 0) goto L97;
            boolean r24 = true;
        L99:
            if ((r54 & 16777216) == 0) goto L101;
            TextExceedLengthListener r25 = null;
        L103:
            if ((r54 & 33554432) == 0) goto L105;
            TextClearedListener r0 = null;
        L106:
            this(r1, r2, r4, r5, r7, r8, r9, r10, r12, r13, r14, r15, r3, r6, r11, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r0);
            return;
        L105:
            r0 = r53;
            goto L106
        L101:
            r25 = r52;
            goto L103
        L97:
            r24 = r51;
            goto L99
        L93:
            r23 = r50;
            goto L95
        L89:
            r22 = r49;
            goto L91
        L85:
            r21 = r48;
            goto L87
        L81:
            r20 = r47;
            goto L83
        L77:
            r19 = r46;
            goto L79
        L73:
            r18 = r45;
            goto L75
        L69:
            r17 = r44;
            goto L71
        L65:
            r16 = r43;
            goto L67
        L61:
            r11 = r42;
            goto L63
        L57:
            r6 = r41;
            goto L59
        L53:
            r3 = r40;
            goto L55
        L49:
            r15 = r39;
            goto L51
        L45:
            r14 = r38;
            goto L47
        L41:
            r13 = r37;
            goto L43
        L37:
            r12 = r36;
            goto L39
        L33:
            r10 = r35;
            goto L35
        L29:
            r9 = r34;
            goto L31
        L25:
            r8 = r33;
            goto L27
        L21:
            r7 = r32;
            goto L23
        L17:
            r5 = r31;
            goto L19
        L13:
            r4 = r30;
            goto L15
        L9:
            r2 = r29;
            goto L11
        L5:
            r1 = r28;
            goto L7
        }

        public final String getTitle() {
            return this.title;
        }

        public final void setTitle(String r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.title = r2;
        }

        public final boolean getShowCounter() {
            return this.showCounter;
        }

        public final void setShowCounter(boolean r1) {
            this.showCounter = r1;
        }

        public final boolean getShowClear() {
            return this.showClear;
        }

        public final void setShowClear(boolean r1) {
            this.showClear = r1;
        }

        public final String getHintText() {
            return this.hintText;
        }

        public final void setHintText(String r1) {
            this.hintText = r1;
        }

        public final View getPrefixView() {
            return this.prefixView;
        }

        /* JADX INFO: renamed from: setPrefixView, reason: collision with other method in class */
        public final void m353setPrefixView(View r1) {
            this.prefixView = r1;
        }

        public final View getSuffixView() {
            return this.suffixView;
        }

        /* JADX INFO: renamed from: setSuffixView, reason: collision with other method in class */
        public final void m354setSuffixView(View r1) {
            this.suffixView = r1;
        }

        public final Integer getLengthLimit() {
            return this.lengthLimit;
        }

        public final void setLengthLimit(Integer r1) {
            this.lengthLimit = r1;
        }

        public final boolean getShowDivider() {
            return this.showDivider;
        }

        public final void setShowDivider(boolean r1) {
            this.showDivider = r1;
        }

        public final String getActionText() {
            return this.actionText;
        }

        public final void setActionText(String r1) {
            this.actionText = r1;
        }

        public final TextWatcher getTextWatcher() {
            return this.textWatcher;
        }

        public final void setTextWatcher(TextWatcher r1) {
            this.textWatcher = r1;
        }

        public final View.OnFocusChangeListener getEditTextOnFocusChangeListener() {
            return this.editTextOnFocusChangeListener;
        }

        public final void setEditTextOnFocusChangeListener(View.OnFocusChangeListener r1) {
            this.editTextOnFocusChangeListener = r1;
        }

        public final boolean getActionTextClickable() {
            return this.actionTextClickable;
        }

        public final void setActionTextClickable(boolean r1) {
            this.actionTextClickable = r1;
        }

        public final Drawable getActionImageDrawable() {
            return this.actionImageDrawable;
        }

        public final void setActionImageDrawable(Drawable r1) {
            this.actionImageDrawable = r1;
        }

        public final View.OnClickListener getActionTextListener() {
            return this.actionTextListener;
        }

        public final void setActionTextListener(View.OnClickListener r1) {
            this.actionTextListener = r1;
        }

        public final View.OnClickListener getActionImageDrawableListener() {
            return this.actionImageDrawableListener;
        }

        public final void setActionImageDrawableListener(View.OnClickListener r1) {
            this.actionImageDrawableListener = r1;
        }

        public final String getInputTips() {
            return this.inputTips;
        }

        public final void setInputTips(String r1) {
            this.inputTips = r1;
        }

        public final Integer getActionTextColor() {
            return this.actionTextColor;
        }

        public final void setActionTextColor(Integer r1) {
            this.actionTextColor = r1;
        }

        public final Integer getInputBoxHeight() {
            return this.inputBoxHeight;
        }

        public final void setInputBoxHeight(Integer r1) {
            this.inputBoxHeight = r1;
        }

        public final Drawable getIvTitleIcon() {
            return this.ivTitleIcon;
        }

        public final void setIvTitleIcon(Drawable r1) {
            this.ivTitleIcon = r1;
        }

        public final boolean isInSearchBar() {
            return this.isInSearchBar;
        }

        public final void setInSearchBar(boolean r1) {
            this.isInSearchBar = r1;
        }

        public final boolean getAutoHideClearWhenTextEmpty() {
            return this.autoHideClearWhenTextEmpty;
        }

        public final void setAutoHideClearWhenTextEmpty(boolean r1) {
            this.autoHideClearWhenTextEmpty = r1;
        }

        public final boolean getMultiLine() {
            return this.multiLine;
        }

        /* JADX INFO: renamed from: setMultiLine, reason: collision with other method in class */
        public final void m352setMultiLine(boolean r1) {
            this.multiLine = r1;
        }

        public final int getMode() {
            return this.mode;
        }

        public final void setMode(int r1) {
            this.mode = r1;
        }

        public final boolean getHideClearWhenNoFocus() {
            return this.hideClearWhenNoFocus;
        }

        public final void setHideClearWhenNoFocus(boolean r1) {
            this.hideClearWhenNoFocus = r1;
        }

        public final TextExceedLengthListener getTextExceedLengthListener() {
            return this.textExceedLengthListener;
        }

        public final void setTextExceedLengthListener(TextExceedLengthListener r1) {
            this.textExceedLengthListener = r1;
        }

        public final TextClearedListener getTextClearedListener() {
            return this.textClearedListener;
        }

        public final void setTextClearedListener(TextClearedListener r1) {
            this.textClearedListener = r1;
        }

        public final Config textClearedListener(TextClearedListener r2) {
            setTextClearedListener(r2);
            return this;
        }

        public final Config textExceedLengthListener(TextExceedLengthListener r2) {
            Intrinsics.checkNotNullParameter(r2, "textExceedLengthListener");
            setTextExceedLengthListener(r2);
            return this;
        }

        public final Config title(String r2) {
            Intrinsics.checkNotNullParameter(r2, "title");
            setTitle(r2);
            return this;
        }

        public final Config inputTips(String r2) {
            Intrinsics.checkNotNullParameter(r2, "tips");
            setInputTips(r2);
            return this;
        }

        public final Config setTitleIcon(Drawable r2) {
            Intrinsics.checkNotNullParameter(r2, "drawable");
            setIvTitleIcon(r2);
            return this;
        }

        public final Config showCounter(boolean r2) {
            setShowCounter(r2);
            return this;
        }

        public final Config lengthLimit(int r2) {
            setLengthLimit(Integer.valueOf(r2));
            return this;
        }

        public final Config showClear(boolean r2) {
            setShowClear(r2);
            return this;
        }

        public final Config hintText(String r2) {
            Intrinsics.checkNotNullParameter(r2, "text");
            setHintText(r2);
            return this;
        }

        public final Config setPrefixView(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            m353setPrefixView(r2);
            return this;
        }

        public final Config setSuffixView(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            m354setSuffixView(r2);
            return this;
        }

        public final Config showDivider(boolean r2) {
            setShowDivider(r2);
            return this;
        }

        public static /* synthetic */ Config actionText$default(Config r1, String r2, boolean r3, View.OnClickListener r4, Integer r5, int r6, Object r7) {
            if ((r6 & 4) == 0) goto L6;
            r4 = null;
        L6:
            if ((r6 & 8) == 0) goto L9;
            r5 = null;
        L9:
            return r1.actionText(r2, r3, r4, r5);
        }

        public final Config actionText(String r2, boolean r3, View.OnClickListener r4, Integer r5) {
            Intrinsics.checkNotNullParameter(r2, "text");
            setActionText(r2);
            setActionTextClickable(r3);
            setActionTextListener(r4);
            if (r5 == null) goto L5;
            setActionTextColor(r5);
        L5:
            return this;
        }

        public final Config actionImageDrawable(Drawable r2, View.OnClickListener r3) {
            Intrinsics.checkNotNullParameter(r2, "drawable");
            Intrinsics.checkNotNullParameter(r3, "onClickListener");
            setActionImageDrawable(r2);
            setActionImageDrawableListener(r3);
            return this;
        }

        public final Config textWatcher(TextWatcher r2) {
            Intrinsics.checkNotNullParameter(r2, "watcher");
            setTextWatcher(r2);
            return this;
        }

        public final Config editTextOnFocusChangeListener(View.OnFocusChangeListener r2) {
            Intrinsics.checkNotNullParameter(r2, "listener");
            setEditTextOnFocusChangeListener(r2);
            return this;
        }

        public final Config inputBoxHeight(int r2) {
            setInputBoxHeight(Integer.valueOf(r2));
            return this;
        }

        public final Config setMultiLine(boolean r2) {
            m352setMultiLine(r2);
            return this;
        }

        public final Config isInSearchBar(boolean r2) {
            setInSearchBar(r2);
            if (r2 == false) goto L5;
            setShowDivider(false);
            setAutoHideClearWhenTextEmpty(true);
        L5:
            return this;
        }

        public final Config autoHideClearWhenTextEmpty(boolean r2) {
            setAutoHideClearWhenTextEmpty(r2);
            return this;
        }

        public final Config mode(int r2) {
            setMode(r2);
            return this;
        }

        public final Config hideClearWhenNoFocus(boolean r2) {
            setHideClearWhenNoFocus(r2);
            return this;
        }
    }

    /* JADX INFO: compiled from: OLineInputView.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/forms/OLineInputView$TextClearedListener;", "", "afterClear", "", "beforeClear", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface TextClearedListener {
        void afterClear();

        void beforeClear();
    }

    /* JADX INFO: compiled from: OLineInputView.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/forms/OLineInputView$TextExceedLengthListener;", "", "textExceedLength", "", "s", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface TextExceedLengthListener {
        void textExceedLength(String r1);
    }

    public static /* synthetic */ void $r8$lambda$4FGNJEnZKHDngkEiL2piCrhLJpI(OLineInputView r0, View r1) {
        m349refreshConfig$lambda2(r0, r1);
    }

    public static /* synthetic */ boolean $r8$lambda$8RigH74U3xT9icIwnXijfbekH3c(OLineInputView r0, View r1, MotionEvent r2) {
        return m351refreshConfig$lambda4(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$Ez1PWrKrk__6UZd2108x3zLwl9U(OLineInputView r0, View r1, boolean r2) {
        m350refreshConfig$lambda3(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$y-zJm8vU0gwNEWdcKLw7Tg-K6Ho, reason: not valid java name */
    public static /* synthetic */ void m347$r8$lambda$yzJm8vU0gwNEWdcKLw7TgK6Ho(OLineInputView r0, View r1, boolean r2) {
        m348refreshConfig$lambda1(r0, r1, r2);
    }

    static {
        Companion = new Companion(null);
    }

    public OLineInputView(Context r9) {
        Intrinsics.checkNotNullParameter(r9, "context");
        this(r9, null, 0, 0, 14, null);
    }

    public OLineInputView(Context r9, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r9, "context");
        this(r9, r10, 0, 0, 12, null);
    }

    public OLineInputView(Context r9, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r9, "context");
        this(r9, r10, r11, 0, 8, null);
    }

    public /* synthetic */ OLineInputView(Context r1, AttributeSet r2, int r3, int r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r3 = 0;
    L9:
        if ((r5 & 8) == 0) goto L11;
        r4 = 1;
    L11:
        this(r1, r2, r3, r4);
    }

    public static final /* synthetic */ Config access$getConfig$p(OLineInputView r0) {
        return r0.config;
    }

    public final int getArrangeDirection() {
        return this.arrangeDirection;
    }

    public final void setArrangeDirection(int r1) {
        this.arrangeDirection = r1;
    }

    public OLineInputView(Context r33, AttributeSet r34, int r35, int r36) {
        Intrinsics.checkNotNullParameter(r33, "context");
        super(r33, r34, r35);
        this.arrangeDirection = r36;
        this.config = new Config.Builder(null, null, null, false, null, false, null, null, null, false, null, null, false, null, null, null, null, null, null, false, false, false, 0, false, null, null, 67108863, null).build();
        this.textGravity = 16;
        this.isShowTitle = true;
        this.DEFAULT_MAX_LINES = 20;
        this.errorTips = "";
        this.inputTips = "";
        TypedArray r4 = r33.getTheme().obtainStyledAttributes(r34, R.styleable.OLineInputView, r35, 0);
        setArrangeDirection(r4.getInt(R.styleable.OLineInputView_oui_formArrangeDirection, 0));
        String r5 = r4.getString(R.styleable.OLineInputView_oui_formTitle);
        Config r7 = this.config;
        if (r5 != null) goto L5;
        r5 = "title";
    L5:
        r7.setTitle(r5);
        boolean r6 = r4.getBoolean(R.styleable.OLineInputView_oui_formShowClear, true);
        this.config.setShowClear(r6);
        String r8 = r4.getString(R.styleable.OLineInputView_android_hint);
        this.config.setHintText(r8);
        boolean r9 = r4.getBoolean(R.styleable.OLineInputView_oui_formShowCounter, false);
        this.config.setShowCounter(r9);
        int r10 = r4.getInt(R.styleable.OLineInputView_oui_formLengthLimit, 0);
        if (r10 <= 0) goto L8;
        this.config.setLengthLimit(Integer.valueOf(r10));
    L8:
        int r11 = r4.getDimensionPixelSize(R.styleable.OLineInputView_oui_formInputHeight, 0);
        if (r11 <= 0) goto L11;
        this.config.setInputBoxHeight(Integer.valueOf(r11));
    L11:
        this.config.m352setMultiLine(r4.getBoolean(R.styleable.OLineInputView_oui_formMultiLine, false));
        boolean r12 = r4.getBoolean(R.styleable.OLineInputView_oui_formShowDivider, true);
        this.config.setShowDivider(r12);
        String r13 = r4.getString(R.styleable.OLineInputView_oui_formInputTips);
        this.config.setInputTips(r13);
        this.text = r4.getString(R.styleable.OLineInputView_android_text);
        this.showTitleDefaultIcon = r4.getBoolean(R.styleable.OLineInputView_oui_formShowTitleDefaultIcon, false);
        this.titleDefaultIconSize = r4.getInt(R.styleable.OLineInputView_oui_formTitleDefaultIconSize, 0);
        this.textGravity = r4.getInt(R.styleable.OLineInputView_android_gravity, 16);
        setFocusableInTouchMode(true);
        setFocusable(true);
        setDescendantFocusability(262144);
        int r1 = this.arrangeDirection;
        if (r1 == 0) goto L19;
        if (r1 != 1) goto L15;
        int r2 = R.layout.o_form_line_input_horizontal;
    L20:
        LayoutInflater.from(r33).inflate(r2, this);
        View r3 = findViewById(R.id.tv_title);
        Intrinsics.checkNotNullExpressionValue(r3, "findViewById(R.id.tv_title)");
        this.tvTitle = (TextView) r3;
        View r14 = findViewById(R.id.et_input);
        Intrinsics.checkNotNullExpressionValue(r14, "findViewById(R.id.et_input)");
        OFormEditText r15 = (OFormEditText) r14;
        this.editText = r15;
        View r16 = findViewById(R.id.tv_error_tips);
        Intrinsics.checkNotNullExpressionValue(r16, "findViewById(R.id.tv_error_tips)");
        this.tvErrorTips = (TextView) r16;
        View r17 = findViewById(R.id.tv_counter);
        Intrinsics.checkNotNullExpressionValue(r17, "findViewById(R.id.tv_counter)");
        this.tvCounter = (TextView) r17;
        View r18 = findViewById(R.id.tv_action);
        Intrinsics.checkNotNullExpressionValue(r18, "findViewById(R.id.tv_action)");
        this.tvAction = (TextView) r18;
        View r19 = findViewById(R.id.iv_clear);
        Intrinsics.checkNotNullExpressionValue(r19, "findViewById(R.id.iv_clear)");
        this.ivClear = (ImageView) r19;
        View r20 = findViewById(R.id.iv_action);
        Intrinsics.checkNotNullExpressionValue(r20, "findViewById(R.id.iv_action)");
        this.ivAction = (ImageView) r20;
        View r21 = findViewById(R.id.divider);
        Intrinsics.checkNotNullExpressionValue(r21, "findViewById(R.id.divider)");
        this.divider = (ODivider) r21;
        View r22 = findViewById(R.id.iv_title_icon);
        Intrinsics.checkNotNullExpressionValue(r22, "findViewById(R.id.iv_title_icon)");
        this.ivTitleIcon = (ImageView) r22;
        View r23 = findViewById(R.id.prefix_container);
        Intrinsics.checkNotNullExpressionValue(r23, "findViewById(R.id.prefix_container)");
        this.prefixContainer = (RelativeLayout) r23;
        View r24 = findViewById(R.id.suffix_container);
        Intrinsics.checkNotNullExpressionValue(r24, "findViewById(R.id.suffix_container)");
        this.suffixContainer = (RelativeLayout) r24;
        View r25 = findViewById(R.id.tv_input_tips);
        Intrinsics.checkNotNullExpressionValue(r25, "findViewById(R.id.tv_input_tips)");
        this.tvInputTips = (TextView) r25;
        View r26 = findViewById(R.id.title_container);
        Intrinsics.checkNotNullExpressionValue(r26, "findViewById(R.id.title_container)");
        this.titleContainer = (ViewGroup) r26;
        View r27 = findViewById(R.id.input_container);
        Intrinsics.checkNotNullExpressionValue(r27, "findViewById(R.id.input_container)");
        this.inputContainer = (ViewGroup) r27;
        this.leftContainer = (ConstraintLayout) findViewById(R.id.left_container);
        View r28 = findViewById(R.id.action_container);
        Intrinsics.checkNotNullExpressionValue(r28, "findViewById(R.id.action_container)");
        this.actionContainer = (ViewGroup) r28;
        this.activeBorderView = (ConstraintLayout) findViewById(R.id.active_border_view);
        View r29 = findViewById(R.id.iv_clear_container);
        Intrinsics.checkNotNullExpressionValue(r29, "findViewById(R.id.iv_clear_container)");
        this.ivClearContainer = (LinearLayout) r29;
        View r30 = findViewById(R.id.iv_action_container);
        Intrinsics.checkNotNullExpressionValue(r30, "findViewById(R.id.iv_action_container)");
        this.ivActionContainer = (LinearLayout) r30;
        updateConfig(this.config);
        r15.setVerticalScrollBarEnabled(false);
        return;
    L15:
        if (r1 == 2) goto L17;
        r2 = R.layout.o_form_line_input_vertical;
        goto L20
    L17:
        r2 = R.layout.o_form_line_input_vertical_single_box;
        goto L20
    L19:
        r2 = R.layout.o_form_line_input_vertical;
        goto L20
    }

    public final TextView getTvTitle() {
        return this.tvTitle;
    }

    public final OFormEditText getEditText() {
        return this.editText;
    }

    public final TextView getTvErrorTips() {
        return this.tvErrorTips;
    }

    public final TextView getTvCounter() {
        return this.tvCounter;
    }

    public final TextView getTvAction() {
        return this.tvAction;
    }

    public final ImageView getIvClear() {
        return this.ivClear;
    }

    public final LinearLayout getIvClearContainer() {
        return this.ivClearContainer;
    }

    public final ImageView getIvAction() {
        return this.ivAction;
    }

    public final LinearLayout getIvActionContainer() {
        return this.ivActionContainer;
    }

    public final ODivider getDivider() {
        return this.divider;
    }

    public final RelativeLayout getPrefixContainer() {
        return this.prefixContainer;
    }

    public final RelativeLayout getSuffixContainer() {
        return this.suffixContainer;
    }

    public final ImageView getIvTitleIcon() {
        return this.ivTitleIcon;
    }

    public final TextView getTvInputTips() {
        return this.tvInputTips;
    }

    public final ViewGroup getTitleContainer() {
        return this.titleContainer;
    }

    public final ViewGroup getInputContainer() {
        return this.inputContainer;
    }

    public final ViewGroup getActionContainer() {
        return this.actionContainer;
    }

    public final ConstraintLayout getActiveBorderView() {
        return this.activeBorderView;
    }

    public final void setActiveBorderView(ConstraintLayout r1) {
        this.activeBorderView = r1;
    }

    public final ConstraintLayout getLeftContainer() {
        return this.leftContainer;
    }

    public final void setLeftContainer(ConstraintLayout r1) {
        this.leftContainer = r1;
    }

    public final void enableVerticalScrollBar(boolean r1) {
        this.editText.setVerticalScrollBarEnabled(r1);
    }

    @Override // android.view.View
    public void setEnabled(boolean r2) {
        this.editText.setEnabled(r2);
        super.setEnabled(r2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        OLineInputView r0 = this;
        int r2 = OUnitExtensionKt.vdp(r0, 44);
        ViewExtensionsKt.expandTouchArea(this.actionContainer, OUnitExtensionKt.vdp(r0, 44));
        ViewExtensionsKt.increaseHitAreaForViews(this.actionContainer, r2, r2, new View[]{this.tvAction, this.ivAction});
    }

    public final void setInputContainerBackground(Drawable r2) {
        Intrinsics.checkNotNullParameter(r2, "drawable");
        this.inputContainer.setBackground(r2);
    }

    public final void setInputContainerPadding(int r1, int r2, int r3, int r4) {
        this.inputContainer.setPadding(r1, r2, r3, r4);
    }

    private final void refreshConfig() {
        String r0 = this.config.getTitle();
        boolean r1 = false;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L11;
        this.tvTitle.setText(this.config.getTitle());
    L13:
        if (this.isShowTitle == false) goto L15;
        showTitle();
    L17:
        if (this.config.getIvTitleIcon() == null) goto L20;
        this.ivTitleIcon.setImageDrawable(this.config.getIvTitleIcon());
        this.isShowTitleIcon = true;
    L20:
        if (this.isShowTitleIcon == false) goto L22;
        showTitleIcon();
    L23:
        int r3 = this.titleDefaultIconSize;
        if (r3 == 0) goto L28;
        if (r3 == 1) goto L27;
        setSmallTitleIcon();
    L30:
        if (this.config.getAutoHideClearWhenTextEmpty() == false) goto L33;
        TextWatcher r4 = new OLineInputView$refreshConfig$clearWatcher$1(this);
        getTextWatchers().add(new WeakReference(r4));
        this.editText.addTextChangedListener(r4);
    L33:
        if (this.config.getShowCounter() == false) goto L38;
        if (this.config.getLengthLimit() == null) goto L38;
        this.counterTextWatcher = new C02761(this);
        ArrayList<WeakReference<TextWatcher>> r5 = getTextWatchers();
        TextWatcher r6 = this.counterTextWatcher;
        Intrinsics.checkNotNull(r6);
        r5.add(new WeakReference(r6));
        this.editText.addTextChangedListener(this.counterTextWatcher);
        ViewExtensionsKt.makeVisible(this.tvCounter);
    L38:
        if (this.config.getShowClear() == true) goto L40;
        hideClear();
        this.editText.setOnFocusChangeListener(new OLineInputView$$ExternalSyntheticLambda0(this));
    L44:
        String r7 = this.config.getHintText();
        if (r7 != null) goto L47;
    L50:
        boolean r8 = true;
    L51:
        if (r8 == true) goto L54;
        this.editText.setHint(this.config.getHintText());
    L54:
        if (this.config.getPrefixView() == null) goto L57;
        this.prefixContainer.removeAllViews();
        this.prefixContainer.addView(this.config.getPrefixView(), new ConstraintLayout.LayoutParams(-2, -2));
        showPrefixView();
    L57:
        if (this.config.getSuffixView() == null) goto L60;
        this.suffixContainer.removeAllViews();
        this.suffixContainer.addView(this.config.getSuffixView(), new ConstraintLayout.LayoutParams(-2, -2));
        showSuffixView();
    L60:
        if (this.config.isInSearchBar() == false) goto L63;
        this.config.setShowDivider(false);
    L63:
        if (this.config.getShowDivider() == false) goto L65;
        showDivider();
    L66:
        String r9 = this.config.getActionText();
        if (r9 != null) goto L69;
    L72:
        boolean r10 = true;
    L73:
        if (r10 == true) goto L85;
        this.tvAction.setText(this.config.getActionText());
        if (this.config.getActionTextColor() == null) goto L77;
        TextView r11 = this.tvAction;
        Integer r12 = this.config.getActionTextColor();
        Intrinsics.checkNotNull(r12);
        r11.setTextColor(r12.intValue());
    L79:
        if (this.config.getActionTextClickable() == true) goto L81;
    L83:
        showActionText();
        goto L85
    L81:
        if (this.config.getActionTextListener() == null) goto L83;
        this.tvAction.setOnClickListener(this.config.getActionTextListener());
        goto L83
    L77:
        this.tvAction.setTextColor(ContextCompat.getColor(getContext(), R.color.TextPrimary));
    L85:
        if (this.config.getTextWatcher() == null) goto L88;
        ArrayList<WeakReference<TextWatcher>> r13 = getTextWatchers();
        TextWatcher r14 = this.config.getTextWatcher();
        Intrinsics.checkNotNull(r14);
        r13.add(new WeakReference(r14));
        this.editText.addTextChangedListener(this.config.getTextWatcher());
    L88:
        if (this.config.getActionImageDrawable() == null) goto L94;
        this.ivAction.setImageDrawable(this.config.getActionImageDrawable());
        if (this.config.getActionImageDrawableListener() == null) goto L92;
        this.ivAction.setOnClickListener(this.config.getActionImageDrawableListener());
    L92:
        showActionImage();
    L94:
        if (TextUtils.isEmpty(this.config.getInputTips()) == true) goto L97;
        String r15 = this.config.getInputTips();
        Intrinsics.checkNotNull(r15);
        showInputTips(r15);
    L97:
        if (this.config.getInputBoxHeight() == null) goto L103;
        ViewGroup r16 = this.inputContainer;
        ViewGroup.LayoutParams r17 = r16.getLayoutParams();
        if (r17 == null) goto L102;
        ConstraintLayout.LayoutParams r18 = (ConstraintLayout.LayoutParams) r17;
        Integer r19 = this.config.getInputBoxHeight();
        Intrinsics.checkNotNull(r19);
        r18.height = r19.intValue();
        r16.setLayoutParams(r18);
    L117:
        if (this.config.getMultiLine() == false) goto L119;
        OFormEditText r20 = this.editText;
        r20.setSingleLine(false);
        r20.setLines(this.DEFAULT_MAX_LINES);
    L120:
        String r21 = this.text;
        if (r21 != null) goto L123;
    L124:
        r1 = true;
    L125:
        if (r1 == true) goto L128;
        setText(this.text);
    L128:
        if (this.showTitleDefaultIcon == true) goto L130;
    L132:
        this.editText.setGravity(this.textGravity);
        if (this.config.getEditTextOnFocusChangeListener() == null) goto L136;
        View.OnFocusChangeListener r22 = this.config.getEditTextOnFocusChangeListener();
        Intrinsics.checkNotNull(r22);
        setEditTextOnFocusChangeListener(r22);
    L136:
        if (this.isShowTitle == false) goto L138;
        showTitle();
    L140:
        if (this.isShowErrorTips == false) goto L142;
        String r23 = this.errorTips;
        Intrinsics.checkNotNull(r23);
        showErrorTips(r23);
    L144:
        if (this.isShowInputTips == false) goto L146;
        String r24 = this.inputTips;
        Intrinsics.checkNotNull(r24);
        showInputTips(r24);
    L148:
        if (this.isShowPrefix == false) goto L150;
        showPrefixView();
    L152:
        if (this.isShowSuffix == false) goto L154;
        showSuffixView();
    L156:
        if (this.isShowActionText == false) goto L158;
        showActionText();
    L160:
        if (this.isShowActionImage == false) goto L162;
        showActionImage();
    L163:
        setMode$default(this, this.config.getMode(), null, 2, null);
        return;
    L162:
        hideActionImage();
        goto L163
    L158:
        hideActionText();
        goto L160
    L154:
        hideSuffixView();
        goto L156
    L150:
        hidePrefixView();
        goto L152
    L146:
        hideInputTips();
        goto L148
    L142:
        hideErrorTips();
        goto L144
    L138:
        hideTitle();
        goto L140
    L130:
        if (this.config.getIvTitleIcon() != null) goto L132;
        showTitleIcon();
        goto L132
    L123:
        if (r21.length() != 0) goto L125;
    L119:
        this.editText.setSingleLine(true);
        goto L120
    L102:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L103:
        ViewGroup r25 = this.inputContainer;
        ViewGroup.LayoutParams r26 = r25.getLayoutParams();
        if (r26 == null) goto L166;
        ConstraintLayout.LayoutParams r27 = (ConstraintLayout.LayoutParams) r26;
        ConstraintLayout.LayoutParams r28 = r27;
        int r29 = getArrangeDirection();
        if (r29 == 1) goto L112;
        if (r29 == 2) goto L110;
        int r30 = OUnitExtensionKt.vdp(this, 40);
    L115:
        r28.height = r30;
        r25.setLayoutParams(r27);
        goto L117
    L110:
        r30 = OUnitExtensionKt.vdp(this, 40);
        goto L115
    L112:
        if (this.config.isInSearchBar() == false) goto L114;
        r30 = OUnitExtensionKt.vdp(this, 36);
        goto L115
    L114:
        r30 = OUnitExtensionKt.vdp(this, 52);
        goto L115
    L166:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L69:
        if (r9.length() == 0) goto L72;
        r10 = false;
        goto L73
    L65:
        hideDivider();
        goto L66
    L47:
        if (r7.length() == 0) goto L50;
        r8 = false;
        goto L51
    L40:
        this.ivClear.setOnClickListener(new OLineInputView$$ExternalSyntheticLambda1(this));
        if (TextUtils.isEmpty(this.editText.getText()) == false) goto L43;
        ViewExtensionsKt.makeGone(this.ivClear);
        ViewExtensionsKt.makeGone(this.ivClearContainer);
    L43:
        this.editText.setOnFocusChangeListener(new OLineInputView$$ExternalSyntheticLambda2(this));
        this.editText.setOnTouchListener(new OLineInputView$$ExternalSyntheticLambda3(this));
        goto L44
    L27:
        setMiddleTitleIcon();
        goto L30
    L28:
        setSmallTitleIcon();
        goto L30
    L22:
        hideTitleIcon();
        goto L23
    L15:
        hideTitle();
        goto L17
    L11:
        this.isShowTitle = false;
        goto L13
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r2 = false;
        goto L9
    }

    /* JADX INFO: renamed from: refreshConfig$lambda-1, reason: not valid java name */
    private static final void m348refreshConfig$lambda1(OLineInputView r0, View r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        if (r2 == false) goto L5;
        r0.showSoftInput();
        return;
    L5:
        r0.hideSoftInput();
    }

    /* JADX INFO: renamed from: refreshConfig$lambda-2, reason: not valid java name */
    private static final void m349refreshConfig$lambda2(OLineInputView r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        TextClearedListener r2 = r0.config.getTextClearedListener();
        if (r2 == null) goto L6;
        r2.beforeClear();
    L6:
        r0.setText("");
        TextClearedListener r3 = r0.config.getTextClearedListener();
        if (r3 == null) goto L11;
        r3.afterClear();
        return;
    }

    /* JADX INFO: renamed from: refreshConfig$lambda-3, reason: not valid java name */
    private static final void m350refreshConfig$lambda3(OLineInputView r0, View r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        if (r2 == false) goto L12;
        if (r0.config.getAutoHideClearWhenTextEmpty() == true) goto L7;
    L9:
        r0.showClear();
    L10:
        r0.showSoftInput();
        return;
    L7:
        if (TextUtils.isEmpty(r0.getText()) == false) goto L9;
        r0.hideClear();
        goto L10
    L12:
        if (r0.config.getHideClearWhenNoFocus() == false) goto L14;
    L15:
        r0.hideClear();
    L16:
        r0.hideSoftInput();
        return;
    L14:
        if (TextUtils.isEmpty(r0.getText()) == false) goto L16;
        goto L15
    }

    /* JADX INFO: renamed from: refreshConfig$lambda-4, reason: not valid java name */
    private static final boolean m351refreshConfig$lambda4(OLineInputView r0, View r1, MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        Intrinsics.checkNotNullParameter(r2, "event");
        int r3 = r2.getActionMasked();
        if (r3 == 0) goto L26;
        if (r3 == 1) goto L10;
        if (r3 == 3) goto L10;
        return false;
    L10:
        if (r0.isErrorState == false) goto L16;
        ConstraintLayout r4 = r0.activeBorderView;
        if (r4 == null) goto L49;
        r4.setBackgroundResource(R.drawable.o_line_box_input_error_default_border);
        return false;
    L49:
        return false;
    L16:
        if (r0.editText.hasFocus() == false) goto L21;
        ConstraintLayout r5 = r0.activeBorderView;
        if (r5 == null) goto L50;
        r5.setBackgroundResource(R.drawable.o_line_box_input_focused_default_border);
        return false;
    L50:
        return false;
    L21:
        ConstraintLayout r6 = r0.activeBorderView;
        if (r6 == null) goto L51;
        r6.setBackgroundResource(R.drawable.o_line_box_input_normal_default_border);
        return false;
    L51:
        return false;
    L26:
        if (r0.isErrorState == false) goto L32;
        ConstraintLayout r7 = r0.activeBorderView;
        if (r7 == null) goto L52;
        r7.setBackgroundResource(R.drawable.o_line_box_input_error_pressed_border);
        return false;
    L52:
        return false;
    L32:
        if (r0.editText.hasFocus() == false) goto L37;
        ConstraintLayout r8 = r0.activeBorderView;
        if (r8 == null) goto L53;
        r8.setBackgroundResource(R.drawable.o_line_box_input_focused_pressed_border);
        return false;
    L53:
        return false;
    L37:
        ConstraintLayout r9 = r0.activeBorderView;
        if (r9 == null) goto L54;
        r9.setBackgroundResource(R.drawable.o_line_box_input_normal_pressed_border);
        return false;
    L54:
        return false;
    }

    private final void showSoftInput() {
        Object r0 = getContext().getSystemService("input_method");
        if (r0 == null) goto L7;
        ((InputMethodManager) r0).showSoftInput(this, 0);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    }

    private final void hideSoftInput() {
        Object r0 = getContext().getSystemService("input_method");
        if (r0 == null) goto L7;
        ((InputMethodManager) r0).hideSoftInputFromWindow(getWindowToken(), 0);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    }

    public static /* synthetic */ void setMode$default(OLineInputView r0, int r1, View.OnClickListener r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.setMode(r1, r2);
    }

    public final void setMode(int r2, View.OnClickListener r3) {
        if (r2 != 2) goto L5;
        this.editText.setFocusable(true);
        this.editText.setFocusableInTouchMode(true);
        this.editText.setOnClickListener(null);
        setOnClickListener(null);
        return;
    L5:
        if (r2 != 3) goto L15;
        this.editText.setFocusable(false);
        this.editText.setFocusableInTouchMode(false);
        if (r3 != null) goto L10;
        this.editText.setOnClickListener(this.config.getActionImageDrawableListener());
        setOnClickListener(this.config.getActionImageDrawableListener());
        return;
    L10:
        this.editText.setOnClickListener(r3);
        setOnClickListener(r3);
        return;
    }

    public final String getText() {
        return String.valueOf(this.editText.getText());
    }

    public final void setText(String r3) {
        if (r3 == null) goto L8;
        String r1 = r3;
        this.editText.setText(r1);
        TextWatcher r2 = this.counterTextWatcher;
        if (r2 == null) goto L9;
        r2.onTextChanged(r1, 0, 0, r3.length());
        return;
    L9:
        return;
    }

    private final void clear() {
        Iterator<WeakReference<TextWatcher>> r0 = getTextWatchers().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        WeakReference<TextWatcher> r1 = r0.next();
        this.editText.removeTextChangedListener(r1.get());
        goto L4
    }

    public final Config getConfig() {
        return this.config;
    }

    public final void updateConfig(Config r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
        this.config = r2;
        clear();
        refreshConfig();
    }

    public static /* synthetic */ void setAutoHideClearWhenTextEmpty$default(OLineInputView r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = true;
    L5:
        r0.setAutoHideClearWhenTextEmpty(r1);
    }

    public final void setAutoHideClearWhenTextEmpty(boolean r2) {
        Config r0 = getConfig();
        r0.setAutoHideClearWhenTextEmpty(r2);
        updateConfig(r0);
    }

    public final void showErrorTips(String r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        ViewExtensionsKt.makeVisible(this.tvErrorTips);
        this.tvErrorTips.setText(r4);
        this.divider.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.Primary));
        if (ViewExtensionsKt.isVisibile(this.tvInputTips) == false) goto L7;
        hideInputTips();
    L7:
        this.isShowErrorTips = true;
        this.errorTips = r4;
    }

    public final void setInputViewNormal() {
        this.isErrorState = false;
        int r0 = R.drawable.o_line_box_input_normal_border_selector;
        Drawable r1 = ContextCompat.getDrawable(getContext(), r0);
        ConstraintLayout r2 = this.activeBorderView;
        if (r2 == null) goto L7;
        r2.setBackground(r1);
        return;
    }

    public final void setInputViewActived() {
        this.isErrorState = false;
        int r0 = R.drawable.o_line_box_input_focused_border_selector;
        Drawable r1 = ContextCompat.getDrawable(getContext(), r0);
        ConstraintLayout r2 = this.activeBorderView;
        if (r2 == null) goto L7;
        r2.setBackground(r1);
        return;
    }

    public final void setInputViewError() {
        this.isErrorState = true;
        int r0 = R.drawable.o_line_box_input_error_border_selector;
        Drawable r1 = ContextCompat.getDrawable(getContext(), r0);
        ConstraintLayout r2 = this.activeBorderView;
        if (r2 == null) goto L7;
        r2.setBackground(r1);
        return;
    }

    public final void hideErrorTips() {
        ViewExtensionsKt.makeGone(this.tvErrorTips);
        this.divider.setStyle(0);
        CharSequence r0 = this.tvInputTips.getText();
        Intrinsics.checkNotNullExpressionValue(r0, "tvInputTips.text");
        if (r0.length() <= 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
        showInputTips(this.tvInputTips.getText().toString());
    L8:
        this.isShowErrorTips = false;
        return;
    L5:
        r1 = false;
        goto L6
    }

    public final void showInputTips(String r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        this.tvInputTips.setText(r3);
        ViewExtensionsKt.makeVisible(this.tvInputTips);
        if (this.tvErrorTips.getVisibility() != 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == false) goto L10;
        hideErrorTips();
    L10:
        this.isShowInputTips = true;
        this.inputTips = r3;
        return;
    L7:
        r0 = false;
        goto L8
    }

    public final void hideInputTips() {
        ViewExtensionsKt.makeGone(this.tvInputTips);
        this.isShowInputTips = false;
    }

    public final void showTitleIcon() {
        if (this.titleContainer.getVisibility() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        ViewExtensionsKt.makeVisible(this.titleContainer);
    L8:
        ViewExtensionsKt.makeVisible(this.ivTitleIcon);
        this.isShowTitleIcon = true;
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void hideTitleIcon() {
        ViewExtensionsKt.makeGone(this.ivTitleIcon);
        if (this.tvTitle.getVisibility() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
    L9:
        ViewExtensionsKt.makeGone(this.titleContainer);
    L10:
        this.isShowTitleIcon = false;
        return;
    L8:
        if (TextUtils.isEmpty(this.tvTitle.getText()) == false) goto L10;
    L5:
        r0 = false;
        goto L6
    }

    public final void setSmallTitleIcon() {
        ViewGroup.LayoutParams r0 = this.ivTitleIcon.getLayoutParams();
        Intrinsics.checkNotNullExpressionValue(r0, "ivTitleIcon.getLayoutParams()");
        OLineInputView r1 = this;
        r0.width = OUnitExtensionKt.vdp(r1, 10);
        r0.height = OUnitExtensionKt.vdp(r1, 10);
        this.ivTitleIcon.setLayoutParams(r0);
    }

    public final void setMiddleTitleIcon() {
        ViewGroup.LayoutParams r0 = this.ivTitleIcon.getLayoutParams();
        Intrinsics.checkNotNullExpressionValue(r0, "ivTitleIcon.getLayoutParams()");
        OLineInputView r1 = this;
        r0.width = OUnitExtensionKt.vdp(r1, 16);
        r0.height = OUnitExtensionKt.vdp(r1, 16);
        this.ivTitleIcon.setLayoutParams(r0);
    }

    public final void showTitle() {
        ViewExtensionsKt.makeVisible(this.tvTitle);
        if (this.titleContainer.getVisibility() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        ViewExtensionsKt.makeVisible(this.titleContainer);
    L8:
        this.isShowTitle = true;
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void hideTitle() {
        ViewExtensionsKt.makeGone(this.tvTitle);
        if (this.ivTitleIcon.getVisibility() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        ViewExtensionsKt.makeGone(this.titleContainer);
    L8:
        this.isShowTitle = false;
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void showClear() {
        ViewExtensionsKt.makeVisible(this.ivClearContainer);
        ViewExtensionsKt.makeVisible(this.ivClear);
        this.config.setShowClear(false);
    }

    public final void hideClear() {
        ViewExtensionsKt.makeGone(this.ivClearContainer);
        ViewExtensionsKt.makeGone(this.ivClear);
        this.config.setShowClear(false);
    }

    public final void showActionImage() {
        if (this.ivAction.getVisibility() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        ViewExtensionsKt.makeVisible(this.ivAction);
    L8:
        this.isShowActionImage = true;
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void hideActionImage() {
        if (this.ivAction.getVisibility() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        ViewExtensionsKt.makeGone(this.ivAction);
    L8:
        this.isShowActionImage = false;
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void showPrefixView() {
        ViewExtensionsKt.makeVisible(this.prefixContainer);
        this.isShowPrefix = true;
    }

    public final void hidePrefixView() {
        ViewExtensionsKt.makeGone(this.prefixContainer);
        this.isShowPrefix = false;
    }

    public final void showSuffixView() {
        ViewExtensionsKt.makeVisible(this.suffixContainer);
        this.isShowSuffix = true;
    }

    public final void hideSuffixView() {
        ViewExtensionsKt.makeGone(this.suffixContainer);
        this.isShowSuffix = false;
    }

    public final void showDivider() {
        ViewExtensionsKt.makeVisible(this.divider);
        this.config.setShowDivider(true);
    }

    public final void hideDivider() {
        ViewExtensionsKt.makeGone(this.divider);
        this.config.setShowDivider(false);
    }

    public final void showActionText() {
        ViewExtensionsKt.makeVisible(this.tvAction);
        this.isShowActionText = true;
    }

    public final void hideActionText() {
        ViewExtensionsKt.makeGone(this.tvAction);
        this.isShowActionText = false;
    }

    public final void setEditTextOnFocusChangeListener(View.OnFocusChangeListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.editText.setOnFocusChangeListener(r2);
    }

    public final void editTextOnFocusChangeListener(final Function2<? super View, ? super Boolean, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "handler");
        setEditTextOnFocusChangeListener(new AnonymousClass1(r2));
    }

    @Override // com.obric.oui.forms.AbsOForm
    public EditText getInterEditText() {
        return this.editText;
    }

    public final void setTextExceedLengthListener(TextExceedLengthListener r2) {
        Intrinsics.checkNotNullParameter(r2, "textExceedLengthListener");
        this.config.setTextExceedLengthListener(r2);
    }

    public final void onTextExceedLengthListener(final Function1<? super String, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "handler");
        this.config.setTextExceedLengthListener(new C02751(r2));
    }

    public final void setTextClearedListener(TextClearedListener r2) {
        Intrinsics.checkNotNullParameter(r2, "textClearedListener");
        this.config.setTextClearedListener(r2);
    }

    public final void setTextWatcher(TextWatcher r2) {
        this.config.setTextWatcher(r2);
        refreshConfig();
    }
}
