package com.obric.oui.window.permission;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowInsetsController;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.android.settings.NotificationDisplayDetailsActivity;
import com.android.settings.teaevent.AppMetricsUtils;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.common.oui.R;
import com.obric.olog.OLog;
import com.obric.oui.button.OButton;
import com.obric.oui.material.MaterialConfigFormatNames;
import com.obric.oui.privacy.OPrivacySheet;
import com.obric.oui.privacy.OPrivacySheetConfig;
import com.obric.oui.privacy.PrivacyItem;
import com.obric.oui.sheet.v2.OSheet;
import com.obric.oui.utils.StyleUtil;
import com.obric.oui.utils.log.L;
import com.obric.privacy.GrantUtil;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.calendar.MonthWeekEventsView;
import org.apache.commons.math3.geometry.VectorFormat;

/* JADX INFO: compiled from: PrivacyStatementActivity.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0011\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 O2\u00020\u0001:\u0003OPQB\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\b\u0010\u001b\u001a\u00020\bH\u0016J\b\u0010\u001c\u001a\u00020\u0013H\u0002J\"\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020!H\u0002J\u0010\u0010#\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J8\u0010$\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0014\u001a\u00020!2\u0006\u0010%\u001a\u00020\u00192\u0016\b\u0002\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0013\u0018\u00010'H\u0002J\b\u0010(\u001a\u00020!H\u0002J\b\u0010)\u001a\u00020\bH\u0002J\b\u0010*\u001a\u00020\u0013H\u0002J\b\u0010+\u001a\u00020\u0013H\u0016J\b\u0010,\u001a\u00020\u0013H\u0016J\b\u0010-\u001a\u00020\u0013H\u0016J\u0012\u0010.\u001a\u00020\u00132\b\u0010/\u001a\u0004\u0018\u000100H\u0015J\b\u00101\u001a\u00020\u0013H\u0014J\b\u00102\u001a\u00020\u0013H\u0016J\b\u00103\u001a\u00020\u0013H\u0016J\b\u00104\u001a\u00020\u0013H\u0014J\b\u00105\u001a\u00020\u0013H\u0014J\b\u00106\u001a\u00020\u0013H\u0014J\b\u00107\u001a\u00020\u0013H\u0014J\u0018\u00108\u001a\u00020\u00132\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!H\u0002J+\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020!0>2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002¢\u0006\u0002\u0010?J \u0010@\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\b\u0010A\u001a\u00020\u0013H\u0002J\u0012\u0010B\u001a\u00020\u00132\b\u0010C\u001a\u0004\u0018\u00010\u0004H\u0002J\u000e\u0010D\u001a\u00020\u00132\u0006\u0010E\u001a\u00020\bJ\u0010\u0010F\u001a\u00020\b2\u0006\u0010G\u001a\u00020HH\u0002J\u0010\u0010I\u001a\u00020\u00132\u0006\u0010J\u001a\u00020KH\u0007J\u0014\u0010L\u001a\u00020\u0013*\u00020M2\b\b\u0002\u0010N\u001a\u00020\bR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006R"}, d2 = {"Lcom/obric/oui/window/permission/PrivacyStatementActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "contentChild", "Landroid/view/View;", "firstFramePreDrawListener", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "firstFrameReported", "", "firstFrameTargetView", "hasAgreed", "onCreateStartElapsedRealtime", "", "privacySheet", "Lcom/obric/oui/privacy/OPrivacySheet;", "root", "showNetworkConfirm", "useLinkTextAsTitle", "applyClickableSpan", "", "text", "Landroid/text/SpannableStringBuilder;", "span", "Landroid/text/style/ClickableSpan;", "start", "", TraceStatsConsts.STATS_KEY_END, "canFinishSelfInOnCreateIfCallbackNotSet", "clearCallbacksAndFinish", "createClickableSpan", "context", "Landroid/content/Context;", "url", "", "title", "createHeaderView", "createSingleButton", "styleRes", "onClickListener", "Lkotlin/Function1;", "getAppPackageName", "isEdgeToEdge", "logPrivacySheetFirstFrame", "onAgree", "onBackPressed", "onContentChanged", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onDisagree", "onPageDismiss", "onPause", "onResume", "onStart", "onStop", "openBrowser", "processMessage", "Landroid/text/SpannableString;", "message", "", "urls", "", "(Ljava/lang/CharSequence;[Ljava/lang/String;Landroid/content/Context;)Landroid/text/SpannableString;", "removeBracePair", "removeFirstFramePreDrawListener", "reportPrivacySheetFirstFrame", "targetView", "setSystemInsetsAppearance", "isLightMode", "shouldApplyJustification", "locale", "Ljava/util/Locale;", "showSheetDialog", "intent", "Landroid/content/Intent;", "setSmartJustification", "Landroid/widget/TextView;", "force", "Companion", "LinkClickListener", "PrivacyConsentCallback", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class PrivacyStatementActivity extends AppCompatActivity {
    public static final Companion Companion = null;
    private static final String EXTRA__KEY_ACTIVITY_INSTANCE_ID = "PrivacyStatementActivityInstanceId";
    private static final String TAG = "PrivacyStatementActivity";
    private static final Map<String, Companion.ActivityCustomizer> activityCustomizers = null;
    private static int counter;
    private static final Map<String, LinkClickListener> linkClickListeners = null;
    private static final Map<String, PrivacyConsentCallback> privacyConsentCallbacks = null;
    private static final Map<String, List<PrivacyItem>> privacyItems = null;
    private static final Map<String, List<String>> privacyPolicyLinkTextsList = null;
    private View contentChild;
    private ViewTreeObserver.OnPreDrawListener firstFramePreDrawListener;
    private boolean firstFrameReported;
    private View firstFrameTargetView;
    private boolean hasAgreed;
    private long onCreateStartElapsedRealtime;
    private OPrivacySheet privacySheet;
    private View root;
    private boolean showNetworkConfirm;
    private boolean useLinkTextAsTitle;

    /* JADX INFO: compiled from: PrivacyStatementActivity.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0002\u0014\u0015B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0013\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00100\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/obric/oui/window/permission/PrivacyStatementActivity$Companion;", "", "()V", "EXTRA__KEY_ACTIVITY_INSTANCE_ID", "", "TAG", "activityCustomizers", "", "Lcom/obric/oui/window/permission/PrivacyStatementActivity$Companion$ActivityCustomizer;", "counter", "", "linkClickListeners", "Lcom/obric/oui/window/permission/PrivacyStatementActivity$LinkClickListener;", "privacyConsentCallbacks", "Lcom/obric/oui/window/permission/PrivacyStatementActivity$PrivacyConsentCallback;", "privacyItems", "", "Lcom/obric/oui/privacy/PrivacyItem;", "privacyPolicyLinkTextsList", "activityInstanceId", "ActivityCustomizer", "Builder", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {

        /* JADX INFO: compiled from: PrivacyStatementActivity.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\u0011"}, d2 = {"Lcom/obric/oui/window/permission/PrivacyStatementActivity$Companion$ActivityCustomizer;", "", "()V", "modifyStartIntent", "", "intent", "Landroid/content/Intent;", "onActivityCreate", "activity", "Landroid/app/Activity;", "onActivityDestroy", "onActivityFinish", "", "onActivityPause", "onActivityResume", "onActivityStart", "onActivityStop", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static abstract class ActivityCustomizer {
            public void modifyStartIntent(Intent r1) {
                Intrinsics.checkNotNullParameter(r1, "intent");
            }

            public void onActivityCreate(Activity r1) {
                Intrinsics.checkNotNullParameter(r1, "activity");
            }

            public void onActivityDestroy(Activity r1) {
                Intrinsics.checkNotNullParameter(r1, "activity");
            }

            public boolean onActivityFinish(Activity r1) {
                Intrinsics.checkNotNullParameter(r1, "activity");
                return false;
            }

            public void onActivityPause(Activity r1) {
                Intrinsics.checkNotNullParameter(r1, "activity");
            }

            public void onActivityResume(Activity r1) {
                Intrinsics.checkNotNullParameter(r1, "activity");
            }

            public void onActivityStart(Activity r1) {
                Intrinsics.checkNotNullParameter(r1, "activity");
            }

            public void onActivityStop(Activity r1) {
                Intrinsics.checkNotNullParameter(r1, "activity");
            }

            public ActivityCustomizer() {
            }
        }

        /* JADX INFO: compiled from: PrivacyStatementActivity.kt */
        @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u001c\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\"\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010#\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010$\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010%\u001a\u00020\u00002\u0006\u0010&\u001a\u00020\u0018J\u000e\u0010'\u001a\u00020\u00002\u0006\u0010(\u001a\u00020\u0006J\u000e\u0010)\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010*\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0006J\u000e\u0010+\u001a\u00020\u00002\u0006\u0010,\u001a\u00020\tJ\u000e\u0010-\u001a\u00020\u00002\u0006\u0010,\u001a\u00020\tJ\u000e\u0010.\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\tJ\u0010\u0010/\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0014\u00100\u001a\u00020\u00002\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013J\u000e\u00101\u001a\u00020\u00002\u0006\u00102\u001a\u00020\u0016J\u0014\u00103\u001a\u00020\u00002\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u00060\u0013J\u000e\u00105\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001bJ\u0019\u00106\u001a\u00020\u00002\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00060\u001f¢\u0006\u0002\u00107J\u000e\u00108\u001a\u00020\u00002\u0006\u00109\u001a\u00020\tJ\u000e\u0010:\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0006J\u0006\u0010;\u001a\u00020\u0000J\u0006\u00109\u001a\u00020<J\u001a\u00109\u001a\u00020<2\u0006\u0010=\u001a\u00020>2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010@J\u0012\u00109\u001a\u00020<2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010@R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00060\u001fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010 R\u000e\u0010!\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006A"}, d2 = {"Lcom/obric/oui/window/permission/PrivacyStatementActivity$Companion$Builder;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "agreeText", "", "cancelText", "cancelable", "", "customPackageName", "customizedCancelText", "description", "enableDim", "enableEnterAnim", "forceNightMode", "iconResId", "", "items", "", "Lcom/obric/oui/privacy/PrivacyItem;", "linkClickListener", "Lcom/obric/oui/window/permission/PrivacyStatementActivity$LinkClickListener;", "privacyConsentCallback", "Lcom/obric/oui/window/permission/PrivacyStatementActivity$PrivacyConsentCallback;", "privacyPolicyLinkTexts", "privacyText", "", "showNetworkConfirm", "title", "urls", "", "[Ljava/lang/String;", "useLinkTextAsTitle", "setAgreeText", "setCancelText", "setCancelable", "setConsentCallback", "callback", "setCustomPackageName", NotificationDisplayDetailsActivity.EXTRA_PACKAGE_NAME, "setCustomizedCancelText", "setDescription", "setEnableDim", "enable", "setEnableEnterAnim", "setForceNightMode", "setIconResId", "setItems", "setLinkClickListener", "listener", "setPrivacyPolicyLinkTexts", "linkTexts", "setPrivacyText", "setPrivacyUrls", "([Ljava/lang/String;)Lcom/obric/oui/window/permission/PrivacyStatementActivity$Companion$Builder;", "setShowNetworkConfirmDialog", "show", "setTitle", "setUseLinkTextAsTitle", "", "intent", "Landroid/content/Intent;", "activityCustomizer", "Lcom/obric/oui/window/permission/PrivacyStatementActivity$Companion$ActivityCustomizer;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Builder {
            private String agreeText;
            private String cancelText;
            private boolean cancelable;
            private final Context context;
            private String customPackageName;
            private String customizedCancelText;
            private String description;
            private boolean enableDim;
            private boolean enableEnterAnim;
            private boolean forceNightMode;
            private int iconResId;
            private List<? extends PrivacyItem> items;
            private LinkClickListener linkClickListener;
            private PrivacyConsentCallback privacyConsentCallback;
            private List<String> privacyPolicyLinkTexts;
            private CharSequence privacyText;
            private boolean showNetworkConfirm;
            private String title;
            private String[] urls;
            private boolean useLinkTextAsTitle;

            public Builder(Context r2) {
                Intrinsics.checkNotNullParameter(r2, "context");
                this.context = r2;
                String r3 = r2.getString(R.string.default_title);
                Intrinsics.checkNotNullExpressionValue(r3, "context.getString(R.string.default_title)");
                this.title = r3;
                this.privacyPolicyLinkTexts = CollectionsKt.emptyList();
                this.items = CollectionsKt.emptyList();
                this.iconResId = R.drawable.ic_default_icon;
                this.showNetworkConfirm = true;
                this.urls = new String[0];
                this.enableDim = true;
                this.cancelable = true;
            }

            public final Builder setForceNightMode(boolean r2) {
                this.forceNightMode = r2;
                return this;
            }

            public final Builder setTitle(String r2) {
                Intrinsics.checkNotNullParameter(r2, "title");
                this.title = r2;
                return this;
            }

            public final Builder setDescription(String r2) {
                Intrinsics.checkNotNullParameter(r2, "description");
                this.description = r2;
                return this;
            }

            public final Builder setCancelText(String r2) {
                Intrinsics.checkNotNullParameter(r2, "cancelText");
                this.cancelText = r2;
                return this;
            }

            public final Builder setAgreeText(String r2) {
                Intrinsics.checkNotNullParameter(r2, "agreeText");
                this.agreeText = r2;
                return this;
            }

            public final Builder setPrivacyText(CharSequence r2) {
                Intrinsics.checkNotNullParameter(r2, "privacyText");
                this.privacyText = r2;
                return this;
            }

            public final Builder setPrivacyPolicyLinkTexts(List<String> r2) {
                Intrinsics.checkNotNullParameter(r2, "linkTexts");
                this.privacyPolicyLinkTexts = r2;
                return this;
            }

            public final Builder setItems(List<? extends PrivacyItem> r2) {
                Intrinsics.checkNotNullParameter(r2, "items");
                this.items = r2;
                return this;
            }

            @Deprecated(message = "不支持应用自行设置")
            public final Builder setIconResId(int r2) {
                this.iconResId = r2;
                return this;
            }

            public final Builder setConsentCallback(PrivacyConsentCallback r2) {
                Intrinsics.checkNotNullParameter(r2, "callback");
                this.privacyConsentCallback = r2;
                return this;
            }

            public final Builder setCustomizedCancelText(String r2) {
                Intrinsics.checkNotNullParameter(r2, "cancelText");
                this.customizedCancelText = r2;
                return this;
            }

            public final Builder setPrivacyUrls(String[] r2) {
                Intrinsics.checkNotNullParameter(r2, "urls");
                this.urls = r2;
                return this;
            }

            public final Builder setLinkClickListener(LinkClickListener r2) {
                Intrinsics.checkNotNullParameter(r2, "listener");
                this.linkClickListener = r2;
                return this;
            }

            public final Builder setShowNetworkConfirmDialog(boolean r2) {
                this.showNetworkConfirm = r2;
                return this;
            }

            public final Builder setUseLinkTextAsTitle() {
                this.useLinkTextAsTitle = true;
                return this;
            }

            public final Builder setCustomPackageName(String r2) {
                Intrinsics.checkNotNullParameter(r2, NotificationDisplayDetailsActivity.EXTRA_PACKAGE_NAME);
                this.customPackageName = r2;
                return this;
            }

            public final Builder setEnableDim(boolean r2) {
                this.enableDim = r2;
                return this;
            }

            public final Builder setCancelable(boolean r2) {
                this.cancelable = r2;
                return this;
            }

            public final Builder setEnableEnterAnim(boolean r2) {
                this.enableEnterAnim = r2;
                return this;
            }

            public final void show() {
                show(null);
            }

            public static /* synthetic */ void show$default(Builder r0, Intent r1, ActivityCustomizer r2, int r3, Object r4) {
                if ((r3 & 2) == 0) goto L5;
                r2 = null;
            L5:
                r0.show(r1, r2);
            }

            public final void show(Intent r4, ActivityCustomizer r5) {
                Intrinsics.checkNotNullParameter(r4, "intent");
                L.d(PrivacyStatementActivity.TAG, "show with intent");
                r4.putExtra("title", this.title);
                r4.putExtra("description", this.description);
                r4.putExtra("cancelText", this.cancelText);
                r4.putExtra("agreeText", this.agreeText);
                r4.putExtra("privacyText", this.privacyText);
                r4.putExtra("iconResId", this.iconResId);
                r4.putExtra("urls", this.urls);
                r4.putExtra("showNetworkConfirm", this.showNetworkConfirm);
                r4.putExtra("useLinkTextAsTitle", this.useLinkTextAsTitle);
                r4.putExtra("customPackageName", this.customPackageName);
                r4.putExtra("forceNightMode", this.forceNightMode);
                r4.putExtra("enableDim", this.enableDim);
                r4.putExtra("cancelable", this.cancelable);
                r4.putExtra("enableEnterAnim", this.enableEnterAnim);
                String r0 = this.customizedCancelText;
                boolean r1 = false;
                if (r0 != null) goto L6;
            L11:
                if (r1 == false) goto L13;
                r4.putExtra("customizedCancelText", this.customizedCancelText);
            L13:
                String r2 = Companion.access$activityInstanceId(PrivacyStatementActivity.Companion);
                r4.putExtra(PrivacyStatementActivity.EXTRA__KEY_ACTIVITY_INSTANCE_ID, r2);
                if (r5 == null) goto L16;
                PrivacyStatementActivity.access$getActivityCustomizers$cp().put(r2, r5);
                r5.modifyStartIntent(r4);
            L16:
                PrivacyStatementActivity.access$getPrivacyItems$cp().put(r2, this.items);
                PrivacyStatementActivity.access$getPrivacyPolicyLinkTextsList$cp().put(r2, this.privacyPolicyLinkTexts);
                PrivacyStatementActivity.access$getPrivacyConsentCallbacks$cp().put(r2, this.privacyConsentCallback);
                PrivacyStatementActivity.access$getLinkClickListeners$cp().put(r2, this.linkClickListener);
                this.context.startActivity(r4);
                return;
            L6:
                if (r0.length() <= 0) goto L8;
                boolean r3 = true;
            L9:
                if (r3 != true) goto L11;
                r1 = true;
                goto L11
            L8:
                r3 = false;
                goto L9
            }

            public static /* synthetic */ void show$default(Builder r0, ActivityCustomizer r1, int r2, Object r3) {
                if ((r2 & 1) == 0) goto L5;
                r1 = null;
            L5:
                r0.show(r1);
            }

            public final void show(ActivityCustomizer r5) {
                L.d(PrivacyStatementActivity.TAG, "show");
                Intent r0 = new Intent(this.context, PrivacyStatementActivity.class);
                r0.putExtra("title", this.title);
                r0.putExtra("description", this.description);
                r0.putExtra("cancelText", this.cancelText);
                r0.putExtra("agreeText", this.agreeText);
                r0.putExtra("privacyText", this.privacyText);
                r0.putExtra("iconResId", this.iconResId);
                r0.putExtra("urls", this.urls);
                r0.putExtra("showNetworkConfirm", this.showNetworkConfirm);
                r0.putExtra("useLinkTextAsTitle", this.useLinkTextAsTitle);
                r0.putExtra("customPackageName", this.customPackageName);
                r0.putExtra("forceNightMode", this.forceNightMode);
                r0.putExtra("enableDim", this.enableDim);
                r0.putExtra("cancelable", this.cancelable);
                r0.putExtra("enableEnterAnim", this.enableEnterAnim);
                String r1 = this.customizedCancelText;
                boolean r2 = false;
                if (r1 != null) goto L6;
            L11:
                if (r2 == false) goto L13;
                r0.putExtra("customizedCancelText", this.customizedCancelText);
            L13:
                String r3 = Companion.access$activityInstanceId(PrivacyStatementActivity.Companion);
                r0.putExtra(PrivacyStatementActivity.EXTRA__KEY_ACTIVITY_INSTANCE_ID, r3);
                if (r5 == null) goto L16;
                PrivacyStatementActivity.access$getActivityCustomizers$cp().put(r3, r5);
                r5.modifyStartIntent(r0);
            L16:
                PrivacyStatementActivity.access$getPrivacyItems$cp().put(r3, this.items);
                PrivacyStatementActivity.access$getPrivacyPolicyLinkTextsList$cp().put(r3, this.privacyPolicyLinkTexts);
                PrivacyStatementActivity.access$getPrivacyConsentCallbacks$cp().put(r3, this.privacyConsentCallback);
                PrivacyStatementActivity.access$getLinkClickListeners$cp().put(r3, this.linkClickListener);
                this.context.startActivity(r0);
                return;
            L6:
                if (r1.length() <= 0) goto L8;
                boolean r4 = true;
            L9:
                if (r4 != true) goto L11;
                r2 = true;
                goto L11
            L8:
                r4 = false;
                goto L9
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public static final /* synthetic */ String access$activityInstanceId(Companion r0) {
            return r0.activityInstanceId();
        }

        private final String activityInstanceId() {
            StringBuilder r2 = new StringBuilder("PrivacyStatementActivity_").append(UUID.randomUUID()).append('_');
            int r0 = PrivacyStatementActivity.access$getCounter$cp();
            PrivacyStatementActivity.access$setCounter$cp(r0 + 1);
            return r2.append(r0).toString();
        }
    }

    /* JADX INFO: compiled from: PrivacyStatementActivity.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/obric/oui/window/permission/PrivacyStatementActivity$LinkClickListener;", "", "onLinkClick", "", "url", "", "context", "Landroid/content/Context;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface LinkClickListener {
        void onLinkClick(String r1, Context r2);
    }

    /* JADX INFO: compiled from: PrivacyStatementActivity.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H'J\u0010\u0010\u0002\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0003H'J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/obric/oui/window/permission/PrivacyStatementActivity$PrivacyConsentCallback;", "", "onAgree", "", "", "activity", "Landroid/app/Activity;", "onCancel", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface PrivacyConsentCallback {

        /* JADX INFO: compiled from: PrivacyStatementActivity.kt */
        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class DefaultImpls {
            public static boolean onAgree(PrivacyConsentCallback r1, Activity r2) {
                Intrinsics.checkNotNullParameter(r1, "this");
                Intrinsics.checkNotNullParameter(r2, "activity");
                return false;
            }

            public static boolean onCancel(PrivacyConsentCallback r1, Activity r2) {
                Intrinsics.checkNotNullParameter(r1, "this");
                Intrinsics.checkNotNullParameter(r2, "activity");
                return false;
            }
        }

        @Deprecated(message = "use onAgree(activity: Activity) instead")
        void onAgree();

        boolean onAgree(Activity r1);

        @Deprecated(message = "use onCancel(activity: Activity) instead")
        void onCancel();

        boolean onCancel(Activity r1);
    }

    /* JADX INFO: renamed from: com.obric.oui.window.permission.PrivacyStatementActivity$createSingleButton$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PrivacyStatementActivity.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Lcom/obric/oui/button/OButton;", "styledContext", "Landroid/content/Context;", MaterialConfigFormatNames.WIDTH, "", MonthWeekEventsView.VIEW_PARAMS_HEIGHT, "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class C03181 extends Lambda implements Function3<Context, Integer, Integer, OButton> {
        final /* synthetic */ Function1<View, Unit> $onClickListener;
        final /* synthetic */ String $text;

        public static /* synthetic */ void $r8$lambda$BU3hBO8pfy95Ebj72EeaFYz_o9c(Function1 r0, View r1) {
            m1460invoke$lambda1$lambda0(r0, r1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        C03181(String r1, Function1<? super View, Unit> r2) {
            this.$text = r1;
            this.$onClickListener = r2;
            super(3);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ OButton invoke(Context r1, Integer r2, Integer r3) {
            return invoke(r1, r2.intValue(), r3.intValue());
        }

        public final OButton invoke(Context r9, int r10, int r11) {
            Intrinsics.checkNotNullParameter(r9, "styledContext");
            OButton r12 = new OButton(r9, null, 0, 0, null, 28, null);
            String r13 = this.$text;
            final Function1<View, Unit> r8 = this.$onClickListener;
            r12.setText(r13);
            r12.setLayoutParams(new ViewGroup.LayoutParams(-1, r11));
            if (r8 != null) goto L5;
            View.OnClickListener r14 = null;
        L6:
            r12.setOnClickListener(r14);
            return r12;
        L5:
            r14 = new PrivacyStatementActivity$createSingleButton$1$$ExternalSyntheticLambda0(r8);
            goto L6
        }

        /* JADX INFO: renamed from: invoke$lambda-1$lambda-0, reason: not valid java name */
        private static final void m1460invoke$lambda1$lambda0(Function1 r0, View r1) {
            r0.invoke(r1);
        }
    }

    public static /* synthetic */ WindowInsetsCompat $r8$lambda$z7ZCz95iUUxU2cfFMTCvvZKMW2o(View r0, WindowInsetsCompat r1) {
        return m1459onContentChanged$lambda5$lambda4(r0, r1);
    }

    public boolean canFinishSelfInOnCreateIfCallbackNotSet() {
        return true;
    }

    public void com_obric_oui_window_permission_PrivacyStatementActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    public void onAgree() {
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_obric_oui_window_permission_PrivacyStatementActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    public void onDisagree() {
    }

    public void onPageDismiss() {
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        com_obric_oui_window_permission_PrivacyStatementActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        com_obric_oui_window_permission_PrivacyStatementActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        com_obric_oui_window_permission_PrivacyStatementActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_obric_oui_window_permission_PrivacyStatementActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public PrivacyStatementActivity() {
        this.showNetworkConfirm = true;
    }

    public static final /* synthetic */ void access$clearCallbacksAndFinish(PrivacyStatementActivity r0) {
        r0.clearCallbacksAndFinish();
    }

    public static final /* synthetic */ Map access$getActivityCustomizers$cp() {
        return activityCustomizers;
    }

    public static final /* synthetic */ int access$getCounter$cp() {
        return counter;
    }

    public static final /* synthetic */ boolean access$getFirstFrameReported$p(PrivacyStatementActivity r0) {
        return r0.firstFrameReported;
    }

    public static final /* synthetic */ boolean access$getHasAgreed$p(PrivacyStatementActivity r0) {
        return r0.hasAgreed;
    }

    public static final /* synthetic */ Map access$getLinkClickListeners$cp() {
        return linkClickListeners;
    }

    public static final /* synthetic */ Map access$getPrivacyConsentCallbacks$cp() {
        return privacyConsentCallbacks;
    }

    public static final /* synthetic */ Map access$getPrivacyItems$cp() {
        return privacyItems;
    }

    public static final /* synthetic */ Map access$getPrivacyPolicyLinkTextsList$cp() {
        return privacyPolicyLinkTextsList;
    }

    public static final /* synthetic */ OPrivacySheet access$getPrivacySheet$p(PrivacyStatementActivity r0) {
        return r0.privacySheet;
    }

    public static final /* synthetic */ boolean access$getShowNetworkConfirm$p(PrivacyStatementActivity r0) {
        return r0.showNetworkConfirm;
    }

    public static final /* synthetic */ void access$logPrivacySheetFirstFrame(PrivacyStatementActivity r0) {
        r0.logPrivacySheetFirstFrame();
    }

    public static final /* synthetic */ void access$openBrowser(PrivacyStatementActivity r0, String r1, String r2) {
        r0.openBrowser(r1, r2);
    }

    public static final /* synthetic */ void access$removeFirstFramePreDrawListener(PrivacyStatementActivity r0) {
        r0.removeFirstFramePreDrawListener();
    }

    public static final /* synthetic */ void access$setCounter$cp(int r0) {
        counter = r0;
    }

    public static final /* synthetic */ void access$setFirstFrameReported$p(PrivacyStatementActivity r0, boolean r1) {
        r0.firstFrameReported = r1;
    }

    public static final /* synthetic */ void access$setHasAgreed$p(PrivacyStatementActivity r0, boolean r1) {
        r0.hasAgreed = r1;
    }

    static {
        Companion = new Companion(null);
        privacyConsentCallbacks = new LinkedHashMap();
        linkClickListeners = new LinkedHashMap();
        activityCustomizers = new LinkedHashMap();
        privacyPolicyLinkTextsList = new LinkedHashMap();
        privacyItems = new LinkedHashMap();
    }

    public void com_obric_oui_window_permission_PrivacyStatementActivity__onCreate$___twin___(Bundle r10) {
        this.onCreateStartElapsedRealtime = SystemClock.elapsedRealtime();
        if (getDelegate().getLocalNightMode() != 2) goto L5;
        boolean r0 = true;
    L7:
        if ((getResources().getConfiguration().uiMode & 48) != 32) goto L9;
        boolean r4 = true;
    L10:
        L.d(TAG, Intrinsics.stringPlus("onCreate savedInstanceState: ", r10));
        L.d(TAG, Intrinsics.stringPlus("onCreate delegate.localNightMode: ", Integer.valueOf(getDelegate().getLocalNightMode())));
        L.d(TAG, Intrinsics.stringPlus("onCreate isLocalInNightMode: ", Boolean.valueOf(r0)));
        L.d(TAG, Intrinsics.stringPlus("onCreate isConfigNightMode: ", Boolean.valueOf(r4)));
        boolean r1 = getIntent().getBooleanExtra("forceNightMode", false);
        L.d(TAG, Intrinsics.stringPlus("onCreate forceNightMode: ", Boolean.valueOf(r1)));
        if (r4 == true) goto L14;
        if (r1 == false) goto L14;
        boolean r5 = true;
    L15:
        if (r10 != null) goto L18;
        if (r1 == false) goto L18;
        getIntent().putExtra("forceNightMode", false);
        getDelegate().setLocalNightMode(2);
    L18:
        super.onCreate(r10);
        if (r10 != null) goto L21;
    L24:
        getWindow().setWindowAnimations(0);
        overridePendingTransition(0, 0);
        String r3 = getIntent().getStringExtra(EXTRA__KEY_ACTIVITY_INSTANCE_ID);
        if (r3 == null) goto L32;
        Companion.ActivityCustomizer r6 = activityCustomizers.get(r3);
        if (r6 == null) goto L32;
        r6.onActivityCreate(this);
    L32:
        if (canFinishSelfInOnCreateIfCallbackNotSet() == false) goto L39;
        if (r10 == null) goto L39;
        L.w(TAG, "onCreate, savedInstanceState is not null");
        if (privacyConsentCallbacks.get(getIntent().getStringExtra(EXTRA__KEY_ACTIVITY_INSTANCE_ID)) != null) goto L38;
        L.w(TAG, "privacyConsentCallbacks is null, finish");
        finish();
        return;
    L38:
        L.i(TAG, "privacyConsentCallbacks is not null");
    L39:
        Window r11 = getWindow();
        r11.clearFlags(1024);
        r11.setBackgroundDrawableResource(android.R.color.transparent);
        r11.getAttributes().format = -2;
        this.showNetworkConfirm = getIntent().getBooleanExtra("showNetworkConfirm", true);
        this.useLinkTextAsTitle = getIntent().getBooleanExtra("useLinkTextAsTitle", false);
        this.root = r11.getDecorView().getRootView();
        if (r5 == true) goto L43;
        Intent r12 = getIntent();
        Intrinsics.checkNotNullExpressionValue(r12, "intent");
        showSheetDialog(r12);
        getIntent().putExtra("finishShowSheet", true);
        return;
    L43:
        return;
    L21:
        if (getIntent().getBooleanExtra("finishShowSheet", false) == false) goto L24;
        L.d(TAG, "onCreate -> finish when savedInstanceState is not null and finishShowSheet is true");
        finish();
        return;
    L14:
        r5 = false;
        goto L15
    L9:
        r4 = false;
        goto L10
    L5:
        r0 = false;
        goto L7
    }

    public final void showSheetDialog(Intent r24) {
        Intrinsics.checkNotNullParameter(r24, "intent");
        String r1 = r24.getStringExtra("title");
        if (r1 != null) goto L5;
        r1 = getString(R.string.default_title);
    L5:
        final String r6 = r1;
        Intrinsics.checkNotNullExpressionValue(r6, "intent.getStringExtra(\"t…g(R.string.default_title)");
        String r11 = r24.getStringExtra("description");
        String r16 = r24.getStringExtra("cancelText");
        String r15 = r24.getStringExtra("agreeText");
        CharSequence r2 = r24.getCharSequenceExtra("privacyText");
        String[] r3 = r24.getStringArrayExtra("urls");
        if (r3 != null) goto L8;
        r3 = new String[0];
    L8:
        final String[] r4 = r3;
        boolean r17 = r24.getBooleanExtra("enableDim", true);
        boolean r18 = r24.getBooleanExtra("cancelable", true);
        boolean r19 = r24.getBooleanExtra("enableEnterAnim", false);
        final PrivacyConsentCallback r5 = privacyConsentCallbacks.get(r24.getStringExtra(EXTRA__KEY_ACTIVITY_INSTANCE_ID));
        List<PrivacyItem> r7 = privacyItems.get(r24.getStringExtra(EXTRA__KEY_ACTIVITY_INSTANCE_ID));
        final List<String> r20 = privacyPolicyLinkTextsList.get(r24.getStringExtra(EXTRA__KEY_ACTIVITY_INSTANCE_ID));
        final LinkClickListener r21 = linkClickListeners.get(r24.getStringExtra(EXTRA__KEY_ACTIVITY_INSTANCE_ID));
        String r9 = getAppPackageName();
        if (r7 != null) goto L11;
        List<PrivacyItem> r12 = CollectionsKt.emptyList();
    L12:
        View r22 = null;
        if (r2 != null) goto L15;
        String r13 = null;
    L16:
        if (r20 != null) goto L18;
        List<String> r14 = CollectionsKt.emptyList();
    L19:
        OPrivacySheet r0 = new OPrivacySheet(this, new OPrivacySheetConfig(r9, r6, r11, r12, r13, r14, r15, r16, r17, r18, r19)).setListener(new C03191(r5, this, r20, r4, r21, r6)).show();
        this.privacySheet = r0;
        if (r0 == null) goto L29;
        OSheet r8 = r0.getSheet();
        if (r8 == null) goto L29;
        Window r10 = r8.getWindow();
        if (r10 == null) goto L29;
        r22 = r10.getDecorView();
    L29:
        reportPrivacySheetFirstFrame(r22);
        return;
    L18:
        r14 = r20;
        goto L19
    L15:
        r13 = r2.toString();
        goto L16
    L11:
        r12 = r7;
        goto L12
    }

    private final void reportPrivacySheetFirstFrame(View r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (this.firstFrameReported == true) goto L9;
        removeFirstFramePreDrawListener();
        this.firstFrameTargetView = r2;
        PrivacyStatementActivity$reportPrivacySheetFirstFrame$listener$1 r0 = new PrivacyStatementActivity$reportPrivacySheetFirstFrame$listener$1(this, r2);
        this.firstFramePreDrawListener = r0;
        r2.getViewTreeObserver().addOnPreDrawListener(r0);
        return;
    }

    private final void removeFirstFramePreDrawListener() {
        ViewTreeObserver.OnPreDrawListener r0 = this.firstFramePreDrawListener;
        if (r0 != null) goto L5;
        return;
    L5:
        View r1 = this.firstFrameTargetView;
        if (r1 == null) goto L14;
        ViewTreeObserver r2 = r1.getViewTreeObserver();
        if (r2 == null) goto L14;
        if (r2.isAlive() == false) goto L14;
        r2.removeOnPreDrawListener(r0);
    L14:
        this.firstFrameTargetView = null;
        this.firstFramePreDrawListener = null;
    }

    private final void logPrivacySheetFirstFrame() {
        long r0 = SystemClock.elapsedRealtime();
        long r2 = r0 - this.onCreateStartElapsedRealtime;
        long r4 = Process.getStartElapsedRealtime();
        StringBuilder r9 = new StringBuilder("PrivacyStatementActivity first frame, processStartToPrivacyFirstFrameMs=");
        Log.i(TAG, r9.append(r0 - r4).append(", activityCreateToFirstFrameMs=").append(r2).append(", processStartElapsedRealtime=").append(r4).append(", firstFrameElapsedRealtime=").append(r0).toString());
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        super.onContentChanged();
        this.contentChild = ((ViewGroup) findViewById(android.R.id.content)).getChildAt(0);
        if (isEdgeToEdge() == false) goto L9;
        View r2 = this.contentChild;
        if (r2 == null) goto L10;
        ViewCompat.setOnApplyWindowInsetsListener(r2, new PrivacyStatementActivity$$ExternalSyntheticLambda0());
        return;
    L10:
        return;
    }

    /* JADX INFO: renamed from: onContentChanged$lambda-5$lambda-4, reason: not valid java name */
    private static final WindowInsetsCompat m1459onContentChanged$lambda5$lambda4(View r4, WindowInsetsCompat r5) {
        int r0 = r5.getSystemWindowInsetTop();
        r5.getSystemWindowInsetBottom();
        Intrinsics.checkNotNullExpressionValue(r4, "v");
        r4.setPadding(r4.getPaddingLeft(), r0, r4.getPaddingRight(), 0);
        return r5;
    }

    private final boolean isEdgeToEdge() {
        View r1 = getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(r1, "window.decorView");
        return !r1.getFitsSystemWindows();
    }

    private final SpannableString processMessage(CharSequence r12, String[] r13, Context r14) {
        String r0 = r12.toString();
        String r7 = r0;
        int r8 = StringsKt.indexOf$default(r7, VectorFormat.DEFAULT_PREFIX, 0, false, 6, null);
        int r9 = StringsKt.indexOf$default(r7, VectorFormat.DEFAULT_SUFFIX, 0, false, 6, null);
        int r10 = StringsKt.lastIndexOf$default(r7, VectorFormat.DEFAULT_PREFIX, 0, false, 6, null);
        int r1 = StringsKt.lastIndexOf$default(r7, VectorFormat.DEFAULT_SUFFIX, 0, false, 6, null);
        if (this.useLinkTextAsTitle == false) goto L8;
        if (r8 == (-1)) goto L8;
        if (r9 == (-1)) goto L8;
        if (r8 >= r9) goto L8;
        String r2 = r0.substring(r8 + 1, r9);
        Intrinsics.checkNotNullExpressionValue(r2, "this as java.lang.String…ing(startIndex, endIndex)");
    L10:
        if (this.useLinkTextAsTitle == false) goto L15;
        if (r10 == (-1)) goto L15;
        if (r1 == (-1)) goto L15;
        if (r10 >= r1) goto L15;
        String r5 = r0.substring(r10 + 1, r1);
        Intrinsics.checkNotNullExpressionValue(r5, "this as java.lang.String…ing(startIndex, endIndex)");
    L16:
        ClickableSpan r3 = createClickableSpan(r14, (String) ArraysKt.getOrNull(r13, 0), r2);
        ClickableSpan r15 = createClickableSpan(r14, (String) ArraysKt.getOrNull(r13, 1), r5);
        SpannableStringBuilder r16 = new SpannableStringBuilder(r12);
        if (r8 == (-1)) goto L38;
        if (r9 == (-1)) goto L38;
        if (r10 == (-1)) goto L38;
        if (r1 == (-1)) goto L38;
        if (r8 != r10) goto L30;
        if (r9 != r1) goto L30;
        if (removeBracePair(r16, r8, r9) == true) goto L28;
        L.w(TAG, "processMessage single marker invalid, start=" + r8 + ", end=" + r9 + ", length=" + r16.length());
        return new SpannableString(r12);
    L28:
        applyClickableSpan(r16, r3, r8, r9 - 1);
    L40:
        return new SpannableString(r16);
    L30:
        if (removeBracePair(r16, r10, r1) == true) goto L34;
        L.w(TAG, "processMessage user marker invalid, start=" + r10 + ", end=" + r1 + ", length=" + r16.length());
        return new SpannableString(r12);
    L34:
        if (removeBracePair(r16, r8, r9) == true) goto L37;
        L.w(TAG, "processMessage privacy marker invalid, start=" + r8 + ", end=" + r9 + ", length=" + r16.length());
        return new SpannableString(r12);
    L37:
        applyClickableSpan(r16, r3, r8, r9 - 1);
        applyClickableSpan(r16, r15, r10 - 2, r1 - 3);
    L38:
        L.w(TAG, Intrinsics.stringPlus("processMessage marker not find, text=", r0));
    L15:
        r5 = getString(R.string.title_user_agreement);
        Intrinsics.checkNotNullExpressionValue(r5, "{\n                getStr…_agreement)\n            }");
    L8:
        r2 = getString(R.string.title_privacy_policy);
        Intrinsics.checkNotNullExpressionValue(r2, "{\n                getStr…acy_policy)\n            }");
        goto L10
    }

    private final ClickableSpan createClickableSpan(final Context r2, final String r3, final String r4) {
        return new AnonymousClass1(this, r3, r4, r2);
    }

    private final void applyClickableSpan(SpannableStringBuilder r1, ClickableSpan r2, int r3, int r4) {
        r1.setSpan(r2, r3, r4, 33);
    }

    private final boolean removeBracePair(SpannableStringBuilder r1, int r2, int r3) {
        if (r2 < 0) goto L10;
        if (r3 < 0) goto L12;
        if (r2 < r3) goto L6;
        return false;
    L6:
        if (r3 >= r1.length()) goto L14;
        r1.delete(r3, r3 + 1);
        r1.delete(r2, r2 + 1);
        return true;
    L14:
        return false;
    L12:
        return false;
    L10:
        return false;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        PrivacyConsentCallback r0 = privacyConsentCallbacks.get(getIntent().getStringExtra(EXTRA__KEY_ACTIVITY_INSTANCE_ID));
        boolean r1 = false;
        if (r0 != null) goto L6;
    L8:
        if (r1 == true) goto L14;
        if (r0 == null) goto L12;
        r0.onCancel();
    L12:
        onDisagree();
        return;
    L14:
        return;
    L6:
        if (r0.onCancel(this) != true) goto L8;
        r1 = true;
        goto L8
    }

    private final void openBrowser(String r1, String r2) {
        WebViewActivity.open(this, r1, r2);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        String r0 = getIntent().getStringExtra(EXTRA__KEY_ACTIVITY_INSTANCE_ID);
        if (r0 == null) goto L10;
        Companion.ActivityCustomizer r1 = activityCustomizers.get(r0);
        if (r1 == null) goto L11;
        r1.onActivityStart(this);
        return;
    L11:
        return;
    }

    public void com_obric_oui_window_permission_PrivacyStatementActivity__onResume$___twin___() {
        super.onResume();
        String r0 = getIntent().getStringExtra(EXTRA__KEY_ACTIVITY_INSTANCE_ID);
        if (r0 == null) goto L10;
        Companion.ActivityCustomizer r1 = activityCustomizers.get(r0);
        if (r1 == null) goto L11;
        r1.onActivityResume(this);
        return;
    L11:
        return;
    }

    public void com_obric_oui_window_permission_PrivacyStatementActivity__onPause$___twin___() {
        super.onPause();
        String r0 = getIntent().getStringExtra(EXTRA__KEY_ACTIVITY_INSTANCE_ID);
        if (r0 == null) goto L10;
        Companion.ActivityCustomizer r1 = activityCustomizers.get(r0);
        if (r1 == null) goto L11;
        r1.onActivityPause(this);
        return;
    L11:
        return;
    }

    public void com_obric_oui_window_permission_PrivacyStatementActivity__onStop$___twin___() {
        super.onStop();
        String r0 = getIntent().getStringExtra(EXTRA__KEY_ACTIVITY_INSTANCE_ID);
        if (r0 == null) goto L10;
        Companion.ActivityCustomizer r1 = activityCustomizers.get(r0);
        if (r1 == null) goto L11;
        r1.onActivityStop(this);
        return;
    L11:
        return;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        L.d(TAG, "onDestroy");
        removeFirstFramePreDrawListener();
        View r0 = this.root;
        if (r0 != null) goto L27;
    L8:
        View r1 = this.contentChild;
        if (r1 != null) goto L29;
    L14:
        OPrivacySheet r2 = this.privacySheet;
        if (r2 == null) goto L18;
        r2.dismissImmediately();
    L18:
        this.root = null;
        this.contentChild = null;
        this.privacySheet = null;
        super.onDestroy();
        String r3 = getIntent().getStringExtra(EXTRA__KEY_ACTIVITY_INSTANCE_ID);
        if (r3 == null) goto L31;
        Map<String, Companion.ActivityCustomizer> r4 = activityCustomizers;
        Companion.ActivityCustomizer r5 = r4.get(r3);
        if (r5 == null) goto L25;
        r5.onActivityDestroy(this);
    L25:
        Companion.ActivityCustomizer r6 = r4.remove(r3);
        return;
    L31:
        return;
    L29:
        ViewCompat.setOnApplyWindowInsetsListener(r1, null);     // Catch: Exception -> L13
    L13:
        L.e(TAG, "removing contentChild WindowInsets listener failed");
        goto L14
    L27:
        r0.setOnApplyWindowInsetsListener(null);     // Catch: Exception -> L7
    L7:
        L.e(TAG, "removing root WindowInsets listener failed");
        goto L8
    }

    private final void clearCallbacksAndFinish() {
        String r0 = getIntent().getStringExtra(EXTRA__KEY_ACTIVITY_INSTANCE_ID);
        if (r0 == null) goto L6;
        privacyConsentCallbacks.remove(r0);
        linkClickListeners.remove(r0);
        privacyPolicyLinkTextsList.remove(r0);
        List<PrivacyItem> r1 = privacyItems.remove(r0);
    L6:
        finish();
    }

    private final View createHeaderView(Context r2) {
        View r1 = LayoutInflater.from(r2).inflate(R.layout.layout_privacy_statement_header, null);
        Intrinsics.checkNotNullExpressionValue(r1, "headerView");
        return r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ View createSingleButton$default(PrivacyStatementActivity r0, Context r1, String r2, int r3, Function1 r4, int r5, Object r6) {
        if (r6 != null) goto L9;
        if ((r5 & 8) == 0) goto L7;
        r4 = null;
    L7:
        return r0.createSingleButton(r1, r2, r3, r4);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createSingleButton");
    }

    private final View createSingleButton(Context r1, String r2, int r3, Function1<? super View, Unit> r4) {
        return StyleUtil.createWidgetWithStyle(r1, r3, new C03181(r2, r4));
    }

    private final String getAppPackageName() {
        String r0 = getIntent().getStringExtra("customPackageName");
        String r1 = r0;
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        String r3 = getPackageName();
        Intrinsics.checkNotNullExpressionValue(r3, "{\n            packageName\n        }");
        return r3;
    L11:
        L.w(TAG, Intrinsics.stringPlus("using custom packageName: ", r0));
        return r0;
    L5:
        if (r1.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    public static /* synthetic */ void setSmartJustification$default(PrivacyStatementActivity r0, TextView r1, boolean r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 1) == 0) goto L6;
        r2 = false;
    L6:
        r0.setSmartJustification(r1, r2);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setSmartJustification");
    }

    public final void setSmartJustification(TextView r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (r3 == true) goto L8;
        Locale r4 = r2.getTextLocale();
        Intrinsics.checkNotNullExpressionValue(r4, "this.textLocale");
        if (shouldApplyJustification(r4) == true) goto L8;
        r2.setJustificationMode(0);
        return;
    L8:
        r2.setJustificationMode(1);
    }

    private final boolean shouldApplyJustification(Locale r1) {
        return !Intrinsics.areEqual(r1.getLanguage(), Locale.ENGLISH.getLanguage());
    }

    public final void setSystemInsetsAppearance(boolean r5) {
        OPrivacySheet r4 = this.privacySheet;
        Window r0 = null;
        if (r4 == null) goto L9;
        OSheet r6 = r4.getSheet();
        if (r6 == null) goto L9;
        r0 = r6.getWindow();
    L9:
        int r7 = 0;
        if (r0 == null) goto L20;
        WindowInsetsController r1 = r0.getInsetsController();
        if (r1 == null) goto L20;
        if (r5 == false) goto L18;
        int r3 = 8;
    L19:
        r1.setSystemBarsAppearance(r3, 8);
        goto L20
    L18:
        r3 = 0;
    L20:
        if (r0 == null) goto L30;
        WindowInsetsController r2 = r0.getInsetsController();
        if (r2 != null) goto L26;
        return;
    L26:
        if (r5 == false) goto L28;
        r7 = 16;
    L28:
        r2.setSystemBarsAppearance(r7, 16);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_obric_oui_window_permission_PrivacyStatementActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(PrivacyStatementActivity r1) {
        r1.com_obric_oui_window_permission_PrivacyStatementActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_obric_oui_window_permission_PrivacyStatementActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(PrivacyStatementActivity r1) {
        String r0 = r1.getClass().getName();
        com_obric_oui_window_permission_PrivacyStatementActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_obric_oui_window_permission_PrivacyStatementActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(PrivacyStatementActivity r4) {
        String r0 = r4.getClass().getName();
        r4.com_obric_oui_window_permission_PrivacyStatementActivity__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        PrivacyStatementActivity r5 = r4;
        String r2 = r5.getCallingPackage();
        if (r2 != null) goto L9;
        OLog.e("BaseActivity", "isDeviceSetupComplete callingPkg is null, try getReferrer");
        Uri r6 = r5.getReferrer();
        if (r6 == null) goto L9;
        r2 = r6.toString();
    L9:
        OLog.i("TeaEventReportUtil", "callingPkg=" + r2);
        if (r2 != null) goto L12;
        r2 = "null";
    L12:
        AppMetricsUtils.INSTANCE.reportColdStartActivity(r2, r0);
    L13:
        AppMetricsUtils.INSTANCE.setColdStartTime(0);
    }

    @Insert(mayCreateSuper = true, value = "startActivityForResult")
    public static void com_obric_oui_window_permission_PrivacyStatementActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(PrivacyStatementActivity r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_obric_oui_window_permission_PrivacyStatementActivity__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_obric_oui_window_permission_PrivacyStatementActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(PrivacyStatementActivity r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_obric_oui_window_permission_PrivacyStatementActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_obric_oui_window_permission_PrivacyStatementActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(PrivacyStatementActivity r4) {
        String r0 = r4.getClass().getName();
        r4.com_obric_oui_window_permission_PrivacyStatementActivity__onPause$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_obric_oui_window_permission_PrivacyStatementActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(PrivacyStatementActivity r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        r3.com_obric_oui_window_permission_PrivacyStatementActivity__onCreate$___twin___(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        PrivacyStatementActivity r5 = r3;
        String r6 = r5.getCallingPackage();
        if (r6 != null) goto L9;
        OLog.e("AppLifecycle", "isDeviceSetupComplete callingPkg is null, try getReferrer");
        Uri r7 = r5.getReferrer();
        if (r7 == null) goto L9;
        r6 = r7.toString();
    L9:
        OLog.i("AppLifecycle", "TeaEventReportUtil callingPkg=" + r6);
        if (r6 != null) goto L12;
        r6 = "null";
    L12:
        AppMetricsUtils r8 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r8.callingPackageEvent(r6, r0, false);
        return;
    }
}
