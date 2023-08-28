alter table websocket_sessions drop column device_id;
alter table websocket_sessions add column device_id text not null;