package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Preconditions;

/* JADX INFO: loaded from: classes3.dex */
public final class LazyBitmapDrawableResource implements Resource<BitmapDrawable>, Initializable {
    private final Resource<Bitmap> bitmapResource;
    private final Resources resources;

    @Override // com.bumptech.glide.load.engine.Resource
    public /* bridge */ /* synthetic */ BitmapDrawable get() {
        return get();
    }

    @Deprecated
    public static LazyBitmapDrawableResource obtain(Context r1, Bitmap r2) {
        return (LazyBitmapDrawableResource) obtain(r1.getResources(), BitmapResource.obtain(r2, Glide.get(r1).getBitmapPool()));
    }

    @Deprecated
    public static LazyBitmapDrawableResource obtain(Resources r0, BitmapPool r1, Bitmap r2) {
        return (LazyBitmapDrawableResource) obtain(r0, BitmapResource.obtain(r2, r1));
    }

    public static Resource<BitmapDrawable> obtain(Resources r1, Resource<Bitmap> r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        return new LazyBitmapDrawableResource(r1, r2);
    }

    private LazyBitmapDrawableResource(Resources r1, Resource<Bitmap> r2) {
        this.resources = (Resources) Preconditions.checkNotNull(r1);
        this.bitmapResource = (Resource) Preconditions.checkNotNull(r2);
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public Class<BitmapDrawable> getResourceClass() {
        return BitmapDrawable.class;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.load.engine.Resource
    public BitmapDrawable get() {
        return new BitmapDrawable(this.resources, this.bitmapResource.get());
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public int getSize() {
        return this.bitmapResource.getSize();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public void recycle() {
        this.bitmapResource.recycle();
    }

    @Override // com.bumptech.glide.load.engine.Initializable
    public void initialize() {
        Resource<Bitmap> r1 = this.bitmapResource;
        if ((r1 instanceof Initializable) == false) goto L6;
        ((Initializable) r1).initialize();
        return;
    }
}
