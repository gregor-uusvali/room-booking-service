-- Create rooms table (simplified version matching current entity)
CREATE TABLE IF NOT EXISTS rooms (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    room_number VARCHAR(50),
    room_price DOUBLE
);

-- Create bookings table
CREATE TABLE IF NOT EXISTS bookings (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    room_id BIGINT,
    user_id BIGINT,
    booking_date DATE,
    check_in_date DATE,
    check_out_date DATE,
    FOREIGN KEY (room_id) REFERENCES rooms(id)
);

-- Insert some sample data (only if tables are empty)
INSERT IGNORE INTO rooms (room_number, room_price) VALUES
('101', 99.99),
('102', 149.99),
('201', 199.99); 