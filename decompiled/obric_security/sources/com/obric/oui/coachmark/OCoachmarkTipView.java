package com.obric.oui.coachmark;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedanceos.security.invokeHistory.InvokeHistoryActivity;
import com.obric.common.oui.R;
import com.obric.oui.button.OButton;
import com.obric.oui.button.OIconButton;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.common.util.ViewExtensionsKt;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.text.OTextView;
import com.obric.oui.utils.log.L;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: OCoachmarkTipView.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 T2\u00020\u0001:\u0002STB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001a\u0010(\u001a\u00020)2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020\u000eH\u0002J\b\u0010,\u001a\u00020\u0010H\u0002J\b\u0010-\u001a\u00020\u000eH\u0002J\u0010\u0010.\u001a\u00020)2\b\u0010/\u001a\u0004\u0018\u000100J\u000e\u00101\u001a\u00020)2\u0006\u00102\u001a\u00020\nJ\u0010\u00103\u001a\u00020)2\u0006\u00104\u001a\u00020\u0007H\u0016J\u000e\u00105\u001a\u00020)2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u00106\u001a\u00020)2\u0006\u00107\u001a\u00020\u0010J/\u00108\u001a\u00020)2\b\u0010/\u001a\u0004\u0018\u0001002\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010:\u001a\u0004\u0018\u00010;H\u0007¢\u0006\u0002\u0010<J\u0010\u0010=\u001a\u00020)2\b\u0010/\u001a\u0004\u0018\u000100J\u0010\u0010>\u001a\u00020)2\b\u0010?\u001a\u0004\u0018\u00010@J\u0010\u0010A\u001a\u00020)2\b\u0010B\u001a\u0004\u0018\u00010CJ\u0010\u0010D\u001a\u00020)2\b\u0010B\u001a\u0004\u0018\u00010CJ\u0010\u0010E\u001a\u00020)2\b\u0010/\u001a\u0004\u0018\u000100J\u0010\u0010F\u001a\u00020)2\b\u0010/\u001a\u0004\u0018\u000100J\u000e\u0010G\u001a\u00020)2\u0006\u0010H\u001a\u00020\u000eJ\u000e\u0010I\u001a\u00020)2\u0006\u0010'\u001a\u00020\u000eJ\b\u0010J\u001a\u00020)H\u0002J\b\u0010K\u001a\u00020)H\u0002J\b\u0010L\u001a\u00020)H\u0002J\b\u0010M\u001a\u00020)H\u0002J\b\u0010N\u001a\u00020)H\u0002J\b\u0010O\u001a\u00020)H\u0002J\b\u0010P\u001a\u00020)H\u0002J\u0010\u0010Q\u001a\u00020)2\u0006\u0010R\u001a\u00020\u000eH\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006U"}, d2 = {"Lcom/obric/oui/coachmark/OCoachmarkTipView;", "Lcom/obric/oui/layout/OUILinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "actionType", "Lcom/obric/oui/coachmark/OCoachmarkTipView$ActionType;", "backgroundColor", "Ljava/lang/Integer;", "closable", "", "customCornerRadius", "", "Ljava/lang/Float;", "descText", "Lcom/obric/oui/text/OTextView;", "hasXmlBackground", "inlineAction", "Lcom/obric/oui/button/OButton;", "inlineContainer", "Landroid/view/View;", "inlineDismiss", "Lcom/obric/oui/button/OIconButton;", "inlineIcon", "Landroid/widget/ImageView;", "inlineText", "multiAction", "multiActions", "multiContainer", "multiDismiss", "multiIcon", "multiLeadingRow", "Landroid/widget/LinearLayout;", "multiTextGroup", "showIcon", "singleLine", "applyAttributes", "", "applyPadding", "multiLine", "effectiveCornerRadius", "isMultiLine", "setActionText", "text", "", "setActionType", "type", "setBackgroundColor", "color", "setClosable", "setCornerRadius", "radius", "setDescription", "maxLines", "ellipsize", "Landroid/text/TextUtils$TruncateAt;", "(Ljava/lang/CharSequence;Ljava/lang/Integer;Landroid/text/TextUtils$TruncateAt;)V", "setDismissText", "setIcon", "drawable", "Landroid/graphics/drawable/Drawable;", "setOnActionClickListener", "listener", "Landroid/view/View$OnClickListener;", "setOnDismissClickListener", "setPrimaryButtonText", "setSecondaryButtonText", "setShowIcon", InvokeHistoryActivity.PREF_SHOW, "setSingleLine", "updateActionButtonStyle", "updateBackground", "updateIconVisibility", "updateInlineActions", "updateLayout", "updateLeadingVisibility", "updateMultiActions", "updateMultiLeadingAlignment", "hasActions", "ActionType", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OCoachmarkTipView extends OUILinearLayout {
    public static final Companion Companion = null;
    private static final int MULTI_LINE_RADIUS_DP = 20;
    private static final String TAG = "OCoachmarkTipView";
    private ActionType actionType;
    private Integer backgroundColor;
    private boolean closable;
    private Float customCornerRadius;
    private final OTextView descText;
    private boolean hasXmlBackground;
    private final OButton inlineAction;
    private final View inlineContainer;
    private final OIconButton inlineDismiss;
    private final ImageView inlineIcon;
    private final OTextView inlineText;
    private final OButton multiAction;
    private final View multiActions;
    private final View multiContainer;
    private final OButton multiDismiss;
    private final ImageView multiIcon;
    private final LinearLayout multiLeadingRow;
    private final View multiTextGroup;
    private boolean showIcon;
    private boolean singleLine;

    /* JADX INFO: compiled from: OCoachmarkTipView.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/obric/oui/coachmark/OCoachmarkTipView$ActionType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "PRIMARY", "NEUTRAL", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum ActionType extends Enum<ActionType> {
        private static final /* synthetic */ ActionType[] $VALUES = null;
        public static final Companion Companion = null;
        public static final ActionType NEUTRAL = null;
        public static final ActionType PRIMARY = null;
        private final int value;

        /* JADX INFO: compiled from: OCoachmarkTipView.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/coachmark/OCoachmarkTipView$ActionType$Companion;", "", "()V", "fromValue", "Lcom/obric/oui/coachmark/OCoachmarkTipView$ActionType;", "value", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker r1) {
                this();
            }

            private Companion() {
            }

            public final ActionType fromValue(int r6) {
                ActionType[] r5 = ActionType.values();
                int r0 = r5.length;
                int r2 = 0;
            L3:
                if (r2 >= r0) goto L11;
                ActionType r3 = r5[r2];
                if (r3.getValue() != r6) goto L7;
                boolean r4 = true;
            L8:
                if (r4 == true) goto L12;
                r2 = r2 + 1;
            L12:
                if (r3 == null) goto L14;
                return r3;
            L14:
                return ActionType.PRIMARY;
            L7:
                r4 = false;
                goto L8
            L11:
                r3 = null;
                goto L12
            }
        }

        private static final /* synthetic */ ActionType[] $values() {
            return new ActionType[]{PRIMARY, NEUTRAL};
        }

        public static ActionType valueOf(String r1) {
            return (ActionType) Enum.valueOf(ActionType.class, r1);
        }

        public static ActionType[] values() {
            return (ActionType[]) $VALUES.clone();
        }

        private ActionType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }

        public final int getValue() {
            return this.value;
        }

        static {
            PRIMARY = new ActionType("PRIMARY", 0, 0);
            NEUTRAL = new ActionType("NEUTRAL", 1, 1);
            $VALUES = $values();
            Companion = new Companion(null);
        }
    }

    /* JADX INFO: compiled from: OCoachmarkTipView.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/coachmark/OCoachmarkTipView$Companion;", "", "()V", "MULTI_LINE_RADIUS_DP", "", "TAG", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: OCoachmarkTipView.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[ActionType.values().length];
            r0[ActionType.PRIMARY.ordinal()] = 1;
            r0[ActionType.NEUTRAL.ordinal()] = 2;
            $EnumSwitchMapping$0 = r0;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public OCoachmarkTipView(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public OCoachmarkTipView(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    public final void setDescription(CharSequence r7) {
        setDescription$default(this, r7, null, null, 6, null);
    }

    public final void setDescription(CharSequence r7, Integer r8) {
        setDescription$default(this, r7, r8, null, 4, null);
    }

    public /* synthetic */ OCoachmarkTipView(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public OCoachmarkTipView(Context r9, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r9, "context");
        super(r9, r10, r11, null, 8, null);
        this.showIcon = true;
        this.actionType = ActionType.PRIMARY;
        setOrientation(1);
        LayoutInflater.from(r9).inflate(R.layout.o_coachmark_tip, this, true);
        View r12 = findViewById(R.id.inline_container);
        Intrinsics.checkNotNullExpressionValue(r12, "findViewById(R.id.inline_container)");
        this.inlineContainer = r12;
        View r13 = findViewById(R.id.iv_inline_icon);
        Intrinsics.checkNotNullExpressionValue(r13, "findViewById(R.id.iv_inline_icon)");
        this.inlineIcon = (ImageView) r13;
        View r14 = findViewById(R.id.tv_inline_text);
        Intrinsics.checkNotNullExpressionValue(r14, "findViewById(R.id.tv_inline_text)");
        this.inlineText = (OTextView) r14;
        View r15 = findViewById(R.id.btn_inline_action);
        Intrinsics.checkNotNullExpressionValue(r15, "findViewById(R.id.btn_inline_action)");
        this.inlineAction = (OButton) r15;
        View r16 = findViewById(R.id.btn_inline_dismiss);
        Intrinsics.checkNotNullExpressionValue(r16, "findViewById(R.id.btn_inline_dismiss)");
        this.inlineDismiss = (OIconButton) r16;
        View r17 = findViewById(R.id.multi_container);
        Intrinsics.checkNotNullExpressionValue(r17, "findViewById(R.id.multi_container)");
        this.multiContainer = r17;
        View r18 = findViewById(R.id.multi_leading_row);
        Intrinsics.checkNotNullExpressionValue(r18, "findViewById(R.id.multi_leading_row)");
        this.multiLeadingRow = (LinearLayout) r18;
        View r19 = findViewById(R.id.iv_multi_icon);
        Intrinsics.checkNotNullExpressionValue(r19, "findViewById(R.id.iv_multi_icon)");
        this.multiIcon = (ImageView) r19;
        View r20 = findViewById(R.id.multi_text_group);
        Intrinsics.checkNotNullExpressionValue(r20, "findViewById(R.id.multi_text_group)");
        this.multiTextGroup = r20;
        View r21 = findViewById(R.id.tv_desc);
        Intrinsics.checkNotNullExpressionValue(r21, "findViewById(R.id.tv_desc)");
        this.descText = (OTextView) r21;
        View r22 = findViewById(R.id.multi_actions);
        Intrinsics.checkNotNullExpressionValue(r22, "findViewById(R.id.multi_actions)");
        this.multiActions = r22;
        View r23 = findViewById(R.id.btn_multi_dismiss);
        Intrinsics.checkNotNullExpressionValue(r23, "findViewById(R.id.btn_multi_dismiss)");
        this.multiDismiss = (OButton) r23;
        View r24 = findViewById(R.id.btn_multi_action);
        Intrinsics.checkNotNullExpressionValue(r24, "findViewById(R.id.btn_multi_action)");
        this.multiAction = (OButton) r24;
        applyAttributes(r10, r11);
    }

    public static /* synthetic */ void setDescription$default(OCoachmarkTipView r1, CharSequence r2, Integer r3, TextUtils.TruncateAt r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = null;
    L8:
        r1.setDescription(r2, r3, r4);
    }

    public final void setDescription(CharSequence r3, Integer r4, TextUtils.TruncateAt r5) {
        this.inlineText.setText(r3);
        this.descText.setText(r3);
        if (r4 == null) goto L6;
        int r6 = r4.intValue();
        this.inlineText.setMaxLines(r6);
        this.descText.setMaxLines(r6);
    L6:
        if (r5 == null) goto L9;
        this.inlineText.setEllipsize(r5);
        this.descText.setEllipsize(r5);
    L9:
        if (r3 != null) goto L11;
    L14:
        boolean r7 = true;
    L15:
        if (r7 == false) goto L20;
        L r8 = L.INSTANCE;
        if (r8.isBlocked(8) == true) goto L20;
        r8.getImpl().writeLog(TAG, 8, "Description is empty.", null);
    L20:
        updateLayout();
        return;
    L11:
        if (StringsKt.isBlank(r3) == true) goto L14;
        r7 = false;
        goto L15
    }

    public final void setActionText(CharSequence r2) {
        this.inlineAction.setText(r2);
        this.multiAction.setText(r2);
        updateLayout();
    }

    public final void setDismissText(CharSequence r2) {
        this.multiDismiss.setText(r2);
        updateLayout();
    }

    public final void setIcon(Drawable r2) {
        this.inlineIcon.setImageDrawable(r2);
        this.multiIcon.setImageDrawable(r2);
        updateLayout();
    }

    public final void setOnActionClickListener(View.OnClickListener r2) {
        this.inlineAction.setOnClickListener(r2);
        this.multiAction.setOnClickListener(r2);
    }

    public final void setOnDismissClickListener(View.OnClickListener r2) {
        this.inlineDismiss.setOnClickListener(r2);
        this.multiDismiss.setOnClickListener(r2);
    }

    public final void setShowIcon(boolean r2) {
        if (this.showIcon == r2) goto L6;
        this.showIcon = r2;
        updateLayout();
        return;
    }

    public final void setClosable(boolean r2) {
        if (this.closable == r2) goto L6;
        this.closable = r2;
        updateLayout();
        return;
    }

    public final void setSingleLine(boolean r2) {
        if (this.singleLine == r2) goto L6;
        this.singleLine = r2;
        updateBackground();
        updateLayout();
        return;
    }

    public final void setActionType(ActionType r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        if (this.actionType == r2) goto L6;
        this.actionType = r2;
        updateActionButtonStyle();
        return;
    }

    public final void setPrimaryButtonText(CharSequence r2) {
        this.inlineAction.setText(r2);
        this.multiAction.setText(r2);
        updateLayout();
    }

    public final void setSecondaryButtonText(CharSequence r2) {
        this.multiDismiss.setText(r2);
        updateLayout();
    }

    @Override // android.view.View
    public void setBackgroundColor(int r1) {
        this.backgroundColor = Integer.valueOf(r1);
        updateBackground();
    }

    public final void setCornerRadius(float r1) {
        this.customCornerRadius = Float.valueOf(r1);
        updateBackground();
    }

    private final void updateBackground() {
        Integer r0 = this.backgroundColor;
        if (r0 != null) goto L5;
        int r1 = getContext().getColor(R.color.oui_fill_element_2);
    L7:
        if (this.backgroundColor == null) goto L9;
    L11:
        float r2 = effectiveCornerRadius();
        GradientDrawable r3 = new GradientDrawable();
        r3.setShape(0);
        r3.setColor(r1);
        r3.setCornerRadius(r2);
        setBackground(r3);
        return;
    L9:
        if (this.hasXmlBackground == false) goto L11;
        return;
    L5:
        r1 = r0.intValue();
        goto L7
    }

    private final float effectiveCornerRadius() {
        Float r0 = this.customCornerRadius;
        if (r0 != null) goto L9;
        if (isMultiLine() == false) goto L11;
        return OUnitExtensionKt.vdpFloat(this, 20);
    L11:
        return OUnitExtensionKt.vdpFloat(this, 28);
    L9:
        return r0.floatValue();
    }

    private final boolean isMultiLine() {
        return !this.singleLine;
    }

    private final void applyAttributes(AttributeSet r4, int r5) {
        if (r4 != null) goto L5;
        updateBackground();
        updateLayout();
        return;
    L5:
        TypedArray r6 = getContext().obtainStyledAttributes(r4, R.styleable.OCoachmarkTip, r5, 0);
        this.showIcon = r6.getBoolean(R.styleable.OCoachmarkTip_oui_cmTipShowIcon, true);
        this.closable = r6.getBoolean(R.styleable.OCoachmarkTip_oui_cmTipClosable, false);
        this.singleLine = r6.getBoolean(R.styleable.OCoachmarkTip_oui_cmTipSingleLine, false);
        this.actionType = ActionType.Companion.fromValue(r6.getInt(R.styleable.OCoachmarkTip_oui_cmTipActionType, ActionType.PRIMARY.getValue()));
        this.hasXmlBackground = r6.hasValue(R.styleable.OCoachmarkTip_android_background);
        CharSequence r7 = r6.getText(R.styleable.OCoachmarkTip_android_text);
        if (r7 == null) goto L9;
        this.inlineText.setText(r7);
        this.descText.setText(r7);
    L9:
        String r8 = r6.getString(R.styleable.OCoachmarkTip_oui_cmTipActionText);
        String r9 = r8;
        this.inlineAction.setText(r9);
        this.multiAction.setText(r9);
        String r10 = r6.getString(R.styleable.OCoachmarkTip_oui_cmTipDismissText);
        this.multiDismiss.setText(r10);
        Drawable r11 = r6.getDrawable(R.styleable.OCoachmarkTip_android_src);
        if (r11 == null) goto L13;
        this.inlineIcon.setImageDrawable(r11);
        this.multiIcon.setImageDrawable(r11);
    L13:
        String r12 = r6.getString(R.styleable.OCoachmarkTip_oui_cmTipPrimaryButtonText);
        if (r12 == null) goto L17;
        String r13 = r12;
        this.inlineAction.setText(r13);
        this.multiAction.setText(r13);
    L17:
        String r14 = r6.getString(R.styleable.OCoachmarkTip_oui_cmTipSecondaryButtonText);
        if (r14 == null) goto L22;
        this.multiDismiss.setText(r14);
    L22:
        if (r6.hasValue(R.styleable.OCoachmarkTip_oui_cmTipBackgroundColor) == false) goto L25;
        this.backgroundColor = Integer.valueOf(r6.getColor(R.styleable.OCoachmarkTip_oui_cmTipBackgroundColor, 0));
    L25:
        if (r6.hasValue(R.styleable.OCoachmarkTip_oui_cmTipCornerRadius) == false) goto L27;
        this.customCornerRadius = Float.valueOf(r6.getDimension(R.styleable.OCoachmarkTip_oui_cmTipCornerRadius, 0.0f));
    L27:
        r6.recycle();
        updateBackground();
        updateLayout();
    }

    private final void updateLayout() {
        boolean r0 = isMultiLine();
        ViewExtensionsKt.setVisibility(this.inlineContainer, !r0);
        ViewExtensionsKt.setVisibility(this.multiContainer, r0);
        applyPadding(r0);
        if (r0 == false) goto L5;
        int r1 = 48;
    L6:
        setGravity(r1);
        updateIconVisibility();
        updateInlineActions();
        updateMultiActions();
        updateLeadingVisibility();
        updateActionButtonStyle();
        return;
    L5:
        r1 = 16;
        goto L6
    }

    private final void applyPadding(boolean r6) {
        Pair r0 = TuplesKt.to(Boolean.valueOf(this.showIcon), Boolean.valueOf(r6));
        if (Intrinsics.areEqual(r0, TuplesKt.to(true, true)) == false) goto L6;
        int r1 = OUnitExtensionKt.vdp(this, 16);
    L9:
        if (r6 == false) goto L11;
        OCoachmarkTipView r7 = this;
        setPaddingRelative(r1, OUnitExtensionKt.vdp(r7, 16), OUnitExtensionKt.vdp(r7, 16), OUnitExtensionKt.vdp(r7, 16));
        setMinimumHeight(0);
        return;
    L11:
        OCoachmarkTipView r8 = this;
        setPaddingRelative(r1, OUnitExtensionKt.vdp(r8, 8), OUnitExtensionKt.vdp(r8, 8), OUnitExtensionKt.vdp(r8, 8));
        setMinimumHeight(OUnitExtensionKt.vdp(r8, 48));
        return;
    L6:
        if (Intrinsics.areEqual(r0, TuplesKt.to(true, false)) == false) goto L8;
        r1 = OUnitExtensionKt.vdp(this, 12);
        goto L9
    L8:
        r1 = OUnitExtensionKt.vdp(this, 20);
        goto L9
    }

    private final void updateInlineActions() {
        if (isMultiLine() == false) goto L5;
        return;
    L5:
        CharSequence r0 = this.inlineAction.getText();
        boolean r1 = false;
        if (r0 != null) goto L8;
    L11:
        boolean r2 = true;
    L12:
        boolean r3 = !r2;
        OButton r4 = this.inlineAction;
        if (r3 == true) goto L15;
    L17:
        ViewExtensionsKt.setVisibility(r4, r1);
        ViewExtensionsKt.setVisibility(this.inlineDismiss, this.closable);
        return;
    L15:
        if (this.closable == true) goto L17;
        r1 = true;
        goto L17
    L8:
        if (StringsKt.isBlank(r0) == true) goto L11;
        r2 = false;
        goto L12
    }

    private final void updateMultiActions() {
        if (isMultiLine() == true) goto L5;
        return;
    L5:
        CharSequence r0 = this.multiDismiss.getText();
        int r1 = 0;
        boolean r2 = true;
        if (r0 != null) goto L8;
    L11:
        boolean r3 = true;
    L12:
        boolean r4 = !r3;
        CharSequence r5 = this.multiAction.getText();
        if (r5 != null) goto L15;
    L18:
        boolean r6 = true;
    L19:
        boolean r7 = !r6;
        if (r4 == true) goto L24;
        if (r7 == true) goto L24;
        r2 = false;
    L24:
        ViewExtensionsKt.setVisibility(this.multiActions, r2);
        View r8 = this.multiActions;
        ViewGroup.LayoutParams r9 = r8.getLayoutParams();
        if (r9 == null) goto L40;
        ViewGroup.MarginLayoutParams r10 = (ViewGroup.MarginLayoutParams) r9;
        ViewGroup.MarginLayoutParams r11 = r10;
        if (r2 == false) goto L29;
        int r12 = OUnitExtensionKt.vdp(this, 8);
    L30:
        r11.topMargin = r12;
        r8.setLayoutParams(r10);
        updateMultiLeadingAlignment(r2);
        ViewExtensionsKt.setVisibility(this.multiDismiss, r4);
        ViewExtensionsKt.setVisibility(this.multiAction, r7);
        OButton r13 = this.multiAction;
        ViewGroup.LayoutParams r14 = r13.getLayoutParams();
        if (r14 == null) goto L38;
        ViewGroup.MarginLayoutParams r15 = (ViewGroup.MarginLayoutParams) r14;
        ViewGroup.MarginLayoutParams r16 = r15;
        if (this.multiDismiss.getVisibility() != 0) goto L35;
        r1 = OUnitExtensionKt.vdp(this, 12);
    L35:
        r16.setMarginStart(r1);
        r13.setLayoutParams(r15);
        return;
    L38:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L29:
        r12 = 0;
        goto L30
    L40:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L15:
        if (StringsKt.isBlank(r5) == true) goto L18;
        r6 = false;
        goto L19
    L8:
        if (StringsKt.isBlank(r0) == true) goto L11;
        r3 = false;
        goto L12
    }

    private final void updateMultiLeadingAlignment(boolean r2) {
        if (r2 == false) goto L4;
        int r3 = 48;
    L6:
        if (this.multiLeadingRow.getGravity() == r3) goto L9;
        this.multiLeadingRow.setGravity(r3);
        return;
    L9:
        return;
    L4:
        r3 = 16;
        goto L6
    }

    private final void updateLeadingVisibility() {
        if (isMultiLine() == true) goto L5;
        return;
    L5:
        ViewExtensionsKt.setVisibility(this.multiIcon, this.showIcon);
        View r0 = this.multiTextGroup;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        if (r1 == null) goto L14;
        ViewGroup.MarginLayoutParams r2 = (ViewGroup.MarginLayoutParams) r1;
        ViewGroup.MarginLayoutParams r3 = r2;
        if (this.showIcon == false) goto L10;
        int r4 = OUnitExtensionKt.vdp(this, 8);
    L11:
        r3.setMarginStart(r4);
        r0.setLayoutParams(r2);
        return;
    L10:
        r4 = 0;
        goto L11
    L14:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    private final void updateIconVisibility() {
        boolean r0 = isMultiLine();
        ImageView r1 = this.inlineIcon;
        int r3 = 0;
        if (this.showIcon == false) goto L6;
        if (r0 == true) goto L6;
        boolean r2 = true;
    L7:
        ViewExtensionsKt.setVisibility(r1, r2);
        OTextView r4 = this.inlineText;
        ViewGroup.LayoutParams r5 = r4.getLayoutParams();
        if (r5 == null) goto L16;
        ViewGroup.MarginLayoutParams r6 = (ViewGroup.MarginLayoutParams) r5;
        ViewGroup.MarginLayoutParams r7 = r6;
        if (this.showIcon == false) goto L13;
        if (r0 == true) goto L13;
        r3 = OUnitExtensionKt.vdp(this, 8);
    L13:
        r7.setMarginStart(r3);
        r4.setLayoutParams(r6);
        return;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L6:
        r2 = false;
        goto L7
    }

    private final void updateActionButtonStyle() {
        ActionType r0 = this.actionType;
        int r1 = WhenMappings.$EnumSwitchMapping$0[r0.ordinal()];
        if (r1 != 1) goto L5;
        int r2 = R.color.oui_accent_6_bg;
    L10:
        int r3 = getContext().getColor(r2);
        this.inlineAction.setTextColor(r3);
        this.multiAction.setTextColor(r3);
        return;
    L5:
        if (r1 != 2) goto L8;
        r2 = R.color.oui_basic_text_1;
        goto L10
    L8:
        throw new NoWhenBranchMatchedException();
    }
}
