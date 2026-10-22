package com.android.settings.wifi.main;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.util.BoostFramework;
import android.view.View;
import android.view.ViewGroup;
import com.android.settings.R;
import com.android.settings.utils.ResourceUtils;
import com.android.settings.wifi.AccessPointInfo;
import com.android.settings.wifi.AccessPointView;
import com.obric.olog.OLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ModularWifiListAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0004'()*B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t¢\u0006\u0002\u0010\fJ\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0018\u001a\u00020\u0014H\u0016J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J$\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010!\u001a\u00020\u0014H\u0016J&\u0010\"\u001a\u00020#2\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J\u0018\u0010&\u001a\u00020#2\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u0016R\u000e\u0010\r\u001a\u00020\u000eX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/android/settings/wifi/main/ModularWifiListAdapter;", "Lcom/android/settings/wifi/main/WifiListAdapter;", "context", "Landroid/content/Context;", "isActivateMode", "", "mPerf", "Landroid/util/BoostFramework;", "constructAccessPointsAction", "Lkotlin/Function0;", "", "Lcom/android/settings/wifi/AccessPointInfo;", "(Landroid/content/Context;ZLandroid/util/BoostFramework;Lkotlin/jvm/functions/Function0;)V", "TAG", "", "realData", "", "Lcom/android/settings/wifi/main/ModularWifiListAdapter$Modular;", "getAccessPointInfo", "position", "", "getCount", "getData", "getItem", "pos", "getItemId", "", "getItemViewType", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "getViewTypeCount", "groupItems", "", "accessPoints", "data", "updateData", "AccessPointInfoModular", "Modular", "TitleModular", "ViewType", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ModularWifiListAdapter extends WifiListAdapter {
    private final String TAG;
    private final Context context;
    private final boolean isActivateMode;
    private final List<Modular> realData;

    /* JADX INFO: compiled from: ModularWifiListAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/android/settings/wifi/main/ModularWifiListAdapter$AccessPointInfoModular;", "Lcom/android/settings/wifi/main/ModularWifiListAdapter$Modular;", "info", "Lcom/android/settings/wifi/AccessPointInfo;", "(Lcom/android/settings/wifi/AccessPointInfo;)V", "getInfo", "()Lcom/android/settings/wifi/AccessPointInfo;", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

    /* JADX INFO: compiled from: ModularWifiListAdapter.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/android/settings/wifi/main/ModularWifiListAdapter$Modular;", "", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface Modular {
    }

    /* JADX INFO: compiled from: ModularWifiListAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/android/settings/wifi/main/ModularWifiListAdapter$TitleModular;", "Lcom/android/settings/wifi/main/ModularWifiListAdapter$Modular;", "title", "", "(Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class TitleModular implements Modular {
        private final String title;

        public TitleModular(String r2) {
            Intrinsics.checkNotNullParameter(r2, "title");
            this.title = r2;
        }

        public final String getTitle() {
            return this.title;
        }
    }

    /* JADX INFO: compiled from: ModularWifiListAdapter.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0007\bB\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0002\t\n¨\u0006\u000b"}, d2 = {"Lcom/android/settings/wifi/main/ModularWifiListAdapter$ViewType;", "", "type", "", "(I)V", "getType", "()I", "AccessPointInfo", "Title", "Lcom/android/settings/wifi/main/ModularWifiListAdapter$ViewType$AccessPointInfo;", "Lcom/android/settings/wifi/main/ModularWifiListAdapter$ViewType$Title;", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class ViewType {
        private final int type;

        /* JADX INFO: compiled from: ModularWifiListAdapter.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/android/settings/wifi/main/ModularWifiListAdapter$ViewType$AccessPointInfo;", "Lcom/android/settings/wifi/main/ModularWifiListAdapter$ViewType;", "()V", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class AccessPointInfo extends ViewType {
            public static final AccessPointInfo INSTANCE = null;

            static {
                INSTANCE = new AccessPointInfo();
            }

            private AccessPointInfo() {
                super(0, null);
            }
        }

        /* JADX INFO: compiled from: ModularWifiListAdapter.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/android/settings/wifi/main/ModularWifiListAdapter$ViewType$Title;", "Lcom/android/settings/wifi/main/ModularWifiListAdapter$ViewType;", "()V", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

    @Override // com.android.settings.SettingsAdapter, android.widget.Adapter
    public long getItemId(int r1) {
        return r1;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // com.android.settings.wifi.main.WifiListAdapter, com.android.settings.SettingsAdapter, android.widget.Adapter
    public /* bridge */ /* synthetic */ Object getItem(int r1) {
        return getItem(r1);
    }

    public ModularWifiListAdapter(Context r2, boolean r3, BoostFramework r4, Function0<? extends List<? extends AccessPointInfo>> r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r5, "constructAccessPointsAction");
        super(r2, r3, r4, r5);
        this.context = r2;
        this.isActivateMode = r3;
        this.TAG = "ModularWifiListAdapter";
        this.realData = new ArrayList();
    }

    @Override // com.android.settings.wifi.main.WifiListAdapter, com.android.settings.SettingsAdapter, android.widget.Adapter
    public int getCount() {
        return this.realData.size();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int r1) {
        if ((this.realData.get(r1) instanceof TitleModular) == false) goto L6;
        return ViewType.Title.INSTANCE.getType();
    L6:
        return ViewType.AccessPointInfo.INSTANCE.getType();
    }

    @Override // com.android.settings.wifi.main.WifiListAdapter, com.android.settings.SettingsAdapter, android.widget.Adapter
    public View getView(int r9, View r10, ViewGroup r11) {
        AccessPointView r1 = null;
        TitleView r2 = null;
        if (getItemViewType(r9) != ViewType.Title.INSTANCE.getType()) goto L10;
        Modular r12 = getItem(r9);
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type com.android.settings.wifi.main.ModularWifiListAdapter.TitleModular");
        TitleModular r13 = (TitleModular) r12;
        if ((r10 instanceof TitleView) == false) goto L7;
        r2 = (TitleView) r10;
    L7:
        if (r2 != null) goto L9;
        r2 = new TitleView(this.context, null, 0, 6, null);
    L9:
        r2.setTitle(r13.getTitle());
        return r2;
    L10:
        Modular r14 = getItem(r9);
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type com.android.settings.wifi.main.ModularWifiListAdapter.AccessPointInfoModular");
        AccessPointInfoModular r15 = (AccessPointInfoModular) r14;
        if ((r10 instanceof AccessPointView) == false) goto L13;
        r1 = (AccessPointView) r10;
    L13:
        if (r1 != null) goto L15;
        r1 = new AccessPointView(this.context);
    L15:
        r1.bindData(r15.getInfo(), r9, this.isActivateMode);
        return r1;
    }

    @Override // com.android.settings.wifi.main.WifiListAdapter
    public void updateData(List<? extends AccessPointInfo> r2) {
        groupItems(r2, this.realData);
        notifyDataSetChanged();
    }

    @Override // com.android.settings.wifi.main.WifiListAdapter, com.android.settings.SettingsAdapter, android.widget.Adapter
    public Modular getItem(int r1) {
        return (Modular) CollectionsKt.getOrNull(this.realData, r1);
    }

    @Override // com.android.settings.wifi.main.WifiListAdapter
    public List<AccessPointInfo> getData() {
        List<Modular> r3 = this.realData;
        ArrayList r0 = new ArrayList();
        Iterator<T> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        Object r1 = r4.next();
        if ((r1 instanceof AccessPointInfoModular) == false) goto L4;
        r0.add(r1);
        goto L4
    L8:
        ArrayList r2 = r0;
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator r6 = r2.iterator();
    L10:
        if (r6.hasNext() == false) goto L13;
        r5.add(((AccessPointInfoModular) r6.next()).getInfo());
        goto L10
    L13:
        return r5;
    }

    @Override // com.android.settings.wifi.main.WifiListAdapter
    public AccessPointInfo getAccessPointInfo(int r2) {
        Object r1 = CollectionsKt.getOrNull(this.realData, r2);
        if ((r1 instanceof AccessPointInfoModular) == false) goto L5;
        AccessPointInfoModular r3 = (AccessPointInfoModular) r1;
    L6:
        if (r3 != null) goto L8;
        return null;
    L8:
        return r3.getInfo();
    L5:
        r3 = null;
        goto L6
    }

    private final void groupItems(List<? extends AccessPointInfo> r14, List<Modular> r15) {
        String r0 = this.TAG;
        StringBuilder r1 = new StringBuilder("connectionInfo ");
        WifiInfo r2 = getMWifiManager().getConnectionInfo();
        Unit r3 = null;
        AccessPointInfo r4 = null;
        if (r2 == null) goto L5;
        String r5 = r2.getSSID();
    L6:
        OLog.d(r0, r1.append(r5).toString());
        String r6 = this.TAG;
        StringBuilder r7 = new StringBuilder("groupItems: ");
        if (r14 == null) goto L9;
        String r8 = CollectionsKt.joinToString$default(r14, null, null, null, 0, null, AnonymousClass1.INSTANCE, 31, null);
    L10:
        OLog.d(r6, r7.append(r8).toString());
        if (r14 == null) goto L39;
        r15.clear();
        final Function1<AccessPointInfo, Boolean> r9 = new ModularWifiListAdapter$groupItems$2$connectedFilter$1(this);
        Function1<AccessPointInfo, Boolean> r10 = new ModularWifiListAdapter$groupItems$2$savedFilter$1(r9);
        ArrayList r11 = new ArrayList();
        ArrayList r12 = new ArrayList();
        Iterator<T> r16 = r14.iterator();
    L14:
        if (r16.hasNext() == false) goto L22;
        AccessPointInfo r13 = (AccessPointInfo) r16.next();
        if (r9.invoke(r13).booleanValue() == true) goto L17;
        if (r10.invoke(r13).booleanValue() == true) goto L20;
        r12.add(r13);
        goto L14
    L20:
        r11.add(r13);
        goto L14
    L17:
        r4 = r13;
        goto L14
    L22:
        if (r4 == null) goto L25;
        r15.add(new AccessPointInfoModular(r4));
    L25:
        if ((!r11.isEmpty()) == false) goto L32;
        r15.add(new TitleModular(ResourceUtils.getString(R.string.save_network)));
        ArrayList r17 = r11;
        ArrayList r18 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r17, 10));
        Iterator r19 = r17.iterator();
    L28:
        if (r19.hasNext() == false) goto L30;
        r18.add(new AccessPointInfoModular((AccessPointInfo) r19.next()));
        goto L28
    L30:
        r15.addAll(r18);
    L32:
        if ((!r12.isEmpty()) == false) goto L38;
        r15.add(new TitleModular(ResourceUtils.getString(R.string.other_network)));
        ArrayList r20 = r12;
        ArrayList r110 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r20, 10));
        Iterator r21 = r20.iterator();
    L35:
        if (r21.hasNext() == false) goto L37;
        r110.add(new AccessPointInfoModular((AccessPointInfo) r21.next()));
        goto L35
    L37:
        r15.addAll(r110);
    L38:
        r3 = Unit.INSTANCE;
    L39:
        if (r3 != null) goto L53;
        r15.clear();
        return;
    L53:
        return;
    L9:
        r8 = null;
        goto L10
    L5:
        r5 = null;
        goto L6
    }
}
