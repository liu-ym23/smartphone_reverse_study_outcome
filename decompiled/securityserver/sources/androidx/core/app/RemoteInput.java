package androidx.core.app;

import a.a;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
    private static final String TAG = "RemoteInput";
    private final boolean mAllowFreeFormTextInput;
    private final Set<String> mAllowedDataTypes;
    private final CharSequence[] mChoices;
    private final int mEditChoicesBeforeSending;
    private final Bundle mExtras;
    private final CharSequence mLabel;
    private final String mResultKey;

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

    public RemoteInput(String r1, CharSequence r2, CharSequence[] r3, boolean r4, int r5, Bundle r6, Set<String> r7) {
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

    public static void addDataResultToIntent(RemoteInput r0, Intent r1, Map<String, Uri> r2) {
        android.app.RemoteInput.addDataResultToIntent(fromCompat(r0), r1, r2);
    }

    public static void addResultsToIntent(RemoteInput[] r0, Intent r1, Bundle r2) {
        android.app.RemoteInput.addResultsToIntent(fromCompat(r0), r1, r2);
    }

    @RequiresApi(20)
    public static android.app.RemoteInput[] fromCompat(RemoteInput[] r3) {
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

    @RequiresApi(16)
    private static Intent getClipDataIntentFromIntent(Intent r3) {
        ClipData r4 = r3.getClipData();
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

    public static Map<String, Uri> getDataResultsFromIntent(Intent r0, String r1) {
        return android.app.RemoteInput.getDataResultsFromIntent(r0, r1);
    }

    private static String getExtraResultsKeyForData(String r1) {
        return a.A(EXTRA_DATA_TYPE_RESULTS_DATA, r1);
    }

    public static Bundle getResultsFromIntent(Intent r0) {
        return android.app.RemoteInput.getResultsFromIntent(r0);
    }

    public static int getResultsSource(@NonNull Intent r0) {
        return android.app.RemoteInput.getResultsSource(r0);
    }

    public static void setResultsSource(@NonNull Intent r0, int r1) {
        android.app.RemoteInput.setResultsSource(r0, r1);
    }

    public boolean getAllowFreeFormInput() {
        return this.mAllowFreeFormTextInput;
    }

    public Set<String> getAllowedDataTypes() {
        return this.mAllowedDataTypes;
    }

    public CharSequence[] getChoices() {
        return this.mChoices;
    }

    public int getEditChoicesBeforeSending() {
        return this.mEditChoicesBeforeSending;
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public CharSequence getLabel() {
        return this.mLabel;
    }

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

    @RequiresApi(20)
    public static android.app.RemoteInput fromCompat(RemoteInput r2) {
        android.app.RemoteInput.Builder r0 = new android.app.RemoteInput.Builder(r2.getResultKey()).setLabel(r2.getLabel()).setChoices(r2.getChoices()).setAllowFreeFormInput(r2.getAllowFreeFormInput()).addExtras(r2.getExtras());
        r0.setEditChoicesBeforeSending(r2.getEditChoicesBeforeSending());
        return r0.build();
    }
}
