package com.android.settings.applications.manageapplications;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.android.settings.R;
import com.obric.oui.lisitem.OListItemGeneral;

/* JADX INFO: loaded from: classes2.dex */
public class OuiWidgetUtils {
    public OuiWidgetUtils() {
    }

    public static void initDopplegangerBadge(OListItemGeneral r3, Drawable r4, boolean r5) {
        r3.setContentImage(r4);
        FrameLayout r6 = r3.getMContentElement();
        r6.removeAllViews();
        LinearLayout.LayoutParams r0 = (LinearLayout.LayoutParams) r6.getLayoutParams();
        r0.setMargins(0, 0, 0, 0);
        r6.setLayoutParams(r0);
        FrameLayout r1 = (FrameLayout) View.inflate(r6.getContext(), R.layout.olist_item_icon_with_badge, null);
        r6.addView(r1);
        ((ImageView) r1.findViewById(R.id.iv_content_img)).setImageDrawable(r4);
        ImageView r7 = (ImageView) r1.findViewById(R.id.iv_doppleganger_icon);
        r7.setImageResource(R.color.transparent);
        if (r5 == false) goto L6;
        r7.setImageResource(R.drawable.settings_oic_doppleganger_badge);
        return;
    }

    public static void initRoundedIcon56(OListItemGeneral r2, Drawable r3, boolean r4) {
        r2.setContentImage(r3);
        FrameLayout r5 = r2.getMContentElement();
        r5.removeAllViews();
        LinearLayout.LayoutParams r6 = (LinearLayout.LayoutParams) r5.getLayoutParams();
        r6.setMargins(0, 0, 0, 0);
        r5.setLayoutParams(r6);
        FrameLayout r7 = (FrameLayout) View.inflate(r5.getContext(), R.layout.olist_item_icon_56, null);
        r5.addView(r7);
        ((ImageView) r7.findViewById(R.id.iv_content_img)).setImageDrawable(r3);
    }
}
