package com.airbnb.lottie;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class TextDelegate {
    private final LottieAnimationView animationView;
    private boolean cacheText;
    private final LottieDrawable drawable;
    private final Map<String, String> stringMap;

    private String getText(String r1) {
        return r1;
    }

    TextDelegate() {
        this.stringMap = new HashMap();
        this.cacheText = true;
        this.animationView = null;
        this.drawable = null;
    }

    public TextDelegate(LottieAnimationView r2) {
        this.stringMap = new HashMap();
        this.cacheText = true;
        this.animationView = r2;
        this.drawable = null;
    }

    public TextDelegate(LottieDrawable r2) {
        this.stringMap = new HashMap();
        this.cacheText = true;
        this.drawable = r2;
        this.animationView = null;
    }

    public void setText(String r2, String r3) {
        this.stringMap.put(r2, r3);
        invalidate();
    }

    public void setCacheText(boolean r1) {
        this.cacheText = r1;
    }

    public void invalidateText(String r2) {
        this.stringMap.remove(r2);
        invalidate();
    }

    public void invalidateAllText() {
        this.stringMap.clear();
        invalidate();
    }

    public final String getTextInternal(String r3) {
        if (this.cacheText == true) goto L5;
    L8:
        String r0 = getText(r3);
        if (this.cacheText == false) goto L11;
        this.stringMap.put(r3, r0);
    L11:
        return r0;
    L5:
        if (this.stringMap.containsKey(r3) == false) goto L8;
        return this.stringMap.get(r3);
    }

    private void invalidate() {
        LottieAnimationView r0 = this.animationView;
        if (r0 == null) goto L5;
        r0.invalidate();
    L5:
        LottieDrawable r1 = this.drawable;
        if (r1 == null) goto L9;
        r1.invalidateSelf();
        return;
    }
}
