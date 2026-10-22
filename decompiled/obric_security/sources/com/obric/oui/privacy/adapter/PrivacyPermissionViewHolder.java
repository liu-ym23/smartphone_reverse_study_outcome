package com.obric.oui.privacy.adapter;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.obric.common.oui.R;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.privacy.PrivacyItem;
import com.obric.oui.text.OTextView;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PrivacyPermissionViewHolder.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/oui/privacy/adapter/PrivacyPermissionViewHolder;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "cardListItem", "Lcom/obric/oui/lisitem/OCardListItem;", "(Lcom/obric/oui/lisitem/OCardListItem;)V", "contentContainer", "Landroid/widget/LinearLayout;", "bind", "", "item", "Lcom/obric/oui/privacy/PrivacyItem$PermissionItem;", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PrivacyPermissionViewHolder extends RecyclerView.ViewHolder {
    public static final Companion Companion = null;
    private final OCardListItem cardListItem;
    private final LinearLayout contentContainer;

    /* JADX INFO: compiled from: PrivacyPermissionViewHolder.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/privacy/adapter/PrivacyPermissionViewHolder$Companion;", "", "()V", "create", "Lcom/obric/oui/privacy/adapter/PrivacyPermissionViewHolder;", "context", "Landroid/content/Context;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final PrivacyPermissionViewHolder create(Context r7) {
            Intrinsics.checkNotNullParameter(r7, "context");
            OCardListItem r6 = new OCardListItem(r7, null, 0, 6, null);
            r6.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            r6.showIcon(false);
            r6.showDivider(false);
            r6.showCustomEnd(false);
            return new PrivacyPermissionViewHolder(r6);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public PrivacyPermissionViewHolder(OCardListItem r6) {
        Intrinsics.checkNotNullParameter(r6, "cardListItem");
        super(r6);
        this.cardListItem = r6;
        r6.setCardType(2);
        OCardListItem.setCardPosition$default(r6, 0, false, 2, null);
        LinearLayout r0 = new LinearLayout(r6.getContext());
        r0.setOrientation(1);
        r0.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.contentContainer = r0;
        r6.setCustomStartView(r0);
        r6.showCustomStart(true);
    }

    public final void bind(PrivacyItem.PermissionItem r22) {
        Intrinsics.checkNotNullParameter(r22, "item");
        Context r1 = this.cardListItem.getContext();
        this.contentContainer.removeAllViews();
        OTextView r3 = new OTextView(new ContextThemeWrapper(r1, R.style.Body_1_Regular), null, 0, null, 14, null);
        r3.setIncludeFontPadding(true);
        r3.setTextColor(ContextCompat.getColor(r1, R.color.oui_basic_text_1));
        r3.setText(r22.getDescription());
        LinearLayout.LayoutParams r5 = new LinearLayout.LayoutParams(-1, -2);
        Intrinsics.checkNotNullExpressionValue(r1, "context");
        r5.setMargins(OUnitExtensionKt.cdp(r1, 12), OUnitExtensionKt.cdp(r1, 8), OUnitExtensionKt.cdp(r1, 12), OUnitExtensionKt.cdp(r1, 8));
        r3.setLayoutParams(r5);
        this.contentContainer.addView(r3);
        Iterator<T> r2 = r22.getPermissions().iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        String r4 = (String) r2.next();
        LinearLayout r6 = new LinearLayout(r1);
        r6.setOrientation(0);
        r6.setGravity(48);
        r6.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        LinearLayout r9 = new LinearLayout(r1);
        LinearLayout r10 = r9;
        r9.setPadding(OUnitExtensionKt.vdp(r10, 4), OUnitExtensionKt.vdp(r10, 4), 0, 0);
        r9.setGravity(17);
        r9.setLayoutParams(new LinearLayout.LayoutParams(OUnitExtensionKt.vdp(r10, 24), OUnitExtensionKt.vdp(r10, 20)));
        View r12 = new View(r1);
        int r13 = OUnitExtensionKt.vdp(r12, 3.43d);
        r12.setLayoutParams(new LinearLayout.LayoutParams(r13, r13));
        GradientDrawable r14 = new GradientDrawable();
        r14.setShape(1);
        r14.setColor(ContextCompat.getColor(r1, R.color.oui_basic_text_3b));
        r12.setBackground(r14);
        r9.addView(r12);
        r6.addView(r10);
        OTextView r11 = new OTextView(new ContextThemeWrapper(r1, R.style.Subtitle_2_Regular), null, 0, null, 14, null);
        r11.setIncludeFontPadding(true);
        r11.setTextColor(ContextCompat.getColor(r1, R.color.oui_basic_text_3));
        r11.setText(r4);
        r11.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
        OTextView r7 = r11;
        r11.setPadding(0, OUnitExtensionKt.vdp(r7, 4), 0, OUnitExtensionKt.vdp(r7, 4));
        r6.addView(r7);
        this.contentContainer.addView(r6);
        goto L4
    }
}
