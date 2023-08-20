create table if not exists category (
    category_id character varying(100) primary key not null,
    created_by character varying(100) not null,
    created_dt timestamp(6) without time zone not null,
    updated_by character varying(100),
    updated_dt timestamp(6) without time zone,
    category_name character varying(100) not null,
    category_type character varying(10) not null
);

create table if not exists sub_category (
    sub_category_id character varying(100) primary key not null,
    created_by character varying(100) not null,
    created_dt timestamp(6) without time zone not null,
    updated_by character varying(100),
    updated_dt timestamp(6) without time zone,
    sub_category_desc character varying(500),
    sub_category_name character varying(100) not null,
    user_type_yn character varying(100) not null,
    category_id character varying(100),
    foreign key (category_id) references public.category (category_id)
      match simple on update no action on delete no action
);

create table if not exists church (
    church_id character varying(100) primary key not null,
    created_by character varying(100) not null,
    created_dt timestamp(6) without time zone not null,
    updated_by character varying(100),
    updated_dt timestamp(6) without time zone,
    church_name character varying(50) not null
);

create table if not exists groups (
   group_id character varying(100) primary key not null,
   created_by character varying(100) not null,
   created_dt timestamp(6) without time zone not null,
   updated_by character varying(100),
   updated_dt timestamp(6) without time zone,
   group_name character varying(50) not null,
   church_id character varying(100),
   foreign key (church_id) references public.church (church_id)
       match simple on update no action on delete no action
);

