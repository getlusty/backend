package ru.lusty.backend.common.jooq;

import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Table;
import org.jooq.TableRecord;
import org.jooq.UpdatableRecord;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class JooqRepository<ID, M extends Model<ID>, R extends TableRecord<R>, T extends Table<R>> {

    @Autowired
    protected DSLContext jdbc;

    protected abstract M fromRecord(R record);

    public M getById(ID id) {
        return jdbc.selectFrom(table())
            .where(((Field<ID>)(table().getPrimaryKey().getFieldsArray()[0])).eq(id))
            .fetchOne(this::fromRecord);
    }

    public List<M> findAll() {
        return jdbc.selectFrom(table())
            .fetch(this::fromRecord);
    }

    protected abstract T table();
}
