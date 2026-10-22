package com.obric.oui.texteffects;

import android.content.Context;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.obric.oui.texteffects.core.FillSpec;
import com.obric.oui.texteffects.core.TextEffectSpec;
import com.obric.oui.texteffects.preset.DimPointEffectSpecFactory;
import com.obric.oui.texteffects.render.TextLayoutCache;
import com.obric.oui.texteffects.render.TextLayoutCacheBuilder;
import com.obric.oui.texteffects.runtime.LayerFrame;
import com.obric.oui.texteffects.runtime.TextEffectFrame;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import obric.widget.search.data.SearchConfigType;

/* JADX INFO: compiled from: ODimPointEffectTextView.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001d\u0018\u0000 H2\u00020\u0001:\u0004HIJKB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001a\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0014J\u0010\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u0014H\u0014J\b\u0010\"\u001a\u00020\u0010H\u0002J\u0006\u0010#\u001a\u00020$J\u0006\u0010%\u001a\u00020&J\u0006\u0010'\u001a\u00020&J\u0006\u0010(\u001a\u00020&J\u0006\u0010)\u001a\u00020&J \u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\f2\u0006\u0010-\u001a\u00020$2\u0006\u0010.\u001a\u00020/H\u0014J\b\u00100\u001a\u00020+H\u0014J\u0018\u00101\u001a\u00020+2\u0006\u0010,\u001a\u00020\f2\u0006\u0010.\u001a\u00020/H\u0014J\b\u00102\u001a\u00020+H\u0014J\u0010\u00103\u001a\u00020+2\u0006\u00104\u001a\u00020\u0010H\u0016J\u000e\u00105\u001a\u00020+2\u0006\u00106\u001a\u00020\nJ\u0010\u00107\u001a\u00020+2\b\u0010!\u001a\u0004\u0018\u00010\u0014J\u0012\u00108\u001a\u00020+2\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u0014J\u0010\u0010:\u001a\u00020+2\b\u0010!\u001a\u0004\u0018\u00010\u0014J\u0012\u0010;\u001a\u00020+2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0014J\u000e\u0010<\u001a\u00020+2\u0006\u0010=\u001a\u00020\u0014J\u0006\u0010>\u001a\u00020+J\u000e\u0010?\u001a\u00020+2\u0006\u0010@\u001a\u00020\u0014J\u000e\u0010A\u001a\u00020+2\u0006\u0010B\u001a\u00020\u0014J\u000e\u0010C\u001a\u00020+2\u0006\u0010D\u001a\u00020\u0014J\b\u0010E\u001a\u00020+H\u0016J\b\u0010F\u001a\u00020+H\u0002J\f\u0010G\u001a\u00020\n*\u00020\fH\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\fX\u0094D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u0010X\u0094D¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006L"}, d2 = {"Lcom/obric/oui/texteffects/ODimPointEffectTextView;", "Lcom/obric/oui/texteffects/OProtocolTextEffectTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "activeMode", "Lcom/obric/oui/texteffects/ODimPointEffectTextView$DimPointMode;", "logTag", "", "getLogTag", "()Ljava/lang/String;", "maxBlurRadiusDp", "", "getMaxBlurRadiusDp", "()F", "pendingRewriteText", "", "pendingTextType", "Lcom/obric/oui/texteffects/ODimPointEffectTextView$PendingTextType;", "promptExitGenerateText", "rewritePhase", "Lcom/obric/oui/texteffects/ODimPointEffectTextView$RewritePhase;", "buildGradientShader", "Landroid/graphics/LinearGradient;", "cache", "Lcom/obric/oui/texteffects/render/TextLayoutCache;", "fill", "Lcom/obric/oui/texteffects/core/FillSpec$LinearGradient;", "buildTextCache", "text", "currentPendingGradientAlpha", "currentRewritePlayTimeMs", "", "isContentPending", "", "isPromptPending", "isRewriteEnteringNewText", "isRewriteExitingOldText", "onEffectFrameUpdated", "", "effectName", "playTimeMs", "spec", "Lcom/obric/oui/texteffects/core/TextEffectSpec;", "onTextEffectFinished", "onTextEffectStarted", "onTextEffectStopped", "setDebugAnimationDurationScale", "scale", "setDimPointMode", SearchConfigType.KEY_MODE, "setTextWithEffect", "startContentPending", "contentText", "startDimPointTextEffect", "startGenerate", "startGenerateFromPromptPending", "actualText", "startPending", "startPromptPending", "promptText", "startPromptTextSwitch", "newPromptText", "startRewrite", "newText", "stopEffect", "updateRewritePhase", "toDimPointMode", "Companion", "DimPointMode", "PendingTextType", "RewritePhase", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ODimPointEffectTextView extends OProtocolTextEffectTextView {
    private static final Companion Companion = null;

    @Deprecated
    private static final String EffectNameGenerate = "generate";

    @Deprecated
    private static final String EffectNamePending = "pending";

    @Deprecated
    private static final String EffectNamePromptExitToGenerate = "prompt_exit_to_generate";

    @Deprecated
    private static final String EffectNamePromptSwitch = "prompt_switch";

    @Deprecated
    private static final String EffectNameRewrite = "rewrite";

    @Deprecated
    private static final String PendingGradientLayerId = "gradient_overlay";

    @Deprecated
    private static final String Tag = "DimPointTextView";
    private DimPointMode activeMode;
    private final String logTag;
    private final float maxBlurRadiusDp;
    private CharSequence pendingRewriteText;
    private PendingTextType pendingTextType;
    private CharSequence promptExitGenerateText;
    private RewritePhase rewritePhase;

    /* JADX INFO: compiled from: ODimPointEffectTextView.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/oui/texteffects/ODimPointEffectTextView$Companion;", "", "()V", "EffectNameGenerate", "", "EffectNamePending", "EffectNamePromptExitToGenerate", "EffectNamePromptSwitch", "EffectNameRewrite", "PendingGradientLayerId", "Tag", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: ODimPointEffectTextView.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/obric/oui/texteffects/ODimPointEffectTextView$DimPointMode;", "", "(Ljava/lang/String;I)V", "NONE", "PENDING", "PROMPT_EXIT_TO_GENERATE", "PROMPT_SWITCH", "GENERATE", "REWRITE", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum DimPointMode extends Enum<DimPointMode> {
        private static final /* synthetic */ DimPointMode[] $VALUES = null;
        public static final DimPointMode GENERATE = null;
        public static final DimPointMode NONE = null;
        public static final DimPointMode PENDING = null;
        public static final DimPointMode PROMPT_EXIT_TO_GENERATE = null;
        public static final DimPointMode PROMPT_SWITCH = null;
        public static final DimPointMode REWRITE = null;

        private static final /* synthetic */ DimPointMode[] $values() {
            return new DimPointMode[]{NONE, PENDING, PROMPT_EXIT_TO_GENERATE, PROMPT_SWITCH, GENERATE, REWRITE};
        }

        public static DimPointMode valueOf(String r1) {
            return (DimPointMode) Enum.valueOf(DimPointMode.class, r1);
        }

        public static DimPointMode[] values() {
            return (DimPointMode[]) $VALUES.clone();
        }

        static {
            NONE = new DimPointMode("NONE", 0);
            PENDING = new DimPointMode("PENDING", 1);
            PROMPT_EXIT_TO_GENERATE = new DimPointMode("PROMPT_EXIT_TO_GENERATE", 2);
            PROMPT_SWITCH = new DimPointMode("PROMPT_SWITCH", 3);
            GENERATE = new DimPointMode("GENERATE", 4);
            REWRITE = new DimPointMode("REWRITE", 5);
            $VALUES = $values();
        }

        private DimPointMode(String r1, int r2) {
            super(r1, r2);
        }
    }

    /* JADX INFO: compiled from: ODimPointEffectTextView.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/texteffects/ODimPointEffectTextView$PendingTextType;", "", "(Ljava/lang/String;I)V", "CONTENT", "PROMPT", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum PendingTextType extends Enum<PendingTextType> {
        private static final /* synthetic */ PendingTextType[] $VALUES = null;
        public static final PendingTextType CONTENT = null;
        public static final PendingTextType PROMPT = null;

        private static final /* synthetic */ PendingTextType[] $values() {
            return new PendingTextType[]{CONTENT, PROMPT};
        }

        public static PendingTextType valueOf(String r1) {
            return (PendingTextType) Enum.valueOf(PendingTextType.class, r1);
        }

        public static PendingTextType[] values() {
            return (PendingTextType[]) $VALUES.clone();
        }

        static {
            CONTENT = new PendingTextType("CONTENT", 0);
            PROMPT = new PendingTextType("PROMPT", 1);
            $VALUES = $values();
        }

        private PendingTextType(String r1, int r2) {
            super(r1, r2);
        }
    }

    /* JADX INFO: compiled from: ODimPointEffectTextView.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/texteffects/ODimPointEffectTextView$RewritePhase;", "", "(Ljava/lang/String;I)V", "NONE", "EXITING_OLD_TEXT", "ENTERING_NEW_TEXT", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum RewritePhase extends Enum<RewritePhase> {
        private static final /* synthetic */ RewritePhase[] $VALUES = null;
        public static final RewritePhase ENTERING_NEW_TEXT = null;
        public static final RewritePhase EXITING_OLD_TEXT = null;
        public static final RewritePhase NONE = null;

        private static final /* synthetic */ RewritePhase[] $values() {
            return new RewritePhase[]{NONE, EXITING_OLD_TEXT, ENTERING_NEW_TEXT};
        }

        public static RewritePhase valueOf(String r1) {
            return (RewritePhase) Enum.valueOf(RewritePhase.class, r1);
        }

        public static RewritePhase[] values() {
            return (RewritePhase[]) $VALUES.clone();
        }

        static {
            NONE = new RewritePhase("NONE", 0);
            EXITING_OLD_TEXT = new RewritePhase("EXITING_OLD_TEXT", 1);
            ENTERING_NEW_TEXT = new RewritePhase("ENTERING_NEW_TEXT", 2);
            $VALUES = $values();
        }

        private RewritePhase(String r1, int r2) {
            super(r1, r2);
        }
    }

    /* JADX INFO: compiled from: ODimPointEffectTextView.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1 = null;

        static {
            int[] r0 = new int[DimPointMode.values().length];
            r0[DimPointMode.PENDING.ordinal()] = 1;
            r0[DimPointMode.GENERATE.ordinal()] = 2;
            r0[DimPointMode.REWRITE.ordinal()] = 3;
            r0[DimPointMode.PROMPT_EXIT_TO_GENERATE.ordinal()] = 4;
            r0[DimPointMode.PROMPT_SWITCH.ordinal()] = 5;
            r0[DimPointMode.NONE.ordinal()] = 6;
            $EnumSwitchMapping$0 = r0;
            int[] r1 = new int[RewritePhase.values().length];
            r1[RewritePhase.EXITING_OLD_TEXT.ordinal()] = 1;
            r1[RewritePhase.ENTERING_NEW_TEXT.ordinal()] = 2;
            r1[RewritePhase.NONE.ordinal()] = 3;
            $EnumSwitchMapping$1 = r1;
        }
    }

    /* JADX INFO: renamed from: com.obric.oui.texteffects.ODimPointEffectTextView$buildTextCache$1, reason: invalid class name */
    /* JADX INFO: compiled from: ODimPointEffectTextView.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Float, Float> {
        AnonymousClass1(Object r8) {
            super(1, r8, ODimPointEffectTextView.class, "computeStartX", "computeStartX(F)F", 0);
        }

        public final Float invoke(float r1) {
            return Float.valueOf(((ODimPointEffectTextView) this.receiver).computeStartX(r1));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Float invoke(Float r1) {
            return invoke(r1.floatValue());
        }
    }

    static {
        Companion = new Companion(null);
    }

    public ODimPointEffectTextView(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public ODimPointEffectTextView(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    public /* synthetic */ ODimPointEffectTextView(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public ODimPointEffectTextView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.activeMode = DimPointMode.NONE;
        this.pendingTextType = PendingTextType.CONTENT;
        this.rewritePhase = RewritePhase.NONE;
        this.logTag = Tag;
        this.maxBlurRadiusDp = 16.0f;
    }

    @Override // com.obric.oui.texteffects.OProtocolTextEffectTextView
    protected String getLogTag() {
        return this.logTag;
    }

    @Override // com.obric.oui.texteffects.OProtocolTextEffectTextView
    protected float getMaxBlurRadiusDp() {
        return this.maxBlurRadiusDp;
    }

    public final void setDimPointMode(DimPointMode r2) {
        Intrinsics.checkNotNullParameter(r2, SearchConfigType.KEY_MODE);
        if (this.activeMode != r2) goto L5;
        return;
    L5:
        stopEffect();
        int r3 = WhenMappings.$EnumSwitchMapping$0[r2.ordinal()];
        if (r3 != 1) goto L8;
        startPending();
        return;
    L8:
        if (r3 != 2) goto L14;
        startGenerate(null);
        return;
    }

    @Override // com.obric.oui.texteffects.OProtocolTextEffectTextView
    public void setDebugAnimationDurationScale(float r11) {
        float r0 = getDebugAnimationDurationScale();
        super.setDebugAnimationDurationScale(r11);
        if (r0 != getDebugAnimationDurationScale()) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L8;
        return;
    L8:
        if (this.activeMode != DimPointMode.PENDING) goto L12;
        OProtocolTextEffectTextView.startTextEffect$default(this, DimPointEffectSpecFactory.INSTANCE.pending(), EffectNamePending, true, null, null, null, 56, null);
        return;
    L12:
        return;
    L5:
        r12 = false;
        goto L6
    }

    public final void startPending() {
        this.pendingTextType = PendingTextType.CONTENT;
        OProtocolTextEffectTextView.startTextEffect$default(this, DimPointEffectSpecFactory.INSTANCE.pending(), EffectNamePending, false, null, null, null, 60, null);
    }

    public final void startPromptPending(CharSequence r10) {
        Intrinsics.checkNotNullParameter(r10, "promptText");
        setText(r10);
        this.pendingTextType = PendingTextType.PROMPT;
        OProtocolTextEffectTextView.startTextEffect$default(this, DimPointEffectSpecFactory.INSTANCE.pending(), EffectNamePending, false, null, null, null, 60, null);
    }

    public final boolean isPromptPending() {
        if (this.activeMode == DimPointMode.PENDING) goto L5;
    L7:
        return false;
    L5:
        if (this.pendingTextType != PendingTextType.PROMPT) goto L7;
        return true;
    }

    public final boolean isContentPending() {
        if (this.activeMode == DimPointMode.PENDING) goto L5;
    L7:
        return false;
    L5:
        if (this.pendingTextType != PendingTextType.CONTENT) goto L7;
        return true;
    }

    public final boolean isRewriteExitingOldText() {
        updateRewritePhase();
        if (this.rewritePhase != RewritePhase.EXITING_OLD_TEXT) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isRewriteEnteringNewText() {
        updateRewritePhase();
        if (this.rewritePhase != RewritePhase.ENTERING_NEW_TEXT) goto L5;
        return true;
    L5:
        return false;
    }

    public final long currentRewritePlayTimeMs() {
        return getCurrentEffectPlayTimeMs();
    }

    public final void startDimPointTextEffect(CharSequence r5) {
        CharSequence r0 = getText();
        if (r0 != null) goto L5;
    L5:
        if (r5 != null) goto L7;
    L7:
        boolean r2 = true;
        if (isPromptPending() == false) goto L17;
        if (r5.length() <= 0) goto L12;
        boolean r1 = true;
    L13:
        if (r1 == false) goto L17;
        startGenerateFromPromptPending(r5);
        return;
    L12:
        r1 = false;
    L17:
        if (TextUtils.equals(r0, r5) == false) goto L25;
        if (r0.length() == 0) goto L22;
        r2 = false;
    L22:
        if (r2 == false) goto L32;
        stopEffect();
        setText(r5);
        return;
    L32:
        return;
    L25:
        if (r0.length() == 0) goto L28;
        r2 = false;
    L28:
        if (r2 == false) goto L30;
        startGenerate(r5);
        return;
    L30:
        startRewrite(r5);
    }

    public final void setTextWithEffect(CharSequence r1) {
        startDimPointTextEffect(r1);
    }

    public final void startGenerateFromPromptPending(CharSequence r11) {
        Intrinsics.checkNotNullParameter(r11, "actualText");
        if (isPromptPending() == true) goto L6;
        startGenerate(r11);
        return;
    L6:
        this.promptExitGenerateText = r11;
        OProtocolTextEffectTextView.startTextEffect$default(this, DimPointEffectSpecFactory.INSTANCE.promptPendingExit(), EffectNamePromptExitToGenerate, false, "", null, null, 52, null);
    }

    public final void startPromptTextSwitch(CharSequence r11) {
        Intrinsics.checkNotNullParameter(r11, "newPromptText");
        CharSequence r0 = getText();
        if (r0 != null) goto L5;
    L5:
        CharSequence r6 = r0;
        setText(r11);
        this.pendingTextType = PendingTextType.PROMPT;
        OProtocolTextEffectTextView.startTextEffect$default(this, DimPointEffectSpecFactory.INSTANCE.promptTextSwitch(), EffectNamePromptSwitch, false, r11, r6, r11, 4, null);
    }

    public static /* synthetic */ void startContentPending$default(ODimPointEffectTextView r0, CharSequence r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = r0.getText();
    L5:
        r0.startContentPending(r1);
    }

    public final void startContentPending(CharSequence r1) {
        if (r1 == null) goto L5;
        setText(r1);
    L5:
        startPending();
    }

    public static /* synthetic */ void startGenerate$default(ODimPointEffectTextView r0, CharSequence r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        r0.startGenerate(r1);
    }

    public final void startGenerate(CharSequence r10) {
        if (r10 == null) goto L4;
        setText(r10);
    L4:
        this.pendingTextType = PendingTextType.CONTENT;
        this.promptExitGenerateText = null;
        OProtocolTextEffectTextView.startTextEffect$default(this, DimPointEffectSpecFactory.INSTANCE.generate(false), EffectNameGenerate, false, getText(), null, null, 52, null);
    }

    public final void startRewrite(CharSequence r11) {
        Intrinsics.checkNotNullParameter(r11, "newText");
        if (this.activeMode != DimPointMode.REWRITE) goto L12;
        RewritePhase r0 = this.rewritePhase;
        int r1 = WhenMappings.$EnumSwitchMapping$1[r0.ordinal()];
        if (r1 != 1) goto L7;
        setText(r11);
        OProtocolTextEffectTextView.updateTextEffectSnapshots$default(this, r11, null, r11, 2, null);
        return;
    L7:
        if (r1 != 2) goto L18;
        this.pendingRewriteText = r11;
        return;
    L18:
        return;
    L12:
        CharSequence r2 = getText();
        if (r2 != null) goto L15;
    L15:
        CharSequence r6 = r2;
        float r3 = currentPendingGradientAlpha();
        this.pendingTextType = PendingTextType.CONTENT;
        this.promptExitGenerateText = null;
        this.pendingRewriteText = null;
        setText(r11);
        OProtocolTextEffectTextView.startTextEffect$default(this, DimPointEffectSpecFactory.INSTANCE.rewrite(false, r3), EffectNameRewrite, false, r11, r6, r11, 4, null);
    }

    @Override // com.obric.oui.texteffects.OProtocolTextEffectTextView
    public void stopEffect() {
        super.stopEffect();
        this.activeMode = DimPointMode.NONE;
        this.pendingTextType = PendingTextType.CONTENT;
        this.promptExitGenerateText = null;
        this.rewritePhase = RewritePhase.NONE;
        this.pendingRewriteText = null;
    }

    @Override // com.obric.oui.texteffects.OProtocolTextEffectTextView
    protected void onTextEffectStarted(String r2, TextEffectSpec r3) {
        Intrinsics.checkNotNullParameter(r2, "effectName");
        Intrinsics.checkNotNullParameter(r3, "spec");
        this.activeMode = toDimPointMode(r2);
        updateRewritePhase();
    }

    @Override // com.obric.oui.texteffects.OProtocolTextEffectTextView
    protected void onTextEffectStopped() {
        this.activeMode = DimPointMode.NONE;
        this.rewritePhase = RewritePhase.NONE;
    }

    @Override // com.obric.oui.texteffects.OProtocolTextEffectTextView
    protected void onTextEffectFinished() {
        DimPointMode r0 = this.activeMode;
        this.activeMode = DimPointMode.NONE;
        this.rewritePhase = RewritePhase.NONE;
        if (r0 != DimPointMode.PROMPT_EXIT_TO_GENERATE) goto L8;
        CharSequence r1 = this.promptExitGenerateText;
        this.promptExitGenerateText = null;
        this.pendingTextType = PendingTextType.CONTENT;
        if (r1 == null) goto L18;
        startGenerate(r1);
        return;
    L18:
        return;
    L8:
        if (r0 != DimPointMode.PROMPT_SWITCH) goto L11;
        this.pendingTextType = PendingTextType.PROMPT;
        return;
    L11:
        if (r0 != DimPointMode.REWRITE) goto L21;
        CharSequence r2 = this.pendingRewriteText;
        this.pendingRewriteText = null;
        if (r2 != null) goto L15;
        return;
    L15:
        if (TextUtils.equals(getText(), r2) == true) goto L23;
        startRewrite(r2);
        return;
    L23:
        return;
    }

    @Override // com.obric.oui.texteffects.OProtocolTextEffectTextView
    protected void onEffectFrameUpdated(String r1, long r2, TextEffectSpec r4) {
        Intrinsics.checkNotNullParameter(r1, "effectName");
        Intrinsics.checkNotNullParameter(r4, "spec");
        updateRewritePhase();
    }

    @Override // com.obric.oui.texteffects.OProtocolTextEffectTextView
    protected TextLayoutCache buildTextCache(CharSequence r9) {
        Intrinsics.checkNotNullParameter(r9, "text");
        TextLayoutCacheBuilder r1 = TextLayoutCacheBuilder.INSTANCE;
        TextPaint r3 = getPaint();
        Intrinsics.checkNotNullExpressionValue(r3, "paint");
        return r1.build(r9, r3, computeContentWidth(), getEllipsize(), new AnonymousClass1(this), new AnonymousClass2(this));
    }

    @Override // com.obric.oui.texteffects.OProtocolTextEffectTextView
    protected LinearGradient buildGradientShader(TextLayoutCache r9, FillSpec.LinearGradient r10) {
        Intrinsics.checkNotNullParameter(r9, "cache");
        Intrinsics.checkNotNullParameter(r10, "fill");
        if (r9.getBaseTotalWidth() > 0.01f) goto L6;
        return null;
    L6:
        float r1 = r9.getBaseStartX();
        return new LinearGradient(r1, 0.0f, r1 + r9.getBaseTotalWidth(), 0.0f, r10.getColors(), r10.getPositions(), Shader.TileMode.CLAMP);
    }

    private final float currentPendingGradientAlpha() {
        if (this.activeMode == DimPointMode.PENDING) goto L5;
        return 0.0f;
    L5:
        if (this.pendingTextType != PendingTextType.CONTENT) goto L29;
        TextEffectFrame r4 = sampleCurrentEffectFrame();
        if (r4 == null) goto L30;
        List<LayerFrame> r5 = r4.getLayers();
        if (r5 == null) goto L31;
        Iterator<T> r6 = r5.iterator();
    L15:
        if (r6.hasNext() == false) goto L19;
        Object r0 = r6.next();
        if (Intrinsics.areEqual(((LayerFrame) r0).getLayerId(), PendingGradientLayerId) == false) goto L15;
    L20:
        LayerFrame r1 = (LayerFrame) r0;
        if (r1 != null) goto L24;
        return 0.0f;
    L24:
        return RangesKt.coerceIn(r1.alphaOr(0.0f), 0.0f, 0.8f);
    L19:
        r0 = null;
        goto L20
    L31:
        return 0.0f;
    L30:
        return 0.0f;
    L29:
        return 0.0f;
    }

    private final void updateRewritePhase() {
        if (this.activeMode == DimPointMode.REWRITE) goto L5;
        RewritePhase r0 = RewritePhase.NONE;
    L9:
        this.rewritePhase = r0;
        return;
    L5:
        if (getCurrentEffectPlayTimeMs() >= 150) goto L7;
        r0 = RewritePhase.EXITING_OLD_TEXT;
        goto L9
    L7:
        r0 = RewritePhase.ENTERING_NEW_TEXT;
        goto L9
    }

    private final DimPointMode toDimPointMode(String r1) {
        switch(r1.hashCode()) {
            case -1253981585: goto L22;
            case -682587753: goto L18;
            case -208065901: goto L14;
            case 1101148556: goto L10;
            case 1810371957: goto L6;
            default: goto L26;
        };
    L6:
        if (r1.equals(EffectNameGenerate) == false) goto L26;
        return DimPointMode.GENERATE;
    L10:
        if (r1.equals(EffectNameRewrite) == false) goto L26;
        return DimPointMode.REWRITE;
    L14:
        if (r1.equals(EffectNamePromptExitToGenerate) == false) goto L26;
        return DimPointMode.PROMPT_EXIT_TO_GENERATE;
    L18:
        if (r1.equals(EffectNamePending) == false) goto L26;
        return DimPointMode.PENDING;
    L22:
        if (r1.equals(EffectNamePromptSwitch) == false) goto L26;
        return DimPointMode.PROMPT_SWITCH;
    L26:
        return DimPointMode.NONE;
    }
}
