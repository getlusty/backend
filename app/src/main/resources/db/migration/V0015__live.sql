create table websocket_sessions (
    id uuid primary key,
    user_id uuid not null,
    device_id uuid not null,
    active_from timestamp not null default now(),
    active_to timestamp null
);
CREATE INDEX idx_websocket_sessions_user_id ON websocket_sessions (user_id);
CREATE INDEX idx_websocket_sessions_active_to ON websocket_sessions (active_to);