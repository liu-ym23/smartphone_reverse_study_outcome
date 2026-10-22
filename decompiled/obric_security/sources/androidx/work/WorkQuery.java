package androidx.work;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public final class WorkQuery {
    private final List<UUID> mIds;
    private final List<WorkInfo.State> mStates;
    private final List<String> mTags;
    private final List<String> mUniqueWorkNames;

    public static final class Builder {
        List<UUID> mIds;
        List<WorkInfo.State> mStates;
        List<String> mTags;
        List<String> mUniqueWorkNames;

        private Builder() {
            this.mIds = new ArrayList();
            this.mUniqueWorkNames = new ArrayList();
            this.mTags = new ArrayList();
            this.mStates = new ArrayList();
        }

        public static Builder fromIds(List<UUID> ids) {
            Builder r0 = new Builder();
            r0.addIds(ids);
            return r0;
        }

        public static Builder fromUniqueWorkNames(List<String> uniqueWorkNames) {
            Builder r0 = new Builder();
            r0.addUniqueWorkNames(uniqueWorkNames);
            return r0;
        }

        public static Builder fromTags(List<String> tags) {
            Builder r0 = new Builder();
            r0.addTags(tags);
            return r0;
        }

        public static Builder fromStates(List<WorkInfo.State> states) {
            Builder r0 = new Builder();
            r0.addStates(states);
            return r0;
        }

        public Builder addIds(List<UUID> ids) {
            this.mIds.addAll(ids);
            return this;
        }

        public Builder addUniqueWorkNames(List<String> uniqueWorkNames) {
            this.mUniqueWorkNames.addAll(uniqueWorkNames);
            return this;
        }

        public Builder addTags(List<String> tags) {
            this.mTags.addAll(tags);
            return this;
        }

        public Builder addStates(List<WorkInfo.State> states) {
            this.mStates.addAll(states);
            return this;
        }

        public WorkQuery build() {
            if (this.mIds.isEmpty() == false) goto L14;
            if (this.mUniqueWorkNames.isEmpty() == false) goto L14;
            if (this.mTags.isEmpty() == false) goto L14;
            if (this.mStates.isEmpty() == false) goto L14;
            throw new IllegalArgumentException("Must specify ids, uniqueNames, tags or states when building a WorkQuery");
        L14:
            return new WorkQuery(this);
        }
    }

    WorkQuery(Builder builder) {
        this.mIds = builder.mIds;
        this.mUniqueWorkNames = builder.mUniqueWorkNames;
        this.mTags = builder.mTags;
        this.mStates = builder.mStates;
    }

    public List<UUID> getIds() {
        return this.mIds;
    }

    public List<String> getUniqueWorkNames() {
        return this.mUniqueWorkNames;
    }

    public List<String> getTags() {
        return this.mTags;
    }

    public List<WorkInfo.State> getStates() {
        return this.mStates;
    }

    public static WorkQuery fromIds(List<UUID> ids) {
        return Builder.fromIds(ids).build();
    }

    public static WorkQuery fromIds(UUID... ids) {
        return fromIds(Arrays.asList(ids));
    }

    public static WorkQuery fromTags(List<String> tags) {
        return Builder.fromTags(tags).build();
    }

    public static WorkQuery fromTags(String... tags) {
        return fromTags(Arrays.asList(tags));
    }

    public static WorkQuery fromUniqueWorkNames(String... uniqueWorkNames) {
        return Builder.fromUniqueWorkNames(Arrays.asList(uniqueWorkNames)).build();
    }

    public static WorkQuery fromUniqueWorkNames(List<String> uniqueWorkNames) {
        return Builder.fromUniqueWorkNames(uniqueWorkNames).build();
    }

    public static WorkQuery fromStates(List<WorkInfo.State> states) {
        return Builder.fromStates(states).build();
    }

    public static WorkQuery fromStates(WorkInfo.State... states) {
        return Builder.fromStates(Arrays.asList(states)).build();
    }
}
