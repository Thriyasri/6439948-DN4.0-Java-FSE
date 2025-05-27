const form = document.getElementById('registrationForm');

form.addEventListener('submit', function(event) {
  event.preventDefault();
  
  const { name, email, selectedEvent } = form.elements;

  let errorMsg = '';
  if (!name.value.trim()) errorMsg = 'Name is required.';
  else if (!email.value.trim() || !email.value.includes('@')) errorMsg = 'Valid email required.';
  else if (!selectedEvent.value) errorMsg = 'Please select an event.';

  const errorDiv = document.getElementById('error');
  if (errorMsg) {
    errorDiv.textContent = errorMsg;
    return;
  }
  
  errorDiv.textContent = '';
  
  console.log('Form Data:', {
    name: name.value,
    email: email.value,
    selectedEvent: selectedEvent.value,
  });
});
