package com.obric.oui.sheet.v2;

import android.R;
import android.app.Dialog;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.security.bytedance.guard.BDSecurityGuardStub;
import android.util.Log;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import com.android.vcard.VCardConfig;
import com.obric.common.oea.foundation.animation.manager.AnimationManager;
import com.obric.oui.common.util.ViewExtensionsKt;
import com.obric.oui.dialog.DialogExtInterface;
import com.obric.oui.dialog.alert.view.RadiusLayout;
import com.obric.oui.material.OMaterialExtBaseKt;
import com.obric.oui.material.OMaterialHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OSheet.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0016\u0018\u0000 Î\u00012\u00020\u00012\u00020\u0002:\u0006Î\u0001Ï\u0001Ð\u0001B7\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\u001e\u0010\u009a\u0001\u001a\u00030\u009b\u00012\t\u0010\u009c\u0001\u001a\u0004\u0018\u00010{2\t\u0010\u009d\u0001\u001a\u0004\u0018\u000100J\n\u0010\u009e\u0001\u001a\u00030\u009b\u0001H\u0016J\b\u0010\u009f\u0001\u001a\u00030\u009b\u0001J\b\u0010 \u0001\u001a\u00030\u009b\u0001J$\u0010¡\u0001\u001a\u0003H¢\u0001\"\t\b\u0000\u0010¢\u0001*\u0002002\u0007\u0010£\u0001\u001a\u00020\u0006H\u0016¢\u0006\u0003\u0010¤\u0001J\t\u0010¥\u0001\u001a\u00020\tH\u0016J\u0016\u0010¦\u0001\u001a\u00030\u009b\u00012\n\u0010§\u0001\u001a\u0005\u0018\u00010¨\u0001H\u0014J\n\u0010©\u0001\u001a\u00030\u009b\u0001H\u0016J\n\u0010ª\u0001\u001a\u00030\u009b\u0001H\u0016J\n\u0010«\u0001\u001a\u00030\u009b\u0001H\u0016J\n\u0010¬\u0001\u001a\u00030\u009b\u0001H\u0016J\n\u0010\u00ad\u0001\u001a\u00030\u009b\u0001H\u0016J\n\u0010®\u0001\u001a\u00030\u009b\u0001H\u0014J\n\u0010¯\u0001\u001a\u00030\u009b\u0001H\u0014J\n\u0010°\u0001\u001a\u00030\u009b\u0001H\u0002J\u0013\u0010±\u0001\u001a\u00030\u009b\u00012\u0007\u0010²\u0001\u001a\u00020\tH\u0016J\u001e\u0010³\u0001\u001a\u00030\u009b\u00012\t\u0010\u009c\u0001\u001a\u0004\u0018\u00010{2\t\u0010\u009d\u0001\u001a\u0004\u0018\u000100J\u0011\u0010´\u0001\u001a\u00030\u009b\u00012\u0007\u0010µ\u0001\u001a\u00020\tJ\u0011\u0010¶\u0001\u001a\u00030\u009b\u00012\u0007\u0010·\u0001\u001a\u00020\tJ\u0013\u0010¸\u0001\u001a\u00030\u009b\u00012\t\u0010¹\u0001\u001a\u0004\u0018\u00010,J\u0013\u0010º\u0001\u001a\u00030\u009b\u00012\t\u0010¹\u0001\u001a\u0004\u0018\u000106J\u0014\u0010»\u0001\u001a\u00030\u009b\u00012\n\u0010¹\u0001\u001a\u0005\u0018\u00010\u008a\u0001J\u0013\u0010¼\u0001\u001a\u00030\u009b\u00012\u0007\u0010½\u0001\u001a\u00020\tH\u0016J\u0019\u0010¾\u0001\u001a\u00030\u009b\u00012\t\u0010¿\u0001\u001a\u0004\u0018\u00010\t¢\u0006\u0003\u0010\u0092\u0001J\u0012\u0010À\u0001\u001a\u00030\u009b\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\u0016\u0010Á\u0001\u001a\u00030\u009b\u00012\n\u0010Â\u0001\u001a\u0005\u0018\u00010Ã\u0001H\u0002J\u0016\u0010Ä\u0001\u001a\u00030\u009b\u00012\n\u0010Â\u0001\u001a\u0005\u0018\u00010Ã\u0001H\u0002J\u0012\u0010Å\u0001\u001a\u00030\u009b\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\n\u0010Æ\u0001\u001a\u00030\u009b\u0001H\u0017J\n\u0010Ç\u0001\u001a\u00030\u009b\u0001H\u0016J\n\u0010È\u0001\u001a\u00030\u009b\u0001H\u0002J\n\u0010É\u0001\u001a\u00030\u009b\u0001H\u0002J\n\u0010Ê\u0001\u001a\u00030\u009b\u0001H\u0002J\t\u0010Ë\u0001\u001a\u00020\tH\u0016J\t\u0010Ì\u0001\u001a\u00020\tH\u0002J\f\u0010Í\u0001\u001a\u0005\u0018\u00010Ã\u0001H\u0016R\u001a\u0010\f\u001a\u00020\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0013\"\u0004\b\u001e\u0010\u0015R\u001a\u0010\u001f\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0013\"\u0004\b!\u0010\u0015R\u001a\u0010\"\u001a\u00020#X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u000e\"\u0004\b*\u0010\u0010R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010/\u001a\u000200X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0010\u00105\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00107\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u000e\"\u0004\b9\u0010\u0010R\u001a\u0010:\u001a\u00020\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u000e\"\u0004\b<\u0010\u0010R\u001a\u0010=\u001a\u00020\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u000e\"\u0004\b?\u0010\u0010R\u001a\u0010@\u001a\u00020\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u000e\"\u0004\bB\u0010\u0010R\u001a\u0010C\u001a\u00020\u0017X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u0019\"\u0004\bE\u0010\u001bR\u001a\u0010F\u001a\u00020GX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u001a\u0010L\u001a\u00020\u0017X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\u0019\"\u0004\bN\u0010\u001bR\u001a\u0010O\u001a\u00020PX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u000e\u0010U\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010V\u001a\u00020\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010\u000e\"\u0004\bX\u0010\u0010R\u001a\u0010Y\u001a\u00020\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010\u000e\"\u0004\bZ\u0010\u0010R\u001a\u0010[\u001a\u00020\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010\u000e\"\u0004\b]\u0010\u0010R\u001a\u0010^\u001a\u00020\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010\u000e\"\u0004\b`\u0010\u0010R$\u0010b\u001a\u00020\u00062\u0006\u0010a\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bc\u0010\u0013\"\u0004\bd\u0010\u0015R\u001a\u0010e\u001a\u00020fX\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR\u001a\u0010k\u001a\u00020lX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR\u001a\u0010q\u001a\u00020lX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\br\u0010n\"\u0004\bs\u0010pR\u001c\u0010t\u001a\u0004\u0018\u00010uX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bv\u0010w\"\u0004\bx\u0010yR\u001a\u0010z\u001a\u00020{X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b|\u0010}\"\u0004\b~\u0010\u007fR \u0010\u0080\u0001\u001a\u00030\u0081\u0001X\u0096.¢\u0006\u0012\n\u0000\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001\"\u0006\b\u0084\u0001\u0010\u0085\u0001R\u0017\u0010\u0086\u0001\u001a\u00020\u00048VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001R\u0012\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u008a\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u008b\u0001\u001a\u00020\tX\u0096\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008c\u0001\u0010\u000e\"\u0005\b\u008d\u0001\u0010\u0010R$\u0010\u008e\u0001\u001a\u0004\u0018\u00010\tX\u0096\u000e¢\u0006\u0015\n\u0003\u0010\u0093\u0001\u001a\u0006\b\u008f\u0001\u0010\u0090\u0001\"\u0006\b\u0091\u0001\u0010\u0092\u0001R\u001d\u0010\u0094\u0001\u001a\u00020\u0006X\u0096\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0095\u0001\u0010\u0013\"\u0005\b\u0096\u0001\u0010\u0015R\u001d\u0010\u0097\u0001\u001a\u00020\u0006X\u0096\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0098\u0001\u0010\u0013\"\u0005\b\u0099\u0001\u0010\u0015¨\u0006Ñ\u0001"}, d2 = {"Lcom/obric/oui/sheet/v2/OSheet;", "Landroid/app/Dialog;", "Lcom/obric/oui/sheet/v2/OSheetBase;", "context", "Landroid/content/Context;", "hostWindowHeight", "", "defStyleAttr", "contentOverlay", "", "userEnableMaterial", "(Landroid/content/Context;IIZZ)V", "autoAddBodyPaddingTopWhenOverlay", "getAutoAddBodyPaddingTopWhenOverlay", "()Z", "setAutoAddBodyPaddingTopWhenOverlay", "(Z)V", "bgColor", "getBgColor", "()I", "setBgColor", "(I)V", "bodyContainer", "Landroid/widget/FrameLayout;", "getBodyContainer", "()Landroid/widget/FrameLayout;", "setBodyContainer", "(Landroid/widget/FrameLayout;)V", "bodyContentPaddingBottom", "getBodyContentPaddingBottom", "setBodyContentPaddingBottom", "bodyContentPaddingTop", "getBodyContentPaddingTop", "setBodyContentPaddingTop", "configurationCallback", "Landroid/content/ComponentCallbacks;", "getConfigurationCallback", "()Landroid/content/ComponentCallbacks;", "setConfigurationCallback", "(Landroid/content/ComponentCallbacks;)V", "configurationCallbackRegistered", "getConfigurationCallbackRegistered", "setConfigurationCallbackRegistered", "configurationListener", "Lcom/obric/oui/dialog/DialogExtInterface$OnConfigurationListener;", "decorForceFullScreen", "decorFullScreen", "dimView", "Landroid/view/View;", "getDimView", "()Landroid/view/View;", "setDimView", "(Landroid/view/View;)V", "dismissAnimListener", "Lcom/obric/oui/dialog/DialogExtInterface$OnDismissAnimListener;", "doShowAnimation", "getDoShowAnimation", "setDoShowAnimation", "enableDimAnim", "getEnableDimAnim", "setEnableDimAnim", "enableEnterAnim", "getEnableEnterAnim", "setEnableEnterAnim", "enableMaterial", "getEnableMaterial", "setEnableMaterial", "footerContainer", "getFooterContainer", "setFooterContainer", "fullWindowSize", "Landroid/util/Size;", "getFullWindowSize", "()Landroid/util/Size;", "setFullWindowSize", "(Landroid/util/Size;)V", "headerContainer", "getHeaderContainer", "setHeaderContainer", "heightStyle", "Lcom/obric/oui/sheet/v2/OSheet$HeightMode;", "getHeightStyle", "()Lcom/obric/oui/sheet/v2/OSheet$HeightMode;", "setHeightStyle", "(Lcom/obric/oui/sheet/v2/OSheet$HeightMode;)V", "hideFirstFrame", "ignoreInsetBottom", "getIgnoreInsetBottom", "setIgnoreInsetBottom", "isContentOverlayMode", "setContentOverlayMode", "mCancelable", "getMCancelable", "setMCancelable", "mClearDimFlag", "getMClearDimFlag", "setMClearDimFlag", "value", "maxRootHeight", "getMaxRootHeight", "setMaxRootHeight", "rootContainer", "Lcom/obric/oui/dialog/alert/view/RadiusLayout;", "getRootContainer", "()Lcom/obric/oui/dialog/alert/view/RadiusLayout;", "setRootContainer", "(Lcom/obric/oui/dialog/alert/view/RadiusLayout;)V", "rootTransMoveStartX", "", "getRootTransMoveStartX", "()F", "setRootTransMoveStartX", "(F)V", "rootTransMoveStartY", "getRootTransMoveStartY", "setRootTransMoveStartY", "runningAnim", "Lcom/obric/common/oea/foundation/animation/manager/AnimationManager;", "getRunningAnim", "()Lcom/obric/common/oea/foundation/animation/manager/AnimationManager;", "setRunningAnim", "(Lcom/obric/common/oea/foundation/animation/manager/AnimationManager;)V", "scaffoldContainer", "Landroid/view/ViewGroup;", "getScaffoldContainer", "()Landroid/view/ViewGroup;", "setScaffoldContainer", "(Landroid/view/ViewGroup;)V", "scaffoldController", "Lcom/obric/oui/sheet/v2/OSheetScaffoldController;", "getScaffoldController", "()Lcom/obric/oui/sheet/v2/OSheetScaffoldController;", "setScaffoldController", "(Lcom/obric/oui/sheet/v2/OSheetScaffoldController;)V", "sheetContext", "getSheetContext", "()Landroid/content/Context;", "showAnimListener", "Lcom/obric/oui/dialog/DialogExtInterface$OnShowAnimListener;", "showing", "getShowing", "setShowing", "systemInsetsAppearanceLightValue", "getSystemInsetsAppearanceLightValue", "()Ljava/lang/Boolean;", "setSystemInsetsAppearanceLightValue", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "userWindowHeight", "getUserWindowHeight", "setUserWindowHeight", "userWindowWidth", "getUserWindowWidth", "setUserWindowWidth", "addChildToParent", "", "parent", "child", "dismiss", "dismissImmediately", "forceHideFirstFrame", "getViewById", ExifInterface.GPS_DIRECTION_TRUE, "id", "(I)Landroid/view/View;", "needDimAnim", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDismissAnimEnd", "onDismissAnimStart", "onDismissComplete", "onShowAnimEnd", "onShowAnimStart", "onStart", "onStop", "originDismiss", "setCanceledOnTouchOutside", BDSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL, "setChildToParent", "setClearDimFlag", "dim", "setFullScreen", "forceFullScreen", "setOnConfigurationListener", "listener", "setOnDismissAnimListener", "setOnShowAnimListener", "setOverlayModeAutoBodyPaddingTopEnabled", "enable", "setSystemInsetsAppearanceLight", "appearanceLight", "setupDimView", "setupSystemInsets", "window", "Landroid/view/Window;", "setupSystemInsetsAppearance", "setupView", "show", "updateMaterial", "updateRootHeight", "updateRootSize", "updateRootWidth", "useWindowDim", "useWindowDimInternal", "windowForAnim", "Companion", "Header", "HeightMode", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OSheet extends Dialog implements OSheetBase {
    public static final Companion Companion = null;
    public static final String TAG = "OInsetSheet";
    private boolean autoAddBodyPaddingTopWhenOverlay;
    private int bgColor;
    public FrameLayout bodyContainer;
    private int bodyContentPaddingBottom;
    private int bodyContentPaddingTop;
    private ComponentCallbacks configurationCallback;
    private boolean configurationCallbackRegistered;
    private DialogExtInterface.OnConfigurationListener configurationListener;
    private boolean decorForceFullScreen;
    private boolean decorFullScreen;
    public View dimView;
    private DialogExtInterface.OnDismissAnimListener dismissAnimListener;
    private boolean doShowAnimation;
    private boolean enableDimAnim;
    private boolean enableEnterAnim;
    private boolean enableMaterial;
    public FrameLayout footerContainer;
    private Size fullWindowSize;
    public FrameLayout headerContainer;
    private HeightMode heightStyle;
    private boolean hideFirstFrame;
    private boolean ignoreInsetBottom;
    private boolean isContentOverlayMode;
    private boolean mCancelable;
    private boolean mClearDimFlag;
    public RadiusLayout rootContainer;
    private float rootTransMoveStartX;
    private float rootTransMoveStartY;
    private AnimationManager runningAnim;
    public ViewGroup scaffoldContainer;
    public OSheetScaffoldController scaffoldController;
    private DialogExtInterface.OnShowAnimListener showAnimListener;
    private boolean showing;
    private Boolean systemInsetsAppearanceLightValue;
    private int userWindowHeight;
    private int userWindowWidth;

    /* JADX INFO: compiled from: OSheet.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/sheet/v2/OSheet$Companion;", "", "()V", "TAG", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: OSheet.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/obric/oui/sheet/v2/OSheet$Header;", "", "(Ljava/lang/String;I)V", "CUSTOM", "PAGE", "ACTION", "MODAL", "ONLY_TITLE", "PAGE_WITH_CLOSE", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum Header extends Enum<Header> {
        private static final /* synthetic */ Header[] $VALUES = null;
        public static final Header ACTION = null;
        public static final Header CUSTOM = null;
        public static final Header MODAL = null;
        public static final Header ONLY_TITLE = null;
        public static final Header PAGE = null;
        public static final Header PAGE_WITH_CLOSE = null;

        private static final /* synthetic */ Header[] $values() {
            return new Header[]{CUSTOM, PAGE, ACTION, MODAL, ONLY_TITLE, PAGE_WITH_CLOSE};
        }

        public static Header valueOf(String r1) {
            return (Header) Enum.valueOf(Header.class, r1);
        }

        public static Header[] values() {
            return (Header[]) $VALUES.clone();
        }

        private Header(String r1, int r2) {
            super(r1, r2);
        }

        static {
            CUSTOM = new Header("CUSTOM", 0);
            PAGE = new Header("PAGE", 1);
            ACTION = new Header("ACTION", 2);
            MODAL = new Header("MODAL", 3);
            ONLY_TITLE = new Header("ONLY_TITLE", 4);
            PAGE_WITH_CLOSE = new Header("PAGE_WITH_CLOSE", 5);
            $VALUES = $values();
        }
    }

    /* JADX INFO: compiled from: OSheet.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/sheet/v2/OSheet$HeightMode;", "", "(Ljava/lang/String;I)V", "FULL_HEIGHT", "WRAP_HEIGHT", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum HeightMode extends Enum<HeightMode> {
        private static final /* synthetic */ HeightMode[] $VALUES = null;
        public static final HeightMode FULL_HEIGHT = null;
        public static final HeightMode WRAP_HEIGHT = null;

        private static final /* synthetic */ HeightMode[] $values() {
            return new HeightMode[]{FULL_HEIGHT, WRAP_HEIGHT};
        }

        public static HeightMode valueOf(String r1) {
            return (HeightMode) Enum.valueOf(HeightMode.class, r1);
        }

        public static HeightMode[] values() {
            return (HeightMode[]) $VALUES.clone();
        }

        private HeightMode(String r1, int r2) {
            super(r1, r2);
        }

        static {
            FULL_HEIGHT = new HeightMode("FULL_HEIGHT", 0);
            WRAP_HEIGHT = new HeightMode("WRAP_HEIGHT", 1);
            $VALUES = $values();
        }
    }

    public static /* synthetic */ void $r8$lambda$dcpCL1sVjB328hijd3vWqjEcBbk(OSheet r0, View r1) {
        m1385show$lambda1(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$y2QNsFDOZCi77fSVAJcdekGQoFY(OSheet r0) {
        m1384onStart$lambda4(r0);
    }

    static {
        Companion = new Companion(null);
    }

    public OSheet(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        this(r10, 0, 0, false, false, 30, null);
    }

    public OSheet(Context r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        this(r10, r11, 0, false, false, 28, null);
    }

    public OSheet(Context r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        this(r10, r11, r12, false, false, 24, null);
    }

    public OSheet(Context r10, int r11, int r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        this(r10, r11, r12, r13, false, 16, null);
    }

    public /* synthetic */ OSheet(Context r8, int r9, int r10, boolean r11, boolean r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L5;
        int r3 = 0;
    L7:
        if ((r13 & 4) == 0) goto L9;
        int r4 = 0;
    L11:
        if ((r13 & 8) == 0) goto L13;
        boolean r5 = false;
    L15:
        if ((r13 & 16) == 0) goto L17;
        r12 = true;
    L17:
        this(r8, r3, r4, r5, r12);
        return;
    L13:
        r5 = r11;
        goto L15
    L9:
        r4 = r10;
        goto L11
    L5:
        r3 = r9;
        goto L7
    }

    public static final /* synthetic */ DialogExtInterface.OnConfigurationListener access$getConfigurationListener$p(OSheet r0) {
        return r0.configurationListener;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void applyMaterial(boolean r1) {
        OSheetBase.DefaultImpls.applyMaterial(this, r1);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void calculateBodyMaxHeight() {
        OSheetBase.DefaultImpls.calculateBodyMaxHeight(this);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void enableIgnoreInsetBottom(boolean r1) {
        OSheetBase.DefaultImpls.enableIgnoreInsetBottom(this, r1);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase, com.obric.oui.sheet.v2.SheetMoveDelegate
    public void fling(float r1, float r2) {
        OSheetBase.DefaultImpls.fling(this, r1, r2);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public int getContentLayoutResId() {
        return OSheetBase.DefaultImpls.getContentLayoutResId(this);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public View getEndActionButton() {
        return OSheetBase.DefaultImpls.getEndActionButton(this);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public OSheetTitleBar getHeaderTitleBar() {
        return OSheetBase.DefaultImpls.getHeaderTitleBar(this);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public int getMaxBodyHeight() {
        return OSheetBase.DefaultImpls.getMaxBodyHeight(this);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public View getNegativeButton() {
        return OSheetBase.DefaultImpls.getNegativeButton(this);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public View getPositiveButton() {
        return OSheetBase.DefaultImpls.getPositiveButton(this);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public View getStartActionButton() {
        return OSheetBase.DefaultImpls.getStartActionButton(this);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void initBgColor() {
        OSheetBase.DefaultImpls.initBgColor(this);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public boolean isDarkTheme() {
        return OSheetBase.DefaultImpls.isDarkTheme(this);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public boolean isRootContainerMaxHeight() {
        return OSheetBase.DefaultImpls.isRootContainerMaxHeight(this);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase, com.obric.oui.sheet.v2.SheetMoveDelegate
    public void move(float r1, float r2, boolean r3) {
        OSheetBase.DefaultImpls.move(this, r1, r2, r3);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void onPostShow() {
        OSheetBase.DefaultImpls.onPostShow(this);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void performEnterAnimation() {
        OSheetBase.DefaultImpls.performEnterAnimation(this);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void performExitAnimation(float r1) {
        OSheetBase.DefaultImpls.performExitAnimation(this, r1);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void registerConfigurationCallbackIfNeeded() {
        OSheetBase.DefaultImpls.registerConfigurationCallbackIfNeeded(this);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void removeOnApplyWindowInsetsListener() {
        OSheetBase.DefaultImpls.removeOnApplyWindowInsetsListener(this);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setBodyView(View r1) {
        OSheetBase.DefaultImpls.setBodyView(this, r1);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setFooterButton(Integer r8, boolean r9, View.OnClickListener r10, Integer r11, boolean r12, View.OnClickListener r13) {
        OSheetBase.DefaultImpls.setFooterButton(this, r8, r9, r10, r11, r12, r13);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setFooterButton(String r8, boolean r9, View.OnClickListener r10, String r11, boolean r12, View.OnClickListener r13) {
        OSheetBase.DefaultImpls.setFooterButton(this, r8, r9, r10, r11, r12, r13);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setFooterView(View r1) {
        OSheetBase.DefaultImpls.setFooterView(this, r1);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setHeader(Header r16, Integer r17, Integer r18, String r19, String r20, boolean r21, View.OnClickListener r22, View.OnClickListener r23, Integer r24, Integer r25, String r26, String r27, Integer r28, Integer r29) {
        OSheetBase.DefaultImpls.setHeader(this, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setHeaderView(View r1) {
        OSheetBase.DefaultImpls.setHeaderView(this, r1);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setHeightMode(HeightMode r1) {
        OSheetBase.DefaultImpls.setHeightMode(this, r1);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setOnApplyWindowInsetsListener() {
        OSheetBase.DefaultImpls.setOnApplyWindowInsetsListener(this);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setSheetBgColor(int r1) {
        OSheetBase.DefaultImpls.setSheetBgColor(this, r1);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void unregisterConfigurationCallbackIfNeeded() {
        OSheetBase.DefaultImpls.unregisterConfigurationCallbackIfNeeded(this);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void updateFullWindowSize() {
        OSheetBase.DefaultImpls.updateFullWindowSize(this);
    }

    public OSheet(Context r2, int r3, int r4, boolean r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.enableDimAnim = true;
        this.enableEnterAnim = true;
        this.heightStyle = HeightMode.WRAP_HEIGHT;
        this.isContentOverlayMode = r5;
        this.decorForceFullScreen = true;
        this.mCancelable = true;
        this.userWindowHeight = r3;
        boolean r7 = false;
        this.fullWindowSize = new Size(0, 0);
        this.autoAddBodyPaddingTopWhenOverlay = true;
        this.configurationCallback = new OSheet$configurationCallback$1(this);
        this.bgColor = -1;
        if (r6 == true) goto L5;
    L10:
        Window r8 = getWindow();
        if (r8 == null) goto L14;
        r8.requestFeature(1);
    L14:
        setContentView(getContentLayoutResId());
        setupView(r2);
        return;
    L5:
        if (OMaterialExtBaseKt.isMaterialEffectEnabled(r2) == true) goto L7;
    L9:
        setEnableMaterial(r7);
        goto L10
    L7:
        if (OMaterialHelper.isWidgetMaterialEffectEnabled() == false) goto L9;
        r7 = true;
        goto L9
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public Context getSheetContext() {
        Context r1 = getContext();
        Intrinsics.checkNotNullExpressionValue(r1, "context");
        return r1;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public ViewGroup getScaffoldContainer() {
        ViewGroup r0 = this.scaffoldContainer;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("scaffoldContainer");
        return null;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setScaffoldContainer(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.scaffoldContainer = r2;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public View getDimView() {
        View r0 = this.dimView;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("dimView");
        return null;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setDimView(View r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.dimView = r2;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public RadiusLayout getRootContainer() {
        RadiusLayout r0 = this.rootContainer;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("rootContainer");
        return null;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setRootContainer(RadiusLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.rootContainer = r2;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public FrameLayout getHeaderContainer() {
        FrameLayout r0 = this.headerContainer;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("headerContainer");
        return null;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setHeaderContainer(FrameLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.headerContainer = r2;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public FrameLayout getFooterContainer() {
        FrameLayout r0 = this.footerContainer;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("footerContainer");
        return null;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setFooterContainer(FrameLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.footerContainer = r2;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public FrameLayout getBodyContainer() {
        FrameLayout r0 = this.bodyContainer;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("bodyContainer");
        return null;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setBodyContainer(FrameLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.bodyContainer = r2;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public boolean getMClearDimFlag() {
        return this.mClearDimFlag;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setMClearDimFlag(boolean r1) {
        this.mClearDimFlag = r1;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public boolean getEnableDimAnim() {
        return this.enableDimAnim;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setEnableDimAnim(boolean r1) {
        this.enableDimAnim = r1;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public boolean getEnableEnterAnim() {
        return this.enableEnterAnim;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setEnableEnterAnim(boolean r1) {
        this.enableEnterAnim = r1;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public OSheetScaffoldController getScaffoldController() {
        OSheetScaffoldController r0 = this.scaffoldController;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("scaffoldController");
        return null;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setScaffoldController(OSheetScaffoldController r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.scaffoldController = r2;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public HeightMode getHeightStyle() {
        return this.heightStyle;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setHeightStyle(HeightMode r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.heightStyle = r2;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public boolean isContentOverlayMode() {
        return this.isContentOverlayMode;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setContentOverlayMode(boolean r1) {
        this.isContentOverlayMode = r1;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public boolean getMCancelable() {
        return this.mCancelable;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setMCancelable(boolean r1) {
        this.mCancelable = r1;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public int getUserWindowWidth() {
        return this.userWindowWidth;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setUserWindowWidth(int r1) {
        this.userWindowWidth = r1;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public int getUserWindowHeight() {
        return this.userWindowHeight;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setUserWindowHeight(int r1) {
        this.userWindowHeight = r1;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public Size getFullWindowSize() {
        return this.fullWindowSize;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setFullWindowSize(Size r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.fullWindowSize = r2;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public Boolean getSystemInsetsAppearanceLightValue() {
        return this.systemInsetsAppearanceLightValue;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setSystemInsetsAppearanceLightValue(Boolean r1) {
        this.systemInsetsAppearanceLightValue = r1;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public boolean getIgnoreInsetBottom() {
        return this.ignoreInsetBottom;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setIgnoreInsetBottom(boolean r1) {
        this.ignoreInsetBottom = r1;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public AnimationManager getRunningAnim() {
        return this.runningAnim;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setRunningAnim(AnimationManager r1) {
        this.runningAnim = r1;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public int getBodyContentPaddingTop() {
        return this.bodyContentPaddingTop;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setBodyContentPaddingTop(int r1) {
        this.bodyContentPaddingTop = r1;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public int getBodyContentPaddingBottom() {
        return this.bodyContentPaddingBottom;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setBodyContentPaddingBottom(int r1) {
        this.bodyContentPaddingBottom = r1;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public boolean getAutoAddBodyPaddingTopWhenOverlay() {
        return this.autoAddBodyPaddingTopWhenOverlay;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setAutoAddBodyPaddingTopWhenOverlay(boolean r1) {
        this.autoAddBodyPaddingTopWhenOverlay = r1;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public boolean getEnableMaterial() {
        return this.enableMaterial;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setEnableMaterial(boolean r1) {
        this.enableMaterial = r1;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public boolean getShowing() {
        return this.showing;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setShowing(boolean r1) {
        this.showing = r1;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public boolean getConfigurationCallbackRegistered() {
        return this.configurationCallbackRegistered;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setConfigurationCallbackRegistered(boolean r1) {
        this.configurationCallbackRegistered = r1;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public ComponentCallbacks getConfigurationCallback() {
        return this.configurationCallback;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setConfigurationCallback(ComponentCallbacks r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.configurationCallback = r2;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public float getRootTransMoveStartX() {
        return this.rootTransMoveStartX;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setRootTransMoveStartX(float r1) {
        this.rootTransMoveStartX = r1;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public float getRootTransMoveStartY() {
        return this.rootTransMoveStartY;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setRootTransMoveStartY(float r1) {
        this.rootTransMoveStartY = r1;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public int getBgColor() {
        return this.bgColor;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setBgColor(int r1) {
        this.bgColor = r1;
    }

    public final boolean getDoShowAnimation() {
        return this.doShowAnimation;
    }

    public final void setDoShowAnimation(boolean r1) {
        this.doShowAnimation = r1;
    }

    public final int getMaxRootHeight() {
        return getScaffoldController().getMaxRootHeight();
    }

    public final void setMaxRootHeight(int r2) {
        getScaffoldController().setMaxRootHeight(r2);
        updateRootHeight();
    }

    public final void setFullScreen(boolean r2) {
        if (this.decorForceFullScreen == r2) goto L6;
        this.decorForceFullScreen = r2;
        updateRootSize();
        return;
    }

    public final void setOnShowAnimListener(DialogExtInterface.OnShowAnimListener r1) {
        this.showAnimListener = r1;
    }

    public final void setOnDismissAnimListener(DialogExtInterface.OnDismissAnimListener r1) {
        this.dismissAnimListener = r1;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setOverlayModeAutoBodyPaddingTopEnabled(boolean r1) {
        OSheetBase.DefaultImpls.setOverlayModeAutoBodyPaddingTopEnabled(this, r1);
    }

    public final void setOnConfigurationListener(DialogExtInterface.OnConfigurationListener r1) {
        this.configurationListener = r1;
    }

    public final void setSystemInsetsAppearanceLight(Boolean r1) {
        setSystemInsetsAppearanceLightValue(r1);
    }

    private final void updateRootSize() {
        updateRootWidth();
        updateRootHeight();
    }

    private final void updateRootWidth() {
        getScaffoldController().updateRootWidth();
    }

    private final void updateRootHeight() {
        getScaffoldController().updateRootHeight();
    }

    private final void setupSystemInsets(Window r2) {
        if (r2 == null) goto L6;
        r2.setNavigationBarContrastEnforced(false);
    L6:
        if (r2 == null) goto L9;
        r2.clearFlags(VCardConfig.FLAG_CONVERT_PHONETIC_NAME_STRINGS);
    L9:
        if (r2 == null) goto L12;
        r2.addFlags(Integer.MIN_VALUE);
    L12:
        if (r2 == null) goto L15;
        r2.setNavigationBarColor(0);
    L15:
        if (r2 == null) goto L18;
        r2.setDecorFitsSystemWindows(false);
    L18:
        if (r2 == null) goto L22;
        r2.setNavigationBarDividerColor(0);
        return;
    }

    private final void setupSystemInsetsAppearance(Window r5) {
        Boolean r0 = getSystemInsetsAppearanceLightValue();
        int r1 = 0;
        if (r0 == null) goto L5;
        boolean r4 = r0.booleanValue();
    L9:
        if (r5 == null) goto L19;
        WindowInsetsController r2 = r5.getInsetsController();
        if (r2 == null) goto L19;
        if (r4 == false) goto L17;
        int r3 = 8;
    L18:
        r2.setSystemBarsAppearance(r3, 8);
        goto L19
    L17:
        r3 = 0;
    L19:
        if (r5 == null) goto L29;
        WindowInsetsController r6 = r5.getInsetsController();
        if (r6 != null) goto L25;
        return;
    L25:
        if (r4 == false) goto L27;
        r1 = 16;
    L27:
        r6.setSystemBarsAppearance(r1, 16);
        return;
    L29:
        return;
    L5:
        if ((getContext().getResources().getConfiguration().uiMode & 48) == 32) goto L7;
        r4 = true;
        goto L9
    L7:
        r4 = false;
        goto L9
    }

    public final void setClearDimFlag(boolean r1) {
        setMClearDimFlag(r1);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public <T extends View> T getViewById(int r1) {
        T r0 = (T) findViewById(r1);
        Intrinsics.checkNotNullExpressionValue(r0, "findViewById(id)");
        return r0;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setupView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        OSheetBase.DefaultImpls.setupView(this, r2);
        updateMaterial();
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void updateMaterial() {
        applyMaterial(true);
        OMaterialExtBaseKt.setMaterialBackdropTarget(getRootContainer(), getDimView());
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setupDimView(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        setDimView(new View(r3));
        if ((getRootContainer().getParent() instanceof ViewGroup) == false) goto L9;
        ViewParent r4 = getRootContainer().getParent();
        if (r4 == null) goto L8;
        ((ViewGroup) r4).addView(getDimView(), 0, new ViewGroup.LayoutParams(-1, -1));
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    private final boolean useWindowDimInternal() {
        return !this.decorForceFullScreen;
    }

    @Override // android.app.Dialog
    public void show() {
        if (getShowing() == false) goto L5;
        updateFullWindowSize();
        getScaffoldController().refreshForConfiguration(getFullWindowSize());
    L9:
        super.show();
        setOnApplyWindowInsetsListener();
        Window r0 = getWindow();
        if (r0 == null) goto L49;
        r0.setSoftInputMode(48);
        r0.setBackgroundDrawableResource(R.color.transparent);
        setupSystemInsets(r0);
        setupSystemInsetsAppearance(r0);
        if (getMClearDimFlag() == false) goto L15;
        r0.clearFlags(2);
    L16:
        Context r2 = r0.getContext();
        Intrinsics.checkNotNullExpressionValue(r2, "context");
        float r3 = OSheetBaseKt.getTargetDimAmount(r2);
        WindowManager.LayoutParams r4 = r0.getAttributes();
        if (getHeightStyle() != HeightMode.FULL_HEIGHT) goto L19;
    L22:
        boolean r5 = true;
    L23:
        this.decorFullScreen = r5;
        boolean r6 = useWindowDimInternal();
        if (r6 == false) goto L26;
    L29:
        ViewExtensionsKt.makeGone(getDimView());
    L31:
        if (getShowing() == true) goto L34;
        r4.dimAmount = 0.0f;
        getDimView().setAlpha(0.0f);
    L34:
        if (needDimAnim() == true) goto L36;
    L37:
        if (r6 == false) goto L39;
        r4.dimAmount = r3;
    L41:
        if (this.decorFullScreen == false) goto L43;
        int r7 = -1;
    L44:
        r0.setLayout(-1, r7);
        if (this.decorFullScreen == false) goto L47;
        r4.setFitInsetsSides(0);
    L48:
        r4.layoutInDisplayCutoutMode = 3;
        r4.gravity = 80;
        r4.windowAnimations = 0;
        r0.setAttributes(r4);
        goto L49
    L47:
        r4.setFitInsetsSides(WindowInsets.Side.all() ^ 8);
        goto L48
    L43:
        r7 = -2;
        goto L44
    L39:
        r4.dimAmount = 0.0f;
        getDimView().setAlpha(r3);
        goto L41
    L36:
        if (getEnableEnterAnim() == true) goto L41;
    L26:
        if (getMClearDimFlag() == true) goto L29;
        ViewExtensionsKt.makeVisible(getDimView());
        goto L31
    L19:
        if (this.decorForceFullScreen == true) goto L22;
        r5 = false;
        goto L23
    L15:
        r0.addFlags(2);
    L49:
        setShowing(true);
        return;
    L5:
        if (getMCancelable() == false) goto L7;
        getDimView().setOnClickListener(new OSheet$$ExternalSyntheticLambda0(this));
        goto L9
    L7:
        getDimView().setOnClickListener(null);
        goto L9
    }

    /* JADX INFO: renamed from: show$lambda-1, reason: not valid java name */
    private static final void m1385show$lambda1(OSheet r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.dismiss();
    }

    @Override // android.app.Dialog, com.obric.oui.sheet.v2.OSheetBase
    public void setCanceledOnTouchOutside(boolean r1) {
        super.setCanceledOnTouchOutside(r1);
        setMCancelable(r1);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle r1) {
        super.onCreate(r1);
        if (r1 == null) goto L5;
        return;
    L5:
        if (getEnableEnterAnim() == false) goto L9;
        getRootContainer().setAlpha(0.0f);
        return;
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
        registerConfigurationCallbackIfNeeded();
        calculateBodyMaxHeight();
        getRootContainer().post(new OSheet$$ExternalSyntheticLambda1(this));
    }

    /* JADX INFO: renamed from: onStart$lambda-4, reason: not valid java name */
    private static final void m1384onStart$lambda4(OSheet r2) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        r2.onPostShow();
        if (r2.doShowAnimation == true) goto L6;
        r2.getRootContainer().setAlpha(0.0f);
        r2.doShowAnimation = true;
        r2.performEnterAnimation();
        return;
    }

    @Override // android.app.Dialog
    protected void onStop() {
        unregisterConfigurationCallbackIfNeeded();
        super.onStop();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        removeOnApplyWindowInsetsListener();
        OSheetBase.DefaultImpls.performExitAnimation$default(this, 0.0f, 1, null);
        this.doShowAnimation = false;
    }

    private final void originDismiss() {
    L6:
        e = move-exception;
        Log.e("OSheet", "origin Dismiss exception!", e);
        return;
    L3:
        if (isShowing() == false) goto L11;
        super.dismiss();     // Catch: Exception -> L6
        return;
    }

    public final void dismissImmediately() {
        setRunningAnim(null);     // Catch: Exception -> L7
        setOnDismissListener(null);     // Catch: Exception -> L7
        if (isShowing() == false) goto L12;
        super.dismiss();     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        Log.e("OSheet", "dismissImmediately exception!", e);
    }

    public final void setChildToParent(ViewGroup r1, View r2) {
        getScaffoldController().setChildToParent(r1, r2);
    }

    public final void addChildToParent(ViewGroup r1, View r2) {
        getScaffoldController().addChildToParent(r1, r2);
    }

    public final void forceHideFirstFrame() {
        this.hideFirstFrame = true;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public Window windowForAnim() {
        return getWindow();
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public boolean useWindowDim() {
        return useWindowDimInternal();
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public boolean needDimAnim() {
        if (getEnableDimAnim() == true) goto L5;
    L7:
        return false;
    L5:
        if (getMClearDimFlag() == true) goto L7;
        return true;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void onShowAnimStart() {
        DialogExtInterface.OnShowAnimListener r0 = this.showAnimListener;
        if (r0 == null) goto L7;
        r0.onShowAnimStart(this);
        return;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void onShowAnimEnd() {
        DialogExtInterface.OnShowAnimListener r0 = this.showAnimListener;
        if (r0 == null) goto L7;
        r0.onShowAnimEnd(this);
        return;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void onDismissAnimStart() {
        DialogExtInterface.OnDismissAnimListener r0 = this.dismissAnimListener;
        if (r0 == null) goto L7;
        r0.onDismissAnimStart(this);
        return;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void onDismissAnimEnd() {
        DialogExtInterface.OnDismissAnimListener r0 = this.dismissAnimListener;
        if (r0 == null) goto L7;
        r0.onDismissAnimEnd(this);
        return;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void onDismissComplete() {
        originDismiss();
    }
}
