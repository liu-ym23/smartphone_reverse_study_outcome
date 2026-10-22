package com.obric.oui;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.UserHandle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.obric.oui.lisitem.OListItemSettings;
import com.obric.security.R;

/* JADX INFO: loaded from: classes3.dex */
public class OuiWidgetUtils {
    public OuiWidgetUtils() {
    }

    public static void initDopplegangerBadge(OListItemSettings view, Drawable drawable, boolean isDoppleganger) {
        view.setContentImage(drawable);
        FrameLayout r3 = view.getMContentElement();
        r3.removeAllViews();
        LinearLayout.LayoutParams r0 = (LinearLayout.LayoutParams) r3.getLayoutParams();
        r0.setMargins(0, 0, 0, 0);
        r3.setLayoutParams(r0);
        FrameLayout r1 = (FrameLayout) View.inflate(r3.getContext(), R.layout.olist_item_icon_with_badge, null);
        r3.addView(r1);
        ((ImageView) r1.findViewById(R.id.iv_content_img)).setImageDrawable(drawable);
        ImageView r4 = (ImageView) r1.findViewById(R.id.iv_doppleganger_icon);
        r4.setImageResource(R.color.transparent);
        if (isDoppleganger == false) goto L6;
        r4.setImageResource(R.drawable.oic_doppleganger_badge);
        return;
    }

    public static Drawable applyDopplegangerBadge(Context context, Drawable baseIcon, boolean isDoppleganger) {
        PackageManager r1 = context.getPackageManager();
        if (isDoppleganger == false) goto L5;
        int r0 = 10;
    L6:
        UserHandle r2 = UserHandle.of(r0);
        if (isDoppleganger == true) goto L9;
        return baseIcon;
    L9:
        return r1.getUserBadgedIcon(baseIcon, r2);
    L5:
        r0 = 0;
        goto L6
    }
}
