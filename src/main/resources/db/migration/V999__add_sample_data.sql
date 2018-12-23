--
-- PostgreSQL database dump
--

SET search_path = almanac;


INSERT INTO category VALUES (1, 'editor', 'Usage of different editors');
INSERT INTO category VALUES (2, 'naming', 'Different naming convention');
INSERT INTO category VALUES (4, 'work', NULL);
INSERT INTO category VALUES (5, 'language', 'Usage of different programming languages');
INSERT INTO category VALUES (3, 'health', NULL);

INSERT INTO hexagram VALUES (1, 1, false);
INSERT INTO hexagram VALUES (2, 2, false);
INSERT INTO hexagram VALUES (3, 3, false);
INSERT INTO hexagram VALUES (4, 4, false);
INSERT INTO hexagram VALUES (5, 5, false);

INSERT INTO locale VALUES (1, 'en', 'US');
INSERT INTO locale VALUES (2, 'zh', 'CN');

INSERT INTO translation VALUES (4, 3, 2, NULL, '抽根烟');
INSERT INTO translation VALUES (6, 1, 2, true, '大幅提高开发效率，而且很帅');
INSERT INTO translation VALUES (7, 1, 2, false, '大家都觉得你在装逼');
INSERT INTO translation VALUES (8, 2, 2, true, '也许可以引领潮流');
INSERT INTO translation VALUES (9, 2, 2, false, '没人会批准你的PR');
INSERT INTO translation VALUES (12, 4, 2, true, '老板今天心情很好');
INSERT INTO translation VALUES (13, 4, 2, false, '最近行情不好');
INSERT INTO translation VALUES (5, 4, 2, NULL, '让老板加薪');
INSERT INTO translation VALUES (14, 5, 2, true, '学习一下新的编程范式');
INSERT INTO translation VALUES (15, 5, 2, false, '不要浪费时间');
INSERT INTO translation VALUES (16, 1, 1, true, 'Makes coding very efficient');
INSERT INTO translation VALUES (17, 1, 1, false, 'We all think you are showing condescension');
INSERT INTO translation VALUES (18, 2, 1, true, 'Let''s lead the new trend');
INSERT INTO translation VALUES (19, 2, 1, false, 'Nobody will approve your PR');
INSERT INTO translation VALUES (20, 3, 1, true, 'Coding Efficiency +35%');
INSERT INTO translation VALUES (21, 3, 1, false, 'Coding Efficiency -27%');
INSERT INTO translation VALUES (1, 1, 2, NULL, '在妹子面前使用$editor$编程');
INSERT INTO translation VALUES (2, 2, 2, NULL, '用$naming$命名');
INSERT INTO translation VALUES (3, 5, 2, NULL, '用$language$编程');
INSERT INTO translation VALUES (10, 3, 2, true, '工作效率+35%');
INSERT INTO translation VALUES (11, 3, 2, false, '工作效率-27%');
INSERT INTO translation VALUES (22, 4, 1, true, 'Your manager looks happy today');
INSERT INTO translation VALUES (23, 4, 1, false, 'Winter is coming');
INSERT INTO translation VALUES (24, 5, 1, true, 'Time to learn new programming paradigm');
INSERT INTO translation VALUES (25, 5, 1, false, 'DO NOT wast your time');

INSERT INTO placeholder VALUES (1, 1, 'VS Code');
INSERT INTO placeholder VALUES (2, 1, 'Vim');
INSERT INTO placeholder VALUES (3, 1, 'Emacs');
INSERT INTO placeholder VALUES (4, 1, 'Notepad');
INSERT INTO placeholder VALUES (5, 1, 'Word');
INSERT INTO placeholder VALUES (6, 1, 'Sublime');
INSERT INTO placeholder VALUES (7, 2, 'lowerCamelCase');
INSERT INTO placeholder VALUES (8, 2, 'UpperCamelCase');
INSERT INTO placeholder VALUES (9, 2, 'kebab-case');
INSERT INTO placeholder VALUES (10, 2, 'snake_case');
INSERT INTO placeholder VALUES (11, 5, 'Java');
INSERT INTO placeholder VALUES (12, 5, 'Python');
INSERT INTO placeholder VALUES (13, 5, 'C#');
INSERT INTO placeholder VALUES (14, 5, 'PHP');
INSERT INTO placeholder VALUES (15, 5, 'ASM');
INSERT INTO placeholder VALUES (16, 5, 'R');
INSERT INTO placeholder VALUES (17, 5, 'C');
INSERT INTO placeholder VALUES (18, 5, 'C++');
INSERT INTO placeholder VALUES (19, 5, 'Clojure');
INSERT INTO placeholder VALUES (20, 5, 'Haskell');
INSERT INTO placeholder VALUES (21, 5, 'Smalltalk');
INSERT INTO placeholder VALUES (22, 5, 'Swift');

SELECT pg_catalog.setval('category_cid_seq', 5, true);
SELECT pg_catalog.setval('hexagram_hid_seq', 5, true);
SELECT pg_catalog.setval('locale_lid_seq', 2, true);
SELECT pg_catalog.setval('translation_tid_seq', 25, true);
SELECT pg_catalog.setval('placeholder_pid_seq', 22, true);

--
-- PostgreSQL database dump complete
--
