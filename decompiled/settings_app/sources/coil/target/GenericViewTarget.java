package coil.target;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import coil.transition.TransitionTarget;
import kotlin.Metadata;

/* JADX INFO: compiled from: GenericViewTarget.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\u00020\u00042\u00020\u0005B\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u0012\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\bH\u0016J\b\u0010\u0019\u001a\u00020\u0010H\u0004J\u0012\u0010\u001a\u001a\u00020\u00102\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0004R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\bX¦\u000e¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcoil/target/GenericViewTarget;", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/view/View;", "Lcoil/target/ViewTarget;", "Lcoil/transition/TransitionTarget;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "()V", "drawable", "Landroid/graphics/drawable/Drawable;", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "setDrawable", "(Landroid/graphics/drawable/Drawable;)V", "isStarted", "", "onError", "", "error", "onStart", "placeholder", "owner", "Landroidx/lifecycle/LifecycleOwner;", "onStop", "onSuccess", "result", "updateAnimation", "updateDrawable", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class GenericViewTarget<T extends View> implements ViewTarget<T>, TransitionTarget, DefaultLifecycleObserver {
    private boolean isStarted;

    @Override // coil.transition.TransitionTarget
    public abstract Drawable getDrawable();

    public abstract void setDrawable(Drawable r1);

    public GenericViewTarget() {
    }

    @Override // coil.target.Target
    public void onStart(Drawable r1) {
        updateDrawable(r1);
    }

    @Override // coil.target.Target
    public void onError(Drawable r1) {
        updateDrawable(r1);
    }

    @Override // coil.target.Target
    public void onSuccess(Drawable r1) {
        updateDrawable(r1);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onStart(LifecycleOwner r1) {
        this.isStarted = true;
        updateAnimation();
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onStop(LifecycleOwner r1) {
        this.isStarted = false;
        updateAnimation();
    }

    protected final void updateDrawable(Drawable r3) {
        Object r0 = getDrawable();
        if ((r0 instanceof Animatable) == false) goto L5;
        Animatable r1 = (Animatable) r0;
    L6:
        if (r1 == null) goto L8;
        r1.stop();
    L8:
        setDrawable(r3);
        updateAnimation();
        return;
    L5:
        r1 = null;
        goto L6
    }

    protected final void updateAnimation() {
        Object r0 = getDrawable();
        if ((r0 instanceof Animatable) == false) goto L5;
        Animatable r1 = (Animatable) r0;
    L6:
        if (r1 != null) goto L9;
        return;
    L9:
        if (this.isStarted == false) goto L11;
        r1.start();
        return;
    L11:
        r1.stop();
        return;
    L5:
        r1 = null;
        goto L6
    }
}
