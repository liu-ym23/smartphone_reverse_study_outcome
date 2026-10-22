package com.obric.oui.indexscrollbar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.obric.common.oui.R;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.material.MaterialConfigFormatNames;
import com.obric.oui.material.MaterialToken;
import com.obric.oui.material.OMaterialExtBaseKt;
import com.obric.oui.utils.ViewUtilKt;
import com.obric.oui.utils.log.L;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: OIndexPopupWindowController.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 '2\u00020\u0001:\u0001'B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0017J\u001a\u0010\u0018\u001a\u00020\u00152\b\b\u0001\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ8\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u00062\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020\u001aJ\u0012\u0010%\u001a\u00020\u00152\b\b\u0001\u0010&\u001a\u00020\u001aH\u0002R\u0010\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0004\n\u0002\b\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006("}, d2 = {"Lcom/obric/oui/indexscrollbar/OIndexPopupWindowController;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "", "TAG$1", "popupContainerView", "Landroid/view/View;", "popupImageView", "Landroid/widget/ImageView;", "popupTextView", "Landroid/widget/TextView;", "popupWindow", "Landroid/widget/PopupWindow;", "getPopupWindow", "()Landroid/widget/PopupWindow;", "setPopupWindow", "(Landroid/widget/PopupWindow;)V", "hidePopup", "", "isShowing", "", "setStyle", "textColor", "", "background", "Landroid/graphics/drawable/Drawable;", "showPopup", "anchorView", "letter", "bitmap", "Landroid/graphics/Bitmap;", MaterialConfigFormatNames.X, "centerY", "minTop", "updatePopupImageTint", "tintColor", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OIndexPopupWindowController {
    public static final Companion Companion = null;
    public static final float DEFAULT_ELEVATION_DP = 45.0f;
    public static final String TAG = "OIndexPopupWindowLayout";
    private final String TAG$1;
    private final Context context;
    private View popupContainerView;
    private ImageView popupImageView;
    private TextView popupTextView;
    private PopupWindow popupWindow;

    /* JADX INFO: compiled from: OIndexPopupWindowController.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/indexscrollbar/OIndexPopupWindowController$Companion;", "", "()V", "DEFAULT_ELEVATION_DP", "", "TAG", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public OIndexPopupWindowController(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        this.context = r10;
        this.TAG$1 = TAG;
        View r0 = LayoutInflater.from(r10).inflate(R.layout.o_index_scrollbar_popup_circle, null);
        this.popupContainerView = r0.findViewById(R.id.popup_container);
        this.popupImageView = (ImageView) r0.findViewById(R.id.popup_img);
        TextView r1 = (TextView) r0.findViewById(R.id.popup_text);
        this.popupTextView = r1;
        if (r1 == null) goto L6;
        updatePopupImageTint(r1.getCurrentTextColor());
    L6:
        View r2 = this.popupContainerView;
        if ((r2 instanceof OUILinearLayout) == false) goto L13;
        if (r2 == null) goto L13;
        OUILinearLayout r3 = (OUILinearLayout) r2;
        r3.setEnableShadowWidthRadius(true);
        if (OMaterialExtBaseKt.isMaterialEffectEnabled(r10) == false) goto L13;
        GradientDrawable r11 = new GradientDrawable();
        r11.setShape(1);
        r11.setSize(OUnitExtensionKt.vdp(r2, 48), OUnitExtensionKt.vdp(r2, 48));
        r11.setColor(0);
        r3.setBackground(r11);
        r3.setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        OMaterialExtBaseKt.materialsFromWindow$default(r2, MaterialToken.OUI_Bg_Popup.invoke(Boolean.valueOf(!ViewUtilKt.isDarkMode(r2))), false, null, 6, null);
    L13:
        this.popupWindow = new PopupWindow(r0, -2, -2, false);
    }

    public final PopupWindow getPopupWindow() {
        return this.popupWindow;
    }

    public final void setPopupWindow(PopupWindow r1) {
        this.popupWindow = r1;
    }

    public final void setStyle(int r2, Drawable r3) {
        TextView r0 = this.popupTextView;
        if (r0 == null) goto L6;
        r0.setTextColor(r2);
    L6:
        updatePopupImageTint(r2);
        View r1 = this.popupContainerView;
        if (r1 == null) goto L11;
        r1.setBackground(r3);
        return;
    }

    public final void showPopup(View r3, String r4, Bitmap r5, int r6, int r7, int r8) {
        Intrinsics.checkNotNullParameter(r3, "anchorView");
        Intrinsics.checkNotNullParameter(r4, "letter");
        if (r5 != null) goto L16;
        TextView r9 = this.popupTextView;
        if (r9 == null) goto L8;
        r9.setText(r4);
    L8:
        ImageView r10 = this.popupImageView;
        if (r10 == null) goto L12;
        r10.setVisibility(8);
    L12:
        TextView r11 = this.popupTextView;
        if (r11 == null) goto L28;
        r11.setVisibility(0);
    L28:
        PopupWindow r12 = this.popupWindow;
        if (r12 != null) goto L32;
        L.w(this.TAG$1, "showPopup skipped: popupWindow is null.");
        return;
    L32:
        View r13 = r12.getContentView();
        if (r13 != null) goto L37;
        L.w(this.TAG$1, "showPopup skipped: contentView is null.");
        return;
    L37:
        if (r3.isAttachedToWindow() == true) goto L40;
        L.w(this.TAG$1, "showPopup skipped: anchorView is not attached to window.");
        return;
    L40:
        int r2 = RangesKt.coerceAtLeast(r7 - (r13.getMeasuredHeight() / 2), r8);
        if (r12.isShowing() == true) goto L43;
        r12.setElevation(OUnitExtensionKt.vdp(r3, 45.0f));
        r12.showAtLocation(r3, 0, r6, r2);
        r13.setElevation(0.0f);
        return;
    L43:
        r12.update(r6, r2, -2, -2);
        return;
    L16:
        TextView r14 = this.popupTextView;
        if (r14 == null) goto L20;
        r14.setVisibility(8);
    L20:
        ImageView r15 = this.popupImageView;
        if (r15 == null) goto L24;
        r15.setVisibility(0);
    L24:
        ImageView r16 = this.popupImageView;
        if (r16 == null) goto L28;
        r16.setImageBitmap(r5);
        goto L28
    }

    private final void updatePopupImageTint(int r2) {
        ImageView r1 = this.popupImageView;
        if (r1 == null) goto L7;
        r1.setColorFilter(r2, PorterDuff.Mode.SRC_IN);
        return;
    }

    public final void hidePopup() {
        PopupWindow r0 = this.popupWindow;
        boolean r1 = false;
        if (r0 != null) goto L6;
    L8:
        if (r1 == false) goto L14;
        PopupWindow r3 = this.popupWindow;
        if (r3 == null) goto L15;
        r3.dismiss();
        return;
    L15:
        return;
    L14:
        return;
    L6:
        if (r0.isShowing() != true) goto L8;
        r1 = true;
        goto L8
    }

    public final boolean isShowing() {
        PopupWindow r2 = this.popupWindow;
        if (r2 != null) goto L6;
        return false;
    L6:
        if (r2.isShowing() == true) goto L8;
        return false;
    L8:
        return true;
    }
}
