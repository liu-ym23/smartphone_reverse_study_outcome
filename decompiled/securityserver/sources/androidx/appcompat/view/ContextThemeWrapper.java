package androidx.appcompat.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.LayoutInflater;
import androidx.annotation.StyleRes;
import androidx.appcompat.R;

/* JADX INFO: loaded from: classes.dex */
public class ContextThemeWrapper extends ContextWrapper {
    private LayoutInflater mInflater;
    private Configuration mOverrideConfiguration;
    private Resources mResources;
    private Resources.Theme mTheme;
    private int mThemeResource;

    public ContextThemeWrapper() {
        super(null);
    }

    private Resources getResourcesInternal() {
        if (this.mResources != null) goto L9;
        Configuration r0 = this.mOverrideConfiguration;
        if (r0 != null) goto L7;
        this.mResources = super.getResources();
        goto L9
    L7:
        this.mResources = createConfigurationContext(r0).getResources();
    L9:
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
    public void attachBaseContext(Context r1) {
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

    public void onApplyThemeResource(Resources.Theme r1, int r2, boolean r3) {
        r1.applyStyle(r2, true);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int r2) {
        if (this.mThemeResource == r2) goto L6;
        this.mThemeResource = r2;
        initializeTheme();
        return;
    }

    public ContextThemeWrapper(Context r1, @StyleRes int r2) {
        super(r1);
        this.mThemeResource = r2;
    }

    public ContextThemeWrapper(Context r1, Resources.Theme r2) {
        super(r1);
        this.mTheme = r2;
    }
}
