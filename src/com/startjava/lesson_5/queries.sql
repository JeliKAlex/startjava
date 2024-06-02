\! chcp 1251;

\echo 'Вся таблица';
SELECT *
  FROM Jaegers
 ORDER BY model_name;

\echo 'Только не уничтоженные роботы';
SELECT *
  FROM Jaegers
 WHERE status = 'Active'
 ORDER BY model_name;

\echo 'Только роботы серии Mark-1 и Mark-4';
SELECT *
  FROM Jaegers
 WHERE mark
    IN ('Mark-1', 'Mark-4')
 ORDER BY model_name;

\echo 'Всех роботов, кроме Mark-1 и Mark-4 отсортировав по убыванию по столбцу mark';
SELECT *
  FROM Jaegers
 WHERE mark
   NOT IN ('Mark-1', 'Mark-4')
 ORDER BY mark DESC;

\echo 'Информация о самых старых роботах(3)';
SELECT *
  FROM Jaegers
 ORDER BY launch, model_name
 LIMIT 3;

\echo 'Информация из столбцов model_name, mark, launch, kaiju_kill тех роботов, которые уничтожили больше всех kaiju';
SELECT model_name, mark, launch, kaiju_kill
  FROM Jaegers
 WHERE kaiju_kill = (SELECT MAX(kaiju_kill)
                       FROM Jaegers)
 ORDER BY model_name;

\echo 'Средний вес роботов, округлив его до трех знаков после запятой';
SELECT ROUND(AVG(weight), 3)
    AS average_weight
  FROM Jaegers;

\echo 'Увеличьте на единицу количество уничтоженных kaiju у неразрушенных роботов, а затем отобразите таблицу';
UPDATE Jaegers
   SET kaiju_kill = kaiju_kill + 1
 WHERE status = 'Active';

SELECT *
  FROM Jaegers
 ORDER BY model_name;

\echo 'Удалите уничтоженных роботов, а затем отобразите оставшихся';
DELETE FROM Jaegers
      WHERE status = 'Destroyed';

SELECT *
  FROM Jaegers
 ORDER BY model_name;