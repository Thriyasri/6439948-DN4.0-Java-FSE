
$(document).ready(function() {
  $('#registerBtn').click(function() {
    alert('Register button clicked!');
  });

  $('.event-card').fadeIn(500);
  setTimeout(() => {
    $('.event-card').fadeOut(500);
  }, 3000);
});

