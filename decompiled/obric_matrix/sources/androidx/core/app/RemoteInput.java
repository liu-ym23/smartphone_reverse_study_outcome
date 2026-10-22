package androidx.core.app;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import com.bytedance.sysoptimizer.BadParcelableCrashOptimizer;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public final class RemoteInput {
    public static final int EDIT_CHOICES_BEFORE_SENDING_AUTO = 0;
    public static final int EDIT_CHOICES_BEFORE_SENDING_DISABLED = 1;
    public static final int EDIT_CHOICES_BEFORE_SENDING_ENABLED = 2;
    private static final String EXTRA_DATA_TYPE_RESULTS_DATA = "android.remoteinput.dataTypeResultsData";
    public static final String EXTRA_RESULTS_DATA = "android.remoteinput.resultsData";
    private static final String EXTRA_RESULTS_SOURCE = "android.remoteinput.resultsSource";
    public static final String RESULTS_CLIP_LABEL = "android.remoteinput.results";
    public static final int SOURCE_CHOICE = 1;
    public static final int SOURCE_FREE_FORM_INPUT = 0;
    private final boolean mAllowFreeFormTextInput;
    private final Set<String> mAllowedDataTypes;
    private final CharSequence[] mChoices;
    private final int mEditChoicesBeforeSending;
    private final Bundle mExtras;
    private final CharSequence mLabel;
    private final String mResultKey;

    @RequiresApi(16)
    static class Api16Impl {
        private Api16Impl() {
        }

        @DoNotInline
        static ClipData getClipData(Intent r0) {
            return r0.getClipData();
        }

        @DoNotInline
        static void setClipData(Intent r0, ClipData r1) {
            r0.setClipData(r1);
        }
    }

    @RequiresApi(20)
    static class Api20Impl {
        private Api20Impl() {
        }

        @DoNotInline
        static void addResultsToIntent(Object r0, Intent r1, Bundle r2) {
            android.app.RemoteInput.addResultsToIntent((android.app.RemoteInput[]) r0, r1, r2);
        }

        public static android.app.RemoteInput fromCompat(RemoteInput r5) {
            int r0 = Build.VERSION.SDK_INT;
            android.app.RemoteInput.Builder r1 = new android.app.RemoteInput.Builder(r5.getResultKey()).setLabel(r5.getLabel()).setChoices(r5.getChoices()).setAllowFreeFormInput(r5.getAllowFreeFormInput()).addExtras(r5.getExtras());
            if (r0 < 26) goto L11;
            Set<String> r2 = r5.getAllowedDataTypes();
            if (r2 == null) goto L11;
            Iterator<String> r3 = r2.iterator();
        L8:
            if (r3.hasNext() == false) goto L11;
            Api26Impl.setAllowDataType(r1, r3.next(), true);
        L11:
            if (r0 < 29) goto L14;
            Api29Impl.setEditChoicesBeforeSending(r1, r5.getEditChoicesBeforeSending());
        L14:
            return r1.build();
        }

        static RemoteInput fromPlatform(Object r5) {
            int r0 = Build.VERSION.SDK_INT;
            android.app.RemoteInput r6 = (android.app.RemoteInput) r5;
            Builder r1 = new Builder(r6.getResultKey()).setLabel(r6.getLabel()).setChoices(r6.getChoices()).setAllowFreeFormInput(r6.getAllowFreeFormInput()).addExtras(r6.getExtras());
            if (r0 < 26) goto L11;
            Set<String> r2 = Api26Impl.getAllowedDataTypes(r6);
            if (r2 == null) goto L11;
            Iterator<String> r3 = r2.iterator();
        L8:
            if (r3.hasNext() == false) goto L11;
            r1.setAllowDataType(r3.next(), true);
        L11:
            if (r0 < 29) goto L14;
            r1.setEditChoicesBeforeSending(Api29Impl.getEditChoicesBeforeSending(r6));
        L14:
            return r1.build();
        }

        @DoNotInline
        static Bundle getResultsFromIntent(Intent r0) {
            return android.app.RemoteInput.getResultsFromIntent(r0);
        }
    }

    @RequiresApi(26)
    static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        static void addDataResultToIntent(RemoteInput r0, Intent r1, Map<String, Uri> r2) {
            android.app.RemoteInput.addDataResultToIntent(RemoteInput.fromCompat(r0), r1, r2);
        }

        @DoNotInline
        static Set<String> getAllowedDataTypes(Object r0) {
            return ((android.app.RemoteInput) r0).getAllowedDataTypes();
        }

        @DoNotInline
        static Map<String, Uri> getDataResultsFromIntent(Intent r0, String r1) {
            return android.app.RemoteInput.getDataResultsFromIntent(r0, r1);
        }

        @DoNotInline
        static android.app.RemoteInput.Builder setAllowDataType(android.app.RemoteInput.Builder r0, String r1, boolean r2) {
            return r0.setAllowDataType(r1, r2);
        }
    }

    @RequiresApi(28)
    static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        static int getResultsSource(Intent r0) {
            return android.app.RemoteInput.getResultsSource(r0);
        }

        @DoNotInline
        static void setResultsSource(Intent r0, int r1) {
            android.app.RemoteInput.setResultsSource(r0, r1);
        }
    }

    @RequiresApi(29)
    static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        static int getEditChoicesBeforeSending(Object r0) {
            return ((android.app.RemoteInput) r0).getEditChoicesBeforeSending();
        }

        @DoNotInline
        static android.app.RemoteInput.Builder setEditChoicesBeforeSending(android.app.RemoteInput.Builder r0, int r1) {
            return r0.setEditChoicesBeforeSending(r1);
        }
    }

    public static final class Builder {
        private boolean mAllowFreeFormTextInput;
        private final Set<String> mAllowedDataTypes;
        private CharSequence[] mChoices;
        private int mEditChoicesBeforeSending;
        private final Bundle mExtras;
        private CharSequence mLabel;
        private final String mResultKey;

        public Builder(@NonNull String r2) {
            this.mAllowedDataTypes = new HashSet();
            this.mExtras = new Bundle();
            this.mAllowFreeFormTextInput = true;
            this.mEditChoicesBeforeSending = 0;
            if (r2 == null) goto L7;
            this.mResultKey = r2;
            return;
        L7:
            throw new IllegalArgumentException("Result key can't be null");
        }

        @NonNull
        public Builder addExtras(@NonNull Bundle r2) {
            if (r2 == null) goto L4;
            this.mExtras.putAll(r2);
        L4:
            return this;
        }

        @NonNull
        public RemoteInput build() {
            return new RemoteInput(this.mResultKey, this.mLabel, this.mChoices, this.mAllowFreeFormTextInput, this.mEditChoicesBeforeSending, this.mExtras, this.mAllowedDataTypes);
        }

        @NonNull
        public Bundle getExtras() {
            return this.mExtras;
        }

        @NonNull
        public Builder setAllowDataType(@NonNull String r1, boolean r2) {
            if (r2 == false) goto L4;
            this.mAllowedDataTypes.add(r1);
        L5:
            return this;
        L4:
            this.mAllowedDataTypes.remove(r1);
            goto L5
        }

        @NonNull
        public Builder setAllowFreeFormInput(boolean r1) {
            this.mAllowFreeFormTextInput = r1;
            return this;
        }

        @NonNull
        public Builder setChoices(@Nullable CharSequence[] r1) {
            this.mChoices = r1;
            return this;
        }

        @NonNull
        public Builder setEditChoicesBeforeSending(int r1) {
            this.mEditChoicesBeforeSending = r1;
            return this;
        }

        @NonNull
        public Builder setLabel(@Nullable CharSequence r1) {
            this.mLabel = r1;
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface EditChoicesBeforeSending {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface Source {
    }

    RemoteInput(String r1, CharSequence r2, CharSequence[] r3, boolean r4, int r5, Bundle r6, Set<String> r7) {
        this.mResultKey = r1;
        this.mLabel = r2;
        this.mChoices = r3;
        this.mAllowFreeFormTextInput = r4;
        this.mEditChoicesBeforeSending = r5;
        this.mExtras = r6;
        this.mAllowedDataTypes = r7;
        if (getEditChoicesBeforeSending() == 2) goto L5;
        return;
    L5:
        if (getAllowFreeFormInput() == false) goto L8;
        return;
    L8:
        throw new IllegalArgumentException("setEditChoicesBeforeSending requires setAllowFreeFormInput");
    }

    @Proxy("getBundleExtra")
    @TargetClass("android.content.Intent")
    public static Bundle INVOKEVIRTUAL_androidx_core_app_RemoteInput_com_bytedance_sysoptimizer_BadParcelableLancet_getBundleExtra(Intent r0, String r1) {
        Bundle r2 = r0.getBundleExtra(r1);
        Context r3 = BadParcelableCrashOptimizer.getContext();
        if (r2 == null) goto L6;
        if (r3 == null) goto L6;
        r2.setClassLoader(r3.getClassLoader());
    L6:
        return r2;
    }

    public static void addDataResultToIntent(@NonNull RemoteInput r5, @NonNull Intent r6, @NonNull Map<String, Uri> r7) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 26) goto L6;
        Api26Impl.addDataResultToIntent(r5, r6, r7);
        return;
    L6:
        if (r0 < 16) goto L28;
        Intent r1 = getClipDataIntentFromIntent(r6);
        if (r1 != null) goto L10;
        r1 = new Intent();
    L10:
        Iterator<Map.Entry<String, Uri>> r8 = r7.entrySet().iterator();
    L12:
        if (r8.hasNext() == false) goto L20;
        Map.Entry<String, Uri> r2 = r8.next();
        String r3 = r2.getKey();
        Uri r4 = r2.getValue();
        if (r3 == null) goto L12;
        Bundle r9 = INVOKEVIRTUAL_androidx_core_app_RemoteInput_com_bytedance_sysoptimizer_BadParcelableLancet_getBundleExtra(r1, getExtraResultsKeyForData(r3));
        if (r9 != null) goto L19;
        r9 = new Bundle();
    L19:
        r9.putString(r5.getResultKey(), r4.toString());
        r1.putExtra(getExtraResultsKeyForData(r3), r9);
        goto L12
    L20:
        Api16Impl.setClipData(r6, ClipData.newIntent(RESULTS_CLIP_LABEL, r1));
        return;
    }

    public static void addResultsToIntent(@NonNull RemoteInput[] r8, @NonNull Intent r9, @NonNull Bundle r10) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 26) goto L5;
        Api20Impl.addResultsToIntent(fromCompat(r8), r9, r10);
        return;
    L5:
        int r2 = 0;
        if (r0 < 20) goto L19;
        Bundle r1 = getResultsFromIntent(r9);
        int r3 = getResultsSource(r9);
        if (r1 == null) goto L11;
        r1.putAll(r10);
        r10 = r1;
    L11:
        int r4 = r8.length;
        int r5 = 0;
    L12:
        if (r5 >= r4) goto L17;
        RemoteInput r6 = r8[r5];
        Map<String, Uri> r7 = getDataResultsFromIntent(r9, r6.getResultKey());
        Api20Impl.addResultsToIntent(fromCompat(new RemoteInput[]{r6}), r9, r10);
        if (r7 == null) goto L16;
        addDataResultToIntent(r6, r9, r7);
    L16:
        r5 = r5 + 1;
        goto L12
    L17:
        setResultsSource(r9, r3);
        return;
    L19:
        if (r0 < 16) goto L42;
        Intent r11 = getClipDataIntentFromIntent(r9);
        if (r11 != null) goto L23;
        r11 = new Intent();
    L23:
        Bundle r12 = INVOKEVIRTUAL_androidx_core_app_RemoteInput_com_bytedance_sysoptimizer_BadParcelableLancet_getBundleExtra(r11, EXTRA_RESULTS_DATA);
        if (r12 != null) goto L26;
        r12 = new Bundle();
    L26:
        int r13 = r8.length;
    L27:
        if (r2 >= r13) goto L32;
        RemoteInput r14 = r8[r2];
        Object r15 = r10.get(r14.getResultKey());
        if ((r15 instanceof CharSequence) == false) goto L31;
        r12.putCharSequence(r14.getResultKey(), (CharSequence) r15);
    L31:
        r2 = r2 + 1;
        goto L27
    L32:
        r11.putExtra(EXTRA_RESULTS_DATA, r12);
        Api16Impl.setClipData(r9, ClipData.newIntent(RESULTS_CLIP_LABEL, r11));
        return;
    }

    @RequiresApi(20)
    static android.app.RemoteInput fromCompat(RemoteInput r0) {
        return Api20Impl.fromCompat(r0);
    }

    @RequiresApi(20)
    static android.app.RemoteInput[] fromCompat(RemoteInput[] r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        android.app.RemoteInput[] r0 = new android.app.RemoteInput[r3.length];
        int r1 = 0;
    L7:
        if (r1 >= r3.length) goto L9;
        r0[r1] = fromCompat(r3[r1]);
        r1 = r1 + 1;
        goto L7
    L9:
        return r0;
    }

    @RequiresApi(20)
    static RemoteInput fromPlatform(android.app.RemoteInput r0) {
        return Api20Impl.fromPlatform(r0);
    }

    @RequiresApi(16)
    private static Intent getClipDataIntentFromIntent(Intent r3) {
        ClipData r4 = Api16Impl.getClipData(r3);
        if (r4 != null) goto L5;
        return null;
    L5:
        ClipDescription r1 = r4.getDescription();
        if (r1.hasMimeType("text/vnd.android.intent") == true) goto L9;
        return null;
    L9:
        if (r1.getLabel().toString().contentEquals(RESULTS_CLIP_LABEL) == true) goto L12;
        return null;
    L12:
        return r4.getItemAt(0).getIntent();
    }

    @Nullable
    public static Map<String, Uri> getDataResultsFromIntent(@NonNull Intent r6, @NonNull String r7) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 26) goto L7;
        return Api26Impl.getDataResultsFromIntent(r6, r7);
    L7:
        if (r0 < 16) goto L41;
        Intent r8 = getClipDataIntentFromIntent(r6);
        if (r8 != null) goto L11;
        return null;
    L11:
        HashMap r1 = new HashMap();
        Iterator<String> r2 = r8.getExtras().keySet().iterator();
    L13:
        if (r2.hasNext() == false) goto L26;
        String r3 = r2.next();
        if (r3.startsWith(EXTRA_DATA_TYPE_RESULTS_DATA) == false) goto L13;
        String r4 = r3.substring(39);
        if (r4.isEmpty() == true) goto L13;
        String r5 = INVOKEVIRTUAL_androidx_core_app_RemoteInput_com_bytedance_sysoptimizer_BadParcelableLancet_getBundleExtra(r8, r3).getString(r7);
        if (r5 == null) goto L13;
        if (r5.isEmpty() == true) goto L13;
        r1.put(r4, Uri.parse(r5));
        goto L13
    L26:
        if (r1.isEmpty() == false) goto L29;
        return null;
    L29:
        return r1;
    L41:
        return null;
    }

    private static String getExtraResultsKeyForData(String r2) {
        return EXTRA_DATA_TYPE_RESULTS_DATA + r2;
    }

    @Nullable
    public static Bundle getResultsFromIntent(@NonNull Intent r3) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 20) goto L7;
        return Api20Impl.getResultsFromIntent(r3);
    L7:
        if (r0 < 16) goto L13;
        Intent r4 = getClipDataIntentFromIntent(r3);
        if (r4 != null) goto L12;
        return null;
    L12:
        return (Bundle) r4.getExtras().getParcelable(EXTRA_RESULTS_DATA);
    L13:
        return null;
    }

    public static int getResultsSource(@NonNull Intent r3) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 28) goto L7;
        return Api28Impl.getResultsSource(r3);
    L7:
        if (r0 < 16) goto L13;
        Intent r4 = getClipDataIntentFromIntent(r3);
        if (r4 != null) goto L12;
        return 0;
    L12:
        return r4.getExtras().getInt(EXTRA_RESULTS_SOURCE, 0);
    L13:
        return 0;
    }

    public static void setResultsSource(@NonNull Intent r2, int r3) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 28) goto L6;
        Api28Impl.setResultsSource(r2, r3);
        return;
    L6:
        if (r0 < 16) goto L13;
        Intent r1 = getClipDataIntentFromIntent(r2);
        if (r1 != null) goto L10;
        r1 = new Intent();
    L10:
        r1.putExtra(EXTRA_RESULTS_SOURCE, r3);
        Api16Impl.setClipData(r2, ClipData.newIntent(RESULTS_CLIP_LABEL, r1));
        return;
    }

    public boolean getAllowFreeFormInput() {
        return this.mAllowFreeFormTextInput;
    }

    @Nullable
    public Set<String> getAllowedDataTypes() {
        return this.mAllowedDataTypes;
    }

    @Nullable
    public CharSequence[] getChoices() {
        return this.mChoices;
    }

    public int getEditChoicesBeforeSending() {
        return this.mEditChoicesBeforeSending;
    }

    @NonNull
    public Bundle getExtras() {
        return this.mExtras;
    }

    @Nullable
    public CharSequence getLabel() {
        return this.mLabel;
    }

    @NonNull
    public String getResultKey() {
        return this.mResultKey;
    }

    public boolean isDataOnly() {
        if (getAllowFreeFormInput() == false) goto L5;
    L13:
        return false;
    L5:
        if (getChoices() == null) goto L9;
        if (getChoices().length != 0) goto L13;
    L9:
        if (getAllowedDataTypes() == null) goto L13;
        if (getAllowedDataTypes().isEmpty() == true) goto L13;
        return true;
    }
}
