create table outgoing_messages (
    id uuid primary key,
    exchange text not null,
    routing_key text null,
    json text not null,
    created_at timestamp not null default now()
);
create index outgoing_messages_created_at on outgoing_messages(created_at);