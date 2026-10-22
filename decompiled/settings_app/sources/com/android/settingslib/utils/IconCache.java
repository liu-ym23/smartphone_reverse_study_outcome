package com.android.settingslib.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import androidx.collection.ArrayMap;

/* JADX INFO: loaded from: classes.dex */
public class IconCache {
    private final Context mContext;
    final ArrayMap<Icon, Drawable> mMap;

    public IconCache(Context r2) {
        this.mMap = new ArrayMap();
        this.mContext = r2;
    }

    public Drawable getIcon(Icon r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        Drawable r0 = this.mMap.get(r2);
        if (r0 != null) goto L9;
        Drawable r1 = r2.loadDrawable(this.mContext);
        updateIcon(r2, r1);
        return r1;
    L9:
        return r0;
    }

    public void updateIcon(Icon r1, Drawable r2) {
        this.mMap.put(r1, r2);
    }
}
