SELECT 
  u.city,
  COUNT(DISTINCT r.user_id) AS unique_user_registrations
FROM Registrations r
JOIN Users u ON r.user_id = u.user_id
GROUP BY u.city
ORDER BY unique_user_registrations DESC
FETCH FIRST 5 ROWS ONLY;
