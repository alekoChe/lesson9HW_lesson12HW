
CREATE TABLE IF NOT EXISTS products (id bigserial, price int, purchase_price int, title VARCHAR(255), PRIMARY KEY (id));
INSERT INTO products (title, price, purchase_price)
VALUES
    ('Product1', 10, 6),
    ('Product2', 15, 10),
    ('Product3', 20, 12),
    ('Product4', 3, 1),
    ('Product5', 19, 15),
    ('Product6', 25, 17),
    ('Product7', 40, 20),
    ('Product8', 55, 35),
    ('Product9', 17, 10),
    ('Product10', 85, 70),
    ('Product11', 27, 11),
    ('Product12', 5, 1),
    ('Product13', 105, 65),
    ('Product14', 155, 100),
    ('Product15', 30, 10),
    ('Product16', 7, 6),
    ('Product17', 19, 12),
    ('Product18', 65, 45),
    ('Product19', 29, 10),
    ('Product20', 3, 1),
    ('Product21', 33, 18);

CREATE TABLE IF NOT EXISTS users (
    id         bigserial primary key,
    user_name   varchar(36) not null,
    phone_number      varchar(50) unique,
    password   varchar(80) not null,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp
);
INSERT INTO users (user_name, phone_number, password)
VALUES
    ('user01', '000001', '$2a$12$ub7305gwTQ7KzdpTyrFv0u3aVaAYOSzR5eA9Qt4E3LPzIxQca3X2.'),
    ('user02', '000002', '$2a$12$N44I.FqavWmhfz5vLWos1eHx9N1/PdDSsXHn5jGViAWf5SBH64Nj.'),
    ('user03', '000003', '$2a$12$Q/T1s6.q6DyhNowb3iXNuOHObXxAVW7/t/2wzdQuG9IZ9Rq3GBCuu'),
    ('user04', '000004', '$2a$12$8r.l9ZvfhsAiAqfc9tPlPuzJD44jSveOzxlJHicwLsVCVlCI576ae'),
    ('user05', '000005', '$2a$12$4uEdsyuXBPicUg/p5wqiv.z6g7XmwIImoWZUnGRryCi1iOZKgG6.e');