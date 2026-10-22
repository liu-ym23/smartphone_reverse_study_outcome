package androidx.core.view;

import android.graphics.Rect;
import android.util.Log;
import android.view.DisplayCutout;
import android.view.WindowInsets;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.Insets;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class WindowInsetsCompat {

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final WindowInsetsCompat CONSUMED = null;
    private static final String TAG = "WindowInsetsCompat";
    private final Impl mImpl;

    public static final class Builder {
        private final BuilderImpl mImpl;

        public Builder() {
            this.mImpl = new BuilderImpl29();
        }

        @NonNull
        public WindowInsetsCompat build() {
            return this.mImpl.build();
        }

        @NonNull
        public Builder setDisplayCutout(@Nullable DisplayCutoutCompat r2) {
            this.mImpl.setDisplayCutout(r2);
            return this;
        }

        @NonNull
        public Builder setMandatorySystemGestureInsets(@NonNull Insets r2) {
            this.mImpl.setMandatorySystemGestureInsets(r2);
            return this;
        }

        @NonNull
        public Builder setStableInsets(@NonNull Insets r2) {
            this.mImpl.setStableInsets(r2);
            return this;
        }

        @NonNull
        public Builder setSystemGestureInsets(@NonNull Insets r2) {
            this.mImpl.setSystemGestureInsets(r2);
            return this;
        }

        @NonNull
        public Builder setSystemWindowInsets(@NonNull Insets r2) {
            this.mImpl.setSystemWindowInsets(r2);
            return this;
        }

        @NonNull
        public Builder setTappableElementInsets(@NonNull Insets r2) {
            this.mImpl.setTappableElementInsets(r2);
            return this;
        }

        public Builder(@NonNull WindowInsetsCompat r2) {
            this.mImpl = new BuilderImpl29(r2);
        }
    }

    public static class BuilderImpl {
        private final WindowInsetsCompat mInsets;

        public BuilderImpl() {
            this(new WindowInsetsCompat(null));
        }

        @NonNull
        public WindowInsetsCompat build() {
            return this.mInsets;
        }

        public void setDisplayCutout(@Nullable DisplayCutoutCompat r1) {
        }

        public void setMandatorySystemGestureInsets(@NonNull Insets r1) {
        }

        public void setStableInsets(@NonNull Insets r1) {
        }

        public void setSystemGestureInsets(@NonNull Insets r1) {
        }

        public void setSystemWindowInsets(@NonNull Insets r1) {
        }

        public void setTappableElementInsets(@NonNull Insets r1) {
        }

        public BuilderImpl(@NonNull WindowInsetsCompat r1) {
            this.mInsets = r1;
        }
    }

    @RequiresApi(api = 20)
    public static class BuilderImpl20 extends BuilderImpl {
        private static Constructor<WindowInsets> sConstructor = null;
        private static boolean sConstructorFetched = false;
        private static Field sConsumedField = null;
        private static boolean sConsumedFieldFetched = false;
        private WindowInsets mInsets;

        public BuilderImpl20() {
            this.mInsets = createWindowInsetsInstance();
        }

        @Nullable
        private static WindowInsets createWindowInsetsInstance() {
            if (sConsumedFieldFetched == false) goto L33;
        L9:
            Field r0 = sConsumedField;
            if (r0 == null) goto L18;
            WindowInsets r1 = (WindowInsets) r0.get(null);     // Catch: ReflectiveOperationException -> L15
            if (r1 == null) goto L18;
            return new WindowInsets(r1);
        L15:
            e = move-exception;
            Log.i(WindowInsetsCompat.TAG, "Could not get value from WindowInsets.CONSUMED field", e);
        L18:
            if (sConstructorFetched == false) goto L31;
        L24:
            Constructor<WindowInsets> r2 = sConstructor;
            if (r2 != null) goto L35;
        L30:
            return null;
        L35:
            return r2.newInstance(new Object[]{new Rect()});
        L28:
            e = move-exception;
            Log.i(WindowInsetsCompat.TAG, "Could not invoke WindowInsets(Rect) constructor", e);
            goto L30
        L31:
            sConstructor = WindowInsets.class.getConstructor(new Class[]{Rect.class});     // Catch: ReflectiveOperationException -> L21
        L23:
            sConstructorFetched = true;
        L21:
            e = move-exception;
            Log.i(WindowInsetsCompat.TAG, "Could not retrieve WindowInsets(Rect) constructor", e);
            goto L23
        L33:
            sConsumedField = WindowInsets.class.getDeclaredField("CONSUMED");     // Catch: ReflectiveOperationException -> L6
        L8:
            sConsumedFieldFetched = true;
        L6:
            e = move-exception;
            Log.i(WindowInsetsCompat.TAG, "Could not retrieve WindowInsets.CONSUMED field", e);
            goto L8
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        @NonNull
        public WindowInsetsCompat build() {
            return WindowInsetsCompat.toWindowInsetsCompat(this.mInsets);
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public void setSystemWindowInsets(@NonNull Insets r5) {
            WindowInsets r0 = this.mInsets;
            if (r0 == null) goto L6;
            this.mInsets = r0.replaceSystemWindowInsets(r5.left, r5.top, r5.right, r5.bottom);
            return;
        }

        public BuilderImpl20(@NonNull WindowInsetsCompat r1) {
            this.mInsets = r1.toWindowInsets();
        }
    }

    @RequiresApi(api = 29)
    public static class BuilderImpl29 extends BuilderImpl {
        final WindowInsets.Builder mPlatBuilder;

        public BuilderImpl29() {
            this.mPlatBuilder = new WindowInsets.Builder();
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        @NonNull
        public WindowInsetsCompat build() {
            return WindowInsetsCompat.toWindowInsetsCompat(this.mPlatBuilder.build());
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public void setDisplayCutout(@Nullable DisplayCutoutCompat r1) {
            WindowInsets.Builder r0 = this.mPlatBuilder;
            if (r1 == null) goto L5;
            DisplayCutout r2 = r1.unwrap();
        L6:
            r0.setDisplayCutout(r2);
            return;
        L5:
            r2 = null;
            goto L6
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public void setMandatorySystemGestureInsets(@NonNull Insets r1) {
            this.mPlatBuilder.setMandatorySystemGestureInsets(r1.toPlatformInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public void setStableInsets(@NonNull Insets r1) {
            this.mPlatBuilder.setStableInsets(r1.toPlatformInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public void setSystemGestureInsets(@NonNull Insets r1) {
            this.mPlatBuilder.setSystemGestureInsets(r1.toPlatformInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public void setSystemWindowInsets(@NonNull Insets r1) {
            this.mPlatBuilder.setSystemWindowInsets(r1.toPlatformInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public void setTappableElementInsets(@NonNull Insets r1) {
            this.mPlatBuilder.setTappableElementInsets(r1.toPlatformInsets());
        }

        public BuilderImpl29(@NonNull WindowInsetsCompat r2) {
            WindowInsets r3 = r2.toWindowInsets();
            if (r3 == null) goto L5;
            WindowInsets.Builder r0 = new WindowInsets.Builder(r3);
        L6:
            this.mPlatBuilder = r0;
            return;
        L5:
            r0 = new WindowInsets.Builder();
            goto L6
        }
    }

    public static class Impl {
        final WindowInsetsCompat mHost;

        public Impl(@NonNull WindowInsetsCompat r1) {
            this.mHost = r1;
        }

        @NonNull
        public WindowInsetsCompat consumeDisplayCutout() {
            return this.mHost;
        }

        @NonNull
        public WindowInsetsCompat consumeStableInsets() {
            return this.mHost;
        }

        @NonNull
        public WindowInsetsCompat consumeSystemWindowInsets() {
            return this.mHost;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof Impl) == true) goto L8;
            return false;
        L8:
            Impl r6 = (Impl) r5;
            if (isRound() != r6.isRound()) goto L20;
            if (isConsumed() != r6.isConsumed()) goto L20;
            if (ObjectsCompat.equals(getSystemWindowInsets(), r6.getSystemWindowInsets()) == false) goto L20;
            if (ObjectsCompat.equals(getStableInsets(), r6.getStableInsets()) == false) goto L20;
            if (ObjectsCompat.equals(getDisplayCutout(), r6.getDisplayCutout()) == false) goto L20;
            return true;
        L20:
            return false;
        }

        @Nullable
        public DisplayCutoutCompat getDisplayCutout() {
            return null;
        }

        @NonNull
        public Insets getMandatorySystemGestureInsets() {
            return getSystemWindowInsets();
        }

        @NonNull
        public Insets getStableInsets() {
            return Insets.NONE;
        }

        @NonNull
        public Insets getSystemGestureInsets() {
            return getSystemWindowInsets();
        }

        @NonNull
        public Insets getSystemWindowInsets() {
            return Insets.NONE;
        }

        @NonNull
        public Insets getTappableElementInsets() {
            return getSystemWindowInsets();
        }

        public int hashCode() {
            return ObjectsCompat.hash(new Object[]{Boolean.valueOf(isRound()), Boolean.valueOf(isConsumed()), getSystemWindowInsets(), getStableInsets(), getDisplayCutout()});
        }

        @NonNull
        public WindowInsetsCompat inset(int r1, int r2, int r3, int r4) {
            return WindowInsetsCompat.CONSUMED;
        }

        public boolean isConsumed() {
            return false;
        }

        public boolean isRound() {
            return false;
        }
    }

    @RequiresApi(20)
    public static class Impl20 extends Impl {

        @NonNull
        final WindowInsets mPlatformInsets;
        private Insets mSystemWindowInsets;

        public Impl20(@NonNull WindowInsetsCompat r1, @NonNull WindowInsets r2) {
            super(r1);
            this.mSystemWindowInsets = null;
            this.mPlatformInsets = r2;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        public final Insets getSystemWindowInsets() {
            if (this.mSystemWindowInsets != null) goto L6;
            this.mSystemWindowInsets = Insets.of(this.mPlatformInsets.getSystemWindowInsetLeft(), this.mPlatformInsets.getSystemWindowInsetTop(), this.mPlatformInsets.getSystemWindowInsetRight(), this.mPlatformInsets.getSystemWindowInsetBottom());
        L6:
            return this.mSystemWindowInsets;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        public WindowInsetsCompat inset(int r3, int r4, int r5, int r6) {
            Builder r0 = new Builder(WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets));
            r0.setSystemWindowInsets(WindowInsetsCompat.insetInsets(getSystemWindowInsets(), r3, r4, r5, r6));
            r0.setStableInsets(WindowInsetsCompat.insetInsets(getStableInsets(), r3, r4, r5, r6));
            return r0.build();
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public boolean isRound() {
            return this.mPlatformInsets.isRound();
        }

        public Impl20(@NonNull WindowInsetsCompat r2, @NonNull Impl20 r3) {
            this(r2, new WindowInsets(r3.mPlatformInsets));
        }
    }

    @RequiresApi(21)
    public static class Impl21 extends Impl20 {
        private Insets mStableInsets;

        public Impl21(@NonNull WindowInsetsCompat r1, @NonNull WindowInsets r2) {
            super(r1, r2);
            this.mStableInsets = null;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        public WindowInsetsCompat consumeStableInsets() {
            return WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets.consumeStableInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        public WindowInsetsCompat consumeSystemWindowInsets() {
            return WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets.consumeSystemWindowInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        public final Insets getStableInsets() {
            if (this.mStableInsets != null) goto L6;
            this.mStableInsets = Insets.of(this.mPlatformInsets.getStableInsetLeft(), this.mPlatformInsets.getStableInsetTop(), this.mPlatformInsets.getStableInsetRight(), this.mPlatformInsets.getStableInsetBottom());
        L6:
            return this.mStableInsets;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public boolean isConsumed() {
            return this.mPlatformInsets.isConsumed();
        }

        public Impl21(@NonNull WindowInsetsCompat r1, @NonNull Impl21 r2) {
            super(r1, r2);
            this.mStableInsets = null;
        }
    }

    @RequiresApi(28)
    public static class Impl28 extends Impl21 {
        public Impl28(@NonNull WindowInsetsCompat r1, @NonNull WindowInsets r2) {
            super(r1, r2);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        public WindowInsetsCompat consumeDisplayCutout() {
            return WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets.consumeDisplayCutout());
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public boolean equals(Object r2) {
            if (this != r2) goto L6;
            return true;
        L6:
            if ((r2 instanceof Impl28) == true) goto L10;
            return false;
        L10:
            return Objects.equals(this.mPlatformInsets, ((Impl28) r2).mPlatformInsets);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @Nullable
        public DisplayCutoutCompat getDisplayCutout() {
            return DisplayCutoutCompat.wrap(this.mPlatformInsets.getDisplayCutout());
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public int hashCode() {
            return this.mPlatformInsets.hashCode();
        }

        public Impl28(@NonNull WindowInsetsCompat r1, @NonNull Impl28 r2) {
            super(r1, r2);
        }
    }

    @RequiresApi(29)
    public static class Impl29 extends Impl28 {
        private Insets mMandatorySystemGestureInsets;
        private Insets mSystemGestureInsets;
        private Insets mTappableElementInsets;

        public Impl29(@NonNull WindowInsetsCompat r1, @NonNull WindowInsets r2) {
            super(r1, r2);
            this.mSystemGestureInsets = null;
            this.mMandatorySystemGestureInsets = null;
            this.mTappableElementInsets = null;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        public Insets getMandatorySystemGestureInsets() {
            if (this.mMandatorySystemGestureInsets != null) goto L6;
            this.mMandatorySystemGestureInsets = Insets.toCompatInsets(this.mPlatformInsets.getMandatorySystemGestureInsets());
        L6:
            return this.mMandatorySystemGestureInsets;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        public Insets getSystemGestureInsets() {
            if (this.mSystemGestureInsets != null) goto L6;
            this.mSystemGestureInsets = Insets.toCompatInsets(this.mPlatformInsets.getSystemGestureInsets());
        L6:
            return this.mSystemGestureInsets;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        public Insets getTappableElementInsets() {
            if (this.mTappableElementInsets != null) goto L6;
            this.mTappableElementInsets = Insets.toCompatInsets(this.mPlatformInsets.getTappableElementInsets());
        L6:
            return this.mTappableElementInsets;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl20, androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        public WindowInsetsCompat inset(int r1, int r2, int r3, int r4) {
            return WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets.inset(r1, r2, r3, r4));
        }

        public Impl29(@NonNull WindowInsetsCompat r1, @NonNull Impl29 r2) {
            super(r1, r2);
            this.mSystemGestureInsets = null;
            this.mMandatorySystemGestureInsets = null;
            this.mTappableElementInsets = null;
        }
    }

    static {
        CONSUMED = new Builder().build().consumeDisplayCutout().consumeStableInsets().consumeSystemWindowInsets();
    }

    @RequiresApi(20)
    private WindowInsetsCompat(@NonNull WindowInsets r2) {
        this.mImpl = new Impl29(this, r2);
    }

    public static Insets insetInsets(Insets r5, int r6, int r7, int r8, int r9) {
        int r0 = Math.max(0, r5.left - r6);
        int r2 = Math.max(0, r5.top - r7);
        int r3 = Math.max(0, r5.right - r8);
        int r1 = Math.max(0, r5.bottom - r9);
        if (r0 != r6) goto L9;
        if (r2 != r7) goto L9;
        if (r3 != r8) goto L9;
        if (r1 != r9) goto L9;
        return r5;
    L9:
        return Insets.of(r0, r2, r3, r1);
    }

    @NonNull
    @RequiresApi(20)
    public static WindowInsetsCompat toWindowInsetsCompat(@NonNull WindowInsets r1) {
        return new WindowInsetsCompat((WindowInsets) Preconditions.checkNotNull(r1));
    }

    @NonNull
    public WindowInsetsCompat consumeDisplayCutout() {
        return this.mImpl.consumeDisplayCutout();
    }

    @NonNull
    public WindowInsetsCompat consumeStableInsets() {
        return this.mImpl.consumeStableInsets();
    }

    @NonNull
    public WindowInsetsCompat consumeSystemWindowInsets() {
        return this.mImpl.consumeSystemWindowInsets();
    }

    public boolean equals(Object r2) {
        if (this != r2) goto L6;
        return true;
    L6:
        if ((r2 instanceof WindowInsetsCompat) == true) goto L10;
        return false;
    L10:
        return ObjectsCompat.equals(this.mImpl, ((WindowInsetsCompat) r2).mImpl);
    }

    @Nullable
    public DisplayCutoutCompat getDisplayCutout() {
        return this.mImpl.getDisplayCutout();
    }

    @NonNull
    public Insets getMandatorySystemGestureInsets() {
        return this.mImpl.getMandatorySystemGestureInsets();
    }

    public int getStableInsetBottom() {
        return getStableInsets().bottom;
    }

    public int getStableInsetLeft() {
        return getStableInsets().left;
    }

    public int getStableInsetRight() {
        return getStableInsets().right;
    }

    public int getStableInsetTop() {
        return getStableInsets().top;
    }

    @NonNull
    public Insets getStableInsets() {
        return this.mImpl.getStableInsets();
    }

    @NonNull
    public Insets getSystemGestureInsets() {
        return this.mImpl.getSystemGestureInsets();
    }

    public int getSystemWindowInsetBottom() {
        return getSystemWindowInsets().bottom;
    }

    public int getSystemWindowInsetLeft() {
        return getSystemWindowInsets().left;
    }

    public int getSystemWindowInsetRight() {
        return getSystemWindowInsets().right;
    }

    public int getSystemWindowInsetTop() {
        return getSystemWindowInsets().top;
    }

    @NonNull
    public Insets getSystemWindowInsets() {
        return this.mImpl.getSystemWindowInsets();
    }

    @NonNull
    public Insets getTappableElementInsets() {
        return this.mImpl.getTappableElementInsets();
    }

    public boolean hasInsets() {
        if (hasSystemWindowInsets() == false) goto L5;
    L16:
        return true;
    L5:
        if (hasStableInsets() == true) goto L16;
        if (getDisplayCutout() != null) goto L16;
        Insets r0 = getSystemGestureInsets();
        Insets r1 = Insets.NONE;
        if (r0.equals(r1) == false) goto L16;
        if (getMandatorySystemGestureInsets().equals(r1) == false) goto L16;
        if (getTappableElementInsets().equals(r1) == false) goto L16;
        return false;
    }

    public boolean hasStableInsets() {
        return !getStableInsets().equals(Insets.NONE);
    }

    public boolean hasSystemWindowInsets() {
        return !getSystemWindowInsets().equals(Insets.NONE);
    }

    public int hashCode() {
        Impl r0 = this.mImpl;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    @NonNull
    public WindowInsetsCompat inset(@NonNull Insets r4) {
        return inset(r4.left, r4.top, r4.right, r4.bottom);
    }

    public boolean isConsumed() {
        return this.mImpl.isConsumed();
    }

    public boolean isRound() {
        return this.mImpl.isRound();
    }

    @NonNull
    @Deprecated
    public WindowInsetsCompat replaceSystemWindowInsets(int r2, int r3, int r4, int r5) {
        return new Builder(this).setSystemWindowInsets(Insets.of(r2, r3, r4, r5)).build();
    }

    @Nullable
    @RequiresApi(20)
    public WindowInsets toWindowInsets() {
        Impl r1 = this.mImpl;
        if ((r1 instanceof Impl20) == true) goto L7;
        return null;
    L7:
        return ((Impl20) r1).mPlatformInsets;
    }

    @NonNull
    public WindowInsetsCompat inset(@IntRange(from = 0) int r1, @IntRange(from = 0) int r2, @IntRange(from = 0) int r3, @IntRange(from = 0) int r4) {
        return this.mImpl.inset(r1, r2, r3, r4);
    }

    public WindowInsetsCompat(@Nullable WindowInsetsCompat r2) {
        if (r2 == null) goto L17;
        Impl r3 = r2.mImpl;
        if ((r3 instanceof Impl29) == false) goto L8;
        this.mImpl = new Impl29(this, (Impl29) r3);
        return;
    L8:
        if ((r3 instanceof Impl28) == false) goto L11;
        this.mImpl = new Impl28(this, (Impl28) r3);
        return;
    L11:
        if ((r3 instanceof Impl21) == false) goto L14;
        this.mImpl = new Impl21(this, (Impl21) r3);
        return;
    L14:
        if ((r3 instanceof Impl20) == false) goto L16;
        this.mImpl = new Impl20(this, (Impl20) r3);
        return;
    L16:
        this.mImpl = new Impl(this);
        return;
    L17:
        this.mImpl = new Impl(this);
    }

    @NonNull
    @Deprecated
    public WindowInsetsCompat replaceSystemWindowInsets(@NonNull Rect r2) {
        return new Builder(this).setSystemWindowInsets(Insets.of(r2)).build();
    }
}
