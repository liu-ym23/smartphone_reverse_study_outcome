package com.obric.oui.common.util;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;

/* JADX INFO: loaded from: classes4.dex */
public class SimpleColorFilter extends PorterDuffColorFilter {
    public SimpleColorFilter(int r2) {
        super(r2, PorterDuff.Mode.SRC_ATOP);
    }
}
