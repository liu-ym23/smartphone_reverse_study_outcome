package com.obric.oui.text;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;
import com.obric.common.oui.R;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class FontConfigurator {
    private static final int DEFAULT_FONT_TYPE = 1;
    private static final boolean DEFAULT_FORCE_EXCLUDE_FONT_PADDING = false;
    private static final boolean DEFAULT_FORCE_INCLUDE_FONT_PADDING = false;
    private static final String TAG = "FontConfigurator";
    private static volatile FontConfigurator sConfigurator;
    private boolean mIsInited;

    private FontConfigurator() {
    }

    public static FontConfigurator getConfigurator() {
        if (sConfigurator != null) goto L15;
        monitor-enter(FontConfigurator.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sConfigurator != null) goto L9;
        sConfigurator = new FontConfigurator();     // Catch: Throwable -> L11
    L9:
        monitor-exit(FontConfigurator.class);     // Catch: Throwable -> L11
    L15:
        return sConfigurator;
    }

    public synchronized void init(Context r3, Map<String, String> r4) {
        monitor-enter(this);
        Log.d(TAG, "init begin.");     // Catch: Throwable -> L12
        this.mIsInited = false;     // Catch: Throwable -> L12
        if (r3 == null) goto L9;
        if (r4 == null) goto L9;
        if (r4.size() <= 0) goto L9;
        FontCache.clear();     // Catch: Throwable -> L12
        FontCache.getInstance().init(r3, r4);     // Catch: Throwable -> L12
        this.mIsInited = true;     // Catch: Throwable -> L12
    L9:
        Log.d(TAG, "init end.");     // Catch: Throwable -> L12
        monitor-exit(this);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public synchronized void configure(TextView r2, AttributeSet r3) {
        monitor-enter(this);
        setParams(r2, r3);     // Catch: Throwable -> L15
        if (r2 != null) goto L6;
    L13:
        monitor-exit(this);
        return;
    L6:
        if (this.mIsInited == false) goto L13;
        int r4 = parseFontTypeAttr(r2, r3);     // Catch: Throwable -> L15
        Typeface r5 = FontCache.getInstance().getTypeface(r4);     // Catch: Throwable -> L15
        if (r5 == null) goto L11;
        r2.setTypeface(r5);     // Catch: Throwable -> L15
    L11:
        monitor-exit(this);
        return;
    L15:
        th = move-exception;
        throw th;
    }

    private void setParams(TextView r3, AttributeSet r4) {
        if (r3 == null) goto L14;
        if (r4 != null) goto L6;
        return;
    L6:
        if (this.mIsInited == false) goto L11;
        if (forceIncludeFontPadding(r3, r4) == false) goto L15;
        r3.setIncludeFontPadding(true);
        return;
    L15:
        return;
    L11:
        if (forceExcludeFontPadding(r3, r4) == true) goto L17;
        r3.setIncludeFontPadding(true);
        return;
    L17:
        return;
    }

    private boolean forceIncludeFontPadding(TextView r2, AttributeSet r3) {
        if (r2 != null) goto L5;
        return false;
    L5:
        if (r3 == null) goto L8;
        TypedArray r4 = r2.getContext().obtainStyledAttributes(r3, R.styleable.OFontConfig);
        boolean r1 = r4.getBoolean(R.styleable.OFontConfig_oui_forceIncludeFontPadding, false);
        r4.recycle();
        return r1;
    L8:
        return false;
    }

    private boolean forceExcludeFontPadding(TextView r2, AttributeSet r3) {
        if (r2 != null) goto L5;
        return false;
    L5:
        if (r3 == null) goto L8;
        TypedArray r4 = r2.getContext().obtainStyledAttributes(r3, R.styleable.OFontConfig);
        boolean r1 = r4.getBoolean(R.styleable.OFontConfig_oui_forceExcludeFontPadding, false);
        r4.recycle();
        return r1;
    L8:
        return false;
    }

    public synchronized void configure(TextView r2, String r3) {
        monitor-enter(this);
        if (r2 != null) goto L17;
    L15:
        monitor-exit(this);
        return;
    L17:
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.mIsInited == false) goto L15;
        Typeface r4 = getTypeface(r3);     // Catch: Throwable -> L12
        if (r4 == null) goto L10;
        r2.setTypeface(r4);     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);
    }

    public synchronized Typeface getTypeface(String r2) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.mIsInited == true) goto L8;
        monitor-exit(this);
        return null;
    L8:
        Typeface r3 = FontCache.getInstance().getTypeface(r2);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r3;
    }

    private static int parseFontTypeAttr(TextView r2, AttributeSet r3) {
        if (r3 == null) goto L6;
        TypedArray r4 = r2.getContext().obtainStyledAttributes(r3, R.styleable.OFontConfig);
        int r0 = r4.getInt(R.styleable.OFontConfig_oui_fontType, 1);
        r4.recycle();
        return r0;
    L6:
        return 1;
    }
}
