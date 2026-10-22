package androidx.emoji2.text;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.provider.FontRequest;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class DefaultEmojiCompatConfig {

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static class DefaultEmojiCompatConfigFactory {

        @NonNull
        private static final String DEFAULT_EMOJI_QUERY = "emojicompat-emoji-font";

        @NonNull
        private static final String INTENT_LOAD_EMOJI_FONT = "androidx.content.action.LOAD_EMOJI_FONT";

        @NonNull
        private static final String TAG = "emoji2.text.DefaultEmojiConfig";
        private final DefaultEmojiCompatConfigHelper mHelper;

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public DefaultEmojiCompatConfigFactory(@Nullable DefaultEmojiCompatConfigHelper r1) {
            if (r1 != null) goto L6;
            r1 = getHelperForApi();
        L6:
            this.mHelper = r1;
        }

        @Nullable
        private EmojiCompat.Config configOrNull(@NonNull Context r1, @Nullable FontRequest r2) {
            if (r2 != null) goto L6;
            return null;
        L6:
            return new FontRequestEmojiCompatConfig(r1, r2);
        }

        @NonNull
        private List<List<byte[]>> convertToByteArray(@NonNull Signature[] r4) {
            ArrayList r3 = new ArrayList();
            int r0 = r4.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L6;
            r3.add(r4[r1].toByteArray());
            r1 = r1 + 1;
            goto L3
        L6:
            return Collections.singletonList(r3);
        }

        @NonNull
        private FontRequest generateFontRequestFrom(@NonNull ProviderInfo r3, @NonNull PackageManager r4) {
            String r0 = r3.authority;
            String r5 = r3.packageName;
            return new FontRequest(r0, r5, DEFAULT_EMOJI_QUERY, convertToByteArray(this.mHelper.getSigningSignatures(r4, r5)));
        }

        @NonNull
        private static DefaultEmojiCompatConfigHelper getHelperForApi() {
            int r0 = Build.VERSION.SDK_INT;
            if (r0 < 28) goto L7;
            return new DefaultEmojiCompatConfigHelper_API28();
        L7:
            if (r0 < 19) goto L11;
            return new DefaultEmojiCompatConfigHelper_API19();
        L11:
            return new DefaultEmojiCompatConfigHelper();
        }

        private boolean hasFlagSystem(@Nullable ProviderInfo r1) {
            if (r1 == null) goto L9;
            ApplicationInfo r2 = r1.applicationInfo;
            if (r2 == null) goto L9;
            if ((r2.flags & 1) != 1) goto L9;
            return true;
        L9:
            return false;
        }

        @Nullable
        private ProviderInfo queryDefaultInstalledContentProvider(@NonNull PackageManager r4) {
            Iterator<ResolveInfo> r5 = this.mHelper.queryIntentContentProviders(r4, new Intent(INTENT_LOAD_EMOJI_FONT), 0).iterator();
        L4:
            if (r5.hasNext() == false) goto L8;
            ResolveInfo r0 = r5.next();
            ProviderInfo r1 = this.mHelper.getProviderInfo(r0);
            if (hasFlagSystem(r1) == false) goto L4;
            return r1;
        L8:
            return null;
        }

        @Nullable
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public EmojiCompat.Config create(@NonNull Context r2) {
            return configOrNull(r2, queryForDefaultFontRequest(r2));
        }

        @Nullable
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        @VisibleForTesting
        FontRequest queryForDefaultFontRequest(@NonNull Context r3) {
            PackageManager r4 = r3.getPackageManager();
            Preconditions.checkNotNull(r4, "Package manager required to locate emoji font provider");
            ProviderInfo r0 = queryDefaultInstalledContentProvider(r4);
            if (r0 != null) goto L10;
            return null;
        L10:
            return generateFontRequestFrom(r0, r4);
        L7:
            e = move-exception;
            Log.wtf(TAG, e);
            return null;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static class DefaultEmojiCompatConfigHelper {
        public DefaultEmojiCompatConfigHelper() {
        }

        @Nullable
        public ProviderInfo getProviderInfo(@NonNull ResolveInfo r1) {
            throw new IllegalStateException("Unable to get provider info prior to API 19");
        }

        @NonNull
        public Signature[] getSigningSignatures(@NonNull PackageManager r1, @NonNull String r2) {
            return r1.getPackageInfo(r2, 64).signatures;
        }

        @NonNull
        public List<ResolveInfo> queryIntentContentProviders(@NonNull PackageManager r1, @NonNull Intent r2, int r3) {
            return Collections.emptyList();
        }
    }

    @RequiresApi(19)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static class DefaultEmojiCompatConfigHelper_API19 extends DefaultEmojiCompatConfigHelper {
        public DefaultEmojiCompatConfigHelper_API19() {
        }

        @Override // androidx.emoji2.text.DefaultEmojiCompatConfig.DefaultEmojiCompatConfigHelper
        @Nullable
        public ProviderInfo getProviderInfo(@NonNull ResolveInfo r1) {
            return r1.providerInfo;
        }

        @Override // androidx.emoji2.text.DefaultEmojiCompatConfig.DefaultEmojiCompatConfigHelper
        @NonNull
        public List<ResolveInfo> queryIntentContentProviders(@NonNull PackageManager r1, @NonNull Intent r2, int r3) {
            return r1.queryIntentContentProviders(r2, r3);
        }
    }

    @RequiresApi(28)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static class DefaultEmojiCompatConfigHelper_API28 extends DefaultEmojiCompatConfigHelper_API19 {
        public DefaultEmojiCompatConfigHelper_API28() {
        }

        @Override // androidx.emoji2.text.DefaultEmojiCompatConfig.DefaultEmojiCompatConfigHelper
        @NonNull
        public Signature[] getSigningSignatures(@NonNull PackageManager r1, @NonNull String r2) {
            return r1.getPackageInfo(r2, 64).signatures;
        }
    }

    private DefaultEmojiCompatConfig() {
    }

    @Nullable
    public static FontRequestEmojiCompatConfig create(@NonNull Context r2) {
        return (FontRequestEmojiCompatConfig) new DefaultEmojiCompatConfigFactory(null).create(r2);
    }
}
