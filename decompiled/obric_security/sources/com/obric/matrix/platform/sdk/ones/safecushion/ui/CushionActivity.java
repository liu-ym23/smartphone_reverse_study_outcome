package com.obric.matrix.platform.sdk.ones.safecushion.ui;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import android.view.View;
import androidx.core.app.NotificationCompat;
import com.obric.matrix.platform.sdk.ones.internal.util.MLog;
import com.obric.matrix.platform.sdk.ones.safecushion.MatrixCushionConfig;
import com.obric.matrix.platform.sdk.ones.safecushion.MatrixCushionManager;
import com.obric.matrix.platform.sdk.ones.safecushion.SafeCushionConstant;
import com.obric.matrix.platform.sdk.ones.safecushion.SafeCushionCrashCounter;
import com.obric.matrix.platform.sdk.ones.safecushion.repair.BaseRepair;
import com.obric.matrix.platform.sdk.ones.safecushion.repair.SafeCushionRepairHandler;
import com.obric.matrix.platform.sdk.ones.safecushion.util.FlagHelper;
import com.obric.matrix.platform.sdk.ones.safecushion.util.SafeCushionFileUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import obric.widget.search.data.SearchConfigType;
import org.json.JSONObject;

/* JADX INFO: compiled from: CushionActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00122\u00020\u0001:\u0002\u0012\u0013B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014J\b\u0010\u0011\u001a\u00020\u000eH\u0014R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00060\bR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/safecushion/ui/CushionActivity;", "Landroid/app/Activity;", "()V", "config", "Lcom/obric/matrix/platform/sdk/ones/safecushion/MatrixCushionConfig;", "getConfig", "()Lcom/obric/matrix/platform/sdk/ones/safecushion/MatrixCushionConfig;", "controller", "Lcom/obric/matrix/platform/sdk/ones/safecushion/ui/CushionActivity$CushionControllerImpl;", "flagHelper", "Lcom/obric/matrix/platform/sdk/ones/safecushion/util/FlagHelper;", "repairHandler", "Lcom/obric/matrix/platform/sdk/ones/safecushion/repair/SafeCushionRepairHandler;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "Companion", "CushionControllerImpl", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CushionActivity extends Activity {
    public static final Companion Companion = null;
    private static final String TAG = "CushionActivity";
    public Map<Integer, View> _$_findViewCache;
    private final CushionControllerImpl controller;
    private final FlagHelper flagHelper;
    private final SafeCushionRepairHandler repairHandler;

    /* JADX INFO: compiled from: CushionActivity.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/safecushion/ui/CushionActivity$Companion;", "", "()V", "TAG", "", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: CushionActivity.kt */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u0010H\u0002J\b\u0010\u0013\u001a\u00020\u0010H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\bH\u0002J\b\u0010\u0018\u001a\u00020\u0010H\u0016JR\u0010\u0019\u001a\u00020\u00102\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f28\u0010\u001c\u001a4\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00100\u001dH\u0016R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\""}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/safecushion/ui/CushionActivity$CushionControllerImpl;", "Lcom/obric/matrix/platform/sdk/ones/safecushion/ui/SafeCushionController;", "(Lcom/obric/matrix/platform/sdk/ones/safecushion/ui/CushionActivity;)V", "crashCount", "", "getCrashCount", "()I", SearchConfigType.KEY_MODE, "", "getMode", "()Ljava/lang/String;", "repairAliases", "", "getRepairAliases", "()Ljava/util/List;", SafeCushionConstant.FINISH_STATE, "", "killApp", "killSelf", "markFinished", "openMarket", "", "openMarketByWeb", "pkgName", "restartApp", "startRepair", "repairList", "Lcom/obric/matrix/platform/sdk/ones/safecushion/repair/BaseRepair;", "onResult", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "success", NotificationCompat.CATEGORY_MESSAGE, "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private final class CushionControllerImpl implements SafeCushionController {
        final /* synthetic */ CushionActivity this$0;

        public CushionControllerImpl(CushionActivity r1) {
            this.this$0 = r1;
        }

        @Override // com.obric.matrix.platform.sdk.ones.safecushion.ui.SafeCushionController
        public String getMode() {
            String r0 = CushionActivity.access$getFlagHelper$p(this.this$0).getSafeMode();
            if (r0 != null) goto L6;
            return "repair";
        L6:
            return r0;
        }

        @Override // com.obric.matrix.platform.sdk.ones.safecushion.ui.SafeCushionController
        public int getCrashCount() {
            JSONObject r2 = SafeCushionFileUtils.INSTANCE.getCrashInfo();
            if (r2 != null) goto L5;
            return 0;
        L5:
            return r2.optInt(SafeCushionConstant.KEY_CRASH_COUNT, 0);
        }

        @Override // com.obric.matrix.platform.sdk.ones.safecushion.ui.SafeCushionController
        public List<String> getRepairAliases() {
            List<BaseRepair> r3 = CushionActivity.access$getConfig(this.this$0).getRepairsForCrashCount(getCrashCount());
            ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
            Iterator<T> r4 = r3.iterator();
        L4:
            if (r4.hasNext() == false) goto L6;
            r0.add(((BaseRepair) r4.next()).getAlias());
            goto L4
        L6:
            ArrayList r5 = new ArrayList();
            Iterator r1 = r0.iterator();
        L8:
            if (r1.hasNext() == false) goto L16;
            Object r2 = r1.next();
            if (((String) r2).length() <= 0) goto L12;
            boolean r6 = true;
        L13:
            if (r6 == false) goto L8;
            r5.add(r2);
            goto L8
        L12:
            r6 = false;
            goto L13
        L16:
            return r5;
        }

        @Override // com.obric.matrix.platform.sdk.ones.safecushion.ui.SafeCushionController
        public void startRepair(List<? extends BaseRepair> r3, final Function2<? super Boolean, ? super String, Unit> r4) {
            Intrinsics.checkNotNullParameter(r4, "onResult");
            CushionActivity.access$getRepairHandler$p(this.this$0).setRepairResultListener(new CushionActivity$CushionControllerImpl$startRepair$1(r4));
            SafeCushionRepairHandler r5 = CushionActivity.access$getRepairHandler$p(this.this$0);
            if (r3 != null) goto L5;
            r3 = CushionActivity.access$getConfig(this.this$0).getRepairsForCrashCount(getCrashCount());
        L5:
            r5.startRepair(r3);
        }

        @Override // com.obric.matrix.platform.sdk.ones.safecushion.ui.SafeCushionController
        public void restartApp() {
            String r0 = CushionActivity.access$getConfig(this.this$0).getTargetClassName();
            if (r0.length() != 0) goto L5;
            boolean r1 = true;
        L7:
            if (r1 == false) goto L20;
            MLog.e$default(CushionActivity.TAG, "restartApp: targetClassName is empty, just kill process", null, 4, null);
            killSelf();
            return;
        L20:
            Intent r2 = new Intent();     // Catch: Throwable -> L12 Exception -> L14
            r2.setComponent(new ComponentName(this.this$0, r0));     // Catch: Throwable -> L12 Exception -> L14
            r2.setFlags(335577088);     // Catch: Throwable -> L12 Exception -> L14
            PendingIntent.getActivity(this.this$0, 0, r2, 201326592).send();     // Catch: Throwable -> L12 Exception -> L14
        L16:
            killSelf();
            return;
        L14:
            e = move-exception;
            MLog.e(CushionActivity.TAG, "restartApp: error", e);     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            killSelf();
            throw th;
        L5:
            r1 = false;
            goto L7
        }

        @Override // com.obric.matrix.platform.sdk.ones.safecushion.ui.SafeCushionController
        public boolean openMarket() {
            String r2 = CushionActivity.access$getConfig(this.this$0).getPkgName();
            Intent r3 = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + r2));     // Catch: Exception -> L5 ActivityNotFoundException -> L7
            r3.setFlags(268435456);     // Catch: Exception -> L5 ActivityNotFoundException -> L7
            this.this$0.startActivity(r3);     // Catch: Exception -> L5 ActivityNotFoundException -> L7
            return true;
        L7:
            e = move-exception;
            MLog.e(CushionActivity.TAG, "openMarket: no market app, fallback to web", e);
            return openMarketByWeb(r2);
        L5:
            e = move-exception;
            MLog.e(CushionActivity.TAG, "openMarket: error", e);
            return false;
        }

        private final boolean openMarketByWeb(String r5) {
            Intent r1 = new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + r5));     // Catch: Exception -> L5
            r1.setFlags(268435456);     // Catch: Exception -> L5
            this.this$0.startActivity(r1);     // Catch: Exception -> L5
            return true;
        L5:
            e = move-exception;
            MLog.e(CushionActivity.TAG, "openMarketByWeb: error", e);
            return false;
        }

        @Override // com.obric.matrix.platform.sdk.ones.safecushion.ui.SafeCushionController
        public void markFinished() {
            CushionActivity.access$getFlagHelper$p(this.this$0).updateSafeModeState(getMode(), SafeCushionConstant.FINISH_STATE);
        }

        @Override // com.obric.matrix.platform.sdk.ones.safecushion.ui.SafeCushionController
        public void finish() {
            this.this$0.finish();
        }

        @Override // com.obric.matrix.platform.sdk.ones.safecushion.ui.SafeCushionController
        public void killApp() {
            killSelf();
        }

        private final void killSelf() {
            Process.killProcess(Process.myPid());
            System.exit(0);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int r3) {
        Map<Integer, View> r0 = this._$_findViewCache;
        View r1 = r0.get(Integer.valueOf(r3));
        if (r1 != null) goto L9;
        View r2 = findViewById(r3);
        if (r2 == null) goto L7;
        r0.put(Integer.valueOf(r3), r2);
        return r2;
    L7:
        return null;
    L9:
        return r1;
    }

    public CushionActivity() {
        this._$_findViewCache = new LinkedHashMap();
        this.flagHelper = new FlagHelper();
        this.repairHandler = new SafeCushionRepairHandler();
        this.controller = new CushionControllerImpl(this);
    }

    public static final /* synthetic */ MatrixCushionConfig access$getConfig(CushionActivity r0) {
        return r0.getConfig();
    }

    public static final /* synthetic */ FlagHelper access$getFlagHelper$p(CushionActivity r0) {
        return r0.flagHelper;
    }

    public static final /* synthetic */ SafeCushionRepairHandler access$getRepairHandler$p(CushionActivity r0) {
        return r0.repairHandler;
    }

    private final MatrixCushionConfig getConfig() {
        return MatrixCushionManager.Companion.getInstance().getConfig();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle r4) {
        super.onCreate(r4);
        SafeCushionUiProvider r5 = getConfig().getUiProvider();
        if (r5 != null) goto L6;
        MLog.e$default(TAG, "onCreate: uiProvider is null, finish", null, 4, null);
        finish();
        return;
    L6:
        SafeCushionCrashCounter.INSTANCE.initSafeMode();
        setContentView(r5.onCreateView(this, this.controller));
        this.flagHelper.markOpenSafeModePage(this.controller.getMode());
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        SafeCushionUiProvider r0 = getConfig().getUiProvider();
        if (r0 == null) goto L6;
        r0.onDestroy();
        return;
    }
}
