package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat;
import androidx.appcompat.resources.R;
import androidx.collection.LongSparseArray;
import androidx.collection.LruCache;
import androidx.collection.SimpleArrayMap;
import androidx.collection.SparseArrayCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class ResourceManagerInternal {
    private static final ColorFilterLruCache COLOR_FILTER_CACHE = null;
    private static final boolean DEBUG = false;
    private static final PorterDuff.Mode DEFAULT_MODE = null;
    private static ResourceManagerInternal INSTANCE = null;
    private static final String PLATFORM_VD_CLAZZ = "android.graphics.drawable.VectorDrawable";
    private static final String SKIP_DRAWABLE_TAG = "appcompat_skip_skip";
    private static final String TAG = "ResourceManagerInternal";
    private SimpleArrayMap<String, InflateDelegate> mDelegates;
    private final WeakHashMap<Context, LongSparseArray<WeakReference<Drawable.ConstantState>>> mDrawableCaches;
    private boolean mHasCheckedVectorDrawableSetup;
    private ResourceManagerHooks mHooks;
    private SparseArrayCompat<String> mKnownDrawableIdTags;
    private WeakHashMap<Context, SparseArrayCompat<ColorStateList>> mTintLists;
    private TypedValue mTypedValue;

    @RequiresApi(11)
    public static class AsldcInflateDelegate implements InflateDelegate {
        public AsldcInflateDelegate() {
        }

        @Override // androidx.appcompat.widget.ResourceManagerInternal.InflateDelegate
        public Drawable createFromXmlInner(@NonNull Context r1, @NonNull XmlPullParser r2, @NonNull AttributeSet r3, @Nullable Resources.Theme r4) {
            return AnimatedStateListDrawableCompat.createFromXmlInner(r1, r1.getResources(), r2, r3, r4);
        L4:
            e = move-exception;
            Log.e("AsldcInflateDelegate", "Exception while inflating <animated-selector>", e);
            return null;
        }
    }

    public static class AvdcInflateDelegate implements InflateDelegate {
        public AvdcInflateDelegate() {
        }

        @Override // androidx.appcompat.widget.ResourceManagerInternal.InflateDelegate
        public Drawable createFromXmlInner(@NonNull Context r1, @NonNull XmlPullParser r2, @NonNull AttributeSet r3, @Nullable Resources.Theme r4) {
            return AnimatedVectorDrawableCompat.createFromXmlInner(r1, r1.getResources(), r2, r3, r4);
        L4:
            e = move-exception;
            Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e);
            return null;
        }
    }

    public static class ColorFilterLruCache extends LruCache<Integer, PorterDuffColorFilter> {
        public ColorFilterLruCache(int r1) {
            super(r1);
        }

        private static int generateCacheKey(int r1, PorterDuff.Mode r2) {
            int r3 = r2.hashCode();
            return r3 + ((r1 + 31) * 31);
        }

        public PorterDuffColorFilter get(int r1, PorterDuff.Mode r2) {
            return get(Integer.valueOf(generateCacheKey(r1, r2)));
        }

        public PorterDuffColorFilter put(int r1, PorterDuff.Mode r2, PorterDuffColorFilter r3) {
            return put(Integer.valueOf(generateCacheKey(r1, r2)), r3);
        }
    }

    public interface InflateDelegate {
        Drawable createFromXmlInner(@NonNull Context r1, @NonNull XmlPullParser r2, @NonNull AttributeSet r3, @Nullable Resources.Theme r4);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public interface ResourceManagerHooks {
        Drawable createDrawableFor(@NonNull ResourceManagerInternal r1, @NonNull Context r2, @DrawableRes int r3);

        ColorStateList getTintListForDrawableRes(@NonNull Context r1, @DrawableRes int r2);

        PorterDuff.Mode getTintModeForDrawableRes(int r1);

        boolean tintDrawable(@NonNull Context r1, @DrawableRes int r2, @NonNull Drawable r3);

        boolean tintDrawableUsingColorFilter(@NonNull Context r1, @DrawableRes int r2, @NonNull Drawable r3);
    }

    public static class VdcInflateDelegate implements InflateDelegate {
        public VdcInflateDelegate() {
        }

        @Override // androidx.appcompat.widget.ResourceManagerInternal.InflateDelegate
        public Drawable createFromXmlInner(@NonNull Context r1, @NonNull XmlPullParser r2, @NonNull AttributeSet r3, @Nullable Resources.Theme r4) {
            return VectorDrawableCompat.createFromXmlInner(r1.getResources(), r2, r3, r4);
        L4:
            e = move-exception;
            Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e);
            return null;
        }
    }

    static {
        DEFAULT_MODE = PorterDuff.Mode.SRC_IN;
        COLOR_FILTER_CACHE = new ColorFilterLruCache(6);
    }

    public ResourceManagerInternal() {
        this.mDrawableCaches = new WeakHashMap(0);
    }

    private void addDelegate(@NonNull String r2, @NonNull InflateDelegate r3) {
        if (this.mDelegates != null) goto L5;
        this.mDelegates = new SimpleArrayMap();
    L5:
        this.mDelegates.put(r2, r3);
    }

    private synchronized boolean addDrawableToCache(@NonNull Context r3, long r4, @NonNull Drawable r6) {
        monitor-enter(this);
        Drawable.ConstantState r7 = r6.getConstantState();     // Catch: Throwable -> L8
        if (r7 == null) goto L14;
        LongSparseArray<WeakReference<Drawable.ConstantState>> r0 = this.mDrawableCaches.get(r3);     // Catch: Throwable -> L8
        if (r0 != null) goto L10;
        r0 = new LongSparseArray();     // Catch: Throwable -> L8
        this.mDrawableCaches.put(r3, r0);     // Catch: Throwable -> L8
    L10:
        r0.put(r4, new WeakReference(r7));     // Catch: Throwable -> L8
        monitor-exit(this);
        return true;
    L14:
        monitor-exit(this);
        return false;
    L8:
        th = move-exception;
        throw th;
    }

    private void addTintListToCache(@NonNull Context r2, @DrawableRes int r3, @NonNull ColorStateList r4) {
        if (this.mTintLists != null) goto L5;
        this.mTintLists = new WeakHashMap();
    L5:
        SparseArrayCompat<ColorStateList> r0 = this.mTintLists.get(r2);
        if (r0 != null) goto L8;
        r0 = new SparseArrayCompat();
        this.mTintLists.put(r2, r0);
    L8:
        r0.append(r3, r4);
    }

    private void checkVectorDrawableSetup(@NonNull Context r2) {
        if (this.mHasCheckedVectorDrawableSetup == false) goto L5;
        return;
    L5:
        this.mHasCheckedVectorDrawableSetup = true;
        Drawable r3 = getDrawable(r2, R.drawable.abc_vector_test);
        if (r3 != null) goto L8;
    L10:
        this.mHasCheckedVectorDrawableSetup = false;
        throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
    L8:
        if (isVectorDrawable(r3) == false) goto L10;
    }

    private static long createCacheKey(TypedValue r4) {
        return (((long) r4.assetCookie) << 32) | ((long) r4.data);
    }

    private Drawable createDrawableIfNeeded(@NonNull Context r5, @DrawableRes int r6) {
        if (this.mTypedValue != null) goto L5;
        this.mTypedValue = new TypedValue();
    L5:
        TypedValue r0 = this.mTypedValue;
        r5.getResources().getValue(r6, r0, true);
        long r1 = createCacheKey(r0);
        Drawable r3 = getCachedDrawable(r5, r1);
        if (r3 == null) goto L8;
        return r3;
    L8:
        ResourceManagerHooks r4 = this.mHooks;
        if (r4 != null) goto L11;
        Drawable r7 = null;
    L12:
        if (r7 == null) goto L14;
        r7.setChangingConfigurations(r0.changingConfigurations);
        addDrawableToCache(r5, r1, r7);
    L14:
        return r7;
    L11:
        r7 = r4.createDrawableFor(this, r5, r6);
        goto L12
    }

    private static PorterDuffColorFilter createTintFilter(ColorStateList r1, PorterDuff.Mode r2, int[] r3) {
        if (r1 == null) goto L7;
        if (r2 != null) goto L6;
        return null;
    L6:
        return getPorterDuffColorFilter(r1.getColorForState(r3, 0), r2);
    L7:
        return null;
    }

    public static synchronized ResourceManagerInternal get() {
        monitor-enter(ResourceManagerInternal.class);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (INSTANCE != null) goto L9;
        ResourceManagerInternal r1 = new ResourceManagerInternal();     // Catch: Throwable -> L7
        INSTANCE = r1;     // Catch: Throwable -> L7
        installDefaultInflateDelegates(r1);     // Catch: Throwable -> L7
    L9:
        ResourceManagerInternal r2 = INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(ResourceManagerInternal.class);
        return r2;
    }

    private synchronized Drawable getCachedDrawable(@NonNull Context r4, long r5) {
        monitor-enter(this);
        LongSparseArray<WeakReference<Drawable.ConstantState>> r0 = this.mDrawableCaches.get(r4);     // Catch: Throwable -> L15
        if (r0 != null) goto L8;
        monitor-exit(this);
        return null;
    L8:
        WeakReference<Drawable.ConstantState> r2 = r0.get(r5);     // Catch: Throwable -> L15
        if (r2 == null) goto L18;
        Drawable.ConstantState r3 = r2.get();     // Catch: Throwable -> L15
        if (r3 == null) goto L17;
        Drawable r6 = r3.newDrawable(r4.getResources());     // Catch: Throwable -> L15
        monitor-exit(this);
        return r6;
    L17:
        r0.remove(r5);     // Catch: Throwable -> L15
    L18:
        monitor-exit(this);
        return null;
    L15:
        th = move-exception;
        throw th;
    }

    public static synchronized PorterDuffColorFilter getPorterDuffColorFilter(int r3, PorterDuff.Mode r4) {
        monitor-enter(ResourceManagerInternal.class);
        ColorFilterLruCache r1 = COLOR_FILTER_CACHE;     // Catch: Throwable -> L8
        PorterDuffColorFilter r2 = r1.get(r3, r4);     // Catch: Throwable -> L8
        if (r2 != null) goto L10;
        r2 = new PorterDuffColorFilter(r3, r4);     // Catch: Throwable -> L8
        r1.put(r3, r4, r2);     // Catch: Throwable -> L8
    L10:
        monitor-exit(ResourceManagerInternal.class);
        return r2;
    L8:
        th = move-exception;
        throw th;
    }

    private ColorStateList getTintListFromCache(@NonNull Context r2, @DrawableRes int r3) {
        WeakHashMap<Context, SparseArrayCompat<ColorStateList>> r1 = this.mTintLists;
        if (r1 == null) goto L8;
        SparseArrayCompat<ColorStateList> r4 = r1.get(r2);
        if (r4 != null) goto L7;
        return null;
    L7:
        return r4.get(r3);
    L8:
        return null;
    }

    private static void installDefaultInflateDelegates(@NonNull ResourceManagerInternal r0) {
    }

    private static boolean isVectorDrawable(@NonNull Drawable r1) {
        if ((r1 instanceof VectorDrawableCompat) == false) goto L5;
    L8:
        return true;
    L5:
        if (PLATFORM_VD_CLAZZ.equals(r1.getClass().getName()) == true) goto L8;
        return false;
    }

    private Drawable loadDrawableFromDelegates(@NonNull Context r11, @DrawableRes int r12) {
        SimpleArrayMap<String, InflateDelegate> r0 = this.mDelegates;
        if (r0 != null) goto L5;
    L44:
        return null;
    L5:
        if (r0.isEmpty() == true) goto L44;
        SparseArrayCompat<String> r1 = this.mKnownDrawableIdTags;
        if (r1 == null) goto L14;
        String r2 = r1.get(r12);
        if (SKIP_DRAWABLE_TAG.equals(r2) == true) goto L13;
        if (r2 == null) goto L16;
        if (this.mDelegates.get(r2) == null) goto L13;
    L16:
        if (this.mTypedValue != null) goto L18;
        this.mTypedValue = new TypedValue();
    L18:
        TypedValue r3 = this.mTypedValue;
        Resources r4 = r11.getResources();
        r4.getValue(r12, r3, true);
        long r5 = createCacheKey(r3);
        Drawable r6 = getCachedDrawable(r11, r5);
        if (r6 == null) goto L21;
        return r6;
    L21:
        CharSequence r7 = r3.string;
        if (r7 != null) goto L24;
    L41:
        if (r6 != null) goto L43;
        this.mKnownDrawableIdTags.append(r12, SKIP_DRAWABLE_TAG);
    L43:
        return r6;
    L24:
        if (r7.toString().endsWith(".xml") == false) goto L41;
        XmlResourceParser r8 = r4.getXml(r12);     // Catch: Exception -> L34
        AttributeSet r9 = Xml.asAttributeSet(r8);     // Catch: Exception -> L34
    L26:
        int r10 = r8.next();     // Catch: Exception -> L34
        if (r10 == 2) goto L30;
        if (r10 != 1) goto L26;
    L30:
        if (r10 != 2) goto L39;
        String r13 = r8.getName();     // Catch: Exception -> L34
        this.mKnownDrawableIdTags.append(r12, r13);     // Catch: Exception -> L34
        InflateDelegate r14 = this.mDelegates.get(r13);     // Catch: Exception -> L34
        if (r14 == null) goto L36;
        r6 = r14.createFromXmlInner(r11, r8, r9, r11.getTheme());     // Catch: Exception -> L34
    L36:
        if (r6 == null) goto L41;
        r6.setChangingConfigurations(r3.changingConfigurations);     // Catch: Exception -> L34
        addDrawableToCache(r11, r5, r6);     // Catch: Exception -> L34
        goto L41
    L39:
        throw new XmlPullParserException("No start tag found");     // Catch: Exception -> L34
    L34:
        e = move-exception;
        Log.e(TAG, "Exception while inflating drawable", e);
    L13:
        return null;
    L14:
        this.mKnownDrawableIdTags = new SparseArrayCompat();
        goto L16
    }

    private Drawable tintDrawable(@NonNull Context r2, @DrawableRes int r3, boolean r4, @NonNull Drawable r5) {
        ColorStateList r0 = getTintList(r2, r3);
        if (r0 != null) goto L5;
        ResourceManagerHooks r1 = this.mHooks;
        if (r1 == null) goto L16;
        if (r1.tintDrawable(r2, r3, r5) == false) goto L16;
        return r5;
    L16:
        if (tintDrawableUsingColorFilter(r2, r3, r5) == true) goto L22;
        if (r4 == false) goto L23;
        return null;
    L23:
        return r5;
    L22:
        return r5;
    L5:
        if (DrawableUtils.canSafelyMutateDrawable(r5) == false) goto L7;
        r5 = r5.mutate();
    L7:
        Drawable r6 = DrawableCompat.wrap(r5);
        DrawableCompat.setTintList(r6, r0);
        PorterDuff.Mode r7 = getTintMode(r3);
        if (r7 == null) goto L20;
        DrawableCompat.setTintMode(r6, r7);
        return r6;
    L20:
        return r6;
    }

    public synchronized Drawable getDrawable(@NonNull Context r2, @DrawableRes int r3) {
        monitor-enter(this);
        Drawable r4 = getDrawable(r2, r3, false);     // Catch: Throwable -> L7
        monitor-exit(this);
        return r4;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized ColorStateList getTintList(@NonNull Context r2, @DrawableRes int r3) {
        monitor-enter(this);
        ColorStateList r0 = getTintListFromCache(r2, r3);     // Catch: Throwable -> L12
        if (r0 != null) goto L14;
        ResourceManagerHooks r1 = this.mHooks;     // Catch: Throwable -> L12
        if (r1 != null) goto L8;
        r0 = null;
    L9:
        if (r0 == null) goto L14;
        addTintListToCache(r2, r3, r0);     // Catch: Throwable -> L12
        goto L14
    L8:
        r0 = r1.getTintListForDrawableRes(r2, r3);     // Catch: Throwable -> L12
    L14:
        monitor-exit(this);
        return r0;
    L12:
        th = move-exception;
        throw th;
    }

    public PorterDuff.Mode getTintMode(int r1) {
        ResourceManagerHooks r0 = this.mHooks;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.getTintModeForDrawableRes(r1);
    }

    public synchronized void onConfigurationChanged(@NonNull Context r2) {
        monitor-enter(this);
        LongSparseArray<WeakReference<Drawable.ConstantState>> r3 = this.mDrawableCaches.get(r2);     // Catch: Throwable -> L7
        if (r3 == null) goto L9;
        r3.clear();     // Catch: Throwable -> L7
    L9:
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized Drawable onDrawableLoadedFromResources(@NonNull Context r2, @NonNull VectorEnabledTintResources r3, @DrawableRes int r4) {
        monitor-enter(this);
        Drawable r0 = loadDrawableFromDelegates(r2, r4);     // Catch: Throwable -> L6
        if (r0 != null) goto L8;
        r0 = r3.superGetDrawable(r4);     // Catch: Throwable -> L6
    L8:
        if (r0 == null) goto L12;
        Drawable r5 = tintDrawable(r2, r4, false, r0);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r5;
    L12:
        monitor-exit(this);
        return null;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void setHooks(ResourceManagerHooks r1) {
        monitor-enter(this);
        this.mHooks = r1;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public boolean tintDrawableUsingColorFilter(@NonNull Context r1, @DrawableRes int r2, @NonNull Drawable r3) {
        ResourceManagerHooks r0 = this.mHooks;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.tintDrawableUsingColorFilter(r1, r2, r3) == false) goto L7;
        return true;
    }

    public synchronized Drawable getDrawable(@NonNull Context r2, @DrawableRes int r3, boolean r4) {
        monitor-enter(this);
        checkVectorDrawableSetup(r2);     // Catch: Throwable -> L6
        Drawable r0 = loadDrawableFromDelegates(r2, r3);     // Catch: Throwable -> L6
        if (r0 != null) goto L8;
        r0 = createDrawableIfNeeded(r2, r3);     // Catch: Throwable -> L6
    L8:
        if (r0 != null) goto L10;
        r0 = ContextCompat.getDrawable(r2, r3);     // Catch: Throwable -> L6
    L10:
        if (r0 == null) goto L12;
        r0 = tintDrawable(r2, r3, r4, r0);     // Catch: Throwable -> L6
    L12:
        if (r0 == null) goto L14;
        DrawableUtils.fixDrawable(r0);     // Catch: Throwable -> L6
    L14:
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public static void tintDrawable(Drawable r2, TintInfo r3, int[] r4) {
        if (DrawableUtils.canSafelyMutateDrawable(r2) == true) goto L5;
    L8:
        boolean r0 = r3.mHasTintList;
        if (r0 == false) goto L11;
    L14:
        if (r0 == false) goto L16;
        ColorStateList r1 = r3.mTintList;
    L18:
        if (r3.mHasTintMode == false) goto L20;
        PorterDuff.Mode r5 = r3.mTintMode;
    L21:
        r2.setColorFilter(createTintFilter(r1, r5, r4));
        return;
    L20:
        r5 = DEFAULT_MODE;
        goto L21
    L16:
        r1 = null;
        goto L18
    L11:
        if (r3.mHasTintMode == true) goto L14;
        r2.clearColorFilter();
        return;
    L5:
        if (r2.mutate() == r2) goto L8;
        Log.d(TAG, "Mutated drawable is not the same instance as the input.");
    }
}
