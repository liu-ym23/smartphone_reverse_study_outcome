package com.obric.oui.lisitem;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.android.settings.search.IndexDatabaseHelper;
import com.obric.common.oui.R;
import com.obric.oui.layout.OUIFrameLayout;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OListItemSettings.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010$\u001a\u00020\bH\u0016J\b\u0010%\u001a\u00020&H\u0016J\u0012\u0010'\u001a\u00020&2\b\u0010(\u001a\u0004\u0018\u00010)H\u0007J\u000e\u0010*\u001a\u00020&2\u0006\u0010+\u001a\u00020\u0010J\u000e\u0010,\u001a\u00020&2\u0006\u0010-\u001a\u00020.J\u000e\u0010/\u001a\u00020&2\u0006\u00100\u001a\u00020\u001eJ\u0018\u00101\u001a\u00020&2\u0006\u00102\u001a\u00020\b2\b\b\u0002\u00103\u001a\u000204J\u000e\u00105\u001a\u00020&2\u0006\u00106\u001a\u00020\bJ\u0010\u00107\u001a\u00020&2\b\u0010(\u001a\u0004\u0018\u00010)R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0019\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR(\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u00068"}, d2 = {"Lcom/obric/oui/lisitem/OListItemSettings;", "Lcom/obric/oui/lisitem/OListItemGeneral;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "contentIconWidth", "", "contentImgBackground", "Lcom/obric/oui/layout/OUIFrameLayout;", "getContentImgBackground", "()Lcom/obric/oui/layout/OUIFrameLayout;", "setContentImgBackground", "(Lcom/obric/oui/layout/OUIFrameLayout;)V", "heightMode", "Lcom/obric/oui/lisitem/ListItemHeightMode;", "mTitleInfo", "Landroid/widget/FrameLayout;", "getMTitleInfo", "()Landroid/widget/FrameLayout;", "setMTitleInfo", "(Landroid/widget/FrameLayout;)V", "rootLayout", "Landroid/view/ViewGroup;", "settingsTrailingView", "Lcom/obric/oui/lisitem/SettingsTrailingView;", "getSettingsTrailingView", "()Lcom/obric/oui/lisitem/SettingsTrailingView;", "value", "", "trailingTextString", "getTrailingTextString", "()Ljava/lang/String;", "setTrailingTextString", "(Ljava/lang/String;)V", "getContentDefaultOneChildWidth", "inflateContent", "", "setImageView", "drawable", "Landroid/graphics/drawable/Drawable;", "setListItemHeightMode", "mode", "setListItemSettingsEnabled", IndexDatabaseHelper.IndexColumns.ENABLED, "", "setTrailingText", "text", "setTrailingTextMaxLines", "lineCount", "ellipsize", "Landroid/text/TextUtils$TruncateAt;", "setTrailingViewMinWidth", "minWidth", "showTrailingImageView", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OListItemSettings extends OListItemGeneral {
    private int contentIconWidth;
    public OUIFrameLayout contentImgBackground;
    private ListItemHeightMode heightMode;
    public FrameLayout mTitleInfo;
    private final ViewGroup rootLayout;
    private final SettingsTrailingView settingsTrailingView;
    private String trailingTextString;

    /* JADX INFO: compiled from: OListItemSettings.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[ListItemHeightMode.values().length];
            r0[ListItemHeightMode.DEFAULT.ordinal()] = 1;
            r0[ListItemHeightMode.COMPACT.ordinal()] = 2;
            $EnumSwitchMapping$0 = r0;
        }
    }

    public /* synthetic */ OListItemSettings(Context r1, AttributeSet r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public OListItemSettings(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        super(r8, r9);
        this.contentIconWidth = r8.getResources().getDimensionPixelSize(R.dimen.oui_listitem_content_width_large);
        this.heightMode = ListItemHeightMode.DEFAULT;
        View r0 = findViewById(R.id.ll_root);
        Intrinsics.checkNotNullExpressionValue(r0, "findViewById(R.id.ll_root)");
        this.rootLayout = (ViewGroup) r0;
        this.settingsTrailingView = new SettingsTrailingView(r8, null, 0, 6, null);
        View r1 = findViewById(R.id.title_info);
        Intrinsics.checkNotNullExpressionValue(r1, "findViewById(R.id.title_info)");
        setMTitleInfo((FrameLayout) r1);
        View r2 = findViewById(R.id.iv_content_img_background);
        Intrinsics.checkNotNullExpressionValue(r2, "findViewById(R.id.iv_content_img_background)");
        setContentImgBackground((OUIFrameLayout) r2);
        TypedArray r10 = r8.obtainStyledAttributes(r9, R.styleable.OListItemGeneral);
        setTrailingTextString(r10.getString(R.styleable.OListItemGeneral_oui_list_item_trailing_text));
        r10.recycle();
        if (getContentImage() == null) goto L6;
        getContentImgBackground().setVisibility(0);
        return;
    }

    public final SettingsTrailingView getSettingsTrailingView() {
        return this.settingsTrailingView;
    }

    public final FrameLayout getMTitleInfo() {
        FrameLayout r0 = this.mTitleInfo;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mTitleInfo");
        return null;
    }

    public final void setMTitleInfo(FrameLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mTitleInfo = r2;
    }

    public final OUIFrameLayout getContentImgBackground() {
        OUIFrameLayout r0 = this.contentImgBackground;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("contentImgBackground");
        return null;
    }

    public final void setContentImgBackground(OUIFrameLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.contentImgBackground = r2;
    }

    public final String getTrailingTextString() {
        return this.trailingTextString;
    }

    public final void setTrailingTextString(String r1) {
        this.trailingTextString = r1;
        updateState();
        String r2 = this.trailingTextString;
        if (r2 == null) goto L6;
        setTrailingText(r2);
    L6:
        setTrailingView(this.settingsTrailingView);
    }

    @Override // com.obric.oui.lisitem.OListItemGeneral
    public void inflateContent() {
        LayoutInflater.from(getContext()).inflate(R.layout.o_listitem_settings, this);
    }

    public final void setTrailingText(String r2) {
        Intrinsics.checkNotNullParameter(r2, "text");
        this.settingsTrailingView.setTrailingText(r2);
    }

    public final void setTrailingViewMinWidth(int r3) {
        ViewGroup.LayoutParams r0 = getMTrailingElement().getLayoutParams();
        if ((r0 instanceof ConstraintLayout.LayoutParams) == false) goto L6;
        FrameLayout r2 = getMTrailingElement();
        ((ConstraintLayout.LayoutParams) r0).matchConstraintMinWidth = r3;
        r2.setLayoutParams(r0);
        return;
    }

    @Deprecated(message = "use showTrailingImageView instead", replaceWith = @ReplaceWith(expression = "showTrailingImageView(drawable)", imports = {}))
    public final void setImageView(Drawable r1) {
        this.settingsTrailingView.setTrailingImage(r1);
    }

    public final void showTrailingImageView(Drawable r3) {
        if (r3 != null) goto L4;
        this.settingsTrailingView.showTrailingImageView(false);
        return;
    L4:
        this.settingsTrailingView.showTrailingImageView(true);
        this.settingsTrailingView.setTrailingImage(r3);
    }

    public static /* synthetic */ void setTrailingTextMaxLines$default(OListItemSettings r0, int r1, TextUtils.TruncateAt r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L6;
        r2 = TextUtils.TruncateAt.END;
    L6:
        r0.setTrailingTextMaxLines(r1, r2);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setTrailingTextMaxLines");
    }

    public final void setTrailingTextMaxLines(int r2, TextUtils.TruncateAt r3) {
        Intrinsics.checkNotNullParameter(r3, "ellipsize");
        this.settingsTrailingView.getTextView().setMaxLines(r2);
        this.settingsTrailingView.getTextView().setEllipsize(r3);
    }

    public final void setListItemSettingsEnabled(boolean r2) {
        setChangeAlphaWhenDisable(false);
        setEnabled(r2);
        if (r2 == false) goto L5;
        getMLeadingElement().setAlpha(1.0f);
        getMClContent().setAlpha(1.0f);
        getMContentElement().setAlpha(1.0f);
        return;
    L5:
        getMLeadingElement().setAlpha(0.3f);
        getMClContent().setAlpha(0.3f);
        getMContentElement().setAlpha(0.3f);
    }

    @Override // com.obric.oui.lisitem.OListItemGeneral
    public int getContentDefaultOneChildWidth() {
        return this.contentIconWidth;
    }

    public final void setListItemHeightMode(ListItemHeightMode r6) {
        Intrinsics.checkNotNullParameter(r6, "mode");
        if (this.heightMode != r6) goto L5;
        return;
    L5:
        int r0 = WhenMappings.$EnumSwitchMapping$0[r6.ordinal()];
        if (r0 != 1) goto L8;
        int r1 = getResources().getDimensionPixelSize(R.dimen.oui_listitem_content_width_large);
    L13:
        this.rootLayout.setMinimumHeight(r1);
        getMClContent().setMinimumHeight(r1);
        getMClContent().setMinHeight(r1);
        ViewGroup.LayoutParams r2 = getMTrailingElement().getLayoutParams();
        if (r2 != null) goto L17;
    L21:
        this.contentIconWidth = r1;
        updateState();
        this.heightMode = r6;
        return;
    L17:
        if ((r2 instanceof ConstraintLayout.LayoutParams) == false) goto L21;
        int r3 = (r1 - getMClContent().getPaddingTop()) - getMClContent().getPaddingBottom();
        ConstraintLayout.LayoutParams r4 = (ConstraintLayout.LayoutParams) r2;
        if (r3 >= r4.matchConstraintMinHeight) goto L21;
        FrameLayout r5 = getMTrailingElement();
        r4.matchConstraintMinHeight = r3;
        r5.setLayoutParams(r2);
        goto L21
    L8:
        if (r0 != 2) goto L11;
        r1 = getResources().getDimensionPixelSize(R.dimen.oui_listitem_content_width_middle);
        goto L13
    L11:
        throw new NoWhenBranchMatchedException();
    }
}
