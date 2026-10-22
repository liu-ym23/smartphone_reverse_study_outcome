package com.bytedanceos.securitycenter.block;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.blockframework.framework.async.AsyncUIBlock;
import com.bytedance.blockframework.framework.core.BlockGenerator;
import com.bytedance.blockframework.framework.core.IBlockModel;
import com.bytedance.blockframework.framework.join.IBlockContext;
import com.bytedanceos.preventdisturb.ToastUtils;
import com.bytedanceos.security.Utils;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.progress.ODownloadProgressView;
import com.obric.oui.text.OTextView;
import com.obric.safecheck.update.VirusDbUpdateManager;
import com.obric.security.R;
import java.text.DateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: SafeCheckSettingsConfigBlock.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 82\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00030\u0001:\u00018B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0002J$\u0010!\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\"\u001a\u0004\u0018\u00010\b2\b\u0010#\u001a\u0004\u0018\u00010\nH\u0002J$\u0010$\u001a\u00020\u001c2\b\u0010\"\u001a\u0004\u0018\u00010\b2\b\u0010#\u001a\u0004\u0018\u00010\n2\u0006\u0010%\u001a\u00020&H\u0002J\u0010\u0010'\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010(\u001a\u00020 H\u0016J\u0010\u0010)\u001a\u00020\u001c2\u0006\u0010*\u001a\u00020+H\u0016J\u0010\u0010,\u001a\u00020\u001c2\u0006\u0010-\u001a\u00020.H\u0002J\u0010\u0010/\u001a\u00020\u001c2\u0006\u0010-\u001a\u00020.H\u0002J\b\u00100\u001a\u000201H\u0016J\u0010\u00102\u001a\u00020\u001c2\u0006\u0010-\u001a\u00020.H\u0016J\u0010\u00103\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u00104\u001a\u00020\u001cH\u0002J\b\u00105\u001a\u00020\u001cH\u0002J\b\u00106\u001a\u00020\u001cH\u0002J\u0010\u00107\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n \u0015*\u0004\u0018\u00010\u00140\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/bytedanceos/securitycenter/block/SafeCheckSettingsConfigBlock;", "Lcom/bytedance/blockframework/framework/async/AsyncUIBlock;", "Ljava/util/Objects;", "Lcom/bytedance/blockframework/framework/core/IBlockModel;", "blockContext", "Lcom/bytedance/blockframework/framework/join/IBlockContext;", "(Lcom/bytedance/blockframework/framework/join/IBlockContext;)V", "autoUpdateItem", "Lcom/obric/oui/lisitem/OCardListItem;", "autoUpdateSwitch", "Lcom/obric/oui/oswitch/OSwitch;", "cloudDetectionItem", "cloudDetectionSwitch", "mainHandler", "Landroid/os/Handler;", "updateButton", "Landroid/widget/LinearLayout;", "updateButtonText", "Landroid/widget/TextView;", "updateExecutor", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "updateLoadingView", "Lcom/obric/oui/progress/ODownloadProgressView;", "updateVirusDbItem", "updating", "Ljava/util/concurrent/atomic/AtomicBoolean;", "applyAutoUpdateSafely", "", "context", "Landroid/content/Context;", "enabled", "", "bindAutoUpdateSwitch", "item", "switch", "bindDefaultCheckedSwitch", "prefKey", "", "createUpdateButton", "enableAsyncBind", "generateSubBlocks", "generator", "Lcom/bytedance/blockframework/framework/core/BlockGenerator;", "initScanSettings", "view", "Landroid/view/View;", "initUpdateSettings", "layoutResource", "", "onViewCreated", "refreshLastUpdateSubtitle", "showButtonDisabledState", "showButtonLoadingState", "showButtonNormalState", "startManualUpdate", "Companion", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class SafeCheckSettingsConfigBlock extends AsyncUIBlock<Objects, IBlockModel<Objects>> {
    private static final Companion Companion = null;

    @Deprecated
    private static final float DISABLED_ALPHA = 0.3f;
    private OCardListItem autoUpdateItem;
    private OSwitch autoUpdateSwitch;
    private OCardListItem cloudDetectionItem;
    private OSwitch cloudDetectionSwitch;
    private final Handler mainHandler;
    private LinearLayout updateButton;
    private TextView updateButtonText;
    private final ExecutorService updateExecutor;
    private ODownloadProgressView updateLoadingView;
    private OCardListItem updateVirusDbItem;
    private final AtomicBoolean updating;

    /* JADX INFO: compiled from: SafeCheckSettingsConfigBlock.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/bytedanceos/securitycenter/block/SafeCheckSettingsConfigBlock$Companion;", "", "()V", "DISABLED_ALPHA", "", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    @Override // com.bytedance.blockframework.framework.async.IAsyncBind
    public boolean enableAsyncBind() {
        return false;
    }

    @Override // com.bytedance.blockframework.framework.base.BaseBlock
    public void generateSubBlocks(BlockGenerator r1) {
        Intrinsics.checkNotNullParameter(r1, "generator");
    }

    @Override // com.bytedance.blockframework.framework.async.AsyncUIBlock
    public int layoutResource() {
        return R.layout.safe_check_settings_config;
    }

    public SafeCheckSettingsConfigBlock(IBlockContext r2) {
        Intrinsics.checkNotNullParameter(r2, "blockContext");
        super(r2);
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.updateExecutor = Executors.newSingleThreadExecutor();
        this.updating = new AtomicBoolean(false);
    }

    public static final /* synthetic */ void access$applyAutoUpdateSafely(SafeCheckSettingsConfigBlock r0, Context r1, boolean r2) {
        r0.applyAutoUpdateSafely(r1, r2);
    }

    public static final /* synthetic */ Handler access$getMainHandler$p(SafeCheckSettingsConfigBlock r0) {
        return r0.mainHandler;
    }

    public static final /* synthetic */ AtomicBoolean access$getUpdating$p(SafeCheckSettingsConfigBlock r0) {
        return r0.updating;
    }

    public static final /* synthetic */ void access$refreshLastUpdateSubtitle(SafeCheckSettingsConfigBlock r0, Context r1) {
        r0.refreshLastUpdateSubtitle(r1);
    }

    public static final /* synthetic */ void access$showButtonDisabledState(SafeCheckSettingsConfigBlock r0) {
        r0.showButtonDisabledState();
    }

    public static final /* synthetic */ void access$showButtonNormalState(SafeCheckSettingsConfigBlock r0) {
        r0.showButtonNormalState();
    }

    public static final /* synthetic */ void access$startManualUpdate(SafeCheckSettingsConfigBlock r0, Context r1) {
        r0.startManualUpdate(r1);
    }

    @Override // com.bytedance.blockframework.framework.async.AsyncUIBlock, com.bytedance.blockframework.framework.base.IUIBlock
    public void onViewCreated(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        initScanSettings(r2);
        initUpdateSettings(r2);
    }

    private final void initScanSettings(View r11) {
        OCardListItem r0 = (OCardListItem) r11.findViewById(R.id.safe_check_settings_cloud_detection);
        this.cloudDetectionItem = r0;
        if (r0 == null) goto L5;
        OCardListItem.setCardPosition$default(r0, 0, false, 2, null);
    L5:
        Context r5 = r11.getContext();
        Intrinsics.checkNotNullExpressionValue(r5, "view.context");
        OSwitch r1 = new OSwitch(r5, null, 0, 6, null);
        this.cloudDetectionSwitch = r1;
        bindDefaultCheckedSwitch(this.cloudDetectionItem, r1, "cloud_detection");
    }

    private final void initUpdateSettings(final View r13) {
        OCardListItem r0 = (OCardListItem) r13.findViewById(R.id.safe_check_settings_auto_update);
        this.autoUpdateItem = r0;
        if (r0 == null) goto L5;
        OCardListItem.setCardPosition$default(r0, 1, false, 2, null);
    L5:
        Context r6 = r13.getContext();
        Intrinsics.checkNotNullExpressionValue(r6, "view.context");
        this.autoUpdateSwitch = new OSwitch(r6, null, 0, 6, null);
        Context r1 = r13.getContext();
        Intrinsics.checkNotNullExpressionValue(r1, "view.context");
        bindAutoUpdateSwitch(r1, this.autoUpdateItem, this.autoUpdateSwitch);
        OCardListItem r2 = (OCardListItem) r13.findViewById(R.id.safe_check_settings_update_row);
        this.updateVirusDbItem = r2;
        if (r2 == null) goto L8;
        OCardListItem.setCardPosition$default(r2, 3, false, 2, null);
    L8:
        Context r3 = r13.getContext();
        Intrinsics.checkNotNullExpressionValue(r3, "view.context");
        LinearLayout r4 = createUpdateButton(r3);
        this.updateButton = r4;
        OCardListItem r5 = this.updateVirusDbItem;
        if (r5 == null) goto L11;
        r5.setCustomEndView(r4);
    L11:
        OCardListItem r7 = this.updateVirusDbItem;
        if (r7 == null) goto L14;
        r7.showCustomEnd(true);
    L14:
        LinearLayout r8 = this.updateButton;
        if (r8 == null) goto L17;
        r8.setOnClickListener(new ViewOnClickListenerC01731(this, r13));
    L17:
        Context r9 = r13.getContext();
        Intrinsics.checkNotNullExpressionValue(r9, "view.context");
        refreshLastUpdateSubtitle(r9);
        VirusDbUpdateManager r10 = VirusDbUpdateManager.INSTANCE;
        Context r14 = r13.getContext();
        Intrinsics.checkNotNullExpressionValue(r14, "view.context");
        Context r15 = r14.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(r15, "view.context.applicationContext");
        if (r10.hasPendingUpdate(r15) == false) goto L20;
        showButtonNormalState();
        return;
    L20:
        showButtonDisabledState();
    }

    private final void bindDefaultCheckedSwitch(OCardListItem r4, OSwitch r5, final String r6) {
        if (r5 == null) goto L7;
        Context r0 = r5.getContext();
        if (r0 == null) goto L7;
        final SharedPreferences r1 = r0.getSharedPreferences("safe_check_settings", 0);
    L9:
        if (r1 == null) goto L11;
        boolean r2 = r1.getBoolean(r6, true);
    L12:
        if (r5 == null) goto L14;
        r5.setChecked(r2);
    L14:
        if (r4 == null) goto L16;
        r4.setCustomEndView(r5);
    L16:
        if (r4 == null) goto L18;
        r4.showCustomEnd(true);
    L18:
        if (r4 == null) goto L20;
        r4.setOnContentClickListener(null);
    L20:
        if (r5 == null) goto L22;
        r5.setOnClickListener(new ViewOnClickListenerC01721(r1, r6));
    L22:
        if (r5 == null) goto L25;
        r5.setOnCheckedChangeListener(new AnonymousClass2(r1, r6));
        return;
    L25:
        return;
    L11:
        r2 = true;
    L7:
        r1 = null;
        goto L9
    }

    private final void bindAutoUpdateSwitch(final Context r5, OCardListItem r6, OSwitch r7) {
        final SharedPreferences r0 = r5.getSharedPreferences("safe_check_settings", 0);
        boolean r1 = r0.getBoolean(VirusDbUpdateManager.KEY_AUTO_UPDATE, true);
        if (r7 == null) goto L5;
        r7.setChecked(r1);
    L5:
        if (r7 == null) goto L7;
        r7.setClickable(true);
    L7:
        if (r6 == null) goto L9;
        r6.setCustomEndView(r7);
    L9:
        if (r6 == null) goto L11;
        r6.showCustomEnd(true);
    L11:
        if (r6 == null) goto L13;
        r6.setOnContentClickListener(null);
    L13:
        if (r7 == null) goto L15;
        r7.setOnCheckedChangeListener(new AnonymousClass1(this, r0, r5));
    L15:
        applyAutoUpdateSafely(r5, r1);
    }

    private final void applyAutoUpdateSafely(Context r1, boolean r2) {
        Context r0 = r1.getApplicationContext();     // Catch: Throwable -> L4
        Intrinsics.checkNotNullExpressionValue(r0, "context.applicationContext");     // Catch: Throwable -> L4
        VirusDbUpdateManager.applyAutoUpdateSetting(r0, r2);     // Catch: Throwable -> L4
        return;
    }

    private final void startManualUpdate(final Context r4) {
        if (this.updating.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        final Context r0 = r4.getApplicationContext();
        if (Utils.isNetworkAvailable(r0) == true) goto L9;
        this.updating.set(false);
        ToastUtils.show(r4.getString(R.string.virus_db_update_no_network));
        return;
    L9:
        showButtonLoadingState();
        this.updateExecutor.execute(new RunnableC01741(this, r0, r4));
    }

    private final void showButtonLoadingState() {
        LinearLayout r0 = this.updateButton;
        if (r0 == null) goto L5;
        r0.setEnabled(false);
    L5:
        LinearLayout r1 = this.updateButton;
        if (r1 == null) goto L8;
        r1.setClickable(false);
    L8:
        LinearLayout r2 = this.updateButton;
        if (r2 == null) goto L11;
        r2.setPadding(MathKt.roundToInt(TypedValue.applyDimension(1, 8, Resources.getSystem().getDisplayMetrics())), 0, MathKt.roundToInt(TypedValue.applyDimension(1, 12, Resources.getSystem().getDisplayMetrics())), 0);
    L11:
        ODownloadProgressView r3 = this.updateLoadingView;
        if (r3 == null) goto L14;
        r3.setVisibility(0);
    L14:
        ODownloadProgressView r4 = this.updateLoadingView;
        if (r4 == null) goto L17;
        r4.setCurrentState(0);
    L17:
        TextView r6 = this.updateButtonText;
        if (r6 == null) goto L21;
        r6.setAlpha(1.0f);
        return;
    }

    private final void showButtonDisabledState() {
        LinearLayout r0 = this.updateButton;
        if (r0 == null) goto L5;
        r0.setEnabled(false);
    L5:
        LinearLayout r1 = this.updateButton;
        if (r1 == null) goto L8;
        r1.setClickable(false);
    L8:
        LinearLayout r2 = this.updateButton;
        if (r2 == null) goto L11;
        float r3 = 12;
        r2.setPadding(MathKt.roundToInt(TypedValue.applyDimension(1, r3, Resources.getSystem().getDisplayMetrics())), 0, MathKt.roundToInt(TypedValue.applyDimension(1, r3, Resources.getSystem().getDisplayMetrics())), 0);
    L11:
        ODownloadProgressView r4 = this.updateLoadingView;
        if (r4 == null) goto L14;
        r4.setCurrentState(10);
    L14:
        ODownloadProgressView r5 = this.updateLoadingView;
        if (r5 == null) goto L17;
        r5.setVisibility(8);
    L17:
        TextView r6 = this.updateButtonText;
        if (r6 == null) goto L21;
        r6.setAlpha(0.3f);
        return;
    }

    private final void showButtonNormalState() {
        LinearLayout r0 = this.updateButton;
        if (r0 == null) goto L5;
        r0.setEnabled(true);
    L5:
        LinearLayout r1 = this.updateButton;
        if (r1 == null) goto L8;
        r1.setClickable(true);
    L8:
        LinearLayout r2 = this.updateButton;
        if (r2 == null) goto L11;
        float r3 = 12;
        r2.setPadding(MathKt.roundToInt(TypedValue.applyDimension(1, r3, Resources.getSystem().getDisplayMetrics())), 0, MathKt.roundToInt(TypedValue.applyDimension(1, r3, Resources.getSystem().getDisplayMetrics())), 0);
    L11:
        ODownloadProgressView r4 = this.updateLoadingView;
        if (r4 == null) goto L14;
        r4.setCurrentState(10);
    L14:
        ODownloadProgressView r5 = this.updateLoadingView;
        if (r5 == null) goto L17;
        r5.setVisibility(8);
    L17:
        TextView r6 = this.updateButtonText;
        if (r6 == null) goto L21;
        r6.setAlpha(1.0f);
        return;
    }

    private final void refreshLastUpdateSubtitle(Context r6) {
        long r0 = VirusDbUpdateManager.INSTANCE.getLastUpdateTime(r6);
        if (r0 <= 0) goto L5;
        String r7 = r6.getString(R.string.virus_db_last_update, new Object[]{DateFormat.getDateInstance(1).format(new Date(r0))});
    L6:
        Intrinsics.checkNotNullExpressionValue(r7, "if (lastTime > 0L) {\n   …_never_updated)\n        }");
        OCardListItem r1 = this.updateVirusDbItem;
        if (r1 == null) goto L9;
        r1.setSubTitle(r7);
    L9:
        OCardListItem r5 = this.updateVirusDbItem;
        if (r5 == null) goto L13;
        r5.showSubTitle(true);
        return;
    L13:
        return;
    L5:
        r7 = r6.getString(R.string.virus_db_never_updated);
        goto L6
    }

    private final LinearLayout createUpdateButton(Context r12) {
        LinearLayout r0 = new LinearLayout(r12);
        r0.setLayoutParams(new ViewGroup.LayoutParams(-2, MathKt.roundToInt(TypedValue.applyDimension(1, 32, Resources.getSystem().getDisplayMetrics()))));
        r0.setOrientation(0);
        r0.setGravity(17);
        r0.setMinimumWidth(MathKt.roundToInt(TypedValue.applyDimension(1, 52, Resources.getSystem().getDisplayMetrics())));
        float r2 = 12;
        r0.setPadding(MathKt.roundToInt(TypedValue.applyDimension(1, r2, Resources.getSystem().getDisplayMetrics())), 0, MathKt.roundToInt(TypedValue.applyDimension(1, r2, Resources.getSystem().getDisplayMetrics())), 0);
        r0.setBackground(ContextCompat.getDrawable(r12, R.drawable.safe_check_update_button_bg));
        r0.setClickable(true);
        r0.setFocusable(true);
        ODownloadProgressView r1 = new ODownloadProgressView(r12);
        float r5 = 16;
        LinearLayout.LayoutParams r3 = new LinearLayout.LayoutParams(MathKt.roundToInt(TypedValue.applyDimension(1, r5, Resources.getSystem().getDisplayMetrics())), MathKt.roundToInt(TypedValue.applyDimension(1, r5, Resources.getSystem().getDisplayMetrics())));
        r3.setMarginEnd(MathKt.roundToInt(TypedValue.applyDimension(1, 4, Resources.getSystem().getDisplayMetrics())));
        Unit r4 = Unit.INSTANCE;
        r1.setLayoutParams(r3);
        r1.setVisibility(8);
        OTextView r6 = new OTextView(r12, null, 0, null, 14, null);
        r6.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        r6.setText(r12.getString(R.string.update));
        r6.setTextSize(14.0f);
        r6.setTextColor(ContextCompat.getColor(r12, R.color.oui_text_1));
        r0.addView(r1);
        r0.addView(r6);
        this.updateLoadingView = r1;
        this.updateButtonText = r6;
        return r0;
    }
}
