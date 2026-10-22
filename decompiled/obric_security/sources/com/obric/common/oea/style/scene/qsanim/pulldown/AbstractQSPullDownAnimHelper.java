package com.obric.common.oea.style.scene.qsanim.pulldown;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.apm.trace.fps.RealFpsTracer;
import com.obric.common.oea.foundation.animation.engine.DynamicAnimation;
import com.obric.common.oea.foundation.util.OEALogger;
import com.obric.common.oea.style.scene.qsanim.common.AnimControlPoint;
import com.obric.common.oea.style.scene.qsanim.common.CubicEaseOutInterpolator;
import com.obric.common.oea.style.scene.qsanim.common.KtExt;
import com.obric.common.oea.style.scene.qsanim.common.PropertyAnimUtils;
import com.obric.common.oea.style.scene.qsanim.common.SpringAnimUtils;
import com.obric.oui.material.MaterialConfigFormatNames;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AbstractQSPullDownAnimHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\t\n\u0002\b\u001c\b&\u0018\u0000 Z2\u00020\u0001:\u0002Z[B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0002\u0010\nJ\u000e\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,J\u0010\u0010)\u001a\u00020*2\b\u0010-\u001a\u0004\u0018\u00010.J\b\u0010/\u001a\u00020*H\u0002J\b\u00100\u001a\u00020*H\u0002J\u0010\u00101\u001a\u00020*2\u0006\u00102\u001a\u00020\u0010H\u0002J\u0010\u00103\u001a\u00020*2\u0006\u00102\u001a\u00020\u0010H\u0002J\u0010\u00104\u001a\u00020*2\u0006\u00102\u001a\u00020\u0010H\u0002J\u000e\u00105\u001a\u00020*2\u0006\u00106\u001a\u00020\u0005J\u0006\u00107\u001a\u00020*J\u0010\u00108\u001a\u00020*2\u0006\u00109\u001a\u00020\u001bH\u0002J\u000e\u0010:\u001a\u00020*2\u0006\u00106\u001a\u00020\u0005J\b\u0010;\u001a\u00020*H\u0002J\u0006\u0010<\u001a\u00020*J\u0006\u0010=\u001a\u00020*J\u0010\u0010>\u001a\u00020\f2\u0006\u0010?\u001a\u00020@H\u0002J\u0010\u0010A\u001a\u00020\f2\u0006\u0010?\u001a\u00020@H\u0002J\b\u0010B\u001a\u00020*H&J\b\u0010C\u001a\u00020*H&J\b\u0010D\u001a\u00020*H&J\b\u0010E\u001a\u00020*H&J\u0018\u0010F\u001a\u00020*2\u0006\u0010G\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u0010H'J\u0018\u0010H\u001a\u00020*2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u00109\u001a\u00020\u001bH&J\b\u0010I\u001a\u00020*H&J\b\u0010J\u001a\u00020*H&J\b\u0010K\u001a\u00020*H&J\b\u0010L\u001a\u00020*H&J\u0010\u0010M\u001a\u00020*2\u0006\u00102\u001a\u00020\u0010H\u0002J\u001a\u0010N\u001a\u00020*2\u0006\u00102\u001a\u00020\u00102\b\b\u0002\u0010O\u001a\u00020\u001eH\u0002J\u0010\u0010P\u001a\u00020*2\u0006\u00102\u001a\u00020\u0010H\u0002J\u0010\u0010Q\u001a\u00020*2\u0006\u00102\u001a\u00020\u0010H\u0002J\u0006\u0010R\u001a\u00020*J\b\u0010S\u001a\u00020*H\u0017J\u0010\u0010T\u001a\u00020*2\b\u0010U\u001a\u0004\u0018\u00010%J\b\u0010V\u001a\u00020*H\u0002J\u000e\u0010W\u001a\u00020*2\u0006\u00106\u001a\u00020\u0005J\u0006\u0010X\u001a\u00020*J\u000e\u0010Y\u001a\u00020*2\u0006\u00106\u001a\u00020\u0005R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u000e\u0010(\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\\"}, d2 = {"Lcom/obric/common/oea/style/scene/qsanim/pulldown/AbstractQSPullDownAnimHelper;", "Lcom/obric/common/oea/style/scene/qsanim/pulldown/BaseViewGroupAnimHelper;", "rootView", "Landroid/view/ViewGroup;", "defInitScale", "", "defInitAlpha", "pullDownDistance", "enterExitControlPoint", "stretchTriggerPoint", "(Landroid/view/ViewGroup;FFFFF)V", "childEnterAnim", "Landroid/animation/Animator;", "childExitAnim", "childTransYProperties", "", "", "Lcom/obric/common/oea/style/scene/qsanim/common/SpringAnimUtils$CommonFloatProperty;", "draBarPerEnterAnim", "draBarPerExitAnim", "dragBar", "Lcom/obric/common/oea/style/scene/qsanim/common/AnimControlPoint;", "dragBarAnimEndListener", "Lcom/obric/common/oea/foundation/animation/engine/DynamicAnimation$OnAnimationEndListener;", "dragBarAnimUpdateListener", "Lcom/obric/common/oea/foundation/animation/engine/DynamicAnimation$OnAnimationUpdateListener;", "dragContinueTimesBeforeDragUp", "", "dragStartConsumed", "Lcom/obric/common/oea/style/scene/qsanim/common/KtExt$AutoExpireFlag;", "", "dragUpAnimPhase", "Lcom/obric/common/oea/style/scene/qsanim/pulldown/AbstractQSPullDownAnimHelper$DragUpAnimPhase;", "lastDragBarY", "lastTouchMoveY", "openCloseAnimInterruptibleF", "qsPullDownAnimListener", "Lcom/obric/common/oea/style/scene/qsanim/pulldown/QSPullDownAnimListener;", "getRootView", "()Landroid/view/ViewGroup;", "speedTar", "addAnimView", "", "view", "Landroid/view/View;", "animConfig", "Lcom/obric/common/oea/style/scene/qsanim/pulldown/QSAnimConfig;", "cancelChildEnterAnim", "cancelChildExitAnim", "cancelCloseAnim", "scene", "cancelOpenAnim", "cancelRunningAnim", "dragContinue", MaterialConfigFormatNames.Y, "dragEnd", "dragFollow", MaterialConfigFormatNames.DIRECTION, "dragStart", "dragUp", "forcePlayCloseAnim", "forcePlayOpenAnim", "makeChildEnterAnim", "animDuration", "", "makeChildExitAnim", "onCancelChildEnterAnim", "onCancelChildExitAnim", "onCancelDragUpCloseAnim", "onCancelDragUpOpenAnim", "onDragDistanceAnimUpdated", RealFpsTracer.SCROLL_DISTANCE, "onDragFollow", "onPlayChildEnterAnim", "onPlayChildExitAnim", "onPlayDragUpCloseAnim", "onPlayDragUpOpenAnim", "playChildEnterAnim", "playChildExitAnim", "exitQuickly", "playCloseAnim", "playOpenAnim", "resetAnimState", "resetViewState", "setQSPullDownAnimListener", "listener", "stretchChildViews", "tryDragContinue", "tryDragEnd", "tryDragStart", "Companion", "DragUpAnimPhase", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public abstract class AbstractQSPullDownAnimHelper extends BaseViewGroupAnimHelper {
    private static final String CHILD_TRANS_Y_PROPERTY = "CHILD_TRANS_Y_PROPERTY";
    public static final Companion Companion = null;
    private static final float FLING_DOWN_SPEED_THRESH = 30.0f;
    private static final float FLING_UP_SPEED_THRESH = 30.0f;
    private static final String TAG = "BaseQSPullDownAnimHelper";
    private static final CubicEaseOutInterpolator cubicEaseOutInterpolator = null;
    private Animator childEnterAnim;
    private Animator childExitAnim;
    private final Map<String, SpringAnimUtils.CommonFloatProperty> childTransYProperties;
    private Animator draBarPerEnterAnim;
    private Animator draBarPerExitAnim;
    private final AnimControlPoint dragBar;
    private final DynamicAnimation.OnAnimationEndListener dragBarAnimEndListener;
    private final DynamicAnimation.OnAnimationUpdateListener dragBarAnimUpdateListener;
    private int dragContinueTimesBeforeDragUp;
    private KtExt.AutoExpireFlag<Boolean> dragStartConsumed;
    private DragUpAnimPhase dragUpAnimPhase;
    private final float enterExitControlPoint;
    private float lastDragBarY;
    private float lastTouchMoveY;
    private KtExt.AutoExpireFlag<Boolean> openCloseAnimInterruptibleF;
    private final float pullDownDistance;
    private QSPullDownAnimListener qsPullDownAnimListener;
    private final ViewGroup rootView;
    private final AnimControlPoint speedTar;
    private final float stretchTriggerPoint;

    /* JADX INFO: compiled from: AbstractQSPullDownAnimHelper.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/common/oea/style/scene/qsanim/pulldown/AbstractQSPullDownAnimHelper$Companion;", "", "()V", AbstractQSPullDownAnimHelper.CHILD_TRANS_Y_PROPERTY, "", "FLING_DOWN_SPEED_THRESH", "", "FLING_UP_SPEED_THRESH", "TAG", "cubicEaseOutInterpolator", "Lcom/obric/common/oea/style/scene/qsanim/common/CubicEaseOutInterpolator;", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    /* JADX INFO: compiled from: AbstractQSPullDownAnimHelper.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/common/oea/style/scene/qsanim/pulldown/AbstractQSPullDownAnimHelper$DragUpAnimPhase;", "", "(Ljava/lang/String;I)V", "NONE", "OPEN", "CLOSE", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
    private static final enum DragUpAnimPhase extends Enum<DragUpAnimPhase> {
        private static final /* synthetic */ DragUpAnimPhase[] $VALUES = null;
        public static final DragUpAnimPhase CLOSE = null;
        public static final DragUpAnimPhase NONE = null;
        public static final DragUpAnimPhase OPEN = null;

        static {
            DragUpAnimPhase r1 = new DragUpAnimPhase("NONE", 0);
            NONE = r1;
            DragUpAnimPhase r2 = new DragUpAnimPhase("OPEN", 1);
            OPEN = r2;
            DragUpAnimPhase r3 = new DragUpAnimPhase("CLOSE", 2);
            CLOSE = r3;
            $VALUES = new DragUpAnimPhase[]{r1, r2, r3};
        }

        public static DragUpAnimPhase valueOf(String r1) {
            return (DragUpAnimPhase) Enum.valueOf(DragUpAnimPhase.class, r1);
        }

        public static DragUpAnimPhase[] values() {
            return (DragUpAnimPhase[]) $VALUES.clone();
        }

        private DragUpAnimPhase(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[DragUpAnimPhase.values().length];
            $EnumSwitchMapping$0 = r0;
            r0[DragUpAnimPhase.OPEN.ordinal()] = 1;
            r0[DragUpAnimPhase.CLOSE.ordinal()] = 2;
            r0[DragUpAnimPhase.NONE.ordinal()] = 3;
        }
    }

    public abstract void onCancelChildEnterAnim();

    public abstract void onCancelChildExitAnim();

    public abstract void onCancelDragUpCloseAnim();

    public abstract void onCancelDragUpOpenAnim();

    @Deprecated(message = "")
    public abstract void onDragDistanceAnimUpdated(float r1, String r2);

    public abstract void onDragFollow(AnimControlPoint r1, int r2);

    public abstract void onPlayChildEnterAnim();

    public abstract void onPlayChildExitAnim();

    public abstract void onPlayDragUpCloseAnim();

    public abstract void onPlayDragUpOpenAnim();

    public static final /* synthetic */ Map access$getChildTransYProperties$p(AbstractQSPullDownAnimHelper r0) {
        return r0.childTransYProperties;
    }

    public static final /* synthetic */ AnimControlPoint access$getDragBar$p(AbstractQSPullDownAnimHelper r0) {
        return r0.dragBar;
    }

    public static final /* synthetic */ KtExt.AutoExpireFlag access$getOpenCloseAnimInterruptibleF$p(AbstractQSPullDownAnimHelper r0) {
        return r0.openCloseAnimInterruptibleF;
    }

    public static final /* synthetic */ float access$getPullDownDistance$p(AbstractQSPullDownAnimHelper r0) {
        return r0.pullDownDistance;
    }

    public static final /* synthetic */ QSPullDownAnimListener access$getQsPullDownAnimListener$p(AbstractQSPullDownAnimHelper r0) {
        return r0.qsPullDownAnimListener;
    }

    public static final /* synthetic */ void access$setOpenCloseAnimInterruptibleF$p(AbstractQSPullDownAnimHelper r0, KtExt.AutoExpireFlag r1) {
        r0.openCloseAnimInterruptibleF = r1;
    }

    public static final /* synthetic */ void access$setQsPullDownAnimListener$p(AbstractQSPullDownAnimHelper r0, QSPullDownAnimListener r1) {
        r0.qsPullDownAnimListener = r1;
    }

    protected final ViewGroup getRootView() {
        return this.rootView;
    }

    public AbstractQSPullDownAnimHelper(ViewGroup r2, float r3, float r4, float r5, float r6, float r7) {
        Intrinsics.checkNotNullParameter(r2, "rootView");
        super(r3, r4);
        this.rootView = r2;
        this.pullDownDistance = r5;
        this.enterExitControlPoint = r6;
        this.stretchTriggerPoint = r7;
        this.dragBar = new AnimControlPoint(0.0f, 0.0f);
        this.speedTar = new AnimControlPoint(0.0f, 0.0f);
        this.dragUpAnimPhase = DragUpAnimPhase.NONE;
        this.childTransYProperties = new LinkedHashMap();
        this.openCloseAnimInterruptibleF = new KtExt.AutoExpireFlag(true, 600);
        this.dragStartConsumed = new KtExt.AutoExpireFlag(true, 120000);
        this.dragBarAnimUpdateListener = new AbstractQSPullDownAnimHelper$dragBarAnimUpdateListener$1(this);
        this.dragBarAnimEndListener = new AbstractQSPullDownAnimHelper$dragBarAnimEndListener$1(this);
    }

    public final void addAnimView(View r9) {
        Intrinsics.checkNotNullParameter(r9, "view");
        QSAnimConfig r0 = new QSAnimConfig(r9, getDefInitScale(), getDefInitAlpha(), false, 8, null);
        getParamViews().add(r0);
        OEALogger.INSTANCE.d(TAG, "addAnimView >> " + r0);
    }

    public final void addAnimView(QSAnimConfig r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        getParamViews().add(r3);
        OEALogger.INSTANCE.d(TAG, "addAnimView >> " + r3);
    }

    public final void setQSPullDownAnimListener(QSPullDownAnimListener r1) {
        this.qsPullDownAnimListener = r1;
    }

    public void resetViewState() {
        OEALogger.INSTANCE.d(TAG, "resetViewState");
        recollectChildViews();
        traverseChildViews(this.rootView, C02211.INSTANCE);
    }

    public final void resetAnimState() {
        OEALogger.INSTANCE.d(TAG, "reset");
        this.dragBar.reset();
        SpringAnimUtils.INSTANCE.cancelSpring(this.dragBar, AnimControlPoint.Companion.getPROPERTY_Y());
        onDragDistanceAnimUpdated(0.0f, "reset");
        this.speedTar.reset();
        Animator r1 = this.childEnterAnim;
        if (r1 == null) goto L5;
        r1.cancel();
    L5:
        Animator r2 = this.childExitAnim;
        if (r2 == null) goto L8;
        r2.cancel();
    L8:
        Animator r3 = this.draBarPerEnterAnim;
        if (r3 == null) goto L11;
        r3.cancel();
    L11:
        Animator r4 = this.draBarPerExitAnim;
        if (r4 == null) goto L14;
        r4.cancel();
    L14:
        this.lastTouchMoveY = 0.0f;
        this.lastDragBarY = 0.0f;
        this.dragUpAnimPhase = DragUpAnimPhase.NONE;
        this.childTransYProperties.clear();
        this.openCloseAnimInterruptibleF.setValue(true);
    }

    public final void tryDragStart(float r4) {
        OEALogger.INSTANCE.d(TAG, "tryDragStart >> y: " + r4);
        dragStart(r4);
    }

    public final void tryDragContinue(float r8) {
        if (this.dragStartConsumed.getValue().booleanValue() == false) goto L5;
        OEALogger.e$default(OEALogger.INSTANCE, TAG, "tryDragContinue, dragStart consumed, treat as dragStart >> y: " + r8, null, 4, null);
        dragStart(r8);
        return;
    L5:
        dragContinue(r8);
    }

    public final void tryDragEnd() {
        OEALogger.INSTANCE.d(TAG, "tryDragEnd");
        if (this.dragStartConsumed.getValue().booleanValue() == false) goto L5;
        OEALogger.e$default(OEALogger.INSTANCE, TAG, "tryDragEnd, dragStart consumed", null, 4, null);
    L5:
        dragEnd();
    }

    public final void dragStart(float r8) {
        if (this.openCloseAnimInterruptibleF.getValue().booleanValue() == true) goto L6;
        OEALogger.e$default(OEALogger.INSTANCE, TAG, "dragStart, openCloseAnimInterruptible is false, return", null, 4, null);
        return;
    L6:
        OEALogger.INSTANCE.d(TAG, "dragStart >> y: " + r8);
        this.dragStartConsumed.setValue(false);
        this.lastTouchMoveY = r8;
        this.speedTar.setY(this.dragBar.getY());
        this.lastDragBarY = this.dragBar.getY();
        this.dragContinueTimesBeforeDragUp = 0;
        cancelRunningAnim("dragStart");
    }

    public final void dragContinue(float r4) {
        if (this.openCloseAnimInterruptibleF.getValue().booleanValue() == true) goto L6;
        OEALogger.INSTANCE.d(TAG, "dragContinue, openCloseAnimInterruptible is false, return");
        return;
    L6:
        float r0 = r4 - this.lastTouchMoveY;
        this.dragBar.setY(this.lastDragBarY + r0);
        if (r0 <= 0) goto L9;
        int r1 = 1;
    L10:
        dragFollow(r1);
        this.lastTouchMoveY = r4;
        this.lastDragBarY = this.dragBar.getY();
        this.dragContinueTimesBeforeDragUp++;
        return;
    L9:
        r1 = -1;
        goto L10
    }

    public final void dragEnd() {
        dragUp();
    }

    public final void forcePlayOpenAnim() {
        this.openCloseAnimInterruptibleF.setValue(false);
        this.dragStartConsumed.setValue(true);
        playOpenAnim("forcePlayOpenAnim");
    }

    public final void forcePlayCloseAnim() {
        this.openCloseAnimInterruptibleF.setValue(false);
        this.dragStartConsumed.setValue(true);
        playCloseAnim("forcePlayCloseAnim");
    }

    private final void dragFollow(int r9) {
        AnimControlPoint r0 = this.speedTar;
        r0.setY(r0.getY() + ((this.dragBar.getY() - this.speedTar.getY()) * 0.2f));
        if (r9 > 0) goto L5;
    L9:
        if (r9 < 0) goto L11;
    L15:
        stretchChildViews();
        onDragFollow(this.dragBar.copy(), r9);
        return;
    L11:
        if (this.dragBar.getPer() < 0.5d) goto L15;
        if (this.dragBar.getY() >= (this.enterExitControlPoint - 10)) goto L15;
        OEALogger.INSTANCE.d(TAG, "dragFollow, playChildExitAnim, direction: " + r9 + ", dragBar: " + this.dragBar + ' ');
        playChildExitAnim$default(this, "dragFollow", false, 2, null);
        goto L15
    L5:
        if (this.dragBar.getPer() >= 0.5d) goto L9;
        if (this.dragBar.getY() < this.enterExitControlPoint) goto L9;
        OEALogger.INSTANCE.d(TAG, "dragFollow, playChildEnterAnim, direction: " + r9 + ", dragBar: " + this.dragBar + ' ');
        playChildEnterAnim("dragFollow");
        goto L15
    }

    private final void dragUp() {
        if (this.openCloseAnimInterruptibleF.getValue().booleanValue() == true) goto L6;
        OEALogger.e$default(OEALogger.INSTANCE, TAG, "dragUp, openCloseAnimInterruptible is false, return", null, 4, null);
        return;
    L6:
        OEALogger.INSTANCE.d(TAG, "dragUp >> dragBar.y: " + this.dragBar.getY() + ", diff: " + (this.dragBar.getY() - this.speedTar.getY()));
        this.dragStartConsumed.setValue(true);
        if (this.dragContinueTimesBeforeDragUp != 0) goto L10;
        OEALogger.e$default(OEALogger.INSTANCE, TAG, "dragUp, dragContinue times is 0, do nothing", null, 4, null);
        return;
    L10:
        this.dragContinueTimesBeforeDragUp = 0;
        if ((this.dragBar.getY() - this.speedTar.getY()) <= 30.0f) goto L14;
        playOpenAnim("dragUp");
        return;
    L14:
        if ((this.dragBar.getY() - this.speedTar.getY()) >= (-30.0f)) goto L17;
        playCloseAnim("dragUp");
        return;
    L17:
        if (this.dragBar.getY() < this.enterExitControlPoint) goto L19;
        playOpenAnim("dragUp");
        return;
    L19:
        playCloseAnim("dragUp");
    }

    private final void stretchChildViews() {
        if (this.dragBar.getY() <= this.stretchTriggerPoint) goto L5;
        final float r0 = this.dragBar.getY() - this.lastDragBarY;
    L6:
        traverseChildViews(this.rootView, new C02221(this, r0));
        return;
    L5:
        r0 = 0.0f;
        goto L6
    }

    private final void playOpenAnim(String r14) {
        OEALogger.INSTANCE.d(TAG, "playOpenAnim, scene: " + r14 + ", dragBar: " + this.dragBar);
        cancelCloseAnim(r14 + "-playOpenAnim");
        this.dragUpAnimPhase = DragUpAnimPhase.OPEN;
        playChildEnterAnim("playOpenAnim");
        onPlayDragUpOpenAnim();
        if (SpringAnimUtils.springTo$default(SpringAnimUtils.INSTANCE, this.dragBar, AnimControlPoint.Companion.getPROPERTY_Y(), this.pullDownDistance, 0.0f, 0.0f, this.dragBarAnimUpdateListener, this.dragBarAnimEndListener, 12, null) != null) goto L5;
        OEALogger.INSTANCE.d(TAG, "playOpenAnim, anim is null, reset flag");
        this.openCloseAnimInterruptibleF.setValue(true);
    L5:
        traverseChildViews(this.rootView, new C02201(this));
    }

    private final void playCloseAnim(String r14) {
        OEALogger.INSTANCE.d(TAG, "playCloseAnim, scene: " + r14 + ", dragBar: " + this.dragBar);
        cancelOpenAnim(r14 + "-playCloseAnim");
        this.dragUpAnimPhase = DragUpAnimPhase.CLOSE;
        playChildExitAnim("playCloseAnim", true);
        onPlayDragUpCloseAnim();
        if (SpringAnimUtils.springTo$default(SpringAnimUtils.INSTANCE, this.dragBar, AnimControlPoint.Companion.getPROPERTY_Y(), 0.0f, 0.0f, 0.0f, this.dragBarAnimUpdateListener, this.dragBarAnimEndListener, 12, null) != null) goto L6;
        OEALogger.INSTANCE.d(TAG, "playCloseAnim, anim is null. reset flag");
        this.openCloseAnimInterruptibleF.setValue(true);
        return;
    }

    private final void cancelRunningAnim(String r4) {
        OEALogger.INSTANCE.d(TAG, "cancelRunningAnim, dragUpAnimPhase: " + this.dragUpAnimPhase + ", dragBar: " + this.dragBar);
        int r0 = WhenMappings.$EnumSwitchMapping$0[this.dragUpAnimPhase.ordinal()];
        if (r0 != 1) goto L5;
        cancelOpenAnim(r4);
        return;
    L5:
        if (r0 != 2) goto L11;
        cancelCloseAnim(r4);
        return;
    }

    private final void cancelOpenAnim(String r4) {
        cancelChildEnterAnim();
        onCancelDragUpOpenAnim();
        SpringAnimUtils.INSTANCE.cancelSpring(this.dragBar, AnimControlPoint.Companion.getPROPERTY_Y());
        traverseChildViews(this.rootView, new AnonymousClass1(this));
        OEALogger.INSTANCE.d(TAG, "cancelOpenAnim, scene: " + r4 + ", dragBar: " + this.dragBar);
    }

    private final void cancelCloseAnim(String r4) {
        cancelChildExitAnim();
        onCancelDragUpCloseAnim();
        SpringAnimUtils.INSTANCE.cancelSpring(this.dragBar, AnimControlPoint.Companion.getPROPERTY_Y());
        OEALogger.INSTANCE.d(TAG, "cancelCloseAnim, scene: " + r4 + ", dragBar: " + this.dragBar);
    }

    private final void cancelChildEnterAnim() {
        Animator r0 = this.childEnterAnim;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        Animator r1 = this.draBarPerEnterAnim;
        if (r1 == null) goto L8;
        r1.cancel();
    L8:
        onCancelChildEnterAnim();
    }

    private final void cancelChildExitAnim() {
        Animator r0 = this.childExitAnim;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        Animator r1 = this.draBarPerExitAnim;
        if (r1 == null) goto L8;
        r1.cancel();
    L8:
        onCancelChildExitAnim();
    }

    private final void playChildEnterAnim(String r12) {
        Animator r0 = this.childExitAnim;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        Animator r1 = this.draBarPerExitAnim;
        if (r1 == null) goto L8;
        r1.cancel();
    L8:
        Animator r2 = this.childEnterAnim;
        if (r2 != null) goto L11;
    L13:
        Animator r3 = this.draBarPerEnterAnim;
        if (r3 != null) goto L16;
    L18:
        Animator r4 = makeChildEnterAnim(300);
        r4.start();
        Unit r5 = Unit.INSTANCE;
        this.childEnterAnim = r4;
        this.draBarPerEnterAnim = PropertyAnimUtils.animTo$default(PropertyAnimUtils.INSTANCE, this.dragBar, "per", 1.0f, 300, null, 8, null);
        onPlayChildEnterAnim();
        OEALogger.INSTANCE.d(TAG, "playChildEnterAnim, scene: " + r12);
        return;
    L16:
        if (r3.isRunning() != true) goto L18;
        return;
    L11:
        if (r2.isRunning() != true) goto L13;
    }

    static /* synthetic */ void playChildExitAnim$default(AbstractQSPullDownAnimHelper r0, String r1, boolean r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L6;
        r2 = false;
    L6:
        r0.playChildExitAnim(r1, r2);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: playChildExitAnim");
    }

    private final void playChildExitAnim(String r13, boolean r14) {
        Animator r0 = this.childEnterAnim;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        Animator r1 = this.draBarPerEnterAnim;
        if (r1 == null) goto L8;
        r1.cancel();
    L8:
        Animator r2 = this.childExitAnim;
        if (r2 != null) goto L11;
    L30:
        Animator r15 = this.draBarPerExitAnim;
        if (r15 != null) goto L33;
    L35:
        Animator r16 = makeChildExitAnim(200);
        r16.start();
        Unit r3 = Unit.INSTANCE;
        this.childExitAnim = r16;
        this.draBarPerExitAnim = PropertyAnimUtils.animTo$default(PropertyAnimUtils.INSTANCE, this.dragBar, "per", 0.0f, 300, null, 8, null);
        onPlayChildExitAnim();
        OEALogger.INSTANCE.d(TAG, "playChildExitAnim, scene: " + r13);
        return;
    L33:
        if (r15.isRunning() != true) goto L35;
        return;
    L11:
        if (r2.isRunning() != true) goto L30;
        if (r14 == false) goto L37;
        Animator r17 = this.childExitAnim;
        if (r17 == null) goto L16;
        Long r18 = Long.valueOf(r17.getDuration());
    L17:
        Intrinsics.checkNotNull(r18);
        if (r18.longValue() <= 100) goto L38;
        OEALogger.INSTANCE.d(TAG, "playChildExitAnim, scene: " + r13 + ", exitQuickly, childExitAnim");
        Animator r19 = makeChildExitAnim(100);
        Animator r110 = this.childExitAnim;
        if (r110 == null) goto L22;
        r110.cancel();
    L22:
        this.childExitAnim = r19;
        if (r19 == null) goto L25;
        r19.start();
    L25:
        Animator r111 = this.draBarPerExitAnim;
        if (r111 == null) goto L28;
        r111.cancel();
    L28:
        this.draBarPerExitAnim = PropertyAnimUtils.animTo$default(PropertyAnimUtils.INSTANCE, this.dragBar, "per", 0.0f, 150, null, 8, null);
        return;
    L38:
        return;
    L16:
        r18 = null;
        goto L17
    }

    private final Animator makeChildEnterAnim(long r4) {
        final AnimatorSet r0 = new AnimatorSet();
        traverseChildViews(this.rootView, new AbstractQSPullDownAnimHelper$makeChildEnterAnim$1$1(r0));
        r0.setDuration(r4);
        r0.setInterpolator(cubicEaseOutInterpolator);
        return r0;
    }

    private final Animator makeChildExitAnim(long r4) {
        final AnimatorSet r0 = new AnimatorSet();
        traverseChildViews(this.rootView, new AbstractQSPullDownAnimHelper$makeChildExitAnim$1$1(r0));
        r0.setDuration(r4);
        r0.setInterpolator(cubicEaseOutInterpolator);
        return r0;
    }

    static {
        Companion = new Companion(null);
        cubicEaseOutInterpolator = new CubicEaseOutInterpolator();
    }
}
