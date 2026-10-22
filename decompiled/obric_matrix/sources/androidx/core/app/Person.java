package androidx.core.app;

import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.os.PersistableBundle;
import androidx.annotation.DoNotInline;
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

    @RequiresApi(22)
    static class Api22Impl {
        private Api22Impl() {
        }

        @DoNotInline
        static Person fromPersistableBundle(PersistableBundle r2) {
            return new Builder().setName(r2.getString(Person.NAME_KEY)).setUri(r2.getString(Person.URI_KEY)).setKey(r2.getString(Person.KEY_KEY)).setBot(r2.getBoolean(Person.IS_BOT_KEY)).setImportant(r2.getBoolean(Person.IS_IMPORTANT_KEY)).build();
        }

        @DoNotInline
        static PersistableBundle toPersistableBundle(Person r3) {
            PersistableBundle r0 = new PersistableBundle();
            CharSequence r1 = r3.mName;
            if (r1 == null) goto L5;
            String r2 = r1.toString();
        L6:
            r0.putString(Person.NAME_KEY, r2);
            r0.putString(Person.URI_KEY, r3.mUri);
            r0.putString(Person.KEY_KEY, r3.mKey);
            r0.putBoolean(Person.IS_BOT_KEY, r3.mIsBot);
            r0.putBoolean(Person.IS_IMPORTANT_KEY, r3.mIsImportant);
            return r0;
        L5:
            r2 = null;
            goto L6
        }
    }

    @RequiresApi(28)
    static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        static Person fromAndroidPerson(android.app.Person r2) {
            Builder r0 = new Builder().setName(r2.getName());
            if (r2.getIcon() == null) goto L5;
            IconCompat r1 = IconCompat.createFromIcon(r2.getIcon());
        L7:
            return r0.setIcon(r1).setUri(r2.getUri()).setKey(r2.getKey()).setBot(r2.isBot()).setImportant(r2.isImportant()).build();
        L5:
            r1 = null;
            goto L7
        }

        @DoNotInline
        static android.app.Person toAndroidPerson(Person r2) {
            android.app.Person.Builder r0 = new android.app.Person.Builder().setName(r2.getName());
            if (r2.getIcon() == null) goto L5;
            Icon r1 = r2.getIcon().toIcon();
        L7:
            return r0.setIcon(r1).setUri(r2.getUri()).setKey(r2.getKey()).setBot(r2.isBot()).setImportant(r2.isImportant()).build();
        L5:
            r1 = null;
            goto L7
        }
    }

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

        Builder(Person r2) {
            this.mName = r2.mName;
            this.mIcon = r2.mIcon;
            this.mUri = r2.mUri;
            this.mKey = r2.mKey;
            this.mIsBot = r2.mIsBot;
            this.mIsImportant = r2.mIsImportant;
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
    }

    Person(Builder r2) {
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
    public static Person fromAndroidPerson(@NonNull android.app.Person r0) {
        return Api28Impl.fromAndroidPerson(r0);
    }

    @NonNull
    public static Person fromBundle(@NonNull Bundle r3) {
        Bundle r0 = r3.getBundle(ICON_KEY);
        Builder r1 = new Builder().setName(r3.getCharSequence(NAME_KEY));
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
    public static Person fromPersistableBundle(@NonNull PersistableBundle r0) {
        return Api22Impl.fromPersistableBundle(r0);
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
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public String resolveToLegacyUri() {
        String r0 = this.mUri;
        if (r0 == null) goto L6;
        return r0;
    L6:
        if (this.mName != null) goto L8;
        return "";
    L8:
        return "name:" + this.mName;
    }

    @NonNull
    @RequiresApi(28)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public android.app.Person toAndroidPerson() {
        return Api28Impl.toAndroidPerson(this);
    }

    @NonNull
    public Builder toBuilder() {
        return new Builder(this);
    }

    @NonNull
    public Bundle toBundle() {
        Bundle r0 = new Bundle();
        r0.putCharSequence(NAME_KEY, this.mName);
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
        return Api22Impl.toPersistableBundle(this);
    }
}
