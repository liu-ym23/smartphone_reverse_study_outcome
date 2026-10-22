package com.obric.oui.popover.v2;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.framwork.core.sdklib.DBHelper;
import com.obric.common.oui.R;
import com.obric.oui.material.MaterialConfig;
import com.obric.oui.material.MaterialToken;
import com.obric.oui.popover.v2.OPopoverBuilderDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OPopoverBuilderDelegate.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b9\b\u0016\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00002\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\n\u0010\u0083\u0001\u001a\u00030\u0084\u0001H\u0014J\n\u0010\u0085\u0001\u001a\u00030\u0086\u0001H\u0016J\n\u0010\u0087\u0001\u001a\u00030\u0088\u0001H\u0016J\u000f\u0010\u0089\u0001\u001a\u00028\u0000H\u0014¢\u0006\u0003\u0010\u008a\u0001J\u0016\u0010\u008b\u0001\u001a\u00028\u00002\u0007\u0010\u008c\u0001\u001a\u00020\n¢\u0006\u0003\u0010\u008d\u0001J\u0016\u0010\u008e\u0001\u001a\u00028\u00002\u0007\u0010\u008c\u0001\u001a\u00020\n¢\u0006\u0003\u0010\u008d\u0001J\u0018\u0010\u008f\u0001\u001a\u00028\u00002\t\b\u0001\u0010\u0090\u0001\u001a\u00020\u0013¢\u0006\u0003\u0010\u0091\u0001J\u0016\u0010\u0092\u0001\u001a\u00028\u00002\u0007\u0010\u0093\u0001\u001a\u00020\u0013¢\u0006\u0003\u0010\u0091\u0001J\u0016\u0010\u0094\u0001\u001a\u00028\u00002\u0007\u0010\u0095\u0001\u001a\u00020\u0013¢\u0006\u0003\u0010\u0091\u0001J\u0016\u0010\u0096\u0001\u001a\u00028\u00002\u0007\u0010\u0097\u0001\u001a\u00020\u001f¢\u0006\u0003\u0010\u0098\u0001J\u0016\u0010\u0099\u0001\u001a\u00028\u00002\u0007\u0010\u009a\u0001\u001a\u00020\u0013¢\u0006\u0003\u0010\u0091\u0001J\u0016\u0010\u009b\u0001\u001a\u00028\u00002\u0007\u0010\u009c\u0001\u001a\u00020\u001f¢\u0006\u0003\u0010\u0098\u0001J\u0016\u0010\u009d\u0001\u001a\u00028\u00002\u0007\u0010\u009c\u0001\u001a\u00020\u001f¢\u0006\u0003\u0010\u0098\u0001J\u0016\u0010\u009e\u0001\u001a\u00028\u00002\u0007\u0010\u009f\u0001\u001a\u00020\u001f¢\u0006\u0003\u0010\u0098\u0001J\u0016\u0010 \u0001\u001a\u00028\u00002\u0007\u0010¡\u0001\u001a\u00020\u001f¢\u0006\u0003\u0010\u0098\u0001J\u0016\u0010¢\u0001\u001a\u00028\u00002\u0007\u0010£\u0001\u001a\u00020\u001f¢\u0006\u0003\u0010\u0098\u0001J(\u0010¤\u0001\u001a\u00028\u00002\u0019\u0010¥\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020E0D0C¢\u0006\u0003\u0010¦\u0001J\u0016\u0010§\u0001\u001a\u00028\u00002\u0007\u0010¨\u0001\u001a\u00020%¢\u0006\u0003\u0010©\u0001J\u0016\u0010ª\u0001\u001a\u00028\u00002\u0007\u0010¨\u0001\u001a\u00020Q¢\u0006\u0003\u0010«\u0001J\u0016\u0010¬\u0001\u001a\u00028\u00002\u0007\u0010¨\u0001\u001a\u00020i¢\u0006\u0003\u0010\u00ad\u0001J\u0016\u0010®\u0001\u001a\u00028\u00002\u0007\u0010¯\u0001\u001a\u00020\u001f¢\u0006\u0003\u0010\u0098\u0001J\u0016\u0010°\u0001\u001a\u00028\u00002\u0007\u0010\u0097\u0001\u001a\u00020\u001f¢\u0006\u0003\u0010\u0098\u0001J\u0017\u0010\u007f\u001a\u00028\u00002\t\b\u0001\u0010±\u0001\u001a\u00020\u0013¢\u0006\u0003\u0010\u0091\u0001J\u0016\u0010²\u0001\u001a\u00028\u00002\u0007\u0010³\u0001\u001a\u00020\u001f¢\u0006\u0003\u0010\u0098\u0001J\u0016\u0010´\u0001\u001a\u00028\u00002\u0007\u0010µ\u0001\u001a\u00020\u001f¢\u0006\u0003\u0010\u0098\u0001J\u0018\u0010¶\u0001\u001a\u00028\u00002\t\b\u0001\u0010\u0090\u0001\u001a\u00020\u0013¢\u0006\u0003\u0010\u0091\u0001J\u0016\u0010·\u0001\u001a\u00028\u00002\u0007\u0010¸\u0001\u001a\u00020]¢\u0006\u0003\u0010¹\u0001J\u0016\u0010º\u0001\u001a\u00028\u00002\u0007\u0010»\u0001\u001a\u00020o¢\u0006\u0003\u0010¼\u0001J\u0016\u0010½\u0001\u001a\u00028\u00002\u0007\u0010¾\u0001\u001a\u00020\u0013¢\u0006\u0003\u0010\u0091\u0001J\u0016\u0010¿\u0001\u001a\u00028\u00002\u0007\u0010¾\u0001\u001a\u00020\u0013¢\u0006\u0003\u0010\u0091\u0001J\u0016\u0010\u0080\u0001\u001a\u00028\u00002\u0007\u0010À\u0001\u001a\u00020\u001f¢\u0006\u0003\u0010\u0098\u0001R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\u001a\u0010\u001b\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017R\u001a\u0010\u001e\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0015\"\u0004\b,\u0010\u0017R\u001a\u0010-\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010!\"\u0004\b/\u0010#R\u001a\u00100\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010!\"\u0004\b2\u0010#R\u001a\u00103\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010!\"\u0004\b5\u0010#R\u001a\u00106\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010!\"\u0004\b8\u0010#R\u001a\u00109\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0015\"\u0004\b;\u0010\u0017R\u001a\u0010<\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u0015\"\u0004\b>\u0010\u0017R\u001a\u0010?\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010!\"\u0004\bA\u0010#R,\u0010B\u001a\u0014\u0012\u0004\u0012\u00020\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020E0D0CX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u001a\u0010J\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010!\"\u0004\bL\u0010#R\u001a\u0010M\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010!\"\u0004\bO\u0010#R\u001c\u0010P\u001a\u0004\u0018\u00010QX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\u001a\u0010V\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010!\"\u0004\bX\u0010#R\u001a\u0010Y\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010!\"\u0004\b[\u0010#R\u001a\u0010\\\u001a\u00020]X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\u001e\u0010b\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010\u0015\"\u0004\bd\u0010\u0017R\u001a\u0010e\u001a\u00020]X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010_\"\u0004\bg\u0010aR\u001c\u0010h\u001a\u0004\u0018\u00010iX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR\u001c\u0010n\u001a\u0004\u0018\u00010oX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010q\"\u0004\br\u0010sR\u001a\u0010t\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bu\u0010\u0015\"\u0004\bv\u0010\u0017R\u001a\u0010w\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bx\u0010\u0015\"\u0004\by\u0010\u0017R\u001a\u0010z\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b{\u0010\u0015\"\u0004\b|\u0010\u0017R\u001e\u0010}\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b~\u0010\u0015\"\u0004\b\u007f\u0010\u0017R\u001d\u0010\u0080\u0001\u001a\u00020\u001fX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0081\u0001\u0010!\"\u0005\b\u0082\u0001\u0010#¨\u0006Á\u0001"}, d2 = {"Lcom/obric/oui/popover/v2/OPopoverBuilderDelegate;", ExifInterface.GPS_DIRECTION_TRUE, "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "setContext", "mAnimTime", "", "getMAnimTime", "()J", "setMAnimTime", "(J)V", "mAutoDismissDelayMillis", "getMAutoDismissDelayMillis", "setMAutoDismissDelayMillis", "mBgColor", "", "getMBgColor", "()I", "setMBgColor", "(I)V", "mBorderColor", "getMBorderColor", "setMBorderColor", "mBorderWidth", "getMBorderWidth", "setMBorderWidth", "mCoverPreviousWhenStacked", "", "getMCoverPreviousWhenStacked", "()Z", "setMCoverPreviousWhenStacked", "(Z)V", "mDismissListener", "Lcom/obric/oui/popover/v2/OPopover$OnBubbleDismissListener;", "getMDismissListener", "()Lcom/obric/oui/popover/v2/OPopover$OnBubbleDismissListener;", "setMDismissListener", "(Lcom/obric/oui/popover/v2/OPopover$OnBubbleDismissListener;)V", "mDisplayOrientation", "getMDisplayOrientation", "setMDisplayOrientation", "mEnableBackPressDismiss", "getMEnableBackPressDismiss", "setMEnableBackPressDismiss", "mEnableBubbleMaterial", "getMEnableBubbleMaterial", "setMEnableBubbleMaterial", "mFocusable", "getMFocusable", "setMFocusable", "mGetLocationInWindow", "getMGetLocationInWindow", "setMGetLocationInWindow", "mGravity", "getMGravity", "setMGravity", "mHeight", "getMHeight", "setMHeight", "mHideVirtualKey", "getMHideVirtualKey", "setMHideVirtualKey", "mMaterials", "Lkotlin/Function1;", "", "Lcom/obric/oui/material/MaterialConfig;", "getMMaterials", "()Lkotlin/jvm/functions/Function1;", "setMMaterials", "(Lkotlin/jvm/functions/Function1;)V", "mOutsideTouchable", "getMOutsideTouchable", "setMOutsideTouchable", "mShadowEnabled", "getMShadowEnabled", "setMShadowEnabled", "mShowListener", "Lcom/obric/oui/popover/v2/OPopover$OnBubbleShowListener;", "getMShowListener", "()Lcom/obric/oui/popover/v2/OPopover$OnBubbleShowListener;", "setMShowListener", "(Lcom/obric/oui/popover/v2/OPopover$OnBubbleShowListener;)V", "mShowWithAnimation", "getMShowWithAnimation", "setMShowWithAnimation", "mSpacingForShadow", "getMSpacingForShadow", "setMSpacingForShadow", "mStackAlphaPrevious", "", "getMStackAlphaPrevious", "()F", "setMStackAlphaPrevious", "(F)V", "mStackCoverColor", "getMStackCoverColor", "setMStackCoverColor", "mStackScalePrevious", "getMStackScalePrevious", "setMStackScalePrevious", "mStartDismissListener", "Lcom/obric/oui/popover/v2/OPopover$OnBubbleStartDismissListener;", "getMStartDismissListener", "()Lcom/obric/oui/popover/v2/OPopover$OnBubbleStartDismissListener;", "setMStartDismissListener", "(Lcom/obric/oui/popover/v2/OPopover$OnBubbleStartDismissListener;)V", "mView", "Landroid/view/View;", "getMView", "()Landroid/view/View;", "setMView", "(Landroid/view/View;)V", "mWidth", "getMWidth", "setMWidth", "mXOffset", "getMXOffset", "setMXOffset", "mYOffset", "getMYOffset", "setMYOffset", "shadowStyle", "getShadowStyle", "setShadowStyle", "transparentBg", "getTransparentBg", "setTransparentBg", "asPopoverBuilder", "Lcom/obric/oui/popover/v2/OPopover$Builder;", "build", "Lcom/obric/oui/popover/v2/OPopover;", "buildModal", "Lcom/obric/oui/popover/v2/OPopoverModal;", "self", "()Lcom/obric/oui/popover/v2/OPopoverBuilderDelegate;", "setAnimTime", DBHelper.COL_TIME, "(J)Lcom/obric/oui/popover/v2/OPopoverBuilderDelegate;", "setAutoDismissDelayMillis", "setBgColor", "color", "(I)Lcom/obric/oui/popover/v2/OPopoverBuilderDelegate;", "setBorderColor", "borderColor", "setBorderWidth", "borderWidth", "setCoverPreviousWhenStacked", "enabled", "(Z)Lcom/obric/oui/popover/v2/OPopoverBuilderDelegate;", "setDisplayOrientation", "orientation", "setEnableBackPressDismiss", "enable", "setEnableBubbleMaterial", "setFocusable", "focusable", "setGetLocationInWindow", "getLocationInWindow", "setHideVirtualKey", "hide", "setMaterials", "materials", "(Lkotlin/jvm/functions/Function1;)Lcom/obric/oui/popover/v2/OPopoverBuilderDelegate;", "setOnDismissListener", "listener", "(Lcom/obric/oui/popover/v2/OPopover$OnBubbleDismissListener;)Lcom/obric/oui/popover/v2/OPopoverBuilderDelegate;", "setOnShowListener", "(Lcom/obric/oui/popover/v2/OPopover$OnBubbleShowListener;)Lcom/obric/oui/popover/v2/OPopoverBuilderDelegate;", "setOnStartDismissListener", "(Lcom/obric/oui/popover/v2/OPopover$OnBubbleStartDismissListener;)Lcom/obric/oui/popover/v2/OPopoverBuilderDelegate;", "setOutSideTouchable", "touchable", "setPopoverShadowEnabled", "shadowStyleRes", "setShowWithAnim", "withAnim", "setSpacingForShadow", "spacingForShadow", "setStackCoverColor", "setStackScalePrevious", "scale", "(F)Lcom/obric/oui/popover/v2/OPopoverBuilderDelegate;", "setView", "view", "(Landroid/view/View;)Lcom/obric/oui/popover/v2/OPopoverBuilderDelegate;", "setXOffset", "offset", "setYOffset", "transparent", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OPopoverBuilderDelegate<T extends OPopoverBuilderDelegate<T>> {
    private Context context;
    private long mAnimTime;
    private long mAutoDismissDelayMillis;
    private int mBgColor;
    private int mBorderColor;
    private int mBorderWidth;
    private boolean mCoverPreviousWhenStacked;
    private OPopover.OnBubbleDismissListener mDismissListener;
    private int mDisplayOrientation;
    private boolean mEnableBackPressDismiss;
    private boolean mEnableBubbleMaterial;
    private boolean mFocusable;
    private boolean mGetLocationInWindow;
    private int mGravity;
    private int mHeight;
    private boolean mHideVirtualKey;
    private Function1<? super Boolean, MaterialConfig[]> mMaterials;
    private boolean mOutsideTouchable;
    private boolean mShadowEnabled;
    private OPopover.OnBubbleShowListener mShowListener;
    private boolean mShowWithAnimation;
    private boolean mSpacingForShadow;
    private float mStackAlphaPrevious;
    private int mStackCoverColor;
    private float mStackScalePrevious;
    private OPopover.OnBubbleStartDismissListener mStartDismissListener;
    private View mView;
    private int mWidth;
    private int mXOffset;
    private int mYOffset;
    private int shadowStyle;
    private boolean transparentBg;

    public OPopoverBuilderDelegate(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this.context = r3;
        this.mBgColor = ContextCompat.getColor(r3, R.color.oui_toast_background);
        this.mAnimTime = 800;
        this.mAutoDismissDelayMillis = Long.MIN_VALUE;
        this.mOutsideTouchable = true;
        this.mEnableBackPressDismiss = true;
        this.mShowWithAnimation = true;
        this.mShadowEnabled = true;
        this.shadowStyle = R.style.OUIShadow_Oui_Shadow_Regular;
        this.mEnableBubbleMaterial = true;
        this.mMaterials = MaterialToken.OUI_Bg_Popup;
        this.mCoverPreviousWhenStacked = true;
        this.mStackCoverColor = Color.parseColor("#08000000");
        this.mStackAlphaPrevious = 0.3f;
        this.mStackScalePrevious = 0.98f;
    }

    public final Context getContext() {
        return this.context;
    }

    public final void setContext(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.context = r2;
    }

    public final boolean getMFocusable() {
        return this.mFocusable;
    }

    public final void setMFocusable(boolean r1) {
        this.mFocusable = r1;
    }

    public final int getMGravity() {
        return this.mGravity;
    }

    public final void setMGravity(int r1) {
        this.mGravity = r1;
    }

    public final int getMDisplayOrientation() {
        return this.mDisplayOrientation;
    }

    public final void setMDisplayOrientation(int r1) {
        this.mDisplayOrientation = r1;
    }

    public final int getMBgColor() {
        return this.mBgColor;
    }

    public final void setMBgColor(int r1) {
        this.mBgColor = r1;
    }

    public final boolean getMHideVirtualKey() {
        return this.mHideVirtualKey;
    }

    public final void setMHideVirtualKey(boolean r1) {
        this.mHideVirtualKey = r1;
    }

    public final int getMXOffset() {
        return this.mXOffset;
    }

    public final void setMXOffset(int r1) {
        this.mXOffset = r1;
    }

    public final int getMYOffset() {
        return this.mYOffset;
    }

    public final void setMYOffset(int r1) {
        this.mYOffset = r1;
    }

    public final long getMAnimTime() {
        return this.mAnimTime;
    }

    public final void setMAnimTime(long r1) {
        this.mAnimTime = r1;
    }

    public final long getMAutoDismissDelayMillis() {
        return this.mAutoDismissDelayMillis;
    }

    public final void setMAutoDismissDelayMillis(long r1) {
        this.mAutoDismissDelayMillis = r1;
    }

    public final View getMView() {
        return this.mView;
    }

    public final void setMView(View r1) {
        this.mView = r1;
    }

    public final int getMWidth() {
        return this.mWidth;
    }

    public final void setMWidth(int r1) {
        this.mWidth = r1;
    }

    public final int getMHeight() {
        return this.mHeight;
    }

    public final void setMHeight(int r1) {
        this.mHeight = r1;
    }

    public final OPopover.OnBubbleStartDismissListener getMStartDismissListener() {
        return this.mStartDismissListener;
    }

    public final void setMStartDismissListener(OPopover.OnBubbleStartDismissListener r1) {
        this.mStartDismissListener = r1;
    }

    public final OPopover.OnBubbleDismissListener getMDismissListener() {
        return this.mDismissListener;
    }

    public final void setMDismissListener(OPopover.OnBubbleDismissListener r1) {
        this.mDismissListener = r1;
    }

    public final OPopover.OnBubbleShowListener getMShowListener() {
        return this.mShowListener;
    }

    public final void setMShowListener(OPopover.OnBubbleShowListener r1) {
        this.mShowListener = r1;
    }

    public final boolean getMOutsideTouchable() {
        return this.mOutsideTouchable;
    }

    public final void setMOutsideTouchable(boolean r1) {
        this.mOutsideTouchable = r1;
    }

    public final boolean getMGetLocationInWindow() {
        return this.mGetLocationInWindow;
    }

    public final void setMGetLocationInWindow(boolean r1) {
        this.mGetLocationInWindow = r1;
    }

    public final boolean getMEnableBackPressDismiss() {
        return this.mEnableBackPressDismiss;
    }

    public final void setMEnableBackPressDismiss(boolean r1) {
        this.mEnableBackPressDismiss = r1;
    }

    public final int getMBorderWidth() {
        return this.mBorderWidth;
    }

    public final void setMBorderWidth(int r1) {
        this.mBorderWidth = r1;
    }

    public final int getMBorderColor() {
        return this.mBorderColor;
    }

    public final void setMBorderColor(int r1) {
        this.mBorderColor = r1;
    }

    public final boolean getTransparentBg() {
        return this.transparentBg;
    }

    public final void setTransparentBg(boolean r1) {
        this.transparentBg = r1;
    }

    public final boolean getMShowWithAnimation() {
        return this.mShowWithAnimation;
    }

    public final void setMShowWithAnimation(boolean r1) {
        this.mShowWithAnimation = r1;
    }

    public final boolean getMShadowEnabled() {
        return this.mShadowEnabled;
    }

    public final void setMShadowEnabled(boolean r1) {
        this.mShadowEnabled = r1;
    }

    public final int getShadowStyle() {
        return this.shadowStyle;
    }

    /* JADX INFO: renamed from: setShadowStyle, reason: collision with other method in class */
    public final void m447setShadowStyle(int r1) {
        this.shadowStyle = r1;
    }

    public final boolean getMSpacingForShadow() {
        return this.mSpacingForShadow;
    }

    public final void setMSpacingForShadow(boolean r1) {
        this.mSpacingForShadow = r1;
    }

    public final boolean getMEnableBubbleMaterial() {
        return this.mEnableBubbleMaterial;
    }

    public final void setMEnableBubbleMaterial(boolean r1) {
        this.mEnableBubbleMaterial = r1;
    }

    public final Function1<Boolean, MaterialConfig[]> getMMaterials() {
        return this.mMaterials;
    }

    public final void setMMaterials(Function1<? super Boolean, MaterialConfig[]> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mMaterials = r2;
    }

    public final boolean getMCoverPreviousWhenStacked() {
        return this.mCoverPreviousWhenStacked;
    }

    public final void setMCoverPreviousWhenStacked(boolean r1) {
        this.mCoverPreviousWhenStacked = r1;
    }

    public final int getMStackCoverColor() {
        return this.mStackCoverColor;
    }

    public final void setMStackCoverColor(int r1) {
        this.mStackCoverColor = r1;
    }

    public final float getMStackAlphaPrevious() {
        return this.mStackAlphaPrevious;
    }

    public final void setMStackAlphaPrevious(float r1) {
        this.mStackAlphaPrevious = r1;
    }

    public final float getMStackScalePrevious() {
        return this.mStackScalePrevious;
    }

    public final void setMStackScalePrevious(float r1) {
        this.mStackScalePrevious = r1;
    }

    protected T self() {
        return this;
    }

    public final T setDisplayOrientation(int r1) {
        this.mDisplayOrientation = r1;
        return (T) self();
    }

    public final T setFocusable(boolean r1) {
        this.mFocusable = r1;
        return (T) self();
    }

    public final T setOutSideTouchable(boolean r1) {
        this.mOutsideTouchable = r1;
        return (T) self();
    }

    public final T setBorderColor(int r1) {
        this.mBorderColor = r1;
        return (T) self();
    }

    public final T setBorderWidth(int r1) {
        this.mBorderWidth = r1;
        return (T) self();
    }

    public final T setOnShowListener(OPopover.OnBubbleShowListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.mShowListener = r2;
        return (T) self();
    }

    public final T setOnStartDismissListener(OPopover.OnBubbleStartDismissListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.mStartDismissListener = r2;
        return (T) self();
    }

    public final T setOnDismissListener(OPopover.OnBubbleDismissListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.mDismissListener = r2;
        return (T) self();
    }

    public final T setShowWithAnim(boolean r1) {
        this.mShowWithAnimation = r1;
        return (T) self();
    }

    public final T setPopoverShadowEnabled(boolean r1) {
        this.mShadowEnabled = r1;
        return (T) self();
    }

    public final T setShadowStyle(int r1) {
        this.shadowStyle = r1;
        return (T) self();
    }

    public final T setCoverPreviousWhenStacked(boolean r1) {
        this.mCoverPreviousWhenStacked = r1;
        return (T) self();
    }

    public final T setStackCoverColor(int r1) {
        this.mStackCoverColor = r1;
        return (T) self();
    }

    public final T setStackScalePrevious(float r1) {
        this.mStackScalePrevious = r1;
        return (T) self();
    }

    public final T setBgColor(int r1) {
        this.mBgColor = r1;
        return (T) self();
    }

    public final T setHideVirtualKey(boolean r1) {
        this.mHideVirtualKey = r1;
        return (T) self();
    }

    public final T setXOffset(int r1) {
        this.mXOffset = r1;
        return (T) self();
    }

    public final T setYOffset(int r1) {
        this.mYOffset = r1;
        return (T) self();
    }

    public final T setAnimTime(long r1) {
        this.mAnimTime = r1;
        return (T) self();
    }

    public final T setAutoDismissDelayMillis(long r1) {
        this.mAutoDismissDelayMillis = r1;
        return (T) self();
    }

    public final T setView(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        this.mView = r2;
        return (T) self();
    }

    public final T setGetLocationInWindow(boolean r1) {
        this.mGetLocationInWindow = r1;
        return (T) self();
    }

    public final T setEnableBackPressDismiss(boolean r1) {
        this.mEnableBackPressDismiss = r1;
        return (T) self();
    }

    public final T setSpacingForShadow(boolean r1) {
        this.mSpacingForShadow = r1;
        return (T) self();
    }

    public final T transparentBg(boolean r1) {
        this.transparentBg = r1;
        return (T) self();
    }

    public final T setEnableBubbleMaterial(boolean r1) {
        this.mEnableBubbleMaterial = r1;
        return (T) self();
    }

    public final T setMaterials(Function1<? super Boolean, MaterialConfig[]> r2) {
        Intrinsics.checkNotNullParameter(r2, "materials");
        this.mMaterials = r2;
        return (T) self();
    }

    public OPopover build() {
        return new OPopover(asPopoverBuilder());
    }

    public OPopoverModal buildModal() {
        return new OPopoverModal(asPopoverBuilder());
    }

    protected OPopover.Builder asPopoverBuilder() {
        return (OPopover.Builder) this;
    }
}
