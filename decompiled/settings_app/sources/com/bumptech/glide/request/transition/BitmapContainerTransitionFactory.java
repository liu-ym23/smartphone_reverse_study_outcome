package com.bumptech.glide.request.transition;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BitmapContainerTransitionFactory<R> implements TransitionFactory<R> {
    private final TransitionFactory<Drawable> realFactory;

    private final class BitmapGlideAnimation implements Transition<R> {
        final /* synthetic */ BitmapContainerTransitionFactory this$0;
        private final Transition<Drawable> transition;

        BitmapGlideAnimation(BitmapContainerTransitionFactory r1, Transition<Drawable> r2) {
            this.this$0 = r1;
            this.transition = r2;
        }

        @Override // com.bumptech.glide.request.transition.Transition
        public boolean transition(R r4, Transition.ViewAdapter r5) {
            BitmapDrawable r1 = new BitmapDrawable(r5.getView().getResources(), this.this$0.getBitmap(r4));
            return this.transition.transition(r1, r5);
        }
    }

    protected abstract Bitmap getBitmap(R r1);

    public BitmapContainerTransitionFactory(TransitionFactory<Drawable> r1) {
        this.realFactory = r1;
    }

    @Override // com.bumptech.glide.request.transition.TransitionFactory
    public Transition<R> build(DataSource r2, boolean r3) {
        return new BitmapGlideAnimation(this, this.realFactory.build(r2, r3));
    }
}
