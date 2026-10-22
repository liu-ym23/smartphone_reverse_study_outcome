package com.obric.oui.sheet;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.obric.common.oui.R;
import com.obric.oui.button.OButton;
import com.obric.oui.text.OTextView;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OInsetSheetTitleBar.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\b\u0016\u0018\u0000 j2\u00020\u0001:\u0002jkB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020\u0007J\u0016\u0010G\u001a\u00020 2\u0006\u0010H\u001a\u00020\u00072\u0006\u0010I\u001a\u00020\u0007J\u000e\u0010J\u001a\u00020E2\u0006\u0010F\u001a\u00020\u0007J\u000e\u0010K\u001a\u00020 2\u0006\u0010F\u001a\u00020\u0007J\u000e\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020OJ\u001e\u0010P\u001a\u00020 2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020\u0007J\u0016\u0010T\u001a\u00020 2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010Q\u001a\u00020RJ\u0016\u0010U\u001a\u00020 2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010Q\u001a\u00020RJ\u0016\u0010V\u001a\u00020 2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010Q\u001a\u00020RJ\u0016\u0010W\u001a\u00020 2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010Q\u001a\u00020RJ\u0006\u0010X\u001a\u00020\u0016J\u0010\u0010Y\u001a\u00020M2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010Z\u001a\u00020M2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J0\u0010[\u001a\u00020M2\u0006\u0010\\\u001a\u0002082\u0006\u0010]\u001a\u00020\u00072\u0006\u0010^\u001a\u00020\u00072\u0006\u0010_\u001a\u00020\u00072\u0006\u0010`\u001a\u00020\u0007H\u0014J\u0018\u0010a\u001a\u00020M2\u0006\u0010b\u001a\u00020\u00072\u0006\u0010c\u001a\u00020\u0007H\u0014J\u0006\u0010d\u001a\u00020MJ\u0006\u0010e\u001a\u00020MJ\u000e\u0010f\u001a\u00020M2\u0006\u0010g\u001a\u00020\u0007J\u000e\u0010f\u001a\u00020M2\u0006\u0010h\u001a\u00020\nJ\u0006\u0010i\u001a\u00020MR(\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0001X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0001X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u00020\u0001X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0012\"\u0004\b\u001c\u0010\u0014R\u000e\u0010\u001d\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u00020 X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020&X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u000e\u0010+\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010,\u001a\u00020&X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010(\"\u0004\b.\u0010*R$\u00100\u001a\u00020/2\u0006\u0010\t\u001a\u00020/@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0011\u00105\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b6\u00107R$\u00109\u001a\u0002082\u0006\u0010\t\u001a\u000208@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R(\u0010>\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\r\"\u0004\b@\u0010\u000fR(\u0010A\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\r\"\u0004\bC\u0010\u000f¨\u0006l"}, d2 = {"Lcom/obric/oui/sheet/OInsetSheetTitleBar;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "", "desText", "getDesText", "()Ljava/lang/String;", "setDesText", "(Ljava/lang/String;)V", "mCenterContainer", "getMCenterContainer", "()Landroid/widget/FrameLayout;", "setMCenterContainer", "(Landroid/widget/FrameLayout;)V", "mCenterTitleView", "Landroid/widget/TextView;", "mDesContainerView", "mDesTextView", "Lcom/obric/oui/text/OTextView;", "mFixedCenterContainer", "getMFixedCenterContainer", "setMFixedCenterContainer", "mFixedCenterSubTitleView", "mFixedCenterTitleView", "mLeftActionBack", "Lcom/obric/oui/button/OButton;", "getMLeftActionBack", "()Lcom/obric/oui/button/OButton;", "setMLeftActionBack", "(Lcom/obric/oui/button/OButton;)V", "mLeftContainer", "Landroid/widget/LinearLayout;", "getMLeftContainer", "()Landroid/widget/LinearLayout;", "setMLeftContainer", "(Landroid/widget/LinearLayout;)V", "mLeftTitleView", "mRightContainer", "getMRightContainer", "setMRightContainer", "Lcom/obric/oui/sheet/OInsetSheetTitleBar$TitlePosition;", "mTitlePosition", "getMTitlePosition", "()Lcom/obric/oui/sheet/OInsetSheetTitleBar$TitlePosition;", "setMTitlePosition", "(Lcom/obric/oui/sheet/OInsetSheetTitleBar$TitlePosition;)V", "mTitleView", "getMTitleView", "()Landroid/widget/TextView;", "", "showLeftBack", "getShowLeftBack", "()Z", "setShowLeftBack", "(Z)V", "subTitleText", "getSubTitleText", "setSubTitleText", "titleText", "getTitleText", "setTitleText", "addLeftImageView", "Landroid/widget/ImageView;", "drawableId", "addRightButton", "style", "stringId", "addRightImageView", "addRightTransButton", "addRightView", "", "view", "Landroid/view/View;", "createButton", "root", "Landroid/view/ViewGroup;", "layoutResId", "createNeutralButton", "createPrimaryLightButton", "createTransButton", "createUnderstatedButton", "getTitleView", "init", "initAttrs", "onLayout", "changed", "left", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "removeAllLeftViews", "removeAllRightViews", "setCenterText", "resId", "title", "sheetTitleBarStyle", "Companion", "TitlePosition", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OInsetSheetTitleBar extends FrameLayout {
    public static final Companion Companion = null;
    public static final int STYLE_AREA_ONLY_ICON = 7;
    public static final int STYLE_BACK = 1;
    public static final int STYLE_CUSTOM_BACKGROUND = 9;
    public static final int STYLE_DELETE = 3;
    public static final int STYLE_HIGHLIGHT_BLUE = 4;
    public static final int STYLE_HIGHLIGHT_RED = 5;
    public static final int STYLE_MIX = 10;
    public static final int STYLE_NORMAL = 0;
    public static final int STYLE_NORMAL_WITH_ICON = 6;
    public static final int STYLE_SEARCH = 8;
    public static final int STYLE_SETTING = 2;
    public static final int STYLE_TNT_3_BLUE = 11;
    private String desText;
    public FrameLayout mCenterContainer;
    private TextView mCenterTitleView;
    private FrameLayout mDesContainerView;
    private OTextView mDesTextView;
    public FrameLayout mFixedCenterContainer;
    private TextView mFixedCenterSubTitleView;
    private TextView mFixedCenterTitleView;
    public OButton mLeftActionBack;
    public LinearLayout mLeftContainer;
    private TextView mLeftTitleView;
    public LinearLayout mRightContainer;
    private TitlePosition mTitlePosition;
    private boolean showLeftBack;
    private String subTitleText;
    private String titleText;

    /* JADX INFO: compiled from: OInsetSheetTitleBar.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/oui/sheet/OInsetSheetTitleBar$Companion;", "", "()V", "STYLE_AREA_ONLY_ICON", "", "STYLE_BACK", "STYLE_CUSTOM_BACKGROUND", "STYLE_DELETE", "STYLE_HIGHLIGHT_BLUE", "STYLE_HIGHLIGHT_RED", "STYLE_MIX", "STYLE_NORMAL", "STYLE_NORMAL_WITH_ICON", "STYLE_SEARCH", "STYLE_SETTING", "STYLE_TNT_3_BLUE", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: OInsetSheetTitleBar.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/oui/sheet/OInsetSheetTitleBar$TitlePosition;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "FIXED_CENTER", "FLOW_WITH_ACTION", "LEFT_IN_ACTION", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum TitlePosition extends Enum<TitlePosition> {
        private static final /* synthetic */ TitlePosition[] $VALUES = null;
        public static final TitlePosition FIXED_CENTER = null;
        public static final TitlePosition FLOW_WITH_ACTION = null;
        public static final TitlePosition LEFT_IN_ACTION = null;
        private final int value;

        private static final /* synthetic */ TitlePosition[] $values() {
            return new TitlePosition[]{FIXED_CENTER, FLOW_WITH_ACTION, LEFT_IN_ACTION};
        }

        public static TitlePosition valueOf(String r1) {
            return (TitlePosition) Enum.valueOf(TitlePosition.class, r1);
        }

        public static TitlePosition[] values() {
            return (TitlePosition[]) $VALUES.clone();
        }

        private TitlePosition(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }

        public final int getValue() {
            return this.value;
        }

        static {
            FIXED_CENTER = new TitlePosition("FIXED_CENTER", 0, 0);
            FLOW_WITH_ACTION = new TitlePosition("FLOW_WITH_ACTION", 1, 1);
            LEFT_IN_ACTION = new TitlePosition("LEFT_IN_ACTION", 2, 2);
            $VALUES = $values();
        }
    }

    /* JADX INFO: compiled from: OInsetSheetTitleBar.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[TitlePosition.values().length];
            r0[TitlePosition.FIXED_CENTER.ordinal()] = 1;
            r0[TitlePosition.FLOW_WITH_ACTION.ordinal()] = 2;
            r0[TitlePosition.LEFT_IN_ACTION.ordinal()] = 3;
            $EnumSwitchMapping$0 = r0;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public OInsetSheetTitleBar(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public OInsetSheetTitleBar(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    public /* synthetic */ OInsetSheetTitleBar(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public OInsetSheetTitleBar(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.showLeftBack = true;
        this.mTitlePosition = TitlePosition.FIXED_CENTER;
        init(r2);
        if (r3 == null) goto L6;
        initAttrs(r3);
        return;
    }

    public final LinearLayout getMLeftContainer() {
        LinearLayout r0 = this.mLeftContainer;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mLeftContainer");
        return null;
    }

    public final void setMLeftContainer(LinearLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mLeftContainer = r2;
    }

    public final LinearLayout getMRightContainer() {
        LinearLayout r0 = this.mRightContainer;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mRightContainer");
        return null;
    }

    public final void setMRightContainer(LinearLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mRightContainer = r2;
    }

    public final FrameLayout getMCenterContainer() {
        FrameLayout r0 = this.mCenterContainer;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mCenterContainer");
        return null;
    }

    public final void setMCenterContainer(FrameLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mCenterContainer = r2;
    }

    public final FrameLayout getMFixedCenterContainer() {
        FrameLayout r0 = this.mFixedCenterContainer;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterContainer");
        return null;
    }

    public final void setMFixedCenterContainer(FrameLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mFixedCenterContainer = r2;
    }

    public final OButton getMLeftActionBack() {
        OButton r0 = this.mLeftActionBack;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mLeftActionBack");
        return null;
    }

    public final void setMLeftActionBack(OButton r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mLeftActionBack = r2;
    }

    public final boolean getShowLeftBack() {
        return this.showLeftBack;
    }

    public final void setShowLeftBack(boolean r3) {
        this.showLeftBack = r3;
        OButton r0 = getMLeftActionBack();
        if (r3 == false) goto L5;
        int r4 = 0;
    L6:
        r0.setVisibility(r4);
        if (this.mTitlePosition != TitlePosition.LEFT_IN_ACTION) goto L10;
        getMLeftActionBack().setVisibility(8);
        return;
    L10:
        return;
    L5:
        r4 = 8;
        goto L6
    }

    public final String getSubTitleText() {
        return this.subTitleText;
    }

    public final void setSubTitleText(String r5) {
        this.subTitleText = r5;
        TextView r0 = null;
        if (r5 != null) goto L9;
        TextView r4 = this.mFixedCenterSubTitleView;
        if (r4 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
    L8:
        r0.setVisibility(8);
        return;
    L7:
        r0 = r4;
        goto L8
    L9:
        TextView r2 = this.mFixedCenterSubTitleView;
        if (r2 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
        r2 = null;
    L12:
        r2.setVisibility(0);
        TextView r6 = this.mFixedCenterSubTitleView;
        if (r6 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
    L16:
        r0.setText(r5);
        return;
    L15:
        r0 = r6;
        goto L16
    }

    public final String getTitleText() {
        return this.titleText;
    }

    public final void setTitleText(String r3) {
        this.titleText = r3;
        if (r3 != null) goto L5;
        getMTitleView().setVisibility(4);
        return;
    L5:
        getMTitleView().setVisibility(0);
        getMTitleView().setText(r3);
    }

    public final String getDesText() {
        return this.desText;
    }

    public final void setDesText(String r5) {
        this.desText = r5;
        String r6 = r5;
        if (r6 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        OTextView r3 = null;
        FrameLayout r4 = null;
        if (r1 == false) goto L16;
        FrameLayout r7 = this.mDesContainerView;
        if (r7 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mDesContainerView");
    L15:
        r4.setVisibility(8);
        return;
    L14:
        r4 = r7;
        goto L15
    L16:
        FrameLayout r2 = this.mDesContainerView;
        if (r2 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mDesContainerView");
        r2 = null;
    L19:
        r2.setVisibility(0);
        OTextView r8 = this.mDesTextView;
        if (r8 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mDesTextView");
    L23:
        r3.setText(r6);
        return;
    L22:
        r3 = r8;
        goto L23
    L5:
        if (r6.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public final TextView getMTitleView() {
        TitlePosition r0 = this.mTitlePosition;
        int r1 = WhenMappings.$EnumSwitchMapping$0[r0.ordinal()];
        if (r1 != 1) goto L5;
        TextView r3 = this.mFixedCenterTitleView;
        if (r3 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        return null;
    L20:
        return r3;
    L5:
        if (r1 != 2) goto L7;
        r3 = this.mCenterTitleView;
        if (r3 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mCenterTitleView");
        return null;
    L7:
        if (r1 != 3) goto L12;
        r3 = this.mLeftTitleView;
        if (r3 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftTitleView");
        return null;
    L12:
        throw new NoWhenBranchMatchedException();
    }

    public final TitlePosition getMTitlePosition() {
        return this.mTitlePosition;
    }

    public final void setMTitlePosition(TitlePosition r8) {
        Intrinsics.checkNotNullParameter(r8, "value");
        this.mTitlePosition = r8;
        int r9 = WhenMappings.$EnumSwitchMapping$0[r8.ordinal()];
        TextView r6 = null;
        if (r9 != 1) goto L5;
        TextView r10 = this.mFixedCenterTitleView;
        if (r10 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        r10 = null;
    L34:
        r10.setVisibility(0);
        TextView r11 = this.mCenterTitleView;
        if (r11 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("mCenterTitleView");
        r11 = null;
    L37:
        r11.setVisibility(8);
        TextView r12 = this.mLeftTitleView;
        if (r12 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftTitleView");
    L41:
        r6.setVisibility(8);
    L42:
        getMTitleView().setText(this.titleText);
        return;
    L40:
        r6 = r12;
        goto L41
    L5:
        if (r9 != 2) goto L7;
        TextView r13 = this.mFixedCenterTitleView;
        if (r13 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        r13 = null;
    L23:
        r13.setVisibility(8);
        TextView r14 = this.mCenterTitleView;
        if (r14 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mCenterTitleView");
        r14 = null;
    L26:
        r14.setVisibility(0);
        TextView r15 = this.mLeftTitleView;
        if (r15 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftTitleView");
    L30:
        r6.setVisibility(8);
        goto L42
    L29:
        r6 = r15;
        goto L30
    L7:
        if (r9 != 3) goto L42;
        TextView r16 = this.mFixedCenterTitleView;
        if (r16 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        r16 = null;
    L12:
        r16.setVisibility(8);
        TextView r17 = this.mCenterTitleView;
        if (r17 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mCenterTitleView");
        r17 = null;
    L15:
        r17.setVisibility(8);
        TextView r18 = this.mLeftTitleView;
        if (r18 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftTitleView");
    L19:
        r6.setVisibility(0);
        setShowLeftBack(false);
        goto L42
    L18:
        r6 = r18;
        goto L19
    }

    private final void init(Context r3) {
        FrameLayout.inflate(r3, R.layout.o_sheet_title_bar_container, this);
        View r4 = findViewById(R.id.center_title);
        Intrinsics.checkNotNullExpressionValue(r4, "findViewById(R.id.center_title)");
        this.mCenterTitleView = (TextView) r4;
        View r5 = findViewById(R.id.left_title);
        Intrinsics.checkNotNullExpressionValue(r5, "findViewById(R.id.left_title)");
        this.mLeftTitleView = (TextView) r5;
        View r6 = findViewById(R.id.ll_left_action_container);
        Intrinsics.checkNotNullExpressionValue(r6, "findViewById(R.id.ll_left_action_container)");
        setMLeftContainer((LinearLayout) r6);
        View r7 = findViewById(R.id.ll_right_action_container);
        Intrinsics.checkNotNullExpressionValue(r7, "findViewById(R.id.ll_right_action_container)");
        setMRightContainer((LinearLayout) r7);
        View r8 = findViewById(R.id.fl_center_action_container);
        Intrinsics.checkNotNullExpressionValue(r8, "findViewById(R.id.fl_center_action_container)");
        setMCenterContainer((FrameLayout) r8);
        View r9 = findViewById(R.id.fl_fixed_center_action_container);
        Intrinsics.checkNotNullExpressionValue(r9, "findViewById(R.id.fl_fix…_center_action_container)");
        setMFixedCenterContainer((FrameLayout) r9);
        View r10 = findViewById(R.id.fixed_center_title);
        Intrinsics.checkNotNullExpressionValue(r10, "findViewById(R.id.fixed_center_title)");
        this.mFixedCenterTitleView = (TextView) r10;
        View r11 = findViewById(R.id.left_action_back);
        Intrinsics.checkNotNullExpressionValue(r11, "findViewById(R.id.left_action_back)");
        setMLeftActionBack((OButton) r11);
        View r12 = findViewById(R.id.fixed_center_sub_title);
        Intrinsics.checkNotNullExpressionValue(r12, "findViewById(R.id.fixed_center_sub_title)");
        this.mFixedCenterSubTitleView = (TextView) r12;
        View r13 = findViewById(R.id.sheet_title_bar_des);
        Intrinsics.checkNotNullExpressionValue(r13, "findViewById(R.id.sheet_title_bar_des)");
        this.mDesContainerView = (FrameLayout) r13;
        View r14 = findViewById(R.id.sheet_title_bar_des_text);
        Intrinsics.checkNotNullExpressionValue(r14, "findViewById(R.id.sheet_title_bar_des_text)");
        OTextView r15 = (OTextView) r14;
        this.mDesTextView = r15;
        if (r15 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mDesTextView");
        r15 = null;
    L5:
        r15.setEnableAutoAlignLeft(true);
    }

    private final void initAttrs(AttributeSet r4) {
        TypedArray r5 = getContext().getTheme().obtainStyledAttributes(r4, R.styleable.OCTitleBar, 0, 0);
        int r0 = r5.getInt(R.styleable.OCTitleBar_oui_title_pos, TitlePosition.FIXED_CENTER.getValue());     // Catch: Throwable -> L6
        setMTitlePosition(TitlePosition.values()[r0]);     // Catch: Throwable -> L6
        setTitleText(r5.getString(R.styleable.OCTitleBar_oui_title_text));     // Catch: Throwable -> L6
        setDesText(r5.getString(R.styleable.OCTitleBar_oui_title_des_text));     // Catch: Throwable -> L6
        setShowLeftBack(r5.getBoolean(R.styleable.OCTitleBar_oui_useBackIcon, true));     // Catch: Throwable -> L6
        setSubTitleText(r5.getString(R.styleable.OCTitleBar_oui_sub_title_text));     // Catch: Throwable -> L6
        r5.recycle();
        return;
    L6:
        th = move-exception;
        r5.recycle();
        throw th;
    }

    public final OButton createNeutralButton(Context r1, ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "root");
        return OButton.Companion.createNeutralButton(r1, r2);
    }

    public final OButton createPrimaryLightButton(Context r1, ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "root");
        return OButton.Companion.createPrimaryLightButton(r1, r2);
    }

    public final OButton createTransButton(Context r1, ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "root");
        return OButton.Companion.createTransButton(r1, r2);
    }

    public final OButton createUnderstatedButton(Context r1, ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "root");
        return OButton.Companion.createUnderstatedButton(r1, r2);
    }

    public final OButton createButton(Context r1, ViewGroup r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "root");
        return OButton.Companion.createButton(r1, r2, r3);
    }

    public final ImageView addLeftImageView(int r3) {
        ImageView r0 = new ImageView(getContext());
        r0.setImageResource(r3);
        getMLeftContainer().addView(r0);
        return r0;
    }

    public final ImageView addRightImageView(int r3) {
        ImageView r0 = new ImageView(getContext());
        r0.setImageResource(r3);
        getMRightContainer().addView(r0);
        return r0;
    }

    public final OButton addRightButton(int r3, int r4) {
        if (r3 != 0) goto L5;
        Context r5 = getContext();
        Intrinsics.checkNotNullExpressionValue(r5, "context");
        OButton r2 = createNeutralButton(r5, getMRightContainer());
    L9:
        r2.setText(r4);
        return r2;
    L5:
        if (r3 == 4) goto L7;
        Context r6 = getContext();
        Intrinsics.checkNotNullExpressionValue(r6, "context");
        r2 = createPrimaryLightButton(r6, getMRightContainer());
        goto L9
    L7:
        Context r7 = getContext();
        Intrinsics.checkNotNullExpressionValue(r7, "context");
        r2 = createPrimaryLightButton(r7, getMRightContainer());
        goto L9
    }

    public final OButton addRightTransButton(int r3) {
        Context r0 = getContext();
        Intrinsics.checkNotNullExpressionValue(r0, "context");
        OButton r2 = createTransButton(r0, getMRightContainer());
        r2.setButtonSourceBitmap(r3);
        return r2;
    }

    public final void setCenterText(int r2) {
        String r3 = getResources().getString(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "resources.getString(resId)");
        setTitleText(r3);
    }

    public final void setCenterText(String r2) {
        Intrinsics.checkNotNullParameter(r2, "title");
        setTitleText(r2);
    }

    public final TextView getTitleView() {
        return getMTitleView();
    }

    public final void removeAllLeftViews() {
        getMLeftContainer().removeAllViews();
    }

    public final void addRightView(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        getMRightContainer().addView(r2);
    }

    public final void removeAllRightViews() {
        getMRightContainer().removeAllViews();
    }

    public final void sheetTitleBarStyle() {
        getMTitleView().setTextSize(16.0f);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }
}
