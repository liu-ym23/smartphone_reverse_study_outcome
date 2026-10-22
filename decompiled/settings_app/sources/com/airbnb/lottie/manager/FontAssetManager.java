package com.airbnb.lottie.manager;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.airbnb.lottie.FontAssetDelegate;
import com.airbnb.lottie.model.MutablePair;
import com.airbnb.lottie.utils.Logger;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class FontAssetManager {
    private final AssetManager assetManager;
    private String defaultFontFileExtension;
    private FontAssetDelegate delegate;
    private final Map<String, Typeface> fontFamilies;
    private final Map<MutablePair<String>, Typeface> fontMap;
    private final MutablePair<String> tempPair;

    public FontAssetManager(Drawable.Callback r2, FontAssetDelegate r3) {
        this.tempPair = new MutablePair();
        this.fontMap = new HashMap();
        this.fontFamilies = new HashMap();
        this.defaultFontFileExtension = ".ttf";
        this.delegate = r3;
        if ((r2 instanceof View) == true) goto L6;
        Logger.warning("LottieDrawable must be inside of a view for images to work.");
        this.assetManager = null;
        return;
    L6:
        this.assetManager = ((View) r2).getContext().getAssets();
    }

    public void setDelegate(FontAssetDelegate r1) {
        this.delegate = r1;
    }

    public void setDefaultFontFileExtension(String r1) {
        this.defaultFontFileExtension = r1;
    }

    public Typeface getTypeface(String r3, String r4) {
        this.tempPair.set(r3, r4);
        Typeface r0 = this.fontMap.get(this.tempPair);
        if (r0 == null) goto L5;
        return r0;
    L5:
        Typeface r5 = typefaceForStyle(getFontFamily(r3), r4);
        this.fontMap.put(this.tempPair, r5);
        return r5;
    }

    private Typeface getFontFamily(String r3) {
        Typeface r0 = this.fontFamilies.get(r3);
        if (r0 == null) goto L5;
        return r0;
    L5:
        FontAssetDelegate r1 = this.delegate;
        if (r1 == null) goto L8;
        Typeface r2 = r1.fetchFont(r3);
    L9:
        FontAssetDelegate r4 = this.delegate;
        if (r4 == null) goto L15;
        if (r2 != null) goto L15;
        String r5 = r4.getFontPath(r3);
        if (r5 == null) goto L15;
        r2 = Typeface.createFromAsset(this.assetManager, r5);
    L15:
        if (r2 != null) goto L17;
        r2 = Typeface.createFromAsset(this.assetManager, "fonts/" + r3 + this.defaultFontFileExtension);
    L17:
        this.fontFamilies.put(r3, r2);
        return r2;
    L8:
        r2 = null;
        goto L9
    }

    private Typeface typefaceForStyle(Typeface r2, String r3) {
        boolean r1 = r3.contains("Italic");
        boolean r4 = r3.contains("Bold");
        if (r1 == false) goto L6;
        if (r4 == false) goto L6;
        int r5 = 3;
    L12:
        if (r2.getStyle() != r5) goto L15;
        return r2;
    L15:
        return Typeface.create(r2, r5);
    L6:
        if (r1 == false) goto L8;
        r5 = 2;
        goto L12
    L8:
        if (r4 == false) goto L10;
        r5 = 1;
        goto L12
    L10:
        r5 = 0;
        goto L12
    }
}
