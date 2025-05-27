
class Event {
  constructor(name, date, seats) {
    this.name = name;
    this.date = date;
    this.seats = seats;
  }
}


Event.prototype.checkAvailability = function() {
  return this.seats > 0 ? "Seats available" : "Sold out";
};


const event1 = new Event("Local Art Festival", "2025-06-15", 10);
const event2 = new Event("Music Concert", "2025-07-10", 0);


console.log(`${event1.name}: ${event1.checkAvailability()}`); // Seats available
console.log(`${event2.name}: ${event2.checkAvailability()}`); // Sold out


console.log("Event1 properties:");
Object.entries(event1).forEach(([key, value]) => {
  console.log(`${key}: ${value}`);
});
