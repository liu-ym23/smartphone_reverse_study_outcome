package com.obric.oui.forms;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.bytedanceos.security.invokeHistory.InvokeHistoryActivity;
import com.obric.common.oui.R;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.common.util.ViewExtensionsKt;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import obric.widget.ChipsView;

/* JADX INFO: compiled from: OBoxInputView.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 K2\u00020\u0001:\u0002KLB/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\b\u00102\u001a\u000203H\u0002J\b\u00104\u001a\u000203H\u0002J\u0006\u00105\u001a\u00020\u0010J\b\u00106\u001a\u000207H\u0016J\u0006\u00108\u001a\u00020$J\u0006\u00109\u001a\u000203J\u0006\u0010:\u001a\u000203J\b\u0010;\u001a\u000203H\u0002J\u0006\u0010<\u001a\u000203J\u0006\u0010=\u001a\u000203J\u0010\u0010>\u001a\u0002032\u0006\u0010?\u001a\u00020@H\u0002J\u0010\u0010A\u001a\u0002032\b\u0010#\u001a\u0004\u0018\u00010$J\u000e\u0010B\u001a\u0002032\u0006\u0010C\u001a\u00020\u0012J\u000e\u0010D\u001a\u0002032\u0006\u0010E\u001a\u00020$J\u0006\u0010F\u001a\u000203J\b\u0010G\u001a\u000203H\u0002J\u0006\u0010H\u001a\u000203J\u0006\u0010I\u001a\u000203J\u000e\u0010J\u001a\u0002032\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\n\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001aR\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010&\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001a\"\u0004\b(\u0010)R\u0011\u0010*\u001a\u00020+¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010.\u001a\u00020+¢\u0006\b\n\u0000\u001a\u0004\b/\u0010-R\u0011\u00100\u001a\u00020+¢\u0006\b\n\u0000\u001a\u0004\b1\u0010-¨\u0006M"}, d2 = {"Lcom/obric/oui/forms/OBoxInputView;", "Lcom/obric/oui/forms/AbsOForm;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "arrangeDirection", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "DEFAULT_MAX_LINES", "getArrangeDirection", "()I", "setArrangeDirection", "(I)V", "config", "Lcom/obric/oui/forms/OBoxInputView$Config;", "counterTextWatcher", "Landroid/text/TextWatcher;", "editText", "Landroidx/appcompat/widget/AppCompatEditText;", "getEditText", "()Landroidx/appcompat/widget/AppCompatEditText;", "inputContainer", "Landroid/view/ViewGroup;", "getInputContainer", "()Landroid/view/ViewGroup;", "ivTitleIcon", "Landroid/widget/ImageView;", "getIvTitleIcon", "()Landroid/widget/ImageView;", "prefixContainer", "getPrefixContainer", "showTitleDefaultIcon", "", "text", "", "textGravity", "titleContainer", "getTitleContainer", "setTitleContainer", "(Landroid/view/ViewGroup;)V", "tvCounter", "Landroid/widget/TextView;", "getTvCounter", "()Landroid/widget/TextView;", "tvErrorTips", "getTvErrorTips", "tvTitle", "getTvTitle", "adjustHeight", "", "clear", "getConfig", "getInterEditText", "Landroid/widget/EditText;", "getText", "hideErrorTips", "hidePrefixView", "hideSoftInput", "hideTitle", "hideTitleIcon", "setPrefixView", "view", "Landroid/view/View;", "setText", "setTextWatcher", "textWatcher", "showErrorTips", "tips", "showPrefixView", "showSoftInput", "showTitle", "showTitleIcon", "updateConfig", "Companion", "Config", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OBoxInputView extends AbsOForm {
    public static final int ARRANGE_DIRECTION_HORIZONTAL = 1;
    public static final int ARRANGE_DIRECTION_VERTICAL = 0;
    public static final Companion Companion = null;
    private static final int DEFAULT_INPUT_BOX_HEIGHT_DP = 0;
    private static final int DEFAULT_LINES = 6;
    private final int DEFAULT_MAX_LINES;
    private int arrangeDirection;
    private Config config;
    private TextWatcher counterTextWatcher;
    private final AppCompatEditText editText;
    private final ViewGroup inputContainer;
    private final ImageView ivTitleIcon;
    private final ViewGroup prefixContainer;
    private boolean showTitleDefaultIcon;
    private String text;
    private int textGravity;
    private ViewGroup titleContainer;
    private final TextView tvCounter;
    private final TextView tvErrorTips;
    private final TextView tvTitle;

    /* JADX INFO: compiled from: OBoxInputView.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/oui/forms/OBoxInputView$Companion;", "", "()V", "ARRANGE_DIRECTION_HORIZONTAL", "", "ARRANGE_DIRECTION_VERTICAL", "DEFAULT_INPUT_BOX_HEIGHT_DP", "DEFAULT_LINES", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: OBoxInputView.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b0\u0018\u00002\u00020\u0001:\u0001AB\u0081\u0001\b\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010\u0013J\u000e\u00109\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0003J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010:\u001a\u00020\u0005J\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010;\u001a\u00020\bJ\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010;\u001a\u00020\bJ\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010<\u001a\u00020\u0012J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010=\u001a\u00020\bJ\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010>\u001a\u00020\u000bJ\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010?\u001a\u00020\u0003J\u000e\u0010\u0002\u001a\u00020\u00002\u0006\u0010?\u001a\u00020\u0003J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010@\u001a\u00020\rJ\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010:\u001a\u00020\u0005R\u001a\u0010\u0010\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u000e\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010\u000f\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001d\"\u0004\b!\u0010\u001fR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010*\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0015\"\u0004\b0\u0010\u0017R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0015\"\u0004\b2\u0010\u0017R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0019\"\u0004\b8\u0010\u001b¨\u0006B"}, d2 = {"Lcom/obric/oui/forms/OBoxInputView$Config;", "", "showTitle", "", "title", "", "showCounter", "lengthLimit", "", "hintText", "prefixView", "Landroid/view/View;", "textWatcher", "Landroid/text/TextWatcher;", "inputBoxHeight", "inputBoxMaxHeight", "autoAdjustHeight", "ivTitleIcon", "Landroid/graphics/drawable/Drawable;", "(ZLjava/lang/String;ZLjava/lang/Integer;Ljava/lang/String;Landroid/view/View;Landroid/text/TextWatcher;IIZLandroid/graphics/drawable/Drawable;)V", "getAutoAdjustHeight", "()Z", "setAutoAdjustHeight", "(Z)V", "getHintText", "()Ljava/lang/String;", "setHintText", "(Ljava/lang/String;)V", "getInputBoxHeight", "()I", "setInputBoxHeight", "(I)V", "getInputBoxMaxHeight", "setInputBoxMaxHeight", "getIvTitleIcon", "()Landroid/graphics/drawable/Drawable;", "setIvTitleIcon", "(Landroid/graphics/drawable/Drawable;)V", "getLengthLimit", "()Ljava/lang/Integer;", "setLengthLimit", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getPrefixView", "()Landroid/view/View;", "setPrefixView", "(Landroid/view/View;)V", "getShowCounter", "setShowCounter", "getShowTitle", "setShowTitle", "getTextWatcher", "()Landroid/text/TextWatcher;", "setTextWatcher", "(Landroid/text/TextWatcher;)V", "getTitle", "setTitle", "enableAdjustHeight", "str", "h", "drawable", "len", "view", InvokeHistoryActivity.PREF_SHOW, "watcher", "Builder", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Config {
        private boolean autoAdjustHeight;
        private String hintText;
        private int inputBoxHeight;
        private int inputBoxMaxHeight;
        private Drawable ivTitleIcon;
        private Integer lengthLimit;
        private View prefixView;
        private boolean showCounter;
        private boolean showTitle;
        private TextWatcher textWatcher;
        private String title;

        /* JADX INFO: compiled from: OBoxInputView.kt */
        @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0018\u0002\n\u0002\b\u001a\b\u0086\b\u0018\u00002\u00020\u0001B\u007f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010\u0013J\u0006\u00109\u001a\u00020:J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\u0010\u0010@\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010'J\u000b\u0010A\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\rHÆ\u0003J\t\u0010D\u001a\u00020\bHÆ\u0003J\t\u0010E\u001a\u00020\bHÆ\u0003J\u0088\u0001\u0010F\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÆ\u0001¢\u0006\u0002\u0010GJ\u000e\u0010H\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0003J\u0013\u0010I\u001a\u00020\u00032\b\u0010J\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010K\u001a\u00020\bHÖ\u0001J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010L\u001a\u00020\u0005J\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010M\u001a\u00020\bJ\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010M\u001a\u00020\bJ\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010N\u001a\u00020\u0012J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010O\u001a\u00020\bJ\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010P\u001a\u00020\u000bJ\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010Q\u001a\u00020\u0003J\u000e\u0010\u0002\u001a\u00020\u00002\u0006\u0010Q\u001a\u00020\u0003J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010R\u001a\u00020\rJ\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010L\u001a\u00020\u0005J\t\u0010S\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0010\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u000e\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010\u000f\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001d\"\u0004\b!\u0010\u001fR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010*\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0015\"\u0004\b0\u0010\u0017R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0015\"\u0004\b2\u0010\u0017R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0019\"\u0004\b8\u0010\u001b¨\u0006T"}, d2 = {"Lcom/obric/oui/forms/OBoxInputView$Config$Builder;", "", "showTitle", "", "title", "", "showCounter", "lengthLimit", "", "hintText", "prefixView", "Landroid/view/View;", "textWatcher", "Landroid/text/TextWatcher;", "inputBoxHeight", "inputBoxMaxHeight", "autoAdjustHeight", "ivTitleIcon", "Landroid/graphics/drawable/Drawable;", "(ZLjava/lang/String;ZLjava/lang/Integer;Ljava/lang/String;Landroid/view/View;Landroid/text/TextWatcher;IIZLandroid/graphics/drawable/Drawable;)V", "getAutoAdjustHeight", "()Z", "setAutoAdjustHeight", "(Z)V", "getHintText", "()Ljava/lang/String;", "setHintText", "(Ljava/lang/String;)V", "getInputBoxHeight", "()I", "setInputBoxHeight", "(I)V", "getInputBoxMaxHeight", "setInputBoxMaxHeight", "getIvTitleIcon", "()Landroid/graphics/drawable/Drawable;", "setIvTitleIcon", "(Landroid/graphics/drawable/Drawable;)V", "getLengthLimit", "()Ljava/lang/Integer;", "setLengthLimit", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getPrefixView", "()Landroid/view/View;", "setPrefixView", "(Landroid/view/View;)V", "getShowCounter", "setShowCounter", "getShowTitle", "setShowTitle", "getTextWatcher", "()Landroid/text/TextWatcher;", "setTextWatcher", "(Landroid/text/TextWatcher;)V", "getTitle", "setTitle", "build", "Lcom/obric/oui/forms/OBoxInputView$Config;", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(ZLjava/lang/String;ZLjava/lang/Integer;Ljava/lang/String;Landroid/view/View;Landroid/text/TextWatcher;IIZLandroid/graphics/drawable/Drawable;)Lcom/obric/oui/forms/OBoxInputView$Config$Builder;", "enableAdjustHeight", "equals", "other", "hashCode", "str", "h", "drawable", "len", "view", InvokeHistoryActivity.PREF_SHOW, "watcher", "toString", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Builder {
            private boolean autoAdjustHeight;
            private String hintText;
            private int inputBoxHeight;
            private int inputBoxMaxHeight;
            private Drawable ivTitleIcon;
            private Integer lengthLimit;
            private View prefixView;
            private boolean showCounter;
            private boolean showTitle;
            private TextWatcher textWatcher;
            private String title;

            public Builder() {
                this(false, null, false, null, null, null, null, 0, 0, false, null, 2047, null);
            }

            public static /* synthetic */ Builder copy$default(Builder r12, boolean r13, String r14, boolean r15, Integer r16, String r17, View r18, TextWatcher r19, int r20, int r21, boolean r22, Drawable r23, int r24, Object r25) {
                if ((r24 & 1) == 0) goto L5;
                boolean r2 = r12.showTitle;
            L7:
                if ((r24 & 2) == 0) goto L9;
                String r3 = r12.title;
            L11:
                if ((r24 & 4) == 0) goto L13;
                boolean r4 = r12.showCounter;
            L15:
                if ((r24 & 8) == 0) goto L17;
                Integer r5 = r12.lengthLimit;
            L19:
                if ((r24 & 16) == 0) goto L21;
                String r6 = r12.hintText;
            L23:
                if ((r24 & 32) == 0) goto L25;
                View r7 = r12.prefixView;
            L27:
                if ((r24 & 64) == 0) goto L29;
                TextWatcher r8 = r12.textWatcher;
            L31:
                if ((r24 & 128) == 0) goto L33;
                int r9 = r12.inputBoxHeight;
            L35:
                if ((r24 & 256) == 0) goto L37;
                int r10 = r12.inputBoxMaxHeight;
            L39:
                if ((r24 & 512) == 0) goto L41;
                boolean r11 = r12.autoAdjustHeight;
            L43:
                if ((r24 & 1024) == 0) goto L45;
                Drawable r1 = r12.ivTitleIcon;
            L47:
                return r12.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r1);
            L45:
                r1 = r23;
                goto L47
            L41:
                r11 = r22;
                goto L43
            L37:
                r10 = r21;
                goto L39
            L33:
                r9 = r20;
                goto L35
            L29:
                r8 = r19;
                goto L31
            L25:
                r7 = r18;
                goto L27
            L21:
                r6 = r17;
                goto L23
            L17:
                r5 = r16;
                goto L19
            L13:
                r4 = r15;
                goto L15
            L9:
                r3 = r14;
                goto L11
            L5:
                r2 = r13;
                goto L7
            }

            public final boolean component1() {
                return this.showTitle;
            }

            public final boolean component10() {
                return this.autoAdjustHeight;
            }

            public final Drawable component11() {
                return this.ivTitleIcon;
            }

            public final String component2() {
                return this.title;
            }

            public final boolean component3() {
                return this.showCounter;
            }

            public final Integer component4() {
                return this.lengthLimit;
            }

            public final String component5() {
                return this.hintText;
            }

            public final View component6() {
                return this.prefixView;
            }

            public final TextWatcher component7() {
                return this.textWatcher;
            }

            public final int component8() {
                return this.inputBoxHeight;
            }

            public final int component9() {
                return this.inputBoxMaxHeight;
            }

            public final Builder copy(boolean r14, String r15, boolean r16, Integer r17, String r18, View r19, TextWatcher r20, int r21, int r22, boolean r23, Drawable r24) {
                return new Builder(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24);
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if ((r5 instanceof Builder) == true) goto L8;
                return false;
            L8:
                Builder r6 = (Builder) r5;
                if (this.showTitle == r6.showTitle) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.title, r6.title) == true) goto L15;
                return false;
            L15:
                if (this.showCounter == r6.showCounter) goto L18;
                return false;
            L18:
                if (Intrinsics.areEqual(this.lengthLimit, r6.lengthLimit) == true) goto L21;
                return false;
            L21:
                if (Intrinsics.areEqual(this.hintText, r6.hintText) == true) goto L24;
                return false;
            L24:
                if (Intrinsics.areEqual(this.prefixView, r6.prefixView) == true) goto L27;
                return false;
            L27:
                if (Intrinsics.areEqual(this.textWatcher, r6.textWatcher) == true) goto L30;
                return false;
            L30:
                if (this.inputBoxHeight == r6.inputBoxHeight) goto L33;
                return false;
            L33:
                if (this.inputBoxMaxHeight == r6.inputBoxMaxHeight) goto L36;
                return false;
            L36:
                if (this.autoAdjustHeight == r6.autoAdjustHeight) goto L39;
                return false;
            L39:
                if (Intrinsics.areEqual(this.ivTitleIcon, r6.ivTitleIcon) == true) goto L41;
                return false;
            L41:
                return true;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v1, types: [int] */
            /* JADX WARN: Type inference failed for: r0v22 */
            /* JADX WARN: Type inference failed for: r0v23 */
            /* JADX WARN: Type inference failed for: r0v5, types: [int] */
            /* JADX WARN: Type inference failed for: r1v0 */
            /* JADX WARN: Type inference failed for: r1v1, types: [int] */
            /* JADX WARN: Type inference failed for: r1v2 */
            /* JADX WARN: Type inference failed for: r2v26 */
            /* JADX WARN: Type inference failed for: r2v28 */
            /* JADX WARN: Type inference failed for: r2v4, types: [int] */
            public int hashCode() {
                boolean r0 = this.showTitle;
                ?? r1 = 1;
                ?? r2 = r0;
                if (r0 == false) goto L5;
                r2 = 1;
            L5:
                int r3 = r2 * 31;
                String r4 = this.title;
                int r5 = 0;
                if (r4 != null) goto L8;
                int r6 = 0;
            L9:
                int r7 = (r3 + r6) * 31;
                boolean r8 = this.showCounter;
                ?? r9 = r8;
                if (r8 == false) goto L12;
                r9 = 1;
            L12:
                int r10 = (r7 + r9) * 31;
                Integer r11 = this.lengthLimit;
                if (r11 != null) goto L15;
                int r12 = 0;
            L16:
                int r13 = (r10 + r12) * 31;
                String r14 = this.hintText;
                if (r14 != null) goto L19;
                int r15 = 0;
            L20:
                int r16 = (r13 + r15) * 31;
                View r17 = this.prefixView;
                if (r17 != null) goto L23;
                int r18 = 0;
            L24:
                int r19 = (r16 + r18) * 31;
                TextWatcher r20 = this.textWatcher;
                if (r20 != null) goto L27;
                int r21 = 0;
            L28:
                int r22 = (((((r19 + r21) * 31) + Integer.hashCode(this.inputBoxHeight)) * 31) + Integer.hashCode(this.inputBoxMaxHeight)) * 31;
                boolean r23 = this.autoAdjustHeight;
                if (r23 == true) goto L32;
                r1 = r23;
            L32:
                int r24 = (r22 + r1) * 31;
                Drawable r25 = this.ivTitleIcon;
                if (r25 == null) goto L37;
                r5 = r25.hashCode();
            L37:
                return r24 + r5;
            L27:
                r21 = r20.hashCode();
                goto L28
            L23:
                r18 = r17.hashCode();
                goto L24
            L19:
                r15 = r14.hashCode();
                goto L20
            L15:
                r12 = r11.hashCode();
                goto L16
            L8:
                r6 = r4.hashCode();
                goto L9
            }

            public String toString() {
                StringBuilder r0 = new StringBuilder("Builder(showTitle=");
                r0.append(this.showTitle).append(", title=").append(this.title).append(", showCounter=").append(this.showCounter).append(", lengthLimit=").append(this.lengthLimit).append(", hintText=").append(this.hintText).append(", prefixView=").append(this.prefixView).append(", textWatcher=").append(this.textWatcher).append(", inputBoxHeight=").append(this.inputBoxHeight).append(", inputBoxMaxHeight=").append(this.inputBoxMaxHeight).append(", autoAdjustHeight=").append(this.autoAdjustHeight).append(", ivTitleIcon=").append(this.ivTitleIcon).append(')');
                return r0.toString();
            }

            public Builder(boolean r1, String r2, boolean r3, Integer r4, String r5, View r6, TextWatcher r7, int r8, int r9, boolean r10, Drawable r11) {
                this.showTitle = r1;
                this.title = r2;
                this.showCounter = r3;
                this.lengthLimit = r4;
                this.hintText = r5;
                this.prefixView = r6;
                this.textWatcher = r7;
                this.inputBoxHeight = r8;
                this.inputBoxMaxHeight = r9;
                this.autoAdjustHeight = r10;
                this.ivTitleIcon = r11;
            }

            public final boolean getShowTitle() {
                return this.showTitle;
            }

            public final void setShowTitle(boolean r1) {
                this.showTitle = r1;
            }

            public final String getTitle() {
                return this.title;
            }

            public final void setTitle(String r1) {
                this.title = r1;
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

            public final String getHintText() {
                return this.hintText;
            }

            public final void setHintText(String r1) {
                this.hintText = r1;
            }

            public final View getPrefixView() {
                return this.prefixView;
            }

            public final void setPrefixView(View r1) {
                this.prefixView = r1;
            }

            public final TextWatcher getTextWatcher() {
                return this.textWatcher;
            }

            public final void setTextWatcher(TextWatcher r1) {
                this.textWatcher = r1;
            }

            public /* synthetic */ Builder(boolean r3, String r4, boolean r5, Integer r6, String r7, View r8, TextWatcher r9, int r10, int r11, boolean r12, Drawable r13, int r14, DefaultConstructorMarker r15) {
                if ((r14 & 1) == 0) goto L6;
                r3 = false;
            L6:
                if ((r14 & 2) == 0) goto L9;
                r4 = null;
            L9:
                if ((r14 & 4) == 0) goto L12;
                r5 = false;
            L12:
                if ((r14 & 8) == 0) goto L15;
                r6 = null;
            L15:
                if ((r14 & 16) == 0) goto L18;
                r7 = null;
            L18:
                if ((r14 & 32) == 0) goto L21;
                r8 = null;
            L21:
                if ((r14 & 64) == 0) goto L24;
                r9 = null;
            L24:
                if ((r14 & 128) == 0) goto L27;
                r10 = OBoxInputView.access$getDEFAULT_INPUT_BOX_HEIGHT_DP$cp();
            L27:
                if ((r14 & 256) == 0) goto L30;
                r11 = Integer.MAX_VALUE;
            L30:
                if ((r14 & 512) == 0) goto L33;
                r12 = false;
            L33:
                if ((r14 & 1024) == 0) goto L35;
                r13 = null;
            L35:
                this(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
            }

            public final int getInputBoxHeight() {
                return this.inputBoxHeight;
            }

            public final void setInputBoxHeight(int r1) {
                this.inputBoxHeight = r1;
            }

            public final int getInputBoxMaxHeight() {
                return this.inputBoxMaxHeight;
            }

            public final void setInputBoxMaxHeight(int r1) {
                this.inputBoxMaxHeight = r1;
            }

            public final boolean getAutoAdjustHeight() {
                return this.autoAdjustHeight;
            }

            public final void setAutoAdjustHeight(boolean r1) {
                this.autoAdjustHeight = r1;
            }

            public final Drawable getIvTitleIcon() {
                return this.ivTitleIcon;
            }

            public final void setIvTitleIcon(Drawable r1) {
                this.ivTitleIcon = r1;
            }

            public final Builder showTitle(boolean r2) {
                setShowTitle(r2);
                return this;
            }

            public final Builder title(String r2) {
                Intrinsics.checkNotNullParameter(r2, "str");
                setTitle(r2);
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

            public final Builder hintText(String r2) {
                Intrinsics.checkNotNullParameter(r2, "str");
                setHintText(r2);
                return this;
            }

            public final Builder prefixView(View r2) {
                Intrinsics.checkNotNullParameter(r2, "view");
                setPrefixView(r2);
                return this;
            }

            public final Builder textWatcher(TextWatcher r2) {
                Intrinsics.checkNotNullParameter(r2, "watcher");
                setTextWatcher(r2);
                return this;
            }

            public final Builder inputBoxHeight(int r2) {
                setInputBoxHeight(r2);
                return this;
            }

            public final Builder inputBoxMaxHeight(int r2) {
                setInputBoxMaxHeight(r2);
                return this;
            }

            public final Builder enableAdjustHeight(boolean r2) {
                setAutoAdjustHeight(r2);
                return this;
            }

            public final Builder ivTitleIcon(Drawable r2) {
                Intrinsics.checkNotNullParameter(r2, "drawable");
                setIvTitleIcon(r2);
                return this;
            }

            public final Config build() {
                boolean r1 = this.showTitle;
                String r2 = this.title;
                boolean r3 = this.showCounter;
                String r5 = this.hintText;
                Integer r4 = this.lengthLimit;
                TextWatcher r7 = this.textWatcher;
                return new Config(r1, r2, r3, r4, r5, this.prefixView, r7, this.inputBoxHeight, this.inputBoxMaxHeight, this.autoAdjustHeight, this.ivTitleIcon, null);
            }
        }

        public /* synthetic */ Config(boolean r1, String r2, boolean r3, Integer r4, String r5, View r6, TextWatcher r7, int r8, int r9, boolean r10, Drawable r11, DefaultConstructorMarker r12) {
            this(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
        }

        private Config(boolean r1, String r2, boolean r3, Integer r4, String r5, View r6, TextWatcher r7, int r8, int r9, boolean r10, Drawable r11) {
            this.showTitle = r1;
            this.title = r2;
            this.showCounter = r3;
            this.lengthLimit = r4;
            this.hintText = r5;
            this.prefixView = r6;
            this.textWatcher = r7;
            this.inputBoxHeight = r8;
            this.inputBoxMaxHeight = r9;
            this.autoAdjustHeight = r10;
            this.ivTitleIcon = r11;
        }

        public final boolean getShowTitle() {
            return this.showTitle;
        }

        public final void setShowTitle(boolean r1) {
            this.showTitle = r1;
        }

        public final String getTitle() {
            return this.title;
        }

        public final void setTitle(String r1) {
            this.title = r1;
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

        public final String getHintText() {
            return this.hintText;
        }

        public final void setHintText(String r1) {
            this.hintText = r1;
        }

        public final View getPrefixView() {
            return this.prefixView;
        }

        public final void setPrefixView(View r1) {
            this.prefixView = r1;
        }

        public final TextWatcher getTextWatcher() {
            return this.textWatcher;
        }

        public final void setTextWatcher(TextWatcher r1) {
            this.textWatcher = r1;
        }

        /* synthetic */ Config(boolean r3, String r4, boolean r5, Integer r6, String r7, View r8, TextWatcher r9, int r10, int r11, boolean r12, Drawable r13, int r14, DefaultConstructorMarker r15) {
            if ((r14 & 1) == 0) goto L6;
            r3 = false;
        L6:
            if ((r14 & 2) == 0) goto L9;
            r4 = null;
        L9:
            if ((r14 & 4) == 0) goto L12;
            r5 = false;
        L12:
            if ((r14 & 8) == 0) goto L15;
            r6 = null;
        L15:
            if ((r14 & 16) == 0) goto L18;
            r7 = null;
        L18:
            if ((r14 & 32) == 0) goto L21;
            r8 = null;
        L21:
            if ((r14 & 64) == 0) goto L24;
            r9 = null;
        L24:
            if ((r14 & 128) == 0) goto L27;
            r10 = OBoxInputView.access$getDEFAULT_INPUT_BOX_HEIGHT_DP$cp();
        L27:
            if ((r14 & 256) == 0) goto L30;
            r11 = Integer.MAX_VALUE;
        L30:
            if ((r14 & 512) == 0) goto L33;
            r12 = false;
        L33:
            if ((r14 & 1024) == 0) goto L35;
            r13 = null;
        L35:
            this(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
        }

        public final int getInputBoxHeight() {
            return this.inputBoxHeight;
        }

        public final void setInputBoxHeight(int r1) {
            this.inputBoxHeight = r1;
        }

        public final int getInputBoxMaxHeight() {
            return this.inputBoxMaxHeight;
        }

        public final void setInputBoxMaxHeight(int r1) {
            this.inputBoxMaxHeight = r1;
        }

        public final boolean getAutoAdjustHeight() {
            return this.autoAdjustHeight;
        }

        public final void setAutoAdjustHeight(boolean r1) {
            this.autoAdjustHeight = r1;
        }

        public final Drawable getIvTitleIcon() {
            return this.ivTitleIcon;
        }

        public final void setIvTitleIcon(Drawable r1) {
            this.ivTitleIcon = r1;
        }

        public final Config showTitle(boolean r2) {
            setShowTitle(r2);
            return this;
        }

        public final Config title(String r2) {
            Intrinsics.checkNotNullParameter(r2, "str");
            setTitle(r2);
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

        public final Config hintText(String r2) {
            Intrinsics.checkNotNullParameter(r2, "str");
            setHintText(r2);
            return this;
        }

        public final Config prefixView(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            setPrefixView(r2);
            return this;
        }

        public final Config textWatcher(TextWatcher r2) {
            Intrinsics.checkNotNullParameter(r2, "watcher");
            setTextWatcher(r2);
            return this;
        }

        public final Config inputBoxHeight(int r2) {
            setInputBoxHeight(r2);
            return this;
        }

        public final Config inputBoxMaxHeight(int r2) {
            setInputBoxMaxHeight(r2);
            return this;
        }

        public final Config enableAdjustHeight(boolean r2) {
            setAutoAdjustHeight(r2);
            return this;
        }

        public final Config ivTitleIcon(Drawable r2) {
            Intrinsics.checkNotNullParameter(r2, "drawable");
            setIvTitleIcon(r2);
            return this;
        }
    }

    /* JADX INFO: renamed from: com.obric.oui.forms.OBoxInputView$updateConfig$1, reason: invalid class name */
    /* JADX INFO: compiled from: OBoxInputView.kt */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J(\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J(\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000e"}, d2 = {"com/obric/oui/forms/OBoxInputView$updateConfig$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class AnonymousClass1 implements TextWatcher {
        final /* synthetic */ OBoxInputView this$0;

        public static /* synthetic */ void $r8$lambda$ECDYGpM9aC33mj5cjXdkKAP8RzQ(OBoxInputView r0) {
            m334afterTextChanged$lambda0(r0);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
            Intrinsics.checkNotNullParameter(r1, "s");
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
            Intrinsics.checkNotNullParameter(r1, "s");
        }

        AnonymousClass1(OBoxInputView r1) {
            this.this$0 = r1;
        }

        /* JADX INFO: renamed from: afterTextChanged$lambda-0, reason: not valid java name */
        private static final void m334afterTextChanged$lambda0(OBoxInputView r1) {
            Intrinsics.checkNotNullParameter(r1, "this$0");
            OBoxInputView.access$adjustHeight(r1);
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable r2) {
            Intrinsics.checkNotNullParameter(r2, "s");
            AppCompatEditText r3 = this.this$0.getEditText();
            final OBoxInputView r1 = this.this$0;
            r3.post(new OBoxInputView$updateConfig$1$$ExternalSyntheticLambda0(r1));
        }
    }

    /* JADX INFO: renamed from: com.obric.oui.forms.OBoxInputView$updateConfig$2, reason: invalid class name */
    /* JADX INFO: compiled from: OBoxInputView.kt */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J*\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000e"}, d2 = {"com/obric/oui/forms/OBoxInputView$updateConfig$2", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class AnonymousClass2 implements TextWatcher {
        final /* synthetic */ Config $config;
        final /* synthetic */ OBoxInputView this$0;

        public static /* synthetic */ void $r8$lambda$fv4rXAuycy9L5ISJFl5w_lV7Tyk(OBoxInputView r0) {
            m335afterTextChanged$lambda0(r0);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        AnonymousClass2(Config r1, OBoxInputView r2) {
            this.$config = r1;
            this.this$0 = r2;
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence r4, int r5, int r6, int r7) {
            if (this.$config.getLengthLimit() == null) goto L24;
            Resources r8 = this.this$0.getResources();
            int r9 = R.string.oui_form_counter;
            Object[] r10 = new Object[2];
            if (r4 != null) goto L7;
            String r0 = null;
        L8:
            r10[0] = r0;
            r10[1] = String.valueOf(this.$config.getLengthLimit());
            String r11 = r8.getString(r9, r10);
            Intrinsics.checkNotNullExpressionValue(r11, "resources.getString(\n   …                        )");
            SpannableString r12 = new SpannableString(r11);
            if (r4 != null) goto L11;
            int r13 = 0;
        L12:
            Integer r14 = this.$config.getLengthLimit();
            Intrinsics.checkNotNull(r14);
            if (r13 <= r14.intValue()) goto L22;
            ForegroundColorSpan r15 = new ForegroundColorSpan(ContextCompat.getColor(this.this$0.getContext(), R.color.Primary));
            if (r4 != null) goto L17;
        L16:
            int r16 = 0;
        L21:
            r12.setSpan(r15, 0, r16, 18);
            goto L22
        L17:
            String r17 = Integer.valueOf(r4.length()).toString();
            if (r17 == null) goto L16;
            r16 = r17.length();
        L22:
            this.this$0.getTvCounter().setText(r12, TextView.BufferType.SPANNABLE);
            return;
        L11:
            r13 = Integer.valueOf(r4.length()).intValue();
            goto L12
        L7:
            r0 = Integer.valueOf(r4.length()).toString();
            goto L8
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable r2) {
            if (this.$config.getAutoAdjustHeight() == false) goto L6;
            AppCompatEditText r3 = this.this$0.getEditText();
            final OBoxInputView r1 = this.this$0;
            r3.post(new OBoxInputView$updateConfig$2$$ExternalSyntheticLambda0(r1));
            return;
        }

        /* JADX INFO: renamed from: afterTextChanged$lambda-0, reason: not valid java name */
        private static final void m335afterTextChanged$lambda0(OBoxInputView r1) {
            Intrinsics.checkNotNullParameter(r1, "this$0");
            OBoxInputView.access$adjustHeight(r1);
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$e6-T8ItmLzs2AXx2sVyao7yHD5o, reason: not valid java name */
    public static /* synthetic */ void m332$r8$lambda$e6T8ItmLzs2AXx2sVyao7yHD5o(OBoxInputView r0, View r1, boolean r2) {
        m333_init_$lambda1(r0, r1, r2);
    }

    public OBoxInputView(Context r9) {
        Intrinsics.checkNotNullParameter(r9, "context");
        this(r9, null, 0, 0, 14, null);
    }

    public OBoxInputView(Context r9, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r9, "context");
        this(r9, r10, 0, 0, 12, null);
    }

    public OBoxInputView(Context r9, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r9, "context");
        this(r9, r10, r11, 0, 8, null);
    }

    public /* synthetic */ OBoxInputView(Context r1, AttributeSet r2, int r3, int r4, int r5, DefaultConstructorMarker r6) {
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

    public static final /* synthetic */ void access$adjustHeight(OBoxInputView r0) {
        r0.adjustHeight();
    }

    public static final /* synthetic */ int access$getDEFAULT_INPUT_BOX_HEIGHT_DP$cp() {
        return DEFAULT_INPUT_BOX_HEIGHT_DP;
    }

    public final int getArrangeDirection() {
        return this.arrangeDirection;
    }

    public final void setArrangeDirection(int r1) {
        this.arrangeDirection = r1;
    }

    public OBoxInputView(Context r18, AttributeSet r19, int r20, int r21) {
        Intrinsics.checkNotNullParameter(r18, "context");
        super(r18, r19, r20);
        this.arrangeDirection = r21;
        this.config = new Config.Builder(false, null, false, null, null, null, null, 0, 0, false, null, 2047, null).build();
        this.textGravity = 48;
        this.DEFAULT_MAX_LINES = 20;
        TypedArray r4 = r18.getTheme().obtainStyledAttributes(r19, R.styleable.OBoxInputView, 0, 0);
        setArrangeDirection(r4.getInt(R.styleable.OBoxInputView_oui_formArrangeDirection, 1));     // Catch: Throwable -> L23
        this.config.setHintText(r4.getString(R.styleable.OBoxInputView_android_hint));     // Catch: Throwable -> L23
        this.config.setShowCounter(r4.getBoolean(R.styleable.OBoxInputView_oui_formShowCounter, false));     // Catch: Throwable -> L23
        int r5 = r4.getInt(R.styleable.OBoxInputView_oui_formLengthLimit, 0);     // Catch: Throwable -> L23
        if (r5 <= 0) goto L6;
        this.config.setLengthLimit(Integer.valueOf(r5));     // Catch: Throwable -> L23
    L6:
        String r6 = r4.getString(R.styleable.OBoxInputView_oui_formTitle);     // Catch: Throwable -> L23
        String r8 = r6;     // Catch: Throwable -> L23
        if (r8 != null) goto L9;
    L12:
        boolean r9 = true;
    L13:
        if (r9 == true) goto L15;
        this.config.setTitle(r6);     // Catch: Throwable -> L23
        this.config.setShowTitle(true);     // Catch: Throwable -> L23
    L16:
        this.config.setInputBoxHeight(r4.getDimensionPixelSize(R.styleable.OBoxInputView_oui_formInputHeight, OUnitExtensionKt.cdp(r18, DEFAULT_INPUT_BOX_HEIGHT_DP)));     // Catch: Throwable -> L23
        this.config.setInputBoxMaxHeight(r4.getDimensionPixelSize(R.styleable.OBoxInputView_oui_formInputMaxHeight, Integer.MAX_VALUE));     // Catch: Throwable -> L23
        this.text = r4.getString(R.styleable.OBoxInputView_android_text);     // Catch: Throwable -> L23
        this.showTitleDefaultIcon = r4.getBoolean(R.styleable.OBoxInputView_oui_formShowTitleDefaultIcon, false);     // Catch: Throwable -> L23
        this.config.setAutoAdjustHeight(r4.getBoolean(R.styleable.OBoxInputView_oui_formAutoAdjustHeight, false));     // Catch: Throwable -> L23
        this.textGravity = r4.getInt(R.styleable.OBoxInputView_android_gravity, 48);     // Catch: Throwable -> L23
        r4.recycle();
        if (this.arrangeDirection != 1) goto L20;
        int r2 = R.layout.o_form_box_horizontal;
    L21:
        LayoutInflater.from(r18).inflate(r2, this);
        View r1 = findViewById(R.id.tv_title);
        Intrinsics.checkNotNullExpressionValue(r1, "findViewById(R.id.tv_title)");
        this.tvTitle = (TextView) r1;
        View r3 = findViewById(R.id.iv_title_icon);
        Intrinsics.checkNotNullExpressionValue(r3, "findViewById(R.id.iv_title_icon)");
        this.ivTitleIcon = (ImageView) r3;
        View r7 = findViewById(R.id.prefix_container);
        Intrinsics.checkNotNullExpressionValue(r7, "findViewById(R.id.prefix_container)");
        this.prefixContainer = (ViewGroup) r7;
        View r10 = findViewById(R.id.edittext);
        Intrinsics.checkNotNullExpressionValue(r10, "findViewById(R.id.edittext)");
        AppCompatEditText r11 = (AppCompatEditText) r10;
        this.editText = r11;
        View r12 = findViewById(R.id.tv_counter);
        Intrinsics.checkNotNullExpressionValue(r12, "findViewById(R.id.tv_counter)");
        this.tvCounter = (TextView) r12;
        View r13 = findViewById(R.id.tv_error_tips);
        Intrinsics.checkNotNullExpressionValue(r13, "findViewById(R.id.tv_error_tips)");
        this.tvErrorTips = (TextView) r13;
        r11.setOnFocusChangeListener(new OBoxInputView$$ExternalSyntheticLambda0(this));
        View r14 = findViewById(R.id.input_container);
        Intrinsics.checkNotNullExpressionValue(r14, "findViewById(R.id.input_container)");
        this.inputContainer = (ViewGroup) r14;
        View r15 = findViewById(R.id.title_container);
        Intrinsics.checkNotNullExpressionValue(r15, "findViewById(R.id.title_container)");
        this.titleContainer = (ViewGroup) r15;
        updateConfig(this.config);
        r11.setLines(20);
        r11.setSingleLine(false);
        return;
    L20:
        r2 = R.layout.o_form_box_vertical;
        goto L21
    L15:
        this.config.setTitle("标题");     // Catch: Throwable -> L23
        goto L16
    L9:
        if (r8.length() == 0) goto L12;
        r9 = false;
    L23:
        th = move-exception;
        r4.recycle();
        throw th;
    }

    public final TextView getTvTitle() {
        return this.tvTitle;
    }

    public final AppCompatEditText getEditText() {
        return this.editText;
    }

    public final TextView getTvErrorTips() {
        return this.tvErrorTips;
    }

    public final TextView getTvCounter() {
        return this.tvCounter;
    }

    public final ImageView getIvTitleIcon() {
        return this.ivTitleIcon;
    }

    public final ViewGroup getInputContainer() {
        return this.inputContainer;
    }

    public final ViewGroup getPrefixContainer() {
        return this.prefixContainer;
    }

    public final ViewGroup getTitleContainer() {
        return this.titleContainer;
    }

    public final void setTitleContainer(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.titleContainer = r2;
    }

    static {
        Companion = new Companion(null);
        DEFAULT_INPUT_BOX_HEIGHT_DP = ChipsView.HISTORY;
    }

    /* JADX INFO: renamed from: _init_$lambda-1, reason: not valid java name */
    private static final void m333_init_$lambda1(OBoxInputView r0, View r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        if (r2 == false) goto L5;
        r0.showSoftInput();
        return;
    L5:
        r0.hideSoftInput();
    }

    private final void setPrefixView(View r3) {
        if (r3 == null) goto L5;
        this.prefixContainer.removeAllViews();
        this.prefixContainer.addView(r3, new ConstraintLayout.LayoutParams(-2, -2));
        return;
    }

    public final void showPrefixView() {
        ViewExtensionsKt.makeVisible(this.prefixContainer);
    }

    public final void hidePrefixView() {
        ViewExtensionsKt.makeGone(this.prefixContainer);
    }

    public final void updateConfig(Config r7) {
        Intrinsics.checkNotNullParameter(r7, "config");
        this.config = r7;
        String r0 = r7.getTitle();
        boolean r1 = true;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L12;
        this.tvTitle.setText(r7.getTitle());
    L12:
        if (r7.getShowTitle() == false) goto L14;
        showTitle();
    L16:
        if (r7.getPrefixView() == null) goto L19;
        View r3 = r7.getPrefixView();
        Intrinsics.checkNotNull(r3);
        setPrefixView(r3);
    L19:
        if (TextUtils.isEmpty(r7.getHintText()) == true) goto L22;
        this.editText.setHint(r7.getHintText());
    L22:
        if (r7.getAutoAdjustHeight() == false) goto L25;
        this.editText.addTextChangedListener(new AnonymousClass1(this));
    L25:
        if (r7.getShowCounter() == true) goto L27;
    L33:
        r7.getInputBoxHeight();
        if (r7.getInputBoxHeight() <= 0) goto L41;
        ViewGroup r4 = this.inputContainer;
        ViewGroup.LayoutParams r5 = r4.getLayoutParams();
        if (r5 == null) goto L39;
        ConstraintLayout.LayoutParams r6 = (ConstraintLayout.LayoutParams) r5;
        r6.height = r7.getInputBoxHeight();
        r4.setLayoutParams(r6);
        goto L41
    L39:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L41:
        if (r7.getTextWatcher() == null) goto L44;
        TextWatcher r8 = r7.getTextWatcher();
        Intrinsics.checkNotNull(r8);
        setTextWatcher(r8);
    L44:
        if (r7.getIvTitleIcon() == null) goto L47;
        this.ivTitleIcon.setImageDrawable(r7.getIvTitleIcon());
    L47:
        if (this.showTitleDefaultIcon == true) goto L49;
    L51:
        String r9 = this.text;
        if (r9 != null) goto L54;
    L57:
        if (r1 == true) goto L59;
        setText(this.text);
    L59:
        this.editText.setGravity(this.textGravity);
        return;
    L54:
        if (r9.length() == 0) goto L57;
        r1 = false;
        goto L57
    L49:
        if (r7.getIvTitleIcon() != null) goto L51;
        showTitleIcon();
        goto L51
    L27:
        if (r7.getLengthLimit() == null) goto L33;
        this.counterTextWatcher = new AnonymousClass2(r7, this);
        ArrayList<WeakReference<TextWatcher>> r10 = getTextWatchers();
        TextWatcher r11 = this.counterTextWatcher;
        Intrinsics.checkNotNull(r11);
        r10.add(new WeakReference(r11));
        this.editText.addTextChangedListener(this.counterTextWatcher);
        TextWatcher r12 = this.counterTextWatcher;
        if (r12 == null) goto L32;
        r12.onTextChanged(this.editText.getText(), 0, 0, 0);
    L32:
        ViewExtensionsKt.makeVisible(this.tvCounter);
        goto L33
    L14:
        hideTitle();
        goto L16
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r2 = false;
        goto L9
    }

    private final void adjustHeight() {
        int r0 = this.editText.getLineCount();
        int r1 = this.editText.getLineHeight();
        int r2 = this.editText.getHeight();
        int r3 = this.inputContainer.getHeight();
        int r4 = ((r0 * r1) + r3) - r2;
        if (r4 >= this.config.getInputBoxHeight()) goto L5;
    L8:
        ViewGroup.LayoutParams r5 = this.inputContainer.getLayoutParams();
        Intrinsics.checkNotNullExpressionValue(r5, "inputContainer.getLayoutParams()");
        r5.height = r3;
        this.inputContainer.setLayoutParams(r5);
        return;
    L5:
        if (r4 >= this.config.getInputBoxMaxHeight()) goto L8;
        r3 = r4;
        goto L8
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

    public final String getText() {
        return String.valueOf(this.editText.getText());
    }

    public final void setText(String r4) {
        String r0 = r4;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L15;
        this.editText.setText(r0);
        TextWatcher r3 = this.counterTextWatcher;
        if (r3 == null) goto L16;
        Intrinsics.checkNotNull(r4);
        r3.onTextChanged(r0, 0, 0, r4.length());
        return;
    L16:
        return;
    L15:
        return;
    L5:
        if (r0.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    public final void showTitleIcon() {
        if (this.titleContainer.getVisibility() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        ViewExtensionsKt.makeVisible(this.titleContainer);
    L8:
        ViewExtensionsKt.makeVisible(this.ivTitleIcon);
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
        return;
    L8:
        if (TextUtils.isEmpty(this.tvTitle.getText()) == true) goto L9;
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void showTitle() {
        ViewExtensionsKt.makeVisible(this.tvTitle);
        if (this.titleContainer.getVisibility() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        ViewExtensionsKt.makeVisible(this.titleContainer);
    L8:
        this.config.setShowTitle(true);
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
        this.config.setShowTitle(false);
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final Config getConfig() {
        return this.config;
    }

    private final void clear() {
        Iterator<WeakReference<TextWatcher>> r0 = getTextWatchers().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        WeakReference<TextWatcher> r1 = r0.next();
        this.editText.removeTextChangedListener(r1.get());
        goto L4
    }

    public final void setTextWatcher(TextWatcher r3) {
        Intrinsics.checkNotNullParameter(r3, "textWatcher");
        clear();
        getTextWatchers().add(new WeakReference(r3));
        this.editText.addTextChangedListener(r3);
    }

    public final void showErrorTips(String r2) {
        Intrinsics.checkNotNullParameter(r2, "tips");
        ViewExtensionsKt.makeVisible(this.tvErrorTips);
        this.tvErrorTips.setText(r2);
    }

    public final void hideErrorTips() {
        this.tvErrorTips.setText("");
        ViewExtensionsKt.makeGone(this.tvErrorTips);
    }

    @Override // com.obric.oui.forms.AbsOForm
    public EditText getInterEditText() {
        return this.editText;
    }
}
