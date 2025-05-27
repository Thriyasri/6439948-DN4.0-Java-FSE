SELECT 
  event_id,
  COUNT(CASE WHEN resource_type = 'pdf' THEN 1 END) AS pdf_count,
  COUNT(CASE WHEN resource_type = 'image' THEN 1 END) AS image_count,
  COUNT(CASE WHEN resource_type = 'link' THEN 1 END) AS link_count
FROM Resources
GROUP BY event_id;
