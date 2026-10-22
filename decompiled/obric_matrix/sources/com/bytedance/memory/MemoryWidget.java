package com.bytedance.memory;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.apm.f;
import com.bytedance.apm.util.i;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.memory.b.c;
import com.bytedance.services.apm.api.WidgetParams;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class MemoryWidget extends f {
    public static final String KEY_CLIENT_ANALYZE = "client_analyze";
    public static final String KEY_ENABLE_WIDGET_MEMORY = "enable_widget_memory";
    public static final String KEY_MAX_CAPACITY_ANALYSE = "max_capacity_analyse";
    public static final String KEY_MEMORY_RATE = "rate_memory_occupied";
    public static final String KEY_RUN_STRATEGY = "memory_strategy";
    private Context mAppContext;
    private volatile boolean mCheckedFolder;
    private boolean mClientAnalyze;
    private boolean mEnable;
    private volatile boolean mInitEd;
    private boolean mIsDebug;
    private com.bytedance.memory.f.a mMemoryWidgetConfig;
    private volatile boolean mNeedStop;
    private com.bytedance.memory.i.b mResultListener;
    private JSONObject memory;

    class a implements Runnable {
        a(MemoryWidget r1) {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.memory.a.a.l().p();
        }
    }

    class b implements Runnable {
        b(MemoryWidget r1) {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.memory.c.a.d().b();
        }
    }

    public MemoryWidget(@NonNull com.bytedance.memory.f.a r2) {
        this.mClientAnalyze = false;
        this.mMemoryWidgetConfig = r2;
    }

    public MemoryWidget(@NonNull com.bytedance.memory.f.a r2, @Nullable com.bytedance.memory.i.b r3) {
        this.mClientAnalyze = false;
        this.mMemoryWidgetConfig = r2;
        this.mResultListener = r3;
    }

    private boolean ableToInit() {
        if (this.mEnable == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mIsDebug == true) goto L8;
        return false;
    }

    private List<String> convertHost(List<String> r6, String r7) {
    L13:
        e = move-exception;
        e.printStackTrace();
    L16:
        return Collections.emptyList();
    L3:
        if (i.b(r6) == true) goto L16;
        ArrayList r5 = new ArrayList(2);     // Catch: Exception -> L13
        int r0 = r6.size();     // Catch: Exception -> L13
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L12;
        String r2 = new URL(r6.get(r1)).getHost();     // Catch: Exception -> L13
        if (TextUtils.isEmpty(r2) == true) goto L11;
        if (r2.indexOf(46) <= 0) goto L11;
        r5.add("https://" + r2 + r7);     // Catch: Exception -> L13
    L11:
        r1 = r1 + 1;
        goto L5
    L12:
        return r5;
    }

    private boolean inited() {
        if (this.mInitEd == true) goto L5;
    L7:
        return false;
    L5:
        if (ableToInit() == false) goto L7;
        return true;
    }

    private void parseConfig(JSONObject r3) {
        JSONObject r4 = r3.optJSONObject("performance_modules");
        if (r4 == null) goto L11;
        JSONObject r5 = r4.optJSONObject("memory");
        this.memory = r5;
        if (r5 == null) goto L12;
        boolean r1 = false;
        if (r5.optInt(KEY_ENABLE_WIDGET_MEMORY, 0) != 1) goto L9;
        r1 = true;
    L9:
        this.mEnable = r1;
        return;
    L12:
        return;
    }

    @Override // com.bytedance.apm.f, com.bytedance.services.apm.api.IWidget
    public void init(Context r2) {
        super.init(r2);
        this.mAppContext = r2;
        registerConfigService();
        com.bytedance.memory.a.a.l().o(this.mAppContext);
        com.bytedance.memory.c.b.d();     // Catch: Exception -> L5
        return;
    L5:
        this.mNeedStop = true;
    }

    @Override // com.bytedance.apm.f, com.bytedance.services.apm.api.IWidget
    public boolean isOnlyMainProcess() {
        return false;
    }

    @Override // com.bytedance.services.apm.api.IWidget
    public void notifyParams(WidgetParams r3) {
        if (r3 == null) goto L23;
        List<String> r4 = r3.getReportDomain();
        if (r4 != null) goto L6;
        return;
    L6:
        if (r4.size() <= 0) goto L25;
        List<String> r0 = convertHost(r4, "/monitor/collect/c/memory_upload_check?aid=%d&os=android");
        if (r0 != null) goto L10;
    L12:
        List<String> r1 = convertHost(r4, "/monitor/collect/c/mom_dump_collect");
        if (r1 != null) goto L15;
    L17:
        List<String> r2 = convertHost(r4, "/monitor/collect/c/exception");
        if (r2 != null) goto L20;
        return;
    L20:
        if (r2.size() <= 0) goto L27;
        com.bytedance.memory.h.a.f5047c = r2;
        return;
    L27:
        return;
    L15:
        if (r1.size() <= 0) goto L17;
        com.bytedance.memory.h.a.f5046b = r1;
        goto L17
    L10:
        if (r0.size() <= 0) goto L12;
        com.bytedance.memory.h.a.f5045a = r0;
        goto L12
    L25:
        return;
    }

    @Override // com.bytedance.apm.f, com.bytedance.services.apm.api.IActivityLifeObserver
    public void onBackground(Activity r1) {
        super.onBackground(r1);
        if (inited() == true) goto L5;
        return;
    L5:
        if (this.mMemoryWidgetConfig.e() != 2) goto L9;
        com.bytedance.memory.i.a.i().l();
        return;
    }

    @Override // com.bytedance.apm.f, com.bytedance.services.apm.api.IActivityLifeObserver
    public void onFront(Activity r1) {
        super.onFront(r1);
        if (inited() == true) goto L5;
        return;
    L5:
        if (this.mMemoryWidgetConfig.e() != 2) goto L9;
        c.c("onFront", new Object[0]);
        com.bytedance.memory.a.a.l().p();
        return;
    }

    @Override // com.bytedance.apm.f, com.bytedance.services.slardar.config.IConfigListener
    public void onRefresh(JSONObject r5, boolean r6) {
        super.onRefresh(r5, r6);
        if (this.mNeedStop == false) goto L5;
        return;
    L5:
        c.c("onRefresh run", new Object[0]);
        this.mIsDebug = this.mMemoryWidgetConfig.g();
        parseConfig(r5);
        if (ableToInit() == false) goto L26;
        if (this.mInitEd == true) goto L20;
        registerAppLifeCycle();
        int r7 = this.mMemoryWidgetConfig.c();
        JSONObject r1 = this.memory;
        if (r1 == null) goto L17;
        this.mMemoryWidgetConfig.k(r1.optInt(KEY_RUN_STRATEGY, this.mMemoryWidgetConfig.e()));
        r7 = this.memory.optInt(KEY_MEMORY_RATE, this.mMemoryWidgetConfig.c());
        if (this.memory.optInt(KEY_CLIENT_ANALYZE, 0) != 1) goto L14;
        boolean r2 = true;
    L15:
        this.mClientAnalyze = r2;
        this.mMemoryWidgetConfig.h(r2);
        goto L17
    L14:
        r2 = false;
    L17:
        if (this.mMemoryWidgetConfig.e() != 2) goto L19;
        c.c("reach top mode", new Object[0]);
        this.mMemoryWidgetConfig.i(r7);
        com.bytedance.memory.f.a r8 = this.mMemoryWidgetConfig;
        r8.j(getConfigInt(KEY_MAX_CAPACITY_ANALYSE, r8.d()));
    L19:
        com.bytedance.memory.a.a.l().m(this.mAppContext, this.mMemoryWidgetConfig, this.mResultListener);
        c.c("memorywidget is inited", new Object[0]);
        this.mInitEd = true;
    L20:
        Handler r9 = new Handler(Looper.getMainLooper());
        a r10 = new a(this);
        if (com.bytedance.memory.a.a.l().i() == false) goto L23;
        long r3 = 0;
    L24:
        r9.postDelayed(r10, r3);
        goto L26
    L23:
        r3 = 20000;
    L26:
        if (com.bytedance.memory.d.a.c("npth_hprof_close") == true) goto L29;
        com.bytedance.memory.e.b.c().d();
    L29:
        if (this.mCheckedFolder == false) goto L31;
        return;
    L31:
        this.mCheckedFolder = true;
        new Handler(Looper.getMainLooper()).postDelayed(new b(this), BDLocationConfig.sScanBleMaxInterval);
    }

    @Override // com.bytedance.apm.f, com.bytedance.services.apm.api.IWidget
    public void start() {
        super.start();
    }
}
