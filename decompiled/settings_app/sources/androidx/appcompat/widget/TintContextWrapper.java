package androidx.appcompat.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class TintContextWrapper extends ContextWrapper {
    private static final Object CACHE_LOCK = null;
    private static ArrayList<WeakReference<TintContextWrapper>> sCache;
    private final Resources mResources;
    private final Resources.Theme mTheme;

    static {
        CACHE_LOCK = new Object();
    }

    public static Context wrap(Context r4) {
        if (shouldWrap(r4) == false) goto L35;
        Object r0 = CACHE_LOCK;
        monitor-enter(r0);
        ArrayList<WeakReference<TintContextWrapper>> r1 = sCache;     // Catch: Throwable -> L32
        if (r1 != null) goto L9;
        sCache = new ArrayList();     // Catch: Throwable -> L32
    L29:
        TintContextWrapper r2 = new TintContextWrapper(r4);     // Catch: Throwable -> L32
        sCache.add(new WeakReference(r2));     // Catch: Throwable -> L32
        monitor-exit(r0);     // Catch: Throwable -> L32
        return r2;
    L9:
        int r3 = r1.size() - 1;     // Catch: Throwable -> L32
    L10:
        if (r3 < 0) goto L17;
        WeakReference<TintContextWrapper> r5 = sCache.get(r3);     // Catch: Throwable -> L32
        if (r5 != null) goto L14;
    L15:
        sCache.remove(r3);     // Catch: Throwable -> L32
    L16:
        r3 = r3 - 1;     // Catch: Throwable -> L32
        goto L10
    L14:
        if (r5.get() != null) goto L16;
    L17:
        int r6 = sCache.size() - 1;     // Catch: Throwable -> L32
    L18:
        if (r6 < 0) goto L29;
        WeakReference<TintContextWrapper> r7 = sCache.get(r6);     // Catch: Throwable -> L32
        if (r7 == null) goto L22;
        TintContextWrapper r8 = r7.get();     // Catch: Throwable -> L32
    L23:
        if (r8 == null) goto L28;
        if (r8.getBaseContext() != r4) goto L28;
        monitor-exit(r0);     // Catch: Throwable -> L32
        return r8;
    L28:
        r6 = r6 - 1;     // Catch: Throwable -> L32
        goto L18
    L22:
        r8 = null;
    L32:
        th = move-exception;
        throw th;
    L35:
        return r4;
    }

    private static boolean shouldWrap(Context r2) {
        if ((r2 instanceof TintContextWrapper) == false) goto L5;
        return false;
    L5:
        if ((r2.getResources() instanceof TintResources) == false) goto L7;
        return false;
    L7:
        if ((r2.getResources() instanceof VectorEnabledTintResources) == false) goto L10;
        return false;
    L10:
        if (VectorEnabledTintResources.shouldBeUsed() == false) goto L15;
        return true;
    L15:
        return false;
    }

    private TintContextWrapper(Context r3) {
        super(r3);
        if (VectorEnabledTintResources.shouldBeUsed() == false) goto L5;
        VectorEnabledTintResources r0 = new VectorEnabledTintResources(this, r3.getResources());
        this.mResources = r0;
        Resources.Theme r1 = r0.newTheme();
        this.mTheme = r1;
        r1.setTo(r3.getTheme());
        return;
    L5:
        this.mResources = new TintResources(this, r3.getResources());
        this.mTheme = null;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme r0 = this.mTheme;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return super.getTheme();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int r2) {
        Resources.Theme r0 = this.mTheme;
        if (r0 != null) goto L5;
        super.setTheme(r2);
        return;
    L5:
        r0.applyStyle(r2, true);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return this.mResources;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return this.mResources.getAssets();
    }
}
