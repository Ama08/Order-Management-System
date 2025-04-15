INSERT INTO users (user_name, password, role)
SELECT 'admin', 'admin123', 'ADMIN'
WHERE NOT EXISTS (
    SELECT 1 FROM users WHERE user_name = 'admin'
);

INSERT INTO users (user_name, password, role)
SELECT 'john', 'john123', 'USER'
WHERE NOT EXISTS (
    SELECT 1 FROM users WHERE user_name = 'john'
);

INSERT INTO users (user_name, password, role)
SELECT 'jane', 'jane123', 'USER'
WHERE NOT EXISTS (
    SELECT 1 FROM users WHERE user_name = 'jane'
);