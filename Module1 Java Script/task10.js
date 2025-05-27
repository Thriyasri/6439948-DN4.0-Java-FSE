const events = [
  { id: 1, name: "Art Festival", category: "Art", date: "2025-06-15", seats: 5 },
  { id: 2, name: "Music Concert", category: "Music", date: "2025-07-10", seats: 2 },
  { id: 3, name: "Tech Workshop", category: "Tech", date: "2025-08-20", seats: 10 }
];

const filterEvents = (eventList = [], category = "all") => {
  const clonedEvents = [...eventList];

  return category.toLowerCase() === "all"
    ? clonedEvents
    : clonedEvents.filter(({ category: cat }) => cat.toLowerCase() === category.toLowerCase());
};

const selectedCategory = "Music";

const filtered = filterEvents(events, selectedCategory);

filtered.forEach(({ id, name, date, seats }) => {
  console.log(`Event ${id}: ${name} on ${date} (${seats} seats left)`);
});
