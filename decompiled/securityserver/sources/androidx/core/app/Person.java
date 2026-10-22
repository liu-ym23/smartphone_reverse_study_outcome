package androidx.core.app;

import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.os.PersistableBundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.IconCompat;

/* JADX INFO: loaded from: classes.dex */
public class Person {
    private static final String ICON_KEY = "icon";
    private static final String IS_BOT_KEY = "isBot";
    private static final String IS_IMPORTANT_KEY = "isImportant";
    private static final String KEY_KEY = "key";
    private static final String NAME_KEY = "name";
    private static final String URI_KEY = "uri";

    @Nullable
    IconCompat mIcon;
    boolean mIsBot;
    boolean mIsImportant;

    @Nullable
    String mKey;

    @Nullable
    CharSequence mName;

    @Nullable
    String mUri;

    public static class Builder {

        @Nullable
        IconCompat mIcon;
        boolean mIsBot;
        boolean mIsImportant;

        @Nullable
        String mKey;

        @Nullable
        CharSequence mName;

        @Nullable
        String mUri;

        public Builder() {
        }

        @NonNull
        public Person build() {
            return new Person(this);
        }

        @NonNull
        public Builder setBot(boolean r1) {
            this.mIsBot = r1;
            return this;
        }

        @NonNull
        public Builder setIcon(@Nullable IconCompat r1) {
            this.mIcon = r1;
            return this;
        }

        @NonNull
        public Builder setImportant(boolean r1) {
            this.mIsImportant = r1;
            return this;
        }

        @NonNull
        public Builder setKey(@Nullable String r1) {
            this.mKey = r1;
            return this;
        }

        @NonNull
        public Builder setName(@Nullable CharSequence r1) {
            this.mName = r1;
            return this;
        }

        @NonNull
        public Builder setUri(@Nullable String r1) {
            this.mUri = r1;
            return this;
        }

        public Builder(Person r2) {
            this.mName = r2.mName;
            this.mIcon = r2.mIcon;
            this.mUri = r2.mUri;
            this.mKey = r2.mKey;
            this.mIsBot = r2.mIsBot;
            this.mIsImportant = r2.mIsImportant;
        }
    }

    public Person(Builder r2) {
        this.mName = r2.mName;
        this.mIcon = r2.mIcon;
        this.mUri = r2.mUri;
        this.mKey = r2.mKey;
        this.mIsBot = r2.mIsBot;
        this.mIsImportant = r2.mIsImportant;
    }

    @NonNull
    @RequiresApi(28)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static Person fromAndroidPerson(@NonNull android.app.Person r2) {
        Builder r0 = new Builder().setName(r2.getName());
        if (r2.getIcon() == null) goto L5;
        IconCompat r1 = IconCompat.createFromIcon(r2.getIcon());
    L7:
        return r0.setIcon(r1).setUri(r2.getUri()).setKey(r2.getKey()).setBot(r2.isBot()).setImportant(r2.isImportant()).build();
    L5:
        r1 = null;
        goto L7
    }

    @NonNull
    public static Person fromBundle(@NonNull Bundle r3) {
        Bundle r0 = r3.getBundle(ICON_KEY);
        Builder r1 = new Builder().setName(r3.getCharSequence("name"));
        if (r0 == null) goto L5;
        IconCompat r2 = IconCompat.createFromBundle(r0);
    L7:
        return r1.setIcon(r2).setUri(r3.getString(URI_KEY)).setKey(r3.getString(KEY_KEY)).setBot(r3.getBoolean(IS_BOT_KEY)).setImportant(r3.getBoolean(IS_IMPORTANT_KEY)).build();
    L5:
        r2 = null;
        goto L7
    }

    @NonNull
    @RequiresApi(22)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static Person fromPersistableBundle(@NonNull PersistableBundle r2) {
        return new Builder().setName(r2.getString("name")).setUri(r2.getString(URI_KEY)).setKey(r2.getString(KEY_KEY)).setBot(r2.getBoolean(IS_BOT_KEY)).setImportant(r2.getBoolean(IS_IMPORTANT_KEY)).build();
    }

    @Nullable
    public IconCompat getIcon() {
        return this.mIcon;
    }

    @Nullable
    public String getKey() {
        return this.mKey;
    }

    @Nullable
    public CharSequence getName() {
        return this.mName;
    }

    @Nullable
    public String getUri() {
        return this.mUri;
    }

    public boolean isBot() {
        return this.mIsBot;
    }

    public boolean isImportant() {
        return this.mIsImportant;
    }

    @NonNull
    @RequiresApi(28)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public android.app.Person toAndroidPerson() {
        android.app.Person.Builder r0 = new android.app.Person.Builder().setName(getName());
        if (getIcon() == null) goto L5;
        Icon r1 = getIcon().toIcon();
    L7:
        return r0.setIcon(r1).setUri(getUri()).setKey(getKey()).setBot(isBot()).setImportant(isImportant()).build();
    L5:
        r1 = null;
        goto L7
    }

    @NonNull
    public Builder toBuilder() {
        return new Builder(this);
    }

    @NonNull
    public Bundle toBundle() {
        Bundle r0 = new Bundle();
        r0.putCharSequence("name", this.mName);
        IconCompat r1 = this.mIcon;
        if (r1 == null) goto L5;
        Bundle r2 = r1.toBundle();
    L6:
        r0.putBundle(ICON_KEY, r2);
        r0.putString(URI_KEY, this.mUri);
        r0.putString(KEY_KEY, this.mKey);
        r0.putBoolean(IS_BOT_KEY, this.mIsBot);
        r0.putBoolean(IS_IMPORTANT_KEY, this.mIsImportant);
        return r0;
    L5:
        r2 = null;
        goto L6
    }

    @NonNull
    @RequiresApi(22)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PersistableBundle toPersistableBundle() {
        PersistableBundle r0 = new PersistableBundle();
        CharSequence r1 = this.mName;
        if (r1 == null) goto L5;
        String r2 = r1.toString();
    L6:
        r0.putString("name", r2);
        r0.putString(URI_KEY, this.mUri);
        r0.putString(KEY_KEY, this.mKey);
        r0.putBoolean(IS_BOT_KEY, this.mIsBot);
        r0.putBoolean(IS_IMPORTANT_KEY, this.mIsImportant);
        return r0;
    L5:
        r2 = null;
        goto L6
    }
}
