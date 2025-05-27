const events = [
  { name: "Yoga Workshop", date: "2025-08-20", seats: 20, category: "Health" },
  { name: "Art Exhibition", date: "2025-12-10", seats: 10, category: "Art" },
  { name: "Music Night", date: "2025-11-05", seats: 15, category: "Music" },
  { name: "Tech Talk", date: "2025-09-01", seats: 5, category: "Technology" },
];

function createRegistrationTracker() {
  const registrations = {};

  return {
    increment(category) {
      registrations[category] = (registrations[category] || 0) + 1;
    },
    getCount(category) {
      return registrations[category] || 0;
    },
    getAll() {
      return {...registrations}; // clone
    }
  };
}

const registrationTracker = createRegistrationTracker();

function addEvent(newEvent) {
  events.push(newEvent);
  console.log(`Added new event: ${newEvent.name} (${newEvent.category})`);
}

function registerUser(eventName) {
  const event = events.find(e => e.name === eventName);
  if (!event) {
    console.error("Event not found");
    return;
  }
  if (event.seats <= 0) {
    console.error("No seats available");
    return;
  }
  event.seats--;
  registrationTracker.increment(event.category);
  console.log(`Registered for ${event.name}. Seats left: ${event.seats}`);
}

function filterEventsByCategory(filterCallback) {
  return events.filter(filterCallback);
}


addEvent({ name: "Cooking Class", date: "2025-10-10", seats: 12, category: "Food" });

registerUser("Yoga Workshop");
registerUser("Cooking Class");
registerUser("Yoga Workshop");

const musicEvents = filterEventsByCategory(event => event.category === "Music");
console.log("Music Events:", musicEvents);

console.log("Registrations count:", registrationTracker.getAll());
