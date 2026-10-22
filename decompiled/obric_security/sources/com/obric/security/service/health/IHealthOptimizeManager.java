package com.obric.security.service.health;

import android.content.Context;
import android.os.Bundle;
import com.obric.security.health.model.HealthModulePresentation;
import com.obric.security.health.model.HealthScoreSnapshot;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: compiled from: IHealthOptimizeManager.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\u001cJ\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016J\b\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\fH&J\b\u0010\u000e\u001a\u00020\fH&J\b\u0010\u000f\u001a\u00020\fH&J\u0012\u0010\u0010\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H&J&\u0010\u0013\u001a\u00020\f2\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00152\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018H&J\u001a\u0010\u0019\u001a\u00020\f2\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015H&J\b\u0010\u001a\u001a\u00020\fH\u0016J\b\u0010\u001b\u001a\u00020\fH&¨\u0006\u001d"}, d2 = {"Lcom/obric/security/service/health/IHealthOptimizeManager;", "", "getHealthSnapshot", "Lcom/obric/security/health/model/HealthScoreSnapshot;", "getScoreSnapshot", "Landroid/os/Bundle;", "getTrashTotalSize", "", "getVisibleModulePresentations", "", "Lcom/obric/security/health/model/HealthModulePresentation;", "onCreate", "", "onDestroy", "pause", "resume", "setCallback", "callback", "Lcom/obric/security/service/health/IHealthOptimizeManager$Callback;", "startOptimize", "itemIds", "", "", "runtimeContext", "Landroid/content/Context;", "startScan", "stopOptimize", "stopScan", "Callback", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public interface IHealthOptimizeManager {

    /* JADX INFO: compiled from: IHealthOptimizeManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J<\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\r\u001a\u00020\u000eH&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J<\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\r\u001a\u00020\u000eH&¨\u0006\u0011"}, d2 = {"Lcom/obric/security/service/health/IHealthOptimizeManager$Callback;", "", "onOptimizeFinish", "", "scoreSnapshot", "Landroid/os/Bundle;", "onOptimizeProgress", "progress", "", "currentItemTitle", "", "currentItemId", "currentModuleId", "taskPassed", "", "onScanFinish", "onScanProgress", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public interface Callback {

        /* JADX INFO: compiled from: IHealthOptimizeManager.kt */
        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
        public static final class DefaultImpls {
            public static /* synthetic */ void onScanProgress$default(Callback r7, int r8, String r9, String r10, String r11, boolean r12, int r13, Object r14) {
                if (r14 != null) goto L17;
                if ((r13 & 4) == 0) goto L6;
                String r15 = (String) null;
                String r4 = null;
            L8:
                if ((r13 & 8) == 0) goto L10;
                String r16 = (String) null;
                String r5 = null;
            L12:
                if ((r13 & 16) == 0) goto L14;
                r12 = false;
            L14:
                r7.onScanProgress(r8, r9, r4, r5, r12);
                return;
            L10:
                r5 = r11;
                goto L12
            L6:
                r4 = r10;
                goto L8
            L17:
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onScanProgress");
            }

            public static /* synthetic */ void onOptimizeProgress$default(Callback r7, int r8, String r9, String r10, String r11, boolean r12, int r13, Object r14) {
                if (r14 != null) goto L17;
                if ((r13 & 4) == 0) goto L6;
                String r15 = (String) null;
                String r4 = null;
            L8:
                if ((r13 & 8) == 0) goto L10;
                String r16 = (String) null;
                String r5 = null;
            L12:
                if ((r13 & 16) == 0) goto L14;
                r12 = false;
            L14:
                r7.onOptimizeProgress(r8, r9, r4, r5, r12);
                return;
            L10:
                r5 = r11;
                goto L12
            L6:
                r4 = r10;
                goto L8
            L17:
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onOptimizeProgress");
            }
        }

        void onOptimizeFinish(Bundle r1);

        void onOptimizeProgress(int r1, String r2, String r3, String r4, boolean r5);

        void onScanFinish(Bundle r1);

        void onScanProgress(int r1, String r2, String r3, String r4, boolean r5);
    }

    /* JADX INFO: compiled from: IHealthOptimizeManager.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static HealthScoreSnapshot getHealthSnapshot(IHealthOptimizeManager r0) {
            return null;
        }

        public static long getTrashTotalSize(IHealthOptimizeManager r2) {
            return 0;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void startScan$default(IHealthOptimizeManager r0, Set r1, int r2, Object r3) {
            if (r3 != null) goto L9;
            if ((r2 & 1) == 0) goto L6;
            r1 = null;
            Set r4 = (Set) null;
        L6:
            r0.startScan(r1);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startScan");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void startOptimize$default(IHealthOptimizeManager r1, Set r2, Context r3, int r4, Object r5) {
            if (r5 != null) goto L12;
            if ((r4 & 1) == 0) goto L7;
            Set r6 = (Set) null;
            r2 = null;
        L7:
            if ((r4 & 2) == 0) goto L9;
            Context r7 = (Context) null;
            r3 = null;
        L9:
            r1.startOptimize(r2, r3);
            return;
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startOptimize");
        }

        public static void stopOptimize(IHealthOptimizeManager r0) {
            r0.stopScan();
        }

        public static List<HealthModulePresentation> getVisibleModulePresentations(IHealthOptimizeManager r0) {
            return CollectionsKt.emptyList();
        }
    }

    HealthScoreSnapshot getHealthSnapshot();

    Bundle getScoreSnapshot();

    long getTrashTotalSize();

    List<HealthModulePresentation> getVisibleModulePresentations();

    void onCreate();

    void onDestroy();

    void pause();

    void resume();

    void setCallback(Callback r1);

    void startOptimize(Set<String> r1, Context r2);

    void startScan(Set<String> r1);

    void stopOptimize();

    void stopScan();
}
