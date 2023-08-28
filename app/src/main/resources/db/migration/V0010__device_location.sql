create table device_locations (
    id uuid primary key,
    device_id text not null,
    user_id text not null,
    latitude double precision not null,
    longitude double precision not null
);