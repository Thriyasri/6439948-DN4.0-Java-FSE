SELECT 
  event_id,
  AVG(EXTRACT(EPOCH FROM (end_time - start_time)) / 60) AS avg_session_duration_minutes
FROM Sessions
GROUP BY event_id;
