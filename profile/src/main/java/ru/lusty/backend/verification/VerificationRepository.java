package ru.lusty.backend.verification;

import org.springframework.stereotype.Component;
import ru.lusty.backend.common.jooq.JooqUpdatableRepository;
import ru.lusty.backend.profile.records.tables.Verifications;
import ru.lusty.backend.profile.records.tables.records.VerificationsRecord;

import java.util.Optional;
import java.util.UUID;

import static ru.lusty.backend.profile.records.tables.Verifications.VERIFICATIONS;

@Component
public class VerificationRepository extends JooqUpdatableRepository<UUID, Verification, VerificationsRecord, Verifications> {

    @Override
    protected VerificationsRecord toRecord(Verification model) {
        return new VerificationsRecord(model.getId(), model.getProfileId(), model.getFileId(), model.getCreatedAt(),
            model.getApproved().orElse(null), model.getReviewedAt().orElse(null));
    }

    @Override
    protected Verification fromRecord(VerificationsRecord record) {
        return new Verification(record.getId(), record.getProfileId(), record.getFileId(), record.getCreatedAt(),
            Optional.ofNullable(record.getReviewedAt()), Optional.ofNullable(record.getApproved()));
    }

    @Override
    protected Verifications table() {
        return VERIFICATIONS;
    }

}
