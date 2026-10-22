package com.google.android.material.color;

/* JADX INFO: loaded from: classes3.dex */
public class DynamicColorsOptions {
    private static final DynamicColors.Precondition ALWAYS_ALLOW = null;
    private static final DynamicColors.OnAppliedCallback NO_OP_CALLBACK = null;
    private final DynamicColors.OnAppliedCallback onAppliedCallback;
    private final DynamicColors.Precondition precondition;
    private final int themeOverlay;

    public static class Builder {
        private DynamicColors.OnAppliedCallback onAppliedCallback;
        private DynamicColors.Precondition precondition;
        private int themeOverlay;

        public Builder() {
            this.precondition = DynamicColorsOptions.access$300();
            this.onAppliedCallback = DynamicColorsOptions.access$400();
        }

        static /* synthetic */ int access$000(Builder r0) {
            return r0.themeOverlay;
        }

        static /* synthetic */ DynamicColors.Precondition access$100(Builder r0) {
            return r0.precondition;
        }

        static /* synthetic */ DynamicColors.OnAppliedCallback access$200(Builder r0) {
            return r0.onAppliedCallback;
        }

        public Builder setThemeOverlay(int r1) {
            this.themeOverlay = r1;
            return this;
        }

        public Builder setPrecondition(DynamicColors.Precondition r1) {
            this.precondition = r1;
            return this;
        }

        public Builder setOnAppliedCallback(DynamicColors.OnAppliedCallback r1) {
            this.onAppliedCallback = r1;
            return this;
        }

        public DynamicColorsOptions build() {
            return new DynamicColorsOptions(this, null);
        }
    }

    /* synthetic */ DynamicColorsOptions(Builder r1, AnonymousClass1 r2) {
        this(r1);
    }

    static /* synthetic */ DynamicColors.Precondition access$300() {
        return ALWAYS_ALLOW;
    }

    static /* synthetic */ DynamicColors.OnAppliedCallback access$400() {
        return NO_OP_CALLBACK;
    }

    static {
        ALWAYS_ALLOW = new AnonymousClass1();
        NO_OP_CALLBACK = new AnonymousClass2();
    }

    private DynamicColorsOptions(Builder r2) {
        this.themeOverlay = Builder.access$000(r2);
        this.precondition = Builder.access$100(r2);
        this.onAppliedCallback = Builder.access$200(r2);
    }

    public int getThemeOverlay() {
        return this.themeOverlay;
    }

    public DynamicColors.Precondition getPrecondition() {
        return this.precondition;
    }

    public DynamicColors.OnAppliedCallback getOnAppliedCallback() {
        return this.onAppliedCallback;
    }
}
