package com.android.settings.about;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.LocaleList;
import android.telephony.TelephonyManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.FragmentActivity;
import com.android.settings.Constants;
import com.android.settings.GuaranteeHelp;
import com.android.settings.NotificationDisplayDetailsActivity;
import com.android.settings.R;
import com.android.settings.SettingsFeature;
import com.android.settings.ToastUtils;
import com.android.settings.Utils;
import com.android.settings.base.BaseFragment;
import com.android.settings.databinding.GuaranteeLayoutBinding;
import com.android.settings.deviceinfo.DeviceInfoProvider;
import com.android.settings.ext.ViewExtKt;
import com.android.settings.service.bean.DeviceInfo;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.HanziToPinyin;
import com.android.settings.utils.ResourceUtils;
import com.android.settings.utils.UIUtils;
import com.bumptech.glide.Glide;
import com.bytedance.android.standard.tools.date.DateUtils;
import com.bytedance.keva.Keva;
import com.google.gson.Gson;
import com.obric.olog.OLog;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.progress.ODownloadProgressView;
import com.obric.oui.sectiontitlebar.OSectionSupportiveText;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.GrantUtil;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.common.security.attestation.PrivacySDKUtils;

/* JADX INFO: compiled from: GuaranteeFragment.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u0000 R2\u00020\u0001:\u0001RB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u00101\u001a\u0004\u0018\u0001022\u0006\u00103\u001a\u000204H\u0002J\b\u00105\u001a\u00020\u000bH\u0002J\u0018\u00106\u001a\u0002072\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u000bH\u0002J\u0010\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u000bH\u0002J\u0010\u0010>\u001a\u0002072\u0006\u0010?\u001a\u00020\u000bH\u0002J$\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020C2\b\u0010D\u001a\u0004\u0018\u00010E2\b\u0010F\u001a\u0004\u0018\u00010GH\u0016J\u001a\u0010H\u001a\u0002072\u0006\u0010I\u001a\u00020A2\b\u0010F\u001a\u0004\u0018\u00010GH\u0016J\u0010\u0010J\u001a\u0002072\u0006\u0010=\u001a\u00020\u000bH\u0002J\u0010\u0010K\u001a\u0002072\u0006\u0010?\u001a\u00020\u000bH\u0002J\u0018\u0010L\u001a\u0004\u0018\u0001092\u0006\u0010:\u001a\u00020\u000bH\u0082@¢\u0006\u0002\u0010MJ\u000e\u0010N\u001a\u0002072\u0006\u0010O\u001a\u00020<J\f\u0010P\u001a\u00020\u000b*\u00020QH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000R\u001f\u0010\f\u001a\u00020\r*\u00020\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001f\u0010\u0012\u001a\u00020\r*\u00020\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0013\u0010\u000fR\u001f\u0010\u0015\u001a\u00020\r*\u00020\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0016\u0010\u000fR\u001f\u0010\u0018\u001a\u00020\r*\u00020\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0011\u001a\u0004\b\u0019\u0010\u000fR\u001f\u0010\u001b\u001a\u00020\r*\u00020\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0011\u001a\u0004\b\u001c\u0010\u000fR\u001f\u0010\u001e\u001a\u00020\r*\u00020\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0011\u001a\u0004\b\u001f\u0010\u000fR\u001f\u0010!\u001a\u00020\r*\u00020\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u0011\u001a\u0004\b\"\u0010\u000fR\u001f\u0010$\u001a\u00020%*\u00020\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\u0011\u001a\u0004\b&\u0010'R\u001f\u0010)\u001a\u00020**\u00020\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\u0011\u001a\u0004\b+\u0010,R\u001f\u0010.\u001a\u00020\r*\u00020\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b0\u0010\u0011\u001a\u0004\b/\u0010\u000f¨\u0006S"}, d2 = {"Lcom/android/settings/about/GuaranteeFragment;", "Lcom/android/settings/base/BaseFragment;", "()V", "gson", "Lcom/google/gson/Gson;", "keva", "Lcom/bytedance/keva/Keva;", "kotlin.jvm.PlatformType", "viewBind", "Lcom/android/settings/databinding/GuaranteeLayoutBinding;", "weixinPackageName", "", "card", "Lcom/obric/oui/text/OTextView;", "getCard", "(Lcom/android/settings/databinding/GuaranteeLayoutBinding;)Lcom/obric/oui/text/OTextView;", "card$delegate", "Lkotlin/Lazy;", "deviceName", "getDeviceName", "deviceName$delegate", "errorText", "getErrorText", "errorText$delegate", "expiredDate", "getExpiredDate", "expiredDate$delegate", "expiredDateTitle", "getExpiredDateTitle", "expiredDateTitle$delegate", "imeiTitle", "getImeiTitle", "imeiTitle$delegate", "imeiTv", "getImeiTv", "imeiTv$delegate", "loadingProgress", "Lcom/obric/oui/progress/ODownloadProgressView;", "getLoadingProgress", "(Lcom/android/settings/databinding/GuaranteeLayoutBinding;)Lcom/obric/oui/progress/ODownloadProgressView;", "loadingProgress$delegate", "mainBg", "Lcom/obric/oui/layout/OUIFrameLayout;", "getMainBg", "(Lcom/android/settings/databinding/GuaranteeLayoutBinding;)Lcom/obric/oui/layout/OUIFrameLayout;", "mainBg$delegate", "stateTv", "getStateTv", "stateTv$delegate", "getDrawable", "Landroid/graphics/drawable/Drawable;", "id", "", "getLanguage", "initView", "", "deviceInfo", "Lcom/android/settings/service/bean/DeviceInfo;", DeviceInfoProvider.IMEI, "isAppInstalled", "", NotificationDisplayDetailsActivity.EXTRA_PACKAGE_NAME, "loadUrl", "url", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "openMarketUrl", "openUrl", "requestDeviceInfo", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showOrHideWarrantyCard", "isShowCard", "formatDate", "", "Companion", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class GuaranteeFragment extends BaseFragment {
    public static final Companion Companion = null;
    private static final String KEY_DEVICE_INFO = "key_device_info";
    private static final String KEY_LANGUAGE = "key_language";
    private static final String REPO_NAME = "settings_guarantee";
    private static DeviceInfo deviceInfo;
    private static long lastRequestTime;
    private static String preLanguage;
    private final Lazy card$delegate;
    private final Lazy deviceName$delegate;
    private final Lazy errorText$delegate;
    private final Lazy expiredDate$delegate;
    private final Lazy expiredDateTitle$delegate;
    private final Gson gson;
    private final Lazy imeiTitle$delegate;
    private final Lazy imeiTv$delegate;
    private final Keva keva;
    private final Lazy loadingProgress$delegate;
    private final Lazy mainBg$delegate;
    private final Lazy stateTv$delegate;
    private GuaranteeLayoutBinding viewBind;
    private final String weixinPackageName;

    /* JADX INFO: compiled from: GuaranteeFragment.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/android/settings/about/GuaranteeFragment$Companion;", "", "()V", "KEY_DEVICE_INFO", "", "KEY_LANGUAGE", "REPO_NAME", "deviceInfo", "Lcom/android/settings/service/bean/DeviceInfo;", "lastRequestTime", "", "preLanguage", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.android.settings.about.GuaranteeFragment$onViewCreated$2, reason: invalid class name */
    /* JADX INFO: compiled from: GuaranteeFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.android.settings.about.GuaranteeFragment$onViewCreated$2", f = "GuaranteeFragment.kt", i = {0}, l = {120, 121}, m = "invokeSuspend", n = {"cacheDeviceInfo"}, s = {"L$0"})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $imei;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ GuaranteeFragment this$0;

        /* JADX INFO: renamed from: com.android.settings.about.GuaranteeFragment$onViewCreated$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: GuaranteeFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.android.settings.about.GuaranteeFragment$onViewCreated$2$1", f = "GuaranteeFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ DeviceInfo $cacheDeviceInfo;
            final /* synthetic */ DeviceInfo $deviceInfo;
            final /* synthetic */ String $imei;
            int label;
            final /* synthetic */ GuaranteeFragment this$0;

            AnonymousClass1(GuaranteeFragment r1, DeviceInfo r2, String r3, DeviceInfo r4, Continuation<? super AnonymousClass1> r5) {
                this.this$0 = r1;
                this.$deviceInfo = r2;
                this.$imei = r3;
                this.$cacheDeviceInfo = r4;
                super(2, r5);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
                return new AnonymousClass1(this.this$0, this.$deviceInfo, this.$imei, this.$cacheDeviceInfo, r8);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return invoke2(r1, r2);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(CoroutineScope r1, Continuation<? super Unit> r2) {
                return ((AnonymousClass1) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r6) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L59;
                ResultKt.throwOnFailure(r6);
                FragmentActivity r7 = this.this$0.getActivity();
                if (r7 == null) goto L9;
                boolean r1 = true;
                if (r7.isDestroyed() != true) goto L9;
            L10:
                if (r1 == true) goto L12;
                GuaranteeFragment r8 = this.this$0;
                GuaranteeLayoutBinding r2 = GuaranteeFragment.access$getViewBind$p(r8);
                GuaranteeLayoutBinding r3 = null;
                if (r2 != null) goto L16;
                Intrinsics.throwUninitializedPropertyAccessException("viewBind");
                r2 = null;
            L16:
                r8.getLoadingProgress(r2).setVisibility(8);
                if (this.$deviceInfo == null) goto L24;
                GuaranteeLayoutBinding r9 = GuaranteeFragment.access$getViewBind$p(this.this$0);
                if (r9 != null) goto L21;
                Intrinsics.throwUninitializedPropertyAccessException("viewBind");
            L22:
                r3.loadingCl.setVisibility(8);
                GuaranteeFragment.access$initView(this.this$0, this.$deviceInfo, this.$imei);
            L57:
                return Unit.INSTANCE;
            L21:
                r3 = r9;
                goto L22
            L24:
                if (this.$cacheDeviceInfo != null) goto L57;
                if (GuaranteeHelp.INSTANCE.isFistShowWarrantyCard() == true) goto L38;
                GuaranteeLayoutBinding r10 = GuaranteeFragment.access$getViewBind$p(this.this$0);
                if (r10 != null) goto L30;
                Intrinsics.throwUninitializedPropertyAccessException("viewBind");
                r10 = null;
            L30:
                r10.loadingProgressLarge.setVisibility(8);
                GuaranteeLayoutBinding r11 = GuaranteeFragment.access$getViewBind$p(this.this$0);
                if (r11 != null) goto L33;
                Intrinsics.throwUninitializedPropertyAccessException("viewBind");
                r11 = null;
            L33:
                r11.loadingText.setVisibility(8);
                GuaranteeLayoutBinding r5 = GuaranteeFragment.access$getViewBind$p(this.this$0);
                if (r5 != null) goto L36;
                Intrinsics.throwUninitializedPropertyAccessException("viewBind");
            L37:
                r3.networkErrorText.setVisibility(0);
                goto L57
            L36:
                r3 = r5;
                goto L37
            L38:
                GuaranteeFragment r12 = this.this$0;
                GuaranteeLayoutBinding r4 = GuaranteeFragment.access$getViewBind$p(r12);
                if (r4 != null) goto L41;
                Intrinsics.throwUninitializedPropertyAccessException("viewBind");
                r4 = null;
            L41:
                OTextView r13 = r12.getStateTv(r4);
                r13.setVisibility(0);
                r13.setText(ResourceUtils.getString(R.string.network_error_new));
                r13.setTextColor(ContextCompat.getColor(r13.getContext(), R.color.oui_dark_functional_orange_8));
                Context r14 = r13.getContext();
                if (r14 == null) goto L44;
                Drawable r15 = r14.getDrawable(R.drawable.expired_state_text_error_bg);
            L45:
                r13.setBackground(r15);
                GuaranteeFragment r16 = this.this$0;
                GuaranteeLayoutBinding r17 = GuaranteeFragment.access$getViewBind$p(r16);
                if (r17 != null) goto L48;
                Intrinsics.throwUninitializedPropertyAccessException("viewBind");
                r17 = null;
            L48:
                r16.getExpiredDateTitle(r17).setVisibility(0);
                GuaranteeFragment r18 = this.this$0;
                GuaranteeLayoutBinding r19 = GuaranteeFragment.access$getViewBind$p(r18);
                if (r19 != null) goto L51;
                Intrinsics.throwUninitializedPropertyAccessException("viewBind");
                r19 = null;
            L51:
                r18.getExpiredDate(r19).setText("--");
                GuaranteeFragment r20 = this.this$0;
                GuaranteeLayoutBinding r21 = GuaranteeFragment.access$getViewBind$p(r20);
                if (r21 != null) goto L54;
                Intrinsics.throwUninitializedPropertyAccessException("viewBind");
            L55:
                r20.getExpiredDate(r3).setVisibility(0);
                goto L57
            L54:
                r3 = r21;
                goto L55
            L44:
                r15 = null;
                goto L45
            L12:
                return Unit.INSTANCE;
            L9:
                r1 = false;
                goto L10
            L59:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        AnonymousClass2(GuaranteeFragment r1, String r2, Continuation<? super AnonymousClass2> r3) {
            this.this$0 = r1;
            this.$imei = r2;
            super(2, r3);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass2 r0 = new AnonymousClass2(this.this$0, this.$imei, r4);
            r0.L$0 = r3;
            return r0;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((AnonymousClass2) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r13) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L10;
            if (r2 == 1) goto L9;
            if (r2 != 2) goto L8;
            ResultKt.throwOnFailure(r13);
        L59:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            DeviceInfo r0 = (DeviceInfo) this.L$0;
            ResultKt.throwOnFailure(r13);
            DeviceInfo r10 = r0;
        L55:
            DeviceInfo r8 = (DeviceInfo) r13;
            this.L$0 = null;
            this.label = 2;
            if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1(this.this$0, r8, this.$imei, r10, null), this) != r1) goto L59;
            return r1;
        L10:
            ResultKt.throwOnFailure(r13);
            CoroutineScope r14 = (CoroutineScope) this.L$0;
            GuaranteeFragment r15 = this.this$0;
            Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L25
            String r7 = GuaranteeFragment.access$getKeva$p(r15).getString("key_device_info", "");     // Catch: Throwable -> L25
            if (r7 == null) goto L22;
            Intrinsics.checkNotNull(r7);     // Catch: Throwable -> L25
            if (r7.length() <= 0) goto L16;
            boolean r9 = true;
        L17:
            if (r9 == true) goto L20;
            r7 = null;
        L20:
            if (r7 == null) goto L22;
            DeviceInfo r16 = (DeviceInfo) GuaranteeFragment.access$getGson$p(r15).fromJson(r7, DeviceInfo.class);     // Catch: Throwable -> L25
        L23:
            Object r17 = Result.m1508constructorimpl(r16);     // Catch: Throwable -> L25
        L28:
            if (Result.m1514isFailureimpl(r17) == false) goto L30;
            r17 = null;
        L30:
            DeviceInfo r18 = (DeviceInfo) r17;
            String r3 = GuaranteeFragment.access$getKeva$p(this.this$0).getString(GuaranteeFragment.KEY_LANGUAGE, "");
            if (r18 == null) goto L36;
            if (Intrinsics.areEqual(r3, GuaranteeFragment.access$getLanguage(this.this$0)) == false) goto L36;
            GuaranteeFragment.access$initView(this.this$0, r18, this.$imei);
        L51:
            this.L$0 = r18;
            this.label = 1;
            Object r4 = GuaranteeFragment.access$requestDeviceInfo(this.this$0, this.$imei, this);
            if (r4 != r1) goto L54;
            return r1;
        L54:
            r10 = r18;
            r13 = r4;
        L36:
            if (GuaranteeHelp.INSTANCE.isFistShowWarrantyCard() == true) goto L41;
            this.this$0.showOrHideWarrantyCard(false);
            GuaranteeLayoutBinding r5 = GuaranteeFragment.access$getViewBind$p(this.this$0);
            if (r5 != null) goto L40;
            Intrinsics.throwUninitializedPropertyAccessException("viewBind");
            r5 = null;
        L40:
            r5.loadingCl.setVisibility(0);
            goto L51
        L41:
            GuaranteeFragment r11 = this.this$0;
            GuaranteeLayoutBinding r12 = GuaranteeFragment.access$getViewBind$p(r11);
            if (r12 != null) goto L44;
            Intrinsics.throwUninitializedPropertyAccessException("viewBind");
            r12 = null;
        L44:
            r11.getLoadingProgress(r12).setVisibility(0);
            GuaranteeFragment r19 = this.this$0;
            GuaranteeLayoutBinding r20 = GuaranteeFragment.access$getViewBind$p(r19);
            if (r20 != null) goto L47;
            Intrinsics.throwUninitializedPropertyAccessException("viewBind");
            r20 = null;
        L47:
            r19.getStateTv(r20).setVisibility(8);
            GuaranteeFragment r21 = this.this$0;
            GuaranteeLayoutBinding r22 = GuaranteeFragment.access$getViewBind$p(r21);
            if (r22 != null) goto L50;
            Intrinsics.throwUninitializedPropertyAccessException("viewBind");
            r22 = null;
        L50:
            r21.getExpiredDateTitle(r22).setVisibility(8);
            goto L51
        L16:
            r9 = false;
        L22:
            r16 = null;
        L25:
            th = move-exception;
            Result.Companion r23 = Result.Companion;
            r17 = Result.m1508constructorimpl(ResultKt.createFailure(th));
            goto L28
        }
    }

    /* JADX INFO: renamed from: com.android.settings.about.GuaranteeFragment$requestDeviceInfo$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: GuaranteeFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/android/settings/service/bean/DeviceInfo;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.android.settings.about.GuaranteeFragment$requestDeviceInfo$2", f = "GuaranteeFragment.kt", i = {0}, l = {443}, m = "invokeSuspend", n = {"osLanguage"}, s = {"L$0"})
    static final class C01422 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super DeviceInfo>, Object> {
        final /* synthetic */ String $imei;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ GuaranteeFragment this$0;

        C01422(GuaranteeFragment r1, String r2, Continuation<? super C01422> r3) {
            this.this$0 = r1;
            this.$imei = r2;
            super(2, r3);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            C01422 r0 = new C01422(this.this$0, this.$imei, r4);
            r0.L$0 = r3;
            return r0;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super DeviceInfo> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r1, Continuation<? super DeviceInfo> r2) {
            return ((C01422) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L12;
            if (r2 != 1) goto L11;
            GuaranteeFragment r3 = (GuaranteeFragment) this.L$1;
            String r4 = (String) this.L$0;
            ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L8
        L31:
            DeviceInfo r11 = (DeviceInfo) r10;     // Catch: Throwable -> L8
            OLog.d(GuaranteeFragment.access$getTAG$p(r3), "Request device info response " + r11);     // Catch: Throwable -> L8
            Companion r0 = GuaranteeFragment.Companion;     // Catch: Throwable -> L8
            GuaranteeFragment.access$setLastRequestTime$cp(System.currentTimeMillis());     // Catch: Throwable -> L8
            Companion r5 = GuaranteeFragment.Companion;     // Catch: Throwable -> L8
            GuaranteeFragment.access$setDeviceInfo$cp(r11);     // Catch: Throwable -> L8
            Companion r6 = GuaranteeFragment.Companion;     // Catch: Throwable -> L8
            GuaranteeFragment.access$setPreLanguage$cp(r4);     // Catch: Throwable -> L8
            if (r11 == null) goto L34;
            GuaranteeFragment.access$getKeva$p(r3).storeString("key_device_info", GuaranteeFragment.access$getGson$p(r3).toJson(r11));     // Catch: Throwable -> L8
            GuaranteeFragment.access$getKeva$p(r3).storeString(GuaranteeFragment.KEY_LANGUAGE, r4);     // Catch: Throwable -> L8
        L34:
            Object r12 = Result.m1508constructorimpl(r11);     // Catch: Throwable -> L8
        L37:
            GuaranteeFragment r9 = this.this$0;
            Throwable r7 = Result.m1511exceptionOrNullimpl(r12);
            if (r7 == null) goto L41;
            OLog.e(GuaranteeFragment.access$getTAG$p(r9), "Request device info failed", r7);
        L41:
            if (Result.m1514isFailureimpl(r12) == false) goto L46;
            return null;
        L46:
            return r12;
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L12:
            ResultKt.throwOnFailure(r10);
            CoroutineScope r13 = (CoroutineScope) this.L$0;
            r4 = GuaranteeFragment.access$getLanguage(this.this$0);
            DeviceInfo r14 = GuaranteeFragment.access$getDeviceInfo$cp();
            if (Math.abs(System.currentTimeMillis() - GuaranteeFragment.access$getLastRequestTime$cp()) >= TimeUnit.MINUTES.toMillis(30)) goto L19;
            if (r14 == null) goto L19;
            if (Intrinsics.areEqual(GuaranteeFragment.access$getPreLanguage$cp(), r4) == false) goto L19;
            OLog.i(GuaranteeFragment.access$getTAG$p(this.this$0), "Return cached device info " + r14);
            return r14;
        L19:
            String r15 = this.$imei;
            GuaranteeFragment r8 = this.this$0;
            Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L8
            String r17 = PrivacySDKUtils.Companion.getInstance().getIDAttestation(r15);     // Catch: Throwable -> L8
            if (r17 != null) goto L24;
            r17 = "";
        L24:
            if (SettingsFeature.isSupportNubiaShare() == false) goto L26;
            String r18 = "N1";
        L27:
            GuaranteeHelp r19 = GuaranteeHelp.INSTANCE;     // Catch: Throwable -> L8
            this.L$0 = r4;     // Catch: Throwable -> L8
            this.L$1 = r8;     // Catch: Throwable -> L8
            this.label = 1;     // Catch: Throwable -> L8
            r10 = r19.getDeviceInfo(r4, r18, r17, this);     // Catch: Throwable -> L8
            if (r10 != r1) goto L30;
            return r1;
        L30:
            r3 = r8;
            goto L31
        L26:
            r18 = "P";
        L8:
            th = move-exception;
            Result.Companion r20 = Result.Companion;
            r12 = Result.m1508constructorimpl(ResultKt.createFailure(th));
            goto L37
        }
    }

    public static /* synthetic */ boolean $r8$lambda$0FdqdFM0gDAWYZzJUeK91TLwBmI(DeviceInfo r0, OCardListItem r1, View r2) {
        return initView$lambda$19$lambda$10$lambda$9(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$GXcq6Dku7nHifjwu8oU4kvR5trg(GuaranteeFragment r0, View r1) {
        onViewCreated$lambda$2$lambda$0(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$OZxdIpOS5gNIoJxpRhQGRaUNQrc(DeviceInfo r0, GuaranteeFragment r1, View r2) {
        initView$lambda$19$lambda$8$lambda$7(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$WZpnhkFWptoNLYpDpHGy3nEH_HQ(GuaranteeFragment r0, DeviceInfo r1, View r2) {
        initView$lambda$19$lambda$14$lambda$13(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$WlhWrpf3mKAYF0M0qrkaSBzNx-Y, reason: not valid java name */
    public static /* synthetic */ void m222$r8$lambda$WlhWrpf3mKAYF0M0qrkaSBzNxY(GuaranteeFragment r0, DeviceInfo r1, View r2) {
        initView$lambda$19$lambda$12$lambda$11(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$_i6KyUuhu1NTWXyvQbPILdRHPiU(GuaranteeFragment r0, DeviceInfo r1, View r2) {
        initView$lambda$19$lambda$16$lambda$15(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$d__GrP00fnQ_YShfKCGz9cV0dMI(GuaranteeFragment r0, DeviceInfo r1, View r2) {
        initView$lambda$19$lambda$18$lambda$17(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$m9l--EuhaMOnu7glrPA5i51Hhdg, reason: not valid java name */
    public static /* synthetic */ boolean m223$r8$lambda$m9lEuhaMOnu7glrPA5i51Hhdg(GuaranteeFragment r0, String r1, View r2) {
        return onViewCreated$lambda$2$lambda$1(r0, r1, r2);
    }

    public void com_android_settings_about_GuaranteeFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_about_GuaranteeFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_about_GuaranteeFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_about_GuaranteeFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public GuaranteeFragment() {
        this.weixinPackageName = "com.tencent.mm";
        this.keva = Keva.getRepo(REPO_NAME);
        this.gson = new Gson();
        this.mainBg$delegate = LazyKt.lazy(new GuaranteeFragment$mainBg$2(this));
        this.card$delegate = LazyKt.lazy(new GuaranteeFragment$card$2(this));
        this.deviceName$delegate = LazyKt.lazy(new GuaranteeFragment$deviceName$2(this));
        this.imeiTv$delegate = LazyKt.lazy(new GuaranteeFragment$imeiTv$2(this));
        this.imeiTitle$delegate = LazyKt.lazy(new GuaranteeFragment$imeiTitle$2(this));
        this.expiredDate$delegate = LazyKt.lazy(new GuaranteeFragment$expiredDate$2(this));
        this.expiredDateTitle$delegate = LazyKt.lazy(new GuaranteeFragment$expiredDateTitle$2(this));
        this.stateTv$delegate = LazyKt.lazy(new GuaranteeFragment$stateTv$2(this));
        this.loadingProgress$delegate = LazyKt.lazy(new GuaranteeFragment$loadingProgress$2(this));
        this.errorText$delegate = LazyKt.lazy(new GuaranteeFragment$errorText$2(this));
    }

    public static final /* synthetic */ DeviceInfo access$getDeviceInfo$cp() {
        return deviceInfo;
    }

    public static final /* synthetic */ Gson access$getGson$p(GuaranteeFragment r0) {
        return r0.gson;
    }

    public static final /* synthetic */ Keva access$getKeva$p(GuaranteeFragment r0) {
        return r0.keva;
    }

    public static final /* synthetic */ String access$getLanguage(GuaranteeFragment r0) {
        return r0.getLanguage();
    }

    public static final /* synthetic */ long access$getLastRequestTime$cp() {
        return lastRequestTime;
    }

    public static final /* synthetic */ String access$getPreLanguage$cp() {
        return preLanguage;
    }

    public static final /* synthetic */ String access$getTAG$p(GuaranteeFragment r0) {
        return r0.TAG;
    }

    public static final /* synthetic */ GuaranteeLayoutBinding access$getViewBind$p(GuaranteeFragment r0) {
        return r0.viewBind;
    }

    public static final /* synthetic */ void access$initView(GuaranteeFragment r0, DeviceInfo r1, String r2) {
        r0.initView(r1, r2);
    }

    public static final /* synthetic */ Object access$requestDeviceInfo(GuaranteeFragment r0, String r1, Continuation r2) {
        return r0.requestDeviceInfo(r1, r2);
    }

    public static final /* synthetic */ void access$setDeviceInfo$cp(DeviceInfo r0) {
        deviceInfo = r0;
    }

    public static final /* synthetic */ void access$setLastRequestTime$cp(long r0) {
        lastRequestTime = r0;
    }

    public static final /* synthetic */ void access$setPreLanguage$cp(String r0) {
        preLanguage = r0;
    }

    static {
        Companion = new Companion(null);
        preLanguage = "";
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        GuaranteeLayoutBinding r6 = GuaranteeLayoutBinding.inflate(r3, r4, false);
        Intrinsics.checkNotNullExpressionValue(r6, "inflate(...)");
        this.viewBind = r6;
        GuaranteeLayoutBinding r7 = null;
        if (r6 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewBind");
        r6 = null;
    L5:
        r6.frameLayout.addView(UIUtils.buildNoScaledView(this.mContext, R.layout.view_banner_guarantee));
        GuaranteeLayoutBinding r2 = this.viewBind;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewBind");
    L9:
        RelativeLayout r8 = r7.getRoot();
        Intrinsics.checkNotNullExpressionValue(r8, "getRoot(...)");
        return r8;
    L8:
        r7 = r2;
        goto L9
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r18, Bundle r19) {
        Intrinsics.checkNotNullParameter(r18, "view");
        super.onViewCreated(r18, r19);
        final String r2 = TelephonyManager.getDefault().getImei(0);
        Intrinsics.checkNotNullExpressionValue(r2, "getImei(...)");
        GuaranteeLayoutBinding r4 = this.viewBind;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewBind");
        r4 = null;
    L5:
        r4.viewTitle.removeStartAction();
        OFloatingTitleBar r7 = r4.viewTitle;
        Intrinsics.checkNotNullExpressionValue(r7, "viewTitle");
        ViewExtKt.setOnDebounceClickListener(OFloatingTitleBar.addStartAction$default(r7, R.drawable.o_floating_title_bar_icon_back, 0, null, 6, null), new GuaranteeFragment$$ExternalSyntheticLambda0(this));
        getDeviceName(r4).setText(ResourceUtils.getString(R.string.guarantee_device_name));
        getImeiTv(r4).setText(CollectionsKt.joinToString$default(StringsKt.chunked(r2, 4), HanziToPinyin.Token.SEPARATOR, null, null, 0, null, null, 62, null));
        getImeiTv(r4).setOnLongClickListener(new GuaranteeFragment$$ExternalSyntheticLambda1(this, r2));
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain(), null, new AnonymousClass2(this, r2, null), 2, null);
        if ((r18 instanceof ViewGroup) == false) goto L9;
        ((ViewGroup) r18).setClipChildren(false);
        return;
    }

    private static final void onViewCreated$lambda$2$lambda$0(GuaranteeFragment r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        FragmentActivity r2 = r0.getActivity();
        if (r2 == null) goto L6;
        r2.onBackPressed();
        return;
    }

    private static final boolean onViewCreated$lambda$2$lambda$1(GuaranteeFragment r2, String r3, View r4) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Intrinsics.checkNotNullParameter(r3, "$imei");
        ToastUtils.showOceanToast(r2.getActivity(), ResourceUtils.getString(R.string.copied) + "IMEI");
        FragmentActivity r5 = r2.getActivity();
        ClipboardManager r6 = null;
        if (r5 == null) goto L5;
        Object r7 = r5.getSystemService("clipboard");
    L7:
        if ((r7 instanceof ClipboardManager) == false) goto L9;
        r6 = (ClipboardManager) r7;
    L9:
        if (r6 == null) goto L13;
        r6.setPrimaryClip(ClipData.newPlainText("info", r3));
        return true;
    L13:
        return true;
    L5:
        r7 = null;
        goto L7
    }

    public final void showOrHideWarrantyCard(boolean r7) {
        View[] r0 = new View[9];
        GuaranteeLayoutBinding r1 = this.viewBind;
        GuaranteeLayoutBinding r2 = null;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewBind");
        r1 = null;
    L5:
        r0[0] = getMainBg(r1);
        GuaranteeLayoutBinding r3 = this.viewBind;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewBind");
        r3 = null;
    L8:
        r0[1] = getCard(r3);
        GuaranteeLayoutBinding r4 = this.viewBind;
        if (r4 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewBind");
        r4 = null;
    L11:
        r0[2] = getDeviceName(r4);
        GuaranteeLayoutBinding r5 = this.viewBind;
        if (r5 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("viewBind");
        r5 = null;
    L14:
        r0[3] = getImeiTv(r5);
        GuaranteeLayoutBinding r6 = this.viewBind;
        if (r6 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("viewBind");
        r6 = null;
    L17:
        r0[4] = getImeiTitle(r6);
        GuaranteeLayoutBinding r8 = this.viewBind;
        if (r8 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("viewBind");
        r8 = null;
    L20:
        r0[5] = getExpiredDate(r8);
        GuaranteeLayoutBinding r9 = this.viewBind;
        if (r9 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("viewBind");
        r9 = null;
    L23:
        r0[6] = getExpiredDateTitle(r9);
        GuaranteeLayoutBinding r10 = this.viewBind;
        if (r10 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("viewBind");
        r10 = null;
    L26:
        r0[7] = getStateTv(r10);
        GuaranteeLayoutBinding r11 = this.viewBind;
        if (r11 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("viewBind");
    L30:
        OSectionSupportiveText r12 = r2.tvExplanation;
        Intrinsics.checkNotNullExpressionValue(r12, "tvExplanation");
        r0[8] = r12;
        Iterator r13 = CollectionsKt.listOf(r0).iterator();
    L32:
        if (r13.hasNext() == false) goto L38;
        View r14 = (View) r13.next();
        if (r7 == false) goto L36;
        int r15 = 0;
    L37:
        r14.setVisibility(r15);
        goto L32
    L36:
        r15 = 8;
        goto L37
    L38:
        return;
    L29:
        r2 = r11;
        goto L30
    }

    private final void initView(final DeviceInfo r10, String r11) {
        FragmentActivity r12 = getActivity();
        int r0 = 1;
        if (r12 != null) goto L5;
    L7:
        boolean r13 = false;
    L8:
        if (r13 == false) goto L10;
        return;
    L10:
        if (isDetached() == true) goto L272;
        GuaranteeLayoutBinding r14 = this.viewBind;
        if (r14 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("viewBind");
        r14 = null;
    L16:
        if (Intrinsics.areEqual(r10.getHideWarrantyCard(), true) == false) goto L18;
        showOrHideWarrantyCard(false);
    L51:
        OCardListItem r4 = r14.officialPhone;
        String r5 = r10.getCustomerService();
        if (r5 != null) goto L54;
    L57:
        boolean r6 = true;
    L59:
        if (r6 == true) goto L80;
        String r7 = r10.getCustomerServiceName();
        if (r7 != null) goto L63;
    L66:
        boolean r8 = true;
    L67:
        if (r8 == true) goto L80;
        r4.setVisibility(0);
        r4.setSubTitle(r10.getCustomerService());
        r4.showSubTitle(true);
        r4.setTitle(r10.getCustomerServiceName());
        r4.setIcon(R.drawable.phone_icon);
        r4.showIcon(true);
        FragmentActivity r9 = getActivity();
        if (r9 != null) goto L72;
    L74:
        boolean r15 = false;
    L75:
        if (r15 == true) goto L77;
    L79:
        r4.setOnContentClickListener(new GuaranteeFragment$$ExternalSyntheticLambda2(r10, this));
    L81:
        final OCardListItem r16 = r14.officialEmail;
        String r17 = r10.getGlbServiceEmail();
        if (r17 != null) goto L84;
    L87:
        boolean r18 = true;
    L88:
        if (r18 == true) goto L109;
        String r19 = r10.getGlbServiceName();
        if (r19 != null) goto L92;
    L95:
        boolean r20 = true;
    L96:
        if (r20 == true) goto L109;
        r16.setVisibility(0);
        r16.setTitle(r10.getGlbServiceName());
        r16.setSubTitle(r10.getGlbServiceEmail());
        r16.showSubTitle(true);
        r16.setIcon(R.drawable.email_icon);
        r16.showIcon(true);
        r16.showTailIcon(false);
        FragmentActivity r21 = getActivity();
        if (r21 != null) goto L101;
    L103:
        boolean r22 = false;
    L104:
        if (r22 == true) goto L106;
    L108:
        r16.setOnContentLongClickListener(new GuaranteeFragment$$ExternalSyntheticLambda3(r10, r16));
    L110:
        OCardListItem r23 = r14.officialWebsite;
        String r24 = r10.getForum();
        if (r24 != null) goto L113;
    L116:
        boolean r25 = true;
    L117:
        if (r25 == true) goto L138;
        String r26 = r10.getForumName();
        if (r26 != null) goto L121;
    L124:
        boolean r27 = true;
    L125:
        if (r27 == true) goto L138;
        r23.setVisibility(0);
        r23.setTitle(r10.getForumName());
        r23.setIcon(R.drawable.zte_icon);
        r23.showIcon(true);
        FragmentActivity r28 = getActivity();
        if (r28 != null) goto L130;
    L132:
        boolean r29 = false;
    L133:
        if (r29 == true) goto L135;
    L137:
        r23.setOnContentClickListener(new GuaranteeFragment$$ExternalSyntheticLambda4(this, r10));
    L139:
        OCardListItem r30 = r14.wechat;
        String r31 = r10.getWechatName();
        if (r31 != null) goto L142;
    L145:
        boolean r32 = true;
    L146:
        if (r32 == true) goto L167;
        String r33 = r10.getWechatUrl();
        if (r33 != null) goto L150;
    L153:
        boolean r34 = true;
    L154:
        if (r34 == true) goto L167;
        r30.setVisibility(0);
        r30.setTitle(r10.getWechatName());
        r30.setIcon(R.drawable.headphone_microphone_icon);
        r30.showIcon(true);
        FragmentActivity r35 = getActivity();
        if (r35 != null) goto L159;
    L161:
        boolean r36 = false;
    L162:
        if (r36 == true) goto L164;
    L166:
        r30.setOnContentClickListener(new GuaranteeFragment$$ExternalSyntheticLambda5(this, r10));
    L168:
        OCardListItem r37 = r14.doubaoCommunity;
        String r38 = r10.getDoubaoCommunityName();
        if (r38 != null) goto L171;
    L174:
        boolean r39 = true;
    L175:
        if (r39 == true) goto L196;
        String r40 = r10.getDoubaoCommunityUrl();
        if (r40 != null) goto L179;
    L182:
        boolean r41 = true;
    L183:
        if (r41 == true) goto L196;
        r37.setVisibility(0);
        r37.setTitle(r10.getDoubaoCommunityName());
        r37.setIcon(R.drawable.home_icon);
        r37.showIcon(true);
        FragmentActivity r42 = getActivity();
        if (r42 != null) goto L188;
    L190:
        boolean r43 = false;
    L191:
        if (r43 == true) goto L193;
    L195:
        r37.setOnContentClickListener(new GuaranteeFragment$$ExternalSyntheticLambda6(this, r10));
    L197:
        OCardListItem r110 = r14.doubaoForum;
        String r44 = r10.getDoubaoPhoneForumName();
        if (r44 != null) goto L200;
    L203:
        boolean r45 = true;
    L204:
        if (r45 == true) goto L225;
        String r46 = r10.getDoubaoPhoneForumUrl();
        if (r46 != null) goto L208;
    L211:
        boolean r47 = true;
    L212:
        if (r47 == true) goto L225;
        r110.setVisibility(0);
        r110.setTitle(r10.getDoubaoPhoneForumName());
        r110.setIcon(R.drawable.website_icon);
        r110.showIcon(true);
        FragmentActivity r48 = getActivity();
        if (r48 != null) goto L217;
    L219:
        boolean r49 = false;
    L220:
        if (r49 == true) goto L222;
    L224:
        r110.setOnContentClickListener(new GuaranteeFragment$$ExternalSyntheticLambda7(this, r10));
    L226:
        OCardListItem[] r111 = new OCardListItem[6];
        GuaranteeLayoutBinding r112 = this.viewBind;
        if (r112 != null) goto L229;
        Intrinsics.throwUninitializedPropertyAccessException("viewBind");
        r112 = null;
    L229:
        r111[0] = r112.officialPhone;
        GuaranteeLayoutBinding r113 = this.viewBind;
        if (r113 != null) goto L232;
        Intrinsics.throwUninitializedPropertyAccessException("viewBind");
        r113 = null;
    L232:
        r111[1] = r113.officialEmail;
        GuaranteeLayoutBinding r114 = this.viewBind;
        if (r114 != null) goto L235;
        Intrinsics.throwUninitializedPropertyAccessException("viewBind");
        r114 = null;
    L235:
        r111[2] = r114.officialWebsite;
        GuaranteeLayoutBinding r115 = this.viewBind;
        if (r115 != null) goto L238;
        Intrinsics.throwUninitializedPropertyAccessException("viewBind");
        r115 = null;
    L238:
        r111[3] = r115.wechat;
        GuaranteeLayoutBinding r116 = this.viewBind;
        if (r116 != null) goto L241;
        Intrinsics.throwUninitializedPropertyAccessException("viewBind");
        r116 = null;
    L241:
        r111[4] = r116.doubaoCommunity;
        GuaranteeLayoutBinding r50 = this.viewBind;
        if (r50 != null) goto L244;
        Intrinsics.throwUninitializedPropertyAccessException("viewBind");
        r50 = null;
    L244:
        r111[5] = r50.doubaoForum;
        List r51 = CollectionsKt.listOf(r111);
        ArrayList r117 = new ArrayList();
        Iterator r52 = r51.iterator();
    L246:
        if (r52.hasNext() == false) goto L253;
        Object r118 = r52.next();
        if (((OCardListItem) r118).getVisibility() != 0) goto L250;
        boolean r2 = true;
    L251:
        if (r2 == false) goto L246;
        r117.add(r118);
        goto L246
    L250:
        r2 = false;
        goto L251
    L253:
        ArrayList r119 = r117;
        int r53 = r119.size();
        if (r53 != 0) goto L256;
        return;
    L256:
        if (r53 == 1) goto L261;
        Object r54 = CollectionsKt.first(r119);
        Intrinsics.checkNotNullExpressionValue(r54, "first(...)");
        OCardListItem.setCardPosition$default((OCardListItem) r54, 1, false, 2, null);
        int r55 = CollectionsKt.getLastIndex(r119);
    L258:
        if (r0 >= r55) goto L260;
        Object r3 = r119.get(r0);
        Intrinsics.checkNotNullExpressionValue(r3, "get(...)");
        OCardListItem.setCardPosition$default((OCardListItem) r3, 2, false, 2, null);
        r0 = r0 + 1;
        goto L258
    L260:
        Object r56 = CollectionsKt.last(r119);
        Intrinsics.checkNotNullExpressionValue(r56, "last(...)");
        OCardListItem.setCardPosition$default((OCardListItem) r56, 3, false, 2, null);
        return;
    L261:
        Object r57 = r119.get(0);
        Intrinsics.checkNotNullExpressionValue(r57, "get(...)");
        OCardListItem.setCardPosition$default((OCardListItem) r57, 0, false, 2, null);
        return;
    L222:
        if (isDetached() == true) goto L224;
        Glide.with(r110.getContext()).load(r10.getDoubaoPhoneForumIcon()).placeholder(R.drawable.website_icon).into(r110.getIconView()).clearOnDetach();
        goto L224
    L217:
        if (r48.isDestroyed() == true) goto L219;
        r49 = true;
        goto L220
    L208:
        if (r46.length() == 0) goto L211;
        r47 = false;
    L225:
        r110.setVisibility(8);
        goto L226
    L200:
        if (r44.length() == 0) goto L203;
        r45 = false;
        goto L204
    L193:
        if (isDetached() == true) goto L195;
        Glide.with(r37.getContext()).load(r10.getDoubaoCommunityIcon()).placeholder(R.drawable.home_icon).into(r37.getIconView()).clearOnDetach();
        goto L195
    L188:
        if (r42.isDestroyed() == true) goto L190;
        r43 = true;
        goto L191
    L179:
        if (r40.length() == 0) goto L182;
        r41 = false;
    L196:
        r37.setVisibility(8);
        goto L197
    L171:
        if (r38.length() == 0) goto L174;
        r39 = false;
        goto L175
    L164:
        if (isDetached() == true) goto L166;
        Glide.with(r30.getContext()).load(r10.getWechatIcon()).placeholder(R.drawable.headphone_microphone_icon).into(r30.getIconView()).clearOnDetach();
        goto L166
    L159:
        if (r35.isDestroyed() == true) goto L161;
        r36 = true;
        goto L162
    L150:
        if (r33.length() == 0) goto L153;
        r34 = false;
    L167:
        r30.setVisibility(8);
        goto L168
    L142:
        if (r31.length() == 0) goto L145;
        r32 = false;
        goto L146
    L135:
        if (isDetached() == true) goto L137;
        Glide.with(r23.getContext()).load(r10.getForumIcon()).placeholder(R.drawable.zte_icon).into(r23.getIconView()).clearOnDetach();
        goto L137
    L130:
        if (r28.isDestroyed() == true) goto L132;
        r29 = true;
        goto L133
    L121:
        if (r26.length() == 0) goto L124;
        r27 = false;
    L138:
        r23.setVisibility(8);
        goto L139
    L113:
        if (r24.length() == 0) goto L116;
        r25 = false;
        goto L117
    L106:
        if (isDetached() == true) goto L108;
        Glide.with(r16.getContext()).load(r10.getGlbServiceIcon()).placeholder(R.drawable.email_icon).into(r16.getIconView()).clearOnDetach();
        goto L108
    L101:
        if (r21.isDestroyed() == true) goto L103;
        r22 = true;
        goto L104
    L92:
        if (r19.length() == 0) goto L95;
        r20 = false;
    L109:
        r16.setVisibility(8);
        goto L110
    L84:
        if (r17.length() == 0) goto L87;
        r18 = false;
        goto L88
    L77:
        if (isDetached() == true) goto L79;
        Glide.with(r4.getContext()).load(r10.getCustomerServiceIcon()).placeholder(R.drawable.phone_icon).into(r4.getIconView()).clearOnDetach();
        goto L79
    L72:
        if (r9.isDestroyed() == true) goto L74;
        r15 = true;
        goto L75
    L63:
        if (r7.length() == 0) goto L66;
        r8 = false;
    L80:
        r4.setVisibility(8);
        goto L81
    L54:
        if (r5.length() == 0) goto L57;
        r6 = false;
        goto L59
    L18:
        showOrHideWarrantyCard(true);
        if (r10.getExpireTime() <= r10.getServerTime()) goto L21;
        boolean r58 = true;
    L22:
        OTextView r59 = getStateTv(r14);
        r59.setVisibility(0);
        if (r58 == false) goto L25;
        int r60 = R.string.warranty_state_in;
    L26:
        r59.setText(ResourceUtils.getString(r60));
        Context r61 = r59.getContext();
        if (r61 == null) goto L32;
        if (r58 == false) goto L30;
        int r62 = R.drawable.expired_state_text_on_bg;
    L31:
        Drawable r63 = r61.getDrawable(r62);
    L33:
        r59.setBackground(r63);
        if (r58 == false) goto L36;
        int r64 = ContextCompat.getColor(r59.getContext(), R.color.oui_dark_functional_graphite_8);
    L37:
        r59.setTextColor(r64);
        getExpiredDateTitle(r14).setVisibility(0);
        getExpiredDate(r14).setText(formatDate(r10.getExpireTime()));
        getExpiredDate(r14).setVisibility(0);
        OTextView r65 = getExpiredDate(r14);
        if (r58 == false) goto L40;
        int r66 = ContextCompat.getColor(r65.getContext(), R.color.oui_dark_basic_text_1);
    L41:
        r65.setTextColor(r66);
        OSectionSupportiveText r67 = r14.tvExplanation;
        String r68 = r10.getRightExplanation();
        if (r68 != null) goto L44;
    L47:
        boolean r69 = true;
    L48:
        if (r69 == true) goto L51;
        r67.setVisibility(0);
        r67.setSectionDes(r10.getRightExplanation());
        goto L51
    L44:
        if (r68.length() == 0) goto L47;
        r69 = false;
        goto L48
    L40:
        r66 = ContextCompat.getColor(r65.getContext(), R.color.oui_dark_basic_text_3);
        goto L41
    L36:
        r64 = ContextCompat.getColor(r59.getContext(), R.color.oui_dark_basic_text_3b);
        goto L37
    L30:
        r62 = R.drawable.expired_state_text_out_bg;
        goto L31
    L32:
        r63 = null;
        goto L33
    L25:
        r60 = R.string.warranty_state_out;
        goto L26
    L21:
        r58 = false;
        goto L22
    L272:
        return;
    L5:
        if (r12.isDestroyed() != true) goto L7;
        r13 = true;
        goto L8
    }

    private static final void initView$lambda$19$lambda$8$lambda$7(DeviceInfo r2, GuaranteeFragment r3, View r4) {
        Intrinsics.checkNotNullParameter(r2, "$deviceInfo");
        Intrinsics.checkNotNullParameter(r3, "this$0");
        Intent r5 = new Intent("android.intent.action.DIAL");
        r5.setData(Uri.parse("tel:" + r2.getCustomerService()));
        r3.startActivity(r5);
    }

    private static final boolean initView$lambda$19$lambda$10$lambda$9(DeviceInfo r4, OCardListItem r5, View r6) {
        Intrinsics.checkNotNullParameter(r4, "$deviceInfo");
        Intrinsics.checkNotNullParameter(r5, "$this_apply");
        String r7 = r4.getGlbServiceEmail();
        if (r7.length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L18;
        Context r1 = r5.getContext();
        ClipboardManager r2 = null;
        if (r1 == null) goto L10;
        Object r3 = r1.getSystemService("clipboard");
    L12:
        if ((r3 instanceof ClipboardManager) == false) goto L14;
        r2 = (ClipboardManager) r3;
    L14:
        ClipData r8 = ClipData.newPlainText("Email", r7);
        if (r2 == null) goto L17;
        r2.setPrimaryClip(r8);
    L17:
        ToastUtils.show(r5.getContext(), ResourceUtils.getString(R.string.copied) + r4.getGlbServiceName());
        goto L18
    L10:
        r3 = null;
    L18:
        return true;
    L5:
        r0 = false;
        goto L6
    }

    private static final void initView$lambda$19$lambda$12$lambda$11(GuaranteeFragment r0, DeviceInfo r1, View r2) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        Intrinsics.checkNotNullParameter(r1, "$deviceInfo");
        r0.openUrl(r1.getForum());
    }

    private static final void initView$lambda$19$lambda$14$lambda$13(GuaranteeFragment r0, DeviceInfo r1, View r2) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        Intrinsics.checkNotNullParameter(r1, "$deviceInfo");
        if (r0.isAppInstalled(r0.weixinPackageName) == true) goto L5;
        r0.openMarketUrl(r0.weixinPackageName);
        return;
    L5:
        r0.openUrl(r1.getWechatUrl());
    }

    private static final void initView$lambda$19$lambda$16$lambda$15(GuaranteeFragment r0, DeviceInfo r1, View r2) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        Intrinsics.checkNotNullParameter(r1, "$deviceInfo");
        r0.openUrl(r1.getDoubaoCommunityUrl());
    }

    private static final void initView$lambda$19$lambda$18$lambda$17(GuaranteeFragment r0, DeviceInfo r1, View r2) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        Intrinsics.checkNotNullParameter(r1, "$deviceInfo");
        r0.openUrl(r1.getDoubaoPhoneForumUrl());
    }

    private final Drawable getDrawable(int r2) {
        return ResourcesCompat.getDrawable(ResourceUtils.getResources(), r2, null);
    }

    private final String formatDate(long r3) {
        Date r2 = new Date(r3 * ((long) 1000));
        String r4 = new SimpleDateFormat(DateUtils.PATTERN_YEAR, Locale.getDefault()).format(r2);
        Intrinsics.checkNotNullExpressionValue(r4, "format(...)");
        return r4;
    }

    private final void loadUrl(String r4) {
        Intent r0 = new Intent("android.intent.action.VIEW");
        r0.setPackage("com.obric.browser");
        r0.putExtra("create_new_tab", true);
        r0.putExtra("support_dark_mode", true);
        r0.addCategory("android.intent.category.BROWSABLE");
        r0.setData(Uri.parse(r4));
        r0.addFlags(268435456);
        startActivity(r0);
    }

    private final void openUrl(String r5) {
        if (StringsKt.startsWith$default(r5, "http", false, 2, null) == false) goto L6;
        loadUrl(r5);
        return;
    L6:
        Intent r0 = new Intent("android.intent.action.VIEW");
        r0.setData(Uri.parse(r5).buildUpon().appendQueryParameter("random_key", String.valueOf(System.currentTimeMillis())).build());
        r0.addFlags(268435456);
        startActivity(r0);
    }

    private final void openMarketUrl(String r4) {
        Intent r0 = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + r4));
        r0.setPackage(Utils.APP_STORE_PACKAGE);
        r0.addFlags(268435456);
        startActivity(r0);
    }

    private final boolean isAppInstalled(String r3) {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L14
        GuaranteeFragment r2 = this;     // Catch: Throwable -> L14
        Context r4 = getContext();     // Catch: Throwable -> L14
        PackageInfo r5 = null;
        if (r4 == null) goto L6;
        PackageManager r6 = r4.getPackageManager();     // Catch: Throwable -> L14
    L7:
        if (r6 == null) goto L9;
        r5 = r6.getPackageInfo(r3, 0);     // Catch: Throwable -> L14
    L9:
        if (r5 == null) goto L11;
        boolean r7 = true;
    L12:
        Object r8 = Result.m1508constructorimpl(Boolean.valueOf(r7));     // Catch: Throwable -> L14
    L17:
        if (Result.m1514isFailureimpl(r8) == false) goto L20;
        r8 = false;
    L20:
        return ((Boolean) r8).booleanValue();
    L11:
        r7 = false;
        goto L12
    L6:
        r6 = null;
    L14:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r8 = Result.m1508constructorimpl(ResultKt.createFailure(th));
        goto L17
    }

    private final Object requestDeviceInfo(String r4, Continuation<? super DeviceInfo> r5) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C01422(this, r4, null), r5);
    }

    private final String getLanguage() {
        Context r1 = getContext();
        if (r1 == null) goto L13;
        Resources r2 = r1.getResources();
        if (r2 == null) goto L13;
        Configuration r3 = r2.getConfiguration();
        if (r3 == null) goto L13;
        LocaleList r4 = r3.getLocales();
        if (r4 == null) goto L13;
        Locale r5 = r4.get(0);
        if (r5 == null) goto L13;
        String r6 = r5.toString();
    L14:
        if (r6 != null) goto L17;
        return Constants.APP_LABELS_OF_ZH_CN;
    L17:
        return r6;
    L13:
        r6 = null;
        goto L14
    }

    public final OUIFrameLayout getMainBg(GuaranteeLayoutBinding r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Object r1 = this.mainBg$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(r1, "getValue(...)");
        return (OUIFrameLayout) r1;
    }

    public final OTextView getCard(GuaranteeLayoutBinding r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Object r1 = this.card$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(r1, "getValue(...)");
        return (OTextView) r1;
    }

    public final OTextView getDeviceName(GuaranteeLayoutBinding r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Object r1 = this.deviceName$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(r1, "getValue(...)");
        return (OTextView) r1;
    }

    public final OTextView getImeiTv(GuaranteeLayoutBinding r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Object r1 = this.imeiTv$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(r1, "getValue(...)");
        return (OTextView) r1;
    }

    public final OTextView getImeiTitle(GuaranteeLayoutBinding r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Object r1 = this.imeiTitle$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(r1, "getValue(...)");
        return (OTextView) r1;
    }

    public final OTextView getExpiredDate(GuaranteeLayoutBinding r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Object r1 = this.expiredDate$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(r1, "getValue(...)");
        return (OTextView) r1;
    }

    public final OTextView getExpiredDateTitle(GuaranteeLayoutBinding r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Object r1 = this.expiredDateTitle$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(r1, "getValue(...)");
        return (OTextView) r1;
    }

    public final OTextView getStateTv(GuaranteeLayoutBinding r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Object r1 = this.stateTv$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(r1, "getValue(...)");
        return (OTextView) r1;
    }

    public final ODownloadProgressView getLoadingProgress(GuaranteeLayoutBinding r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Object r1 = this.loadingProgress$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(r1, "getValue(...)");
        return (ODownloadProgressView) r1;
    }

    public final OTextView getErrorText(GuaranteeLayoutBinding r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Object r1 = this.errorText$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(r1, "getValue(...)");
        return (OTextView) r1;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_about_GuaranteeFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(GuaranteeFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_about_GuaranteeFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_about_GuaranteeFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(GuaranteeFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_about_GuaranteeFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_about_GuaranteeFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(GuaranteeFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_about_GuaranteeFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
