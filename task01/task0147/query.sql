SELECT required, description
FROM parts
WHERE description IS NULL
   OR required IS true;
