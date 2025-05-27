const events = [
  { name: "Yoga Workshop", date: "2025-08-20", seats: 20 },
  { name: "Art Exhibition", date: "2024-12-10", seats: 0 }, // full
  { name: "Music Night", date: "2023-11-05", seats: 15 },  // past
  { name: "Tech Talk", date: "2025-09-01", seats: 5 }
];

const today = new Date().toISOString().split("T")[0];

console.log("Valid Upcoming Events:");

events.forEach(event => {
  if (event.date > today && event.seats > 0) {
    console.log(`${event.name} on ${event.date} - Seats: ${event.seats}`);
  } else {
    console.log(`Skipping "${event.name}" (Past or Full)`);
  }
});

function registerForEvent(eventName) {
  try {
    const event = events.find(e => e.name === eventName);

    if (!event) throw new Error("Event not found.");
    if (event.date <= today) throw new Error("This event has already passed.");
    if (event.seats <= 0) throw new Error("No seats available.");

    event.seats--;
    console.log(`Registered for ${event.name}. Remaining seats: ${event.seats}`);
  } catch (error) {
    console.error(`Registration failed: ${error.message}`);
  }
}

registerForEvent("Yoga Workshop");
registerForEvent("Art Exhibition");
registerForEvent("Music Night");
registerForEvent("Tech Talk");
registerForEvent("Unknown Event");
