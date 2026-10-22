package com.android.settings.qstile;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.SystemProperties;
import android.service.quicksettings.Tile;
import android.service.quicksettings.TileService;

/* JADX INFO: loaded from: classes2.dex */
public class DevelopmentTiles {
    private static final String DEBUG_LAYOUT_PROPERTY = "debug.layout";
    static final Class[] TILE_CLASSES = null;

    public static class GPUProfiling extends TileService {
        public GPUProfiling() {
        }

        @Override // android.service.quicksettings.TileService
        public void onStartListening() {
            super.onStartListening();
            refresh();
        }

        public void refresh() {
            String r0 = SystemProperties.get("debug.hwui.profile");
            Tile r1 = getQsTile();
            if (r0.equals("visual_bars") == false) goto L5;
            int r2 = 2;
        L6:
            r1.setState(r2);
            getQsTile().updateTile();
            return;
        L5:
            r2 = 1;
            goto L6
        }

        @Override // android.service.quicksettings.TileService
        public void onClick() {
            if (getQsTile().getState() != 1) goto L5;
            String r0 = "visual_bars";
        L6:
            SystemProperties.set("debug.hwui.profile", r0);
            refresh();
            return;
        L5:
            r0 = "";
            goto L6
        }
    }

    public static class ShowLayout extends TileService {
        public ShowLayout() {
        }

        @Override // android.service.quicksettings.TileService
        public void onStartListening() {
            super.onStartListening();
            refresh();
        }

        public void refresh() {
            boolean r0 = SystemProperties.getBoolean(DevelopmentTiles.DEBUG_LAYOUT_PROPERTY, false);
            Tile r1 = getQsTile();
            if (r0 == false) goto L5;
            int r2 = 2;
        L6:
            r1.setState(r2);
            getQsTile().updateTile();
            return;
        L5:
            r2 = 1;
            goto L6
        }

        @Override // android.service.quicksettings.TileService
        public void onClick() {
            if (getQsTile().getState() != 1) goto L5;
            String r0 = "true";
        L6:
            SystemProperties.set(DevelopmentTiles.DEBUG_LAYOUT_PROPERTY, r0);
            refresh();
            return;
        L5:
            r0 = "false";
            goto L6
        }
    }

    public DevelopmentTiles() {
    }

    static {
        TILE_CLASSES = new Class[]{ShowLayout.class, GPUProfiling.class};
    }

    public static void setTilesEnabled(Context r6, boolean r7) {
        PackageManager r0 = r6.getPackageManager();
        Class[] r1 = TILE_CLASSES;
        int r2 = r1.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L5;
        r0.setComponentEnabledSetting(new ComponentName(r6, r1[r3]), r7 ? 1 : 0, 1);
        r3 = r3 + 1;
        goto L3
    }
}
