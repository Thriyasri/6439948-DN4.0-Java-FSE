SELECT 
  event_id,
  COUNT(session_id) AS session_count_between_10_to_12
FROM Sessions
WHERE 
  CAST(start_time AS TIME) >= '10:00:00'
  AND CAST(start_time AS TIME) < '12:00:00'
GROUP BY event_id;
