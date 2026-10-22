package com.obric.oui.sheet.v2;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.security.bytedance.guard.BDSecurityGuardStub;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.exifinterface.media.ExifInterface;
import com.obric.common.oea.foundation.animation.builder.PropertyAnimatable;
import com.obric.common.oea.foundation.animation.manager.AnimationManager;
import com.obric.common.oui.R;
import com.obric.oui.color.OPalette;
import com.obric.oui.dialog.alert.view.RadiusLayout;
import com.obric.oui.material.MaterialConfig;
import com.obric.oui.material.MaterialToken;
import com.obric.oui.material.OMaterialExtBaseKt;
import com.obric.oui.utils.ViewUtilKt;
import com.obric.oui.window.OWindowConfigController;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import obric.widget.calendar.MonthWeekEventsView;

/* JADX INFO: compiled from: OSheetBase.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0013\u0010\u0082\u0001\u001a\u00030\u0083\u00012\u0007\u0010\u0084\u0001\u001a\u00020\u0003H\u0016J\n\u0010\u0085\u0001\u001a\u00030\u0083\u0001H\u0016J\u0013\u0010\u0086\u0001\u001a\u00030\u0083\u00012\u0007\u0010\u0087\u0001\u001a\u00020\u0003H\u0016J\u001c\u0010\u0088\u0001\u001a\u00030\u0083\u00012\u0007\u0010\u0089\u0001\u001a\u00020V2\u0007\u0010\u008a\u0001\u001a\u00020VH\u0016J\t\u0010\u008b\u0001\u001a\u00020\tH\u0016J\u000b\u0010\u008c\u0001\u001a\u0004\u0018\u00010$H\u0016J\f\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008e\u0001H\u0016J\t\u0010\u008f\u0001\u001a\u00020\tH\u0016J\u000b\u0010\u0090\u0001\u001a\u0004\u0018\u00010$H\u0016J\u000b\u0010\u0091\u0001\u001a\u0004\u0018\u00010$H\u0016J\u000b\u0010\u0092\u0001\u001a\u0004\u0018\u00010$H\u0016J&\u0010\u0093\u0001\u001a\u0003H\u0094\u0001\"\t\b\u0000\u0010\u0094\u0001*\u00020$2\t\b\u0001\u0010\u0095\u0001\u001a\u00020\tH&¢\u0006\u0003\u0010\u0096\u0001J\n\u0010\u0097\u0001\u001a\u00030\u0083\u0001H\u0016J\t\u0010\u0098\u0001\u001a\u00020\u0003H\u0016J\t\u0010\u0099\u0001\u001a\u00020\u0003H\u0016J%\u0010\u009a\u0001\u001a\u00030\u0083\u00012\u0007\u0010\u009b\u0001\u001a\u00020V2\u0007\u0010\u009c\u0001\u001a\u00020V2\u0007\u0010\u009d\u0001\u001a\u00020\u0003H\u0016J\t\u0010\u009e\u0001\u001a\u00020\u0003H&J\n\u0010\u009f\u0001\u001a\u00030\u0083\u0001H&J\n\u0010 \u0001\u001a\u00030\u0083\u0001H&J\n\u0010¡\u0001\u001a\u00030\u0083\u0001H&J\n\u0010¢\u0001\u001a\u00030\u0083\u0001H\u0016J\n\u0010£\u0001\u001a\u00030\u0083\u0001H&J\n\u0010¤\u0001\u001a\u00030\u0083\u0001H&J\n\u0010¥\u0001\u001a\u00030\u0083\u0001H\u0016J\u0015\u0010¦\u0001\u001a\u00030\u0083\u00012\t\b\u0002\u0010\u008a\u0001\u001a\u00020VH\u0016J\n\u0010§\u0001\u001a\u00030\u0083\u0001H\u0016J\n\u0010¨\u0001\u001a\u00030\u0083\u0001H\u0016J\u0015\u0010©\u0001\u001a\u00030\u0083\u00012\t\u0010ª\u0001\u001a\u0004\u0018\u00010$H\u0016J\u0013\u0010«\u0001\u001a\u00030\u0083\u00012\u0007\u0010¬\u0001\u001a\u00020\u0003H\u0016J\\\u0010\u00ad\u0001\u001a\u00030\u0083\u00012\u000b\b\u0002\u0010®\u0001\u001a\u0004\u0018\u00010\t2\t\b\u0002\u0010¯\u0001\u001a\u00020\u00032\f\b\u0002\u0010°\u0001\u001a\u0005\u0018\u00010±\u00012\u000b\b\u0002\u0010²\u0001\u001a\u0004\u0018\u00010\t2\t\b\u0002\u0010³\u0001\u001a\u00020\u00032\f\b\u0002\u0010´\u0001\u001a\u0005\u0018\u00010±\u0001H\u0016¢\u0006\u0003\u0010µ\u0001JX\u0010\u00ad\u0001\u001a\u00030\u0083\u00012\f\b\u0002\u0010¶\u0001\u001a\u0005\u0018\u00010·\u00012\t\b\u0002\u0010¯\u0001\u001a\u00020\u00032\f\b\u0002\u0010°\u0001\u001a\u0005\u0018\u00010±\u00012\f\b\u0002\u0010¸\u0001\u001a\u0005\u0018\u00010·\u00012\t\b\u0002\u0010³\u0001\u001a\u00020\u00032\f\b\u0002\u0010´\u0001\u001a\u0005\u0018\u00010±\u0001H\u0016J\u0015\u0010¹\u0001\u001a\u00030\u0083\u00012\t\u0010ª\u0001\u001a\u0004\u0018\u00010$H\u0016JÃ\u0001\u0010º\u0001\u001a\u00030\u0083\u00012\b\u0010»\u0001\u001a\u00030¼\u00012\u000b\b\u0002\u0010½\u0001\u001a\u0004\u0018\u00010\t2\u000b\b\u0002\u0010¾\u0001\u001a\u0004\u0018\u00010\t2\f\b\u0002\u0010¿\u0001\u001a\u0005\u0018\u00010·\u00012\f\b\u0002\u0010À\u0001\u001a\u0005\u0018\u00010·\u00012\t\b\u0002\u0010Á\u0001\u001a\u00020\u00032\n\u0010Â\u0001\u001a\u0005\u0018\u00010±\u00012\n\u0010Ã\u0001\u001a\u0005\u0018\u00010±\u00012\u000b\b\u0002\u0010Ä\u0001\u001a\u0004\u0018\u00010\t2\u000b\b\u0002\u0010Å\u0001\u001a\u0004\u0018\u00010\t2\f\b\u0002\u0010Æ\u0001\u001a\u0005\u0018\u00010·\u00012\f\b\u0002\u0010Ç\u0001\u001a\u0005\u0018\u00010·\u00012\u000b\b\u0002\u0010È\u0001\u001a\u0004\u0018\u00010\t2\u000b\b\u0002\u0010É\u0001\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0003\u0010Ê\u0001J\u0015\u0010Ë\u0001\u001a\u00030\u0083\u00012\t\u0010ª\u0001\u001a\u0004\u0018\u00010$H\u0016J\u0013\u0010Ì\u0001\u001a\u00030\u0083\u00012\u0007\u0010Í\u0001\u001a\u00020?H\u0016J\n\u0010Î\u0001\u001a\u00030\u0083\u0001H\u0016J\u0013\u0010Ï\u0001\u001a\u00030\u0083\u00012\u0007\u0010Ð\u0001\u001a\u00020\u0003H\u0016J\u0013\u0010Ñ\u0001\u001a\u00030\u0083\u00012\u0007\u0010Ò\u0001\u001a\u00020\tH\u0016J\u0013\u0010Ó\u0001\u001a\u00030\u0083\u00012\u0007\u0010Ô\u0001\u001a\u00020qH&J\u0013\u0010Õ\u0001\u001a\u00030\u0083\u00012\u0007\u0010Ô\u0001\u001a\u00020qH\u0016J\n\u0010Ö\u0001\u001a\u00030\u0083\u0001H\u0016J\n\u0010×\u0001\u001a\u00030\u0083\u0001H\u0016J\n\u0010Ø\u0001\u001a\u00030\u0083\u0001H&J\t\u0010Ù\u0001\u001a\u00020\u0003H&J\f\u0010Ú\u0001\u001a\u0005\u0018\u00010Û\u0001H&R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u00020\tX¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u00020\u000fX¦\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0014\u001a\u00020\tX¦\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u000b\"\u0004\b\u0016\u0010\rR\u0018\u0010\u0017\u001a\u00020\tX¦\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u000b\"\u0004\b\u0019\u0010\rR\u0018\u0010\u001a\u001a\u00020\u001bX¦\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0018\u0010 \u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b!\u0010\u0005\"\u0004\b\"\u0010\u0007R\u0018\u0010#\u001a\u00020$X¦\u000e¢\u0006\f\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0018\u0010)\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b*\u0010\u0005\"\u0004\b+\u0010\u0007R\u0018\u0010,\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b-\u0010\u0005\"\u0004\b.\u0010\u0007R\u0018\u0010/\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b0\u0010\u0005\"\u0004\b1\u0010\u0007R\u0018\u00102\u001a\u00020\u000fX¦\u000e¢\u0006\f\u001a\u0004\b3\u0010\u0011\"\u0004\b4\u0010\u0013R\u0018\u00105\u001a\u000206X¦\u000e¢\u0006\f\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u0018\u0010;\u001a\u00020\u000fX¦\u000e¢\u0006\f\u001a\u0004\b<\u0010\u0011\"\u0004\b=\u0010\u0013R\u0018\u0010>\u001a\u00020?X¦\u000e¢\u0006\f\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u0018\u0010D\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\bE\u0010\u0005\"\u0004\bF\u0010\u0007R\u0018\u0010G\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\bG\u0010\u0005\"\u0004\bH\u0010\u0007R\u0018\u0010I\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\bJ\u0010\u0005\"\u0004\bK\u0010\u0007R\u0018\u0010L\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\bM\u0010\u0005\"\u0004\bN\u0010\u0007R\u0018\u0010O\u001a\u00020PX¦\u000e¢\u0006\f\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u0018\u0010U\u001a\u00020VX¦\u000e¢\u0006\f\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\u0018\u0010[\u001a\u00020VX¦\u000e¢\u0006\f\u001a\u0004\b\\\u0010X\"\u0004\b]\u0010ZR\u001a\u0010^\u001a\u0004\u0018\u00010_X¦\u000e¢\u0006\f\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR\u0018\u0010d\u001a\u00020eX¦\u000e¢\u0006\f\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR\u0018\u0010j\u001a\u00020kX¦\u000e¢\u0006\f\u001a\u0004\bl\u0010m\"\u0004\bn\u0010oR\u0012\u0010p\u001a\u00020qX¦\u0004¢\u0006\u0006\u001a\u0004\br\u0010sR\u0018\u0010t\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\bu\u0010\u0005\"\u0004\bv\u0010\u0007R\u001a\u0010w\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\bx\u0010y\"\u0004\bz\u0010{R\u0018\u0010|\u001a\u00020\tX¦\u000e¢\u0006\f\u001a\u0004\b}\u0010\u000b\"\u0004\b~\u0010\rR\u001a\u0010\u007f\u001a\u00020\tX¦\u000e¢\u0006\u000e\u001a\u0005\b\u0080\u0001\u0010\u000b\"\u0005\b\u0081\u0001\u0010\r¨\u0006Ü\u0001"}, d2 = {"Lcom/obric/oui/sheet/v2/OSheetBase;", "Lcom/obric/oui/sheet/v2/SheetMoveDelegate;", "autoAddBodyPaddingTopWhenOverlay", "", "getAutoAddBodyPaddingTopWhenOverlay", "()Z", "setAutoAddBodyPaddingTopWhenOverlay", "(Z)V", "bgColor", "", "getBgColor", "()I", "setBgColor", "(I)V", "bodyContainer", "Landroid/widget/FrameLayout;", "getBodyContainer", "()Landroid/widget/FrameLayout;", "setBodyContainer", "(Landroid/widget/FrameLayout;)V", "bodyContentPaddingBottom", "getBodyContentPaddingBottom", "setBodyContentPaddingBottom", "bodyContentPaddingTop", "getBodyContentPaddingTop", "setBodyContentPaddingTop", "configurationCallback", "Landroid/content/ComponentCallbacks;", "getConfigurationCallback", "()Landroid/content/ComponentCallbacks;", "setConfigurationCallback", "(Landroid/content/ComponentCallbacks;)V", "configurationCallbackRegistered", "getConfigurationCallbackRegistered", "setConfigurationCallbackRegistered", "dimView", "Landroid/view/View;", "getDimView", "()Landroid/view/View;", "setDimView", "(Landroid/view/View;)V", "enableDimAnim", "getEnableDimAnim", "setEnableDimAnim", "enableEnterAnim", "getEnableEnterAnim", "setEnableEnterAnim", "enableMaterial", "getEnableMaterial", "setEnableMaterial", "footerContainer", "getFooterContainer", "setFooterContainer", "fullWindowSize", "Landroid/util/Size;", "getFullWindowSize", "()Landroid/util/Size;", "setFullWindowSize", "(Landroid/util/Size;)V", "headerContainer", "getHeaderContainer", "setHeaderContainer", "heightStyle", "Lcom/obric/oui/sheet/v2/OSheet$HeightMode;", "getHeightStyle", "()Lcom/obric/oui/sheet/v2/OSheet$HeightMode;", "setHeightStyle", "(Lcom/obric/oui/sheet/v2/OSheet$HeightMode;)V", "ignoreInsetBottom", "getIgnoreInsetBottom", "setIgnoreInsetBottom", "isContentOverlayMode", "setContentOverlayMode", "mCancelable", "getMCancelable", "setMCancelable", "mClearDimFlag", "getMClearDimFlag", "setMClearDimFlag", "rootContainer", "Lcom/obric/oui/dialog/alert/view/RadiusLayout;", "getRootContainer", "()Lcom/obric/oui/dialog/alert/view/RadiusLayout;", "setRootContainer", "(Lcom/obric/oui/dialog/alert/view/RadiusLayout;)V", "rootTransMoveStartX", "", "getRootTransMoveStartX", "()F", "setRootTransMoveStartX", "(F)V", "rootTransMoveStartY", "getRootTransMoveStartY", "setRootTransMoveStartY", "runningAnim", "Lcom/obric/common/oea/foundation/animation/manager/AnimationManager;", "getRunningAnim", "()Lcom/obric/common/oea/foundation/animation/manager/AnimationManager;", "setRunningAnim", "(Lcom/obric/common/oea/foundation/animation/manager/AnimationManager;)V", "scaffoldContainer", "Landroid/view/ViewGroup;", "getScaffoldContainer", "()Landroid/view/ViewGroup;", "setScaffoldContainer", "(Landroid/view/ViewGroup;)V", "scaffoldController", "Lcom/obric/oui/sheet/v2/OSheetScaffoldController;", "getScaffoldController", "()Lcom/obric/oui/sheet/v2/OSheetScaffoldController;", "setScaffoldController", "(Lcom/obric/oui/sheet/v2/OSheetScaffoldController;)V", "sheetContext", "Landroid/content/Context;", "getSheetContext", "()Landroid/content/Context;", "showing", "getShowing", "setShowing", "systemInsetsAppearanceLightValue", "getSystemInsetsAppearanceLightValue", "()Ljava/lang/Boolean;", "setSystemInsetsAppearanceLightValue", "(Ljava/lang/Boolean;)V", "userWindowHeight", "getUserWindowHeight", "setUserWindowHeight", "userWindowWidth", "getUserWindowWidth", "setUserWindowWidth", "applyMaterial", "", "fromWindow", "calculateBodyMaxHeight", "enableIgnoreInsetBottom", "ignore", "fling", "xVelocity", "yVelocity", "getContentLayoutResId", "getEndActionButton", "getHeaderTitleBar", "Lcom/obric/oui/sheet/v2/OSheetTitleBar;", "getMaxBodyHeight", "getNegativeButton", "getPositiveButton", "getStartActionButton", "getViewById", ExifInterface.GPS_DIRECTION_TRUE, "id", "(I)Landroid/view/View;", "initBgColor", "isDarkTheme", "isRootContainerMaxHeight", "move", "dx", "dy", "start", "needDimAnim", "onDismissAnimEnd", "onDismissAnimStart", "onDismissComplete", "onPostShow", "onShowAnimEnd", "onShowAnimStart", "performEnterAnimation", "performExitAnimation", "registerConfigurationCallbackIfNeeded", "removeOnApplyWindowInsetsListener", "setBodyView", "child", "setCanceledOnTouchOutside", BDSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL, "setFooterButton", "negativeBtnTextResId", "negativeIsPrimary", "negativeActionEvent", "Landroid/view/View$OnClickListener;", "positiveBtnTextResId", "positiveIsPrimary", "positiveActionEvent", "(Ljava/lang/Integer;ZLandroid/view/View$OnClickListener;Ljava/lang/Integer;ZLandroid/view/View$OnClickListener;)V", "negativeBtnText", "", "positiveBtnText", "setFooterView", "setHeader", "style", "Lcom/obric/oui/sheet/v2/OSheet$Header;", "titleResId", "subTitleResId", "title", "subTitle", "showHandleView", "startActionEvent", "endActionEvent", "startActionDesResId", "endActionDesResId", "startActionDes", "endActionDesRes", "startActionIconResId", "endActionIconResId", "(Lcom/obric/oui/sheet/v2/OSheet$Header;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;ZLandroid/view/View$OnClickListener;Landroid/view/View$OnClickListener;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "setHeaderView", "setHeightMode", MonthWeekEventsView.VIEW_PARAMS_HEIGHT, "setOnApplyWindowInsetsListener", "setOverlayModeAutoBodyPaddingTopEnabled", "enable", "setSheetBgColor", "color", "setupDimView", "context", "setupView", "unregisterConfigurationCallbackIfNeeded", "updateFullWindowSize", "updateMaterial", "useWindowDim", "windowForAnim", "Landroid/view/Window;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface OSheetBase extends SheetMoveDelegate {

    /* JADX INFO: compiled from: OSheetBase.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void $r8$lambda$STdbAsav1Ti7S2Fh2MCiU0IxfAw(OSheetBase r0) {
            m1386performEnterAnimation$lambda2(r0);
        }

        public static /* synthetic */ void $r8$lambda$WHrYx15gVOGiUmZ83u3oV8dHZM0(OSheetBase r0) {
            m1387performExitAnimation$lambda3(r0);
        }

        public static int getContentLayoutResId(OSheetBase r1) {
            Intrinsics.checkNotNullParameter(r1, "this");
            if (r1.isContentOverlayMode() == false) goto L7;
            return R.layout.o_sheet_container_overlay;
        L7:
            return R.layout.o_sheet_container;
        }

        public static void setupView(OSheetBase r10, Context r11) {
            Intrinsics.checkNotNullParameter(r10, "this");
            Intrinsics.checkNotNullParameter(r11, "context");
            r10.setRootContainer((RadiusLayout) r10.getViewById(R.id.root_constraint));
            r10.setupDimView(r11);
            r10.setHeaderContainer((FrameLayout) r10.getViewById(R.id.header_container));
            r10.setBodyContainer((FrameLayout) r10.getViewById(R.id.body_container));
            r10.setFooterContainer((FrameLayout) r10.getViewById(R.id.footer_container));
            r10.setScaffoldContainer((ViewGroup) r10.getViewById(R.id.scaffold_container));
            r10.updateFullWindowSize();
            r10.setScaffoldController(new OSheetScaffoldController(r11, r10, r10.getRootContainer(), r10.getHeaderContainer(), r10.getBodyContainer(), r10.getFooterContainer(), r10.getScaffoldContainer(), r10.getDimView()));
            r10.getScaffoldController().setHeightStyle(r10.getHeightStyle());
            r10.getScaffoldController().setIgnoreInsetBottom(r10.getIgnoreInsetBottom());
            r10.getScaffoldController().setupRoot(r10.getFullWindowSize());
            r10.initBgColor();
        }

        public static void updateFullWindowSize(OSheetBase r3) {
            Intrinsics.checkNotNullParameter(r3, "this");
            r3.setFullWindowSize(OWindowConfigController.getFullWindowSize(r3.getSheetContext()));
            if (r3.getUserWindowWidth() <= 0) goto L8;
            if (r3.getUserWindowWidth() >= r3.getFullWindowSize().getWidth()) goto L8;
            r3.setFullWindowSize(new Size(r3.getUserWindowWidth(), r3.getFullWindowSize().getHeight()));
        L8:
            if (r3.getUserWindowHeight() > 0) goto L10;
            return;
        L10:
            if (r3.getUserWindowHeight() >= r3.getFullWindowSize().getHeight()) goto L14;
            r3.setFullWindowSize(new Size(r3.getFullWindowSize().getWidth(), r3.getUserWindowHeight()));
            return;
        }

        public static void setHeightMode(OSheetBase r1, OSheet.HeightMode r2) {
            Intrinsics.checkNotNullParameter(r1, "this");
            Intrinsics.checkNotNullParameter(r2, MonthWeekEventsView.VIEW_PARAMS_HEIGHT);
            r1.setHeightStyle(r2);
            r1.getScaffoldController().setHeightStyle(r2);
            r1.getScaffoldController().updateRootHeight();
        }

        public static void enableIgnoreInsetBottom(OSheetBase r1, boolean r2) {
            Intrinsics.checkNotNullParameter(r1, "this");
            r1.setIgnoreInsetBottom(r2);
            r1.getScaffoldController().setIgnoreInsetBottom(r2);
        }

        public static void setOverlayModeAutoBodyPaddingTopEnabled(OSheetBase r1, boolean r2) {
            Intrinsics.checkNotNullParameter(r1, "this");
            if (r1.getAutoAddBodyPaddingTopWhenOverlay() == r2) goto L8;
            r1.setAutoAddBodyPaddingTopWhenOverlay(r2);
            if (r1.getShowing() == false) goto L9;
            r1.onPostShow();
            return;
        L9:
            return;
        }

        public static /* synthetic */ void setHeader$default(OSheetBase r18, OSheet.Header r19, Integer r20, Integer r21, String r22, String r23, boolean r24, View.OnClickListener r25, View.OnClickListener r26, Integer r27, Integer r28, String r29, String r30, Integer r31, Integer r32, int r33, Object r34) {
            if (r34 != null) goto L51;
            if ((r33 & 2) == 0) goto L7;
            Integer r5 = null;
        L9:
            if ((r33 & 4) == 0) goto L11;
            Integer r6 = null;
        L13:
            if ((r33 & 8) == 0) goto L15;
            String r7 = null;
        L17:
            if ((r33 & 16) == 0) goto L19;
            String r8 = null;
        L21:
            if ((r33 & 32) == 0) goto L23;
            boolean r9 = false;
        L25:
            if ((r33 & 256) == 0) goto L27;
            Integer r12 = null;
        L29:
            if ((r33 & 512) == 0) goto L31;
            Integer r13 = null;
        L33:
            if ((r33 & 1024) == 0) goto L35;
            String r14 = null;
        L37:
            if ((r33 & 2048) == 0) goto L39;
            String r15 = null;
        L41:
            if ((r33 & 4096) == 0) goto L43;
            Integer r16 = null;
        L45:
            if ((r33 & 8192) == 0) goto L47;
            Integer r17 = null;
        L48:
            r18.setHeader(r19, r5, r6, r7, r8, r9, r25, r26, r12, r13, r14, r15, r16, r17);
            return;
        L47:
            r17 = r32;
            goto L48
        L43:
            r16 = r31;
            goto L45
        L39:
            r15 = r30;
            goto L41
        L35:
            r14 = r29;
            goto L37
        L31:
            r13 = r28;
            goto L33
        L27:
            r12 = r27;
            goto L29
        L23:
            r9 = r24;
            goto L25
        L19:
            r8 = r23;
            goto L21
        L15:
            r7 = r22;
            goto L17
        L11:
            r6 = r21;
            goto L13
        L7:
            r5 = r20;
            goto L9
        L51:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setHeader");
        }

        public static void setHeader(OSheetBase r18, OSheet.Header r19, Integer r20, Integer r21, String r22, String r23, boolean r24, View.OnClickListener r25, View.OnClickListener r26, Integer r27, Integer r28, String r29, String r30, Integer r31, Integer r32) {
            Intrinsics.checkNotNullParameter(r18, "this");
            Intrinsics.checkNotNullParameter(r19, "style");
            r18.getScaffoldController().setHeader(r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r18);
        }

        public static void setHeaderView(OSheetBase r1, View r2) {
            Intrinsics.checkNotNullParameter(r1, "this");
            r1.getScaffoldController().setHeaderView(r2);
        }

        public static OSheetTitleBar getHeaderTitleBar(OSheetBase r1) {
            Intrinsics.checkNotNullParameter(r1, "this");
            return r1.getScaffoldController().getHeaderTitleBar();
        }

        public static void setSheetBgColor(OSheetBase r3, int r4) {
            Intrinsics.checkNotNullParameter(r3, "this");
            if (r3.getBgColor() == r4) goto L17;
            boolean r0 = r3.isDarkTheme();
            r3.setBgColor(r4);
            boolean r1 = r3.isDarkTheme();
            if (r3.getEnableMaterial() == true) goto L7;
            r3.getRootContainer().setBackgroundColor(r4);
        L8:
            if (r0 == r1) goto L18;
            View r5 = r3.getScaffoldController().getHeaderContainer().getChildAt(0);
            if ((r5 instanceof OSheetTitleBar) == false) goto L19;
            OSheetTitleBar r6 = (OSheetTitleBar) r5;
            if (r1 == false) goto L14;
            int r7 = 2;
        L15:
            r6.applyDynamicTheme(r7);
            return;
        L14:
            r7 = 1;
            goto L15
        L19:
            return;
        L18:
            return;
        L7:
            r3.updateMaterial();
            goto L8
        }

        public static void setBodyView(OSheetBase r1, View r2) {
            Intrinsics.checkNotNullParameter(r1, "this");
            r1.getScaffoldController().setBodyView(r2);
            if (r2 == null) goto L5;
            r1.setBodyContentPaddingTop(r2.getPaddingTop());
            r1.setBodyContentPaddingBottom(r2.getPaddingBottom());
            return;
        L5:
            r1.setBodyContentPaddingTop(0);
            r1.setBodyContentPaddingBottom(0);
        }

        public static void setFooterView(OSheetBase r1, View r2) {
            Intrinsics.checkNotNullParameter(r1, "this");
            r1.getScaffoldController().setFooterView(r2);
        }

        public static /* synthetic */ void setFooterButton$default(OSheetBase r1, Integer r2, boolean r3, View.OnClickListener r4, Integer r5, boolean r6, View.OnClickListener r7, int r8, Object r9) {
            if (r9 != null) goto L24;
            if ((r8 & 1) == 0) goto L7;
            r2 = null;
        L7:
            if ((r8 & 2) == 0) goto L10;
            r3 = false;
        L10:
            if ((r8 & 4) == 0) goto L13;
            r4 = null;
        L13:
            if ((r8 & 8) == 0) goto L16;
            r5 = null;
        L16:
            if ((r8 & 16) == 0) goto L19;
            r6 = true;
        L19:
            if ((r8 & 32) == 0) goto L21;
            r7 = null;
        L21:
            r1.setFooterButton(r2, r3, r4, r5, r6, r7);
            return;
        L24:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setFooterButton");
        }

        public static void setFooterButton(OSheetBase r8, Integer r9, boolean r10, View.OnClickListener r11, Integer r12, boolean r13, View.OnClickListener r14) {
            Intrinsics.checkNotNullParameter(r8, "this");
            r8.getScaffoldController().setFooterButton(r9, r10, r11, r12, r13, r14);
        }

        public static /* synthetic */ void setFooterButton$default(OSheetBase r1, String r2, boolean r3, View.OnClickListener r4, String r5, boolean r6, View.OnClickListener r7, int r8, Object r9) {
            if (r9 != null) goto L24;
            if ((r8 & 1) == 0) goto L7;
            r2 = null;
        L7:
            if ((r8 & 2) == 0) goto L10;
            r3 = false;
        L10:
            if ((r8 & 4) == 0) goto L13;
            r4 = null;
        L13:
            if ((r8 & 8) == 0) goto L16;
            r5 = null;
        L16:
            if ((r8 & 16) == 0) goto L19;
            r6 = true;
        L19:
            if ((r8 & 32) == 0) goto L21;
            r7 = null;
        L21:
            r1.setFooterButton(r2, r3, r4, r5, r6, r7);
            return;
        L24:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setFooterButton");
        }

        public static void setFooterButton(OSheetBase r8, String r9, boolean r10, View.OnClickListener r11, String r12, boolean r13, View.OnClickListener r14) {
            Intrinsics.checkNotNullParameter(r8, "this");
            r8.getScaffoldController().setFooterButton(r9, r10, r11, r12, r13, r14);
        }

        public static int getMaxBodyHeight(OSheetBase r1) {
            Intrinsics.checkNotNullParameter(r1, "this");
            return r1.getScaffoldController().getMaxBodyHeight();
        }

        public static boolean isRootContainerMaxHeight(OSheetBase r1) {
            Intrinsics.checkNotNullParameter(r1, "this");
            return r1.getScaffoldController().isRootContainerMaxHeight();
        }

        public static View getStartActionButton(OSheetBase r2) {
            Intrinsics.checkNotNullParameter(r2, "this");
            View r0 = r2.getHeaderContainer().findViewById(R.id.btn_start_action);
            if (r0 == null) goto L5;
            return r0;
        L5:
            return r2.getHeaderContainer().findViewById(R.id.left_action_back);
        }

        public static View getEndActionButton(OSheetBase r1) {
            Intrinsics.checkNotNullParameter(r1, "this");
            return r1.getHeaderContainer().findViewById(R.id.btn_end_action);
        }

        public static View getNegativeButton(OSheetBase r1) {
            Intrinsics.checkNotNullParameter(r1, "this");
            return r1.getFooterContainer().findViewById(R.id.btn_negative);
        }

        public static View getPositiveButton(OSheetBase r1) {
            Intrinsics.checkNotNullParameter(r1, "this");
            return r1.getFooterContainer().findViewById(R.id.btn_positive);
        }

        public static void setCanceledOnTouchOutside(OSheetBase r1, boolean r2) {
            Intrinsics.checkNotNullParameter(r1, "this");
            r1.setMCancelable(r2);
        }

        public static void calculateBodyMaxHeight(OSheetBase r1) {
            Intrinsics.checkNotNullParameter(r1, "this");
            r1.getScaffoldController().calculateBodyMaxHeight();
        }

        public static void setOnApplyWindowInsetsListener(OSheetBase r1) {
            Intrinsics.checkNotNullParameter(r1, "this");
            r1.getScaffoldController().setOnApplyWindowInsetsListener();
        }

        public static void removeOnApplyWindowInsetsListener(OSheetBase r1) {
            Intrinsics.checkNotNullParameter(r1, "this");
            r1.getScaffoldController().removeOnApplyWindowInsetsListener();
        }

        public static void onPostShow(OSheetBase r5) {
            Intrinsics.checkNotNullParameter(r5, "this");
            r5.calculateBodyMaxHeight();
            int r1 = 0;
            View r0 = r5.getBodyContainer().getChildAt(0);
            if ((r0 instanceof ViewGroup) == false) goto L5;
            ViewGroup r2 = (ViewGroup) r0;
        L6:
            boolean r3 = true;
            if ((r5.getScaffoldContainer() instanceof LinearLayout) == false) goto L18;
            r5.getBodyContainer().setPadding(0, 0, 0, 0);
            if (r2 == null) goto L12;
            r2.setClipToPadding(true);
        L12:
            if (r2 == null) goto L15;
            r2.setPadding(r2.getPaddingLeft(), r5.getBodyContentPaddingTop(), r2.getPaddingRight(), r5.getBodyContentPaddingBottom());
        L15:
            if (r2 == null) goto L45;
            r2.requestLayout();
            return;
        L45:
            return;
        L18:
            FrameLayout r4 = r5.getBodyContainer();
            if (r5.getFooterContainer().getVisibility() != 0) goto L21;
            boolean r6 = true;
        L22:
            if (r6 == false) goto L24;
            int r7 = r5.getFooterContainer().getMeasuredHeight();
        L25:
            r4.setPadding(0, 0, 0, r7);
            if (r2 == null) goto L29;
            r2.setClipToPadding(false);
        L29:
            if (r2 != null) goto L32;
        L40:
            if (r2 == null) goto L46;
            r2.requestLayout();
            return;
        L46:
            return;
        L32:
            if (r5.getAutoAddBodyPaddingTopWhenOverlay() == true) goto L34;
        L39:
            r2.setPadding(r2.getPaddingLeft(), r5.getBodyContentPaddingTop() + r1, r2.getPaddingRight(), r5.getBodyContentPaddingBottom());
            goto L40
        L34:
            if (r5.getHeaderContainer().getVisibility() == 0) goto L37;
            r3 = false;
        L37:
            if (r3 == false) goto L39;
            r1 = r5.getHeaderContainer().getMeasuredHeight();
            goto L39
        L24:
            r7 = 0;
            goto L25
        L21:
            r6 = false;
            goto L22
        L5:
            r2 = null;
            ViewGroup r8 = (ViewGroup) null;
            goto L6
        }

        public static void registerConfigurationCallbackIfNeeded(OSheetBase r2) {
            Intrinsics.checkNotNullParameter(r2, "this");
            if (r2.getConfigurationCallbackRegistered() == false) goto L5;
            return;
        L5:
            r2.getSheetContext().registerComponentCallbacks(r2.getConfigurationCallback());
            r2.setConfigurationCallbackRegistered(true);
        }

        public static void unregisterConfigurationCallbackIfNeeded(OSheetBase r2) {
            Intrinsics.checkNotNullParameter(r2, "this");
            if (r2.getConfigurationCallbackRegistered() == true) goto L5;
            return;
        L5:
            r2.getSheetContext().unregisterComponentCallbacks(r2.getConfigurationCallback());
            r2.setConfigurationCallbackRegistered(false);
        }

        public static void move(OSheetBase r1, float r2, float r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r1, "this");
            if (r4 == false) goto L9;
            r1.setRootTransMoveStartX(r1.getRootContainer().getTranslationX());
            r1.setRootTransMoveStartY(r1.getRootContainer().getTranslationY());
            AnimationManager r5 = r1.getRunningAnim();
            if (r5 == null) goto L11;
            r5.cancelAnimation(true);
            return;
        L11:
            return;
        L9:
            r1.getRootContainer().setTranslationX(r1.getRootTransMoveStartX() + r2);
            r1.getRootContainer().setTranslationY(r1.getRootTransMoveStartY() + r3);
        }

        public static void fling(final OSheetBase r14, float r15, float r16) {
            Intrinsics.checkNotNullParameter(r14, "this");
            if (SheetAnimStyle.shouldDismiss$default(SheetAnimStyle.INSTANCE, r14.getRootContainer(), r16, 0.0f, 4, null) == false) goto L5;
            r14.performExitAnimation(r16);
            return;
        L5:
            AnimationManager r2 = r14.getRunningAnim();
            if (r2 == null) goto L9;
            AnimationManager.cancelAnimation$default(r2, false, 1, null);
        L9:
            r14.setRunningAnim(PropertyAnimatable.start$default(SheetAnimStyle.sheetPositionSmoothReset$default(SheetAnimStyle.INSTANCE, r14.getRootContainer(), r14.windowForAnim(), r14.getDimView(), r14.needDimAnim(), r14.useWindowDim(), OSheetBaseKt.getTargetDimAmount(r14.getSheetContext()), r16, null, 64, null).onEnd(new AnonymousClass1(r14)).build(), null, null, 3, null));
        }

        public static void performEnterAnimation(final OSheetBase r4) {
            Intrinsics.checkNotNullParameter(r4, "this");
            AnimationManager r0 = r4.getRunningAnim();
            if (r0 == null) goto L7;
            AnimationManager.cancelAnimation$default(r0, false, 1, null);
        L7:
            if (r4.getEnableEnterAnim() == true) goto L10;
            r4.calculateBodyMaxHeight();
            r4.getRootContainer().setAlpha(1.0f);
            r4.getRootContainer().setTranslationY(0.0f);
            SheetAnimStyle.INSTANCE.clearSheetAnimator(r4.getRootContainer(), R.id.o_dialog_anim_in);
            r4.setRunningAnim(null);
            r4.onShowAnimStart();
            r4.onShowAnimEnd();
            return;
        L10:
            r4.getRootContainer().setAlpha(0.0f);
            r4.getRootContainer().post(new OSheetBase$DefaultImpls$$ExternalSyntheticLambda0(r4));
        }

        /* JADX INFO: renamed from: performEnterAnimation$lambda-2, reason: not valid java name */
        private static void m1386performEnterAnimation$lambda2(final OSheetBase r11) {
            Intrinsics.checkNotNullParameter(r11, "this$0");
            r11.setRunningAnim(PropertyAnimatable.start$default(SheetAnimStyle.sheetShow$default(SheetAnimStyle.INSTANCE, r11.getRootContainer(), r11.windowForAnim(), r11.getDimView(), r11.needDimAnim(), r11.useWindowDim(), OSheetBaseKt.getTargetDimAmount(r11.getSheetContext()), null, 32, null).onEnd(new OSheetBase$performEnterAnimation$1$animBuilder$1(r11)).build(), null, null, 3, null));
            r11.onShowAnimStart();
        }

        public static /* synthetic */ void performExitAnimation$default(OSheetBase r0, float r1, int r2, Object r3) {
            if (r3 != null) goto L9;
            if ((r2 & 1) == 0) goto L6;
            r1 = 0.0f;
        L6:
            r0.performExitAnimation(r1);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: performExitAnimation");
        }

        public static void performExitAnimation(final OSheetBase r16, float r17) {
            Intrinsics.checkNotNullParameter(r16, "this");
            AnimationManager r1 = r16.getRunningAnim();
            if (r1 == null) goto L6;
            AnimationManager.cancelAnimation$default(r1, false, 1, null);
        L6:
            r16.setRunningAnim(PropertyAnimatable.start$default(SheetAnimStyle.sheetHide$default(SheetAnimStyle.INSTANCE, r16.getRootContainer(), r16.windowForAnim(), r16.getDimView(), r16.needDimAnim(), r16.useWindowDim(), r17, new OSheetBase$DefaultImpls$$ExternalSyntheticLambda1(r16), null, 64, null).onEnd(new AnonymousClass2(r16)).build(), null, null, 3, null));
            r16.onDismissAnimStart();
        }

        /* JADX INFO: renamed from: performExitAnimation$lambda-3, reason: not valid java name */
        private static void m1387performExitAnimation$lambda3(OSheetBase r2) {
            Intrinsics.checkNotNullParameter(r2, "this$0");
            AnimationManager r0 = r2.getRunningAnim();
            if (r0 == null) goto L6;
            r0.cancelAnimation(true);
        L6:
            r2.getRootContainer().setAlpha(0.0f);
        }

        public static void initBgColor(OSheetBase r1) {
            Intrinsics.checkNotNullParameter(r1, "this");
            if ((r1.getRootContainer().getBackground() instanceof ColorDrawable) == false) goto L10;
            Drawable r0 = r1.getRootContainer().getBackground();
            if (r0 == null) goto L8;
            r1.setBgColor(((ColorDrawable) r0).getColor());
            return;
        L8:
            throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.ColorDrawable");
        L10:
            if ((r1.getRootContainer().getBackground() instanceof GradientDrawable) == false) goto L21;
            Drawable r2 = r1.getRootContainer().getBackground();
            if (r2 == null) goto L19;
            ColorStateList r3 = ((GradientDrawable) r2).getColor();
            if (r3 != null) goto L16;
            int r4 = -1;
        L17:
            r1.setBgColor(r4);
            return;
        L16:
            r4 = r3.getDefaultColor();
            goto L17
        L19:
            throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        }

        public static void applyMaterial(OSheetBase r8, boolean r9) {
            Intrinsics.checkNotNullParameter(r8, "this");
            if (r8.getEnableMaterial() == false) goto L9;
            r8.getRootContainer().getContext();
            MaterialConfig[] r2 = MaterialToken.OUI_Bg_Modal.invoke(Boolean.valueOf(!r8.isDarkTheme()));
            r8.getRootContainer().setBackgroundColor(0);
            if (r9 == false) goto L7;
            OMaterialExtBaseKt.materialsFromWindow$default(r8.getRootContainer(), r2, false, null, 6, null);
            return;
        L7:
            OMaterialExtBaseKt.materials$default(r8.getRootContainer(), r2, false, 0, null, 14, null);
            return;
        }

        public static boolean isDarkTheme(OSheetBase r1) {
            Intrinsics.checkNotNullParameter(r1, "this");
            if (r1.getBgColor() != 0) goto L7;
            return ViewUtilKt.isDarkMode(r1.getRootContainer());
        L7:
            return OPalette.isDarkColor(r1.getBgColor());
        }
    }

    void applyMaterial(boolean r1);

    void calculateBodyMaxHeight();

    void enableIgnoreInsetBottom(boolean r1);

    @Override // com.obric.oui.sheet.v2.SheetMoveDelegate
    void fling(float r1, float r2);

    boolean getAutoAddBodyPaddingTopWhenOverlay();

    int getBgColor();

    FrameLayout getBodyContainer();

    int getBodyContentPaddingBottom();

    int getBodyContentPaddingTop();

    ComponentCallbacks getConfigurationCallback();

    boolean getConfigurationCallbackRegistered();

    int getContentLayoutResId();

    View getDimView();

    boolean getEnableDimAnim();

    boolean getEnableEnterAnim();

    boolean getEnableMaterial();

    View getEndActionButton();

    FrameLayout getFooterContainer();

    Size getFullWindowSize();

    FrameLayout getHeaderContainer();

    OSheetTitleBar getHeaderTitleBar();

    OSheet.HeightMode getHeightStyle();

    boolean getIgnoreInsetBottom();

    boolean getMCancelable();

    boolean getMClearDimFlag();

    int getMaxBodyHeight();

    View getNegativeButton();

    View getPositiveButton();

    RadiusLayout getRootContainer();

    float getRootTransMoveStartX();

    float getRootTransMoveStartY();

    AnimationManager getRunningAnim();

    ViewGroup getScaffoldContainer();

    OSheetScaffoldController getScaffoldController();

    Context getSheetContext();

    boolean getShowing();

    View getStartActionButton();

    Boolean getSystemInsetsAppearanceLightValue();

    int getUserWindowHeight();

    int getUserWindowWidth();

    <T extends View> T getViewById(int r1);

    void initBgColor();

    boolean isContentOverlayMode();

    boolean isDarkTheme();

    boolean isRootContainerMaxHeight();

    @Override // com.obric.oui.sheet.v2.SheetMoveDelegate
    void move(float r1, float r2, boolean r3);

    boolean needDimAnim();

    void onDismissAnimEnd();

    void onDismissAnimStart();

    void onDismissComplete();

    void onPostShow();

    void onShowAnimEnd();

    void onShowAnimStart();

    void performEnterAnimation();

    void performExitAnimation(float r1);

    void registerConfigurationCallbackIfNeeded();

    void removeOnApplyWindowInsetsListener();

    void setAutoAddBodyPaddingTopWhenOverlay(boolean r1);

    void setBgColor(int r1);

    void setBodyContainer(FrameLayout r1);

    void setBodyContentPaddingBottom(int r1);

    void setBodyContentPaddingTop(int r1);

    void setBodyView(View r1);

    void setCanceledOnTouchOutside(boolean r1);

    void setConfigurationCallback(ComponentCallbacks r1);

    void setConfigurationCallbackRegistered(boolean r1);

    void setContentOverlayMode(boolean r1);

    void setDimView(View r1);

    void setEnableDimAnim(boolean r1);

    void setEnableEnterAnim(boolean r1);

    void setEnableMaterial(boolean r1);

    void setFooterButton(Integer r1, boolean r2, View.OnClickListener r3, Integer r4, boolean r5, View.OnClickListener r6);

    void setFooterButton(String r1, boolean r2, View.OnClickListener r3, String r4, boolean r5, View.OnClickListener r6);

    void setFooterContainer(FrameLayout r1);

    void setFooterView(View r1);

    void setFullWindowSize(Size r1);

    void setHeader(OSheet.Header r1, Integer r2, Integer r3, String r4, String r5, boolean r6, View.OnClickListener r7, View.OnClickListener r8, Integer r9, Integer r10, String r11, String r12, Integer r13, Integer r14);

    void setHeaderContainer(FrameLayout r1);

    void setHeaderView(View r1);

    void setHeightMode(OSheet.HeightMode r1);

    void setHeightStyle(OSheet.HeightMode r1);

    void setIgnoreInsetBottom(boolean r1);

    void setMCancelable(boolean r1);

    void setMClearDimFlag(boolean r1);

    void setOnApplyWindowInsetsListener();

    void setOverlayModeAutoBodyPaddingTopEnabled(boolean r1);

    void setRootContainer(RadiusLayout r1);

    void setRootTransMoveStartX(float r1);

    void setRootTransMoveStartY(float r1);

    void setRunningAnim(AnimationManager r1);

    void setScaffoldContainer(ViewGroup r1);

    void setScaffoldController(OSheetScaffoldController r1);

    void setSheetBgColor(int r1);

    void setShowing(boolean r1);

    void setSystemInsetsAppearanceLightValue(Boolean r1);

    void setUserWindowHeight(int r1);

    void setUserWindowWidth(int r1);

    void setupDimView(Context r1);

    void setupView(Context r1);

    void unregisterConfigurationCallbackIfNeeded();

    void updateFullWindowSize();

    void updateMaterial();

    boolean useWindowDim();

    Window windowForAnim();
}
