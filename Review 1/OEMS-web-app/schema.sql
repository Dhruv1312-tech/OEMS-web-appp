-- Create the database
CREATE DATABASE event_management_db;
USE event_management_db;

-- Users Table: Stores all users (Admin, Organizer, Attendee)
CREATE TABLE users (	
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(100) NOT NULL,
    email VARCHAR(50) NOT NULL UNIQUE,
    role ENUM('Admin', 'Organizer', 'Attendee') NOT NULL,
    country VARCHAR(50) NOT NULL,
    passwd VARCHAR(20) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Events Table: Stores details of events created by organizers
CREATE TABLE events (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(200) NOT NULL,
    description TEXT,
    date_time DATETIME NOT NULL,
    venue VARCHAR(200) NOT NULL,
    organizer_id INT NOT NULL,
    status ENUM('Pending', 'Approved', 'Rejected') DEFAULT 'Pending',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (organizer_id) REFERENCES users(id) ON DELETE CASCADE
);

-- Tickets Table: Stores ticket details for each event
CREATE TABLE tickets (
    id INT AUTO_INCREMENT PRIMARY KEY,
    event_id INT NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    quantity INT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (event_id) REFERENCES events(id) ON DELETE CASCADE
);

-- Registrations Table: Tracks event registrations by attendees
CREATE TABLE registrations (
    id INT AUTO_INCREMENT PRIMARY KEY,
    event_id INT NOT NULL,
    attendee_id INT NOT NULL,
    ticket_id INT NOT NULL,
    quantity INT NOT NULL,
    total_price DECIMAL(10, 2) NOT NULL,
    registration_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (event_id) REFERENCES events(id) ON DELETE CASCADE,
    FOREIGN KEY (attendee_id) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY (ticket_id) REFERENCES tickets(id)
);

-- EventUpdates Table: Stores updates or messages sent to attendees for an event
CREATE TABLE event_updates (
    id INT AUTO_INCREMENT PRIMARY KEY,
    event_id INT NOT NULL,
    message TEXT NOT NULL,
    sent_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (event_id) REFERENCES events(id) ON DELETE CASCADE
);

-- UserNotifications Table: Tracks notifications sent to users for event updates or system messages
CREATE TABLE user_notifications (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    event_id INT,
    message TEXT NOT NULL,
    is_read BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY (event_id) REFERENCES events(id) ON DELETE CASCADE
);

-- SystemSettings Table: Stores global system configuration settings
CREATE TABLE system_settings (
    id INT AUTO_INCREMENT PRIMARY KEY,
    setting_name VARCHAR(100) UNIQUE NOT NULL,
    setting_value VARCHAR(200) NOT NULL,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- EventStatistics Table: Stores aggregated data for each event
CREATE TABLE event_statistics (
    id INT AUTO_INCREMENT PRIMARY KEY,
    event_id INT NOT NULL,
    total_registrations INT DEFAULT 0,
    total_revenue DECIMAL(10, 2) DEFAULT 0.0,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (event_id) REFERENCES events(id) ON DELETE CASCADE
);

-- ActivityLogs Table: Stores activity logs for system monitoring
CREATE TABLE activity_logs (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    action VARCHAR(200) NOT NULL,
    target_type ENUM('User', 'Event', 'Ticket', 'SystemSetting') NOT NULL,
    target_id INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE SET NULL
);

desc events;

