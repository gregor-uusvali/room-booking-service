CREATE TABLE IF NOT EXISTS users (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(50) NOT NULL UNIQUE,
  password VARCHAR(255) NOT NULL,
  enabled BOOLEAN NOT NULL DEFAULT TRUE,
  type BIGINT NOT NULL DEFAULT 0
);
-- -u test -p test
INSERT IGNORE INTO users (username, password, enabled, type) VALUES ('test', '$2a$12$Dz3NUOB7fmQjTj9DHdAaJ.2cPRjfrEmgtSAEqCbEQb/NWa4xjhICS', TRUE, 0);