package ru.lusty.backend.adminnotifier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.lusty.backend.common.jooq.Model;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminTgChat implements Model<UUID> {
    private UUID id;
    private String chatId;

}
