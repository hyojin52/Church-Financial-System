INSERT INTO category (category_id, category_name, category_type, created_by, created_dt, updated_by, updated_dt)
VALUES
    ('category-1', 'category-1', 'INCOME', 'test-user', CURRENT_TIMESTAMP, 'test-user', CURRENT_TIMESTAMP),
    ('category-2', 'category-2', 'INCOME', 'test-user', CURRENT_TIMESTAMP, 'test-user', CURRENT_TIMESTAMP),
    ('category-3', 'category-3', 'SPENDING', 'test-user', CURRENT_TIMESTAMP, 'test-user', CURRENT_TIMESTAMP),
    ('category-4', 'category-4', 'SPENDING', 'test-user', CURRENT_TIMESTAMP, 'test-user', CURRENT_TIMESTAMP);

INSERT INTO sub_category (sub_category_id, created_by, created_dt, updated_by, updated_dt, sub_category_desc, sub_category_name, user_type_yn, category_id)
VALUES
    -- category-1
    ('sub-category-1', 'test-user', CURRENT_TIMESTAMP, 'test-user', CURRENT_TIMESTAMP, null, 'sub-category-1-1', 'Y', 'category-1'),
    ('sub-category-2', 'test-user', CURRENT_TIMESTAMP, 'test-user', CURRENT_TIMESTAMP, null, 'sub-category-1-2', 'Y', 'category-1'),
    ('sub-category-3', 'test-user', CURRENT_TIMESTAMP, 'test-user', CURRENT_TIMESTAMP, null, 'sub-category-1-3', 'N', 'category-1'),
    -- category-2
    ('sub-category-4', 'test-user', CURRENT_TIMESTAMP, 'test-user', CURRENT_TIMESTAMP, null, 'sub-category-2-1', 'Y', 'category-2'),
    ('sub-category-5', 'test-user', CURRENT_TIMESTAMP, 'test-user', CURRENT_TIMESTAMP, null, 'sub-category-2-2', 'Y', 'category-2'),
    ('sub-category-6', 'test-user', CURRENT_TIMESTAMP, 'test-user', CURRENT_TIMESTAMP, null, 'sub-category-2-3', 'N', 'category-2'),
    -- category-3
    ('sub-category-7', 'test-user', CURRENT_TIMESTAMP, 'test-user', CURRENT_TIMESTAMP, null, 'sub-category-3-1', 'Y', 'category-3'),
    ('sub-category-8', 'test-user', CURRENT_TIMESTAMP, 'test-user', CURRENT_TIMESTAMP, null, 'sub-category-3-2', 'Y', 'category-3'),
    ('sub-category-9', 'test-user', CURRENT_TIMESTAMP, 'test-user', CURRENT_TIMESTAMP, null, 'sub-category-3-3', 'N', 'category-3'),
    -- category-4
    ('sub-category-10', 'test-user', CURRENT_TIMESTAMP, 'test-user', CURRENT_TIMESTAMP, null, 'sub-category-4-1', 'Y', 'category-4'),
    ('sub-category-11', 'test-user', CURRENT_TIMESTAMP, 'test-user', CURRENT_TIMESTAMP, null, 'sub-category-4-2', 'Y', 'category-4'),
    ('sub-category-12', 'test-user', CURRENT_TIMESTAMP, 'test-user', CURRENT_TIMESTAMP, null, 'sub-category-4-3', 'N', 'category-4');

INSERT INTO church (church_id, church_name, created_by, created_dt, updated_by, updated_dt)
VALUES ('church-1', '000 교회', 'test-user', CURRENT_TIMESTAMP, 'test-user', CURRENT_TIMESTAMP);

INSERT INTO groups (group_id, church_id, group_name, created_by, created_dt, updated_by, updated_dt)
VALUES
    ('group-1', 'church-1', 'vision', 'test-user', CURRENT_TIMESTAMP, 'test-user', CURRENT_TIMESTAMP),
    ('group-2', 'church-1', 'bethel', 'test-user', CURRENT_TIMESTAMP, 'test-user', CURRENT_TIMESTAMP),
    ('group-3', 'church-1', 'grace', 'test-user', CURRENT_TIMESTAMP, 'test-user', CURRENT_TIMESTAMP);

INSERT INTO users (user_id, created_by, created_dt, updated_by, updated_dt, birth_date, mobile_number, position, user_active_yn, user_name)
VALUES
    ('user-1', 'test-user', CURRENT_TIMESTAMP, 'test-user', CURRENT_TIMESTAMP, '20230101', '+821012341234', 'ELDER', 'Y', '홍길동1'),
    ('user-2', 'test-user', CURRENT_TIMESTAMP, 'test-user', CURRENT_TIMESTAMP, '20230102', '+821012341234', 'PASTOR', 'Y', '홍길동2');
