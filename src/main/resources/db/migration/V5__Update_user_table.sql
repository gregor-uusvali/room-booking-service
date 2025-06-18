UPDATE users SET role = 'USER' WHERE id = 2;
INSERT INTO users (username, password, enabled, role) VALUES ('admin', '$2a$12$Dz3NUOB7fmQjTj9DHdAaJ.2cPRjfrEmgtSAEqCbEQb/NWa4xjhICS', TRUE, 'USER,ADMIN');