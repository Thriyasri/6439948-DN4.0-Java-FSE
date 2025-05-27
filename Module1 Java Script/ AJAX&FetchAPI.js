const submitRegistration = async (data) => {
  try {
    document.getElementById('status').textContent = 'Submitting...';

    await new Promise(resolve => setTimeout(resolve, 1500));

    const response = await fetch('https://jsonplaceholder.typicode.com/posts', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(data),
    });

    if (!response.ok) throw new Error('Network response not OK');

    const result = await response.json();

    document.getElementById('status').textContent = 'Registration successful!';
    console.log('Server response:', result);

  } catch (error) {
    document.getElementById('status').textContent = 'Submission failed. Try again.';
    console.error('Error:', error);
  }
};

