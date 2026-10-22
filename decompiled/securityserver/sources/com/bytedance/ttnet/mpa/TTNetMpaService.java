package com.bytedance.ttnet.mpa;

import android.text.TextUtils;
import com.bytedance.android.bytehook.ByteHook;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.frameworks.baselib.network.http.cronet.mpa.IMpaService;
import java.util.List;
import org.chromium.mpa.CronetMpaServiceImpl;

/* JADX INFO: loaded from: classes.dex */
public class TTNetMpaService {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String CRONET_MPA_SERVICE_IMPL_CLASS = "org.chromium.mpa.CronetMpaServiceImpl";
    public static final String TAG = "TTNetMpaService";
    private IMpaService mMpsService;

    /* JADX INFO: renamed from: com.bytedance.ttnet.mpa.TTNetMpaService$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$ttnet$mpa$TTNetMpaService$HookMode = null;

        static {
            int[] r0 = new int[HookMode.values().length];
            $SwitchMap$com$bytedance$ttnet$mpa$TTNetMpaService$HookMode = r0;
            r0[HookMode.BYTE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$com$bytedance$ttnet$mpa$TTNetMpaService$HookMode[HookMode.SHADOW.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$bytedance$ttnet$mpa$TTNetMpaService$HookMode[HookMode.SYMBOL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public static final enum HookMode extends Enum<HookMode> {
        private static final /* synthetic */ HookMode[] $VALUES = null;
        public static final HookMode BYTE = null;
        public static final HookMode SHADOW = null;
        public static final HookMode SYMBOL = null;

        static {
            HookMode r0 = new HookMode("SYMBOL", 0);
            SYMBOL = r0;
            HookMode r1 = new HookMode("BYTE", 1);
            BYTE = r1;
            HookMode r2 = new HookMode("SHADOW", 2);
            SHADOW = r2;
            $VALUES = new HookMode[]{r0, r1, r2};
        }

        private HookMode(String r1, int r2) {
            super(r1, r2);
        }

        public static HookMode valueOf(String r1) {
            return (HookMode) Enum.valueOf(HookMode.class, r1);
        }

        public static HookMode[] values() {
            return (HookMode[]) $VALUES.clone();
        }
    }

    public static class SingletonInstance {
        private static final TTNetMpaService INSTANCE = null;

        static {
            INSTANCE = new TTNetMpaService(null);
        }

        private SingletonInstance() {
        }

        public static /* synthetic */ TTNetMpaService access$100() {
            return INSTANCE;
        }
    }

    public /* synthetic */ TTNetMpaService(AnonymousClass1 r1) {
        this();
    }

    private void command(String r2, String r3) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
    L11:
        Logger.e(TAG, "error command:" + r2 + " extraMessage:" + r3);
        return;
    L5:
        if (TextUtils.isEmpty(r3) == true) goto L11;
        IMpaService r1 = this.mMpsService;
        if (r1 == null) goto L13;
        r1.command(r2, r3);
        return;
    }

    public static TTNetMpaService getInstance() {
        return SingletonInstance.access$100();
    }

    private boolean tryResolveCronetMpaServiceImpl() {
        if (this.mMpsService == null) goto L14;
        return true;
    L14:
        this.mMpsService = (IMpaService) CronetMpaServiceImpl.class.newInstance();     // Catch: Throwable -> L7
    L10:
        if (this.mMpsService != null) goto L16;
        return false;
    L16:
        return true;
    L7:
        th = move-exception;
        th.printStackTrace();
        goto L10
    }

    public void init(IMpaService.ICallback r2) {
        init(r2, HookMode.SYMBOL);
    }

    public void setAccAddress(List<String> r3, IMpaService.ICallback r4) {
        if (r3 != null) goto L5;
    L13:
        if (r4 == null) goto L18;
        r4.onFinish(false, "Address error");
        return;
    L18:
        return;
    L5:
        if (r3.isEmpty() == true) goto L13;
        IMpaService r2 = this.mMpsService;
        if (r2 == null) goto L10;
        r2.setAccAddress(r3, r4);
        return;
    L10:
        if (r4 == null) goto L17;
        r4.onFinish(false, "MpsService is null");
        return;
    }

    public void start(String r2) {
        IMpaService r0 = this.mMpsService;
        if (r0 == null) goto L6;
        r0.start();
        command("begin_user_log", r2);
        return;
    }

    public void stop(String r2) {
        if (this.mMpsService == null) goto L6;
        command("end_user_log", r2);
        this.mMpsService.stop();
        return;
    }

    private TTNetMpaService() {
    }

    public void init(IMpaService.ICallback r4, HookMode r5) {
        if (tryResolveCronetMpaServiceImpl() == true) goto L6;
        r4.onFinish(false, "Load CronetMpaServiceImpl Failed");
        return;
    L6:
        int r6 = AnonymousClass1.$SwitchMap$com$bytedance$ttnet$mpa$TTNetMpaService$HookMode[r5.ordinal()];
        if (r6 != 1) goto L9;
        int r0 = ByteHook.f2a;     // Catch: Throwable -> L20
        int r7 = ((Integer) Reflect.on(ByteHook.class.newInstance()).call("init").get()).intValue();     // Catch: Throwable -> L20
    L23:
        if (r7 == 0) goto L26;
        r4.onFinish(false, "Hook Init Error " + r7);
        return;
    L26:
        this.mMpsService.init(r4);
        return;
    L20:
        th = move-exception;
        th.printStackTrace();
    L22:
        r7 = -1;
        goto L23
    L9:
        if (r6 != 2) goto L11;
        r7 = ((Integer) Reflect.on(Class.forName("com.bytedance.shadowhook.ShadowHook").newInstance()).call("init").get()).intValue();     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        th.printStackTrace();
        goto L22
    L11:
        if (r6 != 3) goto L22;
        r7 = 0;
        goto L23
    }
}
