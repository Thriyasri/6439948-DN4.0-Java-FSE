SELECT 
  EXTRACT(YEAR FROM registration_date) AS year,
  EXTRACT(MONTH FROM registration_date) AS month,
  COUNT(*) AS registration_count
FROM Registrations
WHERE registration_date >= CURRENT_DATE - INTERVAL '12' MONTH
GROUP BY EXTRACT(YEAR FROM registration_date), EXTRACT(MONTH FROM registration_date)
ORDER BY year, month;
