form.addEventListener('submit', function(event) {
  event.preventDefault();

  console.log('Form submission started');

  const { name, email, selectedEvent } = form.elements;
  console.log('Name:', name.value, 'Email:', email.value, 'Event:', selectedEvent.value);

});
