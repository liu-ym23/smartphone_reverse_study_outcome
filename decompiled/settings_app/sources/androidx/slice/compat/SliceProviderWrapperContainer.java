package androidx.slice.compat;

import android.app.slice.Slice;
import android.app.slice.SliceProvider;
import android.app.slice.SliceSpec;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.util.Log;
import androidx.slice.SliceConvert;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.privacy.GrantUtil;
import java.util.Collection;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class SliceProviderWrapperContainer {

    public static class SliceProviderWrapper extends SliceProvider {
        private static final String TAG = "SliceProviderWrapper";
        private androidx.slice.SliceProvider mSliceProvider;

        public void androidx_slice_compat_SliceProviderWrapperContainer$SliceProviderWrapper__onCreate$___twin___() {
            super.onCreate();
        }

        @Override // android.content.ContentProvider
        public void onCreate() {
            androidx_slice_compat_SliceProviderWrapperContainer$SliceProviderWrapper_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Provider(this);
        }

        @Override // android.content.ContentProvider
        public boolean onCreate() {
            return true;
        }

        public SliceProviderWrapper(androidx.slice.SliceProvider r1, String[] r2) {
            super(r2);
            this.mSliceProvider = r1;
        }

        @Override // android.app.slice.SliceProvider, android.content.ContentProvider
        public void attachInfo(Context r2, ProviderInfo r3) {
            this.mSliceProvider.attachInfo(r2, r3);
            super.attachInfo(r2, r3);
        }

        @Override // android.app.slice.SliceProvider
        public Slice onBindSlice(Uri r4, Set<SliceSpec> r5) {
            androidx.slice.SliceProvider.setSpecs(SliceConvert.wrap(r5));
            Slice r3 = SliceConvert.unwrap(this.mSliceProvider.onBindSlice(r4));     // Catch: Throwable -> L6 Exception -> L8
            androidx.slice.SliceProvider.setSpecs(null);
            return r3;
        L8:
            e = move-exception;
            Log.wtf(TAG, "Slice with URI " + r4.toString() + " is invalid.", e);     // Catch: Throwable -> L6
            androidx.slice.SliceProvider.setSpecs(null);
            return null;
        L6:
            th = move-exception;
            androidx.slice.SliceProvider.setSpecs(null);
            throw th;
        }

        @Override // android.app.slice.SliceProvider
        public void onSlicePinned(Uri r2) {
            this.mSliceProvider.onSlicePinned(r2);
            this.mSliceProvider.handleSlicePinned(r2);
        }

        @Override // android.app.slice.SliceProvider
        public void onSliceUnpinned(Uri r2) {
            this.mSliceProvider.onSliceUnpinned(r2);
            this.mSliceProvider.handleSliceUnpinned(r2);
        }

        @Override // android.app.slice.SliceProvider
        public Collection<Uri> onGetSliceDescendants(Uri r1) {
            return this.mSliceProvider.onGetSliceDescendants(r1);
        }

        @Override // android.app.slice.SliceProvider
        public Uri onMapIntentToUri(Intent r1) {
            return this.mSliceProvider.onMapIntentToUri(r1);
        }

        @TargetClass(scope = Scope.LEAF, value = "android.content.ContentProvider")
        @Insert(mayCreateSuper = true, value = "onCreate")
        public static void androidx_slice_compat_SliceProviderWrapperContainer$SliceProviderWrapper_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Provider(SliceProviderWrapper r2) {
            String r0 = r2.getClass().getName();
            r2.androidx_slice_compat_SliceProviderWrapperContainer$SliceProviderWrapper__onCreate$___twin___();
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.reportColdStartProvider(r0);
        L5:
            AppMetricsUtils.INSTANCE.setColdStartTime(0);
        }
    }

    private SliceProviderWrapperContainer() {
    }
}
