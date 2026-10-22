package com.android.settings.wifi.main;

import android.app.Activity;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.android.settings.R;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.ResourceUtils;
import com.android.settings.wifi.AccessPointInfo;
import com.android.settings.wifi.AccessPointView;
import com.obric.olog.OLog;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: ModularWifiListSetupAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 .2\u00020\u0001:\u0002./B\u0087\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007\u0012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b\u0012\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b\u0012\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b\u0012\u001a\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r\u0018\u00010\u0011¢\u0006\u0002\u0010\u0012J\u0018\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u0016H\u0002J\u000e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J\b\u0010\u001e\u001a\u00020\u0016H\u0016J\u0010\u0010\u001f\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u0016H\u0016J&\u0010 \u001a\u00020\r2\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0002J\b\u0010#\u001a\u00020\rH\u0016J\u0018\u0010$\u001a\u00020\r2\u0006\u0010%\u001a\u00020&2\u0006\u0010\u001c\u001a\u00020\u0016H\u0016J\u0018\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u0016H\u0016J\b\u0010,\u001a\u00020\rH\u0016J\u0018\u0010-\u001a\u00020\r2\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0016R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r\u0018\u00010\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/android/settings/wifi/main/ModularWifiListSetupAdapter;", "Lcom/android/settings/wifi/main/WifiListSetupAdapter;", "activity", "Landroid/app/Activity;", "isActivateMode", "", "constructAccessPointsAction", "Lkotlin/Function0;", "", "Lcom/android/settings/wifi/AccessPointInfo;", "onBindHeader", "Lkotlin/Function1;", "Landroid/view/View;", "", "onClickItem", "onBindOtherNetworkTitle", "onBindFooter", "Lkotlin/Function2;", "(Landroid/app/Activity;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "TAG", "", "headerCount", "", "realData", "", "Lcom/android/settings/wifi/main/ModularWifiListSetupAdapter$Companion$Modular;", "checkItemPosition", "listPosition", "position", "getData", "getItemCount", "getItemViewType", "groupItems", "accessPoints", "data", "initData", "onBindViewHolder", "holderModular", "Lcom/android/settings/wifi/main/WifiListSetupAdapter$CustomViewHolder;", "onCreateViewHolder", "Lcom/android/settings/wifi/main/ModularWifiListSetupAdapter$CustomViewHolder;", "parent", "Landroid/view/ViewGroup;", "viewType", "tryUpdateConnectedAccessPointRssi", "updateData", "Companion", "CustomViewHolder", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class ModularWifiListSetupAdapter extends WifiListSetupAdapter {
    public static final Companion Companion = null;
    private static final int TYPE_FOOTER = 0;
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 0;
    private static final int TYPE_TITLE = 0;
    private static final int TYPE_TITLE_NORMAL = 0;
    private static final int TYPE_TITLE_OTHER_NETWORK = 0;
    private final String TAG;
    private final Activity activity;
    private final Function0<List<AccessPointInfo>> constructAccessPointsAction;
    private final int headerCount;
    private final boolean isActivateMode;
    private final Function2<View, Boolean, Unit> onBindFooter;
    private final Function1<View, Unit> onBindHeader;
    private final Function1<View, Unit> onBindOtherNetworkTitle;
    private final Function1<AccessPointInfo, Unit> onClickItem;
    private final List<Companion.Modular> realData;

    /* JADX INFO: compiled from: ModularWifiListSetupAdapter.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0004\u000e\u000f\u0010\u0011B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/android/settings/wifi/main/ModularWifiListSetupAdapter$Companion;", "", "()V", "TYPE_FOOTER", "", "TYPE_HEADER", "TYPE_ITEM", "TYPE_TITLE", "getTYPE_TITLE", "()I", "TYPE_TITLE_NORMAL", "getTYPE_TITLE_NORMAL", "TYPE_TITLE_OTHER_NETWORK", "getTYPE_TITLE_OTHER_NETWORK", "AccessPointInfoModular", "Modular", "TitleModular", "ViewType", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {

        /* JADX INFO: compiled from: ModularWifiListSetupAdapter.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/android/settings/wifi/main/ModularWifiListSetupAdapter$Companion$AccessPointInfoModular;", "Lcom/android/settings/wifi/main/ModularWifiListSetupAdapter$Companion$Modular;", "info", "Lcom/android/settings/wifi/AccessPointInfo;", "(Lcom/android/settings/wifi/AccessPointInfo;)V", "getInfo", "()Lcom/android/settings/wifi/AccessPointInfo;", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
        private static final class AccessPointInfoModular implements Modular {
            private final AccessPointInfo info;

            public AccessPointInfoModular(AccessPointInfo r2) {
                Intrinsics.checkNotNullParameter(r2, "info");
                this.info = r2;
            }

            public final AccessPointInfo getInfo() {
                return this.info;
            }
        }

        /* JADX INFO: compiled from: ModularWifiListSetupAdapter.kt */
        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/android/settings/wifi/main/ModularWifiListSetupAdapter$Companion$Modular;", "", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public interface Modular {
        }

        /* JADX INFO: compiled from: ModularWifiListSetupAdapter.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/android/settings/wifi/main/ModularWifiListSetupAdapter$Companion$TitleModular;", "Lcom/android/settings/wifi/main/ModularWifiListSetupAdapter$Companion$Modular;", "title", "", "type", "", "(Ljava/lang/String;I)V", "getTitle", "()Ljava/lang/String;", "getType", "()I", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
        private static final class TitleModular implements Modular {
            private final String title;
            private final int type;

            public TitleModular(String r2, int r3) {
                Intrinsics.checkNotNullParameter(r2, "title");
                this.title = r2;
                this.type = r3;
            }

            public final String getTitle() {
                return this.title;
            }

            public /* synthetic */ TitleModular(String r1, int r2, int r3, DefaultConstructorMarker r4) {
                if ((r3 & 2) == 0) goto L5;
                r2 = ModularWifiListSetupAdapter.Companion.getTYPE_TITLE_NORMAL();
            L5:
                this(r1, r2);
            }

            public final int getType() {
                return this.type;
            }
        }

        /* JADX INFO: compiled from: ModularWifiListSetupAdapter.kt */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0007\bB\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0002\t\n¨\u0006\u000b"}, d2 = {"Lcom/android/settings/wifi/main/ModularWifiListSetupAdapter$Companion$ViewType;", "", "type", "", "(I)V", "getType", "()I", "AccessPointInfo", "Title", "Lcom/android/settings/wifi/main/ModularWifiListSetupAdapter$Companion$ViewType$AccessPointInfo;", "Lcom/android/settings/wifi/main/ModularWifiListSetupAdapter$Companion$ViewType$Title;", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static abstract class ViewType {
            private final int type;

            /* JADX INFO: compiled from: ModularWifiListSetupAdapter.kt */
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/android/settings/wifi/main/ModularWifiListSetupAdapter$Companion$ViewType$AccessPointInfo;", "Lcom/android/settings/wifi/main/ModularWifiListSetupAdapter$Companion$ViewType;", "()V", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
            public static final class AccessPointInfo extends ViewType {
                public static final AccessPointInfo INSTANCE = null;

                static {
                    INSTANCE = new AccessPointInfo();
                }

                private AccessPointInfo() {
                    super(0, null);
                }
            }

            /* JADX INFO: compiled from: ModularWifiListSetupAdapter.kt */
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/android/settings/wifi/main/ModularWifiListSetupAdapter$Companion$ViewType$Title;", "Lcom/android/settings/wifi/main/ModularWifiListSetupAdapter$Companion$ViewType;", "()V", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
            public static final class Title extends ViewType {
                public static final Title INSTANCE = null;

                static {
                    INSTANCE = new Title();
                }

                private Title() {
                    super(1, null);
                }
            }

            public /* synthetic */ ViewType(int r1, DefaultConstructorMarker r2) {
                this(r1);
            }

            private ViewType(int r1) {
                this.type = r1;
            }

            public final int getType() {
                return this.type;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final int getTYPE_TITLE() {
            return ModularWifiListSetupAdapter.access$getTYPE_TITLE$cp();
        }

        public final int getTYPE_TITLE_NORMAL() {
            return ModularWifiListSetupAdapter.access$getTYPE_TITLE_NORMAL$cp();
        }

        public final int getTYPE_TITLE_OTHER_NETWORK() {
            return ModularWifiListSetupAdapter.access$getTYPE_TITLE_OTHER_NETWORK$cp();
        }
    }

    /* JADX INFO: compiled from: ModularWifiListSetupAdapter.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/android/settings/wifi/main/ModularWifiListSetupAdapter$CustomViewHolder;", "Lcom/android/settings/wifi/main/WifiListSetupAdapter$CustomViewHolder;", "view", "Landroid/view/View;", "viewType", "", "(Landroid/view/View;I)V", "titleView", "Lcom/android/settings/wifi/main/TitleView;", "getTitleView", "()Lcom/android/settings/wifi/main/TitleView;", "setTitleView", "(Lcom/android/settings/wifi/main/TitleView;)V", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class CustomViewHolder extends WifiListSetupAdapter.CustomViewHolder {
        private TitleView titleView;

        public CustomViewHolder(View r3, int r4) {
            Intrinsics.checkNotNullParameter(r3, "view");
            super(r3, r4);
            if (r4 != ModularWifiListSetupAdapter.access$getTYPE_HEADER$cp()) goto L6;
            setHeaderView(r3);
            return;
        L6:
            if (r4 != ModularWifiListSetupAdapter.access$getTYPE_FOOTER$cp()) goto L8;
            setFooterView(r3);
            return;
        L8:
            AccessPointView r1 = null;
            TitleView r2 = null;
            if (r4 != ModularWifiListSetupAdapter.Companion.getTYPE_TITLE()) goto L15;
            if ((r3 instanceof TitleView) == false) goto L13;
            r2 = (TitleView) r3;
        L13:
            this.titleView = r2;
            return;
        L15:
            if ((r3 instanceof AccessPointView) == false) goto L17;
            r1 = (AccessPointView) r3;
        L17:
            setAccessPointView(r1);
        }

        public final TitleView getTitleView() {
            return this.titleView;
        }

        public final void setTitleView(TitleView r1) {
            this.titleView = r1;
        }
    }

    /* JADX INFO: renamed from: com.android.settings.wifi.main.ModularWifiListSetupAdapter$initData$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ModularWifiListSetupAdapter.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.android.settings.wifi.main.ModularWifiListSetupAdapter$initData$1", f = "ModularWifiListSetupAdapter.kt", i = {}, l = {85}, m = "invokeSuspend", n = {}, s = {})
    static final class C01571 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ModularWifiListSetupAdapter this$0;

        /* JADX INFO: renamed from: com.android.settings.wifi.main.ModularWifiListSetupAdapter$initData$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: ModularWifiListSetupAdapter.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.android.settings.wifi.main.ModularWifiListSetupAdapter$initData$1$1", f = "ModularWifiListSetupAdapter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C00391 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ List<AccessPointInfo> $accessPoints;
            int label;
            final /* synthetic */ ModularWifiListSetupAdapter this$0;

            /* JADX WARN: Multi-variable type inference failed */
            C00391(ModularWifiListSetupAdapter r1, List<? extends AccessPointInfo> r2, Continuation<? super C00391> r3) {
                this.this$0 = r1;
                this.$accessPoints = r2;
                super(2, r3);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                return new C00391(this.this$0, this.$accessPoints, r3);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return invoke2(r1, r2);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(CoroutineScope r1, Continuation<? super Unit> r2) {
                return ((C00391) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r2) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r2);
                this.this$0.updateData(this.$accessPoints);
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        C01571(ModularWifiListSetupAdapter r1, Continuation<? super C01571> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new C01571(this.this$0, r2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((C01571) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r7);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            List r8 = (List) ModularWifiListSetupAdapter.access$getConstructAccessPointsAction$p(this.this$0).invoke();
            this.label = 1;
            if (BuildersKt.withContext(Dispatchers.getMain(), new C00391(this.this$0, r8, null), this) != r0) goto L12;
            return r0;
        }
    }

    public static /* synthetic */ void $r8$lambda$0Z8rLA0jeeDhMB3ZTHbZ2yBPo5o(ModularWifiListSetupAdapter r0, Companion.AccessPointInfoModular r1, View r2) {
        onBindViewHolder$lambda$12$lambda$11(r0, r1, r2);
    }

    public static final /* synthetic */ Function0 access$getConstructAccessPointsAction$p(ModularWifiListSetupAdapter r0) {
        return r0.constructAccessPointsAction;
    }

    public static final /* synthetic */ int access$getTYPE_FOOTER$cp() {
        return TYPE_FOOTER;
    }

    public static final /* synthetic */ int access$getTYPE_HEADER$cp() {
        return TYPE_HEADER;
    }

    public static final /* synthetic */ int access$getTYPE_TITLE$cp() {
        return TYPE_TITLE;
    }

    public static final /* synthetic */ int access$getTYPE_TITLE_NORMAL$cp() {
        return TYPE_TITLE_NORMAL;
    }

    public static final /* synthetic */ int access$getTYPE_TITLE_OTHER_NETWORK$cp() {
        return TYPE_TITLE_OTHER_NETWORK;
    }

    @Override // com.android.settings.wifi.main.WifiListSetupAdapter, com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
        onBindViewHolder((WifiListSetupAdapter.CustomViewHolder) r1, r2);
    }

    @Override // com.android.settings.wifi.main.WifiListSetupAdapter, com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ WifiListSetupAdapter.CustomViewHolder onCreateViewHolder(ViewGroup r1, int r2) {
        return onCreateViewHolder(r1, r2);
    }

    @Override // com.android.settings.wifi.main.WifiListSetupAdapter, com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r1, int r2) {
        return onCreateViewHolder(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ModularWifiListSetupAdapter(Activity r8, boolean r9, Function0<? extends List<? extends AccessPointInfo>> r10, Function1<? super View, Unit> r11, Function1<? super AccessPointInfo, Unit> r12, Function1<? super View, Unit> r13, Function2<? super View, ? super Boolean, Unit> r14) {
        Intrinsics.checkNotNullParameter(r8, "activity");
        Intrinsics.checkNotNullParameter(r10, "constructAccessPointsAction");
        super(r8, r9, r10, r11, r12, r14);
        this.activity = r8;
        this.isActivateMode = r9;
        this.constructAccessPointsAction = r10;
        this.onBindHeader = r11;
        this.onClickItem = r12;
        this.onBindOtherNetworkTitle = r13;
        this.onBindFooter = r14;
        this.TAG = "ModularWifiListSetupAdapter";
        this.realData = new ArrayList();
        this.headerCount = !r9 ? 1 : 0;
    }

    static {
        Companion = new Companion(null);
        TYPE_FOOTER = 1;
        TYPE_ITEM = 2;
        TYPE_TITLE = 3;
        TYPE_TITLE_OTHER_NETWORK = 1;
    }

    @Override // com.android.settings.wifi.main.WifiListSetupAdapter
    public void initData() {
        if (getMWifiManager().getWifiState() != 3) goto L6;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new C01571(this, null), 3, null);
        return;
    }

    @Override // com.android.settings.wifi.main.WifiListSetupAdapter
    public List<AccessPointInfo> getData() {
        List<Companion.Modular> r3 = this.realData;
        ArrayList r0 = new ArrayList();
        Iterator<T> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        Object r1 = r4.next();
        if ((r1 instanceof Companion.AccessPointInfoModular) == false) goto L4;
        r0.add(r1);
        goto L4
    L8:
        ArrayList r2 = r0;
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator r6 = r2.iterator();
    L10:
        if (r6.hasNext() == false) goto L13;
        r5.add(((Companion.AccessPointInfoModular) r6.next()).getInfo());
        goto L10
    L13:
        return r5;
    }

    @Override // com.android.settings.wifi.main.WifiListSetupAdapter
    public void updateData(List<? extends AccessPointInfo> r2) {
        groupItems(r2, this.realData);
        notifyDataSetChangedCustom();
        List<? extends AccessPointInfo> r3 = r2;
        if (r3 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L12;
        AppMetricsUtils.INSTANCE.durationEventEnd("wifi_switch_on");
        return;
    L12:
        return;
    L5:
        if (r3.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    private final void groupItems(List<? extends AccessPointInfo> r14, List<Companion.Modular> r15) {
        String r0 = this.TAG;
        StringBuilder r1 = new StringBuilder("connectionInfo ");
        WifiInfo r2 = getMWifiManager().getConnectionInfo();
        DefaultConstructorMarker r3 = null;
        if (r2 == null) goto L5;
        String r4 = r2.getSSID();
    L6:
        OLog.d(r0, r1.append(r4).toString());
        String r5 = this.TAG;
        StringBuilder r6 = new StringBuilder("groupItems: ");
        if (r14 == null) goto L9;
        String r7 = CollectionsKt.joinToString$default(r14, null, null, null, 0, null, AnonymousClass1.INSTANCE, 31, null);
    L10:
        OLog.d(r5, r6.append(r7).toString());
        if (r14 == null) goto L43;
        r15.clear();
        final Function1<AccessPointInfo, Boolean> r8 = new ModularWifiListSetupAdapter$groupItems$2$connectedFilter$1(this);
        Function1<AccessPointInfo, Boolean> r13 = new ModularWifiListSetupAdapter$groupItems$2$savedFilter$1(r8);
        ArrayList r9 = new ArrayList();
        ArrayList r10 = new ArrayList();
        Iterator<T> r16 = r14.iterator();
        AccessPointInfo r11 = null;
    L14:
        if (r16.hasNext() == false) goto L22;
        AccessPointInfo r12 = (AccessPointInfo) r16.next();
        if (r8.invoke(r12).booleanValue() == true) goto L17;
        if (r13.invoke(r12).booleanValue() == true) goto L20;
        r10.add(r12);
        goto L14
    L20:
        r9.add(r12);
        goto L14
    L17:
        r11 = r12;
        goto L14
    L22:
        if (r11 == null) goto L25;
        r15.add(new Companion.AccessPointInfoModular(r11));
    L25:
        if ((!r9.isEmpty()) == false) goto L32;
        r15.add(new Companion.TitleModular(ResourceUtils.getString(R.string.save_network), 0, 2, r3));
        ArrayList r17 = r9;
        ArrayList r18 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r17, 10));
        Iterator r19 = r17.iterator();
    L28:
        if (r19.hasNext() == false) goto L30;
        r18.add(new Companion.AccessPointInfoModular((AccessPointInfo) r19.next()));
        goto L28
    L30:
        r15.addAll(r18);
    L32:
        if ((!r10.isEmpty()) == false) goto L39;
        r15.add(new Companion.TitleModular(ResourceUtils.getString(R.string.other_network), TYPE_TITLE_OTHER_NETWORK));
        ArrayList r110 = r10;
        ArrayList r20 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r110, 10));
        Iterator r111 = r110.iterator();
    L35:
        if (r111.hasNext() == false) goto L37;
        r20.add(new Companion.AccessPointInfoModular((AccessPointInfo) r111.next()));
        goto L35
    L37:
        r15.addAll(r20);
    L39:
        if (r9.isEmpty() == true) goto L41;
        return;
    L41:
        if (r10.isEmpty() == false) goto L57;
        r15.add(new Companion.TitleModular(ResourceUtils.getString(R.string.other_network), TYPE_TITLE_OTHER_NETWORK));
        return;
    L57:
        return;
    L43:
        r15.clear();
        r15.add(new Companion.TitleModular(ResourceUtils.getString(R.string.other_network), TYPE_TITLE_OTHER_NETWORK));
        return;
    L9:
        r7 = null;
        goto L10
    L5:
        r4 = null;
        goto L6
    }

    @Override // com.android.settings.wifi.main.WifiListSetupAdapter
    public void tryUpdateConnectedAccessPointRssi() {
        AccessPointInfo r0 = getAccessPointInfo(0);
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getState() != NetworkInfo.DetailedState.CONNECTED) goto L9;
        notifyDataSetChangedCustom();
        return;
    }

    @Override // com.android.settings.wifi.main.WifiListSetupAdapter, com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public CustomViewHolder onCreateViewHolder(ViewGroup r7, int r8) {
        Intrinsics.checkNotNullParameter(r7, "parent");
        if (r8 != TYPE_HEADER) goto L6;
        View r6 = LayoutInflater.from(this.activity).inflate(R.layout.wifi_switch, null);
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type android.widget.RelativeLayout");
        AccessPointView r9 = (RelativeLayout) r6;
    L12:
        Intrinsics.checkNotNull(r9);
        return new CustomViewHolder(r9, r8);
    L6:
        if (r8 != TYPE_FOOTER) goto L9;
        r9 = LayoutInflater.from(this.activity).inflate(R.layout.wifi_settings_bottom_add_network, null);
        goto L12
    L9:
        if (r8 != TYPE_TITLE) goto L11;
        r9 = new TitleView(this.activity, null, 0, 6, null);
        goto L12
    L11:
        AccessPointView r10 = new AccessPointView(this.activity);
        r10.setClipChildren(false);
        r10.setClipToPadding(false);
        r10.setGravity(1);
        r9 = r10;
        goto L12
    }

    @Override // com.android.settings.wifi.main.WifiListSetupAdapter, com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int r4) {
        int r0 = this.headerCount;
        int r1 = r4 - r0;
        if (r4 >= r0) goto L6;
        return TYPE_HEADER;
    L6:
        if (r4 < (r0 + this.realData.size())) goto L9;
        return TYPE_FOOTER;
    L9:
        if ((((Companion.Modular) CollectionsKt.getOrNull(this.realData, r1)) instanceof Companion.TitleModular) == false) goto L12;
        return TYPE_TITLE;
    L12:
        return TYPE_ITEM;
    }

    private final int checkItemPosition(int r6, int r7) {
        if (r6 == 0) goto L5;
        int r1 = getItemViewType(r6);
        int r2 = TYPE_FOOTER;
        if (r1 == r2) goto L32;
        int r3 = getItemViewType(r6 - 1);
        int r5 = getItemViewType(r6 + 1);
        int r8 = TYPE_TITLE;
        if (r3 != r8) goto L17;
    L26:
        if (r5 != r8) goto L29;
        return 0;
    L29:
        return 1;
    L17:
        if (r3 == TYPE_HEADER) goto L26;
        int r9 = TYPE_ITEM;
        if (r3 == r9) goto L22;
        return 0;
    L22:
        if (r5 == r9) goto L35;
        if (r5 != r2) goto L32;
        return 2;
    L35:
        return 2;
    L32:
        return 3;
    L5:
        if (this.realData.size() <= 1) goto L30;
        int r10 = getItemViewType(1);
        if (r10 != TYPE_FOOTER) goto L9;
        return 0;
    L9:
        if (r10 != TYPE_TITLE) goto L29;
        return 0;
    L30:
        return 0;
    }

    @Override // com.android.settings.wifi.main.WifiListSetupAdapter, com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return (this.realData.size() + this.headerCount) + 1;
    }

    @Override // com.android.settings.wifi.main.WifiListSetupAdapter
    public void onBindViewHolder(WifiListSetupAdapter.CustomViewHolder r8, int r9) {
        Intrinsics.checkNotNullParameter(r8, "holderModular");
        int r5 = r9 - this.headerCount;
        CustomViewHolder r10 = (CustomViewHolder) r8;
        int r0 = r10.getItemViewType();
        if (r0 != TYPE_HEADER) goto L10;
        View r11 = r10.getHeaderView();
        if (r11 == null) goto L44;
        Function1<View, Unit> r7 = this.onBindHeader;
        if (r7 == null) goto L45;
        r7.invoke(r11);
        return;
    L45:
        return;
    L44:
        return;
    L10:
        if (r0 != TYPE_FOOTER) goto L17;
        View r12 = r10.getFooterView();
        if (r12 == null) goto L47;
        Function2<View, Boolean, Unit> r13 = this.onBindFooter;
        if (r13 == null) goto L48;
        r13.invoke(r12, Boolean.valueOf(!getData().isEmpty()));
        return;
    L48:
        return;
    L47:
        return;
    L17:
        if (r0 != TYPE_TITLE) goto L35;
        Object r14 = CollectionsKt.getOrNull(this.realData, r5);
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type com.android.settings.wifi.main.ModularWifiListSetupAdapter.Companion.TitleModular");
        Companion.TitleModular r15 = (Companion.TitleModular) r14;
        TitleView r1 = r10.getTitleView();
        if (r1 == null) goto L22;
        r1.setTitle(r15.getTitle());
    L22:
        if (r15.getType() != TYPE_TITLE_OTHER_NETWORK) goto L50;
        TitleView r16 = r10.getTitleView();
        if (r16 == null) goto L51;
        Function1<View, Unit> r17 = this.onBindOtherNetworkTitle;
        if (r17 == null) goto L28;
        r17.invoke(r16);
    L28:
        int r18 = getMWifiManager().getWifiState();
        if (r18 != 2) goto L31;
    L33:
        int r19 = 0;
    L34:
        r16.setVisibility(r19);
        return;
    L31:
        if (r18 == 3) goto L33;
        r19 = 8;
        goto L34
    L51:
        return;
    L50:
        return;
    L35:
        AccessPointView r20 = r10.getAccessPointView();
        if (r20 == null) goto L53;
        Object r2 = CollectionsKt.getOrNull(this.realData, r5);
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.android.settings.wifi.main.ModularWifiListSetupAdapter.Companion.AccessPointInfoModular");
        final Companion.AccessPointInfoModular r3 = (Companion.AccessPointInfoModular) r2;
        r20.bindData(getMWifiManager(), this.isActivateMode, r3.getInfo(), r5, checkItemPosition(r9, r5));
        View r21 = r20.getItemContainer();
        if ((r21 instanceof OCardListItem) == false) goto L40;
        OCardListItem r22 = (OCardListItem) r21;
    L41:
        if (r22 == null) goto L54;
        r22.setOnContentClickListener(new ModularWifiListSetupAdapter$$ExternalSyntheticLambda0(this, r3));
        return;
    L54:
        return;
    L40:
        r22 = null;
        goto L41
    }

    private static final void onBindViewHolder$lambda$12$lambda$11(ModularWifiListSetupAdapter r0, Companion.AccessPointInfoModular r1, View r2) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        Intrinsics.checkNotNullParameter(r1, "$item");
        Function1<AccessPointInfo, Unit> r3 = r0.onClickItem;
        if (r3 == null) goto L6;
        r3.invoke(r1.getInfo());
        return;
    }
}
