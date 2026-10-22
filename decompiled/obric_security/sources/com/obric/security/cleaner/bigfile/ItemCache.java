package com.obric.security.cleaner.bigfile;

import android.graphics.drawable.Drawable;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public interface ItemCache {
    List<String> getFilePath();

    long getID();

    Drawable getIcon();

    String getName(Locale locale);

    String getNote();

    String getPackage();

    long getProcessedSize();

    long getRemainSize();

    long getSize();

    void setProcessedSize(long processedSize);

    void setRemainSize(long remainSize);
}
