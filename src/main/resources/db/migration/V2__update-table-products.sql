ALTER TABLE product ADD COLUMN new_id VARCHAR(255);

UPDATE product SET new_id = id::VARCHAR;

ALTER TABLE product DROP COLUMN id;

ALTER TABLE product RENAME COLUMN new_id TO id;

ALTER TABLE product ADD PRIMARY KEY (id);
