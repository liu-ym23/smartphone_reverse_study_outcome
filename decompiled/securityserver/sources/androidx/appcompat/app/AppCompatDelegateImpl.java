package androidx.appcompat.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.StandaloneActionMode;
import androidx.appcompat.view.SupportActionModeWrapper;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.WindowCallbackWrapper;
import androidx.appcompat.view.menu.ListMenuPresenter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.DecorContentParent;
import androidx.appcompat.widget.FitWindowsViewGroup;
import androidx.appcompat.widget.TintTypedArray;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.VectorEnabledTintResources;
import androidx.appcompat.widget.ViewStubCompat;
import androidx.appcompat.widget.ViewUtils;
import androidx.collection.SimpleArrayMap;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NavUtils;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.KeyEventDispatcher;
import androidx.core.view.LayoutInflaterCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.widget.PopupWindowCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
class AppCompatDelegateImpl extends AppCompatDelegate implements MenuBuilder.Callback, LayoutInflater.Factory2 {
    static final String EXCEPTION_HANDLER_MESSAGE_SUFFIX = ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.";
    private static final boolean IS_PRE_LOLLIPOP = false;
    private static final boolean sCanApplyOverrideConfiguration = false;
    private static final boolean sCanReturnDifferentContext = false;
    private static boolean sInstalledExceptionHandler;
    private static final SimpleArrayMap<String, Integer> sLocalNightModes = null;
    private static final int[] sWindowBackgroundStyleable = null;
    ActionBar mActionBar;
    private ActionMenuPresenterCallback mActionMenuPresenterCallback;
    ActionMode mActionMode;
    PopupWindow mActionModePopup;
    ActionBarContextView mActionModeView;
    private boolean mActivityHandlesUiMode;
    private boolean mActivityHandlesUiModeChecked;
    final AppCompatCallback mAppCompatCallback;
    private AppCompatViewInflater mAppCompatViewInflater;
    private AppCompatWindowCallback mAppCompatWindowCallback;
    private AutoNightModeManager mAutoBatteryNightModeManager;
    private AutoNightModeManager mAutoTimeNightModeManager;
    private boolean mBaseContextAttached;
    private boolean mClosingActionMenu;
    final Context mContext;
    private boolean mCreated;
    private DecorContentParent mDecorContentParent;
    private boolean mEnableDefaultActionBarUp;
    ViewPropertyAnimatorCompat mFadeAnim;
    private boolean mFeatureIndeterminateProgress;
    private boolean mFeatureProgress;
    private boolean mHandleNativeActionModes;
    boolean mHasActionBar;
    final Object mHost;
    int mInvalidatePanelMenuFeatures;
    boolean mInvalidatePanelMenuPosted;
    private final Runnable mInvalidatePanelMenuRunnable;
    boolean mIsDestroyed;
    boolean mIsFloating;
    private int mLocalNightMode;
    private boolean mLongPressBackDown;
    MenuInflater mMenuInflater;
    boolean mOverlayActionBar;
    boolean mOverlayActionMode;
    private PanelMenuPresenterCallback mPanelMenuPresenterCallback;
    private PanelFeatureState[] mPanels;
    private PanelFeatureState mPreparedPanel;
    Runnable mShowActionModePopup;
    private boolean mStarted;
    private View mStatusGuard;
    ViewGroup mSubDecor;
    private boolean mSubDecorInstalled;
    private Rect mTempRect1;
    private Rect mTempRect2;
    private int mThemeResId;
    private CharSequence mTitle;
    private TextView mTitleView;
    Window mWindow;
    boolean mWindowNoTitle;

    /* JADX INFO: renamed from: androidx.appcompat.app.AppCompatDelegateImpl$1, reason: invalid class name */
    public class AnonymousClass1 implements Thread.UncaughtExceptionHandler {
        final /* synthetic */ Thread.UncaughtExceptionHandler val$defHandler;

        public AnonymousClass1(Thread.UncaughtExceptionHandler r1) {
            this.val$defHandler = r1;
        }

        private boolean shouldWrapException(Throwable r2) {
            if ((r2 instanceof Resources.NotFoundException) == false) goto L12;
            String r1 = r2.getMessage();
            if (r1 != null) goto L7;
            return false;
        L7:
            if (r1.contains("drawable") == false) goto L9;
        L10:
            return true;
        L9:
            if (r1.contains("Drawable") == true) goto L10;
            return false;
        L12:
            return false;
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(@NonNull Thread r4, @NonNull Throwable r5) {
            if (shouldWrapException(r5) == false) goto L5;
            Resources.NotFoundException r0 = new Resources.NotFoundException(r5.getMessage() + AppCompatDelegateImpl.EXCEPTION_HANDLER_MESSAGE_SUFFIX);
            r0.initCause(r5.getCause());
            r0.setStackTrace(r5.getStackTrace());
            this.val$defHandler.uncaughtException(r4, r0);
            return;
        L5:
            this.val$defHandler.uncaughtException(r4, r5);
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.app.AppCompatDelegateImpl$4, reason: invalid class name */
    public class AnonymousClass4 implements FitWindowsViewGroup.OnFitSystemWindowsListener {
        final /* synthetic */ AppCompatDelegateImpl this$0;

        public AnonymousClass4(AppCompatDelegateImpl r1) {
            this.this$0 = r1;
        }

        @Override // androidx.appcompat.widget.FitWindowsViewGroup.OnFitSystemWindowsListener
        public void onFitSystemWindows(Rect r2) {
            r2.top = this.this$0.updateStatusGuard(null, r2);
        }
    }

    public class ActionBarDrawableToggleImpl implements ActionBarDrawerToggle.Delegate {
        final /* synthetic */ AppCompatDelegateImpl this$0;

        public ActionBarDrawableToggleImpl(AppCompatDelegateImpl r1) {
            this.this$0 = r1;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public Context getActionBarThemedContext() {
            return this.this$0.getActionBarThemedContext();
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public Drawable getThemeUpIndicator() {
            TintTypedArray r2 = TintTypedArray.obtainStyledAttributes(getActionBarThemedContext(), null, new int[]{R.attr.homeAsUpIndicator});
            Drawable r0 = r2.getDrawable(0);
            r2.recycle();
            return r0;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public boolean isNavigationVisible() {
            ActionBar r0 = this.this$0.getSupportActionBar();
            if (r0 != null) goto L5;
        L7:
            return false;
        L5:
            if ((r0.getDisplayOptions() & 4) == 0) goto L7;
            return true;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public void setActionBarDescription(int r1) {
            ActionBar r0 = this.this$0.getSupportActionBar();
            if (r0 == null) goto L6;
            r0.setHomeActionContentDescription(r1);
            return;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public void setActionBarUpIndicator(Drawable r1, int r2) {
            ActionBar r0 = this.this$0.getSupportActionBar();
            if (r0 == null) goto L6;
            r0.setHomeAsUpIndicator(r1);
            r0.setHomeActionContentDescription(r2);
            return;
        }
    }

    public final class ActionMenuPresenterCallback implements MenuPresenter.Callback {
        final /* synthetic */ AppCompatDelegateImpl this$0;

        public ActionMenuPresenterCallback(AppCompatDelegateImpl r1) {
            this.this$0 = r1;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public void onCloseMenu(@NonNull MenuBuilder r1, boolean r2) {
            this.this$0.checkCloseActionMenu(r1);
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public boolean onOpenSubMenu(@NonNull MenuBuilder r2) {
            Window.Callback r1 = this.this$0.getWindowCallback();
            if (r1 == null) goto L7;
            r1.onMenuOpened(108, r2);
            return true;
        L7:
            return true;
        }
    }

    public class ActionModeCallbackWrapperV9 implements ActionMode.Callback {
        private ActionMode.Callback mWrapped;
        final /* synthetic */ AppCompatDelegateImpl this$0;

        public ActionModeCallbackWrapperV9(AppCompatDelegateImpl r1, ActionMode.Callback r2) {
            this.this$0 = r1;
            this.mWrapped = r2;
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode r1, MenuItem r2) {
            return this.mWrapped.onActionItemClicked(r1, r2);
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode r1, Menu r2) {
            return this.mWrapped.onCreateActionMode(r1, r2);
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode r3) {
            this.mWrapped.onDestroyActionMode(r3);
            AppCompatDelegateImpl r4 = this.this$0;
            if (r4.mActionModePopup == null) goto L5;
            r4.mWindow.getDecorView().removeCallbacks(this.this$0.mShowActionModePopup);
        L5:
            AppCompatDelegateImpl r5 = this.this$0;
            if (r5.mActionModeView == null) goto L8;
            r5.endOnGoingFadeAnimation();
            AppCompatDelegateImpl r6 = this.this$0;
            r6.mFadeAnim = ViewCompat.animate(r6.mActionModeView).alpha(0.0f);
            this.this$0.mFadeAnim.setListener(new AnonymousClass1(this));
        L8:
            AppCompatDelegateImpl r7 = this.this$0;
            AppCompatCallback r0 = r7.mAppCompatCallback;
            if (r0 == null) goto L11;
            r0.onSupportActionModeFinished(r7.mActionMode);
        L11:
            AppCompatDelegateImpl r2 = this.this$0;
            r2.mActionMode = null;
            ViewCompat.requestApplyInsets(r2.mSubDecor);
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode r2, Menu r3) {
            ViewCompat.requestApplyInsets(this.this$0.mSubDecor);
            return this.mWrapped.onPrepareActionMode(r2, r3);
        }
    }

    public class AppCompatWindowCallback extends WindowCallbackWrapper {
        final /* synthetic */ AppCompatDelegateImpl this$0;

        public AppCompatWindowCallback(AppCompatDelegateImpl r1, Window.Callback r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean dispatchKeyEvent(KeyEvent r2) {
            if (this.this$0.dispatchKeyEvent(r2) == false) goto L5;
        L8:
            return true;
        L5:
            if (super.dispatchKeyEvent(r2) == true) goto L8;
            return false;
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean dispatchKeyShortcutEvent(KeyEvent r2) {
            if (super.dispatchKeyShortcutEvent(r2) == false) goto L5;
        L8:
            return true;
        L5:
            if (this.this$0.onKeyShortcut(r2.getKeyCode(), r2) == true) goto L8;
            return false;
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public void onContentChanged() {
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean onCreatePanelMenu(int r2, Menu r3) {
            if (r2 != 0) goto L8;
            if ((r3 instanceof MenuBuilder) == true) goto L8;
            return false;
        L8:
            return super.onCreatePanelMenu(r2, r3);
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean onMenuOpened(int r1, Menu r2) {
            super.onMenuOpened(r1, r2);
            this.this$0.onMenuOpened(r1);
            return true;
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public void onPanelClosed(int r1, Menu r2) {
            super.onPanelClosed(r1, r2);
            this.this$0.onPanelClosed(r1);
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean onPreparePanel(int r4, View r5, Menu r6) {
            if ((r6 instanceof MenuBuilder) == false) goto L5;
            MenuBuilder r0 = (MenuBuilder) r6;
        L7:
            if (r4 != 0) goto L10;
            if (r0 != null) goto L10;
            return false;
        L10:
            if (r0 == null) goto L12;
            r0.setOverrideVisibleItems(true);
        L12:
            boolean r3 = super.onPreparePanel(r4, r5, r6);
            if (r0 == null) goto L15;
            r0.setOverrideVisibleItems(false);
        L15:
            return r3;
        L5:
            r0 = null;
            goto L7
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        @RequiresApi(24)
        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> r4, Menu r5, int r6) {
            PanelFeatureState r0 = this.this$0.getPanelState(0, true);
            if (r0 == null) goto L7;
            MenuBuilder r1 = r0.menu;
            if (r1 == null) goto L7;
            super.onProvideKeyboardShortcuts(r4, r1, r6);
            return;
        L7:
            super.onProvideKeyboardShortcuts(r4, r5, r6);
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public android.view.ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback r1) {
            return null;
        }

        public final android.view.ActionMode startAsSupportActionMode(android.view.ActionMode.Callback r3) {
            SupportActionModeWrapper.CallbackWrapper r0 = new SupportActionModeWrapper.CallbackWrapper(this.this$0.mContext, r3);
            ActionMode r2 = this.this$0.startSupportActionMode(r0);
            if (r2 != null) goto L5;
            return null;
        L5:
            return r0.getActionModeWrapper(r2);
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        @RequiresApi(23)
        public android.view.ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback r2, int r3) {
            if (this.this$0.isHandleNativeActionModesEnabled() == false) goto L9;
            if (r3 != 0) goto L9;
            return startAsSupportActionMode(r2);
        L9:
            return super.onWindowStartingActionMode(r2, r3);
        }
    }

    public class AutoBatteryNightModeManager extends AutoNightModeManager {
        private final PowerManager mPowerManager;
        final /* synthetic */ AppCompatDelegateImpl this$0;

        public AutoBatteryNightModeManager(@NonNull AppCompatDelegateImpl r1, Context r2) {
            this.this$0 = r1;
            super(r1);
            this.mPowerManager = (PowerManager) r2.getApplicationContext().getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK);
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager
        public IntentFilter createIntentFilterForBroadcastReceiver() {
            IntentFilter r1 = new IntentFilter();
            r1.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
            return r1;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager
        public int getApplyableNightMode() {
            if (this.mPowerManager.isPowerSaveMode() == false) goto L5;
            return 2;
        L5:
            return 1;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager
        public void onChange() {
            this.this$0.applyDayNight();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @VisibleForTesting
    public abstract class AutoNightModeManager {
        private BroadcastReceiver mReceiver;
        final /* synthetic */ AppCompatDelegateImpl this$0;

        public AutoNightModeManager(AppCompatDelegateImpl r1) {
            this.this$0 = r1;
        }

        public void cleanup() {
            BroadcastReceiver r0 = this.mReceiver;
            if (r0 == null) goto L10;
            this.this$0.mContext.unregisterReceiver(r0);     // Catch: IllegalArgumentException -> L7
        L5:
            this.mReceiver = null;
            return;
        }

        @Nullable
        public abstract IntentFilter createIntentFilterForBroadcastReceiver();

        public abstract int getApplyableNightMode();

        public boolean isListening() {
            if (this.mReceiver == null) goto L5;
            return true;
        L5:
            return false;
        }

        public abstract void onChange();

        public void setup() {
            cleanup();
            IntentFilter r0 = createIntentFilterForBroadcastReceiver();
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.countActions() != 0) goto L8;
            return;
        L8:
            if (this.mReceiver != null) goto L10;
            this.mReceiver = new AnonymousClass1(this);
        L10:
            this.this$0.mContext.registerReceiver(this.mReceiver, r0);
        }
    }

    public class AutoTimeNightModeManager extends AutoNightModeManager {
        private final TwilightManager mTwilightManager;
        final /* synthetic */ AppCompatDelegateImpl this$0;

        public AutoTimeNightModeManager(@NonNull AppCompatDelegateImpl r1, TwilightManager r2) {
            this.this$0 = r1;
            super(r1);
            this.mTwilightManager = r2;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager
        public IntentFilter createIntentFilterForBroadcastReceiver() {
            IntentFilter r1 = new IntentFilter();
            r1.addAction("android.intent.action.TIME_SET");
            r1.addAction("android.intent.action.TIMEZONE_CHANGED");
            r1.addAction("android.intent.action.TIME_TICK");
            return r1;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager
        public int getApplyableNightMode() {
            if (this.mTwilightManager.isNight() == false) goto L5;
            return 2;
        L5:
            return 1;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager
        public void onChange() {
            this.this$0.applyDayNight();
        }
    }

    @RequiresApi(17)
    public static class ConfigurationImplApi17 {
        private ConfigurationImplApi17() {
        }

        public static void generateConfigDelta_densityDpi(@NonNull Configuration r0, @NonNull Configuration r1, @NonNull Configuration r2) {
            int r3 = r0.densityDpi;
            int r4 = r1.densityDpi;
            if (r3 == r4) goto L6;
            r2.densityDpi = r4;
            return;
        }
    }

    @RequiresApi(24)
    public static class ConfigurationImplApi24 {
        private ConfigurationImplApi24() {
        }

        public static void generateConfigDelta_locale(@NonNull Configuration r1, @NonNull Configuration r2, @NonNull Configuration r3) {
            LocaleList r4 = r1.getLocales();
            LocaleList r0 = r2.getLocales();
            if (r4.equals(r0) == true) goto L6;
            r3.setLocales(r0);
            r3.locale = r2.locale;
            return;
        }
    }

    @RequiresApi(26)
    public static class ConfigurationImplApi26 {
        private ConfigurationImplApi26() {
        }

        public static void generateConfigDelta_colorMode(@NonNull Configuration r3, @NonNull Configuration r4, @NonNull Configuration r5) {
            int r0 = r3.colorMode & 3;
            int r1 = r4.colorMode;
            if (r0 == (r1 & 3)) goto L5;
            r5.colorMode |= r1 & 3;
        L5:
            int r6 = r3.colorMode & 12;
            int r7 = r4.colorMode;
            if (r6 == (r7 & 12)) goto L9;
            r5.colorMode |= r7 & 12;
            return;
        }
    }

    @RequiresApi(17)
    public static class ContextThemeWrapperCompatApi17Impl {
        private ContextThemeWrapperCompatApi17Impl() {
        }

        public static void applyOverrideConfiguration(ContextThemeWrapper r0, Configuration r1) {
            r0.applyOverrideConfiguration(r1);
        }
    }

    public class ListMenuDecorView extends ContentFrameLayout {
        final /* synthetic */ AppCompatDelegateImpl this$0;

        public ListMenuDecorView(AppCompatDelegateImpl r1, Context r2) {
            this.this$0 = r1;
            super(r2);
        }

        private boolean isOutOfBounds(int r2, int r3) {
            if (r2 < (-5)) goto L11;
            if (r3 < (-5)) goto L11;
            if (r2 > (getWidth() + 5)) goto L11;
            if (r3 > (getHeight() + 5)) goto L11;
            return false;
        L11:
            return true;
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent r2) {
            if (this.this$0.dispatchKeyEvent(r2) == false) goto L5;
        L8:
            return true;
        L5:
            if (super.dispatchKeyEvent(r2) == true) goto L8;
            return false;
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent r3) {
            if (r3.getAction() != 0) goto L9;
            if (isOutOfBounds((int) r3.getX(), (int) r3.getY()) == false) goto L9;
            this.this$0.closePanel(0);
            return true;
        L9:
            return super.onInterceptTouchEvent(r3);
        }

        @Override // android.view.View
        public void setBackgroundResource(int r2) {
            setBackgroundDrawable(AppCompatResources.getDrawable(getContext(), r2));
        }
    }

    public static final class PanelFeatureState {
        int background;
        View createdPanelView;
        ViewGroup decorView;
        int featureId;
        Bundle frozenActionViewState;
        Bundle frozenMenuState;
        int gravity;
        boolean isHandled;
        boolean isOpen;
        boolean isPrepared;
        ListMenuPresenter listMenuPresenter;
        Context listPresenterContext;
        MenuBuilder menu;
        public boolean qwertyMode;
        boolean refreshDecorView;
        boolean refreshMenuContent;
        View shownPanelView;
        boolean wasLastOpen;
        int windowAnimations;
        int x;
        int y;

        @SuppressLint({"BanParcelableUsage"})
        public static class SavedState implements Parcelable {
            public static final Parcelable.Creator<SavedState> CREATOR = null;
            int featureId;
            boolean isOpen;
            Bundle menuState;

            static {
                CREATOR = new AnonymousClass1();
            }

            public SavedState() {
            }

            public static SavedState readFromParcel(Parcel r3, ClassLoader r4) {
                SavedState r0 = new SavedState();
                r0.featureId = r3.readInt();
                boolean r2 = true;
                if (r3.readInt() == 1) goto L6;
                r2 = false;
            L6:
                r0.isOpen = r2;
                if (r2 == false) goto L9;
                r0.menuState = r3.readBundle(r4);
            L9:
                return r0;
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel r1, int r2) {
                r1.writeInt(this.featureId);
                r1.writeInt(this.isOpen ? 1 : 0);
                if (this.isOpen == false) goto L6;
                r1.writeBundle(this.menuState);
                return;
            }
        }

        public PanelFeatureState(int r1) {
            this.featureId = r1;
            this.refreshDecorView = false;
        }

        public void applyFrozenState() {
            MenuBuilder r0 = this.menu;
            if (r0 == null) goto L8;
            Bundle r1 = this.frozenMenuState;
            if (r1 == null) goto L9;
            r0.restorePresenterStates(r1);
            this.frozenMenuState = null;
            return;
        L9:
            return;
        }

        public void clearMenuPresenters() {
            MenuBuilder r0 = this.menu;
            if (r0 == null) goto L5;
            r0.removeMenuPresenter(this.listMenuPresenter);
        L5:
            this.listMenuPresenter = null;
        }

        public MenuView getListMenuView(MenuPresenter.Callback r4) {
            if (this.menu != null) goto L7;
            return null;
        L7:
            if (this.listMenuPresenter != null) goto L10;
            ListMenuPresenter r0 = new ListMenuPresenter(this.listPresenterContext, R.layout.abc_list_menu_item_layout);
            this.listMenuPresenter = r0;
            r0.setCallback(r4);
            this.menu.addMenuPresenter(this.listMenuPresenter);
        L10:
            return this.listMenuPresenter.getMenuView(this.decorView);
        }

        public boolean hasPanelItems() {
            if (this.shownPanelView != null) goto L6;
            return false;
        L6:
            if (this.createdPanelView == null) goto L9;
            return true;
        L9:
            if (this.listMenuPresenter.getAdapter().getCount() > 0) goto L11;
            return false;
        L11:
            return true;
        }

        public void onRestoreInstanceState(Parcelable r2) {
            SavedState r3 = (SavedState) r2;
            this.featureId = r3.featureId;
            this.wasLastOpen = r3.isOpen;
            this.frozenMenuState = r3.menuState;
            this.shownPanelView = null;
            this.decorView = null;
        }

        public Parcelable onSaveInstanceState() {
            SavedState r0 = new SavedState();
            r0.featureId = this.featureId;
            r0.isOpen = this.isOpen;
            if (this.menu == null) goto L5;
            Bundle r1 = new Bundle();
            r0.menuState = r1;
            this.menu.savePresenterStates(r1);
        L5:
            return r0;
        }

        public void setMenu(MenuBuilder r3) {
            MenuBuilder r0 = this.menu;
            if (r3 != r0) goto L5;
            return;
        L5:
            if (r0 == null) goto L7;
            r0.removeMenuPresenter(this.listMenuPresenter);
        L7:
            this.menu = r3;
            if (r3 == null) goto L13;
            ListMenuPresenter r2 = this.listMenuPresenter;
            if (r2 == null) goto L14;
            r3.addMenuPresenter(r2);
            return;
        L14:
            return;
        }

        public void setStyle(Context r5) {
            TypedValue r0 = new TypedValue();
            Resources.Theme r1 = r5.getResources().newTheme();
            r1.setTo(r5.getTheme());
            r1.resolveAttribute(R.attr.actionBarPopupTheme, r0, true);
            int r2 = r0.resourceId;
            if (r2 == 0) goto L5;
            r1.applyStyle(r2, true);
        L5:
            r1.resolveAttribute(R.attr.panelMenuListTheme, r0, true);
            int r3 = r0.resourceId;
            if (r3 == 0) goto L8;
            r1.applyStyle(r3, true);
        L9:
            androidx.appcompat.view.ContextThemeWrapper r4 = new androidx.appcompat.view.ContextThemeWrapper(r5, 0);
            r4.getTheme().setTo(r1);
            this.listPresenterContext = r4;
            TypedArray r6 = r4.obtainStyledAttributes(R.styleable.AppCompatTheme);
            this.background = r6.getResourceId(R.styleable.AppCompatTheme_panelBackground, 0);
            this.windowAnimations = r6.getResourceId(R.styleable.AppCompatTheme_android_windowAnimationStyle, 0);
            r6.recycle();
            return;
        L8:
            r1.applyStyle(R.style.Theme_AppCompat_CompactMenu, true);
            goto L9
        }
    }

    public final class PanelMenuPresenterCallback implements MenuPresenter.Callback {
        final /* synthetic */ AppCompatDelegateImpl this$0;

        public PanelMenuPresenterCallback(AppCompatDelegateImpl r1) {
            this.this$0 = r1;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public void onCloseMenu(@NonNull MenuBuilder r5, boolean r6) {
            MenuBuilder r0 = r5.getRootMenu();
            if (r0 == r5) goto L5;
            boolean r2 = true;
        L6:
            AppCompatDelegateImpl r3 = this.this$0;
            if (r2 == false) goto L9;
            r5 = r0;
        L9:
            PanelFeatureState r7 = r3.findMenuPanel(r5);
            if (r7 == null) goto L15;
            if (r2 == false) goto L13;
            this.this$0.callOnPanelClosed(r7.featureId, r7, r0);
            this.this$0.closePanel(r7, true);
            return;
        L13:
            this.this$0.closePanel(r7, r6);
            return;
        L15:
            return;
        L5:
            r2 = false;
            goto L6
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public boolean onOpenSubMenu(@NonNull MenuBuilder r3) {
            if (r3 != r3.getRootMenu()) goto L13;
            AppCompatDelegateImpl r0 = this.this$0;
            if (r0.mHasActionBar == false) goto L14;
            Window.Callback r1 = r0.getWindowCallback();
            if (r1 != null) goto L9;
            return true;
        L9:
            if (this.this$0.mIsDestroyed == true) goto L16;
            r1.onMenuOpened(108, r3);
            return true;
        L16:
            return true;
        L14:
            return true;
        L13:
            return true;
        }
    }

    static {
        sLocalNightModes = new SimpleArrayMap();
        IS_PRE_LOLLIPOP = false;
        sWindowBackgroundStyleable = new int[]{android.R.attr.windowBackground};
        sCanReturnDifferentContext = !"robolectric".equals(Build.FINGERPRINT);
        sCanApplyOverrideConfiguration = true;
    }

    public AppCompatDelegateImpl(Activity r2, AppCompatCallback r3) {
        this(r2, null, r3, r2);
    }

    private void applyFixedSizeWindow() {
        ContentFrameLayout r0 = (ContentFrameLayout) this.mSubDecor.findViewById(android.R.id.content);
        View r1 = this.mWindow.getDecorView();
        r0.setDecorPadding(r1.getPaddingLeft(), r1.getPaddingTop(), r1.getPaddingRight(), r1.getPaddingBottom());
        TypedArray r5 = this.mContext.obtainStyledAttributes(R.styleable.AppCompatTheme);
        r5.getValue(R.styleable.AppCompatTheme_windowMinWidthMajor, r0.getMinWidthMajor());
        r5.getValue(R.styleable.AppCompatTheme_windowMinWidthMinor, r0.getMinWidthMinor());
        if (r5.hasValue(R.styleable.AppCompatTheme_windowFixedWidthMajor) == false) goto L6;
        r5.getValue(R.styleable.AppCompatTheme_windowFixedWidthMajor, r0.getFixedWidthMajor());
    L6:
        if (r5.hasValue(R.styleable.AppCompatTheme_windowFixedWidthMinor) == false) goto L9;
        r5.getValue(R.styleable.AppCompatTheme_windowFixedWidthMinor, r0.getFixedWidthMinor());
    L9:
        if (r5.hasValue(R.styleable.AppCompatTheme_windowFixedHeightMajor) == false) goto L12;
        r5.getValue(R.styleable.AppCompatTheme_windowFixedHeightMajor, r0.getFixedHeightMajor());
    L12:
        if (r5.hasValue(R.styleable.AppCompatTheme_windowFixedHeightMinor) == false) goto L14;
        r5.getValue(R.styleable.AppCompatTheme_windowFixedHeightMinor, r0.getFixedHeightMinor());
    L14:
        r5.recycle();
        r0.requestLayout();
    }

    private void attachToWindow(@NonNull Window r4) {
        if (this.mWindow != null) goto L14;
        Window.Callback r0 = r4.getCallback();
        if ((r0 instanceof AppCompatWindowCallback) == true) goto L12;
        AppCompatWindowCallback r1 = new AppCompatWindowCallback(this, r0);
        this.mAppCompatWindowCallback = r1;
        r4.setCallback(r1);
        TintTypedArray r2 = TintTypedArray.obtainStyledAttributes(this.mContext, null, sWindowBackgroundStyleable);
        Drawable r3 = r2.getDrawableIfKnown(0);
        if (r3 == null) goto L9;
        r4.setBackgroundDrawable(r3);
    L9:
        r2.recycle();
        this.mWindow = r4;
        return;
    L12:
        throw new IllegalStateException("AppCompat has already installed itself into the Window");
    L14:
        throw new IllegalStateException("AppCompat has already installed itself into the Window");
    }

    private int calculateNightMode() {
        int r1 = this.mLocalNightMode;
        if (r1 == (-100)) goto L6;
        return r1;
    L6:
        return AppCompatDelegate.getDefaultNightMode();
    }

    private void cleanupAutoManagers() {
        AutoNightModeManager r0 = this.mAutoTimeNightModeManager;
        if (r0 == null) goto L5;
        r0.cleanup();
    L5:
        AutoNightModeManager r1 = this.mAutoBatteryNightModeManager;
        if (r1 == null) goto L9;
        r1.cleanup();
        return;
    }

    @NonNull
    private Configuration createOverrideConfigurationForDayNight(@NonNull Context r1, int r2, @Nullable Configuration r3) {
        if (r2 != 1) goto L5;
        int r0 = 16;
    L9:
        Configuration r4 = new Configuration();
        r4.fontScale = 0.0f;
        if (r3 == null) goto L12;
        r4.setTo(r3);
    L12:
        r4.uiMode = r0 | (r4.uiMode & (-49));
        return r4;
    L5:
        if (r2 == 2) goto L7;
        r0 = r1.getApplicationContext().getResources().getConfiguration().uiMode & 48;
        goto L9
    L7:
        r0 = 32;
        goto L9
    }

    private ViewGroup createSubDecor() {
        TypedArray r0 = this.mContext.obtainStyledAttributes(R.styleable.AppCompatTheme);
        if (r0.hasValue(R.styleable.AppCompatTheme_windowActionBar) == true) goto L5;
        r0.recycle();
        throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
    L5:
        if (r0.getBoolean(R.styleable.AppCompatTheme_windowNoTitle, false) == false) goto L8;
        requestWindowFeature(1);
    L11:
        if (r0.getBoolean(R.styleable.AppCompatTheme_windowActionBarOverlay, false) == false) goto L14;
        requestWindowFeature(109);
    L14:
        if (r0.getBoolean(R.styleable.AppCompatTheme_windowActionModeOverlay, false) == false) goto L16;
        requestWindowFeature(10);
    L16:
        this.mIsFloating = r0.getBoolean(R.styleable.AppCompatTheme_android_windowIsFloating, false);
        r0.recycle();
        ensureWindow();
        this.mWindow.getDecorView();
        LayoutInflater r1 = LayoutInflater.from(this.mContext);
        if (this.mWindowNoTitle == true) goto L38;
        if (this.mIsFloating == false) goto L22;
        ViewGroup r2 = (ViewGroup) r1.inflate(R.layout.abc_dialog_title_material, null);
        this.mOverlayActionBar = false;
        this.mHasActionBar = false;
    L41:
        if (r2 == null) goto L56;
        ViewCompat.setOnApplyWindowInsetsListener(r2, new AnonymousClass3(this));
        if (this.mDecorContentParent != null) goto L45;
        this.mTitleView = (TextView) r2.findViewById(R.id.title);
    L45:
        ViewUtils.makeOptionalFitsSystemWindows(r2);
        ContentFrameLayout r3 = (ContentFrameLayout) r2.findViewById(R.id.action_bar_activity_content);
        ViewGroup r4 = (ViewGroup) this.mWindow.findViewById(android.R.id.content);
        if (r4 != null) goto L48;
    L53:
        this.mWindow.setContentView(r2);
        r3.setAttachListener(new AnonymousClass5(this));
        return r2;
    L48:
        if (r4.getChildCount() <= 0) goto L50;
        View r6 = r4.getChildAt(0);
        r4.removeViewAt(0);
        r3.addView(r6);
        goto L48
    L50:
        r4.setId(-1);
        r3.setId(android.R.id.content);
        if ((r4 instanceof FrameLayout) == false) goto L53;
        ((FrameLayout) r4).setForeground(null);
        goto L53
    L56:
        throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.mHasActionBar + ", windowActionBarOverlay: " + this.mOverlayActionBar + ", android:windowIsFloating: " + this.mIsFloating + ", windowActionModeOverlay: " + this.mOverlayActionMode + ", windowNoTitle: " + this.mWindowNoTitle + " }");
    L22:
        if (this.mHasActionBar == false) goto L36;
        TypedValue r5 = new TypedValue();
        this.mContext.getTheme().resolveAttribute(R.attr.actionBarTheme, r5, true);
        if (r5.resourceId == 0) goto L26;
        Context r7 = new androidx.appcompat.view.ContextThemeWrapper(this.mContext, r5.resourceId);
    L27:
        r2 = (ViewGroup) LayoutInflater.from(r7).inflate(R.layout.abc_screen_toolbar, null);
        DecorContentParent r8 = (DecorContentParent) r2.findViewById(R.id.decor_content_parent);
        this.mDecorContentParent = r8;
        r8.setWindowCallback(getWindowCallback());
        if (this.mOverlayActionBar == false) goto L31;
        this.mDecorContentParent.initFeature(109);
    L31:
        if (this.mFeatureProgress == false) goto L34;
        this.mDecorContentParent.initFeature(2);
    L34:
        if (this.mFeatureIndeterminateProgress == false) goto L41;
        this.mDecorContentParent.initFeature(5);
        goto L41
    L26:
        r7 = this.mContext;
        goto L27
    L36:
        r2 = null;
        goto L41
    L38:
        if (this.mOverlayActionMode == false) goto L40;
        r2 = (ViewGroup) r1.inflate(R.layout.abc_screen_simple_overlay_action_mode, null);
        goto L41
    L40:
        r2 = (ViewGroup) r1.inflate(R.layout.abc_screen_simple, null);
        goto L41
    L8:
        if (r0.getBoolean(R.styleable.AppCompatTheme_windowActionBar, false) == false) goto L11;
        requestWindowFeature(108);
        goto L11
    }

    private void ensureSubDecor() {
        if (this.mSubDecorInstalled == true) goto L22;
        this.mSubDecor = createSubDecor();
        CharSequence r0 = getTitle();
        if (TextUtils.isEmpty(r0) == true) goto L15;
        DecorContentParent r1 = this.mDecorContentParent;
        if (r1 == null) goto L10;
        r1.setWindowTitle(r0);
        goto L15
    L10:
        if (peekSupportActionBar() == null) goto L12;
        peekSupportActionBar().setWindowTitle(r0);
        goto L15
    L12:
        TextView r2 = this.mTitleView;
        if (r2 == null) goto L15;
        r2.setText(r0);
    L15:
        applyFixedSizeWindow();
        onSubDecorInstalled(this.mSubDecor);
        this.mSubDecorInstalled = true;
        PanelFeatureState r3 = getPanelState(0, false);
        if (this.mIsDestroyed == true) goto L23;
        if (r3 != null) goto L19;
    L20:
        invalidatePanelMenu(108);
        return;
    L19:
        if (r3.menu == null) goto L20;
        return;
    L23:
        return;
    }

    private void ensureWindow() {
        if (this.mWindow != null) goto L8;
        Object r0 = this.mHost;
        if ((r0 instanceof Activity) == false) goto L8;
        attachToWindow(((Activity) r0).getWindow());
    L8:
        if (this.mWindow == null) goto L11;
        return;
    L11:
        throw new IllegalStateException("We have not been given a Window");
    }

    @NonNull
    private static Configuration generateConfigDelta(@NonNull Configuration r4, @Nullable Configuration r5) {
        Configuration r0 = new Configuration();
        r0.fontScale = 0.0f;
        if (r5 != null) goto L5;
    L62:
        return r0;
    L5:
        if (r4.diff(r5) == 0) goto L62;
        float r1 = r4.fontScale;
        float r2 = r5.fontScale;
        if (r1 == r2) goto L10;
        r0.fontScale = r2;
    L10:
        int r3 = r4.mcc;
        int r6 = r5.mcc;
        if (r3 == r6) goto L13;
        r0.mcc = r6;
    L13:
        int r7 = r4.mnc;
        int r8 = r5.mnc;
        if (r7 == r8) goto L16;
        r0.mnc = r8;
    L16:
        ConfigurationImplApi24.generateConfigDelta_locale(r4, r5, r0);
        int r9 = r4.touchscreen;
        int r10 = r5.touchscreen;
        if (r9 == r10) goto L19;
        r0.touchscreen = r10;
    L19:
        int r11 = r4.keyboard;
        int r12 = r5.keyboard;
        if (r11 == r12) goto L22;
        r0.keyboard = r12;
    L22:
        int r13 = r4.keyboardHidden;
        int r14 = r5.keyboardHidden;
        if (r13 == r14) goto L25;
        r0.keyboardHidden = r14;
    L25:
        int r15 = r4.navigation;
        int r16 = r5.navigation;
        if (r15 == r16) goto L28;
        r0.navigation = r16;
    L28:
        int r17 = r4.navigationHidden;
        int r18 = r5.navigationHidden;
        if (r17 == r18) goto L31;
        r0.navigationHidden = r18;
    L31:
        int r19 = r4.orientation;
        int r20 = r5.orientation;
        if (r19 == r20) goto L34;
        r0.orientation = r20;
    L34:
        int r21 = r4.screenLayout & 15;
        int r22 = r5.screenLayout;
        if (r21 == (r22 & 15)) goto L37;
        r0.screenLayout |= r22 & 15;
    L37:
        int r23 = r4.screenLayout & 192;
        int r24 = r5.screenLayout;
        if (r23 == (r24 & 192)) goto L40;
        r0.screenLayout |= r24 & 192;
    L40:
        int r25 = r4.screenLayout & 48;
        int r26 = r5.screenLayout;
        if (r25 == (r26 & 48)) goto L43;
        r0.screenLayout |= r26 & 48;
    L43:
        int r27 = r4.screenLayout & 768;
        int r28 = r5.screenLayout;
        if (r27 == (r28 & 768)) goto L46;
        r0.screenLayout |= r28 & 768;
    L46:
        ConfigurationImplApi26.generateConfigDelta_colorMode(r4, r5, r0);
        int r29 = r4.uiMode & 15;
        int r30 = r5.uiMode;
        if (r29 == (r30 & 15)) goto L49;
        r0.uiMode |= r30 & 15;
    L49:
        int r31 = r4.uiMode & 48;
        int r32 = r5.uiMode;
        if (r31 == (r32 & 48)) goto L52;
        r0.uiMode |= r32 & 48;
    L52:
        int r33 = r4.screenWidthDp;
        int r34 = r5.screenWidthDp;
        if (r33 == r34) goto L55;
        r0.screenWidthDp = r34;
    L55:
        int r35 = r4.screenHeightDp;
        int r36 = r5.screenHeightDp;
        if (r35 == r36) goto L58;
        r0.screenHeightDp = r36;
    L58:
        int r37 = r4.smallestScreenWidthDp;
        int r38 = r5.smallestScreenWidthDp;
        if (r37 == r38) goto L61;
        r0.smallestScreenWidthDp = r38;
    L61:
        ConfigurationImplApi17.generateConfigDelta_densityDpi(r4, r5, r0);
        goto L62
    }

    private AutoNightModeManager getAutoBatteryNightModeManager(@NonNull Context r2) {
        if (this.mAutoBatteryNightModeManager != null) goto L6;
        this.mAutoBatteryNightModeManager = new AutoBatteryNightModeManager(this, r2);
    L6:
        return this.mAutoBatteryNightModeManager;
    }

    private void initWindowDecorActionBar() {
        ensureSubDecor();
        if (this.mHasActionBar == true) goto L5;
        return;
    L5:
        if (this.mActionBar != null) goto L19;
        Object r0 = this.mHost;
        if ((r0 instanceof Activity) == false) goto L11;
        this.mActionBar = new WindowDecorActionBar((Activity) this.mHost, this.mOverlayActionBar);
    L13:
        ActionBar r1 = this.mActionBar;
        if (r1 == null) goto L18;
        r1.setDefaultDisplayHomeAsUpEnabled(this.mEnableDefaultActionBarUp);
        return;
    L18:
        return;
    L11:
        if ((r0 instanceof Dialog) == false) goto L13;
        this.mActionBar = new WindowDecorActionBar((Dialog) this.mHost);
        goto L13
    }

    private boolean initializePanelContent(PanelFeatureState r4) {
        View r0 = r4.createdPanelView;
        if (r0 == null) goto L7;
        r4.shownPanelView = r0;
        return true;
    L7:
        if (r4.menu != null) goto L10;
        return false;
    L10:
        if (this.mPanelMenuPresenterCallback != null) goto L12;
        this.mPanelMenuPresenterCallback = new PanelMenuPresenterCallback(this);
    L12:
        View r3 = (View) r4.getListMenuView(this.mPanelMenuPresenterCallback);
        r4.shownPanelView = r3;
        if (r3 == null) goto L16;
        return true;
    L16:
        return false;
    }

    private boolean initializePanelDecor(PanelFeatureState r3) {
        r3.setStyle(getActionBarThemedContext());
        r3.decorView = new ListMenuDecorView(this, r3.listPresenterContext);
        r3.gravity = 81;
        return true;
    }

    private boolean initializePanelMenu(PanelFeatureState r7) {
        Context r0 = this.mContext;
        int r1 = r7.featureId;
        if (r1 == 0) goto L7;
        if (r1 == 108) goto L7;
    L19:
        MenuBuilder r2 = new MenuBuilder(r0);
        r2.setCallback(this);
        r7.setMenu(r2);
        return true;
    L7:
        if (this.mDecorContentParent == null) goto L19;
        TypedValue r3 = new TypedValue();
        Resources.Theme r4 = r0.getTheme();
        r4.resolveAttribute(R.attr.actionBarTheme, r3, true);
        if (r3.resourceId == 0) goto L11;
        Resources.Theme r5 = r0.getResources().newTheme();
        r5.setTo(r4);
        r5.applyStyle(r3.resourceId, true);
        r5.resolveAttribute(R.attr.actionBarWidgetTheme, r3, true);
    L13:
        if (r3.resourceId == 0) goto L17;
        if (r5 != null) goto L16;
        r5 = r0.getResources().newTheme();
        r5.setTo(r4);
    L16:
        r5.applyStyle(r3.resourceId, true);
    L17:
        if (r5 == null) goto L19;
        androidx.appcompat.view.ContextThemeWrapper r6 = new androidx.appcompat.view.ContextThemeWrapper(r0, 0);
        r6.getTheme().setTo(r5);
        r0 = r6;
        goto L19
    L11:
        r4.resolveAttribute(R.attr.actionBarWidgetTheme, r3, true);
        r5 = null;
        goto L13
    }

    private void invalidatePanelMenu(int r3) {
        int r4 = 1 << r3;
        this.mInvalidatePanelMenuFeatures = r4 | this.mInvalidatePanelMenuFeatures;
        if (this.mInvalidatePanelMenuPosted == true) goto L6;
        ViewCompat.postOnAnimation(this.mWindow.getDecorView(), this.mInvalidatePanelMenuRunnable);
        this.mInvalidatePanelMenuPosted = true;
        return;
    }

    private boolean isActivityManifestHandlingUiMode() {
        if (this.mActivityHandlesUiModeChecked == false) goto L5;
    L20:
        this.mActivityHandlesUiModeChecked = true;
        return this.mActivityHandlesUiMode;
    L5:
        if ((this.mHost instanceof Activity) == false) goto L20;
        PackageManager r0 = this.mContext.getPackageManager();
        if (r0 != null) goto L22;
        return false;
    L22:
        ActivityInfo r1 = r0.getActivityInfo(new ComponentName(this.mContext, this.mHost.getClass()), 269221888);     // Catch: PackageManager.NameNotFoundException -> L14
        if (r1 != null) goto L12;
    L16:
        boolean r2 = false;
    L17:
        this.mActivityHandlesUiMode = r2;     // Catch: PackageManager.NameNotFoundException -> L14
        goto L20
    L12:
        if ((r1.configChanges & 512) == 0) goto L16;
        r2 = true;
    L14:
        e = move-exception;
        Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e);
        this.mActivityHandlesUiMode = false;
        goto L20
    }

    private boolean onKeyDownPanel(int r2, KeyEvent r3) {
        if (r3.getRepeatCount() != 0) goto L8;
        PanelFeatureState r4 = getPanelState(r2, true);
        if (r4.isOpen == false) goto L7;
        return false;
    L7:
        return preparePanel(r4, r3);
    L8:
        return false;
    }

    private boolean onKeyUpPanel(int r5, KeyEvent r6) {
        if (this.mActionMode == null) goto L5;
        return false;
    L5:
        boolean r0 = true;
        PanelFeatureState r2 = getPanelState(r5, true);
        if (r5 != 0) goto L21;
        DecorContentParent r7 = this.mDecorContentParent;
        if (r7 == null) goto L21;
        if (r7.canShowOverflowMenu() == false) goto L21;
        if (ViewConfiguration.get(this.mContext).hasPermanentMenuKey() == true) goto L21;
        if (this.mDecorContentParent.isOverflowMenuShowing() == false) goto L16;
        r0 = this.mDecorContentParent.hideOverflowMenu();
    L36:
        if (r0 == false) goto L41;
        AudioManager r4 = (AudioManager) this.mContext.getApplicationContext().getSystemService("audio");
        if (r4 == null) goto L40;
        r4.playSoundEffect(0);
        goto L41
    L40:
        Log.w("AppCompatDelegate", "Couldn't get audio manager");
    L41:
        return r0;
    L16:
        if (this.mIsDestroyed == false) goto L18;
    L34:
        r0 = false;
        goto L36
    L18:
        if (preparePanel(r2, r6) == false) goto L34;
        r0 = this.mDecorContentParent.showOverflowMenu();
    L21:
        boolean r8 = r2.isOpen;
        if (r8 == false) goto L24;
    L35:
        closePanel(r2, true);
        r0 = r8;
        goto L36
    L24:
        if (r2.isHandled == true) goto L35;
        if (r2.isPrepared == false) goto L34;
        if (r2.refreshMenuContent == false) goto L31;
        r2.isPrepared = false;
        boolean r9 = preparePanel(r2, r6);
    L32:
        if (r9 == false) goto L34;
        openPanel(r2, r6);
        goto L36
    L31:
        r9 = true;
        goto L32
    }

    private void openPanel(PanelFeatureState r12, KeyEvent r13) {
        if (r12.isOpen == false) goto L5;
        return;
    L5:
        if (this.mIsDestroyed == false) goto L8;
        return;
    L8:
        if (r12.featureId == 0) goto L10;
    L12:
        Window.Callback r0 = getWindowCallback();
        if (r0 != null) goto L15;
    L18:
        WindowManager r1 = (WindowManager) this.mContext.getSystemService("window");
        if (r1 != null) goto L22;
        return;
    L22:
        if (preparePanel(r12, r13) == true) goto L24;
        return;
    L24:
        ViewGroup r14 = r12.decorView;
        if (r14 != null) goto L27;
    L36:
        if (r14 != null) goto L43;
        if (initializePanelDecor(r12) == true) goto L40;
        return;
    L40:
        if (r12.decorView != null) goto L48;
        return;
    L48:
        if (initializePanelContent(r12) == true) goto L50;
    L64:
        r12.refreshDecorView = true;
        return;
    L50:
        if (r12.hasPanelItems() == false) goto L64;
        ViewGroup.LayoutParams r11 = r12.shownPanelView.getLayoutParams();
        if (r11 != null) goto L55;
        r11 = new ViewGroup.LayoutParams(-2, -2);
    L55:
        r12.decorView.setBackgroundResource(r12.background);
        ViewParent r15 = r12.shownPanelView.getParent();
        if ((r15 instanceof ViewGroup) == false) goto L58;
        ((ViewGroup) r15).removeView(r12.shownPanelView);
    L58:
        r12.decorView.addView(r12.shownPanelView, r11);
        if (r12.shownPanelView.hasFocus() == true) goto L61;
        r12.shownPanelView.requestFocus();
    L61:
        int r4 = -2;
    L62:
        r12.isHandled = false;
        WindowManager.LayoutParams r16 = new WindowManager.LayoutParams(r4, -2, r12.x, r12.y, 1002, 8519680, -3);
        r16.gravity = r12.gravity;
        r16.windowAnimations = r12.windowAnimations;
        r1.addView(r12.decorView, r16);
        r12.isOpen = true;
        return;
    L43:
        if (r12.refreshDecorView == false) goto L48;
        if (r14.getChildCount() <= 0) goto L48;
        r12.decorView.removeAllViews();
        goto L48
    L27:
        if (r12.refreshDecorView == true) goto L36;
        View r17 = r12.createdPanelView;
        if (r17 == null) goto L61;
        ViewGroup.LayoutParams r18 = r17.getLayoutParams();
        if (r18 == null) goto L61;
        if (r18.width != (-1)) goto L61;
        r4 = -1;
        goto L62
    L15:
        if (r0.onMenuOpened(r12.featureId, r12.menu) == true) goto L18;
        closePanel(r12, true);
        return;
    L10:
        if ((this.mContext.getResources().getConfiguration().screenLayout & 15) != 4) goto L12;
    }

    private boolean performPanelShortcut(PanelFeatureState r3, int r4, KeyEvent r5, int r6) {
        boolean r1 = false;
        if (r5.isSystem() == false) goto L6;
        return false;
    L6:
        if (r3.isPrepared == false) goto L8;
    L9:
        MenuBuilder r0 = r3.menu;
        if (r0 == null) goto L12;
        r1 = r0.performShortcut(r4, r5, r6);
    L12:
        if (r1 == true) goto L14;
    L18:
        return r1;
    L14:
        if ((r6 & 1) != 0) goto L18;
        if (this.mDecorContentParent != null) goto L18;
        closePanel(r3, true);
        goto L18
    L8:
        if (preparePanel(r3, r5) == false) goto L12;
        goto L9
    }

    private boolean preparePanel(PanelFeatureState r9, KeyEvent r10) {
        if (this.mIsDestroyed == false) goto L6;
        return false;
    L6:
        if (r9.isPrepared == false) goto L8;
        return true;
    L8:
        PanelFeatureState r0 = this.mPreparedPanel;
        if (r0 == null) goto L12;
        if (r0 == r9) goto L12;
        closePanel(r0, false);
    L12:
        Window.Callback r1 = getWindowCallback();
        if (r1 == null) goto L15;
        r9.createdPanelView = r1.onCreatePanelView(r9.featureId);
    L15:
        int r3 = r9.featureId;
        if (r3 != 0) goto L18;
    L21:
        boolean r4 = true;
    L22:
        if (r4 == false) goto L27;
        DecorContentParent r5 = this.mDecorContentParent;
        if (r5 == null) goto L27;
        r5.setMenuPrepared();
    L27:
        if (r9.createdPanelView != null) goto L76;
        if (r4 == true) goto L30;
    L31:
        MenuBuilder r6 = r9.menu;
        if (r6 != null) goto L34;
    L35:
        if (r6 == null) goto L37;
    L41:
        if (r4 == true) goto L43;
    L48:
        r9.menu.stopDispatchingItemsChanged();
        if (r1.onCreatePanelMenu(r9.featureId, r9.menu) == true) goto L56;
        r9.setMenu(null);
        if (r4 == false) goto L55;
        DecorContentParent r11 = this.mDecorContentParent;
        if (r11 == null) goto L55;
        r11.setMenu(null, this.mActionMenuPresenterCallback);
    L55:
        return false;
    L56:
        r9.refreshMenuContent = false;
    L57:
        r9.menu.stopDispatchingItemsChanged();
        Bundle r7 = r9.frozenActionViewState;
        if (r7 == null) goto L61;
        r9.menu.restoreActionViewStates(r7);
        r9.frozenActionViewState = null;
    L61:
        if (r1.onPreparePanel(0, r9.createdPanelView, r9.menu) == true) goto L68;
        if (r4 == false) goto L66;
        DecorContentParent r12 = this.mDecorContentParent;
        if (r12 == null) goto L66;
        r12.setMenu(null, this.mActionMenuPresenterCallback);
    L66:
        r9.menu.startDispatchingItemsChanged();
        return false;
    L68:
        if (r10 == null) goto L70;
        int r13 = r10.getDeviceId();
    L72:
        if (KeyCharacterMap.load(r13).getKeyboardType() == 1) goto L74;
        boolean r14 = true;
    L75:
        r9.qwertyMode = r14;
        r9.menu.setQwertyMode(r14);
        r9.menu.startDispatchingItemsChanged();
        goto L76
    L74:
        r14 = false;
        goto L75
    L70:
        r13 = -1;
        goto L72
    L43:
        if (this.mDecorContentParent == null) goto L48;
        if (this.mActionMenuPresenterCallback != null) goto L47;
        this.mActionMenuPresenterCallback = new ActionMenuPresenterCallback(this);
    L47:
        this.mDecorContentParent.setMenu(r9.menu, this.mActionMenuPresenterCallback);
        goto L48
    L37:
        if (initializePanelMenu(r9) == true) goto L39;
    L40:
        return false;
    L39:
        if (r9.menu != null) goto L41;
    L34:
        if (r9.refreshMenuContent == false) goto L57;
    L30:
        if ((peekSupportActionBar() instanceof ToolbarActionBar) == false) goto L31;
    L76:
        r9.isPrepared = true;
        r9.isHandled = false;
        this.mPreparedPanel = r9;
        return true;
    L18:
        if (r3 == 108) goto L21;
        r4 = false;
        goto L22
    }

    private void reopenMenu(boolean r6) {
        DecorContentParent r0 = this.mDecorContentParent;
        if (r0 != null) goto L5;
    L33:
        PanelFeatureState r7 = getPanelState(0, true);
        r7.refreshDecorView = true;
        closePanel(r7, false);
        openPanel(r7, null);
        return;
    L5:
        if (r0.canShowOverflowMenu() == false) goto L33;
        if (ViewConfiguration.get(this.mContext).hasPermanentMenuKey() == true) goto L9;
    L10:
        Window.Callback r1 = getWindowCallback();
        if (this.mDecorContentParent.isOverflowMenuShowing() == false) goto L17;
        if (r6 == false) goto L17;
        this.mDecorContentParent.hideOverflowMenu();
        if (this.mIsDestroyed == true) goto L35;
        r1.onPanelClosed(108, getPanelState(0, true).menu);
        return;
    L35:
        return;
    L17:
        if (r1 != null) goto L19;
        return;
    L19:
        if (this.mIsDestroyed == false) goto L21;
        return;
    L21:
        if (this.mInvalidatePanelMenuPosted == true) goto L23;
    L25:
        PanelFeatureState r8 = getPanelState(0, true);
        MenuBuilder r2 = r8.menu;
        if (r2 != null) goto L28;
        return;
    L28:
        if (r8.refreshMenuContent == false) goto L30;
        return;
    L30:
        if (r1.onPreparePanel(0, r8.createdPanelView, r2) == false) goto L41;
        r1.onMenuOpened(108, r8.menu);
        this.mDecorContentParent.showOverflowMenu();
        return;
    L41:
        return;
    L23:
        if ((this.mInvalidatePanelMenuFeatures & 1) == 0) goto L25;
        this.mWindow.getDecorView().removeCallbacks(this.mInvalidatePanelMenuRunnable);
        this.mInvalidatePanelMenuRunnable.run();
        goto L25
    L9:
        if (this.mDecorContentParent.isOverflowMenuShowPending() == false) goto L33;
        goto L10
    }

    private int sanitizeWindowFeatureId(int r2) {
        if (r2 != 8) goto L7;
        Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
        return 108;
    L7:
        if (r2 != 9) goto L10;
        Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
        return 109;
    L10:
        return r2;
    }

    private boolean shouldInheritContext(ViewParent r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        View r2 = this.mWindow.getDecorView();
    L6:
        if (r3 == null) goto L7;
        if (r3 == r2) goto L16;
        if ((r3 instanceof View) == false) goto L16;
        if (ViewCompat.isAttachedToWindow((View) r3) == true) goto L16;
        r3 = r3.getParent();
    L16:
        return false;
    L7:
        return true;
    }

    private void throwFeatureRequestIfSubDecorInstalled() {
        if (this.mSubDecorInstalled == true) goto L6;
        return;
    L6:
        throw new AndroidRuntimeException("Window feature must be requested before adding content");
    }

    @Nullable
    private AppCompatActivity tryUnwrapContext() {
        Context r2 = this.mContext;
    L4:
        if (r2 == null) goto L12;
        if ((r2 instanceof AppCompatActivity) == true) goto L8;
        if ((r2 instanceof ContextWrapper) == false) goto L12;
        r2 = ((ContextWrapper) r2).getBaseContext();
        goto L4
    L8:
        return (AppCompatActivity) r2;
    L12:
        return null;
    }

    private boolean updateForNightMode(int r7, boolean r8) {
        Configuration r0 = createOverrideConfigurationForDayNight(this.mContext, r7, null);
        boolean r2 = isActivityManifestHandlingUiMode();
        int r3 = this.mContext.getResources().getConfiguration().uiMode & 48;
        int r1 = r0.uiMode & 48;
        boolean r4 = true;
        if (r3 == r1) goto L17;
        if (r8 == false) goto L17;
        if (r2 == true) goto L17;
        if (this.mBaseContextAttached == false) goto L17;
        if (sCanReturnDifferentContext == false) goto L11;
    L12:
        Object r9 = this.mHost;
        if ((r9 instanceof Activity) == false) goto L17;
        if (((Activity) r9).isChild() == true) goto L17;
        ActivityCompat.recreate((Activity) this.mHost);
        boolean r10 = true;
    L18:
        if (r10 == true) goto L21;
        if (r3 == r1) goto L21;
        updateResourcesConfigurationForNightMode(r1, r2, null);
    L22:
        if (r4 == false) goto L26;
        Object r6 = this.mHost;
        if ((r6 instanceof AppCompatActivity) == false) goto L26;
        ((AppCompatActivity) r6).onNightModeChanged(r7);
    L26:
        return r4;
    L21:
        r4 = r10;
        goto L22
    L11:
        if (this.mCreated == true) goto L12;
    L17:
        r10 = false;
        goto L18
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void updateResourcesConfigurationForNightMode(int r4, boolean r5, @Nullable Configuration r6) {
        Resources r0 = this.mContext.getResources();
        Configuration r1 = new Configuration(r0.getConfiguration());
        if (r6 == null) goto L5;
        r1.updateFrom(r6);
    L5:
        r1.uiMode = r4 | (r0.getConfiguration().uiMode & (-49));
        r0.updateConfiguration(r1, null);
        int r7 = this.mThemeResId;
        if (r7 == 0) goto L8;
        this.mContext.setTheme(r7);
        this.mContext.getTheme().applyStyle(this.mThemeResId, true);
    L8:
        if (r5 == false) goto L20;
        Object r8 = this.mHost;
        if ((r8 instanceof Activity) == false) goto L21;
        Activity r9 = (Activity) r8;
        if ((r9 instanceof LifecycleOwner) == false) goto L17;
        if (((LifecycleOwner) r9).getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == false) goto L22;
        r9.onConfigurationChanged(r1);
        return;
    L22:
        return;
    L17:
        if (this.mStarted == false) goto L24;
        r9.onConfigurationChanged(r1);
        return;
    L24:
        return;
    L21:
        return;
    }

    private void updateStatusGuardColor(View r2) {
        if ((ViewCompat.getWindowSystemUiVisibility(r2) & 8192) == 0) goto L5;
        int r1 = ContextCompat.getColor(this.mContext, R.color.abc_decor_view_status_guard_light);
    L6:
        r2.setBackgroundColor(r1);
        return;
    L5:
        r1 = ContextCompat.getColor(this.mContext, R.color.abc_decor_view_status_guard);
        goto L6
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void addContentView(View r3, ViewGroup.LayoutParams r4) {
        ensureSubDecor();
        ((ViewGroup) this.mSubDecor.findViewById(android.R.id.content)).addView(r3, r4);
        this.mAppCompatWindowCallback.getWrapped().onContentChanged();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public boolean applyDayNight() {
        return applyDayNight(true);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    @NonNull
    @CallSuper
    public Context attachBaseContext2(@NonNull Context r6) {
        this.mBaseContextAttached = true;
        int r0 = mapNightMode(r6, calculateNightMode());
        Configuration r2 = null;
        if (sCanApplyOverrideConfiguration == false) goto L10;
        if ((r6 instanceof ContextThemeWrapper) == false) goto L10;
        ContextThemeWrapperCompatApi17Impl.applyOverrideConfiguration((ContextThemeWrapper) r6, createOverrideConfigurationForDayNight(r6, r0, null));     // Catch: IllegalStateException -> L31
        return r6;
    L10:
        if ((r6 instanceof androidx.appcompat.view.ContextThemeWrapper) == false) goto L15;
        ((androidx.appcompat.view.ContextThemeWrapper) r6).applyOverrideConfiguration(createOverrideConfigurationForDayNight(r6, r0, null));     // Catch: IllegalStateException -> L32
        return r6;
    L15:
        if (sCanReturnDifferentContext == false) goto L17;
        Configuration r1 = r6.getPackageManager().getResourcesForApplication(r6.getApplicationInfo()).getConfiguration();     // Catch: PackageManager.NameNotFoundException -> L28
        Configuration r3 = r6.getResources().getConfiguration();
        if (r1.equals(r3) == true) goto L22;
        r2 = generateConfigDelta(r1, r3);
    L22:
        Configuration r4 = createOverrideConfigurationForDayNight(r6, r0, r2);
        androidx.appcompat.view.ContextThemeWrapper r5 = new androidx.appcompat.view.ContextThemeWrapper(r6, R.style.Theme_AppCompat_Empty);
        r5.applyOverrideConfiguration(r4);
        if (r6.getTheme() == null) goto L27;
        ResourcesCompat.ThemeCompat.rebase(r5.getTheme());
    L27:
        return super.attachBaseContext2(r5);
    L28:
        e = move-exception;
        throw new RuntimeException("Application failed to obtain resources from itself", e);
    L17:
        return super.attachBaseContext2(r6);
    }

    public void callOnPanelClosed(int r3, PanelFeatureState r4, Menu r5) {
        if (r5 != null) goto L10;
        if (r4 != null) goto L8;
        if (r3 < 0) goto L8;
        PanelFeatureState[] r0 = this.mPanels;
        if (r3 >= r0.length) goto L8;
        r4 = r0[r3];
    L8:
        if (r4 == null) goto L10;
        r5 = r4.menu;
    L10:
        if (r4 == null) goto L15;
        if (r4.isOpen == true) goto L15;
        return;
    L15:
        if (this.mIsDestroyed == true) goto L18;
        this.mAppCompatWindowCallback.getWrapped().onPanelClosed(r3, r5);
        return;
    }

    public void checkCloseActionMenu(@NonNull MenuBuilder r3) {
        if (this.mClosingActionMenu == false) goto L5;
        return;
    L5:
        this.mClosingActionMenu = true;
        this.mDecorContentParent.dismissPopups();
        Window.Callback r0 = getWindowCallback();
        if (r0 != null) goto L8;
    L10:
        this.mClosingActionMenu = false;
        return;
    L8:
        if (this.mIsDestroyed == true) goto L10;
        r0.onPanelClosed(108, r3);
        goto L10
    }

    public void closePanel(int r2) {
        closePanel(getPanelState(r2, true), true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.appcompat.app.AppCompatDelegate
    public View createView(View r11, String r12, @NonNull Context r13, @NonNull AttributeSet r14) {
        if (this.mAppCompatViewInflater != null) goto L11;
        String r0 = this.mContext.obtainStyledAttributes(R.styleable.AppCompatTheme).getString(R.styleable.AppCompatTheme_viewInflaterClass);
        if (r0 != null) goto L21;
        this.mAppCompatViewInflater = new AppCompatViewInflater();
        goto L11
    L21:
        this.mAppCompatViewInflater = (AppCompatViewInflater) Class.forName(r0).getDeclaredConstructor(null).newInstance(null);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        Log.i("AppCompatDelegate", "Failed to instantiate custom view inflater " + r0 + ". Falling back to default.", th);
        this.mAppCompatViewInflater = new AppCompatViewInflater();
    L11:
        boolean r7 = IS_PRE_LOLLIPOP;
        boolean r1 = false;
        if (r7 == false) goto L20;
        if ((r14 instanceof XmlPullParser) == true) goto L16;
        r1 = shouldInheritContext((ViewParent) r11);
        goto L20
    L16:
        if (((XmlPullParser) r14).getDepth() <= 1) goto L20;
        r1 = true;
    L20:
        return this.mAppCompatViewInflater.createView(r11, r12, r13, r14, r1, r7, true, VectorEnabledTintResources.shouldBeUsed());
    }

    public void dismissPopups() {
        DecorContentParent r0 = this.mDecorContentParent;
        if (r0 == null) goto L6;
        r0.dismissPopups();
    L6:
        if (this.mActionModePopup == null) goto L11;
        this.mWindow.getDecorView().removeCallbacks(this.mShowActionModePopup);
        if (this.mActionModePopup.isShowing() == true) goto L18;
    L10:
        this.mActionModePopup = null;
        goto L11
    L18:
        this.mActionModePopup.dismiss();     // Catch: IllegalArgumentException -> L17
    L11:
        endOnGoingFadeAnimation();
        PanelFeatureState r2 = getPanelState(0, false);
        if (r2 == null) goto L20;
        MenuBuilder r3 = r2.menu;
        if (r3 == null) goto L21;
        r3.close();
        return;
    L21:
        return;
    }

    public boolean dispatchKeyEvent(KeyEvent r4) {
        Object r0 = this.mHost;
        if ((r0 instanceof KeyEventDispatcher.Component) == false) goto L5;
    L6:
        View r1 = this.mWindow.getDecorView();
        if (r1 != null) goto L9;
    L12:
        if (r4.getKeyCode() == 82) goto L14;
    L16:
        int r2 = r4.getKeyCode();
        if (r4.getAction() != 0) goto L20;
        return onKeyDown(r2, r4);
    L20:
        return onKeyUp(r2, r4);
    L14:
        if (this.mAppCompatWindowCallback.getWrapped().dispatchKeyEvent(r4) == false) goto L16;
        return true;
    L9:
        if (KeyEventDispatcher.dispatchBeforeHierarchy(r1, r4) == false) goto L12;
        return true;
    L5:
        if ((r0 instanceof AppCompatDialog) == false) goto L12;
        goto L6
    }

    public void doInvalidatePanelMenu(int r5) {
        PanelFeatureState r1 = getPanelState(r5, true);
        if (r1.menu == null) goto L8;
        Bundle r2 = new Bundle();
        r1.menu.saveActionViewStates(r2);
        if (r2.size() <= 0) goto L7;
        r1.frozenActionViewState = r2;
    L7:
        r1.menu.stopDispatchingItemsChanged();
        r1.menu.clear();
    L8:
        r1.refreshMenuContent = true;
        r1.refreshDecorView = true;
        if (r5 == 108) goto L12;
        if (r5 == 0) goto L12;
        return;
    L12:
        if (this.mDecorContentParent == null) goto L18;
        PanelFeatureState r0 = getPanelState(0, false);
        if (r0 == null) goto L19;
        r0.isPrepared = false;
        preparePanel(r0, null);
        return;
    L19:
        return;
    }

    public void endOnGoingFadeAnimation() {
        ViewPropertyAnimatorCompat r0 = this.mFadeAnim;
        if (r0 == null) goto L6;
        r0.cancel();
        return;
    }

    public PanelFeatureState findMenuPanel(Menu r5) {
        PanelFeatureState[] r4 = this.mPanels;
        int r0 = 0;
        if (r4 == null) goto L5;
        int r1 = r4.length;
    L6:
        if (r0 >= r1) goto L13;
        PanelFeatureState r2 = r4[r0];
        if (r2 == null) goto L12;
        if (r2.menu != r5) goto L12;
        return r2;
    L12:
        r0 = r0 + 1;
        goto L6
    L13:
        return null;
    L5:
        r1 = 0;
        goto L6
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    @Nullable
    public <T extends View> T findViewById(@IdRes int r1) {
        ensureSubDecor();
        return (T) this.mWindow.findViewById(r1);
    }

    public final Context getActionBarThemedContext() {
        ActionBar r0 = getSupportActionBar();
        if (r0 == null) goto L5;
        Context r1 = r0.getThemedContext();
    L6:
        if (r1 == null) goto L8;
        return r1;
    L8:
        return this.mContext;
    L5:
        r1 = null;
        goto L6
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @VisibleForTesting
    public final AutoNightModeManager getAutoTimeNightModeManager() {
        return getAutoTimeNightModeManager(this.mContext);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final ActionBarDrawerToggle.Delegate getDrawerToggleDelegate() {
        return new ActionBarDrawableToggleImpl(this);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public int getLocalNightMode() {
        return this.mLocalNightMode;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public MenuInflater getMenuInflater() {
        if (this.mMenuInflater != null) goto L10;
        initWindowDecorActionBar();
        ActionBar r1 = this.mActionBar;
        if (r1 == null) goto L7;
        Context r2 = r1.getThemedContext();
    L8:
        this.mMenuInflater = new SupportMenuInflater(r2);
        goto L10
    L7:
        r2 = this.mContext;
    L10:
        return this.mMenuInflater;
    }

    public PanelFeatureState getPanelState(int r4, boolean r5) {
        PanelFeatureState[] r6 = this.mPanels;
        if (r6 != null) goto L5;
    L6:
        PanelFeatureState[] r0 = new PanelFeatureState[r4 + 1];
        if (r6 == null) goto L9;
        System.arraycopy(r6, 0, r0, 0, r6.length);
    L9:
        this.mPanels = r0;
        r6 = r0;
    L10:
        PanelFeatureState r3 = r6[r4];
        if (r3 != null) goto L14;
        PanelFeatureState r7 = new PanelFeatureState(r4);
        r6[r4] = r7;
        return r7;
    L14:
        return r3;
    L5:
        if (r6.length > r4) goto L10;
        goto L6
    }

    public ViewGroup getSubDecor() {
        return this.mSubDecor;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public ActionBar getSupportActionBar() {
        initWindowDecorActionBar();
        return this.mActionBar;
    }

    public final CharSequence getTitle() {
        Object r0 = this.mHost;
        if ((r0 instanceof Activity) == false) goto L7;
        return ((Activity) r0).getTitle();
    L7:
        return this.mTitle;
    }

    public final Window.Callback getWindowCallback() {
        return this.mWindow.getCallback();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public boolean hasWindowFeature(int r5) {
        int r0 = sanitizeWindowFeatureId(r5);
        if (r0 != 1) goto L5;
        boolean r1 = this.mWindowNoTitle;
    L21:
        if (r1 == false) goto L23;
        return true;
    L23:
        if (this.mWindow.hasFeature(r5) == false) goto L26;
        return true;
    L26:
        return false;
    L5:
        if (r0 != 2) goto L7;
        r1 = this.mFeatureProgress;
        goto L21
    L7:
        if (r0 != 5) goto L9;
        r1 = this.mFeatureIndeterminateProgress;
        goto L21
    L9:
        if (r0 != 10) goto L11;
        r1 = this.mOverlayActionMode;
        goto L21
    L11:
        if (r0 != 108) goto L13;
        r1 = this.mHasActionBar;
        goto L21
    L13:
        if (r0 == 109) goto L15;
        r1 = false;
        goto L21
    L15:
        r1 = this.mOverlayActionBar;
        goto L21
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void installViewFactory() {
        LayoutInflater r0 = LayoutInflater.from(this.mContext);
        if (r0.getFactory() != null) goto L6;
        LayoutInflaterCompat.setFactory2(r0, this);
        return;
    L6:
        if ((r0.getFactory2() instanceof AppCompatDelegateImpl) == true) goto L10;
        Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        return;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void invalidateOptionsMenu() {
        ActionBar r0 = getSupportActionBar();
        if (r0 != null) goto L5;
    L7:
        invalidatePanelMenu(0);
        return;
    L5:
        if (r0.invalidateOptionsMenu() == false) goto L7;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public boolean isHandleNativeActionModesEnabled() {
        return this.mHandleNativeActionModes;
    }

    public int mapNightMode(@NonNull Context r3, int r4) {
        if (r4 == (-100)) goto L22;
        if (r4 == (-1)) goto L21;
        if (r4 == 0) goto L17;
        if (r4 == 1) goto L21;
        if (r4 == 2) goto L21;
        if (r4 != 3) goto L15;
        return getAutoBatteryNightModeManager(r3).getApplyableNightMode();
    L15:
        throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
    L17:
        if (((UiModeManager) r3.getApplicationContext().getSystemService(UiModeManager.class)).getNightMode() != 0) goto L20;
        return -1;
    L20:
        return getAutoTimeNightModeManager(r3).getApplyableNightMode();
    L21:
        return r4;
    L22:
        return -1;
    }

    public boolean onBackPressed() {
        ActionMode r0 = this.mActionMode;
        if (r0 == null) goto L6;
        r0.finish();
        return true;
    L6:
        ActionBar r2 = getSupportActionBar();
        if (r2 != null) goto L9;
        return false;
    L9:
        if (r2.collapseActionView() == false) goto L13;
        return true;
    L13:
        return false;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onConfigurationChanged(Configuration r2) {
        if (this.mHasActionBar == true) goto L5;
    L9:
        AppCompatDrawableManager.get().onConfigurationChanged(this.mContext);
        applyDayNight(false);
        return;
    L5:
        if (this.mSubDecorInstalled == false) goto L9;
        ActionBar r0 = getSupportActionBar();
        if (r0 == null) goto L9;
        r0.onConfigurationChanged(r2);
        goto L9
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onCreate(Bundle r3) {
        this.mBaseContextAttached = true;
        applyDayNight(false);
        ensureWindow();
        Object r0 = this.mHost;
        if ((r0 instanceof Activity) == true) goto L15;
    L13:
        this.mCreated = true;
        return;
    L15:
        String r1 = NavUtils.getParentActivityName((Activity) r0);     // Catch: IllegalArgumentException -> L6
    L7:
        if (r1 == null) goto L12;
        ActionBar r2 = peekSupportActionBar();
        if (r2 != null) goto L11;
        this.mEnableDefaultActionBarUp = true;
        goto L12
    L11:
        r2.setDefaultDisplayHomeAsUpEnabled(true);
    L12:
        AppCompatDelegate.addActiveDelegate(this);
    L6:
        r1 = null;
        goto L7
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View r1, String r2, Context r3, AttributeSet r4) {
        return createView(r1, r2, r3, r4);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onDestroy() {
        if ((this.mHost instanceof Activity) == false) goto L6;
        AppCompatDelegate.removeActivityDelegate(this);
    L6:
        if (this.mInvalidatePanelMenuPosted == false) goto L8;
        this.mWindow.getDecorView().removeCallbacks(this.mInvalidatePanelMenuRunnable);
    L8:
        this.mStarted = false;
        this.mIsDestroyed = true;
        if (this.mLocalNightMode == (-100)) goto L15;
        Object r0 = this.mHost;
        if ((r0 instanceof Activity) == false) goto L15;
        if (((Activity) r0).isChangingConfigurations() == false) goto L15;
        sLocalNightModes.put(this.mHost.getClass().getName(), Integer.valueOf(this.mLocalNightMode));
    L16:
        ActionBar r1 = this.mActionBar;
        if (r1 == null) goto L19;
        r1.onDestroy();
    L19:
        cleanupAutoManagers();
        return;
    L15:
        sLocalNightModes.remove(this.mHost.getClass().getName());
        goto L16
    }

    public boolean onKeyDown(int r4, KeyEvent r5) {
        boolean r1 = true;
        if (r4 == 4) goto L10;
        if (r4 != 82) goto L14;
        onKeyDownPanel(0, r5);
        return true;
    L14:
        return false;
    L10:
        if ((r5.getFlags() & 128) != 0) goto L13;
        r1 = false;
    L13:
        this.mLongPressBackDown = r1;
        goto L14
    }

    public boolean onKeyShortcut(int r4, KeyEvent r5) {
        ActionBar r0 = getSupportActionBar();
        if (r0 != null) goto L5;
    L7:
        PanelFeatureState r6 = this.mPreparedPanel;
        if (r6 == null) goto L16;
        if (performPanelShortcut(r6, r5.getKeyCode(), r5, 1) == false) goto L16;
        PanelFeatureState r3 = this.mPreparedPanel;
        if (r3 == null) goto L14;
        r3.isHandled = true;
    L14:
        return true;
    L16:
        if (this.mPreparedPanel != null) goto L20;
        PanelFeatureState r7 = getPanelState(0, true);
        preparePanel(r7, r5);
        boolean r8 = performPanelShortcut(r7, r5.getKeyCode(), r5, 1);
        r7.isPrepared = false;
        if (r8 == false) goto L20;
        return true;
    L20:
        return false;
    L5:
        if (r0.onKeyShortcut(r4, r5) == false) goto L7;
        return true;
    }

    public boolean onKeyUp(int r4, KeyEvent r5) {
        if (r4 != 4) goto L5;
        boolean r6 = this.mLongPressBackDown;
        this.mLongPressBackDown = false;
        PanelFeatureState r7 = getPanelState(0, false);
        if (r7 == null) goto L17;
        if (r7.isOpen == false) goto L17;
        if (r6 == true) goto L15;
        closePanel(r7, true);
    L15:
        return true;
    L17:
        if (onBackPressed() == false) goto L19;
        return true;
    L19:
        return false;
    L5:
        if (r4 != 82) goto L19;
        onKeyUpPanel(0, r5);
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
    public boolean onMenuItemSelected(@NonNull MenuBuilder r3, @NonNull MenuItem r4) {
        Window.Callback r0 = getWindowCallback();
        if (r0 != null) goto L5;
        return false;
    L5:
        if (this.mIsDestroyed == true) goto L12;
        PanelFeatureState r2 = findMenuPanel(r3.getRootMenu());
        if (r2 != null) goto L9;
        return false;
    L9:
        return r0.onMenuItemSelected(r2.featureId, r4);
    L12:
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
    public void onMenuModeChange(@NonNull MenuBuilder r1) {
        reopenMenu(true);
    }

    public void onMenuOpened(int r2) {
        if (r2 != 108) goto L8;
        ActionBar r1 = getSupportActionBar();
        if (r1 == null) goto L9;
        r1.dispatchMenuVisibilityChanged(true);
        return;
    L9:
        return;
    }

    public void onPanelClosed(int r3) {
        if (r3 != 108) goto L7;
        ActionBar r2 = getSupportActionBar();
        if (r2 == null) goto L12;
        r2.dispatchMenuVisibilityChanged(false);
        return;
    L12:
        return;
    L7:
        if (r3 != 0) goto L14;
        PanelFeatureState r4 = getPanelState(r3, true);
        if (r4.isOpen == false) goto L15;
        closePanel(r4, false);
        return;
    L15:
        return;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onPostCreate(Bundle r1) {
        ensureSubDecor();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onPostResume() {
        ActionBar r1 = getSupportActionBar();
        if (r1 == null) goto L6;
        r1.setShowHideAnimationEnabled(true);
        return;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onSaveInstanceState(Bundle r1) {
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onStart() {
        this.mStarted = true;
        applyDayNight();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onStop() {
        this.mStarted = false;
        ActionBar r1 = getSupportActionBar();
        if (r1 == null) goto L6;
        r1.setShowHideAnimationEnabled(false);
        return;
    }

    public void onSubDecorInstalled(ViewGroup r1) {
    }

    public final ActionBar peekSupportActionBar() {
        return this.mActionBar;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public boolean requestWindowFeature(int r5) {
        int r6 = sanitizeWindowFeatureId(r5);
        if (this.mWindowNoTitle == false) goto L7;
        if (r6 != 108) goto L7;
        return false;
    L7:
        if (this.mHasActionBar == false) goto L10;
        if (r6 != 1) goto L10;
        this.mHasActionBar = false;
    L10:
        if (r6 != 1) goto L12;
        throwFeatureRequestIfSubDecorInstalled();
        this.mWindowNoTitle = true;
        return true;
    L12:
        if (r6 != 2) goto L14;
        throwFeatureRequestIfSubDecorInstalled();
        this.mFeatureProgress = true;
        return true;
    L14:
        if (r6 != 5) goto L16;
        throwFeatureRequestIfSubDecorInstalled();
        this.mFeatureIndeterminateProgress = true;
        return true;
    L16:
        if (r6 == 10) goto L26;
        if (r6 != 108) goto L19;
        throwFeatureRequestIfSubDecorInstalled();
        this.mHasActionBar = true;
        return true;
    L19:
        if (r6 != 109) goto L21;
        throwFeatureRequestIfSubDecorInstalled();
        this.mOverlayActionBar = true;
        return true;
    L21:
        return this.mWindow.requestFeature(r6);
    L26:
        throwFeatureRequestIfSubDecorInstalled();
        this.mOverlayActionMode = true;
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void setContentView(View r3) {
        ensureSubDecor();
        ViewGroup r0 = (ViewGroup) this.mSubDecor.findViewById(android.R.id.content);
        r0.removeAllViews();
        r0.addView(r3);
        this.mAppCompatWindowCallback.getWrapped().onContentChanged();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void setHandleNativeActionModesEnabled(boolean r1) {
        this.mHandleNativeActionModes = r1;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    @RequiresApi(17)
    public void setLocalNightMode(int r2) {
        if (this.mLocalNightMode == r2) goto L8;
        this.mLocalNightMode = r2;
        if (this.mBaseContextAttached == false) goto L9;
        applyDayNight();
        return;
    L9:
        return;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void setSupportActionBar(Toolbar r4) {
        if ((this.mHost instanceof Activity) == true) goto L5;
        return;
    L5:
        ActionBar r0 = getSupportActionBar();
        if ((r0 instanceof WindowDecorActionBar) == true) goto L16;
        this.mMenuInflater = null;
        if (r0 == null) goto L10;
        r0.onDestroy();
    L10:
        if (r4 == null) goto L12;
        ToolbarActionBar r1 = new ToolbarActionBar(r4, getTitle(), this.mAppCompatWindowCallback);
        this.mActionBar = r1;
        this.mWindow.setCallback(r1.getWrappedWindowCallback());
    L13:
        invalidateOptionsMenu();
        return;
    L12:
        this.mActionBar = null;
        this.mWindow.setCallback(this.mAppCompatWindowCallback);
        goto L13
    L16:
        throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void setTheme(@StyleRes int r1) {
        this.mThemeResId = r1;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void setTitle(CharSequence r2) {
        this.mTitle = r2;
        DecorContentParent r0 = this.mDecorContentParent;
        if (r0 == null) goto L6;
        r0.setWindowTitle(r2);
        return;
    L6:
        if (peekSupportActionBar() == null) goto L8;
        peekSupportActionBar().setWindowTitle(r2);
        return;
    L8:
        TextView r1 = this.mTitleView;
        if (r1 == null) goto L14;
        r1.setText(r2);
        return;
    }

    public final boolean shouldAnimateActionModeView() {
        if (this.mSubDecorInstalled == false) goto L9;
        ViewGroup r1 = this.mSubDecor;
        if (r1 == null) goto L9;
        if (ViewCompat.isLaidOut(r1) == false) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public ActionMode startSupportActionMode(@NonNull ActionMode.Callback r3) {
        if (r3 == null) goto L19;
        ActionMode r0 = this.mActionMode;
        if (r0 == null) goto L6;
        r0.finish();
    L6:
        ActionModeCallbackWrapperV9 r1 = new ActionModeCallbackWrapperV9(this, r3);
        ActionBar r4 = getSupportActionBar();
        if (r4 == null) goto L14;
        ActionMode r5 = r4.startActionMode(r1);
        this.mActionMode = r5;
        if (r5 == null) goto L14;
        AppCompatCallback r2 = this.mAppCompatCallback;
        if (r2 == null) goto L14;
        r2.onSupportActionModeStarted(r5);
    L14:
        if (this.mActionMode != null) goto L17;
        this.mActionMode = startSupportActionModeFromWindow(r1);
    L17:
        return this.mActionMode;
    L19:
        throw new IllegalArgumentException("ActionMode callback can not be null.");
    }

    public ActionMode startSupportActionModeFromWindow(@NonNull ActionMode.Callback r8) {
        endOnGoingFadeAnimation();
        ActionMode r0 = this.mActionMode;
        if (r0 == null) goto L6;
        r0.finish();
    L6:
        if ((r8 instanceof ActionModeCallbackWrapperV9) == true) goto L8;
        r8 = new ActionModeCallbackWrapperV9(this, r8);
    L8:
        AppCompatCallback r1 = this.mAppCompatCallback;
        if (r1 != null) goto L11;
    L14:
        ActionMode r2 = null;
    L15:
        if (r2 == null) goto L17;
        this.mActionMode = r2;
    L47:
        ActionMode r9 = this.mActionMode;
        if (r9 == null) goto L53;
        AppCompatCallback r3 = this.mAppCompatCallback;
        if (r3 == null) goto L53;
        r3.onSupportActionModeStarted(r9);
    L53:
        return this.mActionMode;
    L17:
        boolean r4 = true;
        if (this.mActionModeView != null) goto L30;
        if (this.mIsFloating == false) goto L26;
        TypedValue r5 = new TypedValue();
        Resources.Theme r6 = this.mContext.getTheme();
        r6.resolveAttribute(R.attr.actionBarTheme, r5, true);
        if (r5.resourceId == 0) goto L24;
        Resources.Theme r7 = this.mContext.getResources().newTheme();
        r7.setTo(r6);
        r7.applyStyle(r5.resourceId, true);
        Context r10 = new androidx.appcompat.view.ContextThemeWrapper(this.mContext, 0);
        r10.getTheme().setTo(r7);
    L25:
        this.mActionModeView = new ActionBarContextView(r10);
        PopupWindow r11 = new PopupWindow(r10, null, R.attr.actionModePopupWindowStyle);
        this.mActionModePopup = r11;
        PopupWindowCompat.setWindowLayoutType(r11, 2);
        this.mActionModePopup.setContentView(this.mActionModeView);
        this.mActionModePopup.setWidth(-1);
        r10.getTheme().resolveAttribute(R.attr.actionBarSize, r5, true);
        this.mActionModeView.setContentHeight(TypedValue.complexToDimensionPixelSize(r5.data, r10.getResources().getDisplayMetrics()));
        this.mActionModePopup.setHeight(-2);
        this.mShowActionModePopup = new AnonymousClass6(this);
        goto L30
    L24:
        r10 = this.mContext;
        goto L25
    L26:
        ViewStubCompat r12 = (ViewStubCompat) this.mSubDecor.findViewById(R.id.action_mode_bar_stub);
        if (r12 == null) goto L30;
        r12.setLayoutInflater(LayoutInflater.from(getActionBarThemedContext()));
        this.mActionModeView = (ActionBarContextView) r12.inflate();
    L30:
        if (this.mActionModeView == null) goto L47;
        endOnGoingFadeAnimation();
        this.mActionModeView.killMode();
        Context r13 = this.mActionModeView.getContext();
        ActionBarContextView r14 = this.mActionModeView;
        if (this.mActionModePopup == null) goto L35;
        r4 = false;
    L35:
        StandaloneActionMode r15 = new StandaloneActionMode(r13, r14, r8, r4);
        if (r8.onCreateActionMode(r15, r15.getMenu()) == false) goto L46;
        r15.invalidate();
        this.mActionModeView.initForMode(r15);
        this.mActionMode = r15;
        if (shouldAnimateActionModeView() == false) goto L40;
        this.mActionModeView.setAlpha(0.0f);
        ViewPropertyAnimatorCompat r16 = ViewCompat.animate(this.mActionModeView).alpha(1.0f);
        this.mFadeAnim = r16;
        r16.setListener(new AnonymousClass7(this));
    L44:
        if (this.mActionModePopup == null) goto L47;
        this.mWindow.getDecorView().post(this.mShowActionModePopup);
        goto L47
    L40:
        this.mActionModeView.setAlpha(1.0f);
        this.mActionModeView.setVisibility(0);
        this.mActionModeView.sendAccessibilityEvent(32);
        if ((this.mActionModeView.getParent() instanceof View) == false) goto L44;
        ViewCompat.requestApplyInsets((View) this.mActionModeView.getParent());
        goto L44
    L46:
        this.mActionMode = null;
        goto L47
    L11:
        if (this.mIsDestroyed == true) goto L14;
        r2 = r1.onWindowStartingSupportActionMode(r8);     // Catch: AbstractMethodError -> L54
        goto L15
    }

    public final int updateStatusGuard(@Nullable WindowInsetsCompat r11, @Nullable Rect r12) {
        int r0 = 0;
        if (r11 == null) goto L5;
        int r1 = r11.getSystemWindowInsetTop();
    L8:
        ActionBarContextView r2 = this.mActionModeView;
        if (r2 != null) goto L11;
    L69:
        boolean r13 = false;
    L70:
        View r10 = this.mStatusGuard;
        if (r10 == null) goto L76;
        if (r13 == true) goto L75;
        r0 = 8;
    L75:
        r10.setVisibility(r0);
    L76:
        return r1;
    L11:
        if ((r2.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) == false) goto L69;
        ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) this.mActionModeView.getLayoutParams();
        boolean r5 = true;
        if (this.mActionModeView.isShown() == false) goto L64;
        if (this.mTempRect1 != null) goto L17;
        this.mTempRect1 = new Rect();
        this.mTempRect2 = new Rect();
    L17:
        Rect r4 = this.mTempRect1;
        Rect r6 = this.mTempRect2;
        if (r11 != null) goto L20;
        r4.set(r12);
    L21:
        ViewUtils.computeFitSystemWindows(this.mSubDecor, r4, r6);
        int r14 = r4.top;
        int r15 = r4.left;
        int r7 = r4.right;
        WindowInsetsCompat r8 = ViewCompat.getRootWindowInsets(this.mSubDecor);
        if (r8 != null) goto L24;
        int r9 = 0;
    L25:
        if (r8 != null) goto L27;
        int r16 = 0;
    L29:
        if (r3.topMargin == r14) goto L31;
    L36:
        r3.topMargin = r14;
        r3.leftMargin = r15;
        r3.rightMargin = r7;
        boolean r17 = true;
    L37:
        if (r14 > 0) goto L39;
    L41:
        View r18 = this.mStatusGuard;
        if (r18 == null) goto L50;
        ViewGroup.MarginLayoutParams r19 = (ViewGroup.MarginLayoutParams) r18.getLayoutParams();
        int r20 = r19.height;
        int r21 = r3.topMargin;
        if (r20 == r21) goto L46;
    L49:
        r19.height = r21;
        r19.leftMargin = r9;
        r19.rightMargin = r16;
        this.mStatusGuard.setLayoutParams(r19);
        goto L50
    L46:
        if (r19.leftMargin != r9) goto L49;
        if (r19.rightMargin != r16) goto L49;
    L50:
        View r110 = this.mStatusGuard;
        if (r110 != null) goto L54;
        r5 = false;
    L54:
        if (r5 == false) goto L59;
        if (r110.getVisibility() == 0) goto L59;
        updateStatusGuardColor(this.mStatusGuard);
    L59:
        if (this.mOverlayActionMode == true) goto L62;
        if (r5 == false) goto L62;
        r1 = 0;
    L62:
        r13 = r5;
        r5 = r17;
    L67:
        if (r5 == false) goto L70;
        this.mActionModeView.setLayoutParams(r3);
        goto L70
    L39:
        if (this.mStatusGuard != null) goto L41;
        View r111 = new View(this.mContext);
        this.mStatusGuard = r111;
        r111.setVisibility(8);
        FrameLayout.LayoutParams r112 = new FrameLayout.LayoutParams(-1, r3.topMargin, 51);
        r112.leftMargin = r9;
        r112.rightMargin = r16;
        this.mSubDecor.addView(this.mStatusGuard, -1, r112);
        goto L50
    L31:
        if (r3.leftMargin != r15) goto L36;
        if (r3.rightMargin != r7) goto L36;
        r17 = false;
        goto L37
    L27:
        r16 = r8.getSystemWindowInsetRight();
        goto L29
    L24:
        r9 = r8.getSystemWindowInsetLeft();
        goto L25
    L20:
        r4.set(r11.getSystemWindowInsetLeft(), r11.getSystemWindowInsetTop(), r11.getSystemWindowInsetRight(), r11.getSystemWindowInsetBottom());
        goto L21
    L64:
        if (r3.topMargin == 0) goto L66;
        r3.topMargin = 0;
        r13 = false;
        goto L67
    L66:
        r13 = false;
        r5 = false;
        goto L67
    L5:
        if (r12 == null) goto L7;
        r1 = r12.top;
        goto L8
    L7:
        r1 = 0;
        goto L8
    }

    public AppCompatDelegateImpl(Dialog r3, AppCompatCallback r4) {
        this(r3.getContext(), r3.getWindow(), r4, r3);
    }

    private boolean applyDayNight(boolean r3) {
        if (this.mIsDestroyed == false) goto L6;
        return false;
    L6:
        int r0 = calculateNightMode();
        boolean r4 = updateForNightMode(mapNightMode(this.mContext, r0), r3);
        if (r0 != 0) goto L9;
        getAutoTimeNightModeManager(this.mContext).setup();
    L13:
        if (r0 != 3) goto L15;
        getAutoBatteryNightModeManager(this.mContext).setup();
    L18:
        return r4;
    L15:
        AutoNightModeManager r2 = this.mAutoBatteryNightModeManager;
        if (r2 == null) goto L18;
        r2.cleanup();
        goto L18
    L9:
        AutoNightModeManager r1 = this.mAutoTimeNightModeManager;
        if (r1 == null) goto L13;
        r1.cleanup();
        goto L13
    }

    private AutoNightModeManager getAutoTimeNightModeManager(@NonNull Context r2) {
        if (this.mAutoTimeNightModeManager != null) goto L6;
        this.mAutoTimeNightModeManager = new AutoTimeNightModeManager(this, TwilightManager.getInstance(r2));
    L6:
        return this.mAutoTimeNightModeManager;
    }

    public void closePanel(PanelFeatureState r4, boolean r5) {
        if (r5 == true) goto L4;
    L11:
        WindowManager r0 = (WindowManager) this.mContext.getSystemService("window");
        if (r0 != null) goto L14;
    L20:
        r4.isPrepared = false;
        r4.isHandled = false;
        r4.isOpen = false;
        r4.shownPanelView = null;
        r4.refreshDecorView = true;
        if (this.mPreparedPanel != r4) goto L24;
        this.mPreparedPanel = null;
        return;
    L24:
        return;
    L14:
        if (r4.isOpen == false) goto L20;
        ViewGroup r2 = r4.decorView;
        if (r2 == null) goto L20;
        r0.removeView(r2);
        if (r5 == false) goto L20;
        callOnPanelClosed(r4.featureId, r4, null);
        goto L20
    L4:
        if (r4.featureId != 0) goto L11;
        DecorContentParent r1 = this.mDecorContentParent;
        if (r1 == null) goto L11;
        if (r1.isOverflowMenuShowing() == false) goto L11;
        checkCloseActionMenu(r4.menu);
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String r2, Context r3, AttributeSet r4) {
        return onCreateView(null, r2, r3, r4);
    }

    public AppCompatDelegateImpl(Context r1, Window r2, AppCompatCallback r3) {
        this(r1, r2, r3, r1);
    }

    public AppCompatDelegateImpl(Context r2, Activity r3, AppCompatCallback r4) {
        this(r2, null, r4, r3);
    }

    private AppCompatDelegateImpl(Context r3, Window r4, AppCompatCallback r5, Object r6) {
        this.mFadeAnim = null;
        this.mHandleNativeActionModes = true;
        this.mLocalNightMode = -100;
        this.mInvalidatePanelMenuRunnable = new AnonymousClass2(this);
        this.mContext = r3;
        this.mAppCompatCallback = r5;
        this.mHost = r6;
        if (this.mLocalNightMode != (-100)) goto L10;
        if ((r6 instanceof Dialog) == false) goto L10;
        AppCompatActivity r7 = tryUnwrapContext();
        if (r7 == null) goto L10;
        this.mLocalNightMode = r7.getDelegate().getLocalNightMode();
    L10:
        if (this.mLocalNightMode != (-100)) goto L14;
        SimpleArrayMap<String, Integer> r8 = sLocalNightModes;
        Integer r9 = r8.get(r6.getClass().getName());
        if (r9 == null) goto L14;
        this.mLocalNightMode = r9.intValue();
        r8.remove(r6.getClass().getName());
    L14:
        if (r4 == null) goto L16;
        attachToWindow(r4);
    L16:
        AppCompatDrawableManager.preload();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void setContentView(int r3) {
        ensureSubDecor();
        ViewGroup r0 = (ViewGroup) this.mSubDecor.findViewById(android.R.id.content);
        r0.removeAllViews();
        LayoutInflater.from(this.mContext).inflate(r3, r0);
        this.mAppCompatWindowCallback.getWrapped().onContentChanged();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void setContentView(View r3, ViewGroup.LayoutParams r4) {
        ensureSubDecor();
        ViewGroup r0 = (ViewGroup) this.mSubDecor.findViewById(android.R.id.content);
        r0.removeAllViews();
        r0.addView(r3, r4);
        this.mAppCompatWindowCallback.getWrapped().onContentChanged();
    }
}
