package com.obric.oui.banner;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;
import com.obric.common.oui.R;
import com.obric.oui.banner.configs.GridFillBannerConfigController;
import com.obric.oui.banner.configs.GridIndentBannerConfigController;
import com.obric.oui.banner.configs.GridTriptychBannerConfig;
import com.obric.oui.banner.configs.GridTriptychBannerConfigController;
import com.obric.oui.banner.interfaces.BannerOperator;
import com.obric.oui.banner.interfaces.OnBannerItemClickListener;
import com.obric.oui.banner.utils.BannerUtils;
import com.obric.oui.common.util.OUILoggerKt;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.dialog.alert.view.RadiusLayout;
import com.obric.oui.haptic.VibratorSmt;
import com.obric.oui.utils.log.L;
import com.obric.oui.window.OWindowConfigController;
import com.obric.oui.window.bean.WindowSizeWithPageSize;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OBanner.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\n\u0018\u0000 \u008c\u00012\u00020\u00012\u00020\u0002:\u0004\u008b\u0001\u008c\u0001B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0018\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020?2\u0006\u0010Z\u001a\u00020&H\u0002J \u0010[\u001a\u00020X2\u0006\u0010Y\u001a\u00020?2\u0006\u0010\\\u001a\u00020\b2\u0006\u0010Z\u001a\u00020&H\u0002J\b\u0010]\u001a\u00020XH\u0002J\b\u0010^\u001a\u00020XH\u0002J\u0010\u0010_\u001a\u00020X2\u0006\u0010Y\u001a\u00020?H\u0003J\b\u0010`\u001a\u00020XH\u0016J\u0006\u0010a\u001a\u00020XJ\u0012\u0010b\u001a\u00020&2\b\u0010c\u001a\u0004\u0018\u00010dH\u0016J\u0006\u0010e\u001a\u00020XJ\u000e\u0010f\u001a\u00020X2\u0006\u0010g\u001a\u00020&J\u0006\u0010h\u001a\u00020\bJ\u001e\u0010i\u001a\u00020X2\u0006\u0010j\u001a\u00020\b2\u0006\u0010k\u001a\u00020\b2\u0006\u0010l\u001a\u00020\bJ\u0006\u0010m\u001a\u00020XJ\b\u0010n\u001a\u00020XH\u0014J\b\u0010o\u001a\u00020XH\u0014J\u0018\u0010p\u001a\u00020X2\u0006\u0010q\u001a\u00020\b2\u0006\u0010r\u001a\u00020\bH\u0014J\u0018\u0010s\u001a\u00020X2\u0006\u0010t\u001a\u00020u2\u0006\u0010v\u001a\u00020\bH\u0002J\u000e\u0010w\u001a\u00020X2\u0006\u0010x\u001a\u00020yJ\u0006\u0010z\u001a\u00020XJ\u000e\u0010{\u001a\u00020X2\u0006\u0010|\u001a\u000205J\u000e\u0010}\u001a\u00020X2\u0006\u0010~\u001a\u000207J\u0017\u0010\u007f\u001a\u00020\u00002\u0006\u0010v\u001a\u00020\b2\u0007\u0010\u0080\u0001\u001a\u00020&J\u0017\u0010\u0081\u0001\u001a\u00020X2\u000e\u0010\u0082\u0001\u001a\t\u0012\u0004\u0012\u00020u0\u0083\u0001J\u0010\u0010\u0084\u0001\u001a\u00020X2\u0007\u0010\u0085\u0001\u001a\u00020:J\u001b\u0010\u0086\u0001\u001a\u00020X2\u0007\u0010\u0087\u0001\u001a\u00020\b2\u0007\u0010\u0088\u0001\u001a\u00020\bH\u0002J\u0007\u0010\u0089\u0001\u001a\u00020XJ\u0007\u0010\u008a\u0001\u001a\u00020XR\u001c\u0010\n\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\b0\b0\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0012\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001e\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0016\"\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010)\u001a\u00020&2\u0006\u0010(\u001a\u00020&8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u000e\u0010-\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010/\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b0\u0010 R\u001e\u00102\u001a\u00020\u00142\u0006\u00101\u001a\u00020\u0014@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u0016R\u0010\u00104\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u00010:X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010;\u001a\b\u0018\u00010<R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010=\u001a\n\u0012\u0004\u0012\u00020?\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010@\u001a\u0004\u0018\u00010AX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010D\u001a\u00020C2\u0006\u0010(\u001a\u00020C@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u0011\u0010I\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\bJ\u0010 R\u001a\u0010K\u001a\b\u0012\u0004\u0012\u00020\b0L8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bM\u0010NR\u001e\u0010O\u001a\u00020\b2\u0006\u00101\u001a\u00020\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bP\u0010 R\u000e\u0010Q\u001a\u00020CX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010R\u001a\u00020S8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bV\u0010\u0012\u001a\u0004\bT\u0010U¨\u0006\u008d\u0001"}, d2 = {"Lcom/obric/oui/banner/OBanner;", "Lcom/obric/oui/dialog/alert/view/RadiusLayout;", "Lcom/obric/oui/banner/interfaces/BannerOperator;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "_selectedPosition", "Landroidx/lifecycle/MutableLiveData;", "kotlin.jvm.PlatformType", "adapter", "Lcom/obric/oui/banner/BannerAdapter;", "getAdapter", "()Lcom/obric/oui/banner/BannerAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "autoSwitchIntervalMs", "", "getAutoSwitchIntervalMs", "()J", "checkAutoPlayRunnable", "Ljava/lang/Runnable;", "compositePageTransformer", "Landroidx/viewpager2/widget/CompositePageTransformer;", "getCompositePageTransformer", "()Landroidx/viewpager2/widget/CompositePageTransformer;", "compositePageTransformer$delegate", "currentItem", "getCurrentItem", "()I", "delayAfterUserTouch", "getDelayAfterUserTouch", "setDelayAfterUserTouch", "(J)V", "haveVibratedAfterUserDragging", "", "isAutoSwitchEnabled", "value", "isInfiniteSwitchEnabled", "()Z", "setInfiniteSwitchEnabled", "(Z)V", "isPadGridAdaptEnable", "isUserDragging", "itemCount", "getItemCount", "<set-?>", "lastUserTouchTime", "getLastUserTouchTime", "mBannerItemClickListener", "Lcom/obric/oui/banner/interfaces/OnBannerItemClickListener;", "mBannerStyle", "Lcom/obric/oui/banner/BannerStyle;", "mLastWindowWidth", "mOnPageChangeListener", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "mPageChangeCallback", "Lcom/obric/oui/banner/OBanner$BannerOnPageChangeCallback;", "mWindowGridConfigObserver", "Landroidx/lifecycle/Observer;", "Lcom/obric/oui/window/bean/WindowSizeWithPageSize;", "marginPageTransformer", "Landroidx/viewpager2/widget/MarginPageTransformer;", "pageInvalid", "", "proportion", "getProportion", "()F", "setProportion", "(F)V", "realCount", "getRealCount", "selectedPosition", "Landroidx/lifecycle/LiveData;", "getSelectedPosition", "()Landroidx/lifecycle/LiveData;", "startPosition", "getStartPosition", "triptychBannerRatio", "viewPager2", "Landroidx/viewpager2/widget/ViewPager2;", "getViewPager2", "()Landroidx/viewpager2/widget/ViewPager2;", "viewPager2$delegate", "adjustBannerForWindowConfigChange", "", "windowSizeWithPageSize", "isFromInit", "adjustBannerParam", "newBannerWidth", "checkAndSwitchPage", "clearCheckTask", "configBanner", "currentItemPlayDone", "disableAutoSwitch", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "enableAutoSwitch", "enablePadGridAdapt", "enable", "getCurrentRealPos", "initTriptychBanner", "bannerWidth", "windowWidth", "bannerPaddingDp", "initViewPager2", "onAttachedToWindow", "onDetachedFromWindow", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onTriptychBannerItemClick", "data", "Lcom/obric/oui/banner/BannerData;", "position", "registerViewHolder", "factory", "Lcom/obric/oui/banner/IBannerViewHolderFactory;", "release", "setBannerItemClickListener", "listener", "setBannerStyle", "style", "setCurrentItem", "smoothScroll", "setData", "dataSet", "", "setOnPageChangeListener", "onPageChangeListener", "setRecyclerViewPadding", "leftItemPadding", "rightItemPadding", "switchNext", "switchPrevious", "BannerOnPageChangeCallback", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OBanner extends RadiusLayout implements BannerOperator {
    public static final Companion Companion = null;
    public static final long DEFAULT_AUTO_SWITCH_INTERVAL_MS = 5000;
    public static final float DEFAULT_TRIPTYCH_BANNER_RATIO = 0.5625f;
    public static final int INVALID_VALUE = -1;
    public static final String TAG = "OBanner";
    private MutableLiveData<Integer> _selectedPosition;
    private final Lazy adapter$delegate;
    private final Runnable checkAutoPlayRunnable;
    private final Lazy compositePageTransformer$delegate;
    private long delayAfterUserTouch;
    private boolean haveVibratedAfterUserDragging;
    private boolean isAutoSwitchEnabled;
    private boolean isPadGridAdaptEnable;
    private boolean isUserDragging;
    private long lastUserTouchTime;
    private OnBannerItemClickListener mBannerItemClickListener;
    private BannerStyle mBannerStyle;
    private int mLastWindowWidth;
    private ViewPager2.OnPageChangeCallback mOnPageChangeListener;
    private BannerOnPageChangeCallback mPageChangeCallback;
    private Observer<WindowSizeWithPageSize> mWindowGridConfigObserver;
    private MarginPageTransformer marginPageTransformer;
    private boolean pageInvalid;
    private float proportion;
    private int startPosition;
    private float triptychBannerRatio;
    private final Lazy viewPager2$delegate;

    /* JADX INFO: compiled from: OBanner.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J \u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/oui/banner/OBanner$BannerOnPageChangeCallback;", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "(Lcom/obric/oui/banner/OBanner;)V", "tempPosition", "", "onPageScrollStateChanged", "", "state", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class BannerOnPageChangeCallback extends ViewPager2.OnPageChangeCallback {
        private int tempPosition;
        final /* synthetic */ OBanner this$0;

        /* JADX INFO: compiled from: OBanner.kt */
        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

            static {
                int[] r0 = new int[BannerStyle.values().length];
                r0[BannerStyle.TRIPTYCH.ordinal()] = 1;
                $EnumSwitchMapping$0 = r0;
            }
        }

        public BannerOnPageChangeCallback(OBanner r2) {
            Intrinsics.checkNotNullParameter(r2, "this$0");
            this.this$0 = r2;
            this.tempPosition = -1;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int r5, float r6, int r7) {
            int r8 = BannerUtils.INSTANCE.getRealPosition(this.this$0.isInfiniteSwitchEnabled(), r5, this.this$0.getRealCount());
            boolean r1 = false;
            if (WhenMappings.$EnumSwitchMapping$0[OBanner.access$getMBannerStyle$p(this.this$0).ordinal()] != 1) goto L8;
            if (r8 != (((this.this$0.getCurrentItem() - 2) + this.this$0.getRealCount()) % this.this$0.getRealCount())) goto L11;
        L9:
            r1 = true;
        L11:
            if (OBanner.access$getMOnPageChangeListener$p(this.this$0) == null) goto L18;
            if (r1 == false) goto L19;
            ViewPager2.OnPageChangeCallback r4 = OBanner.access$getMOnPageChangeListener$p(this.this$0);
            if (r4 == null) goto L20;
            r4.onPageScrolled(r8, r6, r7);
            return;
        L20:
            return;
        L19:
            return;
        L18:
            return;
        L8:
            if (r8 != (this.this$0.getCurrentItem() - 1)) goto L11;
            goto L9
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int r4) {
            int r0 = BannerUtils.INSTANCE.getRealPosition(this.this$0.isInfiniteSwitchEnabled(), r4, this.this$0.getRealCount());
            this.tempPosition = r4;
            if (OBanner.access$getMOnPageChangeListener$p(this.this$0) == null) goto L8;
            ViewPager2.OnPageChangeCallback r1 = OBanner.access$getMOnPageChangeListener$p(this.this$0);
            if (r1 == null) goto L8;
            r1.onPageSelected(r0);
        L8:
            OBanner.access$setPageInvalid$p(this.this$0, false);
            OBanner.access$get_selectedPosition$p(this.this$0).setValue(Integer.valueOf(r0));
            if (OBanner.access$getHaveVibratedAfterUserDragging$p(this.this$0) == true) goto L12;
            L.d(OBanner.TAG, "onPageSelected, position: " + r4 + ", realPosition: " + r0);
            VibratorSmt.vibrateEffectWithHapticPlayer(this.this$0.getContext(), 3);
            OBanner.access$setHaveVibratedAfterUserDragging$p(this.this$0, true);
            return;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int r5) {
            if (r5 != 0) goto L29;
            if (this.tempPosition == (-1)) goto L29;
            if (WhenMappings.$EnumSwitchMapping$0[OBanner.access$getMBannerStyle$p(this.this$0).ordinal()] != 1) goto L19;
            int r0 = this.tempPosition;
            if (r0 != 0) goto L10;
            OBanner r1 = this.this$0;
            r1.setCurrentItem(r1.getStartPosition(), false);
            goto L29
        L10:
            if (r0 != 1) goto L13;
            OBanner r2 = this.this$0;
            r2.setCurrentItem(r2.getStartPosition() + 1, false);
            goto L29
        L13:
            if (r0 != (this.this$0.getItemCount() - 1)) goto L16;
            OBanner r3 = this.this$0;
            r3.setCurrentItem(r3.getStartPosition() - 1, false);
            goto L29
        L16:
            if (r0 != (this.this$0.getItemCount() - 2)) goto L29;
            OBanner r4 = this.this$0;
            r4.setCurrentItem(r4.getStartPosition(), false);
            goto L29
        L19:
            if (this.tempPosition == (-1)) goto L29;
            if (this.this$0.isInfiniteSwitchEnabled() == false) goto L29;
            int r6 = this.tempPosition;
            if (r6 != 0) goto L26;
            OBanner r7 = this.this$0;
            r7.setCurrentItem(r7.getRealCount(), false);
            goto L29
        L26:
            if (r6 != (this.this$0.getItemCount() - 1)) goto L29;
            this.this$0.setCurrentItem(1, false);
        L29:
            if (OBanner.access$getMOnPageChangeListener$p(this.this$0) == null) goto L35;
            ViewPager2.OnPageChangeCallback r8 = OBanner.access$getMOnPageChangeListener$p(this.this$0);
            if (r8 == null) goto L36;
            r8.onPageScrollStateChanged(r5);
            return;
        L36:
            return;
        }
    }

    /* JADX INFO: compiled from: OBanner.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/oui/banner/OBanner$Companion;", "", "()V", "DEFAULT_AUTO_SWITCH_INTERVAL_MS", "", "DEFAULT_TRIPTYCH_BANNER_RATIO", "", "INVALID_VALUE", "", "TAG", "", "getBannerStyle", "Lcom/obric/oui/banner/BannerStyle;", "style", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final BannerStyle getBannerStyle(int r1) {
            if (r1 == 0) goto L11;
            if (r1 == 1) goto L14;
            if (r1 == 2) goto L13;
            return BannerStyle.FILL;
        L13:
            return BannerStyle.TRIPTYCH;
        L14:
            return BannerStyle.INDENT;
        L11:
            return BannerStyle.FILL;
        }
    }

    /* JADX INFO: compiled from: OBanner.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[BannerStyle.values().length];
            r0[BannerStyle.TRIPTYCH.ordinal()] = 1;
            r0[BannerStyle.FILL.ordinal()] = 2;
            r0[BannerStyle.INDENT.ordinal()] = 3;
            $EnumSwitchMapping$0 = r0;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$0-ungOTZ52eHcVdcrVvgWrSHFfA, reason: not valid java name */
    public static /* synthetic */ void m210$r8$lambda$0ungOTZ52eHcVdcrVvgWrSHFfA(OBanner r0) {
        m212checkAutoPlayRunnable$lambda0(r0);
    }

    public static /* synthetic */ void $r8$lambda$K3o40ETndurApIgIhWPxJnsD294(OBanner r0) {
        m211adjustBannerParam$lambda7(r0);
    }

    static {
        Companion = new Companion(null);
    }

    public OBanner(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public OBanner(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    public /* synthetic */ OBanner(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public static final /* synthetic */ BannerAdapter access$getAdapter(OBanner r0) {
        return r0.getAdapter();
    }

    public static final /* synthetic */ boolean access$getHaveVibratedAfterUserDragging$p(OBanner r0) {
        return r0.haveVibratedAfterUserDragging;
    }

    public static final /* synthetic */ OnBannerItemClickListener access$getMBannerItemClickListener$p(OBanner r0) {
        return r0.mBannerItemClickListener;
    }

    public static final /* synthetic */ BannerStyle access$getMBannerStyle$p(OBanner r0) {
        return r0.mBannerStyle;
    }

    public static final /* synthetic */ ViewPager2.OnPageChangeCallback access$getMOnPageChangeListener$p(OBanner r0) {
        return r0.mOnPageChangeListener;
    }

    public static final /* synthetic */ MutableLiveData access$get_selectedPosition$p(OBanner r0) {
        return r0._selectedPosition;
    }

    public static final /* synthetic */ void access$onTriptychBannerItemClick(OBanner r0, BannerData r1, int r2) {
        r0.onTriptychBannerItemClick(r1, r2);
    }

    public static final /* synthetic */ void access$setHaveVibratedAfterUserDragging$p(OBanner r0, boolean r1) {
        r0.haveVibratedAfterUserDragging = r1;
    }

    public static final /* synthetic */ void access$setPageInvalid$p(OBanner r0, boolean r1) {
        r0.pageInvalid = r1;
    }

    public OBanner(final Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        this.delayAfterUserTouch = 5000;
        this.viewPager2$delegate = LazyKt.lazy(new OBanner$viewPager2$2(r3));
        this.lastUserTouchTime = -1;
        this.adapter$delegate = LazyKt.lazy(new OBanner$adapter$2(this));
        this.checkAutoPlayRunnable = new OBanner$$ExternalSyntheticLambda0(this);
        this._selectedPosition = new MutableLiveData(0);
        this.compositePageTransformer$delegate = LazyKt.lazy(OBanner$compositePageTransformer$2.INSTANCE);
        this.mBannerStyle = BannerStyle.FILL;
        this.triptychBannerRatio = 0.5625f;
        this.mLastWindowWidth = -1;
        this.haveVibratedAfterUserDragging = true;
        if (r4 == null) goto L6;
        TypedArray r6 = r3.obtainStyledAttributes(r4, R.styleable.OBanner);
        Intrinsics.checkNotNullExpressionValue(r6, "context.obtainStyledAttr…trs, R.styleable.OBanner)");
        this.mBannerStyle = Companion.getBannerStyle(r6.getInt(R.styleable.OBanner_oui_banner_style, 0));
        this.isPadGridAdaptEnable = r6.getBoolean(R.styleable.OBanner_oui_banner_is_pad_grid_adapt_enable, false);
        setProportion(r6.getFloat(R.styleable.OBanner_oui_banner_proportion, 0.0f));
        this.isAutoSwitchEnabled = r6.getBoolean(R.styleable.OBanner_oui_banner_enableAutoSwitch, false);
        this.delayAfterUserTouch = r6.getInt(R.styleable.OBanner_oui_banner_autoSwitchInterval, 5000);
        setInfiniteSwitchEnabled(r6.getBoolean(R.styleable.OBanner_oui_banner_enableInfiniteSwitch, true));
        r6.recycle();
        return;
    }

    public final long getDelayAfterUserTouch() {
        return this.delayAfterUserTouch;
    }

    public final void setDelayAfterUserTouch(long r1) {
        this.delayAfterUserTouch = r1;
    }

    public final boolean isInfiniteSwitchEnabled() {
        return getAdapter().getUseInfiniteItemCount();
    }

    public final void setInfiniteSwitchEnabled(boolean r2) {
        getAdapter().setUseInfiniteItemCount(r2);
        getAdapter().notifyDataSetChanged();
    }

    public final ViewPager2 getViewPager2() {
        return (ViewPager2) this.viewPager2$delegate.getValue();
    }

    public final long getLastUserTouchTime() {
        return this.lastUserTouchTime;
    }

    private final BannerAdapter getAdapter() {
        return (BannerAdapter) this.adapter$delegate.getValue();
    }

    /* JADX INFO: renamed from: checkAutoPlayRunnable$lambda-0, reason: not valid java name */
    private static final void m212checkAutoPlayRunnable$lambda0(OBanner r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r1.checkAndSwitchPage();
    }

    private final CompositePageTransformer getCompositePageTransformer() {
        return (CompositePageTransformer) this.compositePageTransformer$delegate.getValue();
    }

    public final int getRealCount() {
        return getAdapter().getRealItemCount();
    }

    public final int getCurrentItem() {
        return getViewPager2().getCurrentItem();
    }

    public final int getItemCount() {
        return getAdapter().getItemCount();
    }

    public final int getStartPosition() {
        return this.startPosition;
    }

    public final void initViewPager2() {
        addView(getViewPager2(), new FrameLayout.LayoutParams(-1, -1));
        getViewPager2().setAdapter(getAdapter());
        getViewPager2().setPageTransformer(getCompositePageTransformer());
        BannerOnPageChangeCallback r0 = new BannerOnPageChangeCallback(this);
        getViewPager2().registerOnPageChangeCallback(r0);
        this.mPageChangeCallback = r0;
        ViewCompat.setAccessibilityDelegate(getViewPager2(), new AnonymousClass2(this));
    }

    public final void setBannerItemClickListener(OnBannerItemClickListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.mBannerItemClickListener = r2;
    }

    private final void onTriptychBannerItemClick(BannerData r6, int r7) {
        int r0 = BannerUtils.INSTANCE.getRealPosition(isInfiniteSwitchEnabled(), getCurrentItem(), getRealCount());
        if (getCurrentItem() != 2) goto L8;
        if (r7 != (getRealCount() - 1)) goto L8;
        setCurrentItem(1, true);
        return;
    L8:
        if (getCurrentItem() != (getItemCount() - 3)) goto L12;
        if (r7 != 0) goto L12;
        setCurrentItem(getItemCount() - 2, true);
        return;
    L12:
        if (r0 != (getRealCount() - 1)) goto L15;
        if (r7 != 0) goto L15;
        setCurrentItem(getCurrentItem() + 1, true);
        return;
    L15:
        if (r0 == 0) goto L17;
    L19:
        if (r0 <= r7) goto L21;
        setCurrentItem(getCurrentItem() - 1, true);
        return;
    L21:
        if (r0 >= r7) goto L23;
        setCurrentItem(getCurrentItem() + 1, true);
        return;
    L23:
        OnBannerItemClickListener r5 = this.mBannerItemClickListener;
        if (r5 == null) goto L34;
        r5.onItemClick(r6, r7);
        return;
    L34:
        return;
    L17:
        if (r7 != (getRealCount() - 1)) goto L19;
        setCurrentItem(getCurrentItem() - 1, true);
    }

    public final void enableAutoSwitch() {
        this.isAutoSwitchEnabled = true;
        checkAndSwitchPage();
    }

    public final void disableAutoSwitch() {
        clearCheckTask();
        this.isAutoSwitchEnabled = false;
    }

    public final void release() {
        clearCheckTask();
        getAdapter().release();
        BannerOnPageChangeCallback r0 = this.mPageChangeCallback;
        if (r0 == null) goto L6;
        getViewPager2().unregisterOnPageChangeCallback(r0);
    L6:
        LifecycleOwner r1 = null;
        getViewPager2().setAdapter(null);
        Object r2 = getContext();
        if ((r2 instanceof LifecycleOwner) == false) goto L9;
        r1 = (LifecycleOwner) r2;
    L9:
        if (r1 == null) goto L13;
        OWindowConfigController.INSTANCE.removeWindowConfigChangeListener(r1, this.mWindowGridConfigObserver);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r5) {
        if (r5 != null) goto L4;
        Integer r0 = null;
    L5:
        boolean r2 = true;
        if (r0 != null) goto L9;
    L11:
        if (r0 != null) goto L14;
    L16:
        if (r0 != null) goto L19;
    L21:
        r2 = false;
    L22:
        if (r2 == false) goto L25;
        this.isUserDragging = false;
        this.lastUserTouchTime = SystemClock.uptimeMillis();
        checkAndSwitchPage();
    L25:
        return super.dispatchTouchEvent(r5);
    L19:
        if (r0.intValue() != 3) goto L21;
    L14:
        if (r0.intValue() != 1) goto L16;
    L9:
        if (r0.intValue() != 0) goto L11;
        this.isUserDragging = true;
        this.haveVibratedAfterUserDragging = false;
        goto L25
    L4:
        r0 = Integer.valueOf(r5.getAction());
        goto L5
    }

    public final void switchNext() {
        getViewPager2().setCurrentItem(getViewPager2().getCurrentItem() + 1, true);
    }

    public final void switchPrevious() {
        getViewPager2().setCurrentItem(getViewPager2().getCurrentItem() - 1, true);
    }

    public final void setData(List<? extends BannerData> r4) {
        Intrinsics.checkNotNullParameter(r4, "dataSet");
        getAdapter().setDataSet(r4);
        int r1 = 1;
        if (r4.size() != 1) goto L6;
        disableAutoSwitch();
        setInfiniteSwitchEnabled(false);
    L6:
        if (isInfiniteSwitchEnabled() == false) goto L9;
        r1 = getRealCount() * 100;
    L12:
        this.startPosition = r1;
        setCurrentItem(r1, false);
        getViewPager2().requestTransform();
        return;
    L9:
        if (WhenMappings.$EnumSwitchMapping$0[this.mBannerStyle.ordinal()] == 1) goto L12;
        r1 = 0;
        goto L12
    }

    @Override // com.obric.oui.banner.interfaces.BannerOperator
    public void currentItemPlayDone() {
        this.pageInvalid = true;
        checkAndSwitchPage();
    }

    @Override // com.obric.oui.banner.interfaces.BannerOperator
    public LiveData<Integer> getSelectedPosition() {
        return this._selectedPosition;
    }

    @Override // com.obric.oui.banner.interfaces.BannerOperator
    public long getAutoSwitchIntervalMs() {
        return this.delayAfterUserTouch;
    }

    private final void checkAndSwitchPage() {
        if (this.isAutoSwitchEnabled == true) goto L5;
    L27:
        OUILoggerKt.debugLog("检查换页：开关 false，不换页");
        return;
    L5:
        if (this.delayAfterUserTouch <= 0) goto L27;
        if (this.isUserDragging == false) goto L12;
        OUILoggerKt.debugLog("检查换页：正在拖动，不换页");
        return;
    L12:
        if (isAttachedToWindow() == true) goto L15;
        OUILoggerKt.debugLog("剥离window，不换页");
        return;
    L15:
        long r0 = SystemClock.uptimeMillis() - this.lastUserTouchTime;
        if (r0 >= this.delayAfterUserTouch) goto L23;
        OUILoggerKt.debugLog("检查换页: 刚松手" + r0 + " ms，delay换页");
        Handler r2 = getHandler();
        if (r2 == null) goto L29;
        r2.postDelayed(this.checkAutoPlayRunnable, this.delayAfterUserTouch - r0);
        return;
    L29:
        return;
    L23:
        if (this.pageInvalid == false) goto L25;
        switchNext();
        return;
    L25:
        OUILoggerKt.debugLog("检查换页：不是业务触发的，不换页");
    }

    private final void clearCheckTask() {
        Handler r0 = getHandler();
        if (r0 == null) goto L7;
        r0.removeCallbacks(this.checkAutoPlayRunnable);
        return;
    }

    public final void registerViewHolder(IBannerViewHolderFactory r2) {
        Intrinsics.checkNotNullParameter(r2, "factory");
        getAdapter().registerViewHolder(r2);
    }

    public final float getProportion() {
        return this.proportion;
    }

    public final void setProportion(float r3) {
        if (r3 >= 0.0f) goto L5;
        this.proportion = 0.0f;
        return;
    L5:
        this.proportion = r3;
        invalidate();
    }

    @Override // com.obric.oui.dialog.alert.view.RadiusLayout, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int r3, int r4) {
        if (this.proportion > 0.0f) goto L6;
        super.onMeasure(r3, r4);
        return;
    L6:
        int r5 = View.MeasureSpec.getSize(r3);
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(r5, 1073741824), View.MeasureSpec.makeMeasureSpec((int) Math.floor(r5 / this.proportion), 1073741824));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        checkAndSwitchPage();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public final void setBannerStyle(BannerStyle r2) {
        Intrinsics.checkNotNullParameter(r2, "style");
        this.mBannerStyle = r2;
    }

    public final void enablePadGridAdapt(boolean r1) {
        this.isPadGridAdaptEnable = r1;
    }

    public final OBanner setCurrentItem(int r3, boolean r4) {
        if (getViewPager2().getScrollState() == 0) goto L10;
        Log.w(TAG, "viewPager2 scrollState: " + getViewPager2().getScrollState() + ", ban setCurrentItem");
    L9:
        return this;
    L10:
        getViewPager2().setCurrentItem(r3, r4);     // Catch: Exception -> L6
    L6:
        e = move-exception;
        Log.e(TAG, Intrinsics.stringPlus("setCurrentItem error, msg: ", e.getMessage()));
        goto L9
    }

    public final void initTriptychBanner(int r1, int r2, int r3) {
        int r4 = (r2 - r1) >> 1;
        setRecyclerViewPadding(r4, r4);
        MarginPageTransformer r5 = this.marginPageTransformer;
        if (r5 == null) goto L6;
        getCompositePageTransformer().removeTransformer(r5);
    L6:
        MarginPageTransformer r6 = new MarginPageTransformer(OUnitExtensionKt.vdp(this, r3));
        getCompositePageTransformer().addTransformer(r6);
        this.marginPageTransformer = r6;
    }

    private final void setRecyclerViewPadding(int r5, int r6) {
        ViewPager2 r4 = getViewPager2();
        View r1 = r4.getChildAt(0);
        if (r1 == null) goto L11;
        RecyclerView r2 = (RecyclerView) r1;
        if (r4.getOrientation() != 1) goto L7;
        r2.setPadding(r4.getPaddingLeft(), r5, r4.getPaddingRight(), r6);
    L8:
        r2.setClipToPadding(false);
        return;
    L7:
        r2.setPadding(r5, r4.getPaddingTop(), r6, r4.getPaddingBottom());
        goto L8
    L11:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
    }

    public final void setOnPageChangeListener(ViewPager2.OnPageChangeCallback r2) {
        Intrinsics.checkNotNullParameter(r2, "onPageChangeListener");
        this.mOnPageChangeListener = r2;
    }

    private final void adjustBannerForWindowConfigChange(WindowSizeWithPageSize r3, boolean r4) {
        int r0 = r3.getPageSize().getWidthInPx();
        if (this.mLastWindowWidth == r0) goto L6;
        this.mLastWindowWidth = r0;
        adjustBannerParam(r3, r0, r4);
        configBanner(r3);
        getViewPager2().requestTransform();
        return;
    }

    private final void adjustBannerParam(WindowSizeWithPageSize r7, int r8, boolean r9) {
        ViewGroup.LayoutParams r0 = getLayoutParams();
        int r1 = WhenMappings.$EnumSwitchMapping$0[this.mBannerStyle.ordinal()];
        if (r1 != 1) goto L5;
        r0.width = r8;
        r0.height = (int) (GridTriptychBannerConfigController.getTriptychBannerCardWidth(r7.getWindowSizeClass()) * this.triptychBannerRatio);
        setRadius(0.0f);
    L32:
        setLayoutParams(r0);
        if (r9 == true) goto L36;
        postDelayed(new OBanner$$ExternalSyntheticLambda1(this), 200);
        return;
    L36:
        return;
    L5:
        if (r1 != 2) goto L7;
        r0.width = r8;
        r0.height = GridFillBannerConfigController.getFillBannerHeight(r7);
        setRadius(0.0f);
        goto L32
    L7:
        if (r1 != 3) goto L32;
        Pair<Integer, Integer> r10 = GridIndentBannerConfigController.getIndentBannerSize(r7, getResources().getDisplayMetrics().density);
        r0.width = r10.getFirst().intValue();
        r0.height = r10.getSecond().intValue();
        OBanner r11 = this;
        int r12 = OUnitExtensionKt.vdp(r11, OWindowConfigController.INSTANCE.getCurrentWindowSizeClass().getBaseGridConfig().getPageMargin().getMarginDp());
        ViewGroup.LayoutParams r2 = null;
        if ((r0 instanceof ViewGroup.MarginLayoutParams) == false) goto L12;
        ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) r0;
    L13:
        if (r3 == null) goto L32;
        ViewGroup.LayoutParams r4 = r11.getLayoutParams();
        if ((r4 instanceof ViewGroup.MarginLayoutParams) == true) goto L18;
        r4 = null;
    L18:
        ViewGroup.MarginLayoutParams r5 = (ViewGroup.MarginLayoutParams) r4;
        int r6 = 0;
        if (r5 == null) goto L21;
        int r13 = r5.topMargin;
    L22:
        ViewGroup.LayoutParams r14 = r11.getLayoutParams();
        if ((r14 instanceof ViewGroup.MarginLayoutParams) == false) goto L26;
        r2 = r14;
    L26:
        ViewGroup.MarginLayoutParams r15 = (ViewGroup.MarginLayoutParams) r2;
        if (r15 == null) goto L29;
        r6 = r15.bottomMargin;
    L29:
        r3.setMargins(r12, r13, r12, r6);
        goto L32
    L21:
        r13 = 0;
        goto L22
    L12:
        r3 = null;
        goto L13
    }

    /* JADX INFO: renamed from: adjustBannerParam$lambda-7, reason: not valid java name */
    private static final void m211adjustBannerParam$lambda7(OBanner r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r1.switchNext();
    }

    private final void configBanner(WindowSizeWithPageSize r6) {
        int r0 = WhenMappings.$EnumSwitchMapping$0[this.mBannerStyle.ordinal()];
        if (r0 != 1) goto L5;
        GridTriptychBannerConfig r1 = GridTriptychBannerConfigController.getGridTriptychBannerConfig(r6.getWindowSizeClass());
        int r2 = r1.getGridSpan();
        initTriptychBanner((int) ((r2 * OWindowConfigController.INSTANCE.getBaseGridColumnWidth()) + ((r2 - 1) * OUnitExtensionKt.vdp(this, r6.getWindowSizeClass().getBaseGridConfig().getPageGutter().getGutterDp()))), OWindowConfigController.INSTANCE.getCurrentWindowSize().getWidthInPx(), r1.getItemGutterDp());
        getAdapter().setBannerConfig(r1);
    L12:
        getAdapter().notifyDataSetChanged();
        return;
    L5:
        if (r0 != 2) goto L7;
        getAdapter().setBannerConfig(GridFillBannerConfigController.getGridFillBannerConfig(r6.getWindowSizeClass()));
        goto L12
    L7:
        if (r0 != 3) goto L12;
        getAdapter().setBannerConfig(GridIndentBannerConfigController.getGridIndentBannerConfig(r6.getWindowSizeClass()));
        goto L12
    }

    public final int getCurrentRealPos() {
        return BannerUtils.INSTANCE.getRealPosition(isInfiniteSwitchEnabled(), getCurrentItem(), getRealCount());
    }
}
