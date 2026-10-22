package com.obric.oui.material;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.MaskFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.android.settings.search.IndexDatabaseHelper;
import com.android.settingslib.accessibility.AccessibilityUtils;
import com.android.setupwizardlib.util.WizardManagerHelper;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.obric.common.oea.foundation.animation.token.Token;
import com.obric.common.oui.R;
import com.obric.oui.color.BlendConfig;
import com.obric.oui.color.StrokeConfig;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.fluid.FluidConfig;
import com.obric.oui.res.BlendConfigStateList;
import com.obric.oui.res.StrokeStateList;
import com.obric.oui.shadow.ShadowConfig;
import java.lang.reflect.Field;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import okhttp3.HttpUrl;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: compiled from: OMaterialDrawable.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000Î\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b/\b\u0017\u0018\u0000 £\u00012\u00020\u0001:\u0004£\u0001¤\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020>H\u0002J\u0010\u0010T\u001a\u00020P2\u0006\u0010U\u001a\u00020\u0001H\u0003J\u001f\u0010V\u001a\u00020P2\u0006\u0010W\u001a\u00020X2\f\u0010Y\u001a\b\u0012\u0004\u0012\u00020X0ZH\u0082\bJ\u0010\u0010[\u001a\u00020P2\u0006\u0010Q\u001a\u00020RH\u0016J\u0010\u0010\\\u001a\u00020P2\u0006\u0010Q\u001a\u00020RH\u0003J\u0006\u0010]\u001a\u00020PJ\u0010\u0010^\u001a\u0002022\u0006\u0010_\u001a\u000202H\u0002J\n\u0010`\u001a\u0004\u0018\u00010aH\u0016J.\u0010b\u001a\u00020P2\u0006\u0010c\u001a\u00020d2\u0006\u0010e\u001a\u00020f2\u0006\u0010g\u001a\u00020h2\f\u0010i\u001a\b\u0018\u00010jR\u00020dH\u0016J\u0010\u0010k\u001a\u00020\"2\u0006\u0010l\u001a\u00020@H\u0002J\b\u0010m\u001a\u00020\"H\u0016J\b\u0010n\u001a\u00020PH\u0016J\u0010\u0010o\u001a\u00020P2\u0006\u0010c\u001a\u00020pH\u0014J\u0010\u0010q\u001a\u00020\"2\u0006\u0010_\u001a\u000202H\u0014J0\u0010r\u001a\u00020\"2\u0006\u0010s\u001a\u00020t2\u0006\u0010u\u001a\u00020v2\u0006\u0010w\u001a\u00020\u00102\u0006\u0010_\u001a\u0002022\u0006\u0010x\u001a\u000204H\u0002J\u0010\u0010y\u001a\u00020\"2\u0006\u0010_\u001a\u000202H\u0002J\u000e\u0010z\u001a\u00020P2\u0006\u0010{\u001a\u00020\"J\u000e\u0010|\u001a\u00020P2\u0006\u0010}\u001a\u00020\"J1\u0010~\u001a\u00020P2\u0006\u0010\u007f\u001a\u0002042\t\b\u0002\u0010\u0080\u0001\u001a\u00020\u00102\t\b\u0002\u0010\u0081\u0001\u001a\u00020\u00102\t\b\u0002\u0010\u0082\u0001\u001a\u00020\"H\u0007J@\u0010\u0083\u0001\u001a\u00020P2\u000e\u00103\u001a\n\u0012\u0004\u0012\u000204\u0018\u00010\u00132\t\b\u0002\u0010\u0080\u0001\u001a\u00020\u00102\t\b\u0002\u0010\u0081\u0001\u001a\u00020\u00102\t\b\u0002\u0010\u0082\u0001\u001a\u00020\"H\u0007¢\u0006\u0003\u0010\u0084\u0001J!\u0010\u0085\u0001\u001a\u00020P2\u0006\u0010u\u001a\u00020v2\u0006\u0010w\u001a\u00020\u00102\u0006\u0010x\u001a\u000204H\u0002J\u001d\u0010\u0086\u0001\u001a\u00020P2\u000e\u0010?\u001a\n\u0012\u0004\u0012\u00020@\u0018\u00010\u0013¢\u0006\u0003\u0010\u0087\u0001J\u0011\u0010\u0088\u0001\u001a\u00020P2\b\u0010E\u001a\u0004\u0018\u00010FJG\u0010\u0088\u0001\u001a\u00020P2\u0007\u0010\u0089\u0001\u001a\u00020\u00102\t\b\u0002\u0010\u008a\u0001\u001a\u00020\u00102\t\b\u0002\u0010\u008b\u0001\u001a\u00020\u00102\t\b\u0002\u0010\u008c\u0001\u001a\u00020\u00102\t\b\u0002\u0010\u008d\u0001\u001a\u00020\u00102\t\b\u0002\u0010\u008e\u0001\u001a\u00020\u0010J\u0011\u0010\u008f\u0001\u001a\u00020\"2\u0006\u0010_\u001a\u000202H\u0016J\u001a\u0010\u0090\u0001\u001a\u00020P2\u0007\u0010\u0091\u0001\u001a\u00020\u00102\b\u0010H\u001a\u0004\u0018\u00010FJP\u0010\u0090\u0001\u001a\u00020P2\u0007\u0010\u0091\u0001\u001a\u00020\u00102\u0007\u0010\u0089\u0001\u001a\u00020\u00102\t\b\u0002\u0010\u008a\u0001\u001a\u00020\u00102\t\b\u0002\u0010\u008b\u0001\u001a\u00020\u00102\t\b\u0002\u0010\u008c\u0001\u001a\u00020\u00102\t\b\u0002\u0010\u008d\u0001\u001a\u00020\u00102\t\b\u0002\u0010\u008e\u0001\u001a\u00020\u0010JJ\u0010\u0092\u0001\u001a\u00020\"2\u0006\u0010u\u001a\u00020v2\u0006\u0010w\u001a\u00020\u00102\u0007\u0010\u0093\u0001\u001a\u00020\"2\u000f\u0010\u0094\u0001\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00132\u000f\u0010\u0095\u0001\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0013H\u0002¢\u0006\u0003\u0010\u0096\u0001JJ\u0010\u0097\u0001\u001a\u00020\"2\u0006\u0010u\u001a\u00020v2\u0006\u0010w\u001a\u00020\u00102\u0007\u0010\u0093\u0001\u001a\u00020\"2\u000f\u0010\u0098\u0001\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00132\u000f\u0010\u0099\u0001\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0013H\u0002¢\u0006\u0003\u0010\u0096\u0001J\u001b\u0010\u009a\u0001\u001a\u00020P2\u0007\u0010\u009b\u0001\u001a\u00020\u00102\u0007\u0010\u009c\u0001\u001a\u00020\"H\u0002J\u001b\u0010\u009d\u0001\u001a\u00020P2\u0007\u0010\u009b\u0001\u001a\u00020\u00102\u0007\u0010\u009c\u0001\u001a\u00020\"H\u0002J@\u0010\u009e\u0001\u001a\u00020\"2\u0006\u0010s\u001a\u00020t2\u0006\u0010u\u001a\u00020v2\u0006\u0010w\u001a\u00020\u00102\u0007\u0010\u0093\u0001\u001a\u00020\"2\t\u0010\u009f\u0001\u001a\u0004\u0018\u00010\u001c2\t\u0010 \u0001\u001a\u0004\u0018\u00010\u001cH\u0002J\u0016\u0010¡\u0001\u001a\u00020\"*\u0002022\u0007\u0010¢\u0001\u001a\u00020\u0010H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0013X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0017\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00130\u0013X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0019R\u001e\u0010\u001a\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00130\u0013X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0019R\u0018\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u0013X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001dR\u001e\u0010\u001e\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00130\u0013X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0019R\u001e\u0010\u001f\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00130\u0013X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0019R\u0018\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u0013X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001dR\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010$\u001a\u00020\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0011\u0010)\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\"\u0010,\u001a\b\u0012\u0004\u0012\u00020\"0\u0013X\u0086\u000e¢\u0006\u0010\n\u0002\u00100\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0010\u00101\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u00103\u001a\n\u0012\u0004\u0012\u000204\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0004\n\u0002\u00105R\u000e\u00106\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u00108\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0013X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0015R\u001a\u00109\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010+\"\u0004\b;\u0010<R\u000e\u0010=\u001a\u00020>X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010?\u001a\n\u0012\u0004\u0012\u00020@\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0004\n\u0002\u0010AR\u000e\u0010B\u001a\u00020>X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020DX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010E\u001a\u0004\u0018\u00010FX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010G\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010H\u001a\u0004\u0018\u00010FX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020MX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020MX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006¥\u0001"}, d2 = {"Lcom/obric/oui/material/OMaterialDrawable;", "Landroid/graphics/drawable/GradientDrawable;", "()V", "animDuration", "", "getAnimDuration", "()J", "setAnimDuration", "(J)V", "animInterpolator", "Landroid/view/animation/LinearInterpolator;", "getAnimInterpolator", "()Landroid/view/animation/LinearInterpolator;", "setAnimInterpolator", "(Landroid/view/animation/LinearInterpolator;)V", "animatedSolidColor", "", "animatedStrokeColor", "blendAnimatorArray", "", "Landroid/animation/ValueAnimator;", "[Landroid/animation/ValueAnimator;", "colorAnimator", "currentBlendConfigsArray", "Lcom/obric/oui/color/BlendConfig;", "[[Lcom/obric/oui/color/BlendConfig;", "currentOverlayBlendConfigsArray", "currentStrokeConfigArray", "Lcom/obric/oui/color/StrokeConfig;", "[Lcom/obric/oui/color/StrokeConfig;", "drawBlendConfigsArray", "drawOverlayBlendConfigsArray", "drawStrokeConfigArray", "enableExtraStateChange", "", "enableShadow", "enableStateChangeTransition", "getEnableStateChangeTransition", "()Z", "setEnableStateChangeTransition", "(Z)V", "envMaterialApiVersion", "getEnvMaterialApiVersion", "()I", "isCallbackInitArray", "()[Ljava/lang/Boolean;", "setCallbackInitArray", "([Ljava/lang/Boolean;)V", "[Ljava/lang/Boolean;", "lastStateSet", "", "materialConfigs", "Lcom/obric/oui/material/MaterialConfig;", "[Lcom/obric/oui/material/MaterialConfig;", "materialDrawMode", "materialSrcType", "overlayBlendAnimatorArray", "requireApiVersion", "getRequireApiVersion", "setRequireApiVersion", "(I)V", "shadowClipPath", "Landroid/graphics/Path;", "shadowConfigs", "Lcom/obric/oui/shadow/ShadowConfig;", "[Lcom/obric/oui/shadow/ShadowConfig;", "shadowDrawPath", "shadowPaint", "Landroid/graphics/Paint;", "solidColors", "Landroid/content/res/ColorStateList;", "strokeAnimator", "strokeColors", "strokeWidth", "targetSolidColor", "targetStrokeColor", "tmpRectF", "Landroid/graphics/RectF;", "tmpShadowRectF", "clipOutShadowPath", "", "canvas", "Landroid/graphics/Canvas;", "path", "copyGradientInternalStateFrom", "template", "debugLog", "stage", "", "message", "Lkotlin/Function0;", "draw", "drawMultiLayerShadow", "endAnimation", "filterStateSet", "stateSet", "getConstantState", "Landroid/graphics/drawable/Drawable$ConstantState;", "inflate", "r", "Landroid/content/res/Resources;", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "attrs", "Landroid/util/AttributeSet;", "theme", "Landroid/content/res/Resources$Theme;", "isShadowValid", "config", "isStateful", "jumpToCurrentState", "onBoundsChange", "Landroid/graphics/Rect;", "onStateChange", "processMaterialOnStateChange", "view", "Landroid/view/View;", "effectParams", "", "index", WizardManagerHelper.THEME_MATERIAL, "processSolidAndStrokeOnStateChange", "setEnableExtraStateChange", IndexDatabaseHelper.IndexColumns.ENABLED, "setEnableShadow", "enable", "setMaterialConfig", "materialConfig", "srcType", "drawMode", "applyImmediately", "setMaterialConfigs", "([Lcom/obric/oui/material/MaterialConfig;IIZ)V", "setMaterialToEffectObjectIfNotInit", "setShadowConfigs", "([Lcom/obric/oui/shadow/ShadowConfig;)V", "setSolidColors", "normal", "pressed", MaterialConfigFormatNames.SELECTED, "checked", MaterialConfigFormatNames.HOVER, "disabled", "setState", "setStrokeConfigs", MaterialConfigFormatNames.WIDTH, "updateBlendConfigs", "enableAnimate", "fromBlendConfigs", "toBlendConfigs", "(Ljava/lang/Object;IZ[Lcom/obric/oui/color/BlendConfig;[Lcom/obric/oui/color/BlendConfig;)Z", "updateOverlayBlendConfigs", "fromOverlayBlendConfigs", "toOverlayBlendConfigs", "updateSolidColor", "toColor", "animate", "updateStrokeColor", "updateStrokeConfig", "fromStrokeConfig", "toStrokeConfig", "containsState", "target", "Companion", "OMaterialDrawableState", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OMaterialDrawable extends GradientDrawable {
    public static final Companion Companion = null;
    private static boolean DEBUGGABLE = false;
    private static final int[] DISABLED_STATE_SET = null;
    private static final int[] ENABLED_STATE_SET = null;
    private static final int MAX_MATERIAL_CONFIG_COUNT = 2;
    public static final String TAG = "OMaterialDrawable";
    private long animDuration;
    private LinearInterpolator animInterpolator;
    private int animatedSolidColor;
    private int animatedStrokeColor;
    private ValueAnimator[] blendAnimatorArray;
    private ValueAnimator colorAnimator;
    private BlendConfig[][] currentBlendConfigsArray;
    private BlendConfig[][] currentOverlayBlendConfigsArray;
    private StrokeConfig[] currentStrokeConfigArray;
    private BlendConfig[][] drawBlendConfigsArray;
    private BlendConfig[][] drawOverlayBlendConfigsArray;
    private StrokeConfig[] drawStrokeConfigArray;
    private boolean enableExtraStateChange;
    private boolean enableShadow;
    private boolean enableStateChangeTransition;
    private final int envMaterialApiVersion;
    private Boolean[] isCallbackInitArray;
    private int[] lastStateSet;
    private MaterialConfig[] materialConfigs;
    private int materialDrawMode;
    private int materialSrcType;
    private ValueAnimator[] overlayBlendAnimatorArray;
    private int requireApiVersion;
    private final Path shadowClipPath;
    private ShadowConfig[] shadowConfigs;
    private final Path shadowDrawPath;
    private final Paint shadowPaint;
    private ColorStateList solidColors;
    private ValueAnimator strokeAnimator;
    private ColorStateList strokeColors;
    private int strokeWidth;
    private int targetSolidColor;
    private int targetStrokeColor;
    private final RectF tmpRectF;
    private final RectF tmpShadowRectF;

    /* JADX INFO: compiled from: OMaterialDrawable.kt */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\u0011\u001a\u00020\u00102\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013H\u0002¢\u0006\u0002\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u000eH\u0002J\u0012\u0010\u0018\u001a\u00020\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\u0010\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u000eH\u0002J\u0012\u0010\u001d\u001a\u00020\u00102\b\u0010\u001e\u001a\u0004\u0018\u00010\u000bH\u0002J\u0010\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010\"\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u000bH\u0002R$\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/obric/oui/material/OMaterialDrawable$Companion;", "", "()V", "DEBUGGABLE", "", "getDEBUGGABLE$annotations", "getDEBUGGABLE", "()Z", "setDEBUGGABLE", "(Z)V", "DISABLED_STATE_SET", "", "ENABLED_STATE_SET", "MAX_MATERIAL_CONFIG_COUNT", "", "TAG", "", "describeBlendConfigs", Constants.KEY_CONFIG, "", "Lcom/obric/oui/color/BlendConfig;", "([Lcom/obric/oui/color/BlendConfig;)Ljava/lang/String;", "describeState", "state", "describeStrokeConfig", "config", "Lcom/obric/oui/color/StrokeConfig;", "formatColor", "color", "formatNullableStateSet", "stateSet", "formatProgress", "progress", "", "formatStateSet", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getDEBUGGABLE$annotations() {
        }

        private Companion() {
        }

        public static final /* synthetic */ String access$describeBlendConfigs(Companion r0, BlendConfig[] r1) {
            return r0.describeBlendConfigs(r1);
        }

        public static final /* synthetic */ String access$describeState(Companion r0, int r1) {
            return r0.describeState(r1);
        }

        public static final /* synthetic */ String access$describeStrokeConfig(Companion r0, StrokeConfig r1) {
            return r0.describeStrokeConfig(r1);
        }

        public static final /* synthetic */ String access$formatColor(Companion r0, int r1) {
            return r0.formatColor(r1);
        }

        public static final /* synthetic */ String access$formatNullableStateSet(Companion r0, int[] r1) {
            return r0.formatNullableStateSet(r1);
        }

        public static final /* synthetic */ String access$formatProgress(Companion r0, float r1) {
            return r0.formatProgress(r1);
        }

        public static final /* synthetic */ String access$formatStateSet(Companion r0, int[] r1) {
            return r0.formatStateSet(r1);
        }

        public final boolean getDEBUGGABLE() {
            return OMaterialDrawable.access$getDEBUGGABLE$cp();
        }

        public final void setDEBUGGABLE(boolean r1) {
            OMaterialDrawable.access$setDEBUGGABLE$cp(r1);
        }

        private final String formatNullableStateSet(int[] r2) {
            if (r2 == null) goto L10;
            String r1 = formatStateSet(r2);
            if (r1 != null) goto L9;
            return "null";
        L9:
            return r1;
        L10:
            return "null";
        }

        private final String formatStateSet(int[] r10) {
            if (r10.length != 0) goto L5;
            boolean r9 = true;
        L6:
            if (r9 == false) goto L10;
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        L10:
            return ArraysKt.joinToString$default(r10, null, "[", "]", 0, null, OMaterialDrawable$Companion$formatStateSet$1.INSTANCE, 25, null);
        L5:
            r9 = false;
            goto L6
        }

        private final String describeState(int r1) {
            switch(r1) {
                case -16842910: goto L13;
                case 16842908: goto L12;
                case 16842909: goto L11;
                case 16842910: goto L10;
                case 16842912: goto L9;
                case 16842913: goto L8;
                case 16842919: goto L7;
                case 16843518: goto L6;
                case 16843547: goto L5;
                case 16843623: goto L4;
                default: goto L15;
            };
        L4:
            return "state_hovered";
        L5:
            return "state_accelerated";
        L6:
            return "state_activated";
        L7:
            return "state_pressed";
        L8:
            return "state_selected";
        L9:
            return "state_checked";
        L10:
            return "state_enabled";
        L11:
            return "state_window_focused";
        L12:
            return "state_focused";
        L13:
            return "-state_enabled";
        L15:
            return String.valueOf(r1);
        }

        private final String describeBlendConfigs(BlendConfig[] r10) {
            if (r10 == null) goto L10;
            String r11 = ArraysKt.joinToString$default(r10, null, "[", "]", 0, null, OMaterialDrawable$Companion$describeBlendConfigs$1.INSTANCE, 25, null);
            if (r11 != null) goto L9;
            return "null";
        L9:
            return r11;
        L10:
            return "null";
        }

        private final String describeStrokeConfig(StrokeConfig r3) {
            if (r3 == null) goto L10;
            String r4 = "{width=" + r3.getWidth() + ", color=" + OMaterialDrawable.Companion.formatColor(r3.getColor()) + '}';
            if (r4 != null) goto L9;
            return "null";
        L9:
            return r4;
        L10:
            return "null";
        }

        private final String formatColor(int r3) {
            StringCompanionObject r2 = StringCompanionObject.INSTANCE;
            String r4 = String.format("#%08X", Arrays.copyOf(new Object[]{Integer.valueOf(r3)}, 1));
            Intrinsics.checkNotNullExpressionValue(r4, "format(format, *args)");
            return r4;
        }

        private final String formatProgress(float r3) {
            StringCompanionObject r2 = StringCompanionObject.INSTANCE;
            String r4 = String.format("%.3f", Arrays.copyOf(new Object[]{Float.valueOf(r3)}, 1));
            Intrinsics.checkNotNullExpressionValue(r4, "format(format, *args)");
            return r4;
        }
    }

    /* JADX INFO: compiled from: OMaterialDrawable.kt */
    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u008b\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u0012\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0010\u0012\u0006\u0010\u0016\u001a\u00020\u0004¢\u0006\u0002\u0010\u0017J\b\u0010\u001a\u001a\u00020\u0004H\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0012\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J \u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\f\u0010\u001f\u001a\b\u0018\u00010 R\u00020\u001eH\u0016R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0018R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0010X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0019R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/obric/oui/material/OMaterialDrawable$OMaterialDrawableState;", "Landroid/graphics/drawable/Drawable$ConstantState;", "baseState", "changingConfigurations", "", "enableShadow", "", "enableExtraStateChange", "solidColors", "Landroid/content/res/ColorStateList;", "strokeWidth", "strokeColors", "animDuration", "", "enableStateChangeTransition", "materialConfigs", "", "Lcom/obric/oui/material/MaterialConfig;", "materialSrcType", "materialDrawMode", "shadowConfigs", "Lcom/obric/oui/shadow/ShadowConfig;", "requireApiVersion", "(Landroid/graphics/drawable/Drawable$ConstantState;IZZLandroid/content/res/ColorStateList;ILandroid/content/res/ColorStateList;JZ[Lcom/obric/oui/material/MaterialConfig;II[Lcom/obric/oui/shadow/ShadowConfig;I)V", "[Lcom/obric/oui/material/MaterialConfig;", "[Lcom/obric/oui/shadow/ShadowConfig;", "getChangingConfigurations", "newDrawable", "Landroid/graphics/drawable/Drawable;", "res", "Landroid/content/res/Resources;", "theme", "Landroid/content/res/Resources$Theme;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class OMaterialDrawableState extends Drawable.ConstantState {
        private final long animDuration;
        private final Drawable.ConstantState baseState;
        private final int changingConfigurations;
        private final boolean enableExtraStateChange;
        private final boolean enableShadow;
        private final boolean enableStateChangeTransition;
        private final MaterialConfig[] materialConfigs;
        private final int materialDrawMode;
        private final int materialSrcType;
        private final int requireApiVersion;
        private final ShadowConfig[] shadowConfigs;
        private final ColorStateList solidColors;
        private final ColorStateList strokeColors;
        private final int strokeWidth;

        public OMaterialDrawableState(Drawable.ConstantState r1, int r2, boolean r3, boolean r4, ColorStateList r5, int r6, ColorStateList r7, long r8, boolean r10, MaterialConfig[] r11, int r12, int r13, ShadowConfig[] r14, int r15) {
            this.baseState = r1;
            this.changingConfigurations = r2;
            this.enableShadow = r3;
            this.enableExtraStateChange = r4;
            this.solidColors = r5;
            this.strokeWidth = r6;
            this.strokeColors = r7;
            this.animDuration = r8;
            this.enableStateChangeTransition = r10;
            this.materialConfigs = r11;
            this.materialSrcType = r12;
            this.materialDrawMode = r13;
            this.shadowConfigs = r14;
            this.requireApiVersion = r15;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.changingConfigurations;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return newDrawable(null, null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources r2) {
            return newDrawable(r2, null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources r4, Resources.Theme r5) {
            GradientDrawable r0 = null;
            Drawable.ConstantState r1 = this.baseState;     // Catch: Exception -> L12
            if (r1 == null) goto L13;
            if (r5 == null) goto L8;
            Drawable r6 = r1.newDrawable(r4, r5);     // Catch: Exception -> L12
        L14:
            OMaterialDrawable r7 = new OMaterialDrawable();
            if ((r6 instanceof GradientDrawable) == false) goto L17;
            r0 = (GradientDrawable) r6;
        L17:
            if (r0 == null) goto L20;
            OMaterialDrawable.access$copyGradientInternalStateFrom(r7, r0);
        L20:
            OMaterialDrawable.access$setEnableShadow$p(r7, this.enableShadow);
            OMaterialDrawable.access$setEnableExtraStateChange$p(r7, this.enableExtraStateChange);
            r7.setAnimDuration(this.animDuration);
            r7.setEnableStateChangeTransition(this.enableStateChangeTransition);
            r7.setMaterialConfigs(this.materialConfigs, this.materialSrcType, this.materialDrawMode, false);
            r7.setShadowConfigs(this.shadowConfigs);
            r7.setSolidColors(this.solidColors);
            r7.setStrokeConfigs(this.strokeWidth, this.strokeColors);
            r7.setCallbackInitArray(new Boolean[]{false, false});
            r7.setRequireApiVersion(this.requireApiVersion);
            return r7;
        L12:
            Drawable r8 = (Drawable) null;
            goto L13
        L8:
            if (r4 == null) goto L10;
            r6 = r1.newDrawable(r4);     // Catch: Exception -> L12
            goto L14
        L10:
            r6 = r1.newDrawable();     // Catch: Exception -> L12
        L13:
            r6 = null;
            goto L14
        L24:
            Drawable r9 = (Drawable) null;
            goto L13
        }
    }

    public static /* synthetic */ void $r8$lambda$REzZRhpOZ2PJYWiEVb3ZIIU2YCw(OMaterialDrawable r0, ValueAnimator r1) {
        m1246updateStrokeColor$lambda62$lambda61(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$bJYb-QyA7zuvgu-S8KAJG05Vxwk, reason: not valid java name */
    public static /* synthetic */ void m1241$r8$lambda$bJYbQyA7zuvguS8KAJG05Vxwk(StrokeConfig r0, StrokeConfig r1, OMaterialDrawable r2, int r3, View r4, ValueAnimator r5) {
        m1247updateStrokeConfig$lambda50$lambda49(r0, r1, r2, r3, r4, r5);
    }

    /* JADX INFO: renamed from: $r8$lambda$ecD8iBllaz-2Qi0A_Bqke4BPoSQ, reason: not valid java name */
    public static /* synthetic */ void m1242$r8$lambda$ecD8iBllaz2Qi0A_Bqke4BPoSQ(OMaterialDrawable r0, ValueAnimator r1) {
        m1245updateSolidColor$lambda58$lambda57(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$pTJRImPEavF_Y2lZNu67v2cbwvI(BlendConfig[] r0, BlendConfig[] r1, OMaterialDrawable r2, int r3, Object r4, ValueAnimator r5) {
        m1243updateBlendConfigs$lambda35$lambda34(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ void $r8$lambda$xaWagFZz3V0CMVKZQYKYKvEErVY(BlendConfig[] r0, BlendConfig[] r1, OMaterialDrawable r2, Object r3, int r4, ValueAnimator r5) {
        m1244updateOverlayBlendConfigs$lambda43$lambda42(r0, r1, r2, r3, r4, r5);
    }

    public static final boolean getDEBUGGABLE() {
        return Companion.getDEBUGGABLE();
    }

    public static final void setDEBUGGABLE(boolean r1) {
        Companion.setDEBUGGABLE(r1);
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    public final void setMaterialConfig(MaterialConfig r9) {
        Intrinsics.checkNotNullParameter(r9, "materialConfig");
        setMaterialConfig$default(this, r9, 0, 0, false, 14, null);
    }

    public final void setMaterialConfig(MaterialConfig r9, int r10) {
        Intrinsics.checkNotNullParameter(r9, "materialConfig");
        setMaterialConfig$default(this, r9, r10, 0, false, 12, null);
    }

    public final void setMaterialConfig(MaterialConfig r9, int r10, int r11) {
        Intrinsics.checkNotNullParameter(r9, "materialConfig");
        setMaterialConfig$default(this, r9, r10, r11, false, 8, null);
    }

    public final void setMaterialConfigs(MaterialConfig[] r8) {
        setMaterialConfigs$default(this, r8, 0, 0, false, 14, null);
    }

    public final void setMaterialConfigs(MaterialConfig[] r8, int r9) {
        setMaterialConfigs$default(this, r8, r9, 0, false, 12, null);
    }

    public final void setMaterialConfigs(MaterialConfig[] r8, int r9, int r10) {
        setMaterialConfigs$default(this, r8, r9, r10, false, 8, null);
    }

    public static final /* synthetic */ void access$copyGradientInternalStateFrom(OMaterialDrawable r0, GradientDrawable r1) {
        r0.copyGradientInternalStateFrom(r1);
    }

    public static final /* synthetic */ int access$getAnimatedSolidColor$p(OMaterialDrawable r0) {
        return r0.animatedSolidColor;
    }

    public static final /* synthetic */ int access$getAnimatedStrokeColor$p(OMaterialDrawable r0) {
        return r0.animatedStrokeColor;
    }

    public static final /* synthetic */ boolean access$getDEBUGGABLE$cp() {
        return DEBUGGABLE;
    }

    public static final /* synthetic */ BlendConfig[][] access$getDrawBlendConfigsArray$p(OMaterialDrawable r0) {
        return r0.drawBlendConfigsArray;
    }

    public static final /* synthetic */ BlendConfig[][] access$getDrawOverlayBlendConfigsArray$p(OMaterialDrawable r0) {
        return r0.drawOverlayBlendConfigsArray;
    }

    public static final /* synthetic */ StrokeConfig[] access$getDrawStrokeConfigArray$p(OMaterialDrawable r0) {
        return r0.drawStrokeConfigArray;
    }

    public static final /* synthetic */ void access$setDEBUGGABLE$cp(boolean r0) {
        DEBUGGABLE = r0;
    }

    public static final /* synthetic */ void access$setEnableExtraStateChange$p(OMaterialDrawable r0, boolean r1) {
        r0.enableExtraStateChange = r1;
    }

    public static final /* synthetic */ void access$setEnableShadow$p(OMaterialDrawable r0, boolean r1) {
        r0.enableShadow = r1;
    }

    public OMaterialDrawable() {
        this.enableExtraStateChange = true;
        this.animDuration = Token.Duration.OUI_ANIMATION_DURATION_SHORT_3.getDuration();
        this.animInterpolator = new LinearInterpolator();
        this.materialSrcType = 2;
        this.materialDrawMode = 1;
        Paint r2 = new Paint(1);
        r2.setStyle(Paint.Style.FILL);
        this.shadowPaint = r2;
        this.shadowClipPath = new Path();
        this.shadowDrawPath = new Path();
        this.tmpRectF = new RectF();
        this.tmpShadowRectF = new RectF();
        this.isCallbackInitArray = new Boolean[]{false, false};
        this.requireApiVersion = 1;
        this.envMaterialApiVersion = OMaterialHelper.getMaterialApiVersion();
        this.currentBlendConfigsArray = new BlendConfig[2][];
        this.drawBlendConfigsArray = new BlendConfig[2][];
        this.currentOverlayBlendConfigsArray = new BlendConfig[2][];
        this.drawOverlayBlendConfigsArray = new BlendConfig[2][];
        this.currentStrokeConfigArray = new StrokeConfig[2];
        this.drawStrokeConfigArray = new StrokeConfig[2];
        this.blendAnimatorArray = new ValueAnimator[2];
        this.overlayBlendAnimatorArray = new ValueAnimator[2];
        this.enableStateChangeTransition = true;
    }

    public final long getAnimDuration() {
        return this.animDuration;
    }

    public final void setAnimDuration(long r1) {
        this.animDuration = r1;
    }

    public final LinearInterpolator getAnimInterpolator() {
        return this.animInterpolator;
    }

    public final void setAnimInterpolator(LinearInterpolator r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.animInterpolator = r2;
    }

    public final Boolean[] isCallbackInitArray() {
        return this.isCallbackInitArray;
    }

    public final void setCallbackInitArray(Boolean[] r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.isCallbackInitArray = r2;
    }

    public final int getRequireApiVersion() {
        return this.requireApiVersion;
    }

    public final void setRequireApiVersion(int r1) {
        this.requireApiVersion = r1;
    }

    public final int getEnvMaterialApiVersion() {
        return this.envMaterialApiVersion;
    }

    public final boolean getEnableStateChangeTransition() {
        return this.enableStateChangeTransition;
    }

    public final void setEnableStateChangeTransition(boolean r1) {
        this.enableStateChangeTransition = r1;
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return new OMaterialDrawableState(super.getConstantState(), getChangingConfigurations(), this.enableShadow, this.enableExtraStateChange, this.solidColors, this.strokeWidth, this.strokeColors, this.animDuration, this.enableStateChangeTransition, this.materialConfigs, this.materialSrcType, this.materialDrawMode, this.shadowConfigs, this.requireApiVersion);
    }

    private final void copyGradientInternalStateFrom(GradientDrawable r3) {
        Field r0 = GradientDrawable.class.getDeclaredField("mGradientState");     // Catch: Exception -> L4
        r0.setAccessible(true);     // Catch: Exception -> L4
        r0.set(this, r0.get(r3));     // Catch: Exception -> L4
        return;
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public void inflate(Resources r17, XmlPullParser r18, AttributeSet r19, Resources.Theme r20) {
        Intrinsics.checkNotNullParameter(r17, "r");
        Intrinsics.checkNotNullParameter(r18, "parser");
        Intrinsics.checkNotNullParameter(r19, "attrs");
        if (r20 != null) goto L5;
        TypedArray r0 = null;
    L6:
        if (r0 != null) goto L8;
        r0 = r17.obtainAttributes(r19, R.styleable.OMaterialDrawable);
    L8:
        TypedArray r8 = r0;
        int r9 = -1;
        boolean r10 = true;
        this.requireApiVersion = r8.getInt(R.styleable.OMaterialDrawable_oui_widgetMaterialApiVersion, 1);     // Catch: Throwable -> L52 Exception -> L54
        ColorStateList r11 = r8.getColorStateList(R.styleable.OMaterialDrawable_oui_solidColor);     // Catch: Throwable -> L52 Exception -> L54
        ColorStateList r12 = r8.getColorStateList(R.styleable.OMaterialDrawable_oui_strokeColor);     // Catch: Exception -> L50 Throwable -> L52
        r9 = r8.getDimensionPixelSize(R.styleable.OMaterialDrawable_oui_strokeWidth, -1);     // Catch: Exception -> L48 Throwable -> L52
        this.enableShadow = r8.getBoolean(R.styleable.OMaterialDrawable_oui_widgetEnableShadow, false);     // Catch: Exception -> L48 Throwable -> L52
        this.enableExtraStateChange = r8.getBoolean(R.styleable.OMaterialDrawable_oui_widgetExtraStateChange, true);     // Catch: Exception -> L48 Throwable -> L52
        if (this.envMaterialApiVersion < this.requireApiVersion) goto L47;
        String r1 = r8.getString(R.styleable.OMaterialDrawable_oui_widgetMaterial);     // Catch: Exception -> L48 Throwable -> L52
        int r13 = r8.getInt(R.styleable.OMaterialDrawable_oui_widgetMaterialSrcType, 2);     // Catch: Exception -> L48 Throwable -> L52
        int r14 = r8.getInt(R.styleable.OMaterialDrawable_oui_widgetMaterialDrawMode, 1);     // Catch: Exception -> L48 Throwable -> L52
        String r15 = r1;     // Catch: Exception -> L48 Throwable -> L52
        if (r15 != null) goto L16;
    L19:
        boolean r16 = true;
    L20:
        if (r16 == false) goto L22;
        this.materialSrcType = r13;     // Catch: Exception -> L48 Throwable -> L52
        this.materialDrawMode = r14;     // Catch: Exception -> L48 Throwable -> L52
        goto L47
    L22:
        if ((r17.getConfiguration().uiMode & 48) != 32) goto L25;
        r10 = false;
    L25:
        MaterialConfig[] r6 = MaterialToken.parseSet(r1, r10);     // Catch: Exception -> L48 Throwable -> L52
        if (r6 == null) goto L28;
        setMaterialConfigs(r6, r13, r14, false);     // Catch: Exception -> L48 Throwable -> L52
    L37:
        if (r11 != null) goto L47;
        MaterialConfig[] r2 = this.materialConfigs;     // Catch: Exception -> L48 Throwable -> L52
        if (r2 != null) goto L41;
    L40:
        ColorStateList r7 = null;
    L45:
        r11 = r7;
        goto L47
    L41:
        MaterialConfig r3 = (MaterialConfig) ArraysKt.firstOrNull(r2);     // Catch: Exception -> L48 Throwable -> L52
        if (r3 == null) goto L40;
        r7 = r3.getFallbackBgColor();     // Catch: Exception -> L48 Throwable -> L52
        goto L45
    L28:
        MaterialConfig r21 = MaterialToken.parse(r1, r10);     // Catch: Exception -> L48 Throwable -> L52
        if (r21 != null) goto L34;
        Function1<Boolean, MaterialConfig> r4 = MaterialToken.parse(r1);     // Catch: Exception -> L48 Throwable -> L52
        if (r4 != null) goto L33;
        r21 = null;
        goto L34
    L33:
        r21 = r4.invoke(Boolean.valueOf(r10));     // Catch: Exception -> L48 Throwable -> L52
    L34:
        if (r21 == null) goto L37;
        setMaterialConfig(r21, r13, r14, false);     // Catch: Exception -> L48 Throwable -> L52
        goto L37
    L16:
        if (StringsKt.isBlank(r15) == true) goto L19;
        r16 = false;
    L47:
        r8.recycle();
    L59:
        super.inflate(r17, r18, r19, r20);
        if (r11 != null) goto L62;
        r11 = getColor();
    L62:
        if (r11 != null) goto L64;
        r11 = ColorStateList.valueOf(0);
    L64:
        setSolidColors(r11);
        if (r12 != null) goto L67;
        r12 = ColorStateList.valueOf(0);
    L67:
        this.strokeColors = r12;
        if (r9 < 0) goto L78;
        setStrokeConfigs(r9, r12);
        return;
    L78:
        return;
    L48:
        e = e;
        ColorStateList r22 = r11;
    L57:
        Log.d(TAG, Intrinsics.stringPlus("inflate: ", e));     // Catch: Throwable -> L52
        r8.recycle();
        r11 = r22;
    L50:
        e = e;
        r22 = r11;
    L56:
        r12 = null;
    L54:
        e = e;
        r22 = null;
    L52:
        th = move-exception;
        r8.recycle();
        throw th;
    L5:
        r0 = r20.obtainStyledAttributes(r19, R.styleable.OMaterialDrawable, 0, 0);
        goto L6
    }

    static {
        Companion = new Companion(null);
        ENABLED_STATE_SET = new int[]{android.R.attr.state_enabled};
        DISABLED_STATE_SET = new int[]{-16842910};
    }

    public static /* synthetic */ void setSolidColors$default(OMaterialDrawable r7, int r8, int r9, int r10, int r11, int r12, int r13, int r14, Object r15) {
        if (r15 != null) goto L26;
        if ((r14 & 2) == 0) goto L6;
        int r2 = r8;
    L8:
        if ((r14 & 4) == 0) goto L10;
        int r3 = r8;
    L12:
        if ((r14 & 8) == 0) goto L14;
        int r4 = r3;
    L16:
        if ((r14 & 16) == 0) goto L18;
        int r5 = r2;
    L20:
        if ((r14 & 32) == 0) goto L22;
        int r6 = r8;
    L23:
        r7.setSolidColors(r8, r2, r3, r4, r5, r6);
        return;
    L22:
        r6 = r13;
        goto L23
    L18:
        r5 = r12;
        goto L20
    L14:
        r4 = r11;
        goto L16
    L10:
        r3 = r10;
        goto L12
    L6:
        r2 = r9;
        goto L8
    L26:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setSolidColors");
    }

    public final void setSolidColors(int r17, int r18, int r19, int r20, int r21, int r22) {
        setSolidColors(new ColorStateList(new int[][]{new int[]{android.R.attr.state_pressed, android.R.attr.state_checked}, new int[]{android.R.attr.state_hovered, android.R.attr.state_checked}, new int[]{android.R.attr.state_pressed, android.R.attr.state_selected}, new int[]{android.R.attr.state_hovered, android.R.attr.state_selected}, new int[]{android.R.attr.state_pressed, android.R.attr.state_activated}, new int[]{android.R.attr.state_hovered, android.R.attr.state_activated}, new int[]{android.R.attr.state_pressed}, new int[]{android.R.attr.state_hovered}, new int[]{android.R.attr.state_checked}, new int[]{android.R.attr.state_selected}, new int[]{-16842910}, new int[]{android.R.attr.state_enabled}}, new int[]{r20, r20, r19, r19, r19, r19, r18, r21, r19, r20, r22, r17}));
    }

    public final void setSolidColors(ColorStateList r3) {
        this.solidColors = r3;
        if (r3 == null) goto L11;
        int r4 = r3.getColorForState(getState(), r3.getDefaultColor());
        this.targetSolidColor = r4;
        this.animatedSolidColor = r4;
        ValueAnimator r5 = this.colorAnimator;
        if (r5 == null) goto L9;
        r5.cancel();
    L9:
        setColor(this.targetSolidColor);
        return;
    }

    public static /* synthetic */ void setStrokeConfigs$default(OMaterialDrawable r9, int r10, int r11, int r12, int r13, int r14, int r15, int r16, int r17, Object r18) {
        if (r18 != null) goto L26;
        if ((r17 & 4) == 0) goto L6;
        int r4 = r11;
    L8:
        if ((r17 & 8) == 0) goto L10;
        int r5 = r11;
    L12:
        if ((r17 & 16) == 0) goto L14;
        int r6 = r5;
    L16:
        if ((r17 & 32) == 0) goto L18;
        int r7 = r4;
    L20:
        if ((r17 & 64) == 0) goto L22;
        int r8 = r11;
    L23:
        r9.setStrokeConfigs(r10, r11, r4, r5, r6, r7, r8);
        return;
    L22:
        r8 = r16;
        goto L23
    L18:
        r7 = r15;
        goto L20
    L14:
        r6 = r14;
        goto L16
    L10:
        r5 = r13;
        goto L12
    L6:
        r4 = r12;
        goto L8
    L26:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setStrokeConfigs");
    }

    public final void setStrokeConfigs(int r19, int r20, int r21, int r22, int r23, int r24, int r25) {
        this.strokeWidth = r19;
        ColorStateList r2 = new ColorStateList(new int[][]{new int[]{android.R.attr.state_pressed, android.R.attr.state_checked}, new int[]{android.R.attr.state_hovered, android.R.attr.state_checked}, new int[]{android.R.attr.state_pressed, android.R.attr.state_selected}, new int[]{android.R.attr.state_hovered, android.R.attr.state_selected}, new int[]{android.R.attr.state_pressed, android.R.attr.state_activated}, new int[]{android.R.attr.state_hovered, android.R.attr.state_activated}, new int[]{android.R.attr.state_pressed}, new int[]{android.R.attr.state_hovered}, new int[]{android.R.attr.state_checked}, new int[]{android.R.attr.state_selected}, new int[]{-16842910}, new int[]{android.R.attr.state_enabled}}, new int[]{r23, r23, r22, r22, r22, r22, r21, r24, r22, r23, r25, r20});
        this.strokeColors = r2;
        setStrokeConfigs(r19, r2);
    }

    public final void setStrokeConfigs(int r1, ColorStateList r2) {
        if (r2 == null) goto L10;
        int r3 = r2.getDefaultColor();
        this.targetStrokeColor = r3;
        this.animatedStrokeColor = r3;
        ValueAnimator r4 = this.strokeAnimator;
        if (r4 == null) goto L8;
        r4.cancel();
    L8:
        setStroke(r1, this.targetStrokeColor);
        return;
    }

    public final void setEnableShadow(boolean r1) {
        this.enableShadow = r1;
        invalidateSelf();
    }

    public final void setShadowConfigs(ShadowConfig[] r1) {
        this.shadowConfigs = r1;
        invalidateSelf();
    }

    private final void drawMultiLayerShadow(Canvas r17) {
        ShadowConfig[] r2 = this.shadowConfigs;
        int r4 = 0;
        if (r2 != null) goto L23;
        MaterialConfig[] r3 = this.materialConfigs;
        if (r3 != null) goto L7;
    L6:
        r2 = null;
    L20:
        if (r2 != null) goto L23;
        return;
    L7:
        int r6 = r3.length;
        int r7 = 0;
    L8:
        if (r7 >= r6) goto L16;
        MaterialConfig r8 = r3[r7];
        if (r8.getShadow() == null) goto L12;
        boolean r9 = true;
    L13:
        if (r9 == true) goto L17;
        r7 = r7 + 1;
    L17:
        if (r8 == null) goto L6;
        r2 = r8.getShadow();
        goto L20
    L12:
        r9 = false;
        goto L13
    L16:
        r8 = null;
    L23:
        if (r2.length != 0) goto L25;
        boolean r10 = true;
    L26:
        if (r10 == false) goto L28;
        return;
    L28:
        Rect r11 = getBounds();
        Intrinsics.checkNotNullExpressionValue(r11, "bounds");
        if (r11.isEmpty() == false) goto L31;
        return;
    L31:
        this.tmpRectF.set(r11);
        int r12 = getShape();
        float[] r13 = getCornerRadii();
        float r14 = getCornerRadius();
        this.shadowClipPath.reset();
        if (r12 != 1) goto L34;
        this.shadowClipPath.addOval(this.tmpRectF, Path.Direction.CW);
    L40:
        int r15 = r2.length;
    L41:
        if (r4 >= r15) goto L59;
        ShadowConfig r16 = r2[r4];
        r4 = r4 + 1;
        if (isShadowValid(r16) == false) goto L41;
        int r18 = r17.save();
        clipOutShadowPath(r17, this.shadowClipPath);
        this.tmpShadowRectF.set(this.tmpRectF);
        float r19 = r17.getDensity() / 160.0f;
        this.tmpShadowRectF.offset(OUnitExtensionKt.dp2pxFloat(r16.getX(), r19), OUnitExtensionKt.dp2pxFloat(r16.getY(), r19));
        this.tmpShadowRectF.inset(-r16.getSpread(), -r16.getSpread());
        this.shadowPaint.setColor(r16.getColor());
        Paint r5 = this.shadowPaint;
        if (r16.getBlurRadius() <= 0.0f) goto L48;
        BlurMaskFilter r110 = new BlurMaskFilter(r16.getBlurRadius(), BlurMaskFilter.Blur.NORMAL);
    L49:
        r5.setMaskFilter(r110);
        if (r12 != 1) goto L52;
        r17.drawOval(this.tmpShadowRectF, this.shadowPaint);
    L58:
        r17.restoreToCount(r18);
        goto L41
    L52:
        if (r13 == null) goto L55;
        this.shadowDrawPath.reset();
        this.shadowDrawPath.addRoundRect(this.tmpShadowRectF, r13, Path.Direction.CW);
        r17.drawPath(this.shadowDrawPath, this.shadowPaint);
        goto L58
    L55:
        if (r14 <= 0.0f) goto L57;
        r17.drawRoundRect(this.tmpShadowRectF, r14, r14, this.shadowPaint);
        goto L58
    L57:
        r17.drawRect(this.tmpShadowRectF, this.shadowPaint);
        goto L58
    L48:
        MaskFilter r111 = (MaskFilter) null;
        r110 = null;
        goto L49
    L59:
        return;
    L34:
        if (r13 == null) goto L37;
        this.shadowClipPath.addRoundRect(this.tmpRectF, r13, Path.Direction.CW);
        goto L40
    L37:
        if (r14 <= 0.0f) goto L39;
        this.shadowClipPath.addRoundRect(this.tmpRectF, r14, r14, Path.Direction.CW);
        goto L40
    L39:
        this.shadowClipPath.addRect(this.tmpRectF, Path.Direction.CW);
        goto L40
    L25:
        r10 = false;
        goto L26
    }

    private final boolean isShadowValid(ShadowConfig r4) {
        if (r4.getColor() != 0) goto L6;
        return false;
    L6:
        if (r4.getX() != 0.0f) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L26;
        if (r4.getY() != 0.0f) goto L13;
        boolean r5 = true;
    L14:
        if (r5 == false) goto L26;
        if (r4.getBlurRadius() != 0.0f) goto L18;
        boolean r6 = true;
    L19:
        if (r6 == false) goto L26;
        if (r4.getSpread() != 0.0f) goto L23;
        boolean r7 = true;
    L24:
        if (r7 == false) goto L26;
        return false;
    L23:
        r7 = false;
        goto L24
    L18:
        r6 = false;
        goto L19
    L13:
        r5 = false;
    L26:
        return true;
    L8:
        r3 = false;
        goto L9
    }

    private final void clipOutShadowPath(Canvas r1, Path r2) {
        r1.clipOutPath(r2);
    }

    public final void setEnableExtraStateChange(boolean r3) {
        if (this.enableExtraStateChange != r3) goto L5;
        return;
    L5:
        this.enableExtraStateChange = r3;
        if (Companion.getDEBUGGABLE() == false) goto L8;
        Log.d(TAG, "[" + System.identityHashCode(this) + "][setRespondToOtherStateChange] " + Intrinsics.stringPlus("enabled=", Boolean.valueOf(r3)));
    L8:
        Drawable.Callback r4 = getCallback();
        if ((r4 instanceof View) == false) goto L11;
        View r5 = (View) r4;
    L12:
        if (r5 == null) goto L14;
        int[] r6 = r5.getDrawableState();
        Intrinsics.checkNotNullExpressionValue(r6, "view.drawableState");
        onStateChange(r6);
        return;
    L14:
        int[] r7 = getState();
        Intrinsics.checkNotNullExpressionValue(r7, "state");
        onStateChange(r7);
        return;
    L11:
        r5 = null;
        goto L12
    }

    public static /* synthetic */ void setMaterialConfig$default(OMaterialDrawable r1, MaterialConfig r2, int r3, int r4, boolean r5, int r6, Object r7) {
        if (r7 != null) goto L15;
        if ((r6 & 2) == 0) goto L7;
        r3 = 2;
    L7:
        if ((r6 & 4) == 0) goto L10;
        r4 = 1;
    L10:
        if ((r6 & 8) == 0) goto L12;
        r5 = true;
    L12:
        r1.setMaterialConfig(r2, r3, r4, r5);
        return;
    L15:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setMaterialConfig");
    }

    public final void setMaterialConfig(MaterialConfig r3, int r4, int r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r3, "materialConfig");
        setMaterialConfigs(new MaterialConfig[]{r3}, r4, r5, r6);
    }

    public static /* synthetic */ void setMaterialConfigs$default(OMaterialDrawable r1, MaterialConfig[] r2, int r3, int r4, boolean r5, int r6, Object r7) {
        if (r7 != null) goto L15;
        if ((r6 & 2) == 0) goto L7;
        r3 = 2;
    L7:
        if ((r6 & 4) == 0) goto L10;
        r4 = 1;
    L10:
        if ((r6 & 8) == 0) goto L12;
        r5 = true;
    L12:
        r1.setMaterialConfigs(r2, r3, r4, r5);
        return;
    L15:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setMaterialConfigs");
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect r2) {
        Intrinsics.checkNotNullParameter(r2, "r");
        super.onBoundsChange(r2);
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        if (this.enableShadow == false) goto L5;
        drawMultiLayerShadow(r2);
    L5:
        super.draw(r2);
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        if (Companion.getDEBUGGABLE() == false) goto L5;
        Log.d(TAG, "[" + System.identityHashCode(this) + "][jumpToCurrentState] jump requested by framework");
    L5:
        endAnimation();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] r9) {
        Intrinsics.checkNotNullParameter(r9, "stateSet");
        int[] r0 = filterStateSet(r9);
        Companion r1 = Companion;
        if (r1.getDEBUGGABLE() == false) goto L5;
        Log.d(TAG, "[" + System.identityHashCode(this) + "][setState] " + ("rawState=" + Companion.access$formatStateSet(r1, r9) + ", filteredState=" + Companion.access$formatStateSet(r1, r0) + ", respondToOtherStateChange=" + this.enableExtraStateChange));
    L5:
        Drawable.Callback r2 = getCallback();
        if ((r2 instanceof View) == false) goto L8;
        View r3 = (View) r2;
    L9:
        if (r3 == null) goto L52;
        int r4 = 0;
        if (OMaterialHelper.isMaterialEffectEnabled(r3.getContext()) == true) goto L13;
    L34:
        OMaterialHelper.setEffectSrcAndDraw(r3, 0, this.materialDrawMode);
        ColorStateList r5 = this.solidColors;
        if (r5 != null) goto L37;
        int r6 = 0;
    L38:
        ColorStateList r7 = this.solidColors;
        if (r7 != null) goto L41;
        int r8 = 0;
    L42:
        setColor(r8);
        ColorStateList r10 = this.strokeColors;
        if (r10 != null) goto L45;
        int r11 = 0;
    L46:
        int r12 = OUnitExtensionKt.vdp(r3, this.strokeWidth);
        ColorStateList r13 = this.strokeColors;
        if (r13 == null) goto L50;
        r4 = r13.getColorForState(r0, r11);
    L50:
        setStroke(r12, r4);
        goto L52
    L45:
        r11 = r10.getDefaultColor();
        goto L46
    L41:
        r8 = r7.getColorForState(r0, r6);
        goto L42
    L37:
        r6 = r5.getDefaultColor();
        goto L38
    L13:
        if (this.envMaterialApiVersion < this.requireApiVersion) goto L34;
        Boolean[] r14 = this.isCallbackInitArray;
        int r15 = r14.length;
        int r16 = 0;
    L15:
        if (r16 >= r15) goto L20;
        if (r14[r16].booleanValue() == false) goto L18;
        r16 = r16 + 1;
        goto L15
    L18:
        boolean r17 = false;
    L21:
        if (r17 == true) goto L52;
        MaterialConfig[] r18 = this.materialConfigs;
        if (r18 == null) goto L52;
        int r19 = r18.length;
    L26:
        if (r4 >= r19) goto L52;
        int r20 = r4 + 1;
        MaterialParams r21 = OMaterialHelper.getMaterialParams(r3, r20);
        if (r21 != null) goto L30;
        Object r22 = null;
    L31:
        if (r22 == null) goto L33;
        setMaterialToEffectObjectIfNotInit(r22, r4, r18[r4]);
    L33:
        r4 = r20;
        goto L26
    L30:
        r22 = r21.getProxy();
        goto L31
    L20:
        r17 = true;
    L52:
        return super.setState(r9);
    L8:
        r3 = null;
        goto L9
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] r19) {
        Intrinsics.checkNotNullParameter(r19, "stateSet");
        int[] r8 = filterStateSet(r19);
        Companion r0 = Companion;
        if (r0.getDEBUGGABLE() == false) goto L12;
        StringBuilder r1 = new StringBuilder("[").append(System.identityHashCode(this)).append("][onStateChange] ");
        StringBuilder r2 = new StringBuilder("rawState=").append(Companion.access$formatStateSet(r0, r19)).append(", filteredState=").append(Companion.access$formatStateSet(r0, r8)).append(", last=").append(Companion.access$formatNullableStateSet(r0, this.lastStateSet)).append(", callback=");
        Drawable.Callback r3 = getCallback();
        if (r3 != null) goto L7;
    L6:
        String r4 = null;
    L11:
        Log.d(TAG, r1.append(r2.append(r4).append(", respondToOtherStateChange=").append(this.enableExtraStateChange).toString()).toString());
        goto L12
    L7:
        Class<?> r5 = r3.getClass();
        if (r5 == null) goto L6;
        r4 = r5.getSimpleName();
    L12:
        Drawable.Callback r6 = getCallback();
        if ((r6 instanceof View) == false) goto L15;
        View r10 = (View) r6;
    L17:
        if (r10 != null) goto L19;
    L49:
        boolean r7 = processSolidAndStrokeOnStateChange(r8);
        if (r7 == false) goto L53;
        invalidateSelf();
    L53:
        if (super.onStateChange(r19) == true) goto L64;
        if (r7 == false) goto L57;
        return true;
    L57:
        return false;
    L64:
        return true;
    L19:
        if (OMaterialHelper.isMaterialEffectEnabled(r10.getContext()) == true) goto L21;
    L48:
        OMaterialHelper.setEffectSrcAndDraw(r10, 0, this.materialDrawMode);
        goto L49
    L21:
        if (this.envMaterialApiVersion < this.requireApiVersion) goto L48;
        MaterialConfig[] r13 = this.materialConfigs;
        if (r13 == null) goto L49;
        int r14 = r13.length;
        int r9 = 0;
        boolean r15 = false;
    L26:
        if (r9 >= r14) goto L40;
        int r11 = r9 + 1;
        MaterialParams r12 = OMaterialHelper.getMaterialParams(r10, r11);
        if (r12 != null) goto L30;
        Object r16 = null;
    L31:
        if (r16 == null) goto L38;
        int r17 = r11;
        if (processMaterialOnStateChange(r10, r16, r9, r8, r13[r9]) == true) goto L37;
        if (r15 == true) goto L37;
        r15 = false;
    L39:
        r9 = r17;
    L37:
        r15 = true;
        goto L39
    L38:
        r17 = r11;
        goto L39
    L30:
        r16 = r12.getProxy();
        goto L31
    L40:
        if (r15 == false) goto L42;
        invalidateSelf();
    L42:
        this.lastStateSet = (int[]) r19.clone();
        if (super.onStateChange(r19) == true) goto L62;
        if (r15 == false) goto L47;
        return true;
    L47:
        return false;
    L62:
        return true;
    L15:
        r10 = null;
        goto L17
    }

    private final void setMaterialToEffectObjectIfNotInit(Object r3, int r4, MaterialConfig r5) {
        if (this.isCallbackInitArray[r4].booleanValue() == true) goto L20;
        OMaterialHelper.setEffectSrcAndDraw(r3, this.materialSrcType, this.materialDrawMode);
        Float r0 = r5.getBlurRadius();
        if (r0 == null) goto L8;
        OMaterialHelper.setNormalBlurEffect(r3, r0.floatValue());
    L8:
        FluidConfig r1 = r5.getFluid();
        if (r1 == null) goto L12;
        OMaterialHelper.setFluidEffect(r3, true, r1.getGlassParams());
    L12:
        ShadowConfig[] r6 = r5.getShadow();
        if (r6 == null) goto L18;
        ShadowConfig r7 = (ShadowConfig) ArraysKt.firstOrNull(r6);
        if (r7 == null) goto L18;
        Paint r8 = this.shadowPaint;
        int[] r9 = ShadowConfig.Companion.getShadowBlendIntArray(r7);
        OMaterialHelper.setBlendEffectToShadow(r8, Arrays.copyOf(r9, r9.length));
    L18:
        this.isCallbackInitArray[r4] = true;
        return;
    }

    private final boolean processMaterialOnStateChange(View r21, Object r22, int r23, int[] r24, MaterialConfig r25) {
        setColor(0);
        this.targetSolidColor = 0;
        int[] r11 = this.lastStateSet;
        if (this.isCallbackInitArray[r23].booleanValue() == true) goto L18;
        OMaterialHelper.setEffectSrcAndDraw(r22, this.materialSrcType, this.materialDrawMode);
        Float r0 = r25.getBlurRadius();
        if (r0 == null) goto L8;
        OMaterialHelper.setNormalBlurEffect(r22, r0.floatValue());
    L8:
        FluidConfig r1 = r25.getFluid();
        if (r1 == null) goto L12;
        OMaterialHelper.setFluidEffect(r22, true, r1.getGlassParams());
    L12:
        ShadowConfig[] r2 = r25.getShadow();
        if (r2 == null) goto L18;
        ShadowConfig r3 = (ShadowConfig) ArraysKt.firstOrNull(r2);
        if (r3 == null) goto L18;
        Paint r4 = this.shadowPaint;
        int[] r5 = ShadowConfig.Companion.getShadowBlendIntArray(r3);
        OMaterialHelper.setBlendEffectToShadow(r4, Arrays.copyOf(r5, r5.length));
    L18:
        BlendConfigStateList r6 = r25.getBlendConfigStateList();
        StrokeConfig r14 = null;
        if (r6 != null) goto L21;
        BlendConfig[] r7 = null;
    L22:
        if (r7 != null) goto L24;
        r7 = r25.getBlendConfig();
    L24:
        BlendConfig[] r8 = r7;
        Companion r15 = Companion;
        if (r15.getDEBUGGABLE() == false) goto L27;
        Log.d(TAG, "[" + System.identityHashCode(this) + "][processMaterialOnStateChange] " + ("index=" + r23 + ", view=" + r21.getClass().getSimpleName() + AccessibilityUtils.ENABLED_ACCESSIBILITY_SERVICES_SEPARATOR + r21.hashCode() + ", state=" + Companion.access$formatStateSet(r15, r24) + ", fromState=" + Companion.access$formatNullableStateSet(r15, r11) + ", enableTransition=" + getEnableStateChangeTransition() + ", blendTarget=" + Companion.access$describeBlendConfigs(r15, r8) + ", currentDrawBlend=" + Companion.access$describeBlendConfigs(r15, this.drawBlendConfigsArray[r23])));
    L27:
        if (r8 == null) goto L40;
        BlendConfig[] r12 = this.drawBlendConfigsArray[r23];
        if (this.enableStateChangeTransition == false) goto L34;
        if (r6 == null) goto L34;
        if (r11 == null) goto L34;
        if (r12 == null) goto L34;
        boolean r13 = true;
    L36:
        if (updateBlendConfigs(r22, r23, r13, r12, r8) == true) goto L38;
        boolean r9 = false;
    L39:
        boolean r16 = r9;
    L41:
        BlendConfigStateList r10 = r25.getOverlayBlendConfigStateList();
        if (r10 != null) goto L44;
        BlendConfig[] r17 = null;
    L46:
        if (r15.getDEBUGGABLE() == false) goto L48;
        String r18 = "[";
        String r19 = "][processMaterialOnStateChange] ";
        Log.d(TAG, r18 + System.identityHashCode(this) + r19 + (r4 + r23 + ", overlayTarget=" + Companion.access$describeBlendConfigs(r15, r17) + ", currentDrawOverlay=" + Companion.access$describeBlendConfigs(r15, this.drawOverlayBlendConfigsArray[r23])));
    L49:
        if (r17 == null) goto L62;
        BlendConfig[] r110 = this.drawOverlayBlendConfigsArray[r23];
        if (this.enableStateChangeTransition == false) goto L55;
        if (r11 == null) goto L55;
        if (r110 == null) goto L55;
        boolean r111 = true;
    L56:
        String r112 = r19;
        String r113 = r18;
        if (updateOverlayBlendConfigs(r22, r23, r111, r110, r17) == true) goto L61;
        if (r16 == true) goto L61;
        r16 = false;
    L63:
        StrokeStateList r20 = r25.getStrokeStateList();
        if (r20 == null) goto L67;
        r14 = StrokeStateList.getConfigForState$default(r20, r24, null, 2, null);
    L67:
        if (r14 != null) goto L70;
        r14 = r25.getStroke();
    L70:
        if (r15.getDEBUGGABLE() == false) goto L72;
        Log.d(TAG, r113 + System.identityHashCode(this) + r112 + ("index=" + r23 + ", strokeTarget=" + Companion.access$describeStrokeConfig(r15, r14) + ", currentDrawStroke=" + Companion.access$describeStrokeConfig(r15, this.drawStrokeConfigArray[r23])));
    L72:
        if (r14 == null) goto L87;
        StrokeConfig r26 = this.drawStrokeConfigArray[r23];
        if (this.enableStateChangeTransition == false) goto L79;
        if (r20 == null) goto L79;
        if (r11 == null) goto L79;
        if (r26 == null) goto L79;
        boolean r27 = true;
    L81:
        if (updateStrokeConfig(r21, r22, r23, r27, r26, r14) == true) goto L85;
        if (r16 == true) goto L85;
        boolean r114 = false;
    L86:
        r16 = r114;
    L85:
        r114 = true;
    L79:
        r27 = false;
    L87:
        this.isCallbackInitArray[r23] = true;
        return r16;
    L61:
        r16 = true;
    L55:
        r111 = false;
        goto L56
    L62:
        r112 = r19;
        r113 = r18;
        goto L63
    L48:
        r18 = r2;
        r19 = r3;
        goto L49
    L44:
        r17 = BlendConfigStateList.getConfigForState$default(r10, r24, null, 2, null);
        goto L46
    L38:
        r9 = true;
    L34:
        r13 = false;
        goto L36
    L40:
        r16 = false;
        goto L41
    L21:
        r7 = BlendConfigStateList.getConfigForState$default(r6, r24, null, 2, null);
        goto L22
    }

    /* JADX INFO: renamed from: updateBlendConfigs$lambda-35$lambda-34, reason: not valid java name */
    private static final void m1243updateBlendConfigs$lambda35$lambda34(BlendConfig[] r2, BlendConfig[] r3, OMaterialDrawable r4, int r5, Object r6, ValueAnimator r7) {
        Intrinsics.checkNotNullParameter(r4, "this$0");
        Intrinsics.checkNotNullParameter(r6, "$effectParams");
        Intrinsics.checkNotNullParameter(r7, "animator");
        Object r8 = r7.getAnimatedValue();
        if (r8 == null) goto L10;
        float r9 = ((Float) r8).floatValue();
        BlendConfigStateList.Companion r0 = BlendConfigStateList.Companion;
        Intrinsics.checkNotNull(r2);
        BlendConfig[] r10 = r0.getConfigForTransition(r2, r3, r9);
        r4.drawBlendConfigsArray[r5] = r10;
        Companion r11 = Companion;
        if (r11.getDEBUGGABLE() == false) goto L7;
        Log.d(TAG, "[" + System.identityHashCode(r4) + "][blendAnimator] " + ("index=" + r5 + " update, progress=" + Companion.access$formatProgress(r11, r9) + ", blended=" + Companion.access$describeBlendConfigs(r11, r10)));
    L7:
        int[] r12 = OMaterialHelper.transformToBlendIntArray(r10);
        OMaterialHelper.setBlendEffect(r6, Arrays.copyOf(r12, r12.length));
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }

    /* JADX INFO: renamed from: updateOverlayBlendConfigs$lambda-43$lambda-42, reason: not valid java name */
    private static final void m1244updateOverlayBlendConfigs$lambda43$lambda42(BlendConfig[] r5, BlendConfig[] r6, OMaterialDrawable r7, Object r8, int r9, ValueAnimator r10) {
        Intrinsics.checkNotNullParameter(r7, "this$0");
        Intrinsics.checkNotNullParameter(r8, "$effectParams");
        Intrinsics.checkNotNullParameter(r10, "animator");
        Object r11 = r10.getAnimatedValue();
        if (r11 == null) goto L10;
        float r12 = ((Float) r11).floatValue();
        BlendConfigStateList.Companion r0 = BlendConfigStateList.Companion;
        Intrinsics.checkNotNull(r5);
        BlendConfig[] r13 = r0.getConfigForTransition(r5, r6, r12);
        int r1 = r13[0].getColor();
        int r14 = r13[0].getBlendMode();
        Companion r2 = Companion;
        if (r2.getDEBUGGABLE() == false) goto L7;
        Log.d(TAG, "[" + System.identityHashCode(r7) + "][overlayAnimator] " + ("index=" + r9 + " update, progress=" + Companion.access$formatProgress(r2, r12) + ", blended=" + Companion.access$describeBlendConfigs(r2, r13)));
    L7:
        OMaterialHelper.setOverlayBlendEffect(r8, r1, 1.0f, r14);
        r7.drawOverlayBlendConfigsArray[r9] = r13;
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }

    /* JADX INFO: renamed from: updateStrokeConfig$lambda-50$lambda-49, reason: not valid java name */
    private static final void m1247updateStrokeConfig$lambda50$lambda49(StrokeConfig r1, StrokeConfig r2, OMaterialDrawable r3, int r4, View r5, ValueAnimator r6) {
        Intrinsics.checkNotNullParameter(r2, "$targetStrokeConfig");
        Intrinsics.checkNotNullParameter(r3, "this$0");
        Intrinsics.checkNotNullParameter(r5, "$view");
        Intrinsics.checkNotNullParameter(r6, "animator");
        Object r7 = r6.getAnimatedValue();
        if (r7 == null) goto L10;
        float r8 = ((Float) r7).floatValue();
        StrokeStateList.Companion r0 = StrokeStateList.Companion;
        Intrinsics.checkNotNull(r1);
        StrokeConfig r9 = r0.getConfigForTransition(r1, r2, r8);
        if (r9 == null) goto L11;
        r3.drawStrokeConfigArray[r4] = r9;
        r3.setStroke(OUnitExtensionKt.vdp(r5, r9.getWidth()), r9.getColor());
        return;
    L11:
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }

    private final boolean processSolidAndStrokeOnStateChange(int[] r12) {
        ColorStateList r0 = this.solidColors;
        boolean r1 = false;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        ColorStateList r3 = this.solidColors;
        if (r3 != null) goto L9;
        int r4 = 0;
    L10:
        Companion r5 = Companion;
        if (r5.getDEBUGGABLE() == false) goto L14;
        Log.d(TAG, "[" + System.identityHashCode(this) + "][processSolidAndStrokeOnStateChange] " + ("state=" + Companion.access$formatStateSet(r5, r12) + ", solidCurrent=" + Companion.access$formatColor(r5, this.targetSolidColor) + ", solidTarget=" + Companion.access$formatColor(r5, r4)));
    L14:
        if (r4 == this.targetSolidColor) goto L19;
        if (r4 != r2) goto L17;
        boolean r6 = true;
    L18:
        updateSolidColor(r4, r6);
        this.targetSolidColor = r4;
        boolean r7 = true;
    L20:
        ColorStateList r8 = this.strokeColors;
        if (r8 != null) goto L23;
        int r9 = 0;
    L24:
        ColorStateList r10 = this.strokeColors;
        if (r10 != null) goto L27;
        int r11 = 0;
    L29:
        if (r5.getDEBUGGABLE() == false) goto L32;
        Log.d(TAG, "[" + System.identityHashCode(this) + "][processSolidAndStrokeOnStateChange] " + ("state=" + Companion.access$formatStateSet(r5, r12) + ", strokeCurrent=" + Companion.access$formatColor(r5, this.targetStrokeColor) + ", strokeTarget=" + Companion.access$formatColor(r5, r11)));
    L32:
        if (r11 == this.targetStrokeColor) goto L37;
        if (r11 != r9) goto L35;
        r1 = true;
    L35:
        updateStrokeColor(r11, r1);
        this.targetStrokeColor = r11;
        return true;
    L37:
        return r7;
    L27:
        r11 = r10.getColorForState(r12, r9);
        goto L29
    L23:
        r9 = r8.getDefaultColor();
        goto L24
    L17:
        r6 = false;
        goto L18
    L19:
        r7 = false;
        goto L20
    L9:
        r4 = r3.getColorForState(r12, r2);
        goto L10
    L5:
        r2 = r0.getDefaultColor();
        goto L6
    }

    /* JADX INFO: renamed from: updateSolidColor$lambda-58$lambda-57, reason: not valid java name */
    private static final void m1245updateSolidColor$lambda58$lambda57(OMaterialDrawable r2, ValueAnimator r3) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Intrinsics.checkNotNullParameter(r3, "animator");
        Object r4 = r3.getAnimatedValue();
        if (r4 == null) goto L10;
        r2.animatedSolidColor = ((Integer) r4).intValue();
        Companion r5 = Companion;
        if (r5.getDEBUGGABLE() == false) goto L7;
        Log.d(TAG, "[" + System.identityHashCode(r2) + "][solidColorAnimator] " + Intrinsics.stringPlus("update, color=", Companion.access$formatColor(r5, r2.animatedSolidColor)));
    L7:
        r2.setColor(r2.animatedSolidColor);
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    /* JADX INFO: renamed from: updateStrokeColor$lambda-62$lambda-61, reason: not valid java name */
    private static final void m1246updateStrokeColor$lambda62$lambda61(OMaterialDrawable r2, ValueAnimator r3) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Intrinsics.checkNotNullParameter(r3, "animator");
        Object r4 = r3.getAnimatedValue();
        if (r4 == null) goto L10;
        r2.animatedStrokeColor = ((Integer) r4).intValue();
        Companion r5 = Companion;
        if (r5.getDEBUGGABLE() == false) goto L7;
        Log.d(TAG, "[" + System.identityHashCode(r2) + "][strokeColorAnimator] " + Intrinsics.stringPlus("update, color=", Companion.access$formatColor(r5, r2.animatedStrokeColor)));
    L7:
        r2.setStroke(r2.strokeWidth, r2.animatedStrokeColor);
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    private final void debugLog(String r3, Function0<String> r4) {
        if (Companion.getDEBUGGABLE() == false) goto L6;
        Log.d(TAG, "[" + System.identityHashCode(this) + "][" + r3 + "] " + r4.invoke());
        return;
    }

    private final int[] filterStateSet(int[] r2) {
        if (this.enableExtraStateChange == false) goto L6;
        return r2;
    L6:
        if ((!containsState(r2, -16842910)) == false) goto L9;
        return ENABLED_STATE_SET;
    L9:
        return DISABLED_STATE_SET;
    }

    private final boolean containsState(int[] r4, int r5) {
        int r3 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r3) goto L8;
        int r2 = r4[r1];
        r1 = r1 + 1;
        if (r2 != r5) goto L3;
        return true;
    L8:
        return false;
    }

    public final void endAnimation() {
        if (Companion.getDEBUGGABLE() == false) goto L5;
        Log.d(TAG, "[" + System.identityHashCode(this) + "][endAnimation] force end all animators");
    L5:
        ValueAnimator r0 = this.colorAnimator;
        if (r0 == null) goto L9;
        r0.end();
    L9:
        ValueAnimator r1 = this.strokeAnimator;
        if (r1 == null) goto L13;
        r1.end();
    L13:
        ValueAnimator[] r2 = this.blendAnimatorArray;
        int r3 = r2.length;
        int r4 = 0;
        int r5 = 0;
    L14:
        if (r5 >= r3) goto L20;
        ValueAnimator r6 = r2[r5];
        if (r6 == null) goto L19;
        r6.end();
    L19:
        r5 = r5 + 1;
        goto L14
    L20:
        ValueAnimator[] r7 = this.overlayBlendAnimatorArray;
        int r8 = r7.length;
    L21:
        if (r4 >= r8) goto L27;
        ValueAnimator r9 = r7[r4];
        if (r9 == null) goto L26;
        r9.end();
    L26:
        r4 = r4 + 1;
        goto L21
    }

    public final void setMaterialConfigs(MaterialConfig[] r6, int r7, int r8, boolean r9) {
        int r1 = 0;
        View r2 = null;
        if (Companion.getDEBUGGABLE() == false) goto L16;
        StringBuilder r0 = new StringBuilder("[").append(System.identityHashCode(this)).append("][setMaterialConfigs] ");
        StringBuilder r3 = new StringBuilder("count=");
        if (r6 != null) goto L7;
        int r4 = 0;
    L8:
        StringBuilder r5 = r3.append(r4).append(", srcType=").append(r7).append(", drawMode=").append(r8).append(", applyImmediately=").append(r9).append(", callback=");
        Drawable.Callback r10 = getCallback();
        if (r10 != null) goto L11;
    L10:
        String r11 = null;
    L15:
        Log.d(TAG, r0.append(r5.append(r11).toString()).toString());
        goto L16
    L11:
        Class<?> r12 = r10.getClass();
        if (r12 == null) goto L10;
        r11 = r12.getSimpleName();
        goto L15
    L7:
        r4 = r6.length;
    L16:
        this.materialConfigs = r6;
        this.materialSrcType = r7;
        this.materialDrawMode = r8;
        this.currentBlendConfigsArray = new BlendConfig[2][];
        this.drawBlendConfigsArray = new BlendConfig[2][];
        this.currentOverlayBlendConfigsArray = new BlendConfig[2][];
        this.drawOverlayBlendConfigsArray = new BlendConfig[2][];
        this.currentStrokeConfigArray = new StrokeConfig[2];
        this.drawStrokeConfigArray = new StrokeConfig[2];
        this.lastStateSet = null;
        ValueAnimator[] r13 = this.blendAnimatorArray;
        int r14 = r13.length;
        int r15 = 0;
    L17:
        if (r15 >= r14) goto L23;
        ValueAnimator r16 = r13[r15];
        if (r16 == null) goto L22;
        r16.cancel();
    L22:
        r15 = r15 + 1;
        goto L17
    L23:
        ValueAnimator[] r17 = this.overlayBlendAnimatorArray;
        int r18 = r17.length;
    L24:
        if (r1 >= r18) goto L30;
        ValueAnimator r19 = r17[r1];
        if (r19 == null) goto L29;
        r19.cancel();
    L29:
        r1 = r1 + 1;
        goto L24
    L30:
        if (r6 == null) goto L39;
        MaterialConfig r20 = (MaterialConfig) ArraysKt.firstOrNull(r6);
        if (r20 == null) goto L39;
        ColorStateList r21 = r20.getFallbackBgColor();
        if (r21 == null) goto L39;
        setSolidColors(r21);
    L39:
        Drawable.Callback r22 = getCallback();
        if ((r22 instanceof View) == false) goto L42;
        r2 = (View) r22;
    L42:
        if (r9 == false) goto L45;
        if (r2 == null) goto L45;
        int[] r23 = r2.getDrawableState();
        Intrinsics.checkNotNullExpressionValue(r23, "view.drawableState");
        onStateChange(r23);
    L45:
        invalidateSelf();
    }

    private final boolean updateBlendConfigs(final Object r16, final int r17, boolean r18, final BlendConfig[] r19, final BlendConfig[] r20) {
        Companion r2 = Companion;
        if (r2.getDEBUGGABLE() == false) goto L6;
        Log.d(TAG, "[" + System.identityHashCode(this) + "][updateBlendConfigs] " + ("index=" + r17 + ", enableAnimate=" + r18 + ", from=" + Companion.access$describeBlendConfigs(r2, r19) + ", to=" + Companion.access$describeBlendConfigs(r2, r20)));
    L6:
        if (r19 == null) goto L15;
        if (Arrays.equals(r19, r20) == false) goto L15;
        if (r2.getDEBUGGABLE() == false) goto L13;
        Log.d(TAG, "[" + System.identityHashCode(this) + "][updateBlendConfigs] " + ("index=" + r17 + " skip because from/to are equal"));
    L13:
        return false;
    L15:
        if (this.blendAnimatorArray[r17] != null) goto L17;
    L19:
        ValueAnimator r12 = this.blendAnimatorArray[r17];
        if (r12 == null) goto L24;
        r12.cancel();
    L24:
        if (r20 == null) goto L26;
        if (r18 == false) goto L33;
        ValueAnimator[] r9 = this.blendAnimatorArray;
        ValueAnimator r10 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r10.setDuration(getAnimDuration());
        r10.setInterpolator(getAnimInterpolator());
        r10.addListener(new OMaterialDrawable$updateBlendConfigs$4$1(this, r17, r19, r20));
        r10.addUpdateListener(new OMaterialDrawable$$ExternalSyntheticLambda4(r19, r20, this, r17, r16));
        r10.start();
        Unit r0 = Unit.INSTANCE;
        r9[r17] = r10;
    L36:
        this.currentBlendConfigsArray[r17] = r20;
        return true;
    L33:
        if (r2.getDEBUGGABLE() == false) goto L35;
        Log.d(TAG, "[" + System.identityHashCode(this) + "][updateBlendConfigs] " + ("index=" + r17 + " apply blend immediately, target=" + Companion.access$describeBlendConfigs(r2, r20)));
    L35:
        int[] r1 = OMaterialHelper.transformToBlendIntArray(r20);
        OMaterialHelper.setBlendEffect(r16, Arrays.copyOf(r1, r1.length));
        this.drawBlendConfigsArray[r17] = r20;
        goto L36
    L26:
        if (r2.getDEBUGGABLE() == false) goto L28;
        Log.d(TAG, "[" + System.identityHashCode(this) + "][updateBlendConfigs] " + ("index=" + r17 + " clear blend effect"));
    L28:
        int[] r3 = OMaterialHelper.transformToBlendIntArray(new BlendConfig[0]);
        OMaterialHelper.setBlendEffect(r16, Arrays.copyOf(r3, r3.length));
        this.currentBlendConfigsArray[r17] = null;
        this.drawBlendConfigsArray[r17] = null;
        return true;
    L17:
        if (r2.getDEBUGGABLE() == false) goto L19;
        Log.d(TAG, "[" + System.identityHashCode(this) + "][updateBlendConfigs] " + ("index=" + r17 + " cancel previous blend animator"));
        goto L19
    }

    private final boolean updateOverlayBlendConfigs(final Object r15, final int r16, boolean r17, final BlendConfig[] r18, final BlendConfig[] r19) {
        Companion r2 = Companion;
        if (r2.getDEBUGGABLE() == false) goto L6;
        Log.d(TAG, "[" + System.identityHashCode(this) + "][updateOverlayBlendConfigs] " + ("index=" + r16 + ", enableAnimate=" + r17 + ", from=" + Companion.access$describeBlendConfigs(r2, r18) + ", to=" + Companion.access$describeBlendConfigs(r2, r19)));
    L6:
        if (r18 == null) goto L15;
        if (Arrays.equals(r18, r19) == false) goto L15;
        if (r2.getDEBUGGABLE() == false) goto L13;
        Log.d(TAG, "[" + System.identityHashCode(this) + "][updateOverlayBlendConfigs] " + ("index=" + r16 + " skip because from/to are equal"));
    L13:
        return false;
    L15:
        if (this.overlayBlendAnimatorArray[r16] != null) goto L17;
    L19:
        ValueAnimator r11 = this.overlayBlendAnimatorArray[r16];
        if (r11 == null) goto L24;
        r11.cancel();
    L24:
        if (r19 == null) goto L26;
        if (r17 == false) goto L32;
        ValueAnimator[] r9 = this.overlayBlendAnimatorArray;
        ValueAnimator r10 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r10.setDuration(getAnimDuration());
        r10.setInterpolator(getAnimInterpolator());
        r10.addListener(new OMaterialDrawable$updateOverlayBlendConfigs$4$1(this, r16, r18, r19));
        r10.addUpdateListener(new OMaterialDrawable$$ExternalSyntheticLambda1(r18, r19, this, r15, r16));
        r10.start();
        Unit r0 = Unit.INSTANCE;
        r9[r16] = r10;
    L36:
        this.currentOverlayBlendConfigsArray[r16] = r19;
        return true;
    L32:
        int r1 = r19[0].getColor();
        int r3 = r19[0].getBlendMode();
        if (r2.getDEBUGGABLE() == false) goto L35;
        Log.d(TAG, "[" + System.identityHashCode(this) + "][updateOverlayBlendConfigs] " + ("index=" + r16 + " apply overlay immediately, target=" + Companion.access$describeBlendConfigs(r2, r19)));
    L35:
        OMaterialHelper.setOverlayBlendEffect(r15, r1, 1.0f, r3);
        this.drawOverlayBlendConfigsArray[r16] = r19;
        goto L36
    L26:
        if (r2.getDEBUGGABLE() == false) goto L28;
        Log.d(TAG, "[" + System.identityHashCode(this) + "][updateOverlayBlendConfigs] " + ("index=" + r16 + " clear overlay blend cache"));
    L28:
        this.currentOverlayBlendConfigsArray[r16] = null;
        this.drawOverlayBlendConfigsArray[r16] = null;
        return true;
    L17:
        if (r2.getDEBUGGABLE() == false) goto L19;
        Log.d(TAG, "[" + System.identityHashCode(this) + "][updateOverlayBlendConfigs] " + ("index=" + r16 + " cancel previous overlay animator"));
        goto L19
    }

    private final boolean updateStrokeConfig(final View r8, Object r9, final int r10, boolean r11, final StrokeConfig r12, final StrokeConfig r13) {
        Companion r14 = Companion;
        if (r14.getDEBUGGABLE() == false) goto L6;
        Log.d(TAG, "[" + System.identityHashCode(this) + "][updateStrokeConfig] " + ("index=" + r10 + ", enableAnimate=" + r11 + ", from=" + Companion.access$describeStrokeConfig(r14, r12) + ", to=" + Companion.access$describeStrokeConfig(r14, r13)));
    L6:
        if (r12 != null) goto L8;
    L14:
        if (r13 != null) goto L17;
        return false;
    L17:
        if (this.strokeAnimator != null) goto L19;
    L21:
        ValueAnimator r0 = this.strokeAnimator;
        if (r0 == null) goto L25;
        r0.cancel();
    L25:
        if (r11 == false) goto L28;
        ValueAnimator r15 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r15.setDuration(getAnimDuration());
        r15.setInterpolator(getAnimInterpolator());
        r15.addUpdateListener(new OMaterialDrawable$$ExternalSyntheticLambda0(r12, r13, this, r10, r8));
        r15.addListener(new OMaterialDrawable$updateStrokeConfig$3$2(this, r10, r12, r13, r8));
        r15.start();
        this.strokeAnimator = r15;
    L31:
        this.currentStrokeConfigArray[r10] = r13;
        return true;
    L28:
        if (r14.getDEBUGGABLE() == false) goto L30;
        Log.d(TAG, "[" + System.identityHashCode(this) + "][updateStrokeConfig] " + ("index=" + r10 + " apply stroke immediately, target=" + Companion.access$describeStrokeConfig(r14, r13)));
    L30:
        setStroke(OUnitExtensionKt.vdp(r8, r13.getWidth()), r13.getColor());
        this.drawStrokeConfigArray[r10] = r13;
        goto L31
    L19:
        if (r14.getDEBUGGABLE() == false) goto L21;
        Log.d(TAG, "[" + System.identityHashCode(this) + "][updateStrokeConfig] " + ("index=" + r10 + " cancel previous stroke animator"));
        goto L21
    L8:
        if (r12.equals(r13) == false) goto L14;
        if (r14.getDEBUGGABLE() == false) goto L13;
        Log.d(TAG, "[" + System.identityHashCode(this) + "][updateStrokeConfig] " + ("index=" + r10 + " skip because from/to are equal"));
    L13:
        return false;
    }

    private final void updateSolidColor(final int r5, boolean r6) {
        Companion r0 = Companion;
        if (r0.getDEBUGGABLE() == false) goto L5;
        Log.d(TAG, "[" + System.identityHashCode(this) + "][updateSolidColor] " + ("animate=" + r6 + ", from=" + Companion.access$formatColor(r0, this.animatedSolidColor) + ", to=" + Companion.access$formatColor(r0, r5)));
    L5:
        ValueAnimator r1 = this.colorAnimator;
        if (r1 == null) goto L9;
        r1.cancel();
    L9:
        if (r6 == false) goto L11;
        final int r7 = this.animatedSolidColor;
        ValueAnimator r2 = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(r7), Integer.valueOf(r5)});
        r2.setDuration(getAnimDuration());
        r2.setInterpolator(getAnimInterpolator());
        r2.addListener(new OMaterialDrawable$updateSolidColor$2$1(this, r7, r5));
        r2.addUpdateListener(new OMaterialDrawable$$ExternalSyntheticLambda3(this));
        r2.start();
        this.colorAnimator = r2;
        return;
    L11:
        this.animatedSolidColor = r5;
        setColor(r5);
    }

    private final void updateStrokeColor(final int r5, boolean r6) {
        Companion r0 = Companion;
        if (r0.getDEBUGGABLE() == false) goto L5;
        Log.d(TAG, "[" + System.identityHashCode(this) + "][updateStrokeColor] " + ("animate=" + r6 + ", from=" + Companion.access$formatColor(r0, this.animatedStrokeColor) + ", to=" + Companion.access$formatColor(r0, r5)));
    L5:
        ValueAnimator r1 = this.strokeAnimator;
        if (r1 == null) goto L9;
        r1.cancel();
    L9:
        if (r6 == false) goto L11;
        final int r7 = this.animatedStrokeColor;
        ValueAnimator r2 = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(r7), Integer.valueOf(r5)});
        r2.setDuration(getAnimDuration());
        r2.setInterpolator(getAnimInterpolator());
        r2.addListener(new OMaterialDrawable$updateStrokeColor$2$1(this, r7, r5));
        r2.addUpdateListener(new OMaterialDrawable$$ExternalSyntheticLambda2(this));
        r2.start();
        this.strokeAnimator = r2;
        return;
    L11:
        this.animatedStrokeColor = r5;
        setStroke(this.strokeWidth, r5);
    }
}
