package com.obric.oui.dialog.alert;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.dialog.alert.view.IOImageLoadDelegate;
import com.obric.oui.material.MaterialConfigFormatNames;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import obric.widget.calendar.MonthWeekEventsView;

/* JADX INFO: compiled from: ImageStyleController.kt */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated(message = "已废弃, 请用 com/obric/oui/dialog/v2 下面的版本")
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0007\u0018\u0000 /2\u00020\u0001:\u0003/01B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0018\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0018\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010 \u001a\u00020\u0013H\u0002J\u000e\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\nJ\u0010\u0010#\u001a\u00020\u00182\b\b\u0001\u0010$\u001a\u00020\u0005J\u000e\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\u000fJ\u000e\u0010'\u001a\u00020\u00182\u0006\u0010(\u001a\u00020\fJ\u000e\u0010)\u001a\u00020\u00182\u0006\u0010*\u001a\u00020\u0013J\u001f\u0010+\u001a\u00020\u00182\b\u0010\u0016\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010,J\u000e\u0010-\u001a\u00020\u00182\u0006\u0010.\u001a\u00020\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u00058\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\b¨\u00062"}, d2 = {"Lcom/obric/oui/dialog/alert/ImageStyleController;", "Lcom/obric/oui/dialog/alert/StyleController;", "context", "Landroid/content/Context;", "style", "", "(Landroid/content/Context;I)V", MonthWeekEventsView.VIEW_PARAMS_HEIGHT, "Ljava/lang/Integer;", "iconDrawable", "Landroid/graphics/drawable/Drawable;", "iconImageLoadDelegate", "Lcom/obric/oui/dialog/alert/view/IOImageLoadDelegate;", "iconRes", "iconUrl", "", "ignoreFixRatio", "", "imageView", "Landroid/view/View;", "topImageLoader", "Lcom/obric/oui/dialog/alert/OAlertDialogBuilder$IImageLoader;", MaterialConfigFormatNames.WIDTH, "attachBanner", "", "parent", "Landroid/widget/FrameLayout;", "attachIcon", "attachToDialog", "dialog", "Lcom/obric/oui/dialog/alert/OAlertDialog;", "attachToParent", "createImageView", "setImageDrawable", "drawable", "setImageResource", "res", "setImageUrl", "url", "setImageUrlLoadDelegate", "delegate", "setImageView", "view", "setSize", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "setTopImageLoader", "loader", "Companion", "FixRatioLayout", "ImageStyle", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ImageStyleController implements StyleController {
    public static final int BANNER = 1;
    public static final Companion Companion = null;
    public static final int ICON = 0;
    private final Context context;
    private Integer height;
    private Drawable iconDrawable;
    private IOImageLoadDelegate iconImageLoadDelegate;
    private int iconRes;
    private String iconUrl;
    private boolean ignoreFixRatio;
    private View imageView;
    private final int style;
    private OAlertDialogBuilder.IImageLoader topImageLoader;
    private Integer width;

    /* JADX INFO: compiled from: ImageStyleController.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/dialog/alert/ImageStyleController$Companion;", "", "()V", "BANNER", "", "ICON", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: ImageStyleController.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0014¨\u0006\n"}, d2 = {"Lcom/obric/oui/dialog/alert/ImageStyleController$FixRatioLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "onMeasure", "", "widthMeasureSpec", "", "heightMeasureSpec", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class FixRatioLayout extends FrameLayout {
        public FixRatioLayout(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            super(r2);
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int r2, int r3) {
            super.onMeasure(r2, View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(r2) / 2, 1073741824));
        }
    }

    /* JADX INFO: compiled from: ImageStyleController.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/obric/oui/dialog/alert/ImageStyleController$ImageStyle;", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface ImageStyle {
    }

    static {
        Companion = new Companion(null);
    }

    @Override // com.obric.oui.dialog.alert.StyleController
    public void attachToDialog(OAlertDialog r1) {
        Intrinsics.checkNotNullParameter(r1, "dialog");
    }

    public ImageStyleController(Context r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.context = r2;
        this.style = r3;
    }

    public final void setImageResource(int r1) {
        this.iconRes = r1;
    }

    public final void setImageDrawable(Drawable r2) {
        Intrinsics.checkNotNullParameter(r2, "drawable");
        this.iconDrawable = r2;
    }

    public final void setImageUrl(String r2) {
        Intrinsics.checkNotNullParameter(r2, "url");
        this.iconUrl = r2;
    }

    public final void setImageUrlLoadDelegate(IOImageLoadDelegate r2) {
        Intrinsics.checkNotNullParameter(r2, "delegate");
        this.iconImageLoadDelegate = r2;
    }

    public final void setTopImageLoader(OAlertDialogBuilder.IImageLoader r2) {
        Intrinsics.checkNotNullParameter(r2, "loader");
        this.topImageLoader = r2;
    }

    public final void setImageView(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        this.imageView = r2;
    }

    public final void setSize(Integer r1, Integer r2) {
        this.width = r1;
        this.height = r2;
        this.ignoreFixRatio = true;
    }

    @Override // com.obric.oui.dialog.alert.StyleController
    public void attachToParent(Context r2, FrameLayout r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "parent");
        if (this.style != 0) goto L5;
        attachIcon(r2, r3);
        return;
    L5:
        attachBanner(r2, r3);
    }

    private final void attachIcon(Context r5, FrameLayout r6) {
        Integer r1 = this.width;
        int r2 = -2;
        if (r1 == null) goto L5;
        Intrinsics.checkNotNull(r1);
        int r3 = r1.intValue();
    L6:
        Integer r4 = this.height;
        if (r4 == null) goto L9;
        Intrinsics.checkNotNull(r4);
        r2 = r4.intValue();
    L9:
        FrameLayout.LayoutParams r0 = new FrameLayout.LayoutParams(r3, r2);
        r0.gravity = 1;
        r0.topMargin = OUnitExtensionKt.cdp(r5, 28);
        r6.addView(createImageView(), r0);
        return;
    L5:
        r3 = -2;
        goto L6
    }

    private final void attachBanner(Context r5, FrameLayout r6) {
        Integer r1 = this.width;
        if (r1 == null) goto L5;
        Intrinsics.checkNotNull(r1);
        int r2 = r1.intValue();
    L6:
        Integer r3 = this.height;
        if (r3 == null) goto L9;
        Intrinsics.checkNotNull(r3);
        int r4 = r3.intValue();
    L10:
        FrameLayout.LayoutParams r0 = new FrameLayout.LayoutParams(r2, r4);
        if (this.ignoreFixRatio == false) goto L13;
        FixRatioLayout r7 = new FrameLayout(r5);
    L14:
        r7.addView(createImageView(), new FrameLayout.LayoutParams(-1, -1));
        r6.addView(r7, r0);
        return;
    L13:
        r7 = new FixRatioLayout(r5);
        goto L14
    L9:
        r4 = -2;
        goto L10
    L5:
        r2 = -1;
        goto L6
    }

    private final View createImageView() {
        View r0 = this.imageView;
        if (r0 == null) goto L5;
        return r0;
    L5:
        ImageView r1 = new ImageView(this.context);
        r1.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Drawable r2 = this.iconDrawable;
        int r3 = this.iconRes;
        String r4 = this.iconUrl;
        OAlertDialogBuilder.IImageLoader r5 = this.topImageLoader;
        if (r5 == null) goto L10;
        if (r5 == null) goto L27;
        r5.loadTopImg(r1);
    L27:
        return r1;
    L10:
        if (r2 == null) goto L12;
        r1.setImageDrawable(r2);
        goto L27
    L12:
        if (r3 == 0) goto L14;
        r1.setImageResource(r3);
        goto L27
    L14:
        String r6 = r4;
        if (r6 != null) goto L17;
    L20:
        boolean r7 = true;
    L21:
        if (r7 == true) goto L27;
        IOImageLoadDelegate r8 = this.iconImageLoadDelegate;
        if (r8 == null) goto L27;
        r8.load(r1, r4);
        goto L27
    L17:
        if (r6.length() == 0) goto L20;
        r7 = false;
        goto L21
    }
}
