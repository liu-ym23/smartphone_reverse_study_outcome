package com.android.settings.servicemanager;

import kotlin.Metadata;

/* JADX INFO: compiled from: IGoogleHelp.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, d2 = {"Lcom/android/settings/servicemanager/IGoogleHelp;", "", "isShowGoogleGms", "", "isShowGoogleWellbeing", "isShowLocationServices", "isShowNearbySharingBtn", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface IGoogleHelp {

    /* JADX INFO: compiled from: IGoogleHelp.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static boolean isShowGoogleGms(IGoogleHelp r0) {
            return false;
        }

        public static boolean isShowGoogleWellbeing(IGoogleHelp r0) {
            return false;
        }

        public static boolean isShowLocationServices(IGoogleHelp r0) {
            return false;
        }

        public static boolean isShowNearbySharingBtn(IGoogleHelp r0) {
            return false;
        }
    }

    boolean isShowGoogleGms();

    boolean isShowGoogleWellbeing();

    boolean isShowLocationServices();

    boolean isShowNearbySharingBtn();
}
