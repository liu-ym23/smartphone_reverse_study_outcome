package androidx.appcompat.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.view.LayoutInflater;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.annotation.StyleRes;
import androidx.appcompat.R;

/* JADX INFO: loaded from: classes.dex */
public class ContextThemeWrapper extends ContextWrapper {
    private static Configuration sEmptyConfig;
    private LayoutInflater mInflater;
    private Configuration mOverrideConfiguration;
    private Resources mResources;
    private Resources.Theme mTheme;
    private int mThemeResource;

    @RequiresApi(17)
    static class Api17Impl {
        private Api17Impl() {
        }

        @DoNotInline
        static Context createConfigurationContext(ContextThemeWrapper r0, Configuration r1) {
            return r0.createConfigurationContext(r1);
        }
    }

    public ContextThemeWrapper() {
        super(null);
    }

    public ContextThemeWrapper(Context r1, @StyleRes int r2) {
        super(r1);
        this.mThemeResource = r2;
    }

    public ContextThemeWrapper(Context r1, Resources.Theme r2) {
        super(r1);
        this.mTheme = r2;
    }

    private Resources getResourcesInternal() {
        if (this.mResources != null) goto L18;
        Configuration r0 = this.mOverrideConfiguration;
        if (r0 == null) goto L15;
        int r1 = Build.VERSION.SDK_INT;
        if (r1 < 26) goto L12;
        if (isEmptyConfiguration(r0) == true) goto L15;
    L12:
        if (r1 < 17) goto L14;
        Resources r2 = Api17Impl.createConfigurationContext(this, this.mOverrideConfiguration).getResources();
    L16:
        this.mResources = r2;
        goto L18
    L14:
        Resources r3 = super.getResources();
        Configuration r4 = new Configuration(r3.getConfiguration());
        r4.updateFrom(this.mOverrideConfiguration);
        this.mResources = new Resources(r3.getAssets(), r3.getDisplayMetrics(), r4);
    L15:
        r2 = super.getResources();
    L18:
        return this.mResources;
    }

    private void initializeTheme() {
        if (this.mTheme != null) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        this.mTheme = getResources().newTheme();
        Resources.Theme r1 = getBaseContext().getTheme();
        if (r1 == null) goto L10;
        this.mTheme.setTo(r1);
    L10:
        onApplyThemeResource(this.mTheme, this.mThemeResource, r0);
        return;
    L5:
        r0 = false;
        goto L6
    }

    @RequiresApi(26)
    private static boolean isEmptyConfiguration(Configuration r2) {
        if (r2 != null) goto L6;
        return true;
    L6:
        if (sEmptyConfig != null) goto L9;
        Configuration r0 = new Configuration();
        r0.fontScale = 0.0f;
        sEmptyConfig = r0;
    L9:
        return r2.equals(sEmptyConfig);
    }

    public void applyOverrideConfiguration(Configuration r2) {
        if (this.mResources != null) goto L11;
        if (this.mOverrideConfiguration != null) goto L9;
        this.mOverrideConfiguration = new Configuration(r2);
        return;
    L9:
        throw new IllegalStateException("Override configuration has already been set");
    L11:
        throw new IllegalStateException("getResources() or getAssets() has already been called");
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context r1) {
        super.attachBaseContext(r1);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return getResourcesInternal();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String r2) {
        if ("layout_inflater".equals(r2) == false) goto L10;
        if (this.mInflater != null) goto L8;
        this.mInflater = LayoutInflater.from(getBaseContext()).cloneInContext(this);
    L8:
        return this.mInflater;
    L10:
        return getBaseContext().getSystemService(r2);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme r0 = this.mTheme;
        if (r0 == null) goto L6;
        return r0;
    L6:
        if (this.mThemeResource != 0) goto L8;
        this.mThemeResource = R.style.Theme_AppCompat_Light;
    L8:
        initializeTheme();
        return this.mTheme;
    }

    public int getThemeResId() {
        return this.mThemeResource;
    }

    protected void onApplyThemeResource(Resources.Theme r1, int r2, boolean r3) {
        r1.applyStyle(r2, true);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int r2) {
        if (this.mThemeResource == r2) goto L6;
        this.mThemeResource = r2;
        initializeTheme();
        return;
    }
}
