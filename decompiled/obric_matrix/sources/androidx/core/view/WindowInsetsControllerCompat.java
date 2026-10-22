package androidx.core.view;

import android.R;
import android.annotation.SuppressLint;
import android.os.Build;
import android.os.CancellationSignal;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsAnimationControlListener;
import android.view.WindowInsetsController;
import android.view.animation.Interpolator;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.collection.SimpleArrayMap;

/* JADX INFO: loaded from: classes.dex */
public final class WindowInsetsControllerCompat {
    public static final int BEHAVIOR_SHOW_BARS_BY_SWIPE = 1;
    public static final int BEHAVIOR_SHOW_BARS_BY_TOUCH = 0;
    public static final int BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE = 2;
    private final Impl mImpl;

    private static class Impl {
        Impl() {
        }

        void addOnControllableInsetsChangedListener(OnControllableInsetsChangedListener r1) {
        }

        void controlWindowInsetsAnimation(int r1, long r2, Interpolator r4, CancellationSignal r5, WindowInsetsAnimationControlListenerCompat r6) {
        }

        int getSystemBarsBehavior() {
            return 0;
        }

        void hide(int r1) {
        }

        public boolean isAppearanceLightNavigationBars() {
            return false;
        }

        public boolean isAppearanceLightStatusBars() {
            return false;
        }

        void removeOnControllableInsetsChangedListener(@NonNull OnControllableInsetsChangedListener r1) {
        }

        public void setAppearanceLightNavigationBars(boolean r1) {
        }

        public void setAppearanceLightStatusBars(boolean r1) {
        }

        void setSystemBarsBehavior(int r1) {
        }

        void show(int r1) {
        }
    }

    @RequiresApi(20)
    private static class Impl20 extends Impl {

        @NonNull
        private final View mView;

        @NonNull
        protected final Window mWindow;

        Impl20(@NonNull Window r1, @NonNull View r2) {
            this.mWindow = r1;
            this.mView = r2;
        }

        static /* synthetic */ void a(View r2) {
            ((InputMethodManager) r2.getContext().getSystemService("input_method")).showSoftInput(r2, 0);
        }

        private void hideForType(int r2) {
            if (r2 != 1) goto L5;
            setSystemUiFlag(4);
            return;
        L5:
            if (r2 != 2) goto L7;
            setSystemUiFlag(2);
            return;
        L7:
            if (r2 != 8) goto L15;
            ((InputMethodManager) this.mWindow.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.mWindow.getDecorView().getWindowToken(), 0);
            return;
        }

        private void showForType(int r2) {
            if (r2 != 1) goto L5;
            unsetSystemUiFlag(4);
            unsetWindowFlag(1024);
            return;
        L5:
            if (r2 != 2) goto L7;
            unsetSystemUiFlag(2);
            return;
        L7:
            if (r2 != 8) goto L29;
            final View r3 = this.mView;
            if (r3.isInEditMode() == false) goto L12;
        L15:
            r3.requestFocus();
        L16:
            if (r3 != null) goto L18;
            r3 = this.mWindow.findViewById(R.id.content);
        L18:
            if (r3 != null) goto L20;
            return;
        L20:
            if (r3.hasWindowFocus() == false) goto L28;
            r3.post(new g(r3));
            return;
        L28:
            return;
        L12:
            if (r3.onCheckIsTextEditor() == true) goto L15;
            r3 = this.mWindow.getCurrentFocus();
            goto L16
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void addOnControllableInsetsChangedListener(OnControllableInsetsChangedListener r1) {
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void controlWindowInsetsAnimation(int r1, long r2, Interpolator r4, CancellationSignal r5, WindowInsetsAnimationControlListenerCompat r6) {
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        int getSystemBarsBehavior() {
            return 0;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void hide(int r3) {
            int r0 = 1;
        L4:
            if (r0 > 256) goto L10;
            if ((r3 & r0) == 0) goto L9;
            hideForType(r0);
        L9:
            r0 = r0 << 1;
            goto L4
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void removeOnControllableInsetsChangedListener(@NonNull OnControllableInsetsChangedListener r1) {
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void setSystemBarsBehavior(int r4) {
            if (r4 != 0) goto L4;
            unsetSystemUiFlag(6144);
            return;
        L4:
            if (r4 != 1) goto L6;
            unsetSystemUiFlag(4096);
            setSystemUiFlag(2048);
            return;
        L6:
            if (r4 != 2) goto L14;
            unsetSystemUiFlag(2048);
            setSystemUiFlag(4096);
            return;
        }

        protected void setSystemUiFlag(int r2) {
            View r1 = this.mWindow.getDecorView();
            r1.setSystemUiVisibility(r2 | r1.getSystemUiVisibility());
        }

        protected void setWindowFlag(int r1) {
            this.mWindow.addFlags(r1);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void show(int r3) {
            int r0 = 1;
        L4:
            if (r0 > 256) goto L10;
            if ((r3 & r0) == 0) goto L9;
            showForType(r0);
        L9:
            r0 = r0 << 1;
            goto L4
        }

        protected void unsetSystemUiFlag(int r2) {
            View r1 = this.mWindow.getDecorView();
            int r0 = r1.getSystemUiVisibility();
            r1.setSystemUiVisibility((~r2) & r0);
        }

        protected void unsetWindowFlag(int r1) {
            this.mWindow.clearFlags(r1);
        }
    }

    @RequiresApi(23)
    private static class Impl23 extends Impl20 {
        Impl23(@NonNull Window r1, @Nullable View r2) {
            super(r1, r2);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public boolean isAppearanceLightStatusBars() {
            if ((this.mWindow.getDecorView().getSystemUiVisibility() & 8192) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public void setAppearanceLightStatusBars(boolean r2) {
            if (r2 == false) goto L5;
            unsetWindowFlag(67108864);
            setWindowFlag(Integer.MIN_VALUE);
            setSystemUiFlag(8192);
            return;
        L5:
            unsetSystemUiFlag(8192);
        }
    }

    @RequiresApi(26)
    private static class Impl26 extends Impl23 {
        Impl26(@NonNull Window r1, @Nullable View r2) {
            super(r1, r2);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public boolean isAppearanceLightNavigationBars() {
            if ((this.mWindow.getDecorView().getSystemUiVisibility() & 16) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public void setAppearanceLightNavigationBars(boolean r2) {
            if (r2 == false) goto L5;
            unsetWindowFlag(134217728);
            setWindowFlag(Integer.MIN_VALUE);
            setSystemUiFlag(16);
            return;
        L5:
            unsetSystemUiFlag(16);
        }
    }

    @RequiresApi(30)
    private static class Impl30 extends Impl {
        final WindowInsetsControllerCompat mCompatController;
        final WindowInsetsController mInsetsController;
        private final SimpleArrayMap<OnControllableInsetsChangedListener, WindowInsetsController.OnControllableInsetsChangedListener> mListeners;
        protected Window mWindow;

        Impl30(@NonNull Window r2, @NonNull WindowInsetsControllerCompat r3) {
            this(r2.getInsetsController(), r3);
            this.mWindow = r2;
        }

        Impl30(@NonNull WindowInsetsController r2, @NonNull WindowInsetsControllerCompat r3) {
            this.mListeners = new SimpleArrayMap();
            this.mInsetsController = r2;
            this.mCompatController = r3;
        }

        private /* synthetic */ void a(OnControllableInsetsChangedListener r2, WindowInsetsController r3, int r4) {
            if (this.mInsetsController != r3) goto L6;
            r2.onControllableInsetsChanged(this.mCompatController, r4);
            return;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void addOnControllableInsetsChangedListener(@NonNull final OnControllableInsetsChangedListener r3) {
            if (this.mListeners.containsKey(r3) == false) goto L5;
            return;
        L5:
            WindowInsetsController.OnControllableInsetsChangedListener r0 = new h(this, r3);
            this.mListeners.put(r3, r0);
            this.mInsetsController.addOnControllableInsetsChangedListener(r0);
        }

        public /* synthetic */ void b(OnControllableInsetsChangedListener r1, WindowInsetsController r2, int r3) {
            a(r1, r2, r3);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void controlWindowInsetsAnimation(int r8, long r9, @Nullable Interpolator r11, @Nullable CancellationSignal r12, @NonNull final WindowInsetsAnimationControlListenerCompat r13) {
            WindowInsetsAnimationControlListener r6 = new AnonymousClass1(this, r13);
            this.mInsetsController.controlWindowInsetsAnimation(r8, r9, r11, r12, r6);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        @SuppressLint({"WrongConstant"})
        int getSystemBarsBehavior() {
            return this.mInsetsController.getSystemBarsBehavior();
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void hide(int r1) {
            this.mInsetsController.hide(r1);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public boolean isAppearanceLightNavigationBars() {
            if ((this.mInsetsController.getSystemBarsAppearance() & 16) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public boolean isAppearanceLightStatusBars() {
            if ((this.mInsetsController.getSystemBarsAppearance() & 8) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void removeOnControllableInsetsChangedListener(@NonNull OnControllableInsetsChangedListener r2) {
            WindowInsetsController.OnControllableInsetsChangedListener r3 = this.mListeners.remove(r2);
            if (r3 == null) goto L6;
            this.mInsetsController.removeOnControllableInsetsChangedListener(r3);
            return;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public void setAppearanceLightNavigationBars(boolean r2) {
            if (r2 == false) goto L9;
            if (this.mWindow == null) goto L7;
            setSystemUiFlag(16);
        L7:
            this.mInsetsController.setSystemBarsAppearance(16, 16);
            return;
        L9:
            if (this.mWindow == null) goto L11;
            unsetSystemUiFlag(16);
        L11:
            this.mInsetsController.setSystemBarsAppearance(0, 16);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public void setAppearanceLightStatusBars(boolean r3) {
            if (r3 == false) goto L9;
            if (this.mWindow == null) goto L7;
            setSystemUiFlag(8192);
        L7:
            this.mInsetsController.setSystemBarsAppearance(8, 8);
            return;
        L9:
            if (this.mWindow == null) goto L11;
            unsetSystemUiFlag(8192);
        L11:
            this.mInsetsController.setSystemBarsAppearance(0, 8);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void setSystemBarsBehavior(int r1) {
            this.mInsetsController.setSystemBarsBehavior(r1);
        }

        protected void setSystemUiFlag(int r2) {
            View r1 = this.mWindow.getDecorView();
            r1.setSystemUiVisibility(r2 | r1.getSystemUiVisibility());
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void show(int r4) {
            Window r0 = this.mWindow;
            if (r0 != null) goto L5;
        L9:
            this.mInsetsController.show(r4);
            return;
        L5:
            if ((r4 & 8) == 0) goto L9;
            if (Build.VERSION.SDK_INT >= 32) goto L9;
            ((InputMethodManager) r0.getContext().getSystemService("input_method")).isActive();
            goto L9
        }

        protected void unsetSystemUiFlag(int r2) {
            View r1 = this.mWindow.getDecorView();
            int r0 = r1.getSystemUiVisibility();
            r1.setSystemUiVisibility((~r2) & r0);
        }
    }

    public interface OnControllableInsetsChangedListener {
        void onControllableInsetsChanged(@NonNull WindowInsetsControllerCompat r1, int r2);
    }

    public WindowInsetsControllerCompat(@NonNull Window r3, @NonNull View r4) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 30) goto L6;
        this.mImpl = new Impl30(r3, this);
        return;
    L6:
        if (r0 < 26) goto L10;
        Impl r1 = new Impl26(r3, r4);
    L8:
        this.mImpl = r1;
        return;
    L10:
        if (r0 < 23) goto L13;
        r1 = new Impl23(r3, r4);
        goto L8
    L13:
        if (r0 < 20) goto L15;
        r1 = new Impl20(r3, r4);
        goto L8
    L15:
        this.mImpl = new Impl();
    }

    @RequiresApi(30)
    @Deprecated
    private WindowInsetsControllerCompat(@NonNull WindowInsetsController r2) {
        this.mImpl = new Impl30(r2, this);
    }

    @NonNull
    @RequiresApi(30)
    @Deprecated
    public static WindowInsetsControllerCompat toWindowInsetsControllerCompat(@NonNull WindowInsetsController r1) {
        return new WindowInsetsControllerCompat(r1);
    }

    public void addOnControllableInsetsChangedListener(@NonNull OnControllableInsetsChangedListener r1) {
        this.mImpl.addOnControllableInsetsChangedListener(r1);
    }

    public void controlWindowInsetsAnimation(int r8, long r9, @Nullable Interpolator r11, @Nullable CancellationSignal r12, @NonNull WindowInsetsAnimationControlListenerCompat r13) {
        this.mImpl.controlWindowInsetsAnimation(r8, r9, r11, r12, r13);
    }

    @SuppressLint({"WrongConstant"})
    public int getSystemBarsBehavior() {
        return this.mImpl.getSystemBarsBehavior();
    }

    public void hide(int r1) {
        this.mImpl.hide(r1);
    }

    public boolean isAppearanceLightNavigationBars() {
        return this.mImpl.isAppearanceLightNavigationBars();
    }

    public boolean isAppearanceLightStatusBars() {
        return this.mImpl.isAppearanceLightStatusBars();
    }

    public void removeOnControllableInsetsChangedListener(@NonNull OnControllableInsetsChangedListener r1) {
        this.mImpl.removeOnControllableInsetsChangedListener(r1);
    }

    public void setAppearanceLightNavigationBars(boolean r1) {
        this.mImpl.setAppearanceLightNavigationBars(r1);
    }

    public void setAppearanceLightStatusBars(boolean r1) {
        this.mImpl.setAppearanceLightStatusBars(r1);
    }

    public void setSystemBarsBehavior(int r1) {
        this.mImpl.setSystemBarsBehavior(r1);
    }

    public void show(int r1) {
        this.mImpl.show(r1);
    }
}
