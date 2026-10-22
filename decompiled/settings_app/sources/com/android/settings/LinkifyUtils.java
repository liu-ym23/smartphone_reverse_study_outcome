package com.android.settings;

import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

/* JADX INFO: loaded from: classes2.dex */
public class LinkifyUtils {
    private static final String PLACE_HOLDER_LINK_BEGIN = "LINK_BEGIN";
    private static final String PLACE_HOLDER_LINK_END = "LINK_END";

    public interface OnClickListener {
        void onClick();
    }

    private LinkifyUtils() {
    }

    public static boolean linkify(TextView r4, StringBuilder r5, final OnClickListener r6) {
        int r0 = r5.indexOf(PLACE_HOLDER_LINK_BEGIN);
        if (r0 != (-1)) goto L6;
        r4.setText(r5);
        return false;
    L6:
        r5.delete(r0, r0 + 10);
        int r3 = r5.indexOf(PLACE_HOLDER_LINK_END);
        if (r3 != (-1)) goto L10;
        r4.setText(r5);
        return false;
    L10:
        r5.delete(r3, r3 + 8);
        r4.setText(r5.toString(), TextView.BufferType.SPANNABLE);
        r4.setMovementMethod(LinkMovementMethod.getInstance());
        ((Spannable) r4.getText()).setSpan(new AnonymousClass1(r6), r0, r3, 33);
        return true;
    }
}
