package com.obric.oui.lisitem;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import com.android.settings.search.IndexDatabaseHelper;
import com.obric.common.oui.R;
import com.obric.oui.button.OIconButton;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: OListItemCircleImg.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020*H\u0016J\u0012\u0010+\u001a\u00020*2\b\u0010,\u001a\u0004\u0018\u00010\bH\u0007J\u000e\u0010-\u001a\u00020*2\u0006\u0010.\u001a\u00020/J\u000e\u00100\u001a\u00020*2\u0006\u00101\u001a\u00020!J\u0018\u00102\u001a\u00020*2\u0006\u00103\u001a\u00020(2\b\b\u0002\u00104\u001a\u000205J\u0010\u00106\u001a\u00020*2\b\u0010,\u001a\u0004\u0018\u00010\bR(\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R(\u0010\u0014\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000b\"\u0004\b\u0016\u0010\rR\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001d\u001a\u00020\u001e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R(\u0010\"\u001a\u0004\u0018\u00010!2\b\u0010\u0007\u001a\u0004\u0018\u00010!@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u00067"}, d2 = {"Lcom/obric/oui/lisitem/OListItemCircleImg;", "Lcom/obric/oui/lisitem/OListItemGeneral;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "value", "Landroid/graphics/drawable/Drawable;", "circleImage", "getCircleImage", "()Landroid/graphics/drawable/Drawable;", "setCircleImage", "(Landroid/graphics/drawable/Drawable;)V", "contentImgCircle", "Lcom/obric/oui/button/OIconButton;", "getContentImgCircle", "()Lcom/obric/oui/button/OIconButton;", "setContentImgCircle", "(Lcom/obric/oui/button/OIconButton;)V", "iconImage", "getIconImage", "setIconImage", "ivIcon", "Landroid/widget/ImageView;", "getIvIcon", "()Landroid/widget/ImageView;", "setIvIcon", "(Landroid/widget/ImageView;)V", "settingsTrailingView", "Lcom/obric/oui/lisitem/SettingsTrailingView;", "getSettingsTrailingView", "()Lcom/obric/oui/lisitem/SettingsTrailingView;", "", "trailingTextString", "getTrailingTextString", "()Ljava/lang/String;", "setTrailingTextString", "(Ljava/lang/String;)V", "getContentDefaultOneChildWidth", "", "inflateContent", "", "setImageView", "drawable", "setListItemSettingsEnabled", IndexDatabaseHelper.IndexColumns.ENABLED, "", "setTrailingText", "text", "setTrailingTextMaxLines", "lineCount", "ellipsize", "Landroid/text/TextUtils$TruncateAt;", "showTrailingImageView", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OListItemCircleImg extends OListItemGeneral {
    private Drawable circleImage;
    private OIconButton contentImgCircle;
    private Drawable iconImage;
    private ImageView ivIcon;
    private final SettingsTrailingView settingsTrailingView;
    private String trailingTextString;

    public /* synthetic */ OListItemCircleImg(Context r1, AttributeSet r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public OListItemCircleImg(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        super(r8, r9);
        this.settingsTrailingView = new SettingsTrailingView(r8, null, 0, 6, null);
        View r0 = findViewById(R.id.contentImgCircle);
        Intrinsics.checkNotNullExpressionValue(r0, "findViewById(R.id.contentImgCircle)");
        this.contentImgCircle = (OIconButton) r0;
        View r1 = findViewById(R.id.iv_icon);
        Intrinsics.checkNotNullExpressionValue(r1, "findViewById(R.id.iv_icon)");
        this.ivIcon = (ImageView) r1;
        TypedArray r10 = r8.obtainStyledAttributes(r9, R.styleable.OListItemGeneral);
        setTrailingTextString(r10.getString(R.styleable.OListItemGeneral_oui_list_item_trailing_text));
        r10.recycle();
        if (this.circleImage == null) goto L5;
        this.contentImgCircle.setVisibility(0);
        getMContentElement().setVisibility(0);
        return;
    L5:
        this.contentImgCircle.setVisibility(8);
        getMContentElement().setVisibility(8);
    }

    public final SettingsTrailingView getSettingsTrailingView() {
        return this.settingsTrailingView;
    }

    public final OIconButton getContentImgCircle() {
        return this.contentImgCircle;
    }

    public final void setContentImgCircle(OIconButton r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.contentImgCircle = r2;
    }

    public final ImageView getIvIcon() {
        return this.ivIcon;
    }

    public final void setIvIcon(ImageView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.ivIcon = r2;
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

    public final Drawable getCircleImage() {
        return this.circleImage;
    }

    public final void setCircleImage(Drawable r2) {
        this.circleImage = r2;
        if (r2 == null) goto L5;
        this.contentImgCircle.setImageDrawable(r2);
        this.contentImgCircle.setVisibility(0);
        getMContentElement().setVisibility(0);
    L6:
        updateState();
        return;
    L5:
        this.contentImgCircle.setVisibility(8);
        getMContentElement().setVisibility(8);
        goto L6
    }

    public final Drawable getIconImage() {
        return this.iconImage;
    }

    public final void setIconImage(Drawable r2) {
        this.iconImage = r2;
        if (r2 == null) goto L5;
        this.ivIcon.setImageDrawable(r2);
        this.ivIcon.setVisibility(0);
    L6:
        updateState();
        return;
    L5:
        this.ivIcon.setVisibility(8);
        goto L6
    }

    @Override // com.obric.oui.lisitem.OListItemGeneral
    public void inflateContent() {
        LayoutInflater.from(getContext()).inflate(R.layout.o_listitem_circle_img, this);
    }

    public final void setTrailingText(String r2) {
        Intrinsics.checkNotNullParameter(r2, "text");
        this.settingsTrailingView.setTrailingText(r2);
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

    public static /* synthetic */ void setTrailingTextMaxLines$default(OListItemCircleImg r0, int r1, TextUtils.TruncateAt r2, int r3, Object r4) {
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
        return MathKt.roundToInt(getResources().getDimension(R.dimen.oui_listitem_content_width_large));
    }
}
