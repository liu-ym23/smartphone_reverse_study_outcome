package com.bumptech.glide.load.resource.drawable;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class UnitDrawableDecoder implements ResourceDecoder<Drawable, Drawable> {
    /* JADX INFO: renamed from: handles, reason: avoid collision after fix types in other method */
    public boolean handles2(Drawable r1, Options r2) {
        return true;
    }

    public UnitDrawableDecoder() {
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public /* bridge */ /* synthetic */ Resource<Drawable> decode(Drawable r1, int r2, int r3, Options r4) throws IOException {
        return decode2(r1, r2, r3, r4);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public /* bridge */ /* synthetic */ boolean handles(Drawable r1, Options r2) throws IOException {
        return handles2(r1, r2);
    }

    /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
    public Resource<Drawable> decode2(Drawable r1, int r2, int r3, Options r4) {
        return NonOwnedDrawableResource.newInstance(r1);
    }
}
