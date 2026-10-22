package com.obric.common.oea.foundation.animation.easy;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.constant.AgentConstants;
import com.obric.common.oea.foundation.animation.engine.DynamicAnimation;
import com.obric.common.oea.foundation.animation.engine.FloatPropertyCompat;
import com.obric.common.oea.foundation.animation.engine.SpringAnimation;
import com.obric.oui.material.MaterialConfigFormatNames;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ViewPropertySpringAnimator.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000}\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0015*\u0001+\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0001RB\r\u0012\u0006\u0010\u0004\u001a\u00028\u0000¢\u0006\u0002\u0010\u0005J/\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0019\u001a\u00020\u000f2\u0019\b\u0002\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b¢\u0006\u0002\b\u001eJ/\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0019\u001a\u00020\u000f2\u0019\b\u0002\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b¢\u0006\u0002\b\u001eJ?\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u000e\u0010!\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\n2\u0006\u0010\u0019\u001a\u00020\u000f2\u0019\b\u0002\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b¢\u0006\u0002\b\u001eJg\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0019\u001a\u00020\u000f2\u001d\u0010\"\u001a\u0019\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u001d0#¢\u0006\u0002\b\u001e2\u0017\u0010$\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000f0\u001b¢\u0006\u0002\b\u001e2\u0019\b\u0002\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b¢\u0006\u0002\b\u001eJg\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u001d\u0010\"\u001a\u0019\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u001d0#¢\u0006\u0002\b\u001e2\u0017\u0010$\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000f0\u001b¢\u0006\u0002\b\u001e2\u0006\u0010\u0019\u001a\u00020\u000f2\u0019\b\u0002\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b¢\u0006\u0002\b\u001eJ?\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u000e\u0010!\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\n2\u0006\u0010\u0019\u001a\u00020\u000f2\u0019\b\u0002\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b¢\u0006\u0002\b\u001eJ;\u0010&\u001a\u00020\u001d2\u000e\u0010!\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\n2\u0006\u0010'\u001a\u00020\u000f2\u0019\b\u0002\u0010(\u001a\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b¢\u0006\u0002\b\u001eH\u0002J\u0006\u0010)\u001a\u00020\u001dJK\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000+2\u001d\u0010\"\u001a\u0019\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u001d0#¢\u0006\u0002\b\u001e2\u0017\u0010$\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000f0\u001b¢\u0006\u0002\b\u001eH\u0002¢\u0006\u0002\u0010,J\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0019\u001a\u00020\u000fJ\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0019\u001a\u00020\u000fJ\u000e\u0010-\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020/J\u000e\u00100\u001a\u00020\u001d2\u0006\u0010.\u001a\u000201J/\u00102\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0019\u001a\u00020\u000f2\u0019\b\u0002\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b¢\u0006\u0002\b\u001eJ/\u00103\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0019\u001a\u00020\u000f2\u0019\b\u0002\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b¢\u0006\u0002\b\u001eJ/\u00104\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0019\u001a\u00020\u000f2\u0019\b\u0002\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b¢\u0006\u0002\b\u001eJ/\u00105\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0019\u001a\u00020\u000f2\u0019\b\u0002\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b¢\u0006\u0002\b\u001eJ/\u00106\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0019\u001a\u00020\u000f2\u0019\b\u0002\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b¢\u0006\u0002\b\u001eJ/\u00107\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0019\u001a\u00020\u000f2\u0019\b\u0002\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b¢\u0006\u0002\b\u001eJ/\u00108\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0019\u001a\u00020\u000f2\u0019\b\u0002\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b¢\u0006\u0002\b\u001eJ/\u00109\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0019\u001a\u00020\u000f2\u0019\b\u0002\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b¢\u0006\u0002\b\u001eJ/\u0010:\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0019\u001a\u00020\u000f2\u0019\b\u0002\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b¢\u0006\u0002\b\u001eJ/\u0010;\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0019\u001a\u00020\u000f2\u0019\b\u0002\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b¢\u0006\u0002\b\u001eJ\u008d\u0001\u0010<\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002)\b\u0002\u0010=\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0000¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(@\u0012\u0004\u0012\u00020\u001d0\u001b2)\b\u0002\u0010A\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0000¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(@\u0012\u0004\u0012\u00020\u001d0\u001b2)\b\u0002\u0010B\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0000¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(@\u0012\u0004\u0012\u00020\u001d0\u001bJ\u001c\u0010<\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u000e\u0010.\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007J\u0006\u0010C\u001a\u00020\u001dJ\f\u0010D\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000J/\u0010E\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0019\u001a\u00020\u000f2\u0019\b\u0002\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b¢\u0006\u0002\b\u001eJ/\u0010F\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0019\u001a\u00020\u000f2\u0019\b\u0002\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b¢\u0006\u0002\b\u001eJ/\u0010G\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0019\u001a\u00020\u000f2\u0019\b\u0002\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b¢\u0006\u0002\b\u001eJ/\u0010H\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0019\u001a\u00020\u000f2\u0019\b\u0002\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b¢\u0006\u0002\b\u001eJ/\u0010I\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0019\u001a\u00020\u000f2\u0019\b\u0002\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b¢\u0006\u0002\b\u001eJ/\u0010J\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0019\u001a\u00020\u000f2\u0019\b\u0002\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b¢\u0006\u0002\b\u001eJ/\u0010K\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0019\u001a\u00020\u000f2\u0019\b\u0002\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b¢\u0006\u0002\b\u001eJ/\u0010L\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0019\u001a\u00020\u000f2\u0019\b\u0002\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b¢\u0006\u0002\b\u001eJ/\u0010M\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0019\u001a\u00020\u000f2\u0019\b\u0002\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b¢\u0006\u0002\b\u001eJ/\u0010N\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0019\u001a\u00020\u000f2\u0019\b\u0002\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b¢\u0006\u0002\b\u001eJ/\u0010O\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0019\u001a\u00020\u000f2\u0019\b\u0002\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b¢\u0006\u0002\b\u001eJ/\u0010P\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0019\u001a\u00020\u000f2\u0019\b\u0002\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b¢\u0006\u0002\b\u001eJ\u001c\u0010Q\u001a\u00020\u001d*\u00020\u000b2\u000e\u0010!\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\nH\u0002R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R%\u0010\b\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0000\u0012\u00028\u00000\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0013R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00028\u0000X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0017¨\u0006S"}, d2 = {"Lcom/obric/common/oea/foundation/animation/easy/ViewPropertySpringAnimator;", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/view/View;", "", "view", "(Landroid/view/View;)V", "animatorListener", "Lcom/obric/common/oea/foundation/animation/easy/ViewPropertySpringAnimator$AnimatorListener;", "animatorMap", "", "Lcom/obric/common/oea/foundation/animation/engine/FloatPropertyCompat;", "Lcom/obric/common/oea/foundation/animation/engine/SpringAnimation;", "getAnimatorMap", "()Ljava/util/Map;", "defaultDampingRatio", "", "defaultStiffness", "isRunning", "", "()Z", "pendingAnimations", "", "Lcom/obric/common/oea/foundation/animation/easy/SpringAnimationHolder;", "Landroid/view/View;", "alpha", "value", "config", "Lkotlin/Function1;", "Lcom/obric/common/oea/foundation/animation/easy/SpringAnimationConfig;", "", "Lkotlin/ExtensionFunctionType;", "alphaBy", "animateProperty", "property", "setter", "Lkotlin/Function2;", "getter", "animatePropertyBy", "animatePropertyInternal", "finalValue", "configBuilder", "cancel", "createCustomProperty", "com/obric/common/oea/foundation/animation/easy/ViewPropertySpringAnimator$createCustomProperty$1", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)Lcom/obric/common/oea/foundation/animation/easy/ViewPropertySpringAnimator$createCustomProperty$1;", "removeEndListener", "listener", "Lcom/obric/common/oea/foundation/animation/engine/DynamicAnimation$OnAnimationEndListener;", "removeUpdateListener", "Lcom/obric/common/oea/foundation/animation/engine/DynamicAnimation$OnAnimationUpdateListener;", "rotation", "rotationBy", "rotationX", "rotationXBy", "rotationY", "rotationYBy", "scaleX", "scaleXBy", "scaleY", "scaleYBy", "setListener", AgentConstants.ON_START, "Lkotlin/ParameterName;", "name", "animator", "onCancel", "onEnd", "skipToEnd", "start", "translationX", "translationXBy", "translationY", "translationYBy", "translationZ", "translationZBy", MaterialConfigFormatNames.X, "xBy", MaterialConfigFormatNames.Y, "yBy", "z", "zBy", "cleanSelfOnEnd", "AnimatorListener", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class ViewPropertySpringAnimator<T extends View> {
    private AnimatorListener<T> animatorListener;
    private final Map<FloatPropertyCompat<? super T>, SpringAnimation> animatorMap;
    private float defaultDampingRatio;
    private float defaultStiffness;
    private final List<SpringAnimationHolder> pendingAnimations;
    private final T view;

    /* JADX INFO: compiled from: ViewPropertySpringAnimator.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\u00020\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007H\u0016J\u0016\u0010\b\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007H\u0016J\u0016\u0010\t\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007H\u0016¨\u0006\n"}, d2 = {"Lcom/obric/common/oea/foundation/animation/easy/ViewPropertySpringAnimator$AnimatorListener;", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/view/View;", "", "onAnimationCancel", "", "animator", "Lcom/obric/common/oea/foundation/animation/easy/ViewPropertySpringAnimator;", "onAnimationEnd", "onAnimationStart", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
    public interface AnimatorListener<T extends View> {

        /* JADX INFO: compiled from: ViewPropertySpringAnimator.kt */
        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
        public static final class DefaultImpls {
            public static <T extends View> void onAnimationCancel(AnimatorListener<T> r0, ViewPropertySpringAnimator<T> r1) {
                Intrinsics.checkNotNullParameter(r1, "animator");
            }

            public static <T extends View> void onAnimationEnd(AnimatorListener<T> r0, ViewPropertySpringAnimator<T> r1) {
                Intrinsics.checkNotNullParameter(r1, "animator");
            }

            public static <T extends View> void onAnimationStart(AnimatorListener<T> r0, ViewPropertySpringAnimator<T> r1) {
                Intrinsics.checkNotNullParameter(r1, "animator");
            }
        }

        void onAnimationCancel(ViewPropertySpringAnimator<T> r1);

        void onAnimationEnd(ViewPropertySpringAnimator<T> r1);

        void onAnimationStart(ViewPropertySpringAnimator<T> r1);
    }

    public ViewPropertySpringAnimator(T r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        this.view = r2;
        this.pendingAnimations = new ArrayList();
        this.animatorMap = new LinkedHashMap();
        this.defaultDampingRatio = 0.5f;
        this.defaultStiffness = 1500.0f;
    }

    public static final /* synthetic */ AnimatorListener access$getAnimatorListener$p(ViewPropertySpringAnimator r0) {
        return r0.animatorListener;
    }

    public static final /* synthetic */ void access$setAnimatorListener$p(ViewPropertySpringAnimator r0, AnimatorListener r1) {
        r0.animatorListener = r1;
    }

    public final Map<FloatPropertyCompat<? super T>, SpringAnimation> getAnimatorMap() {
        return this.animatorMap;
    }

    public final boolean isRunning() {
        Collection<SpringAnimation> r2 = this.animatorMap.values();
        if ((r2 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r3 = r2.iterator();
    L9:
        if (r3.hasNext() == false) goto L18;
        if (((SpringAnimation) r3.next()).isRunning() == false) goto L9;
        return true;
    L18:
        return false;
    L5:
        if (r2.isEmpty() == false) goto L7;
        return false;
    }

    public final ViewPropertySpringAnimator<T> defaultDampingRatio(float r2) {
        this.defaultDampingRatio = r2;
        return this;
    }

    public final ViewPropertySpringAnimator<T> defaultStiffness(float r2) {
        this.defaultStiffness = r2;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ViewPropertySpringAnimator x$default(ViewPropertySpringAnimator r0, float r1, C02061 r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = C02061.INSTANCE;
    L6:
        return r0.x(r1, r2);
    }

    public final ViewPropertySpringAnimator<T> x(float r3, Function1<? super SpringAnimationConfig, Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "config");
        DynamicAnimation.ViewProperty r0 = DynamicAnimation.X;
        Intrinsics.checkNotNullExpressionValue(r0, "DynamicAnimation.X");
        return animateProperty(r0, r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ViewPropertySpringAnimator xBy$default(ViewPropertySpringAnimator r0, float r1, C02071 r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = C02071.INSTANCE;
    L6:
        return r0.xBy(r1, r2);
    }

    public final ViewPropertySpringAnimator<T> xBy(float r3, Function1<? super SpringAnimationConfig, Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "config");
        DynamicAnimation.ViewProperty r0 = DynamicAnimation.X;
        Intrinsics.checkNotNullExpressionValue(r0, "DynamicAnimation.X");
        return animatePropertyBy(r0, r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ViewPropertySpringAnimator y$default(ViewPropertySpringAnimator r0, float r1, C02081 r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = C02081.INSTANCE;
    L6:
        return r0.y(r1, r2);
    }

    public final ViewPropertySpringAnimator<T> y(float r3, Function1<? super SpringAnimationConfig, Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "config");
        DynamicAnimation.ViewProperty r0 = DynamicAnimation.Y;
        Intrinsics.checkNotNullExpressionValue(r0, "DynamicAnimation.Y");
        return animateProperty(r0, r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ViewPropertySpringAnimator yBy$default(ViewPropertySpringAnimator r0, float r1, C02091 r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = C02091.INSTANCE;
    L6:
        return r0.yBy(r1, r2);
    }

    public final ViewPropertySpringAnimator<T> yBy(float r3, Function1<? super SpringAnimationConfig, Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "config");
        DynamicAnimation.ViewProperty r0 = DynamicAnimation.Y;
        Intrinsics.checkNotNullExpressionValue(r0, "DynamicAnimation.Y");
        return animatePropertyBy(r0, r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ViewPropertySpringAnimator z$default(ViewPropertySpringAnimator r0, float r1, C02101 r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = C02101.INSTANCE;
    L6:
        return r0.z(r1, r2);
    }

    public final ViewPropertySpringAnimator<T> z(float r3, Function1<? super SpringAnimationConfig, Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "config");
        DynamicAnimation.ViewProperty r0 = DynamicAnimation.Z;
        Intrinsics.checkNotNullExpressionValue(r0, "DynamicAnimation.Z");
        return animateProperty(r0, r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ViewPropertySpringAnimator zBy$default(ViewPropertySpringAnimator r0, float r1, C02111 r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = C02111.INSTANCE;
    L6:
        return r0.zBy(r1, r2);
    }

    public final ViewPropertySpringAnimator<T> zBy(float r3, Function1<? super SpringAnimationConfig, Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "config");
        DynamicAnimation.ViewProperty r0 = DynamicAnimation.Z;
        Intrinsics.checkNotNullExpressionValue(r0, "DynamicAnimation.Z");
        return animatePropertyBy(r0, r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ViewPropertySpringAnimator rotation$default(ViewPropertySpringAnimator r0, float r1, C01881 r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = C01881.INSTANCE;
    L6:
        return r0.rotation(r1, r2);
    }

    public final ViewPropertySpringAnimator<T> rotation(float r3, Function1<? super SpringAnimationConfig, Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "config");
        DynamicAnimation.ViewProperty r0 = DynamicAnimation.ROTATION;
        Intrinsics.checkNotNullExpressionValue(r0, "DynamicAnimation.ROTATION");
        return animateProperty(r0, r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ViewPropertySpringAnimator rotationBy$default(ViewPropertySpringAnimator r0, float r1, C01891 r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = C01891.INSTANCE;
    L6:
        return r0.rotationBy(r1, r2);
    }

    public final ViewPropertySpringAnimator<T> rotationBy(float r3, Function1<? super SpringAnimationConfig, Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "config");
        DynamicAnimation.ViewProperty r0 = DynamicAnimation.ROTATION;
        Intrinsics.checkNotNullExpressionValue(r0, "DynamicAnimation.ROTATION");
        return animatePropertyBy(r0, r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ViewPropertySpringAnimator rotationX$default(ViewPropertySpringAnimator r0, float r1, C01901 r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = C01901.INSTANCE;
    L6:
        return r0.rotationX(r1, r2);
    }

    public final ViewPropertySpringAnimator<T> rotationX(float r3, Function1<? super SpringAnimationConfig, Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "config");
        DynamicAnimation.ViewProperty r0 = DynamicAnimation.ROTATION_X;
        Intrinsics.checkNotNullExpressionValue(r0, "DynamicAnimation.ROTATION_X");
        return animateProperty(r0, r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ViewPropertySpringAnimator rotationXBy$default(ViewPropertySpringAnimator r0, float r1, C01911 r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = C01911.INSTANCE;
    L6:
        return r0.rotationXBy(r1, r2);
    }

    public final ViewPropertySpringAnimator<T> rotationXBy(float r3, Function1<? super SpringAnimationConfig, Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "config");
        DynamicAnimation.ViewProperty r0 = DynamicAnimation.ROTATION_X;
        Intrinsics.checkNotNullExpressionValue(r0, "DynamicAnimation.ROTATION_X");
        return animatePropertyBy(r0, r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ViewPropertySpringAnimator rotationY$default(ViewPropertySpringAnimator r0, float r1, C01921 r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = C01921.INSTANCE;
    L6:
        return r0.rotationY(r1, r2);
    }

    public final ViewPropertySpringAnimator<T> rotationY(float r3, Function1<? super SpringAnimationConfig, Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "config");
        DynamicAnimation.ViewProperty r0 = DynamicAnimation.ROTATION_Y;
        Intrinsics.checkNotNullExpressionValue(r0, "DynamicAnimation.ROTATION_Y");
        return animateProperty(r0, r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ViewPropertySpringAnimator rotationYBy$default(ViewPropertySpringAnimator r0, float r1, C01931 r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = C01931.INSTANCE;
    L6:
        return r0.rotationYBy(r1, r2);
    }

    public final ViewPropertySpringAnimator<T> rotationYBy(float r3, Function1<? super SpringAnimationConfig, Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "config");
        DynamicAnimation.ViewProperty r0 = DynamicAnimation.ROTATION_Y;
        Intrinsics.checkNotNullExpressionValue(r0, "DynamicAnimation.ROTATION_Y");
        return animatePropertyBy(r0, r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ViewPropertySpringAnimator translationX$default(ViewPropertySpringAnimator r0, float r1, C02001 r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = C02001.INSTANCE;
    L6:
        return r0.translationX(r1, r2);
    }

    public final ViewPropertySpringAnimator<T> translationX(float r3, Function1<? super SpringAnimationConfig, Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "config");
        DynamicAnimation.ViewProperty r0 = DynamicAnimation.TRANSLATION_X;
        Intrinsics.checkNotNullExpressionValue(r0, "DynamicAnimation.TRANSLATION_X");
        return animateProperty(r0, r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ViewPropertySpringAnimator translationXBy$default(ViewPropertySpringAnimator r0, float r1, C02011 r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = C02011.INSTANCE;
    L6:
        return r0.translationXBy(r1, r2);
    }

    public final ViewPropertySpringAnimator<T> translationXBy(float r3, Function1<? super SpringAnimationConfig, Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "config");
        DynamicAnimation.ViewProperty r0 = DynamicAnimation.TRANSLATION_X;
        Intrinsics.checkNotNullExpressionValue(r0, "DynamicAnimation.TRANSLATION_X");
        return animatePropertyBy(r0, r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ViewPropertySpringAnimator translationY$default(ViewPropertySpringAnimator r0, float r1, C02021 r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = C02021.INSTANCE;
    L6:
        return r0.translationY(r1, r2);
    }

    public final ViewPropertySpringAnimator<T> translationY(float r3, Function1<? super SpringAnimationConfig, Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "config");
        DynamicAnimation.ViewProperty r0 = DynamicAnimation.TRANSLATION_Y;
        Intrinsics.checkNotNullExpressionValue(r0, "DynamicAnimation.TRANSLATION_Y");
        return animateProperty(r0, r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ViewPropertySpringAnimator translationYBy$default(ViewPropertySpringAnimator r0, float r1, C02031 r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = C02031.INSTANCE;
    L6:
        return r0.translationYBy(r1, r2);
    }

    public final ViewPropertySpringAnimator<T> translationYBy(float r3, Function1<? super SpringAnimationConfig, Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "config");
        DynamicAnimation.ViewProperty r0 = DynamicAnimation.TRANSLATION_Y;
        Intrinsics.checkNotNullExpressionValue(r0, "DynamicAnimation.TRANSLATION_Y");
        return animatePropertyBy(r0, r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ViewPropertySpringAnimator translationZ$default(ViewPropertySpringAnimator r0, float r1, C02041 r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = C02041.INSTANCE;
    L6:
        return r0.translationZ(r1, r2);
    }

    public final ViewPropertySpringAnimator<T> translationZ(float r3, Function1<? super SpringAnimationConfig, Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "config");
        DynamicAnimation.ViewProperty r0 = DynamicAnimation.TRANSLATION_Z;
        Intrinsics.checkNotNullExpressionValue(r0, "DynamicAnimation.TRANSLATION_Z");
        return animateProperty(r0, r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ViewPropertySpringAnimator translationZBy$default(ViewPropertySpringAnimator r0, float r1, C02051 r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = C02051.INSTANCE;
    L6:
        return r0.translationZBy(r1, r2);
    }

    public final ViewPropertySpringAnimator<T> translationZBy(float r3, Function1<? super SpringAnimationConfig, Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "config");
        DynamicAnimation.ViewProperty r0 = DynamicAnimation.TRANSLATION_Z;
        Intrinsics.checkNotNullExpressionValue(r0, "DynamicAnimation.TRANSLATION_Z");
        return animatePropertyBy(r0, r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ViewPropertySpringAnimator scaleX$default(ViewPropertySpringAnimator r0, float r1, C01941 r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = C01941.INSTANCE;
    L6:
        return r0.scaleX(r1, r2);
    }

    public final ViewPropertySpringAnimator<T> scaleX(float r3, Function1<? super SpringAnimationConfig, Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "config");
        DynamicAnimation.ViewProperty r0 = DynamicAnimation.SCALE_X;
        Intrinsics.checkNotNullExpressionValue(r0, "DynamicAnimation.SCALE_X");
        return animateProperty(r0, r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ViewPropertySpringAnimator scaleXBy$default(ViewPropertySpringAnimator r0, float r1, C01951 r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = C01951.INSTANCE;
    L6:
        return r0.scaleXBy(r1, r2);
    }

    public final ViewPropertySpringAnimator<T> scaleXBy(float r3, Function1<? super SpringAnimationConfig, Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "config");
        DynamicAnimation.ViewProperty r0 = DynamicAnimation.SCALE_X;
        Intrinsics.checkNotNullExpressionValue(r0, "DynamicAnimation.SCALE_X");
        return animatePropertyBy(r0, r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ViewPropertySpringAnimator scaleY$default(ViewPropertySpringAnimator r0, float r1, C01961 r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = C01961.INSTANCE;
    L6:
        return r0.scaleY(r1, r2);
    }

    public final ViewPropertySpringAnimator<T> scaleY(float r3, Function1<? super SpringAnimationConfig, Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "config");
        DynamicAnimation.ViewProperty r0 = DynamicAnimation.SCALE_Y;
        Intrinsics.checkNotNullExpressionValue(r0, "DynamicAnimation.SCALE_Y");
        return animateProperty(r0, r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ViewPropertySpringAnimator scaleYBy$default(ViewPropertySpringAnimator r0, float r1, C01971 r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = C01971.INSTANCE;
    L6:
        return r0.scaleYBy(r1, r2);
    }

    public final ViewPropertySpringAnimator<T> scaleYBy(float r3, Function1<? super SpringAnimationConfig, Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "config");
        DynamicAnimation.ViewProperty r0 = DynamicAnimation.SCALE_Y;
        Intrinsics.checkNotNullExpressionValue(r0, "DynamicAnimation.SCALE_Y");
        return animatePropertyBy(r0, r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ViewPropertySpringAnimator alpha$default(ViewPropertySpringAnimator r0, float r1, AnonymousClass1 r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = AnonymousClass1.INSTANCE;
    L6:
        return r0.alpha(r1, r2);
    }

    public final ViewPropertySpringAnimator<T> alpha(float r3, Function1<? super SpringAnimationConfig, Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "config");
        DynamicAnimation.ViewProperty r0 = DynamicAnimation.ALPHA;
        Intrinsics.checkNotNullExpressionValue(r0, "DynamicAnimation.ALPHA");
        return animateProperty(r0, r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ViewPropertySpringAnimator alphaBy$default(ViewPropertySpringAnimator r0, float r1, C01821 r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = C01821.INSTANCE;
    L6:
        return r0.alphaBy(r1, r2);
    }

    public final ViewPropertySpringAnimator<T> alphaBy(float r3, Function1<? super SpringAnimationConfig, Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "config");
        DynamicAnimation.ViewProperty r0 = DynamicAnimation.ALPHA;
        Intrinsics.checkNotNullExpressionValue(r0, "DynamicAnimation.ALPHA");
        return animatePropertyBy(r0, r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ViewPropertySpringAnimator animateProperty$default(ViewPropertySpringAnimator r0, float r1, Function2 r2, Function1 r3, C01831 r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L6;
        r4 = C01831.INSTANCE;
    L6:
        return r0.animateProperty(r1, r2, r3, r4);
    }

    public final ViewPropertySpringAnimator<T> animateProperty(float r2, Function2<? super T, ? super Float, Unit> r3, Function1<? super T, Float> r4, Function1<? super SpringAnimationConfig, Unit> r5) {
        Intrinsics.checkNotNullParameter(r3, "setter");
        Intrinsics.checkNotNullParameter(r4, "getter");
        Intrinsics.checkNotNullParameter(r5, "config");
        return animateProperty(createCustomProperty(r3, r4), r2, r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ViewPropertySpringAnimator animatePropertyBy$default(ViewPropertySpringAnimator r0, Function2 r1, Function1 r2, float r3, C01841 r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L6;
        r4 = C01841.INSTANCE;
    L6:
        return r0.animatePropertyBy(r1, r2, r3, r4);
    }

    public final ViewPropertySpringAnimator<T> animatePropertyBy(Function2<? super T, ? super Float, Unit> r2, Function1<? super T, Float> r3, float r4, Function1<? super SpringAnimationConfig, Unit> r5) {
        Intrinsics.checkNotNullParameter(r2, "setter");
        Intrinsics.checkNotNullParameter(r3, "getter");
        Intrinsics.checkNotNullParameter(r5, "config");
        return animatePropertyBy(createCustomProperty(r2, r3), r4, r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ViewPropertySpringAnimator animateProperty$default(ViewPropertySpringAnimator r0, FloatPropertyCompat r1, float r2, AnonymousClass2 r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = AnonymousClass2.INSTANCE;
    L6:
        return r0.animateProperty(r1, r2, r3);
    }

    public final ViewPropertySpringAnimator<T> animateProperty(FloatPropertyCompat<? super T> r2, float r3, Function1<? super SpringAnimationConfig, Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "property");
        Intrinsics.checkNotNullParameter(r4, "config");
        animatePropertyInternal(r2, r3, r4);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ViewPropertySpringAnimator animatePropertyBy$default(ViewPropertySpringAnimator r0, FloatPropertyCompat r1, float r2, C01852 r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = C01852.INSTANCE;
    L6:
        return r0.animatePropertyBy(r1, r2, r3);
    }

    public final ViewPropertySpringAnimator<T> animatePropertyBy(FloatPropertyCompat<? super T> r2, float r3, Function1<? super SpringAnimationConfig, Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "property");
        Intrinsics.checkNotNullParameter(r4, "config");
        animatePropertyInternal(r2, r3 + r2.getValue(this.view), r4);
        return this;
    }

    public final ViewPropertySpringAnimator<T> start() {
        if (this.pendingAnimations.isEmpty() == true) goto L12;
        List r0 = CollectionsKt.toList(this.pendingAnimations);
        this.pendingAnimations.clear();
        AnimatorListener<T> r1 = this.animatorListener;
        if (r1 == null) goto L8;
        r1.onAnimationStart(this);
    L8:
        Iterator r2 = r0.iterator();
    L10:
        if (r2.hasNext() == false) goto L12;
        ((SpringAnimationHolder) r2.next()).start();
    L12:
        return this;
    }

    public final void cancel() {
        this.pendingAnimations.clear();
        List r0 = CollectionsKt.toList(this.animatorMap.values());
        this.animatorMap.clear();
        Iterator r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ((SpringAnimation) r1.next()).cancel();
        goto L4
    L6:
        AnimatorListener<T> r2 = this.animatorListener;
        if (r2 == null) goto L11;
        r2.onAnimationCancel(this);
        return;
    }

    public final void skipToEnd() {
        this.pendingAnimations.clear();
        List r3 = CollectionsKt.toList(this.animatorMap.values());
        ArrayList r0 = new ArrayList();
        Iterator r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        Object r1 = r4.next();
        if (((SpringAnimation) r1).canSkipToEnd() == false) goto L4;
        r0.add(r1);
        goto L4
    L8:
        Iterator r5 = r0.iterator();
    L10:
        if (r5.hasNext() == false) goto L12;
        ((SpringAnimation) r5.next()).skipToEnd();
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ViewPropertySpringAnimator setListener$default(ViewPropertySpringAnimator r0, C01981 r1, C01992 r2, AnonymousClass3 r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = C01981.INSTANCE;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = C01992.INSTANCE;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = AnonymousClass3.INSTANCE;
    L12:
        return r0.setListener(r1, r2, r3);
    }

    public final ViewPropertySpringAnimator<T> setListener(final Function1<? super ViewPropertySpringAnimator<T>, Unit> r2, final Function1<? super ViewPropertySpringAnimator<T>, Unit> r3, final Function1<? super ViewPropertySpringAnimator<T>, Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, AgentConstants.ON_START);
        Intrinsics.checkNotNullParameter(r3, "onCancel");
        Intrinsics.checkNotNullParameter(r4, "onEnd");
        return setListener((AnimatorListener) new AnonymousClass4(r2, r3, r4));
    }

    public final ViewPropertySpringAnimator<T> setListener(AnimatorListener<T> r2) {
        this.animatorListener = r2;
        return this;
    }

    public final void removeUpdateListener(DynamicAnimation.OnAnimationUpdateListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        Iterator<Map.Entry<FloatPropertyCompat<? super T>, SpringAnimation>> r1 = this.animatorMap.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().getValue().removeUpdateListener(r2);
        goto L4
    }

    public final void removeEndListener(DynamicAnimation.OnAnimationEndListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        Iterator<Map.Entry<FloatPropertyCompat<? super T>, SpringAnimation>> r1 = this.animatorMap.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().getValue().removeEndListener(r2);
        goto L4
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.obric.common.oea.foundation.animation.easy.ViewPropertySpringAnimator$createCustomProperty$1] */
    private final C01871 createCustomProperty(final Function2<? super T, ? super Float, Unit> r2, final Function1<? super T, Float> r3) {
        final String r0 = "CustomProperty";
        return new C01871(r3, r2, r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void animatePropertyInternal$default(ViewPropertySpringAnimator r0, FloatPropertyCompat r1, float r2, C01861 r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = C01861.INSTANCE;
    L5:
        r0.animatePropertyInternal(r1, r2, r3);
    }

    private final void animatePropertyInternal(FloatPropertyCompat<? super T> r3, float r4, Function1<? super SpringAnimationConfig, Unit> r5) {
        SpringAnimation r0 = this.animatorMap.get(r3);
        if (r0 != null) goto L5;
        r0 = new SpringAnimation(this.view, r3);
        cleanSelfOnEnd(r0, r3);
        this.animatorMap.put(r3, r0);
    L5:
        SpringAnimationConfig r6 = new SpringAnimationConfig(r4);
        r5.invoke(r6);
        r6.setDefaultDampingRatio$foundation_standardRelease(this.defaultDampingRatio);
        r6.setDefaultStiffness$foundation_standardRelease(this.defaultStiffness);
        this.pendingAnimations.add(new SpringAnimationHolder(r0, r6));
    }

    private final void cleanSelfOnEnd(SpringAnimation r2, final FloatPropertyCompat<? super T> r3) {
        r2.addEndListener(new ViewPropertySpringAnimator$cleanSelfOnEnd$listener$1(this, r3));
    }
}
