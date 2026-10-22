package com.android.settings.display.color;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import com.android.settings.R;
import com.android.settings.databinding.LayoutScreenTemperatureBinding;
import com.android.settings.search.IndexDatabaseHelper;
import com.android.settings.utils.ResourceUtils;
import com.obric.oui.common.style.IOUILayout;
import com.obric.oui.tab.OTabLayout;
import com.obric.oui.tab.OTabLayoutBase;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: ScreenTemperatureView.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001 B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ^\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00122\u001e\u0010\u0018\u001a\u001a\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00100\u00192\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00100\u001dJ\u0010\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u001bH\u0016R\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/android/settings/display/color/ScreenTemperatureView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "temperatureItems", "", "Lcom/android/settings/display/color/ScreenTemperatureView$TemperatureItem;", "[Lcom/android/settings/display/color/ScreenTemperatureView$TemperatureItem;", "viewBinding", "Lcom/android/settings/databinding/LayoutScreenTemperatureBinding;", "initView", "", "currentTemperatureModeLv", "Landroidx/lifecycle/LiveData;", "Lcom/android/settings/display/color/ScreenColorModeViewModel$TemperatureMode;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "currPointPointPositionLv", "Landroid/graphics/PointF;", "updateTemperature", "Lkotlin/Function3;", "", "", "updateCurrentTemperatureMode", "Lkotlin/Function1;", "setEnabled", IndexDatabaseHelper.IndexColumns.ENABLED, "TemperatureItem", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ScreenTemperatureView extends LinearLayout {
    private final TemperatureItem[] temperatureItems;
    private final LayoutScreenTemperatureBinding viewBinding;

    /* JADX INFO: compiled from: ScreenTemperatureView.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/android/settings/display/color/ScreenTemperatureView$TemperatureItem;", "", "text", "", "mode", "Lcom/android/settings/display/color/ScreenColorModeViewModel$TemperatureMode;", "(Ljava/lang/String;Lcom/android/settings/display/color/ScreenColorModeViewModel$TemperatureMode;)V", "getMode", "()Lcom/android/settings/display/color/ScreenColorModeViewModel$TemperatureMode;", "getText", "()Ljava/lang/String;", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class TemperatureItem {
        private final ScreenColorModeViewModel.TemperatureMode mode;
        private final String text;

        public TemperatureItem(String r2, ScreenColorModeViewModel.TemperatureMode r3) {
            Intrinsics.checkNotNullParameter(r2, "text");
            Intrinsics.checkNotNullParameter(r3, "mode");
            this.text = r2;
            this.mode = r3;
        }

        public final String getText() {
            return this.text;
        }

        public final ScreenColorModeViewModel.TemperatureMode getMode() {
            return this.mode;
        }
    }

    public ScreenTemperatureView(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public ScreenTemperatureView(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    public /* synthetic */ ScreenTemperatureView(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public static final /* synthetic */ TemperatureItem[] access$getTemperatureItems$p(ScreenTemperatureView r0) {
        return r0.temperatureItems;
    }

    public ScreenTemperatureView(Context r5, AttributeSet r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6, r7);
        this.temperatureItems = new TemperatureItem[]{new TemperatureItem(ResourceUtils.getString(R.string.default_), ScreenColorModeViewModel.TemperatureMode.Default.INSTANCE), new TemperatureItem(ResourceUtils.getString(R.string.warm), ScreenColorModeViewModel.TemperatureMode.Warm.INSTANCE), new TemperatureItem(ResourceUtils.getString(R.string.cold), ScreenColorModeViewModel.TemperatureMode.Cold.INSTANCE), new TemperatureItem(ResourceUtils.getString(R.string.customized), ScreenColorModeViewModel.TemperatureMode.Customized.INSTANCE)};
        LayoutScreenTemperatureBinding r8 = LayoutScreenTemperatureBinding.bind(LayoutInflater.from(r5).inflate(R.layout.layout_screen_temperature, this, true));
        Intrinsics.checkNotNullExpressionValue(r8, "bind(...)");
        this.viewBinding = r8;
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        float r9 = 12;
        setPadding(MathKt.roundToInt(TypedValue.applyDimension(1, r9, Resources.getSystem().getDisplayMetrics())), 0, MathKt.roundToInt(TypedValue.applyDimension(1, r9, Resources.getSystem().getDisplayMetrics())), MathKt.roundToInt(TypedValue.applyDimension(1, r9, Resources.getSystem().getDisplayMetrics())));
        setOrientation(1);
        IOUILayout r1 = null;
        setBackground(ResourcesCompat.getDrawable(ResourceUtils.getResources(), R.drawable.radius_20_white, null));
        KeyEvent.Callback r4 = r8.ouiTabLayout.getChildAt(0);
        if ((r4 instanceof IOUILayout) == false) goto L5;
        r1 = (IOUILayout) r4;
    L5:
        if (r1 == null) goto L8;
        r1.setShadowStyle(2132018477);
        return;
    }

    public final void initView(LiveData<ScreenColorModeViewModel.TemperatureMode> r8, LifecycleOwner r9, LiveData<PointF> r10, Function3<? super Float, ? super Float, ? super Boolean, Unit> r11, final Function1<? super ScreenColorModeViewModel.TemperatureMode, Unit> r12) {
        Intrinsics.checkNotNullParameter(r8, "currentTemperatureModeLv");
        Intrinsics.checkNotNullParameter(r9, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r10, "currPointPointPositionLv");
        Intrinsics.checkNotNullParameter(r11, "updateTemperature");
        Intrinsics.checkNotNullParameter(r12, "updateCurrentTemperatureMode");
        final OTabLayout r0 = this.viewBinding.ouiTabLayout;
        TemperatureItem[] r1 = this.temperatureItems;
        int r2 = r1.length;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L5;
        TemperatureItem r5 = r1[r4];
        OTabLayoutBase.Tab r6 = r0.newTab(0);
        r6.setText(r5.getText());
        r0.addTab(r6);
        r4 = r4 + 1;
        goto L3
    L5:
        r0.addOnTabSelectedListener(new ScreenTemperatureView$initView$1$2(r12, this));
        r8.observe(r9, new ScreenTemperatureView$sam$androidx_lifecycle_Observer$0(new ScreenTemperatureView$initView$1$3(r0, this)));
        this.viewBinding.colorTemperatureEditView.initView(r10, r9, r11);
    }

    @Override // android.view.View
    public void setEnabled(boolean r2) {
        super.setEnabled(r2);
        this.viewBinding.colorTemperatureEditView.setEnabled(r2);
        this.viewBinding.ouiTabLayout.setEnabled(r2);
        if (r2 == false) goto L5;
        float r3 = 1.0f;
    L6:
        setAlpha(r3);
        return;
    L5:
        r3 = 0.5f;
        goto L6
    }
}
