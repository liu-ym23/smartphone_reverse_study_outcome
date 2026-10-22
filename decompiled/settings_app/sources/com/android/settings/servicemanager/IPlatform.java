package com.android.settings.servicemanager;

import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.android.settings.inputmethod.LanguageOption;
import com.bytedance.news.common.service.manager.IService;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import obric.api.WifiManagerSmt;

/* JADX INFO: compiled from: IPlatform.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016J\u001e\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016¨\u0006\u0011"}, d2 = {"Lcom/android/settings/servicemanager/IPlatform;", "Lcom/bytedance/news/common/service/manager/IService;", "isCurrentLanguage", "", "info", "Lcom/android/settings/inputmethod/LanguageOption$LocaleInfo;", "isGoogleLawEnable", "isGoogleResetEnable", "isPrintEnable", "isShowConnectedApList", "isShowNubiaShare", "readConfiguredNetworkKey", "", "manager", "Landroid/net/wifi/WifiManager;", "wifiConfig", "Landroid/net/wifi/WifiConfiguration;", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface IPlatform extends IService {

    /* JADX INFO: compiled from: IPlatform.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static boolean isGoogleLawEnable(IPlatform r0) {
            return false;
        }

        public static boolean isGoogleResetEnable(IPlatform r0) {
            return false;
        }

        public static boolean isPrintEnable(IPlatform r0) {
            return false;
        }

        public static boolean isShowConnectedApList(IPlatform r0) {
            return true;
        }

        public static boolean isShowNubiaShare(IPlatform r0) {
            return true;
        }

        public static String readConfiguredNetworkKey(IPlatform r0, WifiManager r1, WifiConfiguration r2) {
            return WifiManagerSmt.getInstance().readConfiguredNetworkKey(r1, r2);
        }

        public static boolean isCurrentLanguage(IPlatform r0, LanguageOption.LocaleInfo r1) {
            Intrinsics.checkNotNullParameter(r1, "info");
            String r2 = Locale.getDefault().getDisplayName();
            return TextUtils.equals(r1.getLocale().getDisplayName(), r2);
        }
    }

    boolean isCurrentLanguage(LanguageOption.LocaleInfo r1);

    boolean isGoogleLawEnable();

    boolean isGoogleResetEnable();

    boolean isPrintEnable();

    boolean isShowConnectedApList();

    boolean isShowNubiaShare();

    String readConfiguredNetworkKey(WifiManager r1, WifiConfiguration r2);
}
