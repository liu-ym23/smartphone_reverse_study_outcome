package com.android.settings.display.color;

import android.content.ContentResolver;
import android.graphics.PointF;
import android.hardware.display.ColorDisplayManager;
import android.provider.Settings;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.android.settings.SettingsApplication;
import java.util.Arrays;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ScreenColorModeViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 72\u00020\u0001:\u0003678B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u001e\u001a\u00020\u0016J\b\u0010\u001f\u001a\u00020\u0013H\u0002J!\u0010 \u001a\u00020\u00162\b\u0010!\u001a\u0004\u0018\u00010\u00162\b\u0010\"\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0002\u0010#J\u000e\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\fJ\u000e\u0010'\u001a\u00020%2\u0006\u0010(\u001a\u00020\u0010J\u000e\u0010)\u001a\u00020%2\u0006\u0010*\u001a\u00020\u0016J\u000e\u0010+\u001a\u00020%2\u0006\u0010*\u001a\u00020\u0016J \u0010,\u001a\u00020%2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.2\b\b\u0002\u00100\u001a\u00020\u0016J\f\u00101\u001a\u00020\f*\u000202H\u0002J\u000e\u00103\u001a\u00020\u0013*\u0004\u0018\u000104H\u0002J\f\u00105\u001a\u00020\u0010*\u000202H\u0002R#\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000eR\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00160\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000eR\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00160\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u00069"}, d2 = {"Lcom/android/settings/display/color/ScreenColorModeViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "colorDisplayManager", "Landroid/hardware/display/ColorDisplayManager;", "kotlin.jvm.PlatformType", "getColorDisplayManager", "()Landroid/hardware/display/ColorDisplayManager;", "colorDisplayManager$delegate", "Lkotlin/Lazy;", "currentColorModeLv", "Landroidx/lifecycle/MutableLiveData;", "Lcom/android/settings/display/color/ScreenColorModeViewModel$ColorMode;", "getCurrentColorModeLv", "()Landroidx/lifecycle/MutableLiveData;", "currentTemperatureModeLv", "Lcom/android/settings/display/color/ScreenColorModeViewModel$TemperatureMode;", "getCurrentTemperatureModeLv", "currentTemperaturePointPositionLv", "Landroid/graphics/PointF;", "getCurrentTemperaturePointPositionLv", "enableAdaptiveTemperatureLv", "", "getEnableAdaptiveTemperatureLv", "eyeProtectedModeEnabledLv", "getEyeProtectedModeEnabledLv", "showEyeProtectedTipsLv", "Landroidx/lifecycle/MediatorLiveData;", "getShowEyeProtectedTipsLv", "()Landroidx/lifecycle/MediatorLiveData;", "eyeProtectedModeEnabled", "getLastTemperature", "showEyeProtectedTips", "adaptiveTemperatureEnable", "eyeProtectModeEnable", "(Ljava/lang/Boolean;Ljava/lang/Boolean;)Z", "updateColorMode", "", "colorMode", "updateCurrentTemperatureMode", "temperatureMode", "updateEnableAdaptiveTemperature", "enable", "updateEyeProtectedModeEnabled", "updateTemperature", "radius", "", "radian", "saveToProvider", "toColorMode", "", "toTemperature", "", "toTemperatureMode", "ColorMode", "Companion", "TemperatureMode", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ScreenColorModeViewModel extends ViewModel {
    public static final Companion Companion = null;
    private static final String KEY_LAST_SCREEN_COLOR_TEMPERATURE = "Settings.Global.LAST_SCREEN_COLOR_TEMPERATURE_VALUE";
    private static final String KEY_LAST_SCREEN_COLOR_TEMPERATURE_MODE = "Settings.Global.LAST_SCREEN_COLOR_TEMPERATURE_MODE";
    private static final String KEY_SCREEN_COLOR_TEMPERATURE = "screen_color_temperature_value";
    private static final String KEY_SCREEN_COLOR_TEMPERATURE_ADAPTIVE = "screen_color_temperature_adaptive";
    private static final String KEY_SCREEN_COLOR_TEMPERATURE_MODE = "Settings.Global.SCREEN_COLOR_TEMPERATURE_MODE";
    private final Lazy colorDisplayManager$delegate;
    private final MutableLiveData<ColorMode> currentColorModeLv;
    private final MutableLiveData<TemperatureMode> currentTemperatureModeLv;
    private final MutableLiveData<PointF> currentTemperaturePointPositionLv;
    private final MutableLiveData<Boolean> enableAdaptiveTemperatureLv;
    private final MutableLiveData<Boolean> eyeProtectedModeEnabledLv;
    private final MediatorLiveData<Boolean> showEyeProtectedTipsLv;

    /* JADX INFO: compiled from: ScreenColorModeViewModel.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0007\b\tB\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0003\n\u000b\f¨\u0006\r"}, d2 = {"Lcom/android/settings/display/color/ScreenColorModeViewModel$ColorMode;", "", "value", "", "(I)V", "getValue", "()I", "Adaptive", "Professional", "Standard", "Lcom/android/settings/display/color/ScreenColorModeViewModel$ColorMode$Adaptive;", "Lcom/android/settings/display/color/ScreenColorModeViewModel$ColorMode$Professional;", "Lcom/android/settings/display/color/ScreenColorModeViewModel$ColorMode$Standard;", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class ColorMode {
        private final int value;

        /* JADX INFO: compiled from: ScreenColorModeViewModel.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/android/settings/display/color/ScreenColorModeViewModel$ColorMode$Adaptive;", "Lcom/android/settings/display/color/ScreenColorModeViewModel$ColorMode;", "()V", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Adaptive extends ColorMode {
            public static final Adaptive INSTANCE = null;

            static {
                INSTANCE = new Adaptive();
            }

            private Adaptive() {
                super(0, null);
            }
        }

        /* JADX INFO: compiled from: ScreenColorModeViewModel.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/android/settings/display/color/ScreenColorModeViewModel$ColorMode$Professional;", "Lcom/android/settings/display/color/ScreenColorModeViewModel$ColorMode;", "()V", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Professional extends ColorMode {
            public static final Professional INSTANCE = null;

            static {
                INSTANCE = new Professional();
            }

            private Professional() {
                super(257, null);
            }
        }

        /* JADX INFO: compiled from: ScreenColorModeViewModel.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/android/settings/display/color/ScreenColorModeViewModel$ColorMode$Standard;", "Lcom/android/settings/display/color/ScreenColorModeViewModel$ColorMode;", "()V", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Standard extends ColorMode {
            public static final Standard INSTANCE = null;

            static {
                INSTANCE = new Standard();
            }

            private Standard() {
                super(256, null);
            }
        }

        public /* synthetic */ ColorMode(int r1, DefaultConstructorMarker r2) {
            this(r1);
        }

        private ColorMode(int r1) {
            this.value = r1;
        }

        public final int getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: ScreenColorModeViewModel.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/android/settings/display/color/ScreenColorModeViewModel$Companion;", "", "()V", "KEY_LAST_SCREEN_COLOR_TEMPERATURE", "", "KEY_LAST_SCREEN_COLOR_TEMPERATURE_MODE", "KEY_SCREEN_COLOR_TEMPERATURE", "KEY_SCREEN_COLOR_TEMPERATURE_ADAPTIVE", "KEY_SCREEN_COLOR_TEMPERATURE_MODE", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: ScreenColorModeViewModel.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u000f\u0010\u0011\u0012B#\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u0082\u0001\u0004\u0013\u0014\u0015\u0016¨\u0006\u0017"}, d2 = {"Lcom/android/settings/display/color/ScreenColorModeViewModel$TemperatureMode;", "", "value", "", "radius", "", "radian", "(IFF)V", "getRadian", "()F", "getRadius", "getValue", "()I", "equals", "", "Cold", "Customized", "Default", "Warm", "Lcom/android/settings/display/color/ScreenColorModeViewModel$TemperatureMode$Cold;", "Lcom/android/settings/display/color/ScreenColorModeViewModel$TemperatureMode$Customized;", "Lcom/android/settings/display/color/ScreenColorModeViewModel$TemperatureMode$Default;", "Lcom/android/settings/display/color/ScreenColorModeViewModel$TemperatureMode$Warm;", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class TemperatureMode {
        private final float radian;
        private final float radius;
        private final int value;

        /* JADX INFO: compiled from: ScreenColorModeViewModel.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/android/settings/display/color/ScreenColorModeViewModel$TemperatureMode$Cold;", "Lcom/android/settings/display/color/ScreenColorModeViewModel$TemperatureMode;", "()V", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Cold extends TemperatureMode {
            public static final Cold INSTANCE = null;

            static {
                INSTANCE = new Cold();
            }

            private Cold() {
                int r2 = 2;
                float r3 = 0.518134f;
                super(r2, r3, 4.712389f, null);
            }
        }

        /* JADX INFO: compiled from: ScreenColorModeViewModel.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/android/settings/display/color/ScreenColorModeViewModel$TemperatureMode$Customized;", "Lcom/android/settings/display/color/ScreenColorModeViewModel$TemperatureMode;", "()V", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Customized extends TemperatureMode {
            public static final Customized INSTANCE = null;

            static {
                INSTANCE = new Customized();
            }

            private Customized() {
                super(3, 0.0f, 0.0f, 6, null);
            }
        }

        /* JADX INFO: compiled from: ScreenColorModeViewModel.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/android/settings/display/color/ScreenColorModeViewModel$TemperatureMode$Default;", "Lcom/android/settings/display/color/ScreenColorModeViewModel$TemperatureMode;", "()V", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Default extends TemperatureMode {
            public static final Default INSTANCE = null;

            static {
                INSTANCE = new Default();
            }

            private Default() {
                super(0, 0.0f, 0.0f, 6, null);
            }
        }

        /* JADX INFO: compiled from: ScreenColorModeViewModel.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/android/settings/display/color/ScreenColorModeViewModel$TemperatureMode$Warm;", "Lcom/android/settings/display/color/ScreenColorModeViewModel$TemperatureMode;", "()V", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Warm extends TemperatureMode {
            public static final Warm INSTANCE = null;

            static {
                INSTANCE = new Warm();
            }

            private Warm() {
                int r2 = 1;
                float r3 = 0.518134f;
                super(r2, r3, 2.6179938f, null);
            }
        }

        public /* synthetic */ TemperatureMode(int r1, float r2, float r3, DefaultConstructorMarker r4) {
            this(r1, r2, r3);
        }

        private TemperatureMode(int r1, float r2, float r3) {
            this.value = r1;
            this.radius = r2;
            this.radian = r3;
        }

        public /* synthetic */ TemperatureMode(int r2, float r3, float r4, int r5, DefaultConstructorMarker r6) {
            if ((r5 & 2) == 0) goto L6;
            r3 = 0.0f;
        L6:
            if ((r5 & 4) == 0) goto L8;
            r4 = 0.0f;
        L8:
            this(r2, r3, r4, null);
        }

        public final float getRadian() {
            return this.radian;
        }

        public final float getRadius() {
            return this.radius;
        }

        public final int getValue() {
            return this.value;
        }

        public final boolean equals(float r3, float r4) {
            if (this.radius != r3) goto L5;
            boolean r5 = true;
        L6:
            if (r5 == false) goto L14;
            if (this.radian != r4) goto L10;
            boolean r2 = true;
        L11:
            if (r2 == false) goto L14;
            return true;
        L10:
            r2 = false;
        L14:
            return false;
        L5:
            r5 = false;
            goto L6
        }
    }

    static {
        Companion = new Companion(null);
    }

    public ScreenColorModeViewModel() {
        this.currentColorModeLv = new MutableLiveData(toColorMode(Settings.System.getInt(SettingsApplication.getContext().getContentResolver(), "display_color_mode", ColorMode.Adaptive.INSTANCE.getValue())));
        boolean r3 = false;
        if (Settings.Global.getInt(SettingsApplication.getContext().getContentResolver(), KEY_SCREEN_COLOR_TEMPERATURE_ADAPTIVE, 0) != 1) goto L5;
        r3 = true;
    L5:
        MutableLiveData<Boolean> r0 = new MutableLiveData(Boolean.valueOf(r3));
        this.enableAdaptiveTemperatureLv = r0;
        MutableLiveData<Boolean> r1 = new MutableLiveData(Boolean.valueOf(eyeProtectedModeEnabled()));
        this.eyeProtectedModeEnabledLv = r1;
        MediatorLiveData<Boolean> r2 = new MediatorLiveData(Boolean.valueOf(showEyeProtectedTips(r0.getValue(), r1.getValue())));
        this.showEyeProtectedTipsLv = r2;
        this.currentTemperatureModeLv = new MutableLiveData(toTemperatureMode(Settings.Global.getInt(SettingsApplication.getContext().getContentResolver(), KEY_SCREEN_COLOR_TEMPERATURE_MODE, ColorMode.Adaptive.INSTANCE.getValue())));
        this.currentTemperaturePointPositionLv = new MutableLiveData(getLastTemperature());
        this.colorDisplayManager$delegate = LazyKt.lazy(ScreenColorModeViewModel$colorDisplayManager$2.INSTANCE);
        r2.addSource(r0, new ScreenColorModeViewModel$sam$androidx_lifecycle_Observer$0(new AnonymousClass1(this)));
        r2.addSource(r1, new ScreenColorModeViewModel$sam$androidx_lifecycle_Observer$0(new AnonymousClass2(this)));
    }

    public static final /* synthetic */ boolean access$showEyeProtectedTips(ScreenColorModeViewModel r0, Boolean r1, Boolean r2) {
        return r0.showEyeProtectedTips(r1, r2);
    }

    public final MutableLiveData<ColorMode> getCurrentColorModeLv() {
        return this.currentColorModeLv;
    }

    public final MutableLiveData<Boolean> getEnableAdaptiveTemperatureLv() {
        return this.enableAdaptiveTemperatureLv;
    }

    public final MutableLiveData<Boolean> getEyeProtectedModeEnabledLv() {
        return this.eyeProtectedModeEnabledLv;
    }

    public final MediatorLiveData<Boolean> getShowEyeProtectedTipsLv() {
        return this.showEyeProtectedTipsLv;
    }

    public final MutableLiveData<TemperatureMode> getCurrentTemperatureModeLv() {
        return this.currentTemperatureModeLv;
    }

    public final MutableLiveData<PointF> getCurrentTemperaturePointPositionLv() {
        return this.currentTemperaturePointPositionLv;
    }

    private final ColorDisplayManager getColorDisplayManager() {
        return (ColorDisplayManager) this.colorDisplayManager$delegate.getValue();
    }

    public final void updateEyeProtectedModeEnabled(boolean r3) {
        if (Intrinsics.areEqual(this.eyeProtectedModeEnabledLv.getValue(), Boolean.valueOf(r3)) == false) goto L5;
        return;
    L5:
        this.eyeProtectedModeEnabledLv.setValue(Boolean.valueOf(r3));
    }

    public final void updateCurrentTemperatureMode(TemperatureMode r4) {
        Intrinsics.checkNotNullParameter(r4, "temperatureMode");
        if (Intrinsics.areEqual(this.currentTemperatureModeLv.getValue(), r4) == false) goto L5;
        return;
    L5:
        Settings.Global.putInt(SettingsApplication.getContext().getContentResolver(), KEY_SCREEN_COLOR_TEMPERATURE_MODE, r4.getValue());
        this.currentTemperatureModeLv.setValue(r4);
        if (Intrinsics.areEqual(r4, TemperatureMode.Customized.INSTANCE) == true) goto L9;
        updateTemperature(r4.getRadius(), r4.getRadian(), true);
        return;
    }

    public final void updateEnableAdaptiveTemperature(boolean r8) {
        if (Intrinsics.areEqual(this.enableAdaptiveTemperatureLv.getValue(), Boolean.valueOf(r8)) == false) goto L6;
        return;
    L6:
        if (r8 == false) goto L15;
        TemperatureMode r2 = this.currentTemperatureModeLv.getValue();
        if (r2 == null) goto L14;
        int r3 = r2.getValue();
        Settings.Global.putInt(SettingsApplication.getContext().getContentResolver(), KEY_LAST_SCREEN_COLOR_TEMPERATURE_MODE, r3);
        if (r3 != TemperatureMode.Customized.INSTANCE.getValue()) goto L14;
        PointF r1 = this.currentTemperaturePointPositionLv.getValue();
        if (r1 == null) goto L14;
        ContentResolver r4 = SettingsApplication.getContext().getContentResolver();
        String r5 = String.format("%f,%f", Arrays.copyOf(new Object[]{Float.valueOf(r1.x), Float.valueOf(r1.y)}, 2));
        Intrinsics.checkNotNullExpressionValue(r5, "format(...)");
        Settings.Global.putString(r4, KEY_LAST_SCREEN_COLOR_TEMPERATURE, r5);
    L14:
        updateCurrentTemperatureMode(TemperatureMode.Default.INSTANCE);
    L18:
        Settings.Global.putInt(SettingsApplication.getContext().getContentResolver(), KEY_SCREEN_COLOR_TEMPERATURE_ADAPTIVE, r8 ? 1 : 0);
        this.enableAdaptiveTemperatureLv.setValue(Boolean.valueOf(r8));
        return;
    L15:
        TemperatureMode r6 = toTemperatureMode(Settings.Global.getInt(SettingsApplication.getContext().getContentResolver(), KEY_LAST_SCREEN_COLOR_TEMPERATURE_MODE, ColorMode.Adaptive.INSTANCE.getValue()));
        updateCurrentTemperatureMode(r6);
        if (Intrinsics.areEqual(r6, TemperatureMode.Customized.INSTANCE) == false) goto L18;
        PointF r0 = toTemperature(Settings.Global.getString(SettingsApplication.getContext().getContentResolver(), KEY_LAST_SCREEN_COLOR_TEMPERATURE));
        updateTemperature$default(this, r0.x, r0.y, false, 4, null);
        goto L18
    }

    public final void updateColorMode(ColorMode r4) {
        Intrinsics.checkNotNullParameter(r4, "colorMode");
        if (Intrinsics.areEqual(this.currentColorModeLv.getValue(), r4) == false) goto L5;
        return;
    L5:
        Settings.System.putInt(SettingsApplication.getContext().getContentResolver(), "display_color_mode", r4.getValue());
        this.currentColorModeLv.setValue(r4);
    }

    public static /* synthetic */ void updateTemperature$default(ScreenColorModeViewModel r0, float r1, float r2, boolean r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = false;
    L5:
        r0.updateTemperature(r1, r2, r3);
    }

    public final void updateTemperature(float r3, float r4, boolean r5) {
        this.currentTemperaturePointPositionLv.setValue(new PointF(r3, r4));
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L9
        ColorDisplayManager r1 = getColorDisplayManager();     // Catch: Throwable -> L9
        if (r1 == null) goto L6;
        r1.setTemporaryPolarCoordinates(r3, r4);     // Catch: Throwable -> L9
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        Result.m1508constructorimpl(r2);     // Catch: Throwable -> L9
    L12:
        if (TemperatureMode.Cold.INSTANCE.equals(r3, r4) == false) goto L14;
    L18:
        if (r5 == false) goto L23;
        ContentResolver r6 = SettingsApplication.getContext().getContentResolver();
        String r7 = String.format("%f,%f", Arrays.copyOf(new Object[]{Float.valueOf(r3), Float.valueOf(r4)}, 2));
        Intrinsics.checkNotNullExpressionValue(r7, "format(...)");
        Settings.Global.putString(r6, KEY_SCREEN_COLOR_TEMPERATURE, r7);
        return;
    L23:
        return;
    L14:
        if (TemperatureMode.Warm.INSTANCE.equals(r3, r4) == true) goto L18;
        if (TemperatureMode.Default.INSTANCE.equals(r3, r4) == true) goto L18;
        updateCurrentTemperatureMode(TemperatureMode.Customized.INSTANCE);
        goto L18
    L6:
        r2 = null;
    L9:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        Result.m1508constructorimpl(ResultKt.createFailure(th));
        goto L12
    }

    private final PointF getLastTemperature() {
        return toTemperature(Settings.Global.getString(SettingsApplication.getContext().getContentResolver(), KEY_SCREEN_COLOR_TEMPERATURE));
    }

    private final PointF toTemperature(String r8) {
        String r0 = r8;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == true) goto L12;
        List r2 = StringsKt.split$default(r0, new String[]{","}, false, 0, 6, null);
        if (r2.size() != 2) goto L16;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L19
        Object r7 = Result.m1508constructorimpl(new PointF(Float.parseFloat((String) r2.get(0)), Float.parseFloat((String) r2.get(1))));     // Catch: Throwable -> L19
    L21:
        PointF r9 = new PointF(0.0f, 0.0f);
        if (Result.m1514isFailureimpl(r7) == false) goto L25;
        r7 = r9;
    L25:
        return (PointF) r7;
    L19:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r7 = Result.m1508constructorimpl(ResultKt.createFailure(th));
        goto L21
    L16:
        return new PointF(0.0f, 0.0f);
    L12:
        return new PointF(0.0f, 0.0f);
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L10
    }

    private final ColorMode toColorMode(int r1) {
        if (r1 != ColorMode.Adaptive.INSTANCE.getValue()) goto L6;
        return ColorMode.Adaptive.INSTANCE;
    L6:
        if (r1 != ColorMode.Standard.INSTANCE.getValue()) goto L9;
        return ColorMode.Standard.INSTANCE;
    L9:
        if (r1 != ColorMode.Professional.INSTANCE.getValue()) goto L12;
        return ColorMode.Professional.INSTANCE;
    L12:
        return ColorMode.Adaptive.INSTANCE;
    }

    private final TemperatureMode toTemperatureMode(int r1) {
        if (r1 != TemperatureMode.Default.INSTANCE.getValue()) goto L6;
        return TemperatureMode.Default.INSTANCE;
    L6:
        if (r1 != TemperatureMode.Warm.INSTANCE.getValue()) goto L9;
        return TemperatureMode.Warm.INSTANCE;
    L9:
        if (r1 != TemperatureMode.Cold.INSTANCE.getValue()) goto L12;
        return TemperatureMode.Cold.INSTANCE;
    L12:
        if (r1 != TemperatureMode.Customized.INSTANCE.getValue()) goto L15;
        return TemperatureMode.Customized.INSTANCE;
    L15:
        return TemperatureMode.Default.INSTANCE;
    }

    private final boolean showEyeProtectedTips(Boolean r2, Boolean r3) {
        if (Intrinsics.areEqual(r2, false) == true) goto L5;
        return false;
    L5:
        if (Intrinsics.areEqual(r3, true) == true) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean eyeProtectedModeEnabled() {
        if (Settings.Secure.getInt(SettingsApplication.getContext().getContentResolver(), "night_display_activated", 0) == 0) goto L6;
        return true;
    L6:
        return false;
    }
}
