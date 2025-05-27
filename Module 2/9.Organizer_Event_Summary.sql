SELECT e.organizer_id, e.status, COUNT(*) AS event_count
FROM Events e
GROUP BY e.organizer_id, e.status;
