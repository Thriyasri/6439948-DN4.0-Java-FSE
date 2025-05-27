const events = [
  { name: 'Music Concert', date: '2025-06-10', category: 'Music' },
  { name: 'Art Workshop', date: '2025-06-12', category: 'Art' },
  { name: 'Coding Bootcamp', date: '2025-06-15', category: 'Education' },
];

const filterEvents = (eventList = [], category = '') => {
  const clonedList = [...eventList];
  
  return clonedList.filter(({ category: cat }) => cat === category);
};

const musicEvents = filterEvents(events, 'Music');
console.log('Music Events:', musicEvents);
