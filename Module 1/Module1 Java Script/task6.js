
const events = [
  { name: "Local Art Festival", category: "Art", date: "2025-06-15" },
  { name: "Rock Music Concert", category: "Music", date: "2025-07-10" },
  { name: "Baking Workshop", category: "Workshop", date: "2025-08-05" }
];

events.push({ name: "Jazz Night", category: "Music", date: "2025-09-01" });
events.push({ name: "Yoga Workshop", category: "Workshop", date: "2025-10-12" });

const musicEvents = events.filter(event => event.category.toLowerCase() === "music");

const displayCards = musicEvents.map(event => `Event: ${event.name} on ${event.date}`);

console.log("All Events:");
console.log(events);

console.log("\nMusic Events:");
console.log(musicEvents);

console.log("\nDisplay Cards for Music Events:");
displayCards.forEach(card => console.log(card));
