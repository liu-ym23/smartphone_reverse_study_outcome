package com.obric.oui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.obric.oui.button.OButton;
import com.obric.security.R;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OCustomTitleBar.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\"\b\u0016\u0018\u0000 j2\u00020\u0001:\u0002jkB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020\u0007J\u000e\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020JJ\u0016\u0010K\u001a\u00020\u001c2\u0006\u0010L\u001a\u00020\u00072\u0006\u0010M\u001a\u00020\u0007J\u000e\u0010N\u001a\u00020E2\u0006\u0010F\u001a\u00020\u0007J\u000e\u0010O\u001a\u00020\u001c2\u0006\u0010F\u001a\u00020\u0007J\u000e\u0010P\u001a\u00020H2\u0006\u0010I\u001a\u00020JJ\u001e\u0010Q\u001a\u00020\u001c2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010R\u001a\u00020\n2\u0006\u0010S\u001a\u00020\u0007J\u0016\u0010T\u001a\u00020\u001c2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010R\u001a\u00020\nJ\u0016\u0010U\u001a\u00020\u001c2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010R\u001a\u00020\nJ\u0016\u0010V\u001a\u00020\u001c2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010R\u001a\u00020\nJ\u0016\u0010W\u001a\u00020\u001c2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010R\u001a\u00020\nJ\u0016\u0010X\u001a\u00020\u001c2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010R\u001a\u00020\nJ\u0006\u0010Y\u001a\u00020\u0015J\u0010\u0010Z\u001a\u00020H2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010[\u001a\u00020H2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J0\u0010\\\u001a\u00020H2\u0006\u0010]\u001a\u0002052\u0006\u0010^\u001a\u00020\u00072\u0006\u0010_\u001a\u00020\u00072\u0006\u0010`\u001a\u00020\u00072\u0006\u0010a\u001a\u00020\u0007H\u0014J\u0018\u0010b\u001a\u00020H2\u0006\u0010c\u001a\u00020\u00072\u0006\u0010d\u001a\u00020\u0007H\u0014J\u0006\u0010e\u001a\u00020HJ\u0006\u0010f\u001a\u00020HJ\u000e\u0010g\u001a\u00020H2\u0006\u0010h\u001a\u00020\u0007J\u000e\u0010g\u001a\u00020H2\u0006\u0010i\u001a\u00020;R\u001a\u0010\t\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0001X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\u0001X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0011\"\u0004\b\u0018\u0010\u0013R\u000e\u0010\u0019\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u00020\u001cX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\"X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u000e\u0010'\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010(\u001a\u00020\"X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010$\"\u0004\b*\u0010&R$\u0010-\u001a\u00020,2\u0006\u0010+\u001a\u00020,@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0011\u00102\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b3\u00104R$\u00106\u001a\u0002052\u0006\u0010+\u001a\u000205@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R(\u0010<\u001a\u0004\u0018\u00010;2\b\u0010+\u001a\u0004\u0018\u00010;@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R(\u0010A\u001a\u0004\u0018\u00010;2\b\u0010+\u001a\u0004\u0018\u00010;@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010>\"\u0004\bC\u0010@¨\u0006l"}, d2 = {"Lcom/obric/oui/OCustomTitleBar;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "fixedCenterTitleContainer", "Landroid/view/ViewGroup;", "getFixedCenterTitleContainer", "()Landroid/view/ViewGroup;", "setFixedCenterTitleContainer", "(Landroid/view/ViewGroup;)V", "mCenterContainer", "getMCenterContainer", "()Landroid/widget/FrameLayout;", "setMCenterContainer", "(Landroid/widget/FrameLayout;)V", "mCenterTitleView", "Landroid/widget/TextView;", "mFixedCenterContainer", "getMFixedCenterContainer", "setMFixedCenterContainer", "mFixedCenterSubTitleView", "mFixedCenterTitleView", "mLeftActionBack", "Lcom/obric/oui/button/OButton;", "getMLeftActionBack", "()Lcom/obric/oui/button/OButton;", "setMLeftActionBack", "(Lcom/obric/oui/button/OButton;)V", "mLeftContainer", "Landroid/widget/LinearLayout;", "getMLeftContainer", "()Landroid/widget/LinearLayout;", "setMLeftContainer", "(Landroid/widget/LinearLayout;)V", "mLeftTitleView", "mRightContainer", "getMRightContainer", "setMRightContainer", "value", "Lcom/obric/oui/OCustomTitleBar$TitlePosition;", "mTitlePosition", "getMTitlePosition", "()Lcom/obric/oui/OCustomTitleBar$TitlePosition;", "setMTitlePosition", "(Lcom/obric/oui/OCustomTitleBar$TitlePosition;)V", "mTitleView", "getMTitleView", "()Landroid/widget/TextView;", "", "showLeftBack", "getShowLeftBack", "()Z", "setShowLeftBack", "(Z)V", "", "subTitleText", "getSubTitleText", "()Ljava/lang/String;", "setSubTitleText", "(Ljava/lang/String;)V", "titleText", "getTitleText", "setTitleText", "addLeftImageView", "Landroid/widget/ImageView;", "drawableId", "addLeftView", "", "view", "Landroid/view/View;", "addRightButton", "style", "stringId", "addRightImageView", "addRightTransButton", "addRightView", "createButton", "root", "layoutResId", "createNeutralButton", "createPrimaryButton", "createPrimaryLightButton", "createTransButton", "createTransIconButton", "getTitleView", "init", "initAttrs", "onLayout", "changed", "left", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "removeAllLeftViews", "removeAllRightViews", "setCenterText", "resId", "title", "Companion", "TitlePosition", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public class OCustomTitleBar extends FrameLayout {
    public static final Companion Companion = null;
    public static final int STYLE_HIGHLIGHT_BLUE = 1;
    public static final int STYLE_NORMAL = 0;
    public static final int STYLE_PRIMARY_BLUE = 2;
    private HashMap _$_findViewCache;
    public ViewGroup fixedCenterTitleContainer;
    public FrameLayout mCenterContainer;
    private TextView mCenterTitleView;
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

    /* JADX INFO: compiled from: OCustomTitleBar.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/OCustomTitleBar$Companion;", "", "()V", "STYLE_HIGHLIGHT_BLUE", "", "STYLE_NORMAL", "STYLE_PRIMARY_BLUE", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    /* JADX INFO: compiled from: OCustomTitleBar.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/oui/OCustomTitleBar$TitlePosition;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "FIXED_CENTER", "FLOW_WITH_ACTION", "LEFT_IN_ACTION", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum TitlePosition extends Enum<TitlePosition> {
        private static final /* synthetic */ TitlePosition[] $VALUES = null;
        public static final TitlePosition FIXED_CENTER = null;
        public static final TitlePosition FLOW_WITH_ACTION = null;
        public static final TitlePosition LEFT_IN_ACTION = null;
        private final int value;

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
            TitlePosition r1 = new TitlePosition("FIXED_CENTER", 0, 0);
            FIXED_CENTER = r1;
            TitlePosition r2 = new TitlePosition("FLOW_WITH_ACTION", 1, 1);
            FLOW_WITH_ACTION = r2;
            TitlePosition r3 = new TitlePosition("LEFT_IN_ACTION", 2, 2);
            LEFT_IN_ACTION = r3;
            $VALUES = new TitlePosition[]{r1, r2, r3};
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1 = null;

        static {
            int[] r0 = new int[TitlePosition.values().length];
            $EnumSwitchMapping$0 = r0;
            r0[TitlePosition.FIXED_CENTER.ordinal()] = 1;
            r0[TitlePosition.FLOW_WITH_ACTION.ordinal()] = 2;
            r0[TitlePosition.LEFT_IN_ACTION.ordinal()] = 3;
            int[] r1 = new int[TitlePosition.values().length];
            $EnumSwitchMapping$1 = r1;
            r1[TitlePosition.FIXED_CENTER.ordinal()] = 1;
            r1[TitlePosition.FLOW_WITH_ACTION.ordinal()] = 2;
            r1[TitlePosition.LEFT_IN_ACTION.ordinal()] = 3;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public OCustomTitleBar(Context r7) {
        this(r7, null, 0, 6, null);
    }

    public OCustomTitleBar(Context r7, AttributeSet r8) {
        this(r7, r8, 0, 4, null);
    }

    public void _$_clearFindViewByIdCache() {
        HashMap r0 = this._$_findViewCache;
        if (r0 == null) goto L6;
        r0.clear();
        return;
    }

    public View _$_findCachedViewById(int r3) {
        if (this._$_findViewCache != null) goto L5;
        this._$_findViewCache = new HashMap();
    L5:
        View r0 = (View) this._$_findViewCache.get(Integer.valueOf(r3));
        if (r0 != null) goto L9;
        View r1 = findViewById(r3);
        this._$_findViewCache.put(Integer.valueOf(r3), r1);
        return r1;
    L9:
        return r0;
    }

    public /* synthetic */ OCustomTitleBar(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
        AttributeSet r6 = (AttributeSet) null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public OCustomTitleBar(Context r2, AttributeSet r3, int r4) {
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
        LinearLayout r1 = this.mLeftContainer;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftContainer");
    L5:
        return r1;
    }

    public final void setMLeftContainer(LinearLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mLeftContainer = r2;
    }

    public final LinearLayout getMRightContainer() {
        LinearLayout r1 = this.mRightContainer;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mRightContainer");
    L5:
        return r1;
    }

    public final void setMRightContainer(LinearLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mRightContainer = r2;
    }

    public final FrameLayout getMCenterContainer() {
        FrameLayout r1 = this.mCenterContainer;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mCenterContainer");
    L5:
        return r1;
    }

    public final void setMCenterContainer(FrameLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mCenterContainer = r2;
    }

    public final FrameLayout getMFixedCenterContainer() {
        FrameLayout r1 = this.mFixedCenterContainer;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterContainer");
    L5:
        return r1;
    }

    public final void setMFixedCenterContainer(FrameLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mFixedCenterContainer = r2;
    }

    public final ViewGroup getFixedCenterTitleContainer() {
        ViewGroup r1 = this.fixedCenterTitleContainer;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("fixedCenterTitleContainer");
    L5:
        return r1;
    }

    public final void setFixedCenterTitleContainer(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.fixedCenterTitleContainer = r2;
    }

    public final OButton getMLeftActionBack() {
        OButton r1 = this.mLeftActionBack;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftActionBack");
    L5:
        return r1;
    }

    public final void setMLeftActionBack(OButton r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mLeftActionBack = r2;
    }

    public final boolean getShowLeftBack() {
        return this.showLeftBack;
    }

    public final void setShowLeftBack(boolean r4) {
        this.showLeftBack = r4;
        OButton r0 = this.mLeftActionBack;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftActionBack");
    L6:
        if (r4 == false) goto L8;
        int r5 = 0;
    L9:
        r0.setVisibility(r5);
        if (this.mTitlePosition != TitlePosition.LEFT_IN_ACTION) goto L16;
        OButton r3 = this.mLeftActionBack;
        if (r3 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftActionBack");
    L14:
        r3.setVisibility(8);
        return;
    L16:
        return;
    L8:
        r5 = 8;
        goto L9
    }

    public final String getSubTitleText() {
        return this.subTitleText;
    }

    public final void setSubTitleText(String r4) {
        this.subTitleText = r4;
        if (r4 != null) goto L8;
        TextView r3 = this.mFixedCenterSubTitleView;
        if (r3 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
    L7:
        r3.setVisibility(8);
        return;
    L8:
        TextView r1 = this.mFixedCenterSubTitleView;
        if (r1 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
    L11:
        r1.setVisibility(0);
        TextView r5 = this.mFixedCenterSubTitleView;
        if (r5 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
    L14:
        r5.setText(r4);
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

    public final TextView getMTitleView() {
        TitlePosition r0 = this.mTitlePosition;
        int r1 = WhenMappings.$EnumSwitchMapping$0[r0.ordinal()];
        if (r1 != 1) goto L5;
        TextView r2 = this.mFixedCenterTitleView;
        if (r2 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
    L19:
        return r2;
    L5:
        if (r1 != 2) goto L7;
        r2 = this.mCenterTitleView;
        if (r2 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mCenterTitleView");
        goto L19
    L7:
        if (r1 != 3) goto L12;
        r2 = this.mLeftTitleView;
        if (r2 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftTitleView");
        goto L19
    L12:
        throw new NoWhenBranchMatchedException();
    }

    public final TitlePosition getMTitlePosition() {
        return this.mTitlePosition;
    }

    public final void setMTitlePosition(TitlePosition r7) {
        Intrinsics.checkNotNullParameter(r7, "value");
        this.mTitlePosition = r7;
        int r8 = WhenMappings.$EnumSwitchMapping$1[r7.ordinal()];
        if (r8 != 1) goto L5;
        TextView r9 = this.mFixedCenterTitleView;
        if (r9 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
    L32:
        r9.setVisibility(0);
        TextView r10 = this.mCenterTitleView;
        if (r10 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("mCenterTitleView");
    L35:
        r10.setVisibility(8);
        TextView r11 = this.mLeftTitleView;
        if (r11 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftTitleView");
    L38:
        r11.setVisibility(8);
    L39:
        getMTitleView().setText(this.titleText);
        return;
    L5:
        if (r8 != 2) goto L7;
        TextView r12 = this.mFixedCenterTitleView;
        if (r12 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
    L22:
        r12.setVisibility(8);
        TextView r13 = this.mCenterTitleView;
        if (r13 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("mCenterTitleView");
    L25:
        r13.setVisibility(0);
        TextView r14 = this.mLeftTitleView;
        if (r14 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftTitleView");
    L28:
        r14.setVisibility(8);
        goto L39
    L7:
        if (r8 != 3) goto L39;
        TextView r15 = this.mFixedCenterTitleView;
        if (r15 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
    L12:
        r15.setVisibility(8);
        TextView r16 = this.mCenterTitleView;
        if (r16 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mCenterTitleView");
    L15:
        r16.setVisibility(8);
        TextView r17 = this.mLeftTitleView;
        if (r17 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftTitleView");
    L18:
        r17.setVisibility(0);
        setShowLeftBack(false);
        goto L39
    }

    private final void init(Context r3) {
        FrameLayout.inflate(r3, R.layout.o_title_bar_container2, this);
        View r4 = findViewById(R.id.center_title);
        Intrinsics.checkNotNull(r4);
        this.mCenterTitleView = (TextView) r4;
        View r5 = findViewById(R.id.left_title);
        Intrinsics.checkNotNull(r5);
        this.mLeftTitleView = (TextView) r5;
        View r6 = findViewById(R.id.ll_left_action_container);
        Intrinsics.checkNotNull(r6);
        this.mLeftContainer = (LinearLayout) r6;
        View r7 = findViewById(R.id.ll_right_action_container);
        Intrinsics.checkNotNull(r7);
        this.mRightContainer = (LinearLayout) r7;
        View r8 = findViewById(R.id.fl_center_action_container);
        Intrinsics.checkNotNull(r8);
        this.mCenterContainer = (FrameLayout) r8;
        View r9 = findViewById(R.id.fl_fixed_center_action_container);
        Intrinsics.checkNotNull(r9);
        this.mFixedCenterContainer = (FrameLayout) r9;
        View r10 = findViewById(R.id.fixed_center_title);
        Intrinsics.checkNotNull(r10);
        this.mFixedCenterTitleView = (TextView) r10;
        View r11 = findViewById(R.id.left_action_back);
        Intrinsics.checkNotNull(r11);
        this.mLeftActionBack = (OButton) r11;
        View r12 = findViewById(R.id.fixed_center_sub_title);
        Intrinsics.checkNotNull(r12);
        this.mFixedCenterSubTitleView = (TextView) r12;
        View r13 = findViewById(R.id.fixed_center_title_container);
        Intrinsics.checkNotNull(r13);
        this.fixedCenterTitleContainer = (ViewGroup) r13;
    }

    private final void initAttrs(AttributeSet r4) {
        Context r0 = getContext();
        Intrinsics.checkNotNullExpressionValue(r0, "context");
        TypedArray r5 = r0.getTheme().obtainStyledAttributes(r4, R.styleable.OCTitleBar, 0, 0);
        int r1 = r5.getInt(3, TitlePosition.FIXED_CENTER.getValue());     // Catch: Throwable -> L6
        setMTitlePosition(TitlePosition.values()[r1]);     // Catch: Throwable -> L6
        setTitleText(r5.getString(4));     // Catch: Throwable -> L6
        setShowLeftBack(r5.getBoolean(5, true));     // Catch: Throwable -> L6
        setSubTitleText(r5.getString(1));     // Catch: Throwable -> L6
        r5.recycle();
        return;
    L6:
        th = move-exception;
        r5.recycle();
        throw th;
    }

    public final OButton createNeutralButton(Context r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "root");
        return createButton(r2, r3, R.layout.o_widget_titlebar_button_neutral);
    }

    public final OButton createPrimaryLightButton(Context r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "root");
        return createButton(r2, r3, R.layout.o_widget_titlebar_primarylight_button);
    }

    public final OButton createTransButton(Context r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "root");
        return createButton(r2, r3, R.layout.o_widget_titlebar_trans_button);
    }

    public final OButton createTransIconButton(Context r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "root");
        return createButton(r2, r3, R.layout.o_widget_titlebar_trans_icon_button);
    }

    public final OButton createPrimaryButton(Context r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "root");
        return createButton(r2, r3, R.layout.o_widget_titlebar_primary_button);
    }

    public final OButton createButton(Context r2, ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "root");
        if (((OButton) r3.findViewById(R.id.btn_titlebar)) != null) goto L5;
        View r1 = FrameLayout.inflate(r2, r4, r3).findViewById(R.id.btn_titlebar);
        Intrinsics.checkNotNull(r1);
        return (OButton) r1;
    L5:
        View r5 = LayoutInflater.from(r2).inflate(r4, r3, false);
        if (r5 == null) goto L10;
        OButton r6 = (OButton) r5;
        r6.setId(-1);
        r3.addView(r6);
        return r6;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.button.OButton");
    }

    public final ImageView addLeftImageView(int r3) {
        ImageView r0 = new ImageView(getContext());
        r0.setImageResource(r3);
        LinearLayout r2 = this.mLeftContainer;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftContainer");
    L5:
        r2.addView(r0);
        return r0;
    }

    public final ImageView addRightImageView(int r3) {
        ImageView r0 = new ImageView(getContext());
        r0.setImageResource(r3);
        LinearLayout r2 = this.mRightContainer;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mRightContainer");
    L5:
        r2.addView(r0);
        return r0;
    }

    public final OButton addRightButton(int r4, int r5) {
        if (r4 != 0) goto L5;
        Context r6 = getContext();
        Intrinsics.checkNotNullExpressionValue(r6, "context");
        LinearLayout r1 = this.mRightContainer;
        if (r1 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mRightContainer");
    L23:
        OButton r3 = createNeutralButton(r6, r1);
    L24:
        r3.setText(r5);
        return r3;
    L5:
        if (r4 != 1) goto L7;
        Context r7 = getContext();
        Intrinsics.checkNotNullExpressionValue(r7, "context");
        LinearLayout r2 = this.mRightContainer;
        if (r2 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mRightContainer");
    L19:
        r3 = createPrimaryLightButton(r7, r2);
        goto L24
    L7:
        if (r4 == 2) goto L12;
        Context r8 = getContext();
        Intrinsics.checkNotNullExpressionValue(r8, "context");
        LinearLayout r9 = this.mRightContainer;
        if (r9 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mRightContainer");
    L11:
        r3 = createPrimaryLightButton(r8, r9);
        goto L24
    L12:
        Context r10 = getContext();
        Intrinsics.checkNotNullExpressionValue(r10, "context");
        LinearLayout r11 = this.mRightContainer;
        if (r11 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mRightContainer");
    L15:
        r3 = createPrimaryButton(r10, r11);
        goto L24
    }

    public final OButton addRightTransButton(int r4) {
        Context r0 = getContext();
        Intrinsics.checkNotNullExpressionValue(r0, "context");
        LinearLayout r1 = this.mRightContainer;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mRightContainer");
    L5:
        OButton r3 = createTransButton(r0, r1);
        r3.setButtonSourceBitmap(r4);
        return r3;
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
        LinearLayout r1 = this.mLeftContainer;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftContainer");
    L5:
        r1.removeAllViews();
    }

    public final void addLeftView(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        LinearLayout r1 = this.mLeftContainer;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftContainer");
    L5:
        r1.addView(r2);
    }

    public final void addRightView(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        LinearLayout r1 = this.mRightContainer;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mRightContainer");
    L5:
        r1.addView(r2);
    }

    public final void removeAllRightViews() {
        LinearLayout r1 = this.mRightContainer;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mRightContainer");
    L5:
        r1.removeAllViews();
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
