SELECT u.user_id, u.full_name, u.email, u.city, u.registration_date
FROM Users u
WHERE u.user_id NOT IN (
  SELECT DISTINCT r.user_id
  FROM Registrations r
  WHERE r.registration_date >= CURRENT_DATE - INTERVAL '90' DAY
);