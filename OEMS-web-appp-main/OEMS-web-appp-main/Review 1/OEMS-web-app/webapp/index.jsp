<!DOCTYPE html>
<html>
<head>
    <title>Event Form</title>
</head>
<body>
    <h1>Create an Event</h1>
    <form action="event" method="post">
        <label for="name">Event Name:</label>
        <input type="text" id="name" name="name" required><br><br>
        
        <label for="date">Event Date:</label>
        <input type="date" id="date" name="date" required><br><br>
        
        <label for="location">Location:</label>
        <input type="text" id="location" name="location" required><br><br>
        
        <button type="submit">Create Event</button>
    </form>
</body>
</html>
