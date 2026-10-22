package com.obric.oui.view;

import android.view.WindowInsetsAnimationController;

/* JADX INFO: loaded from: classes5.dex */
public final class WindowInsetsAnimationControllerCompat {
    private final Impl mImpl;

    private static class Impl {
        void finish(boolean r1) {
        }

        public float getCurrentAlpha() {
            return 0.0f;
        }

        public float getCurrentFraction() {
            return 0.0f;
        }

        public int getTypes() {
            return 0;
        }

        boolean isCancelled() {
            return true;
        }

        boolean isFinished() {
            return false;
        }

        public boolean isReady() {
            return false;
        }

        public void setInsetsAndAlpha(androidx.core.graphics.Insets r1, float r2, float r3) {
        }

        Impl() {
        }

        public androidx.core.graphics.Insets getHiddenStateInsets() {
            return androidx.core.graphics.Insets.NONE;
        }

        public androidx.core.graphics.Insets getShownStateInsets() {
            return androidx.core.graphics.Insets.NONE;
        }

        public androidx.core.graphics.Insets getCurrentInsets() {
            return androidx.core.graphics.Insets.NONE;
        }
    }

    private static class Impl30 extends Impl {
        private final WindowInsetsAnimationController mController;

        Impl30(WindowInsetsAnimationController r1) {
            this.mController = r1;
        }

        @Override // com.obric.oui.view.WindowInsetsAnimationControllerCompat.Impl
        public androidx.core.graphics.Insets getHiddenStateInsets() {
            return androidx.core.graphics.Insets.toCompatInsets(this.mController.getHiddenStateInsets());
        }

        @Override // com.obric.oui.view.WindowInsetsAnimationControllerCompat.Impl
        public androidx.core.graphics.Insets getShownStateInsets() {
            return androidx.core.graphics.Insets.toCompatInsets(this.mController.getShownStateInsets());
        }

        @Override // com.obric.oui.view.WindowInsetsAnimationControllerCompat.Impl
        public androidx.core.graphics.Insets getCurrentInsets() {
            return androidx.core.graphics.Insets.toCompatInsets(this.mController.getCurrentInsets());
        }

        @Override // com.obric.oui.view.WindowInsetsAnimationControllerCompat.Impl
        public float getCurrentFraction() {
            return this.mController.getCurrentFraction();
        }

        @Override // com.obric.oui.view.WindowInsetsAnimationControllerCompat.Impl
        public float getCurrentAlpha() {
            return this.mController.getCurrentAlpha();
        }

        @Override // com.obric.oui.view.WindowInsetsAnimationControllerCompat.Impl
        public int getTypes() {
            return this.mController.getTypes();
        }

        @Override // com.obric.oui.view.WindowInsetsAnimationControllerCompat.Impl
        public void setInsetsAndAlpha(androidx.core.graphics.Insets r1, float r2, float r3) {
            WindowInsetsAnimationController r0 = this.mController;
            if (r1 != null) goto L5;
            android.graphics.Insets r4 = null;
        L6:
            r0.setInsetsAndAlpha(r4, r2, r3);
            return;
        L5:
            r4 = r1.toPlatformInsets();
            goto L6
        }

        @Override // com.obric.oui.view.WindowInsetsAnimationControllerCompat.Impl
        void finish(boolean r1) {
            this.mController.finish(r1);
        }

        @Override // com.obric.oui.view.WindowInsetsAnimationControllerCompat.Impl
        public boolean isReady() {
            return this.mController.isReady();
        }

        @Override // com.obric.oui.view.WindowInsetsAnimationControllerCompat.Impl
        boolean isFinished() {
            return this.mController.isFinished();
        }

        @Override // com.obric.oui.view.WindowInsetsAnimationControllerCompat.Impl
        boolean isCancelled() {
            return this.mController.isCancelled();
        }
    }

    WindowInsetsAnimationControllerCompat() {
        throw new UnsupportedOperationException("On API 30+, the constructor taking a " + WindowInsetsAnimationController.class.getSimpleName() + " as parameter");
    }

    WindowInsetsAnimationControllerCompat(WindowInsetsAnimationController r2) {
        this.mImpl = new Impl30(r2);
    }

    public androidx.core.graphics.Insets getHiddenStateInsets() {
        return this.mImpl.getHiddenStateInsets();
    }

    public androidx.core.graphics.Insets getShownStateInsets() {
        return this.mImpl.getShownStateInsets();
    }

    public androidx.core.graphics.Insets getCurrentInsets() {
        return this.mImpl.getCurrentInsets();
    }

    public float getCurrentFraction() {
        return this.mImpl.getCurrentFraction();
    }

    public float getCurrentAlpha() {
        return this.mImpl.getCurrentAlpha();
    }

    public int getTypes() {
        return this.mImpl.getTypes();
    }

    public void setInsetsAndAlpha(androidx.core.graphics.Insets r1, float r2, float r3) {
        this.mImpl.setInsetsAndAlpha(r1, r2, r3);
    }

    public void finish(boolean r1) {
        this.mImpl.finish(r1);
    }

    public boolean isReady() {
        if (isFinished() == false) goto L5;
    L7:
        return false;
    L5:
        if (isCancelled() == true) goto L7;
        return true;
    }

    public boolean isFinished() {
        return this.mImpl.isFinished();
    }

    public boolean isCancelled() {
        return this.mImpl.isCancelled();
    }
}
