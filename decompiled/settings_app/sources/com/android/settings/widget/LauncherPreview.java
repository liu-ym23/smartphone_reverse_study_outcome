package com.android.settings.widget;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.android.settings.Constants;
import com.android.settings.R;
import com.android.settings.SettingsFeature;
import com.android.settings.Utils;
import com.android.settings.WallpaperCache;
import com.obric.olog.OLog;
import java.io.ByteArrayInputStream;

/* JADX INFO: loaded from: classes.dex */
public class LauncherPreview extends LinearLayout implements View.OnClickListener {
    private static final String TAG = "LauncherPreview";
    final Uri URI_LAUNCHER;
    private Callback mCallback;
    private PreviewOptionItemView mClassicThemeOptionView;
    private ImageView mFrame;
    private PreviewOptionItemView mGridLauncher12;
    private PreviewOptionItemView mGridLauncher16;
    private PreviewOptionItemView mGridLauncher20;
    private PreviewOptionItemView mGridLauncher9;
    private long mLastClickTime;
    private ImageView mPreview;
    private PreviewOptionItemView mTransparentThemeOptionView;

    public interface Callback {
        void onLauncherThemeChanged(boolean r1);

        void onLauncherTypeChanged(int r1);
    }

    private static class WallpaperPreview {
        Drawable background;
        Drawable src;

        private WallpaperPreview() {
        }

        /* synthetic */ WallpaperPreview(AnonymousClass1 r1) {
            this();
        }
    }

    static /* synthetic */ Context access$000(LauncherPreview r0) {
        return r0.mContext;
    }

    static /* synthetic */ Drawable access$100(LauncherPreview r0, Context r1, String r2) {
        return r0.getBytedanceLauncherDrawable(r1, r2);
    }

    static /* synthetic */ PreviewOptionItemView access$200(LauncherPreview r0) {
        return r0.mClassicThemeOptionView;
    }

    static /* synthetic */ WallpaperPreview access$300(LauncherPreview r0, Context r1, int r2, boolean r3) {
        return r0.getPreviewDrawable(r1, r2, r3);
    }

    public LauncherPreview(Context r2) {
        this(r2, null);
    }

    public LauncherPreview(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public LauncherPreview(Context r3, AttributeSet r4, int r5) {
        super(r3, r4, r5);
        this.URI_LAUNCHER = Uri.parse("content://com.bytedanceos.launcher.exportprovider");
        LayoutInflater.from(r3).inflate(R.layout.launcher_preview_layout, this, true);
        setOrientation(1);
        this.mPreview = (ImageView) findViewById(R.id.id_preview);
        ImageView r6 = (ImageView) findViewById(R.id.id_frame);
        this.mFrame = r6;
        r6.setImageResource(Utils.getPhoneFrameResId());
        int r7 = getResources().getDimensionPixelOffset(R.dimen.launcher_theme_option_text_size);
        PreviewOptionItemView r8 = (PreviewOptionItemView) findViewById(R.id.id_grid_9);
        this.mGridLauncher9 = r8;
        r8.setTag(9);
        this.mGridLauncher9.setOnClickListener(this);
        PreviewOptionItemView r9 = (PreviewOptionItemView) findViewById(R.id.id_grid_12);
        this.mGridLauncher12 = r9;
        r9.setTag(12);
        this.mGridLauncher12.setOnClickListener(this);
        PreviewOptionItemView r10 = (PreviewOptionItemView) findViewById(R.id.id_grid_16);
        this.mGridLauncher16 = r10;
        r10.setTag(16);
        this.mGridLauncher16.setOnClickListener(this);
        PreviewOptionItemView r11 = (PreviewOptionItemView) findViewById(R.id.id_grid_20);
        this.mGridLauncher20 = r11;
        r11.setTag(20);
        this.mGridLauncher20.setOnClickListener(this);
        if (SettingsFeature.isLauncher12GridsSupport() == false) goto L5;
        this.mGridLauncher9.setVisibility(8);
        this.mGridLauncher12.setVisibility(0);
    L7:
        if (SettingsFeature.LAUNCHER_4X5_SUPPORTED == false) goto L9;
        this.mGridLauncher16.setVisibility(8);
    L10:
        int r12 = getResources().getDimensionPixelSize(R.dimen.select_option_icon_size);
        int r13 = getResources().getDimensionPixelOffset(R.dimen.launcher_theme_option_translation_y);
        PreviewOptionItemView r1 = (PreviewOptionItemView) findViewById(R.id.id_classic);
        this.mClassicThemeOptionView = r1;
        r1.setIconSize(r12, r12);
        float r14 = r13;
        this.mClassicThemeOptionView.getTitleView().setTranslationY(r14);
        float r15 = r7;
        this.mClassicThemeOptionView.getTitleView().setTextSize(0, r15);
        this.mClassicThemeOptionView.setOnClickListener(this);
        PreviewOptionItemView r2 = (PreviewOptionItemView) findViewById(R.id.id_transparent_theme);
        this.mTransparentThemeOptionView = r2;
        r2.setIconSize(r12, r12);
        this.mTransparentThemeOptionView.getTitleView().setTextSize(0, r15);
        this.mTransparentThemeOptionView.getTitleView().setTranslationY(r14);
        this.mTransparentThemeOptionView.setOnClickListener(this);
        return;
    L9:
        this.mGridLauncher20.setVisibility(8);
        goto L10
    L5:
        this.mGridLauncher9.setVisibility(0);
        this.mGridLauncher12.setVisibility(8);
        goto L7
    }

    public void setCallback(Callback r1) {
        this.mCallback = r1;
    }

    public void updateViews(int r5, boolean r6) {
        PreviewOptionItemView r0 = this.mGridLauncher9;
        boolean r2 = false;
        if (r5 != 9) goto L5;
        boolean r1 = true;
    L6:
        r0.setActive(r1);
        PreviewOptionItemView r3 = this.mGridLauncher12;
        if (r5 != 12) goto L9;
        boolean r4 = true;
    L10:
        r3.setActive(r4);
        PreviewOptionItemView r7 = this.mGridLauncher16;
        if (r5 != 16) goto L13;
        boolean r8 = true;
    L14:
        r7.setActive(r8);
        PreviewOptionItemView r9 = this.mGridLauncher20;
        if (r5 != 20) goto L17;
        r2 = true;
    L17:
        r9.setActive(r2);
        updatePreview(r5, r6);
        this.mClassicThemeOptionView.setActive(!r6);
        this.mTransparentThemeOptionView.setActive(r6);
        updateThemeEnableState(r5);
        return;
    L13:
        r8 = false;
        goto L14
    L9:
        r4 = false;
        goto L10
    L5:
        r1 = false;
        goto L6
    }

    private void updateThemeEnableState(int r2) {
        if (r2 != 0) goto L4;
        this.mClassicThemeOptionView.setEnabled(false);
        this.mTransparentThemeOptionView.setEnabled(false);
        return;
    L4:
        this.mClassicThemeOptionView.setEnabled(true);
        this.mTransparentThemeOptionView.setEnabled(true);
    }

    private void updatePreview(int r3, boolean r4) {
        setPreviewDrawable(this.mContext, this.mPreview, r3, r4);
        setThemeOptionPreviewDrawable();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.android.settings.widget.LauncherPreview$1] */
    private void setThemeOptionPreviewDrawable() {
        Void r2 = (Void) null;
        new AnonymousClass1(this).execute(new Void[]{null});
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r5) {
        boolean r1 = true;
        if (r5 == this.mGridLauncher9) goto L25;
        if (r5 == this.mGridLauncher12) goto L25;
        if (r5 == this.mGridLauncher16) goto L25;
        if (r5 == this.mGridLauncher20) goto L25;
        if (r5 == this.mTransparentThemeOptionView) goto L16;
        if (r5 == this.mClassicThemeOptionView) goto L16;
        return;
    L16:
        if ((!((PreviewOptionItemView) r5).isActive()) == false) goto L35;
        Callback r0 = this.mCallback;
        if (r0 != null) goto L20;
        return;
    L20:
        if (r5 == this.mTransparentThemeOptionView) goto L23;
        r1 = false;
    L23:
        r0.onLauncherThemeChanged(r1);
        return;
    L35:
        return;
    L25:
        if ((!((PreviewOptionItemView) r5).isActive()) == true) goto L27;
        return;
    L27:
        long r2 = SystemClock.elapsedRealtime() - this.mLastClickTime;
        this.mLastClickTime = SystemClock.elapsedRealtime();
        if (r2 >= 300) goto L30;
        return;
    L30:
        Callback r4 = this.mCallback;
        if (r4 == null) goto L38;
        r4.onLauncherTypeChanged(((Integer) r5.getTag()).intValue());
        return;
    }

    /* JADX WARN: Type inference failed for: r6v0, types: [com.android.settings.widget.LauncherPreview$2] */
    private void setPreviewDrawable(final Context r8, final ImageView r9, final int r10, final boolean r11) {
        Void r12 = (Void) null;
        new AnonymousClass2(this, r8, r10, r11, r9).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[]{null});
    }

    /* JADX WARN: Multi-variable type inference failed */
    private WallpaperPreview getPreviewDrawable(Context r6, int r7, boolean r8) {
        long r0 = System.currentTimeMillis();
        Drawable r3 = null;
        WallpaperPreview r2 = new WallpaperPreview(0 == true ? 1 : 0);
        if (r8 == false) goto L6;
        r3 = WallpaperCache.getInstance().getLauncherWallpaper();
        Utils.drawableToBitmap(r3);
    L6:
        if (r7 != 9) goto L8;
    L14:
        if (r8 == false) goto L16;
        r2.src = Utils.getDrawableFromPkg(this.mContext, Constants.PKG_WALLPAPER_PROVIDER, "launcher_" + r7 + "_white");
        r2.background = r3;
    L17:
        OLog.d(TAG, "useTime " + (System.currentTimeMillis() - r0));
        return r2;
    L16:
        r2.src = getBytedanceLauncherDrawable(r6, "L.jpg", r7);
        goto L17
    L8:
        if (r7 == 12) goto L14;
        if (r7 == 16) goto L14;
        if (r7 == 20) goto L14;
        goto L14
    }

    private Drawable getBytedanceLauncherDrawable(Context r2, String r3) {
        return getBytedanceLauncherDrawable(r2, r3, -1);
    }

    private Drawable getBytedanceLauncherDrawable(Context r4, String r5, int r6) {
        ContentResolver r7 = r4.getContentResolver();     // Catch: Exception -> L12
        Bundle r1 = new Bundle();     // Catch: Exception -> L12
        r1.putString("name", r5);     // Catch: Exception -> L12
        if (r6 <= 0) goto L6;
        r1.putInt("singleMode", r6);     // Catch: Exception -> L12
    L6:
        Bundle r3 = r7.call(this.URI_LAUNCHER, "CALL_METHOD_GET_THEME_PREVIEW_RES", null, r1);     // Catch: Exception -> L12
        if (r3 == null) goto L17;
        byte[] r8 = r3.getByteArray("data");     // Catch: Exception -> L12
        if (r8 == null) goto L18;
        return Drawable.createFromStream(new ByteArrayInputStream(r8), null);
    L18:
        return null;
    L17:
        return null;
    L12:
        e = move-exception;
        e.printStackTrace();
        return null;
    }
}
