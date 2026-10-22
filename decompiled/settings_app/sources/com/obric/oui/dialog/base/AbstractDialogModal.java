package com.obric.oui.dialog.base;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.icu.lang.UCharacter;
import android.security.bytedance.guard.BDSecurityGuardStub;
import android.util.Size;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.android.settings.search.IndexDatabaseHelper;
import com.obric.common.oui.R;
import com.obric.oui.animation.easy.ViewPropertySpringAnimator;
import com.obric.oui.color.OPalette;
import com.obric.oui.color.StrokeConfig;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.common.util.ViewExtensionsKt;
import com.obric.oui.dialog.anim.DialogAnimStyle;
import com.obric.oui.dialog.v2.alert.style.AlertDialogHost;
import com.obric.oui.material.MaterialConfig;
import com.obric.oui.material.MaterialToken;
import com.obric.oui.material.OMaterialExtBaseKt;
import com.obric.oui.material.OMaterialHelper;
import com.obric.oui.utils.ViewUtilKt;
import com.obric.oui.view.ViewCompat;
import com.obric.oui.view.WindowInsetsCompat;
import com.obric.oui.window.OWindowConfigController;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AbstractDialogModal.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0083\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\"*\u0001 \b&\u0018\u0000 \u0089\u00012\u00020\u00012\u00020\u0002:\u0006\u0087\u0001\u0088\u0001\u0089\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ-\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020\u00182\n\b\u0002\u0010U\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010V\u001a\u0004\u0018\u00010\u000bH\u0007¢\u0006\u0002\u0010WJ\u0010\u0010X\u001a\u00020S2\u0006\u0010Y\u001a\u00020ZH\u0002J\b\u0010[\u001a\u00020SH\u0016J\b\u0010\\\u001a\u00020SH\u0004J\b\u0010]\u001a\u00020SH\u0016J\u0012\u0010^\u001a\u00020S2\b\u0010_\u001a\u0004\u0018\u00010`H\u0002J\n\u0010a\u001a\u0004\u0018\u00010`H\u0002J\u0006\u0010b\u001a\u00020SJ\b\u0010c\u001a\u00020\u000bH\u0014J\b\u0010d\u001a\u00020\u000bH&J\b\u0010e\u001a\u00020\u000bH\u0014J\b\u0010f\u001a\u00020\u000bH\u0014J\u0010\u0010g\u001a\u00020h2\u0006\u0010\u0003\u001a\u00020\u0004H\u0014J\b\u0010i\u001a\u00020SH\u0002J\b\u0010j\u001a\u00020\u0006H\u0016J\b\u0010k\u001a\u00020\u0006H\u0004J\b\u0010l\u001a\u00020SH\u0014J\b\u0010m\u001a\u00020SH\u0014J\b\u0010n\u001a\u00020SH\u0014J\b\u0010o\u001a\u00020SH\u0014J\b\u0010p\u001a\u00020SH\u0002J\b\u0010q\u001a\u00020SH\u0014J\b\u0010r\u001a\u00020SH\u0004J\u000e\u0010s\u001a\u00020S2\u0006\u0010t\u001a\u00020\u0006J\u0010\u0010u\u001a\u00020S2\u0006\u0010v\u001a\u00020\u0006H\u0016J\u000e\u0010w\u001a\u00020S2\u0006\u0010[\u001a\u00020\u0006J\u001c\u0010x\u001a\u00020S2\u0006\u0010t\u001a\u00020\u00062\n\b\u0002\u0010y\u001a\u0004\u0018\u00010FH\u0016J\u0015\u0010z\u001a\u00020S2\b\u0010{\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010|J\u0010\u0010}\u001a\u00020S2\b\u0010y\u001a\u0004\u0018\u00010\u0011J\u0010\u0010~\u001a\u00020S2\b\u0010y\u001a\u0004\u0018\u00010/J\u0010\u0010\u007f\u001a\u00020S2\b\u0010y\u001a\u0004\u0018\u00010\u001aJ\u0018\u0010\u0080\u0001\u001a\u00020S2\t\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u000b¢\u0006\u0003\u0010\u0082\u0001J\t\u0010\u0083\u0001\u001a\u00020SH\u0002J\u0015\u0010\u0084\u0001\u001a\u00020S2\n\b\u0002\u0010_\u001a\u0004\u0018\u00010`H\u0016J\t\u0010\u0085\u0001\u001a\u00020SH\u0002J\t\u0010\u0086\u0001\u001a\u00020SH\u0002R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0010\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0004\n\u0002\u0010!R\u000e\u0010\"\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010#\u001a\u00020\u0015X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020\u0015X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010%\"\u0004\b*\u0010'R\u001a\u0010+\u001a\u00020\u0015X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010%\"\u0004\b-\u0010'R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00100\u001a\u00020\u0006X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001a\u00105\u001a\u00020\u0006X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00102\"\u0004\b7\u00104R\u0012\u00108\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0004\n\u0002\u00109R\u001a\u0010:\u001a\u00020\u0006X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u00102\"\u0004\b;\u00104R\u001a\u0010<\u001a\u00020\u0006X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u00102\"\u0004\b>\u00104R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b?\u00102R\u001a\u0010@\u001a\u00020\u000bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\r\"\u0004\bB\u0010\u000fR\u0010\u0010C\u001a\u0004\u0018\u00010DX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010E\u001a\u0004\u0018\u00010FX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010G\u001a\u0004\u0018\u00010DX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010H\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010IR\u001a\u0010J\u001a\u00020\u0006X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u00102\"\u0004\bL\u00104R\u0010\u0010M\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010N\u001a\u00020\u0006X\u0094\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u00102\"\u0004\bP\u00104R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\bQ\u00102¨\u0006\u008a\u0001"}, d2 = {"Lcom/obric/oui/dialog/base/AbstractDialogModal;", "Landroid/widget/FrameLayout;", "Lcom/obric/oui/dialog/v2/alert/style/AlertDialogHost;", "context", "Landroid/content/Context;", "widthMatch", "", "matchParentHeight", "(Landroid/content/Context;ZZ)V", "autoDismissOnButtonClick", "bgColor", "", "getBgColor", "()I", "setBgColor", "(I)V", "cancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "closeIcon", "Landroid/widget/ImageView;", "closeIconContainer", "Landroid/view/View;", "closeIconEnabled", "closeIconStyle", "Lcom/obric/oui/dialog/base/AbstractDialogModal$CloseIconStyle;", "completeShowListener", "Landroid/content/DialogInterface$OnShowListener;", "getCompleteShowListener", "()Landroid/content/DialogInterface$OnShowListener;", "setCompleteShowListener", "(Landroid/content/DialogInterface$OnShowListener;)V", "configurationCallback", "com/obric/oui/dialog/base/AbstractDialogModal$configurationCallback$1", "Lcom/obric/oui/dialog/base/AbstractDialogModal$configurationCallback$1;", "configurationCallbackRegistered", "contentRootView", "getContentRootView", "()Landroid/view/View;", "setContentRootView", "(Landroid/view/View;)V", "dialogRootView", "getDialogRootView", "setDialogRootView", "dimView", "getDimView", "setDimView", "dismissListener", "Landroid/content/DialogInterface$OnDismissListener;", "enableMaterial", "getEnableMaterial", "()Z", "setEnableMaterial", "(Z)V", "hideFirstFrame", "getHideFirstFrame", "setHideFirstFrame", "includeCutoutInLandscape", "Ljava/lang/Boolean;", "isShowingModal", "setShowingModal", "mCancelable", "getMCancelable", "setMCancelable", "getMatchParentHeight", "maxRootViewHeightGap", "getMaxRootViewHeightGap", "setMaxRootViewHeightGap", "myWindowCallback", "Landroid/view/Window$Callback;", "onCloseClickListener", "Landroid/view/View$OnClickListener;", "originalWindowCallback", "rootFixedHeightPx", "Ljava/lang/Integer;", "showAnimRunning", "getShowAnimRunning", "setShowAnimRunning", "showListener", "useNewDialogAnim", "getUseNewDialogAnim", "setUseNewDialogAnim", "getWidthMatch", "applyCloseIconStyle", "", "style", "customIconColor", "customIconBgColor", "(Lcom/obric/oui/dialog/base/AbstractDialogModal$CloseIconStyle;Ljava/lang/Integer;Ljava/lang/Integer;)V", "applyInsets", "insets", "Lcom/obric/oui/view/WindowInsetsCompat;", BDSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL, "completeOnShow", "dismiss", "ensureAttachedToParent", "parent", "Landroid/view/ViewGroup;", "findDecorViewParent", "forceHideFirstFrame", "getBaseLayoutRes", "getLayout", "getLayoutMarginBottom", "getLayoutMarginHorizontal", "getTargetDimAmount", "", "interceptBackPressed", "isAutoDismiss", "isDarkTheme", "onDetachedFromWindow", "originDismiss", "performEnterAnimation", "performExitAnimation", "registerConfigurationCallbackIfNeeded", "requestModalApplyInsets", "restoreWindowCallback", "setAutoDismiss", IndexDatabaseHelper.IndexColumns.ENABLED, "setCancelable", "cancelable", "setCanceledOnTouchOutside", "setCloseIconEnabled", "listener", "setIncludeCutoutInLandscape", "include", "(Ljava/lang/Boolean;)V", "setOnCancelListener", "setOnDismissListener", "setOnShowListener", "setRootFixedHeight", "heightPx", "(Ljava/lang/Integer;)V", "setupDimViewClick", "show", "unregisterConfigurationCallbackIfNeeded", "updateRootLayout", "BackPressedWindowCallback", "CloseIconStyle", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class AbstractDialogModal extends FrameLayout implements AlertDialogHost {
    public static final Companion Companion = null;
    public static final String TAG = "AbstractDialogModal";
    private boolean autoDismissOnButtonClick;
    private int bgColor;
    private DialogInterface.OnCancelListener cancelListener;
    private ImageView closeIcon;
    private View closeIconContainer;
    private boolean closeIconEnabled;
    private CloseIconStyle closeIconStyle;
    private DialogInterface.OnShowListener completeShowListener;
    private AbstractDialogModal$configurationCallback$1 configurationCallback;
    private boolean configurationCallbackRegistered;
    protected View contentRootView;
    public View dialogRootView;
    protected View dimView;
    private DialogInterface.OnDismissListener dismissListener;
    private boolean enableMaterial;
    private boolean hideFirstFrame;
    private Boolean includeCutoutInLandscape;
    private boolean isShowingModal;
    private boolean mCancelable;
    private final boolean matchParentHeight;
    private int maxRootViewHeightGap;
    private Window.Callback myWindowCallback;
    private View.OnClickListener onCloseClickListener;
    private Window.Callback originalWindowCallback;
    private Integer rootFixedHeightPx;
    private boolean showAnimRunning;
    private DialogInterface.OnShowListener showListener;
    private boolean useNewDialogAnim;
    private final boolean widthMatch;

    /* JADX INFO: compiled from: AbstractDialogModal.kt */
    @Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0002\u0010\u0005J\u0019\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n \b*\u0004\u0018\u00010\f0\fH\u0096\u0001J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0019\u0010\u0010\u001a\u00020\n2\u000e\u0010\u000b\u001a\n \b*\u0004\u0018\u00010\u000f0\u000fH\u0096\u0001J\u0019\u0010\u0011\u001a\u00020\n2\u000e\u0010\u000b\u001a\n \b*\u0004\u0018\u00010\u00120\u0012H\u0096\u0001J\u0019\u0010\u0013\u001a\u00020\n2\u000e\u0010\u000b\u001a\n \b*\u0004\u0018\u00010\f0\fH\u0096\u0001J\u0019\u0010\u0014\u001a\u00020\n2\u000e\u0010\u000b\u001a\n \b*\u0004\u0018\u00010\f0\fH\u0096\u0001J\u0019\u0010\u0015\u001a\u00020\u00162\u000e\u0010\u000b\u001a\n \b*\u0004\u0018\u00010\u00170\u0017H\u0096\u0001J\u0019\u0010\u0018\u001a\u00020\u00162\u000e\u0010\u000b\u001a\n \b*\u0004\u0018\u00010\u00170\u0017H\u0096\u0001J\t\u0010\u0019\u001a\u00020\u0016H\u0096\u0001J\t\u0010\u001a\u001a\u00020\u0016H\u0096\u0001J\u001b\u0010\u001b\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u001c2\b\b\u0001\u0010\u001d\u001a\u00020\u001eH\u0096\u0001J\u0013\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010\u000b\u001a\u00020\u001cH\u0097\u0001J\t\u0010!\u001a\u00020\u0016H\u0096\u0001J\u001b\u0010\"\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u001c2\b\b\u0001\u0010\u001d\u001a\u00020#H\u0096\u0001J\u001b\u0010$\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u001c2\b\b\u0001\u0010\u001d\u001a\u00020\u001eH\u0096\u0001J\u001b\u0010%\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\u001c2\b\b\u0001\u0010\u001d\u001a\u00020\u001eH\u0096\u0001J'\u0010&\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u001c2\n\b\u0001\u0010\u001d\u001a\u0004\u0018\u00010 2\b\b\u0001\u0010'\u001a\u00020\u001eH\u0096\u0001J\t\u0010(\u001a\u00020\nH\u0096\u0001J\u0019\u0010(\u001a\u00020\n2\u000e\u0010\u000b\u001a\n \b*\u0004\u0018\u00010)0)H\u0096\u0001J\u0019\u0010*\u001a\u00020\u00162\u000e\u0010\u000b\u001a\n \b*\u0004\u0018\u00010+0+H\u0096\u0001J\u0011\u0010,\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\nH\u0096\u0001J\u001b\u0010-\u001a\u0004\u0018\u00010\u00172\u000e\u0010\u000b\u001a\n \b*\u0004\u0018\u00010.0.H\u0097\u0001J#\u0010-\u001a\u0004\u0018\u00010\u00172\u000e\u0010\u000b\u001a\n \b*\u0004\u0018\u00010.0.2\u0006\u0010\u001d\u001a\u00020\u001cH\u0097\u0001R\u000e\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00030\u00030\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/obric/oui/dialog/base/AbstractDialogModal$BackPressedWindowCallback;", "Landroid/view/Window$Callback;", "dialog", "Lcom/obric/oui/dialog/base/AbstractDialogModal;", "delegate", "(Lcom/obric/oui/dialog/base/AbstractDialogModal;Landroid/view/Window$Callback;)V", "dialogRef", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "dispatchGenericMotionEvent", "", "p0", "Landroid/view/MotionEvent;", "dispatchKeyEvent", "event", "Landroid/view/KeyEvent;", "dispatchKeyShortcutEvent", "dispatchPopulateAccessibilityEvent", "Landroid/view/accessibility/AccessibilityEvent;", "dispatchTouchEvent", "dispatchTrackballEvent", "onActionModeFinished", "", "Landroid/view/ActionMode;", "onActionModeStarted", "onAttachedToWindow", "onContentChanged", "onCreatePanelMenu", "", "p1", "Landroid/view/Menu;", "onCreatePanelView", "Landroid/view/View;", "onDetachedFromWindow", "onMenuItemSelected", "Landroid/view/MenuItem;", "onMenuOpened", "onPanelClosed", "onPreparePanel", "p2", "onSearchRequested", "Landroid/view/SearchEvent;", "onWindowAttributesChanged", "Landroid/view/WindowManager$LayoutParams;", "onWindowFocusChanged", "onWindowStartingActionMode", "Landroid/view/ActionMode$Callback;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class BackPressedWindowCallback implements Window.Callback {
        private final Window.Callback delegate;
        private final WeakReference<AbstractDialogModal> dialogRef;

        @Override // android.view.Window.Callback
        public boolean dispatchGenericMotionEvent(MotionEvent r1) {
            return this.delegate.dispatchGenericMotionEvent(r1);
        }

        @Override // android.view.Window.Callback
        public boolean dispatchKeyShortcutEvent(KeyEvent r1) {
            return this.delegate.dispatchKeyShortcutEvent(r1);
        }

        @Override // android.view.Window.Callback
        public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent r1) {
            return this.delegate.dispatchPopulateAccessibilityEvent(r1);
        }

        @Override // android.view.Window.Callback
        public boolean dispatchTouchEvent(MotionEvent r1) {
            return this.delegate.dispatchTouchEvent(r1);
        }

        @Override // android.view.Window.Callback
        public boolean dispatchTrackballEvent(MotionEvent r1) {
            return this.delegate.dispatchTrackballEvent(r1);
        }

        @Override // android.view.Window.Callback
        public void onActionModeFinished(ActionMode r1) {
            this.delegate.onActionModeFinished(r1);
        }

        @Override // android.view.Window.Callback
        public void onActionModeStarted(ActionMode r1) {
            this.delegate.onActionModeStarted(r1);
        }

        @Override // android.view.Window.Callback
        public void onAttachedToWindow() {
            this.delegate.onAttachedToWindow();
        }

        @Override // android.view.Window.Callback
        public void onContentChanged() {
            this.delegate.onContentChanged();
        }

        @Override // android.view.Window.Callback
        public boolean onCreatePanelMenu(int r2, Menu r3) {
            Intrinsics.checkNotNullParameter(r3, "p1");
            return this.delegate.onCreatePanelMenu(r2, r3);
        }

        @Override // android.view.Window.Callback
        public View onCreatePanelView(int r1) {
            return this.delegate.onCreatePanelView(r1);
        }

        @Override // android.view.Window.Callback
        public void onDetachedFromWindow() {
            this.delegate.onDetachedFromWindow();
        }

        @Override // android.view.Window.Callback
        public boolean onMenuItemSelected(int r2, MenuItem r3) {
            Intrinsics.checkNotNullParameter(r3, "p1");
            return this.delegate.onMenuItemSelected(r2, r3);
        }

        @Override // android.view.Window.Callback
        public boolean onMenuOpened(int r2, Menu r3) {
            Intrinsics.checkNotNullParameter(r3, "p1");
            return this.delegate.onMenuOpened(r2, r3);
        }

        @Override // android.view.Window.Callback
        public void onPanelClosed(int r2, Menu r3) {
            Intrinsics.checkNotNullParameter(r3, "p1");
            this.delegate.onPanelClosed(r2, r3);
        }

        @Override // android.view.Window.Callback
        public boolean onPreparePanel(int r2, View r3, Menu r4) {
            Intrinsics.checkNotNullParameter(r4, "p2");
            return this.delegate.onPreparePanel(r2, r3, r4);
        }

        @Override // android.view.Window.Callback
        public boolean onSearchRequested() {
            return this.delegate.onSearchRequested();
        }

        @Override // android.view.Window.Callback
        public boolean onSearchRequested(SearchEvent r1) {
            return this.delegate.onSearchRequested(r1);
        }

        @Override // android.view.Window.Callback
        public void onWindowAttributesChanged(WindowManager.LayoutParams r1) {
            this.delegate.onWindowAttributesChanged(r1);
        }

        @Override // android.view.Window.Callback
        public void onWindowFocusChanged(boolean r1) {
            this.delegate.onWindowFocusChanged(r1);
        }

        @Override // android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback r1) {
            return this.delegate.onWindowStartingActionMode(r1);
        }

        @Override // android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback r1, int r2) {
            return this.delegate.onWindowStartingActionMode(r1, r2);
        }

        public BackPressedWindowCallback(AbstractDialogModal r2, Window.Callback r3) {
            Intrinsics.checkNotNullParameter(r2, "dialog");
            Intrinsics.checkNotNullParameter(r3, "delegate");
            this.delegate = r3;
            this.dialogRef = new WeakReference(r2);
        }

        @Override // android.view.Window.Callback
        public boolean dispatchKeyEvent(KeyEvent r4) {
            Intrinsics.checkNotNullParameter(r4, "event");
            AbstractDialogModal r0 = this.dialogRef.get();
            if (r0 == null) goto L13;
            if (r4.getKeyCode() != 4) goto L13;
            if (r4.getAction() != 1) goto L13;
            if (r0.isShowingModal() == false) goto L13;
            r0.cancel();
            return true;
        L13:
            return this.delegate.dispatchKeyEvent(r4);
        }
    }

    /* JADX INFO: compiled from: AbstractDialogModal.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/dialog/base/AbstractDialogModal$CloseIconStyle;", "", "(Ljava/lang/String;I)V", "LIGHT", "DARK", "CUSTOM", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum CloseIconStyle extends Enum<CloseIconStyle> {
        private static final /* synthetic */ CloseIconStyle[] $VALUES = null;
        public static final CloseIconStyle CUSTOM = null;
        public static final CloseIconStyle DARK = null;
        public static final CloseIconStyle LIGHT = null;

        private static final /* synthetic */ CloseIconStyle[] $values() {
            return new CloseIconStyle[]{LIGHT, DARK, CUSTOM};
        }

        public static CloseIconStyle valueOf(String r1) {
            return (CloseIconStyle) Enum.valueOf(CloseIconStyle.class, r1);
        }

        public static CloseIconStyle[] values() {
            return (CloseIconStyle[]) $VALUES.clone();
        }

        private CloseIconStyle(String r1, int r2) {
            super(r1, r2);
        }

        static {
            LIGHT = new CloseIconStyle("LIGHT", 0);
            DARK = new CloseIconStyle("DARK", 1);
            CUSTOM = new CloseIconStyle("CUSTOM", 2);
            $VALUES = $values();
        }
    }

    /* JADX INFO: compiled from: AbstractDialogModal.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/dialog/base/AbstractDialogModal$Companion;", "", "()V", "TAG", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: AbstractDialogModal.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[CloseIconStyle.values().length];
            r0[CloseIconStyle.DARK.ordinal()] = 1;
            r0[CloseIconStyle.LIGHT.ordinal()] = 2;
            r0[CloseIconStyle.CUSTOM.ordinal()] = 3;
            $EnumSwitchMapping$0 = r0;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$D-x2ZsOvK7gLOknwyZdnONsEPTY, reason: not valid java name */
    public static /* synthetic */ void m1132$r8$lambda$Dx2ZsOvK7gLOknwyZdnONsEPTY(AbstractDialogModal r0) {
        m1140updateRootLayout$lambda11(r0);
    }

    public static /* synthetic */ void $r8$lambda$KN2ONiczFcX8LWOTXShjFj8DGy0(AbstractDialogModal r0) {
        m1137performExitAnimation$lambda8(r0);
    }

    public static /* synthetic */ void $r8$lambda$TfVAJAGMXmoD8Aw6L1Q56fFtytY(AbstractDialogModal r0, View r1) {
        m1138setCloseIconEnabled$lambda6$lambda5(r0, r1);
    }

    public static /* synthetic */ WindowInsetsCompat $r8$lambda$UZuQXPKOvaMGSNh1G8CQiZ1R2fU(AbstractDialogModal r0, View r1, WindowInsetsCompat r2) {
        return m1135_init_$lambda3(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$p3i1BSQ7b07IttbJ-kwq_wv2V-E, reason: not valid java name */
    public static /* synthetic */ void m1133$r8$lambda$p3i1BSQ7b07IttbJkwq_wv2VE(AbstractDialogModal r0, View r1) {
        m1139setupDimViewClick$lambda10(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$s-gQPthDznMOSavMncpOxN1CNGg, reason: not valid java name */
    public static /* synthetic */ void m1134$r8$lambda$sgQPthDznMOSavMncpOxN1CNGg(AbstractDialogModal r0) {
        m1136performEnterAnimation$lambda7(r0);
    }

    static {
        Companion = new Companion(null);
    }

    public final void applyCloseIconStyle(CloseIconStyle r8) {
        Intrinsics.checkNotNullParameter(r8, "style");
        applyCloseIconStyle$default(this, r8, null, null, 6, null);
    }

    public final void applyCloseIconStyle(CloseIconStyle r8, Integer r9) {
        Intrinsics.checkNotNullParameter(r8, "style");
        applyCloseIconStyle$default(this, r8, r9, null, 4, null);
    }

    public abstract int getLayout();

    public /* synthetic */ AbstractDialogModal(Context r2, boolean r3, boolean r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = false;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = false;
    L8:
        this(r2, r3, r4);
    }

    public static final /* synthetic */ void access$updateRootLayout(AbstractDialogModal r0) {
        r0.updateRootLayout();
    }

    public final boolean getWidthMatch() {
        return this.widthMatch;
    }

    public final boolean getMatchParentHeight() {
        return this.matchParentHeight;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.obric.oui.dialog.base.AbstractDialogModal$configurationCallback$1] */
    public AbstractDialogModal(Context r10, boolean r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10);
        this.widthMatch = r11;
        this.matchParentHeight = r12;
        this.closeIconStyle = CloseIconStyle.DARK;
        this.autoDismissOnButtonClick = true;
        this.mCancelable = true;
        this.maxRootViewHeightGap = -1;
        this.useNewDialogAnim = true;
        this.configurationCallback = new AbstractDialogModal$configurationCallback$1(this);
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        setClipChildren(false);
        setClipToPadding(false);
        setClickable(true);
        setFocusable(true);
        setVisibility(8);
        View r3 = new View(r10);
        r3.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        r3.setBackgroundColor(-16777216);
        r3.setAlpha(0.0f);
        r3.setVisibility(8);
        setDimView(r3);
        addView(getDimView());
        View r2 = LayoutInflater.from(r10).inflate(getBaseLayoutRes(), this, false);
        Intrinsics.checkNotNullExpressionValue(r2, "from(context).inflate(ge…LayoutRes(), this, false)");
        setDialogRootView(r2);
        addView(getDialogRootView());
        if ((getDialogRootView().getBackground() instanceof ColorDrawable) == false) goto L10;
        Drawable r4 = getDialogRootView().getBackground();
        if (r4 == null) goto L8;
        this.bgColor = ((ColorDrawable) r4).getColor();
    L20:
        getDialogRootView().setAlpha(0.0f);
        this.closeIcon = (ImageView) findViewById(R.id.btn_close);
        this.closeIconContainer = findViewById(R.id.close_container);
        if (r12 == false) goto L23;
        View r13 = getDialogRootView();
        ViewGroup.LayoutParams r5 = getDialogRootView().getLayoutParams();
        r5.height = -1;
        r13.setLayoutParams(r5);
    L23:
        setCloseIconEnabled$default(this, this.closeIconEnabled, null, 2, null);
        ViewStub r14 = (ViewStub) findViewById(R.id.contentView);
        r14.setLayoutResource(getLayout());
        View r15 = r14.inflate();
        Intrinsics.checkNotNullExpressionValue(r15, "viewStub.inflate()");
        setContentRootView(r15);
        DialogAnimStyle.INSTANCE.adjustDialogTopSpace(getDialogRootView());
        if (OMaterialExtBaseKt.isMaterialEffectEnabled(r10) == true) goto L26;
    L28:
        boolean r16 = false;
    L29:
        this.enableMaterial = r16;
        if (r16 == false) goto L41;
        getDialogRootView().setBackgroundColor(0);
        MaterialConfig[] r17 = MaterialToken.OUI_Bg_Modal.invoke(Boolean.valueOf(!ViewUtilKt.isDarkMode(getDialogRootView())));
        OMaterialExtBaseKt.materials$default(getDialogRootView(), r17, false, 0, null, 14, null);
        if (OMaterialHelper.getMaterialLevel(r10) != 1) goto L34;
    L35:
        StrokeConfig r18 = r17[0].getStroke();
        if (r18 == null) goto L41;
        if ((getDialogRootView() instanceof DialogRootView) == false) goto L41;
        ((DialogRootView) getDialogRootView()).setStroke(r18.getColor(), OUnitExtensionKt.cdp(r10, r18.getWidth()));
        goto L41
    L34:
        if (r17.length == 1) goto L35;
    L41:
        ViewCompat.setOnApplyWindowInsetsListener(this, new AbstractDialogModal$$ExternalSyntheticLambda0(this));
        return;
    L26:
        if (OMaterialHelper.isWidgetMaterialEffectEnabled() == false) goto L28;
        r16 = true;
        goto L29
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.ColorDrawable");
    L10:
        if ((getDialogRootView().getBackground() instanceof GradientDrawable) == false) goto L20;
        Drawable r6 = getDialogRootView().getBackground();
        if (r6 == null) goto L19;
        ColorStateList r7 = ((GradientDrawable) r6).getColor();
        if (r7 != null) goto L16;
        int r8 = 0;
    L17:
        this.bgColor = r8;
        goto L20
    L16:
        r8 = r7.getDefaultColor();
        goto L17
    L19:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
    }

    protected final boolean getMCancelable() {
        return this.mCancelable;
    }

    protected final void setMCancelable(boolean r1) {
        this.mCancelable = r1;
    }

    public final DialogInterface.OnShowListener getCompleteShowListener() {
        return this.completeShowListener;
    }

    public final void setCompleteShowListener(DialogInterface.OnShowListener r1) {
        this.completeShowListener = r1;
    }

    protected final boolean getHideFirstFrame() {
        return this.hideFirstFrame;
    }

    protected final void setHideFirstFrame(boolean r1) {
        this.hideFirstFrame = r1;
    }

    protected final boolean getEnableMaterial() {
        return this.enableMaterial;
    }

    protected final void setEnableMaterial(boolean r1) {
        this.enableMaterial = r1;
    }

    protected final int getBgColor() {
        return this.bgColor;
    }

    protected final void setBgColor(int r1) {
        this.bgColor = r1;
    }

    protected final int getMaxRootViewHeightGap() {
        return this.maxRootViewHeightGap;
    }

    protected final void setMaxRootViewHeightGap(int r1) {
        this.maxRootViewHeightGap = r1;
    }

    protected final boolean getShowAnimRunning() {
        return this.showAnimRunning;
    }

    protected final void setShowAnimRunning(boolean r1) {
        this.showAnimRunning = r1;
    }

    protected boolean getUseNewDialogAnim() {
        return this.useNewDialogAnim;
    }

    protected void setUseNewDialogAnim(boolean r1) {
        this.useNewDialogAnim = r1;
    }

    protected final boolean isShowingModal() {
        return this.isShowingModal;
    }

    protected final void setShowingModal(boolean r1) {
        this.isShowingModal = r1;
    }

    public final View getDialogRootView() {
        View r0 = this.dialogRootView;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("dialogRootView");
        return null;
    }

    public final void setDialogRootView(View r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.dialogRootView = r2;
    }

    protected final View getContentRootView() {
        View r0 = this.contentRootView;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("contentRootView");
        return null;
    }

    protected final void setContentRootView(View r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.contentRootView = r2;
    }

    protected final View getDimView() {
        View r0 = this.dimView;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("dimView");
        return null;
    }

    protected final void setDimView(View r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.dimView = r2;
    }

    /* JADX INFO: renamed from: _init_$lambda-3, reason: not valid java name */
    private static final WindowInsetsCompat m1135_init_$lambda3(AbstractDialogModal r0, View r1, WindowInsetsCompat r2) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        Intrinsics.checkNotNullExpressionValue(r2, "insets");
        r0.applyInsets(r2);
        return r2;
    }

    public final void setRootFixedHeight(Integer r3) {
        if (r3 != null) goto L6;
    L4:
        r3 = null;
    L10:
        this.rootFixedHeightPx = r3;
        return;
    L6:
        if (r3.intValue() <= 0) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L4;
    L8:
        r1 = false;
        goto L9
    }

    public final void setOnShowListener(DialogInterface.OnShowListener r1) {
        this.showListener = r1;
    }

    public final void setOnDismissListener(DialogInterface.OnDismissListener r1) {
        this.dismissListener = r1;
    }

    public final void setOnCancelListener(DialogInterface.OnCancelListener r1) {
        this.cancelListener = r1;
    }

    public void setCancelable(boolean r1) {
        this.mCancelable = r1;
    }

    public final void setCanceledOnTouchOutside(boolean r1) {
        setCancelable(r1);
    }

    public final void setAutoDismiss(boolean r1) {
        this.autoDismissOnButtonClick = r1;
    }

    @Override // com.obric.oui.dialog.v2.alert.style.AlertDialogHost
    public boolean isAutoDismiss() {
        return this.autoDismissOnButtonClick;
    }

    public static /* synthetic */ void setCloseIconEnabled$default(AbstractDialogModal r0, boolean r1, View.OnClickListener r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        r0.setCloseIconEnabled(r1, r2);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setCloseIconEnabled");
    }

    public void setCloseIconEnabled(boolean r7, View.OnClickListener r8) {
        this.closeIconEnabled = r7;
        this.onCloseClickListener = r8;
        ImageView r9 = this.closeIcon;
        if (r9 == null) goto L21;
        Context r0 = getContext();
        Intrinsics.checkNotNullExpressionValue(r0, "context");
        ViewExtensionsKt.expandTouchArea(r9, OUnitExtensionKt.cdp(r0, 44));
        if (r7 == false) goto L15;
        View r10 = this.closeIconContainer;
        if (r10 == null) goto L11;
        ViewExtensionsKt.makeVisible(r10);
    L11:
        applyCloseIconStyle$default(this, this.closeIconStyle, null, null, 6, null);
        View r11 = this.closeIconContainer;
        if (r11 == null) goto L22;
        r11.setOnClickListener(new AbstractDialogModal$$ExternalSyntheticLambda2(this));
        return;
    L22:
        return;
    L15:
        View r6 = this.closeIconContainer;
        if (r6 == null) goto L23;
        ViewExtensionsKt.makeGone(r6);
        return;
    L23:
        return;
    }

    /* JADX INFO: renamed from: setCloseIconEnabled$lambda-6$lambda-5, reason: not valid java name */
    private static final void m1138setCloseIconEnabled$lambda6$lambda5(AbstractDialogModal r1, View r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r1.dismiss();
        View.OnClickListener r3 = r1.onCloseClickListener;
        if (r3 == null) goto L7;
        r3.onClick(r2);
        return;
    }

    public static /* synthetic */ void applyCloseIconStyle$default(AbstractDialogModal r1, CloseIconStyle r2, Integer r3, Integer r4, int r5, Object r6) {
        if (r6 != null) goto L12;
        if ((r5 & 2) == 0) goto L7;
        r3 = null;
    L7:
        if ((r5 & 4) == 0) goto L9;
        r4 = null;
    L9:
        r1.applyCloseIconStyle(r2, r3, r4);
        return;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: applyCloseIconStyle");
    }

    public final void applyCloseIconStyle(CloseIconStyle r2, Integer r3, Integer r4) {
        Intrinsics.checkNotNullParameter(r2, "style");
        this.closeIconStyle = r2;
        if (this.closeIconEnabled == true) goto L5;
        return;
    L5:
        int r5 = WhenMappings.$EnumSwitchMapping$0[r2.ordinal()];
        if (r5 != 1) goto L8;
        int r6 = R.color.ConstTextInverse;
        r4 = Integer.valueOf(R.color.ConstBGContainer7);
    L18:
        ImageView r7 = this.closeIcon;
        if (r7 == null) goto L22;
        r7.setImageTintList(ContextCompat.getColorStateList(getContext(), r6));
    L22:
        GradientDrawable r8 = null;
        if (r4 != null) goto L28;
        View r1 = this.closeIconContainer;
        if (r1 == null) goto L40;
        r1.setBackground(null);
        return;
    L40:
        return;
    L28:
        View r9 = this.closeIconContainer;
        if (r9 != null) goto L31;
        Drawable r10 = null;
    L33:
        if ((r10 instanceof GradientDrawable) == false) goto L35;
        r8 = (GradientDrawable) r10;
    L35:
        if (r8 == null) goto L41;
        r8.setColor(ContextCompat.getColorStateList(getContext(), r4.intValue()));
        return;
    L41:
        return;
    L31:
        r10 = r9.getBackground();
        goto L33
    L8:
        if (r5 != 2) goto L10;
        r6 = R.color.TextReverse;
        r4 = Integer.valueOf(R.color.ConstTextInverse5);
        goto L18
    L10:
        if (r5 != 3) goto L15;
        if (r3 != null) goto L13;
        r6 = R.color.ConstTextInverse;
        goto L18
    L13:
        r6 = r3.intValue();
        goto L18
    L15:
        throw new NoWhenBranchMatchedException();
    }

    public final void setIncludeCutoutInLandscape(Boolean r1) {
        this.includeCutoutInLandscape = r1;
    }

    public final void forceHideFirstFrame() {
        this.hideFirstFrame = true;
    }

    public static /* synthetic */ void show$default(AbstractDialogModal r0, ViewGroup r1, int r2, Object r3) {
        if (r3 != null) goto L9;
        if ((r2 & 1) == 0) goto L6;
        r1 = null;
    L6:
        r0.show(r1);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: show");
    }

    public void show(ViewGroup r2) {
        if (this.isShowingModal == true) goto L9;
        ensureAttachedToParent(r2);
        setupDimViewClick();
        updateRootLayout();
        requestModalApplyInsets();
        setVisibility(0);
        DialogInterface.OnShowListener r3 = this.showListener;
        if (r3 == null) goto L8;
        r3.onShow(this);
    L8:
        this.isShowingModal = true;
        this.showAnimRunning = true;
        performEnterAnimation();
        interceptBackPressed();
        registerConfigurationCallbackIfNeeded();
        return;
    L9:
        updateRootLayout();
        requestModalApplyInsets();
    }

    protected void performEnterAnimation() {
        ViewExtensionsKt.makeVisible(getDimView());
        getDimView().setAlpha(0.0f);
        ViewPropertyAnimator r0 = getDimView().animate();
        Context r1 = getContext();
        Intrinsics.checkNotNullExpressionValue(r1, "context");
        r0.alpha(getTargetDimAmount(r1)).setDuration(220).start();
        getDialogRootView().post(new AbstractDialogModal$$ExternalSyntheticLambda5(this));
    }

    /* JADX INFO: renamed from: performEnterAnimation$lambda-7, reason: not valid java name */
    private static final void m1136performEnterAnimation$lambda7(final AbstractDialogModal r9) {
        Intrinsics.checkNotNullParameter(r9, "this$0");
        ViewPropertySpringAnimator r1 = DialogAnimStyle.dialogBottomShow$default(DialogAnimStyle.INSTANCE, r9.getDialogRootView(), null, false, 0.0f, r9.getUseNewDialogAnim(), 4, null).start();
        if (r9.hideFirstFrame == false) goto L5;
        r1.setListener(new AbstractDialogModal$performEnterAnimation$1$1(r9), new AbstractDialogModal$performEnterAnimation$1$2(r9), new AbstractDialogModal$performEnterAnimation$1$3(r9));
        return;
    L5:
        ViewPropertySpringAnimator.setListener$default(r1, null, new AbstractDialogModal$performEnterAnimation$1$4(r9), new AbstractDialogModal$performEnterAnimation$1$5(r9), 1, null);
    }

    protected void performExitAnimation() {
        getDimView().animate().alpha(0.0f).setDuration(180).withEndAction(new AbstractDialogModal$$ExternalSyntheticLambda3(this)).start();
        ViewPropertySpringAnimator<View> r0 = DialogAnimStyle.INSTANCE.dialogBottomHide(getDialogRootView(), null, false, getUseNewDialogAnim());
        ViewPropertySpringAnimator.setListener$default(r0, null, new AbstractDialogModal$performExitAnimation$2$1(this), new AbstractDialogModal$performExitAnimation$2$2(this), 1, null);
        r0.start();
    }

    /* JADX INFO: renamed from: performExitAnimation$lambda-8, reason: not valid java name */
    private static final void m1137performExitAnimation$lambda8(AbstractDialogModal r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        ViewExtensionsKt.makeGone(r1.getDimView());
    }

    protected void originDismiss() {
        if (this.isShowingModal == true) goto L5;
        return;
    L5:
        this.isShowingModal = false;
        this.showAnimRunning = false;
        restoreWindowCallback();
        unregisterConfigurationCallbackIfNeeded();
        DialogInterface.OnDismissListener r0 = this.dismissListener;
        if (r0 == null) goto L9;
        r0.onDismiss(this);
    L9:
        ViewParent r1 = getParent();
        if ((r1 instanceof ViewGroup) == false) goto L12;
        ViewGroup r2 = (ViewGroup) r1;
    L13:
        if (r2 == null) goto L16;
        r2.removeView(this);
    L16:
        setVisibility(8);
        getDimView().setAlpha(0.0f);
        getDialogRootView().setAlpha(1.0f);
        getDialogRootView().setTranslationX(0.0f);
        getDialogRootView().setTranslationY(0.0f);
        return;
    L12:
        r2 = null;
        goto L13
    }

    @Override // android.content.DialogInterface
    public void dismiss() {
        if (this.isShowingModal == true) goto L5;
        return;
    L5:
        restoreWindowCallback();
        performExitAnimation();
    }

    @Override // android.content.DialogInterface
    public void cancel() {
        if (this.mCancelable == true) goto L5;
        return;
    L5:
        DialogInterface.OnCancelListener r0 = this.cancelListener;
        if (r0 == null) goto L9;
        r0.onCancel(this);
    L9:
        dismiss();
    }

    protected final void completeOnShow() {
        this.showAnimRunning = false;
        DialogInterface.OnShowListener r0 = this.completeShowListener;
        if (r0 == null) goto L7;
        r0.onShow(this);
        return;
    }

    protected int getBaseLayoutRes() {
        if (this.matchParentHeight == false) goto L6;
        return R.layout.o_base_dialog_with_match_parent_height;
    L6:
        return R.layout.o_base_dialog;
    }

    protected float getTargetDimAmount(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
        if ((r1.getResources().getConfiguration().uiMode & 48) != 32) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return 0.8f;
    L8:
        return 0.32f;
    L5:
        r0 = false;
        goto L6
    }

    protected int getLayoutMarginHorizontal() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.oui_dialog_layout_margin);
    }

    protected int getLayoutMarginBottom() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.oui_dialog_layout_margin);
    }

    protected void requestModalApplyInsets() {
        ViewCompat.requestApplyInsets(this);
    }

    private final void setupDimViewClick() {
        if (this.mCancelable == false) goto L5;
        getDimView().setOnClickListener(new AbstractDialogModal$$ExternalSyntheticLambda4(this));
        return;
    L5:
        getDimView().setOnClickListener(null);
    }

    /* JADX INFO: renamed from: setupDimViewClick$lambda-10, reason: not valid java name */
    private static final void m1139setupDimViewClick$lambda10(AbstractDialogModal r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.cancel();
    }

    private final void ensureAttachedToParent(ViewGroup r3) {
        if (getParent() == null) goto L5;
        return;
    L5:
        if (r3 != null) goto L7;
        r3 = findDecorViewParent();
    L7:
        if (r3 != null) goto L9;
        return;
    L9:
        r3.addView(this, new ViewGroup.LayoutParams(-1, -1));
    }

    private final ViewGroup findDecorViewParent() {
        Context r0 = getContext();
    L4:
        if ((r0 instanceof ContextWrapper) == false) goto L16;
        if ((r0 instanceof Activity) == true) goto L7;
        r0 = ((ContextWrapper) r0).getBaseContext();
        goto L4
    L7:
        Window r3 = ((Activity) r0).getWindow();
        if (r3 != null) goto L10;
        View r4 = null;
    L12:
        if ((r4 instanceof ViewGroup) == true) goto L14;
        return null;
    L14:
        return (ViewGroup) r4;
    L10:
        r4 = r3.getDecorView();
        goto L12
    L16:
        Context r5 = getContext();
        if ((r5 instanceof Activity) == false) goto L19;
        Activity r6 = (Activity) r5;
    L20:
        if (r6 != null) goto L22;
    L21:
        View r7 = null;
    L27:
        if ((r7 instanceof ViewGroup) == true) goto L29;
        return null;
    L29:
        return (ViewGroup) r7;
    L22:
        Window r8 = r6.getWindow();
        if (r8 == null) goto L21;
        r7 = r8.getDecorView();
        goto L27
    L19:
        r6 = null;
        goto L20
    }

    private final void updateRootLayout() {
        getDialogRootView().post(new AbstractDialogModal$$ExternalSyntheticLambda1(this));
    }

    /* JADX INFO: renamed from: updateRootLayout$lambda-11, reason: not valid java name */
    private static final void m1140updateRootLayout$lambda11(AbstractDialogModal r6) {
        Intrinsics.checkNotNullParameter(r6, "this$0");
        Size r0 = OWindowConfigController.getFullWindowSize(r6.getContext());
        ViewGroup.LayoutParams r1 = r6.getDialogRootView().getLayoutParams();
        if ((r1 instanceof FrameLayout.LayoutParams) == false) goto L5;
        FrameLayout.LayoutParams r2 = (FrameLayout.LayoutParams) r1;
    L6:
        int r3 = -2;
        if (r2 != null) goto L10;
        r2 = new FrameLayout.LayoutParams(-2, -2);
    L10:
        if (r6.matchParentHeight == false) goto L17;
        if (r6.widthMatch == false) goto L14;
        int r4 = -1;
    L15:
        r2.width = r4;
        r2.height = -1;
        r2.gravity = 17;
        r2.bottomMargin = 0;
    L32:
        r6.getDialogRootView().setLayoutParams(r2);
        return;
    L14:
        r4 = r2.width;
        goto L15
    L17:
        if (r6.widthMatch == false) goto L25;
        r2.width = -1;
        Integer r5 = r6.rootFixedHeightPx;
        if (r5 == null) goto L22;
        r3 = r5.intValue();
    L22:
        r2.height = r3;
        r2.gravity = 80;
        r2.bottomMargin = 0;
        if ((r6.getDialogRootView() instanceof DialogRootView) == false) goto L32;
        float r7 = r6.getContext().getResources().getDimension(R.dimen.oui_r_l3);
        ((DialogRootView) r6.getDialogRootView()).setRadius(r7, r7, 0.0f, 0.0f);
        goto L32
    L25:
        int r8 = Math.min(r0.getWidth(), r0.getHeight()) - (r6.getLayoutMarginHorizontal() * 2);
        r2.width = r8;
        Integer r9 = r6.rootFixedHeightPx;
        if (r9 == null) goto L29;
        r3 = r9.intValue();
    L29:
        r2.height = r3;
        r2.gravity = 81;
        r6.getDialogRootView().measure(View.MeasureSpec.makeMeasureSpec(r8, Integer.MIN_VALUE), 0);
        if (r0.getWidth() >= r0.getHeight()) goto L32;
        int r10 = r0.getHeight();
        Context r11 = r6.getContext();
        Intrinsics.checkNotNullExpressionValue(r11, "context");
        r6.maxRootViewHeightGap = Math.max(0, r6.getDialogRootView().getMeasuredHeight() - (r10 - OUnitExtensionKt.cdp(r11, UCharacter.UnicodeBlock.LINEAR_A_ID)));
        goto L32
    L5:
        r2 = null;
        goto L6
    }

    private final void applyInsets(WindowInsetsCompat r6) {
        Context r0 = getContext();
        Intrinsics.checkNotNullExpressionValue(r0, "context");
        boolean r1 = OWindowConfigController.isGestureNavigation(r0);
        int r7 = r6.getInsets(WindowInsetsCompat.Type.ime()).bottom;
        OWindowConfigController r2 = OWindowConfigController.INSTANCE;
        Context r3 = getContext();
        Intrinsics.checkNotNullExpressionValue(r3, "context");
        boolean r4 = r2.isLandscape(r3);
        OWindowConfigController r5 = OWindowConfigController.INSTANCE;
        Context r8 = getContext();
        Intrinsics.checkNotNullExpressionValue(r8, "context");
        boolean r9 = r5.isInMultiWindowMode(r8);
        int r10 = 0;
        if (r9 == true) goto L7;
        if (r4 == true) goto L7;
        boolean r11 = false;
    L8:
        if (r11 == false) goto L10;
        int r12 = 0;
    L11:
        ViewGroup.LayoutParams r13 = getDialogRootView().getLayoutParams();
        if ((r13 instanceof ViewGroup.MarginLayoutParams) == false) goto L14;
        ViewGroup.MarginLayoutParams r14 = (ViewGroup.MarginLayoutParams) r13;
    L15:
        if (r14 != null) goto L18;
        return;
    L18:
        if (this.widthMatch == false) goto L20;
        r14.bottomMargin = 0;
        getDialogRootView().setLayoutParams(r14);
        getDialogRootView().setTranslationY(0.0f);
        getDialogRootView().setPadding(getDialogRootView().getPaddingLeft(), getDialogRootView().getPaddingTop(), getDialogRootView().getPaddingRight(), r7);
        return;
    L20:
        if (r1 == false) goto L22;
        r12 = 0;
    L22:
        int r15 = getLayoutMarginBottom();
        if (r7 <= 0) goto L25;
        int r16 = 0;
    L26:
        int r17 = r15 + r16;
        if (r14.bottomMargin == r17) goto L29;
        r14.bottomMargin = r17;
        getDialogRootView().setLayoutParams(r14);
    L29:
        if (r7 <= 0) goto L31;
        r10 = Math.max(0, r7 - r12);
    L31:
        getDialogRootView().setTranslationY(-r10);
        return;
    L25:
        r16 = r12;
        goto L26
    L14:
        r14 = null;
        goto L15
    L10:
        r12 = OWindowConfigController.INSTANCE.getNavigationBarHeight(getContext());
    L7:
        r11 = true;
        goto L8
    }

    private final void registerConfigurationCallbackIfNeeded() {
        if (this.configurationCallbackRegistered == false) goto L5;
        return;
    L5:
        getContext().registerComponentCallbacks(this.configurationCallback);
        this.configurationCallbackRegistered = true;
    }

    private final void unregisterConfigurationCallbackIfNeeded() {
        if (this.configurationCallbackRegistered == true) goto L5;
        return;
    L5:
        getContext().unregisterComponentCallbacks(this.configurationCallback);
        this.configurationCallbackRegistered = false;
    }

    private final void interceptBackPressed() {
        OWindowConfigController r0 = OWindowConfigController.INSTANCE;
        Context r1 = getContext();
        Intrinsics.checkNotNullExpressionValue(r1, "context");
        Activity r2 = r0.getActivity(r1);
        if (r2 != null) goto L5;
        return;
    L5:
        Window.Callback r3 = r2.getWindow().getCallback();
        if (r3 != null) goto L8;
        return;
    L8:
        this.originalWindowCallback = r3;
        this.myWindowCallback = new BackPressedWindowCallback(this, r3);
        r2.getWindow().setCallback(this.myWindowCallback);
    }

    protected final void restoreWindowCallback() {
        OWindowConfigController r0 = OWindowConfigController.INSTANCE;
        Context r1 = getContext();
        Intrinsics.checkNotNullExpressionValue(r1, "context");
        Activity r2 = r0.getActivity(r1);
        if (r2 != null) goto L5;
        return;
    L5:
        Window.Callback r3 = this.originalWindowCallback;
        if (r3 != null) goto L9;
        return;
    L9:
        if (r2.getWindow().getCallback() != this.myWindowCallback) goto L11;
        r2.getWindow().setCallback(r3);
    L11:
        this.myWindowCallback = null;
        this.originalWindowCallback = null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        restoreWindowCallback();
        unregisterConfigurationCallbackIfNeeded();
    }

    protected final boolean isDarkTheme() {
        int r0 = this.bgColor;
        if (r0 != 0) goto L7;
        return ViewUtilKt.isDarkMode(getDialogRootView());
    L7:
        return OPalette.isDarkColor(r0);
    }
}
