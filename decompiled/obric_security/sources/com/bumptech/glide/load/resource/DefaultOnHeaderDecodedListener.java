package com.bumptech.glide.load.resource;

import android.graphics.ColorSpace;
import android.graphics.ImageDecoder;
import android.util.Log;
import android.util.Size;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.PreferredColorSpace;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.load.resource.bitmap.HardwareConfigState;
import com.obric.oui.material.MaterialConfigFormatNames;

/* JADX INFO: loaded from: classes.dex */
public final class DefaultOnHeaderDecodedListener implements ImageDecoder.OnHeaderDecodedListener {
    private static final String TAG = "ImageDecoder";
    private final DecodeFormat decodeFormat;
    private final HardwareConfigState hardwareConfigState;
    private final boolean isHardwareConfigAllowed;
    private final PreferredColorSpace preferredColorSpace;
    private final int requestedHeight;
    private final int requestedWidth;
    private final DownsampleStrategy strategy;

    public DefaultOnHeaderDecodedListener(int r2, int r3, Options r4) {
        this.hardwareConfigState = HardwareConfigState.getInstance();
        this.requestedWidth = r2;
        this.requestedHeight = r3;
        this.decodeFormat = (DecodeFormat) r4.get(Downsampler.DECODE_FORMAT);
        this.strategy = (DownsampleStrategy) r4.get(DownsampleStrategy.OPTION);
        if (r4.get(Downsampler.ALLOW_HARDWARE_CONFIG) != null) goto L5;
    L7:
        boolean r5 = false;
    L8:
        this.isHardwareConfigAllowed = r5;
        this.preferredColorSpace = (PreferredColorSpace) r4.get(Downsampler.PREFERRED_COLOR_SPACE);
        return;
    L5:
        if (((Boolean) r4.get(Downsampler.ALLOW_HARDWARE_CONFIG)).booleanValue() == false) goto L7;
        r5 = true;
        goto L8
    }

    @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
    public void onHeaderDecoded(ImageDecoder r9, ImageDecoder.ImageInfo r10, ImageDecoder.Source r11) {
        boolean r3 = false;
        if (this.hardwareConfigState.isHardwareConfigAllowed(this.requestedWidth, this.requestedHeight, this.isHardwareConfigAllowed, false) == false) goto L5;
        r9.setAllocator(3);
    L7:
        if (this.decodeFormat != DecodeFormat.PREFER_RGB_565) goto L9;
        r9.setMemorySizePolicy(0);
    L9:
        r9.setOnPartialImageListener(new AnonymousClass1(this));
        Size r12 = r10.getSize();
        int r1 = this.requestedWidth;
        if (r1 != Integer.MIN_VALUE) goto L12;
        r1 = r12.getWidth();
    L12:
        int r4 = this.requestedHeight;
        if (r4 != Integer.MIN_VALUE) goto L15;
        r4 = r12.getHeight();
    L15:
        float r2 = this.strategy.getScaleFactor(r12.getWidth(), r12.getHeight(), r1, r4);
        int r5 = Math.round(r12.getWidth() * r2);
        int r6 = Math.round(r12.getHeight() * r2);
        if (Log.isLoggable(TAG, 2) == false) goto L18;
        Log.v(TAG, "Resizing from [" + r12.getWidth() + MaterialConfigFormatNames.X + r12.getHeight() + "] to [" + r5 + MaterialConfigFormatNames.X + r6 + "] scaleFactor: " + r2);
    L18:
        r9.setTargetSize(r5, r6);
        if (this.preferredColorSpace != null) goto L21;
        return;
    L21:
        if (this.preferredColorSpace == PreferredColorSpace.DISPLAY_P3) goto L23;
    L27:
        if (r3 == false) goto L29;
        ColorSpace.Named r8 = ColorSpace.Named.DISPLAY_P3;
    L30:
        r9.setTargetColorSpace(ColorSpace.get(r8));
        return;
    L29:
        r8 = ColorSpace.Named.SRGB;
        goto L30
    L23:
        if (r10.getColorSpace() == null) goto L27;
        if (r10.getColorSpace().isWideGamut() == false) goto L27;
        r3 = true;
        goto L27
    L5:
        r9.setAllocator(1);
        goto L7
    }
}
