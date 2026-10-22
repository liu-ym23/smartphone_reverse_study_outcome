package com.bumptech.glide.load.resource.drawable;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.util.Preconditions;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DrawableResource<T extends Drawable> implements Resource<T>, Initializable {
    protected final T drawable;

    @Override // com.bumptech.glide.load.engine.Resource
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public DrawableResource(T r1) {
        this.drawable = (T) Preconditions.checkNotNull(r1);
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public final T get() {
        Drawable.ConstantState r0 = this.drawable.getConstantState();
        if (r0 != null) goto L7;
        return this.drawable;
    L7:
        return (T) r0.newDrawable();
    }

    public void initialize() {
        T r1 = this.drawable;
        if ((r1 instanceof BitmapDrawable) == false) goto L6;
        ((BitmapDrawable) r1).getBitmap().prepareToDraw();
        return;
    L6:
        if ((r1 instanceof GifDrawable) == false) goto L10;
        ((GifDrawable) r1).getFirstFrame().prepareToDraw();
        return;
    }
}
