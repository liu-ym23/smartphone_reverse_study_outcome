package com.obric.oui.indexscrollbar;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.TextView;
import com.obric.common.oui.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: AlphabetView.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0002¨\u0006\u000b"}, d2 = {"Lcom/obric/oui/indexscrollbar/AlphabetView;", "Landroid/widget/TextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "init", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AlphabetView extends TextView {
    public AlphabetView(Context r7) {
        this(r7, null, 0, 6, null);
    }

    public AlphabetView(Context r7, AttributeSet r8) {
        this(r7, r8, 0, 4, null);
    }

    public /* synthetic */ AlphabetView(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public AlphabetView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        init();
    }

    private final void init() {
        setGravity(17);
        setTextSize(0, getResources().getDimension(R.dimen.bytedance_quickbarex_gridview_font_size));
        setTypeface(null, 1);
        setTextColor(Color.parseColor("#80000000"));
    }
}
