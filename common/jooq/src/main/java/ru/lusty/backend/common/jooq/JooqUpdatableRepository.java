package ru.lusty.backend.common.jooq;

import org.jooq.Field;
import org.jooq.Table;
import org.jooq.UpdatableRecord;

public abstract class JooqUpdatableRepository<ID, M extends Model<ID>, R extends UpdatableRecord<R>, T extends Table<R>>
    extends JooqRepository<ID, M ,R, T> {

    protected abstract R toRecord(M model);

    public void insert(M model) {
        final var record = toRecord(model);
        record.attach(jdbc.configuration());
        record.insert();
    }

    public void update(M model) {
        final var record = toRecord(model);
        record.attach(jdbc.configuration());
        record.update();
    }

    public void delete(ID id) {
        jdbc.deleteFrom(table())
            .where(((Field<ID>)(table().getPrimaryKey().getFieldsArray()[0])).eq(id))
            .execute();
    }

    public void delete(M model) {
        final var record = toRecord(model);
        record.attach(jdbc.configuration());
        record.delete();
    }
}
