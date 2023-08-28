drop table device_locations;
create table device_locations (
    id uuid primary key,
    device_id text not null,
    user_id uuid not null,
    latitude double precision not null,
    longitude double precision not null,
    created_at timestamp not null default now()
);
create index device_locations_user_id_created_at on device_locations(user_id, created_at);
create index device_locations_lat_lng on device_locations(latitude, longitude);