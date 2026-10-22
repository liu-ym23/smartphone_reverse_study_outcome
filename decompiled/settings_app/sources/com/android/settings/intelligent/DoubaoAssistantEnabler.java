package com.android.settings.intelligent;

import android.content.BroadcastReceiver;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.widget.CompoundButton;
import com.GlobalProxyLancet;
import com.android.settings.search.IndexDatabaseHelper;
import com.android.settings.settingitemsprovider.DatabaseHelper;
import com.android.settings.teaevent.TrackerEvent;
import com.android.settingslib.SliceBroadcastRelay;
import com.android.settingslib.drawer.EntriesProvider;
import com.obric.olog.OLog;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: DoubaoAssistantEnabler.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u0000 %2\u00020\u0001:\u0001%B9\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0006\u0010\u001d\u001a\u00020\rJ)\u0010\u001e\u001a\u00020\u001c2!\u0010\u001f\u001a\u001d\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u001c0\u0018J\u000e\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\rJ\u000e\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\rJ\u0006\u0010$\u001a\u00020\u001cR\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u0004¢\u0006\u0004\n\u0002\b\u0011R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0013X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0010X\u0082D¢\u0006\u0002\n\u0000R+\u0010\u0017\u001a\u001f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/android/settings/intelligent/DoubaoAssistantEnabler;", "", "context", "Landroid/content/Context;", "switchEx", "Lcom/obric/oui/oswitch/OSwitch;", "containerView", "Landroid/view/View;", "style", "Lcom/obric/oui/lisitem/OCardListItem;", "checkedListener", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "mOpposite", "", "(Landroid/content/Context;Lcom/obric/oui/oswitch/OSwitch;Landroid/view/View;Lcom/obric/oui/lisitem/OCardListItem;Landroid/widget/CompoundButton$OnCheckedChangeListener;Z)V", "TAG", "", "TAG$1", "defaultValue", "", "disableValue", "enableValue", "enablerKey", "mEnableChange", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "enable", "", "isEnabled", "setEnableChangeCallback", "callback", "setEnabled", IndexDatabaseHelper.IndexColumns.ENABLED, "updateSwitchView", EntriesProvider.METHOD_IS_CHECKED, "updateView", "Companion", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DoubaoAssistantEnabler {
    public static final Companion Companion = null;
    public static final String DOUBAO_ASSISTANT_PKG = "com.larus.nova";
    public static final String METHOD_DISABLE_ASSIST = "disableAssist";
    public static final String METHOD_ENABLE_ASSIST = "enableAssist";
    public static final String METHOD_IS_ASSIST_DISABLED = "isAssistDisabled";
    public static final String METHOD_SHOW_ENABLE_DIALOG = "showDialog";
    public static final String METHOD_SHOW_INSTALL_DIALOG = "showInstallDialog";
    public static final String RESULT_KEY = "result";
    public static final String TAG = "DoubaoAssistantEnabler-ServicesUtils";
    private final String TAG$1;
    private final CompoundButton.OnCheckedChangeListener checkedListener;
    private final View containerView;
    private final Context context;
    private final int defaultValue;
    private final int disableValue;
    private final int enableValue;
    private final String enablerKey;
    private Function1<? super Boolean, Unit> mEnableChange;
    private final boolean mOpposite;
    private final OCardListItem style;
    private final OSwitch switchEx;

    /* JADX INFO: compiled from: DoubaoAssistantEnabler.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u001e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0007J\u0016\u0010\u0016\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\rJ\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0018\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u0012H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/android/settings/intelligent/DoubaoAssistantEnabler$Companion;", "", "()V", "DOUBAO_ASSISTANT_PKG", "", "METHOD_DISABLE_ASSIST", "METHOD_ENABLE_ASSIST", "METHOD_IS_ASSIST_DISABLED", "METHOD_SHOW_ENABLE_DIALOG", "METHOD_SHOW_INSTALL_DIALOG", "RESULT_KEY", "TAG", "getAssistantDisabled", "", "context", "Landroid/content/Context;", "isInstalled", "registerReceiver", "Landroid/content/BroadcastReceiver;", "uninstall", "Lkotlin/Function0;", "", "setAssistantEnabled", IndexDatabaseHelper.IndexColumns.ENABLED, DoubaoAssistantEnabler.METHOD_SHOW_INSTALL_DIALOG, "unregisterReceiver", SliceBroadcastRelay.EXTRA_RECEIVER, "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v11, types: [android.os.Bundle] */
        /* JADX WARN: Type inference failed for: r3v15, types: [android.os.Bundle] */
        /* JADX WARN: Type inference failed for: r3v16 */
        /* JADX WARN: Type inference failed for: r3v18 */
        /* JADX WARN: Type inference failed for: r3v20 */
        /* JADX WARN: Type inference failed for: r3v23 */
        /* JADX WARN: Type inference failed for: r3v24 */
        /* JADX WARN: Type inference failed for: r3v25 */
        /* JADX WARN: Type inference failed for: r3v5 */
        /* JADX WARN: Type inference failed for: r3v6, types: [android.content.ContentProviderClient] */
        /* JADX WARN: Type inference failed for: r3v9 */
        /* JADX WARN: Type inference failed for: r4v16 */
        /* JADX WARN: Type inference failed for: r4v18 */
        /* JADX WARN: Type inference failed for: r4v2 */
        /* JADX WARN: Type inference failed for: r4v20 */
        /* JADX WARN: Type inference failed for: r4v21 */
        /* JADX WARN: Type inference failed for: r4v22 */
        /* JADX WARN: Type inference failed for: r4v23 */
        /* JADX WARN: Type inference failed for: r4v24 */
        /* JADX WARN: Type inference failed for: r4v4 */
        /* JADX WARN: Type inference failed for: r4v6 */
        /* JADX WARN: Type inference failed for: r4v7 */
        /* JADX WARN: Type inference failed for: r4v8 */
        /* JADX WARN: Type inference failed for: r4v9 */
        public final boolean setAssistantEnabled(Context r4, boolean r5) {
            Intrinsics.checkNotNullParameter(r4, "context");
            OLog.i(DoubaoAssistantEnabler.TAG, "setAssistantEnabled1: " + r5);
            ?? r3 = 0;
            r3 = 0;
            r3 = 0;
            r3 = 0;
            ContentProviderClient r6 = null;
            r6 = null;
            ContentProviderClient r1 = r4.getContentResolver().acquireUnstableContentProviderClient(Uri.parse("content://obric.assist.management"));     // Catch: Throwable -> L16 RemoteException -> L22
            if (r5 == false) goto L6;
            String r2 = DoubaoAssistantEnabler.METHOD_ENABLE_ASSIST;
        L7:
            if (r1 != null) goto L39;
        L9:
            DatabaseHelper.getInstance(r4).handleAssistantChangeStateChanged(r5);     // Catch: Throwable -> L12 RemoteException -> L14
            if (r1 == null) goto L27;
            r1.close();
        L27:
            if (r3 == 0) goto L29;
            boolean r7 = r3.getBoolean("result");
            OLog.i(DoubaoAssistantEnabler.TAG, "setAssistantEnabled call result = " + r7);
        L30:
            OLog.i(DoubaoAssistantEnabler.TAG, "setAssistantEnabled2");
            return r7;
        L29:
            r7 = false;
            goto L30
        L14:
            e = move-exception;
            RemoteException r8 = e;
            ?? r9 = r3;
            r6 = r1;
        L24:
            OLog.e(DoubaoAssistantEnabler.TAG, "setAssistantEnabled call remote show dialog error: ", r8);     // Catch: Throwable -> L32
            ?? r10 = r9;
            ?? r11 = r9;
            if (r6 != null) goto L20;
        L21:
            r3 = r10;
        L20:
            r6.close();
            r10 = r11;
        L12:
            th = move-exception;
            Throwable r12 = th;
            ?? r13 = r3;
            r6 = r1;
        L18:
            OLog.e(DoubaoAssistantEnabler.TAG, "setAssistantEnabled error: ", r12);     // Catch: Throwable -> L32
            r10 = r13;
            r11 = r13;
            if (r6 == null) goto L21;
        L39:
            r3 = r1.call(r2, null, null);     // Catch: Throwable -> L12 RemoteException -> L14
            goto L9
        L6:
            r2 = DoubaoAssistantEnabler.METHOD_DISABLE_ASSIST;
            goto L7
        L32:
            th = move-exception;
            if (r3 == 0) goto L35;
            r3.close();
        L35:
            throw th;
        L22:
            e = move-exception;
            r8 = e;
            r9 = 0;
        L16:
            th = move-exception;
            r12 = th;
            r13 = 0;
            goto L18
        }

        public final boolean getAssistantDisabled(Context r6) {
            Intrinsics.checkNotNullParameter(r6, "context");
            OLog.i(DoubaoAssistantEnabler.TAG, "getAssistantDisabled1");
            Bundle r0 = null;
            ContentProviderClient r2 = r6.getContentResolver().acquireUnstableContentProviderClient(Uri.parse("content://obric.assist.management"));     // Catch: Throwable -> L13 RemoteException -> L18
        L5:
            if (r2 != null) goto L38;
        L7:
            if (r2 == null) goto L23;
        L8:
            r2.close();
        L35:
        L23:
            if (r0 == null) goto L25;
            boolean r1 = r0.getBoolean("result");
            OLog.i(DoubaoAssistantEnabler.TAG, "getAssistantDisabled call result = " + r1);
        L27:
            if (isInstalled(r6) == true) goto L30;
            OLog.i(DoubaoAssistantEnabler.TAG, "getAssistantDisabled uninstall");
            return true;
        L30:
            return r1;
        L25:
            r1 = false;
            goto L27
        L38:
            r0 = r2.call(DoubaoAssistantEnabler.METHOD_IS_ASSIST_DISABLED, null, null);     // Catch: Throwable -> L9 RemoteException -> L11
        L11:
            e = e;
        L20:
            OLog.e(DoubaoAssistantEnabler.TAG, "getAssistantDisabled call remote show dialog error: ", e);     // Catch: Throwable -> L31
            if (r2 == null) goto L35;
        L9:
            th = th;
        L15:
            OLog.e(DoubaoAssistantEnabler.TAG, "getAssistantDisabled error: ", th);     // Catch: Throwable -> L31
            if (r2 == null) goto L35;
        L31:
            th = move-exception;
            if (r2 == null) goto L34;
            r2.close();
        L34:
            throw th;
        L18:
            e = e;
            r2 = null;
        L13:
            th = th;
            r2 = null;
            goto L15
        }

        @JvmStatic
        public final void showInstallDialog(Context r4) {
            Intrinsics.checkNotNullParameter(r4, "context");
            ContentProviderClient r0 = null;
            Bundle r1 = null;
            r1 = null;
            r1 = null;
            ContentProviderClient r5 = r4.getContentResolver().acquireUnstableContentProviderClient(Uri.parse("content://obric.assist.management"));     // Catch: Throwable -> L11 RemoteException -> L13
            if (r5 != null) goto L26;
        L9:
            if (r5 == null) goto L18;
        L10:
            r5.close();
        L18:
            if (r1 == null) goto L31;
            OLog.i(DoubaoAssistantEnabler.TAG, "call result = " + r1.getBoolean("result"));
            return;
        L31:
            return;
        L26:
            r1 = r5.call(DoubaoAssistantEnabler.METHOD_SHOW_INSTALL_DIALOG, null, null);     // Catch: RemoteException -> L7 Throwable -> L21
        L7:
            e = e;
        L15:
            OLog.e(DoubaoAssistantEnabler.TAG, "call remote show dialog error!", e);     // Catch: Throwable -> L21
            if (r5 == null) goto L18;
        L21:
            th = th;
            r0 = r5;
        L23:
            if (r0 == null) goto L25;
            r0.close();
        L25:
            throw th;
        L13:
            e = e;
            r5 = null;
        L11:
            th = th;
            goto L23
        }

        @JvmStatic
        public final boolean isInstalled(Context r3) {
            Intrinsics.checkNotNullParameter(r3, "context");
            if (r3.getPackageManager().getPackageInfo("com.larus.nova", 0) == null) goto L12;
            return true;
        L12:
            return false;
        L7:
            e = move-exception;
            OLog.e(DoubaoAssistantEnabler.TAG, "isInstalled", e);
            return false;
        }

        @JvmStatic
        public final BroadcastReceiver registerReceiver(Context r2, final Function0<Unit> r3) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, "uninstall");
            BroadcastReceiver r1 = new DoubaoAssistantEnabler$Companion$registerReceiver$receiver$1(r3);
            IntentFilter r4 = new IntentFilter("android.intent.action.PACKAGE_REMOVED");
            r4.addDataScheme("package");
            BroadcastReceiver r5 = r1;
            GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r2, r5, r4, 2);
            return r5;
        }

        @JvmStatic
        public final void unregisterReceiver(Context r1, BroadcastReceiver r2) {
            Intrinsics.checkNotNullParameter(r1, "context");
            Intrinsics.checkNotNullParameter(r2, SliceBroadcastRelay.EXTRA_RECEIVER);
            r1.unregisterReceiver(r2);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public DoubaoAssistantEnabler(Context r11, OSwitch r12, View r13, OCardListItem r14, CompoundButton.OnCheckedChangeListener r15) {
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, "switchEx");
        Intrinsics.checkNotNullParameter(r13, "containerView");
        Intrinsics.checkNotNullParameter(r14, "style");
        Intrinsics.checkNotNullParameter(r15, "checkedListener");
        this(r11, r12, r13, r14, r15, false, 32, null);
    }

    @JvmStatic
    public static final boolean isInstalled(Context r1) {
        return Companion.isInstalled(r1);
    }

    @JvmStatic
    public static final BroadcastReceiver registerReceiver(Context r1, Function0<Unit> r2) {
        return Companion.registerReceiver(r1, r2);
    }

    @JvmStatic
    public static final void showInstallDialog(Context r1) {
        Companion.showInstallDialog(r1);
    }

    @JvmStatic
    public static final void unregisterReceiver(Context r1, BroadcastReceiver r2) {
        Companion.unregisterReceiver(r1, r2);
    }

    public DoubaoAssistantEnabler(Context r2, OSwitch r3, View r4, OCardListItem r5, CompoundButton.OnCheckedChangeListener r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "switchEx");
        Intrinsics.checkNotNullParameter(r4, "containerView");
        Intrinsics.checkNotNullParameter(r5, "style");
        Intrinsics.checkNotNullParameter(r6, "checkedListener");
        this.context = r2;
        this.switchEx = r3;
        this.containerView = r4;
        this.style = r5;
        this.checkedListener = r6;
        this.mOpposite = r7;
        this.TAG$1 = Reflection.getOrCreateKotlinClass(DoubaoAssistantEnabler.class).getSimpleName();
        this.enablerKey = "doubao_enabler_tmp";
        this.enableValue = 1;
        this.defaultValue = this.disableValue;
        updateView();
        r3.setOnCheckedChangeListener(r6);
    }

    public /* synthetic */ DoubaoAssistantEnabler(Context r8, OSwitch r9, View r10, OCardListItem r11, CompoundButton.OnCheckedChangeListener r12, boolean r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 32) == 0) goto L5;
        r13 = false;
    L5:
        this(r8, r9, r10, r11, r12, r13);
    }

    public final void updateView() {
        this.switchEx.setOnCheckedChangeListener(null);
        this.switchEx.setChecked(isEnabled());
        this.switchEx.setOnCheckedChangeListener(this.checkedListener);
        View r0 = this.containerView;
        if (this.switchEx.isChecked() == false) goto L5;
        int r2 = 0;
    L6:
        r0.setVisibility(r2);
        OCardListItem.setCardPosition$default(this.style, this.switchEx.isChecked() ? 1 : 0, false, 2, null);
        return;
    L5:
        r2 = 8;
        goto L6
    }

    public final void updateSwitchView(boolean r3) {
        this.switchEx.setOnCheckedChangeListener(null);
        this.switchEx.setChecked(r3);
        this.switchEx.setOnCheckedChangeListener(this.checkedListener);
    }

    public final boolean isEnabled() {
        boolean r0 = !Companion.getAssistantDisabled(this.context);
        OLog.i(this.TAG$1, "isEnabled=" + r0);
        return r0;
    }

    public final void setEnabled(boolean r5) {
        OLog.i(this.TAG$1, "setEnabled=" + r5 + ", ret=" + Companion.setAssistantEnabled(this.context, r5));
        TrackerEvent.switchEvent("settings_system_intelligent", r5);
        updateView();
        Function1<? super Boolean, Unit> r4 = this.mEnableChange;
        if (r4 == null) goto L6;
        r4.invoke(Boolean.valueOf(r5));
        return;
    }

    public final void setEnableChangeCallback(Function1<? super Boolean, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.mEnableChange = r2;
    }
}
