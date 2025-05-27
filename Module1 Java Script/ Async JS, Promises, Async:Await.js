const loadingEl = document.getElementById('loading');
const eventsContainer = document.getElementById('eventsContainer');

const MOCK_API_URL = 'https://mocki.io/v1/2b59a64f-7a42-49da-8307-3240f4644cfc';

function fetchEventsWithThen() {
  loadingEl.style.display = 'block';
  eventsContainer.innerHTML = '';

  fetch(MOCK_API_URL)
    .then(response => {
      if (!response.ok) throw new Error('Network response was not OK');
      return response.json();
    })
    .then(events => {
      loadingEl.style.display = 'none';
      displayEvents(events);
    })
    .catch(error => {
      loadingEl.style.display = 'none';
      eventsContainer.innerHTML = `<p style="color:red;">Error: ${error.message}</p>`;
    });
}

async function fetchEventsAsync() {
  loadingEl.style.display = 'block';
  eventsContainer.innerHTML = '';

  try {
    const response = await fetch(MOCK_API_URL);
    if (!response.ok) throw new Error('Network response was not OK');
    const events = await response.json();
    loadingEl.style.display = 'none';
    displayEvents(events);
  } catch (error) {
    loadingEl.style.display = 'none';
    eventsContainer.innerHTML = `<p style="color:red;">Error: ${error.message}</p>`;
  }
}

function displayEvents(events) {
  if (!events || events.length === 0) {
    eventsContainer.innerHTML = '<p>No events found.</p>';
    return;
  }

  eventsContainer.innerHTML = '';
  events.forEach(event => {
    const div = document.createElement('div');
    div.textContent = `${event.name} - Date: ${event.date}`;
    eventsContainer.appendChild(div);
  });
}


fetchEventsAsync();
