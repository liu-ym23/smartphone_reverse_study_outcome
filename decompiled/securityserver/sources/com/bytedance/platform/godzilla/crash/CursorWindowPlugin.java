package com.bytedance.platform.godzilla.crash;

import android.app.Application;
import android.database.CursorWindow;
import com.bytedance.platform.godzilla.common.Logger;
import com.bytedance.platform.godzilla.plugin.BasePlugin;
import com.bytedance.platform.godzilla.utils.FieldUtils;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public class CursorWindowPlugin extends BasePlugin {
    private static final int DEFAULT_SIZE = 1048576;
    private static Field sCursorWindowSizeField = null;
    private static int sOriginSize = -1;
    private int mSize;

    public CursorWindowPlugin() {
        this.mSize = 0;
    }

    private boolean resetCursorWindowSize(int r4) {
        Field r1 = FieldUtils.getField(CursorWindow.class, "sCursorWindowSize");
        sCursorWindowSizeField = r1;
        if (r1 == null) goto L12;
        if (r4 > 0) goto L6;
        r4 = 1048576;
    L6:
        r1.setAccessible(true);
        int r2 = ((Integer) FieldUtils.readStaticField(sCursorWindowSizeField)).intValue();     // Catch: IllegalAccessException -> L14
        sOriginSize = r2;     // Catch: IllegalAccessException -> L14
        if (r2 == r4) goto L10;
        FieldUtils.writeStaticField(sCursorWindowSizeField, Integer.valueOf(r4));     // Catch: IllegalAccessException -> L14
    L10:
        int r5 = ((Integer) FieldUtils.readStaticField(sCursorWindowSizeField)).intValue();     // Catch: IllegalAccessException -> L14
        Logger.e(getName(), "Resize cursor window size successful! Resize form :" + sOriginSize + "to " + r5);     // Catch: IllegalAccessException -> L14
        return true;
    L17:
        return false;
    L12:
        return false;
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void destroy() {
        super.destroy();
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public String getName() {
        return "CursorWindowPlugin";
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void init(Application r1) {
        super.init(r1);
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void start() {
        super.start();
        int r0 = this.mSize;
        if (r0 <= 0) goto L5;
        resetCursorWindowSize(r0);
        return;
    L5:
        resetCursorWindowSize(1048576);
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void stop() {
        super.stop();
        Field r1 = sCursorWindowSizeField;
        if (r1 == null) goto L11;
        int r0 = sOriginSize;
        if (r0 <= 0) goto L12;
        FieldUtils.writeStaticField(r1, Integer.valueOf(r0));     // Catch: IllegalAccessException -> L8
        return;
    L13:
        return;
    L12:
        return;
    }

    public CursorWindowPlugin(int r1) {
        this.mSize = r1;
    }
}
