drop table profile_photo;
create table profile_photo (
    profile_id uuid,
    file_id uuid,
    priority int,
    primary key (profile_id, file_id)
);