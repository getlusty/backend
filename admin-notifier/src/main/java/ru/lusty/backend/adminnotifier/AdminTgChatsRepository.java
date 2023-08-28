package ru.lusty.backend.adminnotifier;

import org.springframework.stereotype.Component;
import ru.lusty.backend.adminnotifier.records.tables.AdminTgChats;
import ru.lusty.backend.adminnotifier.records.tables.records.AdminTgChatsRecord;
import ru.lusty.backend.common.jooq.JooqUpdatableRepository;

import java.util.UUID;

import static ru.lusty.backend.adminnotifier.records.tables.AdminTgChats.ADMIN_TG_CHATS;

@Component
public class AdminTgChatsRepository extends JooqUpdatableRepository<UUID, AdminTgChat, AdminTgChatsRecord, AdminTgChats> {

    @Override
    protected AdminTgChatsRecord toRecord(AdminTgChat model) {
        return new AdminTgChatsRecord(model.getId(), model.getChatId());
    }

    @Override
    protected AdminTgChat fromRecord(AdminTgChatsRecord record) {
        return new AdminTgChat(record.getId(), record.getChatId());
    }

    @Override
    protected AdminTgChats table() {
        return ADMIN_TG_CHATS;
    }
}
