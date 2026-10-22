package com.obric.oui.tab.optimize;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.obric.common.oui.R;
import com.obric.oui.material.MaterialConfigFormatNames;
import com.obric.oui.utils.log.L;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OBottomTabItem.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 (2\u00020\u0001:\u0001(B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0002J&\u0010#\u001a\u00020 2\b\b\u0002\u0010$\u001a\u00020\b2\b\b\u0002\u0010%\u001a\u00020\b2\b\b\u0002\u0010&\u001a\u00020\bH\u0007J\u0010\u0010'\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0015\"\u0004\b\u001e\u0010\u0017¨\u0006)"}, d2 = {"Lcom/obric/oui/tab/optimize/OBottomTabItem;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defaultSelectTextColor", "", "defaultTextColor", "icon", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "iconContainer", "Landroid/widget/FrameLayout;", "selectBgColor", "selectedBg", "Landroid/graphics/drawable/Drawable;", "selectedIconDrawable", "getSelectedIconDrawable", "()Landroid/graphics/drawable/Drawable;", "setSelectedIconDrawable", "(Landroid/graphics/drawable/Drawable;)V", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "unselectedIconDrawable", "getUnselectedIconDrawable", "setUnselectedIconDrawable", "refreshIconDrawableOnSelect", "", MaterialConfigFormatNames.SELECTED, "", "setImageAndTextTintColor", "selectedColor", "unSelectedColor", "bgColor", "setSelected", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OBottomTabItem extends RelativeLayout {
    public static final Companion Companion = null;
    private static final String TAG = "optimize.OBottomTabItem";
    private final int defaultSelectTextColor;
    private final int defaultTextColor;
    private final ImageView icon;
    private final FrameLayout iconContainer;
    private int selectBgColor;
    private Drawable selectedBg;
    private Drawable selectedIconDrawable;
    private final TextView title;
    private Drawable unselectedIconDrawable;

    /* JADX INFO: compiled from: OBottomTabItem.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/tab/optimize/OBottomTabItem$Companion;", "", "()V", "TAG", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
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

    /* JADX WARN: Multi-variable type inference failed */
    public OBottomTabItem(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, null, 2, 0 == true ? 1 : 0);
    }

    public final void setImageAndTextTintColor() {
        setImageAndTextTintColor$default(this, 0, 0, 0, 7, null);
    }

    public final void setImageAndTextTintColor(int r7) {
        setImageAndTextTintColor$default(this, r7, 0, 0, 6, null);
    }

    public final void setImageAndTextTintColor(int r7, int r8) {
        setImageAndTextTintColor$default(this, r7, r8, 0, 4, null);
    }

    public /* synthetic */ OBottomTabItem(Context r1, AttributeSet r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public OBottomTabItem(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setClickable(false);
        setFocusable(false);
        LayoutInflater.from(r3).inflate(R.layout.o_tab_bottom_item, this, true);
        View r5 = findViewById(R.id.icon_container);
        Intrinsics.checkNotNullExpressionValue(r5, "findViewById(R.id.icon_container)");
        this.iconContainer = (FrameLayout) r5;
        View r6 = findViewById(R.id.icon);
        Intrinsics.checkNotNullExpressionValue(r6, "findViewById(R.id.icon)");
        this.icon = (ImageView) r6;
        View r7 = findViewById(R.id.title);
        Intrinsics.checkNotNullExpressionValue(r7, "findViewById(R.id.title)");
        this.title = (TextView) r7;
        int r8 = ContextCompat.getColor(getContext(), R.color.oui_accent_fg);
        this.defaultSelectTextColor = r8;
        int r9 = ContextCompat.getColor(getContext(), R.color.oui_text_3b);
        this.defaultTextColor = r9;
        int r0 = ContextCompat.getColor(getContext(), R.color.oui_accent_bg_low_contrast);
        this.selectBgColor = r0;
        setImageAndTextTintColor(r8, r9, r0);
    }

    public final ImageView getIcon() {
        return this.icon;
    }

    public final TextView getTitle() {
        return this.title;
    }

    public static /* synthetic */ void setImageAndTextTintColor$default(OBottomTabItem r0, int r1, int r2, int r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = ContextCompat.getColor(r0.getContext(), R.color.oui_accent_fg);
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = ContextCompat.getColor(r0.getContext(), R.color.oui_text_3b);
    L9:
        if ((r4 & 4) == 0) goto L11;
        r3 = ContextCompat.getColor(r0.getContext(), R.color.oui_accent_bg_low_contrast);
    L11:
        r0.setImageAndTextTintColor(r1, r2, r3);
    }

    public final void setImageAndTextTintColor(int r8, int r9, int r10) {
        ColorStateList r0 = new ColorStateList(new int[][]{new int[]{android.R.attr.state_selected}, new int[0]}, new int[]{r8, r9});
        this.selectedBg = null;
        this.selectBgColor = r10;
        this.icon.setImageTintList(r0);
        this.title.setTextColor(r0);
    }

    @Override // android.view.View
    public void setSelected(boolean r1) {
        super.setSelected(r1);
        refreshIconDrawableOnSelect(r1);
        if (r1 == false) goto L5;
        this.title.setTextAppearance(R.style.Label_S_Thick);
        return;
    L5:
        this.title.setTextAppearance(R.style.Label_S);
    }

    public final Drawable getSelectedIconDrawable() {
        return this.selectedIconDrawable;
    }

    public final void setSelectedIconDrawable(Drawable r1) {
        this.selectedIconDrawable = r1;
    }

    public final Drawable getUnselectedIconDrawable() {
        return this.unselectedIconDrawable;
    }

    public final void setUnselectedIconDrawable(Drawable r1) {
        this.unselectedIconDrawable = r1;
    }

    private final void refreshIconDrawableOnSelect(boolean r3) {
        Drawable r0 = this.selectedIconDrawable;
        if (r0 == null) goto L11;
        Drawable r1 = this.unselectedIconDrawable;
        if (r1 == null) goto L11;
        if (r3 == false) goto L9;
        this.icon.setImageDrawable(r0);
        return;
    L9:
        this.icon.setImageDrawable(r1);
        return;
    L11:
        L.w(TAG, "please set selectedIconDrawable and unselectedIconDrawable");
    }
}
