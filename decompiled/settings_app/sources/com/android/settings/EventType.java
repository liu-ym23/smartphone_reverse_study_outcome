package com.android.settings;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes2.dex */
public class EventType {

    public static class InstallWpsEvent {
        public InstallWpsEvent() {
        }
    }

    public static class LauncherThemeIconUpdateEvent {
        public Drawable themeIcon;

        public LauncherThemeIconUpdateEvent(Drawable r1) {
            this.themeIcon = r1;
        }
    }

    public static class LauncherWallpaperGotEvent {
        public Drawable wallpaper;

        public LauncherWallpaperGotEvent(Drawable r1) {
            this.wallpaper = r1;
        }
    }

    public static class LockscreenWallpaperIconUpdateEvent {
        public Bitmap lockscreenWallpaper;

        public LockscreenWallpaperIconUpdateEvent(Bitmap r1) {
            this.lockscreenWallpaper = r1;
        }
    }

    public static class OTABadgeUpdateEvent {
        private boolean showBadge;

        public OTABadgeUpdateEvent(boolean r1) {
            this.showBadge = r1;
        }

        public boolean showOTABadge() {
            return this.showBadge;
        }
    }

    public EventType() {
    }
}
